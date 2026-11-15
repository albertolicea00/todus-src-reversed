package cu.todus.android.exceptions;

/**
 * Exception thrown when authentication fails.
 *
 * @obfuscated_class cu.todus.android.exceptions.AuthenticationException
 */
public final class AuthenticationException extends ToDusException {

    public AuthenticationException() {
        super("auth error", () -> {}, false);
    }
}
