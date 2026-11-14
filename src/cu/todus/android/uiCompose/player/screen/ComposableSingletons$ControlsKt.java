package cu.todus.android.uiCompose.player.screen;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ControlsKt {
    public static final ComposableSingletons$ControlsKt INSTANCE = new ComposableSingletons$ControlsKt();
    private static Function3 lambda$1121610416 = ComposableLambdaKt.composableLambdaInstance(1121610416, false, new Function3() { // from class: cu.todus.android.uiCompose.player.screen.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ControlsKt.lambda_1121610416$lambda$0((SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-200876903, reason: not valid java name */
    private static Function3 f353lambda$200876903 = ComposableLambdaKt.composableLambdaInstance(-200876903, false, new Function3() { // from class: cu.todus.android.uiCompose.player.screen.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ControlsKt.lambda__200876903$lambda$0((SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2 lambda$1621741040 = ComposableLambdaKt.composableLambdaInstance(1621741040, false, new Function2() { // from class: cu.todus.android.uiCompose.player.screen.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ControlsKt.lambda_1621741040$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_1121610416$lambda$0(SliderState it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121610416, i10, -1, "cu.todus.android.uiCompose.player.screen.ComposableSingletons$ControlsKt.lambda$1121610416.<anonymous> (Controls.kt:108)");
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
    public static final ua.k0 lambda_1621741040$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621741040, i10, -1, "cu.todus.android.uiCompose.player.screen.ComposableSingletons$ControlsKt.lambda$1621741040.<anonymous> (Controls.kt:164)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), SettingsKt.getSettings(Icons.Filled.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
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
    public static final ua.k0 lambda__200876903$lambda$0(SliderState it, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-200876903, i10, -1, "cu.todus.android.uiCompose.player.screen.ComposableSingletons$ControlsKt.lambda$-200876903.<anonymous> (Controls.kt:127)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-200876903$app_productionPFast, reason: not valid java name */
    public final Function3 m10074getLambda$200876903$app_productionPFast() {
        return f353lambda$200876903;
    }

    public final Function3 getLambda$1121610416$app_productionPFast() {
        return lambda$1121610416;
    }

    public final Function2 getLambda$1621741040$app_productionPFast() {
        return lambda$1621741040;
    }
}
