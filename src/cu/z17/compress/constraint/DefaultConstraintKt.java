package cu.z17.compress.constraint;

import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcu/z17/compress/constraint/Compression;", "", "width", "height", "Landroid/graphics/Bitmap$CompressFormat;", "format", "quality", "Lua/k0;", "default", "(Lcu/z17/compress/constraint/Compression;IILandroid/graphics/Bitmap$CompressFormat;I)V", "compress_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DefaultConstraintKt {
    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final void m10130default(Compression compression, int i10, int i11, Bitmap.CompressFormat format, int i12) {
        y.i(compression, "<this>");
        y.i(format, "format");
        compression.constraint(new DefaultConstraint(i10, i11, format, i12));
    }

    public static /* synthetic */ void default$default(Compression compression, int i10, int i11, Bitmap.CompressFormat compressFormat, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
        }
        if ((i13 & 2) != 0) {
            i11 = 816;
        }
        if ((i13 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if ((i13 & 8) != 0) {
            i12 = 80;
        }
        m10130default(compression, i10, i11, compressFormat, i12);
    }
}
