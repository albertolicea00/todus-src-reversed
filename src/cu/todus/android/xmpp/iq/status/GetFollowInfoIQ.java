package cu.todus.android.xmpp.iq.status;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcu/todus/android/xmpp/iq/status/GetFollowInfoIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "uid", "", "state", "Lkotlin/Pair;", "", "followsCount", "", "code", "<init>", "(Ljava/lang/String;Lkotlin/Pair;Lkotlin/Pair;Ljava/lang/String;)V", "getState", "()Lkotlin/Pair;", "getFollowsCount", "getCode", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetFollowInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "td:status:follower:info";
    public static final String USER_JID = "user_jid";
    private final String code;
    private final Pair<Integer, Integer> followsCount;
    private final Pair<Boolean, Boolean> state;
    private final String uid;
    public static final int $stable = 8;

    public GetFollowInfoIQ() {
        this(null, null, null, null, 15, null);
    }

    public final String getCode() {
        return this.code;
    }

    public final Pair<Integer, Integer> getFollowsCount() {
        return this.followsCount;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("user_jid", this.uid);
        xml.rightAngleBracket();
        return xml;
    }

    public final Pair<Boolean, Boolean> getState() {
        return this.state;
    }

    public /* synthetic */ GetFollowInfoIQ(String str, Pair pair, Pair pair2, String str2, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : pair, (i10 & 4) != 0 ? null : pair2, (i10 & 8) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFollowInfoIQ(String uid, Pair<Boolean, Boolean> pair, Pair<Integer, Integer> pair2, String code) {
        super("query", NAMESPACE);
        y.i(uid, "uid");
        y.i(code, "code");
        this.uid = uid;
        this.state = pair;
        this.followsCount = pair2;
        this.code = code;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.STATUS_RECEPTOR));
    }
}
