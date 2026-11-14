package cu.todus.android.xmpp.iq.status;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.xmlpull.v1.XmlPullParser;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/status/GetFollowInfoIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/status/GetFollowInfoIQ;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetFollowInfoIQProvider extends IQProvider<GetFollowInfoIQ> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public GetFollowInfoIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        String attributeValue = parser.getAttributeValue("", MamElements.MamResultExtension.ELEMENT);
        String attributeValue2 = parser.getAttributeValue("", "error_code");
        String attributeValue3 = parser.getAttributeValue("", "following");
        y.h(attributeValue3, "getAttributeValue(...)");
        boolean z10 = Integer.parseInt(attributeValue3) == 1;
        String attributeValue4 = parser.getAttributeValue("", "follower");
        y.h(attributeValue4, "getAttributeValue(...)");
        boolean z11 = Integer.parseInt(attributeValue4) == 1;
        String attributeValue5 = parser.getAttributeValue("", "followers");
        y.h(attributeValue5, "getAttributeValue(...)");
        int i10 = Integer.parseInt(attributeValue5);
        String attributeValue6 = parser.getAttributeValue("", "followings");
        y.h(attributeValue6, "getAttributeValue(...)");
        int i11 = Integer.parseInt(attributeValue6);
        Pair pairA = z.a(Boolean.valueOf(z10), Boolean.valueOf(z11));
        Pair pairA2 = z.a(Integer.valueOf(i10), Integer.valueOf(i11));
        String str = d0.q0(attributeValue) ? attributeValue2 : attributeValue;
        y.h(str, "ifBlank(...)");
        return new GetFollowInfoIQ(null, pairA, pairA2, str, 1, null);
    }
}
