package cu.z17.views.videoEditor.sections.viewer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.w;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import cb.m;
import cu.z17.views.videoPlayer.PlayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoEditor.sections.viewer.ViewerKt$Viewer$3$2$1", f = "Viewer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class ViewerKt$Viewer$3$2$1 extends m implements Function2 {
    final /* synthetic */ PlayerView $defaultPlayerView;
    final /* synthetic */ ExoPlayer $player;
    final /* synthetic */ PlayerState $playerState;
    final /* synthetic */ Function2 $updatePlayerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewerKt$Viewer$3$2$1(PlayerView playerView, ExoPlayer exoPlayer, PlayerState playerState, Function2 function2, ab.e<? super ViewerKt$Viewer$3$2$1> eVar) {
        super(2, eVar);
        this.$defaultPlayerView = playerView;
        this.$player = exoPlayer;
        this.$playerState = playerState;
        this.$updatePlayerState = function2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new ViewerKt$Viewer$3$2$1(this.$defaultPlayerView, this.$player, this.$playerState, this.$updatePlayerState, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        this.$defaultPlayerView.setPlayer(this.$player);
        ExoPlayer exoPlayer = this.$player;
        final PlayerState playerState = this.$playerState;
        final Function2 function2 = this.$updatePlayerState;
        exoPlayer.addListener(new Player.Listener() { // from class: cu.z17.views.videoEditor.sections.viewer.ViewerKt$Viewer$3$2$1.1
            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                w.a(this, audioAttributes);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioSessionIdChanged(int i10) {
                w.b(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                w.c(this, commands);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(CueGroup cueGroup) {
                w.d(this, cueGroup);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                w.f(this, deviceInfo);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
                w.g(this, i10, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onEvents(Player player, Player.Events events) {
                y.i(player, "player");
                y.i(events, "events");
                w.h(this, player, events);
                PlayerState playerState2 = playerState;
                function2.invoke(playerState2.copy((3583 & 1) != 0 ? playerState2.isFullscreen : false, (3583 & 2) != 0 ? playerState2.isPlaying : player.isPlaying(), (3583 & 4) != 0 ? playerState2.isLoading : player.isLoading(), (3583 & 8) != 0 ? playerState2.isPIP : false, (3583 & 16) != 0 ? playerState2.playbackState : player.getPlaybackState(), (3583 & 32) != 0 ? playerState2.bufferedPercentage : player.getBufferedPercentage(), (3583 & 64) != 0 ? playerState2.currentPosition : rb.k.f(player.getCurrentPosition(), 0L), (3583 & 128) != 0 ? playerState2.totalDuration : rb.k.f(player.getDuration(), 0L), (3583 & 256) != 0 ? playerState2.tripleTrackSave : null, (3583 & 512) != 0 ? playerState2.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerState2.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState2.selectedSubsTrack : null), player);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsLoadingChanged(boolean z10) {
                w.i(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsPlayingChanged(boolean z10) {
                w.j(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onLoadingChanged(boolean z10) {
                w.k(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j10) {
                w.l(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i10) {
                w.m(this, mediaItem, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                w.n(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMetadata(androidx.media3.common.Metadata metadata) {
                w.o(this, metadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
                w.p(this, z10, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                w.q(this, playbackParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackStateChanged(int i10) {
                w.r(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
                w.s(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                w.t(this, playbackException);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                w.u(this, playbackException);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
                w.v(this, z10, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                w.w(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(int i10) {
                w.x(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRenderedFirstFrame() {
                w.z(this);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRepeatModeChanged(int i10) {
                w.A(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekBackIncrementChanged(long j10) {
                w.B(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
                w.C(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
                w.D(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
                w.E(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
                w.F(this, i10, i11);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
                w.G(this, timeline, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                w.H(this, trackSelectionParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTracksChanged(Tracks tracks) {
                w.I(this, tracks);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                w.J(this, videoSize);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVolumeChanged(float f10) {
                w.K(this, f10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(List list) {
                w.e(this, list);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
                w.y(this, positionInfo, positionInfo2, i10);
            }
        });
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((ViewerKt$Viewer$3$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
