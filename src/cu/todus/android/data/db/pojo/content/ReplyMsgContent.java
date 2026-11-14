package cu.todus.android.data.db.pojo.content;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0001HÆ\u0003J{\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0083\u0004J\n\u00100\u001a\u00020\nHÖ\u0081\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcu/todus/android/data/db/pojo/content/ReplyMsgContent;", "Lcu/todus/android/data/db/pojo/content/Content;", Room.COLUMN_LAST_MSG, "", "isMe", "", "shortMsg", "senderId", "senderAlias", "position", "", "msgDate", "", "found", "isStatus", "statusId", "statusContent", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZZLjava/lang/String;Lcu/todus/android/data/db/pojo/content/Content;)V", "getMsgId", "()Ljava/lang/String;", "()Z", "getShortMsg", "getSenderId", "getSenderAlias", "getPosition", "()I", "getMsgDate", "()J", "getFound", "getStatusId", "getStatusContent", "()Lcu/todus/android/data/db/pojo/content/Content;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ReplyMsgContent extends Content {
    public static final int $stable = 0;
    private final boolean found;
    private final boolean isMe;
    private final boolean isStatus;
    private final long msgDate;
    private final String msgId;
    private final int position;
    private final String senderAlias;
    private final String senderId;
    private final String shortMsg;
    private final Content statusContent;
    private final String statusId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyMsgContent(String msgId, boolean z10, String shortMsg, String senderId, String senderAlias, int i10, long j10, boolean z11, boolean z12, String str, Content content) {
        super(9);
        y.i(msgId, "msgId");
        y.i(shortMsg, "shortMsg");
        y.i(senderId, "senderId");
        y.i(senderAlias, "senderAlias");
        this.msgId = msgId;
        this.isMe = z10;
        this.shortMsg = shortMsg;
        this.senderId = senderId;
        this.senderAlias = senderAlias;
        this.position = i10;
        this.msgDate = j10;
        this.found = z11;
        this.isStatus = z12;
        this.statusId = str;
        this.statusContent = content;
    }

    public static /* synthetic */ ReplyMsgContent copy$default(ReplyMsgContent replyMsgContent, String str, boolean z10, String str2, String str3, String str4, int i10, long j10, boolean z11, boolean z12, String str5, Content content, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = replyMsgContent.msgId;
        }
        if ((i11 & 2) != 0) {
            z10 = replyMsgContent.isMe;
        }
        if ((i11 & 4) != 0) {
            str2 = replyMsgContent.shortMsg;
        }
        if ((i11 & 8) != 0) {
            str3 = replyMsgContent.senderId;
        }
        if ((i11 & 16) != 0) {
            str4 = replyMsgContent.senderAlias;
        }
        if ((i11 & 32) != 0) {
            i10 = replyMsgContent.position;
        }
        if ((i11 & 64) != 0) {
            j10 = replyMsgContent.msgDate;
        }
        if ((i11 & 128) != 0) {
            z11 = replyMsgContent.found;
        }
        if ((i11 & 256) != 0) {
            z12 = replyMsgContent.isStatus;
        }
        if ((i11 & 512) != 0) {
            str5 = replyMsgContent.statusId;
        }
        if ((i11 & 1024) != 0) {
            content = replyMsgContent.statusContent;
        }
        long j11 = j10;
        String str6 = str4;
        int i12 = i10;
        String str7 = str2;
        String str8 = str3;
        return replyMsgContent.copy(str, z10, str7, str8, str6, i12, j11, z11, z12, str5, content);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStatusId() {
        return this.statusId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Content getStatusContent() {
        return this.statusContent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getShortMsg() {
        return this.shortMsg;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSenderAlias() {
        return this.senderAlias;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getMsgDate() {
        return this.msgDate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getFound() {
        return this.found;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsStatus() {
        return this.isStatus;
    }

    public final ReplyMsgContent copy(String msgId, boolean isMe, String shortMsg, String senderId, String senderAlias, int position, long msgDate, boolean found, boolean isStatus, String statusId, Content statusContent) {
        y.i(msgId, "msgId");
        y.i(shortMsg, "shortMsg");
        y.i(senderId, "senderId");
        y.i(senderAlias, "senderAlias");
        return new ReplyMsgContent(msgId, isMe, shortMsg, senderId, senderAlias, position, msgDate, found, isStatus, statusId, statusContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplyMsgContent)) {
            return false;
        }
        ReplyMsgContent replyMsgContent = (ReplyMsgContent) other;
        return y.d(this.msgId, replyMsgContent.msgId) && this.isMe == replyMsgContent.isMe && y.d(this.shortMsg, replyMsgContent.shortMsg) && y.d(this.senderId, replyMsgContent.senderId) && y.d(this.senderAlias, replyMsgContent.senderAlias) && this.position == replyMsgContent.position && this.msgDate == replyMsgContent.msgDate && this.found == replyMsgContent.found && this.isStatus == replyMsgContent.isStatus && y.d(this.statusId, replyMsgContent.statusId) && y.d(this.statusContent, replyMsgContent.statusContent);
    }

    public final boolean getFound() {
        return this.found;
    }

    public final long getMsgDate() {
        return this.msgDate;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getSenderAlias() {
        return this.senderAlias;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final String getShortMsg() {
        return this.shortMsg;
    }

    public final Content getStatusContent() {
        return this.statusContent;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.msgId.hashCode() * 31) + r.a(this.isMe)) * 31) + this.shortMsg.hashCode()) * 31) + this.senderId.hashCode()) * 31) + this.senderAlias.hashCode()) * 31) + this.position) * 31) + l.a(this.msgDate)) * 31) + r.a(this.found)) * 31) + r.a(this.isStatus)) * 31;
        String str = this.statusId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Content content = this.statusContent;
        return iHashCode2 + (content != null ? content.hashCode() : 0);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean isStatus() {
        return this.isStatus;
    }

    public String toString() {
        return "ReplyMsgContent(msgId=" + this.msgId + ", isMe=" + this.isMe + ", shortMsg=" + this.shortMsg + ", senderId=" + this.senderId + ", senderAlias=" + this.senderAlias + ", position=" + this.position + ", msgDate=" + this.msgDate + ", found=" + this.found + ", isStatus=" + this.isStatus + ", statusId=" + this.statusId + ", statusContent=" + this.statusContent + ")";
    }

    public /* synthetic */ ReplyMsgContent(String str, boolean z10, String str2, String str3, String str4, int i10, long j10, boolean z11, boolean z12, String str5, Content content, int i11, p pVar) {
        this(str, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? "" : str3, (i11 & 16) == 0 ? str4 : "", (i11 & 32) != 0 ? -1 : i10, (i11 & 64) != 0 ? 0L : j10, (i11 & 128) != 0 ? false : z11, (i11 & 256) == 0 ? z12 : false, (i11 & 512) != 0 ? null : str5, (i11 & 1024) != 0 ? null : content);
    }
}
