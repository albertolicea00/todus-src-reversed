package cu.todus.android.exceptions;

/**
 * Exception thrown when writing a file fails.
 *
 * @obfuscated_class cu.todus.android.exceptions.FileWriterException
 */
public final class FileWriterException extends ToDusException {

    public FileWriterException() {
        super("write file error", () -> {}, false);
    }
}
