package cu.todus.android.uiCompose.shared.modal;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cu.todus.android.uiCompose.shared.modal.ComposableSingletons$ModalKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ModalKt {
    public static final ComposableSingletons$ModalKt INSTANCE = new ComposableSingletons$ModalKt();
    private static Function2 lambda$665928376 = ComposableLambdaKt.composableLambdaInstance(665928376, false, new Function2() { // from class: r8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ModalKt.lambda_665928376$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_665928376$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(665928376, i10, -1, "cu.todus.android.uiCompose.shared.modal.ComposableSingletons$ModalKt.lambda$665928376.<anonymous> (Modal.kt:38)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$665928376$app_productionPFast() {
        return lambda$665928376;
    }
}
