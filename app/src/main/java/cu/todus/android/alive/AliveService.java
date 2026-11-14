package cu.todus.android.alive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Foreground service ({@code foregroundServiceType="remoteMessaging"}) keeping
 * the XMPP connection alive when battery optimization is unrestricted.
 *
 * @obfuscated_class cu.todus.android.alive.AliveService
 */
public final class AliveService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }
}
