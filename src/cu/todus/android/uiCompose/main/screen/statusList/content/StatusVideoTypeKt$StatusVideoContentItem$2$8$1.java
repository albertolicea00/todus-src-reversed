package cu.todus.android.uiCompose.main.screen.statusList.content;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Player;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoTypeKt$StatusVideoContentItem$2$8$1", f = "StatusVideoType.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StatusVideoTypeKt$StatusVideoContentItem$2$8$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $clearVideo;
    final /* synthetic */ MutableState<Player> $player$delegate;
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusVideoTypeKt$StatusVideoContentItem$2$8$1(boolean z10, MutableState<Player> mutableState, MutableState<PlayerState> mutableState2, ab.e<? super StatusVideoTypeKt$StatusVideoContentItem$2$8$1> eVar) {
        super(2, eVar);
        this.$clearVideo = z10;
        this.$player$delegate = mutableState;
        this.$playerState$delegate = mutableState2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new StatusVideoTypeKt$StatusVideoContentItem$2$8$1(this.$clearVideo, this.$player$delegate, this.$playerState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        if (this.$clearVideo) {
            Player playerStatusVideoContentItem$lambda$8 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate);
            if (playerStatusVideoContentItem$lambda$8 != null) {
                playerStatusVideoContentItem$lambda$8.stop();
            }
            Player playerStatusVideoContentItem$lambda$9 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate);
            if (playerStatusVideoContentItem$lambda$9 != null) {
                playerStatusVideoContentItem$lambda$9.release();
            }
        }
        if (!this.$clearVideo && !StatusVideoTypeKt.StatusVideoContentItem$lambda$5(this.$playerState$delegate).isPlaying()) {
            Player playerStatusVideoContentItem$lambda$10 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate);
            if (playerStatusVideoContentItem$lambda$10 != null) {
                playerStatusVideoContentItem$lambda$10.seekTo(0L);
            }
            StatusVideoTypeKt.StatusVideoContentItem$onCurrentTimeChanged(this.$playerState$delegate, 0L);
            Player playerStatusVideoContentItem$lambda$11 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate);
            if (playerStatusVideoContentItem$lambda$11 != null) {
                playerStatusVideoContentItem$lambda$11.setPlayWhenReady(true);
            }
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((StatusVideoTypeKt$StatusVideoContentItem$2$8$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
