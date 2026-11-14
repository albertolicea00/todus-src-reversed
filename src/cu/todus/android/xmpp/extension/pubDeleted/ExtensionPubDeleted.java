package cu.todus.android.xmpp.extension.pubDeleted;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcu/todus/android/xmpp/extension/pubDeleted/ExtensionPubDeleted;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "chId", "", "getChId", "()Ljava/lang/String;", "setChId", "(Ljava/lang/String;)V", "pubsId", "", "getPubsId", "()Ljava/util/List;", "setPubsId", "(Ljava/util/List;)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionPubDeleted implements ExtensionElement {
    public static final String ELEMENT = "pubsdeleted";
    public static final String NAMESPACE = "pubsdeleted:n";
    public static final String TAG_CH_ID = "ch_id";
    public static final String TAG_ID = "i";
    public static final String TAG_MESSAGE_ID = "mi";
    public static final String TAG_MSG_PUB_ID = "pubs_id";
    private String chId = "";
    private List<String> pubsId = w.n();
    public static final int $stable = 8;

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

    public final List<String> getPubsId() {
        return this.pubsId;
    }

    public final void setChId(String str) {
        y.i(str, "<set-?>");
        this.chId = str;
    }

    public final void setPubsId(List<String> list) {
        y.i(list, "<set-?>");
        this.pubsId = list;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("ch_id", this.chId);
        xmlStringBuilder.attribute(TAG_MSG_PUB_ID, g0.G0(this.pubsId, ",", null, null, 0, null, null, 62, null));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
