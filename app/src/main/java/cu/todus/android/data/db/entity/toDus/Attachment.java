package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.pojo.content.Content;
import java.util.Objects;

/**
 * Room entity representing a media or payload attachment bound to a {@link Message}.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Attachment
 */
@Immutable
@Entity(
        tableName = Attachment.TABLE_NAME,
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
public final class Attachment {

    public static final String TABLE_NAME = "attachments";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MSG = "msg";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PERSISTENT = "persistent";

    public static final int NOT_UPLOADED = 0;
    public static final int UPLOADING = 1;
    public static final int UPLOADED = 2;
    public static final int UPLOAD_CANCELED = 3;
    public static final int NOT_DOWNLOAD = 4;
    public static final int DOWNLOADING = 5;
    public static final int DOWNLOADED = 6;
    public static final int DOWNLOAD_CANCELED = 7;

    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_VOICE = 4;
    public static final int TYPE_FILE = 5;
    public static final int TYPE_CONTACT = 6;
    public static final int TYPE_GIF = 7;
    public static final int TYPE_EVENT = 8;
    public static final int TYPE_REPLY = 9;
    public static final int TYPE_LOCATION = 10;
    public static final int TYPE_EMOJI = 11;
    public static final int TYPE_STICKER = 13;
    public static final int TYPE_FORWARDED = 14;
    public static final int TYPE_EDITED = 15;
    public static final int TYPE_DELETED = 16;
    public static final int TYPE_LINK_INFO = 20;
    public static final int TYPE_BUTTON = 21;
    public static final int TYPE_STATUS_EXISTENCE = 22;
    public static final int TYPE_REACTION = 23;
    public static final int TYPE_PUB_EDITED = 24;
    public static final int TYPE_PUB_DELETED = 25;
    public static final int TYPE_STATUS_CONTENT_TEXT = 26;
    public static final int TYPE_STATUS_CONTENT_IMAGE = 27;
    public static final int TYPE_REFRESH_TODUS_ID = 28;
    public static final int TYPE_DELETE_OWNER_MSG = 29;
    public static final int TYPE_STATUS_CONTENT_VIDEO = 30;
    public static final int TYPE_STREAM_VIDEO = 31;
    public static final int TYPE_CALL = 32;

    @PrimaryKey
    private final String id;
    private final String msg;
    private final Content content;
    private final int state;
    private final int type;
    private final boolean persistent;

    public Attachment(String id, String msg, Content content, int state) {
        this(id, msg, content, state, TYPE_FILE, false);
    }

    public Attachment(
            String id,
            String msg,
            Content content,
            int state,
            int type,
            boolean persistent
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.msg = Objects.requireNonNull(msg, "msg");
        this.content = Objects.requireNonNull(content, "content");
        this.state = state;
        this.type = type;
        this.persistent = persistent;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Content getContent() {
        return content;
    }

    public int getState() {
        return state;
    }

    public int getType() {
        return type;
    }

    public boolean getPersistent() {
        return persistent;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attachment)) {
            return false;
        }
        Attachment that = (Attachment) other;
        return state == that.state
                && type == that.type
                && persistent == that.persistent
                && Objects.equals(id, that.id)
                && Objects.equals(msg, that.msg)
                && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msg, content, state, type, persistent);
    }

    @Override
    public String toString() {
        return id + " " + msg + " " + state + " " + content;
    }
}
