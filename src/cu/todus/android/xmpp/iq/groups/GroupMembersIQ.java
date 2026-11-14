package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GroupMembersIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "members", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getMembers", "()Ljava/util/HashMap;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GroupMembersIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x11";
    private final HashMap<Jid, String> members;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupMembersIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final HashMap<Jid, String> getMembers() {
        return this.members;
    }

    public /* synthetic */ GroupMembersIQ(String str, HashMap map, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, (i10 & 2) != 0 ? new HashMap() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupMembersIQ(String groupId, HashMap<Jid, String> members) {
        super("query", "x11");
        y.i(groupId, "groupId");
        y.i(members, "members");
        this.members = members;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(groupId));
    }
}
