package cu.todus.android.rest.catalogue;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.WebmConstants;
import bb.b;
import cb.f;
import cb.m;
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
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import mi.a0;
import org.json.JSONObject;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020 H\u0086@¢\u0006\u0004\b!\u0010\"J \u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b#\u0010$J \u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b&\u0010$J\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\bH\u0086@¢\u0006\u0004\b(\u0010\u000bJ \u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b)\u0010$J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\b2\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b+\u0010,J6\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\b2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102¨\u00063"}, d2 = {"Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "", "Lcu/todus/android/rest/catalogue/CatalogueService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/catalogue/CatalogueService;Lcu/todus/android/rest/BaseDataSource;)V", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/rest/response/VersionResponse;", "version", "(Lab/e;)Ljava/lang/Object;", "", User.COLUMN_TODUS_ID, "", "offset", "limit", "Lcu/todus/android/data/rest/response/CatalogResponse;", "shop", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "myShop", "(IILab/e;)Ljava/lang/Object;", "productId", "Lcu/todus/android/data/db/entity/cache/Product;", "getProduct", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/request/AddProductRequest;", "body", "Lcu/todus/android/data/rest/response/AddProductResponse;", "addProduct", "(Lcu/todus/android/data/rest/request/AddProductRequest;Lab/e;)Ljava/lang/Object;", "id", "Lcu/todus/android/data/rest/request/UpdateProductRequest;", "updateProduct", "(ILcu/todus/android/data/rest/request/UpdateProductRequest;Lab/e;)Ljava/lang/Object;", "deleteProduct", "(ILab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/response/UrlResponse;", "shareProduct", "Lorg/json/JSONObject;", "shareCatalog", "requestProduct", "Lcu/todus/android/data/rest/response/TagsResponse;", "searchTags", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "tag", "Lcu/todus/android/data/rest/response/CatalogFilteredResponse;", "searchProductsByTag", "(Ljava/lang/String;Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/catalogue/CatalogueService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CatalogueDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final CatalogueService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$addProduct$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$addProduct$2", f = "CatalogueDataSource.kt", l = {38}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ AddProductRequest $body;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AddProductRequest addProductRequest, e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$body = addProductRequest;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new AnonymousClass2(this.$body, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            AddProductRequest addProductRequest = this.$body;
            this.label = 1;
            Object objAddProduct = catalogueService.addProduct(addProductRequest, this);
            return objAddProduct == objG ? objG : objAddProduct;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$deleteProduct$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$deleteProduct$2", f = "CatalogueDataSource.kt", l = {46}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11562 extends m implements Function1 {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11562(int i10, e<? super C11562> eVar) {
            super(1, eVar);
            this.$id = i10;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11562(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11562) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            int i11 = this.$id;
            this.label = 1;
            Object objDeleteProduct = catalogueService.deleteProduct(i11, this);
            return objDeleteProduct == objG ? objG : objDeleteProduct;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$getProduct$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$getProduct$2", f = "CatalogueDataSource.kt", l = {34}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11572 extends m implements Function1 {
        final /* synthetic */ int $productId;
        final /* synthetic */ String $toDusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11572(String str, int i10, e<? super C11572> eVar) {
            super(1, eVar);
            this.$toDusId = str;
            this.$productId = i10;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11572(this.$toDusId, this.$productId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11572) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            String str = this.$toDusId;
            int i11 = this.$productId;
            this.label = 1;
            Object product = catalogueService.getProduct(str, i11, this);
            return product == objG ? objG : product;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$myShop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$myShop$2", f = "CatalogueDataSource.kt", l = {30}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11582 extends m implements Function1 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11582(int i10, int i11, e<? super C11582> eVar) {
            super(1, eVar);
            this.$offset = i10;
            this.$limit = i11;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11582(this.$offset, this.$limit, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11582) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            int i11 = this.$offset;
            int i12 = this.$limit;
            this.label = 1;
            Object objMyShop = catalogueService.myShop(i11, i12, this);
            return objMyShop == objG ? objG : objMyShop;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$requestProduct$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$requestProduct$2", f = "CatalogueDataSource.kt", l = {58}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11592 extends m implements Function1 {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11592(int i10, e<? super C11592> eVar) {
            super(1, eVar);
            this.$id = i10;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11592(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11592) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            int i11 = this.$id;
            this.label = 1;
            Object objRequestProduct = catalogueService.requestProduct(i11, this);
            return objRequestProduct == objG ? objG : objRequestProduct;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$searchProductsByTag$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$searchProductsByTag$2", f = "CatalogueDataSource.kt", l = {WebmConstants.MAX_META_SEEK_SIZE}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11602 extends m implements Function1 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        final /* synthetic */ String $tag;
        final /* synthetic */ String $toDusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11602(String str, String str2, int i10, int i11, e<? super C11602> eVar) {
            super(1, eVar);
            this.$tag = str;
            this.$toDusId = str2;
            this.$offset = i10;
            this.$limit = i11;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11602(this.$tag, this.$toDusId, this.$offset, this.$limit, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11602) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            String str = this.$tag;
            String str2 = this.$toDusId;
            int i11 = this.$offset;
            int i12 = this.$limit;
            this.label = 1;
            Object objSearchProductsByTag = catalogueService.searchProductsByTag(str, str2, i11, i12, this);
            return objSearchProductsByTag == objG ? objG : objSearchProductsByTag;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$searchTags$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$searchTags$2", f = "CatalogueDataSource.kt", l = {RectListKt.BitOffsetForGesturable}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11612 extends m implements Function1 {
        final /* synthetic */ String $toDusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11612(String str, e<? super C11612> eVar) {
            super(1, eVar);
            this.$toDusId = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11612(this.$toDusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11612) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            String str = this.$toDusId;
            this.label = 1;
            Object objSearchTags = catalogueService.searchTags(str, this);
            return objSearchTags == objG ? objG : objSearchTags;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$shareCatalog$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$shareCatalog$2", f = "CatalogueDataSource.kt", l = {54}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11622 extends m implements Function1 {
        int label;

        public C11622(e<? super C11622> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11622(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11622) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            this.label = 1;
            Object objShareCatalog = catalogueService.shareCatalog(this);
            return objShareCatalog == objG ? objG : objShareCatalog;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$shareProduct$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$shareProduct$2", f = "CatalogueDataSource.kt", l = {50}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11632 extends m implements Function1 {
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11632(int i10, e<? super C11632> eVar) {
            super(1, eVar);
            this.$id = i10;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11632(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11632) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            int i11 = this.$id;
            this.label = 1;
            Object objShareProduct = catalogueService.shareProduct(i11, this);
            return objShareProduct == objG ? objG : objShareProduct;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$shop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$shop$2", f = "CatalogueDataSource.kt", l = {26}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11642 extends m implements Function1 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        final /* synthetic */ String $toDusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11642(String str, int i10, int i11, e<? super C11642> eVar) {
            super(1, eVar);
            this.$toDusId = str;
            this.$offset = i10;
            this.$limit = i11;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11642(this.$toDusId, this.$offset, this.$limit, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11642) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            String str = this.$toDusId;
            int i11 = this.$offset;
            int i12 = this.$limit;
            this.label = 1;
            Object objShop = catalogueService.shop(str, i11, i12, this);
            return objShop == objG ? objG : objShop;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$updateProduct$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$updateProduct$2", f = "CatalogueDataSource.kt", l = {42}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11652 extends m implements Function1 {
        final /* synthetic */ UpdateProductRequest $body;
        final /* synthetic */ int $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11652(int i10, UpdateProductRequest updateProductRequest, e<? super C11652> eVar) {
            super(1, eVar);
            this.$id = i10;
            this.$body = updateProductRequest;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11652(this.$id, this.$body, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11652) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            int i11 = this.$id;
            UpdateProductRequest updateProductRequest = this.$body;
            this.label = 1;
            Object objUpdateProduct = catalogueService.updateProduct(i11, updateProductRequest, this);
            return objUpdateProduct == objG ? objG : objUpdateProduct;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.catalogue.CatalogueDataSource$version$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.catalogue.CatalogueDataSource$version$2", f = "CatalogueDataSource.kt", l = {22}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11662 extends m implements Function1 {
        int label;

        public C11662(e<? super C11662> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return CatalogueDataSource.this.new C11662(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11662) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return obj;
            }
            v.b(obj);
            CatalogueService catalogueService = CatalogueDataSource.this.service;
            this.label = 1;
            Object objVersion = catalogueService.version(this);
            return objVersion == objG ? objG : objVersion;
        }
    }

    public CatalogueDataSource(CatalogueService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public final Object addProduct(AddProductRequest addProductRequest, e<? super DataWrapper<AddProductResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(addProductRequest, null), eVar);
    }

    public final Object deleteProduct(int i10, e<? super DataWrapper<VersionResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11562(i10, null), eVar);
    }

    public final Object getProduct(String str, int i10, e<? super DataWrapper<Product>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11572(str, i10, null), eVar);
    }

    public final Object myShop(int i10, int i11, e<? super DataWrapper<CatalogResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11582(i10, i11, null), eVar);
    }

    public final Object requestProduct(int i10, e<? super DataWrapper<JSONObject>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11592(i10, null), eVar);
    }

    public final Object searchProductsByTag(String str, String str2, int i10, int i11, e<? super DataWrapper<CatalogFilteredResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11602(str, str2, i10, i11, null), eVar);
    }

    public final Object searchTags(String str, e<? super DataWrapper<TagsResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11612(str, null), eVar);
    }

    public final Object shareCatalog(e<? super DataWrapper<JSONObject>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11622(null), eVar);
    }

    public final Object shareProduct(int i10, e<? super DataWrapper<UrlResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11632(i10, null), eVar);
    }

    public final Object shop(String str, int i10, int i11, e<? super DataWrapper<CatalogResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11642(str, i10, i11, null), eVar);
    }

    public final Object updateProduct(int i10, UpdateProductRequest updateProductRequest, e<? super DataWrapper<VersionResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11652(i10, updateProductRequest, null), eVar);
    }

    public final Object version(e<? super DataWrapper<VersionResponse>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11662(null), eVar);
    }
}
