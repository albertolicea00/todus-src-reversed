package cu.todus.android.xmpp.iq.roster;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.utils.Base64Util;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterGetListPaginatedIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/roster/RosterGetListPaginatedIQ;", "<init>", "()V", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "", "initialDepth", "parse", "(Lorg/xmlpull/v1/XmlPullParser;I)Lcu/todus/android/xmpp/iq/roster/RosterGetListPaginatedIQ;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterGetListPaginatedIQProvider extends IQProvider<RosterGetListPaginatedIQ> {
    public static final int $stable = 8;
    private final f gson = new f();

    public final f getGson() {
        return this.gson;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public RosterGetListPaginatedIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = parser.next();
            if (next == 2) {
                String attributeValue = parser.getAttributeValue("", "phone");
                String strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, parser.getAttributeValue("", User.COLUMN_ALIAS), 0, 2, null);
                arrayList.add(new Pair(attributeValue, strDecodedMessage$default != null ? strDecodedMessage$default : ""));
            } else if (next == 3 && parser.getDepth() == initialDepth) {
                return new RosterGetListPaginatedIQ(arrayList, 0, 0, 6, null);
            }
        }
    }
}
