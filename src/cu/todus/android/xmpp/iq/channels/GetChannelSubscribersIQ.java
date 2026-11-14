package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetChannelSubscribersIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "id", "", "limit", "", "offset", "subscribers", "", "<init>", "(Ljava/lang/String;IILjava/util/Map;)V", "getId", "()Ljava/lang/String;", "getLimit", "()I", "getOffset", "getSubscribers", "()Ljava/util/Map;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetChannelSubscribersIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:getsubscribers:2";
    private final String id;
    private final int limit;
    private final int offset;
    private final Map<String, String> subscribers;
    public static final int $stable = 8;

    public GetChannelSubscribersIQ() {
        this(null, 0, 0, null, 15, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("limit", this.limit);
        xml.attribute("offset", this.offset);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getId() {
        return this.id;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final Map<String, String> getSubscribers() {
        return this.subscribers;
    }

    public /* synthetic */ GetChannelSubscribersIQ(String str, int i10, int i11, Map map, int i12, p pVar) {
        this((i12 & 1) != 0 ? Service.Config.SERVER_NAME_CHANNELS : str, (i12 & 2) != 0 ? 50 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? w0.i() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetChannelSubscribersIQ(String id2, int i10, int i11, Map<String, String> subscribers) {
        super("query", NAMESPACE);
        y.i(id2, "id");
        y.i(subscribers, "subscribers");
        this.id = id2;
        this.limit = i10;
        this.offset = i11;
        this.subscribers = subscribers;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(id2));
    }
}
