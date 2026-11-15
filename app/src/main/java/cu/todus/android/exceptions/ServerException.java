package cu.todus.android.exceptions;

import java.util.Objects;

/**
 * Exception representing a server error with a numeric error code.
 *
 * @obfuscated_class cu.todus.android.exceptions.ServerException
 */
public final class ServerException extends ToDusException {
    private int code;

    public ServerException(String message, int code) {
        super(Objects.requireNonNull(message, "message"), () -> {}, false);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
