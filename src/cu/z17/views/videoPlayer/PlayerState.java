package cu.z17.views.videoPlayer;

import androidx.compose.runtime.Immutable;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.trackSelector.TripleTrackSave;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0087\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00064"}, d2 = {"Lcu/z17/views/videoPlayer/PlayerState;", "", "isFullscreen", "", "isPlaying", "isLoading", "isPIP", "playbackState", "", "bufferedPercentage", "currentPosition", "", "totalDuration", "tripleTrackSave", "Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "selectedVideoTrack", "Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "selectedAudioTrack", "selectedSubsTrack", "<init>", "(ZZZZIIJJLcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Lcu/z17/views/videoPlayer/trackSelector/TrackElement;Lcu/z17/views/videoPlayer/trackSelector/TrackElement;)V", "()Z", "getPlaybackState", "()I", "getBufferedPercentage", "getCurrentPosition", "()J", "getTotalDuration", "getTripleTrackSave", "()Lcu/z17/views/videoPlayer/trackSelector/TripleTrackSave;", "getSelectedVideoTrack", "()Lcu/z17/views/videoPlayer/trackSelector/TrackElement;", "getSelectedAudioTrack", "getSelectedSubsTrack", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PlayerState {
    public static final int $stable = 0;
    private final int bufferedPercentage;
    private final long currentPosition;
    private final boolean isFullscreen;
    private final boolean isLoading;
    private final boolean isPIP;
    private final boolean isPlaying;
    private final int playbackState;
    private final TrackElement selectedAudioTrack;
    private final TrackElement selectedSubsTrack;
    private final TrackElement selectedVideoTrack;
    private final long totalDuration;
    private final TripleTrackSave tripleTrackSave;

    public PlayerState() {
        this(false, false, false, false, 0, 0, 0L, 0L, null, null, null, null, 4095, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFullscreen() {
        return this.isFullscreen;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final TrackElement getSelectedVideoTrack() {
        return this.selectedVideoTrack;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final TrackElement getSelectedAudioTrack() {
        return this.selectedAudioTrack;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final TrackElement getSelectedSubsTrack() {
        return this.selectedSubsTrack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPIP() {
        return this.isPIP;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPlaybackState() {
        return this.playbackState;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBufferedPercentage() {
        return this.bufferedPercentage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final TripleTrackSave getTripleTrackSave() {
        return this.tripleTrackSave;
    }

    public final PlayerState copy(boolean isFullscreen, boolean isPlaying, boolean isLoading, boolean isPIP, int playbackState, int bufferedPercentage, long currentPosition, long totalDuration, TripleTrackSave tripleTrackSave, TrackElement selectedVideoTrack, TrackElement selectedAudioTrack, TrackElement selectedSubsTrack) {
        kotlin.jvm.internal.y.i(tripleTrackSave, "tripleTrackSave");
        return new PlayerState(isFullscreen, isPlaying, isLoading, isPIP, playbackState, bufferedPercentage, currentPosition, totalDuration, tripleTrackSave, selectedVideoTrack, selectedAudioTrack, selectedSubsTrack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerState)) {
            return false;
        }
        PlayerState playerState = (PlayerState) other;
        return this.isFullscreen == playerState.isFullscreen && this.isPlaying == playerState.isPlaying && this.isLoading == playerState.isLoading && this.isPIP == playerState.isPIP && this.playbackState == playerState.playbackState && this.bufferedPercentage == playerState.bufferedPercentage && this.currentPosition == playerState.currentPosition && this.totalDuration == playerState.totalDuration && kotlin.jvm.internal.y.d(this.tripleTrackSave, playerState.tripleTrackSave) && kotlin.jvm.internal.y.d(this.selectedVideoTrack, playerState.selectedVideoTrack) && kotlin.jvm.internal.y.d(this.selectedAudioTrack, playerState.selectedAudioTrack) && kotlin.jvm.internal.y.d(this.selectedSubsTrack, playerState.selectedSubsTrack);
    }

    public final int getBufferedPercentage() {
        return this.bufferedPercentage;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    public final int getPlaybackState() {
        return this.playbackState;
    }

    public final TrackElement getSelectedAudioTrack() {
        return this.selectedAudioTrack;
    }

    public final TrackElement getSelectedSubsTrack() {
        return this.selectedSubsTrack;
    }

    public final TrackElement getSelectedVideoTrack() {
        return this.selectedVideoTrack;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final TripleTrackSave getTripleTrackSave() {
        return this.tripleTrackSave;
    }

    public int hashCode() {
        int iA = ((((((((((((((((androidx.camera.camera2.adapter.r.a(this.isFullscreen) * 31) + androidx.camera.camera2.adapter.r.a(this.isPlaying)) * 31) + androidx.camera.camera2.adapter.r.a(this.isLoading)) * 31) + androidx.camera.camera2.adapter.r.a(this.isPIP)) * 31) + this.playbackState) * 31) + this.bufferedPercentage) * 31) + defpackage.l.a(this.currentPosition)) * 31) + defpackage.l.a(this.totalDuration)) * 31) + this.tripleTrackSave.hashCode()) * 31;
        TrackElement trackElement = this.selectedVideoTrack;
        int iHashCode = (iA + (trackElement == null ? 0 : trackElement.hashCode())) * 31;
        TrackElement trackElement2 = this.selectedAudioTrack;
        int iHashCode2 = (iHashCode + (trackElement2 == null ? 0 : trackElement2.hashCode())) * 31;
        TrackElement trackElement3 = this.selectedSubsTrack;
        return iHashCode2 + (trackElement3 != null ? trackElement3.hashCode() : 0);
    }

    public final boolean isFullscreen() {
        return this.isFullscreen;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isPIP() {
        return this.isPIP;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public String toString() {
        return "val isFullscreen: Boolean = " + this.isFullscreen + ",\n    val isPlaying: Boolean = " + this.isPlaying + ",\n    val isLoading: Boolean = " + this.isLoading + ",\n    val playbackState: Int = " + this.playbackState + ",\n    val bufferedPercentage: Int = " + this.bufferedPercentage + ",\n    val currentPosition: Long = " + this.currentPosition + ",\n    val totalDuration: Long = " + this.totalDuration + ",\n";
    }

    public PlayerState(boolean z10, boolean z11, boolean z12, boolean z13, int i10, int i11, long j10, long j11, TripleTrackSave tripleTrackSave, TrackElement trackElement, TrackElement trackElement2, TrackElement trackElement3) {
        kotlin.jvm.internal.y.i(tripleTrackSave, "tripleTrackSave");
        this.isFullscreen = z10;
        this.isPlaying = z11;
        this.isLoading = z12;
        this.isPIP = z13;
        this.playbackState = i10;
        this.bufferedPercentage = i11;
        this.currentPosition = j10;
        this.totalDuration = j11;
        this.tripleTrackSave = tripleTrackSave;
        this.selectedVideoTrack = trackElement;
        this.selectedAudioTrack = trackElement2;
        this.selectedSubsTrack = trackElement3;
    }

    public /* synthetic */ PlayerState(boolean z10, boolean z11, boolean z12, boolean z13, int i10, int i11, long j10, long j11, TripleTrackSave tripleTrackSave, TrackElement trackElement, TrackElement trackElement2, TrackElement trackElement3, int i12, kotlin.jvm.internal.p pVar) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? false : z11, (i12 & 4) != 0 ? false : z12, (i12 & 8) != 0 ? false : z13, (i12 & 16) != 0 ? 1 : i10, (i12 & 32) == 0 ? i11 : 0, (i12 & 64) != 0 ? 0L : j10, (i12 & 128) == 0 ? j11 : 0L, (i12 & 256) != 0 ? new TripleTrackSave(null, null, null, 7, null) : tripleTrackSave, (i12 & 512) != 0 ? null : trackElement, (i12 & 1024) != 0 ? null : trackElement2, (i12 & 2048) != 0 ? null : trackElement3);
    }
}
