package cu.todus.android.xmpp.iq.channels;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/GetPubByIdIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "pubId", "", "chId", "pubEdited", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "getPubId", "()Ljava/lang/String;", "getChId", "getPubEdited", "()Landroid/os/Bundle;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetPubByIdIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:ch:getpub:id";
    public static final String PUB_ID = "pub_id";
    private final String chId;
    private final Bundle pubEdited;
    private final String pubId;
    public static final int $stable = 8;

    public GetPubByIdIQ() {
        this(null, null, null, 7, null);
    }

    public final String getChId() {
        return this.chId;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("pub_id", this.pubId);
        xml.rightAngleBracket();
        return xml;
    }

    public final Bundle getPubEdited() {
        return this.pubEdited;
    }

    public final String getPubId() {
        return this.pubId;
    }

    public /* synthetic */ GetPubByIdIQ(String str, String str2, Bundle bundle, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPubByIdIQ(String pubId, String chId, Bundle bundle) {
        super("query", NAMESPACE);
        y.i(pubId, "pubId");
        y.i(chId, "chId");
        this.pubId = pubId;
        this.chId = chId;
        this.pubEdited = bundle;
        setType(IQ.Type.get);
        if (d0.q0(chId)) {
            return;
        }
        setTo(JidCreate.bareFrom(chId));
    }
}
