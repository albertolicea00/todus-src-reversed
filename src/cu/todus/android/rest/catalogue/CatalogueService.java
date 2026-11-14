package cu.todus.android.rest.catalogue;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.rest.request.AddProductRequest;
import cu.todus.android.data.rest.request.UpdateProductRequest;
import cu.todus.android.data.rest.response.AddProductResponse;
import cu.todus.android.data.rest.response.CatalogFilteredResponse;
import cu.todus.android.data.rest.response.CatalogResponse;
import cu.todus.android.data.rest.response.TagsResponse;
import cu.todus.android.data.rest.response.UrlResponse;
import cu.todus.android.data.rest.response.VersionResponse;
import kotlin.Metadata;
import mi.a0;
import oi.a;
import oi.b;
import oi.f;
import oi.n;
import oi.p;
import oi.s;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\bH§@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u0015H§@¢\u0006\u0004\b\u0018\u0010\u0019J*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\u001aH§@¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0004\b \u0010\u001eJ \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00022\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0004\b\"\u0010\u001eJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u0002H§@¢\u0006\u0004\b#\u0010\u0005J \u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@¢\u0006\u0004\b%\u0010&J>\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00022\b\b\u0001\u0010'\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@¢\u0006\u0004\b)\u0010*¨\u0006+À\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/catalogue/CatalogueService;", "", "Lmi/a0;", "Lcu/todus/android/data/rest/response/VersionResponse;", "version", "(Lab/e;)Ljava/lang/Object;", "", "id", "", "offset", "limit", "Lcu/todus/android/data/rest/response/CatalogResponse;", "shop", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "myShop", "(IILab/e;)Ljava/lang/Object;", User.COLUMN_TODUS_ID, "productId", "Lcu/todus/android/data/db/entity/cache/Product;", "getProduct", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/request/AddProductRequest;", "body", "Lcu/todus/android/data/rest/response/AddProductResponse;", "addProduct", "(Lcu/todus/android/data/rest/request/AddProductRequest;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/request/UpdateProductRequest;", "updateProduct", "(ILcu/todus/android/data/rest/request/UpdateProductRequest;Lab/e;)Ljava/lang/Object;", "deleteProduct", "(ILab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/response/UrlResponse;", "shareProduct", "Lorg/json/JSONObject;", "requestProduct", "shareCatalog", "Lcu/todus/android/data/rest/response/TagsResponse;", "searchTags", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "tag", "Lcu/todus/android/data/rest/response/CatalogFilteredResponse;", "searchProductsByTag", "(Ljava/lang/String;Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CatalogueService {
    @p("product")
    Object addProduct(@a AddProductRequest addProductRequest, e<? super a0<AddProductResponse>> eVar);

    @b("product/{id}")
    Object deleteProduct(@s("id") int i10, e<? super a0<VersionResponse>> eVar);

    @f(Service.Endpoint.GET_PRODUCT)
    Object getProduct(@s("todus_id") String str, @s("id") int i10, e<? super a0<Product>> eVar);

    @f(Service.Endpoint.MY_SHOP)
    Object myShop(@s("offset") int i10, @s("limit") int i11, e<? super a0<CatalogResponse>> eVar);

    @f(Service.Endpoint.REQUEST_PRODUCT)
    Object requestProduct(@s("id") int i10, e<? super a0<JSONObject>> eVar);

    @f(Service.Endpoint.SEARCH_PRODUCT_BY_TAG)
    Object searchProductsByTag(@s("tag") String str, @s("todus_id") String str2, @s("offset") int i10, @s("limit") int i11, e<? super a0<CatalogFilteredResponse>> eVar);

    @f(Service.Endpoint.SEARCH_TAGS)
    Object searchTags(@s("todus_id") String str, e<? super a0<TagsResponse>> eVar);

    @f("share/product/{id}")
    Object shareCatalog(e<? super a0<JSONObject>> eVar);

    @f("share/product/{id}")
    Object shareProduct(@s("id") int i10, e<? super a0<UrlResponse>> eVar);

    @f(Service.Endpoint.SHOP)
    Object shop(@s("todus_id") String str, @s("offset") int i10, @s("limit") int i11, e<? super a0<CatalogResponse>> eVar);

    @n("product/{id}")
    Object updateProduct(@s("id") int i10, @a UpdateProductRequest updateProductRequest, e<? super a0<VersionResponse>> eVar);

    @f("version")
    Object version(e<? super a0<VersionResponse>> eVar);
}
