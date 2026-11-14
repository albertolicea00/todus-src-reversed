package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/db/pojo/StatusForPagination;", "", "index", "", "status", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "<init>", "(ILcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;)V", "getIndex", "()I", "getStatus", "()Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StatusForPagination {
    public static final int $stable = 0;
    private final int index;
    private final StatusWithPartnersOrRooms status;

    public StatusForPagination(int i10, StatusWithPartnersOrRooms status) {
        y.i(status, "status");
        this.index = i10;
        this.status = status;
    }

    public static /* synthetic */ StatusForPagination copy$default(StatusForPagination statusForPagination, int i10, StatusWithPartnersOrRooms statusWithPartnersOrRooms, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = statusForPagination.index;
        }
        if ((i11 & 2) != 0) {
            statusWithPartnersOrRooms = statusForPagination.status;
        }
        return statusForPagination.copy(i10, statusWithPartnersOrRooms);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StatusWithPartnersOrRooms getStatus() {
        return this.status;
    }

    public final StatusForPagination copy(int index, StatusWithPartnersOrRooms status) {
        y.i(status, "status");
        return new StatusForPagination(index, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusForPagination)) {
            return false;
        }
        StatusForPagination statusForPagination = (StatusForPagination) other;
        return this.index == statusForPagination.index && y.d(this.status, statusForPagination.status);
    }

    public final int getIndex() {
        return this.index;
    }

    public final StatusWithPartnersOrRooms getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.index * 31) + this.status.hashCode();
    }

    public String toString() {
        return "StatusForPagination(index=" + this.index + ", status=" + this.status + ")";
    }

    public /* synthetic */ StatusForPagination(int i10, StatusWithPartnersOrRooms statusWithPartnersOrRooms, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, statusWithPartnersOrRooms);
    }
}
