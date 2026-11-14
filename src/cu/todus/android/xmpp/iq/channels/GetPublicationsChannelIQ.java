package cu.todus.android.xmpp.iq.channels;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetPublicationsChannelIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "id", "", CreateChannelIQ.LAST_ID, "limit", "", "pubList", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;)V", "getId", "()Ljava/lang/String;", "getLast_id", "getLimit", "()I", "getPubList", "()Ljava/util/ArrayList;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetPublicationsChannelIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:getpub";
    private final String id;
    private final String last_id;
    private final int limit;
    private final ArrayList<Bundle> pubList;
    public static final int $stable = 8;

    public GetPublicationsChannelIQ() {
        this(null, null, 0, null, 15, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(CreateChannelIQ.LAST_ID, this.last_id);
        xml.attribute("limit", this.limit);
        xml.rightAngleBracket();
        return xml;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLast_id() {
        return this.last_id;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final ArrayList<Bundle> getPubList() {
        return this.pubList;
    }

    public /* synthetic */ GetPublicationsChannelIQ(String str, String str2, int i10, ArrayList arrayList, int i11, p pVar) {
        this((i11 & 1) != 0 ? Service.Config.SERVER_NAME_CHANNELS : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? 25 : i10, (i11 & 8) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPublicationsChannelIQ(String id2, String last_id, int i10, ArrayList<Bundle> pubList) {
        super("query", NAMESPACE);
        y.i(id2, "id");
        y.i(last_id, "last_id");
        y.i(pubList, "pubList");
        this.id = id2;
        this.last_id = last_id;
        this.limit = i10;
        this.pubList = pubList;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(id2));
    }
}
