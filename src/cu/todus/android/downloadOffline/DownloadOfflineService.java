package cu.todus.android.downloadOffline;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcu/todus/android/downloadOffline/DownloadOfflineService;", "Landroid/app/Service;", "<init>", "()V", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DownloadOfflineService extends Service {
    public static final int $stable = 8;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        y.i(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return 2;
        }
        Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
        intent2.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 1107296256 : 1073741824);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, "download_offline").setSmallIcon(R.drawable.icon);
        smallIcon.setContentTitle(getString(R.string.app_name));
        smallIcon.setContentText(getString(R.string.downloading_messages));
        Notification notificationBuild = smallIcon.setGroup("cu.todus.android.DOWNLOADING_OFFLINE").setGroupSummary(true).setContentIntent(activity).setAutoCancel(true).setPriority(-2).setTimeoutAfter(1000L).build();
        y.h(notificationBuild, "build(...)");
        startForeground(intent.getIntExtra("download_offline", 98), notificationBuild);
        return 2;
    }
}
