package cu.todus.android.xmpp.iq.status;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/xmpp/iq/status/GetFollowingIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "uid", "", "limit", "", "offset", "following", "", "error", "<init>", "(Ljava/lang/String;IILjava/util/List;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getLimit", "()I", "getOffset", "getFollowing", "()Ljava/util/List;", "getError", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetFollowingIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String LIMIT = "limit";
    public static final String NAMESPACE = "td:status:following";
    public static final String OFFSET = "offset";
    public static final String USER_JID = "user_jid";
    private final String error;
    private final List<String> following;
    private final int limit;
    private final int offset;
    private final String uid;
    public static final int $stable = 8;

    public GetFollowingIQ() {
        this(null, 0, 0, null, null, 31, null);
    }

    public final String getError() {
        return this.error;
    }

    public final List<String> getFollowing() {
        return this.following;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("user_jid", this.uid);
        xml.attribute("limit", this.limit);
        xml.attribute("offset", this.offset);
        xml.rightAngleBracket();
        return xml;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getUid() {
        return this.uid;
    }

    public /* synthetic */ GetFollowingIQ(String str, int i10, int i11, List list, String str2, int i12, p pVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? 50 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? w.n() : list, (i12 & 16) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFollowingIQ(String uid, int i10, int i11, List<String> following, String error) {
        super("query", NAMESPACE);
        y.i(uid, "uid");
        y.i(following, "following");
        y.i(error, "error");
        this.uid = uid;
        this.limit = i10;
        this.offset = i11;
        this.following = following;
        this.error = error;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.STATUS_RECEPTOR));
    }
}
