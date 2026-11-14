package cu.todus.android.uiCompose.main.screen.qrReader;

import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavHostController;
import cu.z17.views.scaffold.Z17ScaffoldKt;
import cu.z17.views.topBar.Z17TopBarKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lua/k0;", "QrReaderScreen", "(Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class QrReaderScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void QrReaderScreen(final NavHostController navHostController, Composer composer, final int i10) {
        int i11;
        y.i(navHostController, "navHostController");
        Composer composerStartRestartGroup = composer.startRestartGroup(100613890);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(100613890, i11, -1, "cu.todus.android.uiCompose.main.screen.qrReader.QrReaderScreen (QrReaderScreen.kt:56)");
            }
            Z17ScaffoldKt.m10301Z17BaseScaffoldueL0Wzs(ComposableLambdaKt.rememberComposableLambda(1266853686, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QrReaderScreenKt.QrReaderScreen$lambda$0(navHostController, (TopAppBarScrollBehavior) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, false, false, null, null, 0L, ScaffoldKt.rememberScaffoldState(null, null, composerStartRestartGroup, 0, 3), null, ComposableSingletons$QrReaderScreenKt.INSTANCE.getLambda$102382264$app_productionPFast(), composerStartRestartGroup, 805306806, 376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrReaderScreenKt.QrReaderScreen$lambda$1(navHostController, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 QrReaderScreen$lambda$0(final NavHostController navHostController, TopAppBarScrollBehavior it, Composer composer, int i10) {
        y.i(it, "it");
        if (composer.shouldExecute((i10 & 17) != 16, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1266853686, i10, -1, "cu.todus.android.uiCompose.main.screen.qrReader.QrReaderScreen.<anonymous> (QrReaderScreen.kt:62)");
            }
            Function2 function2M9961getLambda$2065297021$app_productionPFast = ComposableSingletons$QrReaderScreenKt.INSTANCE.m9961getLambda$2065297021$app_productionPFast();
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.qrReader.l
                    @Override // lb.a
                    public final Object invoke() {
                        return QrReaderScreenKt.QrReaderScreen$lambda$0$0$0(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17TopBarKt.m10304Z17TopBardW2gCk(function2M9961getLambda$2065297021$app_productionPFast, null, false, null, false, navHostController, (lb.a) objRememberedValue, null, 0L, 0L, 0.0f, composer, 6, 0, 1950);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 QrReaderScreen$lambda$0$0$0(NavHostController navHostController) {
        navHostController.navigateUp();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 QrReaderScreen$lambda$1(NavHostController navHostController, int i10, Composer composer, int i11) {
        QrReaderScreen(navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
