package cu.todus.android.uiCompose.main.screen.chat.preview;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import cu.z17.views.picture.Z17PictureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$MsgPreviewKt {
    public static final ComposableSingletons$MsgPreviewKt INSTANCE = new ComposableSingletons$MsgPreviewKt();

    /* JADX INFO: renamed from: lambda$-162533231, reason: not valid java name */
    private static Function2 f201lambda$162533231 = ComposableLambdaKt.composableLambdaInstance(-162533231, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MsgPreviewKt.lambda__162533231$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$1754997669 = ComposableLambdaKt.composableLambdaInstance(1754997669, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MsgPreviewKt.lambda_1754997669$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_1754997669$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1754997669, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.ComposableSingletons$MsgPreviewKt.lambda$1754997669.<anonymous> (MsgPreview.kt:175)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), CloseKt.getClose(Icons.Outlined.INSTANCE), null, null, null, "close edit btn", 0, null, null, composer, 196614, 476);
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
    public static final k0 lambda__162533231$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-162533231, i10, -1, "cu.todus.android.uiCompose.main.screen.chat.preview.ComposableSingletons$MsgPreviewKt.lambda$-162533231.<anonymous> (MsgPreview.kt:119)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), CloseKt.getClose(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), 0, 2, null), null, "close reply btn", 0, null, null, composer, 196614, 468);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-162533231$app_productionPFast, reason: not valid java name */
    public final Function2 m9907getLambda$162533231$app_productionPFast() {
        return f201lambda$162533231;
    }

    public final Function2 getLambda$1754997669$app_productionPFast() {
        return lambda$1754997669;
    }
}
