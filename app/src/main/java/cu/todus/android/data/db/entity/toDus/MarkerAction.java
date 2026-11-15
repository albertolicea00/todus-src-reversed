package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;
import java.util.Objects;

/**
 * Room entity tracking XMPP chat marker / delivery-receipt actions on messages.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.MarkerAction
 */
@Immutable
@Entity(
        tableName = MarkerAction.TABLE_NAME,
        indices = {@Index({"msg"})},
        foreignKeys = {
                @ForeignKey(
                        entity = Message.class,
                        parentColumns = {"id"},
                        childColumns = {"msg"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public final class MarkerAction {

    public static final String TABLE_NAME = "marker";

    public static final String COLUMN_UID = "uid";
    public static final String COLUMN_MSG = "msg";
    public static final String COLUMN_ROOM = "room";
    public static final String COLUMN_MARKER = "marker";
    public static final String COLUMN_CREATE_AT = "createdAt";

    public static final int RECEIVED = 1;
    public static final int DISPLAYED = 2;
    public static final int ACKNOWLEDGED = 3;
    public static final int RECEIVED_FROM_TARGET = 4;
    public static final int READ_FROM_TARGET = 5;

    @PrimaryKey
    private final String uid;
    private final String msg;
    private final String room;
    private final int marker;
    private final long createdAt;

    public MarkerAction(String uid, String msg, String room, int marker) {
        this(uid, msg, room, marker, new Date().getTime());
    }

    public MarkerAction(String uid, String msg, String room, int marker, long createdAt) {
        this.uid = Objects.requireNonNull(uid, "uid");
        this.msg = Objects.requireNonNull(msg, "msg");
        this.room = Objects.requireNonNull(room, "room");
        this.marker = marker;
        this.createdAt = createdAt;
    }

    public String getUid() {
        return uid;
    }

    public String getMsg() {
        return msg;
    }

    public String getRoom() {
        return room;
    }

    public int getMarker() {
        return marker;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || MarkerAction.class != other.getClass()) {
            return false;
        }
        MarkerAction that = (MarkerAction) other;
        return marker == that.marker
                && Objects.equals(msg, that.msg)
                && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg, room, marker);
    }

    @Override
    public String toString() {
        return "MarkerAction(uid=" + uid
                + ", msg=" + msg
                + ", room=" + room
                + ", marker=" + marker
                + ", createdAt=" + createdAt + ")";
    }
}
