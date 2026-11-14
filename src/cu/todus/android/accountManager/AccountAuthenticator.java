package cu.todus.android.accountManager;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.os.BundleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcu/todus/android/accountManager/AccountAuthenticator;", "Landroid/accounts/AbstractAccountAuthenticator;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "addAccount", "Landroid/os/Bundle;", SaslStreamElements.Response.ELEMENT, "Landroid/accounts/AccountAuthenticatorResponse;", "accountType", "", "authTokenType", "requiredFeatures", "", "options", "(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "confirmCredentials", "arg0", "arg1", "Landroid/accounts/Account;", "arg2", "editProperties", "getAuthToken", "account", "getAuthTokenLabel", "hasFeatures", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;[Ljava/lang/String;)Landroid/os/Bundle;", "updateCredentials", "arg3", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AccountAuthenticator extends AbstractAccountAuthenticator {
    public static final int $stable = 8;
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountAuthenticator(Context mContext) {
        super(mContext);
        y.i(mContext, "mContext");
        this.mContext = mContext;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        y.i(response, "response");
        y.i(accountType, "accountType");
        y.i(authTokenType, "authTokenType");
        y.i(requiredFeatures, "requiredFeatures");
        y.i(options, "options");
        return BundleKt.bundleOf();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse arg0, Account arg1, Bundle arg2) throws NetworkErrorException {
        y.i(arg0, "arg0");
        y.i(arg1, "arg1");
        y.i(arg2, "arg2");
        return BundleKt.bundleOf();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse arg0, String arg1) {
        y.i(arg0, "arg0");
        y.i(arg1, "arg1");
        return BundleKt.bundleOf();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        y.i(response, "response");
        y.i(account, "account");
        y.i(authTokenType, "authTokenType");
        y.i(options, "options");
        return BundleKt.bundleOf();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String arg0) {
        y.i(arg0, "arg0");
        return "";
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse arg0, Account arg1, String[] arg2) throws NetworkErrorException {
        y.i(arg0, "arg0");
        y.i(arg1, "arg1");
        y.i(arg2, "arg2");
        return BundleKt.bundleOf();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse arg0, Account arg1, String arg2, Bundle arg3) throws NetworkErrorException {
        y.i(arg0, "arg0");
        y.i(arg1, "arg1");
        y.i(arg2, "arg2");
        y.i(arg3, "arg3");
        return BundleKt.bundleOf();
    }
}
