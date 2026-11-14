package cu.todus.android.webrtc.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import cu.todus.android.R;
import cu.todus.android.notification.SystemNotificationExecutor;
import cu.todus.android.uiCompose.call.CallActivity;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.webrtc.notification.CallIntentReceiver;
import cu.todus.android.webrtc.notification.IncomingCallNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import te.b0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0011"}, d2 = {"Lcu/todus/android/webrtc/service/CallService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lua/k0;", "onCreate", "onDestroy", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallService extends Service {
    public static final int $stable = 8;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        y.i(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        b0 isCallServiceRunning;
        super.onCreate();
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (isCallServiceRunning = instanceOrNull.getIsCallServiceRunning()) == null) {
            return;
        }
        isCallServiceRunning.setValue(Boolean.TRUE);
    }

    @Override // android.app.Service
    public void onDestroy() {
        b0 isCallServiceRunning;
        super.onDestroy();
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (isCallServiceRunning = instanceOrNull.getIsCallServiceRunning()) == null) {
            return;
        }
        isCallServiceRunning.setValue(Boolean.FALSE);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String string;
        CallServiceUtility.INSTANCE.createNotificationChannel(this);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null || (string = extras.getString(CallServiceUtility.IN_CALL_NAME)) == null) {
                string = "";
            }
            Intent intent2 = new Intent(this, (Class<?>) CallActivity.class);
            intent2.addFlags(67108864);
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 1107296256 : 1073741824);
            Intent intent3 = new Intent(this, (Class<?>) CallIntentReceiver.class);
            intent3.putExtra("uid", InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT);
            intent3.setAction(CallIntentReceiver.ACTION_HANG_UP);
            NotificationCompat.Action action = new NotificationCompat.Action((IconCompat) null, IncomingCallNotificationBuilder.INSTANCE.getActionText(this, R.string.hang_up, R.color.colorPrimary), PendingIntent.getBroadcast(this, IncomingCallNotificationBuilder.INCOMING_CALL_HANG_UP_REQUEST_ID, intent3, SystemNotificationExecutor.INSTANCE.retrieveFlags()));
            NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, "todus_call").setSmallIcon(R.drawable.icon);
            smallIcon.setContentTitle(getString(R.string.call));
            smallIcon.setContentText(string);
            Notification notificationBuild = smallIcon.setGroup("cu.todus.android.CALL").setGroupSummary(true).addAction(action).setContentIntent(activity).build();
            y.h(notificationBuild, "build(...)");
            startForeground(intent.getIntExtra("todus_call", 99), notificationBuild);
        }
        return 1;
    }
}
