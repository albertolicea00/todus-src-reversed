package cu.todus.android.uiCompose.intentReceiver;

import android.content.Intent;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import cb.m;
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
@cb.f(c = "cu.todus.android.uiCompose.intentReceiver.IntentReceiverAppKt$IntentReceiverApp$2$1", f = "IntentReceiverApp.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class IntentReceiverAppKt$IntentReceiverApp$2$1 extends m implements Function2 {
    final /* synthetic */ lb.a $closeActivity;
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ State<FlowsState<Intent>> $newIntent;
    final /* synthetic */ IntentReceiverActivityViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IntentReceiverAppKt$IntentReceiverApp$2$1(State<? extends FlowsState<? extends Intent>> state, IntentReceiverActivityViewModel intentReceiverActivityViewModel, m0 m0Var, NavHostController navHostController, lb.a aVar, ab.e<? super IntentReceiverAppKt$IntentReceiverApp$2$1> eVar) {
        super(2, eVar);
        this.$newIntent = state;
        this.$viewModel = intentReceiverActivityViewModel;
        this.$coroutineScope = m0Var;
        this.$navHostController = navHostController;
        this.$closeActivity = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$0(m0 m0Var, NavHostController navHostController, String str) {
        pe.k.d(m0Var, d1.c(), null, new IntentReceiverAppKt$IntentReceiverApp$2$1$1$1(navHostController, str, null), 2, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invokeSuspend$lambda$1(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new IntentReceiverAppKt$IntentReceiverApp$2$1(this.$newIntent, this.$viewModel, this.$coroutineScope, this.$navHostController, this.$closeActivity, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        if (this.$newIntent.getValue().getStatus() == Status.SUCCESS && this.$newIntent.getValue().getData() != null) {
            IntentReceiverActivityIntentHandler intentReceiverActivityIntentHandler = IntentReceiverActivityIntentHandler.INSTANCE;
            Intent data = this.$newIntent.getValue().getData();
            y.f(data);
            final m0 m0Var = this.$coroutineScope;
            final NavHostController navHostController = this.$navHostController;
            Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.intentReceiver.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return IntentReceiverAppKt$IntentReceiverApp$2$1.invokeSuspend$lambda$0(m0Var, navHostController, (String) obj2);
                }
            };
            final lb.a aVar = this.$closeActivity;
            intentReceiverActivityIntentHandler.processExtras(data, function1, new lb.a() { // from class: cu.todus.android.uiCompose.intentReceiver.k
                @Override // lb.a
                public final Object invoke() {
                    return IntentReceiverAppKt$IntentReceiverApp$2$1.invokeSuspend$lambda$1(aVar);
                }
            });
            this.$viewModel.resetIntent();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((IntentReceiverAppKt$IntentReceiverApp$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
