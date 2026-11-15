package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Room entity representing an ephemeral user status post (text, image, or video).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Status
 */
@Immutable
@Entity(tableName = Status.TABLE_NAME)
public final class Status {

    public static final String TABLE_NAME = "status";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CREATOR_ID = "creatorId";
    public static final String COLUMN_REPLIED_ID = "repliedId";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_IS_PUBLIC = "isPublic";
    public static final String COLUMN_IS_DELETED = "isDelete";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_SEEN = "seen";
    public static final String COLUMN_CLOSED = "closed";
    public static final String COLUMN_UPLOAD_STATE = "uploadState";
    public static final String COLUMN_VIEW_COUNT = "viewCount";
    public static final String COLUMN_INTERACT_COUNT = "interactCount";
    public static final String COLUMN_SHARE_COUNT = "interactCount";

    public static final int STATUS_SENT = 0;
    public static final int STATUS_UNSENT = 1;
    public static final int STATUS_PREPARING_ATTACHMENTS = 2;
    public static final int STATUS_WITH_ERROR = 3;
    public static final int STATUS_UPLOADING = 4;
    public static final int STATUS_WAITING_PROCESS = 5;
    public static final int STATUS_RECEIVED = 6;
    public static final int STATUS_EXISTENCE_UNREQUESTED = 7;

    public static final String TEXT_TYPE = "text_type";
    public static final String IMG_TYPE = "img_type";
    public static final String VIDEO_TYPE = "video_type";

    @PrimaryKey
    private final String id;
    private final String creatorId;
    private final String repliedId;
    private final long createdAt;
    private final boolean isPublic;
    private final boolean isDelete;
    private final boolean canRespond;
    private final String type;
    private final Content content;
    private final boolean seen;
    private final boolean closed;
    private final List<MessageEntity> messageEntities;
    private final int uploadState;
    private final String location;
    private final int viewCount;
    private final int interactCount;
    private final int shareCount;

    public Status(
            String id,
            String creatorId,
            String repliedId,
            boolean isPublic,
            boolean isDelete,
            boolean canRespond,
            String type,
            Content content,
            String location
    ) {
        this(
                id,
                creatorId,
                repliedId,
                new Date().getTime(),
                isPublic,
                isDelete,
                canRespond,
                type,
                content,
                true,
                true,
                Collections.emptyList(),
                STATUS_UNSENT,
                location,
                0,
                0,
                0
        );
    }

    public Status(
            String id,
            String creatorId,
            String repliedId,
            long createdAt,
            boolean isPublic,
            boolean isDelete,
            boolean canRespond,
            String type,
            Content content,
            boolean seen,
            boolean closed,
            List<? extends MessageEntity> messageEntities,
            int uploadState,
            String location,
            int viewCount,
            int interactCount,
            int shareCount
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.creatorId = Objects.requireNonNull(creatorId, "creatorId");
        this.repliedId = Objects.requireNonNull(repliedId, "repliedId");
        this.createdAt = createdAt;
        this.isPublic = isPublic;
        this.isDelete = isDelete;
        this.canRespond = canRespond;
        this.type = Objects.requireNonNull(type, "type");
        this.content = Objects.requireNonNull(content, "content");
        this.seen = seen;
        this.closed = closed;
        this.messageEntities = new ArrayList<>(Objects.requireNonNull(messageEntities, "messageEntities"));
        this.uploadState = uploadState;
        this.location = Objects.requireNonNull(location, "location");
        this.viewCount = viewCount;
        this.interactCount = interactCount;
        this.shareCount = shareCount;
    }

    public static String buildId(String ownerId, boolean isVideo) {
        Objects.requireNonNull(ownerId, "ownerId");
        return "status_" + (isVideo ? "stream" : "") + "_" + ownerId + "_" + UUID.randomUUID();
    }

    public static boolean checkIfIsForStatus(String reactionId) {
        Objects.requireNonNull(reactionId, "reactionId");
        return reactionId.startsWith("status_");
    }

    public String getId() {
        return id;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getRepliedId() {
        return repliedId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public boolean getCanRespond() {
        return canRespond;
    }

    public String getType() {
        return type;
    }

    public Content getContent() {
        return content;
    }

    public boolean getSeen() {
        return seen;
    }

    public boolean getClosed() {
        return closed;
    }

    public List<MessageEntity> getMessageEntities() {
        return Collections.unmodifiableList(messageEntities);
    }

    public int getUploadState() {
        return uploadState;
    }

    public String getLocation() {
        return location;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getInteractCount() {
        return interactCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public String getTextContent() {
        if (content instanceof StatusVideoContent) {
            String text = ((StatusVideoContent) content).getTextContent();
            return text != null && !text.trim().isEmpty() ? text : null;
        }
        if (content instanceof StatusImageContent) {
            String text = ((StatusImageContent) content).getTextContent();
            return text != null && !text.trim().isEmpty() ? text : null;
        }
        return null;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Status)) {
            return false;
        }
        Status that = (Status) other;
        return createdAt == that.createdAt
                && isPublic == that.isPublic
                && isDelete == that.isDelete
                && canRespond == that.canRespond
                && seen == that.seen
                && closed == that.closed
                && uploadState == that.uploadState
                && viewCount == that.viewCount
                && interactCount == that.interactCount
                && shareCount == that.shareCount
                && Objects.equals(id, that.id)
                && Objects.equals(creatorId, that.creatorId)
                && Objects.equals(repliedId, that.repliedId)
                && Objects.equals(type, that.type)
                && Objects.equals(content, that.content)
                && Objects.equals(messageEntities, that.messageEntities)
                && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                creatorId,
                repliedId,
                createdAt,
                isPublic,
                isDelete,
                canRespond,
                type,
                content,
                seen,
                closed,
                messageEntities,
                uploadState,
                location,
                viewCount,
                interactCount,
                shareCount
        );
    }

    @Override
    public String toString() {
        return "Status(id=" + id
                + ", creatorId=" + creatorId
                + ", repliedId=" + repliedId
                + ", createdAt=" + createdAt
                + ", isPublic=" + isPublic
                + ", isDelete=" + isDelete
                + ", canRespond=" + canRespond
                + ", type=" + type
                + ", content=" + content
                + ", seen=" + seen
                + ", closed=" + closed
                + ", messageEntities=" + messageEntities
                + ", uploadState=" + uploadState
                + ", location=" + location
                + ", viewCount=" + viewCount
                + ", interactCount=" + interactCount
                + ", shareCount=" + shareCount + ")";
    }
}
