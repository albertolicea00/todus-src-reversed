package cu.todus.android.uiCompose.main.screen.statusList.content;

import androidx.compose.runtime.MutableState;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class StatusVideoTypeKt$StatusVideoContentItem$2$3$1 extends v implements Function1 {
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusVideoTypeKt$StatusVideoContentItem$2$3$1(MutableState<PlayerState> mutableState) {
        super(1, y.a.class, "onCurrentTimeChanged", "StatusVideoContentItem$onCurrentTimeChanged(Landroidx/compose/runtime/MutableState;J)V", 0);
        this.$playerState$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return k0.f43947a;
    }

    public final void invoke(long j10) {
        StatusVideoTypeKt.StatusVideoContentItem$onCurrentTimeChanged(this.$playerState$delegate, j10);
    }
}
