package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcu/todus/android/data/rest/response/LinkedDevicesResponse;", "", "sessions", "", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "<init>", "(Ljava/util/List;)V", "getSessions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LinkedDevicesResponse {
    public static final int $stable = 8;

    @c("sessions")
    private final List<LinkedDevice> sessions;

    public LinkedDevicesResponse(List<LinkedDevice> sessions) {
        y.i(sessions, "sessions");
        this.sessions = sessions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkedDevicesResponse copy$default(LinkedDevicesResponse linkedDevicesResponse, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = linkedDevicesResponse.sessions;
        }
        return linkedDevicesResponse.copy(list);
    }

    public final List<LinkedDevice> component1() {
        return this.sessions;
    }

    public final LinkedDevicesResponse copy(List<LinkedDevice> sessions) {
        y.i(sessions, "sessions");
        return new LinkedDevicesResponse(sessions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LinkedDevicesResponse) && y.d(this.sessions, ((LinkedDevicesResponse) other).sessions);
    }

    public final List<LinkedDevice> getSessions() {
        return this.sessions;
    }

    public int hashCode() {
        return this.sessions.hashCode();
    }

    public String toString() {
        return "LinkedDevicesResponse(sessions=" + this.sessions + ")";
    }
}
