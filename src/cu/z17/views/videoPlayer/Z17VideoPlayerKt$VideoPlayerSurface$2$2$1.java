package cu.z17.views.videoPlayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.MutableState;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.p001lifecycle.Lifecycle;
import cu.z17.views.videoPlayer.pip.PictureInPictureKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.videoPlayer.Z17VideoPlayerKt$VideoPlayerSurface$2$2$1", f = "Z17VideoPlayer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17VideoPlayerKt$VideoPlayerSurface$2$2$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $autoPlay;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Lifecycle.Event> $currentEvent$delegate;
    final /* synthetic */ PlayerView $defaultPlayerView;
    final /* synthetic */ boolean $enablePip;
    final /* synthetic */ boolean $handleLifecycle;
    final /* synthetic */ MutableState<Boolean> $isPendingPipMode$delegate;
    final /* synthetic */ lb.a $onPipEntered;
    final /* synthetic */ Pair<Integer, Integer> $pipScale;
    final /* synthetic */ ExoPlayer $player;
    final /* synthetic */ boolean $usePlayerController;
    int label;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17VideoPlayerKt$VideoPlayerSurface$2$2$1(ExoPlayer exoPlayer, PlayerView playerView, boolean z10, boolean z11, boolean z12, Context context, boolean z13, MutableState<Lifecycle.Event> mutableState, MutableState<Boolean> mutableState2, Pair<Integer, Integer> pair, lb.a aVar, ab.e<? super Z17VideoPlayerKt$VideoPlayerSurface$2$2$1> eVar) {
        super(2, eVar);
        this.$player = exoPlayer;
        this.$defaultPlayerView = playerView;
        this.$enablePip = z10;
        this.$autoPlay = z11;
        this.$usePlayerController = z12;
        this.$context = context;
        this.$handleLifecycle = z13;
        this.$currentEvent$delegate = mutableState;
        this.$isPendingPipMode$delegate = mutableState2;
        this.$pipScale = pair;
        this.$onPipEntered = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(Context context, PlayerView playerView, Pair pair, lb.a aVar, final MutableState mutableState) {
        PictureInPictureKt.enterPIPMode$default(context, playerView, pair, null, 8, null);
        aVar.invoke();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: cu.z17.views.videoPlayer.x
            @Override // java.lang.Runnable
            public final void run() {
                Z17VideoPlayerKt.VideoPlayerSurface$lambda$44(mutableState, false);
            }
        }, 500L);
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17VideoPlayerKt$VideoPlayerSurface$2$2$1(this.$player, this.$defaultPlayerView, this.$enablePip, this.$autoPlay, this.$usePlayerController, this.$context, this.$handleLifecycle, this.$currentEvent$delegate, this.$isPendingPipMode$delegate, this.$pipScale, this.$onPipEntered, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        try {
            Lifecycle.Event eventVideoPlayerSurface$lambda$46 = Z17VideoPlayerKt.VideoPlayerSurface$lambda$46(this.$currentEvent$delegate);
            int i10 = eventVideoPlayerSurface$lambda$46 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventVideoPlayerSurface$lambda$46.ordinal()];
            if (i10 == 1) {
                this.$player.pause();
                this.$defaultPlayerView.onPause();
                if (this.$enablePip && this.$player.getPlayWhenReady()) {
                    Z17VideoPlayerKt.VideoPlayerSurface$lambda$44(this.$isPendingPipMode$delegate, true);
                    Handler handler = new Handler(Looper.getMainLooper());
                    final Context context = this.$context;
                    final PlayerView playerView = this.$defaultPlayerView;
                    final Pair<Integer, Integer> pair = this.$pipScale;
                    final lb.a aVar = this.$onPipEntered;
                    final MutableState<Boolean> mutableState = this.$isPendingPipMode$delegate;
                    handler.post(new Runnable() { // from class: cu.z17.views.videoPlayer.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            Z17VideoPlayerKt$VideoPlayerSurface$2$2$1.invokeSuspend$lambda$1(context, playerView, pair, aVar, mutableState);
                        }
                    });
                }
            } else if (i10 == 2) {
                this.$defaultPlayerView.onResume();
                if (this.$autoPlay) {
                    this.$player.play();
                }
                if (this.$enablePip && this.$player.getPlayWhenReady()) {
                    this.$defaultPlayerView.setUseController(this.$usePlayerController);
                }
            } else if (i10 == 3) {
                boolean zIsActivityStatePipMode = PictureInPictureKt.isActivityStatePipMode(this.$context);
                if (this.$handleLifecycle || (this.$enablePip && zIsActivityStatePipMode && !Z17VideoPlayerKt.VideoPlayerSurface$lambda$43(this.$isPendingPipMode$delegate))) {
                    this.$player.pause();
                }
            } else if (i10 == 4) {
                this.$player.stop();
                this.$player.release();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17VideoPlayerKt$VideoPlayerSurface$2$2$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
