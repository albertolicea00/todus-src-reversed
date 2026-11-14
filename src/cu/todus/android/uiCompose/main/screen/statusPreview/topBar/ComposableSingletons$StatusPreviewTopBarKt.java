package cu.todus.android.uiCompose.main.screen.statusPreview.topBar;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowBackIosKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.uiCompose.main.screen.statusPreview.topBar.ComposableSingletons$StatusPreviewTopBarKt;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$StatusPreviewTopBarKt {
    public static final ComposableSingletons$StatusPreviewTopBarKt INSTANCE = new ComposableSingletons$StatusPreviewTopBarKt();

    /* JADX INFO: renamed from: lambda$-2087634567, reason: not valid java name */
    private static Function2 f276lambda$2087634567 = ComposableLambdaKt.composableLambdaInstance(-2087634567, false, new Function2() { // from class: j8.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatusPreviewTopBarKt.lambda__2087634567$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__2087634567$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087634567, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.topBar.ComposableSingletons$StatusPreviewTopBarKt.lambda$-2087634567.<anonymous> (StatusPreviewTopBar.kt:75)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), ArrowBackIosKt.getArrowBackIos(Icons.AutoMirrored.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-2087634567$app_productionPFast, reason: not valid java name */
    public final Function2 m9995getLambda$2087634567$app_productionPFast() {
        return f276lambda$2087634567;
    }
}
