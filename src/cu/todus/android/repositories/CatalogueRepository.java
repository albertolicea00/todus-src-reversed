package cu.todus.android.repositories;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.video.AudioStats;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.rest.request.AddProductRequest;
import cu.todus.android.data.rest.request.UpdateProductRequest;
import cu.todus.android.data.rest.response.AddProductResponse;
import cu.todus.android.data.rest.response.CatalogFilteredResponse;
import cu.todus.android.data.rest.response.CatalogResponse;
import cu.todus.android.data.rest.response.TagsResponse;
import cu.todus.android.data.rest.response.VersionResponse;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.db.dao.cache.ProductDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.catalogue.CatalogueDataSource;
import cu.z17.singledi.SingletonInitializer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ0\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u0017\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00182\u0006\u0010\u0017\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001d\u0010\u001bJ \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00182\u0006\u0010\u001e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!H\u0086@¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b'\u0010#J\u0018\u0010)\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b)\u0010 J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b*\u0010\u0016J@\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcu/todus/android/repositories/CatalogueRepository;", "", "<init>", "()V", "", "offset", "limit", "", "Lcu/todus/android/data/db/entity/cache/Product;", "getMyProducts", "(IILab/e;)Ljava/lang/Object;", "", User.COLUMN_TODUS_ID, "getOtherProducts", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "tag", "filter", "Landroidx/paging/PagingSource;", "myProductPagingFiltered", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "Lcu/todus/android/data/wrapper/FlowsState;", "checkForProduct", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "product", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/rest/response/AddProductResponse;", "addProduct", "(Lcu/todus/android/data/db/entity/cache/Product;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/rest/response/VersionResponse;", "updateProduct", "productId", "deleteProduct", "(ILab/e;)Ljava/lang/Object;", "Lua/k0;", "loadPersonalCatalogue", "(Lab/e;)Ljava/lang/Object;", "getProductOnlineInfo", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "getProductUrlToShare", "getPublicProductCant", "", "requestProduct", "searchTags", "getOtherProductsFiltered", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "catalogueDataSource", "Lcu/todus/android/rest/catalogue/CatalogueDataSource;", "Lcu/todus/android/db/dao/cache/ProductDao;", "productDao", "Lcu/todus/android/db/dao/cache/ProductDao;", "catalogueInLoading", "Z", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CatalogueRepository {
    private boolean catalogueInLoading;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final PreferencesModule preferences = PreferencesModule.INSTANCE.getInstance();
    private final CatalogueDataSource catalogueDataSource = RetrofitModule.INSTANCE.getInstance().getCatalogueDataSource();
    private final ProductDao productDao = DatabaseModule.INSTANCE.getInstance().getProductDao();

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/CatalogueRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/CatalogueRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<CatalogueRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$addProduct$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {63, 75, 76}, m = "addProduct", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.addProduct(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$checkForProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {47}, m = "checkForProduct", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10201 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10201(ab.e<? super C10201> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.checkForProduct(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$deleteProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER, 107, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "deleteProduct", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10211 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10211(ab.e<? super C10211> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.deleteProduct(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$getMyProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {29}, m = "getMyProducts", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10221 extends cb.d {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        public C10221(ab.e<? super C10221> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.getMyProducts(0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$getOtherProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {37}, m = "getOtherProducts", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10231 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10231(ab.e<? super C10231> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.getOtherProducts(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$getOtherProductsFiltered$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {180}, m = "getOtherProductsFiltered", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10241 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10241(ab.e<? super C10241> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.getOtherProductsFiltered(null, null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$getProductOnlineInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {150}, m = "getProductOnlineInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10251 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10251(ab.e<? super C10251> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.getProductOnlineInfo(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$getProductUrlToShare$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {WebmConstants.MkvEbmlElement.FLAG_LACING, WebmConstants.MkvEbmlElement.CHANNELS, WebmConstants.MkvEbmlElement.BLOCK}, m = "getProductUrlToShare", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10261 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10261(ab.e<? super C10261> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.getProductUrlToShare(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$loadPersonalCatalogue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {118, 121, 124, WebmConstants.MkvEbmlElement.TRACK_TYPE, 133, 141}, m = "loadPersonalCatalogue", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10271 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10271(ab.e<? super C10271> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.loadPersonalCatalogue(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$requestProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "requestProduct", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10281 extends cb.d {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C10281(ab.e<? super C10281> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.requestProduct(0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$searchTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {175}, m = "searchTags", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10291 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10291(ab.e<? super C10291> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.searchTags(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.CatalogueRepository$updateProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.CatalogueRepository", f = "CatalogueRepository.kt", l = {83, 96, 97}, m = "updateProduct", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10301 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10301(ab.e<? super C10301> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueRepository.this.updateProduct(null, this);
        }
    }

    public static /* synthetic */ PagingSource myProductPagingFiltered$default(CatalogueRepository catalogueRepository, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return catalogueRepository.myProductPagingFiltered(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object addProduct(Product product, ab.e<? super DataWrapper<AddProductResponse>> eVar) {
        AnonymousClass1 anonymousClass1;
        Product product2;
        DataWrapper dataWrapper;
        Product product3;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objAddProduct = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(objAddProduct);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            AddProductRequest addProductRequest = new AddProductRequest(product.getName(), product.getDescription(), product.getPictureUrl(), product.getPrice(), product.isPublic(), product.getInfo());
            product2 = product;
            anonymousClass1.L$0 = product2;
            anonymousClass1.label = 1;
            objAddProduct = catalogueDataSource.addProduct(addProductRequest, anonymousClass1);
            if (objAddProduct != objG) {
            }
        }
        if (i11 == 1) {
            product2 = (Product) anonymousClass1.L$0;
            ua.v.b(objAddProduct);
        } else {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DataWrapper dataWrapper2 = (DataWrapper) anonymousClass1.L$1;
                ua.v.b(objAddProduct);
                return dataWrapper2;
            }
            dataWrapper = (DataWrapper) anonymousClass1.L$1;
            product3 = (Product) anonymousClass1.L$0;
            ua.v.b(objAddProduct);
        }
        PreferencesModule preferencesModule = this.preferences;
        int version = ((AddProductResponse) dataWrapper.getResponseBody()).getVersion();
        anonymousClass1.L$0 = cb.l.a(product3);
        anonymousClass1.L$1 = dataWrapper;
        anonymousClass1.label = 3;
        return preferencesModule.setCatalogueVersion(version, anonymousClass1) == objG ? objG : dataWrapper;
        Product product4 = product2;
        dataWrapper = (DataWrapper) objAddProduct;
        if (dataWrapper.getThrowable() == null && (dataWrapper.getCode() == 200 || dataWrapper.getCode() == 201)) {
            ProductDao productDao = this.productDao;
            Object responseBody = dataWrapper.getResponseBody();
            kotlin.jvm.internal.y.f(responseBody);
            Product productCopy$default = Product.copy$default(product4, ((AddProductResponse) responseBody).getId(), null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, false, null, 0, TypedValues.PositionType.TYPE_POSITION_TYPE, null);
            anonymousClass1.L$0 = cb.l.a(product4);
            anonymousClass1.L$1 = dataWrapper;
            anonymousClass1.label = 2;
            if (productDao.insert(productCopy$default, anonymousClass1) != objG) {
                product3 = product4;
                PreferencesModule preferencesModule2 = this.preferences;
                int version2 = ((AddProductResponse) dataWrapper.getResponseBody()).getVersion();
                anonymousClass1.L$0 = cb.l.a(product3);
                anonymousClass1.L$1 = dataWrapper;
                anonymousClass1.label = 3;
                if (preferencesModule2.setCatalogueVersion(version2, anonymousClass1) == objG) {
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object checkForProduct(String str, ab.e<? super FlowsState<Integer>> eVar) {
        C10201 c10201;
        if (eVar instanceof C10201) {
            c10201 = (C10201) eVar;
            int i10 = c10201.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10201.label = i10 - Integer.MIN_VALUE;
            } else {
                c10201 = new C10201(eVar);
            }
        } else {
            c10201 = new C10201(eVar);
        }
        Object objShop = c10201.result;
        Object objG = bb.b.g();
        int i11 = c10201.label;
        if (i11 == 0) {
            ua.v.b(objShop);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10201.L$0 = cb.l.a(str);
            c10201.label = 1;
            objShop = catalogueDataSource.shop(str, 0, 1, c10201);
            if (objShop == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objShop);
        }
        DataWrapper dataWrapper = (DataWrapper) objShop;
        if (dataWrapper.getResponseBody() == null) {
            return FlowsState.INSTANCE.error("", cb.b.d(3));
        }
        List<Product> catalog = ((CatalogResponse) dataWrapper.getResponseBody()).getCatalog();
        kotlin.jvm.internal.y.f(catalog);
        return catalog.isEmpty() ? FlowsState.INSTANCE.emptyData() : FlowsState.INSTANCE.success(cb.b.d(1));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deleteProduct(int i10, ab.e<? super DataWrapper<VersionResponse>> eVar) {
        C10211 c10211;
        DataWrapper dataWrapper;
        if (eVar instanceof C10211) {
            c10211 = (C10211) eVar;
            int i11 = c10211.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10211.label = i11 - Integer.MIN_VALUE;
            } else {
                c10211 = new C10211(eVar);
            }
        } else {
            c10211 = new C10211(eVar);
        }
        Object objDeleteProduct = c10211.result;
        Object objG = bb.b.g();
        int i12 = c10211.label;
        if (i12 == 0) {
            ua.v.b(objDeleteProduct);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10211.I$0 = i10;
            c10211.label = 1;
            objDeleteProduct = catalogueDataSource.deleteProduct(i10, c10211);
            if (objDeleteProduct != objG) {
            }
        }
        if (i12 == 1) {
            i10 = c10211.I$0;
            ua.v.b(objDeleteProduct);
        } else {
            if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DataWrapper dataWrapper2 = (DataWrapper) c10211.L$0;
                ua.v.b(objDeleteProduct);
                return dataWrapper2;
            }
            i10 = c10211.I$0;
            dataWrapper = (DataWrapper) c10211.L$0;
            ua.v.b(objDeleteProduct);
        }
        PreferencesModule preferencesModule = this.preferences;
        VersionResponse versionResponse = (VersionResponse) dataWrapper.getResponseBody();
        int version = versionResponse != null ? versionResponse.getVersion() : 1;
        c10211.L$0 = dataWrapper;
        c10211.I$0 = i10;
        c10211.label = 3;
        return preferencesModule.setCatalogueVersion(version, c10211) == objG ? objG : dataWrapper;
        dataWrapper = (DataWrapper) objDeleteProduct;
        if (dataWrapper.getThrowable() == null && (dataWrapper.getCode() == 200 || dataWrapper.getCode() == 201)) {
            ProductDao productDao = this.productDao;
            c10211.L$0 = dataWrapper;
            c10211.I$0 = i10;
            c10211.label = 2;
            if (productDao.deleteById(i10, c10211) != objG) {
                PreferencesModule preferencesModule2 = this.preferences;
                VersionResponse versionResponse2 = (VersionResponse) dataWrapper.getResponseBody();
                if (versionResponse2 != null) {
                }
                c10211.L$0 = dataWrapper;
                c10211.I$0 = i10;
                c10211.label = 3;
                if (preferencesModule2.setCatalogueVersion(version, c10211) == objG) {
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getMyProducts(int i10, int i11, ab.e<? super List<Product>> eVar) {
        C10221 c10221;
        if (eVar instanceof C10221) {
            c10221 = (C10221) eVar;
            int i12 = c10221.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c10221.label = i12 - Integer.MIN_VALUE;
            } else {
                c10221 = new C10221(eVar);
            }
        } else {
            c10221 = new C10221(eVar);
        }
        Object objMyShop = c10221.result;
        Object objG = bb.b.g();
        int i13 = c10221.label;
        if (i13 == 0) {
            ua.v.b(objMyShop);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10221.I$0 = i10;
            c10221.I$1 = i11;
            c10221.label = 1;
            objMyShop = catalogueDataSource.myShop(i10, i11, c10221);
            if (objMyShop == objG) {
                return objG;
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objMyShop);
        }
        DataWrapper dataWrapper = (DataWrapper) objMyShop;
        CatalogResponse catalogResponse = (CatalogResponse) dataWrapper.getResponseBody();
        if ((catalogResponse != null ? catalogResponse.getCatalog() : null) == null) {
            return null;
        }
        return ((CatalogResponse) dataWrapper.getResponseBody()).getCatalog();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getOtherProducts(String str, int i10, int i11, ab.e<? super List<Product>> eVar) {
        C10231 c10231;
        if (eVar instanceof C10231) {
            c10231 = (C10231) eVar;
            int i12 = c10231.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c10231.label = i12 - Integer.MIN_VALUE;
            } else {
                c10231 = new C10231(eVar);
            }
        } else {
            c10231 = new C10231(eVar);
        }
        Object objShop = c10231.result;
        Object objG = bb.b.g();
        int i13 = c10231.label;
        if (i13 == 0) {
            ua.v.b(objShop);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10231.L$0 = cb.l.a(str);
            c10231.I$0 = i10;
            c10231.I$1 = i11;
            c10231.label = 1;
            objShop = catalogueDataSource.shop(str, i10, i11, c10231);
            if (objShop == objG) {
                return objG;
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objShop);
        }
        DataWrapper dataWrapper = (DataWrapper) objShop;
        CatalogResponse catalogResponse = (CatalogResponse) dataWrapper.getResponseBody();
        if ((catalogResponse != null ? catalogResponse.getCatalog() : null) == null) {
            return null;
        }
        return ((CatalogResponse) dataWrapper.getResponseBody()).getCatalog();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object getOtherProductsFiltered(String str, String str2, String str3, int i10, int i11, ab.e<? super List<Product>> eVar) {
        C10241 c10241;
        if (eVar instanceof C10241) {
            c10241 = (C10241) eVar;
            int i12 = c10241.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c10241.label = i12 - Integer.MIN_VALUE;
            } else {
                c10241 = new C10241(eVar);
            }
        } else {
            c10241 = new C10241(eVar);
        }
        C10241 c10242 = c10241;
        Object objSearchProductsByTag = c10242.result;
        Object objG = bb.b.g();
        int i13 = c10242.label;
        if (i13 == 0) {
            ua.v.b(objSearchProductsByTag);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10242.L$0 = cb.l.a(str);
            c10242.L$1 = cb.l.a(str2);
            c10242.L$2 = cb.l.a(str3);
            c10242.I$0 = i10;
            c10242.I$1 = i11;
            c10242.label = 1;
            objSearchProductsByTag = catalogueDataSource.searchProductsByTag(str, str3, i10, i11, c10242);
            if (objSearchProductsByTag == objG) {
                return objG;
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objSearchProductsByTag);
        }
        DataWrapper dataWrapper = (DataWrapper) objSearchProductsByTag;
        CatalogFilteredResponse catalogFilteredResponse = (CatalogFilteredResponse) dataWrapper.getResponseBody();
        if ((catalogFilteredResponse != null ? catalogFilteredResponse.getProducts() : null) == null) {
            return null;
        }
        return ((CatalogFilteredResponse) dataWrapper.getResponseBody()).getProducts();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getProductOnlineInfo(String str, int i10, ab.e<? super Product> eVar) {
        C10251 c10251;
        if (eVar instanceof C10251) {
            c10251 = (C10251) eVar;
            int i11 = c10251.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10251.label = i11 - Integer.MIN_VALUE;
            } else {
                c10251 = new C10251(eVar);
            }
        } else {
            c10251 = new C10251(eVar);
        }
        Object product = c10251.result;
        Object objG = bb.b.g();
        int i12 = c10251.label;
        if (i12 == 0) {
            ua.v.b(product);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10251.L$0 = cb.l.a(str);
            c10251.I$0 = i10;
            c10251.label = 1;
            product = catalogueDataSource.getProduct(str, i10, c10251);
            if (product == objG) {
                return objG;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(product);
        }
        return ((DataWrapper) product).getResponseBody();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        if (r2.setCatalogueVersion(r4, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getProductUrlToShare(int r8, ab.e<? super java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cu.todus.android.repositories.CatalogueRepository.C10261
            if (r0 == 0) goto L13
            r0 = r9
            cu.todus.android.repositories.CatalogueRepository$getProductUrlToShare$1 r0 = (cu.todus.android.repositories.CatalogueRepository.C10261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.CatalogueRepository$getProductUrlToShare$1 r0 = new cu.todus.android.repositories.CatalogueRepository$getProductUrlToShare$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4d
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.L$0
            cu.todus.android.data.wrapper.DataWrapper r8 = (cu.todus.android.data.wrapper.DataWrapper) r8
            ua.v.b(r9)
            goto L90
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$0
            cu.todus.android.data.wrapper.DataWrapper r2 = (cu.todus.android.data.wrapper.DataWrapper) r2
            ua.v.b(r9)
            r9 = r8
            r8 = r2
            goto L77
        L47:
            int r8 = r0.I$0
            ua.v.b(r9)
            goto L5d
        L4d:
            ua.v.b(r9)
            cu.todus.android.rest.catalogue.CatalogueDataSource r9 = r7.catalogueDataSource
            r0.I$0 = r8
            r0.label = r5
            java.lang.Object r9 = r9.shareProduct(r8, r0)
            if (r9 != r1) goto L5d
            goto L8f
        L5d:
            cu.todus.android.data.wrapper.DataWrapper r9 = (cu.todus.android.data.wrapper.DataWrapper) r9
            java.lang.Object r2 = r9.getResponseBody()
            if (r2 == 0) goto L9b
            cu.todus.android.db.dao.cache.ProductDao r2 = r7.productDao
            r0.L$0 = r9
            r0.I$0 = r8
            r0.label = r4
            java.lang.Object r2 = r2.setProductVisibility(r5, r8, r0)
            if (r2 != r1) goto L74
            goto L8f
        L74:
            r6 = r9
            r9 = r8
            r8 = r6
        L77:
            cu.todus.android.di.PreferencesModule r2 = r7.preferences
            java.lang.Object r4 = r8.getResponseBody()
            cu.todus.android.data.rest.response.UrlResponse r4 = (cu.todus.android.data.rest.response.UrlResponse) r4
            int r4 = r4.getVersion()
            r0.L$0 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r9 = r2.setCatalogueVersion(r4, r0)
            if (r9 != r1) goto L90
        L8f:
            return r1
        L90:
            java.lang.Object r8 = r8.getResponseBody()
            cu.todus.android.data.rest.response.UrlResponse r8 = (cu.todus.android.data.rest.response.UrlResponse) r8
            java.lang.String r8 = r8.getUrl()
            return r8
        L9b:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.CatalogueRepository.getProductUrlToShare(int, ab.e):java.lang.Object");
    }

    public final Object getPublicProductCant(ab.e<? super Integer> eVar) {
        return this.productDao.getPublicCant(eVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0096  */
    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:50:0x0118  */
    /* JADX WARN: Code duplicated, block: B:53:0x0120  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f8 -> B:48:0x0112). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x010f -> B:48:0x0112). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object loadPersonalCatalogue(ab.e<? super ua.k0> r12) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.CatalogueRepository.loadPersonalCatalogue(ab.e):java.lang.Object");
    }

    public final PagingSource<Integer, Product> myProductPagingFiltered(String tag, String filter) {
        kotlin.jvm.internal.y.i(tag, "tag");
        kotlin.jvm.internal.y.i(filter, "filter");
        return this.productDao.getMyProductsPagingFiltered(tag, filter);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object requestProduct(int i10, ab.e<? super Boolean> eVar) {
        C10281 c10281;
        if (eVar instanceof C10281) {
            c10281 = (C10281) eVar;
            int i11 = c10281.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10281.label = i11 - Integer.MIN_VALUE;
            } else {
                c10281 = new C10281(eVar);
            }
        } else {
            c10281 = new C10281(eVar);
        }
        Object objRequestProduct = c10281.result;
        Object objG = bb.b.g();
        int i12 = c10281.label;
        if (i12 == 0) {
            ua.v.b(objRequestProduct);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10281.I$0 = i10;
            c10281.label = 1;
            objRequestProduct = catalogueDataSource.requestProduct(i10, c10281);
            if (objRequestProduct == objG) {
                return objG;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objRequestProduct);
        }
        return cb.b.a(((DataWrapper) objRequestProduct).getThrowable() == null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object searchTags(String str, ab.e<? super List<String>> eVar) {
        C10291 c10291;
        String tags;
        List listS0;
        if (eVar instanceof C10291) {
            c10291 = (C10291) eVar;
            int i10 = c10291.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10291.label = i10 - Integer.MIN_VALUE;
            } else {
                c10291 = new C10291(eVar);
            }
        } else {
            c10291 = new C10291(eVar);
        }
        Object objSearchTags = c10291.result;
        Object objG = bb.b.g();
        int i11 = c10291.label;
        if (i11 == 0) {
            ua.v.b(objSearchTags);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            c10291.L$0 = cb.l.a(str);
            c10291.label = 1;
            objSearchTags = catalogueDataSource.searchTags(str, c10291);
            if (objSearchTags == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objSearchTags);
        }
        TagsResponse tagsResponse = (TagsResponse) ((DataWrapper) objSearchTags).getResponseBody();
        return (tagsResponse == null || (tags = tagsResponse.getTags()) == null || (listS0 = le.d0.S0(tags, new String[]{"%_%"}, false, 0, 6, null)) == null) ? va.w.n() : listS0;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object updateProduct(Product product, ab.e<? super DataWrapper<VersionResponse>> eVar) {
        C10301 c10301;
        Product product2;
        Product product3;
        DataWrapper dataWrapper;
        PreferencesModule preferencesModule;
        int version;
        if (eVar instanceof C10301) {
            c10301 = (C10301) eVar;
            int i10 = c10301.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10301.label = i10 - Integer.MIN_VALUE;
            } else {
                c10301 = new C10301(eVar);
            }
        } else {
            c10301 = new C10301(eVar);
        }
        Object objUpdateProduct = c10301.result;
        Object objG = bb.b.g();
        int i11 = c10301.label;
        if (i11 == 0) {
            ua.v.b(objUpdateProduct);
            CatalogueDataSource catalogueDataSource = this.catalogueDataSource;
            int id2 = product.getId();
            UpdateProductRequest updateProductRequest = new UpdateProductRequest(product.getName(), product.getDescription(), product.getPictureUrl(), product.getPrice(), product.isPublic(), product.getInfo());
            c10301.L$0 = product;
            c10301.label = 1;
            objUpdateProduct = catalogueDataSource.updateProduct(id2, updateProductRequest, c10301);
            if (objUpdateProduct != objG) {
                product2 = product;
            }
            return objG;
        }
        if (i11 == 1) {
            product2 = (Product) c10301.L$0;
            ua.v.b(objUpdateProduct);
        } else {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DataWrapper dataWrapper2 = (DataWrapper) c10301.L$1;
                ua.v.b(objUpdateProduct);
                return dataWrapper2;
            }
            dataWrapper = (DataWrapper) c10301.L$1;
            product3 = (Product) c10301.L$0;
            ua.v.b(objUpdateProduct);
        }
        preferencesModule = this.preferences;
        VersionResponse versionResponse = (VersionResponse) dataWrapper.getResponseBody();
        version = versionResponse != null ? versionResponse.getVersion() : 1;
        c10301.L$0 = cb.l.a(product3);
        c10301.L$1 = dataWrapper;
        c10301.label = 3;
        if (preferencesModule.setCatalogueVersion(version, c10301) != objG) {
            return objG;
        }
        return dataWrapper;
        DataWrapper dataWrapper3 = (DataWrapper) objUpdateProduct;
        if (dataWrapper3.getThrowable() != null || (dataWrapper3.getCode() != 200 && dataWrapper3.getCode() != 201)) {
            return dataWrapper3;
        }
        ProductDao productDao = this.productDao;
        c10301.L$0 = cb.l.a(product2);
        c10301.L$1 = dataWrapper3;
        c10301.label = 2;
        if (productDao.update(product2, c10301) != objG) {
            product3 = product2;
            dataWrapper = dataWrapper3;
            preferencesModule = this.preferences;
            VersionResponse versionResponse2 = (VersionResponse) dataWrapper.getResponseBody();
            if (versionResponse2 != null) {
            }
            c10301.L$0 = cb.l.a(product3);
            c10301.L$1 = dataWrapper;
            c10301.label = 3;
            if (preferencesModule.setCatalogueVersion(version, c10301) != objG) {
                return dataWrapper;
            }
        }
        return objG;
    }
}
