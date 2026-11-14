package cu.todus.android.xmpp.iq.version;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.service.UpdateDownloadService;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.z;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;", "<init>", "()V", "TAG", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetUpdateInfoIQProvider extends IQProvider<GetUpdateInfoIQ> {
    public static final int $stable = 8;
    private final String TAG = "GetUpdateInfoIQProvider";

    @Override // org.jivesoftware.smack.provider.Provider
    public GetUpdateInfoIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        long j10;
        long j11;
        Long lX;
        Long lX2;
        y.i(parser, "parser");
        parser.getDepth();
        parser.getEventType();
        parser.getName();
        long jLongValue = -1;
        if (parser.getEventType() == 2 && y.d(parser.getName(), "query")) {
            String attributeValue = parser.getAttributeValue("", "pn");
            if (attributeValue == null) {
                attributeValue = "";
            }
            String attributeValue2 = parser.getAttributeValue("", "vc");
            long jLongValue2 = (attributeValue2 == null || (lX2 = z.x(attributeValue2)) == null) ? -1L : lX2.longValue();
            String attributeValue3 = parser.getAttributeValue("", "vn");
            if (attributeValue3 == null) {
                attributeValue3 = "";
            }
            String attributeValue4 = parser.getAttributeValue("", "min_required_vc");
            if (attributeValue4 != null && (lX = z.x(attributeValue4)) != null) {
                jLongValue = lX.longValue();
            }
            String attributeValue5 = parser.getAttributeValue("", UpdateDownloadService.EXTRA_URL);
            if (attributeValue5 == null) {
                attributeValue5 = "";
            }
            String attributeValue6 = parser.getAttributeValue("", "published_at");
            str = attributeValue;
            str2 = attributeValue3;
            str4 = attributeValue6 != null ? attributeValue6 : "";
            j11 = jLongValue;
            j10 = jLongValue2;
            str3 = attributeValue5;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            j10 = -1;
            j11 = -1;
        }
        while (true) {
            if (parser.getEventType() == 3 && parser.getDepth() == initialDepth) {
                return new GetUpdateInfoIQ(str, j10, str2, j11, str3, str4);
            }
            parser.next();
            parser.getName();
            parser.getDepth();
        }
    }
}
