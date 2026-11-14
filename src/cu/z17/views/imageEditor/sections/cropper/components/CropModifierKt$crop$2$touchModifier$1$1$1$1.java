package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropStateImplKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.CropModifierKt$crop$2$touchModifier$1$1$1$1", f = "CropModifier.kt", l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class CropModifierKt$crop$2$touchModifier$1$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ PointerInputChange $it;
    final /* synthetic */ Function1 $onDown;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropModifierKt$crop$2$touchModifier$1$1$1$1(CropState cropState, PointerInputChange pointerInputChange, Function1 function1, ab.e<? super CropModifierKt$crop$2$touchModifier$1$1$1$1> eVar) {
        super(2, eVar);
        this.$cropState = cropState;
        this.$it = pointerInputChange;
        this.$onDown = function1;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CropModifierKt$crop$2$touchModifier$1$1$1$1(this.$cropState, this.$it, this.$onDown, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            CropState cropState = this.$cropState;
            PointerInputChange pointerInputChange = this.$it;
            this.label = 1;
            if (cropState.onDown$views_release(pointerInputChange, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        Function1 function1 = this.$onDown;
        if (function1 != null) {
            function1.invoke(CropStateImplKt.getCropData(this.$cropState));
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CropModifierKt$crop$2$touchModifier$1$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
