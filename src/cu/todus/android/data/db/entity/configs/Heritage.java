package cu.todus.android.data.db.entity.configs;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000HÆ\u0001J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/db/entity/configs/Heritage;", "", "tag", "", Config.TABLE_NAME, "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/entity/configs/Heritage;)V", "getTag", "()Ljava/lang/String;", "getHeritage", "()Lcu/todus/android/data/db/entity/configs/Heritage;", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Heritage {
    private final Heritage heritage;
    private final String tag;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcu/todus/android/data/db/entity/configs/Heritage$Companion;", "", "<init>", "()V", "contains", "", "uid", "", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "getLeaf", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final boolean contains(String uid, Heritage heritage) {
            y.i(uid, "uid");
            y.i(heritage, "heritage");
            if (y.d(heritage.getTag(), uid)) {
                return true;
            }
            if (heritage.getHeritage() == null) {
                return false;
            }
            return contains(uid, heritage.getHeritage());
        }

        public final String getLeaf(Heritage heritage) {
            y.i(heritage, "heritage");
            return heritage.getHeritage() == null ? heritage.getTag() : getLeaf(heritage.getHeritage());
        }

        private Companion() {
        }
    }

    public Heritage(String tag, Heritage heritage) {
        y.i(tag, "tag");
        this.tag = tag;
        this.heritage = heritage;
    }

    public static /* synthetic */ Heritage copy$default(Heritage heritage, String str, Heritage heritage2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = heritage.tag;
        }
        if ((i10 & 2) != 0) {
            heritage2 = heritage.heritage;
        }
        return heritage.copy(str, heritage2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Heritage getHeritage() {
        return this.heritage;
    }

    public final Heritage copy(String tag, Heritage heritage) {
        y.i(tag, "tag");
        return new Heritage(tag, heritage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!y.d(Heritage.class, other != null ? other.getClass() : null)) {
            return false;
        }
        y.g(other, "null cannot be cast to non-null type cu.todus.android.data.db.entity.configs.Heritage");
        Heritage heritage = (Heritage) other;
        if (y.d(this.tag, heritage.tag)) {
            return y.d(this.heritage, heritage.heritage);
        }
        return false;
    }

    public final Heritage getHeritage() {
        return this.heritage;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int iHashCode = this.tag.hashCode() * 31;
        Heritage heritage = this.heritage;
        return iHashCode + (heritage != null ? heritage.hashCode() : 0);
    }

    public String toString() {
        return "Heritage(tag=" + this.tag + ", heritage=" + this.heritage + ")";
    }

    public /* synthetic */ Heritage(String str, Heritage heritage, int i10, p pVar) {
        this(str, (i10 & 2) != 0 ? null : heritage);
    }
}
