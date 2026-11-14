package cu.todus.android.xmpp.iq.groups;

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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/AddGroupMembersIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "newMembers", "", "code", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getNewMembers", "()Ljava/util/List;", "setNewMembers", "(Ljava/util/List;)V", "getCode", "()Ljava/lang/String;", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AddGroupMembersIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "td:g:add_occupant";
    public static final String NEW_OCCUPANTS = "new_occupants";
    private final String code;
    private List<String> newMembers;
    public static final int $stable = 8;

    public AddGroupMembersIQ() {
        this(null, null, null, 7, null);
    }

    public final String getCode() {
        return this.code;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.attribute(NEW_OCCUPANTS, g0.G0(this.newMembers, ",", null, null, 0, null, null, 62, null));
        xml.rightAngleBracket();
        return xml;
    }

    public final List<String> getNewMembers() {
        return this.newMembers;
    }

    public final void setNewMembers(List<String> list) {
        y.i(list, "<set-?>");
        this.newMembers = list;
    }

    public /* synthetic */ AddGroupMembersIQ(String str, List list, String str2, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, (i10 & 2) != 0 ? w.n() : list, (i10 & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddGroupMembersIQ(String groupId, List<String> newMembers, String code) {
        super("query", NAMESPACE);
        y.i(groupId, "groupId");
        y.i(newMembers, "newMembers");
        y.i(code, "code");
        this.newMembers = newMembers;
        this.code = code;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
