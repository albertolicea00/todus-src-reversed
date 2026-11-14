package cu.todus.android.xmpp.extension.image;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/extension/image/ExtensionImageProvider;", "Lorg/jivesoftware/smack/provider/ExtensionElementProvider;", "Lcu/todus/android/xmpp/extension/image/ExtensionImage;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtensionImageProvider extends ExtensionElementProvider<ExtensionImage> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public ExtensionImage parse(XmlPullParser parser, int initialDepth) {
        y.i(parser, "parser");
        ExtensionImage extensionImage = new ExtensionImage();
        String attributeValue = parser.getAttributeValue("", "i");
        y.h(attributeValue, "getAttributeValue(...)");
        extensionImage.setId(attributeValue);
        String attributeValue2 = parser.getAttributeValue("", "mi");
        y.h(attributeValue2, "getAttributeValue(...)");
        extensionImage.setMessageId(attributeValue2);
        String attributeValue3 = parser.getAttributeValue("", "url");
        y.h(attributeValue3, "getAttributeValue(...)");
        extensionImage.setUrl(attributeValue3);
        String attributeValue4 = parser.getAttributeValue("", "n");
        y.h(attributeValue4, "getAttributeValue(...)");
        extensionImage.setName(attributeValue4);
        String attributeValue5 = parser.getAttributeValue("", "s");
        y.h(attributeValue5, "getAttributeValue(...)");
        extensionImage.setSize(Long.parseLong(attributeValue5));
        String attributeValue6 = parser.getAttributeValue("", "h");
        y.h(attributeValue6, "getAttributeValue(...)");
        extensionImage.setHash(attributeValue6);
        String attributeValue7 = parser.getAttributeValue("", "w");
        y.h(attributeValue7, "getAttributeValue(...)");
        extensionImage.setWidth(Long.parseLong(attributeValue7));
        String attributeValue8 = parser.getAttributeValue("", "he");
        y.h(attributeValue8, "getAttributeValue(...)");
        extensionImage.setHeight(Long.parseLong(attributeValue8));
        String attributeValue9 = parser.getAttributeValue("", "tnail");
        y.h(attributeValue9, "getAttributeValue(...)");
        extensionImage.setThumbnail(attributeValue9);
        return extensionImage;
    }
}
