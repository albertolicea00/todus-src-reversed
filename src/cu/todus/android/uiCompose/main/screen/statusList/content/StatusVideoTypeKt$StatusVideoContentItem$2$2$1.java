package cu.todus.android.uiCompose.main.screen.statusList.content;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Player;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class StatusVideoTypeKt$StatusVideoContentItem$2$2$1 extends v implements Function2 {
    final /* synthetic */ MutableState<Player> $player$delegate;
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusVideoTypeKt$StatusVideoContentItem$2$2$1(MutableState<PlayerState> mutableState, MutableState<Player> mutableState2) {
        super(2, y.a.class, "updatePlayerState", "StatusVideoContentItem$updatePlayerState(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Lcu/z17/views/videoPlayer/PlayerState;Landroidx/media3/common/Player;)V", 0);
        this.$playerState$delegate = mutableState;
        this.$player$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PlayerState) obj, (Player) obj2);
        return k0.f43947a;
    }

    public final void invoke(PlayerState p10, Player p11) {
        y.i(p10, "p0");
        y.i(p11, "p1");
        StatusVideoTypeKt.StatusVideoContentItem$updatePlayerState(this.$playerState$delegate, this.$player$delegate, p10, p11);
    }
}
