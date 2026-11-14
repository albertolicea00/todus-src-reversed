package cu.todus.android.uiCompose.call.screen.call.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.uiCompose.call.screen.call.components.ComposableSingletons$BigCallItemKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$BigCallItemKt {
    public static final ComposableSingletons$BigCallItemKt INSTANCE = new ComposableSingletons$BigCallItemKt();
    private static Function3 lambda$117701665 = ComposableLambdaKt.composableLambdaInstance(117701665, false, new Function3() { // from class: i7.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigCallItemKt.lambda_117701665$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2088015414, reason: not valid java name */
    private static Function3 f160lambda$2088015414 = ComposableLambdaKt.composableLambdaInstance(-2088015414, false, new Function3() { // from class: i7.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BigCallItemKt.lambda__2088015414$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_117701665$lambda$0(RowScope Z17BaseDialogButton, Composer composer, int i10) {
        y.i(Z17BaseDialogButton, "$this$Z17BaseDialogButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(117701665, i10, -1, "cu.todus.android.uiCompose.call.screen.call.components.ComposableSingletons$BigCallItemKt.lambda$117701665.<anonymous> (BigCallItem.kt:84)");
            }
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24));
            Integer numValueOf = Integer.valueOf(R.drawable.call_end);
            ColorFilter.Companion companion = ColorFilter.INSTANCE;
            Color.Companion companion2 = Color.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, numValueOf, null, ColorFilter.Companion.m5907tintxETnrds$default(companion, companion2.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.hang_up, composer, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), companion2.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 49);
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
    public static final k0 lambda__2088015414$lambda$0(RowScope Z17BaseDialogButton, Composer composer, int i10) {
        y.i(Z17BaseDialogButton, "$this$Z17BaseDialogButton");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2088015414, i10, -1, "cu.todus.android.uiCompose.call.screen.call.components.ComposableSingletons$BigCallItemKt.lambda$-2088015414.<anonymous> (BigCallItem.kt:108)");
            }
            Modifier modifierM1769size3ABfNKs = SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24));
            Integer numValueOf = Integer.valueOf(R.drawable.call_start);
            ColorFilter.Companion companion = ColorFilter.INSTANCE;
            Color.Companion companion2 = Color.INSTANCE;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(modifierM1769size3ABfNKs, numValueOf, null, ColorFilter.Companion.m5907tintxETnrds$default(companion, companion2.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.answer, composer, 0), TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), companion2.m5903getWhite0d7_KjU(), 0, 0, composer, 3072, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-2088015414$app_productionPFast, reason: not valid java name */
    public final Function3 m9810getLambda$2088015414$app_productionPFast() {
        return f160lambda$2088015414;
    }

    public final Function3 getLambda$117701665$app_productionPFast() {
        return lambda$117701665;
    }
}
