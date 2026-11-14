package cu.todus.android.uiCompose.shared.errorSnack;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cu.todus.android.R;
import cu.todus.android.exceptions.ToDusException;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcu/todus/android/exceptions/ToDusException;", "error", "Lkotlin/Function0;", "Lua/k0;", "onClear", "ErrorSnack", "(Lcu/todus/android/exceptions/ToDusException;Llb/a;Landroidx/compose/runtime/Composer;I)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ErrorSnackKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ErrorSnack(final ToDusException toDusException, final lb.a onClear, Composer composer, final int i10) {
        int i11;
        ComposableLambda composableLambdaRememberComposableLambda;
        y.i(onClear, "onClear");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1485309177);
        if ((i10 & 6) == 0) {
            i11 = ((i10 & 8) == 0 ? composerStartRestartGroup.changed(toDusException) : composerStartRestartGroup.changedInstance(toDusException) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onClear) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1485309177, i11, -1, "cu.todus.android.uiCompose.shared.errorSnack.ErrorSnack (ErrorSnack.kt:23)");
            }
            if (toDusException != null) {
                composerStartRestartGroup.startReplaceGroup(-1452972551);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierSafeContentPadding = WindowInsetsPadding_androidKt.safeContentPadding(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomCenter(), false);
                int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSafeContentPadding);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                lb.a constructor = companion2.getConstructor();
                if (!r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i12 = MaterialTheme.$stable;
                long onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i12).getOnBackground();
                long background = materialTheme.getColorScheme(composerStartRestartGroup, i12).getBackground();
                if (toDusException.getCanRetry()) {
                    composerStartRestartGroup.startReplaceGroup(2041232845);
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1377505312, true, new Function2() { // from class: cu.todus.android.uiCompose.shared.errorSnack.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ErrorSnackKt.ErrorSnack$lambda$0$0(toDusException, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2041214647);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                int i13 = i11;
                SnackbarKt.m3692SnackbareQBnUkQ(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(8)), composableLambdaRememberComposableLambda, null, false, null, onBackground, background, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(71273227, true, new Function2() { // from class: cu.todus.android.uiCompose.shared.errorSnack.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ErrorSnackKt.ErrorSnack$lambda$0$1(toDusException, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 412);
                composerStartRestartGroup = composerStartRestartGroup;
                String message = toDusException.getMessage();
                boolean z10 = (i13 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ErrorSnackKt$ErrorSnack$1$3$1(onClear, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                EffectsKt.LaunchedEffect(message, (Function2) objRememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2091536261);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.errorSnack.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ErrorSnackKt.ErrorSnack$lambda$1(toDusException, onClear, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ErrorSnack$lambda$0$0(final ToDusException toDusException, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1377505312, i10, -1, "cu.todus.android.uiCompose.shared.errorSnack.ErrorSnack.<anonymous>.<anonymous> (ErrorSnack.kt:34)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.try_again, composer, 0);
            boolean zChangedInstance = composer.changedInstance(toDusException);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.errorSnack.d
                    @Override // lb.a
                    public final Object invoke() {
                        return ErrorSnackKt.ErrorSnack$lambda$0$0$0$0(toDusException);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Z17ButtonsKt.Z17SnackbarButton(null, (lb.a) objRememberedValue, strStringResource, null, false, composer, 0, 25);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ErrorSnack$lambda$0$0$0$0(ToDusException toDusException) {
        toDusException.getRetryFunction().invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ErrorSnack$lambda$0$1(ToDusException toDusException, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(71273227, i10, -1, "cu.todus.android.uiCompose.shared.errorSnack.ErrorSnack.<anonymous>.<anonymous> (ErrorSnack.kt:40)");
            }
            String message = toDusException.getMessage();
            if (message == null) {
                message = "";
            }
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, message, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), 0, 0, composer, 0, 53);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ErrorSnack$lambda$1(ToDusException toDusException, lb.a aVar, int i10, Composer composer, int i11) {
        ErrorSnack(toDusException, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
