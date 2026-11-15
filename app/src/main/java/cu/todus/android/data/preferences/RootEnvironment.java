package cu.todus.android.data.preferences;

import cu.todus.android.constants.Service;
import java.util.Objects;

/**
 * Persisted active server environment and root base URL.
 *
 * @obfuscated_class cu.todus.android.data.preferences.RootEnvironment
 */
public final class RootEnvironment {
    private final Service.ApplicationEnvironment applicationEnvironment;
    private final String rootUrl;

    public RootEnvironment(Service.ApplicationEnvironment applicationEnvironment, String rootUrl) {
        this.applicationEnvironment = Objects.requireNonNull(applicationEnvironment, "applicationEnvironment");
        this.rootUrl = Objects.requireNonNull(rootUrl, "rootUrl");
    }

    public Service.ApplicationEnvironment getApplicationEnvironment() {
        return this.applicationEnvironment;
    }

    public String getRootUrl() {
        return this.rootUrl;
    }

    public RootEnvironment copy(Service.ApplicationEnvironment applicationEnvironment, String rootUrl) {
        return new RootEnvironment(
                Objects.requireNonNull(applicationEnvironment, "applicationEnvironment"),
                Objects.requireNonNull(rootUrl, "rootUrl")
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RootEnvironment)) {
            return false;
        }
        RootEnvironment that = (RootEnvironment) other;
        return this.applicationEnvironment == that.applicationEnvironment
                && Objects.equals(this.rootUrl, that.rootUrl);
    }

    @Override
    public int hashCode() {
        return (this.applicationEnvironment.hashCode() * 31) + this.rootUrl.hashCode();
    }

    @Override
    public String toString() {
        return "RootEnvironment(applicationEnvironment=" + this.applicationEnvironment
                + ", rootUrl=" + this.rootUrl + ")";
    }
}
