package cu.todus.android.xmpp.extension.link;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcu/todus/android/xmpp/extension/link/ExtensionLinkInfo;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "messageId", "getMessageId", "setMessageId", "downloadedInfo", "", "getDownloadedInfo", "()Z", "setDownloadedInfo", "(Z)V", "linkEntity", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", "getLinkEntity", "()Lcu/todus/android/data/db/pojo/content/LinkEntity;", "setLinkEntity", "(Lcu/todus/android/data/db/pojo/content/LinkEntity;)V", "toXML", "", "enclosingNamespace", "getNamespace", "getElementName", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionLinkInfo implements ExtensionElement {
    public static final String ELEMENT = "linkInfo";
    public static final String NAMESPACE = "linkInfo:n";
    public static final String TAG_DOWNLOADED = "down";
    public static final String TAG_ENTITY = "ent";
    public static final String TAG_ID = "i";
    public static final String TAG_MESSAGE_ID = "mi";
    private boolean downloadedInfo;
    private LinkEntity linkEntity;
    public static final int $stable = 8;
    private String id = "";
    private String messageId = "";

    public final boolean getDownloadedInfo() {
        return this.downloadedInfo;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public final String getId() {
        return this.id;
    }

    public final LinkEntity getLinkEntity() {
        return this.linkEntity;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public final void setDownloadedInfo(boolean z10) {
        this.downloadedInfo = z10;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setLinkEntity(LinkEntity linkEntity) {
        this.linkEntity = linkEntity;
    }

    public final void setMessageId(String str) {
        y.i(str, "<set-?>");
        this.messageId = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("i", this.id);
        xmlStringBuilder.attribute("mi", this.messageId);
        xmlStringBuilder.attribute(TAG_DOWNLOADED, this.downloadedInfo);
        xmlStringBuilder.attribute(TAG_ENTITY, new f().t(this.linkEntity));
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
