package cu.todus.android.uiCompose.main.screen.rooms.selectType;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
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
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.todus.android.uiCompose.main.screen.rooms.selectType.SelectTypeKt;
import cu.todus.android.uiCompose.theme.Other;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "selected", "Lkotlin/Function1;", "Lua/k0;", "onSelected", "SelectType", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SelectTypeKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectType(Modifier modifier, final int i10, final Function1 function1, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        Composer composer2;
        final Modifier modifier3;
        final Function1 onSelected = function1;
        y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1618624930);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
            modifier2 = modifier;
        } else if ((i11 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i11;
        } else {
            modifier2 = modifier;
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onSelected) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            Modifier modifier4 = i14 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1618624930, i13, -1, "cu.todus.android.uiCompose.main.screen.rooms.selectType.SelectType (SelectType.kt:25)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Modifier modifier5 = modifier4;
            Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            int iA = l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            a constructor = companion.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f10 = 16;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            boolean z10 = i10 == -1;
            FilterChipDefaults filterChipDefaults = FilterChipDefaults.INSTANCE;
            Other other = Other.INSTANCE;
            long jM5865copywmQWz5c$default = Color.m5865copywmQWz5c$default(other.m10112getGrey0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
            long onBackground = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            long jM5865copywmQWz5c$default2 = Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getSecondary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
            long onBackground2 = materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground();
            int i16 = FilterChipDefaults.$stable;
            SelectableChipColors selectableChipColorsM3237filterChipColorsXqyqHi0 = filterChipDefaults.m3237filterChipColorsXqyqHi0(jM5865copywmQWz5c$default, onBackground, 0L, 0L, 0L, 0L, 0L, jM5865copywmQWz5c$default2, 0L, onBackground2, 0L, 0L, composerStartRestartGroup, 0, i16 << 6, 3452);
            CornerBasedShape large = materialTheme.getShapes(composerStartRestartGroup, i15).getLarge();
            float f11 = 4;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11));
            int i17 = i13 & 896;
            boolean z11 = i17 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: d8.f
                    @Override // lb.a
                    public final Object invoke() {
                        return SelectTypeKt.SelectType$lambda$0$0$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$SelectTypeKt composableSingletons$SelectTypeKt = ComposableSingletons$SelectTypeKt.INSTANCE;
            ChipKt.FilterChip(z10, (a) objRememberedValue, composableSingletons$SelectTypeKt.m9974getLambda$410127495$app_productionPFast(), modifierM1725padding3ABfNKs, false, null, null, large, selectableChipColorsM3237filterChipColorsXqyqHi0, null, null, null, composerStartRestartGroup, 3456, 0, 3696);
            boolean z12 = i10 == 0;
            SelectableChipColors selectableChipColorsM3237filterChipColorsXqyqHi1 = filterChipDefaults.m3237filterChipColorsXqyqHi0(Color.m5865copywmQWz5c$default(other.m10112getGrey0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, 0L, 0L, 0L, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getSecondary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, composerStartRestartGroup, 0, i16 << 6, 3452);
            CornerBasedShape large2 = materialTheme.getShapes(composerStartRestartGroup, i15).getLarge();
            Modifier modifierM1725padding3ABfNKs2 = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11));
            boolean z13 = i17 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z13 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a() { // from class: d8.g
                    @Override // lb.a
                    public final Object invoke() {
                        return SelectTypeKt.SelectType$lambda$0$1$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ChipKt.FilterChip(z12, (a) objRememberedValue2, composableSingletons$SelectTypeKt.getLambda$602386224$app_productionPFast(), modifierM1725padding3ABfNKs2, false, null, null, large2, selectableChipColorsM3237filterChipColorsXqyqHi1, null, null, null, composerStartRestartGroup, 3456, 0, 3696);
            boolean z14 = i10 == 1;
            SelectableChipColors selectableChipColorsM3237filterChipColorsXqyqHi2 = filterChipDefaults.m3237filterChipColorsXqyqHi0(Color.m5865copywmQWz5c$default(other.m10112getGrey0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, 0L, 0L, 0L, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getSecondary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, composerStartRestartGroup, 0, i16 << 6, 3452);
            CornerBasedShape large3 = materialTheme.getShapes(composerStartRestartGroup, i15).getLarge();
            Modifier modifierM1725padding3ABfNKs3 = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11));
            boolean z15 = i17 == 256;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z15 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new a() { // from class: d8.h
                    @Override // lb.a
                    public final Object invoke() {
                        return SelectTypeKt.SelectType$lambda$0$2$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ChipKt.FilterChip(z14, (a) objRememberedValue3, composableSingletons$SelectTypeKt.m9973getLambda$1500067279$app_productionPFast(), modifierM1725padding3ABfNKs3, false, null, null, large3, selectableChipColorsM3237filterChipColorsXqyqHi2, null, null, null, composerStartRestartGroup, 3456, 0, 3696);
            boolean z16 = i10 == 2;
            SelectableChipColors selectableChipColorsM3237filterChipColorsXqyqHi3 = filterChipDefaults.m3237filterChipColorsXqyqHi0(Color.m5865copywmQWz5c$default(other.m10112getGrey0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, 0L, 0L, 0L, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getSecondary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, composerStartRestartGroup, 0, i16 << 6, 3452);
            CornerBasedShape large4 = materialTheme.getShapes(composerStartRestartGroup, i15).getLarge();
            Modifier modifierM1725padding3ABfNKs4 = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11));
            boolean z17 = i17 == 256;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z17 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new a() { // from class: d8.i
                    @Override // lb.a
                    public final Object invoke() {
                        return SelectTypeKt.SelectType$lambda$0$3$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ChipKt.FilterChip(z16, (a) objRememberedValue4, composableSingletons$SelectTypeKt.getLambda$692446514$app_productionPFast(), modifierM1725padding3ABfNKs4, false, null, null, large4, selectableChipColorsM3237filterChipColorsXqyqHi3, null, null, null, composerStartRestartGroup, 3456, 0, 3696);
            boolean z18 = i10 == 3;
            SelectableChipColors selectableChipColorsM3237filterChipColorsXqyqHi4 = filterChipDefaults.m3237filterChipColorsXqyqHi0(Color.m5865copywmQWz5c$default(other.m10112getGrey0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, 0L, 0L, 0L, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getSecondary(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0L, 0L, composerStartRestartGroup, 0, i16 << 6, 3452);
            CornerBasedShape large5 = materialTheme.getShapes(composerStartRestartGroup, i15).getLarge();
            Modifier modifierM1725padding3ABfNKs5 = PaddingKt.m1725padding3ABfNKs(companion2, Dp.m8823constructorimpl(f11));
            boolean z19 = i17 == 256;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z19 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                onSelected = function1;
                objRememberedValue5 = new a() { // from class: d8.j
                    @Override // lb.a
                    public final Object invoke() {
                        return SelectTypeKt.SelectType$lambda$0$4$0(onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                onSelected = function1;
            }
            ChipKt.FilterChip(z18, (a) objRememberedValue5, composableSingletons$SelectTypeKt.m9972getLambda$1410006989$app_productionPFast(), modifierM1725padding3ABfNKs5, false, null, null, large5, selectableChipColorsM3237filterChipColorsXqyqHi4, null, null, null, composerStartRestartGroup, 3456, 0, 3696);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(f10)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: d8.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectTypeKt.SelectType$lambda$1(modifier3, i10, onSelected, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$0$0$0(Function1 function1) {
        function1.invoke(-1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$0$1$0(Function1 function1) {
        function1.invoke(0);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$0$2$0(Function1 function1) {
        function1.invoke(1);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$0$3$0(Function1 function1) {
        function1.invoke(2);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$0$4$0(Function1 function1) {
        function1.invoke(3);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 SelectType$lambda$1(Modifier modifier, int i10, Function1 function1, int i11, int i12, Composer composer, int i13) {
        SelectType(modifier, i10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
