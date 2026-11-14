package cu.todus.android.uiCompose.call.screen.audio;

import android.content.Context;
import cu.todus.android.uiCompose.call.screen.call.AudioCallViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class AudioCallScreenKt$AudioCallScreen$3$5$1 extends v implements lb.a {
    final /* synthetic */ Context $context;
    final /* synthetic */ AudioCallViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioCallScreenKt$AudioCallScreen$3$5$1(Context context, AudioCallViewModel audioCallViewModel) {
        super(0, y.a.class, "endCall", "AudioCallScreen$endCall(Landroid/content/Context;Lcu/todus/android/uiCompose/call/screen/call/AudioCallViewModel;)V", 0);
        this.$context = context;
        this.$viewModel = audioCallViewModel;
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9809invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9809invoke() {
        AudioCallScreenKt.AudioCallScreen$endCall(this.$context, this.$viewModel);
    }
}
