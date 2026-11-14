package cu.todus.android.uiCompose.main.screen.catalogue;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$CatalogueWebScreenKt {
    public static final ComposableSingletons$CatalogueWebScreenKt INSTANCE = new ComposableSingletons$CatalogueWebScreenKt();

    /* JADX INFO: renamed from: lambda$-1551904743, reason: not valid java name */
    private static Function2 f168lambda$1551904743 = ComposableLambdaKt.composableLambdaInstance(-1551904743, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CatalogueWebScreenKt.lambda__1551904743$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3 lambda$611118926 = ComposableLambdaKt.composableLambdaInstance(611118926, false, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.k
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CatalogueWebScreenKt.lambda_611118926$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_611118926$lambda$0(Modifier it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611118926, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.ComposableSingletons$CatalogueWebScreenKt.lambda$611118926.<anonymous> (CatalogueWebScreen.kt:39)");
            }
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
    public static final k0 lambda__1551904743$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1551904743, i10, -1, "cu.todus.android.uiCompose.main.screen.catalogue.ComposableSingletons$CatalogueWebScreenKt.lambda$-1551904743.<anonymous> (CatalogueWebScreen.kt:30)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.catalog, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1551904743$app_productionPFast, reason: not valid java name */
    public final Function2 m9839getLambda$1551904743$app_productionPFast() {
        return f168lambda$1551904743;
    }

    public final Function3 getLambda$611118926$app_productionPFast() {
        return lambda$611118926;
    }
}
