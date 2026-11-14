package cu.z17.compress.constraint;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/z17/compress/constraint/Compression;", "", "<init>", "()V", "Lcu/z17/compress/constraint/Constraint;", "constraint", "Lua/k0;", "(Lcu/z17/compress/constraint/Constraint;)V", "", "constraints", "Ljava/util/List;", "getConstraints$compress_release", "()Ljava/util/List;", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Compression {
    private final List<Constraint> constraints = new ArrayList();

    public final void constraint(Constraint constraint) {
        y.i(constraint, "constraint");
        this.constraints.add(constraint);
    }

    public final List<Constraint> getConstraints$compress_release() {
        return this.constraints;
    }
}
