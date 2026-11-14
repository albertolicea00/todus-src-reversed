package cu.todus.android.alive;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.R;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import cu.todus.android.utils.ExtensionFunsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import pe.a2;
import pe.d1;
import pe.m0;
import pe.n0;
import ua.k0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0016J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010%\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00103\u001a\b\u0012\u0004\u0012\u00020\u0012028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u00069"}, d2 = {"Lcu/todus/android/alive/AliveUtility;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "countOpenActivities", "(Landroid/content/Context;)I", "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "", "checkForNotificationsActives", "(Landroidx/core/app/NotificationManagerCompat;)Z", "", "aliveTimeInSec", "Lcu/todus/android/data/db/entity/cache/WelcomeMessage;", "nextMessage", "Lua/k0;", "startService", "(Landroid/content/Context;JLcu/todus/android/data/db/entity/cache/WelcomeMessage;)V", "stopService", "(Landroid/content/Context;)V", "createNotificationChannel", "", "retrieveMockupWelcomeMessages", "()Ljava/util/List;", "appIsOnActivity", "(Landroid/content/Context;)Z", "", "ALIVE_FOREGROUND_SERVICE_NOTIFICATION_ID", "Ljava/lang/String;", "ALIVE_CHANNEL_ID", "ALIVE_TIME", "ALIVE_WELCOME_MSG_TITLE", "ALIVE_WELCOME_MSG_TEXT", "ALIVE_WELCOME_MSG_IMG", "ALIVE_WELCOME_MSG_URL", "Lpe/m0;", "job", "Lpe/m0;", "getJob", "()Lpe/m0;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "getListener", "()Lpe/a2;", "setListener", "(Lpe/a2;)V", "Lkotlin/Function0;", "resetAliveTimer", "Llb/a;", "getResetAliveTimer", "()Llb/a;", "setResetAliveTimer", "(Llb/a;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AliveUtility {
    public static final String ALIVE_CHANNEL_ID = "todus_alive";
    public static final String ALIVE_FOREGROUND_SERVICE_NOTIFICATION_ID = "todus_alive";
    public static final String ALIVE_TIME = "todus_alive_time";
    public static final String ALIVE_WELCOME_MSG_IMG = "alive_welcome_msg_img";
    public static final String ALIVE_WELCOME_MSG_TEXT = "alive_welcome_msg_text";
    public static final String ALIVE_WELCOME_MSG_TITLE = "alive_welcome_msg_title";
    public static final String ALIVE_WELCOME_MSG_URL = "alive_welcome_msg_url";
    private static a2 listener;
    public static final AliveUtility INSTANCE = new AliveUtility();
    private static final m0 job = n0.a(d1.c());
    private static lb.a resetAliveTimer = new lb.a() { // from class: cu.todus.android.alive.c
        @Override // lb.a
        public final Object invoke() {
            return k0.f43947a;
        }
    };
    public static final int $stable = 8;

    private AliveUtility() {
    }

    private final boolean checkForNotificationsActives(NotificationManagerCompat notificationManagerCompat) {
        try {
            List<StatusBarNotification> activeNotifications = notificationManagerCompat.getActiveNotifications();
            y.h(activeNotifications, "getActiveNotifications(...)");
            while (true) {
                boolean z10 = false;
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!z10) {
                        if (statusBarNotification.getId() != 99) {
                            z10 = true;
                        }
                    }
                }
                return z10;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    private final int countOpenActivities(Context context) {
        ActivityManager.RecentTaskInfo taskInfo;
        Object systemService = context.getSystemService("activity");
        y.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        int size = activityManager.getRunningTasks(2).size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
            y.h(appTasks, "getAppTasks(...)");
            ActivityManager.AppTask appTask = (ActivityManager.AppTask) g0.y0(appTasks);
            ComponentName componentName = (appTask == null || (taskInfo = appTask.getTaskInfo()) == null) ? null : taskInfo.topActivity;
            if ((componentName != null ? componentName.getClassName() : null) != null) {
                i10++;
            }
        }
        return i10;
    }

    public static /* synthetic */ void startService$default(AliveUtility aliveUtility, Context context, long j10, WelcomeMessage welcomeMessage, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 30;
        }
        if ((i10 & 4) != 0) {
            welcomeMessage = null;
        }
        aliveUtility.startService(context, j10, welcomeMessage);
    }

    public final boolean appIsOnActivity(Context context) {
        y.i(context, "context");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        y.h(notificationManagerCompatFrom, "from(...)");
        return countOpenActivities(context) > 0 || checkForNotificationsActives(notificationManagerCompatFrom);
    }

    public final void createNotificationChannel(Context context) {
        y.i(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            k.a();
            NotificationChannel notificationChannelA = j.a("todus_alive", context.getString(R.string.alive_service), 0);
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

    public final m0 getJob() {
        return job;
    }

    public final a2 getListener() {
        return listener;
    }

    public final lb.a getResetAliveTimer() {
        return resetAliveTimer;
    }

    public final List<WelcomeMessage> retrieveMockupWelcomeMessages() {
        return w.q(new WelcomeMessage(0, "toDus", "¡Hola! ¿Qué tal si le mandas un mensaje a ese amigo que hace tiempo no ves?", "", ""), new WelcomeMessage(1, "toDus", "La vida es corta, ¡No dejes de decirle “Te quiero” a esa persona especial ahora mismo!", "", ""), new WelcomeMessage(2, "toDus", "¿Sabías que un mensaje puede alegrar el día de alguien? ¡Inténtalo!", "", ""), new WelcomeMessage(3, "toDus", "La mejor conversación comienza con un simple 'Hola'.", "", ""), new WelcomeMessage(4, "toDus", "¿Qué tal si envías un mensaje para poner una sonrisa en el rostro de alguien?", "", ""), new WelcomeMessage(5, "toDus", "Un mensaje puede hacer que alguien se sienta querido. ¡Haz la diferencia!", "", ""), new WelcomeMessage(6, "toDus", "Nunca subestimes el poder de un mensaje sincero.", "", ""), new WelcomeMessage(7, "toDus", "La vida está llena de momentos especiales, compártelos a través de mensajes.", "", ""), new WelcomeMessage(8, "toDus", "Un mensaje puede cambiar el rumbo del día de alguien. ¡Hazlo!", "", ""), new WelcomeMessage(9, "toDus", "¿Qué esperas? Envía un mensaje a esa persona que te importa, quizás está esperando por ti.", "", ""), new WelcomeMessage(10, "toDus", "¡No dejes para después lo que puedes decir ahora mismo!", "", ""), new WelcomeMessage(11, "toDus", "Un mensaje puede ser el inicio de algo grandioso. ¡Anímate a enviarlo!", "", ""), new WelcomeMessage(12, "toDus", "toDus puede ser la mejor forma de conectarte con los demás.", "", ""), new WelcomeMessage(13, "toDus", "Los mensajes son como abrazos virtuales. ¡Abraza ahora mismo!", "", ""), new WelcomeMessage(14, "toDus", "¿Qué tal si envías un mensaje para recordarle a alguien lo especial que es?", "", ""), new WelcomeMessage(15, "toDus", "Un mensaje puede convertir un día ordinario en algo extraordinario.", "", ""), new WelcomeMessage(16, "toDus", "Un mensaje oportuno puede marcar la diferencia en la vida de alguien.", "", ""), new WelcomeMessage(17, "toDus", "¿Por qué no envías un mensaje para recordarle a alguien lo mucho que significa para ti?", "", ""), new WelcomeMessage(18, "toDus", "Un mensaje puede ser el inicio de una conversación inolvidable.", "", ""), new WelcomeMessage(19, "toDus", "Un mensaje puede ser el comienzo de una bonita historia.", "", ""), new WelcomeMessage(20, "toDus", "¡Sonríe! Un mensaje nuevo puede estar en camino.", "", ""), new WelcomeMessage(21, "toDus", "¿Qué tal si le mandas un mensaje a esa persona que hace tiempo no ves?", "", ""), new WelcomeMessage(22, "toDus", "¿Has enviado un mensaje hoy? ¡Es el momento perfecto para hacerlo!", "", ""), new WelcomeMessage(23, "toDus", "La mejor parte del día es recibir un mensaje inesperado.", "", ""), new WelcomeMessage(24, "toDus", "La vida está llena de sorpresas, ¡envía un mensaje y crea una!", "", ""));
    }

    public final void setListener(a2 a2Var) {
        listener = a2Var;
    }

    public final void setResetAliveTimer(lb.a aVar) {
        y.i(aVar, "<set-?>");
        resetAliveTimer = aVar;
    }

    public final void startService(Context context, long aliveTimeInSec, WelcomeMessage nextMessage) {
        String title;
        String image;
        String url;
        String text;
        y.i(context, "context");
        try {
            createNotificationChannel(context);
            if (ExtensionFunsKt.areNotificationsEnabled(context)) {
                Intent intent = new Intent();
                intent.putExtra(ALIVE_TIME, ((long) 1000) * aliveTimeInSec);
                String str = "toDus";
                if (nextMessage == null || (title = nextMessage.getTitle()) == null) {
                    title = "toDus";
                }
                intent.putExtra(ALIVE_WELCOME_MSG_TITLE, title);
                if (nextMessage != null && (text = nextMessage.getText()) != null) {
                    str = text;
                }
                intent.putExtra(ALIVE_WELCOME_MSG_TEXT, str);
                String str2 = "";
                if (nextMessage == null || (image = nextMessage.getImage()) == null) {
                    image = "";
                }
                intent.putExtra(ALIVE_WELCOME_MSG_IMG, image);
                if (nextMessage != null && (url = nextMessage.getUrl()) != null) {
                    str2 = url;
                }
                intent.putExtra(ALIVE_WELCOME_MSG_URL, str2);
                intent.setClassName(context, AliveService.class.getName());
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
        context.stopService(new Intent(context, (Class<?>) AliveService.class));
        a2 a2Var = listener;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
    }
}
