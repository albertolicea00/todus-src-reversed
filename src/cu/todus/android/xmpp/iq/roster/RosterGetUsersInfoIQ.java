package cu.todus.android.xmpp.iq.roster;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.User;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterGetUsersInfoIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "numbers", "", "", "users", "Lcu/todus/android/data/db/entity/toDus/User;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getNumbers", "()Ljava/util/List;", "getUsers", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterGetUsersInfoIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "todus:users:getinfo";
    private final List<String> numbers;
    private final List<User> users;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public RosterGetUsersInfoIQ() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        List<String> list = this.numbers;
        xml.attribute("users", list != null ? g0.G0(list, ",", null, null, 0, null, null, 62, null) : null);
        xml.rightAngleBracket();
        return xml;
    }

    public final List<String> getNumbers() {
        return this.numbers;
    }

    public final List<User> getUsers() {
        return this.users;
    }

    public /* synthetic */ RosterGetUsersInfoIQ(List list, List list2, int i10, p pVar) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? w.n() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterGetUsersInfoIQ(List<String> list, List<User> users) {
        super("query", NAMESPACE);
        y.i(users, "users");
        this.numbers = list;
        this.users = users;
        setType(IQ.Type.get);
        setTo(JidCreate.bareFrom(Service.Config.SERVER_DOMAIN));
    }
}
