package cu.z17.views.permission;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcu/z17/views/permission/PermissionsResult;", "", "state", "", "<init>", "(Ljava/lang/Integer;)V", "getState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcu/z17/views/permission/PermissionsResult;", "equals", "", "other", "hashCode", "toString", "", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PermissionsResult {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer state;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcu/z17/views/permission/PermissionsResult$Companion;", "", "<init>", "()V", "granted", "Lcu/z17/views/permission/PermissionsResult;", "notGranted", NavLinks.LOADING, "request", "notRequest", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final PermissionsResult granted() {
            return new PermissionsResult(2);
        }

        public final PermissionsResult loading() {
            return new PermissionsResult(1);
        }

        public final PermissionsResult notGranted() {
            return new PermissionsResult(4);
        }

        public final PermissionsResult notRequest() {
            return new PermissionsResult(3);
        }

        public final PermissionsResult request() {
            return new PermissionsResult(0);
        }

        private Companion() {
        }
    }

    public PermissionsResult(Integer num) {
        this.state = num;
    }

    public static /* synthetic */ PermissionsResult copy$default(PermissionsResult permissionsResult, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = permissionsResult.state;
        }
        return permissionsResult.copy(num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getState() {
        return this.state;
    }

    public final PermissionsResult copy(Integer state) {
        return new PermissionsResult(state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PermissionsResult) && kotlin.jvm.internal.y.d(this.state, ((PermissionsResult) other).state);
    }

    public final Integer getState() {
        return this.state;
    }

    public int hashCode() {
        Integer num = this.state;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "PermissionsResult(state=" + this.state + ")";
    }
}
