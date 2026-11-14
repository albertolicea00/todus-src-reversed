package cu.z17.views.videoEditor;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.Player;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class Z17VideoEditorKt$Z17VideoEditor$1$1$5$1$1$1 extends v implements Function2 {
    final /* synthetic */ MutableState<Player> $player$delegate;
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17VideoEditorKt$Z17VideoEditor$1$1$5$1$1$1(MutableState<PlayerState> mutableState, MutableState<Player> mutableState2) {
        super(2, y.a.class, "updatePlayerState", "Z17VideoEditor$lambda$54$updatePlayerState(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Lcu/z17/views/videoPlayer/PlayerState;Landroidx/media3/common/Player;)V", 0);
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
        Z17VideoEditorKt.Z17VideoEditor$lambda$54$updatePlayerState(this.$playerState$delegate, this.$player$delegate, p10, p11);
    }
}
