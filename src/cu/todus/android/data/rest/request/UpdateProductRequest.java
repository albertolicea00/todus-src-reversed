package cu.todus.android.data.rest.request;

import androidx.camera.camera2.adapter.r;
import androidx.collection.a;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.User;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcu/todus/android/data/rest/request/UpdateProductRequest;", "", "name", "", "description", User.COLUMN_PHOTO_URL, "price", "", "isPublic", "", "info", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DZLjava/util/Map;)V", "getName", "()Ljava/lang/String;", "getDescription", "getPictureUrl", "getPrice", "()D", "()Z", "getInfo", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdateProductRequest {
    public static final int $stable = 8;
    private final String description;
    private final Map<String, String> info;

    @c("is_public")
    private final boolean isPublic;
    private final String name;

    @c("picture_url")
    private final String pictureUrl;
    private final double price;

    public UpdateProductRequest(String name, String description, String pictureUrl, double d10, boolean z10, Map<String, String> map) {
        y.i(name, "name");
        y.i(description, "description");
        y.i(pictureUrl, "pictureUrl");
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.price = d10;
        this.isPublic = z10;
        this.info = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateProductRequest copy$default(UpdateProductRequest updateProductRequest, String str, String str2, String str3, double d10, boolean z10, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateProductRequest.name;
        }
        if ((i10 & 2) != 0) {
            str2 = updateProductRequest.description;
        }
        if ((i10 & 4) != 0) {
            str3 = updateProductRequest.pictureUrl;
        }
        if ((i10 & 8) != 0) {
            d10 = updateProductRequest.price;
        }
        if ((i10 & 16) != 0) {
            z10 = updateProductRequest.isPublic;
        }
        if ((i10 & 32) != 0) {
            map = updateProductRequest.info;
        }
        double d11 = d10;
        String str4 = str3;
        return updateProductRequest.copy(str, str2, str4, d11, z10, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    public final Map<String, String> component6() {
        return this.info;
    }

    public final UpdateProductRequest copy(String name, String description, String pictureUrl, double price, boolean isPublic, Map<String, String> info) {
        y.i(name, "name");
        y.i(description, "description");
        y.i(pictureUrl, "pictureUrl");
        return new UpdateProductRequest(name, description, pictureUrl, price, isPublic, info);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateProductRequest)) {
            return false;
        }
        UpdateProductRequest updateProductRequest = (UpdateProductRequest) other;
        return y.d(this.name, updateProductRequest.name) && y.d(this.description, updateProductRequest.description) && y.d(this.pictureUrl, updateProductRequest.pictureUrl) && Double.compare(this.price, updateProductRequest.price) == 0 && this.isPublic == updateProductRequest.isPublic && y.d(this.info, updateProductRequest.info);
    }

    public final String getDescription() {
        return this.description;
    }

    public final Map<String, String> getInfo() {
        return this.info;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final double getPrice() {
        return this.price;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.pictureUrl.hashCode()) * 31) + a.a(this.price)) * 31) + r.a(this.isPublic)) * 31;
        Map<String, String> map = this.info;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public String toString() {
        return "UpdateProductRequest(name=" + this.name + ", description=" + this.description + ", pictureUrl=" + this.pictureUrl + ", price=" + this.price + ", isPublic=" + this.isPublic + ", info=" + this.info + ")";
    }
}
