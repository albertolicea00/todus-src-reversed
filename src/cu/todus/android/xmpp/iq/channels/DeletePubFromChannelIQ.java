package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/DeletePubFromChannelIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "publIDs", "", "", "chId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getPublIDs", "()Ljava/util/List;", "getChId", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeletePubFromChannelIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:delpub";
    public static final String PUB_IDS = "pub_ids";
    private final String chId;
    private final List<String> publIDs;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public DeletePubFromChannelIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final String getChId() {
        return this.chId;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(PUB_IDS, g0.G0(this.publIDs, ",", null, null, 0, null, null, 62, null));
        xml.rightAngleBracket();
        return xml;
    }

    public final List<String> getPublIDs() {
        return this.publIDs;
    }

    public /* synthetic */ DeletePubFromChannelIQ(List list, String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? w.n() : list, (i10 & 2) != 0 ? "" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeletePubFromChannelIQ(List<String> publIDs, String chId) {
        super("query", NAMESPACE);
        y.i(publIDs, "publIDs");
        y.i(chId, "chId");
        this.publIDs = publIDs;
        this.chId = chId;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(chId));
    }
}
