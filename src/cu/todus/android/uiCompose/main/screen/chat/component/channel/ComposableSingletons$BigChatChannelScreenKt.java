package cu.todus.android.uiCompose.main.screen.chat.component.channel;

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
public final class ComposableSingletons$BigChatChannelScreenKt {
    public static final ComposableSingletons$BigChatChannelScreenKt INSTANCE = new ComposableSingletons$BigChatChannelScreenKt();
    private static Function3 lambda$1345821347 = ComposableLambdaKt.composableLambdaInstance(1345821347, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.m7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigChatChannelScreenKt.lambda_1345821347$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1345821347$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1345821347, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.channel.ComposableSingletons$BigChatChannelScreenKt.lambda$1345821347.<anonymous> (BigChatChannelScreen.kt:1433)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    public final Function3 getLambda$1345821347$app_productionPFast() {
        return lambda$1345821347;
    }
}
