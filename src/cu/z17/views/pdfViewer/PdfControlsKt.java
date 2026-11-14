package cu.z17.views.pdfViewer;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.z17.views.label.Z17LabelKt;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "actualPageIndex", "pageCount", "Lkotlin/Function1;", "Lua/k0;", "onPageChange", "PdfControls", "(IILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PdfControlsKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PdfControls(final int i10, final int i11, final Function1 onPageChange, Composer composer, final int i12) {
        int i13;
        final Function1 function1;
        int i14;
        char c10;
        boolean z10;
        boolean z11;
        y.i(onPageChange, "onPageChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(438890367);
        if ((i12 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(i10) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(i11) ? 32 : 16;
        }
        if ((i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onPageChange) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 147) != 146, i13 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(438890367, i13, -1, "cu.z17.views.pdfViewer.PdfControls (PdfControls.kt:30)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1725padding3ABfNKs(companion, Dp.m8823constructorimpl(20)), 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            if (i10 != 0) {
                composerStartRestartGroup.startReplaceGroup(478724895);
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                boolean z12 = ((i13 & 896) == 256) | ((i13 & 14) == 4);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.pdfViewer.d
                        @Override // lb.a
                        public final Object invoke() {
                            return PdfControlsKt.PdfControls$lambda$4$lambda$1$lambda$0(onPageChange, i10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                c10 = 65247;
                i14 = i13;
                z10 = false;
                z11 = true;
                IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1204backgroundbw27NRU, false, null, null, ComposableSingletons$PdfControlsKt.INSTANCE.m10267getLambda$1020791845$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            } else {
                i14 = i13;
                c10 = 65247;
                z10 = false;
                z11 = true;
                composerStartRestartGroup.startReplaceGroup(477298399);
            }
            composerStartRestartGroup.endReplaceGroup();
            float f10 = 10;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i15 = MaterialTheme.$stable;
            Z17LabelKt.m10262Z17LabelfWhpE4E(null, "P: " + (i10 + 1) + " / " + i11, materialTheme.getTypography(composerStartRestartGroup, i15).getLabelLarge(), 0L, 0, 0, composerStartRestartGroup, 0, 57);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            if (i10 != i11 - 1) {
                composerStartRestartGroup.startReplaceGroup(479569955);
                Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(companion, Color.m5865copywmQWz5c$default(materialTheme.getColorScheme(composerStartRestartGroup, i15).getOnBackground(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                boolean z13 = (i14 & 896) == 256 ? z11 : z10;
                if ((i14 & 14) == 4) {
                    z10 = z11;
                }
                boolean z14 = z13 | z10;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    function1 = onPageChange;
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.pdfViewer.e
                        @Override // lb.a
                        public final Object invoke() {
                            return PdfControlsKt.PdfControls$lambda$4$lambda$3$lambda$2(function1, i10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function1 = onPageChange;
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1204backgroundbw27NRU2, false, null, null, ComposableSingletons$PdfControlsKt.INSTANCE.getLambda$1385959890$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            } else {
                function1 = onPageChange;
                composerStartRestartGroup.startReplaceGroup(477298399);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function1 = onPageChange;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.pdfViewer.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfControlsKt.PdfControls$lambda$5(i10, i11, function1, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PdfControls$lambda$4$lambda$1$lambda$0(Function1 function1, int i10) {
        function1.invoke(Integer.valueOf(i10 - 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PdfControls$lambda$4$lambda$3$lambda$2(Function1 function1, int i10) {
        function1.invoke(Integer.valueOf(i10 + 1));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 PdfControls$lambda$5(int i10, int i11, Function1 function1, int i12, Composer composer, int i13) {
        PdfControls(i10, i11, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i12 | 1));
        return k0.f43947a;
    }
}
