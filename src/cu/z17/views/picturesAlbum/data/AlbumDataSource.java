package cu.z17.views.picturesAlbum.data;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012.\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u0004\u0018\u00010\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R<\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/z17/views/picturesAlbum/data/AlbumDataSource;", "Landroidx/paging/PagingSource;", "", "Lcu/z17/views/picturesAlbum/data/AlbumImage;", "Lkotlin/Function3;", "Lab/e;", "", "", "onFetch", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Landroidx/paging/PagingState;", "state", "getRefreshKey", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "load", "(Landroidx/paging/PagingSource$LoadParams;Lab/e;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlbumDataSource extends PagingSource<Integer, AlbumImage> {
    public static final int $stable = 8;
    private final Function3 onFetch;

    /* JADX INFO: renamed from: cu.z17.views.picturesAlbum.data.AlbumDataSource$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.z17.views.picturesAlbum.data.AlbumDataSource", f = "AlbumDataSource.kt", l = {22}, m = "load")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumDataSource.this.load(null, this);
        }
    }

    public AlbumDataSource(Function3 onFetch) {
        y.i(onFetch, "onFetch");
        this.onFetch = onFetch;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> loadParams, e<? super PagingSource.LoadResult<Integer, AlbumImage>> eVar) {
        AnonymousClass1 anonymousClass1;
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
        Object objG = b.g();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            v.b(obj);
            Integer key = loadParams.getKey();
            int iIntValue = key != null ? key.intValue() : 0;
            int loadSize = loadParams.getLoadSize();
            Function3 function3 = this.onFetch;
            Integer numD = cb.b.d(loadSize);
            Integer numD2 = cb.b.d(iIntValue * loadSize);
            anonymousClass1.L$0 = l.a(loadParams);
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.I$1 = loadSize;
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
        return new PagingSource.LoadResult.Page(list, i10 > 0 ? cb.b.d(i10 - 1) : null, list.isEmpty() ? null : cb.b.d(i10 + 1));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, AlbumImage> state) {
        Integer nextKey;
        Integer prevKey;
        y.i(state, "state");
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition != null) {
            int iIntValue = anchorPosition.intValue();
            PagingSource.LoadResult.Page<Integer, AlbumImage> pageClosestPageToPosition = state.closestPageToPosition(iIntValue);
            if (pageClosestPageToPosition != null && (prevKey = pageClosestPageToPosition.getPrevKey()) != null) {
                return Integer.valueOf(prevKey.intValue() + 1);
            }
            PagingSource.LoadResult.Page<Integer, AlbumImage> pageClosestPageToPosition2 = state.closestPageToPosition(iIntValue);
            if (pageClosestPageToPosition2 != null && (nextKey = pageClosestPageToPosition2.getNextKey()) != null) {
                return Integer.valueOf(nextKey.intValue() - 1);
            }
        }
        return null;
    }
}
