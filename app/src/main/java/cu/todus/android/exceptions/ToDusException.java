package cu.todus.android.exceptions;

import java.util.Objects;

/**
 * Base application exception carrying an optional retry callback and retryability flag.
 *
 * @obfuscated_class cu.todus.android.exceptions.ToDusException
 */
public class ToDusException extends Exception {
    private final Runnable retryFunction;
    private final boolean canRetry;

    public ToDusException() {
        this("", () -> {}, false);
    }

    public ToDusException(String message, Runnable retryFunction, boolean canRetry) {
        super(Objects.requireNonNull(message, "message"));
        this.retryFunction = Objects.requireNonNull(retryFunction, "retryFunction");
        this.canRetry = canRetry;
    }

    public Runnable getRetryFunction() {
        return this.retryFunction;
    }

    public boolean getCanRetry() {
        return this.canRetry;
    }
}
