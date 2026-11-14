package cu.todus.android.s3.upload;

import cb.m;
import cu.todus.android.utils.CoroutineUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import re.u;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.s3.upload.DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1", f = "DirectUploadCallbackFlow.kt", l = {93}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1 extends m implements Function2 {
    final /* synthetic */ u $$this$callbackFlow;
    final /* synthetic */ DirectUploadState $directUploadState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1(u uVar, DirectUploadState directUploadState, ab.e<? super DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1> eVar) {
        super(2, eVar);
        this.$$this$callbackFlow = uVar;
        this.$directUploadState = directUploadState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1(this.$$this$callbackFlow, this.$directUploadState, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            u uVar = this.$$this$callbackFlow;
            DirectUploadState directUploadState = this.$directUploadState;
            this.label = 1;
            if (CoroutineUtilsKt.sendWithPrecautions(uVar, directUploadState, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((DirectUploadCallbackFlow$callbackFlow$1$requestBody$1$onProgressChanged$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
