package cu.z17.views.map;

import android.location.Location;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.z17.views.R;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcu/z17/views/map/Z17MapMarker;", "", "id", "", "latitude", "", "longitude", "altitude", "location", "Landroid/location/Location;", "accuracy", "", "icon", "", "<init>", "(Ljava/lang/String;DDDLandroid/location/Location;Ljava/lang/Float;I)V", "getId", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getAltitude", "getLocation", "()Landroid/location/Location;", "getAccuracy", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getIcon", "()I", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17MapMarker {
    public static final int $stable = 8;
    private final Float accuracy;
    private final double altitude;
    private final int icon;
    private final String id;
    private final double latitude;
    private final Location location;
    private final double longitude;

    public Z17MapMarker(String id2, double d10, double d11, double d12, Location location, Float f10, int i10) {
        y.i(id2, "id");
        this.id = id2;
        this.latitude = d10;
        this.longitude = d11;
        this.altitude = d12;
        this.location = location;
        this.accuracy = f10;
        this.icon = i10;
    }

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public /* synthetic */ Z17MapMarker(String str, double d10, double d11, double d12, Location location, Float f10, int i10, int i11, p pVar) {
        this(str, d10, d11, d12, (i11 & 16) != 0 ? null : location, (i11 & 32) != 0 ? null : f10, (i11 & 64) != 0 ? R.drawable.location_pointer : i10);
    }
}
