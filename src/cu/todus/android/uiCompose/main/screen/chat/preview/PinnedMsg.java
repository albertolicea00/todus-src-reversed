package cu.todus.android.uiCompose.main.screen.chat.preview;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/preview/PinnedMsg;", "", Room.COLUMN_LAST_MSG, "", "shortMsg", "position", "", "msgDate", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "getMsgId", "()Ljava/lang/String;", "getShortMsg", "getPosition", "()I", "getMsgDate", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PinnedMsg {
    public static final int $stable = 0;
    private final long msgDate;
    private final String msgId;
    private final int position;
    private final String shortMsg;

    public PinnedMsg(String msgId, String shortMsg, int i10, long j10) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(shortMsg, "shortMsg");
        this.msgId = msgId;
        this.shortMsg = shortMsg;
        this.position = i10;
        this.msgDate = j10;
    }

    public static /* synthetic */ PinnedMsg copy$default(PinnedMsg pinnedMsg, String str, String str2, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pinnedMsg.msgId;
        }
        if ((i11 & 2) != 0) {
            str2 = pinnedMsg.shortMsg;
        }
        if ((i11 & 4) != 0) {
            i10 = pinnedMsg.position;
        }
        if ((i11 & 8) != 0) {
            j10 = pinnedMsg.msgDate;
        }
        int i12 = i10;
        return pinnedMsg.copy(str, str2, i12, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShortMsg() {
        return this.shortMsg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMsgDate() {
        return this.msgDate;
    }

    public final PinnedMsg copy(String msgId, String shortMsg, int position, long msgDate) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        kotlin.jvm.internal.y.i(shortMsg, "shortMsg");
        return new PinnedMsg(msgId, shortMsg, position, msgDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PinnedMsg)) {
            return false;
        }
        PinnedMsg pinnedMsg = (PinnedMsg) other;
        return kotlin.jvm.internal.y.d(this.msgId, pinnedMsg.msgId) && kotlin.jvm.internal.y.d(this.shortMsg, pinnedMsg.shortMsg) && this.position == pinnedMsg.position && this.msgDate == pinnedMsg.msgDate;
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

    public final String getShortMsg() {
        return this.shortMsg;
    }

    public int hashCode() {
        return (((((this.msgId.hashCode() * 31) + this.shortMsg.hashCode()) * 31) + this.position) * 31) + defpackage.l.a(this.msgDate);
    }

    public String toString() {
        return "PinnedMsg(msgId=" + this.msgId + ", shortMsg=" + this.shortMsg + ", position=" + this.position + ", msgDate=" + this.msgDate + ")";
    }

    public /* synthetic */ PinnedMsg(String str, String str2, int i10, long j10, int i11, kotlin.jvm.internal.p pVar) {
        this(str, str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? 0L : j10);
    }
}
