package cu.todus.android.uiCompose.auth.screen.register;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.media3.extractor.ts.TsExtractor;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.uiCompose.auth.screen.AuthViewModel;
import cu.todus.android.utils.SMSReceived;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.u0;
import le.d0;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.auth.screen.register.RegisterScreenKt$RegisterScreen$1$3$1", f = "RegisterScreen.kt", l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class RegisterScreenKt$RegisterScreen$1$3$1 extends cb.m implements Function2 {
    final /* synthetic */ State<AppState> $appState$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ MutableState<Boolean> $permissionsGranted$delegate;
    final /* synthetic */ MutableState<String> $smsNumber;
    final /* synthetic */ AuthViewModel $viewModel;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.register.RegisterScreenKt$RegisterScreen$1$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.auth.screen.register.RegisterScreenKt$RegisterScreen$1$3$1$1", f = "RegisterScreen.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "code", "Lua/k0;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ u0 $codeProcessed;
        final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
        final /* synthetic */ MutableState<String> $smsNumber;
        final /* synthetic */ AuthViewModel $viewModel;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(u0 u0Var, MutableState<String> mutableState, AuthViewModel authViewModel, MutableState<Boolean> mutableState2, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$codeProcessed = u0Var;
            this.$smsNumber = mutableState;
            this.$viewModel = authViewModel;
            this.$isLoading$delegate = mutableState2;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$codeProcessed, this.$smsNumber, this.$viewModel, this.$isLoading$delegate, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            if (!d0.q0(str)) {
                u0 u0Var = this.$codeProcessed;
                if (!u0Var.f36629c) {
                    u0Var.f36629c = true;
                    this.$smsNumber.setValue(str);
                    RegisterScreenKt.RegisterScreen$lambda$0$register(this.$viewModel, this.$smsNumber, this.$isLoading$delegate);
                }
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(str, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegisterScreenKt$RegisterScreen$1$3$1(Context context, MutableState<String> mutableState, MutableState<Boolean> mutableState2, State<AppState> state, AuthViewModel authViewModel, MutableState<Boolean> mutableState3, ab.e<? super RegisterScreenKt$RegisterScreen$1$3$1> eVar) {
        super(2, eVar);
        this.$context = context;
        this.$smsNumber = mutableState;
        this.$permissionsGranted$delegate = mutableState2;
        this.$appState$delegate = state;
        this.$viewModel = authViewModel;
        this.$isLoading$delegate = mutableState3;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new RegisterScreenKt$RegisterScreen$1$3$1(this.$context, this.$smsNumber, this.$permissionsGranted$delegate, this.$appState$delegate, this.$viewModel, this.$isLoading$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            if (RegisterScreenKt.RegisterScreen$lambda$0$10(this.$permissionsGranted$delegate) && RegisterScreenKt.RegisterScreen$lambda$0$0(this.$appState$delegate).getAppStep() == AppStateStep.WAITING_REGISTER) {
                u0 u0Var = new u0();
                SMSReceived sMSReceived = new SMSReceived(this.$context);
                String fromInbox = sMSReceived.readFromInbox(RegisterScreenKt.RegisterScreen$lambda$0$0(this.$appState$delegate).getLastTimeSmsWaSent());
                if (fromInbox == null || u0Var.f36629c) {
                    te.h hVarRegister = sMSReceived.register();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(u0Var, this.$smsNumber, this.$viewModel, this.$isLoading$delegate, null);
                    this.L$0 = cb.l.a(u0Var);
                    this.L$1 = cb.l.a(sMSReceived);
                    this.L$2 = cb.l.a(fromInbox);
                    this.label = 1;
                    if (te.j.k(hVarRegister, anonymousClass1, this) == objG) {
                        return objG;
                    }
                } else {
                    u0Var.f36629c = true;
                    this.$smsNumber.setValue(fromInbox);
                    RegisterScreenKt.RegisterScreen$lambda$0$register(this.$viewModel, this.$smsNumber, this.$isLoading$delegate);
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((RegisterScreenKt$RegisterScreen$1$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
