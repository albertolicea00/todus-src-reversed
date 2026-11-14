package cu.todus.android.s3.upload;

import androidx.media3.muxer.WebmConstants;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.s3.S3State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.y0;
import pe.m0;
import re.u;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$close$1", f = "UploadStatusDataSource.kt", l = {162, WebmConstants.MkvEbmlElement.BLOCK, WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class UploadStatusDataSource$upload$2$close$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ y0 $call;
    final /* synthetic */ Status $status;
    Object L$0;
    int label;
    final /* synthetic */ UploadStatusDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadStatusDataSource$upload$2$close$1(UploadStatusDataSource uploadStatusDataSource, u uVar, y0 y0Var, Status status, ab.e<? super UploadStatusDataSource$upload$2$close$1> eVar) {
        super(2, eVar);
        this.this$0 = uploadStatusDataSource;
        this.$$this$callbackFlow = uVar;
        this.$call = y0Var;
        this.$status = status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0$0(Status status, S3State s3State) {
        return y.d(s3State.getItemId(), status.getId());
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new UploadStatusDataSource$upload$2$close$1(this.this$0, this.$$this$callbackFlow, this.$call, this.$status, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r9, r1, r8) == r0) goto L20;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L2a
            if (r1 == r5) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            ua.v.b(r9)
            goto L6e
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1e:
            ua.v.b(r9)
            goto L5f
        L22:
            java.lang.Object r1 = r8.L$0
            te.b0 r1 = (te.b0) r1
            ua.v.b(r9)
            goto L44
        L2a:
            ua.v.b(r9)
            cu.todus.android.s3.upload.UploadStatusDataSource r9 = r8.this$0
            te.b0 r1 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r9)
            cu.todus.android.s3.upload.UploadStatusDataSource r9 = r8.this$0
            te.b0 r9 = cu.todus.android.s3.upload.UploadStatusDataSource.access$get_uploadQueue$p(r9)
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = te.j.x(r9, r8)
            if (r9 != r0) goto L44
            goto L6d
        L44:
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.List r9 = va.g0.r1(r9)
            cu.todus.android.data.db.entity.toDus.Status r6 = r8.$status
            cu.todus.android.s3.upload.j r7 = new cu.todus.android.s3.upload.j
            r7.<init>()
            va.b0.N(r9, r7)
            r8.L$0 = r4
            r8.label = r3
            java.lang.Object r9 = r1.emit(r9, r8)
            if (r9 != r0) goto L5f
            goto L6d
        L5f:
            re.u r9 = r8.$$this$callbackFlow
            java.lang.Boolean r1 = cb.b.a(r5)
            r8.label = r2
            java.lang.Object r9 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r9, r1, r8)
            if (r9 != r0) goto L6e
        L6d:
            return r0
        L6e:
            kotlin.jvm.internal.y0 r9 = r8.$call
            java.lang.Object r9 = r9.f36634c
            nf.e r9 = (nf.e) r9
            if (r9 == 0) goto L79
            r9.cancel()
        L79:
            re.u r9 = r8.$$this$callbackFlow
            re.w r9 = r9.getChannel()
            re.w.a.a(r9, r4, r5, r4)
            ua.k0 r9 = ua.k0.f43947a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$close$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((UploadStatusDataSource$upload$2$close$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
