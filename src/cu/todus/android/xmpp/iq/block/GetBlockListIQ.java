package cu.todus.android.xmpp.iq.block;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jxmpp.jid.impl.JidCreate;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/block/GetBlockListIQ;", "Lorg/jivesoftware/smack/packet/IQ;", BlockContactsIQ.ELEMENT, "", "", "code", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getBlock", "()Ljava/util/List;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetBlockListIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:block:get:2";
    private final List<String> block;
    private final Integer code;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GetBlockListIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<String> getBlock() {
        return this.block;
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

    public /* synthetic */ GetBlockListIQ(List list, Integer num, int i10, p pVar) {
        this((i10 & 1) != 0 ? w.n() : list, (i10 & 2) != 0 ? null : num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetBlockListIQ(List<String> block, Integer num) {
        super("query", NAMESPACE);
        y.i(block, "block");
        this.block = block;
        this.code = num;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
