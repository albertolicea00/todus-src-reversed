package cu.todus.android.xmpp.iq.roster;

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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterGetVersionIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "user", "", "rosterVersion", "", "<init>", "(Ljava/lang/String;I)V", "getUser", "()Ljava/lang/String;", "getRosterVersion", "()I", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterGetVersionIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:users:getrosterversion";
    public static final String USER = "user";
    private final int rosterVersion;
    private final String user;
    public static final int $stable = 8;

    public /* synthetic */ RosterGetVersionIQ(String str, int i10, int i11, p pVar) {
        this(str, (i11 & 2) != 0 ? 0 : i10);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("user", this.user);
        xml.rightAngleBracket();
        return xml;
    }

    public final int getRosterVersion() {
        return this.rosterVersion;
    }

    public final String getUser() {
        return this.user;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterGetVersionIQ(String user, int i10) {
        super("query", NAMESPACE);
        y.i(user, "user");
        this.user = user;
        this.rosterVersion = i10;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
