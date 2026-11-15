package cu.todus.android.exceptions;

import java.util.Objects;

/**
 * Exception representing an HTTP error status code and request type.
 *
 * @obfuscated_class cu.todus.android.exceptions.HTTPException
 */
public final class HTTPException extends ToDusException {
    private final int code;
    private final Companion.TYPE type;

    public static final class Companion {
        private Companion() {
        }

        public enum TYPE {
        }
    }

    public HTTPException(int code, Companion.TYPE type) {
        super("http error code: " + code, () -> {}, false);
        this.code = code;
        this.type = Objects.requireNonNull(type, "type");
    }

    public int getCode() {
        return this.code;
    }

    public Companion.TYPE getType() {
        return this.type;
    }

    public HTTPException copy(int code, Companion.TYPE type) {
        return new HTTPException(code, Objects.requireNonNull(type, "type"));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPException)) {
            return false;
        }
        HTTPException that = (HTTPException) other;
        return this.code == that.code && this.type == that.type;
    }

    @Override
    public int hashCode() {
        return (this.code * 31) + this.type.hashCode();
    }

    @Override
    public String toString() {
        return "HTTPException(code=" + this.code + ", type=" + this.type + ")";
    }
}
