package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Room entity representing a 1-to-1 chat, MUC-light group, channel, or card room.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Room
 */
@Immutable
@Entity(
        tableName = Room.TABLE_NAME,
        indices = {
                @Index({"id"}),
                @Index(name = "rooms_pined_lastUpdate_index", value = {Room.COLUMN_PINED, Room.COLUMN_LAST_UPDATE})
        }
)
public final class Room {

    public static final String TABLE_NAME = "rooms";

    public static final String COLUMN_UID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_VERSION = "version";
    public static final String COLUMN_LAST_UPDATE = "lastUpdate";
    public static final String COLUMN_UNREAD = "unreadMessages";
    public static final String COLUMN_LAST_MSG = "msgId";
    public static final String COLUMN_PINED = "pined";
    public static final String COLUMN_SECRET = "secret"; // pragma: allowlist secret
    public static final String COLUMN_MUTED = "isMuted";

    public static final int TYPE_1TO1 = 0;
    public static final int TYPE_MUC_LIGHT = 1;
    public static final int TYPE_CHANNEL = 2;
    public static final int TYPE_CARD = 3;

    public static final String CONFIG_CONFIG = "config";
    public static final String CONFIG_ROOM_NAME = "roomname";
    public static final String CONFIG_ROOM_SUBJECT = "subject";
    public static final String CONFIG_PICTURE = "picture";
    public static final String CONFIG_PICTURE_THUMBNAIL = "picture_thumbnail_url";
    public static final String CONFIG_NO_PICTURE = "-1";
    public static final String CONFIG_CHAT_BACKGROUND = "chat_background";
    public static final String CONFIG_CREATED_AT = "created_at";
    public static final String CONFIG_DRAFT = "draft";
    public static final String CONFIG_OFFICIAL = "official";
    public static final String CONFIG_PUBLIC = "public";
    public static final String CONFIG_RIGHTS = "rights";
    public static final String CONFIG_ROLE = "role";
    public static final String CONFIG_SHARE_LINK = "share_link";
    public static final String CONFIG_PINED_MESSAGE = "pinned_msg";
    public static final String CONFIG_PINED_MESSAGE_ID = "pinned_msg_id";
    public static final String CONFIG_SUBSCRIBED_STATE = "subscribe";
    public static final String CONFIG_UNKNOWN_ROOM = "unknown_ROOM";
    public static final String CONFIG_UNREAD_COUNT = "unread_count";
    public static final String CONFIG_AFF_COUNT = "aff_count";

    public static final String UR_ACCEPTED = "accepted";
    public static final String UR_BLOCKED = "blocked";
    public static final String UR_NEW = "new";
    public static final String UR_REJECTED = "rejected";
    public static final String UR_SHARED = "shared";

    @PrimaryKey
    private final String id;
    private final String name;
    private final int type;
    private final String version;
    private final String subject;
    private final Map<String, String> config;
    private final long lastUpdate;
    private final int unreadMessages;
    private final String msgId;
    private final boolean pined;
    private final boolean secret;
    private final boolean isMuted;

    public Room(String id, int type) {
        this(id, "", type, "", "", Collections.emptyMap(), 0L, 0, "", false, false, false);
    }

    public Room(
            String id,
            String name,
            int type,
            String version,
            String subject,
            Map<String, String> config,
            long lastUpdate,
            int unreadMessages,
            String msgId,
            boolean pined,
            boolean secret,
            boolean isMuted
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.type = type;
        this.version = Objects.requireNonNull(version, "version");
        this.subject = Objects.requireNonNull(subject, "subject");
        this.config = new LinkedHashMap<>(Objects.requireNonNull(config, "config"));
        this.lastUpdate = lastUpdate;
        this.unreadMessages = unreadMessages;
        this.msgId = Objects.requireNonNull(msgId, "msgId");
        this.pined = pined;
        this.secret = secret;
        this.isMuted = isMuted;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public String getSubject() {
        return subject;
    }

    public Map<String, String> getConfig() {
        return Collections.unmodifiableMap(config);
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public int getUnreadMessages() {
        return unreadMessages;
    }

    public String getMsgId() {
        return msgId;
    }

    public boolean getPined() {
        return pined;
    }

    public boolean getSecret() {
        return secret;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public String getPicture() {
        String value = config.get(CONFIG_PICTURE);
        return value != null ? value : "";
    }

    public String getThumbnail() {
        String value = config.get(CONFIG_PICTURE_THUMBNAIL);
        if (value == null || value.trim().isEmpty()) {
            return getPicture();
        }
        return value;
    }

    public String getBackground() {
        String value = config.get(CONFIG_CHAT_BACKGROUND);
        return value != null ? value : "";
    }

    public String getPinnedMessage() {
        String value = config.get(CONFIG_PINED_MESSAGE);
        return value != null ? value : "";
    }

    public String getPinnedMessageId() {
        String value = config.get(CONFIG_PINED_MESSAGE_ID);
        return value != null ? value : "";
    }

    public String getOnlySubject() {
        String value = config.get(CONFIG_ROOM_SUBJECT);
        return value != null ? value : subject;
    }

    public String getOnlyName() {
        String value = config.get(CONFIG_ROOM_NAME);
        return value != null ? value : name;
    }

    public List<String> getRights() {
        String value = config.get(CONFIG_RIGHTS);
        if (value == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(value.split(",", -1));
    }

    public String getUnknownState() {
        String value = config.get(CONFIG_UNKNOWN_ROOM);
        return value != null ? value : "";
    }

    public String getDraft() {
        String value = config.get(CONFIG_DRAFT);
        return value != null ? value : "";
    }

    public String getSubscribedState() {
        String value = config.get(CONFIG_SUBSCRIBED_STATE);
        return value != null ? value : "";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Room)) {
            return false;
        }
        Room that = (Room) other;
        return type == that.type
                && lastUpdate == that.lastUpdate
                && unreadMessages == that.unreadMessages
                && pined == that.pined
                && secret == that.secret
                && isMuted == that.isMuted
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(version, that.version)
                && Objects.equals(subject, that.subject)
                && Objects.equals(config, that.config)
                && Objects.equals(msgId, that.msgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                name,
                type,
                version,
                subject,
                config,
                lastUpdate,
                unreadMessages,
                msgId,
                pined,
                secret,
                isMuted
        );
    }

    @Override
    public String toString() {
        return "Room(id=" + id
                + ", name=" + name
                + ", type=" + type
                + ", version=" + version
                + ", subject=" + subject
                + ", config=" + config
                + ", lastUpdate=" + lastUpdate
                + ", unreadMessages=" + unreadMessages
                + ", msgId=" + msgId
                + ", pined=" + pined
                + ", secret=" + secret
                + ", isMuted=" + isMuted + ")";
    }
}
