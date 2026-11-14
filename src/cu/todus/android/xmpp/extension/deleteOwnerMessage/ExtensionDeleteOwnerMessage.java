package cu.todus.android.xmpp.extension.deleteOwnerMessage;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/extension/deleteOwnerMessage/ExtensionDeleteOwnerMessage;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "messageId", "", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionDeleteOwnerMessage implements ExtensionElement {
    public static final String ELEMENT = "deletedowner";
    public static final String NAMESPACE = "deletedowner:n";
    public static final String TAG_MESSAGE_ID = "mi";
    private String messageId = "";
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
