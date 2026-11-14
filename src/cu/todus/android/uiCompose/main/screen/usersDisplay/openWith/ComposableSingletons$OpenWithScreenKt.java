package cu.todus.android.uiCompose.main.screen.usersDisplay.openWith;

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
import androidx.compose.ui.res.StringResources_androidKt;
import cu.todus.android.R;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$OpenWithScreenKt {
    public static final ComposableSingletons$OpenWithScreenKt INSTANCE = new ComposableSingletons$OpenWithScreenKt();

    /* JADX INFO: renamed from: lambda$-983848052, reason: not valid java name */
    private static Function2 f278lambda$983848052 = ComposableLambdaKt.composableLambdaInstance(-983848052, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OpenWithScreenKt.lambda__983848052$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$2074458691 = ComposableLambdaKt.composableLambdaInstance(2074458691, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OpenWithScreenKt.lambda_2074458691$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 lambda_2074458691$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2074458691, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.ComposableSingletons$OpenWithScreenKt.lambda$2074458691.<anonymous> (OpenWithScreen.kt:194)");
            }
            IconKt.m3298Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
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
    public static final ua.k0 lambda__983848052$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-983848052, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.openWith.ComposableSingletons$OpenWithScreenKt.lambda$-983848052.<anonymous> (OpenWithScreen.kt:178)");
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.start_conversation, composer, 0), MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0, 0, composer, 0, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-983848052$app_productionPFast, reason: not valid java name */
    public final Function2 m9999getLambda$983848052$app_productionPFast() {
        return f278lambda$983848052;
    }

    public final Function2 getLambda$2074458691$app_productionPFast() {
        return lambda$2074458691;
    }
}
