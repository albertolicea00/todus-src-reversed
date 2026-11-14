package cu.todus.android.backup;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcu/todus/android/backup/RoomSaved;", "", "roomId", "", "msgList", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getRoomId", "()Ljava/lang/String;", "getMsgList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RoomSaved {
    public static final int $stable = 8;
    private final List<String> msgList;
    private final String roomId;

    public RoomSaved(String roomId, List<String> msgList) {
        y.i(roomId, "roomId");
        y.i(msgList, "msgList");
        this.roomId = roomId;
        this.msgList = msgList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomSaved copy$default(RoomSaved roomSaved, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = roomSaved.roomId;
        }
        if ((i10 & 2) != 0) {
            list = roomSaved.msgList;
        }
        return roomSaved.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    public final List<String> component2() {
        return this.msgList;
    }

    public final RoomSaved copy(String roomId, List<String> msgList) {
        y.i(roomId, "roomId");
        y.i(msgList, "msgList");
        return new RoomSaved(roomId, msgList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomSaved)) {
            return false;
        }
        RoomSaved roomSaved = (RoomSaved) other;
        return y.d(this.roomId, roomSaved.roomId) && y.d(this.msgList, roomSaved.msgList);
    }

    public final List<String> getMsgList() {
        return this.msgList;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (this.roomId.hashCode() * 31) + this.msgList.hashCode();
    }

    public String toString() {
        return "RoomSaved(roomId=" + this.roomId + ", msgList=" + this.msgList + ")";
    }
}
