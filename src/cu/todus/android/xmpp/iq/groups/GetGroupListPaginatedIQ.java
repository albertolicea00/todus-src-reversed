package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B1\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GetGroupListPaginatedIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "mucs", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "", "limit", "", "offset", "<init>", "(Ljava/util/HashMap;II)V", "getMucs", "()Ljava/util/HashMap;", "getLimit", "()I", "getOffset", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetGroupListPaginatedIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:muclight:my_mucs:2";
    private final int limit;
    private final HashMap<Jid, String> mucs;
    private final int offset;
    public static final int $stable = 8;

    public GetGroupListPaginatedIQ() {
        this(null, 0, 0, 7, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("limit", this.limit);
        xml.attribute("offset", this.offset);
        xml.rightAngleBracket();
        return xml;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final HashMap<Jid, String> getMucs() {
        return this.mucs;
    }

    public final int getOffset() {
        return this.offset;
    }

    public /* synthetic */ GetGroupListPaginatedIQ(HashMap map, int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? new HashMap() : map, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetGroupListPaginatedIQ(HashMap<Jid, String> mucs, int i10, int i11) {
        super("query", NAMESPACE);
        y.i(mucs, "mucs");
        this.mucs = mucs;
        this.limit = i10;
        this.offset = i11;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.MUC_LIGHT_SERVICE_NAME));
    }
}
