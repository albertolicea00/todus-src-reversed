package cu.todus.android.uiCompose.call.screen.video;

import android.content.Context;
import cu.todus.android.uiCompose.call.screen.call.VideoCallViewModel;
import kotlin.Metadata;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class VideoCallScreenKt$VideoCallScreen$3$6$1 extends kotlin.jvm.internal.v implements lb.a {
    final /* synthetic */ Context $context;
    final /* synthetic */ VideoCallViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallScreenKt$VideoCallScreen$3$6$1(Context context, VideoCallViewModel videoCallViewModel) {
        super(0, kotlin.jvm.internal.y.a.class, "endCall", "VideoCallScreen$endCall(Landroid/content/Context;Lcu/todus/android/uiCompose/call/screen/call/VideoCallViewModel;)V", 0);
        this.$context = context;
        this.$viewModel = videoCallViewModel;
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9829invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9829invoke() {
        VideoCallScreenKt.VideoCallScreen$endCall(this.$context, this.$viewModel);
    }
}
