package cu.z17.views.imageEditor.sections.cropper.components.util;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;
import rb.b;
import rb.j;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aA\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u000f\u001a%\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"", TtmlNode.START, "stop", "fraction", "lerp", "(FFF)F", "start1", "end1", "pos", "start2", "end2", "scale", "(FFFFF)F", "Lrb/b;", ValidateElement.RangeValidateElement.METHOD, "(FFLrb/b;FF)Lrb/b;", TtmlNode.END, "calculateFraction", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DimensionUtilKt {
    public static final float calculateFraction(float f10, float f11, float f12) {
        float f13 = f11 - f10;
        return k.n(f13 == 0.0f ? 0.0f : (f12 - f10) / f13, 0.0f, 1.0f);
    }

    public static final float lerp(float f10, float f11, float f12) {
        return ((1 - f12) * f10) + (f12 * f11);
    }

    public static final float scale(float f10, float f11, float f12, float f13, float f14) {
        return lerp(f13, f14, calculateFraction(f10, f11, f12));
    }

    public static final b scale(float f10, float f11, b range, float f12, float f13) {
        y.i(range, "range");
        return j.b(scale(f10, f11, ((Number) range.getStart()).floatValue(), f12, f13), scale(f10, f11, ((Number) range.getEndInclusive()).floatValue(), f12, f13));
    }
}
