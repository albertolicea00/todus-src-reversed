package cu.todus.android.uiCompose.main;

import android.content.Intent;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.data.wrapper.Status;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.ChatAppKt$ChatApp$3$1", f = "ChatApp.kt", l = {197}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ChatAppKt$ChatApp$3$1 extends cb.m implements Function2 {
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ State<FlowsState<Intent>> $newIntent;
    final /* synthetic */ MainActivityViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatAppKt$ChatApp$3$1(State<? extends FlowsState<? extends Intent>> state, MainActivityViewModel mainActivityViewModel, m0 m0Var, NavHostController navHostController, ab.e<? super ChatAppKt$ChatApp$3$1> eVar) {
        super(2, eVar);
        this.$newIntent = state;
        this.$viewModel = mainActivityViewModel;
        this.$coroutineScope = m0Var;
        this.$navHostController = navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(m0 m0Var, NavHostController navHostController, String str) {
        pe.k.d(m0Var, d1.c(), null, new ChatAppKt$ChatApp$3$1$1$1(navHostController, str, null), 2, null);
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ChatAppKt$ChatApp$3$1(this.$newIntent, this.$viewModel, this.$coroutineScope, this.$navHostController, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            if (this.$newIntent.getValue().getStatus() == Status.SUCCESS && this.$newIntent.getValue().getData() != null) {
                MainActivityIntentHandler mainActivityIntentHandler = MainActivityIntentHandler.INSTANCE;
                Intent data = this.$newIntent.getValue().getData();
                y.f(data);
                final m0 m0Var = this.$coroutineScope;
                final NavHostController navHostController = this.$navHostController;
                Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChatAppKt$ChatApp$3$1.invokeSuspend$lambda$0(m0Var, navHostController, (String) obj2);
                    }
                };
                this.label = 1;
                if (mainActivityIntentHandler.processExtras(data, function1, this) == objG) {
                    return objG;
                }
            }
            return k0.f43947a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$viewModel.resetIntent();
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ChatAppKt$ChatApp$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
