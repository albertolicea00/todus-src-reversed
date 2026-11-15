package cu.todus.android.exceptions;

import java.util.Locale;
import java.util.Objects;

/**
 * Exception thrown during phone number reservation, SMS verification, or registration.
 *
 * @obfuscated_class cu.todus.android.exceptions.PhoneAuthException
 */
public final class PhoneAuthException extends ToDusException {
    private ERROR_TYPE errorType;

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
        INVALID_REQUEST
    }

    public PhoneAuthException(String message) {
        super(Objects.requireNonNull(message, "message"), () -> {}, false);
        String normalized = message.toUpperCase(Locale.ROOT).replace("-", "_");
        this.errorType = ERROR_TYPE.valueOf(normalized);
    }

    public PhoneAuthException(ERROR_TYPE errorType) {
        this(Objects.requireNonNull(errorType, "errorType").name());
        this.errorType = errorType;
    }

    public ERROR_TYPE getErrorType() {
        return this.errorType;
    }

    public void setErrorType(ERROR_TYPE errorType) {
        this.errorType = Objects.requireNonNull(errorType, "errorType");
    }
}
