package cu.todus.android.uiCompose.main.screen.chat.component.card;

import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatCardScreenKt$ChatCardScreen$4$2$3$4$1 extends kotlin.jvm.internal.v implements Function1 {
    public ChatCardScreenKt$ChatCardScreen$4$2$3$4$1(Object obj) {
        super(1, obj, ChatViewModel.class, "loadLinkInfo", "loadLinkInfo(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageWithPartnerWithReactions) obj);
        return ua.k0.f43947a;
    }

    public final void invoke(MessageWithPartnerWithReactions p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        ((ChatViewModel) this.receiver).loadLinkInfo(p10);
    }
}
