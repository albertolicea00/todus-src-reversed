package cu.todus.android.uiCompose.main.screen.catalogue.preview;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/catalogue/preview/ProductPreviewParams;", "", User.COLUMN_TODUS_ID, "", "productId", "", "<init>", "(Ljava/lang/String;I)V", "getToDusId", "()Ljava/lang/String;", "getProductId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ProductPreviewParams {
    public static final int $stable = 0;
    private final int productId;
    private final String toDusId;

    public ProductPreviewParams(String toDusId, int i10) {
        kotlin.jvm.internal.y.i(toDusId, "toDusId");
        this.toDusId = toDusId;
        this.productId = i10;
    }

    public static /* synthetic */ ProductPreviewParams copy$default(ProductPreviewParams productPreviewParams, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productPreviewParams.toDusId;
        }
        if ((i11 & 2) != 0) {
            i10 = productPreviewParams.productId;
        }
        return productPreviewParams.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProductId() {
        return this.productId;
    }

    public final ProductPreviewParams copy(String toDusId, int productId) {
        kotlin.jvm.internal.y.i(toDusId, "toDusId");
        return new ProductPreviewParams(toDusId, productId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductPreviewParams)) {
            return false;
        }
        ProductPreviewParams productPreviewParams = (ProductPreviewParams) other;
        return kotlin.jvm.internal.y.d(this.toDusId, productPreviewParams.toDusId) && this.productId == productPreviewParams.productId;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public int hashCode() {
        return (this.toDusId.hashCode() * 31) + this.productId;
    }

    public String toString() {
        return "ProductPreviewParams(toDusId=" + this.toDusId + ", productId=" + this.productId + ")";
    }
}
