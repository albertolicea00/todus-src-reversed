package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GetGroupListPaginatedIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/groups/GetGroupListPaginatedIQ;", "<init>", "()V", "parseMuc", "Ljava/util/HashMap;", "Lorg/jxmpp/jid/Jid;", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "map", "parse", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetGroupListPaginatedIQProvider extends IQProvider<GetGroupListPaginatedIQ> {
    public static final int $stable = 8;

    private final HashMap<Jid, String> parseMuc(XmlPullParser parser, HashMap<Jid, String> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(JidCreate.from(parser.nextText()), parser.getAttributeValue("", "v"));
        return map;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public GetGroupListPaginatedIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        HashMap<Jid, String> map = new HashMap<>();
        while (true) {
            int next = parser.next();
            if (next != 2) {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    return new GetGroupListPaginatedIQ(map, 0, 0, 6, null);
                }
            } else if (y.d(parser.getName(), "muc")) {
                map = parseMuc(parser, map);
            }
        }
    }
}
