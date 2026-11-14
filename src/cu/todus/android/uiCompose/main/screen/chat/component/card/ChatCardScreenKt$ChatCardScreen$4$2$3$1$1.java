package cu.todus.android.uiCompose.main.screen.chat.component.card;

import cu.todus.android.data.preferences.Owner;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatCardScreenKt$ChatCardScreen$4$2$3$1$1 extends kotlin.jvm.internal.v implements lb.a {
    public ChatCardScreenKt$ChatCardScreen$4$2$3$1$1(Object obj) {
        super(0, obj, ChatViewModel.class, "getOwner", "getOwner()Lcu/todus/android/data/preferences/Owner;", 0);
    }

    @Override // lb.a
    public final Owner invoke() {
        return ((ChatViewModel) this.receiver).getOwner();
    }
}
