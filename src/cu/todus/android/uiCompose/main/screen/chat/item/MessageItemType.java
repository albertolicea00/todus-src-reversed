package cu.todus.android.uiCompose.main.screen.chat.item;

import com.google.android.gms.stats.CodePackage;
import cu.todus.android.data.db.entity.toDus.RosterChange;
import cu.todus.android.data.db.pojo.content.FileContent;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/item/MessageItemType;", "", "<init>", "(Ljava/lang/String;I)V", "LINKS", "DELAYED_MESSAGE", "EMPTY_MESSAGE", "MESSAGE", "STICKER", "IMAGE", "GIF", "VOICE", "AUDIO", "VIDEO", "CONTACT", FileContent.TYPE, "EVENT", CodePackage.LOCATION, RosterChange.TYPE_DELETE, "BUTTON", "CALL", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum MessageItemType {
    LINKS,
    DELAYED_MESSAGE,
    EMPTY_MESSAGE,
    MESSAGE,
    STICKER,
    IMAGE,
    GIF,
    VOICE,
    AUDIO,
    VIDEO,
    CONTACT,
    FILE,
    EVENT,
    LOCATION,
    DELETE,
    BUTTON,
    CALL;

    private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

    public static db.a getEntries() {
        return $ENTRIES;
    }
}
