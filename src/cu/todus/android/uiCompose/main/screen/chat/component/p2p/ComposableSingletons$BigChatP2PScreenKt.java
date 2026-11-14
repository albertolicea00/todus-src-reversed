package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

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
public final class ComposableSingletons$BigChatP2PScreenKt {
    public static final ComposableSingletons$BigChatP2PScreenKt INSTANCE = new ComposableSingletons$BigChatP2PScreenKt();
    private static Function3 lambda$1021151426 = ComposableLambdaKt.composableLambdaInstance(1021151426, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.n7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigChatP2PScreenKt.lambda_1021151426$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3 lambda$1437156971 = ComposableLambdaKt.composableLambdaInstance(1437156971, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.p2p.o7
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigChatP2PScreenKt.lambda_1437156971$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1021151426$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1021151426, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ComposableSingletons$BigChatP2PScreenKt.lambda$1021151426.<anonymous> (BigChatP2PScreen.kt:1286)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1437156971$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1437156971, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.p2p.ComposableSingletons$BigChatP2PScreenKt.lambda$1437156971.<anonymous> (BigChatP2PScreen.kt:1318)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    public final Function3 getLambda$1021151426$app_productionPFast() {
        return lambda$1021151426;
    }

    public final Function3 getLambda$1437156971$app_productionPFast() {
        return lambda$1437156971;
    }
}
