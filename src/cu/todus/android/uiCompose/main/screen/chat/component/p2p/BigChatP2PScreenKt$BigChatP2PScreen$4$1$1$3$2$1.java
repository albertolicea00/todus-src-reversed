package cu.todus.android.uiCompose.main.screen.chat.component.p2p;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class BigChatP2PScreenKt$BigChatP2PScreen$4$1$1$3$2$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ SnapshotStateList<MessageWithPartnerWithReactions> $selectedList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigChatP2PScreenKt$BigChatP2PScreen$4$1$1$3$2$1(SnapshotStateList<MessageWithPartnerWithReactions> snapshotStateList) {
        super(1, kotlin.jvm.internal.y.a.class, "selectedContains", "BigChatP2PScreen$selectedContains(Landroidx/compose/runtime/snapshots/SnapshotStateList;Ljava/lang/String;)Z", 0);
        this.$selectedList = snapshotStateList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(String p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        return Boolean.valueOf(BigChatP2PScreenKt.BigChatP2PScreen$selectedContains(this.$selectedList, p10));
    }
}
