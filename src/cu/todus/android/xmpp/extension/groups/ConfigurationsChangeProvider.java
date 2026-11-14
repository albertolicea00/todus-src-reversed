package cu.todus.android.xmpp.extension.groups;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.xmpp.iq.groups.ConfigurationsChangeExtension;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lcu/todus/android/xmpp/extension/groups/ConfigurationsChangeProvider;", "Lorg/jivesoftware/smack/provider/ExtensionElementProvider;", "Lcu/todus/android/xmpp/iq/groups/ConfigurationsChangeExtension;", "<init>", "()V", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "initialDepth", "", "unmimefy", "", "name", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigurationsChangeProvider extends ExtensionElementProvider<ConfigurationsChangeExtension> {
    public static final int $stable = 8;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String unmimefy(String name) {
        int iHashCode = name.hashCode();
        if (iHashCode != 118) {
            switch (iHashCode) {
                case 3242:
                    if (name.equals("g1")) {
                        return "display_lines";
                    }
                    break;
                case 3243:
                    if (name.equals("g2")) {
                        return Room.CONFIG_PINED_MESSAGE;
                    }
                    break;
                case 3244:
                    if (name.equals("g3")) {
                        return Room.CONFIG_PICTURE;
                    }
                    break;
                case 3245:
                    if (name.equals("g4")) {
                        return Room.CONFIG_ROOM_NAME;
                    }
                    break;
            }
        } else if (name.equals("v")) {
            return "version";
        }
        return name;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // org.jivesoftware.smack.provider.Provider
    public ConfigurationsChangeExtension parse(XmlPullParser parser, int initialDepth) throws Exception {
        String str;
        String str2;
        y.i(parser, "parser");
        String strNextText = null;
        String strNextText2 = null;
        String strNextText3 = null;
        String strNextText4 = null;
        HashMap map = null;
        while (true) {
            int next = parser.next();
            if (next == 2) {
                str = strNextText2;
                str2 = strNextText4;
                String name = parser.getName();
                y.h(name, "getName(...)");
                String strUnmimefy = unmimefy(name);
                switch (strUnmimefy.hashCode()) {
                    case -1867885268:
                        if (!strUnmimefy.equals("subject")) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(strUnmimefy, parser.nextText());
                        } else {
                            strNextText4 = parser.nextText();
                            strNextText2 = str;
                        }
                        break;
                    case -1147224258:
                        if (!strUnmimefy.equals("prev-version")) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(strUnmimefy, parser.nextText());
                        } else {
                            strNextText = parser.nextText();
                        }
                        break;
                    case -172550682:
                        if (!strUnmimefy.equals(Room.CONFIG_ROOM_NAME)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(strUnmimefy, parser.nextText());
                        } else {
                            strNextText3 = parser.nextText();
                        }
                        break;
                    case 351608024:
                        if (!strUnmimefy.equals("version")) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(strUnmimefy, parser.nextText());
                        } else {
                            strNextText2 = parser.nextText();
                        }
                        strNextText4 = str2;
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(strUnmimefy, parser.nextText());
                        break;
                }
            } else {
                if (next == 3 && parser.getDepth() == initialDepth) {
                    String str3 = strNextText2;
                    if (strNextText == null) {
                        strNextText = "";
                    }
                    String str4 = strNextText4;
                    String str5 = str3 == null ? "" : str3;
                    String str6 = strNextText3 == null ? "" : strNextText3;
                    if (str4 == null) {
                        str4 = "";
                    }
                    return new ConfigurationsChangeExtension(strNextText, str5, str6, str4, map);
                }
                str = strNextText2;
                str2 = strNextText4;
            }
            strNextText2 = str;
            strNextText4 = str2;
        }
    }
}
