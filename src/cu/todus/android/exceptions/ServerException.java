package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/exceptions/ServerException;", "Lcu/todus/android/exceptions/ToDusException;", "message", "", "code", "", "<init>", "(Ljava/lang/String;I)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getCode", "()I", "setCode$app_productionPFast", "(I)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServerException extends ToDusException {
    public static final int $stable = 8;
    private int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerException(String message, int i10) {
        super(message, null, false, 6, null);
        y.i(message, "message");
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode$app_productionPFast(int i10) {
        this.code = i10;
    }
}
