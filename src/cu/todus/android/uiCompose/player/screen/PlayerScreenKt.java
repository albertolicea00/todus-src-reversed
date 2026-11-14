package cu.todus.android.uiCompose.player.screen;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.CountDownTimer;
import androidx.annotation.OptIn;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.media3.common.C;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.NavHostController;
import androidx.p001lifecycle.HasDefaultViewModelProviderFactory;
import androidx.p001lifecycle.ViewModelProvider;
import androidx.p001lifecycle.ViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.CreationExtras;
import androidx.p001lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.p001lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import cu.todus.android.R;
import cu.todus.android.uiCompose.player.PlayerParams;
import cu.z17.views.label.Z17LabelKt;
import cu.z17.views.videoPlayer.PlayerState;
import cu.z17.views.videoPlayer.RepeatMode;
import cu.z17.views.videoPlayer.Z17HLSVideoPlayerKt;
import cu.z17.views.videoPlayer.Z17VideoPlayerKt;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.uri.HLSMediaItem;
import cu.z17.views.videoPlayer.uri.VideoPlayerMediaItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a«\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!²\u0006\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010 \u001a\u00020\r8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navHostController", "Lcu/todus/android/uiCompose/player/PlayerParams;", "playerParams", "Lcu/todus/android/uiCompose/player/screen/PlayerViewModel;", "viewModel", "Lua/k0;", "PlayerScreen", "(Landroidx/navigation/NavHostController;Lcu/todus/android/uiCompose/player/PlayerParams;Lcu/todus/android/uiCompose/player/screen/PlayerViewModel;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "", "autoPlay", "isMiniPlayer", "showFullScreen", "Lkotlin/Function0;", "onPauseToggle", "Lkotlin/Function1;", "onClickFullscreen", "", "onSeekChanged", "Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "onSelectedVideoTrack", "onSelectedAudioTrack", "onSelectedSubsTrack", "PlayerControls", "(Landroidx/compose/ui/Modifier;Lcu/z17/views/videoPlayer/PlayerState;ZZZLlb/a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Landroidx/media3/common/Player;", "player", "isVisible", "showPopup", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PlayerScreenKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PlayerControls(Modifier modifier, final PlayerState playerState, final boolean z10, final boolean z11, final boolean z12, final lb.a onPauseToggle, final Function1 onClickFullscreen, final Function1 onSeekChanged, final Function1 onSelectedVideoTrack, final Function1 onSelectedAudioTrack, final Function1 onSelectedSubsTrack, Composer composer, final int i10, final int i11, final int i12) {
        Modifier modifier2;
        int i13;
        boolean z13;
        boolean z14;
        int i14;
        Composer composer2;
        final Modifier modifier3;
        kotlin.jvm.internal.y.i(playerState, "playerState");
        kotlin.jvm.internal.y.i(onPauseToggle, "onPauseToggle");
        kotlin.jvm.internal.y.i(onClickFullscreen, "onClickFullscreen");
        kotlin.jvm.internal.y.i(onSeekChanged, "onSeekChanged");
        kotlin.jvm.internal.y.i(onSelectedVideoTrack, "onSelectedVideoTrack");
        kotlin.jvm.internal.y.i(onSelectedAudioTrack, "onSelectedAudioTrack");
        kotlin.jvm.internal.y.i(onSelectedSubsTrack, "onSelectedSubsTrack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1626908385);
        int i15 = i12 & 1;
        if (i15 != 0) {
            i13 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 6) == 0) {
            modifier2 = modifier;
            i13 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i13 = i10;
        }
        if ((i10 & 48) == 0) {
            i13 |= composerStartRestartGroup.changed(playerState) ? 32 : 16;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            z13 = z10;
            i13 |= composerStartRestartGroup.changed(z13) ? 256 : 128;
        } else {
            z13 = z10;
        }
        if ((i10 & 3072) == 0) {
            z14 = z11;
            i13 |= composerStartRestartGroup.changed(z14) ? 2048 : 1024;
        } else {
            z14 = z11;
        }
        if ((i10 & 24576) == 0) {
            i13 |= composerStartRestartGroup.changed(z12) ? 16384 : 8192;
        }
        if ((i10 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onPauseToggle) ? 131072 : 65536;
        }
        if ((i10 & 1572864) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onClickFullscreen) ? 1048576 : 524288;
        }
        if ((i10 & 12582912) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onSeekChanged) ? 8388608 : 4194304;
        }
        if ((i10 & 100663296) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onSelectedVideoTrack) ? 67108864 : 33554432;
        }
        if ((i10 & 805306368) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onSelectedAudioTrack) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i11 & 6) == 0) {
            i14 = i11 | (composerStartRestartGroup.changedInstance(onSelectedSubsTrack) ? 4 : 2);
        } else {
            i14 = i11;
        }
        if (composerStartRestartGroup.shouldExecute(((i13 & 306783379) == 306783378 && (i14 & 3) == 2) ? false : true, i13 & 1)) {
            Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1626908385, i13, i14, "cu.todus.android.uiCompose.player.screen.PlayerControls (PlayerScreen.kt:203)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new CountDownTimer() { // from class: cu.todus.android.uiCompose.player.screen.PlayerScreenKt$PlayerControls$timer$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, 1000L);
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        PlayerScreenKt.PlayerControls$lambda$2(mutableState, false);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final PlayerScreenKt$PlayerControls$timer$1$1 playerScreenKt$PlayerControls$timer$1$1 = (PlayerScreenKt$PlayerControls$timer$1$1) objRememberedValue2;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(playerScreenKt$PlayerControls$timer$1$1);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.a0
                    @Override // lb.a
                    public final Object invoke() {
                        return PlayerScreenKt.PlayerControls$lambda$4$0(playerScreenKt$PlayerControls$timer$1$1, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM1240clickableoSLSa3U$default = ClickableKt.m1240clickableoSLSa3U$default(modifier4, false, null, null, null, (lb.a) objRememberedValue3, 15, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1240clickableoSLSa3U$default);
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
            Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion2.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl, companion2.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            final boolean z15 = z14;
            final boolean z16 = z13;
            composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(PlayerControls$lambda$1(mutableState), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-581461247, true, new Function3() { // from class: cu.todus.android.uiCompose.player.screen.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PlayerScreenKt.PlayerControls$lambda$5$0(z16, z15, playerState, onPauseToggle, onSeekChanged, z12, onClickFullscreen, onSelectedVideoTrack, onSelectedAudioTrack, onSelectedSubsTrack, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 200112, 16);
            Boolean boolValueOf = Boolean.valueOf(PlayerControls$lambda$1(mutableState));
            boolean zChangedInstance2 = composer2.changedInstance(playerScreenKt$PlayerControls$timer$1$1);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new PlayerScreenKt$PlayerControls$2$2$1(playerScreenKt$PlayerControls$timer$1$1, mutableState, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue4, composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerScreenKt.PlayerControls$lambda$6(modifier3, playerState, z10, z11, z12, onPauseToggle, onClickFullscreen, onSeekChanged, onSelectedVideoTrack, onSelectedAudioTrack, onSelectedSubsTrack, i10, i11, i12, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlayerControls$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlayerControls$lambda$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerControls$lambda$4$0(PlayerScreenKt$PlayerControls$timer$1$1 playerScreenKt$PlayerControls$timer$1$1, MutableState mutableState) {
        playerScreenKt$PlayerControls$timer$1$1.cancel();
        PlayerControls$lambda$2(mutableState, !PlayerControls$lambda$1(mutableState));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PlayerControls$lambda$5$0(boolean z10, boolean z11, final PlayerState playerState, lb.a aVar, Function1 function1, boolean z12, Function1 function2, final Function1 function3, final Function1 function4, final Function1 function5, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i10) {
        kotlin.jvm.internal.y.i(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-581461247, i10, -1, "cu.todus.android.uiCompose.player.screen.PlayerControls.<anonymous>.<anonymous> (PlayerScreen.kt:231)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierM1205backgroundbw27NRU$default = BackgroundKt.m1205backgroundbw27NRU$default(companion, Color.m5865copywmQWz5c$default(Color.INSTANCE.m5892getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1205backgroundbw27NRU$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        lb.a constructor = companion3.getConstructor();
        if (!defpackage.r.a(composer.getApplier())) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5176constructorimpl = Updater.m5176constructorimpl(composer);
        Updater.m5184setimpl(composerM5176constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m5184setimpl(composerM5176constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Updater.m5180initimpl(composerM5176constructorimpl, Integer.valueOf(iA), companion3.getSetCompositeKeyHash());
        Updater.m5182reconcileimpl(composerM5176constructorimpl, companion3.getApplyOnDeactivatedNodeAssertion());
        Updater.m5184setimpl(composerM5176constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (objRememberedValue == companion4.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion4.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlayerScreenKt.PlayerControls$lambda$5$0$0$3$0(((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ControlsKt.TopControl(z10, z11, (Function1) objRememberedValue2, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
        ControlsKt.CenterControls(SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion, companion2.getCenter()), 0.0f, 1, null), playerState.isPlaying(), playerState.getPlaybackState(), aVar, composer, 0, 0);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(boxScopeInstance.align(companion, companion2.getBottomCenter()), 0.0f, 1, null);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion4.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(PlayerScreenKt.PlayerControls$lambda$5$0$0$4$0(((Integer) obj).intValue()));
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        EnterTransition enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue3, 1, null);
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == companion4.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(PlayerScreenKt.PlayerControls$lambda$5$0$0$5$0(((Integer) obj).intValue()));
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierC = AnimatedVisibilityScope.CC.c(AnimatedVisibility, modifierFillMaxWidth$default, enterTransitionSlideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue4, 1, null), null, 4, null);
        Object objRememberedValue5 = composer.rememberedValue();
        if (objRememberedValue5 == companion4.getEmpty()) {
            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.x
                @Override // lb.a
                public final Object invoke() {
                    return PlayerScreenKt.PlayerControls$lambda$5$0$0$6$0(mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ControlsKt.BottomControls(modifierC, function1, z11, z12, playerState, (lb.a) objRememberedValue5, function2, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
        if (PlayerControls$lambda$5$0$0$1(mutableState)) {
            composer.startReplaceGroup(1664124715);
            Alignment center = companion2.getCenter();
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == companion4.getEmpty()) {
                objRememberedValue6 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.y
                    @Override // lb.a
                    public final Object invoke() {
                        return PlayerScreenKt.PlayerControls$lambda$5$0$0$7$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            AndroidPopup_androidKt.m9081PopupK5zGePQ(center, 0L, (lb.a) objRememberedValue6, null, ComposableLambdaKt.rememberComposableLambda(-417363229, true, new Function2() { // from class: cu.todus.android.uiCompose.player.screen.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlayerScreenKt.PlayerControls$lambda$5$0$0$8(playerState, function3, function4, function5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 24966, 10);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(48981287);
            composer.endReplaceGroup();
        }
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return ua.k0.f43947a;
    }

    private static final boolean PlayerControls$lambda$5$0$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PlayerControls$lambda$5$0$0$2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerControls$lambda$5$0$0$3$0(boolean z10) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerControls$lambda$5$0$0$6$0(MutableState mutableState) {
        PlayerControls$lambda$5$0$0$2(mutableState, true);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerControls$lambda$5$0$0$7$0(MutableState mutableState) {
        PlayerControls$lambda$5$0$0$2(mutableState, false);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final ua.k0 PlayerControls$lambda$5$0$0$8(PlayerState playerState, Function1 function1, Function1 function2, Function1 function3, Composer composer, int i10) {
        if (composer.shouldExecute((i10 & 3) != 2, i10 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-417363229, i10, -1, "cu.todus.android.uiCompose.player.screen.PlayerControls.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlayerScreen.kt:276)");
            }
            TracksControlSelectionKt.TrackSelectionMenu(playerState.getSelectedVideoTrack(), playerState.getSelectedAudioTrack(), playerState.getSelectedSubsTrack(), playerState.getTripleTrackSave(), function1, function2, function3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerControls$lambda$6(Modifier modifier, PlayerState playerState, boolean z10, boolean z11, boolean z12, lb.a aVar, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i10, int i11, int i12, Composer composer, int i13) {
        PlayerControls(modifier, playerState, z10, z11, z12, aVar, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), RecomposeScopeImplKt.updateChangedFlags(i11), i12);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:106:0x026a  */
    /* JADX WARN: Code duplicated, block: B:108:0x027d  */
    /* JADX WARN: Code duplicated, block: B:120:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:135:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:148:0x0328  */
    /* JADX WARN: Code duplicated, block: B:150:0x0382  */
    /* JADX WARN: Code duplicated, block: B:152:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:155:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:156:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:160:0x041d  */
    /* JADX WARN: Code duplicated, block: B:164:0x042c  */
    /* JADX WARN: Code duplicated, block: B:168:0x044e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0454  */
    /* JADX WARN: Code duplicated, block: B:176:0x0461  */
    /* JADX WARN: Code duplicated, block: B:180:0x046b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0479  */
    /* JADX WARN: Code duplicated, block: B:185:0x047f  */
    /* JADX WARN: Code duplicated, block: B:191:0x048c  */
    /* JADX WARN: Code duplicated, block: B:193:0x0492  */
    /* JADX WARN: Code duplicated, block: B:196:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:199:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:201:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:207:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:209:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:212:0x04da  */
    /* JADX WARN: Code duplicated, block: B:214:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:220:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:222:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:225:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:227:0x0505  */
    /* JADX WARN: Code duplicated, block: B:232:0x0510  */
    /* JADX WARN: Code duplicated, block: B:234:0x0516  */
    /* JADX WARN: Code duplicated, block: B:239:0x054c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:58:0x010b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x011b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01cc  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @OptIn(markerClass = {UnstableApi.class})
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void PlayerScreen(final NavHostController navHostController, final PlayerParams playerParams, PlayerViewModel playerViewModel, Composer composer, final int i10, final int i11) {
        int i12;
        final PlayerViewModel playerViewModel2;
        int i13;
        int i14;
        Object objRememberedValue;
        Composer.Companion companion;
        MutableState mutableState;
        Modifier.Companion companion2;
        Alignment.Companion companion3;
        ComposeUiNode.Companion companion4;
        lb.a constructor;
        PlayerViewModel playerViewModel3;
        int i15;
        Modifier.Companion companion5;
        Object obj;
        float f10;
        int i16;
        MutableState mutableState2;
        PlayerViewModel playerViewModel4;
        lb.a constructor2;
        int i17;
        boolean z10;
        Object objRememberedValue2;
        boolean z11;
        Object objRememberedValue3;
        MutableState mutableState3;
        boolean z12;
        Object objRememberedValue4;
        int i18;
        int i19;
        Object objRememberedValue5;
        final MutableState mutableState4;
        int i20;
        Object objRememberedValue6;
        Object objRememberedValue7;
        int i21;
        Object objRememberedValue8;
        int i22;
        Object objRememberedValue9;
        Object objRememberedValue10;
        boolean z13;
        Object objRememberedValue11;
        boolean z14;
        Object objRememberedValue12;
        boolean z15;
        Object objRememberedValue13;
        int i23;
        PlayerViewModel playerViewModel5 = playerViewModel;
        kotlin.jvm.internal.y.i(navHostController, "navHostController");
        kotlin.jvm.internal.y.i(playerParams, "playerParams");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1601026386);
        if ((i10 & 48) == 0) {
            i12 = (composerStartRestartGroup.changed(playerParams) ? 32 : 16) | i10;
        } else {
            i12 = i10;
        }
        if ((i10 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i11 & 4) != 0) {
                i23 = 128;
            } else {
                if ((i10 & 512) == 0 ? composerStartRestartGroup.changed(playerViewModel5) : composerStartRestartGroup.changedInstance(playerViewModel5)) {
                    i23 = 256;
                } else {
                    i23 = 128;
                }
            }
            i12 |= i23;
        }
        int i24 = i12;
        if (composerStartRestartGroup.shouldExecute((i24 & 145) != 144, i24 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i11 & 4) != 0) {
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                    i24 &= -897;
                    i13 = 1;
                    playerViewModel5 = (PlayerViewModel) ViewModelKt.viewModel(z0.b(PlayerViewModel.class), current, (String) null, (ViewModelProvider.Factory) null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composerStartRestartGroup, 0, 0);
                }
                i14 = i24;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1601026386, i14, -1, "cu.todus.android.uiCompose.player.screen.PlayerScreen (PlayerScreen.kt:60)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, i13, null);
                companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int iA = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                companion4 = ComposeUiNode.INSTANCE;
                constructor = companion4.getConstructor();
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
                if (le.d0.q0(playerParams.getUrl())) {
                    playerViewModel3 = playerViewModel5;
                    i15 = i14;
                    companion5 = companion2;
                    obj = null;
                    f10 = 0.0f;
                    i16 = 1;
                    if (le.d0.q0(playerParams.getPath())) {
                        mutableState2 = mutableState;
                        playerViewModel4 = playerViewModel3;
                        composerStartRestartGroup.startReplaceGroup(1782225724);
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                        int iA2 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
                        constructor2 = companion4.getConstructor();
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
                        Updater.m5184setimpl(composerM5176constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                        Updater.m5184setimpl(composerM5176constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                        Updater.m5180initimpl(composerM5176constructorimpl2, Integer.valueOf(iA2), companion4.getSetCompositeKeyHash());
                        Updater.m5182reconcileimpl(composerM5176constructorimpl2, companion4.getApplyOnDeactivatedNodeAssertion());
                        Updater.m5184setimpl(composerM5176constructorimpl2, modifierMaterializeModifier2, companion4.getSetModifier());
                        i17 = 0;
                        Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.video_not_found, composerStartRestartGroup, 0), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1781152101);
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null);
                        Uri uri = Uri.parse(playerParams.getPath());
                        kotlin.jvm.internal.y.h(uri, "parse(...)");
                        List listE = va.v.e(new VideoPlayerMediaItem.StorageMediaItem(uri, null, null, 6, null));
                        RepeatMode repeatMode = RepeatMode.NONE;
                        PlayerState playerState = playerViewModel3.getPlayerState();
                        Pair<Integer, Integer> pipScale = playerParams.getPipScale();
                        int i25 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                        z10 = (i25 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel3)) || (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z10 || objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new PlayerScreenKt$PlayerScreen$1$4$1(playerViewModel3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) ((sb.h) objRememberedValue2);
                        z11 = (i25 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel3)) || (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11 || objRememberedValue3 == companion.getEmpty()) {
                            mutableState3 = mutableState;
                            objRememberedValue3 = new PlayerScreenKt$PlayerScreen$1$5$1(playerViewModel3, mutableState3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            mutableState3 = mutableState;
                        }
                        Function2 function2 = (Function2) ((sb.h) objRememberedValue3);
                        z12 = (i25 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel3)) || (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z12 || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new PlayerScreenKt$PlayerScreen$1$6$1(playerViewModel3);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        playerViewModel4 = playerViewModel3;
                        mutableState2 = mutableState3;
                        Z17VideoPlayerKt.Z17VideoPlayer(modifierFillMaxWidth$default, listE, true, true, true, false, null, 0L, 0L, repeatMode, 0.5f, function1, true, true, true, null, playerState, function2, (Function1) ((sb.h) objRememberedValue4), pipScale, 1, 0, composerStartRestartGroup, (VideoPlayerMediaItem.StorageMediaItem.$stable << 3) | 805531014, 28038, 6, 2130368);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if ((le.d0.q0(playerParams.getUrl()) || !le.d0.q0(playerParams.getPath())) && !playerViewModel4.getPlayerState().isPIP()) {
                        composerStartRestartGroup.startReplaceGroup(1858618324);
                        Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                        PlayerState playerState2 = playerViewModel4.getPlayerState();
                        i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                        playerViewModel2 = playerViewModel4;
                        i19 = ((i18 > 256 || !composerStartRestartGroup.changedInstance(playerViewModel2)) && (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) ? i17 : i16;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (i19 == 0 || objRememberedValue5 == companion.getEmpty()) {
                            mutableState4 = mutableState2;
                            objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                                @Override // lb.a
                                public final Object invoke() {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            mutableState4 = mutableState2;
                        }
                        lb.a aVar = (lb.a) objRememberedValue5;
                        i20 = ((i18 > 256 || !composerStartRestartGroup.changedInstance(playerViewModel2)) && (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) ? i17 : i16;
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (i20 == 0 || objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        Function1 function3 = (Function1) objRememberedValue6;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Function1 function4 = (Function1) objRememberedValue7;
                        i21 = ((i18 > 256 || !composerStartRestartGroup.changedInstance(playerViewModel2)) && (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) ? i17 : i16;
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (i21 == 0 || objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function5 = (Function1) objRememberedValue8;
                        i22 = ((i18 > 256 || !composerStartRestartGroup.changedInstance(playerViewModel2)) && (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) ? i17 : i16;
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (i22 == 0 || objRememberedValue9 == companion.getEmpty()) {
                            objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        Function1 function6 = (Function1) objRememberedValue9;
                        if ((i18 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel2)) || (i15 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) {
                        }
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (i17 == 0 || objRememberedValue10 == companion.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        Composer composer2 = composerStartRestartGroup;
                        PlayerControls(modifierFillMaxSize$default3, playerState2, true, false, true, aVar, function3, function4, function5, function6, (Function1) objRememberedValue10, composer2, 12610950, 0, 0);
                        composerStartRestartGroup = composer2;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        playerViewModel2 = playerViewModel4;
                        composerStartRestartGroup.startReplaceGroup(1784173082);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.startReplaceGroup(1780166921);
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    HLSMediaItem hLSMediaItem = new HLSMediaItem(playerParams.getUrl(), null, null, null, null, 30, null);
                    RepeatMode repeatMode2 = RepeatMode.NONE;
                    PlayerState playerState3 = playerViewModel5.getPlayerState();
                    Pair<Integer, Integer> pipScale2 = playerParams.getPipScale();
                    int i26 = (i14 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    z13 = (i26 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel5)) || (i14 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (z13 || objRememberedValue11 == companion.getEmpty()) {
                        objRememberedValue11 = new PlayerScreenKt$PlayerScreen$1$1$1(playerViewModel5);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Function1 function7 = (Function1) ((sb.h) objRememberedValue11);
                    z14 = (i26 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel5)) || (i14 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (z14 || objRememberedValue12 == companion.getEmpty()) {
                        objRememberedValue12 = new PlayerScreenKt$PlayerScreen$1$2$1(playerViewModel5, mutableState);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    Function2 function8 = (Function2) ((sb.h) objRememberedValue12);
                    z15 = (i26 <= 256 && composerStartRestartGroup.changedInstance(playerViewModel5)) || (i14 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (z15 || objRememberedValue13 == companion.getEmpty()) {
                        objRememberedValue13 = new PlayerScreenKt$PlayerScreen$1$3$1(playerViewModel5);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    companion5 = companion2;
                    f10 = 0.0f;
                    obj = null;
                    i15 = i14;
                    PlayerViewModel playerViewModel6 = playerViewModel5;
                    i16 = 1;
                    Z17HLSVideoPlayerKt.Z17HLSVideoPlayer(modifierFillMaxWidth$default2, hLSMediaItem, true, true, true, false, null, 0L, 0L, repeatMode2, 0.5f, function7, true, true, true, null, playerState3, function8, (Function1) ((sb.h) objRememberedValue13), pipScale2, 0, 0, composerStartRestartGroup, (HLSMediaItem.$stable << 3) | 805531014, 28038, 0, 3178944);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState;
                    playerViewModel4 = playerViewModel6;
                }
                i17 = 0;
                if (le.d0.q0(playerParams.getUrl())) {
                    composerStartRestartGroup.startReplaceGroup(1858618324);
                    Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                    PlayerState playerState4 = playerViewModel4.getPlayerState();
                    i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    playerViewModel2 = playerViewModel4;
                    if (i18 > 256) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (i19 == 0) {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    lb.a aVar2 = (lb.a) objRememberedValue5;
                    if (i18 > 256) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (i20 == 0) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function9 = (Function1) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function10 = (Function1) objRememberedValue7;
                    if (i18 > 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (i21 == 0) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function11 = (Function1) objRememberedValue8;
                    if (i18 > 256) {
                    }
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (i22 == 0) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function12 = (Function1) objRememberedValue9;
                    i17 = i18 <= 256 ? i16 : i16;
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (i17 == 0) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Composer composer3 = composerStartRestartGroup;
                    PlayerControls(modifierFillMaxSize$default4, playerState4, true, false, true, aVar2, function9, function10, function11, function12, (Function1) objRememberedValue10, composer3, 12610950, 0, 0);
                    composerStartRestartGroup = composer3;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1858618324);
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                    PlayerState playerState5 = playerViewModel4.getPlayerState();
                    i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    playerViewModel2 = playerViewModel4;
                    if (i18 > 256) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (i19 == 0) {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    lb.a aVar3 = (lb.a) objRememberedValue5;
                    if (i18 > 256) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (i20 == 0) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function13 = (Function1) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function14 = (Function1) objRememberedValue7;
                    if (i18 > 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (i21 == 0) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function15 = (Function1) objRememberedValue8;
                    if (i18 > 256) {
                    }
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (i22 == 0) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function16 = (Function1) objRememberedValue9;
                    if (i18 <= 256) {
                    }
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (i17 == 0) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Composer composer4 = composerStartRestartGroup;
                    PlayerControls(modifierFillMaxSize$default5, playerState5, true, false, true, aVar3, function13, function14, function15, function16, (Function1) objRememberedValue10, composer4, 12610950, 0, 0);
                    composerStartRestartGroup = composer4;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 4) != 0) {
                    i24 &= -897;
                }
            }
            i13 = 1;
            i14 = i24;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1601026386, i14, -1, "cu.todus.android.uiCompose.player.screen.PlayerScreen (PlayerScreen.kt:60)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            companion2 = Modifier.INSTANCE;
            Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(companion2, 0.0f, i13, null);
            companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int iA3 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default6);
            companion4 = ComposeUiNode.INSTANCE;
            constructor = companion4.getConstructor();
            if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5176constructorimpl3 = Updater.m5176constructorimpl(composerStartRestartGroup);
            Updater.m5184setimpl(composerM5176constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m5184setimpl(composerM5176constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Updater.m5180initimpl(composerM5176constructorimpl3, Integer.valueOf(iA3), companion4.getSetCompositeKeyHash());
            Updater.m5182reconcileimpl(composerM5176constructorimpl3, companion4.getApplyOnDeactivatedNodeAssertion());
            Updater.m5184setimpl(composerM5176constructorimpl3, modifierMaterializeModifier3, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (le.d0.q0(playerParams.getUrl())) {
                composerStartRestartGroup.startReplaceGroup(1780166921);
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                HLSMediaItem hLSMediaItem2 = new HLSMediaItem(playerParams.getUrl(), null, null, null, null, 30, null);
                RepeatMode repeatMode3 = RepeatMode.NONE;
                PlayerState playerState6 = playerViewModel5.getPlayerState();
                Pair<Integer, Integer> pipScale3 = playerParams.getPipScale();
                int i27 = (i14 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                if (i27 <= 256) {
                }
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (z13) {
                    objRememberedValue11 = new PlayerScreenKt$PlayerScreen$1$1$1(playerViewModel5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new PlayerScreenKt$PlayerScreen$1$1$1(playerViewModel5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Function1 function17 = (Function1) ((sb.h) objRememberedValue11);
                if (i27 <= 256) {
                }
                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue12 = new PlayerScreenKt$PlayerScreen$1$2$1(playerViewModel5, mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new PlayerScreenKt$PlayerScreen$1$2$1(playerViewModel5, mutableState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                Function2 function18 = (Function2) ((sb.h) objRememberedValue12);
                if (i27 <= 256) {
                }
                objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue13 = new PlayerScreenKt$PlayerScreen$1$3$1(playerViewModel5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new PlayerScreenKt$PlayerScreen$1$3$1(playerViewModel5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                }
                companion5 = companion2;
                f10 = 0.0f;
                obj = null;
                i15 = i14;
                PlayerViewModel playerViewModel7 = playerViewModel5;
                i16 = 1;
                Z17HLSVideoPlayerKt.Z17HLSVideoPlayer(modifierFillMaxWidth$default3, hLSMediaItem2, true, true, true, false, null, 0L, 0L, repeatMode3, 0.5f, function17, true, true, true, null, playerState6, function18, (Function1) ((sb.h) objRememberedValue13), pipScale3, 0, 0, composerStartRestartGroup, (HLSMediaItem.$stable << 3) | 805531014, 28038, 0, 3178944);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
                mutableState2 = mutableState;
                playerViewModel4 = playerViewModel7;
            } else {
                playerViewModel3 = playerViewModel5;
                i15 = i14;
                companion5 = companion2;
                obj = null;
                f10 = 0.0f;
                i16 = 1;
                if (le.d0.q0(playerParams.getPath())) {
                    composerStartRestartGroup.startReplaceGroup(1781152101);
                    Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null);
                    Uri uri2 = Uri.parse(playerParams.getPath());
                    kotlin.jvm.internal.y.h(uri2, "parse(...)");
                    List listE2 = va.v.e(new VideoPlayerMediaItem.StorageMediaItem(uri2, null, null, 6, null));
                    RepeatMode repeatMode4 = RepeatMode.NONE;
                    PlayerState playerState7 = playerViewModel3.getPlayerState();
                    Pair<Integer, Integer> pipScale4 = playerParams.getPipScale();
                    int i28 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    if (i28 <= 256) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z10) {
                        objRememberedValue2 = new PlayerScreenKt$PlayerScreen$1$4$1(playerViewModel3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new PlayerScreenKt$PlayerScreen$1$4$1(playerViewModel3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function19 = (Function1) ((sb.h) objRememberedValue2);
                    if (i28 <= 256) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        mutableState3 = mutableState;
                        objRememberedValue3 = new PlayerScreenKt$PlayerScreen$1$5$1(playerViewModel3, mutableState3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        mutableState3 = mutableState;
                        objRememberedValue3 = new PlayerScreenKt$PlayerScreen$1$5$1(playerViewModel3, mutableState3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function2 function20 = (Function2) ((sb.h) objRememberedValue3);
                    if (i28 <= 256) {
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        objRememberedValue4 = new PlayerScreenKt$PlayerScreen$1$6$1(playerViewModel3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new PlayerScreenKt$PlayerScreen$1$6$1(playerViewModel3);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    playerViewModel4 = playerViewModel3;
                    mutableState2 = mutableState3;
                    Z17VideoPlayerKt.Z17VideoPlayer(modifierFillMaxWidth$default4, listE2, true, true, true, false, null, 0L, 0L, repeatMode4, 0.5f, function19, true, true, true, null, playerState7, function20, (Function1) ((sb.h) objRememberedValue4), pipScale4, 1, 0, composerStartRestartGroup, (VideoPlayerMediaItem.StorageMediaItem.$stable << 3) | 805531014, 28038, 6, 2130368);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    mutableState2 = mutableState;
                    playerViewModel4 = playerViewModel3;
                    composerStartRestartGroup.startReplaceGroup(1782225724);
                    Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                    int iA4 = defpackage.l.a(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default7);
                    constructor2 = companion4.getConstructor();
                    if (!defpackage.r.a(composerStartRestartGroup.getApplier())) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5176constructorimpl4 = Updater.m5176constructorimpl(composerStartRestartGroup);
                    Updater.m5184setimpl(composerM5176constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, companion4.getSetMeasurePolicy());
                    Updater.m5184setimpl(composerM5176constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                    Updater.m5180initimpl(composerM5176constructorimpl4, Integer.valueOf(iA4), companion4.getSetCompositeKeyHash());
                    Updater.m5182reconcileimpl(composerM5176constructorimpl4, companion4.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5184setimpl(composerM5176constructorimpl4, modifierMaterializeModifier4, companion4.getSetModifier());
                    i17 = 0;
                    Z17LabelKt.m10262Z17LabelfWhpE4E(null, StringResources_androidKt.stringResource(R.string.video_not_found, composerStartRestartGroup, 0), null, 0L, 0, 0, composerStartRestartGroup, 0, 61);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (le.d0.q0(playerParams.getUrl())) {
                    composerStartRestartGroup.startReplaceGroup(1858618324);
                    Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                    PlayerState playerState8 = playerViewModel4.getPlayerState();
                    i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    playerViewModel2 = playerViewModel4;
                    if (i18 > 256) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (i19 == 0) {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    lb.a aVar4 = (lb.a) objRememberedValue5;
                    if (i18 > 256) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (i20 == 0) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function110 = (Function1) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function111 = (Function1) objRememberedValue7;
                    if (i18 > 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (i21 == 0) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function112 = (Function1) objRememberedValue8;
                    if (i18 > 256) {
                    }
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (i22 == 0) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function113 = (Function1) objRememberedValue9;
                    if (i18 <= 256) {
                    }
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (i17 == 0) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Composer composer5 = composerStartRestartGroup;
                    PlayerControls(modifierFillMaxSize$default8, playerState8, true, false, true, aVar4, function110, function111, function112, function113, (Function1) objRememberedValue10, composer5, 12610950, 0, 0);
                    composerStartRestartGroup = composer5;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1858618324);
                    Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                    PlayerState playerState9 = playerViewModel4.getPlayerState();
                    i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    playerViewModel2 = playerViewModel4;
                    if (i18 > 256) {
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (i19 == 0) {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState4 = mutableState2;
                        objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                            @Override // lb.a
                            public final Object invoke() {
                                return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    lb.a aVar5 = (lb.a) objRememberedValue5;
                    if (i18 > 256) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (i20 == 0) {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function114 = (Function1) objRememberedValue6;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function115 = (Function1) objRememberedValue7;
                    if (i18 > 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (i21 == 0) {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function116 = (Function1) objRememberedValue8;
                    if (i18 > 256) {
                    }
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (i22 == 0) {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    Function1 function117 = (Function1) objRememberedValue9;
                    if (i18 <= 256) {
                    }
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (i17 == 0) {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Composer composer6 = composerStartRestartGroup;
                    PlayerControls(modifierFillMaxSize$default9, playerState9, true, false, true, aVar5, function114, function115, function116, function117, (Function1) objRememberedValue10, composer6, 12610950, 0, 0);
                    composerStartRestartGroup = composer6;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i17 = 0;
            if (le.d0.q0(playerParams.getUrl())) {
                composerStartRestartGroup.startReplaceGroup(1858618324);
                Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                PlayerState playerState10 = playerViewModel4.getPlayerState();
                i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                playerViewModel2 = playerViewModel4;
                if (i18 > 256) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (i19 == 0) {
                    mutableState4 = mutableState2;
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                        @Override // lb.a
                        public final Object invoke() {
                            return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    mutableState4 = mutableState2;
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                        @Override // lb.a
                        public final Object invoke() {
                            return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar6 = (lb.a) objRememberedValue5;
                if (i18 > 256) {
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (i20 == 0) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function1 function118 = (Function1) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function119 = (Function1) objRememberedValue7;
                if (i18 > 256) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (i21 == 0) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Function1 function1110 = (Function1) objRememberedValue8;
                if (i18 > 256) {
                }
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (i22 == 0) {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Function1 function1111 = (Function1) objRememberedValue9;
                if (i18 <= 256) {
                }
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (i17 == 0) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Composer composer7 = composerStartRestartGroup;
                PlayerControls(modifierFillMaxSize$default10, playerState10, true, false, true, aVar6, function118, function119, function1110, function1111, (Function1) objRememberedValue10, composer7, 12610950, 0, 0);
                composerStartRestartGroup = composer7;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1858618324);
                Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(companion5, f10, i16, obj);
                PlayerState playerState11 = playerViewModel4.getPlayerState();
                i18 = (i15 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                playerViewModel2 = playerViewModel4;
                if (i18 > 256) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (i19 == 0) {
                    mutableState4 = mutableState2;
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                        @Override // lb.a
                        public final Object invoke() {
                            return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    mutableState4 = mutableState2;
                    objRememberedValue5 = new lb.a() { // from class: cu.todus.android.uiCompose.player.screen.d0
                        @Override // lb.a
                        public final Object invoke() {
                            return PlayerScreenKt.PlayerScreen$lambda$3$7$0(playerViewModel2, mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                lb.a aVar7 = (lb.a) objRememberedValue5;
                if (i18 > 256) {
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (i20 == 0) {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$8$0(playerViewModel2, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function1 function1112 = (Function1) objRememberedValue6;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$9$0(mutableState4, ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function1113 = (Function1) objRememberedValue7;
                if (i18 > 256) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (i21 == 0) {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$10$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Function1 function1114 = (Function1) objRememberedValue8;
                if (i18 > 256) {
                }
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (i22 == 0) {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$11$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Function1 function1115 = (Function1) objRememberedValue9;
                if (i18 <= 256) {
                }
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (i17 == 0) {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: cu.todus.android.uiCompose.player.screen.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlayerScreenKt.PlayerScreen$lambda$3$12$0(playerViewModel2, (TrackElement) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Composer composer8 = composerStartRestartGroup;
                PlayerControls(modifierFillMaxSize$default11, playerState11, true, false, true, aVar7, function1112, function1113, function1114, function1115, (Function1) objRememberedValue10, composer8, 12610950, 0, 0);
                composerStartRestartGroup = composer8;
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            playerViewModel2 = playerViewModel5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: cu.todus.android.uiCompose.player.screen.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PlayerScreenKt.PlayerScreen$lambda$4(navHostController, playerParams, playerViewModel2, i10, i11, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final Player PlayerScreen$lambda$1(MutableState<Player> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$10$0(PlayerViewModel playerViewModel, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerState = playerViewModel.getPlayerState();
        playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : false, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : 0L, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : it, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$11$0(PlayerViewModel playerViewModel, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerState = playerViewModel.getPlayerState();
        playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : false, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : 0L, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : it, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$12$0(PlayerViewModel playerViewModel, TrackElement it) {
        kotlin.jvm.internal.y.i(it, "it");
        PlayerState playerState = playerViewModel.getPlayerState();
        playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : false, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : 0L, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : it));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$7$0(PlayerViewModel playerViewModel, MutableState mutableState) {
        if (playerViewModel.getPlayerState().isPlaying()) {
            Player playerPlayerScreen$lambda$1 = PlayerScreen$lambda$1(mutableState);
            if (playerPlayerScreen$lambda$1 != null) {
                playerPlayerScreen$lambda$1.pause();
            }
        } else if (playerViewModel.getPlayerState().isPlaying() || playerViewModel.getPlayerState().getPlaybackState() != 4) {
            Player playerPlayerScreen$lambda$2 = PlayerScreen$lambda$1(mutableState);
            if (playerPlayerScreen$lambda$2 != null) {
                playerPlayerScreen$lambda$2.play();
            }
        } else {
            Player playerPlayerScreen$lambda$3 = PlayerScreen$lambda$1(mutableState);
            if (playerPlayerScreen$lambda$3 != null) {
                playerPlayerScreen$lambda$3.seekTo(0L);
            }
            PlayerScreen$onCurrentTimeChanged(playerViewModel, 0L);
            Player playerPlayerScreen$lambda$4 = PlayerScreen$lambda$1(mutableState);
            if (playerPlayerScreen$lambda$4 != null) {
                playerPlayerScreen$lambda$4.setPlayWhenReady(true);
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$8$0(PlayerViewModel playerViewModel, boolean z10) {
        PlayerState playerState = playerViewModel.getPlayerState();
        playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : z10, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : 0L, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : null));
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$3$9$0(MutableState mutableState, float f10) {
        Player playerPlayerScreen$lambda$1 = PlayerScreen$lambda$1(mutableState);
        if (playerPlayerScreen$lambda$1 != null) {
            playerPlayerScreen$lambda$1.seekTo((long) f10);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 PlayerScreen$lambda$4(NavHostController navHostController, PlayerParams playerParams, PlayerViewModel playerViewModel, int i10, int i11, Composer composer, int i12) {
        PlayerScreen(navHostController, playerParams, playerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i10 | 1), i11);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlayerScreen$onCurrentTimeChanged(PlayerViewModel playerViewModel, long j10) {
        PlayerState playerState = playerViewModel.getPlayerState();
        playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : false, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : j10, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlayerScreen$onRotate(PlayerViewModel playerViewModel, boolean z10) {
        if (z10 && !playerViewModel.getPlayerState().isFullscreen()) {
            PlayerState playerState = playerViewModel.getPlayerState();
            playerViewModel.setPlayerState(playerState.copy((3583 & 1) != 0 ? playerState.isFullscreen : true, (3583 & 2) != 0 ? playerState.isPlaying : false, (3583 & 4) != 0 ? playerState.isLoading : false, (3583 & 8) != 0 ? playerState.isPIP : false, (3583 & 16) != 0 ? playerState.playbackState : 0, (3583 & 32) != 0 ? playerState.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState.currentPosition : 0L, (3583 & 128) != 0 ? playerState.totalDuration : 0L, (3583 & 256) != 0 ? playerState.tripleTrackSave : null, (3583 & 512) != 0 ? playerState.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState.selectedSubsTrack : null));
        } else {
            if (z10 || !playerViewModel.getPlayerState().isFullscreen()) {
                return;
            }
            PlayerState playerState2 = playerViewModel.getPlayerState();
            playerViewModel.setPlayerState(playerState2.copy((3583 & 1) != 0 ? playerState2.isFullscreen : false, (3583 & 2) != 0 ? playerState2.isPlaying : false, (3583 & 4) != 0 ? playerState2.isLoading : false, (3583 & 8) != 0 ? playerState2.isPIP : false, (3583 & 16) != 0 ? playerState2.playbackState : 0, (3583 & 32) != 0 ? playerState2.bufferedPercentage : 0, (3583 & 64) != 0 ? playerState2.currentPosition : 0L, (3583 & 128) != 0 ? playerState2.totalDuration : 0L, (3583 & 256) != 0 ? playerState2.tripleTrackSave : null, (3583 & 512) != 0 ? playerState2.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState2.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState2.selectedSubsTrack : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlayerScreen$updatePlayerState(PlayerViewModel playerViewModel, MutableState<Player> mutableState, PlayerState playerState, Player player) {
        playerViewModel.setPlayerState(playerState);
        mutableState.setValue(player);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PlayerControls$lambda$5$0$0$4$0(int i10) {
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PlayerControls$lambda$5$0$0$5$0(int i10) {
        return i10;
    }
}
