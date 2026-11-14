package cu.z17.views.imageEditor.sections.filter;

import ab.j;
import android.graphics.Bitmap;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import cu.z17.views.picture.Z17PictureKt;
import defpackage.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.k;
import pe.m0;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroid/graphics/Bitmap;", "bitmap", "", "filteredBitmaps", "", "filterSelected", "Lkotlin/Function1;", "Lua/k0;", "onSelected", "FilterTopBar", "(Landroidx/compose/ui/Modifier;Landroid/graphics/Bitmap;Ljava/util/List;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilterTopBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void FilterTopBar(Modifier modifier, final Bitmap bitmap, final List<Bitmap> filteredBitmaps, int i10, final Function1 onSelected, Composer composer, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        int i14;
        final Modifier modifier3;
        y.i(bitmap, "bitmap");
        y.i(filteredBitmaps, "filteredBitmaps");
        y.i(onSelected, "onSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1674729478);
        int i15 = i12 & 1;
        if (i15 != 0) {
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
            i13 |= composerStartRestartGroup.changedInstance(bitmap) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(filteredBitmaps) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 2048 : 1024;
        }
        if ((i11 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onSelected) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 9363) != 9362, i13 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1674729478, i13, -1, "cu.z17.views.imageEditor.sections.filter.FilterTopBar (FilterTopBar.kt:28)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(j.f643c, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final m0 m0Var = (m0) objRememberedValue;
            Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(modifier4, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            int i16 = 57344 & i13;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(m0Var) | (i16 == 16384);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.filter.g
                    @Override // lb.a
                    public final Object invoke() {
                        return FilterTopBarKt.FilterTopBar$lambda$5$lambda$1$lambda$0(m0Var, onSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierM1238clickableXHw0xAI$default = ClickableKt.m1238clickableXHw0xAI$default(companion3, false, null, null, (lb.a) objRememberedValue2, 7, null);
            float fM8823constructorimpl = i10 == 0 ? Dp.m8823constructorimpl(2) : Dp.m8823constructorimpl(0);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i17 = MaterialTheme.$stable;
            float f10 = 15;
            float f11 = 5;
            float f12 = 70;
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(modifierM1238clickableXHw0xAI$default, fM8823constructorimpl, materialTheme.getColorScheme(composerStartRestartGroup, i17).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(f11)), Dp.m8823constructorimpl(f12)), bitmap, Color.m5856boximpl(materialTheme.getColorScheme(composerStartRestartGroup, i17).getBackground()), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, (i13 & 112) | 24576, 488);
            composerStartRestartGroup.startReplaceGroup(-1673597431);
            final int i18 = 0;
            for (Object obj : filteredBitmaps) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    w.x();
                }
                Bitmap bitmap2 = (Bitmap) obj;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(m0Var) | (i16 == 16384) | composerStartRestartGroup.changed(i18);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.imageEditor.sections.filter.h
                        @Override // lb.a
                        public final Object invoke() {
                            return FilterTopBarKt.FilterTopBar$lambda$5$lambda$4$lambda$3$lambda$2(m0Var, onSelected, i18);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierM1238clickableXHw0xAI$default2 = ClickableKt.m1238clickableXHw0xAI$default(companion4, false, null, null, (lb.a) objRememberedValue3, 7, null);
                float fM8823constructorimpl2 = i19 == i10 ? Dp.m8823constructorimpl(2) : Dp.m8823constructorimpl(0);
                MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                int i20 = MaterialTheme.$stable;
                Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(BorderKt.m1216borderxT4_qwU(modifierM1238clickableXHw0xAI$default2, fM8823constructorimpl2, materialTheme2.getColorScheme(composerStartRestartGroup, i20).getPrimary(), RoundedCornerShapeKt.m2015RoundedCornerShape0680j_4(Dp.m8823constructorimpl(f10))), Dp.m8823constructorimpl(f11)), Dp.m8823constructorimpl(f12)), bitmap2, Color.m5856boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, i20).getBackground()), null, ContentScale.INSTANCE.getCrop(), null, 0, null, null, composerStartRestartGroup, 24576, 488);
                i18 = i19;
            }
            i14 = i10;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            i14 = i10;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i21 = i14;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.imageEditor.sections.filter.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FilterTopBarKt.FilterTopBar$lambda$6(modifier3, bitmap, filteredBitmaps, i21, onSelected, i11, i12, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FilterTopBar$lambda$5$lambda$1$lambda$0(m0 m0Var, Function1 function1) {
        k.d(m0Var, null, null, new FilterTopBarKt$FilterTopBar$1$1$1$1(function1, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FilterTopBar$lambda$5$lambda$4$lambda$3$lambda$2(m0 m0Var, Function1 function1, int i10) {
        k.d(m0Var, null, null, new FilterTopBarKt$FilterTopBar$1$2$1$1$1(function1, i10, null), 3, null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 FilterTopBar$lambda$6(Modifier modifier, Bitmap bitmap, List list, int i10, Function1 function1, int i11, int i12, Composer composer, int i13) {
        FilterTopBar(modifier, bitmap, list, i10, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return k0.f43947a;
    }
}
