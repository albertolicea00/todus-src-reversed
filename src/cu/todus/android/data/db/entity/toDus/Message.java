package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.pojo.info.MessagePayload;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import defpackage.l;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(foreignKeys = {@ForeignKey(childColumns = {"roomId"}, entity = Room.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"id"}), @Index({"roomId"}), @Index(name = "messages_createAt_index", value = {"createAt"})}, tableName = Message.TABLE_NAME)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0011\u0010\u0015J\u0006\u0010$\u001a\u00020%J\u0014\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010(\u001a\u00020\nH\u0096\u0080\u0004J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00066"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Message;", "", "id", "", "roomId", Message.COLUMN_USER_SENDER, "content", "createAt", "", "state", "", Message.COLUMN_PAYLOAD, "Lcu/todus/android/data/db/pojo/info/MessagePayload;", Message.COLUMN_MESSAGE_ENTITIES, "", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", Message.COLUMN_MESSAGE_PUBL_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILcu/todus/android/data/db/pojo/info/MessagePayload;Ljava/util/List;Ljava/lang/String;)V", "builder", "Lcu/todus/android/data/db/entity/toDus/Message$Builder;", "(Lcu/todus/android/data/db/entity/toDus/Message$Builder;)V", "getId", "()Ljava/lang/String;", "getRoomId", "getUserSender", "getContent", "getCreateAt", "()J", "getState", "()I", "getPayload", "()Lcu/todus/android/data/db/pojo/info/MessagePayload;", "getMessageEntities", "()Ljava/util/List;", "getPublId", "available", "", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "toString", "Builder", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Message {
    public static final int $stable = 0;
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATE_AT = "createAt";
    public static final String COLUMN_MESSAGE_ENTITIES = "messageEntities";
    public static final String COLUMN_MESSAGE_PUBL_ID = "publId";
    public static final String COLUMN_PAYLOAD = "payload";
    public static final String COLUMN_ROOM = "roomId";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_UID = "id";
    public static final String COLUMN_USER_SENDER = "userSender";
    public static final int STATUS_PREPARING_ATTACHMENT = -1;
    public static final int STATUS_READ_FROM_TARGET = 3;
    public static final int STATUS_RECEIPT_FROM_SERVER = 1;
    public static final int STATUS_RECEIPT_FROM_TARGET = 2;
    public static final int STATUS_RECEIVING_ATTACHMENT = -2;
    public static final int STATUS_SENTRY_SEND = 6;
    public static final int STATUS_SENTRY_UNSEND = 5;
    public static final int STATUS_TIMEOUT = 7;
    public static final int STATUS_UNABLE_TO_SEND = 4;
    public static final int STATUS_UNSENT = 0;
    public static final String TABLE_NAME = "messages";
    private final String content;
    private final long createAt;

    @PrimaryKey
    private final String id;
    private final List<MessageEntity> messageEntities;
    private final MessagePayload payload;
    private final String publId;
    private final String roomId;
    private final int state;
    private final String userSender;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0013J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0017J\u0014\u0010\u001d\u001a\u00020\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u0010$\u001a\u00020%R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\b¨\u0006&"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Message$Builder;", "", "<init>", "()V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "id", "getId", "()Ljava/lang/String;", "roomId", "getRoomId", Message.COLUMN_USER_SENDER, "getUserSender", "content", "getContent", "", "createAt", "getCreateAt", "()J", "", "state", "getState", "()I", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", Message.COLUMN_PAYLOAD, "getPayload", "()Lcu/todus/android/data/db/pojo/info/MessagePayload;", "", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", Message.COLUMN_MESSAGE_ENTITIES, "getMessageEntities", "()Ljava/util/List;", Message.COLUMN_MESSAGE_PUBL_ID, "getPublId", "messagePayload", "entities", "build", "Lcu/todus/android/data/db/entity/toDus/Message;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String content;
        private long createAt;
        private String id;
        private List<? extends MessageEntity> messageEntities;
        private MessagePayload payload;
        private String publId;
        private String roomId;
        private int state;
        private String userSender;

        public Builder() {
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            this.id = string;
            this.userSender = "";
            this.content = "";
            this.createAt = new Date().getTime();
            this.messageEntities = w.n();
            this.publId = "";
        }

        public static /* synthetic */ Builder userSender$default(Builder builder, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "";
            }
            return builder.userSender(str);
        }

        public final Message build() {
            return new Message(this, null);
        }

        public final Builder content(String value) {
            y.i(value, "value");
            this.content = value;
            return this;
        }

        public final Builder createAt(long value) {
            this.createAt = value;
            return this;
        }

        public final String getContent() {
            return this.content;
        }

        public final long getCreateAt() {
            return this.createAt;
        }

        public final String getId() {
            return this.id;
        }

        public final List<MessageEntity> getMessageEntities() {
            return this.messageEntities;
        }

        public final MessagePayload getPayload() {
            return this.payload;
        }

        public final String getPublId() {
            return this.publId;
        }

        public final String getRoomId() {
            String str = this.roomId;
            if (str != null) {
                return str;
            }
            y.w("roomId");
            return null;
        }

        public final int getState() {
            return this.state;
        }

        public final String getUserSender() {
            return this.userSender;
        }

        public final Builder id(String value) {
            y.i(value, "value");
            this.id = value;
            return this;
        }

        public final Builder messageEntities(List<? extends MessageEntity> entities) {
            y.i(entities, "entities");
            this.messageEntities = entities;
            return this;
        }

        public final Builder messagePayload(MessagePayload messagePayload) {
            this.payload = messagePayload;
            return this;
        }

        public final Builder publId(String value) {
            if (value == null) {
                value = "";
            }
            this.publId = value;
            return this;
        }

        public final Builder roomId(String value) {
            y.i(value, "value");
            this.roomId = value;
            return this;
        }

        public final Builder state(int value) {
            this.state = value;
            return this;
        }

        public final Builder userSender(String value) {
            y.i(value, "value");
            this.userSender = value;
            return this;
        }
    }

    public /* synthetic */ Message(Builder builder, p pVar) {
        this(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Message copy$default(Message message, String str, String str2, String str3, String str4, long j10, int i10, MessagePayload messagePayload, List list, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = message.id;
        }
        if ((i11 & 2) != 0) {
            str2 = message.roomId;
        }
        if ((i11 & 4) != 0) {
            str3 = message.userSender;
        }
        if ((i11 & 8) != 0) {
            str4 = message.content;
        }
        if ((i11 & 16) != 0) {
            j10 = message.createAt;
        }
        if ((i11 & 32) != 0) {
            i10 = message.state;
        }
        if ((i11 & 64) != 0) {
            messagePayload = message.payload;
        }
        if ((i11 & 128) != 0) {
            list = message.messageEntities;
        }
        if ((i11 & 256) != 0) {
            str5 = message.publId;
        }
        long j11 = j10;
        String str6 = str3;
        String str7 = str4;
        return message.copy(str, str2, str6, str7, j11, i10, messagePayload, list, str5);
    }

    public final boolean available() {
        int i10 = this.state;
        return i10 == 2 || i10 == 3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserSender() {
        return this.userSender;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getCreateAt() {
        return this.createAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MessagePayload getPayload() {
        return this.payload;
    }

    public final List<MessageEntity> component8() {
        return this.messageEntities;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPublId() {
        return this.publId;
    }

    public final Message copy(String id2, String roomId, String userSender, String content, long createAt, int state, MessagePayload payload, List<? extends MessageEntity> messageEntities, String publId) {
        y.i(id2, "id");
        y.i(roomId, "roomId");
        y.i(userSender, "userSender");
        y.i(content, "content");
        y.i(messageEntities, "messageEntities");
        return new Message(id2, roomId, userSender, content, createAt, state, payload, messageEntities, publId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!y.d(Message.class, other != null ? other.getClass() : null)) {
            return false;
        }
        y.g(other, "null cannot be cast to non-null type cu.todus.android.data.db.entity.toDus.Message");
        Message message = (Message) other;
        if (y.d(this.id, message.id) && y.d(this.roomId, message.roomId) && y.d(this.userSender, message.userSender) && y.d(this.content, message.content) && this.createAt == message.createAt && this.state == message.state && y.d(this.payload, message.payload)) {
            return y.d(this.messageEntities, message.messageEntities);
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getId() {
        return this.id;
    }

    public final List<MessageEntity> getMessageEntities() {
        return this.messageEntities;
    }

    public final MessagePayload getPayload() {
        return this.payload;
    }

    public final String getPublId() {
        return this.publId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final int getState() {
        return this.state;
    }

    public final String getUserSender() {
        return this.userSender;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.roomId.hashCode()) * 31) + this.userSender.hashCode()) * 31) + this.content.hashCode()) * 31) + l.a(this.createAt)) * 31) + this.state) * 31;
        MessagePayload messagePayload = this.payload;
        return ((iHashCode + (messagePayload != null ? messagePayload.hashCode() : 0)) * 31) + this.messageEntities.hashCode();
    }

    public String toString() {
        return "Message(id=" + this.id + ", roomId=" + this.roomId + ", userSender=" + this.userSender + ", content=" + this.content + ", createAt=" + this.createAt + ", state=" + this.state + ", payload=" + this.payload + ", messageEntities=" + this.messageEntities + ", publId=" + this.publId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Message(String id2, String roomId, String userSender, String content, long j10, int i10, MessagePayload messagePayload, List<? extends MessageEntity> messageEntities, String str) {
        y.i(id2, "id");
        y.i(roomId, "roomId");
        y.i(userSender, "userSender");
        y.i(content, "content");
        y.i(messageEntities, "messageEntities");
        this.id = id2;
        this.roomId = roomId;
        this.userSender = userSender;
        this.content = content;
        this.createAt = j10;
        this.state = i10;
        this.payload = messagePayload;
        this.messageEntities = messageEntities;
        this.publId = str;
    }

    public /* synthetic */ Message(String str, String str2, String str3, String str4, long j10, int i10, MessagePayload messagePayload, List list, String str5, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, str2, str3, str4, (i11 & 16) != 0 ? new Date().getTime() : j10, (i11 & 32) != 0 ? 0 : i10, (i11 & 64) != 0 ? null : messagePayload, (i11 & 128) != 0 ? w.n() : list, (i11 & 256) != 0 ? null : str5);
    }

    private Message(Builder builder) {
        this(builder.getId(), builder.getRoomId(), builder.getUserSender(), builder.getContent(), builder.getCreateAt(), builder.getState(), builder.getPayload(), builder.getMessageEntities(), builder.getPublId());
    }
}
