package cu.todus.android.xmpp.iq.status;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.xmlpull.v1.XmlPullParser;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/status/GetFollowingIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/status/GetFollowingIQ;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetFollowingIQProvider extends IQProvider<GetFollowingIQ> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public GetFollowingIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        String attributeValue = parser.getAttributeValue("", MamElements.MamResultExtension.ELEMENT);
        y.h(attributeValue, "getAttributeValue(...)");
        List listS0 = d0.S0(attributeValue, new String[]{","}, false, 0, 6, null);
        String attributeValue2 = parser.getAttributeValue("", "error_code");
        if (listS0.size() == 1 && d0.q0((CharSequence) listS0.get(0))) {
            listS0 = w.n();
        }
        y.f(attributeValue2);
        return new GetFollowingIQ(null, 0, 0, listS0, attributeValue2, 7, null);
    }
}
