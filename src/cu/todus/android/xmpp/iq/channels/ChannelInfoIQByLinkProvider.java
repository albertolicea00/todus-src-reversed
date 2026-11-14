package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.xmpp.ChannelInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/ChannelInfoIQByLinkProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/channels/ChannelInfoIQByLink;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelInfoIQByLinkProvider extends IQProvider<ChannelInfoIQByLink> {
    public static final int $stable = 8;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x00b9  */
    @Override // org.jivesoftware.smack.provider.Provider
    public ChannelInfoIQByLink parse(XmlPullParser parser, int initialDepth) throws XmlPullParserException, IOException {
        String str;
        List arrayList;
        y.i(parser, "parser");
        ChannelInfo channelInfo = null;
        while (true) {
            int next = parser.next();
            if (next == 2) {
                String attributeValue = parser.getAttributeValue("", "ch_id");
                if (attributeValue == null) {
                    attributeValue = "";
                }
                String attributeValue2 = parser.getAttributeValue("", "name");
                String str2 = attributeValue2 == null ? "" : attributeValue2;
                String attributeValue3 = parser.getAttributeValue("", "created");
                String str3 = attributeValue3 == null ? "" : attributeValue3;
                String attributeValue4 = parser.getAttributeValue("", "desc");
                String str4 = attributeValue4 == null ? "" : attributeValue4;
                String attributeValue5 = parser.getAttributeValue("", "link");
                String str5 = attributeValue5 == null ? "" : attributeValue5;
                String attributeValue6 = parser.getAttributeValue("", "profile_photo");
                String str6 = attributeValue6 == null ? "" : attributeValue6;
                String attributeValue7 = parser.getAttributeValue("", "public");
                int i10 = attributeValue7 != null ? Integer.parseInt(attributeValue7) : 0;
                String attributeValue8 = parser.getAttributeValue("", "subs_c");
                int i11 = attributeValue8 != null ? Integer.parseInt(attributeValue8) : 0;
                String attributeValue9 = parser.getAttributeValue("", Room.CONFIG_ROLE);
                if (attributeValue9 == null) {
                    attributeValue9 = ExifInterface.GPS_MEASUREMENT_3D;
                }
                switch (attributeValue9) {
                    case "1":
                        str = UserRoomJoin.AFFILIATION_OWNER;
                        break;
                    case "2":
                        str = "admin";
                        break;
                    case "3":
                        str = UserRoomJoin.AFFILIATION_MEMBER;
                        break;
                    default:
                        str = "none";
                        break;
                }
                String str7 = str;
                String attributeValue10 = parser.getAttributeValue("", "rights");
                if (attributeValue10 == null || (arrayList = d0.S0(attributeValue10, new String[]{","}, false, 0, 6, null)) == null) {
                    arrayList = new ArrayList();
                }
                channelInfo = new ChannelInfo(attributeValue + "@ch", str2, str3, str4, str5, str6, null, i10, i11, str7, arrayList, null, 2112, null);
            } else if (next == 3 && parser.getDepth() == initialDepth) {
                return new ChannelInfoIQByLink(null, channelInfo, 1, null);
            }
        }
    }
}
