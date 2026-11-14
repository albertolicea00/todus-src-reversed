package cu.todus.android.uiCompose.auth.screen;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.repositories.AuthRepository;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.RandomString;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.k;
import pe.m0;
import te.h;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0003R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcu/todus/android/uiCompose/auth/screen/AuthViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "nextUid", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "countryCode", "Lkotlin/Function0;", "Lua/k0;", "onComplete", "verityPhone", "(Ljava/lang/String;ILlb/a;)V", "codeSMS", "onError", "register", "(Ljava/lang/String;Llb/a;Llb/a;)V", "backToVerify", "Lcu/todus/android/repositories/AuthRepository;", "authRepository", "Lcu/todus/android/repositories/AuthRepository;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/h;", "Lcu/todus/android/data/preferences/AppState;", "kotlin.jvm.PlatformType", "appState", "Lte/h;", "getAppState", "()Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuthViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final h appState;
    private final AuthRepository authRepository;
    private final v5.f gson;
    private final PreferencesModule preferences;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$backToVerify$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$backToVerify$1", f = "AuthViewModel.kt", l = {RectListKt.BitOffsetForGesturable}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return AuthViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                AuthRepository authRepository = AuthViewModel.this.authRepository;
                this.label = 1;
                if (authRepository.backToVerifyEdit(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1", f = "AuthViewModel.kt", l = {47}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11891 extends m implements Function1 {
        final /* synthetic */ String $codeSMS;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onError;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1$1", f = "AuthViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02081 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02081(lb.a aVar, ab.e<? super C02081> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02081(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02081) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$register$1$2", f = "AuthViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11891(String str, lb.a aVar, lb.a aVar2, ab.e<? super C11891> eVar) {
            super(1, eVar);
            this.$codeSMS = str;
            this.$onComplete = aVar;
            this.$onError = aVar2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return AuthViewModel.this.new C11891(this.$codeSMS, this.$onComplete, this.$onError, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11891) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                AuthRepository authRepository = AuthViewModel.this.authRepository;
                String str = this.$codeSMS;
                this.label = 1;
                obj = authRepository.register(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                k.d(ViewModelKt.getViewModelScope(AuthViewModel.this), d1.c(), null, new C02081(this.$onComplete, null), 2, null);
            } else {
                k.d(ViewModelKt.getViewModelScope(AuthViewModel.this), d1.c(), null, new AnonymousClass2(this.$onError, null), 2, null);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$verityPhone$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$verityPhone$1", f = "AuthViewModel.kt", l = {29}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11901 extends m implements Function1 {
        final /* synthetic */ int $countryCode;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $phoneNumber;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.auth.screen.AuthViewModel$verityPhone$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.auth.screen.AuthViewModel$verityPhone$1$1", f = "AuthViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02091 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02091(lb.a aVar, ab.e<? super C02091> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02091(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02091) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11901(String str, int i10, String str2, lb.a aVar, ab.e<? super C11901> eVar) {
            super(1, eVar);
            this.$phoneNumber = str;
            this.$countryCode = i10;
            this.$uid = str2;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return AuthViewModel.this.new C11901(this.$phoneNumber, this.$countryCode, this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11901) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                AuthRepository authRepository = AuthViewModel.this.authRepository;
                String str = this.$phoneNumber;
                int i11 = this.$countryCode;
                String str2 = this.$uid;
                this.label = 1;
                if (authRepository.verifyPhoneNumber(str, i11, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            k.d(ViewModelKt.getViewModelScope(AuthViewModel.this), d1.c(), null, new C02091(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    public AuthViewModel() throws SinglediException {
        AuthRepository singletonInitializer = AuthRepository.INSTANCE.getInstance();
        this.authRepository = singletonInitializer;
        this.preferences = PreferencesModule.INSTANCE.getInstance();
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.appState = singletonInitializer.getActualAppState();
    }

    private final String nextUid() {
        return new RandomString(150, null, null, 6, null).nextString();
    }

    public final void backToVerify() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final h getAppState() {
        return this.appState;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final void register(String codeSMS, lb.a onComplete, lb.a onError) {
        y.i(codeSMS, "codeSMS");
        y.i(onComplete, "onComplete");
        y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11891(codeSMS, onComplete, onError, null), 3, null);
    }

    public final void verityPhone(String phoneNumber, int countryCode, lb.a onComplete) {
        y.i(phoneNumber, "phoneNumber");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11901(phoneNumber, countryCode, nextUid(), onComplete, null), 3, null);
    }
}
