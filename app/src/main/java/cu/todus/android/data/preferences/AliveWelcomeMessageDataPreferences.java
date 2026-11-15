package cu.todus.android.data.preferences;

/**
 * Preferences state for tracking Alive welcome message display counts.
 *
 * @obfuscated_class cu.todus.android.data.preferences.AliveWelcomeMessageDataPreferences
 */
public final class AliveWelcomeMessageDataPreferences {
    private final boolean mockupSaved;
    private final int lastShowed;
    private final int actualMax;

    public AliveWelcomeMessageDataPreferences() {
        this(false, 0, 0);
    }

    public AliveWelcomeMessageDataPreferences(boolean mockupSaved, int lastShowed, int actualMax) {
        this.mockupSaved = mockupSaved;
        this.lastShowed = lastShowed;
        this.actualMax = actualMax;
    }

    public boolean getMockupSaved() {
        return this.mockupSaved;
    }

    public int getLastShowed() {
        return this.lastShowed;
    }

    public int getActualMax() {
        return this.actualMax;
    }

    public AliveWelcomeMessageDataPreferences copy(boolean mockupSaved, int lastShowed, int actualMax) {
        return new AliveWelcomeMessageDataPreferences(mockupSaved, lastShowed, actualMax);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AliveWelcomeMessageDataPreferences)) {
            return false;
        }
        AliveWelcomeMessageDataPreferences that = (AliveWelcomeMessageDataPreferences) other;
        return this.mockupSaved == that.mockupSaved
                && this.lastShowed == that.lastShowed
                && this.actualMax == that.actualMax;
    }

    @Override
    public int hashCode() {
        return (((Boolean.hashCode(this.mockupSaved) * 31) + this.lastShowed) * 31) + this.actualMax;
    }

    @Override
    public String toString() {
        return "AliveWelcomeMessageDataPreferences(mockupSaved=" + this.mockupSaved
                + ", lastShowed=" + this.lastShowed
                + ", actualMax=" + this.actualMax + ")";
    }
}
