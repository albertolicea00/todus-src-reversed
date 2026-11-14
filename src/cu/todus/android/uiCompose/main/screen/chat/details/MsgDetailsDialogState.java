package cu.todus.android.uiCompose.main.screen.chat.details;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/details/MsgDetailsDialogState;", "", "isLoading", "", "data", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "reactions", "", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "<init>", "(ZLcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;Ljava/util/List;)V", "()Z", "getData", "()Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "getReactions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MsgDetailsDialogState {
    public static final int $stable = 0;
    private final MessageWithPartnerWithRoomWithReactions data;
    private final boolean isLoading;
    private final List<ReactionWithPartner> reactions;

    public MsgDetailsDialogState() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgDetailsDialogState copy$default(MsgDetailsDialogState msgDetailsDialogState, boolean z10, MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = msgDetailsDialogState.isLoading;
        }
        if ((i10 & 2) != 0) {
            messageWithPartnerWithRoomWithReactions = msgDetailsDialogState.data;
        }
        if ((i10 & 4) != 0) {
            list = msgDetailsDialogState.reactions;
        }
        return msgDetailsDialogState.copy(z10, messageWithPartnerWithRoomWithReactions, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageWithPartnerWithRoomWithReactions getData() {
        return this.data;
    }

    public final List<ReactionWithPartner> component3() {
        return this.reactions;
    }

    public final MsgDetailsDialogState copy(boolean isLoading, MessageWithPartnerWithRoomWithReactions data, List<ReactionWithPartner> reactions) {
        kotlin.jvm.internal.y.i(reactions, "reactions");
        return new MsgDetailsDialogState(isLoading, data, reactions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgDetailsDialogState)) {
            return false;
        }
        MsgDetailsDialogState msgDetailsDialogState = (MsgDetailsDialogState) other;
        return this.isLoading == msgDetailsDialogState.isLoading && kotlin.jvm.internal.y.d(this.data, msgDetailsDialogState.data) && kotlin.jvm.internal.y.d(this.reactions, msgDetailsDialogState.reactions);
    }

    public final MessageWithPartnerWithRoomWithReactions getData() {
        return this.data;
    }

    public final List<ReactionWithPartner> getReactions() {
        return this.reactions;
    }

    public int hashCode() {
        int iA = androidx.camera.camera2.adapter.r.a(this.isLoading) * 31;
        MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions = this.data;
        return ((iA + (messageWithPartnerWithRoomWithReactions == null ? 0 : messageWithPartnerWithRoomWithReactions.hashCode())) * 31) + this.reactions.hashCode();
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "MsgDetailsDialogState(isLoading=" + this.isLoading + ", data=" + this.data + ", reactions=" + this.reactions + ")";
    }

    public MsgDetailsDialogState(boolean z10, MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, List<ReactionWithPartner> reactions) {
        kotlin.jvm.internal.y.i(reactions, "reactions");
        this.isLoading = z10;
        this.data = messageWithPartnerWithRoomWithReactions;
        this.reactions = reactions;
    }

    public /* synthetic */ MsgDetailsDialogState(boolean z10, MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, List list, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? null : messageWithPartnerWithRoomWithReactions, (i10 & 4) != 0 ? va.w.n() : list);
    }
}
