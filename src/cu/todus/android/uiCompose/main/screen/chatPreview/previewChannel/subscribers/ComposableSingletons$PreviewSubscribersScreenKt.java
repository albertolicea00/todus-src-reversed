package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$PreviewSubscribersScreenKt {
    public static final ComposableSingletons$PreviewSubscribersScreenKt INSTANCE = new ComposableSingletons$PreviewSubscribersScreenKt();
    private static Function2 lambda$553133687 = ComposableLambdaKt.composableLambdaInstance(553133687, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewSubscribersScreenKt.lambda_553133687$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1074747132 = ComposableLambdaKt.composableLambdaInstance(1074747132, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewSubscribersScreenKt.lambda_1074747132$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1074747132$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1074747132, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.ComposableSingletons$PreviewSubscribersScreenKt.lambda$1074747132.<anonymous> (PreviewSubscribersScreen.kt:96)");
            }
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
    public static final k0 lambda_553133687$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(553133687, i10, -1, "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.subscribers.ComposableSingletons$PreviewSubscribersScreenKt.lambda$553133687.<anonymous> (PreviewSubscribersScreen.kt:55)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.subscriptions, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$1074747132$app_productionPFast() {
        return lambda$1074747132;
    }

    public final Function2 getLambda$553133687$app_productionPFast() {
        return lambda$553133687;
    }
}
