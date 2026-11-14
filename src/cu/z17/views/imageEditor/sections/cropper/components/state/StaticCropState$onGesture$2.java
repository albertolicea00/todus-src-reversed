package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.ui.input.pointer.PointerInputChange;
import cb.f;
import cb.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGesture$2", f = "StaticCropState.kt", l = {70}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class StaticCropState$onGesture$2 extends m implements Function2 {
    final /* synthetic */ long $centroid;
    final /* synthetic */ List<PointerInputChange> $changes;
    final /* synthetic */ PointerInputChange $mainPointer;
    final /* synthetic */ long $panChange;
    final /* synthetic */ float $rotationChange;
    final /* synthetic */ float $zoomChange;
    int label;
    final /* synthetic */ StaticCropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticCropState$onGesture$2(StaticCropState staticCropState, long j10, long j11, float f10, float f11, List<PointerInputChange> list, PointerInputChange pointerInputChange, e<? super StaticCropState$onGesture$2> eVar) {
        super(2, eVar);
        this.this$0 = staticCropState;
        this.$centroid = j10;
        this.$panChange = j11;
        this.$zoomChange = f10;
        this.$rotationChange = f11;
        this.$changes = list;
        this.$mainPointer = pointerInputChange;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new StaticCropState$onGesture$2(this.this$0, this.$centroid, this.$panChange, this.$zoomChange, this.$rotationChange, this.$changes, this.$mainPointer, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        StaticCropState$onGesture$2 staticCropState$onGesture$2;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            this.this$0.doubleTapped = false;
            StaticCropState staticCropState = this.this$0;
            long j10 = this.$centroid;
            long j11 = this.$panChange;
            float f10 = this.$zoomChange;
            float f11 = this.$rotationChange;
            this.label = 1;
            staticCropState$onGesture$2 = this;
            if (staticCropState.m10230updateTransformStateIUXd7x4$views_release(j10, j11, f10, f11, staticCropState$onGesture$2) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            staticCropState$onGesture$2 = this;
        }
        StaticCropState staticCropState2 = staticCropState$onGesture$2.this$0;
        staticCropState2.setDrawAreaRect(staticCropState2.updateImageDrawRectFromTransformation$views_release());
        if (staticCropState$onGesture$2.this$0.getPannable() && staticCropState$onGesture$2.this$0.getFling() && staticCropState$onGesture$2.$changes.size() == 1) {
            staticCropState$onGesture$2.this$0.m10223addPositionUv8p0NA$views_release(staticCropState$onGesture$2.$mainPointer.getUptimeMillis(), staticCropState$onGesture$2.$mainPointer.getPosition());
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((StaticCropState$onGesture$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
