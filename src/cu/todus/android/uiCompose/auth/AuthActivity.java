package cu.todus.android.uiCompose.auth;

import ab.i;
import android.content.Context;
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
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import androidx.p001lifecycle.p002compose.LocalLifecycleOwnerKt;
import cu.todus.android.ToDusApp;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.uiCompose.auth.AuthActivity;
import cu.todus.android.uiCompose.loading.screen.LoadingScreenKt;
import cu.todus.android.uiCompose.shared.ManageAppStateChangesKt;
import cu.todus.android.uiCompose.shared.errorSnack.ErrorSnackKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationListKt;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.todus.android.uiCompose.theme.WindowSize;
import cu.todus.android.uiCompose.theme.WindowsSizeUtilKt;
import cu.todus.android.volatileState.AppVolatileState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0012²\u0006\f\u0010\n\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010\f\u001a\u00020\u000b8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r8\nX\u008a\u0084\u0002²\u0006\u0012\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/auth/AuthActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lua/k0;", "onCreate", "(Landroid/os/Bundle;)V", "Lcu/todus/android/data/preferences/AppState;", "appState", "", "themeSelected", "Lcu/todus/android/exceptions/ToDusException;", "error", "", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "notifications", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuthActivity extends ComponentActivity {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0(final ToDusApp toDusApp, final AuthActivity authActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1215647616, i10, -1, "cu.todus.android.uiCompose.auth.AuthActivity.onCreate.<anonymous> (AuthActivity.kt:30)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())), ComposableLambdaKt.rememberComposableLambda(-761462080, true, new Function2() { // from class: g7.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthActivity.onCreate$lambda$0$0(toDusApp, authActivity, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 onCreate$lambda$0$0(final ToDusApp toDusApp, final AuthActivity authActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-761462080, i10, -1, "cu.todus.android.uiCompose.auth.AuthActivity.onCreate.<anonymous>.<anonymous> (AuthActivity.kt:33)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getAppState(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 0, 7);
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getError(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 0, 7);
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getInsideNotifications().getValue(), w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 48, 14);
            WindowSize windowSizeRememberWindowSizeClass = WindowsSizeUtilKt.rememberWindowSizeClass(composer, 0);
            ThemeKt.ToDusAppTheme(onCreate$lambda$0$0$1(stateCollectAsStateWithLifecycle2), windowSizeRememberWindowSizeClass == WindowSize.Expanded, ComposableLambdaKt.rememberComposableLambda(361743390, true, new Function2() { // from class: g7.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthActivity.onCreate$lambda$0$0$4(this.f32525c, toDusApp, stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle4, stateCollectAsStateWithLifecycle3, (Composer) obj, ((Integer) obj2).intValue());
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

    private static final AppState onCreate$lambda$0$0$0(State<AppState> state) {
        return state.getValue();
    }

    private static final int onCreate$lambda$0$0$1(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final ToDusException onCreate$lambda$0$0$2(State<? extends ToDusException> state) {
        return state.getValue();
    }

    private static final List<InsideNotificationState> onCreate$lambda$0$0$3(State<? extends List<InsideNotificationState>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0$0$4(AuthActivity authActivity, final ToDusApp toDusApp, State state, State state2, State state3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(361743390, i10, -1, "cu.todus.android.uiCompose.auth.AuthActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (AuthActivity.kt:49)");
            }
            AppStateStep appStateStep = AppStateStep.WAITING_VERIFY;
            AppStateStep appStateStep2 = AppStateStep.WAITING_REGISTER;
            if (w.q(appStateStep, appStateStep2).contains(onCreate$lambda$0$0$0(state).getAppStep())) {
                composer.startReplaceGroup(-256945449);
                AuthAppKt.AuthApp(onCreate$lambda$0$0$0(state), composer, 0);
                composer.endReplaceGroup();
            } else {
                if (onCreate$lambda$0$0$0(state).getAppStep() == AppStateStep.LOADING) {
                    composer.startReplaceGroup(-256941587);
                    LoadingScreenKt.LoadingScreen(composer, 0);
                } else {
                    composer.startReplaceGroup(624759812);
                }
                composer.endReplaceGroup();
            }
            ManageAppStateChangesKt.ManageAppStateChanges(authActivity, onCreate$lambda$0$0$0(state).getAppStep(), w.q(appStateStep, appStateStep2), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            List<InsideNotificationState> listOnCreate$lambda$0$0$3 = onCreate$lambda$0$0$3(state2);
            boolean zChangedInstance = composer.changedInstance(toDusApp);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: g7.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthActivity.onCreate$lambda$0$0$4$0$0(toDusApp, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            InsideNotificationListKt.InsideNotificationList(listOnCreate$lambda$0$0$3, (Function1) objRememberedValue, composer, 0);
            ToDusException toDusExceptionOnCreate$lambda$0$0$2 = onCreate$lambda$0$0$2(state3);
            boolean zChangedInstance2 = composer.changedInstance(toDusApp);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a() { // from class: g7.b
                    @Override // lb.a
                    public final Object invoke() {
                        return AuthActivity.onCreate$lambda$0$0$4$1$0(toDusApp);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ErrorSnackKt.ErrorSnack(toDusExceptionOnCreate$lambda$0$0$2, (a) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$4$0$0(ToDusApp toDusApp, String it) {
        y.i(it, "it");
        toDusApp.notificationDisplayed(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onCreate$lambda$0$0$4$1$0(ToDusApp toDusApp) {
        toDusApp.errorRead();
        return k0.f43947a;
    }

    @Override // androidx.p000activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        final ToDusApp toDusApp = (ToDusApp) applicationContext;
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1215647616, true, new Function2() { // from class: g7.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AuthActivity.onCreate$lambda$0(toDusApp, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }
}
