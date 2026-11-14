package cu.z17.compress.constraint;

import cu.z17.compress.UtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/z17/compress/constraint/QualityConstraint;", "Lcu/z17/compress/constraint/Constraint;", "quality", "", "<init>", "(I)V", "isResolved", "", "isSatisfied", "imageFile", "Ljava/io/File;", "satisfy", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QualityConstraint implements Constraint {
    private boolean isResolved;
    private final int quality;

    public QualityConstraint(int i10) {
        this.quality = i10;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public boolean isSatisfied(File imageFile) {
        y.i(imageFile, "imageFile");
        return this.isResolved;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public File satisfy(File imageFile) {
        y.i(imageFile, "imageFile");
        File fileOverWrite$default = UtilKt.overWrite$default(imageFile, UtilKt.loadBitmap(imageFile), null, this.quality, 4, null);
        this.isResolved = true;
        return fileOverWrite$default;
    }
}
