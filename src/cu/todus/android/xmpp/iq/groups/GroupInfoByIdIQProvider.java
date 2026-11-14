package cu.todus.android.xmpp.iq.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.xmpp.MucInfo;
import cu.todus.android.utils.Base64Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smack.provider.IQProvider;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import ua.z;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcu/todus/android/xmpp/iq/groups/GroupInfoByIdIQProvider;", "Lorg/jivesoftware/smack/provider/IQProvider;", "Lcu/todus/android/xmpp/iq/groups/GroupInfoByIdIQ;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GroupInfoByIdIQProvider extends IQProvider<GroupInfoByIdIQ> {
    public static final int $stable = 8;

    @Override // org.jivesoftware.smack.provider.Provider
    public GroupInfoByIdIQ parse(XmlPullParser parser, int initialDepth) throws Exception {
        y.i(parser, "parser");
        String attributeValue = parser.getAttributeValue("", "info");
        if (attributeValue == null) {
            attributeValue = "";
        }
        if (attributeValue.length() == 0) {
            return new GroupInfoByIdIQ("muc_example@muclight.im.todus.cu", null);
        }
        String strDecodedMessage = Base64Util.INSTANCE.decodedMessage(attributeValue, 0);
        if (strDecodedMessage == null) {
            strDecodedMessage = "{}";
        }
        JSONObject jSONObject = new JSONObject(strDecodedMessage);
        JSONObject jSONObject2 = new JSONObject(jSONObject.getString(Room.CONFIG_CONFIG));
        String string = jSONObject.has("muc_luser") ? jSONObject.getString("muc_luser") : "";
        int i10 = jSONObject.has(Room.CONFIG_AFF_COUNT) ? jSONObject.getInt(Room.CONFIG_AFF_COUNT) : 0;
        String[] strArr = {jSONObject.has("admin") ? jSONObject.getString("admin") : ""};
        String string2 = jSONObject2.has(Room.CONFIG_PICTURE) ? jSONObject2.getString(Room.CONFIG_PICTURE) : "";
        String string3 = jSONObject2.has(Room.CONFIG_PICTURE_THUMBNAIL) ? jSONObject2.getString(Room.CONFIG_PICTURE_THUMBNAIL) : "";
        String string4 = jSONObject2.has(Room.CONFIG_ROOM_NAME) ? jSONObject2.getString(Room.CONFIG_ROOM_NAME) : "";
        String string5 = jSONObject2.has("subject") ? jSONObject2.getString("subject") : "";
        String string6 = jSONObject.has("version") ? jSONObject.getString("version") : "";
        String string7 = jSONObject.has("aff") ? jSONObject.getString("aff") : "";
        String str = ((Object) (d0.q0(string) ? "muc_example" : string)) + "@muclight.im.todus.cu";
        String str2 = string + "@muclight.im.todus.cu";
        Map mapL = w0.l(z.a(Room.CONFIG_PICTURE, string2), z.a(Room.CONFIG_PICTURE_THUMBNAIL, string3), z.a(Room.CONFIG_ROOM_NAME, string4), z.a("subject", string5));
        y.f(string6);
        y.f(string7);
        return new GroupInfoByIdIQ(str, new MucInfo(str2, null, string6, mapL, strArr, i10, string7, 2, null));
    }
}
