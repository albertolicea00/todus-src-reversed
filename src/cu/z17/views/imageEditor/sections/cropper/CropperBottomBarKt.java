package cu.z17.views.imageEditor.sections.cropper;

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
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.imageEditor.sections.cropper.CropperBottomBarKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "onOk", "onCancel", "CropperBottomBar", "(Llb/a;Llb/a;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CropperBottomBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CropperBottomBar(final a onOk, final a onCancel, Composer composer, final int i10) {
        int i11;
        y.i(onOk, "onOk");
        y.i(onCancel, "onCancel");
        Composer composerStartRestartGroup = composer.startRestartGroup(203846565);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changedInstance(onOk) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(onCancel) ? 32 : 16;
        }
        int i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i12 & 19) != 18, i12 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(203846565, i12, -1, "cu.z17.views.imageEditor.sections.cropper.CropperBottomBar (CropperBottomBar.kt:27)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i13 = MaterialTheme.$stable;
            Modifier modifierM1729paddingqDBjuR0$default = PaddingKt.m1729paddingqDBjuR0$default(PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m1205backgroundbw27NRU$default(companion, materialTheme.getColorScheme(composerStartRestartGroup, i13).getBackground(), null, 2, null), 0.0f, 1, null), Dp.m8823constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m8823constructorimpl(30), 7, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1729paddingqDBjuR0$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM5176constructorimpl.getInserting() || !y.d(composerM5176constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5176constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5176constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f10 = 1;
            Modifier modifierM1216borderxT4_qwU = BorderKt.m1216borderxT4_qwU(companion, Dp.m8823constructorimpl(f10), materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), RoundedCornerShapeKt.getCircleShape());
            boolean z10 = (i12 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a() { // from class: f9.c
                    @Override // lb.a
                    public final Object invoke() {
                        return CropperBottomBarKt.CropperBottomBar$lambda$4$lambda$1$lambda$0(onCancel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposableSingletons$CropperBottomBarKt composableSingletons$CropperBottomBarKt = ComposableSingletons$CropperBottomBarKt.INSTANCE;
            IconButtonKt.IconButton((a) objRememberedValue, modifierM1216borderxT4_qwU, false, null, null, composableSingletons$CropperBottomBarKt.getLambda$1486693380$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 6);
            Modifier modifierM1216borderxT4_qwU2 = BorderKt.m1216borderxT4_qwU(companion, Dp.m8823constructorimpl(f10), materialTheme.getColorScheme(composerStartRestartGroup, i13).getOnBackground(), RoundedCornerShapeKt.getCircleShape());
            boolean z11 = (i12 & 14) == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a() { // from class: f9.d
                    @Override // lb.a
                    public final Object invoke() {
                        return CropperBottomBarKt.CropperBottomBar$lambda$4$lambda$3$lambda$2(onOk);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            IconButtonKt.IconButton((a) objRememberedValue2, modifierM1216borderxT4_qwU2, false, null, null, composableSingletons$CropperBottomBarKt.m10148getLambda$173808531$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: f9.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CropperBottomBarKt.CropperBottomBar$lambda$5(onOk, onCancel, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropperBottomBar$lambda$4$lambda$1$lambda$0(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropperBottomBar$lambda$4$lambda$3$lambda$2(a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 CropperBottomBar$lambda$5(a aVar, a aVar2, int i10, Composer composer, int i11) {
        CropperBottomBar(aVar, aVar2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return k0.f43947a;
    }
}
