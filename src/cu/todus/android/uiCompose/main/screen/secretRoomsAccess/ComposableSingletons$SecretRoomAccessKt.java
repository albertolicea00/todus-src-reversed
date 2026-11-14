package cu.todus.android.uiCompose.main.screen.secretRoomsAccess;

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
public final class ComposableSingletons$SecretRoomAccessKt {
    public static final ComposableSingletons$SecretRoomAccessKt INSTANCE = new ComposableSingletons$SecretRoomAccessKt();

    /* JADX INFO: renamed from: lambda$-222957894, reason: not valid java name */
    private static Function2 f264lambda$222957894 = ComposableLambdaKt.composableLambdaInstance(-222957894, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.secretRoomsAccess.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SecretRoomAccessKt.lambda__222957894$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__222957894$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222957894, i10, -1, "cu.todus.android.uiCompose.main.screen.secretRoomsAccess.ComposableSingletons$SecretRoomAccessKt.lambda$-222957894.<anonymous> (SecretRoomAccess.kt:175)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.secret_folder, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-222957894$app_productionPFast, reason: not valid java name */
    public final Function2 m9979getLambda$222957894$app_productionPFast() {
        return f264lambda$222957894;
    }
}
