package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.pojo.info.ConfigChangeInChannel;
import cu.todus.android.data.db.pojo.info.ConfigChangeInGroup;
import cu.todus.android.data.db.pojo.info.DatePayload;
import cu.todus.android.data.db.pojo.info.DestroyGroup;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInChannel;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup;
import cu.todus.android.data.db.pojo.info.RoomBannerPayload;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import v5.k;
import v5.q;
import v5.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/MessageInfoSerializer;", "Lv5/r;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "<init>", "()V", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lv5/q;", "context", "Lv5/k;", "serialize", "(Lcu/todus/android/data/db/pojo/info/MessagePayload;Ljava/lang/reflect/Type;Lv5/q;)Lv5/k;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageInfoSerializer implements r {
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

    @Override // v5.r
    public k serialize(MessagePayload src, Type typeOfSrc, q context) {
        y.i(src, "src");
        y.i(context, "context");
        switch (WhenMappings.$EnumSwitchMapping$0[src.getType().ordinal()]) {
            case 1:
                k kVarB = context.b((PrivilegesChangeInGroup) src);
                y.f(kVarB);
                return kVarB;
            case 2:
                k kVarB2 = context.b((PrivilegesChangeInChannel) src);
                y.f(kVarB2);
                return kVarB2;
            case 3:
                k kVarB3 = context.b((ConfigChangeInGroup) src);
                y.f(kVarB3);
                return kVarB3;
            case 4:
                k kVarB4 = context.b((ConfigChangeInChannel) src);
                y.f(kVarB4);
                return kVarB4;
            case 5:
                k kVarB5 = context.b((DestroyGroup) src);
                y.f(kVarB5);
                return kVarB5;
            case 6:
                k kVarB6 = context.b((DatePayload) src);
                y.h(kVarB6, "serialize(...)");
                return kVarB6;
            case 7:
                k kVarB7 = context.b((RoomBannerPayload) src);
                y.h(kVarB7, "serialize(...)");
                return kVarB7;
            default:
                throw new ua.r();
        }
    }
}
