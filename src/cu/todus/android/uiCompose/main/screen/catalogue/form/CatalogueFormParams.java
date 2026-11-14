package cu.todus.android.uiCompose.main.screen.catalogue.form;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.cache.Product;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/catalogue/form/CatalogueFormParams;", "", "product", "Lcu/todus/android/data/db/entity/cache/Product;", "<init>", "(Lcu/todus/android/data/db/entity/cache/Product;)V", "getProduct", "()Lcu/todus/android/data/db/entity/cache/Product;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CatalogueFormParams {
    public static final int $stable = 0;
    private final Product product;

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogueFormParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CatalogueFormParams copy$default(CatalogueFormParams catalogueFormParams, Product product, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            product = catalogueFormParams.product;
        }
        return catalogueFormParams.copy(product);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Product getProduct() {
        return this.product;
    }

    public final CatalogueFormParams copy(Product product) {
        return new CatalogueFormParams(product);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CatalogueFormParams) && kotlin.jvm.internal.y.d(this.product, ((CatalogueFormParams) other).product);
    }

    public final Product getProduct() {
        return this.product;
    }

    public int hashCode() {
        Product product = this.product;
        if (product == null) {
            return 0;
        }
        return product.hashCode();
    }

    public String toString() {
        return "CatalogueFormParams(product=" + this.product + ")";
    }

    public CatalogueFormParams(Product product) {
        this.product = product;
    }

    public /* synthetic */ CatalogueFormParams(Product product, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? null : product);
    }
}
