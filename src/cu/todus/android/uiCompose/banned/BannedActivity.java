package cu.todus.android.uiCompose.banned;

import ab.i;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
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
import cu.todus.android.uiCompose.banned.BannedActivity;
import cu.todus.android.uiCompose.shared.ManageAppStateChangesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\f\u0010\n\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/banned/BannedActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lua/k0;", "onCreate", "(Landroid/os/Bundle;)V", "Lcu/todus/android/data/preferences/AppState;", "appState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BannedActivity extends ComponentActivity {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 onCreate$lambda$0(final ToDusApp toDusApp, final BannedActivity bannedActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(758489886, i10, -1, "cu.todus.android.uiCompose.banned.BannedActivity.onCreate.<anonymous> (BannedActivity.kt:47)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())), ComposableLambdaKt.rememberComposableLambda(1931077214, true, new Function2() { // from class: h7.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BannedActivity.onCreate$lambda$0$0(toDusApp, bannedActivity, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final k0 onCreate$lambda$0$0(ToDusApp toDusApp, BannedActivity bannedActivity, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931077214, i10, -1, "cu.todus.android.uiCompose.banned.BannedActivity.onCreate.<anonymous>.<anonymous> (BannedActivity.kt:50)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(toDusApp.getAppState(), (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composer, 0, 7);
            Composer composer2 = composer;
            AppStateStep appStep = onCreate$lambda$0$0$0(stateCollectAsStateWithLifecycle).getAppStep();
            AppStateStep appStateStep = AppStateStep.BANNED;
            if (appStep == appStateStep) {
                composer2.startReplaceGroup(339339398);
                SurfaceKt.m3707SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableSingletons$BannedActivityKt.INSTANCE.m9804getLambda$1582938264$app_productionPFast(), composer, 12582918, 122);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1932823396);
                composer2.endReplaceGroup();
            }
            ManageAppStateChangesKt.ManageAppStateChanges(bannedActivity, onCreate$lambda$0$0$0(stateCollectAsStateWithLifecycle).getAppStep(), v.e(appStateStep), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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

    @Override // androidx.p000activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Context applicationContext = getApplicationContext();
        y.g(applicationContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
        final ToDusApp toDusApp = (ToDusApp) applicationContext;
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(758489886, true, new Function2() { // from class: h7.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BannedActivity.onCreate$lambda$0(toDusApp, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }
}
