package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.volatileState.AppVolatileState;
import java.util.Objects;

/**
 * Room entity representing an individual sticker within a {@link StickerPack}.
 *
 * @obfuscated_class cu.todus.android.data.db.entity.toDus.Sticker
 */
@Immutable
@Entity(
        tableName = Sticker.TABLE_NAME,
        foreignKeys = {
                @ForeignKey(
                        entity = StickerPack.class,
                        parentColumns = {"name"},
                        childColumns = {Sticker.COLUMN_PACK_NAME},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public final class Sticker {

    public static final String TABLE_NAME = "sticker";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PACK_NAME = "packName";
    public static final String COLUMN_FAVORITE = "favorite";
    public static final String COLUMN_LAST_USE = "lastUse";

    @PrimaryKey
    private final String id;
    private final String packName;
    private final String name;
    private final String folder;
    private final boolean favorite;
    private final long lastUse;

    public Sticker(String id, String packName, String name, String folder) {
        this(id, packName, name, folder, false, 0L);
    }

    public Sticker(
            String id,
            String packName,
            String name,
            String folder,
            boolean favorite,
            long lastUse
    ) {
        this.id = Objects.requireNonNull(id, "id");
        this.packName = Objects.requireNonNull(packName, "packName");
        this.name = Objects.requireNonNull(name, "name");
        this.folder = Objects.requireNonNull(folder, "folder");
        this.favorite = favorite;
        this.lastUse = lastUse;
    }

    public String getId() {
        return id;
    }

    public String getPackName() {
        return packName;
    }

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public long getLastUse() {
        return lastUse;
    }

    public String getUrl() {
        Service.ApplicationEnvironment environment = Service.ApplicationEnvironment.PROD_2;
        AppVolatileState state = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (state != null) {
            RootEnvironment rootEnv = state.getRootEnvironment();
            if (rootEnv != null && rootEnv.getApplicationEnvironment() != null) {
                environment = rootEnv.getApplicationEnvironment();
            }
        }
        return Service.INSTANCE.provideStickersUrl(environment) + id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sticker)) {
            return false;
        }
        Sticker that = (Sticker) other;
        return favorite == that.favorite
                && lastUse == that.lastUse
                && Objects.equals(id, that.id)
                && Objects.equals(packName, that.packName)
                && Objects.equals(name, that.name)
                && Objects.equals(folder, that.folder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, packName, name, folder, favorite, lastUse);
    }

    @Override
    public String toString() {
        return "Sticker(id=" + id
                + ", packName=" + packName
                + ", name=" + name
                + ", folder=" + folder
                + ", favorite=" + favorite
                + ", lastUse=" + lastUse + ")";
    }
}
