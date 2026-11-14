package cu.todus.android.uiCompose.main.screen.createGroup;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CheckKt;
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

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$CreateGroupStep2ConfigurationScreenKt {
    public static final ComposableSingletons$CreateGroupStep2ConfigurationScreenKt INSTANCE = new ComposableSingletons$CreateGroupStep2ConfigurationScreenKt();
    private static Function2 lambda$798189632 = ComposableLambdaKt.composableLambdaInstance(798189632, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.lambda_798189632$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1565787689, reason: not valid java name */
    private static Function2 f218lambda$1565787689 = ComposableLambdaKt.composableLambdaInstance(-1565787689, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.createGroup.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.lambda__1565787689$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_798189632$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(798189632, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.lambda$798189632.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:142)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.new_group, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
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
    public static final ua.k0 lambda__1565787689$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1565787689, i10, -1, "cu.todus.android.uiCompose.main.screen.createGroup.ComposableSingletons$CreateGroupStep2ConfigurationScreenKt.lambda$-1565787689.<anonymous> (CreateGroupStep2ConfigurationScreen.kt:157)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(25)), CheckKt.getCheck(Icons.Outlined.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 2, null), null, "complete action btn", 0, null, null, composer, 196614, 468);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1565787689$app_productionPFast, reason: not valid java name */
    public final Function2 m9926getLambda$1565787689$app_productionPFast() {
        return f218lambda$1565787689;
    }

    public final Function2 getLambda$798189632$app_productionPFast() {
        return lambda$798189632;
    }
}
