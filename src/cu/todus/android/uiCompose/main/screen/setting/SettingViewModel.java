package cu.todus.android.uiCompose.main.screen.setting;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.sentry.SentryDataSource;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.singledi.SinglediException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010\r\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\f0\f0\u001a8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e¨\u0006#"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/setting/SettingViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "", "newValue", "Lua/k0;", "changeSentryState", "(Z)V", "Lcu/todus/android/data/preferences/RootEnvironment;", "rootEnvironment", "changeRootEnvironment", "(Lcu/todus/android/data/preferences/RootEnvironment;)V", "changeRequestModeState", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/sentry/SentryDataSource;", "sentryDataSource", "Lcu/todus/android/sentry/SentryDataSource;", "Lte/h;", "sentryState", "Lte/h;", "getSentryState", "()Lte/h;", "kotlin.jvm.PlatformType", "getRootEnvironment", "requestModeState", "getRequestModeState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SettingViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final MainRepository mainRepository = MainRepository.INSTANCE.getInstance();
    private final PreferencesModule preferences;
    private final te.h requestModeState;
    private final te.h rootEnvironment;
    private final SentryDataSource sentryDataSource;
    private final te.h sentryState;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeRequestModeState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeRequestModeState$1", f = "SettingViewModel.kt", l = {57}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ boolean $newValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$newValue = z10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return SettingViewModel.this.new AnonymousClass1(this.$newValue, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.b0 isRequestModeActivated;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PreferencesModule preferencesModule = SettingViewModel.this.preferences;
                boolean z10 = this.$newValue;
                this.label = 1;
                if (preferencesModule.setRequestMode(z10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null && (isRequestModeActivated = instanceOrNull.getIsRequestModeActivated()) != null) {
                isRequestModeActivated.setValue(cb.b.a(this.$newValue));
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeRootEnvironment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeRootEnvironment$1", f = "SettingViewModel.kt", l = {41}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13101 extends cb.m implements Function1 {
        final /* synthetic */ RootEnvironment $rootEnvironment;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13101(RootEnvironment rootEnvironment, ab.e<? super C13101> eVar) {
            super(1, eVar);
            this.$rootEnvironment = rootEnvironment;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return SettingViewModel.this.new C13101(this.$rootEnvironment, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13101) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PreferencesModule preferencesModule = SettingViewModel.this.preferences;
                RootEnvironment rootEnvironment = this.$rootEnvironment;
                this.label = 1;
                if (preferencesModule.setRootEnvironment(rootEnvironment, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            MainRepository mainRepository = SettingViewModel.this.mainRepository;
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.y.h(string, "toString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(le.a0.O(string, "-", "", false, 4, null), Cause.CORRECT, "Root has been changed"));
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeSentryState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.setting.SettingViewModel$changeSentryState$1", f = "SettingViewModel.kt", l = {28, 31, 33}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13111 extends cb.m implements Function1 {
        final /* synthetic */ boolean $newValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13111(boolean z10, ab.e<? super C13111> eVar) {
            super(1, eVar);
            this.$newValue = z10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return SettingViewModel.this.new C13111(this.$newValue, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C13111) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        
            if (r6.createSentryRoomIfNeedIt(r5) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        
            if (r6.removeSentryChat(r5) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                ua.v.b(r6)
                goto L58
            L1e:
                ua.v.b(r6)
                goto L36
            L22:
                ua.v.b(r6)
                cu.todus.android.uiCompose.main.screen.setting.SettingViewModel r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.this
                cu.todus.android.di.PreferencesModule r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.access$getPreferences$p(r6)
                boolean r1 = r5.$newValue
                r5.label = r4
                java.lang.Object r6 = r6.setSentryState(r1, r5)
                if (r6 != r0) goto L36
                goto L57
            L36:
                boolean r6 = r5.$newValue
                if (r6 == 0) goto L49
                cu.todus.android.uiCompose.main.screen.setting.SettingViewModel r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.this
                cu.todus.android.sentry.SentryDataSource r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.access$getSentryDataSource$p(r6)
                r5.label = r3
                java.lang.Object r6 = r6.createSentryRoomIfNeedIt(r5)
                if (r6 != r0) goto L58
                goto L57
            L49:
                cu.todus.android.uiCompose.main.screen.setting.SettingViewModel r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.this
                cu.todus.android.sentry.SentryDataSource r6 = cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.access$getSentryDataSource$p(r6)
                r5.label = r2
                java.lang.Object r6 = r6.removeSentryChat(r5)
                if (r6 != r0) goto L58
            L57:
                return r0
            L58:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.setting.SettingViewModel.C13111.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SettingViewModel() throws SinglediException {
        PreferencesModule singletonInitializer = PreferencesModule.INSTANCE.getInstance();
        this.preferences = singletonInitializer;
        this.sentryDataSource = SentryDataSource.INSTANCE.getInstance();
        this.sentryState = singletonInitializer.getSentryState();
        this.rootEnvironment = singletonInitializer.getRootEnvironmentFlow();
        this.requestModeState = singletonInitializer.getRequestModeFlow();
    }

    public final void changeRequestModeState(boolean newValue) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(newValue, null), 3, null);
    }

    public final void changeRootEnvironment(RootEnvironment rootEnvironment) {
        kotlin.jvm.internal.y.i(rootEnvironment, "rootEnvironment");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13101(rootEnvironment, null), 3, null);
    }

    public final void changeSentryState(boolean newValue) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C13111(newValue, null), 3, null);
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final te.h getRequestModeState() {
        return this.requestModeState;
    }

    public final te.h getRootEnvironment() {
        return this.rootEnvironment;
    }

    public final te.h getSentryState() {
        return this.sentryState;
    }
}
