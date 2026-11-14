package cu.todus.android.repositories;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.spatial.RectListKt;
import androidx.paging.PagingSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.data.db.pojo.StickerGroup;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.db.dao.toDus.StickerDao;
import cu.todus.android.db.dao.toDus.StickerPackDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.rest.sticker.StickerDataSource;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.proto.ApiProto;
import cu.z17.singledi.SingletonInitializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0014¢\u0006\u0004\b\u001a\u0010\u0017J\u0019\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0086@¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcu/todus/android/repositories/StickersRepository;", "", "<init>", "()V", "", "offset", "limit", "", NavLinks.SEARCH, "", "Lcu/todus/android/data/rest/entity/StickerPack;", "getStickersPack", "(IILjava/lang/String;Lab/e;)Ljava/lang/Object;", StickerPack.TABLE_NAME, "Lua/k0;", "saveStickerPackInfo", "(Lcu/todus/android/data/rest/entity/StickerPack;Lab/e;)Ljava/lang/Object;", Sticker.COLUMN_PACK_NAME, "deleteStickerPack", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "getFavoriteStickers", "()Landroidx/paging/PagingSource;", "getRecentStickers", "Lcu/todus/android/data/db/pojo/StickerGroup;", "getStickers", "Lte/h;", "actualStickersDownloaded", "()Lte/h;", "id", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "onChangeStickerFavoriteStatus", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "Lcu/todus/android/rest/sticker/StickerDataSource;", "stickerDataSource", "Lcu/todus/android/rest/sticker/StickerDataSource;", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "stickerPackDao", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "Lcu/todus/android/db/dao/toDus/StickerDao;", "stickerDao", "Lcu/todus/android/db/dao/toDus/StickerDao;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StickersRepository {
    private final StickerDao stickerDao;
    private final StickerDataSource stickerDataSource = RetrofitModule.INSTANCE.getInstance().getStickerDataSource();
    private final StickerPackDao stickerPackDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/StickersRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/StickersRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<StickersRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StickersRepository$getStickersPack$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StickersRepository", f = "StickersRepository.kt", l = {23}, m = "getStickersPack", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StickersRepository.this.getStickersPack(0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.StickersRepository$saveStickerPackInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.StickersRepository", f = "StickersRepository.kt", l = {48, RectListKt.BitOffsetForGesturable}, m = "saveStickerPackInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11481 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11481(ab.e<? super C11481> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StickersRepository.this.saveStickerPackInfo(null, this);
        }
    }

    public StickersRepository() {
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.stickerPackDao = companion.getInstance().getStickerPackDao();
        this.stickerDao = companion.getInstance().getStickerDao();
    }

    public static /* synthetic */ Object getStickersPack$default(StickersRepository stickersRepository, int i10, int i11, String str, ab.e eVar, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str = "";
        }
        return stickersRepository.getStickersPack(i10, i11, str, eVar);
    }

    public final te.h actualStickersDownloaded() {
        return this.stickerPackDao.getStickerIds();
    }

    public final Object deleteStickerPack(String str, ab.e<? super ua.k0> eVar) {
        Object objDeleteById = this.stickerPackDao.deleteById(str, eVar);
        return objDeleteById == bb.b.g() ? objDeleteById : ua.k0.f43947a;
    }

    public final PagingSource<Integer, Sticker> getFavoriteStickers() {
        return this.stickerDao.getFavoriteStickers();
    }

    public final PagingSource<Integer, Sticker> getRecentStickers() {
        return this.stickerDao.getRecentStickers();
    }

    public final PagingSource<Integer, StickerGroup> getStickers() {
        return this.stickerPackDao.getStickerGroups();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object getStickersPack(int i10, int i11, String str, ab.e<? super List<cu.todus.android.data.rest.entity.StickerPack>> eVar) {
        AnonymousClass1 anonymousClass1;
        List<ApiProto.GetPacksResp.Pack> packsList;
        int i12 = i10;
        int i13 = i11;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i14 = anonymousClass1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i14 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objPacks = anonymousClass1.result;
        Object objG = bb.b.g();
        int i15 = anonymousClass1.label;
        if (i15 == 0) {
            ua.v.b(objPacks);
            StickerDataSource stickerDataSource = this.stickerDataSource;
            anonymousClass1.L$0 = cb.l.a(str);
            anonymousClass1.I$0 = i12;
            anonymousClass1.I$1 = i13;
            anonymousClass1.label = 1;
            objPacks = stickerDataSource.packs(i12, i13, str, anonymousClass1);
            if (objPacks == objG) {
                return objG;
            }
        } else {
            if (i15 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i16 = anonymousClass1.I$1;
            int i17 = anonymousClass1.I$0;
            ua.v.b(objPacks);
            i13 = i16;
            i12 = i17;
        }
        DataWrapper dataWrapper = (DataWrapper) objPacks;
        if (dataWrapper.getResponseOkButNull()) {
            return va.w.n();
        }
        ApiProto.GetPacksResp getPacksResp = (ApiProto.GetPacksResp) dataWrapper.getResponseBody();
        if (getPacksResp == null || (packsList = getPacksResp.getPacksList()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(va.x.y(packsList, 10));
        for (ApiProto.GetPacksResp.Pack pack : packsList) {
            String name = pack.getName();
            kotlin.jvm.internal.y.h(name, "getName(...)");
            String title = pack.getTitle();
            kotlin.jvm.internal.y.h(title, "getTitle(...)");
            String thumb = pack.getThumb();
            kotlin.jvm.internal.y.h(thumb, "getThumb(...)");
            arrayList.add(new cu.todus.android.data.rest.entity.StickerPack(name, title, thumb, false, (int) pack.getCount(), i12 + ((ApiProto.GetPacksResp) dataWrapper.getResponseBody()).getPacksCount(), ((ApiProto.GetPacksResp) dataWrapper.getResponseBody()).getPacksCount() == i13, 8, null));
        }
        return arrayList;
    }

    public final Object onChangeStickerFavoriteStatus(String str, boolean z10, ab.e<? super ua.k0> eVar) {
        Object objOnChangeStickerFavoriteStatus = this.stickerDao.onChangeStickerFavoriteStatus(str, z10, eVar);
        return objOnChangeStickerFavoriteStatus == bb.b.g() ? objOnChangeStickerFavoriteStatus : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
    
        if (r1.insert(r9, r2) == r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x010e, code lost:
    
        if (r1.insert(r11, r2) == r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0110, code lost:
    
        return r3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x010e -> B:25:0x0111). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveStickerPackInfo(cu.todus.android.data.rest.entity.StickerPack r20, ab.e<? super ua.k0> r21) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.StickersRepository.saveStickerPackInfo(cu.todus.android.data.rest.entity.StickerPack, ab.e):java.lang.Object");
    }
}
