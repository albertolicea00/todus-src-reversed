package cu.todus.android.xmpp.iq.roster;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.z;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/xmpp/iq/roster/RosterGetUsersInfoIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/roster/RosterGetUsersInfoIQ;", "<init>", "()V", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "", "initialDepth", "parse", "(Lorg/xmlpull/v1/XmlPullParser;I)Lcu/todus/android/xmpp/iq/roster/RosterGetUsersInfoIQ;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterGetUsersInfoIQProvider extends IQProvider<RosterGetUsersInfoIQ> {
    public static final int $stable = 8;
    private final f gson = new f();

    public final f getGson() {
        return this.gson;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public RosterGetUsersInfoIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = parser.next();
            if (next != 2) {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    return new RosterGetUsersInfoIQ(null, arrayList, 1, null);
                }
            } else if (y.d(parser.getName(), "user")) {
                String attributeValue = parser.getAttributeValue("", "username");
                String attributeValue2 = parser.getAttributeValue("", User.COLUMN_ALIAS);
                String attributeValue3 = parser.getAttributeValue("", "description");
                String attributeValue4 = parser.getAttributeValue("", "official");
                String attributeValue5 = parser.getAttributeValue("", "pic_url");
                y.h(attributeValue5, "getAttributeValue(...)");
                String strO = a0.O(attributeValue5, "s3.todus.cu", "profile.todus.cu", false, 4, null);
                String attributeValue6 = parser.getAttributeValue("", "pic_thumb_url");
                y.h(attributeValue6, "getAttributeValue(...)");
                String strO2 = a0.O(attributeValue6, "s3.todus.cu", "profile.todus.cu", false, 4, null);
                String attributeValue7 = parser.getAttributeValue("", "exists");
                String attributeValue8 = parser.getAttributeValue("", "todus_id");
                String attributeValue9 = parser.getAttributeValue("", RosterUpdateVersionIQ.ROSTER_VERSION);
                y.h(attributeValue9, "getAttributeValue(...)");
                Integer numV = z.v(attributeValue9);
                int iIntValue = numV != null ? numV.intValue() : -1;
                y.f(attributeValue);
                y.f(attributeValue2);
                y.f(attributeValue3);
                y.f(attributeValue4);
                int i10 = Integer.parseInt(attributeValue4);
                y.f(attributeValue8);
                User user = new User(attributeValue + "@im.todus.cu", attributeValue, attributeValue2, strO, attributeValue3, iIntValue, strO2, i10, false, attributeValue8, 256, null);
                y.f(attributeValue7);
                if (Integer.parseInt(attributeValue7) == 1) {
                    arrayList.add(user);
                }
            }
        }
    }
}
