package cu.z17.views.videoPlayer.controller;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000eHÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00063"}, d2 = {"Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig;", "", "showSpeedAndPitchOverlay", "", "showSubtitleButton", "showCurrentTimeAndTotalTime", "showBufferingProgress", "showForwardIncrementButton", "showBackwardIncrementButton", "showBackTrackButton", "showNextTrackButton", "showRepeatModeButton", "showFullScreenButton", "controllerShowTimeMilliSeconds", "", "controllerAutoShow", "<init>", "(ZZZZZZZZZZIZ)V", "getShowSpeedAndPitchOverlay", "()Z", "getShowSubtitleButton", "getShowCurrentTimeAndTotalTime", "getShowBufferingProgress", "getShowForwardIncrementButton", "getShowBackwardIncrementButton", "getShowBackTrackButton", "getShowNextTrackButton", "getShowRepeatModeButton", "getShowFullScreenButton", "getControllerShowTimeMilliSeconds", "()I", "getControllerAutoShow", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VideoPlayerControllerConfig {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final VideoPlayerControllerConfig Default = new VideoPlayerControllerConfig(false, true, true, false, false, false, true, true, false, true, 5000, true);
    private final boolean controllerAutoShow;
    private final int controllerShowTimeMilliSeconds;
    private final boolean showBackTrackButton;
    private final boolean showBackwardIncrementButton;
    private final boolean showBufferingProgress;
    private final boolean showCurrentTimeAndTotalTime;
    private final boolean showForwardIncrementButton;
    private final boolean showFullScreenButton;
    private final boolean showNextTrackButton;
    private final boolean showRepeatModeButton;
    private final boolean showSpeedAndPitchOverlay;
    private final boolean showSubtitleButton;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig$Companion;", "", "<init>", "()V", "Default", "Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig;", "getDefault", "()Lcu/z17/views/videoPlayer/controller/VideoPlayerControllerConfig;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final VideoPlayerControllerConfig getDefault() {
            return VideoPlayerControllerConfig.Default;
        }

        private Companion() {
        }
    }

    public VideoPlayerControllerConfig(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, int i10, boolean z20) {
        this.showSpeedAndPitchOverlay = z10;
        this.showSubtitleButton = z11;
        this.showCurrentTimeAndTotalTime = z12;
        this.showBufferingProgress = z13;
        this.showForwardIncrementButton = z14;
        this.showBackwardIncrementButton = z15;
        this.showBackTrackButton = z16;
        this.showNextTrackButton = z17;
        this.showRepeatModeButton = z18;
        this.showFullScreenButton = z19;
        this.controllerShowTimeMilliSeconds = i10;
        this.controllerAutoShow = z20;
    }

    public static /* synthetic */ VideoPlayerControllerConfig copy$default(VideoPlayerControllerConfig videoPlayerControllerConfig, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, int i10, boolean z20, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = videoPlayerControllerConfig.showSpeedAndPitchOverlay;
        }
        if ((i11 & 2) != 0) {
            z11 = videoPlayerControllerConfig.showSubtitleButton;
        }
        if ((i11 & 4) != 0) {
            z12 = videoPlayerControllerConfig.showCurrentTimeAndTotalTime;
        }
        if ((i11 & 8) != 0) {
            z13 = videoPlayerControllerConfig.showBufferingProgress;
        }
        if ((i11 & 16) != 0) {
            z14 = videoPlayerControllerConfig.showForwardIncrementButton;
        }
        if ((i11 & 32) != 0) {
            z15 = videoPlayerControllerConfig.showBackwardIncrementButton;
        }
        if ((i11 & 64) != 0) {
            z16 = videoPlayerControllerConfig.showBackTrackButton;
        }
        if ((i11 & 128) != 0) {
            z17 = videoPlayerControllerConfig.showNextTrackButton;
        }
        if ((i11 & 256) != 0) {
            z18 = videoPlayerControllerConfig.showRepeatModeButton;
        }
        if ((i11 & 512) != 0) {
            z19 = videoPlayerControllerConfig.showFullScreenButton;
        }
        if ((i11 & 1024) != 0) {
            i10 = videoPlayerControllerConfig.controllerShowTimeMilliSeconds;
        }
        if ((i11 & 2048) != 0) {
            z20 = videoPlayerControllerConfig.controllerAutoShow;
        }
        int i12 = i10;
        boolean z21 = z20;
        boolean z22 = z18;
        boolean z23 = z19;
        boolean z24 = z16;
        boolean z25 = z17;
        boolean z26 = z14;
        boolean z27 = z15;
        return videoPlayerControllerConfig.copy(z10, z11, z12, z13, z26, z27, z24, z25, z22, z23, i12, z21);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowSpeedAndPitchOverlay() {
        return this.showSpeedAndPitchOverlay;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowFullScreenButton() {
        return this.showFullScreenButton;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getControllerShowTimeMilliSeconds() {
        return this.controllerShowTimeMilliSeconds;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowSubtitleButton() {
        return this.showSubtitleButton;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowCurrentTimeAndTotalTime() {
        return this.showCurrentTimeAndTotalTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowBufferingProgress() {
        return this.showBufferingProgress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowForwardIncrementButton() {
        return this.showForwardIncrementButton;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowBackwardIncrementButton() {
        return this.showBackwardIncrementButton;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowBackTrackButton() {
        return this.showBackTrackButton;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowNextTrackButton() {
        return this.showNextTrackButton;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShowRepeatModeButton() {
        return this.showRepeatModeButton;
    }

    public final VideoPlayerControllerConfig copy(boolean showSpeedAndPitchOverlay, boolean showSubtitleButton, boolean showCurrentTimeAndTotalTime, boolean showBufferingProgress, boolean showForwardIncrementButton, boolean showBackwardIncrementButton, boolean showBackTrackButton, boolean showNextTrackButton, boolean showRepeatModeButton, boolean showFullScreenButton, int controllerShowTimeMilliSeconds, boolean controllerAutoShow) {
        return new VideoPlayerControllerConfig(showSpeedAndPitchOverlay, showSubtitleButton, showCurrentTimeAndTotalTime, showBufferingProgress, showForwardIncrementButton, showBackwardIncrementButton, showBackTrackButton, showNextTrackButton, showRepeatModeButton, showFullScreenButton, controllerShowTimeMilliSeconds, controllerAutoShow);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoPlayerControllerConfig)) {
            return false;
        }
        VideoPlayerControllerConfig videoPlayerControllerConfig = (VideoPlayerControllerConfig) other;
        return this.showSpeedAndPitchOverlay == videoPlayerControllerConfig.showSpeedAndPitchOverlay && this.showSubtitleButton == videoPlayerControllerConfig.showSubtitleButton && this.showCurrentTimeAndTotalTime == videoPlayerControllerConfig.showCurrentTimeAndTotalTime && this.showBufferingProgress == videoPlayerControllerConfig.showBufferingProgress && this.showForwardIncrementButton == videoPlayerControllerConfig.showForwardIncrementButton && this.showBackwardIncrementButton == videoPlayerControllerConfig.showBackwardIncrementButton && this.showBackTrackButton == videoPlayerControllerConfig.showBackTrackButton && this.showNextTrackButton == videoPlayerControllerConfig.showNextTrackButton && this.showRepeatModeButton == videoPlayerControllerConfig.showRepeatModeButton && this.showFullScreenButton == videoPlayerControllerConfig.showFullScreenButton && this.controllerShowTimeMilliSeconds == videoPlayerControllerConfig.controllerShowTimeMilliSeconds && this.controllerAutoShow == videoPlayerControllerConfig.controllerAutoShow;
    }

    public final boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public final int getControllerShowTimeMilliSeconds() {
        return this.controllerShowTimeMilliSeconds;
    }

    public final boolean getShowBackTrackButton() {
        return this.showBackTrackButton;
    }

    public final boolean getShowBackwardIncrementButton() {
        return this.showBackwardIncrementButton;
    }

    public final boolean getShowBufferingProgress() {
        return this.showBufferingProgress;
    }

    public final boolean getShowCurrentTimeAndTotalTime() {
        return this.showCurrentTimeAndTotalTime;
    }

    public final boolean getShowForwardIncrementButton() {
        return this.showForwardIncrementButton;
    }

    public final boolean getShowFullScreenButton() {
        return this.showFullScreenButton;
    }

    public final boolean getShowNextTrackButton() {
        return this.showNextTrackButton;
    }

    public final boolean getShowRepeatModeButton() {
        return this.showRepeatModeButton;
    }

    public final boolean getShowSpeedAndPitchOverlay() {
        return this.showSpeedAndPitchOverlay;
    }

    public final boolean getShowSubtitleButton() {
        return this.showSubtitleButton;
    }

    public int hashCode() {
        return (((((((((((((((((((((r.a(this.showSpeedAndPitchOverlay) * 31) + r.a(this.showSubtitleButton)) * 31) + r.a(this.showCurrentTimeAndTotalTime)) * 31) + r.a(this.showBufferingProgress)) * 31) + r.a(this.showForwardIncrementButton)) * 31) + r.a(this.showBackwardIncrementButton)) * 31) + r.a(this.showBackTrackButton)) * 31) + r.a(this.showNextTrackButton)) * 31) + r.a(this.showRepeatModeButton)) * 31) + r.a(this.showFullScreenButton)) * 31) + this.controllerShowTimeMilliSeconds) * 31) + r.a(this.controllerAutoShow);
    }

    public String toString() {
        return "VideoPlayerControllerConfig(showSpeedAndPitchOverlay=" + this.showSpeedAndPitchOverlay + ", showSubtitleButton=" + this.showSubtitleButton + ", showCurrentTimeAndTotalTime=" + this.showCurrentTimeAndTotalTime + ", showBufferingProgress=" + this.showBufferingProgress + ", showForwardIncrementButton=" + this.showForwardIncrementButton + ", showBackwardIncrementButton=" + this.showBackwardIncrementButton + ", showBackTrackButton=" + this.showBackTrackButton + ", showNextTrackButton=" + this.showNextTrackButton + ", showRepeatModeButton=" + this.showRepeatModeButton + ", showFullScreenButton=" + this.showFullScreenButton + ", controllerShowTimeMilliSeconds=" + this.controllerShowTimeMilliSeconds + ", controllerAutoShow=" + this.controllerAutoShow + ")";
    }
}
