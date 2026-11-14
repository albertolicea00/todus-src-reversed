package cu.todus.android.uiCompose.main.screen.chat.component.card;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ChatCardScreenKt {
    public static final ComposableSingletons$ChatCardScreenKt INSTANCE = new ComposableSingletons$ChatCardScreenKt();
    private static Function3 lambda$327451974 = ComposableLambdaKt.composableLambdaInstance(327451974, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.p6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ChatCardScreenKt.lambda_327451974$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_327451974$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(327451974, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ComposableSingletons$ChatCardScreenKt.lambda$327451974.<anonymous> (ChatCardScreen.kt:1221)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    public final Function3 getLambda$327451974$app_productionPFast() {
        return lambda$327451974;
    }
}
