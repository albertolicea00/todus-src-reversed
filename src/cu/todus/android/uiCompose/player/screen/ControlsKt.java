package cu.todus.android.uiCompose.player.screen;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.e3;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FullscreenExitKt;
import androidx.compose.material.icons.filled.FullscreenKt;
import androidx.compose.material.icons.outlined.PauseKt;
import androidx.compose.material.icons.outlined.PlayArrowKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.utils.DateFormatterKt;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.loader.Z17SimpleCircleLoaderKt;
import cu.z17.views.picture.Z17PictureKt;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001ag\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"", "autoPlay", "isMiniPlayer", "Lkotlin/Function1;", "Lua/k0;", "onChangeAutoPlay", "TopControl", "(ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", "isPlaying", "", "playbackState", "Lkotlin/Function0;", "onPauseToggle", "CenterControls", "(Landroidx/compose/ui/Modifier;ZILlb/a;Landroidx/compose/runtime/Composer;II)V", "", "onSeekChanged", "showFullScreen", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "onClickOptions", "onClickFullscreen", "BottomControls", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;ZZLcu/z17/views/videoPlayer/PlayerState;Llb/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ControlsKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void BottomControls(Modifier modifier, final Function1 onSeekChanged, final boolean z10, final boolean z11, PlayerState playerState, lb.a onClickOptions, Function1 onClickFullscreen, Composer composer, final int i10, final int i11) {
        Modifier modifier2;
        int i12;
        final lb.a aVar;
        final Function1 function1;
        final PlayerState playerState2;
        kotlin.jvm.internal.y.i(onSeekChanged, "onSeekChanged");
        kotlin.jvm.internal.y.i(playerState, "playerState");
        kotlin.jvm.internal.y.i(onClickOptions, "onClickOptions");
        kotlin.jvm.internal.y.i(onClickFullscreen, "onClickFullscreen");
        Composer composerStartRestartGroup = composer.startRestartGroup(-379391581);
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
            i12 |= composerStartRestartGroup.changedInstance(onSeekChanged) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i12 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i12 |= composerStartRestartGroup.changed(playerState) ? 16384 : 8192;
        }
        if ((196608 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClickOptions) ? 131072 : 65536;
        }
        if ((1572864 & i10) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(onClickFullscreen) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier3 = i13 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-379391581, i12, -1, "cu.todus.android.uiCompose.player.screen.BottomControls (Controls.kt:96)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical bottom = arrangement.getBottom();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(bottom, companion.getStart(), composerStartRestartGroup, 6);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            lb.a constructor = companion2.getConstructor();
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (z10) {
                aVar = onClickOptions;
                function1 = onClickFullscreen;
                modifier2 = modifier3;
                playerState2 = playerState;
                composerStartRestartGroup.startReplaceGroup(-1618940619);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1622282016);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
                int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                lb.a constructor2 = companion2.getConstructor();
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
                Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                float f10 = 20;
                Modifier modifierM1755height3ABfNKs = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                float bufferedPercentage = playerState.getBufferedPercentage();
                rb.b bVarB = rb.j.b(0.0f, 100.0f);
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                Color.Companion companion4 = Color.INSTANCE;
                SliderColors sliderColorsM3661colorsq0g_0yA = sliderDefaults.m3661colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, companion4.m5903getWhite0d7_KjU(), companion4.m5896getGray0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, 1769472, 6, 927);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                Composer.Companion companion5 = Composer.INSTANCE;
                if (objRememberedValue == companion5.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ControlsKt.BottomControls$lambda$0$0$0$0(((Float) obj).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposableSingletons$ControlsKt composableSingletons$ControlsKt = ComposableSingletons$ControlsKt.INSTANCE;
                SliderKt.Slider(bufferedPercentage, (Function1) objRememberedValue, modifierM1755height3ABfNKs, false, null, sliderColorsM3661colorsq0g_0yA, null, 0, composableSingletons$ControlsKt.getLambda$1121610416$app_productionPFast(), null, bVarB, composerStartRestartGroup, 100666800, 0, 720);
                Modifier modifierM1755height3ABfNKs2 = SizeKt.m1755height3ABfNKs(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10));
                float currentPosition = playerState.getCurrentPosition();
                rb.b bVarB2 = rb.j.b(0.0f, playerState.getTotalDuration());
                long jM5901getTransparent0d7_KjU = companion4.m5901getTransparent0d7_KjU();
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                Modifier modifier4 = modifier3;
                int i14 = MaterialTheme.$stable;
                int i15 = i12;
                composerStartRestartGroup = composerStartRestartGroup;
                SliderKt.Slider(currentPosition, onSeekChanged, modifierM1755height3ABfNKs2, false, null, sliderDefaults.m3661colorsq0g_0yA(0L, materialTheme.getColorScheme(composerStartRestartGroup, i14).getSurface(), 0L, materialTheme.getColorScheme(composerStartRestartGroup, i14).getOnSurface(), 0L, jM5901getTransparent0d7_KjU, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 6, 981), null, 0, composableSingletons$ControlsKt.m10074getLambda$200876903$app_productionPFast(), null, bVarB2, composerStartRestartGroup, (i12 & 112) | 100663680, 0, 728);
                composerStartRestartGroup.endNode();
                Modifier modifierM1727paddingVpY3zN4$default = PaddingKt.m1727paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), Dp.m8823constructorimpl(f10), 0.0f, 2, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), composerStartRestartGroup, 48);
                int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1727paddingVpY3zN4$default);
                lb.a constructor3 = companion2.getConstructor();
                if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
                Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion2.getSetCompositeKeyHash());
                Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion2.getApplyOnDeactivatedNodeAssertion());
                Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
                Z17LabelKt.m10262Z17LabelfWhpE4E(e3.a(RowScopeInstance.INSTANCE, companion3, 1.0f, false, 2, null), DateFormatterKt.formatHourMinSec(playerState.getCurrentPosition()), materialTheme.getTypography(composerStartRestartGroup, i14).getBodySmall(), companion4.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 48);
                if (playerState.isLoading()) {
                    composerStartRestartGroup.startReplaceGroup(726915955);
                    Z17SimpleCircleLoaderKt.m10265Z17SimpleCircleLoaderZij2fk(SizeKt.m1769size3ABfNKs(PaddingKt.m1725padding3ABfNKs(companion3, Dp.m8823constructorimpl(3)), Dp.m8823constructorimpl(10)), 0.0f, 0.0f, companion4.m5903getWhite0d7_KjU(), composerStartRestartGroup, 3078, 6);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(727162932);
                    composerStartRestartGroup.endReplaceGroup();
                }
                boolean z12 = (i15 & 458752) == 131072;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12 || objRememberedValue2 == companion5.getEmpty()) {
                    aVar = onClickOptions;
                    objRememberedValue2 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.h
                        @Override // lb.a
                        public final Object invoke() {
                            return ControlsKt.BottomControls$lambda$0$1$0$0(aVar);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    aVar = onClickOptions;
                }
                IconButtonKt.IconButton((lb.a) objRememberedValue2, null, false, null, null, null, composableSingletons$ControlsKt.getLambda$1621741040$app_productionPFast(), composerStartRestartGroup, 1572864, 62);
                if (z11) {
                    composerStartRestartGroup.startReplaceGroup(1408945659);
                    boolean z13 = ((i15 & 3670016) == 1048576) | ((i15 & 57344) == 16384);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue3 == companion5.getEmpty()) {
                        playerState2 = playerState;
                        function1 = onClickFullscreen;
                        objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.i
                            @Override // lb.a
                            public final Object invoke() {
                                return ControlsKt.BottomControls$lambda$0$1$1$0(function1, playerState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        playerState2 = playerState;
                        function1 = onClickFullscreen;
                    }
                    IconButtonKt.IconButton((lb.a) objRememberedValue3, null, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(1121046238, true, new Function2() { // from class: cu.todus.android.uiCompose.player.screen.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ControlsKt.BottomControls$lambda$0$1$2(playerState2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 62);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    playerState2 = playerState;
                    function1 = onClickFullscreen;
                    composerStartRestartGroup.startReplaceGroup(728146996);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Z17LabelKt.m10262Z17LabelfWhpE4E(null, DateFormatterKt.formatHourMinSec(playerState2.getTotalDuration()), materialTheme.getTypography(composerStartRestartGroup, i14).getBodySmall(), companion4.m5903getWhite0d7_KjU(), 0, 0, composerStartRestartGroup, 3072, 49);
                composerStartRestartGroup.endNode();
                modifier2 = modifier4;
                SpacerKt.Spacer(SizeKt.m1755height3ABfNKs(modifier2, Dp.m8823constructorimpl(10)), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            aVar = onClickOptions;
            function1 = onClickFullscreen;
            playerState2 = playerState;
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier5 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PlayerState playerState3 = playerState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ControlsKt.BottomControls$lambda$1(modifier5, onSeekChanged, z10, z11, playerState3, aVar, function1, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BottomControls$lambda$0$0$0$0(float f10) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BottomControls$lambda$0$1$0$0(lb.a aVar) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BottomControls$lambda$0$1$1$0(Function1 function1, PlayerState playerState) {
        function1.invoke(Boolean.valueOf(!playerState.isFullscreen()));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 BottomControls$lambda$0$1$2(PlayerState playerState, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121046238, i10, -1, "cu.todus.android.uiCompose.player.screen.BottomControls.<anonymous>.<anonymous>.<anonymous> (Controls.kt:177)");
            }
            Z17PictureKt.m10278Z17BasePictureC8z9wKI(SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(24)), !playerState.isFullscreen() ? FullscreenKt.getFullscreen(Icons.Filled.INSTANCE) : FullscreenExitKt.getFullscreenExit(Icons.Filled.INSTANCE), null, ColorFilter.Companion.m5907tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m5903getWhite0d7_KjU(), 0, 2, null), null, null, 0, null, null, composer, 3078, XMPPTCPConnection.PacketWriter.QUEUE_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 BottomControls$lambda$1(Modifier modifier, Function1 function1, boolean z10, boolean z11, PlayerState playerState, lb.a aVar, Function1 function2, int i10, int i11, Composer composer, int i12) {
        BottomControls(modifier, function1, z10, z11, playerState, aVar, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CenterControls(Modifier modifier, final boolean z10, final int i10, final lb.a onPauseToggle, Composer composer, final int i11, final int i12) {
        int i13;
        kotlin.jvm.internal.y.i(onPauseToggle, "onPauseToggle");
        Composer composerStartRestartGroup = composer.startRestartGroup(1191346724);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i11 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i11 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i13 |= composerStartRestartGroup.changed(i10) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onPauseToggle) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i13 & 1171) != 1170, i13 & 1)) {
            if (i14 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1191346724, i13, -1, "cu.todus.android.uiCompose.player.screen.CenterControls (Controls.kt:60)");
            }
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            IconButtonKt.IconButton(onPauseToggle, SizeKt.m1769size3ABfNKs(Modifier.INSTANCE, Dp.m8823constructorimpl(60)), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1584603934, true, new Function2() { // from class: cu.todus.android.uiCompose.player.screen.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ControlsKt.CenterControls$lambda$0$0(z10, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 14) | 1572912, 60);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ControlsKt.CenterControls$lambda$1(modifier2, z10, i10, onPauseToggle, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 CenterControls$lambda$0$0(boolean z10, int i10, Composer composer, int i11) {
        ImageVector playArrow;
        if (composer.shouldExecute((i11 & 3) != 2, i11 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1584603934, i11, -1, "cu.todus.android.uiCompose.player.screen.CenterControls.<anonymous>.<anonymous> (Controls.kt:65)");
            }
            if (z10) {
                playArrow = PauseKt.getPause(Icons.Outlined.INSTANCE);
            } else {
                playArrow = i10 == 4 ? PlayArrowKt.getPlayArrow(Icons.Outlined.INSTANCE) : PlayArrowKt.getPlayArrow(Icons.Outlined.INSTANCE);
            }
            IconKt.m3298Iconww6aTOc(playArrow, "Play/Pause", (Modifier) null, Color.INSTANCE.m5903getWhite0d7_KjU(), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 CenterControls$lambda$1(Modifier modifier, boolean z10, int i10, lb.a aVar, int i11, int i12, Composer composer, int i13) {
        CenterControls(modifier, z10, i10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i11 | 1), i12);
        return ua.k0.f43947a;
    }

    @Composable
    public static final void TopControl(final boolean z10, final boolean z11, final Function1 onChangeAutoPlay, Composer composer, final int i10) {
        kotlin.jvm.internal.y.i(onChangeAutoPlay, "onChangeAutoPlay");
        Composer composerStartRestartGroup = composer.startRestartGroup(-253528746);
        int i11 = i10 & 1;
        if (composerStartRestartGroup.shouldExecute(i11 != 0, i11)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-253528746, i10, -1, "cu.todus.android.uiCompose.player.screen.TopControl (Controls.kt:41)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ControlsKt.TopControl$lambda$0(z10, z11, onChangeAutoPlay, i10, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 TopControl$lambda$0(boolean z10, boolean z11, Function1 function1, int i10, Composer composer, int i11) {
        TopControl(z10, z11, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
        return ua.k0.f43947a;
    }
}
