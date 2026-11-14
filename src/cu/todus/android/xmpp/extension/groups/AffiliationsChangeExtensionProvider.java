package cu.todus.android.xmpp.extension.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.xmpp.GroupAffiliation;
import cu.todus.android.xmpp.iq.groups.AffiliationsChangeExtension;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jxmpp.jid.impl.JidCreate;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/extension/groups/AffiliationsChangeExtensionProvider;", "Lorg/jivesoftware/smack/provider/ExtensionElementProvider;", "Lcu/todus/android/xmpp/iq/groups/AffiliationsChangeExtension;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AffiliationsChangeExtensionProvider extends ExtensionElementProvider<AffiliationsChangeExtension> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public AffiliationsChangeExtension parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        HashMap map = new HashMap();
        String strNextText = null;
        String strNextText2 = null;
        while (true) {
            int next = parser.next();
            if (next == 2) {
                if (y.d(parser.getName(), "prev-version")) {
                    strNextText = parser.nextText();
                }
                if (y.d(parser.getName(), "version")) {
                    strNextText2 = parser.nextText();
                }
                if (y.d(parser.getName(), "user")) {
                    map.put(JidCreate.from(parser.nextText()), GroupAffiliation.INSTANCE.fromString(parser.getAttributeValue("", UserRoomJoin.COLUMN_AFFILIATION)));
                }
            } else if (next == 3 && parser.getDepth() == initialDepth) {
                break;
            }
        }
        if (strNextText == null) {
            strNextText = "";
        }
        if (strNextText2 == null) {
            strNextText2 = "";
        }
        return new AffiliationsChangeExtension(map, strNextText, strNextText2);
    }
}
