package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Entity(tableName = "roster_change")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJd\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\rHÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/RosterChange;", "", "id", "", "phone", "", "changeType", "timestamp", "previousName", "currentName", "synced", "", "targetVersion", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)V", "getId", "()J", "getPhone", "()Ljava/lang/String;", "getChangeType", "getTimestamp", "getPreviousName", "getCurrentName", "getSynced", "()Z", "getTargetVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Lcu/todus/android/data/db/entity/toDus/RosterChange;", "equals", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RosterChange {
    public static final int $stable = 0;
    public static final String TYPE_ADD = "ADD";
    public static final String TYPE_DELETE = "DELETE";
    public static final String TYPE_UPDATE = "UPDATE";
    private final String changeType;
    private final String currentName;

    @PrimaryKey(autoGenerate = true)
    private final long id;
    private final String phone;
    private final String previousName;
    private final boolean synced;
    private final Integer targetVersion;
    private final long timestamp;

    public RosterChange(long j10, String phone, String changeType, long j11, String str, String str2, boolean z10, Integer num) {
        y.i(phone, "phone");
        y.i(changeType, "changeType");
        this.id = j10;
        this.phone = phone;
        this.changeType = changeType;
        this.timestamp = j11;
        this.previousName = str;
        this.currentName = str2;
        this.synced = z10;
        this.targetVersion = num;
    }

    public static /* synthetic */ RosterChange copy$default(RosterChange rosterChange, long j10, String str, String str2, long j11, String str3, String str4, boolean z10, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = rosterChange.id;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = rosterChange.phone;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = rosterChange.changeType;
        }
        return rosterChange.copy(j12, str5, str2, (i10 & 8) != 0 ? rosterChange.timestamp : j11, (i10 & 16) != 0 ? rosterChange.previousName : str3, (i10 & 32) != 0 ? rosterChange.currentName : str4, (i10 & 64) != 0 ? rosterChange.synced : z10, (i10 & 128) != 0 ? rosterChange.targetVersion : num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChangeType() {
        return this.changeType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPreviousName() {
        return this.previousName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCurrentName() {
        return this.currentName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSynced() {
        return this.synced;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getTargetVersion() {
        return this.targetVersion;
    }

    public final RosterChange copy(long id2, String phone, String changeType, long timestamp, String previousName, String currentName, boolean synced, Integer targetVersion) {
        y.i(phone, "phone");
        y.i(changeType, "changeType");
        return new RosterChange(id2, phone, changeType, timestamp, previousName, currentName, synced, targetVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RosterChange)) {
            return false;
        }
        RosterChange rosterChange = (RosterChange) other;
        return this.id == rosterChange.id && y.d(this.phone, rosterChange.phone) && y.d(this.changeType, rosterChange.changeType) && this.timestamp == rosterChange.timestamp && y.d(this.previousName, rosterChange.previousName) && y.d(this.currentName, rosterChange.currentName) && this.synced == rosterChange.synced && y.d(this.targetVersion, rosterChange.targetVersion);
    }

    public final String getChangeType() {
        return this.changeType;
    }

    public final String getCurrentName() {
        return this.currentName;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPreviousName() {
        return this.previousName;
    }

    public final boolean getSynced() {
        return this.synced;
    }

    public final Integer getTargetVersion() {
        return this.targetVersion;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iA = ((((((l.a(this.id) * 31) + this.phone.hashCode()) * 31) + this.changeType.hashCode()) * 31) + l.a(this.timestamp)) * 31;
        String str = this.previousName;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currentName;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + r.a(this.synced)) * 31;
        Integer num = this.targetVersion;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "RosterChange(id=" + this.id + ", phone=" + this.phone + ", changeType=" + this.changeType + ", timestamp=" + this.timestamp + ", previousName=" + this.previousName + ", currentName=" + this.currentName + ", synced=" + this.synced + ", targetVersion=" + this.targetVersion + ")";
    }

    public /* synthetic */ RosterChange(long j10, String str, String str2, long j11, String str3, String str4, boolean z10, Integer num, int i10, p pVar) {
        this((i10 & 1) != 0 ? 0L : j10, str, str2, (i10 & 8) != 0 ? System.currentTimeMillis() : j11, str3, str4, (i10 & 64) != 0 ? false : z10, (i10 & 128) != 0 ? null : num);
    }
}
