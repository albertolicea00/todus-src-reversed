package cu.z17.compress.constraint;

import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcu/z17/compress/constraint/Compression;", "", "width", "height", "Lua/k0;", "resolution", "(Lcu/z17/compress/constraint/Compression;II)V", "compress_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ResolutionConstraintKt {
    public static final void resolution(Compression compression, int i10, int i11) {
        y.i(compression, "<this>");
        compression.constraint(new ResolutionConstraint(i10, i11));
    }
}
