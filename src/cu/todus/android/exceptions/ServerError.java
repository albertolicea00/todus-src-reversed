package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/exceptions/ServerError;", "Lcu/todus/android/exceptions/ToDusException;", "message", "", "errorBody", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorBody", "()Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServerError extends ToDusException {
    public static final int $stable = 8;
    private final String errorBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerError(String message, String errorBody) {
        super(message, null, false, 6, null);
        y.i(message, "message");
        y.i(errorBody, "errorBody");
        this.errorBody = errorBody;
    }

    public final String getErrorBody() {
        return this.errorBody;
    }
}
