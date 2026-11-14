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
public final class ComposableSingletons$AudioCallActivityKt {
    public static final ComposableSingletons$AudioCallActivityKt INSTANCE = new ComposableSingletons$AudioCallActivityKt();

    /* JADX INFO: renamed from: lambda$-957391558, reason: not valid java name */
    private static Function2 f159lambda$957391558 = ComposableLambdaKt.composableLambdaInstance(-957391558, false, new Function2() { // from class: cu.todus.android.uiCompose.call.o
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AudioCallActivityKt.lambda__957391558$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-647682084, reason: not valid java name */
    private static Function2 f158lambda$647682084 = ComposableLambdaKt.composableLambdaInstance(-647682084, false, new Function2() { // from class: cu.todus.android.uiCompose.call.p
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AudioCallActivityKt.lambda__647682084$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__647682084$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-647682084, i10, -1, "cu.todus.android.uiCompose.call.ComposableSingletons$AudioCallActivityKt.lambda$-647682084.<anonymous> (AudioCallActivity.kt:58)");
            }
            ThemeKt.ToDusAppTheme(((Number) FlowExtKt.collectAsStateWithLifecycle(AppVolatileState.INSTANCE.getInstance().getThemeSelected(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composer, 0, 7).getValue()).intValue(), false, f159lambda$957391558, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final k0 lambda__957391558$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-957391558, i10, -1, "cu.todus.android.uiCompose.call.ComposableSingletons$AudioCallActivityKt.lambda$-957391558.<anonymous> (AudioCallActivity.kt:61)");
            }
            AudioCallActivityKt.AudioCallNavigation(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-647682084$app_productionPFast, reason: not valid java name */
    public final Function2 m9805getLambda$647682084$app_productionPFast() {
        return f158lambda$647682084;
    }

    /* JADX INFO: renamed from: getLambda$-957391558$app_productionPFast, reason: not valid java name */
    public final Function2 m9806getLambda$957391558$app_productionPFast() {
        return f159lambda$957391558;
    }
}
