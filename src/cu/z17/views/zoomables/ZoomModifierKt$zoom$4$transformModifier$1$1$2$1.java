package cu.z17.views.zoomables;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.zoomables.ZoomModifierKt$zoom$4$transformModifier$1$1$2$1", f = "ZoomModifier.kt", l = {191}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ZoomModifierKt$zoom$4$transformModifier$1$1$2$1 extends cb.m implements Function2 {
    final /* synthetic */ Offset $centroid;
    final /* synthetic */ Offset $pan;
    final /* synthetic */ float $rotation;
    final /* synthetic */ float $zoom;
    final /* synthetic */ ZoomState $zoomState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomModifierKt$zoom$4$transformModifier$1$1$2$1(ZoomState zoomState, Offset offset, Offset offset2, float f10, float f11, ab.e<? super ZoomModifierKt$zoom$4$transformModifier$1$1$2$1> eVar) {
        super(2, eVar);
        this.$zoomState = zoomState;
        this.$centroid = offset;
        this.$pan = offset2;
        this.$zoom = f10;
        this.$rotation = f11;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ZoomModifierKt$zoom$4$transformModifier$1$1$2$1(this.$zoomState, this.$centroid, this.$pan, this.$zoom, this.$rotation, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            ZoomState zoomState = this.$zoomState;
            long jM5636unboximpl = this.$centroid.m5636unboximpl();
            long jM5636unboximpl2 = this.$pan.m5636unboximpl();
            float f10 = this.$zoom;
            float f11 = this.$rotation;
            this.label = 1;
            if (zoomState.m10350updateZoomStateIUXd7x4(jM5636unboximpl, jM5636unboximpl2, f10, f11, this) == objG) {
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
        return ((ZoomModifierKt$zoom$4$transformModifier$1$1$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
