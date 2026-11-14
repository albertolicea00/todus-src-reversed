package cu.todus.android.uiCompose.player.screen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class PlayerScreenKt$PlayerScreen$1$6$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ PlayerViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerScreenKt$PlayerScreen$1$6$1(PlayerViewModel playerViewModel) {
        super(1, kotlin.jvm.internal.y.a.class, "onRotate", "PlayerScreen$onRotate(Lcu/todus/android/uiCompose/player/screen/PlayerViewModel;Z)V", 0);
        this.$viewModel = playerViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return ua.k0.f43947a;
    }

    public final void invoke(boolean z10) {
        PlayerScreenKt.PlayerScreen$onRotate(this.$viewModel, z10);
    }
}
