package cu.todus.android.data.preferences;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/preferences/RootEnvironment;", "", "applicationEnvironment", "Lcu/todus/android/constants/Service$ApplicationEnvironment;", "rootUrl", "", "<init>", "(Lcu/todus/android/constants/Service$ApplicationEnvironment;Ljava/lang/String;)V", "getApplicationEnvironment", "()Lcu/todus/android/constants/Service$ApplicationEnvironment;", "getRootUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RootEnvironment {
    public static final int $stable = 0;
    private final Service.ApplicationEnvironment applicationEnvironment;
    private final String rootUrl;

    public RootEnvironment(Service.ApplicationEnvironment applicationEnvironment, String rootUrl) {
        y.i(applicationEnvironment, "applicationEnvironment");
        y.i(rootUrl, "rootUrl");
        this.applicationEnvironment = applicationEnvironment;
        this.rootUrl = rootUrl;
    }

    public static /* synthetic */ RootEnvironment copy$default(RootEnvironment rootEnvironment, Service.ApplicationEnvironment applicationEnvironment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            applicationEnvironment = rootEnvironment.applicationEnvironment;
        }
        if ((i10 & 2) != 0) {
            str = rootEnvironment.rootUrl;
        }
        return rootEnvironment.copy(applicationEnvironment, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Service.ApplicationEnvironment getApplicationEnvironment() {
        return this.applicationEnvironment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRootUrl() {
        return this.rootUrl;
    }

    public final RootEnvironment copy(Service.ApplicationEnvironment applicationEnvironment, String rootUrl) {
        y.i(applicationEnvironment, "applicationEnvironment");
        y.i(rootUrl, "rootUrl");
        return new RootEnvironment(applicationEnvironment, rootUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RootEnvironment)) {
            return false;
        }
        RootEnvironment rootEnvironment = (RootEnvironment) other;
        return this.applicationEnvironment == rootEnvironment.applicationEnvironment && y.d(this.rootUrl, rootEnvironment.rootUrl);
    }

    public final Service.ApplicationEnvironment getApplicationEnvironment() {
        return this.applicationEnvironment;
    }

    public final String getRootUrl() {
        return this.rootUrl;
    }

    public int hashCode() {
        return (this.applicationEnvironment.hashCode() * 31) + this.rootUrl.hashCode();
    }

    public String toString() {
        return "RootEnvironment(applicationEnvironment=" + this.applicationEnvironment + ", rootUrl=" + this.rootUrl + ")";
    }
}
