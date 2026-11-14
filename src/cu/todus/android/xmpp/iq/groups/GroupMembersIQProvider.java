package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.IQProvider;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JT\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0006\u001a\u00020\u00072&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GroupMembersIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/groups/GroupMembersIQ;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "parseUser", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "", "Lkotlin/collections/HashMap;", "map", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GroupMembersIQProvider extends IQProvider<GroupMembersIQ> {
    public static final int $stable = 8;

    private final HashMap<Jid, String> parseUser(XmlPullParser parser, HashMap<Jid, String> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(JidCreate.from(parser.nextText()), parser.getAttributeValue("", UserRoomJoin.COLUMN_AFFILIATION));
        return map;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public GroupMembersIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        HashMap<Jid, String> map = new HashMap<>();
        while (true) {
            int next = parser.next();
            if (next != 2) {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    return new GroupMembersIQ(null, map, 1, null);
                }
            } else if (y.d(parser.getName(), "user")) {
                map = parseUser(parser, map);
            }
        }
    }
}
