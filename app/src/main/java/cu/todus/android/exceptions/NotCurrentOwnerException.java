package cu.todus.android.exceptions;

import cu.todus.android.R;
import cu.todus.android.di.MainModule;

/**
 * Exception thrown when an operation is attempted for a non-current account owner.
 *
 * @obfuscated_class cu.todus.android.exceptions.NotCurrentOwnerException
 */
public final class NotCurrentOwnerException extends ToDusException {

    public NotCurrentOwnerException() {
        super(MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.owner_init_error), () -> {}, false);
    }
}
