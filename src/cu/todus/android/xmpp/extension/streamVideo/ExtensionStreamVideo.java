package cu.todus.android.xmpp.extension.streamVideo;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0019"}, d2 = {"Lcu/todus/android/xmpp/extension/streamVideo/ExtensionStreamVideo;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "error", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "getUrl", "getGetUrl", "setGetUrl", "streamUrl", "getStreamUrl", "setStreamUrl", "downloadUrl", "getDownloadUrl", "setDownloadUrl", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionStreamVideo implements ExtensionElement {
    public static final String ELEMENT = "streamvideo";
    public static final String NAMESPACE = "streamvideo:n";
    public static final String TAG_DOWNLOAD_URL = "du";
    public static final String TAG_ERROR_CODE = "ec";
    public static final String TAG_GET_URL = "gu";
    public static final String TAG_STREAM_URL = "su";
    public static final int $stable = 8;
    private String error = "";
    private String getUrl = "";
    private String streamUrl = "";
    private String downloadUrl = "";

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final String getError() {
        return this.error;
    }

    public final String getGetUrl() {
        return this.getUrl;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final void setDownloadUrl(String str) {
        y.i(str, "<set-?>");
        this.downloadUrl = str;
    }

    public final void setError(String str) {
        y.i(str, "<set-?>");
        this.error = str;
    }

    public final void setGetUrl(String str) {
        y.i(str, "<set-?>");
        this.getUrl = str;
    }

    public final void setStreamUrl(String str) {
        y.i(str, "<set-?>");
        this.streamUrl = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(TAG_GET_URL, this.getUrl);
        xmlStringBuilder.attribute("su", this.streamUrl);
        xmlStringBuilder.attribute(TAG_DOWNLOAD_URL, this.downloadUrl);
        xmlStringBuilder.attribute(TAG_ERROR_CODE, this.error);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
