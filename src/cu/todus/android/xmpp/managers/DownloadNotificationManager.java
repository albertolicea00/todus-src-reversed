package cu.todus.android.xmpp.managers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import cu.todus.android.R;
import cu.todus.android.constants.CloudType;
import cu.todus.android.service.UpdateDownloadService;
import cu.todus.android.utils.versionupdate.DownloadState;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.d1;
import pe.m0;
import pe.n0;
import pe.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\u001f¨\u0006$"}, d2 = {"Lcu/todus/android/xmpp/managers/DownloadNotificationManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lua/k0;", "createNotificationChannel", "()V", "", "delayMs", "autoCloseNotification", "(J)V", "Lcu/todus/android/utils/versionupdate/DownloadState$Progress;", "state", "Landroidx/core/app/NotificationCompat$Builder;", "buildProgressNotification", "(Lcu/todus/android/utils/versionupdate/DownloadState$Progress;)Landroidx/core/app/NotificationCompat$Builder;", "buildSuccessNotification", "()Landroidx/core/app/NotificationCompat$Builder;", "buildErrorNotification", "Lcu/todus/android/utils/versionupdate/DownloadState;", "updateNotification", "(Lcu/todus/android/utils/versionupdate/DownloadState;)V", "cancelNotification", "Landroid/content/Context;", "Landroid/app/NotificationManager;", "notificationManager", "Landroid/app/NotificationManager;", "", "DOWNLOAD_CHANNEL_ID", "Ljava/lang/String;", "", "DOWNLOAD_NOTIFICATION_ID", "I", "TAG", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DownloadNotificationManager {
    public static final int $stable = 8;
    private final String DOWNLOAD_CHANNEL_ID;
    private final int DOWNLOAD_NOTIFICATION_ID;
    private final String TAG;
    private final Context context;
    private final NotificationManager notificationManager;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.DownloadNotificationManager$autoCloseNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.DownloadNotificationManager$autoCloseNotification$1", f = "DownloadNotificationManager.kt", l = {64}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ DownloadNotificationManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j10, DownloadNotificationManager downloadNotificationManager, ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$delayMs = j10;
            this.this$0 = downloadNotificationManager;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new AnonymousClass1(this.$delayMs, this.this$0, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                long j10 = this.$delayMs;
                this.label = 1;
                if (w0.b(j10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            String unused = this.this$0.TAG;
            this.this$0.cancelNotification();
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public DownloadNotificationManager(Context context) {
        kotlin.jvm.internal.y.i(context, "context");
        this.context = context;
        Object systemService = context.getSystemService(CloudType.WORKER_NOTIFICATION);
        kotlin.jvm.internal.y.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.notificationManager = (NotificationManager) systemService;
        this.DOWNLOAD_CHANNEL_ID = UpdateDownloadService.CHANNEL_ID;
        this.DOWNLOAD_NOTIFICATION_ID = UpdateDownloadService.NOTIF_ID;
        this.TAG = "NotificationManager";
        createNotificationChannel();
    }

    private final void autoCloseNotification(long delayMs) {
        pe.k.d(n0.a(d1.c()), null, null, new AnonymousClass1(delayMs, this, null), 3, null);
    }

    private final NotificationCompat.Builder buildErrorNotification() {
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.context, this.DOWNLOAD_CHANNEL_ID).setContentTitle("✗ Error en la descarga").setContentText("Toca para reintentar").setSmallIcon(R.drawable.icon).setOngoing(false).setPriority(1).setAutoCancel(true);
        kotlin.jvm.internal.y.h(autoCancel, "setAutoCancel(...)");
        return autoCancel;
    }

    private final NotificationCompat.Builder buildProgressNotification(DownloadState.Progress state) {
        Intent intent = new Intent(this.context, (Class<?>) UpdateDownloadService.class);
        intent.setAction(UpdateDownloadService.ACTION_CANCEL);
        NotificationCompat.Builder builderAddAction = new NotificationCompat.Builder(this.context, this.DOWNLOAD_CHANNEL_ID).setContentTitle("Descargando actualización").setContentText(state.getCurrentMb() + "MB de " + state.getTotalMb() + "MB").setSmallIcon(R.drawable.icon).setProgress(100, state.getPercent(), false).setOngoing(true).setPriority(-1).setAutoCancel(false).addAction(android.R.drawable.ic_menu_close_clear_cancel, "Cancelar", PendingIntent.getService(this.context, 2, intent, 201326592));
        kotlin.jvm.internal.y.h(builderAddAction, "addAction(...)");
        return builderAddAction;
    }

    private final NotificationCompat.Builder buildSuccessNotification() {
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.context, this.DOWNLOAD_CHANNEL_ID).setContentTitle("✓ Actualización lista").setContentText("Toca para instalar").setSmallIcon(R.drawable.icon).setOngoing(false).setPriority(1).setAutoCancel(true);
        kotlin.jvm.internal.y.h(autoCancel, "setAutoCancel(...)");
        return autoCancel;
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            androidx.media3.common.util.k.a();
            NotificationChannel notificationChannelA = androidx.media3.common.util.j.a(this.DOWNLOAD_CHANNEL_ID, "Descargas de aplicación", 2);
            notificationChannelA.setDescription("Notificaciones de descarga de actualizaciones");
            this.notificationManager.createNotificationChannel(notificationChannelA);
        }
    }

    public final void cancelNotification() {
        this.notificationManager.cancel(this.DOWNLOAD_NOTIFICATION_ID);
    }

    public final void updateNotification(DownloadState state) {
        NotificationCompat.Builder builderBuildErrorNotification;
        kotlin.jvm.internal.y.i(state, "state");
        Objects.toString(state);
        if (state instanceof DownloadState.Idle) {
            cancelNotification();
            return;
        }
        if (state instanceof DownloadState.Progress) {
            builderBuildErrorNotification = buildProgressNotification((DownloadState.Progress) state);
        } else if (state instanceof DownloadState.Success) {
            builderBuildErrorNotification = buildSuccessNotification();
        } else {
            if (!(state instanceof DownloadState.Error)) {
                throw new ua.r();
            }
            builderBuildErrorNotification = buildErrorNotification();
        }
        this.notificationManager.notify(this.DOWNLOAD_NOTIFICATION_ID, builderBuildErrorNotification.build());
        if (state instanceof DownloadState.Success) {
            autoCloseNotification(3000L);
        }
    }
}
