package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/rest/request/VerifyPhoneNumberRequest;", "", "username", "", "clientToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class VerifyPhoneNumberRequest {
    public static final int $stable = 0;

    @c("clientToken")
    private final String clientToken;

    @c("username")
    private final String username;

    public VerifyPhoneNumberRequest(String username, String clientToken) {
        y.i(username, "username");
        y.i(clientToken, "clientToken");
        this.username = username;
        this.clientToken = clientToken;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getClientToken() {
        return this.clientToken;
    }

    public static /* synthetic */ VerifyPhoneNumberRequest copy$default(VerifyPhoneNumberRequest verifyPhoneNumberRequest, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = verifyPhoneNumberRequest.username;
        }
        if ((i10 & 2) != 0) {
            str2 = verifyPhoneNumberRequest.clientToken;
        }
        return verifyPhoneNumberRequest.copy(str, str2);
    }

    public final VerifyPhoneNumberRequest copy(String username, String clientToken) {
        y.i(username, "username");
        y.i(clientToken, "clientToken");
        return new VerifyPhoneNumberRequest(username, clientToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifyPhoneNumberRequest)) {
            return false;
        }
        VerifyPhoneNumberRequest verifyPhoneNumberRequest = (VerifyPhoneNumberRequest) other;
        return y.d(this.username, verifyPhoneNumberRequest.username) && y.d(this.clientToken, verifyPhoneNumberRequest.clientToken);
    }

    public int hashCode() {
        return (this.username.hashCode() * 31) + this.clientToken.hashCode();
    }

    public String toString() {
        return "VerifyPhoneNumberRequest(username=" + this.username + ", clientToken=" + this.clientToken + ")";
    }
}
