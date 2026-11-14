package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0013HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcu/todus/android/data/db/pojo/RoomMember;", "Lcu/todus/android/data/db/pojo/UserCommon;", "userRoomJoin", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "user", "Lcu/todus/android/data/db/entity/toDus/User;", "contact", "Lcu/todus/android/data/db/entity/toDus/Contact;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;)V", "getUserRoomJoin", "()Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "getUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "getContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "exists", "", "getId", "", "getName", "getPicture", "getThumbnailPicture", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RoomMember implements UserCommon {
    public static final int $stable = 0;

    @Relation(entityColumn = "uid", parentColumn = "userId")
    private final Contact contact;

    @Relation(entityColumn = "uid", parentColumn = "userId")
    private final User user;

    @Embedded
    private final UserRoomJoin userRoomJoin;

    public RoomMember(UserRoomJoin userRoomJoin, User user, Contact contact) {
        y.i(userRoomJoin, "userRoomJoin");
        this.userRoomJoin = userRoomJoin;
        this.user = user;
        this.contact = contact;
    }

    public static /* synthetic */ RoomMember copy$default(RoomMember roomMember, UserRoomJoin userRoomJoin, User user, Contact contact, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            userRoomJoin = roomMember.userRoomJoin;
        }
        if ((i10 & 2) != 0) {
            user = roomMember.user;
        }
        if ((i10 & 4) != 0) {
            contact = roomMember.contact;
        }
        return roomMember.copy(userRoomJoin, user, contact);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserRoomJoin getUserRoomJoin() {
        return this.userRoomJoin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    public final RoomMember copy(UserRoomJoin userRoomJoin, User user, Contact contact) {
        y.i(userRoomJoin, "userRoomJoin");
        return new RoomMember(userRoomJoin, user, contact);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomMember)) {
            return false;
        }
        RoomMember roomMember = (RoomMember) other;
        return y.d(this.userRoomJoin, roomMember.userRoomJoin) && y.d(this.user, roomMember.user) && y.d(this.contact, roomMember.contact);
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return this.user != null;
    }

    public final Contact getContact() {
        return this.contact;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.userRoomJoin.getUserId();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String phone;
        Contact contact = this.contact;
        if (contact != null && !d0.q0(contact.getFName())) {
            return this.contact.getFName();
        }
        User user = this.user;
        if (user != null && !d0.q0(user.getAlias())) {
            return this.user.getAlias();
        }
        Contact contact2 = this.contact;
        return (contact2 == null || (phone = contact2.getPhone()) == null) ? "~" : phone;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getPicture() {
        String photoUrl;
        User user = this.user;
        return (user == null || (photoUrl = user.getPhotoUrl()) == null) ? "" : photoUrl;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getThumbnailPicture() {
        String photoThumbnail;
        User user = this.user;
        if (user != null && (photoThumbnail = user.getPhotoThumbnail()) != null) {
            if (d0.q0(photoThumbnail)) {
                photoThumbnail = this.user.getPhotoUrl();
            }
            if (photoThumbnail != null) {
                return photoThumbnail;
            }
        }
        User user2 = this.user;
        return user2 != null ? user2.getPhotoUrl() : "";
    }

    public final User getUser() {
        return this.user;
    }

    public final UserRoomJoin getUserRoomJoin() {
        return this.userRoomJoin;
    }

    public int hashCode() {
        int iHashCode = this.userRoomJoin.hashCode() * 31;
        User user = this.user;
        int iHashCode2 = (iHashCode + (user == null ? 0 : user.hashCode())) * 31;
        Contact contact = this.contact;
        return iHashCode2 + (contact != null ? contact.hashCode() : 0);
    }

    public String toString() {
        return "RoomMember(userRoomJoin=" + this.userRoomJoin + ", user=" + this.user + ", contact=" + this.contact + ")";
    }

    public /* synthetic */ RoomMember(UserRoomJoin userRoomJoin, User user, Contact contact, int i10, p pVar) {
        this(userRoomJoin, (i10 & 2) != 0 ? null : user, (i10 & 4) != 0 ? null : contact);
    }
}
