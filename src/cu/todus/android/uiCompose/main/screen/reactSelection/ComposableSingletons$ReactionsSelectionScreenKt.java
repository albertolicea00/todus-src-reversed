package cu.todus.android.uiCompose.main.screen.reactSelection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.RestoreKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ReactionsSelectionScreenKt {
    public static final ComposableSingletons$ReactionsSelectionScreenKt INSTANCE = new ComposableSingletons$ReactionsSelectionScreenKt();

    /* JADX INFO: renamed from: lambda$-238641872, reason: not valid java name */
    private static Function2 f249lambda$238641872 = ComposableLambdaKt.composableLambdaInstance(-238641872, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ReactionsSelectionScreenKt.lambda__238641872$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1783891267, reason: not valid java name */
    private static Function2 f248lambda$1783891267 = ComposableLambdaKt.composableLambdaInstance(-1783891267, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.reactSelection.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ReactionsSelectionScreenKt.lambda__1783891267$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1783891267$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783891267, i10, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ComposableSingletons$ReactionsSelectionScreenKt.lambda$-1783891267.<anonymous> (ReactionsSelectionScreen.kt:77)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(30)), RestoreKt.getRestore(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, null, 0, null, null, composer, 6, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final k0 lambda__238641872$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-238641872, i10, -1, "cu.todus.android.uiCompose.main.screen.reactSelection.ComposableSingletons$ReactionsSelectionScreenKt.lambda$-238641872.<anonymous> (ReactionsSelectionScreen.kt:61)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.my_reactions, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1783891267$app_productionPFast, reason: not valid java name */
    public final Function2 m9962getLambda$1783891267$app_productionPFast() {
        return f248lambda$1783891267;
    }

    /* JADX INFO: renamed from: getLambda$-238641872$app_productionPFast, reason: not valid java name */
    public final Function2 m9963getLambda$238641872$app_productionPFast() {
        return f249lambda$238641872;
    }
}
