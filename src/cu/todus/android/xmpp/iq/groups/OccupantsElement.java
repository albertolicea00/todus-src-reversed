package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.xmpp.GroupAffiliation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/OccupantsElement;", "Lorg/jivesoftware/smack/packet/Element;", "occupants", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "Lcu/todus/android/data/xmpp/GroupAffiliation;", "<init>", "(Ljava/util/HashMap;)V", "toXML", "", "enclosingNamespace", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OccupantsElement implements Element {
    public static final int $stable = 8;
    private final HashMap<Jid, GroupAffiliation> occupants;

    public OccupantsElement(HashMap<Jid, GroupAffiliation> occupants) {
        y.i(occupants, "occupants");
        this.occupants = occupants;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement("occupants");
        for (Map.Entry<Jid, GroupAffiliation> entry : this.occupants.entrySet()) {
            xmlStringBuilder.element(new UserWithAffiliationElement(entry.getKey(), entry.getValue()));
        }
        xmlStringBuilder.closeElement("occupants");
        return xmlStringBuilder;
    }
}
