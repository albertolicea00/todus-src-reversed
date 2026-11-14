package cu.todus.android.xmpp.iq.near;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcu/todus/android/xmpp/iq/near/NearGetStatusIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "isShowIn", "", "<init>", "(Z)V", "()Z", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NearGetStatusIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "tnearp:status:get";
    private final boolean isShowIn;
    public static final int $stable = 8;

    public NearGetStatusIQ() {
        this(false, 1, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    /* JADX INFO: renamed from: isShowIn, reason: from getter */
    public final boolean getIsShowIn() {
        return this.isShowIn;
    }

    public NearGetStatusIQ(boolean z10) {
        super("query", NAMESPACE);
        this.isShowIn = z10;
        setType(IQ.Type.get);
    }

    public /* synthetic */ NearGetStatusIQ(boolean z10, int i10, p pVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
