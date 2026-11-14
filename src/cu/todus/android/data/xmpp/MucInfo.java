package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jf\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006)"}, d2 = {"Lcu/todus/android/data/xmpp/MucInfo;", "", "luser", "", "lserver", "version", Room.CONFIG_CONFIG, "", "admins", "", "cant_affs", "", UserRoomJoin.COLUMN_AFFILIATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/String;ILjava/lang/String;)V", "getLuser", "()Ljava/lang/String;", "getLserver", "getVersion", "getConfig", "()Ljava/util/Map;", "getAdmins", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCant_affs", "()I", "getAffiliation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/String;ILjava/lang/String;)Lcu/todus/android/data/xmpp/MucInfo;", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MucInfo {
    public static final int $stable = 8;
    private final String[] admins;
    private final String affiliation;
    private final int cant_affs;
    private final Map<String, String> config;
    private final String lserver;
    private final String luser;
    private final String version;

    public MucInfo(String luser, String lserver, String version, Map<String, String> config, String[] admins, int i10, String affiliation) {
        y.i(luser, "luser");
        y.i(lserver, "lserver");
        y.i(version, "version");
        y.i(config, "config");
        y.i(admins, "admins");
        y.i(affiliation, "affiliation");
        this.luser = luser;
        this.lserver = lserver;
        this.version = version;
        this.config = config;
        this.admins = admins;
        this.cant_affs = i10;
        this.affiliation = affiliation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MucInfo copy$default(MucInfo mucInfo, String str, String str2, String str3, Map map, String[] strArr, int i10, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mucInfo.luser;
        }
        if ((i11 & 2) != 0) {
            str2 = mucInfo.lserver;
        }
        if ((i11 & 4) != 0) {
            str3 = mucInfo.version;
        }
        if ((i11 & 8) != 0) {
            map = mucInfo.config;
        }
        if ((i11 & 16) != 0) {
            strArr = mucInfo.admins;
        }
        if ((i11 & 32) != 0) {
            i10 = mucInfo.cant_affs;
        }
        if ((i11 & 64) != 0) {
            str4 = mucInfo.affiliation;
        }
        int i12 = i10;
        String str5 = str4;
        String[] strArr2 = strArr;
        String str6 = str3;
        return mucInfo.copy(str, str2, str6, map, strArr2, i12, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLuser() {
        return this.luser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLserver() {
        return this.lserver;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> component4() {
        return this.config;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String[] getAdmins() {
        return this.admins;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCant_affs() {
        return this.cant_affs;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAffiliation() {
        return this.affiliation;
    }

    public final MucInfo copy(String luser, String lserver, String version, Map<String, String> config, String[] admins, int cant_affs, String affiliation) {
        y.i(luser, "luser");
        y.i(lserver, "lserver");
        y.i(version, "version");
        y.i(config, "config");
        y.i(admins, "admins");
        y.i(affiliation, "affiliation");
        return new MucInfo(luser, lserver, version, config, admins, cant_affs, affiliation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MucInfo)) {
            return false;
        }
        MucInfo mucInfo = (MucInfo) other;
        return y.d(this.luser, mucInfo.luser) && y.d(this.lserver, mucInfo.lserver) && y.d(this.version, mucInfo.version) && y.d(this.config, mucInfo.config) && y.d(this.admins, mucInfo.admins) && this.cant_affs == mucInfo.cant_affs && y.d(this.affiliation, mucInfo.affiliation);
    }

    public final String[] getAdmins() {
        return this.admins;
    }

    public final String getAffiliation() {
        return this.affiliation;
    }

    public final int getCant_affs() {
        return this.cant_affs;
    }

    public final Map<String, String> getConfig() {
        return this.config;
    }

    public final String getLserver() {
        return this.lserver;
    }

    public final String getLuser() {
        return this.luser;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((this.luser.hashCode() * 31) + this.lserver.hashCode()) * 31) + this.version.hashCode()) * 31) + this.config.hashCode()) * 31) + Arrays.hashCode(this.admins)) * 31) + this.cant_affs) * 31) + this.affiliation.hashCode();
    }

    public String toString() {
        return "MucInfo(luser=" + this.luser + ", lserver=" + this.lserver + ", version=" + this.version + ", config=" + this.config + ", admins=" + Arrays.toString(this.admins) + ", cant_affs=" + this.cant_affs + ", affiliation=" + this.affiliation + ")";
    }

    public /* synthetic */ MucInfo(String str, String str2, String str3, Map map, String[] strArr, int i10, String str4, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? w0.i() : map, strArr, i10, (i11 & 64) != 0 ? "none" : str4);
    }
}
