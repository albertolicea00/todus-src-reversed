package cu.todus.android.accountManager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/accountManager/AccountUtils;", "", "<init>", "()V", "ACCOUNT_TYPE", "", "AUTH_TOKEN_TYPE", "getAccount", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "accountName", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AccountUtils {
    public static final int $stable = 0;
    public static final String ACCOUNT_TYPE = "cu.todus.android";
    public static final String AUTH_TOKEN_TYPE = "cu.todus.android.token";
    public static final AccountUtils INSTANCE = new AccountUtils();

    private AccountUtils() {
    }

    public final Account getAccount(Context context, String accountName) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("cu.todus.android");
        y.h(accountsByType, "getAccountsByType(...)");
        for (Account account : accountsByType) {
            if (a0.G(account.name, accountName, true)) {
                return account;
            }
        }
        return null;
    }
}
