package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Room entity representing a chat message inside a {@link Room}.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Message
 */
@Immutable
@Entity(
        tableName = Message.TABLE_NAME,
        indices = {
                @Index({"id"}),
                @Index({"roomId"}),
                @Index(name = "messages_createAt_index", value = {"createAt"})
        },
        foreignKeys = {
                @ForeignKey(
                        entity = Room.class,
                        parentColumns = {"id"},
                        childColumns = {"roomId"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public final class Message {

    public static final String TABLE_NAME = "messages";

    public static final String COLUMN_UID = "id";
    public static final String COLUMN_ROOM = "roomId";
    public static final String COLUMN_USER_SENDER = "userSender";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_PAYLOAD = "payload";
    public static final String COLUMN_MESSAGE_ENTITIES = "messageEntities";
    public static final String COLUMN_MESSAGE_PUBL_ID = "publId";

    public static final int STATUS_RECEIVING_ATTACHMENT = -2;
    public static final int STATUS_PREPARING_ATTACHMENT = -1;
    public static final int STATUS_UNSENT = 0;
    public static final int STATUS_RECEIPT_FROM_SERVER = 1;
    public static final int STATUS_RECEIPT_FROM_TARGET = 2;
    public static final int STATUS_READ_FROM_TARGET = 3;
    public static final int STATUS_UNABLE_TO_SEND = 4;
    public static final int STATUS_SENTRY_UNSEND = 5;
    public static final int STATUS_SENTRY_SEND = 6;
    public static final int STATUS_TIMEOUT = 7;

    @PrimaryKey
    private final String id;
    private final String roomId;
    private final String userSender;
    private final String content;
    private final long createAt;
    private final int state;
    private final MessagePayload payload;
    private final List<MessageEntity> messageEntities;
    private final String publId;

    public Message(String roomId, String userSender, String content) {
        this("", roomId, userSender, content, new Date().getTime(), STATUS_UNSENT, null, Collections.emptyList(), null);
    }

    public Message(
            String id,
            String roomId,
            String userSender,
            String content,
            long createAt,
            int state,
            MessagePayload payload,
            List<? extends MessageEntity> messageEntities,
            String publId
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.roomId = Objects.requireNonNull(roomId, "roomId");
        this.userSender = Objects.requireNonNull(userSender, "userSender");
        this.content = Objects.requireNonNull(content, "content");
        this.createAt = createAt;
        this.state = state;
        this.payload = payload;
        this.messageEntities = new ArrayList<>(Objects.requireNonNull(messageEntities, "messageEntities"));
        this.publId = publId;
    }

    private Message(Builder builder) {
        this(
                builder.getId(),
                builder.getRoomId(),
                builder.getUserSender(),
                builder.getContent(),
                builder.getCreateAt(),
                builder.getState(),
                builder.getPayload(),
                builder.getMessageEntities(),
                builder.getPublId()
        );
    }

    public String getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getUserSender() {
        return userSender;
    }

    public String getContent() {
        return content;
    }

    public long getCreateAt() {
        return createAt;
    }

    public int getState() {
        return state;
    }

    public MessagePayload getPayload() {
        return payload;
    }

    public List<MessageEntity> getMessageEntities() {
        return Collections.unmodifiableList(messageEntities);
    }

    public String getPublId() {
        return publId;
    }

    public boolean available() {
        return state == STATUS_RECEIPT_FROM_TARGET || state == STATUS_READ_FROM_TARGET;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Message.class != other.getClass()) {
            return false;
        }
        Message that = (Message) other;
        return createAt == that.createAt
                && state == that.state
                && Objects.equals(id, that.id)
                && Objects.equals(roomId, that.roomId)
                && Objects.equals(userSender, that.userSender)
                && Objects.equals(content, that.content)
                && Objects.equals(payload, that.payload)
                && Objects.equals(messageEntities, that.messageEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, userSender, content, createAt, state, payload, messageEntities);
    }

    @Override
    public String toString() {
        return "Message(id=" + id
                + ", roomId=" + roomId
                + ", userSender=" + userSender
                + ", content=" + content
                + ", createAt=" + createAt
                + ", state=" + state
                + ", payload=" + payload
                + ", messageEntities=" + messageEntities
                + ", publId=" + publId + ")";
    }

    /**
     * Fluent builder for constructing {@link Message} instances.
     */
    public static final class Builder {

        private String id = UUID.randomUUID().toString();
        private String roomId;
        private String userSender = "";
        private String content = "";
        private long createAt = new Date().getTime();
        private int state;
        private MessagePayload payload;
        private List<? extends MessageEntity> messageEntities = Collections.emptyList();
        private String publId = "";

        public Builder id(String value) {
            this.id = Objects.requireNonNull(value, "value");
            return this;
        }

        public Builder roomId(String value) {
            this.roomId = Objects.requireNonNull(value, "value");
            return this;
        }

        public Builder userSender(String value) {
            this.userSender = Objects.requireNonNull(value, "value");
            return this;
        }

        public Builder content(String value) {
            this.content = Objects.requireNonNull(value, "value");
            return this;
        }

        public Builder createAt(long value) {
            this.createAt = value;
            return this;
        }

        public Builder state(int value) {
            this.state = value;
            return this;
        }

        public Builder messagePayload(MessagePayload messagePayload) {
            this.payload = messagePayload;
            return this;
        }

        public Builder messageEntities(List<? extends MessageEntity> entities) {
            this.messageEntities = Objects.requireNonNull(entities, "entities");
            return this;
        }

        public Builder publId(String value) {
            this.publId = value != null ? value : "";
            return this;
        }

        public String getId() {
            return id;
        }

        public String getRoomId() {
            if (roomId == null) {
                throw new IllegalStateException("roomId must be set");
            }
            return roomId;
        }

        public String getUserSender() {
            return userSender;
        }

        public String getContent() {
            return content;
        }

        public long getCreateAt() {
            return createAt;
        }

        public int getState() {
            return state;
        }

        public MessagePayload getPayload() {
            return payload;
        }

        public List<MessageEntity> getMessageEntities() {
            return Collections.unmodifiableList(messageEntities);
        }

        public String getPublId() {
            return publId;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
