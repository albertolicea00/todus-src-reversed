package cu.todus.android.data.db.entity.cache;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity for cached welcome/banner messages ({@code welcome_message} table).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.cache.WelcomeMessage
 */
@Entity(tableName = WelcomeMessage.TABLE_NAME)
public final class WelcomeMessage {

    public static final String COLUMN_ID = "id";
    public static final String TABLE_NAME = "welcome_message";

    @PrimaryKey
    private final int id;
    private final String title;
    private final String text;
    private final String image;
    private final String url;

    public WelcomeMessage(int id, String title, String text, String image, String url) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
