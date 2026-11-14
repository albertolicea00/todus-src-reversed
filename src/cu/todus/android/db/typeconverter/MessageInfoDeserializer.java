package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.info.ConfigChangeInChannel;
import cu.todus.android.data.db.pojo.info.ConfigChangeInGroup;
import cu.todus.android.data.db.pojo.info.DatePayload;
import cu.todus.android.data.db.pojo.info.DestroyGroup;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInChannel;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup;
import cu.todus.android.data.db.pojo.info.RoomBannerPayload;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.r;
import v5.i;
import v5.j;
import v5.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/MessageInfoDeserializer;", "Lv5/j;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "<init>", "()V", "Lv5/k;", ExtensionSticker.TAG_JSON, "Ljava/lang/reflect/Type;", UserRoomJoin.AFFILIATION_MEMBER, "Lv5/i;", "context", "deserialize", "(Lv5/k;Ljava/lang/reflect/Type;Lv5/i;)Lcu/todus/android/data/db/pojo/info/MessagePayload;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageInfoDeserializer implements j {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessagePayload.TYPE.values().length];
            try {
                iArr[MessagePayload.TYPE.PRIVILEGES_CHANGE_IN_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessagePayload.TYPE.PRIVILEGES_CHANGE_IN_CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessagePayload.TYPE.CONFIG_CHANGE_IN_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessagePayload.TYPE.CONFIG_CHANGE_IN_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessagePayload.TYPE.DESTROY_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessagePayload.TYPE.DATE_PAYLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MessagePayload.TYPE.ROOM_BANNER_PAYLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // v5.j
    public MessagePayload deserialize(k json, Type member, i context) {
        y.i(json, "json");
        y.i(member, "member");
        y.i(context, "context");
        String strF = json.d().n("type").f();
        y.f(strF);
        switch (WhenMappings.$EnumSwitchMapping$0[MessagePayload.TYPE.valueOf(strF).ordinal()]) {
            case 1:
                Object objA = context.a(json, PrivilegesChangeInGroup.class);
                y.h(objA, "deserialize(...)");
                return (MessagePayload) objA;
            case 2:
                Object objA2 = context.a(json, PrivilegesChangeInChannel.class);
                y.h(objA2, "deserialize(...)");
                return (MessagePayload) objA2;
            case 3:
                Object objA3 = context.a(json, ConfigChangeInGroup.class);
                y.h(objA3, "deserialize(...)");
                return (MessagePayload) objA3;
            case 4:
                Object objA4 = context.a(json, ConfigChangeInChannel.class);
                y.h(objA4, "deserialize(...)");
                return (MessagePayload) objA4;
            case 5:
                Object objA5 = context.a(json, DestroyGroup.class);
                y.h(objA5, "deserialize(...)");
                return (MessagePayload) objA5;
            case 6:
                Object objA6 = context.a(json, DatePayload.class);
                y.h(objA6, "deserialize(...)");
                return (MessagePayload) objA6;
            case 7:
                Object objA7 = context.a(json, RoomBannerPayload.class);
                y.h(objA7, "deserialize(...)");
                return (MessagePayload) objA7;
            default:
                throw new r();
        }
    }
}
