package cu.todus.android.uiCompose.shared.pagingSource;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cu.todus.android.exceptions.ToDusException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003BA\u00120\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R>\u0010\b\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcu/todus/android/uiCompose/shared/pagingSource/ResultPagingSource;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PagingSource;", "", "Lkotlin/Function3;", "Lab/e;", "", "dataSource", "pageSize", "<init>", "(Lkotlin/jvm/functions/Function3;I)V", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "load", "(Landroidx/paging/PagingSource$LoadParams;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingState;", "state", "getRefreshKey", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "Lkotlin/jvm/functions/Function3;", "I", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ResultPagingSource<T> extends PagingSource<Integer, T> {
    public static final int $stable = 8;
    private final Function3 dataSource;
    private final int pageSize;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.uiCompose.shared.pagingSource.ResultPagingSource", f = "ResultPagingSource.kt", l = {16}, m = "load", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ResultPagingSource<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ResultPagingSource<T> resultPagingSource, e<? super AnonymousClass1> eVar) {
            super(eVar);
            this.this$0 = resultPagingSource;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(null, this);
        }
    }

    public ResultPagingSource(Function3 dataSource, int i10) {
        y.i(dataSource, "dataSource");
        this.dataSource = dataSource;
        this.pageSize = i10;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> loadParams, e<? super PagingSource.LoadResult<Integer, T>> eVar) {
        AnonymousClass1 anonymousClass1;
        int i10;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, eVar);
        }
        Object obj = anonymousClass1.result;
        Object objG = b.g();
        int i12 = anonymousClass1.label;
        try {
            if (i12 == 0) {
                v.b(obj);
                Integer key = loadParams.getKey();
                int iIntValue = key != null ? key.intValue() : 0;
                Function3 function3 = this.dataSource;
                Integer numD = cb.b.d(iIntValue);
                Integer numD2 = cb.b.d(this.pageSize);
                anonymousClass1.L$0 = l.a(loadParams);
                anonymousClass1.I$0 = iIntValue;
                anonymousClass1.label = 1;
                Object objInvoke = function3.invoke(numD, numD2, anonymousClass1);
                if (objInvoke == objG) {
                    return objG;
                }
                int i13 = iIntValue;
                obj = objInvoke;
                i10 = i13;
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = anonymousClass1.I$0;
                v.b(obj);
            }
            List list = (List) obj;
            if (list == null) {
                return new PagingSource.LoadResult.Error(new ToDusException(null, null, false, 7, null));
            }
            Integer numD3 = null;
            Integer numD4 = list.isEmpty() ? null : cb.b.d(this.pageSize + i10);
            if (i10 != 0) {
                numD3 = cb.b.d(i10 - this.pageSize);
            }
            return new PagingSource.LoadResult.Page(list, numD3, numD4);
        } catch (Exception e10) {
            return new PagingSource.LoadResult.Error(e10);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, T> state) {
        Integer nextKey;
        Integer prevKey;
        y.i(state, "state");
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition != null) {
            int iIntValue = anchorPosition.intValue();
            PagingSource.LoadResult.Page<Integer, T> pageClosestPageToPosition = state.closestPageToPosition(iIntValue);
            if (pageClosestPageToPosition != null && (prevKey = pageClosestPageToPosition.getPrevKey()) != null) {
                return Integer.valueOf(prevKey.intValue() + this.pageSize);
            }
            PagingSource.LoadResult.Page<Integer, T> pageClosestPageToPosition2 = state.closestPageToPosition(iIntValue);
            if (pageClosestPageToPosition2 != null && (nextKey = pageClosestPageToPosition2.getNextKey()) != null) {
                return Integer.valueOf(nextKey.intValue() - this.pageSize);
            }
        }
        return null;
    }
}
