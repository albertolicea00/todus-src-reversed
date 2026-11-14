package cu.todus.android.xmpp.iq.call;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.xmpp.TurnCredentials;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcu/todus/android/xmpp/iq/call/GetCredentialsIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "userId", "", "turnCredentials", "Lcu/todus/android/data/xmpp/TurnCredentials;", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/xmpp/TurnCredentials;)V", "getTurnCredentials", "()Lcu/todus/android/data/xmpp/TurnCredentials;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetCredentialsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:turn:cred";
    private final TurnCredentials turnCredentials;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GetCredentialsIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final TurnCredentials getTurnCredentials() {
        return this.turnCredentials;
    }

    public /* synthetic */ GetCredentialsIQ(String str, TurnCredentials turnCredentials, int i10, p pVar) {
        this((i10 & 1) != 0 ? "xxxx@im.todus.cu" : str, (i10 & 2) != 0 ? null : turnCredentials);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCredentialsIQ(String userId, TurnCredentials turnCredentials) {
        super("query", NAMESPACE);
        y.i(userId, "userId");
        this.turnCredentials = turnCredentials;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(userId));
    }
}
