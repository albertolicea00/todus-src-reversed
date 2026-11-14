package cu.todus.android.s3.upload;

import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.utils.CoroutineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import pe.a2;
import pe.m0;
import re.u;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadDataSource$upload$2$1$onFailure$1", f = "UploadDataSource.kt", l = {397}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class UploadDataSource$upload$2$1$onFailure$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ y0 $call;
    final /* synthetic */ a2 $cancelWatcherJob;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $notifManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadDataSource$upload$2$1$onFailure$1(a2 a2Var, u uVar, m0 m0Var, y0 y0Var, u0 u0Var, NotificationManager notificationManager, Attachment attachment, ab.e<? super UploadDataSource$upload$2$1$onFailure$1> eVar) {
        super(2, eVar);
        this.$cancelWatcherJob = a2Var;
        this.$$this$callbackFlow = uVar;
        this.$downloadScope = m0Var;
        this.$call = y0Var;
        this.$isSuccess = u0Var;
        this.$notifManager = notificationManager;
        this.$attachment = attachment;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new UploadDataSource$upload$2$1$onFailure$1(this.$cancelWatcherJob, this.$$this$callbackFlow, this.$downloadScope, this.$call, this.$isSuccess, this.$notifManager, this.$attachment, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            a2.a.a(this.$cancelWatcherJob, null, 1, null);
            u uVar = this.$$this$callbackFlow;
            Boolean boolA = cb.b.a(false);
            this.label = 1;
            if (CoroutineUtilsKt.sendWithPrecautions(uVar, boolA, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        UploadDataSource.AnonymousClass2.invokeSuspend$close(this.$downloadScope, this.$$this$callbackFlow, this.$call, this.$isSuccess, this.$notifManager, this.$attachment);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((UploadDataSource$upload$2$1$onFailure$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
