package cu.todus.android.uiCompose.main.screen.dataPreferences;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import cu.todus.android.data.preferences.CallQuality;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.z17.compress.UtilKt;
import cu.z17.singledi.SinglediException;
import cu.z17.views.camera.Z17CameraModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/dataPreferences/DataPreferencesViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "Lcu/todus/android/data/preferences/DataPreferences;", "newDataPreferences", "Lua/k0;", "updateDataPreferences", "(Lcu/todus/android/data/preferences/DataPreferences;)V", "Lcu/todus/android/data/preferences/CallQuality;", "newValue", "changeCallQuality", "(Lcu/todus/android/data/preferences/CallQuality;)V", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lte/h;", "dataPreferences", "Lte/h;", "getDataPreferences", "()Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DataPreferencesViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final te.h dataPreferences;
    private final PreferencesModule preferences;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesViewModel$changeCallQuality$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesViewModel$changeCallQuality$1", f = "DataPreferencesViewModel.kt", l = {35}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ CallQuality $newValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CallQuality callQuality, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$newValue = callQuality;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return DataPreferencesViewModel.this.new AnonymousClass1(this.$newValue, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.b0 callQuality;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PreferencesModule preferencesModule = DataPreferencesViewModel.this.preferences;
                CallQuality callQuality2 = this.$newValue;
                this.label = 1;
                if (preferencesModule.setCallQuality(callQuality2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null && (callQuality = instanceOrNull.getCallQuality()) != null) {
                callQuality.setValue(this.$newValue);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesViewModel$updateDataPreferences$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.dataPreferences.DataPreferencesViewModel$updateDataPreferences$1", f = "DataPreferencesViewModel.kt", l = {22}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12811 extends cb.m implements Function1 {
        final /* synthetic */ DataPreferences $newDataPreferences;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12811(DataPreferences dataPreferences, ab.e<? super C12811> eVar) {
            super(1, eVar);
            this.$newDataPreferences = dataPreferences;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return DataPreferencesViewModel.this.new C12811(this.$newDataPreferences, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12811) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                PreferencesModule preferencesModule = DataPreferencesViewModel.this.preferences;
                DataPreferences dataPreferences = this.$newDataPreferences;
                this.label = 1;
                if (preferencesModule.saveDataPreferences(dataPreferences, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            PathsVolatileState.INSTANCE.getInstance().updateDataPreferences(this.$newDataPreferences);
            AppVolatileState.INSTANCE.getInstance().setUploadQuality(this.$newDataPreferences.getUploadQuality());
            Z17CameraModule.INSTANCE.getInstance().setDefaultFormat(UtilKt.compressFormat(this.$newDataPreferences.getDefaultFormat()));
            return k0.f43947a;
        }
    }

    public DataPreferencesViewModel() throws SinglediException {
        PreferencesModule singletonInitializer = PreferencesModule.INSTANCE.getInstance();
        this.preferences = singletonInitializer;
        this.dataPreferences = singletonInitializer.dataPreferencesFlow();
    }

    public final void changeCallQuality(CallQuality newValue) {
        kotlin.jvm.internal.y.i(newValue, "newValue");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(newValue, null), 3, null);
    }

    public final te.h getDataPreferences() {
        return this.dataPreferences;
    }

    public final void updateDataPreferences(DataPreferences newDataPreferences) {
        kotlin.jvm.internal.y.i(newDataPreferences, "newDataPreferences");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12811(newDataPreferences, null), 3, null);
    }
}
