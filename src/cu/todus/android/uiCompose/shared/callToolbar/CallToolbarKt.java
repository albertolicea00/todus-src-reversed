package cu.todus.android.uiCompose.shared.callToolbar;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.Lifecycle;
import androidx.p001lifecycle.LifecycleOwner;
import androidx.p001lifecycle.p002compose.FlowExtKt;
import cu.todus.android.R;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.webrtc.CallState;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.permission.PermissionNeedIt;
import cu.z17.views.permission.PermissionsRequesterState;
import cu.z17.views.permission.PermissionsResult;
import cu.z17.views.permission.Z17PermissionRequesterKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aO\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013²\u0006\u000e\u0010\u0012\u001a\u00020\u00118\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lua/k0;", "CallToolbar", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Lcu/todus/android/webrtc/CallState;", "call", "Lkotlin/Function1;", "", "acceptCall", "rejectCall", "CallItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/webrtc/CallState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function2;", "", "CallItemNew", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/webrtc/CallState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lcu/z17/views/permission/PermissionsRequesterState;", "callPermissionsState", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CallToolbarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallItem(Modifier modifier, final CallState call, Function1 function1, final Function1 rejectCall, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        final Function1 acceptCall = function1;
        y.i(call, "call");
        y.i(acceptCall, "acceptCall");
        y.i(rejectCall, "rejectCall");
        Composer composerStartRestartGroup = composer.startRestartGroup(-499913282);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(call) : composerStartRestartGroup.changedInstance(call) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(acceptCall) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(rejectCall) ? 2048 : 1024;
        }
        boolean z10 = true;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-499913282, i12, -1, "cu.todus.android.uiCompose.shared.callToolbar.CallItem (CallToolbar.kt:229)");
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(modifier4, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(2));
            Other other = Other.INSTANCE;
            float f10 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1726paddingVpY3zN4, Color.m5865copywmQWz5c$default(other.m10111getGreen0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.call_from, composerStartRestartGroup, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            int i15 = i12;
            Modifier modifier5 = modifier4;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, strStringResource, materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), 0L, 0, 0, composerStartRestartGroup, 6, 56);
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), call.getPartner().getName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
            float f11 = 3;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10)), other.m10118getRed0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            int i16 = i15 & 112;
            boolean z11 = (i16 == 32 || ((i15 & 64) != 0 && composerStartRestartGroup.changedInstance(call))) | ((i15 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.l
                    @Override // lb.a
                    public final Object invoke() {
                        return CallToolbarKt.CallItem$lambda$0$0$0(rejectCall, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$CallToolbarKt composableSingletons$CallToolbarKt = ComposableSingletons$CallToolbarKt.INSTANCE;
            IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1204backgroundbw27NRU, false, null, null, null, composableSingletons$CallToolbarKt.getLambda$13791996$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
            Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10)), other.m10111getGreen0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            boolean z12 = (i15 & 896) == 256;
            if (i16 != 32 && ((i15 & 64) == 0 || !composerStartRestartGroup.changedInstance(call))) {
                z10 = false;
            }
            boolean z13 = z12 | z10;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                acceptCall = function1;
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.b
                    @Override // lb.a
                    public final Object invoke() {
                        return CallToolbarKt.CallItem$lambda$0$1$0(acceptCall, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                acceptCall = function1;
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1204backgroundbw27NRU2, false, null, null, null, composableSingletons$CallToolbarKt.getLambda$1121261669$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallToolbarKt.CallItem$lambda$1(modifier3, call, acceptCall, rejectCall, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItem$lambda$0$0$0(Function1 function1, CallState callState) {
        function1.invoke(callState.getWith());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItem$lambda$0$1$0(Function1 function1, CallState callState) {
        function1.invoke(callState.getWith());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItem$lambda$1(Modifier modifier, CallState callState, Function1 function1, Function1 function2, int i10, int i11, Composer composer, int i12) {
        CallItem(modifier, callState, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallItemNew(Modifier modifier, final CallState call, Function2 function2, final Function1 rejectCall, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        final Function2 acceptCall = function2;
        y.i(call, "call");
        y.i(acceptCall, "acceptCall");
        y.i(rejectCall, "rejectCall");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1120066945);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 48) == 0) {
            i12 |= (i10 & 64) == 0 ? composerStartRestartGroup.changed(call) : composerStartRestartGroup.changedInstance(call) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(acceptCall) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(rejectCall) ? 2048 : 1024;
        }
        boolean z10 = true;
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120066945, i12, -1, "cu.todus.android.uiCompose.shared.callToolbar.CallItemNew (CallToolbar.kt:293)");
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(modifier4, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(2));
            Other other = Other.INSTANCE;
            float f10 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(BackgroundKt.m1204backgroundbw27NRU(modifierM1726paddingVpY3zN4, Color.m5865copywmQWz5c$default(other.m10111getGreen0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(15))), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(companion2, Dp.m8823constructorimpl(f10), 0.0f, 2, null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.call_from, composerStartRestartGroup, 0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            int i15 = i12;
            Modifier modifier5 = modifier4;
            Z17LabelKt.m10262Z17LabelfWhpE4E(modifierM1727paddingVpY3zN4$default, strStringResource, materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), 0L, 0, 0, composerStartRestartGroup, 6, 56);
            Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(rowScopeInstance, companion2, 1.0f, false, 2, null), call.getPartner().getName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
            float f11 = 3;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10)), other.m10118getRed0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            int i16 = i15 & 112;
            boolean z11 = (i16 == 32 || ((i15 & 64) != 0 && composerStartRestartGroup.changedInstance(call))) | ((i15 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.i
                    @Override // lb.a
                    public final Object invoke() {
                        return CallToolbarKt.CallItemNew$lambda$0$0$0(rejectCall, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$CallToolbarKt composableSingletons$CallToolbarKt = ComposableSingletons$CallToolbarKt.INSTANCE;
            IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1204backgroundbw27NRU, false, null, null, null, composableSingletons$CallToolbarKt.m10080getLambda$294605695$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
            Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(PaddingKt.m1726paddingVpY3zN4(companion2, Dp.m8823constructorimpl(f11), Dp.m8823constructorimpl(f10)), other.m10111getGreen0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            boolean z12 = (i15 & 896) == 256;
            if (i16 != 32 && ((i15 & 64) == 0 || !composerStartRestartGroup.changedInstance(call))) {
                z10 = false;
            }
            boolean z13 = z12 | z10;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                acceptCall = function2;
                objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.j
                    @Override // lb.a
                    public final Object invoke() {
                        return CallToolbarKt.CallItemNew$lambda$0$1$0(acceptCall, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                acceptCall = function2;
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1204backgroundbw27NRU2, false, null, null, null, composableSingletons$CallToolbarKt.m10079getLambda$1604345224$app_productionPFast(), composerStartRestartGroup, 1572864, 60);
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallToolbarKt.CallItemNew$lambda$1(modifier3, call, acceptCall, rejectCall, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItemNew$lambda$0$0$0(Function1 function1, CallState callState) {
        function1.invoke(callState.getWith());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItemNew$lambda$0$1$0(Function2 function2, CallState callState) {
        function2.invoke(callState.getWith(), Boolean.valueOf(callState.isVideoCall()));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallItemNew$lambda$1(Modifier modifier, CallState callState, Function2 function2, Function1 function1, int i10, int i11, Composer composer, int i12) {
        CallItemNew(modifier, callState, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CallToolbar(Modifier modifier, Composer composer, final int i10, final int i11) {
        final Modifier modifier2;
        int i12;
        MutableState mutableState;
        Modifier modifier3;
        final MutableState mutableState2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1583380047);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 3) != 2, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1583380047, i12, -1, "cu.todus.android.uiCompose.shared.callToolbar.CallToolbar (CallToolbar.kt:55)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(MainRepository.INSTANCE.getInstance().requestingCalls().getValue(), va.w.n(), (LifecycleOwner) null, (Lifecycle.State) null, (ab.i) null, composerStartRestartGroup, 48, 14);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(ab.j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final m0 m0Var = (m0) objRememberedValue;
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PermissionsRequesterState(null, false, va.w.q(PermissionNeedIt.STORAGE, PermissionNeedIt.CAMERA, PermissionNeedIt.RECORD_AUDIO, PermissionNeedIt.CALLS), 1, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (((Collection) stateCollectAsStateWithLifecycle.getValue()).isEmpty()) {
                mutableState = mutableState3;
                modifier3 = modifier4;
                composerStartRestartGroup.startReplaceGroup(-931605651);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(247024796);
                Modifier modifierM1756heightInVpY3zN4 = SizeKt.m1756heightInVpY3zN4(modifier4, Dp.m8823constructorimpl(0), Dp.m8823constructorimpl(WebmConstants.MkvEbmlElement.BLOCK_GROUP));
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), composerStartRestartGroup, 0);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1756heightInVpY3zN4);
                lb.a constructor2 = companion4.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.a
                        @Override // lb.a
                        public final Object invoke() {
                            return Integer.valueOf(CallToolbarKt.CallToolbar$lambda$3$0$0$0(stateCollectAsStateWithLifecycle));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = mutableState3;
                modifier3 = modifier4;
                PagerKt.m1961HorizontalPager8jOkeI(PagerStateKt.rememberPagerState(0, 0.0f, (lb.a) objRememberedValue3, composerStartRestartGroup, 6, 2), null, null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-814524057, true, new lb.o() { // from class: cu.todus.android.uiCompose.shared.callToolbar.d
                    @Override // lb.o
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CallToolbarKt.CallToolbar$lambda$3$0$1(stateCollectAsStateWithLifecycle, m0Var, context, mutableState3, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 0, 24576, 16382);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceGroup();
            }
            PermissionsRequesterState permissionsRequesterStateCallToolbar$lambda$1 = CallToolbar$lambda$1(mutableState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                mutableState2 = mutableState;
                objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.shared.callToolbar.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CallToolbarKt.CallToolbar$lambda$3$1$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                mutableState2 = mutableState;
            }
            Z17PermissionRequesterKt.Z17PermissionChecker(null, null, permissionsRequesterStateCallToolbar$lambda$1, (Function1) objRememberedValue4, ComposableSingletons$CallToolbarKt.INSTANCE.getLambda$2136723829$app_productionPFast(), composerStartRestartGroup, 27648, 3);
            PermissionsRequesterState permissionsRequesterStateCallToolbar$lambda$2 = CallToolbar$lambda$1(mutableState2);
            String packageName = context.getPackageName();
            y.h(packageName, "getPackageName(...)");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.shared.callToolbar.f
                    @Override // lb.a
                    public final Object invoke() {
                        return CallToolbarKt.CallToolbar$lambda$3$2$0(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            lb.a aVar = (lb.a) objRememberedValue5;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.shared.callToolbar.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CallToolbarKt.CallToolbar$lambda$3$3$0(mutableState2, (PermissionsResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Composer composer2 = composerStartRestartGroup;
            Z17PermissionRequesterKt.Z17PermissionRequester(permissionsRequesterStateCallToolbar$lambda$2, aVar, (Function1) objRememberedValue6, packageName, composer2, 432);
            composerStartRestartGroup = composer2;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.shared.callToolbar.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CallToolbarKt.CallToolbar$lambda$4(modifier2, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CallToolbar$goCall(m0 m0Var, MutableState<PermissionsRequesterState> mutableState, Context context, String str) {
        if (y.d(CallToolbar$lambda$1(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new CallToolbarKt$CallToolbar$goCall$1(str, m0Var, context, null), 3, null);
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), null, true, null, 5, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CallToolbar$goCallNew(m0 m0Var, MutableState<PermissionsRequesterState> mutableState, Context context, String str, boolean z10) {
        if (y.d(CallToolbar$lambda$1(mutableState).getPermissionsResult(), PermissionsResult.INSTANCE.granted())) {
            CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new CallToolbarKt$CallToolbar$goCallNew$1(str, m0Var, z10, context, null), 3, null);
        } else {
            mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), null, true, null, 5, null));
        }
    }

    private static final PermissionsRequesterState CallToolbar$lambda$1(MutableState<PermissionsRequesterState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CallToolbar$lambda$3$0$0$0(State state) {
        return ((List) state.getValue()).size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final k0 CallToolbar$lambda$3$0$1(State state, m0 m0Var, Context context, MutableState mutableState, PagerScope HorizontalPager, int i10, Composer composer, int i11) {
        y.i(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-814524057, i11, -1, "cu.todus.android.uiCompose.shared.callToolbar.CallToolbar.<anonymous>.<anonymous>.<anonymous> (CallToolbar.kt:179)");
        }
        CallState callState = (CallState) g0.Y0((Iterable) state.getValue()).get(i10);
        boolean zChangedInstance = composer.changedInstance(m0Var) | composer.changedInstance(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CallToolbarKt$CallToolbar$1$1$1$1$1(m0Var, mutableState, context);
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) ((sb.h) objRememberedValue);
        boolean zChangedInstance2 = composer.changedInstance(m0Var);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new CallToolbarKt$CallToolbar$1$1$1$2$1(m0Var);
            composer.updateRememberedValue(objRememberedValue2);
        }
        CallItemNew(null, callState, function2, (Function1) ((sb.h) objRememberedValue2), composer, CallState.$stable << 3, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallToolbar$lambda$3$1$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), result, false, null, 6, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallToolbar$lambda$3$2$0(MutableState mutableState) {
        mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), null, false, null, 5, null));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallToolbar$lambda$3$3$0(MutableState mutableState, PermissionsResult result) {
        y.i(result, "result");
        mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), result, false, null, 6, null));
        Integer state = result.getState();
        if (state != null && state.intValue() == 2) {
            mutableState.setValue(PermissionsRequesterState.copy$default(CallToolbar$lambda$1(mutableState), null, false, null, 5, null));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CallToolbar$lambda$4(Modifier modifier, int i10, int i11, Composer composer, int i12) {
        CallToolbar(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CallToolbar$rejectCall(m0 m0Var, String str) {
        CoroutineUtilsKt.launchWithContext$default(m0Var, null, null, new CallToolbarKt$CallToolbar$rejectCall$1(str, null), 3, null);
    }
}
