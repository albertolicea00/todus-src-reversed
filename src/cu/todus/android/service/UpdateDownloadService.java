package cu.todus.android.service;

import ab.e;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.camera.core.processing.util.GLUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import androidx.media3.extractor.text.ttml.TtmlNode;
import bb.b;
import cb.d;
import cb.f;
import cb.l;
import cb.m;
import cu.todus.android.R;
import cu.todus.android.constants.CloudType;
import cu.todus.android.utils.UpdateChecker;
import cu.todus.android.utils.versionupdate.DownloadState;
import cu.todus.android.utils.versionupdate.DownloadStateBus;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.a0;
import pe.a2;
import pe.d1;
import pe.i;
import pe.m0;
import pe.n0;
import pe.w2;
import ua.k0;
import ua.n;
import ua.o;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010!\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0003R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcu/todus/android/service/UpdateDownloadService;", "Landroid/app/Service;", "<init>", "()V", "", "urlStr", "", "targetVersion", "Lua/k0;", "runDownload", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "createChannel", "", "pct", "d", "t", "Landroidx/core/app/NotificationCompat$Builder;", "buildProgressNotification", "(ILjava/lang/String;Ljava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;", "Ljava/io/File;", ExtensionFile.ELEMENT, "buildSuccessNotification", "(Ljava/io/File;)Landroidx/core/app/NotificationCompat$Builder;", "buildErrorNotification", "()Landroidx/core/app/NotificationCompat$Builder;", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Lpe/a0;", "serviceJob", "Lpe/a0;", "Lpe/m0;", "serviceScope", "Lpe/m0;", "Lpe/a2;", "activeDownload", "Lpe/a2;", "Ljava/net/HttpURLConnection;", "currentConnection", "Ljava/net/HttpURLConnection;", "Landroid/app/NotificationManager;", "notificationManager$delegate", "Lua/n;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateDownloadService extends Service {
    public static final String ACTION_CANCEL = "cu.todus.android.CANCEL_DOWNLOAD";
    public static final String CHANNEL_ID = "app_update_download";
    public static final String EXTRA_TARGET_VERSION = "target_version";
    public static final String EXTRA_URL = "download_url";
    public static final int NOTIF_ID = 9999;
    private a2 activeDownload;
    private HttpURLConnection currentConnection;

    /* JADX INFO: renamed from: notificationManager$delegate, reason: from kotlin metadata */
    private final n notificationManager;
    private final a0 serviceJob;
    private final m0 serviceScope;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcu/todus/android/service/UpdateDownloadService$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "url", "", "targetVersion", "Lua/k0;", TtmlNode.START, "(Landroid/content/Context;Ljava/lang/String;J)V", "cancel", "(Landroid/content/Context;)V", "EXTRA_URL", "Ljava/lang/String;", "EXTRA_TARGET_VERSION", "ACTION_CANCEL", "", "NOTIF_ID", "I", "CHANNEL_ID", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final void cancel(Context context) {
            y.i(context, "context");
            context.stopService(new Intent(context, (Class<?>) UpdateDownloadService.class));
        }

        public final void start(Context context, String url, long targetVersion) {
            y.i(context, "context");
            y.i(url, "url");
            Intent intent = new Intent(context, (Class<?>) UpdateDownloadService.class);
            intent.putExtra(UpdateDownloadService.EXTRA_URL, url);
            intent.putExtra(UpdateDownloadService.EXTRA_TARGET_VERSION, targetVersion);
            ContextCompat.startForegroundService(context, intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.service.UpdateDownloadService$onStartCommand$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.service.UpdateDownloadService$onStartCommand$1", f = "UpdateDownloadService.kt", l = {85}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ long $targetVersion;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j10, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$url = str;
            this.$targetVersion = j10;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return UpdateDownloadService.this.new AnonymousClass1(this.$url, this.$targetVersion, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                UpdateDownloadService updateDownloadService = UpdateDownloadService.this;
                String str = this.$url;
                long j10 = this.$targetVersion;
                this.label = 1;
                if (updateDownloadService.runDownload(str, j10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.service.UpdateDownloadService$runDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.service.UpdateDownloadService", f = "UpdateDownloadService.kt", l = {106}, m = "runDownload", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11881 extends d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11881(e<? super C11881> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateDownloadService.this.runDownload(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.service.UpdateDownloadService$runDownload$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.service.UpdateDownloadService$runDownload$2", f = "UpdateDownloadService.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends m implements Function2 {
        final /* synthetic */ long $existingSize;
        final /* synthetic */ File $file;
        final /* synthetic */ String $urlStr;
        int label;
        final /* synthetic */ UpdateDownloadService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, UpdateDownloadService updateDownloadService, long j10, File file, e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$urlStr = str;
            this.this$0 = updateDownloadService;
            this.$existingSize = j10;
            this.$file = file;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return new AnonymousClass2(this.$urlStr, this.this$0, this.$existingSize, this.$file, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws IOException {
            HttpURLConnection httpURLConnection;
            b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            URL url = new URL(this.$urlStr);
            UpdateDownloadService updateDownloadService = this.this$0;
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            y.g(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            updateDownloadService.currentConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            long j10 = 0;
            if (this.$existingSize > 0 && (httpURLConnection = this.this$0.currentConnection) != null) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + this.$existingSize + "-");
            }
            HttpURLConnection httpURLConnection2 = this.this$0.currentConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.connect();
            }
            HttpURLConnection httpURLConnection3 = this.this$0.currentConnection;
            if (httpURLConnection3 == null) {
                return k0.f43947a;
            }
            if (this.$existingSize > 0 && httpURLConnection3.getResponseCode() != 206) {
                httpURLConnection3.getResponseCode();
                this.$file.delete();
                httpURLConnection3.disconnect();
                UpdateDownloadService updateDownloadService2 = this.this$0;
                URLConnection uRLConnectionOpenConnection2 = url.openConnection();
                y.g(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                updateDownloadService2.currentConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
                HttpURLConnection httpURLConnection4 = this.this$0.currentConnection;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.connect();
                }
                httpURLConnection3 = this.this$0.currentConnection;
                if (httpURLConnection3 == null) {
                    return k0.f43947a;
                }
            }
            long contentLength = ((long) httpURLConnection3.getContentLength()) + (httpURLConnection3.getResponseCode() == 206 ? this.$existingSize : 0L);
            InputStream inputStream = httpURLConnection3.getInputStream();
            int i10 = 0;
            int i11 = 1;
            FileOutputStream fileOutputStream = new FileOutputStream(this.$file, httpURLConnection3.getResponseCode() == 206);
            byte[] bArr = new byte[8192];
            long j11 = httpURLConnection3.getResponseCode() == 206 ? this.$existingSize : 0L;
            while (true) {
                int i12 = inputStream.read(bArr);
                if (i12 == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    this.$file.length();
                    return k0.f43947a;
                }
                fileOutputStream.write(bArr, i10, i12);
                long j12 = j10;
                j11 += (long) i12;
                int i13 = contentLength > j12 ? (int) ((j11 / contentLength) * 100) : i10;
                e1 e1Var = e1.f36604a;
                Object[] objArr = new Object[i11];
                objArr[i10] = cb.b.b(j11 / 1048576.0d);
                String str = String.format("%.1f", Arrays.copyOf(objArr, i11));
                y.h(str, "format(...)");
                int i14 = i10;
                Object[] objArr2 = new Object[1];
                objArr2[i14] = cb.b.b(contentLength / 1048576.0d);
                String str2 = String.format("%.1f", Arrays.copyOf(objArr2, 1));
                y.h(str2, "format(...)");
                DownloadStateBus.INSTANCE.update(new DownloadState.Progress(i13, str, str2));
                this.this$0.getNotificationManager().notify(UpdateDownloadService.NOTIF_ID, this.this$0.buildProgressNotification(i13, str, str2).build());
                i10 = i14;
                i11 = 1;
                j10 = j12;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public UpdateDownloadService() {
        a0 a0VarB = w2.b(null, 1, null);
        this.serviceJob = a0VarB;
        this.serviceScope = n0.a(d1.b().plus(a0VarB));
        this.notificationManager = o.a(new lb.a() { // from class: cu.todus.android.service.a
            @Override // lb.a
            public final Object invoke() {
                return UpdateDownloadService.notificationManager_delegate$lambda$0(this.f20915c);
            }
        });
    }

    private final NotificationCompat.Builder buildErrorNotification() {
        NotificationCompat.Builder priority = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("✗ Error en la descarga").setContentText("Toca para reintentar").setSmallIcon(R.drawable.icon).setAutoCancel(true).setPriority(1);
        y.h(priority, "setPriority(...)");
        return priority;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationCompat.Builder buildProgressNotification(int pct, String d10, String t10) {
        Intent intent = new Intent(this, (Class<?>) UpdateDownloadService.class);
        intent.setAction(ACTION_CANCEL);
        NotificationCompat.Builder builderAddAction = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("Descargando actualización").setContentText(d10 + " MB de " + t10 + " MB").setSmallIcon(R.drawable.icon).setProgress(100, pct, false).setOngoing(true).setPriority(-1).addAction(android.R.drawable.ic_menu_close_clear_cancel, "Cancelar", PendingIntent.getService(this, 1, intent, 201326592));
        y.h(builderAddAction, "addAction(...)");
        return builderAddAction;
    }

    private final NotificationCompat.Builder buildSuccessNotification(File file) {
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.addFlags(1);
        intent.addFlags(268435456);
        NotificationCompat.Builder priority = new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("✓ Actualización lista").setContentText("Toca para instalar").setSmallIcon(R.drawable.icon).setContentIntent(PendingIntent.getActivity(this, 2, intent, 201326592)).setAutoCancel(true).setPriority(1);
        y.h(priority, "setPriority(...)");
        return priority;
    }

    private final void createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            k.a();
            NotificationChannel notificationChannelA = j.a(CHANNEL_ID, "Descargas de aplicación", 2);
            notificationChannelA.setDescription("Notificaciones de descarga de actualizaciones");
            getNotificationManager().createNotificationChannel(notificationChannelA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager notificationManager_delegate$lambda$0(UpdateDownloadService updateDownloadService) {
        Object systemService = updateDownloadService.getSystemService(CloudType.WORKER_NOTIFICATION);
        y.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object runDownload(String str, long j10, e<? super k0> eVar) throws Throwable {
        C11881 c11881;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        File file;
        long j11;
        UpdateChecker updateChecker;
        if (eVar instanceof C11881) {
            c11881 = (C11881) eVar;
            int i10 = c11881.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11881.label = i10 - Integer.MIN_VALUE;
            } else {
                c11881 = new C11881(eVar);
            }
        } else {
            c11881 = new C11881(eVar);
        }
        C11881 c11882 = c11881;
        Object obj = c11882.result;
        Object objG = b.g();
        int i11 = c11882.label;
        Function1 function1 = null;
        Object[] objArr = 0;
        try {
            try {
                if (i11 == 0) {
                    v.b(obj);
                    UpdateChecker updateChecker2 = new UpdateChecker(this, function1, 2, objArr == true ? 1 : 0);
                    updateChecker2.clearCacheIfStale(j10);
                    File file2 = new File(getCacheDir(), UpdateChecker.CACHED_APK_NAME);
                    file2.getAbsolutePath();
                    long length = file2.exists() ? file2.length() : 0L;
                    pe.k0 k0VarB = d1.b();
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, this, length, file2, null);
                    c11882.L$0 = l.a(str);
                    c11882.L$1 = updateChecker2;
                    c11882.L$2 = file2;
                    c11882.J$0 = j10;
                    c11882.J$1 = length;
                    c11882.label = 1;
                    if (i.g(k0VarB, anonymousClass2, c11882) == objG) {
                        return objG;
                    }
                    file = file2;
                    j11 = j10;
                    updateChecker = updateChecker2;
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j11 = c11882.J$0;
                    file = (File) c11882.L$2;
                    updateChecker = (UpdateChecker) c11882.L$1;
                    try {
                        v.b(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = null;
                        this.currentConnection = httpURLConnection2;
                        stopSelf();
                        throw th;
                    }
                }
                updateChecker.markDownloadCompleted(j11);
                DownloadStateBus.INSTANCE.update(DownloadState.Success.INSTANCE);
                stopForeground(false);
                getNotificationManager().notify(NOTIF_ID, buildSuccessNotification(file).build());
                httpURLConnection = null;
            } catch (CancellationException unused) {
                stopForeground(true);
                httpURLConnection = null;
            } catch (Exception e10) {
                Log.e("UpdateService", "Download error", e10);
                DownloadStateBus.INSTANCE.update(DownloadState.Error.INSTANCE);
                stopForeground(false);
                getNotificationManager().notify(NOTIF_ID, buildErrorNotification().build());
                httpURLConnection = null;
            }
            this.currentConnection = httpURLConnection;
            stopSelf();
            return k0.f43947a;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createChannel();
    }

    @Override // android.app.Service
    public void onDestroy() {
        HttpURLConnection httpURLConnection = this.currentConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        a2.a.a(this.serviceJob, null, 1, null);
        DownloadStateBus downloadStateBus = DownloadStateBus.INSTANCE;
        if (!(downloadStateBus.getState().getValue() instanceof DownloadState.Success)) {
            downloadStateBus.update(DownloadState.Idle.INSTANCE);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (y.d(intent != null ? intent.getAction() : null, ACTION_CANCEL)) {
            stopForeground(true);
            stopSelf();
            return 2;
        }
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_URL) : null;
        if (stringExtra == null) {
            stopSelf();
            return 2;
        }
        a2 a2Var = this.activeDownload;
        if (a2Var != null && a2Var.isActive()) {
            return 2;
        }
        long longExtra = intent.getLongExtra(EXTRA_TARGET_VERSION, -1L);
        startForeground(NOTIF_ID, buildProgressNotification(0, GLUtils.VERSION_UNKNOWN, GLUtils.VERSION_UNKNOWN).build());
        this.activeDownload = pe.k.d(this.serviceScope, null, null, new AnonymousClass1(stringExtra, longExtra, null), 3, null);
        return 2;
    }
}
