package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.utils.TextUtilsKt;
import cu.todus.android.xmpp.XMPPUtils;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u001dHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006-"}, d2 = {"Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "", "message", "Lcu/todus/android/data/db/entity/toDus/Message;", "senderUser", "Lcu/todus/android/data/db/entity/toDus/User;", "senderContact", "Lcu/todus/android/data/db/entity/toDus/Contact;", Attachment.TABLE_NAME, "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "senderRoom", "Lcu/todus/android/data/db/entity/toDus/Room;", "reactions", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Message;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;Ljava/util/List;Lcu/todus/android/data/db/entity/toDus/Room;Ljava/util/List;)V", "getMessage", "()Lcu/todus/android/data/db/entity/toDus/Message;", "getSenderUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "getSenderContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getAttachments", "()Ljava/util/List;", "getSenderRoom", "()Lcu/todus/android/data/db/entity/toDus/Room;", "getReactions", "getId", "", "getRoomName", "getSenderAlias", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MessageWithPartnerWithRoomWithReactions {
    public static final int $stable = 0;

    @Relation(entityColumn = "msg", parentColumn = "id")
    private final List<Attachment> attachments;

    @Embedded
    private final Message message;

    @Relation(entityColumn = Reaction.COLUMN_ENTITY, parentColumn = "id")
    private final List<Reaction> reactions;

    @Relation(entityColumn = "uid", parentColumn = Message.COLUMN_USER_SENDER)
    private final Contact senderContact;

    @Relation(entityColumn = "id", parentColumn = "roomId")
    private final Room senderRoom;

    @Relation(entityColumn = "uid", parentColumn = Message.COLUMN_USER_SENDER)
    private final User senderUser;

    public MessageWithPartnerWithRoomWithReactions(Message message, User user, Contact contact, List<Attachment> attachments, Room room, List<Reaction> reactions) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        y.i(reactions, "reactions");
        this.message = message;
        this.senderUser = user;
        this.senderContact = contact;
        this.attachments = attachments;
        this.senderRoom = room;
        this.reactions = reactions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageWithPartnerWithRoomWithReactions copy$default(MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions, Message message, User user, Contact contact, List list, Room room, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = messageWithPartnerWithRoomWithReactions.message;
        }
        if ((i10 & 2) != 0) {
            user = messageWithPartnerWithRoomWithReactions.senderUser;
        }
        if ((i10 & 4) != 0) {
            contact = messageWithPartnerWithRoomWithReactions.senderContact;
        }
        if ((i10 & 8) != 0) {
            list = messageWithPartnerWithRoomWithReactions.attachments;
        }
        if ((i10 & 16) != 0) {
            room = messageWithPartnerWithRoomWithReactions.senderRoom;
        }
        if ((i10 & 32) != 0) {
            list2 = messageWithPartnerWithRoomWithReactions.reactions;
        }
        Room room2 = room;
        List list3 = list2;
        return messageWithPartnerWithRoomWithReactions.copy(message, user, contact, list, room2, list3);
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Room getSenderRoom() {
        return this.senderRoom;
    }

    public final List<Reaction> component6() {
        return this.reactions;
    }

    public final MessageWithPartnerWithRoomWithReactions copy(Message message, User senderUser, Contact senderContact, List<Attachment> attachments, Room senderRoom, List<Reaction> reactions) {
        y.i(message, "message");
        y.i(attachments, "attachments");
        y.i(reactions, "reactions");
        return new MessageWithPartnerWithRoomWithReactions(message, senderUser, senderContact, attachments, senderRoom, reactions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageWithPartnerWithRoomWithReactions)) {
            return false;
        }
        MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions = (MessageWithPartnerWithRoomWithReactions) other;
        return y.d(this.message, messageWithPartnerWithRoomWithReactions.message) && y.d(this.senderUser, messageWithPartnerWithRoomWithReactions.senderUser) && y.d(this.senderContact, messageWithPartnerWithRoomWithReactions.senderContact) && y.d(this.attachments, messageWithPartnerWithRoomWithReactions.attachments) && y.d(this.senderRoom, messageWithPartnerWithRoomWithReactions.senderRoom) && y.d(this.reactions, messageWithPartnerWithRoomWithReactions.reactions);
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final String getId() {
        String id2 = this.message.getId();
        List<Attachment> list = this.attachments;
        ArrayList arrayList = new ArrayList(x.y(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Attachment) it.next()).getState()));
        }
        return id2 + TextUtilsKt.get256Hash(arrayList) + this.message.getContent();
    }

    public final Message getMessage() {
        return this.message;
    }

    public final List<Reaction> getReactions() {
        return this.reactions;
    }

    public final String getRoomName() {
        String onlyName;
        String fName;
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        if (xMPPUtils.isMUC(this.message.getRoomId()) || xMPPUtils.isChannel(this.message.getRoomId()) || xMPPUtils.isCard(this.message.getRoomId())) {
            Room room = this.senderRoom;
            return (room == null || (onlyName = room.getOnlyName()) == null) ? "" : onlyName;
        }
        Contact contact = this.senderContact;
        if (contact != null && (fName = contact.getFName()) != null) {
            return fName;
        }
        User user = this.senderUser;
        return user != null ? user.getAlias() : "";
    }

    public final String getSenderAlias() {
        String fName;
        Contact contact = this.senderContact;
        if (contact != null && (fName = contact.getFName()) != null) {
            return fName;
        }
        User user = this.senderUser;
        if (user != null) {
            return user.getAlias();
        }
        Room room = this.senderRoom;
        String onlyName = room != null ? room.getOnlyName() : null;
        return onlyName == null ? "..." : onlyName;
    }

    public final Contact getSenderContact() {
        return this.senderContact;
    }

    public final Room getSenderRoom() {
        return this.senderRoom;
    }

    public final User getSenderUser() {
        return this.senderUser;
    }

    public int hashCode() {
        int iHashCode = this.message.hashCode() * 31;
        User user = this.senderUser;
        int iHashCode2 = (iHashCode + (user == null ? 0 : user.hashCode())) * 31;
        Contact contact = this.senderContact;
        int iHashCode3 = (((iHashCode2 + (contact == null ? 0 : contact.hashCode())) * 31) + this.attachments.hashCode()) * 31;
        Room room = this.senderRoom;
        return ((iHashCode3 + (room != null ? room.hashCode() : 0)) * 31) + this.reactions.hashCode();
    }

    public String toString() {
        return "MessageWithPartnerWithRoomWithReactions(message=" + this.message + ", senderUser=" + this.senderUser + ", senderContact=" + this.senderContact + ", attachments=" + this.attachments + ", senderRoom=" + this.senderRoom + ", reactions=" + this.reactions + ")";
    }

    public /* synthetic */ MessageWithPartnerWithRoomWithReactions(Message message, User user, Contact contact, List list, Room room, List list2, int i10, p pVar) {
        this(message, (i10 & 2) != 0 ? null : user, (i10 & 4) != 0 ? null : contact, (i10 & 8) != 0 ? w.n() : list, (i10 & 16) != 0 ? null : room, (i10 & 32) != 0 ? w.n() : list2);
    }
}
