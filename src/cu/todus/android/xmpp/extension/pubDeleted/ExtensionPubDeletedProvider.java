package cu.todus.android.xmpp.extension.pubDeleted;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/extension/pubDeleted/ExtensionPubDeletedProvider;", "Lorg/jivesoftware/smack/provider/ExtensionElementProvider;", "Lcu/todus/android/xmpp/extension/pubDeleted/ExtensionPubDeleted;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionPubDeletedProvider extends ExtensionElementProvider<ExtensionPubDeleted> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public ExtensionPubDeleted parse(XmlPullParser parser, int initialDepth) {
        y.i(parser, "parser");
        ExtensionPubDeleted extensionPubDeleted = new ExtensionPubDeleted();
        String attributeValue = parser.getAttributeValue("", "ch_id");
        y.h(attributeValue, "getAttributeValue(...)");
        extensionPubDeleted.setChId(attributeValue);
        String attributeValue2 = parser.getAttributeValue("", ExtensionPubDeleted.TAG_MSG_PUB_ID);
        extensionPubDeleted.setPubsId(d0.S0(attributeValue2 == null ? "" : attributeValue2, new String[]{","}, false, 0, 6, null));
        return extensionPubDeleted;
    }
}
