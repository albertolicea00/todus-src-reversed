package cu.z17.views.permission;

import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcu/z17/views/permission/PermissionsRequesterState;", "", "permissionsResult", "Lcu/z17/views/permission/PermissionsResult;", "open", "", "permissions", "", "Lcu/z17/views/permission/PermissionNeedIt;", "<init>", "(Lcu/z17/views/permission/PermissionsResult;ZLjava/util/List;)V", "getPermissionsResult", "()Lcu/z17/views/permission/PermissionsResult;", "getOpen", "()Z", "getPermissions", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PermissionsRequesterState {
    public static final int $stable = 0;
    private final boolean open;
    private final List<PermissionNeedIt> permissions;
    private final PermissionsResult permissionsResult;

    public PermissionsRequesterState() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionsRequesterState copy$default(PermissionsRequesterState permissionsRequesterState, PermissionsResult permissionsResult, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            permissionsResult = permissionsRequesterState.permissionsResult;
        }
        if ((i10 & 2) != 0) {
            z10 = permissionsRequesterState.open;
        }
        if ((i10 & 4) != 0) {
            list = permissionsRequesterState.permissions;
        }
        return permissionsRequesterState.copy(permissionsResult, z10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PermissionsResult getPermissionsResult() {
        return this.permissionsResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOpen() {
        return this.open;
    }

    public final List<PermissionNeedIt> component3() {
        return this.permissions;
    }

    public final PermissionsRequesterState copy(PermissionsResult permissionsResult, boolean open, List<? extends PermissionNeedIt> permissions) {
        kotlin.jvm.internal.y.i(permissionsResult, "permissionsResult");
        kotlin.jvm.internal.y.i(permissions, "permissions");
        return new PermissionsRequesterState(permissionsResult, open, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsRequesterState)) {
            return false;
        }
        PermissionsRequesterState permissionsRequesterState = (PermissionsRequesterState) other;
        return kotlin.jvm.internal.y.d(this.permissionsResult, permissionsRequesterState.permissionsResult) && this.open == permissionsRequesterState.open && kotlin.jvm.internal.y.d(this.permissions, permissionsRequesterState.permissions);
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final List<PermissionNeedIt> getPermissions() {
        return this.permissions;
    }

    public final PermissionsResult getPermissionsResult() {
        return this.permissionsResult;
    }

    public int hashCode() {
        return (((this.permissionsResult.hashCode() * 31) + androidx.camera.camera2.adapter.r.a(this.open)) * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "PermissionsRequesterState(permissionsResult=" + this.permissionsResult + ", open=" + this.open + ", permissions=" + this.permissions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionsRequesterState(PermissionsResult permissionsResult, boolean z10, List<? extends PermissionNeedIt> permissions) {
        kotlin.jvm.internal.y.i(permissionsResult, "permissionsResult");
        kotlin.jvm.internal.y.i(permissions, "permissions");
        this.permissionsResult = permissionsResult;
        this.open = z10;
        this.permissions = permissions;
    }

    public /* synthetic */ PermissionsRequesterState(PermissionsResult permissionsResult, boolean z10, List list, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? PermissionsResult.INSTANCE.request() : permissionsResult, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? va.w.n() : list);
    }
}
