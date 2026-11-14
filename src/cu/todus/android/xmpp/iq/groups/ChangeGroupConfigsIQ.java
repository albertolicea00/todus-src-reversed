package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eBM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/ChangeGroupConfigsIQ;", "Lorg/jivesoftware/smack/packet/IQ;", "groupId", "", "name", "subject", "customConfigs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getIQChildElementBuilder", "Lorg/jivesoftware/smack/packet/IQ$IQChildElementXmlStringBuilder;", "xml", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChangeGroupConfigsIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "x10";
    private final HashMap<String, String> customConfigs;
    private final String name;
    private final String subject;
    public static final int $stable = 8;

    public /* synthetic */ ChangeGroupConfigsIQ(String str, String str2, String str3, HashMap map, int i10, p pVar) {
        this((i10 & 1) != 0 ? "muc_example_name@muclight.im.todus.cu" : str, str2, str3, map);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder xml) {
        y.i(xml, "xml");
        xml.rightAngleBracket();
        xml.optElement(Room.CONFIG_ROOM_NAME, this.name);
        xml.optElement("subject", this.subject);
        HashMap<String, String> map = this.customConfigs;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                xml.element(entry.getKey(), entry.getValue());
            }
        }
        return xml;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeGroupConfigsIQ(String groupId, String str, String str2, HashMap<String, String> map) {
        super("query", "x10");
        y.i(groupId, "groupId");
        this.name = str;
        this.subject = str2;
        this.customConfigs = map;
        setType(IQ.Type.set);
        setTo(JidCreate.bareFrom(groupId));
    }
}
