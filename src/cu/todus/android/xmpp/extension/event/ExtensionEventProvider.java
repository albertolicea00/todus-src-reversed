package cu.todus.android.xmpp.extension.event;

import androidx.compose.runtime.internal.StabilityInferred;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/extension/event/ExtensionEventProvider;", "Lorg/jivesoftware/smack/provider/ExtensionElementProvider;", "Lcu/todus/android/xmpp/extension/event/ExtensionEvent;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionEventProvider extends ExtensionElementProvider<ExtensionEvent> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public ExtensionEvent parse(XmlPullParser parser, int initialDepth) throws XmlPullParserException, IOException {
        y.i(parser, "parser");
        ExtensionEvent extensionEvent = new ExtensionEvent();
        String attributeValue = parser.getAttributeValue("", "i");
        y.h(attributeValue, "getAttributeValue(...)");
        extensionEvent.setId(attributeValue);
        String attributeValue2 = parser.getAttributeValue("", "mi");
        y.h(attributeValue2, "getAttributeValue(...)");
        extensionEvent.setMessageId(attributeValue2);
        String attributeValue3 = parser.getAttributeValue("", ExtensionEvent.TAG_TITLE);
        y.h(attributeValue3, "getAttributeValue(...)");
        extensionEvent.setTitle(attributeValue3);
        String attributeValue4 = parser.getAttributeValue("", "s");
        y.h(attributeValue4, "getAttributeValue(...)");
        extensionEvent.setStart(Long.parseLong(attributeValue4));
        String attributeValue5 = parser.getAttributeValue("", ExtensionEvent.TAG_END);
        y.h(attributeValue5, "getAttributeValue(...)");
        extensionEvent.setEnd(Long.parseLong(attributeValue5));
        String attributeValue6 = parser.getAttributeValue("", ExtensionEvent.TAG_ALL_DAY);
        extensionEvent.setAllDay(attributeValue6 != null ? Boolean.parseBoolean(attributeValue6) : false);
        while (true) {
            int next = parser.next();
            String name = parser.getName();
            if (next != 2) {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    return extensionEvent;
                }
            } else if (y.d(name, ExtensionEvent.TAG_ICS)) {
                String strNextText = parser.nextText();
                y.h(strNextText, "nextText(...)");
                extensionEvent.setIcs(strNextText);
            }
        }
    }
}
