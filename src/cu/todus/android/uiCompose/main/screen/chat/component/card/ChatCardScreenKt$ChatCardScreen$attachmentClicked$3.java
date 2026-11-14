package cu.todus.android.uiCompose.main.screen.chat.component.card;

import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatCardScreenKt$ChatCardScreen$attachmentClicked$3 extends kotlin.jvm.internal.v implements Function3 {
    public ChatCardScreenKt$ChatCardScreen$attachmentClicked$3(Object obj) {
        super(3, obj, ChatViewModel.class, "requestUserByContact", "requestUserByContact(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (String) obj3);
        return ua.k0.f43947a;
    }

    public final void invoke(String p10, String p11, String p12) {
        kotlin.jvm.internal.y.i(p10, "p0");
        kotlin.jvm.internal.y.i(p11, "p1");
        kotlin.jvm.internal.y.i(p12, "p2");
        ((ChatViewModel) this.receiver).requestUserByContact(p10, p11, p12);
    }
}
