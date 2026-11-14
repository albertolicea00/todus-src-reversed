package cu.todus.android.xmpp.iq.privacy;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/privacy/PrivacyAddUpdateIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "whoCan", "", PrivacyGetIQ.PRIVACY_EXCEPTIONS, "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getWhoCan", "()Ljava/lang/String;", "getExceptions", "()Ljava/util/List;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrivacyAddUpdateIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:group:privacy";
    private final List<String> exceptions;
    private final String whoCan;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyAddUpdateIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<String> getExceptions() {
        return this.exceptions;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(PrivacyGetIQ.PRIVACY_WHO_CAN, this.whoCan);
        xml.attribute(PrivacyGetIQ.PRIVACY_EXCEPTIONS, g0.G0(this.exceptions, ",", null, null, 0, null, null, 62, null));
        xml.rightAngleBracket();
        return xml;
    }

    public final String getWhoCan() {
        return this.whoCan;
    }

    public /* synthetic */ PrivacyAddUpdateIQ(String str, List list, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? new ArrayList() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyAddUpdateIQ(String whoCan, List<String> exceptions) {
        super("query", "todus:group:privacy");
        y.i(whoCan, "whoCan");
        y.i(exceptions, "exceptions");
        this.whoCan = whoCan;
        this.exceptions = exceptions;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
