package cu.todus.android.uiCompose.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.ComponentActivity;
import androidx.p000activity.compose.ComponentActivityKt;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.p002compose.LocalLifecycleOwnerKt;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import cu.todus.android.ToDusApp;
import cu.todus.android.alive.AliveUtility;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.notification.INotificationFilter;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.auth.screen.UpdateRequiredScreenKt;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.main.screen.updateRequired.UpdateViewModel;
import cu.todus.android.uiCompose.shared.ManageAppStateChangesKt;
import cu.todus.android.uiCompose.shared.errorSnack.ErrorSnackKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import cu.todus.android.utils.UpdateInfo;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.ConnectionState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z0;
import te.b0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006!²\u0006\f\u0010\u0017\u001a\u00020\u00168\nX\u008a\u0084\u0002²\u0006\f\u0010\u0019\u001a\u00020\u00188\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\nX\u008a\u0084\u0002²\u0006\u000e\u0010 \u001a\u0004\u0018\u00010\u001f8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lua/k0;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "onStop", "Lcu/todus/android/uiCompose/main/MainActivityViewModel;", "viewModel", "Lcu/todus/android/uiCompose/main/MainActivityViewModel;", "", "wasCreated", "Z", "", "themeSelected", "Lcu/todus/android/data/preferences/AppState;", "appState", "Lcu/todus/android/exceptions/ToDusException;", "error", "", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "notifications", "Lcu/todus/android/utils/UpdateInfo;", "updateInfo", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;
    private MainActivityViewModel viewModel;
    private boolean wasCreated;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0(final ToDusApp toDusApp, final MainActivity mainActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1679835501, i10, -1, "cu.todus.android.uiCompose.main.MainActivity.onCreate.<anonymous> (MainActivity.kt:50)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())), ComposableLambdaKt.rememberComposableLambda(-297274195, true, new Function2() { // from class: cu.todus.android.uiCompose.main.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$0$0(toDusApp, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0$0(final ToDusApp toDusApp, final MainActivity mainActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-297274195, i10, -1, "cu.todus.android.uiCompose.main.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:53)");
            }
            ThemeKt.ToDusAppTheme(onCreate$lambda$0$0$0(FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7)), WindowsSizeUtilKt.rememberWindowSizeClass(composer, 0) == WindowSize.Expanded, ComposableLambdaKt.rememberComposableLambda(825931275, true, new Function2() { // from class: cu.todus.android.uiCompose.main.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$0$0$1(toDusApp, mainActivity, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final int onCreate$lambda$0$0$0(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0$0$1(final ToDusApp toDusApp, MainActivity mainActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(825931275, i10, -1, "cu.todus.android.uiCompose.main.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:61)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getAppState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getError(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getInsideNotifications().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getUpdateInfo(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            UpdateInfo updateInfoOnCreate$lambda$0$0$1$3 = onCreate$lambda$0$0$1$3(stateCollectAsStateWithLifecycle4);
            if (updateInfoOnCreate$lambda$0$0$1$3 == null || !updateInfoOnCreate$lambda$0$0$1$3.isBlocking()) {
                composer.startReplaceGroup(-547881140);
                AppStateStep appStep = onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep();
                AppStateStep appStateStep = AppStateStep.LOGIN_COMPLETED;
                if (appStep == appStateStep || onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep() == AppStateStep.WAITING_COMPLETE_PROFILE) {
                    composer.startReplaceGroup(-848951685);
                    AppState appStateOnCreate$lambda$0$0$1$0 = onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle);
                    MainActivityViewModel mainActivityViewModel = mainActivity.viewModel;
                    if (mainActivityViewModel == null) {
                        y.w("viewModel");
                        mainActivityViewModel = null;
                    }
                    ChatAppKt.ChatApp(appStateOnCreate$lambda$0$0$1$0, mainActivityViewModel, composer, MainActivityViewModel.$stable << 3);
                    composer.endReplaceGroup();
                } else {
                    if (onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep() == AppStateStep.LOADING) {
                        composer.startReplaceGroup(-848946854);
                        LoadingScreenKt.LoadingScreen(composer, 0);
                    } else {
                        composer.startReplaceGroup(-547534281);
                    }
                    composer.endReplaceGroup();
                }
                ManageAppStateChangesKt.ManageAppStateChanges(mainActivity, onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep(), w.q(AppStateStep.WAITING_COMPLETE_PROFILE, appStateStep), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                List<InsideNotificationState> listOnCreate$lambda$0$0$1$2 = onCreate$lambda$0$0$1$2(stateCollectAsStateWithLifecycle3);
                boolean zChangedInstance = composer.changedInstance(toDusApp);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.main.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivity.onCreate$lambda$0$0$1$5$0(toDusApp, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                InsideNotificationListKt.InsideNotificationList(listOnCreate$lambda$0$0$1$2, (Function1) objRememberedValue, composer, 0);
                ToDusException toDusExceptionOnCreate$lambda$0$0$1$1 = onCreate$lambda$0$0$1$1(stateCollectAsStateWithLifecycle2);
                boolean zChangedInstance2 = composer.changedInstance(toDusApp);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.p
                        @Override // lb.a
                        public final Object invoke() {
                            return MainActivity.onCreate$lambda$0$0$1$6$0(toDusApp);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ErrorSnackKt.ErrorSnack(toDusExceptionOnCreate$lambda$0$0$1$1, (lb.a) objRememberedValue2, composer, ToDusException.$stable);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-548452656);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                UpdateViewModel updateViewModel = (UpdateViewModel) ViewModelKt.viewModel(z0.b(UpdateViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer, 0, 0);
                UpdateInfo updateInfoOnCreate$lambda$0$0$1$4 = onCreate$lambda$0$0$1$3(stateCollectAsStateWithLifecycle4);
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.n
                        @Override // lb.a
                        public final Object invoke() {
                            return k0.f43947a;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                UpdateRequiredScreenKt.UpdateRequiredScreen(updateViewModel, updateInfoOnCreate$lambda$0$0$1$4, (lb.a) objRememberedValue3, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    private static final AppState onCreate$lambda$0$0$1$0(State<AppState> state) {
        return state.getValue();
    }

    private static final ToDusException onCreate$lambda$0$0$1$1(State<? extends ToDusException> state) {
        return state.getValue();
    }

    private static final List<InsideNotificationState> onCreate$lambda$0$0$1$2(State<? extends List<InsideNotificationState>> state) {
        return state.getValue();
    }

    private static final UpdateInfo onCreate$lambda$0$0$1$3(State<UpdateInfo> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$1$5$0(ToDusApp toDusApp, String it) {
        y.i(it, "it");
        toDusApp.notificationDisplayed(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$1$6$0(ToDusApp toDusApp) {
        toDusApp.errorRead();
        return k0.f43947a;
    }

    @Override // androidx.p000activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityViewModel mainActivityViewModel = (MainActivityViewModel) new ViewModelProvider(this).get(MainActivityViewModel.class);
        this.viewModel = mainActivityViewModel;
        if (mainActivityViewModel == null) {
            y.w("viewModel");
            mainActivityViewModel = null;
        }
        Intent intent = getIntent();
        y.h(intent, "getIntent(...)");
        mainActivityViewModel.addNewIntent(intent);
        requestWindowFeature(1);
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        final ToDusApp toDusApp = (ToDusApp) applicationContext;
        if (((AppState) toDusApp.getAppState().getValue()).getAppStep() == AppStateStep.LOGIN_COMPLETED) {
            MainActivityViewModel mainActivityViewModel2 = this.viewModel;
            if (mainActivityViewModel2 == null) {
                y.w("viewModel");
                mainActivityViewModel2 = null;
            }
            mainActivityViewModel2.forceStartConnection();
        }
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1679835501, true, new Function2() { // from class: cu.todus.android.uiCompose.main.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$0(toDusApp, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    @Override // androidx.p000activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        y.i(intent, "intent");
        super.onNewIntent(intent);
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            y.w("viewModel");
            mainActivityViewModel = null;
        }
        mainActivityViewModel.addNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        MainActivityViewModel mainActivityViewModel2 = null;
        if (mainActivityViewModel == null) {
            y.w("viewModel");
            mainActivityViewModel = null;
        }
        NotificationManager instanceOrNull = NotificationManager.INSTANCE.getInstanceOrNull();
        mainActivityViewModel.setPreviewsNotificationFilter(instanceOrNull != null ? instanceOrNull.unregisterActualFilter() : null);
        MainActivityViewModel mainActivityViewModel3 = this.viewModel;
        if (mainActivityViewModel3 != null) {
            if (mainActivityViewModel3 == null) {
                y.w("viewModel");
                mainActivityViewModel3 = null;
            }
            mainActivityViewModel3.stopMedia();
            MainActivityViewModel mainActivityViewModel4 = this.viewModel;
            if (mainActivityViewModel4 == null) {
                y.w("viewModel");
            } else {
                mainActivityViewModel2 = mainActivityViewModel4;
            }
            mainActivityViewModel2.sendAppClose();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        NotificationManager instanceOrNull;
        super.onResume();
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        MainActivityViewModel mainActivityViewModel2 = null;
        if (mainActivityViewModel == null) {
            y.w("viewModel");
            mainActivityViewModel = null;
        }
        if (mainActivityViewModel.getPreviewsNotificationFilter() != null && (instanceOrNull = NotificationManager.INSTANCE.getInstanceOrNull()) != null) {
            MainActivityViewModel mainActivityViewModel3 = this.viewModel;
            if (mainActivityViewModel3 == null) {
                y.w("viewModel");
                mainActivityViewModel3 = null;
            }
            INotificationFilter previewsNotificationFilter = mainActivityViewModel3.getPreviewsNotificationFilter();
            y.f(previewsNotificationFilter);
            instanceOrNull.register(previewsNotificationFilter);
        }
        AppVolatileState instanceOrNull2 = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull2 != null && instanceOrNull2.getIsServiceRunning()) {
            AliveUtility aliveUtility = AliveUtility.INSTANCE;
            Context applicationContext = getApplicationContext();
            y.h(applicationContext, "getApplicationContext(...)");
            aliveUtility.stopService(applicationContext);
        }
        MainActivityViewModel mainActivityViewModel4 = this.viewModel;
        if (mainActivityViewModel4 != null && this.wasCreated) {
            if (mainActivityViewModel4 == null) {
                y.w("viewModel");
                mainActivityViewModel4 = null;
            }
            mainActivityViewModel4.forceStartConnection();
        }
        MainActivityViewModel mainActivityViewModel5 = this.viewModel;
        if (mainActivityViewModel5 != null) {
            if (mainActivityViewModel5 == null) {
                y.w("viewModel");
                mainActivityViewModel5 = null;
            }
            mainActivityViewModel5.forceStartConnection();
            MainActivityViewModel mainActivityViewModel6 = this.viewModel;
            if (mainActivityViewModel6 == null) {
                y.w("viewModel");
            } else {
                mainActivityViewModel2 = mainActivityViewModel6;
            }
            mainActivityViewModel2.sendAppOpen();
        }
        this.wasCreated = true;
    }

    @Override // android.app.Activity
    public void onStop() {
        b0 connectionState;
        ConnectionState connectionState2;
        String aliveConfiguration;
        super.onStop();
        MainRepository instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (connectionState = instanceOrNull.getConnectionState()) == null || (connectionState2 = (ConnectionState) connectionState.getValue()) == null || !connectionState2.isConnected()) {
            return;
        }
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        ToDusApp toDusApp = (ToDusApp) applicationContext;
        AppVolatileState instanceOrNull2 = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull2 == null || (aliveConfiguration = instanceOrNull2.getAliveConfiguration()) == null) {
            aliveConfiguration = DataPreferences.CON_ECO;
        }
        toDusApp.manageAlive(aliveConfiguration, true);
    }
}
