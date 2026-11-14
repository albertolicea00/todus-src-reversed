package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.xmpp.GroupAffiliation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B?\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016R1\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/AffiliationsChangeExtension;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "affiliations", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "Lcu/todus/android/data/xmpp/GroupAffiliation;", "Lkotlin/collections/HashMap;", "prevVersion", "", "version", "<init>", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V", "getAffiliations", "()Ljava/util/HashMap;", "getPrevVersion", "()Ljava/lang/String;", "getVersion", "getElementName", "getNamespace", "toXML", "", "enclosingNamespace", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AffiliationsChangeExtension implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "x11";
    private final HashMap<Jid, GroupAffiliation> affiliations;
    private final String prevVersion;
    private final String version;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/AffiliationsChangeExtension$Companion;", "", "<init>", "()V", "ELEMENT", "", "NAMESPACE", TypedValues.TransitionType.S_FROM, "Lcu/todus/android/xmpp/iq/groups/AffiliationsChangeExtension;", "message", "Lorg/jivesoftware/smack/packet/Message;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final AffiliationsChangeExtension from(Message message) {
            y.i(message, "message");
            ExtensionElement extension = message.getExtension("x", "x11");
            y.h(extension, "getExtension(...)");
            return (AffiliationsChangeExtension) extension;
        }

        private Companion() {
        }
    }

    public AffiliationsChangeExtension(HashMap<Jid, GroupAffiliation> affiliations, String prevVersion, String version) {
        y.i(affiliations, "affiliations");
        y.i(prevVersion, "prevVersion");
        y.i(version, "version");
        this.affiliations = affiliations;
        this.prevVersion = prevVersion;
        this.version = version;
    }

    public final HashMap<Jid, GroupAffiliation> getAffiliations() {
        return this.affiliations;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "x11";
    }

    public final String getPrevVersion() {
        return this.prevVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        y.i(enclosingNamespace, "enclosingNamespace");
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("prev-version", this.prevVersion);
        xmlStringBuilder.optElement("version", this.version);
        for (Map.Entry<Jid, GroupAffiliation> entry : this.affiliations.entrySet()) {
            xmlStringBuilder.element(new UserWithAffiliationElement(entry.getKey(), entry.getValue()));
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
