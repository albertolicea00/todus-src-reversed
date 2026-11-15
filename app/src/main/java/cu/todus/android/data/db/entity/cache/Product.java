package cu.todus.android.data.db.entity.cache;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

/**
 * Room entity for cached catalog/shop products ({@code product} table).
 *
 * @obfuscated_class cu.todus.android.data.db.entity.cache.Product
 */
@Entity(tableName = Product.TABLE_NAME)
public final class Product {

    public static final String COIN_CUP = "C.U.P.";
    public static final String COIN_MLC = "M.L.C.";
    public static final String COIN_YUK = "Y.U.K.";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_INFO = "info";
    public static final String COLUMN_IS_PUBLIC = "isPublic";
    public static final String COLUMN_NAME = "name";
    public static final String EXTRA_COIN_TYPE = "coin_type";
    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_LOCATION = "location";
    public static final String EXTRA_MUNICIPALITY = "municipality";
    public static final String EXTRA_PROVINCE = "province";
    public static final String EXTRA_STATE = "state";
    public static final String EXTRA_TAG = "tag";
    public static final String EXTRA_VIEWS = "views";
    public static final String STATE_BAD = "bad";
    public static final String STATE_GOOD = "good";
    public static final String STATE_NEW = "new";
    public static final String STATE_REFURBISHED = "ref";
    public static final String TABLE_NAME = "product";

    @PrimaryKey
    private final int id;
    private final String createdAt;
    private final String description;
    private final String name;
    private final String pictureUrl;
    private final double price;
    private final boolean isPublic;
    private final Map<String, String> info;
    private final int offset;

    public Product(
            int id,
            String createdAt,
            String description,
            String name,
            String pictureUrl,
            double price,
            boolean isPublic,
            Map<String, String> info,
            int offset
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.isPublic = isPublic;
        this.info = info;
        this.offset = offset;
    }

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public int getOffset() {
        return offset;
    }
}
