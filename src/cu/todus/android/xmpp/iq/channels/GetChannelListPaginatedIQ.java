package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0013"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetChannelListPaginatedIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "chId", "", "", "limit", "", "offset", "<init>", "(Ljava/util/List;II)V", "getChId", "()Ljava/util/List;", "getLimit", "()I", "getOffset", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetChannelListPaginatedIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:my_channels:2";
    private final List<String> chId;
    private final int limit;
    private final int offset;
    public static final int $stable = 8;

    public GetChannelListPaginatedIQ() {
        this(null, 0, 0, 7, null);
    }

    public final List<String> getChId() {
        return this.chId;
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

    public /* synthetic */ GetChannelListPaginatedIQ(List list, int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? w.n() : list, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetChannelListPaginatedIQ(List<String> chId, int i10, int i11) {
        super("query", NAMESPACE);
        y.i(chId, "chId");
        this.chId = chId;
        this.limit = i10;
        this.offset = i11;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_NAME_CHANNELS));
    }
}
