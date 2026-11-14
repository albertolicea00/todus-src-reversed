package cu.z17.views.imageEditor;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.z17.views.imageEditor.Z17ImageEditorKt$Z17ImageEditor$1$4$1", f = "Z17ImageEditor.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17ImageEditorKt$Z17ImageEditor$1$4$1 extends cb.m implements Function2 {
    final /* synthetic */ State<Z17EditorState> $currentState$delegate;
    final /* synthetic */ lb.a $onError;
    final /* synthetic */ Function1 $onViewState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Z17ImageEditorKt$Z17ImageEditor$1$4$1(Function1 function1, lb.a aVar, State<? extends Z17EditorState> state, ab.e<? super Z17ImageEditorKt$Z17ImageEditor$1$4$1> eVar) {
        super(2, eVar);
        this.$onViewState = function1;
        this.$onError = aVar;
        this.$currentState$delegate = state;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new Z17ImageEditorKt$Z17ImageEditor$1$4$1(this.$onViewState, this.$onError, this.$currentState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        this.$onViewState.invoke(cb.b.a(Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$0(this.$currentState$delegate) == Z17EditorState.VIEW));
        if (Z17ImageEditorKt.Z17ImageEditor$lambda$95$lambda$0(this.$currentState$delegate) == Z17EditorState.ERROR) {
            this.$onError.invoke();
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((Z17ImageEditorKt$Z17ImageEditor$1$4$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
