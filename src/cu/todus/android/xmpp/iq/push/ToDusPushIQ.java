package cu.todus.android.xmpp.iq.push;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcu/todus/android/xmpp/iq/push/ToDusPushIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusPushIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:fb:push";
    private final String id;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ToDusPushIQ() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement("push_id");
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.id);
        xmlStringBuilder.closeElement("push_id");
        xml.element(xmlStringBuilder);
        return xml;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToDusPushIQ(String id2) {
        super("query", NAMESPACE);
        y.i(id2, "id");
        this.id = id2;
        setType(IQ.Type.set);
        setTo(JidCreate.from(Service.Config.SERVER_DOMAIN));
    }

    public /* synthetic */ ToDusPushIQ(String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
