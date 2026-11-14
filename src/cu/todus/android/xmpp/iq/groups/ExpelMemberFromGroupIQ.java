package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.xmpp.GroupAffiliation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/ExpelMemberFromGroupIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "affiliations", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "Lcu/todus/android/data/xmpp/GroupAffiliation;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getAffiliations", "()Ljava/util/HashMap;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExpelMemberFromGroupIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x11";
    private final HashMap<Jid, GroupAffiliation> affiliations;
    public static final int $stable = 8;

    public /* synthetic */ ExpelMemberFromGroupIQ(String str, HashMap map, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, map);
    }

    public final HashMap<Jid, GroupAffiliation> getAffiliations() {
        return this.affiliations;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        HashMap<Jid, GroupAffiliation> map = this.affiliations;
        if (map != null) {
            for (Map.Entry<Jid, GroupAffiliation> entry : map.entrySet()) {
                y.h(entry, "next(...)");
                Map.Entry<Jid, GroupAffiliation> entry2 = entry;
                Jid key = entry2.getKey();
                y.h(key, "<get-key>(...)");
                xml.element(new UserWithAffiliationElement(key, entry2.getValue()));
            }
        }
        return xml;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpelMemberFromGroupIQ(String groupId, HashMap<Jid, GroupAffiliation> map) {
        super("query", "x11");
        y.i(groupId, "groupId");
        this.affiliations = map;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
