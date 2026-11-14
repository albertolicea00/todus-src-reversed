package cu.todus.android.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.repositories.MainRepository;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcu/todus/android/notification/CancelTransferReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lua/k0;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CancelTransferReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws SinglediException {
        String stringExtra;
        y.i(context, "context");
        y.i(intent, "intent");
        if (!y.d(intent.getAction(), "CANCEL_TRANSFER") || (stringExtra = intent.getStringExtra("ATT_ID")) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("IS_UPLOAD", false);
        MainRepository singletonInitializer = MainRepository.INSTANCE.getInstance();
        if (!booleanExtra) {
            singletonInitializer.getDownloadDataSource().cancelDownload(stringExtra);
            return;
        }
        String stringExtra2 = intent.getStringExtra("MSG_ID");
        if (stringExtra2 == null) {
            return;
        }
        singletonInitializer.getUploadDataSource().cancelUpload(stringExtra2);
    }
}
