package cu.todus.android.uiCompose.main.screen.batteryPreference;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.betterypermissionhelper.BatteryPermissionHelper;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcu/todus/android/uiCompose/main/screen/batteryPreference/BatteryPreferenceViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "newValue", "Lua/k0;", "changeBatteryPreference", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lte/h;", "", "isBatteryPermissionAvailable", "(Landroid/content/Context;)Lte/h;", "batteryRequest", "(Landroid/content/Context;)V", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/utils/betterypermissionhelper/BatteryPermissionHelper;", "batteryPermissionHelper", "Lcu/todus/android/utils/betterypermissionhelper/BatteryPermissionHelper;", "Lcu/todus/android/data/preferences/DataPreferences;", "actualPreference", "Lte/h;", "getActualPreference", "()Lte/h;", "Lte/b0;", "isFirstTime", "Lte/b0;", "()Lte/b0;", "setFirstTime", "(Lte/b0;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BatteryPreferenceViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.h actualPreference;
    private final BatteryPermissionHelper batteryPermissionHelper;
    private te.b0 isFirstTime;
    private final PreferencesModule preferences;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel$1", f = "BatteryPreferenceViewModel.kt", l = {44}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return BatteryPreferenceViewModel.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
                if (instanceOrNull != null && !instanceOrNull.getBatterySettingsShowed()) {
                    BatteryPreferenceViewModel.this.getIsFirstTime().setValue(cb.b.a(true));
                    PreferencesModule preferencesModule = BatteryPreferenceViewModel.this.preferences;
                    this.label = 1;
                    if (preferencesModule.setBatterySettingsShowed(true, this) == objG) {
                        return objG;
                    }
                }
                return ua.k0.f43947a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            AppVolatileState instanceOrNull2 = AppVolatileState.INSTANCE.getInstanceOrNull();
            if (instanceOrNull2 != null) {
                instanceOrNull2.setBatterySettingsShowed(true);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel$changeBatteryPreference$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel$changeBatteryPreference$1", f = "BatteryPreferenceViewModel.kt", l = {23, 25}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11971 extends cb.m implements Function1 {
        final /* synthetic */ String $newValue;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11971(String str, ab.e<? super C11971> eVar) {
            super(1, eVar);
            this.$newValue = str;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return BatteryPreferenceViewModel.this.new C11971(this.$newValue, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C11971) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
        
            if (r2.saveDataPreferences(r5, r20) == r1) goto L15;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = bb.b.g()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                java.lang.Object r1 = r0.L$0
                cu.todus.android.data.preferences.DataPreferences r1 = (cu.todus.android.data.preferences.DataPreferences) r1
                ua.v.b(r21)
                goto L68
            L18:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L20:
                ua.v.b(r21)
                r2 = r21
                goto L38
            L26:
                ua.v.b(r21)
                cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel r2 = cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel.this
                te.h r2 = r2.getActualPreference()
                r0.label = r4
                java.lang.Object r2 = te.j.x(r2, r0)
                if (r2 != r1) goto L38
                goto L67
            L38:
                r4 = r2
                cu.todus.android.data.preferences.DataPreferences r4 = (cu.todus.android.data.preferences.DataPreferences) r4
                cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel r2 = cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel.this
                cu.todus.android.di.PreferencesModule r2 = cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel.access$getPreferences$p(r2)
                java.lang.String r15 = r0.$newValue
                r18 = 7167(0x1bff, float:1.0043E-41)
                r19 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 0
                r17 = 0
                cu.todus.android.data.preferences.DataPreferences r5 = cu.todus.android.data.preferences.DataPreferences.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                java.lang.Object r4 = cb.l.a(r4)
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r2 = r2.saveDataPreferences(r5, r0)
                if (r2 != r1) goto L68
            L67:
                return r1
            L68:
                ua.k0 r1 = ua.k0.f43947a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.batteryPreference.BatteryPreferenceViewModel.C11971.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public BatteryPreferenceViewModel() throws SinglediException {
        PreferencesModule singletonInitializer = PreferencesModule.INSTANCE.getInstance();
        this.preferences = singletonInitializer;
        this.batteryPermissionHelper = BatteryPermissionHelper.INSTANCE.getInstance();
        this.actualPreference = singletonInitializer.dataPreferencesFlow();
        this.isFirstTime = r0.a(Boolean.FALSE);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void batteryRequest(Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        this.batteryPermissionHelper.getPermission(context, true, true);
    }

    public final void changeBatteryPreference(String newValue) {
        kotlin.jvm.internal.y.i(newValue, "newValue");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11971(newValue, null), 3, null);
    }

    public final te.h getActualPreference() {
        return this.actualPreference;
    }

    public final te.h isBatteryPermissionAvailable(Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        return this.batteryPermissionHelper.isBatterySaverPermissionAvailableFlow(context, true);
    }

    /* JADX INFO: renamed from: isFirstTime, reason: from getter */
    public final te.b0 getIsFirstTime() {
        return this.isFirstTime;
    }

    public final void setFirstTime(te.b0 b0Var) {
        kotlin.jvm.internal.y.i(b0Var, "<set-?>");
        this.isFirstTime = b0Var;
    }
}
