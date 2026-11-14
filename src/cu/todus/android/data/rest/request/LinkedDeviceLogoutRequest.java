package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/rest/request/LinkedDeviceLogoutRequest;", "", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceLogoutRequest {
    public static final int $stable = 0;

    @c(LinkedDevice.COLUMN_ID)
    private final String sessionId;

    public LinkedDeviceLogoutRequest(String sessionId) {
        y.i(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
