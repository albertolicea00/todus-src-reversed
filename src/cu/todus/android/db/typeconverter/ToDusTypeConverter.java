package cu.todus.android.db.typeconverter;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.TypeConverter;
import com.google.gson.reflect.TypeToken;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.xmpp.ChatMarker;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import v5.f;
import v5.g;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0007¢\u0006\u0004\b%\u0010!J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010#J)\u0010(\u001a\u00020\u00042\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040'0\u001dH\u0007¢\u0006\u0004\b(\u0010!J)\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040'0\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b)\u0010#J\u001b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u0004\u0018\u00010*2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b.\u0010/R*\u00102\u001a\n 1*\u0004\u0018\u000100008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00068"}, d2 = {"Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "", "<init>", "()V", "", ExtensionSticker.TAG_JSON, "", "toConfiguration", "(Ljava/lang/String;)Ljava/util/Map;", "configuration", "fromConfiguration", "(Ljava/util/Map;)Ljava/lang/String;", "Lcu/todus/android/data/db/pojo/content/Content;", "toAttachmentContent", "(Ljava/lang/String;)Lcu/todus/android/data/db/pojo/content/Content;", "content", "fromAttachmentContent", "(Lcu/todus/android/data/db/pojo/content/Content;)Ljava/lang/String;", "Lcu/todus/android/data/xmpp/ChatMarker$TYPE;", "toChatMarkerType", "(Ljava/lang/String;)Lcu/todus/android/data/xmpp/ChatMarker$TYPE;", "fromChatMarkerType", "(Lcu/todus/android/data/xmpp/ChatMarker$TYPE;)Ljava/lang/String;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "messagePayload", "fromMessagePayload", "(Lcu/todus/android/data/db/pojo/info/MessagePayload;)Ljava/lang/String;", "toMessagePayload", "(Ljava/lang/String;)Lcu/todus/android/data/db/pojo/info/MessagePayload;", "", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", Message.COLUMN_MESSAGE_ENTITIES, "fromMessageEntity", "(Ljava/util/List;)Ljava/lang/String;", "toMessageEntity", "(Ljava/lang/String;)Ljava/util/List;", Service.Endpoint.LINKED_DEVICES_LIST, "fromListString", "toListString", "Lkotlin/Pair;", "fromPairString", "toPair", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", "linkEntity", "fromGraphQlEntity", "(Lcu/todus/android/data/db/pojo/content/LinkEntity;)Ljava/lang/String;", "toGraphQlEntity", "(Ljava/lang/String;)Lcu/todus/android/data/db/pojo/content/LinkEntity;", "Lv5/f;", "kotlin.jvm.PlatformType", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "setGson", "(Lv5/f;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusTypeConverter {
    public static final int $stable = 8;
    private f gson = new g().d(MessageEntity.class, new MessageEntityDeserializer()).d(MessageEntity.class, new MessageEntitySerializer()).d(Content.class, new ContentDeserializer()).d(Content.class, new ContentSerializer()).d(MessagePayload.class, new MessageInfoSerializer()).d(MessagePayload.class, new MessageInfoDeserializer()).b();

    @TypeConverter
    public final String fromAttachmentContent(Content content) {
        y.i(content, "content");
        String strT = this.gson.t(content);
        y.h(strT, "toJson(...)");
        return strT;
    }

    @TypeConverter
    public final String fromChatMarkerType(ChatMarker.TYPE content) {
        y.i(content, "content");
        return content.name();
    }

    @TypeConverter
    public final String fromConfiguration(Map<String, String> configuration) {
        y.i(configuration, "configuration");
        String strT = this.gson.t(configuration);
        y.h(strT, "toJson(...)");
        return strT;
    }

    @TypeConverter
    public final String fromGraphQlEntity(LinkEntity linkEntity) {
        if (linkEntity == null) {
            return null;
        }
        return this.gson.t(linkEntity);
    }

    @TypeConverter
    public final String fromListString(List<String> list) {
        y.i(list, "list");
        String strT = this.gson.t(list);
        y.h(strT, "toJson(...)");
        return strT;
    }

    @TypeConverter
    public final String fromMessageEntity(List<? extends MessageEntity> messageEntities) {
        y.i(messageEntities, "messageEntities");
        String strT = this.gson.t(messageEntities);
        y.h(strT, "toJson(...)");
        return strT;
    }

    @TypeConverter
    public final String fromMessagePayload(MessagePayload messagePayload) {
        if (messagePayload == null) {
            return "";
        }
        String strT = this.gson.t(messagePayload);
        y.h(strT, "toJson(...)");
        return strT;
    }

    @TypeConverter
    public final String fromPairString(List<Pair<String, String>> list) {
        y.i(list, "list");
        String strT = this.gson.t(list);
        y.h(strT, "toJson(...)");
        return strT;
    }

    public final f getGson() {
        return this.gson;
    }

    public final void setGson(f fVar) {
        this.gson = fVar;
    }

    @TypeConverter
    public final Content toAttachmentContent(String json) {
        y.i(json, "json");
        try {
            Object objJ = this.gson.j(json, Content.class);
            y.f(objJ);
            return (Content) objJ;
        } catch (Exception unused) {
            return new DeletedContent();
        }
    }

    @TypeConverter
    public final ChatMarker.TYPE toChatMarkerType(String json) {
        y.i(json, "json");
        return ChatMarker.TYPE.valueOf(json);
    }

    @TypeConverter
    public final Map<String, String> toConfiguration(String json) {
        y.i(json, "json");
        Object objK = this.gson.k(json, new TypeToken<HashMap<String, String>>() { // from class: cu.todus.android.db.typeconverter.ToDusTypeConverter$toConfiguration$turnsType$1
        }.getType());
        y.h(objK, "fromJson(...)");
        return (Map) objK;
    }

    @TypeConverter
    public final LinkEntity toGraphQlEntity(String json) {
        if (json == null) {
            return null;
        }
        return (LinkEntity) this.gson.k(json, new TypeToken<LinkEntity>() { // from class: cu.todus.android.db.typeconverter.ToDusTypeConverter$toGraphQlEntity$turnsType$1
        }.getType());
    }

    @TypeConverter
    public final List<String> toListString(String json) {
        y.i(json, "json");
        Object objK = this.gson.k(json, new TypeToken<List<? extends String>>() { // from class: cu.todus.android.db.typeconverter.ToDusTypeConverter$toListString$turnsType$1
        }.getType());
        y.h(objK, "fromJson(...)");
        return (List) objK;
    }

    @TypeConverter
    public final List<MessageEntity> toMessageEntity(String json) {
        y.i(json, "json");
        Object objK = this.gson.k(json, new TypeToken<List<? extends MessageEntity>>() { // from class: cu.todus.android.db.typeconverter.ToDusTypeConverter$toMessageEntity$turnsType$1
        }.getType());
        y.h(objK, "fromJson(...)");
        return (List) objK;
    }

    @TypeConverter
    public final MessagePayload toMessagePayload(String json) {
        y.i(json, "json");
        return (MessagePayload) this.gson.j(json, MessagePayload.class);
    }

    @TypeConverter
    public final List<Pair<String, String>> toPair(String json) {
        y.i(json, "json");
        Object objK = this.gson.k(json, new TypeToken<List<? extends Pair<? extends String, ? extends String>>>() { // from class: cu.todus.android.db.typeconverter.ToDusTypeConverter$toPair$turnsType$1
        }.getType());
        y.h(objK, "fromJson(...)");
        return (List) objK;
    }
}
