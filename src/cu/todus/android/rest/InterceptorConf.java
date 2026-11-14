package cu.todus.android.rest;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import nf.g0;
import nf.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/rest/InterceptorConf;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lnf/z;", "genInterceptor", "(Landroid/content/Context;)Lnf/z;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InterceptorConf {
    public static final int $stable = 0;
    public static final InterceptorConf INSTANCE = new InterceptorConf();

    private InterceptorConf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g0 genInterceptor$lambda$0(z.a chain) {
        y.i(chain, "chain");
        return chain.a(chain.b());
    }

    public final z genInterceptor(Context context) {
        y.i(context, "context");
        return new z() { // from class: cu.todus.android.rest.a
            @Override // nf.z
            public final g0 a(z.a aVar) {
                return InterceptorConf.genInterceptor$lambda$0(aVar);
            }
        };
    }
}
