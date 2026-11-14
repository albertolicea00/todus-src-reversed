package cu.todus.android.uiCompose.main.screen.chat.attachmentPreview;

import androidx.compose.runtime.MutableState;
import cu.z17.views.videoPlayer.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class VideoPreviewKt$PreviewVideoShowIn$1$1$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ MutableState<PlayerState> $playerState$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPreviewKt$PreviewVideoShowIn$1$1$1(MutableState<PlayerState> mutableState) {
        super(1, kotlin.jvm.internal.y.a.class, "onCurrentTimeChanged", "PreviewVideoShowIn$onCurrentTimeChanged(Landroidx/compose/runtime/MutableState;J)V", 0);
        this.$playerState$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return ua.k0.f43947a;
    }

    public final void invoke(long j10) {
        VideoPreviewKt.PreviewVideoShowIn$onCurrentTimeChanged(this.$playerState$delegate, j10);
    }
}
