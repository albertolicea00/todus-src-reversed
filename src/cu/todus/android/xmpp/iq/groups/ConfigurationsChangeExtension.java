package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR9\u0010\u0007\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/ConfigurationsChangeExtension;", "Lorg/jivesoftware/smack/packet/ExtensionElement;", "prevVersion", "", "version", "roomName", "subject", "customConfigs", "Ljava/util/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getPrevVersion", "()Ljava/lang/String;", "getVersion", "getRoomName", "getSubject", "Lkotlin/collections/HashMap;", "getCustomConfigs", "()Ljava/util/HashMap;", "getElementName", "getNamespace", "toXML", "", "enclosingNamespace", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigurationsChangeExtension implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "x10";
    private final HashMap<String, String> customConfigs;
    private final String prevVersion;
    private final String roomName;
    private final String subject;
    private final String version;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/ConfigurationsChangeExtension$Companion;", "", "<init>", "()V", "ELEMENT", "", "NAMESPACE", TypedValues.TransitionType.S_FROM, "Lcu/todus/android/xmpp/iq/groups/ConfigurationsChangeExtension;", "message", "Lorg/jivesoftware/smack/packet/Message;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final ConfigurationsChangeExtension from(Message message) {
            y.i(message, "message");
            ExtensionElement extension = message.getExtension("x", "x10");
            y.h(extension, "getExtension(...)");
            return (ConfigurationsChangeExtension) extension;
        }

        private Companion() {
        }
    }

    public ConfigurationsChangeExtension(String prevVersion, String version, String roomName, String subject, HashMap<String, String> map) {
        y.i(prevVersion, "prevVersion");
        y.i(version, "version");
        y.i(roomName, "roomName");
        y.i(subject, "subject");
        this.prevVersion = prevVersion;
        this.version = version;
        this.roomName = roomName;
        this.subject = subject;
        this.customConfigs = map;
    }

    public final HashMap<String, String> getCustomConfigs() {
        return this.customConfigs;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "x10";
    }

    public final String getPrevVersion() {
        return this.prevVersion;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    public final String getSubject() {
        return this.subject;
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
        xmlStringBuilder.optElement(Room.CONFIG_ROOM_NAME, this.roomName);
        xmlStringBuilder.optElement("subject", this.subject);
        HashMap<String, String> map = this.customConfigs;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                xmlStringBuilder.element(entry.getKey(), entry.getValue());
            }
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
