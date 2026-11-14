package cu.todus.android.xmpp.extension.location;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\""}, d2 = {"Lcu/todus/android/xmpp/extension/location/ExtensionLocation;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", ExtensionLocation.TAG_LAT, "", "getLat", "()D", "setLat", "(D)V", ExtensionLocation.TAG_LON, "getLon", "setLon", "zoom", "getZoom", "setZoom", "thumbnails", "getThumbnails", "setThumbnails", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionLocation implements ExtensionElement {
    public static final String ELEMENT = "location";
    public static final String NAMESPACE = "location:n";
    public static final String TAG_ID = "i";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LON = "lon";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_THUMBNAILS = "t";
    public static final String TAG_ZOOM = "z";
    private double zoom;
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";
    private double lat = -1.0d;
    private double lon = -1.0d;
    private String thumbnails = "";

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "location";
    }

    public final String getId() {
        return this.id;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final String getThumbnails() {
        return this.thumbnails;
    }

    public final double getZoom() {
        return this.zoom;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setLat(double d10) {
        this.lat = d10;
    }

    public final void setLon(double d10) {
        this.lon = d10;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setThumbnails(String str) {
        y.i(str, "<set-?>");
        this.thumbnails = str;
    }

    public final void setZoom(double d10) {
        this.zoom = d10;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute(TAG_LAT, String.valueOf(this.lat));
        xmlStringBuilder.attribute(TAG_LON, String.valueOf(this.lon));
        xmlStringBuilder.attribute(TAG_ZOOM, String.valueOf(this.zoom));
        xmlStringBuilder.attribute("t", this.thumbnails);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
