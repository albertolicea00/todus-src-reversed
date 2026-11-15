package cu.todus.android.data.db.entity.cache;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity for cached bot shortcut entries ({@code bot_shortcut} table).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.cache.BotShortcut
 */
@Entity(tableName = BotShortcut.TABLE_NAME)
public final class BotShortcut {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_ROOM_ID = "roomId";
    public static final String LOCATION_ATTACHMENT_SELECTOR = "location_attachment_selector";
    public static final String LOCATION_HOME_FLOATING = "location_home_floating";
    public static final String TABLE_NAME = "bot_shortcut";

    @PrimaryKey
    private final int id;
    private final String roomId;
    private final String location;
    private final String icon;
    private final String label;
    private final String description;
    private final String btnColor;
    private final String btnContent;
    private final long createAt;

    public BotShortcut(
            int id,
            String roomId,
            String location,
            String icon,
            String label,
            String description,
            String btnColor,
            String btnContent,
            long createAt
    ) {
        this.id = id;
        this.roomId = roomId;
        this.location = location;
        this.icon = icon;
        this.label = label;
        this.description = description;
        this.btnColor = btnColor;
        this.btnContent = btnContent;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getLocation() {
        return location;
    }

    public String getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getBtnColor() {
        return btnColor;
    }

    public String getBtnContent() {
        return btnContent;
    }

    public long getCreateAt() {
        return createAt;
    }
}
