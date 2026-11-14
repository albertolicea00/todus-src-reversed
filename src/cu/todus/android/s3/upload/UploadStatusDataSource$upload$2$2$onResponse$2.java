package cu.todus.android.s3.upload;

import cb.m;
import cu.todus.android.data.db.entity.toDus.Status;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y0;
import pe.m0;
import re.u;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$2$onResponse$2", f = "UploadStatusDataSource.kt", l = {329, 331, 333}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class UploadStatusDataSource$upload$2$2$onResponse$2 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ y0 $call;
    final /* synthetic */ m0 $downloadScope;
    final /* synthetic */ Status $status;
    final /* synthetic */ Status $statusObj;
    int label;
    final /* synthetic */ UploadStatusDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadStatusDataSource$upload$2$2$onResponse$2(Status status, UploadStatusDataSource uploadStatusDataSource, u uVar, m0 m0Var, y0 y0Var, Status status2, ab.e<? super UploadStatusDataSource$upload$2$2$onResponse$2> eVar) {
        super(2, eVar);
        this.$statusObj = status;
        this.this$0 = uploadStatusDataSource;
        this.$$this$callbackFlow = uVar;
        this.$downloadScope = m0Var;
        this.$call = y0Var;
        this.$status = status2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new UploadStatusDataSource$upload$2$2$onResponse$2(this.$statusObj, this.this$0, this.$$this$callbackFlow, this.$downloadScope, this.$call, this.$status, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
    
        if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r2, r4, r27) == r1) goto L23;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.s3.upload.UploadStatusDataSource$upload$2$2$onResponse$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((UploadStatusDataSource$upload$2$2$onResponse$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
