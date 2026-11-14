package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.data.xmpp.ChannelAdmin;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetChannelAdminsIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "id", "", "admins", "Ljava/util/ArrayList;", "Lcu/todus/android/data/xmpp/ChannelAdmin;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/String;", "getAdmins", "()Ljava/util/ArrayList;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetChannelAdminsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:getadmins";
    private final ArrayList<ChannelAdmin> admins;
    private final String id;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public GetChannelAdminsIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final ArrayList<ChannelAdmin> getAdmins() {
        return this.admins;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        return xml;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ GetChannelAdminsIQ(String str, ArrayList arrayList, int i10, p pVar) {
        this((i10 & 1) != 0 ? Service.Config.SERVER_NAME_CHANNELS : str, (i10 & 2) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetChannelAdminsIQ(String id2, ArrayList<ChannelAdmin> admins) {
        super("query", NAMESPACE);
        y.i(id2, "id");
        y.i(admins, "admins");
        this.id = id2;
        this.admins = admins;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(id2));
    }
}
