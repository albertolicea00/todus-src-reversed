package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/rest/response/LinkedDeviceLoginResponse;", "", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LinkedDeviceLoginResponse {
    public static final int $stable = 0;

    @c(LinkedDevice.COLUMN_ID)
    private final String sessionId;

    public LinkedDeviceLoginResponse(String sessionId) {
        y.i(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    public static /* synthetic */ LinkedDeviceLoginResponse copy$default(LinkedDeviceLoginResponse linkedDeviceLoginResponse, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = linkedDeviceLoginResponse.sessionId;
        }
        return linkedDeviceLoginResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final LinkedDeviceLoginResponse copy(String sessionId) {
        y.i(sessionId, "sessionId");
        return new LinkedDeviceLoginResponse(sessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LinkedDeviceLoginResponse) && y.d(this.sessionId, ((LinkedDeviceLoginResponse) other).sessionId);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return this.sessionId.hashCode();
    }

    public String toString() {
        return "LinkedDeviceLoginResponse(sessionId=" + this.sessionId + ")";
    }
}
