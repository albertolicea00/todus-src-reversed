package cu.todus.android.data.preferences;

import java.util.Objects;

/**
 * Persisted onboarding and authentication state for the local client.
 *
 * @obfuscated_class cu.todus.android.data.preferences.AppState
 */
public final class AppState {
    private final AppStateStep appStep;
    private final String savedNumber;
    private final String clientUid;
    private final int countryCode;
    private final long lastTimeSmsWaSent;

    public AppState() {
        this(AppStateStep.NEW_USER, "", "", 53, 0L);
    }

    public AppState(AppStateStep appStep, String savedNumber, String clientUid, int countryCode, long lastTimeSmsWaSent) {
        this.appStep = Objects.requireNonNull(appStep, "appStep");
        this.savedNumber = Objects.requireNonNull(savedNumber, "savedNumber");
        this.clientUid = Objects.requireNonNull(clientUid, "clientUid");
        this.countryCode = countryCode;
        this.lastTimeSmsWaSent = lastTimeSmsWaSent;
    }

    public AppStateStep getAppStep() {
        return this.appStep;
    }

    public String getSavedNumber() {
        return this.savedNumber;
    }

    public String getClientUid() {
        return this.clientUid;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public long getLastTimeSmsWaSent() {
        return this.lastTimeSmsWaSent;
    }

    public AppState copy(AppStateStep appStep, String savedNumber, String clientUid, int countryCode, long lastTimeSmsWaSent) {
        return new AppState(
                Objects.requireNonNull(appStep, "appStep"),
                Objects.requireNonNull(savedNumber, "savedNumber"),
                Objects.requireNonNull(clientUid, "clientUid"),
                countryCode,
                lastTimeSmsWaSent
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppState)) {
            return false;
        }
        AppState that = (AppState) other;
        return this.appStep == that.appStep
                && Objects.equals(this.savedNumber, that.savedNumber)
                && Objects.equals(this.clientUid, that.clientUid)
                && this.countryCode == that.countryCode
                && this.lastTimeSmsWaSent == that.lastTimeSmsWaSent;
    }

    @Override
    public int hashCode() {
        return (((((((this.appStep.hashCode() * 31)
                + this.savedNumber.hashCode()) * 31)
                + this.clientUid.hashCode()) * 31)
                + this.countryCode) * 31)
                + Long.hashCode(this.lastTimeSmsWaSent);
    }

    @Override
    public String toString() {
        return "AppState(appStep=" + this.appStep
                + ", savedNumber=" + this.savedNumber
                + ", clientUid=" + this.clientUid
                + ", countryCode=" + this.countryCode
                + ", lastTimeSmsWaSent=" + this.lastTimeSmsWaSent + ")";
    }
}
