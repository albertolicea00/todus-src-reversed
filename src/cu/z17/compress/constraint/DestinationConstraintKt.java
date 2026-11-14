package cu.z17.compress.constraint;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/z17/compress/constraint/Compression;", "Ljava/io/File;", "destination", "Lua/k0;", "(Lcu/z17/compress/constraint/Compression;Ljava/io/File;)V", "compress_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DestinationConstraintKt {
    public static final void destination(Compression compression, File destination) {
        y.i(compression, "<this>");
        y.i(destination, "destination");
        compression.constraint(new DestinationConstraint(destination));
    }
}
