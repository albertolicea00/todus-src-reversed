package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.xmpp.GroupAffiliation;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/UserWithAffiliationElement;", "Lorg/jivesoftware/smack/packet/Element;", "user", "Lorg/jxmpp/jid/Jid;", UserRoomJoin.COLUMN_AFFILIATION, "Lcu/todus/android/data/xmpp/GroupAffiliation;", "<init>", "(Lorg/jxmpp/jid/Jid;Lcu/todus/android/data/xmpp/GroupAffiliation;)V", "toXML", "", "enclosingNamespace", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UserWithAffiliationElement implements Element {
    public static final int $stable = 8;
    private final GroupAffiliation affiliation;
    private final Jid user;

    public UserWithAffiliationElement(Jid user, GroupAffiliation groupAffiliation) {
        y.i(user, "user");
        this.user = user;
        this.affiliation = groupAffiliation;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(String enclosingNamespace) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement("user");
        xmlStringBuilder.attribute(UserRoomJoin.COLUMN_AFFILIATION, this.affiliation);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.user);
        xmlStringBuilder.closeElement("user");
        return xmlStringBuilder;
    }
}
