package cu.todus.android.data.db.pojo.info;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcu/todus/android/data/db/pojo/info/RoomBannerPayload;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "roomName", "", "roomId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRoomName", "()Ljava/lang/String;", "getRoomId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RoomBannerPayload extends MessagePayload {
    public static final int $stable = 0;
    private final String roomId;
    private final String roomName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomBannerPayload(String roomName, String roomId) {
        super(MessagePayload.TYPE.ROOM_BANNER_PAYLOAD);
        y.i(roomName, "roomName");
        y.i(roomId, "roomId");
        this.roomName = roomName;
        this.roomId = roomId;
    }

    public static /* synthetic */ RoomBannerPayload copy$default(RoomBannerPayload roomBannerPayload, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = roomBannerPayload.roomName;
        }
        if ((i10 & 2) != 0) {
            str2 = roomBannerPayload.roomId;
        }
        return roomBannerPayload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoomName() {
        return this.roomName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    public final RoomBannerPayload copy(String roomName, String roomId) {
        y.i(roomName, "roomName");
        y.i(roomId, "roomId");
        return new RoomBannerPayload(roomName, roomId);
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomBannerPayload)) {
            return false;
        }
        RoomBannerPayload roomBannerPayload = (RoomBannerPayload) other;
        return y.d(this.roomName, roomBannerPayload.roomName) && y.d(this.roomId, roomBannerPayload.roomId);
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public int hashCode() {
        return (this.roomName.hashCode() * 31) + this.roomId.hashCode();
    }

    public String toString() {
        return "RoomBannerPayload(roomName=" + this.roomName + ", roomId=" + this.roomId + ")";
    }
}
