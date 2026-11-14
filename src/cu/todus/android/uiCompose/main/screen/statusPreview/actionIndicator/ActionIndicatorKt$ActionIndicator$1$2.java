package cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator;

import ab.e;
import androidx.compose.animation.AnimatedVisibilityScope;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import pe.m0;
import pe.w0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicatorKt$ActionIndicator$1$2", f = "ActionIndicator.kt", l = {112}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ActionIndicatorKt$ActionIndicator$1$2 extends m implements Function2 {
    final /* synthetic */ u0 $completed;
    final /* synthetic */ lb.a $onCompleted;
    final /* synthetic */ AnimatedVisibilityScope $this_AnimatedVisibility;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionIndicatorKt$ActionIndicator$1$2(AnimatedVisibilityScope animatedVisibilityScope, u0 u0Var, lb.a aVar, e<? super ActionIndicatorKt$ActionIndicator$1$2> eVar) {
        super(2, eVar);
        this.$this_AnimatedVisibility = animatedVisibilityScope;
        this.$completed = u0Var;
        this.$onCompleted = aVar;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new ActionIndicatorKt$ActionIndicator$1$2(this.$this_AnimatedVisibility, this.$completed, this.$onCompleted, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            if (this.$this_AnimatedVisibility.getTransition().getCurrentState() == this.$this_AnimatedVisibility.getTransition().getTargetState()) {
                u0 u0Var = this.$completed;
                if (!u0Var.f36629c) {
                    u0Var.f36629c = true;
                    this.label = 1;
                    if (w0.b(1000L, this) == objG) {
                        return objG;
                    }
                }
            }
            return k0.f43947a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$onCompleted.invoke();
        this.$completed.f36629c = false;
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((ActionIndicatorKt$ActionIndicator$1$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
