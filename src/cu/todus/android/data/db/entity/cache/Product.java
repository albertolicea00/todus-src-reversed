package cu.todus.android.data.db.entity.cache;

import androidx.camera.camera2.adapter.r;
import androidx.collection.a;
import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;
import va.w;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(tableName = "product")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0010\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003Jq\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00060"}, d2 = {"Lcu/todus/android/data/db/entity/cache/Product;", "", "id", "", "createdAt", "", "description", "name", User.COLUMN_PHOTO_URL, "price", "", "isPublic", "", "info", "", "offset", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DZLjava/util/Map;I)V", "getId", "()I", "getCreatedAt", "()Ljava/lang/String;", "getDescription", "getName", "getPictureUrl", "getPrice", "()D", "()Z", "getInfo", "()Ljava/util/Map;", "getOffset", "getTags", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Product {
    public static final int $stable = 0;
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

    @c(Room.CONFIG_CREATED_AT)
    private final String createdAt;
    private final String description;

    @PrimaryKey
    private final int id;
    private final Map<String, String> info;

    @c("is_public")
    private final boolean isPublic;
    private final String name;
    private final int offset;

    @c("picture_url")
    private final String pictureUrl;
    private final double price;

    public Product(int i10, String createdAt, String description, String name, String pictureUrl, double d10, boolean z10, Map<String, String> map, int i11) {
        y.i(createdAt, "createdAt");
        y.i(description, "description");
        y.i(name, "name");
        y.i(pictureUrl, "pictureUrl");
        this.id = i10;
        this.createdAt = createdAt;
        this.description = description;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.price = d10;
        this.isPublic = z10;
        this.info = map;
        this.offset = i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Product copy$default(Product product, int i10, String str, String str2, String str3, String str4, double d10, boolean z10, Map map, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = product.id;
        }
        if ((i12 & 2) != 0) {
            str = product.createdAt;
        }
        if ((i12 & 4) != 0) {
            str2 = product.description;
        }
        if ((i12 & 8) != 0) {
            str3 = product.name;
        }
        if ((i12 & 16) != 0) {
            str4 = product.pictureUrl;
        }
        if ((i12 & 32) != 0) {
            d10 = product.price;
        }
        if ((i12 & 64) != 0) {
            z10 = product.isPublic;
        }
        if ((i12 & 128) != 0) {
            map = product.info;
        }
        if ((i12 & 256) != 0) {
            i11 = product.offset;
        }
        int i13 = i11;
        boolean z11 = z10;
        double d11 = d10;
        String str5 = str3;
        String str6 = str4;
        String str7 = str2;
        return product.copy(i10, str, str7, str5, str6, d11, z11, map, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    public final Map<String, String> component8() {
        return this.info;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    public final Product copy(int id2, String createdAt, String description, String name, String pictureUrl, double price, boolean isPublic, Map<String, String> info, int offset) {
        y.i(createdAt, "createdAt");
        y.i(description, "description");
        y.i(name, "name");
        y.i(pictureUrl, "pictureUrl");
        return new Product(id2, createdAt, description, name, pictureUrl, price, isPublic, info, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product) other;
        return this.id == product.id && y.d(this.createdAt, product.createdAt) && y.d(this.description, product.description) && y.d(this.name, product.name) && y.d(this.pictureUrl, product.pictureUrl) && Double.compare(this.price, product.price) == 0 && this.isPublic == product.isPublic && y.d(this.info, product.info) && this.offset == product.offset;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    public final Map<String, String> getInfo() {
        return this.info;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final double getPrice() {
        return this.price;
    }

    public final List<String> getTags() {
        String str;
        List<String> listS0;
        Map<String, String> map = this.info;
        if (map == null || (str = map.get("tag")) == null || (listS0 = d0.S0(str, new String[]{"%_%"}, false, 0, 6, null)) == null) {
            return w.n();
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : listS0) {
            if (d0.q0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.id * 31) + this.createdAt.hashCode()) * 31) + this.description.hashCode()) * 31) + this.name.hashCode()) * 31) + this.pictureUrl.hashCode()) * 31) + a.a(this.price)) * 31) + r.a(this.isPublic)) * 31;
        Map<String, String> map = this.info;
        return ((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this.offset;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public String toString() {
        return "Product(id=" + this.id + ", createdAt=" + this.createdAt + ", description=" + this.description + ", name=" + this.name + ", pictureUrl=" + this.pictureUrl + ", price=" + this.price + ", isPublic=" + this.isPublic + ", info=" + this.info + ", offset=" + this.offset + ")";
    }

    public /* synthetic */ Product(int i10, String str, String str2, String str3, String str4, double d10, boolean z10, Map map, int i11, int i12, p pVar) {
        this(i10, str, str2, str3, str4, (i12 & 32) != 0 ? 0.0d : d10, z10, map, (i12 & 256) != 0 ? 0 : i11);
    }
}
