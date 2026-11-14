package cu.todus.android.xmpp.iq.call;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/call/CallStatusIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "fromUser", "", "toUser", "status", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFromUser", "()Ljava/lang/String;", "getToUser", "getStatus", "getContent", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallStatusIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:call:status";
    private final String content;
    private final String fromUser;
    private final String status;
    private final String toUser;
    public static final int $stable = 8;

    public CallStatusIQ() {
        this(null, null, null, null, 15, null);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFromUser() {
        return this.fromUser;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("to_user", this.toUser);
        xml.attribute("from_user", this.fromUser);
        xml.attribute("status", this.status);
        xml.attribute("content", this.content);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getToUser() {
        return this.toUser;
    }

    public /* synthetic */ CallStatusIQ(String str, String str2, String str3, String str4, int i10, p pVar) {
        this((i10 & 1) != 0 ? "xxxx@im.todus.cu" : str, (i10 & 2) != 0 ? "xxxx@im.todus.cu" : str2, (i10 & 4) != 0 ? "EXAMPLE" : str3, (i10 & 8) != 0 ? "{}" : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallStatusIQ(String fromUser, String toUser, String status, String content) {
        super("query", NAMESPACE);
        y.i(fromUser, "fromUser");
        y.i(toUser, "toUser");
        y.i(status, "status");
        y.i(content, "content");
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.status = status;
        this.content = content;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(toUser));
    }
}
