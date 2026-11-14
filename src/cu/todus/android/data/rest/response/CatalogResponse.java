package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.cache.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcu/todus/android/data/rest/response/CatalogResponse;", "", "catalog", "", "Lcu/todus/android/data/db/entity/cache/Product;", "<init>", "(Ljava/util/List;)V", "getCatalog", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CatalogResponse {
    public static final int $stable = 8;
    private final List<Product> catalog;

    public CatalogResponse(List<Product> list) {
        this.catalog = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CatalogResponse copy$default(CatalogResponse catalogResponse, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = catalogResponse.catalog;
        }
        return catalogResponse.copy(list);
    }

    public final List<Product> component1() {
        return this.catalog;
    }

    public final CatalogResponse copy(List<Product> catalog) {
        return new CatalogResponse(catalog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CatalogResponse) && y.d(this.catalog, ((CatalogResponse) other).catalog);
    }

    public final List<Product> getCatalog() {
        return this.catalog;
    }

    public int hashCode() {
        List<Product> list = this.catalog;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "CatalogResponse(catalog=" + this.catalog + ")";
    }
}
