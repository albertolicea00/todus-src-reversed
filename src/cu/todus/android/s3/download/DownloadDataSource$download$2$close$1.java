package cu.todus.android.s3.download;

import ab.e;
import androidx.media3.muxer.WebmConstants;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.s3.S3State;
import cu.todus.android.utils.CoroutineUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import pe.m0;
import re.u;
import re.w;
import te.b0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.s3.download.DownloadDataSource$download$2$close$1", f = "DownloadDataSource.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_ADD_ID}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class DownloadDataSource$download$2$close$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ Attachment $attachment;
    final /* synthetic */ y0 $call;
    final /* synthetic */ u0 $isSuccess;
    final /* synthetic */ NotificationManager $sysNotifier;
    int label;
    final /* synthetic */ DownloadDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDataSource$download$2$close$1(y0 y0Var, DownloadDataSource downloadDataSource, u0 u0Var, NotificationManager notificationManager, Attachment attachment, u uVar, e<? super DownloadDataSource$download$2$close$1> eVar) {
        super(2, eVar);
        this.$call = y0Var;
        this.this$0 = downloadDataSource;
        this.$isSuccess = u0Var;
        this.$sysNotifier = notificationManager;
        this.$attachment = attachment;
        this.$$this$callbackFlow = uVar;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new DownloadDataSource$download$2$close$1(this.$call, this.this$0, this.$isSuccess, this.$sysNotifier, this.$attachment, this.$$this$callbackFlow, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object value;
        ArrayList arrayList;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            nf.e eVar = (nf.e) this.$call.f36634c;
            if (eVar != null) {
                eVar.cancel();
            }
            b0 b0Var = this.this$0._downloadQueue;
            Attachment attachment = this.$attachment;
            do {
                value = b0Var.getValue();
                arrayList = new ArrayList();
                for (Object obj2 : (List) value) {
                    if (!y.d(((S3State) obj2).getItemId(), attachment.getId())) {
                        arrayList.add(obj2);
                    }
                }
            } while (!b0Var.g(value, arrayList));
            if (!this.$isSuccess.f36629c) {
                this.$sysNotifier.dismissDownloadProgress(this.$attachment.getId());
            }
            u uVar = this.$$this$callbackFlow;
            Boolean boolA = cb.b.a(true);
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
        w.a.a(this.$$this$callbackFlow.getChannel(), null, 1, null);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((DownloadDataSource$download$2$close$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
