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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GroupGetLinkIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GroupGetLinkIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x14";
    private final String link;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupGetLinkIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final String getLink() {
        return this.link;
    }

    public /* synthetic */ GroupGetLinkIQ(String str, String str2, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, (i10 & 2) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupGetLinkIQ(String groupId, String link) {
        super("query", "x14");
        y.i(groupId, "groupId");
        y.i(link, "link");
        this.link = link;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(groupId));
    }
}
