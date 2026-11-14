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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterUpdateVersionIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "rosterVersion", "", "code", "<init>", "(Ljava/lang/Integer;I)V", "getRosterVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()I", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterUpdateVersionIQ extends IQ {
    public static final String CODE = "code";
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:users:updaterosterversion";
    public static final String ROSTER_VERSION = "roster_version";
    private final int code;
    private final Integer rosterVersion;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public RosterUpdateVersionIQ() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public final int getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        Integer num = this.rosterVersion;
        if (num != null) {
            xml.attribute(ROSTER_VERSION, String.valueOf(num.intValue()));
        }
        xml.rightAngleBracket();
        return xml;
    }

    public final Integer getRosterVersion() {
        return this.rosterVersion;
    }

    public /* synthetic */ RosterUpdateVersionIQ(Integer num, int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? 0 : i10);
    }

    public RosterUpdateVersionIQ(Integer num, int i10) {
        super("query", NAMESPACE);
        this.rosterVersion = num;
        this.code = i10;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
