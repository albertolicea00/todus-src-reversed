package cu.todus.android.s3.upload;

import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.s3.S3State;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import pe.m0;
import pe.n0;
import re.u;
import te.p0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$upload$2$cancelWatcherJob$1", f = "UploadDataSource.kt", l = {265}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class UploadDataSource$upload$2$cancelWatcherJob$1 extends m implements Function1 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ y0 $call;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $notifManager;
    int label;
    final /* synthetic */ UploadDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadDataSource$upload$2$cancelWatcherJob$1(UploadDataSource uploadDataSource, u uVar, Attachment attachment, m0 m0Var, y0 y0Var, u0 u0Var, NotificationManager notificationManager, ab.e<? super UploadDataSource$upload$2$cancelWatcherJob$1> eVar) {
        super(1, eVar);
        this.this$0 = uploadDataSource;
        this.$$this$callbackFlow = uVar;
        this.$attachment = attachment;
        this.$downloadScope = m0Var;
        this.$call = y0Var;
        this.$isSuccess = u0Var;
        this.$notifManager = notificationManager;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new UploadDataSource$upload$2$cancelWatcherJob$1(this.this$0, this.$$this$callbackFlow, this.$attachment, this.$downloadScope, this.$call, this.$isSuccess, this.$notifManager, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((UploadDataSource$upload$2$cancelWatcherJob$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            p0 uploadQueue = this.this$0.getUploadQueue();
            final u uVar = this.$$this$callbackFlow;
            final Attachment attachment = this.$attachment;
            final m0 m0Var = this.$downloadScope;
            final y0 y0Var = this.$call;
            final u0 u0Var = this.$isSuccess;
            final NotificationManager notificationManager = this.$notifManager;
            te.i iVar = new te.i() { // from class: cu.todus.android.s3.upload.UploadDataSource$upload$2$cancelWatcherJob$1.1
                @Override // te.i
                public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                    return emit((List<S3State>) obj2, (ab.e<? super k0>) eVar);
                }

                public final Object emit(List<S3State> list, ab.e<? super k0> eVar) {
                    T next;
                    Attachment attachment2 = attachment;
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = (T) null;
                            break;
                        }
                        next = it.next();
                    } while (!y.d(((S3State) next).getItemId(), attachment2.getMsg()));
                    S3State s3State = next;
                    if (s3State != null && !s3State.getRun()) {
                        UploadDataSource.AnonymousClass2.invokeSuspend$close(m0Var, uVar, y0Var, u0Var, notificationManager, attachment);
                        n0.d(uVar, null, 1, null);
                    }
                    return k0.f43947a;
                }
            };
            this.label = 1;
            if (uploadQueue.collect(iVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        throw new ua.j();
    }
}
