package cu.todus.android.data.migration;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ2\u0010\u000f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022*\b\u0002\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\rR9\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcu/todus/android/data/migration/ToDusMigration;", "", "", "startVersion", "endVersion", "Lkotlin/Function2;", "Lkotlin/Function0;", "Lua/k0;", "Lab/e;", "migrate", "<init>", "(IILkotlin/jvm/functions/Function2;)V", "component1", "()I", "component2", "component3", "()Lkotlin/jvm/functions/Function2;", "copy", "(IILkotlin/jvm/functions/Function2;)Lcu/todus/android/data/migration/ToDusMigration;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStartVersion", "getEndVersion", "Lkotlin/jvm/functions/Function2;", "getMigrate", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ToDusMigration {
    public static final int $stable = 8;
    private final int endVersion;
    private final Function2 migrate;
    private final int startVersion;

    public ToDusMigration(int i10, int i11, Function2 migrate) {
        y.i(migrate, "migrate");
        this.startVersion = i10;
        this.endVersion = i11;
        this.migrate = migrate;
    }

    public static /* synthetic */ ToDusMigration copy$default(ToDusMigration toDusMigration, int i10, int i11, Function2 function2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = toDusMigration.startVersion;
        }
        if ((i12 & 2) != 0) {
            i11 = toDusMigration.endVersion;
        }
        if ((i12 & 4) != 0) {
            function2 = toDusMigration.migrate;
        }
        return toDusMigration.copy(i10, i11, function2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStartVersion() {
        return this.startVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEndVersion() {
        return this.endVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Function2 getMigrate() {
        return this.migrate;
    }

    public final ToDusMigration copy(int startVersion, int endVersion, Function2 migrate) {
        y.i(migrate, "migrate");
        return new ToDusMigration(startVersion, endVersion, migrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToDusMigration)) {
            return false;
        }
        ToDusMigration toDusMigration = (ToDusMigration) other;
        return this.startVersion == toDusMigration.startVersion && this.endVersion == toDusMigration.endVersion && y.d(this.migrate, toDusMigration.migrate);
    }

    public final int getEndVersion() {
        return this.endVersion;
    }

    public final Function2 getMigrate() {
        return this.migrate;
    }

    public final int getStartVersion() {
        return this.startVersion;
    }

    public int hashCode() {
        return (((this.startVersion * 31) + this.endVersion) * 31) + this.migrate.hashCode();
    }

    public String toString() {
        return "ToDusMigration(startVersion=" + this.startVersion + ", endVersion=" + this.endVersion + ", migrate=" + this.migrate + ")";
    }
}
