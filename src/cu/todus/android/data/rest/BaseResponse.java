package cu.todus.android.data.rest;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/rest/BaseResponse;", "", "success", "", "message", "error", "errorType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Ljava/lang/String;", "setSuccess", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getError", "setError", "getErrorType", "setErrorType", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class BaseResponse {
    public static final int $stable = 8;
    private String error;
    private String errorType;
    private String message;
    private String success;

    public BaseResponse(String success, String str, String str2, String str3) {
        y.i(success, "success");
        this.success = success;
        this.message = str;
        this.error = str2;
        this.errorType = str3;
    }

    public final String getError() {
        return this.error;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSuccess() {
        return this.success;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final void setErrorType(String str) {
        this.errorType = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setSuccess(String str) {
        y.i(str, "<set-?>");
        this.success = str;
    }

    public /* synthetic */ BaseResponse(String str, String str2, String str3, String str4, int i10, p pVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
