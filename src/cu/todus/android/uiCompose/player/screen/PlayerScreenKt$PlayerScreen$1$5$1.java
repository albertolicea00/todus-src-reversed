package cu.todus.android.uiCompose.player.screen;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Player;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class PlayerScreenKt$PlayerScreen$1$5$1 extends kotlin.jvm.internal.v implements Function2 {
    final /* synthetic */ MutableState<Player> $player$delegate;
    final /* synthetic */ PlayerViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerScreenKt$PlayerScreen$1$5$1(PlayerViewModel playerViewModel, MutableState<Player> mutableState) {
        super(2, kotlin.jvm.internal.y.a.class, "updatePlayerState", "PlayerScreen$updatePlayerState(Lcu/todus/android/uiCompose/player/screen/PlayerViewModel;Landroidx/compose/runtime/MutableState;Lcu/z17/views/videoPlayer/PlayerState;Landroidx/media3/common/Player;)V", 0);
        this.$viewModel = playerViewModel;
        this.$player$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PlayerState) obj, (Player) obj2);
        return ua.k0.f43947a;
    }

    public final void invoke(PlayerState p10, Player p11) {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        PlayerScreenKt.PlayerScreen$updatePlayerState(this.$viewModel, this.$player$delegate, p10, p11);
    }
}
