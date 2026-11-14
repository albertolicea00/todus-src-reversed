package cu.z17.views.videoPlayer;

import android.content.Context;
import androidx.compose.runtime.MutableState;
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
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.ui.PlayerView;
import c3.h0;
import cu.z17.views.videoPlayer.trackSelector.FormatAudioPreferred;
import cu.z17.views.videoPlayer.trackSelector.FormatSubsPreferred;
import cu.z17.views.videoPlayer.trackSelector.FormatVideoResolution;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.trackSelector.TrackSelectorHelper;
import cu.z17.views.videoPlayer.trackSelector.TripleTrackSave;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoPlayer.Z17VideoPlayerKt$Z17VideoPlayer$8$1", f = "Z17VideoPlayer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17VideoPlayerKt$Z17VideoPlayer$8$1 extends cb.m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ PlayerView $defaultPlayerView;
    final /* synthetic */ ExoPlayer $player;
    final /* synthetic */ PlayerState $playerState;
    final /* synthetic */ MutableState<DefaultTrackSelector> $trackSelector$delegate;
    final /* synthetic */ MutableState<TrackSelectorHelper> $trackSelectorHelper$delegate;
    final /* synthetic */ Function2 $updatePlayerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17VideoPlayerKt$Z17VideoPlayer$8$1(PlayerView playerView, ExoPlayer exoPlayer, Context context, MutableState<TrackSelectorHelper> mutableState, MutableState<DefaultTrackSelector> mutableState2, PlayerState playerState, Function2 function2, ab.e<? super Z17VideoPlayerKt$Z17VideoPlayer$8$1> eVar) {
        super(2, eVar);
        this.$defaultPlayerView = playerView;
        this.$player = exoPlayer;
        this.$context = context;
        this.$trackSelectorHelper$delegate = mutableState;
        this.$trackSelector$delegate = mutableState2;
        this.$playerState = playerState;
        this.$updatePlayerState = function2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17VideoPlayerKt$Z17VideoPlayer$8$1(this.$defaultPlayerView, this.$player, this.$context, this.$trackSelectorHelper$delegate, this.$trackSelector$delegate, this.$playerState, this.$updatePlayerState, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        this.$defaultPlayerView.setPlayer(this.$player);
        ExoPlayer exoPlayer = this.$player;
        final Context context = this.$context;
        final MutableState<TrackSelectorHelper> mutableState = this.$trackSelectorHelper$delegate;
        final MutableState<DefaultTrackSelector> mutableState2 = this.$trackSelector$delegate;
        final PlayerState playerState = this.$playerState;
        final Function2 function2 = this.$updatePlayerState;
        exoPlayer.addListener(new Player.Listener() { // from class: cu.z17.views.videoPlayer.Z17VideoPlayerKt$Z17VideoPlayer$8$1.1
            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                androidx.media3.common.w.a(this, audioAttributes);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioSessionIdChanged(int i10) {
                androidx.media3.common.w.b(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                androidx.media3.common.w.c(this, commands);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(CueGroup cueGroup) {
                androidx.media3.common.w.d(this, cueGroup);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                androidx.media3.common.w.f(this, deviceInfo);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
                androidx.media3.common.w.g(this, i10, z10);
            }

            /* JADX WARN: Code duplicated, block: B:51:0x0193 A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:3:0x0013, B:5:0x001b, B:9:0x008b, B:11:0x0094, B:13:0x009a, B:15:0x00b5, B:27:0x00f6, B:29:0x00fe, B:31:0x0104, B:33:0x011f, B:45:0x015d, B:47:0x018a, B:52:0x01a4, B:54:0x01b4, B:56:0x01ce, B:57:0x01e5, B:51:0x0193, B:35:0x0128, B:37:0x0130, B:39:0x0136, B:41:0x013c, B:44:0x0146, B:16:0x00be, B:18:0x00c6, B:20:0x00cc, B:22:0x00d2, B:25:0x00dc), top: B:61:0x0013 }] */
            /* JADX WARN: Code duplicated, block: B:54:0x01b4 A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:3:0x0013, B:5:0x001b, B:9:0x008b, B:11:0x0094, B:13:0x009a, B:15:0x00b5, B:27:0x00f6, B:29:0x00fe, B:31:0x0104, B:33:0x011f, B:45:0x015d, B:47:0x018a, B:52:0x01a4, B:54:0x01b4, B:56:0x01ce, B:57:0x01e5, B:51:0x0193, B:35:0x0128, B:37:0x0130, B:39:0x0136, B:41:0x013c, B:44:0x0146, B:16:0x00be, B:18:0x00c6, B:20:0x00cc, B:22:0x00d2, B:25:0x00dc), top: B:61:0x0013 }] */
            /* JADX WARN: Code duplicated, block: B:56:0x01ce A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:3:0x0013, B:5:0x001b, B:9:0x008b, B:11:0x0094, B:13:0x009a, B:15:0x00b5, B:27:0x00f6, B:29:0x00fe, B:31:0x0104, B:33:0x011f, B:45:0x015d, B:47:0x018a, B:52:0x01a4, B:54:0x01b4, B:56:0x01ce, B:57:0x01e5, B:51:0x0193, B:35:0x0128, B:37:0x0130, B:39:0x0136, B:41:0x013c, B:44:0x0146, B:16:0x00be, B:18:0x00c6, B:20:0x00cc, B:22:0x00d2, B:25:0x00dc), top: B:61:0x0013 }] */
            @Override // androidx.media3.common.Player.Listener
            public void onEvents(Player player, Player.Events events) {
                TrackElement trackElement;
                TrackElement trackElement2;
                TripleTrackSave tripleTrackSave;
                List<TrackElement> audioTracks;
                TrackElement trackElement3;
                TripleTrackSave tripleTrackSave2;
                List<TrackElement> subsTracks;
                TrackSelectorHelper trackSelectorHelperZ17VideoPlayer$lambda$18;
                TripleTrackSave tripleTrackSave3;
                PlayerState playerStateCopy;
                TripleTrackSave tripleTrackSaveLoadTrackData;
                kotlin.jvm.internal.y.i(player, "player");
                kotlin.jvm.internal.y.i(events, "events");
                androidx.media3.common.w.h(this, player, events);
                try {
                    TrackElement selectedVideoTrack = playerState.getSelectedVideoTrack();
                    if (selectedVideoTrack == null) {
                        trackElement = new TrackElement(2, 0, 0, Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().maxVideoWidth + " × " + Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().maxVideoHeight + " " + Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().maxVideoBitrate + " Mbps", new FormatVideoResolution(Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().maxVideoWidth, Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().maxVideoHeight));
                    } else {
                        trackElement = selectedVideoTrack;
                    }
                    TrackElement selectedAudioTrack = playerState.getSelectedAudioTrack();
                    TrackElement selectedSubsTrack = null;
                    String trackStringData = selectedAudioTrack != null ? selectedAudioTrack.getTrackStringData() : null;
                    h0 preferredAudioLanguages = Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().preferredAudioLanguages;
                    kotlin.jvm.internal.y.h(preferredAudioLanguages, "preferredAudioLanguages");
                    if (kotlin.jvm.internal.y.d(trackStringData, g0.y0(preferredAudioLanguages))) {
                        trackElement2 = playerState.getSelectedAudioTrack();
                    } else {
                        TrackSelectorHelper trackSelectorHelperZ17VideoPlayer$lambda$19 = Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState);
                        TrackElement trackElement4 = (trackSelectorHelperZ17VideoPlayer$lambda$19 == null || (tripleTrackSave = trackSelectorHelperZ17VideoPlayer$lambda$19.getTripleTrackSave()) == null || (audioTracks = tripleTrackSave.getAudioTracks()) == null) ? null : (TrackElement) g0.y0(audioTracks);
                        trackElement2 = trackElement4 != null ? new TrackElement(1, 0, 0, trackElement4.getTrackStringData(), new FormatAudioPreferred(trackElement4.getTrackStringData())) : null;
                    }
                    TrackElement selectedSubsTrack2 = playerState.getSelectedSubsTrack();
                    String trackStringData2 = selectedSubsTrack2 != null ? selectedSubsTrack2.getTrackStringData() : null;
                    h0 preferredTextLanguages = Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2).getParameters().preferredTextLanguages;
                    kotlin.jvm.internal.y.h(preferredTextLanguages, "preferredTextLanguages");
                    if (!kotlin.jvm.internal.y.d(trackStringData2, g0.y0(preferredTextLanguages))) {
                        TrackSelectorHelper trackSelectorHelperZ17VideoPlayer$lambda$110 = Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState);
                        TrackElement trackElement5 = (trackSelectorHelperZ17VideoPlayer$lambda$110 == null || (tripleTrackSave2 = trackSelectorHelperZ17VideoPlayer$lambda$110.getTripleTrackSave()) == null || (subsTracks = tripleTrackSave2.getSubsTracks()) == null) ? null : (TrackElement) g0.y0(subsTracks);
                        if (trackElement5 != null) {
                            trackElement3 = new TrackElement(3, 0, 0, trackElement5.getTrackStringData(), new FormatSubsPreferred(trackElement5.getTrackStringData()));
                        }
                        PlayerState playerState2 = playerState;
                        boolean zIsPlaying = player.isPlaying();
                        boolean zIsLoading = player.isLoading();
                        int playbackState = player.getPlaybackState();
                        int bufferedPercentage = player.getBufferedPercentage();
                        long jF = rb.k.f(player.getCurrentPosition(), 0L);
                        long jF2 = rb.k.f(player.getDuration(), 0L);
                        trackSelectorHelperZ17VideoPlayer$lambda$18 = Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState);
                        if (trackSelectorHelperZ17VideoPlayer$lambda$18 != null || (tripleTrackSaveLoadTrackData = trackSelectorHelperZ17VideoPlayer$lambda$18.loadTrackData()) == null) {
                            tripleTrackSave3 = new TripleTrackSave(null, null, null, 7, null);
                        } else {
                            tripleTrackSave3 = tripleTrackSaveLoadTrackData;
                        }
                        playerStateCopy = playerState2.copy((3583 & 1) != 0 ? playerState2.isFullscreen : false, (3583 & 2) != 0 ? playerState2.isPlaying : zIsPlaying, (3583 & 4) != 0 ? playerState2.isLoading : zIsLoading, (3583 & 8) != 0 ? playerState2.isPIP : false, (3583 & 16) != 0 ? playerState2.playbackState : playbackState, (3583 & 32) != 0 ? playerState2.bufferedPercentage : bufferedPercentage, (3583 & 64) != 0 ? playerState2.currentPosition : jF, (3583 & 128) != 0 ? playerState2.totalDuration : jF2, (3583 & 256) != 0 ? playerState2.tripleTrackSave : tripleTrackSave3, (3583 & 512) != 0 ? playerState2.selectedVideoTrack : trackElement, (3583 & 1024) != 0 ? playerState2.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState2.selectedSubsTrack : null);
                        if (trackElement2 != null) {
                            playerStateCopy = playerStateCopy.copy((3583 & 1) != 0 ? playerStateCopy.isFullscreen : false, (3583 & 2) != 0 ? playerStateCopy.isPlaying : false, (3583 & 4) != 0 ? playerStateCopy.isLoading : false, (3583 & 8) != 0 ? playerStateCopy.isPIP : false, (3583 & 16) != 0 ? playerStateCopy.playbackState : 0, (3583 & 32) != 0 ? playerStateCopy.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStateCopy.currentPosition : 0L, (3583 & 128) != 0 ? playerStateCopy.totalDuration : 0L, (3583 & 256) != 0 ? playerStateCopy.tripleTrackSave : null, (3583 & 512) != 0 ? playerStateCopy.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStateCopy.selectedAudioTrack : trackElement2, (3583 & 2048) != 0 ? playerStateCopy.selectedSubsTrack : null);
                        }
                        if (trackElement3 != null) {
                            playerStateCopy = playerStateCopy.copy((3583 & 1) != 0 ? playerStateCopy.isFullscreen : false, (3583 & 2) != 0 ? playerStateCopy.isPlaying : false, (3583 & 4) != 0 ? playerStateCopy.isLoading : false, (3583 & 8) != 0 ? playerStateCopy.isPIP : false, (3583 & 16) != 0 ? playerStateCopy.playbackState : 0, (3583 & 32) != 0 ? playerStateCopy.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStateCopy.currentPosition : 0L, (3583 & 128) != 0 ? playerStateCopy.totalDuration : 0L, (3583 & 256) != 0 ? playerStateCopy.tripleTrackSave : null, (3583 & 512) != 0 ? playerStateCopy.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStateCopy.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStateCopy.selectedSubsTrack : trackElement3);
                        }
                        function2.invoke(playerStateCopy, player);
                    }
                    selectedSubsTrack = playerState.getSelectedSubsTrack();
                    trackElement3 = selectedSubsTrack;
                    PlayerState playerState3 = playerState;
                    boolean zIsPlaying2 = player.isPlaying();
                    boolean zIsLoading2 = player.isLoading();
                    int playbackState2 = player.getPlaybackState();
                    int bufferedPercentage2 = player.getBufferedPercentage();
                    long jF3 = rb.k.f(player.getCurrentPosition(), 0L);
                    long jF4 = rb.k.f(player.getDuration(), 0L);
                    trackSelectorHelperZ17VideoPlayer$lambda$18 = Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState);
                    if (trackSelectorHelperZ17VideoPlayer$lambda$18 != null) {
                        tripleTrackSave3 = new TripleTrackSave(null, null, null, 7, null);
                    } else {
                        tripleTrackSave3 = new TripleTrackSave(null, null, null, 7, null);
                    }
                    playerStateCopy = playerState3.copy((3583 & 1) != 0 ? playerState3.isFullscreen : false, (3583 & 2) != 0 ? playerState3.isPlaying : zIsPlaying2, (3583 & 4) != 0 ? playerState3.isLoading : zIsLoading2, (3583 & 8) != 0 ? playerState3.isPIP : false, (3583 & 16) != 0 ? playerState3.playbackState : playbackState2, (3583 & 32) != 0 ? playerState3.bufferedPercentage : bufferedPercentage2, (3583 & 64) != 0 ? playerState3.currentPosition : jF3, (3583 & 128) != 0 ? playerState3.totalDuration : jF4, (3583 & 256) != 0 ? playerState3.tripleTrackSave : tripleTrackSave3, (3583 & 512) != 0 ? playerState3.selectedVideoTrack : trackElement, (3583 & 1024) != 0 ? playerState3.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerState3.selectedSubsTrack : null);
                    if (trackElement2 != null) {
                        playerStateCopy = playerStateCopy.copy((3583 & 1) != 0 ? playerStateCopy.isFullscreen : false, (3583 & 2) != 0 ? playerStateCopy.isPlaying : false, (3583 & 4) != 0 ? playerStateCopy.isLoading : false, (3583 & 8) != 0 ? playerStateCopy.isPIP : false, (3583 & 16) != 0 ? playerStateCopy.playbackState : 0, (3583 & 32) != 0 ? playerStateCopy.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStateCopy.currentPosition : 0L, (3583 & 128) != 0 ? playerStateCopy.totalDuration : 0L, (3583 & 256) != 0 ? playerStateCopy.tripleTrackSave : null, (3583 & 512) != 0 ? playerStateCopy.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStateCopy.selectedAudioTrack : trackElement2, (3583 & 2048) != 0 ? playerStateCopy.selectedSubsTrack : null);
                    }
                    if (trackElement3 != null) {
                        playerStateCopy = playerStateCopy.copy((3583 & 1) != 0 ? playerStateCopy.isFullscreen : false, (3583 & 2) != 0 ? playerStateCopy.isPlaying : false, (3583 & 4) != 0 ? playerStateCopy.isLoading : false, (3583 & 8) != 0 ? playerStateCopy.isPIP : false, (3583 & 16) != 0 ? playerStateCopy.playbackState : 0, (3583 & 32) != 0 ? playerStateCopy.bufferedPercentage : 0, (3583 & 64) != 0 ? playerStateCopy.currentPosition : 0L, (3583 & 128) != 0 ? playerStateCopy.totalDuration : 0L, (3583 & 256) != 0 ? playerStateCopy.tripleTrackSave : null, (3583 & 512) != 0 ? playerStateCopy.selectedVideoTrack : null, (3583 & 1024) != 0 ? playerStateCopy.selectedAudioTrack : null, (3583 & 2048) != 0 ? playerStateCopy.selectedSubsTrack : trackElement3);
                    }
                    function2.invoke(playerStateCopy, player);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsLoadingChanged(boolean z10) {
                androidx.media3.common.w.i(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsPlayingChanged(boolean z10) {
                androidx.media3.common.w.j(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onLoadingChanged(boolean z10) {
                androidx.media3.common.w.k(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j10) {
                androidx.media3.common.w.l(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i10) {
                androidx.media3.common.w.m(this, mediaItem, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                androidx.media3.common.w.n(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMetadata(androidx.media3.common.Metadata metadata) {
                androidx.media3.common.w.o(this, metadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
                androidx.media3.common.w.p(this, z10, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                androidx.media3.common.w.q(this, playbackParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
                androidx.media3.common.w.r(this, playbackState);
                if (playbackState == 3) {
                    try {
                        if (Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState) == null) {
                            mutableState.setValue(new TrackSelectorHelper(context, Z17VideoPlayerKt.Z17VideoPlayer$lambda$16(mutableState2)));
                            TrackSelectorHelper trackSelectorHelperZ17VideoPlayer$lambda$18 = Z17VideoPlayerKt.Z17VideoPlayer$lambda$18(mutableState);
                            if (trackSelectorHelperZ17VideoPlayer$lambda$18 != null) {
                                trackSelectorHelperZ17VideoPlayer$lambda$18.loadTrackData();
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
                androidx.media3.common.w.s(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                androidx.media3.common.w.t(this, playbackException);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                androidx.media3.common.w.u(this, playbackException);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
                androidx.media3.common.w.v(this, z10, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                androidx.media3.common.w.w(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(int i10) {
                androidx.media3.common.w.x(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRenderedFirstFrame() {
                androidx.media3.common.w.z(this);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRepeatModeChanged(int i10) {
                androidx.media3.common.w.A(this, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekBackIncrementChanged(long j10) {
                androidx.media3.common.w.B(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
                androidx.media3.common.w.C(this, j10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
                androidx.media3.common.w.D(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
                androidx.media3.common.w.E(this, z10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
                androidx.media3.common.w.F(this, i10, i11);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
                androidx.media3.common.w.G(this, timeline, i10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                androidx.media3.common.w.H(this, trackSelectionParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTracksChanged(Tracks tracks) {
                androidx.media3.common.w.I(this, tracks);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                androidx.media3.common.w.J(this, videoSize);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVolumeChanged(float f10) {
                androidx.media3.common.w.K(this, f10);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(List list) {
                androidx.media3.common.w.e(this, list);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
                androidx.media3.common.w.y(this, positionInfo, positionInfo2, i10);
            }
        });
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17VideoPlayerKt$Z17VideoPlayer$8$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
