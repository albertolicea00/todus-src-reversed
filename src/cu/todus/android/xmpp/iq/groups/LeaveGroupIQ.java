package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/LeaveGroupIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "<init>", "(Ljava/lang/String;)V", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LeaveGroupIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x13";
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public LeaveGroupIQ() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public /* synthetic */ LeaveGroupIQ(String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGroupIQ(String groupId) {
        super("query", NAMESPACE);
        y.i(groupId, "groupId");
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
