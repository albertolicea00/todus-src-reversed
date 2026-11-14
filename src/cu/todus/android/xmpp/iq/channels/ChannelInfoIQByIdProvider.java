package cu.todus.android.xmpp.iq.channels;

import androidx.compose.runtime.internal.StabilityInferred;
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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/channels/ChannelInfoIQByIdProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/channels/ChannelInfoIQById;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelInfoIQByIdProvider extends IQProvider<ChannelInfoIQById> {
    public static final int $stable = 8;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:60:0x00c3  */
    @Override // org.jivesoftware.smack.provider.Provider
    public ChannelInfoIQById parse(XmlPullParser parser, int initialDepth) throws XmlPullParserException, IOException {
        String str;
        List arrayList;
        y.i(parser, "parser");
        ChannelInfo channelInfo = null;
        while (true) {
            int next = parser.next();
            if (next == 2) {
                String attributeValue = parser.getAttributeValue("", "name");
                String str2 = attributeValue == null ? "" : attributeValue;
                String attributeValue2 = parser.getAttributeValue("", "created");
                String str3 = attributeValue2 == null ? "" : attributeValue2;
                String attributeValue3 = parser.getAttributeValue("", "desc");
                String str4 = attributeValue3 == null ? "" : attributeValue3;
                String attributeValue4 = parser.getAttributeValue("", "link");
                String str5 = attributeValue4 == null ? "" : attributeValue4;
                String attributeValue5 = parser.getAttributeValue("", "profile_photo");
                String str6 = attributeValue5 == null ? "" : attributeValue5;
                String attributeValue6 = parser.getAttributeValue("", CreateChannelIQ.PROFILE_PHOTO_THUMB);
                String attributeValue7 = parser.getAttributeValue("", "public");
                int i10 = attributeValue7 != null ? Integer.parseInt(attributeValue7) : 0;
                String attributeValue8 = parser.getAttributeValue("", "subs_c");
                int i11 = attributeValue8 != null ? Integer.parseInt(attributeValue8) : 0;
                String attributeValue9 = parser.getAttributeValue("", "v");
                String str7 = attributeValue9 == null ? "" : attributeValue9;
                String attributeValue10 = parser.getAttributeValue("", Room.CONFIG_ROLE);
                if (attributeValue10 == null) {
                    attributeValue10 = "4";
                }
                switch (attributeValue10) {
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
                String str8 = str;
                String attributeValue11 = parser.getAttributeValue("", "rights");
                if (attributeValue11 == null || (arrayList = d0.S0(attributeValue11, new String[]{","}, false, 0, 6, null)) == null) {
                    arrayList = new ArrayList();
                }
                List list = arrayList;
                y.f(attributeValue6);
                channelInfo = new ChannelInfo("", str2, str3, str4, str5, str6, attributeValue6, i10, i11, str8, list, str7);
            } else if (next == 3 && parser.getDepth() == initialDepth) {
                return new ChannelInfoIQById(null, channelInfo, 1, null);
            }
        }
    }
}
