package cu.todus.android.uiCompose.main.screen.chat.component.card;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatCardScreenKt$ChatCardScreen$4$3$5$1 extends kotlin.jvm.internal.v implements lb.a {
    final /* synthetic */ ChatParams $chatParams;
    final /* synthetic */ SnapshotStateList<MessageWithPartnerWithReactions> $selectedList;
    final /* synthetic */ ChatViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCardScreenKt$ChatCardScreen$4$3$5$1(ChatViewModel chatViewModel, ChatParams chatParams, SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        super(0, kotlin.jvm.internal.y.a.class, "onDeleteToAll", "ChatCardScreen$onDeleteToAll(Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;Lcu/todus/android/uiCompose/main/screen/chat/component/ChatParams;Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", 0);
        this.$viewModel = chatViewModel;
        this.$chatParams = chatParams;
        this.$selectedList = snapshotStateList;
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9861invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9861invoke() {
        ChatCardScreenKt.ChatCardScreen$onDeleteToAll(this.$viewModel, this.$chatParams, this.$selectedList);
    }
}
