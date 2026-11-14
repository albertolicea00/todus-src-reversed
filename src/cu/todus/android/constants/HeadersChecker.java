package cu.todus.android.constants;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/constants/HeadersChecker;", "", "<init>", "()V", "needHeaders", "", "url", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadersChecker {
    public static final int $stable = 0;
    public static final HeadersChecker INSTANCE = new HeadersChecker();

    private HeadersChecker() {
    }

    public final boolean needHeaders(String url) {
        y.i(url, "url");
        return (d0.a0(url, "s3.todus.cu/official", false, 2, null) || d0.a0(url, "s3.todus.cu/catalog", false, 2, null) || d0.a0(url, "s3.todus.cu/videodown", false, 2, null) || d0.a0(url, "s3.todus.cu/status", false, 2, null) || d0.a0(url, "s3.todus.cu/stream", false, 2, null)) ? false : true;
    }
}
