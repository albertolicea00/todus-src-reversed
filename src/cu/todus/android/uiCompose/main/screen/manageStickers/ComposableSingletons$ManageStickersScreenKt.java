package cu.todus.android.uiCompose.main.screen.manageStickers;

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
public final class ComposableSingletons$ManageStickersScreenKt {
    public static final ComposableSingletons$ManageStickersScreenKt INSTANCE = new ComposableSingletons$ManageStickersScreenKt();

    /* JADX INFO: renamed from: lambda$-69619731, reason: not valid java name */
    private static Function2 f233lambda$69619731 = ComposableLambdaKt.composableLambdaInstance(-69619731, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ManageStickersScreenKt.lambda__69619731$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1677827942, reason: not valid java name */
    private static Function2 f232lambda$1677827942 = ComposableLambdaKt.composableLambdaInstance(-1677827942, false, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ManageStickersScreenKt.lambda__1677827942$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__1677827942$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1677827942, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ComposableSingletons$ManageStickersScreenKt.lambda$-1677827942.<anonymous> (ManageStickersScreen.kt:106)");
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

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 lambda__69619731$lambda$0(Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-69619731, i10, -1, "cu.todus.android.uiCompose.main.screen.manageStickers.ComposableSingletons$ManageStickersScreenKt.lambda$-69619731.<anonymous> (ManageStickersScreen.kt:82)");
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

    /* JADX INFO: renamed from: getLambda$-1677827942$app_productionPFast, reason: not valid java name */
    public final Function2 m9944getLambda$1677827942$app_productionPFast() {
        return f232lambda$1677827942;
    }

    /* JADX INFO: renamed from: getLambda$-69619731$app_productionPFast, reason: not valid java name */
    public final Function2 m9945getLambda$69619731$app_productionPFast() {
        return f233lambda$69619731;
    }
}
