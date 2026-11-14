package cu.todus.android.data.db.pojo.content;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.Immutable;
import cu.todus.android.xmpp.extension.location.ExtensionLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0082\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/pojo/content/LocationContent;", "Lcu/todus/android/data/db/pojo/content/Content;", ExtensionLocation.TAG_LAT, "", ExtensionLocation.TAG_LON, "zoom", "thumbnail", "", "<init>", "(DDDLjava/lang/String;)V", "getLat", "()D", "getLon", "getZoom", "getThumbnail", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class LocationContent extends Content {
    public static final int $stable = 0;
    private final double lat;
    private final double lon;
    private final String thumbnail;
    private final double zoom;

    public LocationContent() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return y.d(getClass(), other != null ? other.getClass() : null);
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final double getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationContent(double d10, double d11, double d12, String thumbnail) {
        super(10);
        y.i(thumbnail, "thumbnail");
        this.lat = d10;
        this.lon = d11;
        this.zoom = d12;
        this.thumbnail = thumbnail;
    }

    public /* synthetic */ LocationContent(double d10, double d11, double d12, String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? 0.0d : d10, (i10 & 2) != 0 ? 0.0d : d11, (i10 & 4) != 0 ? 0.0d : d12, (i10 & 8) != 0 ? "" : str);
    }
}
