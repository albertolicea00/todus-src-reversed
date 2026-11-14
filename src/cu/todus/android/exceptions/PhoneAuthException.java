package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import db.a;
import db.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcu/todus/android/exceptions/PhoneAuthException;", "Lcu/todus/android/exceptions/ToDusException;", "message", "", "<init>", "(Ljava/lang/String;)V", "errorType", "Lcu/todus/android/exceptions/PhoneAuthException$ERROR_TYPE;", "(Lcu/todus/android/exceptions/PhoneAuthException$ERROR_TYPE;)V", "getErrorType", "()Lcu/todus/android/exceptions/PhoneAuthException$ERROR_TYPE;", "setErrorType", "ERROR_TYPE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PhoneAuthException extends ToDusException {
    public static final int $stable = 8;
    private ERROR_TYPE errorType;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcu/todus/android/exceptions/PhoneAuthException$ERROR_TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_PHONE_NUMBER", "NOT_CUBAN_PHONE_NUMBER", "INSECURE_TOKEN", "CLIENT_TOKEN_MISMATCH", "SMS_CODE_MISMATCH", "USER_NOT_RESERVED", "RESERVATION_EXPIRED", "USER_LOGGED", "USER_NOT_TODUS", "NETWORK_ERROR", "ERROR_SEND_SMS", "INTERNAL_ERROR", "INVALID_REQUEST", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum ERROR_TYPE {
        INVALID_PHONE_NUMBER,
        NOT_CUBAN_PHONE_NUMBER,
        INSECURE_TOKEN,
        CLIENT_TOKEN_MISMATCH,
        SMS_CODE_MISMATCH,
        USER_NOT_RESERVED,
        RESERVATION_EXPIRED,
        USER_LOGGED,
        USER_NOT_TODUS,
        NETWORK_ERROR,
        ERROR_SEND_SMS,
        INTERNAL_ERROR,
        INVALID_REQUEST;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneAuthException(String message) {
        super(message, null, false, 6, null);
        y.i(message, "message");
        Locale ROOT = Locale.ROOT;
        y.h(ROOT, "ROOT");
        String upperCase = message.toUpperCase(ROOT);
        y.h(upperCase, "toUpperCase(...)");
        this.errorType = ERROR_TYPE.valueOf(a0.O(upperCase, "-", "_", false, 4, null));
    }

    public final ERROR_TYPE getErrorType() {
        return this.errorType;
    }

    public final void setErrorType(ERROR_TYPE error_type) {
        y.i(error_type, "<set-?>");
        this.errorType = error_type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhoneAuthException(ERROR_TYPE errorType) {
        this(errorType.name());
        y.i(errorType, "errorType");
        this.errorType = errorType;
    }
}
