package cu.todus.android.xmpp.iq.block;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.ParserUtils;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/block/BlockUserIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "user", "Lorg/jxmpp/jid/Jid;", "code", "", "<init>", "(Lorg/jxmpp/jid/Jid;Ljava/lang/String;)V", "getUser", "()Lorg/jxmpp/jid/Jid;", "getCode", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BlockUserIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:block:set";
    private final String code;
    private final Jid user;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockUserIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final String getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(ParserUtils.JID, this.user);
        xml.rightAngleBracket();
        return xml;
    }

    public final Jid getUser() {
        return this.user;
    }

    public BlockUserIQ(Jid jid, String str) {
        super("query", NAMESPACE);
        this.user = jid;
        this.code = str;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }

    public /* synthetic */ BlockUserIQ(Jid jid, String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? null : jid, (i10 & 2) != 0 ? null : str);
    }
}
