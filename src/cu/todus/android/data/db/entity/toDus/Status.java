package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import defpackage.l;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = "status")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b4\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0001HB¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u00101\u001a\u0004\u0018\u00010\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u0010>\u001a\u00020\u0015HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0015HÆ\u0003J\t\u0010A\u001a\u00020\u0015HÆ\u0003J\t\u0010B\u001a\u00020\u0015HÆ\u0003J¹\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015HÆ\u0001J\u0014\u0010D\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010F\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010G\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0011\u0010\u0019\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,¨\u0006I"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Status;", "", "id", "", Status.COLUMN_CREATOR_ID, Status.COLUMN_REPLIED_ID, "createdAt", "", "isPublic", "", Status.COLUMN_IS_DELETED, "canRespond", "type", "content", "Lcu/todus/android/data/db/pojo/content/Content;", Status.COLUMN_SEEN, Status.COLUMN_CLOSED, Message.COLUMN_MESSAGE_ENTITIES, "", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", Status.COLUMN_UPLOAD_STATE, "", "location", Status.COLUMN_VIEW_COUNT, "interactCount", "shareCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZZLjava/lang/String;Lcu/todus/android/data/db/pojo/content/Content;ZZLjava/util/List;ILjava/lang/String;III)V", "getId", "()Ljava/lang/String;", "getCreatorId", "getRepliedId", "getCreatedAt", "()J", "()Z", "getCanRespond", "getType", "getContent", "()Lcu/todus/android/data/db/pojo/content/Content;", "getSeen", "getClosed", "getMessageEntities", "()Ljava/util/List;", "getUploadState", "()I", "getLocation", "getViewCount", "getInteractCount", "getShareCount", "getTextContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Status {
    public static final int $stable = 0;
    public static final String COLUMN_CLOSED = "closed";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_CREATOR_ID = "creatorId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_INTERACT_COUNT = "interactCount";
    public static final String COLUMN_IS_DELETED = "isDelete";
    public static final String COLUMN_IS_PUBLIC = "isPublic";
    public static final String COLUMN_REPLIED_ID = "repliedId";
    public static final String COLUMN_SEEN = "seen";
    public static final String COLUMN_SHARE_COUNT = "interactCount";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UPLOAD_STATE = "uploadState";
    public static final String COLUMN_VIEW_COUNT = "viewCount";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IMG_TYPE = "img_type";
    public static final int STATUS_EXISTENCE_UNREQUESTED = 7;
    public static final int STATUS_PREPARING_ATTACHMENTS = 2;
    public static final int STATUS_RECEIVED = 6;
    public static final int STATUS_SENT = 0;
    public static final int STATUS_UNSENT = 1;
    public static final int STATUS_UPLOADING = 4;
    public static final int STATUS_WAITING_PROCESS = 5;
    public static final int STATUS_WITH_ERROR = 3;
    public static final String TABLE_NAME = "status";
    public static final String TEXT_TYPE = "text_type";
    public static final String VIDEO_TYPE = "video_type";
    private final boolean canRespond;
    private final boolean closed;
    private final Content content;
    private final long createdAt;
    private final String creatorId;

    @PrimaryKey
    private final String id;
    private final int interactCount;
    private final boolean isDelete;
    private final boolean isPublic;
    private final String location;
    private final List<MessageEntity> messageEntities;
    private final String repliedId;
    private final boolean seen;
    private final int shareCount;
    private final String type;
    private final int uploadState;
    private final int viewCount;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Status$Companion;", "", "<init>", "()V", "TABLE_NAME", "", "COLUMN_ID", "COLUMN_CREATOR_ID", "COLUMN_REPLIED_ID", "COLUMN_CREATED_AT", "COLUMN_IS_PUBLIC", "COLUMN_IS_DELETED", "COLUMN_TYPE", "COLUMN_CONTENT", "COLUMN_SEEN", "COLUMN_CLOSED", "COLUMN_UPLOAD_STATE", "COLUMN_VIEW_COUNT", "COLUMN_INTERACT_COUNT", "COLUMN_SHARE_COUNT", "STATUS_SENT", "", "STATUS_UNSENT", "STATUS_PREPARING_ATTACHMENTS", "STATUS_WITH_ERROR", "STATUS_UPLOADING", "STATUS_WAITING_PROCESS", "STATUS_RECEIVED", "STATUS_EXISTENCE_UNREQUESTED", "TEXT_TYPE", "IMG_TYPE", "VIDEO_TYPE", "buildId", "ownerId", "isVideo", "", "checkIfIsForStatus", "reactionId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String buildId(String ownerId, boolean isVideo) {
            y.i(ownerId, "ownerId");
            return "status_" + (isVideo ? "stream" : "") + "_" + ownerId + "_" + UUID.randomUUID();
        }

        public final boolean checkIfIsForStatus(String reactionId) {
            y.i(reactionId, "reactionId");
            return a0.U(reactionId, "status_", false, 2, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Status(String id2, String creatorId, String repliedId, long j10, boolean z10, boolean z11, boolean z12, String type, Content content, boolean z13, boolean z14, List<? extends MessageEntity> messageEntities, int i10, String location, int i11, int i12, int i13) {
        y.i(id2, "id");
        y.i(creatorId, "creatorId");
        y.i(repliedId, "repliedId");
        y.i(type, "type");
        y.i(content, "content");
        y.i(messageEntities, "messageEntities");
        y.i(location, "location");
        this.id = id2;
        this.creatorId = creatorId;
        this.repliedId = repliedId;
        this.createdAt = j10;
        this.isPublic = z10;
        this.isDelete = z11;
        this.canRespond = z12;
        this.type = type;
        this.content = content;
        this.seen = z13;
        this.closed = z14;
        this.messageEntities = messageEntities;
        this.uploadState = i10;
        this.location = location;
        this.viewCount = i11;
        this.interactCount = i12;
        this.shareCount = i13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Status copy$default(Status status, String str, String str2, String str3, long j10, boolean z10, boolean z11, boolean z12, String str4, Content content, boolean z13, boolean z14, List list, int i10, String str5, int i11, int i12, int i13, int i14, Object obj) {
        int i15;
        int i16;
        String str6 = (i14 & 1) != 0 ? status.id : str;
        String str7 = (i14 & 2) != 0 ? status.creatorId : str2;
        String str8 = (i14 & 4) != 0 ? status.repliedId : str3;
        long j11 = (i14 & 8) != 0 ? status.createdAt : j10;
        boolean z15 = (i14 & 16) != 0 ? status.isPublic : z10;
        boolean z16 = (i14 & 32) != 0 ? status.isDelete : z11;
        boolean z17 = (i14 & 64) != 0 ? status.canRespond : z12;
        String str9 = (i14 & 128) != 0 ? status.type : str4;
        Content content2 = (i14 & 256) != 0 ? status.content : content;
        boolean z18 = (i14 & 512) != 0 ? status.seen : z13;
        boolean z19 = (i14 & 1024) != 0 ? status.closed : z14;
        List list2 = (i14 & 2048) != 0 ? status.messageEntities : list;
        int i17 = (i14 & 4096) != 0 ? status.uploadState : i10;
        String str10 = str6;
        String str11 = (i14 & 8192) != 0 ? status.location : str5;
        int i18 = (i14 & 16384) != 0 ? status.viewCount : i11;
        int i19 = (i14 & 32768) != 0 ? status.interactCount : i12;
        if ((i14 & 65536) != 0) {
            i16 = i19;
            i15 = status.shareCount;
        } else {
            i15 = i13;
            i16 = i19;
        }
        return status.copy(str10, str7, str8, j11, z15, z16, z17, str9, content2, z18, z19, list2, i17, str11, i18, i16, i15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getSeen() {
        return this.seen;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getClosed() {
        return this.closed;
    }

    public final List<MessageEntity> component12() {
        return this.messageEntities;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getUploadState() {
        return this.uploadState;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getViewCount() {
        return this.viewCount;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getInteractCount() {
        return this.interactCount;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getShareCount() {
        return this.shareCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRepliedId() {
        return this.repliedId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsDelete() {
        return this.isDelete;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanRespond() {
        return this.canRespond;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Content getContent() {
        return this.content;
    }

    public final Status copy(String id2, String creatorId, String repliedId, long createdAt, boolean isPublic, boolean isDelete, boolean canRespond, String type, Content content, boolean seen, boolean closed, List<? extends MessageEntity> messageEntities, int uploadState, String location, int viewCount, int interactCount, int shareCount) {
        y.i(id2, "id");
        y.i(creatorId, "creatorId");
        y.i(repliedId, "repliedId");
        y.i(type, "type");
        y.i(content, "content");
        y.i(messageEntities, "messageEntities");
        y.i(location, "location");
        return new Status(id2, creatorId, repliedId, createdAt, isPublic, isDelete, canRespond, type, content, seen, closed, messageEntities, uploadState, location, viewCount, interactCount, shareCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Status)) {
            return false;
        }
        Status status = (Status) other;
        return y.d(this.id, status.id) && y.d(this.creatorId, status.creatorId) && y.d(this.repliedId, status.repliedId) && this.createdAt == status.createdAt && this.isPublic == status.isPublic && this.isDelete == status.isDelete && this.canRespond == status.canRespond && y.d(this.type, status.type) && y.d(this.content, status.content) && this.seen == status.seen && this.closed == status.closed && y.d(this.messageEntities, status.messageEntities) && this.uploadState == status.uploadState && y.d(this.location, status.location) && this.viewCount == status.viewCount && this.interactCount == status.interactCount && this.shareCount == status.shareCount;
    }

    public final boolean getCanRespond() {
        return this.canRespond;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final Content getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getId() {
        return this.id;
    }

    public final int getInteractCount() {
        return this.interactCount;
    }

    public final String getLocation() {
        return this.location;
    }

    public final List<MessageEntity> getMessageEntities() {
        return this.messageEntities;
    }

    public final String getRepliedId() {
        return this.repliedId;
    }

    public final boolean getSeen() {
        return this.seen;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    public final String getTextContent() {
        Content content = this.content;
        if (content instanceof StatusVideoContent) {
            String textContent = ((StatusVideoContent) content).getTextContent();
            if (d0.q0(textContent)) {
                return null;
            }
            return textContent;
        }
        if (!(content instanceof StatusImageContent)) {
            return null;
        }
        String textContent2 = ((StatusImageContent) content).getTextContent();
        if (d0.q0(textContent2)) {
            return null;
        }
        return textContent2;
    }

    public final String getType() {
        return this.type;
    }

    public final int getUploadState() {
        return this.uploadState;
    }

    public final int getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.creatorId.hashCode()) * 31) + this.repliedId.hashCode()) * 31) + l.a(this.createdAt)) * 31) + r.a(this.isPublic)) * 31) + r.a(this.isDelete)) * 31) + r.a(this.canRespond)) * 31) + this.type.hashCode()) * 31) + this.content.hashCode()) * 31) + r.a(this.seen)) * 31) + r.a(this.closed)) * 31) + this.messageEntities.hashCode()) * 31) + this.uploadState) * 31) + this.location.hashCode()) * 31) + this.viewCount) * 31) + this.interactCount) * 31) + this.shareCount;
    }

    public final boolean isDelete() {
        return this.isDelete;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public String toString() {
        return "Status(id=" + this.id + ", creatorId=" + this.creatorId + ", repliedId=" + this.repliedId + ", createdAt=" + this.createdAt + ", isPublic=" + this.isPublic + ", isDelete=" + this.isDelete + ", canRespond=" + this.canRespond + ", type=" + this.type + ", content=" + this.content + ", seen=" + this.seen + ", closed=" + this.closed + ", messageEntities=" + this.messageEntities + ", uploadState=" + this.uploadState + ", location=" + this.location + ", viewCount=" + this.viewCount + ", interactCount=" + this.interactCount + ", shareCount=" + this.shareCount + ")";
    }

    public /* synthetic */ Status(String str, String str2, String str3, long j10, boolean z10, boolean z11, boolean z12, String str4, Content content, boolean z13, boolean z14, List list, int i10, String str5, int i11, int i12, int i13, int i14, p pVar) {
        this(str, str2, str3, (i14 & 8) != 0 ? new Date().getTime() : j10, z10, z11, z12, str4, content, (i14 & 512) != 0 ? true : z13, (i14 & 1024) != 0 ? true : z14, (i14 & 2048) != 0 ? w.n() : list, (i14 & 4096) != 0 ? 1 : i10, str5, (i14 & 16384) != 0 ? 0 : i11, (32768 & i14) != 0 ? 0 : i12, (i14 & 65536) != 0 ? 0 : i13);
    }
}
