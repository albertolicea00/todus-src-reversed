package cu.todus.android.uiCompose.main.screen.catalogue;

import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cb.l;
import cb.m;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.Product;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.geo.CubaGeoDataSource;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.CatalogueRepository;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import pe.d1;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;
import ua.z;
import va.g0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\rJ+\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ}\u0010+\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b+\u0010,J\u0097\u0001\u00101\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u00100\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b1\u00102J1\u00105\u001a\u00020\u000b2\u0006\u00103\u001a\u00020-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020-¢\u0006\u0004\b7\u00108J7\u0010;\u001a\u00020\u000b2\u0006\u00103\u001a\u00020-2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b092\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\rJ\u0015\u0010>\u001a\u00020\u000b2\u0006\u00103\u001a\u00020-¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b@\u0010\u0005J\r\u0010A\u001a\u00020\u000b¢\u0006\u0004\bA\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0017\u0010L\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR \u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR#\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0V0Y8\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR \u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010XR#\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140V0Y8\u0006¢\u0006\f\n\u0004\bg\u0010[\u001a\u0004\bh\u0010]R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020-0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010XR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020-0Y8\u0006¢\u0006\f\n\u0004\bj\u0010[\u001a\u0004\bk\u0010]R\"\u0010m\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010l0V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010XR%\u0010n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010l0V0Y8\u0006¢\u0006\f\n\u0004\bn\u0010[\u001a\u0004\bo\u0010]R\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00020a8\u0006¢\u0006\f\n\u0004\bp\u0010c\u001a\u0004\bq\u0010e¨\u0006r"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/catalogue/CatalogueViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "", User.COLUMN_TODUS_ID, "<init>", "(Ljava/lang/String;)V", "getTags", "(Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "()Lcu/todus/android/data/preferences/Owner;", "Lua/k0;", "loadPersonalProducts", "()V", "Lkotlin/Function0;", "onComplete", "checkForProducts", "(Ljava/lang/String;Llb/a;)V", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/entity/cache/Product;", "catalogue", "()Lte/h;", "tag", "filter", "catalogueFiltered", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "errorObtainingLocation", "myFilteredCatalogue", "name", "description", "", "price", "Landroid/net/Uri;", "pictureUri", "", "isPublic", Product.EXTRA_PROVINCE, Product.EXTRA_MUNICIPALITY, "location", "state", "coinType", "goBack", "addProduct", "(Ljava/lang/String;Ljava/lang/String;DLandroid/net/Uri;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llb/a;Llb/a;)V", "", "id", "createDate", User.COLUMN_PHOTO_URL, "updateProduct", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLandroid/net/Uri;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llb/a;Llb/a;)V", "productId", "onDeleted", "deleteProduct", "(ILlb/a;Llb/a;)V", "getProductInfo", "(Ljava/lang/String;I)V", "Lkotlin/Function1;", "onResult", "loadProductUrl", "(ILkotlin/jvm/functions/Function1;Llb/a;)V", "loadPublicCant", "imInterestedIn", "(I)V", "loadTags", "clearTags", "Ljava/lang/String;", "getToDusId", "()Ljava/lang/String;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/CatalogueRepository;", "catalogueRepository", "Lcu/todus/android/repositories/CatalogueRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lcu/todus/android/data/geo/CubaGeoDataSource;", "cubaGeoDataSource", "Lcu/todus/android/data/geo/CubaGeoDataSource;", "getCubaGeoDataSource", "()Lcu/todus/android/data/geo/CubaGeoDataSource;", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "_checkResponse", "Lte/b0;", "Lte/p0;", "checkResponse", "Lte/p0;", "getCheckResponse", "()Lte/p0;", "Landroidx/paging/PagingConfig;", "pagingPagingConfig", "Landroidx/paging/PagingConfig;", "Lcu/z17/views/utils/Z17MutableListFlow;", "productTags", "Lcu/z17/views/utils/Z17MutableListFlow;", "getProductTags", "()Lcu/z17/views/utils/Z17MutableListFlow;", "_product", "product", "getProduct", "_publicCant", "publicCant", "getPublicCant", "", "_interested", "interested", "getInterested", "allTags", "getAllTags", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CatalogueViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _checkResponse;
    private final b0 _interested;
    private final b0 _product;
    private final b0 _publicCant;
    private final Z17MutableListFlow<String> allTags;
    private final CatalogueRepository catalogueRepository;
    private final p0 checkResponse;
    private final CubaGeoDataSource cubaGeoDataSource;
    private final v5.f gson;
    private final p0 interested;
    private final MainRepository mainRepository;
    private final PagingConfig pagingPagingConfig;
    private final p0 product;
    private final Z17MutableListFlow<String> productTags;
    private final p0 publicCant;
    private final String toDusId;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1", f = "CatalogueViewModel.kt", l = {141, 157, WebmConstants.MkvEbmlElement.BLOCK}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        final /* synthetic */ String $coinType;
        final /* synthetic */ String $description;
        final /* synthetic */ lb.a $goBack;
        final /* synthetic */ boolean $isPublic;
        final /* synthetic */ String $location;
        final /* synthetic */ String $municipality;
        final /* synthetic */ String $name;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ Uri $pictureUri;
        final /* synthetic */ double $price;
        final /* synthetic */ String $province;
        final /* synthetic */ String $state;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1$1", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02151 extends m implements Function2 {
            final /* synthetic */ lb.a $goBack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02151(lb.a aVar, ab.e<? super C02151> eVar) {
                super(2, eVar);
                this.$goBack = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02151(this.$goBack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$goBack.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02151) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$addProduct$1$3", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, String str, String str2, String str3, String str4, String str5, String str6, String str7, double d10, boolean z10, lb.a aVar, lb.a aVar2, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$pictureUri = uri;
            this.$province = str;
            this.$municipality = str2;
            this.$location = str3;
            this.$state = str4;
            this.$coinType = str5;
            this.$description = str6;
            this.$name = str7;
            this.$price = d10;
            this.$isPublic = z10;
            this.$goBack = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(Product product, CatalogueViewModel catalogueViewModel, Uri uri, String str, String str2, String str3, String str4, String str5, lb.a aVar, lb.a aVar2) {
            catalogueViewModel.addProduct(product.getName(), product.getDescription(), product.getPrice(), uri, product.isPublic(), str, str2, str3, str4, str5, aVar, aVar2);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new AnonymousClass1(this.$pictureUri, this.$province, this.$municipality, this.$location, this.$state, this.$coinType, this.$description, this.$name, this.$price, this.$isPublic, this.$goBack, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0123  */
        /* JADX WARN: Code duplicated, block: B:31:0x0192  */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objUploadProductImage;
            Pair pair;
            String strValueOf;
            String str;
            Pair[] pairArr;
            int i10;
            Object tags;
            String str2;
            Pair[] pairArr2;
            Product product;
            Object objAddProduct;
            final Product product2;
            DataWrapper dataWrapper;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                v.b(obj);
                MainRepository mainRepository = CatalogueViewModel.this.mainRepository;
                Uri uri = this.$pictureUri;
                this.label = 1;
                objUploadProductImage = mainRepository.uploadProductImage(uri, this);
                if (objUploadProductImage != objG) {
                }
                return objG;
            }
            if (i11 == 1) {
                v.b(obj);
                objUploadProductImage = obj;
            } else {
                if (i11 == 2) {
                    int i12 = this.I$0;
                    str2 = (String) this.L$5;
                    pairArr = (Pair[]) this.L$4;
                    pairArr2 = (Pair[]) this.L$3;
                    str = (String) this.L$2;
                    strValueOf = (String) this.L$1;
                    pair = (Pair) this.L$0;
                    v.b(obj);
                    i10 = i12;
                    tags = obj;
                    String str3 = str;
                    String str4 = strValueOf;
                    pairArr[i10] = z.a(str2, tags);
                    product = new Product(0, str4, this.$description, this.$name, str3, this.$price, this.$isPublic, w0.l(pairArr2), 0, 256, null);
                    CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                    this.L$0 = l.a(pair);
                    this.L$1 = product;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 3;
                    objAddProduct = catalogueRepository.addProduct(product, this);
                    if (objAddProduct != objG) {
                        product2 = product;
                    }
                    return objG;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Product product3 = (Product) this.L$1;
                v.b(obj);
                objAddProduct = obj;
                product2 = product3;
            }
            dataWrapper = (DataWrapper) objAddProduct;
            if (dataWrapper.getThrowable() == null || !(dataWrapper.getCode() == 200 || dataWrapper.getCode() == 201)) {
                Function1 setError = CatalogueViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_created);
                y.h(string, "getString(...)");
                final CatalogueViewModel catalogueViewModel = CatalogueViewModel.this;
                final Uri uri2 = this.$pictureUri;
                final String str5 = this.$province;
                final String str6 = this.$municipality;
                final String str7 = this.$location;
                final String str8 = this.$state;
                final String str9 = this.$coinType;
                final lb.a aVar = this.$goBack;
                final lb.a aVar2 = this.$onComplete;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.d
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueViewModel.AnonymousClass1.invokeSuspend$lambda$0(product2, catalogueViewModel, uri2, str5, str6, str7, str8, str9, aVar, aVar2);
                    }
                }, true));
            } else {
                MainRepository mainRepository2 = CatalogueViewModel.this.mainRepository;
                String string2 = UUID.randomUUID().toString();
                y.h(string2, "toString(...)");
                String strO = a0.O(string2, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_created);
                y.h(string3, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string3));
                pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new C02151(this.$goBack, null), 2, null);
            }
            pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
            return k0.f43947a;
            pair = (Pair) objUploadProductImage;
            strValueOf = String.valueOf(new Date().getTime());
            str = (String) pair.getSecond();
            pairArr = new Pair[6];
            pairArr[0] = z.a(Product.EXTRA_PROVINCE, this.$province);
            pairArr[1] = z.a(Product.EXTRA_MUNICIPALITY, this.$municipality);
            pairArr[2] = z.a("location", this.$location);
            pairArr[3] = z.a("state", this.$state);
            pairArr[4] = z.a(Product.EXTRA_COIN_TYPE, this.$coinType);
            CatalogueViewModel catalogueViewModel2 = CatalogueViewModel.this;
            this.L$0 = l.a(pair);
            this.L$1 = strValueOf;
            this.L$2 = str;
            this.L$3 = pairArr;
            this.L$4 = pairArr;
            this.L$5 = "tag";
            i10 = 5;
            this.I$0 = 5;
            this.label = 2;
            tags = catalogueViewModel2.getTags(this);
            if (tags != objG) {
                str2 = "tag";
                pairArr2 = pairArr;
                String str10 = str;
                String str11 = strValueOf;
                pairArr[i10] = z.a(str2, tags);
                product = new Product(0, str11, this.$description, this.$name, str10, this.$price, this.$isPublic, w0.l(pairArr2), 0, 256, null);
                CatalogueRepository catalogueRepository2 = CatalogueViewModel.this.catalogueRepository;
                this.L$0 = l.a(pair);
                this.L$1 = product;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 3;
                objAddProduct = catalogueRepository2.addProduct(product, this);
                if (objAddProduct != objG) {
                    product2 = product;
                    dataWrapper = (DataWrapper) objAddProduct;
                    if (dataWrapper.getThrowable() == null) {
                        Function1 setError2 = CatalogueViewModel.this.mainRepository.getSetError();
                        String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_created);
                        y.h(string4, "getString(...)");
                        final CatalogueViewModel catalogueViewModel3 = CatalogueViewModel.this;
                        final Uri uri3 = this.$pictureUri;
                        final String str12 = this.$province;
                        final String str13 = this.$municipality;
                        final String str14 = this.$location;
                        final String str15 = this.$state;
                        final String str16 = this.$coinType;
                        final lb.a aVar3 = this.$goBack;
                        final lb.a aVar4 = this.$onComplete;
                        setError2.invoke(new ToDusException(string4, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.d
                            @Override // lb.a
                            public final Object invoke() {
                                return CatalogueViewModel.AnonymousClass1.invokeSuspend$lambda$0(product2, catalogueViewModel3, uri3, str12, str13, str14, str15, str16, aVar3, aVar4);
                            }
                        }, true));
                    } else {
                        Function1 setError3 = CatalogueViewModel.this.mainRepository.getSetError();
                        String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_created);
                        y.h(string5, "getString(...)");
                        final CatalogueViewModel catalogueViewModel4 = CatalogueViewModel.this;
                        final Uri uri4 = this.$pictureUri;
                        final String str17 = this.$province;
                        final String str18 = this.$municipality;
                        final String str19 = this.$location;
                        final String str110 = this.$state;
                        final String str111 = this.$coinType;
                        final lb.a aVar5 = this.$goBack;
                        final lb.a aVar6 = this.$onComplete;
                        setError3.invoke(new ToDusException(string5, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.d
                            @Override // lb.a
                            public final Object invoke() {
                                return CatalogueViewModel.AnonymousClass1.invokeSuspend$lambda$0(product2, catalogueViewModel4, uri4, str17, str18, str19, str110, str111, aVar5, aVar6);
                            }
                        }, true));
                    }
                    pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
                    return k0.f43947a;
                }
            }
            return objG;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$checkForProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$checkForProducts$1", f = "CatalogueViewModel.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11981 extends m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ String $toDusId;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$checkForProducts$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$checkForProducts$1$1", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02161 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02161(lb.a aVar, ab.e<? super C02161> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02161(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02161) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11981(String str, lb.a aVar, ab.e<? super C11981> eVar) {
            super(1, eVar);
            this.$toDusId = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C11981(this.$toDusId, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11981) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                b0 b0Var2 = CatalogueViewModel.this._checkResponse;
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                String str = this.$toDusId;
                this.L$0 = b0Var2;
                this.label = 1;
                Object objCheckForProduct = catalogueRepository.checkForProduct(str, this);
                if (objCheckForProduct == objG) {
                    return objG;
                }
                b0Var = b0Var2;
                obj = objCheckForProduct;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) this.L$0;
                v.b(obj);
            }
            b0Var.setValue(obj);
            pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new C02161(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1", f = "CatalogueViewModel.kt", l = {287}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11991 extends m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ lb.a $onDeleted;
        final /* synthetic */ int $productId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1$1", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02171 extends m implements Function2 {
            final /* synthetic */ lb.a $onDeleted;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02171(lb.a aVar, ab.e<? super C02171> eVar) {
                super(2, eVar);
                this.$onDeleted = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02171(this.$onDeleted, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onDeleted.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02171) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$deleteProduct$1$3", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11991(int i10, lb.a aVar, lb.a aVar2, ab.e<? super C11991> eVar) {
            super(1, eVar);
            this.$productId = i10;
            this.$onDeleted = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(CatalogueViewModel catalogueViewModel, int i10, lb.a aVar, lb.a aVar2) {
            catalogueViewModel.deleteProduct(i10, aVar, aVar2);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C11991(this.$productId, this.$onDeleted, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C11991) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                int i11 = this.$productId;
                this.label = 1;
                obj = catalogueRepository.deleteProduct(i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            DataWrapper dataWrapper = (DataWrapper) obj;
            if (dataWrapper.getThrowable() == null && (dataWrapper.getCode() == 200 || dataWrapper.getCode() == 201)) {
                MainRepository mainRepository = CatalogueViewModel.this.mainRepository;
                String string = UUID.randomUUID().toString();
                y.h(string, "toString(...)");
                String strO = a0.O(string, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_deleted);
                y.h(string2, "getString(...)");
                mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
                pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new C02171(this.$onDeleted, null), 2, null);
            } else {
                Function1 setError = CatalogueViewModel.this.mainRepository.getSetError();
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_delete);
                y.h(string3, "getString(...)");
                final CatalogueViewModel catalogueViewModel = CatalogueViewModel.this;
                final int i12 = this.$productId;
                final lb.a aVar = this.$onDeleted;
                final lb.a aVar2 = this.$onComplete;
                setError.invoke(new ToDusException(string3, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.e
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueViewModel.C11991.invokeSuspend$lambda$0(catalogueViewModel, i12, aVar, aVar2);
                    }
                }, true));
            }
            CatalogueViewModel.this.loadPublicCant();
            pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$getProductInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$getProductInfo$1", f = "CatalogueViewModel.kt", l = {328}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12001 extends m implements Function1 {
        final /* synthetic */ int $productId;
        final /* synthetic */ String $toDusId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12001(String str, int i10, ab.e<? super C12001> eVar) {
            super(1, eVar);
            this.$toDusId = str;
            this.$productId = i10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12001(this.$toDusId, this.$productId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12001) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                CatalogueViewModel.this._product.setValue(FlowsState.INSTANCE.loading());
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                String str = this.$toDusId;
                int i11 = this.$productId;
                this.label = 1;
                obj = catalogueRepository.getProductOnlineInfo(str, i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            Product product = (Product) obj;
            if (product == null) {
                CatalogueViewModel.this._product.setValue(FlowsState.INSTANCE.error("not product found", null));
            } else {
                CatalogueViewModel.this._product.setValue(FlowsState.INSTANCE.success(product));
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$getTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel", f = "CatalogueViewModel.kt", l = {121}, m = "getTags", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C12011 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C12011(ab.e<? super C12011> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CatalogueViewModel.this.getTags(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$imInterestedIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$imInterestedIn$1", f = "CatalogueViewModel.kt", l = {379}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12021 extends m implements Function1 {
        final /* synthetic */ int $productId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12021(int i10, ab.e<? super C12021> eVar) {
            super(1, eVar);
            this.$productId = i10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12021(this.$productId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12021) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                CatalogueViewModel.this._interested.setValue(FlowsState.INSTANCE.loading());
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                int i11 = this.$productId;
                this.label = 1;
                obj = catalogueRepository.requestProduct(i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                CatalogueViewModel.this._interested.setValue(FlowsState.INSTANCE.success(null));
            } else {
                CatalogueViewModel.this._interested.setValue(FlowsState.INSTANCE.error("", null));
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadPersonalProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadPersonalProducts$1", f = "CatalogueViewModel.kt", l = {47}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12031 extends m implements Function1 {
        int label;

        public C12031(ab.e<? super C12031> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12031(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12031) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                this.label = 1;
                if (catalogueRepository.loadPersonalCatalogue(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadProductUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadProductUrl$1", f = "CatalogueViewModel.kt", l = {340}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12041 extends m implements Function1 {
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ Function1 $onResult;
        final /* synthetic */ int $productId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadProductUrl$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadProductUrl$1$2", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12041(int i10, Function1 function1, lb.a aVar, ab.e<? super C12041> eVar) {
            super(1, eVar);
            this.$productId = i10;
            this.$onResult = function1;
            this.$onComplete = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(CatalogueViewModel catalogueViewModel, int i10, Function1 function1, lb.a aVar) {
            catalogueViewModel.loadProductUrl(i10, function1, aVar);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12041(this.$productId, this.$onResult, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12041) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                int i11 = this.$productId;
                this.label = 1;
                obj = catalogueRepository.getProductUrlToShare(i11, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            String str = (String) obj;
            if (d0.q0(str)) {
                Function1 setError = CatalogueViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.url_has_not_been_resolved);
                y.h(string, "getString(...)");
                final CatalogueViewModel catalogueViewModel = CatalogueViewModel.this;
                final int i12 = this.$productId;
                final Function1 function1 = this.$onResult;
                final lb.a aVar = this.$onComplete;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.f
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueViewModel.C12041.invokeSuspend$lambda$0(catalogueViewModel, i12, function1, aVar);
                    }
                }, true));
            } else {
                this.$onResult.invoke(str);
            }
            pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass2(this.$onComplete, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadPublicCant$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadPublicCant$1", f = "CatalogueViewModel.kt", l = {368}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12051 extends m implements Function1 {
        Object L$0;
        int label;

        public C12051(ab.e<? super C12051> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12051(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12051) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                b0 b0Var2 = CatalogueViewModel.this._publicCant;
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                this.L$0 = b0Var2;
                this.label = 1;
                Object publicProductCant = catalogueRepository.getPublicProductCant(this);
                if (publicProductCant == objG) {
                    return objG;
                }
                b0Var = b0Var2;
                obj = publicProductCant;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) this.L$0;
                v.b(obj);
            }
            b0Var.setValue(obj);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$loadTags$1", f = "CatalogueViewModel.kt", l = {390}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12061 extends m implements Function1 {
        final /* synthetic */ String $toDusId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12061(String str, ab.e<? super C12061> eVar) {
            super(1, eVar);
            this.$toDusId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12061(this.$toDusId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12061) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Z17MutableListFlow<String> z17MutableListFlow;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                Z17MutableListFlow<String> allTags = CatalogueViewModel.this.getAllTags();
                CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                String str = this.$toDusId;
                this.L$0 = allTags;
                this.label = 1;
                Object objSearchTags = catalogueRepository.searchTags(str, this);
                if (objSearchTags == objG) {
                    return objG;
                }
                z17MutableListFlow = allTags;
                obj = objSearchTags;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z17MutableListFlow = (Z17MutableListFlow) this.L$0;
                v.b(obj);
            }
            z17MutableListFlow.addAll((List) obj);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1", f = "CatalogueViewModel.kt", l = {220, WebmConstants.MkvEbmlElement.VOID, PsExtractor.VIDEO_STREAM_MASK}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12071 extends m implements Function1 {
        final /* synthetic */ String $coinType;
        final /* synthetic */ String $createDate;
        final /* synthetic */ String $description;
        final /* synthetic */ lb.a $goBack;
        final /* synthetic */ int $id;
        final /* synthetic */ boolean $isPublic;
        final /* synthetic */ String $location;
        final /* synthetic */ String $municipality;
        final /* synthetic */ String $name;
        final /* synthetic */ lb.a $onComplete;
        final /* synthetic */ Uri $pictureUri;
        final /* synthetic */ String $pictureUrl;
        final /* synthetic */ double $price;
        final /* synthetic */ String $province;
        final /* synthetic */ String $state;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1$1", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02181 extends m implements Function2 {
            final /* synthetic */ lb.a $goBack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02181(lb.a aVar, ab.e<? super C02181> eVar) {
                super(2, eVar);
                this.$goBack = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02181(this.$goBack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$goBack.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02181) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.catalogue.CatalogueViewModel$updateProduct$1$3", f = "CatalogueViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(lb.a aVar, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12071(Uri uri, String str, String str2, String str3, String str4, String str5, int i10, String str6, String str7, String str8, double d10, boolean z10, String str9, lb.a aVar, lb.a aVar2, ab.e<? super C12071> eVar) {
            super(1, eVar);
            this.$pictureUri = uri;
            this.$province = str;
            this.$municipality = str2;
            this.$location = str3;
            this.$state = str4;
            this.$coinType = str5;
            this.$id = i10;
            this.$createDate = str6;
            this.$description = str7;
            this.$name = str8;
            this.$price = d10;
            this.$isPublic = z10;
            this.$pictureUrl = str9;
            this.$goBack = aVar;
            this.$onComplete = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(Product product, CatalogueViewModel catalogueViewModel, Uri uri, String str, String str2, String str3, String str4, String str5, lb.a aVar, lb.a aVar2) {
            CatalogueViewModel.updateProduct$default(catalogueViewModel, product.getId(), product.getCreatedAt(), product.getName(), product.getDescription(), product.getPrice(), uri, null, product.isPublic(), str, str2, str3, str4, str5, aVar, aVar2, 64, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return CatalogueViewModel.this.new C12071(this.$pictureUri, this.$province, this.$municipality, this.$location, this.$state, this.$coinType, this.$id, this.$createDate, this.$description, this.$name, this.$price, this.$isPublic, this.$pictureUrl, this.$goBack, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12071) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0119  */
        /* JADX WARN: Code duplicated, block: B:34:0x0188  */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objUploadProductImage;
            Pair pair;
            String str;
            Pair[] pairArr;
            int i10;
            Object tags;
            String str2;
            Pair[] pairArr2;
            Product product;
            Object objUpdateProduct;
            final Product product2;
            DataWrapper dataWrapper;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                v.b(obj);
                MainRepository mainRepository = CatalogueViewModel.this.mainRepository;
                Uri uri = this.$pictureUri;
                this.label = 1;
                objUploadProductImage = mainRepository.uploadProductImage(uri, this);
                if (objUploadProductImage != objG) {
                }
                return objG;
            }
            if (i11 == 1) {
                v.b(obj);
                objUploadProductImage = obj;
            } else {
                if (i11 == 2) {
                    int i12 = this.I$0;
                    str2 = (String) this.L$4;
                    pairArr = (Pair[]) this.L$3;
                    pairArr2 = (Pair[]) this.L$2;
                    str = (String) this.L$1;
                    pair = (Pair) this.L$0;
                    v.b(obj);
                    i10 = i12;
                    tags = obj;
                    String str3 = str;
                    pairArr[i10] = z.a(str2, tags);
                    product = new Product(this.$id, this.$createDate, this.$description, this.$name, str3, this.$price, this.$isPublic, w0.l(pairArr2), 0, 256, null);
                    CatalogueRepository catalogueRepository = CatalogueViewModel.this.catalogueRepository;
                    this.L$0 = l.a(pair);
                    this.L$1 = product;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 3;
                    objUpdateProduct = catalogueRepository.updateProduct(product, this);
                    if (objUpdateProduct != objG) {
                        product2 = product;
                    }
                    return objG;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Product product3 = (Product) this.L$1;
                v.b(obj);
                objUpdateProduct = obj;
                product2 = product3;
            }
            dataWrapper = (DataWrapper) objUpdateProduct;
            if (dataWrapper.getThrowable() == null || !(dataWrapper.getCode() == 200 || dataWrapper.getCode() == 201)) {
                Function1 setError = CatalogueViewModel.this.mainRepository.getSetError();
                String string = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_updated);
                y.h(string, "getString(...)");
                final CatalogueViewModel catalogueViewModel = CatalogueViewModel.this;
                final Uri uri2 = this.$pictureUri;
                final String str4 = this.$province;
                final String str5 = this.$municipality;
                final String str6 = this.$location;
                final String str7 = this.$state;
                final String str8 = this.$coinType;
                final lb.a aVar = this.$goBack;
                final lb.a aVar2 = this.$onComplete;
                setError.invoke(new ToDusException(string, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.g
                    @Override // lb.a
                    public final Object invoke() {
                        return CatalogueViewModel.C12071.invokeSuspend$lambda$1(product2, catalogueViewModel, uri2, str4, str5, str6, str7, str8, aVar, aVar2);
                    }
                }, true));
            } else {
                MainRepository mainRepository2 = CatalogueViewModel.this.mainRepository;
                String string2 = UUID.randomUUID().toString();
                y.h(string2, "toString(...)");
                String strO = a0.O(string2, "-", "", false, 4, null);
                Cause cause = Cause.CORRECT;
                String string3 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_updated);
                y.h(string3, "getString(...)");
                mainRepository2.addNewNotification(new InsideNotificationState(strO, cause, string3));
                pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new C02181(this.$goBack, null), 2, null);
            }
            pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
            return k0.f43947a;
            pair = (Pair) objUploadProductImage;
            CharSequence charSequence = (CharSequence) pair.getSecond();
            String str9 = this.$pictureUrl;
            if (d0.q0(charSequence)) {
                charSequence = str9;
            }
            str = (String) charSequence;
            pairArr = new Pair[6];
            pairArr[0] = z.a(Product.EXTRA_PROVINCE, this.$province);
            pairArr[1] = z.a(Product.EXTRA_MUNICIPALITY, this.$municipality);
            pairArr[2] = z.a("location", this.$location);
            pairArr[3] = z.a("state", this.$state);
            pairArr[4] = z.a(Product.EXTRA_COIN_TYPE, this.$coinType);
            CatalogueViewModel catalogueViewModel2 = CatalogueViewModel.this;
            this.L$0 = l.a(pair);
            this.L$1 = str;
            this.L$2 = pairArr;
            this.L$3 = pairArr;
            this.L$4 = "tag";
            i10 = 5;
            this.I$0 = 5;
            this.label = 2;
            tags = catalogueViewModel2.getTags(this);
            if (tags != objG) {
                str2 = "tag";
                pairArr2 = pairArr;
                String str10 = str;
                pairArr[i10] = z.a(str2, tags);
                product = new Product(this.$id, this.$createDate, this.$description, this.$name, str10, this.$price, this.$isPublic, w0.l(pairArr2), 0, 256, null);
                CatalogueRepository catalogueRepository2 = CatalogueViewModel.this.catalogueRepository;
                this.L$0 = l.a(pair);
                this.L$1 = product;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                objUpdateProduct = catalogueRepository2.updateProduct(product, this);
                if (objUpdateProduct != objG) {
                    product2 = product;
                    dataWrapper = (DataWrapper) objUpdateProduct;
                    if (dataWrapper.getThrowable() == null) {
                        Function1 setError2 = CatalogueViewModel.this.mainRepository.getSetError();
                        String string4 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_updated);
                        y.h(string4, "getString(...)");
                        final CatalogueViewModel catalogueViewModel3 = CatalogueViewModel.this;
                        final Uri uri3 = this.$pictureUri;
                        final String str11 = this.$province;
                        final String str12 = this.$municipality;
                        final String str13 = this.$location;
                        final String str14 = this.$state;
                        final String str15 = this.$coinType;
                        final lb.a aVar3 = this.$goBack;
                        final lb.a aVar4 = this.$onComplete;
                        setError2.invoke(new ToDusException(string4, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.g
                            @Override // lb.a
                            public final Object invoke() {
                                return CatalogueViewModel.C12071.invokeSuspend$lambda$1(product2, catalogueViewModel3, uri3, str11, str12, str13, str14, str15, aVar3, aVar4);
                            }
                        }, true));
                    } else {
                        Function1 setError3 = CatalogueViewModel.this.mainRepository.getSetError();
                        String string5 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.product_has_not_been_updated);
                        y.h(string5, "getString(...)");
                        final CatalogueViewModel catalogueViewModel4 = CatalogueViewModel.this;
                        final Uri uri4 = this.$pictureUri;
                        final String str16 = this.$province;
                        final String str17 = this.$municipality;
                        final String str18 = this.$location;
                        final String str19 = this.$state;
                        final String str110 = this.$coinType;
                        final lb.a aVar5 = this.$goBack;
                        final lb.a aVar6 = this.$onComplete;
                        setError3.invoke(new ToDusException(string5, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.g
                            @Override // lb.a
                            public final Object invoke() {
                                return CatalogueViewModel.C12071.invokeSuspend$lambda$1(product2, catalogueViewModel4, uri4, str16, str17, str18, str19, str110, aVar5, aVar6);
                            }
                        }, true));
                    }
                    pe.k.d(ViewModelKt.getViewModelScope(CatalogueViewModel.this), d1.c(), null, new AnonymousClass3(this.$onComplete, null), 2, null);
                    return k0.f43947a;
                }
            }
            return objG;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CatalogueViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource catalogue$lambda$0(CatalogueViewModel catalogueViewModel) {
        return new ResultPagingSource(new CatalogueViewModel$catalogue$1$pagingSource$1(catalogueViewModel, null), catalogueViewModel.pagingPagingConfig.pageSize);
    }

    public static /* synthetic */ te.h catalogueFiltered$default(CatalogueViewModel catalogueViewModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return catalogueViewModel.catalogueFiltered(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource catalogueFiltered$lambda$0(CatalogueViewModel catalogueViewModel, String str, String str2) {
        return new ResultPagingSource(new CatalogueViewModel$catalogueFiltered$1$pagingSource$1(catalogueViewModel, str, str2, null), catalogueViewModel.pagingPagingConfig.pageSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getTags(ab.e<? super String> eVar) {
        C12011 c12011;
        if (eVar instanceof C12011) {
            c12011 = (C12011) eVar;
            int i10 = c12011.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c12011.label = i10 - Integer.MIN_VALUE;
            } else {
                c12011 = new C12011(eVar);
            }
        } else {
            c12011 = new C12011(eVar);
        }
        Object objX = c12011.result;
        Object objG = bb.b.g();
        int i11 = c12011.label;
        if (i11 == 0) {
            v.b(objX);
            te.h value = this.productTags.getValue();
            c12011.label = 1;
            objX = te.j.x(value, c12011);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objX);
        }
        String strG0 = g0.G0((Iterable) objX, "%_%", null, null, 0, null, null, 62, null);
        this.productTags.removeAll();
        return strG0;
    }

    public static /* synthetic */ te.h myFilteredCatalogue$default(CatalogueViewModel catalogueViewModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return catalogueViewModel.myFilteredCatalogue(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource myFilteredCatalogue$lambda$0(CatalogueViewModel catalogueViewModel, String str, String str2) {
        return catalogueViewModel.catalogueRepository.myProductPagingFiltered(str, str2);
    }

    public static /* synthetic */ void updateProduct$default(CatalogueViewModel catalogueViewModel, int i10, String str, String str2, String str3, double d10, Uri uri, String str4, boolean z10, String str5, String str6, String str7, String str8, String str9, lb.a aVar, lb.a aVar2, int i11, Object obj) {
        catalogueViewModel.updateProduct(i10, str, str2, str3, d10, (i11 & 32) != 0 ? null : uri, (i11 & 64) != 0 ? "" : str4, z10, str5, str6, str7, str8, str9, aVar, aVar2);
    }

    public final void addProduct(String name, String description, double price, Uri pictureUri, boolean isPublic, String province, String municipality, String location, String state, String coinType, lb.a goBack, lb.a onComplete) {
        y.i(name, "name");
        y.i(description, "description");
        y.i(province, "province");
        y.i(municipality, "municipality");
        y.i(location, "location");
        y.i(state, "state");
        y.i(coinType, "coinType");
        y.i(goBack, "goBack");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(pictureUri, province, municipality, location, state, coinType, description, name, price, isPublic, goBack, onComplete, null), 3, null);
    }

    public final te.h catalogue() {
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.a
            @Override // lb.a
            public final Object invoke() {
                return CatalogueViewModel.catalogue$lambda$0(this.f21572c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final te.h catalogueFiltered(final String tag, final String filter) {
        y.i(tag, "tag");
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.b
            @Override // lb.a
            public final Object invoke() {
                return CatalogueViewModel.catalogueFiltered$lambda$0(this.f21573c, tag, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void checkForProducts(String toDusId, lb.a onComplete) {
        y.i(toDusId, "toDusId");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11981(toDusId, onComplete, null), 3, null);
    }

    public final void clearTags() {
        this.allTags.removeAll();
    }

    public final void deleteProduct(int productId, lb.a onDeleted, lb.a onComplete) {
        y.i(onDeleted, "onDeleted");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C11991(productId, onDeleted, onComplete, null), 3, null);
    }

    public final void errorObtainingLocation() {
        MainRepository mainRepository = this.mainRepository;
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        String strO = a0.O(string, "-", "", false, 4, null);
        Cause cause = Cause.ERROR;
        String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.location_cannot_be_resolve);
        y.h(string2, "getString(...)");
        mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
    }

    public final Z17MutableListFlow<String> getAllTags() {
        return this.allTags;
    }

    public final p0 getCheckResponse() {
        return this.checkResponse;
    }

    public final CubaGeoDataSource getCubaGeoDataSource() {
        return this.cubaGeoDataSource;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final p0 getInterested() {
        return this.interested;
    }

    public final p0 getProduct() {
        return this.product;
    }

    public final void getProductInfo(String toDusId, int productId) {
        y.i(toDusId, "toDusId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12001(toDusId, productId, null), 3, null);
    }

    public final Z17MutableListFlow<String> getProductTags() {
        return this.productTags;
    }

    public final p0 getPublicCant() {
        return this.publicCant;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public final void imInterestedIn(int productId) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12021(productId, null), 3, null);
    }

    public final void loadPersonalProducts() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12031(null), 3, null);
    }

    public final void loadProductUrl(int productId, Function1 onResult, lb.a onComplete) {
        y.i(onResult, "onResult");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12041(productId, onResult, onComplete, null), 3, null);
    }

    public final void loadPublicCant() {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12051(null), 3, null);
    }

    public final void loadTags(String toDusId) {
        y.i(toDusId, "toDusId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12061(toDusId, null), 3, null);
    }

    public final te.h myFilteredCatalogue(final String tag, final String filter) {
        y.i(tag, "tag");
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.pagingPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.catalogue.c
            @Override // lb.a
            public final Object invoke() {
                return CatalogueViewModel.myFilteredCatalogue$lambda$0(this.f21576c, tag, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final Owner owner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final void updateProduct(int id2, String createDate, String name, String description, double price, Uri pictureUri, String pictureUrl, boolean isPublic, String province, String municipality, String location, String state, String coinType, lb.a goBack, lb.a onComplete) {
        y.i(createDate, "createDate");
        y.i(name, "name");
        y.i(description, "description");
        y.i(pictureUrl, "pictureUrl");
        y.i(province, "province");
        y.i(municipality, "municipality");
        y.i(location, "location");
        y.i(state, "state");
        y.i(coinType, "coinType");
        y.i(goBack, "goBack");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12071(pictureUri, province, municipality, location, state, coinType, id2, createDate, description, name, price, isPublic, pictureUrl, goBack, onComplete, null), 3, null);
    }

    public CatalogueViewModel(String toDusId) {
        y.i(toDusId, "toDusId");
        this.toDusId = toDusId;
        this.mainRepository = MainRepository.INSTANCE.getInstance();
        this.catalogueRepository = CatalogueRepository.INSTANCE.getInstance();
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.cubaGeoDataSource = new CubaGeoDataSource();
        FlowsState.Companion companion = FlowsState.INSTANCE;
        b0 b0VarA = r0.a(companion.notRequested());
        this._checkResponse = b0VarA;
        this.checkResponse = te.j.b(b0VarA);
        this.pagingPagingConfig = new PagingConfig(5, 5, true, 10, Integer.MAX_VALUE, 0, 32, null);
        this.productTags = new Z17MutableListFlow<>(null, 1, null);
        b0 b0VarA2 = r0.a(companion.notRequested());
        this._product = b0VarA2;
        this.product = te.j.b(b0VarA2);
        b0 b0VarA3 = r0.a(0);
        this._publicCant = b0VarA3;
        this.publicCant = te.j.b(b0VarA3);
        b0 b0VarA4 = r0.a(companion.notRequested());
        this._interested = b0VarA4;
        this.interested = te.j.b(b0VarA4);
        this.allTags = new Z17MutableListFlow<>(null, 1, null);
    }

    public /* synthetic */ CatalogueViewModel(String str, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
