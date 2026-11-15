package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import java.util.Objects;

/**
 * Room join entity linking a {@link User} to a {@link Room} with an affiliation role.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.UserRoomJoin
 */
@Immutable
@Entity(
        tableName = UserRoomJoin.TABLE_NAME,
        primaryKeys = {"userId", "roomId"},
        indices = {@Index({"roomId"})},
        foreignKeys = {
                @ForeignKey(
                        entity = Room.class,
                        parentColumns = {"id"},
                        childColumns = {"roomId"},
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public final class UserRoomJoin {

    public static final String TABLE_NAME = "user_room_join";

    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_ROOM_UID = "roomId";
    public static final String COLUMN_AFFILIATION = "affiliation";

    public static final String AFFILIATION_OWNER = "owner";
    public static final String AFFILIATION_ADMIN = "admin";
    public static final String AFFILIATION_MEMBER = "member";
    public static final String AFFILIATION_NONE = "none";

    private final String userId;
    private final String roomId;
    private final String affiliation;

    public UserRoomJoin(String userId, String roomId, String affiliation) {
        this.userId = Objects.requireNonNull(userId, "userId");
        this.roomId = Objects.requireNonNull(roomId, "roomId");
        this.affiliation = Objects.requireNonNull(affiliation, "affiliation");
    }

    public String getUserId() {
        return userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getAffiliation() {
        return affiliation;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || UserRoomJoin.class != other.getClass()) {
            return false;
        }
        UserRoomJoin that = (UserRoomJoin) other;
        return Objects.equals(userId, that.userId)
                && Objects.equals(roomId, that.roomId)
                && Objects.equals(affiliation, that.affiliation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roomId, affiliation);
    }

    @Override
    public String toString() {
        return "UserRoomJoin(userId=" + userId
                + ", roomId=" + roomId
                + ", affiliation=" + affiliation + ")";
    }
}
