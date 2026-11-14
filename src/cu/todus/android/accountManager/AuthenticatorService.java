package cu.todus.android.accountManager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcu/todus/android/accountManager/AuthenticatorService;", "Landroid/app/Service;", "<init>", "()V", "sAccountAuthenticator", "Lcu/todus/android/accountManager/AccountAuthenticator;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "authenticator", "getAuthenticator", "()Lcu/todus/android/accountManager/AccountAuthenticator;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuthenticatorService extends Service {
    public static final int $stable = 8;
    private AccountAuthenticator sAccountAuthenticator;

    private final AccountAuthenticator getAuthenticator() {
        if (this.sAccountAuthenticator == null) {
            this.sAccountAuthenticator = new AccountAuthenticator(this);
        }
        return this.sAccountAuthenticator;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        y.i(intent, "intent");
        if (!y.d(intent.getAction(), "android.accounts.AccountAuthenticator")) {
            return null;
        }
        AccountAuthenticator authenticator = getAuthenticator();
        y.f(authenticator);
        return authenticator.getIBinder();
    }
}
