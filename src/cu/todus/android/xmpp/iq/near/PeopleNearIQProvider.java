package cu.todus.android.xmpp.iq.near;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.xmpp.XMPPUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/near/PeopleNearIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/near/PeopleNearIQ;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PeopleNearIQProvider extends IQProvider<PeopleNearIQ> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public PeopleNearIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        ArrayList arrayList = new ArrayList();
        while (true) {
            int next = parser.next();
            if (next != 2) {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    return new PeopleNearIQ(0, 0, arrayList, 3, null);
                }
            } else if (y.d(parser.getName(), "user")) {
                String attributeValue = parser.getAttributeValue("", "dist");
                y.h(attributeValue, "getAttributeValue(...)");
                double d10 = Double.parseDouble(attributeValue);
                String attributeValue2 = parser.getAttributeValue("", "pic");
                String attributeValue3 = parser.getAttributeValue("", User.COLUMN_ALIAS);
                String attributeValue4 = parser.getAttributeValue("", "desc");
                String str = attributeValue4 == null ? "" : attributeValue4;
                String strNextText = parser.nextText();
                Double dValueOf = Double.valueOf(d10);
                String strFromUserNameToJID = XMPPUtils.INSTANCE.fromUserNameToJID(strNextText);
                y.f(strNextText);
                y.f(attributeValue3);
                y.f(attributeValue2);
                arrayList.add(z.a(dValueOf, new User(strFromUserNameToJID, strNextText, attributeValue3, attributeValue2, str, 0, null, 0, false, null, 992, null)));
            }
        }
    }
}
