package cu.todus.android.backup;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import defpackage.l;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcu/todus/android/backup/MsgSaved;", "", "id", "", "content", Message.COLUMN_USER_SENDER, "createAt", "", Attachment.TABLE_NAME, "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getId", "()Ljava/lang/String;", "getContent", "getUserSender", "getCreateAt", "()J", "getAttachments", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MsgSaved {
    public static final int $stable = 8;
    private final List<Attachment> attachments;
    private final String content;
    private final long createAt;
    private final String id;
    private final String userSender;

    public MsgSaved(String id2, String content, String userSender, long j10, List<Attachment> attachments) {
        y.i(id2, "id");
        y.i(content, "content");
        y.i(userSender, "userSender");
        y.i(attachments, "attachments");
        this.id = id2;
        this.content = content;
        this.userSender = userSender;
        this.createAt = j10;
        this.attachments = attachments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgSaved copy$default(MsgSaved msgSaved, String str, String str2, String str3, long j10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = msgSaved.id;
        }
        if ((i10 & 2) != 0) {
            str2 = msgSaved.content;
        }
        if ((i10 & 4) != 0) {
            str3 = msgSaved.userSender;
        }
        if ((i10 & 8) != 0) {
            j10 = msgSaved.createAt;
        }
        if ((i10 & 16) != 0) {
            list = msgSaved.attachments;
        }
        List list2 = list;
        String str4 = str3;
        return msgSaved.copy(str, str2, str4, j10, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserSender() {
        return this.userSender;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCreateAt() {
        return this.createAt;
    }

    public final List<Attachment> component5() {
        return this.attachments;
    }

    public final MsgSaved copy(String id2, String content, String userSender, long createAt, List<Attachment> attachments) {
        y.i(id2, "id");
        y.i(content, "content");
        y.i(userSender, "userSender");
        y.i(attachments, "attachments");
        return new MsgSaved(id2, content, userSender, createAt, attachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgSaved)) {
            return false;
        }
        MsgSaved msgSaved = (MsgSaved) other;
        return y.d(this.id, msgSaved.id) && y.d(this.content, msgSaved.content) && y.d(this.userSender, msgSaved.userSender) && this.createAt == msgSaved.createAt && y.d(this.attachments, msgSaved.attachments);
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUserSender() {
        return this.userSender;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.content.hashCode()) * 31) + this.userSender.hashCode()) * 31) + l.a(this.createAt)) * 31) + this.attachments.hashCode();
    }

    public String toString() {
        return "MsgSaved(id=" + this.id + ", content=" + this.content + ", userSender=" + this.userSender + ", createAt=" + this.createAt + ", attachments=" + this.attachments + ")";
    }

    public /* synthetic */ MsgSaved(String str, String str2, String str3, long j10, List list, int i10, p pVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? new Date().getTime() : j10, (i10 & 16) != 0 ? w.n() : list);
    }
}
