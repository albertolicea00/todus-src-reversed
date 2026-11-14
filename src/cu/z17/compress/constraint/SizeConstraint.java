package cu.z17.compress.constraint;

import cu.z17.compress.UtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcu/z17/compress/constraint/SizeConstraint;", "Lcu/z17/compress/constraint/Constraint;", "maxFileSize", "", "stepSize", "", "maxIteration", "minQuality", "<init>", "(JIII)V", "iteration", "isSatisfied", "", "imageFile", "Ljava/io/File;", "satisfy", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SizeConstraint implements Constraint {
    private int iteration;
    private final long maxFileSize;
    private final int maxIteration;
    private final int minQuality;
    private final int stepSize;

    public SizeConstraint(long j10, int i10, int i11, int i12) {
        this.maxFileSize = j10;
        this.stepSize = i10;
        this.maxIteration = i11;
        this.minQuality = i12;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public boolean isSatisfied(File imageFile) {
        y.i(imageFile, "imageFile");
        return imageFile.length() <= this.maxFileSize || this.iteration >= this.maxIteration;
    }

    @Override // cu.z17.compress.constraint.Constraint
    public File satisfy(File imageFile) {
        y.i(imageFile, "imageFile");
        int i10 = this.iteration + 1;
        this.iteration = i10;
        Integer numValueOf = Integer.valueOf(100 - (i10 * this.stepSize));
        int iIntValue = numValueOf.intValue();
        int iIntValue2 = this.minQuality;
        if (iIntValue < iIntValue2) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue2 = numValueOf.intValue();
        }
        return UtilKt.overWrite$default(imageFile, UtilKt.loadBitmap(imageFile), null, iIntValue2, 4, null);
    }

    public /* synthetic */ SizeConstraint(long j10, int i10, int i11, int i12, int i13, p pVar) {
        this(j10, i10, i11, (i13 & 8) != 0 ? 20 : i12);
    }
}
