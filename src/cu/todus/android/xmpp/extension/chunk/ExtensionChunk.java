package cu.todus.android.xmpp.extension.chunk;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0014"}, d2 = {"Lcu/todus/android/xmpp/extension/chunk/ExtensionChunk;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", Room.COLUMN_LAST_MSG, "", "index", "", "total", "<init>", "(Ljava/lang/String;II)V", "getMsgId", "()Ljava/lang/String;", "getIndex", "()I", "getTotal", "getElementName", "getNamespace", "toXML", "", "enclosingNamespace", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionChunk implements ExtensionElement {
    public static final int $stable = 0;
    public static final String ELEMENT = "chunk";
    public static final String NAMESPACE = "msg:fragment:n";
    private final int index;
    private final String msgId;
    private final int total;

    public ExtensionChunk(String msgId, int i10, int i11) {
        y.i(msgId, "msgId");
        this.msgId = msgId;
        this.index = i10;
        this.total = i11;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final int getTotal() {
        return this.total;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(Room.COLUMN_LAST_MSG, this.msgId);
        xmlStringBuilder.attribute("index", String.valueOf(this.index));
        xmlStringBuilder.attribute("total", String.valueOf(this.total));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
