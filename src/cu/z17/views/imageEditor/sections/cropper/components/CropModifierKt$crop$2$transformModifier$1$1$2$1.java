package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.sections.cropper.components.CropModifierKt$crop$2$transformModifier$1$1$2$1", f = "CropModifier.kt", l = {80}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class CropModifierKt$crop$2$transformModifier$1$1$2$1 extends cb.m implements Function2 {
    final /* synthetic */ Offset $centroid;
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ PointerInputChange $mainPointer;
    final /* synthetic */ Offset $pan;
    final /* synthetic */ List<PointerInputChange> $pointerList;
    final /* synthetic */ float $rotate;
    final /* synthetic */ float $zoom;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropModifierKt$crop$2$transformModifier$1$1$2$1(CropState cropState, Offset offset, Offset offset2, float f10, float f11, PointerInputChange pointerInputChange, List<PointerInputChange> list, ab.e<? super CropModifierKt$crop$2$transformModifier$1$1$2$1> eVar) {
        super(2, eVar);
        this.$cropState = cropState;
        this.$centroid = offset;
        this.$pan = offset2;
        this.$zoom = f10;
        this.$rotate = f11;
        this.$mainPointer = pointerInputChange;
        this.$pointerList = list;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CropModifierKt$crop$2$transformModifier$1$1$2$1(this.$cropState, this.$centroid, this.$pan, this.$zoom, this.$rotate, this.$mainPointer, this.$pointerList, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            CropState cropState = this.$cropState;
            long jM5636unboximpl = this.$centroid.m5636unboximpl();
            long jM5636unboximpl2 = this.$pan.m5636unboximpl();
            float f10 = this.$zoom;
            float f11 = this.$rotate;
            PointerInputChange pointerInputChange = this.$mainPointer;
            List<PointerInputChange> list = this.$pointerList;
            this.label = 1;
            if (cropState.mo10215onGesturet6rOp4E$views_release(jM5636unboximpl, jM5636unboximpl2, f10, f11, pointerInputChange, list, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CropModifierKt$crop$2$transformModifier$1$1$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
