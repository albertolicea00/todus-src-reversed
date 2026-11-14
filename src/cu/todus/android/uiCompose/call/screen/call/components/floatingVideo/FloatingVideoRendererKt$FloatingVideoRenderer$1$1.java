package cu.todus.android.uiCompose.call.screen.call.components.floatingVideo;

import ab.e;
import androidx.compose.runtime.MutableState;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.FloatingVideoRendererKt$FloatingVideoRenderer$1$1", f = "FloatingVideoRenderer.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class FloatingVideoRendererKt$FloatingVideoRenderer$1$1 extends m implements Function2 {
    final /* synthetic */ MutableState<Float> $offsetX$delegate;
    final /* synthetic */ MutableState<Float> $offsetY$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingVideoRendererKt$FloatingVideoRenderer$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, e<? super FloatingVideoRendererKt$FloatingVideoRenderer$1$1> eVar) {
        super(2, eVar);
        this.$offsetX$delegate = mutableState;
        this.$offsetY$delegate = mutableState2;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new FloatingVideoRendererKt$FloatingVideoRenderer$1$1(this.$offsetX$delegate, this.$offsetY$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$5(this.$offsetX$delegate, 0.0f);
        FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$8(this.$offsetY$delegate, 0.0f);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((FloatingVideoRendererKt$FloatingVideoRenderer$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
