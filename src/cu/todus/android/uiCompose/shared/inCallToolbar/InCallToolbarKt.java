package cu.todus.android.uiCompose.shared.inCallToolbar;

import ab.i;
import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.R;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.volatileState.AppVolatileState;
import cu.z17.views.label.Z17LabelKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import te.b0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lua/k0;", "InCallToolbar", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "", "startTime", "TickTack", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "", "currentPassedTime", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class InCallToolbarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InCallToolbar(Modifier modifier, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1318130570);
        int i12 = i10 & 1;
        if (composerStartRestartGroup.shouldExecute(i12 != 0, i12)) {
            modifier2 = (i11 & 1) != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1318130570, i10, -1, "cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbar (InCallToolbar.kt:35)");
            }
            AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
            State stateCollectAsStateWithLifecycle = null;
            b0 isCallServiceRunning = instanceOrNull != null ? instanceOrNull.getIsCallServiceRunning() : null;
            if (isCallServiceRunning == null) {
                composerStartRestartGroup.startReplaceGroup(-458034694);
            } else {
                composerStartRestartGroup.startReplaceGroup(-291869977);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(isCallServiceRunning, (LifecycleOwner) null, (Lifecycle.State) null, (i) null, composerStartRestartGroup, 0, 7);
            }
            composerStartRestartGroup.endReplaceGroup();
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            AnimatedVisibilityKt.AnimatedVisibility(stateCollectAsStateWithLifecycle != null && ((Boolean) stateCollectAsStateWithLifecycle.getValue()).booleanValue(), (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-988725150, true, new Function3() { // from class: cu.todus.android.uiCompose.shared.inCallToolbar.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InCallToolbarKt.InCallToolbar$lambda$0(context, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.inCallToolbar.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InCallToolbarKt.InCallToolbar$lambda$1(modifier2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void InCallToolbar$goCall(Context context) {
        CallActivity.Companion.openCallActivity$default(CallActivity.INSTANCE, context, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 InCallToolbar$lambda$0(final Context context, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-988725150, i10, -1, "cu.todus.android.uiCompose.shared.inCallToolbar.InCallToolbar.<anonymous> (InCallToolbar.kt:50)");
        }
        Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8823constructorimpl(10), Dp.m8823constructorimpl(5));
        boolean zChangedInstance = composer.changedInstance(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.inCallToolbar.d
                @Override // lb.a
                public final Object invoke() {
                    return InCallToolbarKt.InCallToolbar$lambda$0$0$0(context);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Modifier modifierM1726paddingVpY3zN5 = PaddingKt.m1726paddingVpY3zN4(BackgroundKt.m1204backgroundbw27NRU(ClickableKt.m1240clickableoSLSa3U$default(modifierM1726paddingVpY3zN4, false, null, null, null, (lb.a) objRememberedValue, 15, null), Other.INSTANCE.m10111getGreen0d7_KjU(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(8), Dp.m8823constructorimpl(20));
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getTop(), composer, 6);
        int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1726paddingVpY3zN5);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        lb.a constructor = companion.getConstructor();
        if (!r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.calling_hint, composer, 0), null, 0L, 0, 0, composer, 0, 61);
        TickTack(null, AppVolatileState.INSTANCE.getInstance().getCallStartTime(), composer, 0, 1);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InCallToolbar$lambda$0$0$0(Context context) {
        InCallToolbar$goCall(context);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 InCallToolbar$lambda$1(Modifier modifier, int i10, int i11, Composer composer, int i12) {
        InCallToolbar(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TickTack(Modifier modifier, final long j10, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1689392650);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = i10 | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= composerStartRestartGroup.changed(j10) ? 32 : 16;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 19) != 18, i14 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1689392650, i14, -1, "cu.todus.android.uiCompose.shared.inCallToolbar.TickTack (InCallToolbar.kt:70)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("00:00", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifier5 = modifier4;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifier5, TickTack$lambda$1(mutableState), null, 0L, 0, 0, composerStartRestartGroup, i14 & 14, 60);
            k0 k0Var = k0.f43947a;
            boolean z10 = (i14 & 112) == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new InCallToolbarKt$TickTack$1$1(j10, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(k0Var, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.inCallToolbar.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InCallToolbarKt.TickTack$lambda$4(modifier3, j10, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String TickTack$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 TickTack$lambda$4(Modifier modifier, long j10, int i10, int i11, Composer composer, int i12) {
        TickTack(modifier, j10, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
