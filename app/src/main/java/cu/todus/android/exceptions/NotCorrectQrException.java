package cu.todus.android.exceptions;

import cu.todus.android.R;
import cu.todus.android.di.MainModule;

/**
 * Exception thrown when a scanned QR code is invalid.
 *
 * @obfuscated_class cu.todus.android.exceptions.NotCorrectQrException
 */
public final class NotCorrectQrException extends ToDusException {

    public NotCorrectQrException() {
        super(MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.wrong_qr_code), () -> {}, false);
    }
}
