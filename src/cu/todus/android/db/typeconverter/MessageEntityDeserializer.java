package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.messageentity.MentionLink;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import v5.i;
import v5.j;
import v5.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/MessageEntityDeserializer;", "Lv5/j;", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "<init>", "()V", "Lv5/k;", ExtensionSticker.TAG_JSON, "Ljava/lang/reflect/Type;", UserRoomJoin.AFFILIATION_MEMBER, "Lv5/i;", "context", "deserialize", "(Lv5/k;Ljava/lang/reflect/Type;Lv5/i;)Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageEntityDeserializer implements j {
    public static final int $stable = 0;

    @Override // v5.j
    public MessageEntity deserialize(k json, Type member, i context) {
        y.i(json, "json");
        y.i(member, "member");
        y.i(context, "context");
        int iB = json.d().n("type").b();
        if (iB == 1) {
            Object objA = context.a(json, MentionName.class);
            y.h(objA, "deserialize(...)");
            return (MessageEntity) objA;
        }
        if (iB != 2) {
            Object objA2 = context.a(json, MessageEntity.class);
            y.h(objA2, "deserialize(...)");
            return (MessageEntity) objA2;
        }
        Object objA3 = context.a(json, MentionLink.class);
        y.h(objA3, "deserialize(...)");
        return (MessageEntity) objA3;
    }
}
