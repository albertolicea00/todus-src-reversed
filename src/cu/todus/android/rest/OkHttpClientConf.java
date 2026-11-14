package cu.todus.android.rest;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import nf.c0;
import nf.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/todus/android/rest/OkHttpClientConf;", "", "<init>", "()V", "Lnf/z;", "networkInterceptor", "Lnf/c0;", "genClient", "(Lnf/z;)Lnf/c0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OkHttpClientConf {
    public static final int $stable = 0;
    public static final OkHttpClientConf INSTANCE = new OkHttpClientConf();

    private OkHttpClientConf() {
    }

    public final c0 genClient(z networkInterceptor) {
        y.i(networkInterceptor, "networkInterceptor");
        eg.a aVar = new eg.a(null, 1, null);
        aVar.d(eg.a.b.BODY);
        c0.a aVarB = new c0.a().a(aVar).b(networkInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVarB.e(15L, timeUnit).R(15L, timeUnit).N(15L, timeUnit).d();
    }
}
