package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;
import java.util.Objects;

/**
 * Room entity representing an emoji reaction on a message or status.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Reaction
 */
@Immutable
@Entity(tableName = Reaction.TABLE_NAME)
public final class Reaction {

    public static final String TABLE_NAME = "reaction";

    public static final String COLUMN_REACTION_ID = "id";
    public static final String COLUMN_ENTITY = "entity";
    public static final String COLUMN_REACTION_USER_ID = "userId";
    public static final String COLUMN_ROOM_ID = "roomId";
    public static final String COLUMN_REACTION_STATE = "reactionState";
    public static final String COLUMN_CREATED_AT = "createdAt";

    public static final int REACTION_SENT = 0;
    public static final int REACTION_UNSENT = 1;
    public static final int REACTION_RECEIVED = 2;

    @PrimaryKey
    private final String id;
    private final String entity;
    private final String userId;
    private final String roomId;
    private final String reactionContent;
    private final int reactionState;
    private final long createdAt;

    public Reaction(
            String id,
            String entity,
            String userId,
            String roomId,
            String reactionContent
    ) {
        this(id, entity, userId, roomId, reactionContent, REACTION_UNSENT, new Date().getTime());
    }

    public Reaction(
            String id,
            String entity,
            String userId,
            String roomId,
            String reactionContent,
            int reactionState,
            long createdAt
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.entity = Objects.requireNonNull(entity, "entity");
        this.userId = Objects.requireNonNull(userId, "userId");
        this.roomId = Objects.requireNonNull(roomId, "roomId");
        this.reactionContent = Objects.requireNonNull(reactionContent, "reactionContent");
        this.reactionState = reactionState;
        this.createdAt = createdAt;
    }

    public static String buildId(String entity, String ownerId) {
        Objects.requireNonNull(entity, "entity");
        Objects.requireNonNull(ownerId, "ownerId");
        return "reaction_" + entity + "_" + ownerId;
    }

    public static boolean checkIfIsForStatus(String reactionId) {
        Objects.requireNonNull(reactionId, "reactionId");
        return reactionId.startsWith("reaction_status");
    }

    public String getId() {
        return id;
    }

    public String getEntity() {
        return entity;
    }

    public String getUserId() {
        return userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getReactionContent() {
        return reactionContent;
    }

    public int getReactionState() {
        return reactionState;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reaction)) {
            return false;
        }
        Reaction that = (Reaction) other;
        return reactionState == that.reactionState
                && createdAt == that.createdAt
                && Objects.equals(id, that.id)
                && Objects.equals(entity, that.entity)
                && Objects.equals(userId, that.userId)
                && Objects.equals(roomId, that.roomId)
                && Objects.equals(reactionContent, that.reactionContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entity, userId, roomId, reactionContent, reactionState, createdAt);
    }

    @Override
    public String toString() {
        return "Reaction(id=" + id
                + ", entity=" + entity
                + ", userId=" + userId
                + ", roomId=" + roomId
                + ", reactionContent=" + reactionContent
                + ", reactionState=" + reactionState
                + ", createdAt=" + createdAt + ")";
    }
}
