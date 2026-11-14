package cu.todus.android.webrtc.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.R;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import pe.a2;
import pe.d1;
import pe.m0;
import pe.n0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcu/todus/android/webrtc/service/CallServiceUtility;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "withName", "Lua/k0;", "startService", "(Landroid/content/Context;Ljava/lang/String;)V", "stopService", "(Landroid/content/Context;)V", "createNotificationChannel", "CALL_FOREGROUND_SERVICE_NOTIFICATION_ID", "Ljava/lang/String;", "CALL_CHANNEL_ID", "IN_CALL_NAME", "Lpe/m0;", "job", "Lpe/m0;", "getJob", "()Lpe/m0;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "getListener", "()Lpe/a2;", "setListener", "(Lpe/a2;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallServiceUtility {
    public static final String CALL_CHANNEL_ID = "todus_call";
    public static final String CALL_FOREGROUND_SERVICE_NOTIFICATION_ID = "todus_call";
    public static final String IN_CALL_NAME = "in_call_name";
    private static a2 listener;
    public static final CallServiceUtility INSTANCE = new CallServiceUtility();
    private static final m0 job = n0.a(d1.c());
    public static final int $stable = 8;

    private CallServiceUtility() {
    }

    public final void createNotificationChannel(Context context) {
        y.i(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            k.a();
            NotificationChannel notificationChannelA = j.a("todus_call", context.getString(R.string.call_service), 4);
            notificationChannelA.setDescription("");
            notificationChannelA.enableLights(false);
            notificationChannelA.setShowBadge(false);
            notificationChannelA.setLockscreenVisibility(-1);
            notificationChannelA.setImportance(2);
            notificationChannelA.setBypassDnd(true);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setSound(null, new AudioAttributes.Builder().build());
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            y.f(notificationManager);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }

    public final m0 getJob() {
        return job;
    }

    public final a2 getListener() {
        return listener;
    }

    public final void setListener(a2 a2Var) {
        listener = a2Var;
    }

    public final void startService(Context context, String withName) {
        y.i(context, "context");
        y.i(withName, "withName");
        Intent intent = new Intent();
        intent.putExtra(IN_CALL_NAME, withName);
        intent.setClassName(context, CallService.class.getName());
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void stopService(Context context) {
        y.i(context, "context");
        context.stopService(new Intent(context, (Class<?>) CallService.class));
        a2 a2Var = listener;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
    }
}
