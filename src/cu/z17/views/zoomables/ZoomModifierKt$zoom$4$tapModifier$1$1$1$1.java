package cu.z17.views.zoomables;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.zoomables.ZoomModifierKt$zoom$4$tapModifier$1$1$1$1", f = "ZoomModifier.kt", l = {221}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ZoomModifierKt$zoom$4$tapModifier$1$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ float $newZoom;
    final /* synthetic */ ZoomState $zoomState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomModifierKt$zoom$4$tapModifier$1$1$1$1(ZoomState zoomState, float f10, ab.e<? super ZoomModifierKt$zoom$4$tapModifier$1$1$1$1> eVar) {
        super(2, eVar);
        this.$zoomState = zoomState;
        this.$newZoom = f10;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ZoomModifierKt$zoom$4$tapModifier$1$1$1$1(this.$zoomState, this.$newZoom, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            ZoomState zoomState = this.$zoomState;
            float f10 = this.$newZoom;
            float rotationInitial = zoomState.getRotationInitial();
            this.label = 1;
            if (ZoomState.m10340resetWithAnimationM_7yMNQ$views_release$default(zoomState, 0L, f10, rotationInitial, this, 1, null) == objG) {
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
        return ((ZoomModifierKt$zoom$4$tapModifier$1$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
