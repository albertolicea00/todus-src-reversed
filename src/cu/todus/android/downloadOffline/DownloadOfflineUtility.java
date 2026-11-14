package cu.todus.android.downloadOffline;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import cu.todus.android.R;
import cu.todus.android.utils.ExtensionFunsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcu/todus/android/downloadOffline/DownloadOfflineUtility;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lua/k0;", "startService", "(Landroid/content/Context;)V", "stopService", "createNotificationChannel", "", "DOWNLOAD_OFFLINE_FOREGROUND_SERVICE_NOTIFICATION_ID", "Ljava/lang/String;", "DOWNLOAD_OFFLINE_CHANNEL_ID", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DownloadOfflineUtility {
    public static final int $stable = 0;
    public static final String DOWNLOAD_OFFLINE_CHANNEL_ID = "download_offline";
    public static final String DOWNLOAD_OFFLINE_FOREGROUND_SERVICE_NOTIFICATION_ID = "download_offline";
    public static final DownloadOfflineUtility INSTANCE = new DownloadOfflineUtility();

    private DownloadOfflineUtility() {
    }

    public final void createNotificationChannel(Context context) {
        y.i(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            k.a();
            NotificationChannel notificationChannelA = j.a("download_offline", context.getString(R.string.messages_download), 0);
            notificationChannelA.setDescription(context.getString(R.string.muteable));
            notificationChannelA.setBypassDnd(true);
            notificationChannelA.setSound(null, new AudioAttributes.Builder().build());
            notificationChannelA.setLockscreenVisibility(-1);
            notificationChannelA.setImportance(0);
            notificationChannelA.enableLights(false);
            notificationChannelA.setShowBadge(false);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            y.f(notificationManager);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }

    public final void startService(Context context) {
        y.i(context, "context");
        try {
            createNotificationChannel(context);
            if (ExtensionFunsKt.areNotificationsEnabled(context)) {
                Intent intent = new Intent();
                intent.setClassName(context, DownloadOfflineService.class.getName());
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void stopService(Context context) {
        y.i(context, "context");
        context.stopService(new Intent(context, (Class<?>) DownloadOfflineService.class));
    }
}
