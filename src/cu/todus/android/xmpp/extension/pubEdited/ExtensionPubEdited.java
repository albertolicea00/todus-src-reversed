package cu.todus.android.xmpp.extension.pubEdited;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0013"}, d2 = {"Lcu/todus/android/xmpp/extension/pubEdited/ExtensionPubEdited;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "pubId", "", "getPubId", "()Ljava/lang/String;", "setPubId", "(Ljava/lang/String;)V", "chId", "getChId", "setChId", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionPubEdited implements ExtensionElement {
    public static final String ELEMENT = "pubedited";
    public static final String NAMESPACE = "pubedited:n";
    public static final String TAG_CH_ID = "ch_id";
    public static final String TAG_ID = "i";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_MSG_PUB_ID = "pub_id";
    public static final int $stable = 8;
    private String pubId = "";
    private String chId = "";

    public final String getChId() {
        return this.chId;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final String getPubId() {
        return this.pubId;
    }

    public final void setChId(String str) {
        y.i(str, "<set-?>");
        this.chId = str;
    }

    public final void setPubId(String str) {
        y.i(str, "<set-?>");
        this.pubId = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("pub_id", this.pubId);
        xmlStringBuilder.attribute("ch_id", this.chId);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
