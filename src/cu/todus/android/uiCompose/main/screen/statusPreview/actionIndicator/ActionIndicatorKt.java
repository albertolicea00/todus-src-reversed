package cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.screen.statusPreview.actionsBar.StatusActionsBarKt;
import cu.z17.views.label.Z17LabelKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y;
import l0.j;
import le.d0;
import p0.e;
import p0.l;
import p0.n;
import p0.r;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u0004\u0018\u00010\u00078\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/actionIndicator/ActionIndicatorData;", "actionIndicatorData", "Lkotlin/Function0;", "Lua/k0;", "onCompleted", "ActionIndicator", "(Lcu/todus/android/uiCompose/main/screen/statusPreview/actionIndicator/ActionIndicatorData;Llb/a;Landroidx/compose/runtime/Composer;I)V", "Ll0/j;", "sparkles", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ActionIndicatorKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ActionIndicator(final ActionIndicatorData actionIndicatorData, final lb.a onCompleted, Composer composer, final int i10) {
        int i11;
        y.i(actionIndicatorData, "actionIndicatorData");
        y.i(onCompleted, "onCompleted");
        Composer composerStartRestartGroup = composer.startRestartGroup(-152342345);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(actionIndicatorData) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCompleted) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i11 & 19) != 18, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-152342345, i11, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicator (ActionIndicator.kt:37)");
            }
            final u0 u0Var = new u0();
            final l lVarQ = r.q(n.a.a(n.a.b(R.raw.sparkles)), null, null, null, null, null, composerStartRestartGroup, 0, 62);
            AnimatedVisibilityKt.AnimatedVisibility(actionIndicatorData.getAction() != 0, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(722396047, true, new Function3() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ActionIndicatorKt.ActionIndicator$lambda$1(actionIndicatorData, lVarQ, u0Var, onCompleted, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionIndicatorKt.ActionIndicator$lambda$2(actionIndicatorData, onCompleted, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final j ActionIndicator$lambda$0(l lVar) {
        return (j) lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 ActionIndicator$lambda$1(ActionIndicatorData actionIndicatorData, l lVar, u0 u0Var, lb.a aVar, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        int i11;
        Composer composer2 = composer;
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(722396047, i10, -1, "cu.todus.android.uiCompose.main.screen.statusPreview.actionIndicator.ActionIndicator.<anonymous> (ActionIndicator.kt:49)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        Color.Companion companion2 = Color.INSTANCE;
        Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(modifierFillMaxSize$default, Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1205backgroundbw27NRU$default);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion4.getConstructor();
        if (!defpackage.r.a(composer2.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor);
        } else {
            composer2.useNode();
        }
        Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer2);
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        int action = actionIndicatorData.getAction();
        if (action == 1) {
            i11 = 0;
            composer2.startReplaceGroup(1839616135);
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.response_sent, composer2, 0), MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), companion2.m5903getWhite0d7_KjU(), 0, 0, composer2, 3072, 48);
            composer2.endReplaceGroup();
        } else if (action != 2) {
            if (action != 3) {
                composer2.startReplaceGroup(1841668397);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1841132686);
                Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(10)), StringResources_androidKt.stringResource(R.string.shared, composer2, 0), MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), companion2.m5903getWhite0d7_KjU(), 0, 0, composer2, 3072, 48);
                composer2.endReplaceGroup();
            }
            i11 = 0;
        } else {
            composer2.startReplaceGroup(1840196424);
            if (d0.q0(actionIndicatorData.getReactionValue())) {
                i11 = 0;
                composer2.startReplaceGroup(1841075181);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-910467130);
                Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(companion2.m5892getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(10));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1725padding3ABfNKs);
                lb.a constructor2 = companion4.getConstructor();
                if (!defpackage.r.a(composer2.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composer2);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                i11 = 0;
                e.a(ActionIndicator$lambda$0(lVar), SizeKt.m1769size3ABfNKs(companion, Dp.m8823constructorimpl(250)), false, false, null, 0.0f, 1, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, composer, 1572912, 0, 0, 4194236);
                StatusActionsBarKt.m9994ReactionItemKmRG4DE(actionIndicatorData.getReactionValue(), TextUnitKt.getSp(100), composer, 48, 0);
                composer2 = composer;
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
        }
        composer2.endNode();
        EffectsKt.LaunchedEffect(AnimatedVisibility.getTransition().getCurrentState(), new ActionIndicatorKt$ActionIndicator$1$2(AnimatedVisibility, u0Var, aVar, null), composer2, i11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ActionIndicator$lambda$2(ActionIndicatorData actionIndicatorData, lb.a aVar, int i10, Composer composer, int i11) {
        ActionIndicator(actionIndicatorData, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
