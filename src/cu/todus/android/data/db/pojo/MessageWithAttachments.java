package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "", "message", "Lcu/todus/android/data/db/entity/toDus/Message;", Attachment.TABLE_NAME, "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;)V", "getMessage", "()Lcu/todus/android/data/db/entity/toDus/Message;", "getAttachments", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MessageWithAttachments {
    public static final int $stable = 0;

    @Relation(entityColumn = "msg", parentColumn = "id")
    private final List<Attachment> attachments;

    @Embedded
    private final Message message;

    public MessageWithAttachments(Message message, List<Attachment> attachments) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        this.message = message;
        this.attachments = attachments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageWithAttachments copy$default(MessageWithAttachments messageWithAttachments, Message message, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = messageWithAttachments.message;
        }
        if ((i10 & 2) != 0) {
            list = messageWithAttachments.attachments;
        }
        return messageWithAttachments.copy(message, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    public final List<Attachment> component2() {
        return this.attachments;
    }

    public final MessageWithAttachments copy(Message message, List<Attachment> attachments) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        return new MessageWithAttachments(message, attachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageWithAttachments)) {
            return false;
        }
        MessageWithAttachments messageWithAttachments = (MessageWithAttachments) other;
        return y.d(this.message, messageWithAttachments.message) && y.d(this.attachments, messageWithAttachments.attachments);
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final Message getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.attachments.hashCode();
    }

    public String toString() {
        return "MessageWithAttachments(message=" + this.message + ", attachments=" + this.attachments + ")";
    }

    public /* synthetic */ MessageWithAttachments(Message message, List list, int i10, p pVar) {
        this(message, (i10 & 2) != 0 ? w.n() : list);
    }
}
