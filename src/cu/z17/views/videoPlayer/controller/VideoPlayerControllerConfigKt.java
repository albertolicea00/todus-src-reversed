package cu.z17.views.videoPlayer.controller;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig;", "Landroidx/media3/ui/PlayerView;", "playerView", "Lkotlin/Function1;", "", "Lua/k0;", "onFullScreenStatusChanged", "applyToExoPlayerView", "(Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig;Landroidx/media3/ui/PlayerView;Lkotlin/jvm/functions/Function1;)V", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayerControllerConfigKt {
    @SuppressLint({"UnsafeOptInUsageError"})
    public static final void applyToExoPlayerView(VideoPlayerControllerConfig videoPlayerControllerConfig, PlayerView playerView, final Function1 onFullScreenStatusChanged) {
        y.i(videoPlayerControllerConfig, "<this>");
        y.i(playerView, "playerView");
        y.i(onFullScreenStatusChanged, "onFullScreenStatusChanged");
        View rootView = playerView.getRootView();
        View viewFindViewById = rootView.findViewById(R.id.exo_settings);
        y.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(videoPlayerControllerConfig.getShowSpeedAndPitchOverlay() ? 0 : 8);
        playerView.setShowSubtitleButton(videoPlayerControllerConfig.getShowSubtitleButton());
        View viewFindViewById2 = rootView.findViewById(R.id.exo_time);
        y.h(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(videoPlayerControllerConfig.getShowCurrentTimeAndTotalTime() ? 0 : 8);
        playerView.setShowBuffering(!videoPlayerControllerConfig.getShowBufferingProgress() ? 0 : 2);
        View viewFindViewById3 = rootView.findViewById(R.id.exo_ffwd_with_amount);
        y.h(viewFindViewById3, "findViewById(...)");
        viewFindViewById3.setVisibility(videoPlayerControllerConfig.getShowForwardIncrementButton() ? 0 : 8);
        View viewFindViewById4 = rootView.findViewById(R.id.exo_rew_with_amount);
        y.h(viewFindViewById4, "findViewById(...)");
        viewFindViewById4.setVisibility(videoPlayerControllerConfig.getShowBackwardIncrementButton() ? 0 : 8);
        playerView.setShowNextButton(videoPlayerControllerConfig.getShowNextTrackButton());
        playerView.setShowPreviousButton(videoPlayerControllerConfig.getShowBackTrackButton());
        playerView.setShowFastForwardButton(videoPlayerControllerConfig.getShowForwardIncrementButton());
        playerView.setShowRewindButton(videoPlayerControllerConfig.getShowBackwardIncrementButton());
        playerView.setControllerShowTimeoutMs(videoPlayerControllerConfig.getControllerShowTimeMilliSeconds());
        playerView.setControllerAutoShow(videoPlayerControllerConfig.getControllerAutoShow());
        if (videoPlayerControllerConfig.getShowFullScreenButton()) {
            playerView.setControllerOnFullScreenModeChangedListener(new PlayerControlView.OnFullScreenModeChangedListener() { // from class: cu.z17.views.videoPlayer.controller.f
                @Override // androidx.media3.ui.PlayerControlView.OnFullScreenModeChangedListener
                public final void onFullScreenModeChanged(boolean z10) {
                    VideoPlayerControllerConfigKt.applyToExoPlayerView$lambda$0(onFullScreenStatusChanged, z10);
                }
            });
        } else {
            playerView.setControllerOnFullScreenModeChangedListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyToExoPlayerView$lambda$0(Function1 function1, boolean z10) {
        function1.invoke(Boolean.valueOf(z10));
    }
}
