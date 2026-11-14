package cu.todus.android.uiCompose.main.screen.dateEditor;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/dateEditor/DateEditorParams;", "", "roomId", "", "replyMsgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRoomId", "()Ljava/lang/String;", "getReplyMsgId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DateEditorParams {
    public static final int $stable = 0;
    private final String replyMsgId;
    private final String roomId;

    /* JADX WARN: Multi-variable type inference failed */
    public DateEditorParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DateEditorParams copy$default(DateEditorParams dateEditorParams, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dateEditorParams.roomId;
        }
        if ((i10 & 2) != 0) {
            str2 = dateEditorParams.replyMsgId;
        }
        return dateEditorParams.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReplyMsgId() {
        return this.replyMsgId;
    }

    public final DateEditorParams copy(String roomId, String replyMsgId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new DateEditorParams(roomId, replyMsgId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateEditorParams)) {
            return false;
        }
        DateEditorParams dateEditorParams = (DateEditorParams) other;
        return kotlin.jvm.internal.y.d(this.roomId, dateEditorParams.roomId) && kotlin.jvm.internal.y.d(this.replyMsgId, dateEditorParams.replyMsgId);
    }

    public final String getReplyMsgId() {
        return this.replyMsgId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        int iHashCode = this.roomId.hashCode() * 31;
        String str = this.replyMsgId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DateEditorParams(roomId=" + this.roomId + ", replyMsgId=" + this.replyMsgId + ")";
    }

    public DateEditorParams(String roomId, String str) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        this.roomId = roomId;
        this.replyMsgId = str;
    }

    public /* synthetic */ DateEditorParams(String str, String str2, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : str2);
    }
}
