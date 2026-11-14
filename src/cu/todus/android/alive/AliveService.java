package cu.todus.android.alive;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import cu.todus.android.R;
import cu.todus.android.uiCompose.main.MainActivity;
import cu.todus.android.volatileState.AppVolatileState;
import kotlin.Metadata;
import kotlin.jvm.internal.x0;
import kotlin.jvm.internal.y;
import le.d0;
import pe.a2;
import pe.j;
import pe.k;
import pe.o0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0011"}, d2 = {"Lcu/todus/android/alive/AliveService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lua/k0;", "onCreate", "onDestroy", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AliveService extends Service {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 onStartCommand$lambda$0$1(x0 x0Var, Intent intent) {
        Bundle extras = intent.getExtras();
        x0Var.f36633c = extras != null ? extras.getLong(AliveUtility.ALIVE_TIME) : 15000L;
        return k0.f43947a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        y.i(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.setServiceRunning(true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull != null) {
            instanceOrNull.setServiceRunning(false);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int flags, int startId) {
        String string;
        String string2;
        String string3;
        String string4;
        if (intent == null) {
            return 2;
        }
        Bundle extras = intent.getExtras();
        String str = "";
        if (extras == null || (string = extras.getString(AliveUtility.ALIVE_WELCOME_MSG_TITLE)) == null) {
            string = "";
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 == null || (string2 = extras2.getString(AliveUtility.ALIVE_WELCOME_MSG_TEXT)) == null) {
            string2 = "";
        }
        Bundle extras3 = intent.getExtras();
        if (extras3 == null || (string3 = extras3.getString(AliveUtility.ALIVE_WELCOME_MSG_IMG)) == null) {
            string3 = "";
        }
        Bundle extras4 = intent.getExtras();
        if (extras4 != null && (string4 = extras4.getString(AliveUtility.ALIVE_WELCOME_MSG_URL)) != null) {
            str = string4;
        }
        Intent intent2 = d0.q0(str) ? new Intent(this, (Class<?>) MainActivity.class) : new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent2.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 1107296256 : 1073741824);
        Bitmap bitmap = !d0.q0(string3) ? (Bitmap) j.b(null, new AliveService$onStartCommand$1$bitmap$1(string3, null), 1, null) : null;
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, "todus_alive").setSmallIcon(R.drawable.icon);
        if (d0.q0(string)) {
            string = getString(R.string.app_name);
            y.h(string, "getString(...)");
        }
        smallIcon.setContentTitle(string);
        smallIcon.setContentText(string2);
        if (bitmap != null) {
            smallIcon.setLargeIcon(bitmap);
        }
        Notification notificationBuild = smallIcon.setGroup("cu.todus.android.ALIVE_SERVICE").setGroupSummary(true).setContentIntent(activity).setAutoCancel(true).setPriority(-2).setTimeoutAfter(1000L).build();
        y.h(notificationBuild, "build(...)");
        startForeground(intent.getIntExtra("todus_alive", 99), notificationBuild);
        final x0 x0Var = new x0();
        Bundle extras5 = intent.getExtras();
        x0Var.f36633c = extras5 != null ? extras5.getLong(AliveUtility.ALIVE_TIME) : 30000L;
        AliveUtility aliveUtility = AliveUtility.INSTANCE;
        aliveUtility.setListener(k.d(aliveUtility.getJob(), null, o0.LAZY, new AliveService$onStartCommand$1$1(x0Var, this, null), 1, null));
        aliveUtility.setResetAliveTimer(new lb.a() { // from class: cu.todus.android.alive.a
            @Override // lb.a
            public final Object invoke() {
                return AliveService.onStartCommand$lambda$0$1(x0Var, intent);
            }
        });
        a2 listener = aliveUtility.getListener();
        if (listener == null) {
            return 2;
        }
        listener.start();
        return 2;
    }
}
