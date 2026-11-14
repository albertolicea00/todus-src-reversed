package cu.todus.android.webrtc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Foreground service ({@code foregroundServiceType="phoneCall"}) managing active
 * WebRTC call notifications and hang-up actions.
 *
 * @obfuscated_class cu.todus.android.webrtc.service.CallService
 */
public final class CallService extends Service {

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
        return START_STICKY;
    }
}
