package cu.z17.views.videoEditor.sections.cutter;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "Lua/k0;", "onOk", "onCancel", "CutterBottomBar", "(Landroidx/compose/ui/Modifier;Llb/a;Llb/a;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CutterBottomBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CutterBottomBar(Modifier modifier, final lb.a onOk, final lb.a onCancel, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        y.i(onOk, "onOk");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(1551199678);
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
            i12 |= composerStartRestartGroup.changedInstance(onOk) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onCancel) ? 256 : 128;
        }
        int i14 = i12;
        if (composerStartRestartGroup.shouldExecute((i14 & 147) != 146, i14 & 1)) {
            Modifier modifier4 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1551199678, i14, -1, "cu.z17.views.videoEditor.sections.cutter.CutterBottomBar (CutterBottomBar.kt:28)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m1205backgroundbw27NRU$default(modifier4, materialTheme.getColorScheme(composerStartRestartGroup, i15).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(30), 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            lb.a constructor = companion.getConstructor();
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
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f10 = 1;
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(companion2, Dp.m8823constructorimpl(f10), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), RoundedCornerShapeKt.getCircleShape());
            boolean z10 = (i14 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new lb.a() { // from class: cu.z17.views.videoEditor.sections.cutter.d
                    @Override // lb.a
                    public final Object invoke() {
                        return CutterBottomBarKt.CutterBottomBar$lambda$4$lambda$1$lambda$0(onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$CutterBottomBarKt composableSingletons$CutterBottomBarKt = ComposableSingletons$CutterBottomBarKt.INSTANCE;
            IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1216borderxT4_qwU, false, null, null, composableSingletons$CutterBottomBarKt.m10312getLambda$493348131$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion2, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(companion2, Dp.m8823constructorimpl(f10), materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), RoundedCornerShapeKt.getCircleShape());
            boolean z11 = (i14 & 112) == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new lb.a() { // from class: cu.z17.views.videoEditor.sections.cutter.e
                    @Override // lb.a
                    public final Object invoke() {
                        return CutterBottomBarKt.CutterBottomBar$lambda$4$lambda$3$lambda$2(onOk);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1216borderxT4_qwU2, false, null, null, composableSingletons$CutterBottomBarKt.m10311getLambda$2114115450$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.cutter.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CutterBottomBarKt.CutterBottomBar$lambda$5(modifier3, onOk, onCancel, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CutterBottomBar$lambda$4$lambda$1$lambda$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CutterBottomBar$lambda$4$lambda$3$lambda$2(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CutterBottomBar$lambda$5(Modifier modifier, lb.a aVar, lb.a aVar2, int i10, int i11, Composer composer, int i12) {
        CutterBottomBar(modifier, aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
