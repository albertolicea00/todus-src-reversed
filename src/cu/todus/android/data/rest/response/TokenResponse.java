package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/data/rest/response/TokenResponse;", "", "token", "", "expire", "", "<init>", "(Ljava/lang/String;J)V", "getToken", "()Ljava/lang/String;", "getExpire", "()J", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TokenResponse {
    public static final int $stable = 0;
    private final long expire;
    private final String token;

    public TokenResponse(String token, long j10) {
        y.i(token, "token");
        this.token = token;
        this.expire = j10;
    }

    public final long getExpire() {
        return this.expire;
    }

    public final String getToken() {
        return this.token;
    }
}
