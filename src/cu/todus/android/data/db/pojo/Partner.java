package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0006\u0010\u0018\u001a\u00020\u0011J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0013HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcu/todus/android/data/db/pojo/Partner;", "Lcu/todus/android/data/db/pojo/UserCommon;", "user", "Lcu/todus/android/data/db/entity/toDus/User;", "contact", "Lcu/todus/android/data/db/entity/toDus/Contact;", MarkerAction.COLUMN_ROOM, "Lcu/todus/android/data/db/entity/toDus/Room;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/User;Lcu/todus/android/data/db/entity/toDus/Contact;Lcu/todus/android/data/db/entity/toDus/Room;)V", "getUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "getContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getRoom", "()Lcu/todus/android/data/db/entity/toDus/Room;", "exists", "", "getId", "", "getName", "getBio", "getPicture", "getThumbnailPicture", "hasContact", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Partner implements UserCommon {
    public static final int $stable = 0;

    @Relation(entityColumn = "phone", parentColumn = "username")
    private final Contact contact;

    @Relation(entityColumn = "id", parentColumn = "uid")
    private final Room room;

    @Embedded
    private final User user;

    public Partner(User user, Contact contact, Room room) {
        y.i(user, "user");
        this.user = user;
        this.contact = contact;
        this.room = room;
    }

    public static /* synthetic */ Partner copy$default(Partner partner, User user, Contact contact, Room room, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = partner.user;
        }
        if ((i10 & 2) != 0) {
            contact = partner.contact;
        }
        if ((i10 & 4) != 0) {
            room = partner.room;
        }
        return partner.copy(user, contact, room);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Room getRoom() {
        return this.room;
    }

    public final Partner copy(User user, Contact contact, Room room) {
        y.i(user, "user");
        return new Partner(user, contact, room);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Partner)) {
            return false;
        }
        Partner partner = (Partner) other;
        return y.d(this.user, partner.user) && y.d(this.contact, partner.contact) && y.d(this.room, partner.room);
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return true;
    }

    public final String getBio() {
        return this.user.getDescription();
    }

    public final Contact getContact() {
        return this.contact;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.user.getUid();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String fName;
        Contact contact = this.contact;
        if (contact != null && (fName = contact.getFName()) != null) {
            if (d0.q0(fName)) {
                fName = this.user.getAlias();
                if (d0.q0(fName)) {
                    fName = "~";
                }
            }
            if (fName != null) {
                return fName;
            }
        }
        String alias = this.user.getAlias();
        return d0.q0(alias) ? "~" : alias;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getPicture() {
        return this.user.getPhotoUrl();
    }

    public final Room getRoom() {
        return this.room;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getThumbnailPicture() {
        String photoThumbnail = this.user.getPhotoThumbnail();
        return d0.q0(photoThumbnail) ? this.user.getPhotoUrl() : photoThumbnail;
    }

    public final User getUser() {
        return this.user;
    }

    public final boolean hasContact() {
        return this.contact != null;
    }

    public int hashCode() {
        int iHashCode = this.user.hashCode() * 31;
        Contact contact = this.contact;
        int iHashCode2 = (iHashCode + (contact == null ? 0 : contact.hashCode())) * 31;
        Room room = this.room;
        return iHashCode2 + (room != null ? room.hashCode() : 0);
    }

    public String toString() {
        return "Partner(user=" + this.user + ", contact=" + this.contact + ", room=" + this.room + ")";
    }

    public /* synthetic */ Partner(User user, Contact contact, Room room, int i10, p pVar) {
        this(user, (i10 & 2) != 0 ? null : contact, (i10 & 4) != 0 ? null : room);
    }
}
