package cu.todus.android.xmpp.iq.near;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR,\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcu/todus/android/xmpp/iq/near/PeopleNearIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "offset", "", "limit", "users", "", "Lkotlin/Pair;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "<init>", "(IILjava/util/List;)V", "getOffset", "()I", "getLimit", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PeopleNearIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "tnearp:find";
    private final int limit;
    private final int offset;
    private List<Pair<Double, User>> users;
    public static final int $stable = 8;

    public PeopleNearIQ() {
        this(0, 0, null, 7, null);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute("offset", this.offset);
        xml.attribute("limit", this.limit);
        xml.rightAngleBracket();
        return xml;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final List<Pair<Double, User>> getUsers() {
        return this.users;
    }

    public final void setUsers(List<Pair<Double, User>> list) {
        y.i(list, "<set-?>");
        this.users = list;
    }

    public /* synthetic */ PeopleNearIQ(int i10, int i11, List list, int i12, p pVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 50 : i11, (i12 & 4) != 0 ? w.n() : list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeopleNearIQ(int i10, int i11, List<Pair<Double, User>> users) {
        super("query", NAMESPACE);
        y.i(users, "users");
        this.offset = i10;
        this.limit = i11;
        this.users = users;
        setType(IQ.Type.get);
    }
}
