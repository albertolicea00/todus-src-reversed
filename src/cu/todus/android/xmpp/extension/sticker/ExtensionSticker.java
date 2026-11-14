package cu.todus.android.xmpp.extension.sticker;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006("}, d2 = {"Lcu/todus/android/xmpp/extension/sticker/ExtensionSticker;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", "name", "getName", "setName", "folder", "getFolder", "setFolder", "url", "getUrl", "setUrl", "size", "", "getSize", "()J", "setSize", "(J)V", "hash", "getHash", "setHash", ExtensionSticker.TAG_JSON, "getJson", "setJson", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionSticker implements ExtensionElement {
    public static final String ELEMENT = "sticker";
    public static final String NAMESPACE = "sticker:n";
    public static final String TAG_FOLDER = "f";
    public static final String TAG_HASH = "h";
    public static final String TAG_ID = "i";
    public static final String TAG_JSON = "json";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_NAME = "n";
    public static final String TAG_SIZE = "s";
    public static final String TAG_TYPE = "t";
    public static final String TAG_URL = "url";
    private long size;
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";
    private String name = "";
    private String folder = "";
    private String url = "";
    private String hash = "";
    private String json = "";

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "sticker";
    }

    public final String getFolder() {
        return this.folder;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getId() {
        return this.id;
    }

    public final String getJson() {
        return this.json;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setFolder(String str) {
        y.i(str, "<set-?>");
        this.folder = str;
    }

    public final void setHash(String str) {
        y.i(str, "<set-?>");
        this.hash = str;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setJson(String str) {
        y.i(str, "<set-?>");
        this.json = str;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void setName(String str) {
        y.i(str, "<set-?>");
        this.name = str;
    }

    public final void setSize(long j10) {
        this.size = j10;
    }

    public final void setUrl(String str) {
        y.i(str, "<set-?>");
        this.url = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute("n", this.name);
        xmlStringBuilder.attribute(TAG_FOLDER, this.folder);
        xmlStringBuilder.attribute("url", this.url);
        xmlStringBuilder.attribute("s", (int) this.size);
        xmlStringBuilder.attribute("h", this.hash);
        xmlStringBuilder.attribute(TAG_JSON, this.json);
        xmlStringBuilder.closeEmptyElement();
        String string = xmlStringBuilder.toString();
        y.h(string, "toString(...)");
        return string;
    }
}
