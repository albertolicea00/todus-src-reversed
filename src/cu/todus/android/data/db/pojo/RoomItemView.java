package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.utils.DateFormatter;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0015HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcu/todus/android/data/db/pojo/RoomItemView;", "", MarkerAction.COLUMN_ROOM, "Lcu/todus/android/data/db/entity/toDus/Room;", "lastMessage", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "roomUser", "Lcu/todus/android/data/db/entity/toDus/User;", "contact", "Lcu/todus/android/data/db/entity/toDus/Contact;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Room;Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;)V", "getRoom", "()Lcu/todus/android/data/db/entity/toDus/Room;", "getLastMessage", "()Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "getRoomUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "getContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getId", "", "getIdOnList", "getLastMsgId", "getName", "getPhoto", "getThumbnail", "getVersion", "getLastUpdate", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RoomItemView {
    public static final int $stable = 0;

    @Relation(entityColumn = "uid", parentColumn = "id")
    private final Contact contact;

    @Relation(entity = Message.class, entityColumn = "id", parentColumn = Room.COLUMN_LAST_MSG)
    private final MessageWithPartnerWithReactions lastMessage;

    @Embedded
    private final Room room;

    @Relation(entityColumn = "uid", parentColumn = "id")
    private final User roomUser;

    public RoomItemView(Room room, MessageWithPartnerWithReactions messageWithPartnerWithReactions, User user, Contact contact) {
        y.i(room, "room");
        this.room = room;
        this.lastMessage = messageWithPartnerWithReactions;
        this.roomUser = user;
        this.contact = contact;
    }

    public static /* synthetic */ RoomItemView copy$default(RoomItemView roomItemView, Room room, MessageWithPartnerWithReactions messageWithPartnerWithReactions, User user, Contact contact, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            room = roomItemView.room;
        }
        if ((i10 & 2) != 0) {
            messageWithPartnerWithReactions = roomItemView.lastMessage;
        }
        if ((i10 & 4) != 0) {
            user = roomItemView.roomUser;
        }
        if ((i10 & 8) != 0) {
            contact = roomItemView.contact;
        }
        return roomItemView.copy(room, messageWithPartnerWithReactions, user, contact);
    }

    private final String getLastMsgId() {
        String id2;
        List<Attachment> attachments;
        Message message;
        Message message2;
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = this.lastMessage;
        Object objValueOf = "";
        if (messageWithPartnerWithReactions == null || (message2 = messageWithPartnerWithReactions.getMessage()) == null || (id2 = message2.getId()) == null) {
            id2 = "";
        }
        MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = this.lastMessage;
        if (messageWithPartnerWithReactions2 != null && (message = messageWithPartnerWithReactions2.getMessage()) != null) {
            objValueOf = Integer.valueOf(message.getState());
        }
        MessageWithPartnerWithReactions messageWithPartnerWithReactions3 = this.lastMessage;
        return id2 + objValueOf + ((messageWithPartnerWithReactions3 == null || (attachments = messageWithPartnerWithReactions3.getAttachments()) == null) ? null : Integer.valueOf(attachments.size()));
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Room getRoom() {
        return this.room;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageWithPartnerWithReactions getLastMessage() {
        return this.lastMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getRoomUser() {
        return this.roomUser;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    public final RoomItemView copy(Room room, MessageWithPartnerWithReactions lastMessage, User roomUser, Contact contact) {
        y.i(room, "room");
        return new RoomItemView(room, lastMessage, roomUser, contact);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomItemView)) {
            return false;
        }
        RoomItemView roomItemView = (RoomItemView) other;
        return y.d(this.room, roomItemView.room) && y.d(this.lastMessage, roomItemView.lastMessage) && y.d(this.roomUser, roomItemView.roomUser) && y.d(this.contact, roomItemView.contact);
    }

    public final Contact getContact() {
        return this.contact;
    }

    public final String getId() {
        return this.room.getId();
    }

    public final String getIdOnList() {
        return this.room.getId() + getLastMsgId();
    }

    public final MessageWithPartnerWithReactions getLastMessage() {
        return this.lastMessage;
    }

    public final CharSequence getLastUpdate() {
        return this.lastMessage != null ? DateFormatter.INSTANCE.prettyFormatter(new Date(this.room.getLastUpdate())) : "";
    }

    public final String getName() {
        String alias;
        String fName;
        if (this.room.getType() != 0) {
            return this.room.getOnlyName();
        }
        Contact contact = this.contact;
        if (contact != null && (fName = contact.getFName()) != null) {
            return fName;
        }
        User user = this.roomUser;
        return (user == null || (alias = user.getAlias()) == null) ? this.room.getOnlyName() : alias;
    }

    public final String getPhoto() {
        String photoUrl;
        if (this.room.getType() != 0) {
            return this.room.getPicture();
        }
        User user = this.roomUser;
        return (user == null || (photoUrl = user.getPhotoUrl()) == null) ? "" : photoUrl;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final User getRoomUser() {
        return this.roomUser;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    public final String getThumbnail() {
        String photoThumbnail;
        if (this.room.getType() != 0) {
            String thumbnail = this.room.getThumbnail();
            return d0.q0(thumbnail) ? this.room.getPicture() : thumbnail;
        }
        User user = this.roomUser;
        if (user == null || (photoThumbnail = user.getPhotoThumbnail()) == null) {
            photoThumbnail = "";
        } else {
            if (d0.q0(photoThumbnail)) {
                photoThumbnail = this.roomUser.getPhotoUrl();
            }
            if (photoThumbnail == null) {
                photoThumbnail = "";
            }
        }
        if (!d0.q0(photoThumbnail)) {
            return photoThumbnail;
        }
        String thumbnail2 = this.room.getThumbnail();
        return d0.q0(thumbnail2) ? this.room.getPicture() : thumbnail2;
    }

    public final String getVersion() {
        String strValueOf;
        if (this.room.getType() != 0) {
            return this.room.getVersion();
        }
        User user = this.roomUser;
        return (user == null || (strValueOf = String.valueOf(user.getVersion())) == null) ? this.room.getName() : strValueOf;
    }

    public int hashCode() {
        int iHashCode = this.room.hashCode() * 31;
        MessageWithPartnerWithReactions messageWithPartnerWithReactions = this.lastMessage;
        int iHashCode2 = (iHashCode + (messageWithPartnerWithReactions == null ? 0 : messageWithPartnerWithReactions.hashCode())) * 31;
        User user = this.roomUser;
        int iHashCode3 = (iHashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        Contact contact = this.contact;
        return iHashCode3 + (contact != null ? contact.hashCode() : 0);
    }

    public String toString() {
        return "RoomItemView(room=" + this.room + ", lastMessage=" + this.lastMessage + ", roomUser=" + this.roomUser + ", contact=" + this.contact + ")";
    }

    public /* synthetic */ RoomItemView(Room room, MessageWithPartnerWithReactions messageWithPartnerWithReactions, User user, Contact contact, int i10, p pVar) {
        this(room, (i10 & 2) != 0 ? null : messageWithPartnerWithReactions, (i10 & 4) != 0 ? null : user, (i10 & 8) != 0 ? null : contact);
    }
}
