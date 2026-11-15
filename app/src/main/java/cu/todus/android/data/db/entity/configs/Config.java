package cu.todus.android.data.db.entity.configs;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity storing per-tag notification configuration ({@code heritage} table).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.configs.Config
 */
@Entity(tableName = Config.TABLE_NAME)
public final class Config {

    public static final String COLUMN_PARENT = "parent";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_VALUES = "values";
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_URGENT = 3;
    public static final String TABLE_NAME = "heritage";

    @PrimaryKey
    private final String tag;

    @Embedded
    private final Values values;

    public Config(String tag, Values values) {
        this.tag = tag;
        this.values = values;
    }

    public String getTag() {
        return tag;
    }

    public Values getValues() {
        return values;
    }
}
