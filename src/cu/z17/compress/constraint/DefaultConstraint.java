package cu.z17.compress.constraint;

import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.z17.compress.UtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcu/z17/compress/constraint/DefaultConstraint;", "Lcu/z17/compress/constraint/Constraint;", "width", "", "height", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "<init>", "(IILandroid/graphics/Bitmap$CompressFormat;I)V", "isResolved", "", "isSatisfied", "imageFile", "Ljava/io/File;", "satisfy", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultConstraint implements Constraint {
    private final Bitmap.CompressFormat format;
    private final int height;
    private boolean isResolved;
    private final int quality;
    private final int width;

    public DefaultConstraint() {
        this(0, 0, null, 0, 15, null);
    }

    @Override // cu.z17.compress.constraint.Constraint
    public boolean isSatisfied(File imageFile) {
        y.i(imageFile, "imageFile");
        return this.isResolved;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public File satisfy(File imageFile) throws Throwable {
        y.i(imageFile, "imageFile");
        File fileOverWrite = UtilKt.overWrite(imageFile, UtilKt.determineImageRotation$default(imageFile, UtilKt.decodeSampledBitmapFromFile(imageFile, this.width, this.height), 0, 0, 12, null), this.format, this.quality);
        this.isResolved = true;
        return fileOverWrite;
    }

    public DefaultConstraint(int i10, int i11, Bitmap.CompressFormat format, int i12) {
        y.i(format, "format");
        this.width = i10;
        this.height = i11;
        this.format = format;
        this.quality = i12;
    }

    public /* synthetic */ DefaultConstraint(int i10, int i11, Bitmap.CompressFormat compressFormat, int i12, int i13, p pVar) {
        this((i13 & 1) != 0 ? TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID : i10, (i13 & 2) != 0 ? 816 : i11, (i13 & 4) != 0 ? Bitmap.CompressFormat.JPEG : compressFormat, (i13 & 8) != 0 ? 80 : i12);
    }
}
