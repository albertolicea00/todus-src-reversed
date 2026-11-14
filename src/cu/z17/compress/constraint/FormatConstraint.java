package cu.z17.compress.constraint;

import android.graphics.Bitmap;
import cu.z17.compress.UtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/z17/compress/constraint/FormatConstraint;", "Lcu/z17/compress/constraint/Constraint;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "<init>", "(Landroid/graphics/Bitmap$CompressFormat;)V", "isSatisfied", "", "imageFile", "Ljava/io/File;", "satisfy", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FormatConstraint implements Constraint {
    private final Bitmap.CompressFormat format;

    public FormatConstraint(Bitmap.CompressFormat format) {
        y.i(format, "format");
        this.format = format;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public boolean isSatisfied(File imageFile) {
        y.i(imageFile, "imageFile");
        return this.format == UtilKt.compressFormat(imageFile);
    }

    @Override // cu.z17.compress.constraint.Constraint
    public File satisfy(File imageFile) {
        y.i(imageFile, "imageFile");
        return UtilKt.overWrite$default(imageFile, UtilKt.loadBitmap(imageFile), this.format, 0, 8, null);
    }
}
