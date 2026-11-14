package cu.todus.android.uiCompose.main.screen.statusPreview;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import cu.todus.android.data.db.pojo.StatusForPagination;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.repositories.StatusRepository;
import cu.z17.singledi.SinglediException;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/StatusPreviewPagingSource;", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StatusForPagination;", "", "first", "<init>", "(Ljava/lang/String;)V", "key", "ensureValidKey", "(I)I", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "load", "(Landroidx/paging/PagingSource$LoadParams;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "getRefreshKey", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "Ljava/lang/String;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusPreviewPagingSource extends PagingSource<Integer, StatusForPagination> {
    public static final int STARTING_KEY = 0;
    private final String first;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewPagingSource$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.statusPreview.StatusPreviewPagingSource", f = "StatusPreviewPagingSource.kt", l = {19}, m = "load", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
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
            return StatusPreviewPagingSource.this.load(null, this);
        }
    }

    public StatusPreviewPagingSource(String first) {
        kotlin.jvm.internal.y.i(first, "first");
        this.first = first;
    }

    private final int ensureValidKey(int key) {
        return Math.max(0, key);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> loadParams, ab.e<? super PagingSource.LoadResult<Integer, StatusForPagination>> eVar) throws SinglediException {
        AnonymousClass1 anonymousClass1;
        PagingSource.LoadParams<Integer> loadParams2;
        int i10;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object obj = anonymousClass1.result;
        Object objG = bb.b.g();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            ua.v.b(obj);
            Integer key = loadParams.getKey();
            int iIntValue = key != null ? key.intValue() : 0;
            StatusRepository singletonInitializer = StatusRepository.INSTANCE.getInstance();
            String str = this.first;
            int loadSize = loadParams.getLoadSize();
            anonymousClass1.L$0 = loadParams;
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.label = 1;
            Object statusPaginated = singletonInitializer.getStatusPaginated(str, iIntValue, loadSize, anonymousClass1);
            if (statusPaginated == objG) {
                return objG;
            }
            loadParams2 = loadParams;
            i10 = iIntValue;
            obj = statusPaginated;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = anonymousClass1.I$0;
            loadParams2 = (PagingSource.LoadParams) anonymousClass1.L$0;
            ua.v.b(obj);
        }
        List list = (List) obj;
        if (list == null) {
            return new PagingSource.LoadResult.Error(new ToDusException(null, null, false, 7, null));
        }
        StatusForPagination statusForPagination = (StatusForPagination) va.g0.K0(list);
        Integer numD = null;
        Integer numD2 = (statusForPagination != null ? cb.b.d(statusForPagination.getIndex()) : null) == null ? null : cb.b.d(((StatusForPagination) va.g0.I0(list)).getIndex() + 1);
        if (i10 != 0) {
            StatusForPagination statusForPagination2 = (StatusForPagination) va.g0.y0(list);
            numD = cb.b.d(ensureValidKey((statusForPagination2 != null ? statusForPagination2.getIndex() : 0) - loadParams2.getLoadSize()));
        }
        return new PagingSource.LoadResult.Page(list, numD, numD2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, StatusForPagination> state) {
        StatusForPagination statusForPaginationClosestItemToPosition;
        kotlin.jvm.internal.y.i(state, "state");
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null || (statusForPaginationClosestItemToPosition = state.closestItemToPosition(anchorPosition.intValue())) == null) {
            return null;
        }
        return Integer.valueOf(ensureValidKey(statusForPaginationClosestItemToPosition.getIndex() - (state.getConfig().pageSize / 2)));
    }
}
