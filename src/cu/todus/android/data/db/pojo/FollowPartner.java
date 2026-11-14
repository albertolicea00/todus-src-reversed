package cu.todus.android.data.db.pojo;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.core.os.EnvironmentCompat;
import cu.todus.android.data.db.entity.toDus.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0006\u0010\u0016\u001a\u00020\u0012J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/pojo/FollowPartner;", "Lcu/todus/android/data/db/pojo/UserCommon;", "index", "", "partner", "Lcu/todus/android/data/db/pojo/Partner;", EnvironmentCompat.MEDIA_UNKNOWN, "", "<init>", "(ILcu/todus/android/data/db/pojo/Partner;Z)V", "getIndex", "()I", "getPartner", "()Lcu/todus/android/data/db/pojo/Partner;", "getUnknown", "()Z", "exists", "getId", "", "getName", "getPicture", "getThumbnailPicture", "getToDusId", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FollowPartner implements UserCommon {
    public static final int $stable = 0;
    private final int index;
    private final Partner partner;
    private final boolean unknown;

    public FollowPartner(int i10, Partner partner, boolean z10) {
        y.i(partner, "partner");
        this.index = i10;
        this.partner = partner;
        this.unknown = z10;
    }

    public static /* synthetic */ FollowPartner copy$default(FollowPartner followPartner, int i10, Partner partner, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = followPartner.index;
        }
        if ((i11 & 2) != 0) {
            partner = followPartner.partner;
        }
        if ((i11 & 4) != 0) {
            z10 = followPartner.unknown;
        }
        return followPartner.copy(i10, partner, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUnknown() {
        return this.unknown;
    }

    public final FollowPartner copy(int index, Partner partner, boolean unknown) {
        y.i(partner, "partner");
        return new FollowPartner(index, partner, unknown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowPartner)) {
            return false;
        }
        FollowPartner followPartner = (FollowPartner) other;
        return this.index == followPartner.index && y.d(this.partner, followPartner.partner) && this.unknown == followPartner.unknown;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return true;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.partner.getUser().getUid();
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        String phone;
        if (this.partner.getContact() != null && !d0.q0(this.partner.getContact().getFName())) {
            return this.partner.getContact().getFName();
        }
        if (this.partner.getUser().getAlias().length() > 0) {
            return this.partner.getUser().getAlias();
        }
        Contact contact = this.partner.getContact();
        return (contact == null || (phone = contact.getPhone()) == null) ? "~" : phone;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getPicture() {
        return this.partner.getUser().getPhotoUrl();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getThumbnailPicture() {
        String photoThumbnail = this.partner.getUser().getPhotoThumbnail();
        return d0.q0(photoThumbnail) ? this.partner.getUser().getPhotoUrl() : photoThumbnail;
    }

    public final String getToDusId() {
        return this.partner.getUser().getToDusId();
    }

    public final boolean getUnknown() {
        return this.unknown;
    }

    public int hashCode() {
        return (((this.index * 31) + this.partner.hashCode()) * 31) + r.a(this.unknown);
    }

    public String toString() {
        return "FollowPartner(index=" + this.index + ", partner=" + this.partner + ", unknown=" + this.unknown + ")";
    }

    public /* synthetic */ FollowPartner(int i10, Partner partner, boolean z10, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, partner, (i11 & 4) != 0 ? false : z10);
    }
}
