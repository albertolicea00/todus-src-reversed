package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;
import java.util.Objects;

/**
 * Room entity representing a downloaded or available sticker pack.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.StickerPack
 */
@Immutable
@Entity(tableName = StickerPack.TABLE_NAME)
public final class StickerPack {

    public static final String TABLE_NAME = "stickerPack";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CREATE_AT = "createAt";

    @PrimaryKey
    private final String name;
    private final String title;
    private final String thumb;
    private final long createAt;

    public StickerPack(String name, String title, String thumb) {
        this(name, title, thumb, new Date().getTime());
    }

    public StickerPack(String name, String title, String thumb, long createAt) {
        this.name = Objects.requireNonNull(name, "name");
        this.title = Objects.requireNonNull(title, "title");
        this.thumb = Objects.requireNonNull(thumb, "thumb");
        this.createAt = createAt;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getThumb() {
        return thumb;
    }

    public long getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPack)) {
            return false;
        }
        StickerPack that = (StickerPack) other;
        return createAt == that.createAt
                && Objects.equals(name, that.name)
                && Objects.equals(title, that.title)
                && Objects.equals(thumb, that.thumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, thumb, createAt);
    }

    @Override
    public String toString() {
        return "StickerPack(name=" + name
                + ", title=" + title
                + ", thumb=" + thumb
                + ", createAt=" + createAt + ")";
    }
}
