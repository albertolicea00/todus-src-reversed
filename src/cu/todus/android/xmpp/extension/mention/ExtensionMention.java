package cu.todus.android.xmpp.extension.mention;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcu/todus/android/xmpp/extension/mention/ExtensionMention;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "length", "getLength", "setLength", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionMention implements ExtensionElement {
    public static final String ELEMENT = "mention";
    public static final String NAMESPACE = "mention:n";
    public static final String TAG_LENGTH = "l";
    public static final String TAG_OFFSET = "o";
    public static final String TAG_USER_ID = "ui";
    private int length;
    private int offset;
    private String userId = "";
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final int getLength() {
        return this.length;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setLength(int i10) {
        this.length = i10;
    }

    public final void setOffset(int i10) {
        this.offset = i10;
    }

    public final void setUserId(String str) {
        y.i(str, "<set-?>");
        this.userId = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(TAG_OFFSET, this.offset);
        xmlStringBuilder.attribute("l", this.length);
        xmlStringBuilder.attribute(TAG_USER_ID, this.userId);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
