package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$3 extends kotlin.jvm.internal.v implements lb.a {
    public ChatP2PScreenKt$ChatP2PScreen$attachmentClicked$3(Object obj) {
        super(0, obj, ChatViewModel.class, "stopPlaying", "stopPlaying()V", 0);
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9881invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9881invoke() {
        ((ChatViewModel) this.receiver).stopPlaying();
    }
}
