package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u000fHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/db/pojo/Friend;", "Lcu/todus/android/data/db/pojo/UserCommon;", "contact", "Lcu/todus/android/data/db/entity/toDus/Contact;", "user", "Lcu/todus/android/data/db/entity/toDus/User;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/Contact;Lcu/todus/android/data/db/entity/toDus/User;)V", "getContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "exists", "", "getId", "", "getName", "getPicture", "getThumbnailPicture", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Friend implements UserCommon {
    public static final int $stable = 0;

    @Embedded
    private final Contact contact;

    @Relation(entityColumn = "username", parentColumn = "phone")
    private final User user;

    public Friend(Contact contact, User user) {
        y.i(contact, "contact");
        this.contact = contact;
        this.user = user;
    }

    public static /* synthetic */ Friend copy$default(Friend friend, Contact contact, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contact = friend.contact;
        }
        if ((i10 & 2) != 0) {
            user = friend.user;
        }
        return friend.copy(contact, user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final Friend copy(Contact contact, User user) {
        y.i(contact, "contact");
        return new Friend(contact, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Friend)) {
            return false;
        }
        Friend friend = (Friend) other;
        return y.d(this.contact, friend.contact) && y.d(this.user, friend.user);
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
        return this.contact.getUid();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String alias;
        String fName = this.contact.getFName();
        if (!d0.q0(fName)) {
            return fName;
        }
        User user = this.user;
        if (user != null && (alias = user.getAlias()) != null) {
            if (d0.q0(alias)) {
                alias = this.contact.getPhone();
            }
            if (alias != null) {
                return alias;
            }
        }
        return this.contact.getPhone();
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

    public int hashCode() {
        int iHashCode = this.contact.hashCode() * 31;
        User user = this.user;
        return iHashCode + (user == null ? 0 : user.hashCode());
    }

    public String toString() {
        return "Friend(contact=" + this.contact + ", user=" + this.user + ")";
    }

    public /* synthetic */ Friend(Contact contact, User user, int i10, p pVar) {
        this(contact, (i10 & 2) != 0 ? null : user);
    }
}
