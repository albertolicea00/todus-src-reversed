package cu.z17.views.videoEditor.sections.viewer;

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
import cu.z17.views.imageEditor.Z17EditorState;
import cu.z17.views.videoEditor.VideoEditorConfigurations;
import defpackage.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "canCancel", "Lkotlin/Function1;", "Lcu/z17/views/imageEditor/Z17EditorState;", "Lua/k0;", "requestState", "Lkotlin/Function0;", "requestCancel", "Lcu/z17/views/videoEditor/VideoEditorConfigurations;", "configs", "ViewerTopBar", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Llb/a;Lcu/z17/views/videoEditor/VideoEditorConfigurations;Landroidx/compose/runtime/Composer;II)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewerTopBarKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ViewerTopBar(Modifier modifier, final boolean z10, final Function1 requestState, final lb.a requestCancel, final VideoEditorConfigurations configs, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final Modifier modifier3;
        int i13;
        boolean z11;
        boolean z12;
        Modifier.Companion companion;
        int i14;
        y.i(requestState, "requestState");
        y.i(requestCancel, "requestCancel");
        y.i(configs, "configs");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1561517551);
        int i15 = i11 & 1;
        if (i15 != 0) {
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
            i12 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(requestState) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(requestCancel) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(configs) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i12 & 9363) != 9362, i12 & 1)) {
            modifier3 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1561517551, i12, -1, "cu.z17.views.videoEditor.sections.viewer.ViewerTopBar (ViewerTopBar.kt:33)");
            }
            float f10 = 10;
            Modifier modifierM1725padding3ABfNKs = PaddingKt.m1725padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1725padding3ABfNKs);
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
            if (z10) {
                composerStartRestartGroup.startReplaceGroup(-212526915);
                Modifier modifierM1204backgroundbw27NRU = BackgroundKt.m1204backgroundbw27NRU(Modifier.INSTANCE, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                boolean z13 = (i12 & 7168) == 2048;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z13 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.h
                        @Override // lb.a
                        public final Object invoke() {
                            return ViewerTopBarKt.ViewerTopBar$lambda$6$lambda$1$lambda$0(requestCancel);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                i13 = i12;
                z11 = false;
                z12 = true;
                IconButtonKt.IconButton((lb.a) objRememberedValue, modifierM1204backgroundbw27NRU, false, null, null, ComposableSingletons$ViewerTopBarKt.INSTANCE.getLambda$2030274869$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            } else {
                i13 = i12;
                z11 = false;
                z12 = true;
                composerStartRestartGroup.startReplaceGroup(-214100971);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion3, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            if (configs.getAllowCrop()) {
                composerStartRestartGroup.startReplaceGroup(-211836731);
                Modifier modifierM1204backgroundbw27NRU2 = BackgroundKt.m1204backgroundbw27NRU(companion3, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                int i16 = i13;
                boolean z14 = (i16 & 896) == 256 ? z12 : z11;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.i
                        @Override // lb.a
                        public final Object invoke() {
                            return ViewerTopBarKt.ViewerTopBar$lambda$6$lambda$3$lambda$2(requestState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                companion = companion3;
                i14 = i16;
                IconButtonKt.IconButton((lb.a) objRememberedValue2, modifierM1204backgroundbw27NRU2, false, null, null, ComposableSingletons$ViewerTopBarKt.INSTANCE.getLambda$1314349598$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            } else {
                companion = companion3;
                i14 = i13;
                composerStartRestartGroup.startReplaceGroup(-214100971);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier.Companion companion4 = companion;
            SpacerKt.Spacer(SizeKt.m1774width3ABfNKs(companion4, Dp.m8823constructorimpl(f10)), composerStartRestartGroup, 6);
            if (configs.getAllowFilters()) {
                composerStartRestartGroup.startReplaceGroup(-211120693);
                Modifier modifierM1204backgroundbw27NRU3 = BackgroundKt.m1204backgroundbw27NRU(companion4, Color.m5865copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                boolean z15 = (i14 & 896) == 256 ? z12 : z11;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z15 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new lb.a() { // from class: cu.z17.views.videoEditor.sections.viewer.j
                        @Override // lb.a
                        public final Object invoke() {
                            return ViewerTopBarKt.ViewerTopBar$lambda$6$lambda$5$lambda$4(requestState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue3, modifierM1204backgroundbw27NRU3, false, null, null, ComposableSingletons$ViewerTopBarKt.INSTANCE.m10313getLambda$1798384963$views_release(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            } else {
                composerStartRestartGroup.startReplaceGroup(-214100971);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.z17.views.videoEditor.sections.viewer.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ViewerTopBarKt.ViewerTopBar$lambda$7(modifier3, z10, requestState, requestCancel, configs, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$6$lambda$1$lambda$0(lb.a aVar) {
        aVar.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$6$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(Z17EditorState.CROP);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$6$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(Z17EditorState.FILTER);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 ViewerTopBar$lambda$7(Modifier modifier, boolean z10, Function1 function1, lb.a aVar, VideoEditorConfigurations videoEditorConfigurations, int i10, int i11, Composer composer, int i12) {
        ViewerTopBar(modifier, z10, function1, aVar, videoEditorConfigurations, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return k0.f43947a;
    }
}
