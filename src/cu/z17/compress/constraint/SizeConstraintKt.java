package cu.z17.compress.constraint;

import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/z17/compress/constraint/Compression;", "", "maxFileSize", "", "stepSize", "maxIteration", "Lua/k0;", "size", "(Lcu/z17/compress/constraint/Compression;JII)V", "compress_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SizeConstraintKt {
    public static final void size(Compression compression, long j10, int i10, int i11) {
        y.i(compression, "<this>");
        compression.constraint(new SizeConstraint(j10, i10, i11, 0, 8, null));
    }
}
