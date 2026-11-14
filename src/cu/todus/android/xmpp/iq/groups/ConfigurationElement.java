package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.xmpp.GroupConfiguration;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/ConfigurationElement;", "Lorg/jivesoftware/smack/packet/Element;", "configuration", "Lcu/todus/android/data/xmpp/GroupConfiguration;", "<init>", "(Lcu/todus/android/data/xmpp/GroupConfiguration;)V", "toXML", "", "enclosingNamespace", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigurationElement implements Element {
    public static final int $stable = 8;
    private final GroupConfiguration configuration;

    public ConfigurationElement(GroupConfiguration configuration) {
        y.i(configuration, "configuration");
        this.configuration = configuration;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement("configuration");
        xmlStringBuilder.element(Room.CONFIG_ROOM_NAME, this.configuration.getRoomName());
        xmlStringBuilder.optElement("subject", this.configuration.getSubject());
        if (!this.configuration.getCustomConfigs().isEmpty()) {
            for (Map.Entry<String, String> entry : this.configuration.getCustomConfigs().entrySet()) {
                xmlStringBuilder.element(entry.getKey(), entry.getValue());
            }
        }
        xmlStringBuilder.closeElement("configuration");
        return xmlStringBuilder;
    }
}
