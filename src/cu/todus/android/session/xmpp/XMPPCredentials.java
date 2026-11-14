package cu.todus.android.session.xmpp;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.session.store.Credentials;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcu/todus/android/session/xmpp/XMPPCredentials;", "Lcu/todus/android/session/store/Credentials;", "username", "", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getPassword", "setPassword", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XMPPCredentials extends Credentials {
    public static final int $stable = 8;
    private String password;
    private String username;

    public XMPPCredentials(String username, String password) {
        y.i(username, "username");
        y.i(password, "password");
        this.username = username;
        this.password = password;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setPassword(String str) {
        y.i(str, "<set-?>");
        this.password = str;
    }

    public final void setUsername(String str) {
        y.i(str, "<set-?>");
        this.username = str;
    }
}
