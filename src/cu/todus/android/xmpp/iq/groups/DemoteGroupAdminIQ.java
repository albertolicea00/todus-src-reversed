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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/DemoteGroupAdminIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "admin", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdmin", "()Ljava/lang/String;", "getCode", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DemoteGroupAdminIQ extends IQ {
    public static final String ADMIN = "admin";
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "td:g:demote";
    private final String admin;
    private final String code;
    public static final int $stable = 8;

    public DemoteGroupAdminIQ() {
        this(null, null, null, 7, null);
    }

    public final String getAdmin() {
        return this.admin;
    }

    public final String getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("admin", this.admin);
        xml.rightAngleBracket();
        return xml;
    }

    public /* synthetic */ DemoteGroupAdminIQ(String str, String str2, String str3, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoteGroupAdminIQ(String groupId, String admin, String code) {
        super("query", NAMESPACE);
        y.i(groupId, "groupId");
        y.i(admin, "admin");
        y.i(code, "code");
        this.admin = admin;
        this.code = code;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
