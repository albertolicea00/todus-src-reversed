package cu.todus.android.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.Service;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005¨\u0006\u0016"}, d2 = {"Lcu/todus/android/xmpp/XMPPUtils;", "", "<init>", "()V", "fromJIDToUserName", "", "jidString", "fromUserNameToJID", "userName", "fromMUCIdToJID", "roomId", "fromChannelIdToJID", "isUser", "", "uid", "isMUC", "isChannel", "isCard", "getChatType", "", "proveIsNotPhoneNumber", "needSendMarkers", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XMPPUtils {
    public static final int $stable = 0;
    public static final XMPPUtils INSTANCE = new XMPPUtils();

    private XMPPUtils() {
    }

    private final boolean proveIsNotPhoneNumber(String uid) {
        try {
            Long.parseLong((String) le.d0.S0(uid, new String[]{"@"}, false, 0, 6, null).get(0));
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final String fromChannelIdToJID(String roomId) {
        if (roomId == null) {
            return "";
        }
        if (le.d0.a0(roomId, "@", false, 2, null)) {
            return roomId;
        }
        return roomId + "@ch";
    }

    public final String fromJIDToUserName(String jidString) {
        kotlin.jvm.internal.y.i(jidString, "jidString");
        int iO0 = le.d0.o0(jidString, "@", 0, false, 6, null);
        if (iO0 >= 0 && !kotlin.jvm.internal.y.d(jidString, "")) {
            String strSubstring = jidString.substring(iO0 + 1);
            kotlin.jvm.internal.y.h(strSubstring, "substring(...)");
            if (le.a0.U(strSubstring, Service.Config.SERVER_DOMAIN, false, 2, null)) {
                String strSubstring2 = jidString.substring(0, iO0);
                kotlin.jvm.internal.y.h(strSubstring2, "substring(...)");
                return strSubstring2;
            }
        }
        return jidString;
    }

    public final String fromMUCIdToJID(String roomId) {
        if (roomId == null) {
            return "";
        }
        if (le.d0.a0(roomId, "@", false, 2, null)) {
            return roomId;
        }
        return roomId + "@muclight.im.todus.cu";
    }

    public final String fromUserNameToJID(String userName) {
        if (userName == null) {
            return "";
        }
        if (le.d0.a0(userName, "@", false, 2, null)) {
            return userName;
        }
        return userName + "@im.todus.cu";
    }

    public final int getChatType(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        if (isCard(uid)) {
            return 3;
        }
        if (isUser(uid)) {
            return 0;
        }
        if (isMUC(uid)) {
            return 1;
        }
        return isChannel(uid) ? 2 : 0;
    }

    public final boolean isCard(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        if (!le.a0.F(uid, Service.Config.SERVER_NAME_CHANNELS, false, 2, null) && !le.d0.a0(uid, Service.Config.MUC_LIGHT_SERVICE_NAME, false, 2, null) && le.d0.a0(uid, "@im.todus.cu", false, 2, null) && proveIsNotPhoneNumber(uid)) {
            try {
                Long.parseLong((String) le.d0.S0(uid, new String[]{"@"}, false, 0, 6, null).get(0));
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    public final boolean isChannel(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return le.a0.F(uid, Service.Config.SERVER_NAME_CHANNELS, false, 2, null);
    }

    public final boolean isMUC(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return le.d0.a0(uid, Service.Config.MUC_LIGHT_SERVICE_NAME, false, 2, null);
    }

    public final boolean isUser(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return (isMUC(uid) || isChannel(uid) || isCard(uid)) ? false : true;
    }

    public final boolean needSendMarkers(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return (isCard(uid) || isChannel(uid)) ? false : true;
    }
}
