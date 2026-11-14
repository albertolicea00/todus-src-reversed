package cu.z17.views.imageEditor.sections.cropper.components.util;

import androidx.compose.ui.geometry.Offset;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import rb.c;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "Lrb/c;", "", "horizontalRange", "verticalRange", "coerceIn-9KIMszo", "(JLrb/c;Lrb/c;)J", "coerceIn", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OffsetUtilKt {
    /* JADX INFO: renamed from: coerceIn-9KIMszo, reason: not valid java name */
    public static final long m10234coerceIn9KIMszo(long j10, c horizontalRange, c verticalRange) {
        y.i(horizontalRange, "horizontalRange");
        y.i(verticalRange, "verticalRange");
        float fFloatValue = ((Number) k.t(Float.valueOf(Float.intBitsToFloat((int) (j10 >> 32))), horizontalRange)).floatValue();
        float fFloatValue2 = ((Number) k.t(Float.valueOf(Float.intBitsToFloat((int) (j10 & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), verticalRange)).floatValue();
        return Offset.m5618constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(fFloatValue2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }
}
