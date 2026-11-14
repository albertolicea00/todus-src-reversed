package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(foreignKeys = {@ForeignKey(childColumns = {"roomId"}, entity = Room.class, onDelete = 5, parentColumns = {"id"})}, indices = {@Index({"roomId"})}, primaryKeys = {"userId", "roomId"}, tableName = UserRoomJoin.TABLE_NAME)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "", "userId", "", "roomId", UserRoomJoin.COLUMN_AFFILIATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getRoomId", "getAffiliation", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UserRoomJoin {
    public static final int $stable = 0;
    public static final String AFFILIATION_ADMIN = "admin";
    public static final String AFFILIATION_MEMBER = "member";
    public static final String AFFILIATION_NONE = "none";
    public static final String AFFILIATION_OWNER = "owner";
    public static final String COLUMN_AFFILIATION = "affiliation";
    public static final String COLUMN_ROOM_UID = "roomId";
    public static final String COLUMN_USER_ID = "userId";
    public static final String TABLE_NAME = "user_room_join";
    private final String affiliation;
    private final String roomId;
    private final String userId;

    public UserRoomJoin(String userId, String roomId, String affiliation) {
        y.i(userId, "userId");
        y.i(roomId, "roomId");
        y.i(affiliation, "affiliation");
        this.userId = userId;
        this.roomId = roomId;
        this.affiliation = affiliation;
    }

    public static /* synthetic */ UserRoomJoin copy$default(UserRoomJoin userRoomJoin, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userRoomJoin.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = userRoomJoin.roomId;
        }
        if ((i10 & 4) != 0) {
            str3 = userRoomJoin.affiliation;
        }
        return userRoomJoin.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAffiliation() {
        return this.affiliation;
    }

    public final UserRoomJoin copy(String userId, String roomId, String affiliation) {
        y.i(userId, "userId");
        y.i(roomId, "roomId");
        y.i(affiliation, "affiliation");
        return new UserRoomJoin(userId, roomId, affiliation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!y.d(UserRoomJoin.class, other != null ? other.getClass() : null)) {
            return false;
        }
        y.g(other, "null cannot be cast to non-null type cu.todus.android.data.db.entity.toDus.UserRoomJoin");
        UserRoomJoin userRoomJoin = (UserRoomJoin) other;
        if (y.d(this.userId, userRoomJoin.userId) && y.d(this.roomId, userRoomJoin.roomId)) {
            return y.d(this.affiliation, userRoomJoin.affiliation);
        }
        return false;
    }

    public final String getAffiliation() {
        return this.affiliation;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.roomId.hashCode()) * 31) + this.affiliation.hashCode();
    }

    public String toString() {
        return "UserRoomJoin(userId=" + this.userId + ", roomId=" + this.roomId + ", affiliation=" + this.affiliation + ")";
    }
}
