package cu.todus.android.uiCompose.call;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p000activity.ComponentActivity;
import androidx.p000activity.compose.ComponentActivityKt;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.p002compose.LocalLifecycleOwnerKt;
import cu.todus.android.ToDusApp;
import cu.todus.android.alive.AliveUtility;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.ManageAppStateChangesKt;
import cu.todus.android.uiCompose.shared.errorSnack.ErrorSnackKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.ConnectionState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import te.b0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003¨\u0006\u0015²\u0006\f\u0010\r\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\f\u0010\u000f\u001a\u00020\u000e8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/call/CallActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lua/k0;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onStop", "Companion", "", "themeSelected", "Lcu/todus/android/data/preferences/AppState;", "appState", "Lcu/todus/android/exceptions/ToDusException;", "error", "", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "notifications", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallActivity extends ComponentActivity {
    public static final String CALL_PARAMS_KEY = "call_params_key";
    private static final String DEFAULT_PARAMS;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/uiCompose/call/CallActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "pickId", "Lua/k0;", "openCallActivity", "(Landroid/content/Context;Ljava/lang/String;)V", "DEFAULT_PARAMS", "Ljava/lang/String;", "getDEFAULT_PARAMS", "()Ljava/lang/String;", "CALL_PARAMS_KEY", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public static /* synthetic */ void openCallActivity$default(Companion companion, Context context, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "";
            }
            companion.openCallActivity(context, str);
        }

        public final String getDEFAULT_PARAMS() {
            return CallActivity.DEFAULT_PARAMS;
        }

        public final void openCallActivity(Context context, String pickId) {
            y.i(context, "context");
            y.i(pickId, "pickId");
            Intent intent = new Intent(context, (Class<?>) CallActivity.class);
            Bundle bundle = new Bundle();
            NavLinks navLinks = NavLinks.INSTANCE;
            String strT = new v5.f().t(new CallParams(pickId, false, 2, null));
            y.h(strT, "toJson(...)");
            bundle.putString(CallActivity.CALL_PARAMS_KEY, navLinks.encode(strT));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    static {
        NavLinks navLinks = NavLinks.INSTANCE;
        String strT = new v5.f().t(new CallParams("", false, 2, null));
        y.h(strT, "toJson(...)");
        DEFAULT_PARAMS = navLinks.encode(strT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0(final ToDusApp toDusApp, final CallActivity callActivity, final CallParams callParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1760559074, i10, -1, "cu.todus.android.uiCompose.call.CallActivity.onCreate.<anonymous> (CallActivity.kt:50)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())), ComposableLambdaKt.rememberComposableLambda(557298526, true, new Function2() { // from class: cu.todus.android.uiCompose.call.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallActivity.onCreate$lambda$0$0(toDusApp, callActivity, callParams, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 onCreate$lambda$0$0(final ToDusApp toDusApp, final CallActivity callActivity, final CallParams callParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(557298526, i10, -1, "cu.todus.android.uiCompose.call.CallActivity.onCreate.<anonymous>.<anonymous> (CallActivity.kt:53)");
            }
            ThemeKt.ToDusAppTheme(onCreate$lambda$0$0$0(FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7)), WindowsSizeUtilKt.rememberWindowSizeClass(composer, 0) == WindowSize.Expanded, ComposableLambdaKt.rememberComposableLambda(1680503996, true, new Function2() { // from class: cu.todus.android.uiCompose.call.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallActivity.onCreate$lambda$0$0$1(toDusApp, callActivity, callParams, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 onCreate$lambda$0$0$1(final ToDusApp toDusApp, CallActivity callActivity, CallParams callParams, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1680503996, i10, -1, "cu.todus.android.uiCompose.call.CallActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (CallActivity.kt:61)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getAppState(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getError(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getInsideNotifications().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 48, 14);
            AppStateStep appStep = onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep();
            AppStateStep appStateStep = AppStateStep.LOGIN_COMPLETED;
            if (appStep == appStateStep || onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep() == AppStateStep.WAITING_COMPLETE_PROFILE) {
                composer.startReplaceGroup(56652517);
                CallAppKt.CallApp(composer, 0);
                composer.endReplaceGroup();
            } else {
                if (onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep() == AppStateStep.LOADING) {
                    composer.startReplaceGroup(56655883);
                    LoadingScreenKt.LoadingScreen(composer, 0);
                } else {
                    composer.startReplaceGroup(1756346790);
                }
                composer.endReplaceGroup();
            }
            ManageAppStateChangesKt.ManageAppStateChanges(callActivity, onCreate$lambda$0$0$1$0(stateCollectAsStateWithLifecycle).getAppStep(), w.q(AppStateStep.WAITING_COMPLETE_PROFILE, appStateStep), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            List<InsideNotificationState> listOnCreate$lambda$0$0$1$2 = onCreate$lambda$0$0$1$2(stateCollectAsStateWithLifecycle3);
            boolean zChangedInstance = composer.changedInstance(toDusApp);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.call.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CallActivity.onCreate$lambda$0$0$1$3$0(toDusApp, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            InsideNotificationListKt.InsideNotificationList(listOnCreate$lambda$0$0$1$2, (Function1) objRememberedValue, composer, 0);
            ToDusException toDusExceptionOnCreate$lambda$0$0$1$1 = onCreate$lambda$0$0$1$1(stateCollectAsStateWithLifecycle2);
            boolean zChangedInstance2 = composer.changedInstance(toDusApp);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.call.e
                    @Override // lb.a
                    public final Object invoke() {
                        return CallActivity.onCreate$lambda$0$0$1$4$0(toDusApp);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ErrorSnackKt.ErrorSnack(toDusExceptionOnCreate$lambda$0$0$1$1, (lb.a) objRememberedValue2, composer, 0);
            String pickId = callParams.getPickId();
            boolean zChanged = composer.changed(callParams);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new CallActivity$onCreate$1$1$1$3$1(callParams, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(pickId, (Function2) objRememberedValue3, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$1$3$0(ToDusApp toDusApp, String it) {
        y.i(it, "it");
        toDusApp.notificationDisplayed(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$1$4$0(ToDusApp toDusApp) {
        toDusApp.errorRead();
        return k0.f43947a;
    }

    @Override // androidx.p000activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        NavLinks navLinks = NavLinks.INSTANCE;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString(CALL_PARAMS_KEY, DEFAULT_PARAMS)) == null) {
            string = DEFAULT_PARAMS;
        }
        String strDecode = navLinks.decode(string);
        getWindow().addFlags(128);
        final CallParams callParams = (CallParams) new v5.f().j(strDecode, CallParams.class);
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        final ToDusApp toDusApp = (ToDusApp) applicationContext;
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1760559074, true, new Function2() { // from class: cu.todus.android.uiCompose.call.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CallActivity.onCreate$lambda$0(toDusApp, this, callParams, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        AliveUtility aliveUtility = AliveUtility.INSTANCE;
        Context applicationContext = getApplicationContext();
        y.h(applicationContext, "getApplicationContext(...)");
        aliveUtility.stopService(applicationContext);
    }

    @Override // android.app.Activity
    public void onStop() {
        b0 connectionState;
        ConnectionState connectionState2;
        String aliveConfiguration;
        super.onStop();
        getWindow().clearFlags(128);
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
