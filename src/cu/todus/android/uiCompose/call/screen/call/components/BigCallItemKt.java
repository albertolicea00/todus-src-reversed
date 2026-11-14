package cu.todus.android.uiCompose.call.screen.call.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.R;
import cu.todus.android.uiCompose.call.screen.call.components.BigCallItemKt;
import cu.todus.android.uiCompose.theme.Other;
import cu.todus.android.webrtc.CallState;
import cu.z17.views.button.Z17ButtonsKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.picture.Z17PictureAvatarKt;
import defpackage.l;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aI\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcu/todus/android/webrtc/CallState;", "call", "Lkotlin/Function1;", "", "Lua/k0;", "acceptCall", "rejectCall", "BigCallItem", "(Landroidx/compose/ui/Modifier;Lcu/todus/android/webrtc/CallState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BigCallItemKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BigCallItem(Modifier modifier, final CallState call, Function1 acceptCall, final Function1 rejectCall, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Function1 function1;
        Modifier modifier3;
        y.i(call, "call");
        y.i(acceptCall, "acceptCall");
        y.i(rejectCall, "rejectCall");
        Composer composerStartRestartGroup = composer.startRestartGroup(1854751978);
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
        if (composerStartRestartGroup.shouldExecute((i12 & 1171) != 1170, i12 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1854751978, i12, -1, "cu.todus.android.uiCompose.call.screen.call.components.BigCallItem (BigCallItem.kt:33)");
            }
            Modifier modifierM1726paddingVpY3zN4 = PaddingKt.m1726paddingVpY3zN4(modifier4, Dp.m8823constructorimpl(20), Dp.m8823constructorimpl(2));
            Other other = Other.INSTANCE;
            float f10 = 15;
            Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(modifierM1726paddingVpY3zN4, Color.m5865copywmQWz5c$default(other.m10111getGreen0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            float fM8823constructorimpl = Dp.m8823constructorimpl(1);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i14 = MaterialTheme.$stable;
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(modifierM1204backgroundbw27NRU, fM8823constructorimpl, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnBackground(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10)));
            float f11 = 5;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(modifierM1216borderxT4_qwU, Dp.m8823constructorimpl(f11));
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            int i15 = i12;
            modifier3 = modifier4;
            boolean z10 = true;
            Z17LabelKt.m10262Z17LabelfWhpE4E(PaddingKt.m1727paddingVpY3zN4$default(companion3, Dp.m8823constructorimpl(f11), 0.0f, 2, null), StringResources_androidKt.stringResource(R.string.call_from, composerStartRestartGroup, 0), materialTheme.getTypography(composerStartRestartGroup, i14).getBodyMedium(), 0L, 0, 0, composerStartRestartGroup, 6, 56);
            Z17PictureAvatarKt.m10277Z17PictureAvatarajT4Zlk(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(10)), Dp.m8823constructorimpl(100)), call.getPartner().getPicture(), null, null, "imagen de " + call.getPartner().getName(), 0, null, false, null, call.getPartner().getName(), true, 0, composerStartRestartGroup, 6, 6, 2540);
            Z17LabelKt.m10262Z17LabelfWhpE4E(x.a(columnScopeInstance, companion3, 1.0f, false, 2, null), call.getPartner().getName(), TextStyle.m8271copyp1EtxEg$default(materialTheme.getTypography(composerStartRestartGroup, i14).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), 0L, 1, 0, composerStartRestartGroup, 24576, 40);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composerStartRestartGroup, 48);
            int iA2 = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            a constructor2 = companion2.getConstructor();
            if (!r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl2 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i16 = i15 & 112;
            boolean z11 = (i16 == 32 || ((i15 & 64) != 0 && composerStartRestartGroup.changedInstance(call))) | ((i15 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: i7.a
                    @Override // lb.a
                    public final Object invoke() {
                        return BigCallItemKt.BigCallItem$lambda$0$0$0$0(rejectCall, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            a aVar = (a) objRememberedValue;
            float f12 = 3;
            Modifier modifierA = e3.a(rowScopeInstance, PaddingKt.m1726paddingVpY3zN4(companion3, Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f11)), 0.5f, false, 2, null);
            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
            long jM10118getRed0d7_KjU = other.m10118getRed0d7_KjU();
            int i17 = ButtonDefaults.$stable;
            ButtonColors buttonColorsM2902buttonColorsro_MJ88 = buttonDefaults.m2902buttonColorsro_MJ88(jM10118getRed0d7_KjU, 0L, 0L, 0L, composerStartRestartGroup, i17 << 12, 14);
            ComposableSingletons$BigCallItemKt composableSingletons$BigCallItemKt = ComposableSingletons$BigCallItemKt.INSTANCE;
            Z17ButtonsKt.Z17BaseDialogButton(aVar, modifierA, false, null, buttonColorsM2902buttonColorsro_MJ88, null, null, null, null, composableSingletons$BigCallItemKt.getLambda$117701665$app_productionPFast(), composerStartRestartGroup, 805306368, 492);
            boolean z12 = (i15 & 896) == 256;
            if (i16 != 32 && ((i15 & 64) == 0 || !composerStartRestartGroup.changedInstance(call))) {
                z10 = false;
            }
            boolean z13 = z12 | z10;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                function1 = acceptCall;
                objRememberedValue2 = new a() { // from class: i7.b
                    @Override // lb.a
                    public final Object invoke() {
                        return BigCallItemKt.BigCallItem$lambda$0$0$1$0(function1, call);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function1 = acceptCall;
            }
            Z17ButtonsKt.Z17BaseDialogButton((a) objRememberedValue2, e3.a(rowScopeInstance, PaddingKt.m1726paddingVpY3zN4(companion3, Dp.m8823constructorimpl(f12), Dp.m8823constructorimpl(f11)), 0.5f, false, 2, null), false, null, buttonDefaults.m2902buttonColorsro_MJ88(other.m10111getGreen0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, i17 << 12, 14), null, null, null, null, composableSingletons$BigCallItemKt.m9810getLambda$2088015414$app_productionPFast(), composerStartRestartGroup, 805306368, 492);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function1 = acceptCall;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function2 = function1;
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: i7.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BigCallItemKt.BigCallItem$lambda$1(modifier5, call, function2, rejectCall, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigCallItem$lambda$0$0$0$0(Function1 function1, CallState callState) {
        function1.invoke(callState.getWith());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigCallItem$lambda$0$0$1$0(Function1 function1, CallState callState) {
        function1.invoke(callState.getWith());
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 BigCallItem$lambda$1(Modifier modifier, CallState callState, Function1 function1, Function1 function2, int i10, int i11, Composer composer, int i12) {
        BigCallItem(modifier, callState, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
