package cu.z17.views.videoEditor;

import androidx.compose.runtime.State;
import cu.z17.views.imageEditor.Z17EditorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoEditor.Z17VideoEditorKt$Z17VideoEditor$1$3$1", f = "Z17VideoEditor.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17VideoEditorKt$Z17VideoEditor$1$3$1 extends cb.m implements Function2 {
    final /* synthetic */ State<Z17EditorState> $currentState$delegate;
    final /* synthetic */ lb.a $onError;
    final /* synthetic */ Function1 $onViewState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Z17VideoEditorKt$Z17VideoEditor$1$3$1(Function1 function1, lb.a aVar, State<? extends Z17EditorState> state, ab.e<? super Z17VideoEditorKt$Z17VideoEditor$1$3$1> eVar) {
        super(2, eVar);
        this.$onViewState = function1;
        this.$onError = aVar;
        this.$currentState$delegate = state;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17VideoEditorKt$Z17VideoEditor$1$3$1(this.$onViewState, this.$onError, this.$currentState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$onViewState.invoke(cb.b.a(Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$6(this.$currentState$delegate) == Z17EditorState.VIEW));
        if (Z17VideoEditorKt.Z17VideoEditor$lambda$54$lambda$6(this.$currentState$delegate) == Z17EditorState.ERROR) {
            this.$onError.invoke();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17VideoEditorKt$Z17VideoEditor$1$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
