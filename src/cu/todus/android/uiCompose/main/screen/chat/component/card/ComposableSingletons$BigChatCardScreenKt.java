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
public final class ComposableSingletons$BigChatCardScreenKt {
    public static final ComposableSingletons$BigChatCardScreenKt INSTANCE = new ComposableSingletons$BigChatCardScreenKt();

    /* JADX INFO: renamed from: lambda$-1669566604, reason: not valid java name */
    private static Function3 f184lambda$1669566604 = ComposableLambdaKt.composableLambdaInstance(-1669566604, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.card.o6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigChatCardScreenKt.lambda__1669566604$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda__1669566604$lambda$0(Modifier it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669566604, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.component.card.ComposableSingletons$BigChatCardScreenKt.lambda$-1669566604.<anonymous> (BigChatCardScreen.kt:1232)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1669566604$app_productionPFast, reason: not valid java name */
    public final Function3 m9863getLambda$1669566604$app_productionPFast() {
        return f184lambda$1669566604;
    }
}
