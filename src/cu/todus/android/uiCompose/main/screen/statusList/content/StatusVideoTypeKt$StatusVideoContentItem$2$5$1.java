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
@cb.f(c = "cu.todus.android.uiCompose.main.screen.statusList.content.StatusVideoTypeKt$StatusVideoContentItem$2$5$1", f = "StatusVideoType.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class StatusVideoTypeKt$StatusVideoContentItem$2$5$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ MutableState<Player> $player$delegate;
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusVideoTypeKt$StatusVideoContentItem$2$5$1(boolean z10, MutableState<PlayerState> mutableState, MutableState<Player> mutableState2, ab.e<? super StatusVideoTypeKt$StatusVideoContentItem$2$5$1> eVar) {
        super(2, eVar);
        this.$isPlaying = z10;
        this.$playerState$delegate = mutableState;
        this.$player$delegate = mutableState2;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new StatusVideoTypeKt$StatusVideoContentItem$2$5$1(this.$isPlaying, this.$playerState$delegate, this.$player$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Player playerStatusVideoContentItem$lambda$8;
        Player playerStatusVideoContentItem$lambda$9;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        if (this.$isPlaying && !StatusVideoTypeKt.StatusVideoContentItem$lambda$5(this.$playerState$delegate).isPlaying() && StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate) != null && (playerStatusVideoContentItem$lambda$9 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate)) != null) {
            playerStatusVideoContentItem$lambda$9.play();
        }
        if (!this.$isPlaying && StatusVideoTypeKt.StatusVideoContentItem$lambda$5(this.$playerState$delegate).isPlaying() && StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate) != null && (playerStatusVideoContentItem$lambda$8 = StatusVideoTypeKt.StatusVideoContentItem$lambda$8(this.$player$delegate)) != null) {
            playerStatusVideoContentItem$lambda$8.pause();
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((StatusVideoTypeKt$StatusVideoContentItem$2$5$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
