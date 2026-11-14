package cu.todus.android.uiCompose.main.screen.themeSelector;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cb.m;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/themeSelector/ThemeSelectorViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lua/k0;", "updateThemeSelected", "(I)V", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "getPreferences", "()Lcu/todus/android/di/PreferencesModule;", "Lte/h;", "themeSelected", "Lte/h;", "getThemeSelected", "()Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThemeSelectorViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final PreferencesModule preferences;
    private final te.h themeSelected;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.themeSelector.ThemeSelectorViewModel$updateThemeSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.themeSelector.ThemeSelectorViewModel$updateThemeSelected$1", f = "ThemeSelectorViewModel.kt", l = {16}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ int $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i10, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$value = i10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ThemeSelectorViewModel.this.new AnonymousClass1(this.$value, eVar);
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
                PreferencesModule preferences = ThemeSelectorViewModel.this.getPreferences();
                int i11 = this.$value;
                this.label = 1;
                if (preferences.setThemeSelectedState(i11, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            AppVolatileState.INSTANCE.getInstance().getThemeSelected().setValue(cb.b.d(this.$value));
            return k0.f43947a;
        }
    }

    public ThemeSelectorViewModel() throws SinglediException {
        PreferencesModule singletonInitializer = PreferencesModule.INSTANCE.getInstance();
        this.preferences = singletonInitializer;
        this.themeSelected = singletonInitializer.getThemeSelectedState();
    }

    public final PreferencesModule getPreferences() {
        return this.preferences;
    }

    public final te.h getThemeSelected() {
        return this.themeSelected;
    }

    public final void updateThemeSelected(int value) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(value, null), 3, null);
    }
}
