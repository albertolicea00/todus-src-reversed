package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u001cJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0001J\u0014\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0019HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006*"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "", "message", "Lcu/todus/android/data/db/entity/toDus/Message;", "senderUser", "Lcu/todus/android/data/db/entity/toDus/User;", "senderContact", "Lcu/todus/android/data/db/entity/toDus/Contact;", Attachment.TABLE_NAME, "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "reactions", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Message;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;Ljava/util/List;Ljava/util/List;)V", "getMessage", "()Lcu/todus/android/data/db/entity/toDus/Message;", "getSenderUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "getSenderContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getAttachments", "()Ljava/util/List;", "getReactions", "getId", "", "getSenderAlias", "editable", "", "ownerId", "available", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MessageWithPartnerWithReactions {
    public static final int $stable = 0;

    @Relation(entityColumn = "msg", parentColumn = "id")
    private final List<Attachment> attachments;

    @Embedded
    private final Message message;

    @Relation(entityColumn = Reaction.COLUMN_ENTITY, parentColumn = "id")
    private final List<Reaction> reactions;

    @Relation(entityColumn = "uid", parentColumn = Message.COLUMN_USER_SENDER)
    private final Contact senderContact;

    @Relation(entityColumn = "uid", parentColumn = Message.COLUMN_USER_SENDER)
    private final User senderUser;

    public MessageWithPartnerWithReactions(Message message, User user, Contact contact, List<Attachment> attachments, List<Reaction> reactions) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        y.i(reactions, "reactions");
        this.message = message;
        this.senderUser = user;
        this.senderContact = contact;
        this.attachments = attachments;
        this.reactions = reactions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageWithPartnerWithReactions copy$default(MessageWithPartnerWithReactions messageWithPartnerWithReactions, Message message, User user, Contact contact, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = messageWithPartnerWithReactions.message;
        }
        if ((i10 & 2) != 0) {
            user = messageWithPartnerWithReactions.senderUser;
        }
        if ((i10 & 4) != 0) {
            contact = messageWithPartnerWithReactions.senderContact;
        }
        if ((i10 & 8) != 0) {
            list = messageWithPartnerWithReactions.attachments;
        }
        if ((i10 & 16) != 0) {
            list2 = messageWithPartnerWithReactions.reactions;
        }
        List list3 = list2;
        Contact contact2 = contact;
        return messageWithPartnerWithReactions.copy(message, user, contact2, list, list3);
    }

    public final boolean available() {
        return this.message.available();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getSenderUser() {
        return this.senderUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Contact getSenderContact() {
        return this.senderContact;
    }

    public final List<Attachment> component4() {
        return this.attachments;
    }

    public final List<Reaction> component5() {
        return this.reactions;
    }

    public final MessageWithPartnerWithReactions copy(Message message, User senderUser, Contact senderContact, List<Attachment> attachments, List<Reaction> reactions) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        y.i(reactions, "reactions");
        return new MessageWithPartnerWithReactions(message, senderUser, senderContact, attachments, reactions);
    }

    public final boolean editable(String ownerId) {
        y.i(ownerId, "ownerId");
        return available() && y.d(this.message.getUserSender(), ownerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageWithPartnerWithReactions)) {
            return false;
        }
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = (MessageWithPartnerWithReactions) other;
        return y.d(this.message, messageWithPartnerWithReactions.message) && y.d(this.senderUser, messageWithPartnerWithReactions.senderUser) && y.d(this.senderContact, messageWithPartnerWithReactions.senderContact) && y.d(this.attachments, messageWithPartnerWithReactions.attachments) && y.d(this.reactions, messageWithPartnerWithReactions.reactions);
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final String getId() {
        String id2 = this.message.getId();
        int size = this.attachments.size();
        int state = this.message.getState();
        List<Reaction> list = this.reactions;
        ArrayList arrayList = new ArrayList(x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Reaction) it.next()).getReactionContent());
        }
        return id2 + size + state + arrayList.hashCode();
    }

    public final Message getMessage() {
        return this.message;
    }

    public final List<Reaction> getReactions() {
        return this.reactions;
    }

    public final String getSenderAlias() {
        String fName;
        Contact contact = this.senderContact;
        if (contact != null && (fName = contact.getFName()) != null) {
            return fName;
        }
        User user = this.senderUser;
        return user != null ? user.getAlias() : "...";
    }

    public final Contact getSenderContact() {
        return this.senderContact;
    }

    public final User getSenderUser() {
        return this.senderUser;
    }

    public int hashCode() {
        int iHashCode = this.message.hashCode() * 31;
        User user = this.senderUser;
        int iHashCode2 = (iHashCode + (user == null ? 0 : user.hashCode())) * 31;
        Contact contact = this.senderContact;
        return ((((iHashCode2 + (contact != null ? contact.hashCode() : 0)) * 31) + this.attachments.hashCode()) * 31) + this.reactions.hashCode();
    }

    public String toString() {
        return "MessageWithPartnerWithReactions(message=" + this.message + ", senderUser=" + this.senderUser + ", senderContact=" + this.senderContact + ", attachments=" + this.attachments + ", reactions=" + this.reactions + ")";
    }

    public /* synthetic */ MessageWithPartnerWithReactions(Message message, User user, Contact contact, List list, List list2, int i10, p pVar) {
        this(message, (i10 & 2) != 0 ? null : user, (i10 & 4) != 0 ? null : contact, (i10 & 8) != 0 ? w.n() : list, (i10 & 16) != 0 ? w.n() : list2);
    }
}
