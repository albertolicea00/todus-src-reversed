package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.pojo.content.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(foreignKeys = {@ForeignKey(childColumns = {"msg"}, entity = Message.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"msg"})}, tableName = Attachment.TABLE_NAME)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u001a\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Attachment;", "", "id", "", "msg", "content", "Lcu/todus/android/data/db/pojo/content/Content;", "state", "", "type", Attachment.COLUMN_PERSISTENT, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/Content;IIZ)V", "getId", "()Ljava/lang/String;", "getMsg", "getContent", "()Lcu/todus/android/data/db/pojo/content/Content;", "getState", "()I", "getType", "getPersistent", "()Z", "equals", "other", "hashCode", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Attachment {
    public static final int $stable = 0;
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MSG = "msg";
    public static final String COLUMN_PERSISTENT = "persistent";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_TYPE = "type";
    public static final int DOWNLOADED = 6;
    public static final int DOWNLOADING = 5;
    public static final int DOWNLOAD_CANCELED = 7;
    public static final int NOT_DOWNLOAD = 4;
    public static final int NOT_UPLOADED = 0;
    public static final String TABLE_NAME = "attachments";
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_BUTTON = 21;
    public static final int TYPE_CALL = 32;
    public static final int TYPE_CONTACT = 6;
    public static final int TYPE_DELETED = 16;
    public static final int TYPE_DELETE_OWNER_MSG = 29;
    public static final int TYPE_EDITED = 15;
    public static final int TYPE_EMOJI = 11;
    public static final int TYPE_EVENT = 8;
    public static final int TYPE_FILE = 5;
    public static final int TYPE_FORWARDED = 14;
    public static final int TYPE_GIF = 7;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_LINK_INFO = 20;
    public static final int TYPE_LOCATION = 10;
    public static final int TYPE_PUB_DELETED = 25;
    public static final int TYPE_PUB_EDITED = 24;
    public static final int TYPE_REACTION = 23;
    public static final int TYPE_REFRESH_TODUS_ID = 28;
    public static final int TYPE_REPLY = 9;
    public static final int TYPE_STATUS_CONTENT_IMAGE = 27;
    public static final int TYPE_STATUS_CONTENT_TEXT = 26;
    public static final int TYPE_STATUS_CONTENT_VIDEO = 30;
    public static final int TYPE_STATUS_EXISTENCE = 22;
    public static final int TYPE_STICKER = 13;
    public static final int TYPE_STREAM_VIDEO = 31;
    public static final int TYPE_VIDEO = 2;
    public static final int TYPE_VOICE = 4;
    public static final int UPLOADED = 2;
    public static final int UPLOADING = 1;
    public static final int UPLOAD_CANCELED = 3;
    private final Content content;

    @PrimaryKey
    private final String id;
    private final String msg;
    private final boolean persistent;
    private final int state;
    private final int type;

    public Attachment(String id2, String msg, Content content, int i10, int i11, boolean z10) {
        y.i(id2, "id");
        y.i(msg, "msg");
        y.i(content, "content");
        this.id = id2;
        this.msg = msg;
        this.content = content;
        this.state = i10;
        this.type = i11;
        this.persistent = z10;
    }

    public static /* synthetic */ Attachment copy$default(Attachment attachment, String str, String str2, Content content, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = attachment.id;
        }
        if ((i12 & 2) != 0) {
            str2 = attachment.msg;
        }
        if ((i12 & 4) != 0) {
            content = attachment.content;
        }
        if ((i12 & 8) != 0) {
            i10 = attachment.state;
        }
        if ((i12 & 16) != 0) {
            i11 = attachment.type;
        }
        if ((i12 & 32) != 0) {
            z10 = attachment.persistent;
        }
        int i13 = i11;
        boolean z11 = z10;
        return attachment.copy(str, str2, content, i10, i13, z11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Content getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    public final Attachment copy(String id2, String msg, Content content, int state, int type, boolean persistent) {
        y.i(id2, "id");
        y.i(msg, "msg");
        y.i(content, "content");
        return new Attachment(id2, msg, content, state, type, persistent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return y.d(this.id, attachment.id) && y.d(this.msg, attachment.msg) && y.d(this.content, attachment.content) && this.state == attachment.state && this.type == attachment.type && this.persistent == attachment.persistent;
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final boolean getPersistent() {
        return this.persistent;
    }

    public final int getState() {
        return this.state;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.msg.hashCode()) * 31) + this.content.hashCode()) * 31) + this.state) * 31) + this.type) * 31) + r.a(this.persistent);
    }

    public String toString() {
        return this.id + " " + this.msg + " " + this.state + " " + this.content;
    }

    public /* synthetic */ Attachment(String str, String str2, Content content, int i10, int i11, boolean z10, int i12, p pVar) {
        this(str, str2, content, i10, (i12 & 16) != 0 ? 5 : i11, (i12 & 32) != 0 ? false : z10);
    }
}
