package cu.todus.android.uiCompose.call;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.uiCompose.theme.ThemeKt;
import cu.todus.android.volatileState.AppVolatileState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$VideoCallActivityKt {
    public static final ComposableSingletons$VideoCallActivityKt INSTANCE = new ComposableSingletons$VideoCallActivityKt();
    private static Function2 lambda$1115679834 = ComposableLambdaKt.composableLambdaInstance(1115679834, false, new Function2() { // from class: cu.todus.android.uiCompose.call.q
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$VideoCallActivityKt.lambda_1115679834$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1425389308 = ComposableLambdaKt.composableLambdaInstance(1425389308, false, new Function2() { // from class: cu.todus.android.uiCompose.call.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$VideoCallActivityKt.lambda_1425389308$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1115679834$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1115679834, i10, -1, "cu.todus.android.uiCompose.call.ComposableSingletons$VideoCallActivityKt.lambda$1115679834.<anonymous> (VideoCallActivity.kt:67)");
            }
            VideoCallActivityKt.VideoCallNavigation(composer, 0);
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
    public static final k0 lambda_1425389308$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1425389308, i10, -1, "cu.todus.android.uiCompose.call.ComposableSingletons$VideoCallActivityKt.lambda$1425389308.<anonymous> (VideoCallActivity.kt:64)");
            }
            ThemeKt.ToDusAppTheme(((Number) FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7).getValue()).intValue(), false, lambda$1115679834, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$1115679834$app_productionPFast() {
        return lambda$1115679834;
    }

    public final Function2 getLambda$1425389308$app_productionPFast() {
        return lambda$1425389308;
    }
}
