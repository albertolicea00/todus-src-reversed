package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.content.AudioContent;
import cu.todus.android.data.db.pojo.content.ButtonContent;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EditedContent;
import cu.todus.android.data.db.pojo.content.EmojiContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.ForwardedContent;
import cu.todus.android.data.db.pojo.content.GifContent;
import cu.todus.android.data.db.pojo.content.ImageContent;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.ReactionContent;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.db.pojo.content.StickerContent;
import cu.todus.android.data.db.pojo.content.VideoContent;
import cu.todus.android.data.db.pojo.content.VoiceContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusImageContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusTextContent;
import cu.todus.android.data.db.pojo.content.statusContent.StatusVideoContent;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/db/typeconverter/ContentDeserializer;", "Lv5/j;", "Lcu/todus/android/data/db/pojo/content/Content;", "<init>", "()V", "Lv5/k;", ExtensionSticker.TAG_JSON, "Ljava/lang/reflect/Type;", UserRoomJoin.AFFILIATION_MEMBER, "Lv5/i;", "context", "deserialize", "(Lv5/k;Ljava/lang/reflect/Type;Lv5/i;)Lcu/todus/android/data/db/pojo/content/Content;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentDeserializer implements j {
    public static final int $stable = 0;

    @Override // v5.j
    public Content deserialize(k json, Type member, i context) {
        y.i(json, "json");
        y.i(member, "member");
        y.i(context, "context");
        switch (json.d().n("type").b()) {
            case 1:
                Object objA = context.a(json, ImageContent.class);
                y.h(objA, "deserialize(...)");
                return (Content) objA;
            case 2:
                Object objA2 = context.a(json, VideoContent.class);
                y.h(objA2, "deserialize(...)");
                return (Content) objA2;
            case 3:
                Object objA3 = context.a(json, AudioContent.class);
                y.h(objA3, "deserialize(...)");
                return (Content) objA3;
            case 4:
                Object objA4 = context.a(json, VoiceContent.class);
                y.h(objA4, "deserialize(...)");
                return (Content) objA4;
            case 5:
            case 12:
            case 17:
            case 18:
            case 19:
            case 22:
            case 24:
            case 25:
            case 28:
            case 29:
            case 31:
            default:
                Object objA5 = context.a(json, FileContent.class);
                y.h(objA5, "deserialize(...)");
                return (Content) objA5;
            case 6:
                Object objA6 = context.a(json, ContactContent.class);
                y.h(objA6, "deserialize(...)");
                return (Content) objA6;
            case 7:
                Object objA7 = context.a(json, GifContent.class);
                y.h(objA7, "deserialize(...)");
                return (Content) objA7;
            case 8:
                Object objA8 = context.a(json, EventContent.class);
                y.h(objA8, "deserialize(...)");
                return (Content) objA8;
            case 9:
                Object objA9 = context.a(json, ReplyMsgContent.class);
                y.h(objA9, "deserialize(...)");
                return (Content) objA9;
            case 10:
                Object objA10 = context.a(json, LocationContent.class);
                y.h(objA10, "deserialize(...)");
                return (Content) objA10;
            case 11:
                Object objA11 = context.a(json, EmojiContent.class);
                y.h(objA11, "deserialize(...)");
                return (Content) objA11;
            case 13:
                Object objA12 = context.a(json, StickerContent.class);
                y.h(objA12, "deserialize(...)");
                return (Content) objA12;
            case 14:
                Object objA13 = context.a(json, ForwardedContent.class);
                y.h(objA13, "deserialize(...)");
                return (Content) objA13;
            case 15:
                Object objA14 = context.a(json, EditedContent.class);
                y.h(objA14, "deserialize(...)");
                return (Content) objA14;
            case 16:
                Object objA15 = context.a(json, DeletedContent.class);
                y.h(objA15, "deserialize(...)");
                return (Content) objA15;
            case 20:
                Object objA16 = context.a(json, LinkInfoContent.class);
                y.h(objA16, "deserialize(...)");
                return (Content) objA16;
            case 21:
                Object objA17 = context.a(json, ButtonContent.class);
                y.f(objA17);
                return (Content) objA17;
            case 23:
                Object objA18 = context.a(json, ReactionContent.class);
                y.f(objA18);
                return (Content) objA18;
            case 26:
                Object objA19 = context.a(json, StatusTextContent.class);
                y.f(objA19);
                return (Content) objA19;
            case 27:
                Object objA20 = context.a(json, StatusImageContent.class);
                y.f(objA20);
                return (Content) objA20;
            case 30:
                Object objA21 = context.a(json, StatusVideoContent.class);
                y.f(objA21);
                return (Content) objA21;
            case 32:
                Object objA22 = context.a(json, CallContent.class);
                y.h(objA22, "deserialize(...)");
                return (Content) objA22;
        }
    }
}
