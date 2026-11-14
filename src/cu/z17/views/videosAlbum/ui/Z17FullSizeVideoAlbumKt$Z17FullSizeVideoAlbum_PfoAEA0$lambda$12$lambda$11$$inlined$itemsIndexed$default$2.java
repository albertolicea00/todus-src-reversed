package cu.z17.views.videosAlbum.ui;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.e0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J", "androidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
public final class Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$2 extends e0 implements Function2 {
    final /* synthetic */ List $items;
    final /* synthetic */ Function3 $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17FullSizeVideoAlbumKt$Z17FullSizeVideoAlbum_PfoAEA0$lambda$12$lambda$11$$inlined$itemsIndexed$default$2(Function3 function3, List list) {
        super(2);
        this.$span = function3;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.m1837boximpl(m10327invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }

    /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
    public final long m10327invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i10) {
        return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i10), this.$items.get(i10))).getPackedValue();
    }
}
