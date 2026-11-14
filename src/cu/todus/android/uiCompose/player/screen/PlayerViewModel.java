package cu.todus.android.uiCompose.player.screen;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcu/todus/android/uiCompose/player/screen/PlayerViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "<set-?>", "Lcu/z17/views/videoPlayer/PlayerState;", "playerState", "getPlayerState", "()Lcu/z17/views/videoPlayer/PlayerState;", "setPlayerState", "(Lcu/z17/views/videoPlayer/PlayerState;)V", "playerState$delegate", "Landroidx/compose/runtime/MutableState;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayerViewModel extends ToDusViewModel {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: playerState$delegate, reason: from kotlin metadata */
    private final MutableState playerState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PlayerState(false, false, false, false, 0, 0, 0, 0, null, null, null, null, 4095, null), null, 2, null);

    /* JADX WARN: Multi-variable type inference failed */
    public final PlayerState getPlayerState() {
        return (PlayerState) this.playerState.getValue();
    }

    public final void setPlayerState(PlayerState playerState) {
        kotlin.jvm.internal.y.i(playerState, "<set-?>");
        this.playerState.setValue(playerState);
    }
}
