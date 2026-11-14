package cu.z17.views.imageEditor.sections.cropper.components.util;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a!\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"getScaledBitmapRect", "Landroidx/compose/ui/unit/IntRect;", "boxWidth", "", "boxHeight", "imageWidth", "", "imageHeight", "bitmapWidth", "bitmapHeight", "getParentSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;II)J", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageContentScaleUtilKt {
    public static final long getParentSize(BoxWithConstraintsScope boxWithConstraintsScope, int i10, int i11) {
        y.i(boxWithConstraintsScope, "<this>");
        boolean z10 = false;
        boolean z11 = Constraints.m8784getHasBoundedWidthimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()) && Constraints.m8783getHasBoundedHeightimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk());
        if (Constraints.m8786getHasFixedWidthimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()) && Constraints.m8785getHasFixedHeightimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk())) {
            z10 = true;
        }
        return IntSize.m8985constructorimpl((((long) ((z11 || z10) ? Constraints.m8788getMaxWidthimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()) : k.e(Constraints.m8790getMinWidthimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()), i10))) << 32) | (((long) ((z11 || z10) ? Constraints.m8787getMaxHeightimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()) : k.e(Constraints.m8789getMinHeightimpl(boxWithConstraintsScope.mo1633getConstraintsmsEJaDk()), i11))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    public static final IntRect getScaledBitmapRect(int i10, int i11, float f10, float f11, int i12, int i13) {
        float f12 = i10;
        float f13 = f12 / f10;
        float f14 = i11;
        float f15 = i12;
        float f16 = ((f10 - f12) * f15) / f10;
        float f17 = 2;
        float f18 = i13;
        return IntRectKt.m8980IntRectVbeCjmY(IntOffset.m8941constructorimpl((((long) ((int) k.d(f16 / f17, 0.0f))) << 32) | (((long) ((int) k.d((((f11 - f14) * f18) / f11) / f17, 0.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), IntSize.m8985constructorimpl((((long) k.j((int) (f18 * (f14 / f11)), i13)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) k.j((int) (f15 * f13), i12)) << 32)));
    }
}
