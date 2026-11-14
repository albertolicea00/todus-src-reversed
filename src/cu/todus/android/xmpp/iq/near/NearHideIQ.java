package cu.todus.android.xmpp.iq.near;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcu/todus/android/xmpp/iq/near/NearHideIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "code", "", "<init>", "(Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NearHideIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "tnearp:loc:hide";
    private final Integer code;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public NearHideIQ() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Integer getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public NearHideIQ(Integer num) {
        super("query", NAMESPACE);
        this.code = num;
        setType(IQ.Type.set);
    }

    public /* synthetic */ NearHideIQ(Integer num, int i10, p pVar) {
        this((i10 & 1) != 0 ? null : num);
    }
}
