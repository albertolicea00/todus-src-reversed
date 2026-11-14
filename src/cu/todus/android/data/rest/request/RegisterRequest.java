package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcu/todus/android/data/rest/request/RegisterRequest;", "", "username", "", "name", "clientToken", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RegisterRequest {
    public static final int $stable = 0;

    @c("clientToken")
    private final String clientToken;

    @c("code")
    private final String code;

    @c("name")
    private final String name;

    @c("username")
    private final String username;

    public RegisterRequest(String username, String name, String clientToken, String code) {
        y.i(username, "username");
        y.i(name, "name");
        y.i(clientToken, "clientToken");
        y.i(code, "code");
        this.username = username;
        this.name = name;
        this.clientToken = clientToken;
        this.code = code;
    }
}
