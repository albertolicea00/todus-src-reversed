package cu.z17.views.videoPlayer;

import androidx.compose.runtime.MutableState;
import cu.z17.views.videoPlayer.trackSelector.TrackElement;
import cu.z17.views.videoPlayer.trackSelector.TrackSelectorHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoPlayer.Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1", f = "Z17HLSVideoPlayer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1 extends cb.m implements Function2 {
    final /* synthetic */ PlayerState $playerState;
    final /* synthetic */ MutableState<TrackSelectorHelper> $trackSelectorHelper$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1(PlayerState playerState, MutableState<TrackSelectorHelper> mutableState, ab.e<? super Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1> eVar) {
        super(2, eVar);
        this.$playerState = playerState;
        this.$trackSelectorHelper$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1(this.$playerState, this.$trackSelectorHelper$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        TrackSelectorHelper trackSelectorHelperZ17HLSVideoPlayer$lambda$23;
        TrackSelectorHelper trackSelectorHelperZ17HLSVideoPlayer$lambda$24;
        TrackSelectorHelper trackSelectorHelperZ17HLSVideoPlayer$lambda$25;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        TrackElement selectedVideoTrack = this.$playerState.getSelectedVideoTrack();
        if (selectedVideoTrack != null && (trackSelectorHelperZ17HLSVideoPlayer$lambda$25 = Z17HLSVideoPlayerKt.Z17HLSVideoPlayer$lambda$23(this.$trackSelectorHelper$delegate)) != null) {
            trackSelectorHelperZ17HLSVideoPlayer$lambda$25.selectTrack(selectedVideoTrack);
        }
        TrackElement selectedAudioTrack = this.$playerState.getSelectedAudioTrack();
        if (selectedAudioTrack != null && (trackSelectorHelperZ17HLSVideoPlayer$lambda$24 = Z17HLSVideoPlayerKt.Z17HLSVideoPlayer$lambda$23(this.$trackSelectorHelper$delegate)) != null) {
            trackSelectorHelperZ17HLSVideoPlayer$lambda$24.selectTrack(selectedAudioTrack);
        }
        TrackElement selectedSubsTrack = this.$playerState.getSelectedSubsTrack();
        if (selectedSubsTrack != null && (trackSelectorHelperZ17HLSVideoPlayer$lambda$23 = Z17HLSVideoPlayerKt.Z17HLSVideoPlayer$lambda$23(this.$trackSelectorHelper$delegate)) != null) {
            trackSelectorHelperZ17HLSVideoPlayer$lambda$23.selectTrack(selectedSubsTrack);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17HLSVideoPlayerKt$Z17HLSVideoPlayer$12$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
