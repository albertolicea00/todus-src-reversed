package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0015\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0004HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcu/todus/android/data/xmpp/Muc;", "", "aff", "", "", "", "muc", "version", Room.CONFIG_CONFIG, "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAff", "()Ljava/util/Map;", "getMuc", "()Ljava/lang/String;", "getVersion", "getConfig", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Muc {
    public static final int $stable = 8;
    private final Map<String, Integer> aff;
    private final Map<String, String> config;
    private final String muc;
    private final String version;

    public Muc() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Muc copy$default(Muc muc, Map map, String str, String str2, Map map2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = muc.aff;
        }
        if ((i10 & 2) != 0) {
            str = muc.muc;
        }
        if ((i10 & 4) != 0) {
            str2 = muc.version;
        }
        if ((i10 & 8) != 0) {
            map2 = muc.config;
        }
        return muc.copy(map, str, str2, map2);
    }

    public final Map<String, Integer> component1() {
        return this.aff;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMuc() {
        return this.muc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> component4() {
        return this.config;
    }

    public final Muc copy(Map<String, Integer> aff, String muc, String version, Map<String, String> config) {
        y.i(aff, "aff");
        y.i(muc, "muc");
        y.i(version, "version");
        y.i(config, "config");
        return new Muc(aff, muc, version, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Muc)) {
            return false;
        }
        Muc muc = (Muc) other;
        return y.d(this.aff, muc.aff) && y.d(this.muc, muc.muc) && y.d(this.version, muc.version) && y.d(this.config, muc.config);
    }

    public final Map<String, Integer> getAff() {
        return this.aff;
    }

    public final Map<String, String> getConfig() {
        return this.config;
    }

    public final String getMuc() {
        return this.muc;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.aff.hashCode() * 31) + this.muc.hashCode()) * 31) + this.version.hashCode()) * 31) + this.config.hashCode();
    }

    public String toString() {
        return "Muc(aff=" + this.aff + ", muc=" + this.muc + ", version=" + this.version + ", config=" + this.config + ")";
    }

    public Muc(Map<String, Integer> aff, String muc, String version, Map<String, String> config) {
        y.i(aff, "aff");
        y.i(muc, "muc");
        y.i(version, "version");
        y.i(config, "config");
        this.aff = aff;
        this.muc = muc;
        this.version = version;
        this.config = config;
    }

    public /* synthetic */ Muc(Map map, String str, String str2, Map map2, int i10, p pVar) {
        this((i10 & 1) != 0 ? w0.i() : map, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? w0.i() : map2);
    }
}
