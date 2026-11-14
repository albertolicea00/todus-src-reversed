package cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.PreviewChannelScreenKt$PreviewChannelScreen$2$10$1", f = "PreviewChannelScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class PreviewChannelScreenKt$PreviewChannelScreen$2$10$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ String $uid;
    final /* synthetic */ PreviewChannelViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewChannelScreenKt$PreviewChannelScreen$2$10$1(PreviewChannelViewModel previewChannelViewModel, String str, MutableState<Boolean> mutableState, ab.e<? super PreviewChannelScreenKt$PreviewChannelScreen$2$10$1> eVar) {
        super(2, eVar);
        this.$viewModel = previewChannelViewModel;
        this.$uid = str;
        this.$isLoading$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invokeSuspend$lambda$0(MutableState mutableState) {
        PreviewChannelScreenKt.PreviewChannelScreen$lambda$7(mutableState, false);
        return ua.k0.f43947a;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new PreviewChannelScreenKt$PreviewChannelScreen$2$10$1(this.$viewModel, this.$uid, this.$isLoading$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        PreviewChannelViewModel previewChannelViewModel = this.$viewModel;
        String str = this.$uid;
        final MutableState<Boolean> mutableState = this.$isLoading$delegate;
        previewChannelViewModel.loadPreviewChannel(str, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chatPreview.previewChannel.m0
            @Override // lb.a
            public final Object invoke() {
                return PreviewChannelScreenKt$PreviewChannelScreen$2$10$1.invokeSuspend$lambda$0(mutableState);
            }
        });
        this.$viewModel.loadAdminChannels(this.$uid);
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((PreviewChannelScreenKt$PreviewChannelScreen$2$10$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
