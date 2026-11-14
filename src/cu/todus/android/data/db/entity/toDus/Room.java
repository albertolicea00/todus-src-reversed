package cu.todus.android.data.db.entity.toDus;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import defpackage.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(indices = {@Index({"id"}), @Index(name = "rooms_pined_lastUpdate_index", value = {Room.COLUMN_PINED, Room.COLUMN_LAST_UPDATE})}, tableName = Room.TABLE_NAME)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\u0016\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0001BB\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0003J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-J\u0006\u0010.\u001a\u00020\u0003J\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u00020\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\t\u0010;\u001a\u00020\u0010HÆ\u0003J\t\u0010<\u001a\u00020\u0010HÆ\u0003J\u008d\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010HÆ\u0001J\u0014\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010@\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010A\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010#¨\u0006C"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Room;", "", "id", "", "name", "type", "", "version", "subject", Room.CONFIG_CONFIG, "", Room.COLUMN_LAST_UPDATE, "", Room.COLUMN_UNREAD, Room.COLUMN_LAST_MSG, Room.COLUMN_PINED, "", Room.COLUMN_SECRET, Room.COLUMN_MUTED, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;JILjava/lang/String;ZZZ)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()I", "getVersion", "getSubject", "getConfig", "()Ljava/util/Map;", "getLastUpdate", "()J", "getUnreadMessages", "getMsgId", "getPined", "()Z", "getSecret", "getPicture", "getThumbnail", "getBackground", "getPinnedMessage", "getPinnedMessageId", "getOnlySubject", "getOnlyName", "getRights", "", "getUnknownState", "getDraft", "getSubscribedState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Room {
    public static final int $stable = 0;
    public static final String COLUMN_LAST_MSG = "msgId";
    public static final String COLUMN_LAST_UPDATE = "lastUpdate";
    public static final String COLUMN_MUTED = "isMuted";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PINED = "pined";
    public static final String COLUMN_SECRET = "secret"; // pragma: allowlist secret
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_UID = "id";
    public static final String COLUMN_UNREAD = "unreadMessages";
    public static final String COLUMN_VERSION = "version";
    public static final String CONFIG_AFF_COUNT = "aff_count";
    public static final String CONFIG_CHAT_BACKGROUND = "chat_background";
    public static final String CONFIG_CONFIG = "config";
    public static final String CONFIG_CREATED_AT = "created_at";
    public static final String CONFIG_DRAFT = "draft";
    public static final String CONFIG_NO_PICTURE = "-1";
    public static final String CONFIG_OFFICIAL = "official";
    public static final String CONFIG_PICTURE = "picture";
    public static final String CONFIG_PICTURE_THUMBNAIL = "picture_thumbnail_url";
    public static final String CONFIG_PINED_MESSAGE = "pinned_msg";
    public static final String CONFIG_PINED_MESSAGE_ID = "pinned_msg_id";
    public static final String CONFIG_PUBLIC = "public";
    public static final String CONFIG_RIGHTS = "rights";
    public static final String CONFIG_ROLE = "role";
    public static final String CONFIG_ROOM_NAME = "roomname";
    public static final String CONFIG_ROOM_SUBJECT = "subject";
    public static final String CONFIG_SHARE_LINK = "share_link";
    public static final String CONFIG_SUBSCRIBED_STATE = "subscribe";
    public static final String CONFIG_UNKNOWN_ROOM = "unknown_ROOM";
    public static final String CONFIG_UNREAD_COUNT = "unread_count";
    public static final String TABLE_NAME = "rooms";
    public static final int TYPE_1TO1 = 0;
    public static final int TYPE_CARD = 3;
    public static final int TYPE_CHANNEL = 2;
    public static final int TYPE_MUC_LIGHT = 1;
    public static final String UR_ACCEPTED = "accepted";
    public static final String UR_BLOCKED = "blocked";
    public static final String UR_NEW = "new";
    public static final String UR_REJECTED = "rejected";
    public static final String UR_SHARED = "shared";
    private final Map<String, String> config;

    @PrimaryKey
    private final String id;
    private final boolean isMuted;
    private final long lastUpdate;
    private final String msgId;
    private final String name;
    private final boolean pined;
    private final boolean secret;
    private final String subject;
    private final int type;
    private final int unreadMessages;
    private final String version;

    public Room(String id2, String name, int i10, String version, String subject, Map<String, String> config, long j10, int i11, String msgId, boolean z10, boolean z11, boolean z12) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(version, "version");
        y.i(subject, "subject");
        y.i(config, "config");
        y.i(msgId, "msgId");
        this.id = id2;
        this.name = name;
        this.type = i10;
        this.version = version;
        this.subject = subject;
        this.config = config;
        this.lastUpdate = j10;
        this.unreadMessages = i11;
        this.msgId = msgId;
        this.pined = z10;
        this.secret = z11;
        this.isMuted = z12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Room copy$default(Room room, String str, String str2, int i10, String str3, String str4, Map map, long j10, int i11, String str5, boolean z10, boolean z11, boolean z12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = room.id;
        }
        return room.copy(str, (i12 & 2) != 0 ? room.name : str2, (i12 & 4) != 0 ? room.type : i10, (i12 & 8) != 0 ? room.version : str3, (i12 & 16) != 0 ? room.subject : str4, (i12 & 32) != 0 ? room.config : map, (i12 & 64) != 0 ? room.lastUpdate : j10, (i12 & 128) != 0 ? room.unreadMessages : i11, (i12 & 256) != 0 ? room.msgId : str5, (i12 & 512) != 0 ? room.pined : z10, (i12 & 1024) != 0 ? room.secret : z11, (i12 & 2048) != 0 ? room.isMuted : z12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getPined() {
        return this.pined;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSecret() {
        return this.secret;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final Map<String, String> component6() {
        return this.config;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getLastUpdate() {
        return this.lastUpdate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getUnreadMessages() {
        return this.unreadMessages;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    public final Room copy(String id2, String name, int type, String version, String subject, Map<String, String> config, long lastUpdate, int unreadMessages, String msgId, boolean pined, boolean secret, boolean isMuted) {
        y.i(id2, "id");
        y.i(name, "name");
        y.i(version, "version");
        y.i(subject, "subject");
        y.i(config, "config");
        y.i(msgId, "msgId");
        return new Room(id2, name, type, version, subject, config, lastUpdate, unreadMessages, msgId, pined, secret, isMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Room)) {
            return false;
        }
        Room room = (Room) other;
        return y.d(this.id, room.id) && y.d(this.name, room.name) && this.type == room.type && y.d(this.version, room.version) && y.d(this.subject, room.subject) && y.d(this.config, room.config) && this.lastUpdate == room.lastUpdate && this.unreadMessages == room.unreadMessages && y.d(this.msgId, room.msgId) && this.pined == room.pined && this.secret == room.secret && this.isMuted == room.isMuted;
    }

    public final String getBackground() {
        String str = this.config.get(CONFIG_CHAT_BACKGROUND);
        return str == null ? "" : str;
    }

    public final Map<String, String> getConfig() {
        return this.config;
    }

    public final String getDraft() {
        String str = this.config.get(CONFIG_DRAFT);
        return str == null ? "" : str;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastUpdate() {
        return this.lastUpdate;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOnlyName() {
        String str = this.config.get(CONFIG_ROOM_NAME);
        return str == null ? this.name : str;
    }

    public final String getOnlySubject() {
        String str = this.config.get("subject");
        return str == null ? this.subject : str;
    }

    public final String getPicture() {
        String str = this.config.get(CONFIG_PICTURE);
        return str == null ? "" : str;
    }

    public final boolean getPined() {
        return this.pined;
    }

    public final String getPinnedMessage() {
        String str = this.config.get(CONFIG_PINED_MESSAGE);
        return str == null ? "" : str;
    }

    public final String getPinnedMessageId() {
        String str = this.config.get(CONFIG_PINED_MESSAGE_ID);
        return str == null ? "" : str;
    }

    public final List<String> getRights() {
        List<String> listS0;
        String str = this.config.get("rights");
        return (str == null || (listS0 = d0.S0(str, new String[]{","}, false, 0, 6, null)) == null) ? new ArrayList() : listS0;
    }

    public final boolean getSecret() {
        return this.secret;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSubscribedState() {
        String str = this.config.get(CONFIG_SUBSCRIBED_STATE);
        return str == null ? "" : str;
    }

    public final String getThumbnail() {
        String str = this.config.get(CONFIG_PICTURE_THUMBNAIL);
        if (str == null) {
            str = "";
        }
        return d0.q0(str) ? getPicture() : str;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnknownState() {
        String str = this.config.get(CONFIG_UNKNOWN_ROOM);
        return str == null ? "" : str;
    }

    public final int getUnreadMessages() {
        return this.unreadMessages;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type) * 31) + this.version.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.config.hashCode()) * 31) + l.a(this.lastUpdate)) * 31) + this.unreadMessages) * 31) + this.msgId.hashCode()) * 31) + r.a(this.pined)) * 31) + r.a(this.secret)) * 31) + r.a(this.isMuted);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        return "Room(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", version=" + this.version + ", subject=" + this.subject + ", config=" + this.config + ", lastUpdate=" + this.lastUpdate + ", unreadMessages=" + this.unreadMessages + ", msgId=" + this.msgId + ", pined=" + this.pined + ", secret=" + this.secret + ", isMuted=" + this.isMuted + ")";
    }

    public /* synthetic */ Room(String str, String str2, int i10, String str3, String str4, Map map, long j10, int i11, String str5, boolean z10, boolean z11, boolean z12, int i12, p pVar) {
        this(str, (i12 & 2) != 0 ? "" : str2, i10, (i12 & 8) != 0 ? "" : str3, (i12 & 16) != 0 ? "" : str4, (i12 & 32) != 0 ? w0.i() : map, (i12 & 64) != 0 ? 0L : j10, (i12 & 128) != 0 ? 0 : i11, (i12 & 256) != 0 ? "" : str5, (i12 & 512) != 0 ? false : z10, (i12 & 1024) != 0 ? false : z11, (i12 & 2048) != 0 ? false : z12);
    }
}
