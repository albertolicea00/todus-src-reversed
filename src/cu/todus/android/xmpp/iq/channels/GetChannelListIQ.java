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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetChannelListIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "chId", "", "", "<init>", "(Ljava/util/List;)V", "getChId", "()Ljava/util/List;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetChannelListIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:my_channels";
    private final List<String> chId;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GetChannelListIQ() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<String> getChId() {
        return this.chId;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public /* synthetic */ GetChannelListIQ(List list, int i10, p pVar) {
        this((i10 & 1) != 0 ? w.n() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetChannelListIQ(List<String> chId) {
        super("query", NAMESPACE);
        y.i(chId, "chId");
        this.chId = chId;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_NAME_CHANNELS));
    }
}
