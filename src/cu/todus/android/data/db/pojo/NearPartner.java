package cu.todus.android.data.db.pojo;

import androidx.camera.video.AudioStats;
import androidx.collection.a;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/pojo/NearPartner;", "Lcu/todus/android/data/db/pojo/UserCommon;", "index", "", "distance", "", "partner", "Lcu/todus/android/data/db/pojo/Partner;", "<init>", "(IDLcu/todus/android/data/db/pojo/Partner;)V", "getIndex", "()I", "getDistance", "()D", "getPartner", "()Lcu/todus/android/data/db/pojo/Partner;", "exists", "", "getId", "", "getName", "getPicture", "getThumbnailPicture", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NearPartner implements UserCommon {
    public static final int $stable = 0;
    private final double distance;
    private final int index;
    private final Partner partner;

    public NearPartner(int i10, double d10, Partner partner) {
        y.i(partner, "partner");
        this.index = i10;
        this.distance = d10;
        this.partner = partner;
    }

    public static /* synthetic */ NearPartner copy$default(NearPartner nearPartner, int i10, double d10, Partner partner, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = nearPartner.index;
        }
        if ((i11 & 2) != 0) {
            d10 = nearPartner.distance;
        }
        if ((i11 & 4) != 0) {
            partner = nearPartner.partner;
        }
        return nearPartner.copy(i10, d10, partner);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getDistance() {
        return this.distance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Partner getPartner() {
        return this.partner;
    }

    public final NearPartner copy(int index, double distance, Partner partner) {
        y.i(partner, "partner");
        return new NearPartner(index, distance, partner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NearPartner)) {
            return false;
        }
        NearPartner nearPartner = (NearPartner) other;
        return this.index == nearPartner.index && Double.compare(this.distance, nearPartner.distance) == 0 && y.d(this.partner, nearPartner.partner);
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public boolean exists() {
        return true;
    }

    public final double getDistance() {
        return this.distance;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getId() {
        return this.partner.getId();
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getName() {
        return this.partner.getName();
    }

    public final Partner getPartner() {
        return this.partner;
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getPicture() {
        return this.partner.getPicture();
    }

    @Override // cu.todus.android.data.db.pojo.UserCommon
    public String getThumbnailPicture() {
        return this.partner.getThumbnailPicture();
    }

    public int hashCode() {
        return (((this.index * 31) + a.a(this.distance)) * 31) + this.partner.hashCode();
    }

    public String toString() {
        return "NearPartner(index=" + this.index + ", distance=" + this.distance + ", partner=" + this.partner + ")";
    }

    public /* synthetic */ NearPartner(int i10, double d10, Partner partner, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d10, partner);
    }
}
