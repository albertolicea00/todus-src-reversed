package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import pe.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.ImageCropperKt$ImageCropper$1$3$1", f = "ImageCropper.kt", l = {167}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ImageCropperKt$ImageCropper$1$3$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $visible$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCropperKt$ImageCropper$1$3$1(MutableState<Boolean> mutableState, ab.e<? super ImageCropperKt$ImageCropper$1$3$1> eVar) {
        super(2, eVar);
        this.$visible$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ImageCropperKt$ImageCropper$1$3$1(this.$visible$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            this.label = 1;
            if (w0.b(100L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        ImageCropperKt.ImageCropper_7Wsh9oA$lambda$11$lambda$9(this.$visible$delegate, true);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ImageCropperKt$ImageCropper$1$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
