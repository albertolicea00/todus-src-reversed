package cu.todus.android.data.preferences;

/**
 * Registration and login flow states persisted in application preferences.
 *
 * @obfuscated_class cu.todus.android.data.preferences.AppStateStep
 */
public enum AppStateStep {
    LOADING,
    NEW_USER,
    BANNED,
    WRONG_AUTH,
    WAITING_VERIFY,
    WAITING_REGISTER,
    WAITING_COMPLETE_PROFILE,
    UPDATE_REQUIRED,
    LOGIN_COMPLETED
}
