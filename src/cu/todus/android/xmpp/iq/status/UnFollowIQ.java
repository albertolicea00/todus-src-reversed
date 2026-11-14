package cu.todus.android.xmpp.iq.status;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcu/todus/android/xmpp/iq/status/UnFollowIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "uid", "", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnFollowIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "td:status:unfollow";
    public static final String UNFOLLOW_TO = "unfollow_to";
    private final String code;
    private final String uid;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public UnFollowIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final String getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(UNFOLLOW_TO, this.uid);
        xml.rightAngleBracket();
        return xml;
    }

    public /* synthetic */ UnFollowIQ(String str, String str2, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnFollowIQ(String uid, String code) {
        super("query", NAMESPACE);
        y.i(uid, "uid");
        y.i(code, "code");
        this.uid = uid;
        this.code = code;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.STATUS_RECEPTOR));
    }
}
