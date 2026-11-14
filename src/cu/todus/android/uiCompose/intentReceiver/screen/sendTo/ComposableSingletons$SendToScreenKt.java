package cu.todus.android.uiCompose.intentReceiver.screen.sendTo;

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
public final class ComposableSingletons$SendToScreenKt {
    public static final ComposableSingletons$SendToScreenKt INSTANCE = new ComposableSingletons$SendToScreenKt();

    /* JADX INFO: renamed from: lambda$-1470238034, reason: not valid java name */
    private static Function2 f163lambda$1470238034 = ComposableLambdaKt.composableLambdaInstance(-1470238034, false, new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SendToScreenKt.lambda__1470238034$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$424332865 = ComposableLambdaKt.composableLambdaInstance(424332865, false, new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SendToScreenKt.lambda_424332865$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2112570399, reason: not valid java name */
    private static Function2 f164lambda$2112570399 = ComposableLambdaKt.composableLambdaInstance(-2112570399, false, new Function2() { // from class: cu.todus.android.uiCompose.intentReceiver.screen.sendTo.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SendToScreenKt.lambda__2112570399$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_424332865$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424332865, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.ComposableSingletons$SendToScreenKt.lambda$424332865.<anonymous> (SendToScreen.kt:156)");
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
    public static final k0 lambda__1470238034$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1470238034, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.ComposableSingletons$SendToScreenKt.lambda$-1470238034.<anonymous> (SendToScreen.kt:143)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.send_to_hint, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final k0 lambda__2112570399$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112570399, i10, -1, "cu.todus.android.uiCompose.intentReceiver.screen.sendTo.ComposableSingletons$SendToScreenKt.lambda$-2112570399.<anonymous> (SendToScreen.kt:260)");
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

    /* JADX INFO: renamed from: getLambda$-1470238034$app_productionPFast, reason: not valid java name */
    public final Function2 m9833getLambda$1470238034$app_productionPFast() {
        return f163lambda$1470238034;
    }

    /* JADX INFO: renamed from: getLambda$-2112570399$app_productionPFast, reason: not valid java name */
    public final Function2 m9834getLambda$2112570399$app_productionPFast() {
        return f164lambda$2112570399;
    }

    public final Function2 getLambda$424332865$app_productionPFast() {
        return lambda$424332865;
    }
}
