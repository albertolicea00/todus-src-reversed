package cu.z17.views.camera;

import androidx.compose.runtime.MutableFloatState;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import pe.w0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@cb.f(c = "cu.z17.views.camera.Z17CameraKt$Z17Camera$1$1$1", f = "Z17Camera.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17CameraKt$Z17Camera$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableFloatState $actualRotation$delegate;
    final /* synthetic */ MutableFloatState $rotationStateOnlyForAnimation$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17CameraKt$Z17Camera$1$1$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, ab.e<? super Z17CameraKt$Z17Camera$1$1$1> eVar) {
        super(2, eVar);
        this.$actualRotation$delegate = mutableFloatState;
        this.$rotationStateOnlyForAnimation$delegate = mutableFloatState2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17CameraKt$Z17Camera$1$1$1(this.$actualRotation$delegate, this.$rotationStateOnlyForAnimation$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            if (this.$actualRotation$delegate.getFloatValue() != this.$rotationStateOnlyForAnimation$delegate.getFloatValue()) {
                this.label = 1;
                if (w0.b(400L, this) == objG) {
                    return objG;
                }
            }
            return k0.f43947a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        MutableFloatState mutableFloatState = this.$rotationStateOnlyForAnimation$delegate;
        float floatValue = this.$actualRotation$delegate.getFloatValue();
        float f10 = 90.0f;
        if (floatValue == 90.0f) {
            f10 = 270.0f;
        } else if (floatValue == 180.0f) {
            f10 = 180.0f;
        } else if (floatValue != 270.0f) {
            f10 = 0.0f;
        }
        mutableFloatState.setFloatValue(f10);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17CameraKt$Z17Camera$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
