package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState$onGestureStart$2", f = "StaticCropState.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class StaticCropState$onGestureStart$2 extends m implements Function2 {
    int label;

    public StaticCropState$onGestureStart$2(e<? super StaticCropState$onGestureStart$2> eVar) {
        super(2, eVar);
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new StaticCropState$onGestureStart$2(eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((StaticCropState$onGestureStart$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
