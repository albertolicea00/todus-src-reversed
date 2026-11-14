package cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material3.IconKt;
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
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$ForwardToScreenKt {
    public static final ComposableSingletons$ForwardToScreenKt INSTANCE = new ComposableSingletons$ForwardToScreenKt();
    private static Function2 lambda$1341889331 = ComposableLambdaKt.composableLambdaInstance(1341889331, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ForwardToScreenKt.lambda_1341889331$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$13318534 = ComposableLambdaKt.composableLambdaInstance(13318534, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ForwardToScreenKt.lambda_13318534$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$542428966 = ComposableLambdaKt.composableLambdaInstance(542428966, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ForwardToScreenKt.lambda_542428966$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_13318534$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(13318534, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ComposableSingletons$ForwardToScreenKt.lambda$13318534.<anonymous> (ForwardToScreen.kt:127)");
            }
            IconKt.m3298Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final k0 lambda_1341889331$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341889331, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ComposableSingletons$ForwardToScreenKt.lambda$1341889331.<anonymous> (ForwardToScreen.kt:114)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.resend_hint, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 lambda_542428966$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(542428966, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.forwardTo.ComposableSingletons$ForwardToScreenKt.lambda$542428966.<anonymous> (ForwardToScreen.kt:177)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), Integer.valueOf(R.drawable.send_icon), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "Send on forward btn", 0, null, null, composer, 196614, 468);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    public final Function2 getLambda$13318534$app_productionPFast() {
        return lambda$13318534;
    }

    public final Function2 getLambda$1341889331$app_productionPFast() {
        return lambda$1341889331;
    }

    public final Function2 getLambda$542428966$app_productionPFast() {
        return lambda$542428966;
    }
}
