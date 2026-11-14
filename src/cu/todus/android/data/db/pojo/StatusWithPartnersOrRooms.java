package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÂ\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0012HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "", "status", "Lcu/todus/android/data/db/entity/toDus/Status;", "creatorUser", "Lcu/todus/android/data/db/entity/toDus/User;", "creatorContact", "Lcu/todus/android/data/db/entity/toDus/Contact;", "repliedUser", "repliedContact", "creatorRoom", "Lcu/todus/android/data/db/entity/toDus/Room;", "repliedRoom", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Status;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;Lcu/todus/android/data/db/entity/toDus/Room;Lcu/todus/android/data/db/entity/toDus/Room;)V", "getStatus", "()Lcu/todus/android/data/db/entity/toDus/Status;", "getCreatorId", "", "getCreatorToDusId", "getCreatorName", "getCreatorImage", "getCreatorThumbnail", "getRepliedId", "getRepliedIdToDusId", "getRepliedName", "getRepliedPicture", "getRepliedThumbnail", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StatusWithPartnersOrRooms {
    public static final int $stable = 0;

    @Relation(entityColumn = "uid", parentColumn = Status.COLUMN_CREATOR_ID)
    private final Contact creatorContact;

    @Relation(entityColumn = "id", parentColumn = Status.COLUMN_CREATOR_ID)
    private final Room creatorRoom;

    @Relation(entityColumn = "uid", parentColumn = Status.COLUMN_CREATOR_ID)
    private final User creatorUser;

    @Relation(entityColumn = "uid", parentColumn = Status.COLUMN_REPLIED_ID)
    private final Contact repliedContact;

    @Relation(entityColumn = "id", parentColumn = Status.COLUMN_REPLIED_ID)
    private final Room repliedRoom;

    @Relation(entityColumn = "uid", parentColumn = Status.COLUMN_REPLIED_ID)
    private final User repliedUser;

    @Embedded
    private final Status status;

    public StatusWithPartnersOrRooms(Status status, User user, Contact contact, User user2, Contact contact2, Room room, Room room2) {
        y.i(status, "status");
        this.status = status;
        this.creatorUser = user;
        this.creatorContact = contact;
        this.repliedUser = user2;
        this.repliedContact = contact2;
        this.creatorRoom = room;
        this.repliedRoom = room2;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final User getCreatorUser() {
        return this.creatorUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Contact getCreatorContact() {
        return this.creatorContact;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final User getRepliedUser() {
        return this.repliedUser;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final Contact getRepliedContact() {
        return this.repliedContact;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final Room getCreatorRoom() {
        return this.creatorRoom;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final Room getRepliedRoom() {
        return this.repliedRoom;
    }

    public static /* synthetic */ StatusWithPartnersOrRooms copy$default(StatusWithPartnersOrRooms statusWithPartnersOrRooms, Status status, User user, Contact contact, User user2, Contact contact2, Room room, Room room2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            status = statusWithPartnersOrRooms.status;
        }
        if ((i10 & 2) != 0) {
            user = statusWithPartnersOrRooms.creatorUser;
        }
        if ((i10 & 4) != 0) {
            contact = statusWithPartnersOrRooms.creatorContact;
        }
        if ((i10 & 8) != 0) {
            user2 = statusWithPartnersOrRooms.repliedUser;
        }
        if ((i10 & 16) != 0) {
            contact2 = statusWithPartnersOrRooms.repliedContact;
        }
        if ((i10 & 32) != 0) {
            room = statusWithPartnersOrRooms.creatorRoom;
        }
        if ((i10 & 64) != 0) {
            room2 = statusWithPartnersOrRooms.repliedRoom;
        }
        Room room3 = room;
        Room room4 = room2;
        Contact contact3 = contact2;
        Contact contact4 = contact;
        return statusWithPartnersOrRooms.copy(status, user, contact4, user2, contact3, room3, room4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final StatusWithPartnersOrRooms copy(Status status, User creatorUser, Contact creatorContact, User repliedUser, Contact repliedContact, Room creatorRoom, Room repliedRoom) {
        y.i(status, "status");
        return new StatusWithPartnersOrRooms(status, creatorUser, creatorContact, repliedUser, repliedContact, creatorRoom, repliedRoom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusWithPartnersOrRooms)) {
            return false;
        }
        StatusWithPartnersOrRooms statusWithPartnersOrRooms = (StatusWithPartnersOrRooms) other;
        return y.d(this.status, statusWithPartnersOrRooms.status) && y.d(this.creatorUser, statusWithPartnersOrRooms.creatorUser) && y.d(this.creatorContact, statusWithPartnersOrRooms.creatorContact) && y.d(this.repliedUser, statusWithPartnersOrRooms.repliedUser) && y.d(this.repliedContact, statusWithPartnersOrRooms.repliedContact) && y.d(this.creatorRoom, statusWithPartnersOrRooms.creatorRoom) && y.d(this.repliedRoom, statusWithPartnersOrRooms.repliedRoom);
    }

    public final String getCreatorId() {
        return this.status.getCreatorId();
    }

    public final String getCreatorImage() {
        String photoUrl;
        String picture;
        User user = this.creatorUser;
        if (user == null || (photoUrl = user.getPhotoUrl()) == null) {
            photoUrl = "";
        }
        if (!d0.q0(photoUrl)) {
            return photoUrl;
        }
        Room room = this.creatorRoom;
        return (room == null || (picture = room.getPicture()) == null) ? "" : picture;
    }

    public final String getCreatorName() {
        User user;
        String alias;
        String onlyName;
        User user2;
        Contact contact = this.creatorContact;
        String str = "";
        if (contact == null || (alias = contact.getFName()) == null ? !((user = this.creatorUser) == null || (alias = user.getAlias()) == null || d0.q0(alias)) : !(d0.q0(alias) && ((user2 = this.creatorUser) == null || (alias = user2.getAlias()) == null || d0.q0(alias)))) {
            str = alias;
        }
        if (!d0.q0(str)) {
            return str;
        }
        Room room = this.creatorRoom;
        return (room == null || (onlyName = room.getOnlyName()) == null) ? "~" : onlyName;
    }

    public final String getCreatorThumbnail() {
        String photoUrl;
        String thumbnail;
        User user;
        User user2 = this.creatorUser;
        if (user2 == null || (photoUrl = user2.getPhotoThumbnail()) == null) {
            photoUrl = "";
        }
        if (d0.q0(photoUrl) && ((user = this.creatorUser) == null || (photoUrl = user.getPhotoUrl()) == null)) {
            photoUrl = "";
        }
        if (!d0.q0(photoUrl)) {
            return photoUrl;
        }
        Room room = this.creatorRoom;
        return (room == null || (thumbnail = room.getThumbnail()) == null) ? "" : thumbnail;
    }

    public final String getCreatorToDusId() {
        String toDusId;
        User user = this.creatorUser;
        return (user == null || (toDusId = user.getToDusId()) == null) ? "" : toDusId;
    }

    public final String getRepliedId() {
        return this.status.getRepliedId();
    }

    public final String getRepliedIdToDusId() {
        String toDusId;
        User user = this.repliedUser;
        return (user == null || (toDusId = user.getToDusId()) == null) ? "" : toDusId;
    }

    public final String getRepliedName() {
        User user;
        String alias;
        String onlyName;
        User user2;
        Contact contact = this.repliedContact;
        if (contact == null || (alias = contact.getFName()) == null ? (user = this.repliedUser) == null || (alias = user.getAlias()) == null || d0.q0(alias) : d0.q0(alias) && ((user2 = this.repliedUser) == null || (alias = user2.getAlias()) == null || d0.q0(alias))) {
            alias = "";
        }
        if (!d0.q0(alias)) {
            return alias;
        }
        Room room = this.repliedRoom;
        return (room == null || (onlyName = room.getOnlyName()) == null) ? "" : onlyName;
    }

    public final String getRepliedPicture() {
        String photoUrl;
        String picture;
        User user = this.repliedUser;
        if (user == null || (photoUrl = user.getPhotoUrl()) == null) {
            photoUrl = "";
        }
        if (!d0.q0(photoUrl)) {
            return photoUrl;
        }
        Room room = this.repliedRoom;
        return (room == null || (picture = room.getPicture()) == null) ? "" : picture;
    }

    public final String getRepliedThumbnail() {
        String photoUrl;
        String thumbnail;
        User user;
        User user2 = this.repliedUser;
        if (user2 == null || (photoUrl = user2.getPhotoThumbnail()) == null) {
            photoUrl = "";
        }
        if (d0.q0(photoUrl) && ((user = this.repliedUser) == null || (photoUrl = user.getPhotoUrl()) == null)) {
            photoUrl = "";
        }
        if (!d0.q0(photoUrl)) {
            return photoUrl;
        }
        Room room = this.repliedRoom;
        return (room == null || (thumbnail = room.getThumbnail()) == null) ? "" : thumbnail;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        User user = this.creatorUser;
        int iHashCode2 = (iHashCode + (user == null ? 0 : user.hashCode())) * 31;
        Contact contact = this.creatorContact;
        int iHashCode3 = (iHashCode2 + (contact == null ? 0 : contact.hashCode())) * 31;
        User user2 = this.repliedUser;
        int iHashCode4 = (iHashCode3 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Contact contact2 = this.repliedContact;
        int iHashCode5 = (iHashCode4 + (contact2 == null ? 0 : contact2.hashCode())) * 31;
        Room room = this.creatorRoom;
        int iHashCode6 = (iHashCode5 + (room == null ? 0 : room.hashCode())) * 31;
        Room room2 = this.repliedRoom;
        return iHashCode6 + (room2 != null ? room2.hashCode() : 0);
    }

    public String toString() {
        return "StatusWithPartnersOrRooms(status=" + this.status + ", creatorUser=" + this.creatorUser + ", creatorContact=" + this.creatorContact + ", repliedUser=" + this.repliedUser + ", repliedContact=" + this.repliedContact + ", creatorRoom=" + this.creatorRoom + ", repliedRoom=" + this.repliedRoom + ")";
    }

    public /* synthetic */ StatusWithPartnersOrRooms(Status status, User user, Contact contact, User user2, Contact contact2, Room room, Room room2, int i10, p pVar) {
        this(status, (i10 & 2) != 0 ? null : user, (i10 & 4) != 0 ? null : contact, (i10 & 8) != 0 ? null : user2, (i10 & 16) != 0 ? null : contact2, (i10 & 32) != 0 ? null : room, (i10 & 64) != 0 ? null : room2);
    }
}
