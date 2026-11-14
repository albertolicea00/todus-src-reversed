package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import androidx.room.Embedded;
import androidx.room.Relation;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0013HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "Lcu/todus/android/data/db/pojo/UserCommon;", "markerAction", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "contact", "Lcu/todus/android/data/db/entity/toDus/Contact;", "user", "Lcu/todus/android/data/db/entity/toDus/User;", "<init>", "(Lcu/todus/android/data/db/entity/toDus/MarkerAction;Lcu/todus/android/data/db/entity/toDus/Contact;Lcu/todus/android/data/db/entity/toDus/User;)V", "getMarkerAction", "()Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "getContact", "()Lcu/todus/android/data/db/entity/toDus/Contact;", "getUser", "()Lcu/todus/android/data/db/entity/toDus/User;", "exists", "", "getId", "", "getName", "getPicture", "getThumbnailPicture", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MarkerWithPartner implements UserCommon {
    public static final int $stable = 0;

    @Relation(entityColumn = "uid", parentColumn = MarkerAction.COLUMN_ROOM)
    private final Contact contact;

    @Embedded
    private final MarkerAction markerAction;

    @Relation(entityColumn = "uid", parentColumn = MarkerAction.COLUMN_ROOM)
    private final User user;

    public MarkerWithPartner(MarkerAction markerAction, Contact contact, User user) {
        y.i(markerAction, "markerAction");
        this.markerAction = markerAction;
        this.contact = contact;
        this.user = user;
    }

    public static /* synthetic */ MarkerWithPartner copy$default(MarkerWithPartner markerWithPartner, MarkerAction markerAction, Contact contact, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            markerAction = markerWithPartner.markerAction;
        }
        if ((i10 & 2) != 0) {
            contact = markerWithPartner.contact;
        }
        if ((i10 & 4) != 0) {
            user = markerWithPartner.user;
        }
        return markerWithPartner.copy(markerAction, contact, user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MarkerAction getMarkerAction() {
        return this.markerAction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final MarkerWithPartner copy(MarkerAction markerAction, Contact contact, User user) {
        y.i(markerAction, "markerAction");
        return new MarkerWithPartner(markerAction, contact, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkerWithPartner)) {
            return false;
        }
        MarkerWithPartner markerWithPartner = (MarkerWithPartner) other;
        return y.d(this.markerAction, markerWithPartner.markerAction) && y.d(this.contact, markerWithPartner.contact) && y.d(this.user, markerWithPartner.user);
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return true;
    }

    public final Contact getContact() {
        return this.contact;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.markerAction.getUid();
    }

    public final MarkerAction getMarkerAction() {
        return this.markerAction;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String alias;
        String fName;
        Contact contact = this.contact;
        if (contact != null && (fName = contact.getFName()) != null) {
            if (d0.q0(fName)) {
                User user = this.user;
                if (user == null || (fName = user.getAlias()) == null) {
                    fName = null;
                } else if (d0.q0(fName)) {
                    fName = "~";
                }
            }
            if (fName != null) {
                return fName;
            }
        }
        User user2 = this.user;
        if (user2 == null || (alias = user2.getAlias()) == null) {
            return "...";
        }
        return d0.q0(alias) ? "~" : alias;
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
        int iHashCode = this.markerAction.hashCode() * 31;
        Contact contact = this.contact;
        int iHashCode2 = (iHashCode + (contact == null ? 0 : contact.hashCode())) * 31;
        User user = this.user;
        return iHashCode2 + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        return "MarkerWithPartner(markerAction=" + this.markerAction + ", contact=" + this.contact + ", user=" + this.user + ")";
    }

    public /* synthetic */ MarkerWithPartner(MarkerAction markerAction, Contact contact, User user, int i10, p pVar) {
        this(markerAction, (i10 & 2) != 0 ? null : contact, (i10 & 4) != 0 ? null : user);
    }
}
