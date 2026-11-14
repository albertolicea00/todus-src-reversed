package cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$SearchContactTopBarKt {
    public static final ComposableSingletons$SearchContactTopBarKt INSTANCE = new ComposableSingletons$SearchContactTopBarKt();

    /* JADX INFO: renamed from: lambda$-1751361229, reason: not valid java name */
    private static Function2 f279lambda$1751361229 = ComposableLambdaKt.composableLambdaInstance(-1751361229, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SearchContactTopBarKt.lambda__1751361229$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2 lambda$961044201 = ComposableLambdaKt.composableLambdaInstance(961044201, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SearchContactTopBarKt.lambda_961044201$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-748205796, reason: not valid java name */
    private static Function2 f280lambda$748205796 = ComposableLambdaKt.composableLambdaInstance(-748205796, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SearchContactTopBarKt.lambda__748205796$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda_961044201$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(961044201, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.ComposableSingletons$SearchContactTopBarKt.lambda$961044201.<anonymous> (SearchContactTopBar.kt:73)");
            }
            IconKt.m3298Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary(), composer, 48, 4);
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
    public static final k0 lambda__1751361229$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1751361229, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.ComposableSingletons$SearchContactTopBarKt.lambda$-1751361229.<anonymous> (SearchContactTopBar.kt:35)");
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
    public static final k0 lambda__748205796$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748205796, i10, -1, "cu.todus.android.uiCompose.main.screen.usersDisplay.toolbar.ComposableSingletons$SearchContactTopBarKt.lambda$-748205796.<anonymous> (SearchContactTopBar.kt:96)");
            }
            IconKt.m3298Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: getLambda$-1751361229$app_productionPFast, reason: not valid java name */
    public final Function2 m10000getLambda$1751361229$app_productionPFast() {
        return f279lambda$1751361229;
    }

    /* JADX INFO: renamed from: getLambda$-748205796$app_productionPFast, reason: not valid java name */
    public final Function2 m10001getLambda$748205796$app_productionPFast() {
        return f280lambda$748205796;
    }

    public final Function2 getLambda$961044201$app_productionPFast() {
        return lambda$961044201;
    }
}
