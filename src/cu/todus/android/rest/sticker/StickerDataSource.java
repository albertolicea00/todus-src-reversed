package cu.todus.android.rest.sticker;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import bb.b;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.proto.ApiProto;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import mi.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcu/todus/android/rest/sticker/StickerDataSource;", "", "Lcu/todus/android/rest/sticker/StickerService;", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/BaseDataSource;", "baseDataSource", "<init>", "(Lcu/todus/android/rest/sticker/StickerService;Lcu/todus/android/rest/BaseDataSource;)V", "", "offset", "limit", "", NavLinks.SEARCH, "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/proto/ApiProto$GetPacksResp;", "packs", "(IILjava/lang/String;Lab/e;)Ljava/lang/Object;", Sticker.COLUMN_PACK_NAME, "Lcu/todus/proto/ApiProto$GetPackInfoResp;", "packInfo", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/sticker/StickerService;", "Lcu/todus/android/rest/BaseDataSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StickerDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final StickerService service;

    /* JADX INFO: renamed from: cu.todus.android.rest.sticker.StickerDataSource$packInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.sticker.StickerDataSource$packInfo$2", f = "StickerDataSource.kt", l = {17}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function1 {
        final /* synthetic */ String $packName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$packName = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return StickerDataSource.this.new AnonymousClass2(this.$packName, eVar);
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
            StickerService stickerService = StickerDataSource.this.service;
            String str = this.$packName;
            this.label = 1;
            Object objPackInfo = stickerService.packInfo(str, this);
            return objPackInfo == objG ? objG : objPackInfo;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.rest.sticker.StickerDataSource$packs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.rest.sticker.StickerDataSource$packs$2", f = "StickerDataSource.kt", l = {13}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lmi/a0;", "<anonymous>", "()Lmi/a0;"}, k = 3, mv = {2, 3, 0})
    public static final class C11722 extends m implements Function1 {
        final /* synthetic */ int $limit;
        final /* synthetic */ int $offset;
        final /* synthetic */ String $search;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11722(int i10, int i11, String str, e<? super C11722> eVar) {
            super(1, eVar);
            this.$offset = i10;
            this.$limit = i11;
            this.$search = str;
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return StickerDataSource.this.new C11722(this.$offset, this.$limit, this.$search, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super a0<?>> eVar) {
            return ((C11722) create(eVar)).invokeSuspend(k0.f43947a);
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
            StickerService stickerService = StickerDataSource.this.service;
            int i11 = this.$offset;
            int i12 = this.$limit;
            String str = this.$search;
            this.label = 1;
            Object objPacks = stickerService.packs(i11, i12, str, this);
            return objPacks == objG ? objG : objPacks;
        }
    }

    public StickerDataSource(StickerService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }

    public static /* synthetic */ Object packs$default(StickerDataSource stickerDataSource, int i10, int i11, String str, e eVar, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str = "";
        }
        return stickerDataSource.packs(i10, i11, str, eVar);
    }

    public final Object packInfo(String str, e<? super DataWrapper<ApiProto.GetPackInfoResp>> eVar) {
        return this.baseDataSource.handleFlowRequest(new AnonymousClass2(str, null), eVar);
    }

    public final Object packs(int i10, int i11, String str, e<? super DataWrapper<ApiProto.GetPacksResp>> eVar) {
        return this.baseDataSource.handleFlowRequest(new C11722(i10, i11, str, null), eVar);
    }
}
