package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.xmpp.GroupAffiliation;
import cu.todus.android.data.xmpp.GroupConfiguration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/CreateGroupIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "roomName", "subject", "customConfigs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "newOccupants", "", "Lorg/jxmpp/jid/Jid;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/List;)V", "getRoomName", "()Ljava/lang/String;", "getSubject", "getCustomConfigs", "()Ljava/util/HashMap;", "getNewOccupants", "()Ljava/util/List;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CreateGroupIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x16";
    private final HashMap<String, String> customConfigs;
    private final List<Jid> newOccupants;
    private final String roomName;
    private final String subject;
    public static final int $stable = 8;

    public /* synthetic */ CreateGroupIQ(String str, String str2, String str3, HashMap map, List list, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, str2, str3, map, list);
    }

    public final HashMap<String, String> getCustomConfigs() {
        return this.customConfigs;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        GroupConfiguration groupConfiguration = new GroupConfiguration(this.roomName, this.subject, "", this.customConfigs);
        HashMap map = new HashMap();
        Iterator<Jid> it = this.newOccupants.iterator();
        while (it.hasNext()) {
            map.put(it.next(), GroupAffiliation.member);
        }
        xml.rightAngleBracket();
        xml.element(new ConfigurationElement(groupConfiguration));
        if (!map.isEmpty()) {
            xml.element(new OccupantsElement(map));
        }
        return xml;
    }

    public final List<Jid> getNewOccupants() {
        return this.newOccupants;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    public final String getSubject() {
        return this.subject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CreateGroupIQ(String groupId, String roomName, String subject, HashMap<String, String> customConfigs, List<? extends Jid> newOccupants) {
        super("query", NAMESPACE);
        y.i(groupId, "groupId");
        y.i(roomName, "roomName");
        y.i(subject, "subject");
        y.i(customConfigs, "customConfigs");
        y.i(newOccupants, "newOccupants");
        this.roomName = roomName;
        this.subject = subject;
        this.customConfigs = customConfigs;
        this.newOccupants = newOccupants;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
