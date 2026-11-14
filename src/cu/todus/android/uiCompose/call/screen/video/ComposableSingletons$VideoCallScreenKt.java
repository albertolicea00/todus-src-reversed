package cu.todus.android.uiCompose.call.screen.video;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import cu.todus.android.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$VideoCallScreenKt {
    public static final ComposableSingletons$VideoCallScreenKt INSTANCE = new ComposableSingletons$VideoCallScreenKt();

    /* JADX INFO: renamed from: lambda$-359242039, reason: not valid java name */
    private static Function3 f162lambda$359242039 = ComposableLambdaKt.composableLambdaInstance(-359242039, false, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$VideoCallScreenKt.lambda__359242039$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2002292295, reason: not valid java name */
    private static Function3 f161lambda$2002292295 = ComposableLambdaKt.composableLambdaInstance(-2002292295, false, new Function3() { // from class: cu.todus.android.uiCompose.call.screen.video.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$VideoCallScreenKt.lambda__2002292295$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__2002292295$lambda$0(RowScope Button, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(Button, "$this$Button");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2002292295, i10, -1, "cu.todus.android.uiCompose.call.screen.video.ComposableSingletons$VideoCallScreenKt.lambda$-2002292295.<anonymous> (VideoCallScreen.kt:647)");
            }
            TextKt.m3850TextNvy7gAk(StringResources_androidKt.stringResource(R.string.exit, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8271copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
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
    public static final k0 lambda__359242039$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-359242039, i10, -1, "cu.todus.android.uiCompose.call.screen.video.ComposableSingletons$VideoCallScreenKt.lambda$-359242039.<anonymous> (VideoCallScreen.kt:291)");
        }
        VideoCallScreenKt.VideoScrim(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-2002292295$app_productionPFast, reason: not valid java name */
    public final Function3 m9823getLambda$2002292295$app_productionPFast() {
        return f161lambda$2002292295;
    }

    /* JADX INFO: renamed from: getLambda$-359242039$app_productionPFast, reason: not valid java name */
    public final Function3 m9824getLambda$359242039$app_productionPFast() {
        return f162lambda$359242039;
    }
}
