package cu.todus.android.xmpp.iq.roster;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B9\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014R%\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterGetListPaginatedIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "contacts", "", "Lkotlin/Pair;", "", "limit", "", "offset", "<init>", "(Ljava/util/List;II)V", "getContacts", "()Ljava/util/List;", "getLimit", "()I", "getOffset", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterGetListPaginatedIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:roster:list:2";
    public static final int PAGE_SIZE = 20;
    private final List<Pair<String, String>> contacts;
    private final int limit;
    private final int offset;
    public static final int $stable = 8;

    public RosterGetListPaginatedIQ() {
        this(null, 0, 0, 7, null);
    }

    public final List<Pair<String, String>> getContacts() {
        return this.contacts;
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

    public final int getOffset() {
        return this.offset;
    }

    public /* synthetic */ RosterGetListPaginatedIQ(List list, int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? w.n() : list, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }

    public RosterGetListPaginatedIQ(List<Pair<String, String>> list, int i10, int i11) {
        super("query", NAMESPACE);
        this.contacts = list;
        this.limit = i10;
        this.offset = i11;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
