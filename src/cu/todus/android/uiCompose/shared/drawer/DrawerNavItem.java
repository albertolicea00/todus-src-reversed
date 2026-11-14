package cu.todus.android.uiCompose.shared.drawer;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/todus/android/uiCompose/shared/drawer/DrawerNavItem;", "", "name", "", "route", "icon", "isDivider", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Z)V", "getName", "()Ljava/lang/String;", "getRoute", "getIcon", "()Ljava/lang/Object;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DrawerNavItem {
    public static final int $stable = 0;
    private final Object icon;
    private final boolean isDivider;
    private final String name;
    private final String route;

    public DrawerNavItem(String name, String route, Object obj, boolean z10) {
        y.i(name, "name");
        y.i(route, "route");
        this.name = name;
        this.route = route;
        this.icon = obj;
        this.isDivider = z10;
    }

    public static /* synthetic */ DrawerNavItem copy$default(DrawerNavItem drawerNavItem, String str, String str2, Object obj, boolean z10, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = drawerNavItem.name;
        }
        if ((i10 & 2) != 0) {
            str2 = drawerNavItem.route;
        }
        if ((i10 & 4) != 0) {
            obj = drawerNavItem.icon;
        }
        if ((i10 & 8) != 0) {
            z10 = drawerNavItem.isDivider;
        }
        return drawerNavItem.copy(str, str2, obj, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDivider() {
        return this.isDivider;
    }

    public final DrawerNavItem copy(String name, String route, Object icon, boolean isDivider) {
        y.i(name, "name");
        y.i(route, "route");
        return new DrawerNavItem(name, route, icon, isDivider);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawerNavItem)) {
            return false;
        }
        DrawerNavItem drawerNavItem = (DrawerNavItem) other;
        return y.d(this.name, drawerNavItem.name) && y.d(this.route, drawerNavItem.route) && y.d(this.icon, drawerNavItem.icon) && this.isDivider == drawerNavItem.isDivider;
    }

    public final Object getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoute() {
        return this.route;
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.route.hashCode()) * 31;
        Object obj = this.icon;
        return ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + r.a(this.isDivider);
    }

    public final boolean isDivider() {
        return this.isDivider;
    }

    public String toString() {
        return "DrawerNavItem(name=" + this.name + ", route=" + this.route + ", icon=" + this.icon + ", isDivider=" + this.isDivider + ")";
    }

    public /* synthetic */ DrawerNavItem(String str, String str2, Object obj, boolean z10, int i10, p pVar) {
        this(str, str2, (i10 & 4) != 0 ? null : obj, (i10 & 8) != 0 ? false : z10);
    }
}
