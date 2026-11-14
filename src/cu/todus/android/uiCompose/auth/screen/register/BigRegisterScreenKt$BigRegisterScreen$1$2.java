package cu.todus.android.uiCompose.auth.screen.register;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.auth.screen.register.BigRegisterScreenKt$BigRegisterScreen$1$2", f = "BigRegisterScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class BigRegisterScreenKt$BigRegisterScreen$1$2 extends cb.m implements Function2 {
    final /* synthetic */ State<AppState> $appState$delegate;
    final /* synthetic */ u0 $chronometerRunning;
    final /* synthetic */ MutableState<Boolean> $resendEnable;
    final /* synthetic */ MutableState<String> $smsNumber;
    final /* synthetic */ MutableState<String> $timeData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigRegisterScreenKt$BigRegisterScreen$1$2(State<AppState> state, u0 u0Var, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, ab.e<? super BigRegisterScreenKt$BigRegisterScreen$1$2> eVar) {
        super(2, eVar);
        this.$appState$delegate = state;
        this.$chronometerRunning = u0Var;
        this.$resendEnable = mutableState;
        this.$timeData = mutableState2;
        this.$smsNumber = mutableState3;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new BigRegisterScreenKt$BigRegisterScreen$1$2(this.$appState$delegate, this.$chronometerRunning, this.$resendEnable, this.$timeData, this.$smsNumber, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (BigRegisterScreenKt.BigRegisterScreen$lambda$0$0(this.$appState$delegate).getAppStep() == AppStateStep.WAITING_REGISTER) {
            BigRegisterScreenKt.BigRegisterScreen$lambda$0$chronometerStart(this.$chronometerRunning, this.$resendEnable, this.$timeData, this.$smsNumber, new Date(BigRegisterScreenKt.BigRegisterScreen$lambda$0$0(this.$appState$delegate).getLastTimeSmsWaSent()));
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((BigRegisterScreenKt$BigRegisterScreen$1$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
