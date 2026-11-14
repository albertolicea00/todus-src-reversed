package cu.todus.android.uiCompose.main.screen.manageStickers;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.di.MainModule;
import cu.todus.android.repositories.StickersRepository;
import cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/manageStickers/ManageStickersViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "s", "Lua/k0;", "setNewFilterValue", "(Ljava/lang/String;)V", "filter", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/rest/entity/StickerPack;", "stickers", "(Ljava/lang/String;)Lte/h;", StickerPack.TABLE_NAME, "saveStickerPack", "(Lcu/todus/android/data/rest/entity/StickerPack;)V", "deleteStickerPack", "Lcu/todus/android/repositories/StickersRepository;", "stickersRepository", "Lcu/todus/android/repositories/StickersRepository;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "", "actualDownloaded", "Lte/h;", "getActualDownloaded", "()Lte/h;", "Lte/b0;", "_filterValue", "Lte/b0;", "Lte/p0;", "filterValue", "Lte/p0;", "getFilterValue", "()Lte/p0;", "Landroidx/paging/PagingConfig;", "stickersPagingConfig", "Landroidx/paging/PagingConfig;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ManageStickersViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _filterValue;
    private final te.h actualDownloaded;
    private final p0 filterValue;
    private final v5.f gson;
    private final PagingConfig stickersPagingConfig;
    private final StickersRepository stickersRepository;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersViewModel$deleteStickerPack$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersViewModel$deleteStickerPack$1", f = "ManageStickersViewModel.kt", l = {60}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ cu.todus.android.data.rest.entity.StickerPack $stickerPack;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(cu.todus.android.data.rest.entity.StickerPack stickerPack, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$stickerPack = stickerPack;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ManageStickersViewModel.this.new AnonymousClass1(this.$stickerPack, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StickersRepository stickersRepository = ManageStickersViewModel.this.stickersRepository;
                String name = this.$stickerPack.getName();
                this.label = 1;
                if (stickersRepository.deleteStickerPack(name, this) == objG) {
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

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersViewModel$saveStickerPack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.manageStickers.ManageStickersViewModel$saveStickerPack$1", f = "ManageStickersViewModel.kt", l = {54}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12941 extends cb.m implements Function1 {
        final /* synthetic */ cu.todus.android.data.rest.entity.StickerPack $stickerPack;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12941(cu.todus.android.data.rest.entity.StickerPack stickerPack, ab.e<? super C12941> eVar) {
            super(1, eVar);
            this.$stickerPack = stickerPack;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ManageStickersViewModel.this.new C12941(this.$stickerPack, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12941) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StickersRepository stickersRepository = ManageStickersViewModel.this.stickersRepository;
                cu.todus.android.data.rest.entity.StickerPack stickerPack = this.$stickerPack;
                this.label = 1;
                if (stickersRepository.saveStickerPackInfo(stickerPack, this) == objG) {
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

    public ManageStickersViewModel() throws SinglediException {
        StickersRepository singletonInitializer = StickersRepository.INSTANCE.getInstance();
        this.stickersRepository = singletonInitializer;
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.actualDownloaded = singletonInitializer.actualStickersDownloaded();
        b0 b0VarA = r0.a("");
        this._filterValue = b0VarA;
        this.filterValue = te.j.b(b0VarA);
        this.stickersPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource stickers$lambda$0(ManageStickersViewModel manageStickersViewModel, String str) {
        return new ResultPagingSource(new ManageStickersViewModel$stickers$1$pagingSource$1(manageStickersViewModel, str, null), manageStickersViewModel.stickersPagingConfig.pageSize);
    }

    public final void deleteStickerPack(cu.todus.android.data.rest.entity.StickerPack stickerPack) {
        y.i(stickerPack, "stickerPack");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(stickerPack, null), 3, null);
    }

    public final te.h getActualDownloaded() {
        return this.actualDownloaded;
    }

    public final p0 getFilterValue() {
        return this.filterValue;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final void saveStickerPack(cu.todus.android.data.rest.entity.StickerPack stickerPack) {
        y.i(stickerPack, "stickerPack");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12941(stickerPack, null), 3, null);
    }

    public final void setNewFilterValue(String s10) {
        y.i(s10, "s");
        this._filterValue.setValue(s10);
    }

    public final te.h stickers(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.stickersPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.manageStickers.o
            @Override // lb.a
            public final Object invoke() {
                return ManageStickersViewModel.stickers$lambda$0(this.f26617c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }
}
