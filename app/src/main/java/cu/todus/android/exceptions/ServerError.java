package cu.todus.android.exceptions;

import java.util.Objects;

/**
 * Exception representing a server error with a raw error response body.
 *
 * @obfuscated_class cu.todus.android.exceptions.ServerError
 */
public final class ServerError extends ToDusException {
    private final String errorBody;

    public ServerError(String message, String errorBody) {
        super(Objects.requireNonNull(message, "message"), () -> {}, false);
        this.errorBody = Objects.requireNonNull(errorBody, "errorBody");
    }

    public String getErrorBody() {
        return this.errorBody;
    }
}
