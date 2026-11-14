package cu.todus.android;

import android.app.Application;
import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.connection.ConnectionManager;
import cu.todus.android.constants.HeadersChecker;
import cu.todus.android.contact.ContactDataSource;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.DataPreferences;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.MediaModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.exceptions.ToDusException;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.repositories.AuthRepository;
import cu.todus.android.repositories.BotShortcutRepository;
import cu.todus.android.repositories.CatalogueRepository;
import cu.todus.android.repositories.LinkedDeviceRepository;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.MigrationsRepository;
import cu.todus.android.repositories.ReactionsRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.StickersRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.repositories.WelcomeMessageRepository;
import cu.todus.android.rest.BaseDataSource;
import cu.todus.android.rest.TokenAuthenticator;
import cu.todus.android.sentry.SentryDataSource;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.volatileState.PathsVolatileState;
import cu.todus.android.xmpp.extension.event.ExtensionEvent;
import cu.z17.views.camera.Z17CameraModule;
import cu.z17.views.utils.Z17BasePictureHeaders;
import cu.z17.views.utils.Z17CoilDecoders;
import cu.z17.views.utils.Z17Markown;
import cu.z17.views.utils.Z17MutableListFlow;
import cu.z17.views.videoPlayer.Z17VideoModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y0;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.util.stringencoder.Base64;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.p0;
import te.r0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J!\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\u0003J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u0003R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020&0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010(R\u001f\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0)8\u0006¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u0010-R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010(R\u001f\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070)8\u0006¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010-R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcu/todus/android/ToDusApp;", "Landroid/app/Application;", "<init>", "()V", "Lua/k0;", "startApp", "Lcu/todus/android/data/preferences/Owner;", "existingOwner", "", "askForNewToken", "isFirstTime", "initializeCompleteApp", "(Lcu/todus/android/data/preferences/Owner;ZZLab/e;)Ljava/lang/Object;", "Lcu/todus/android/exceptions/ToDusException;", ExtensionEvent.TAG_END, "setError", "(Lcu/todus/android/exceptions/ToDusException;)V", "errorRead", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "newNotification", "addNotification", "(Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;)V", "", "id", "", "notificationDisplayed", "(Ljava/lang/String;)Ljava/util/List;", "onCreate", "actualBatteryPreference", "noCheckActivity", "manageAlive", "(Ljava/lang/String;Z)V", "logout", "dismissUpdate", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Lte/b0;", "Lcu/todus/android/data/preferences/AppState;", "_appState", "Lte/b0;", "Lte/p0;", "appState", "Lte/p0;", "getAppState", "()Lte/p0;", "Lcu/todus/android/volatileState/AppVolatileState;", "appVolatileState", "Lcu/todus/android/volatileState/AppVolatileState;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "_error", "error", "getError", "Lcu/todus/android/utils/UpdateInfo;", "_updateInfo", "updateInfo", "getUpdateInfo", "isLoggingOut", "Z", "Lcu/z17/views/utils/Z17MutableListFlow;", "insideNotifications", "Lcu/z17/views/utils/Z17MutableListFlow;", "getInsideNotifications", "()Lcu/z17/views/utils/Z17MutableListFlow;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDusApp extends Application {
    public static final int $stable = 8;
    private final String TAG = ToDusApp.class.getSimpleName();
    private final te.b0 _appState;
    private final te.b0 _error;
    private final te.b0 _updateInfo;
    private final p0 appState;
    private final AppVolatileState appVolatileState;
    private final m0 coroutineScope;
    private final p0 error;
    private final Z17MutableListFlow<InsideNotificationState> insideNotifications;
    private volatile boolean isLoggingOut;
    private final p0 updateInfo;

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$initializeCompleteApp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp", f = "ToDusApp.kt", l = {335, 339, 344, 347, 350, 434, 447, 450, 453, 455}, m = "initializeCompleteApp", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ToDusApp.this.initializeCompleteApp(null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$initializeCompleteApp$18, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp$initializeCompleteApp$18", f = "ToDusApp.kt", l = {462, 474}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass18 extends cb.m implements Function1 {
        final /* synthetic */ MainRepository $mainRepository;
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ ToDusApp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass18(MainRepository mainRepository, ToDusApp toDusApp, ab.e<? super AnonymousClass18> eVar) {
            super(1, eVar);
            this.$mainRepository = mainRepository;
            this.this$0 = toDusApp;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass18(this.$mainRepository, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass18) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x004b  */
        /* JADX WARN: Code duplicated, block: B:21:0x0053  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d1  */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        
            if (pe.w0.b(500, r7) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
        
            if (r8 == r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0046 -> B:18:0x0049). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 227
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.AnonymousClass18.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$initializeCompleteApp$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends kotlin.jvm.internal.v implements lb.a {
        public AnonymousClass6(Object obj) {
            super(0, obj, AuthRepository.class, "newToken", "newToken()Lkotlin/Pair;", 0);
        }

        @Override // lb.a
        public final Pair<Boolean, String> invoke() {
            return ((AuthRepository) this.receiver).newToken();
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$logout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp$logout$1", f = "ToDusApp.kt", l = {493, XMPPTCPConnection.PacketWriter.QUEUE_SIZE, 515, 532, 534, 541}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C09531 extends cb.m implements Function1 {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public C09531(ab.e<? super C09531> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ToDusApp.this.new C09531(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C09531) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00c3 A[LOOP:0: B:17:0x00bd->B:19:0x00c3, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:27:0x0139 A[PHI: r1 r4
          0x0139: PHI (r1v11 cu.todus.android.data.paths.DirectoryPaths) = (r1v8 cu.todus.android.data.paths.DirectoryPaths), (r1v14 cu.todus.android.data.paths.DirectoryPaths) binds: [B:25:0x0135, B:9:0x0052] A[DONT_GENERATE, DONT_INLINE]
          0x0139: PHI (r4v12 cu.todus.android.repositories.MainRepository) = (r4v9 cu.todus.android.repositories.MainRepository), (r4v15 cu.todus.android.repositories.MainRepository) binds: [B:25:0x0135, B:9:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:30:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:34:0x01c7 A[PHI: r1 r4 r5 r6
          0x01c7: PHI (r1v18 cu.todus.android.di.PreferencesModule) = (r1v15 cu.todus.android.di.PreferencesModule), (r1v20 cu.todus.android.di.PreferencesModule) binds: [B:32:0x01c4, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x01c7: PHI (r4v19 cu.todus.android.di.DatabaseModule) = (r4v16 cu.todus.android.di.DatabaseModule), (r4v21 cu.todus.android.di.DatabaseModule) binds: [B:32:0x01c4, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x01c7: PHI (r5v11 cu.todus.android.data.paths.DirectoryPaths) = (r5v8 cu.todus.android.data.paths.DirectoryPaths), (r5v13 cu.todus.android.data.paths.DirectoryPaths) binds: [B:32:0x01c4, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x01c7: PHI (r6v16 cu.todus.android.repositories.MainRepository) = (r6v13 cu.todus.android.repositories.MainRepository), (r6v18 cu.todus.android.repositories.MainRepository) binds: [B:32:0x01c4, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x01fa, code lost:
        
            if (pe.w0.b(1000, r13) == r0) goto L36;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws cu.z17.singledi.SinglediException {
            /*
                Method dump skipped, instruction units count: 542
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.C09531.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$manageAlive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp$manageAlive$1", f = "ToDusApp.kt", l = {259, 269, 281}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C09541 extends cb.m implements Function1 {
        final /* synthetic */ String $actualBatteryPreference;
        final /* synthetic */ boolean $noCheckActivity;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09541(String str, boolean z10, ab.e<? super C09541> eVar) {
            super(1, eVar);
            this.$actualBatteryPreference = str;
            this.$noCheckActivity = z10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ToDusApp.this.new C09541(this.$actualBatteryPreference, this.$noCheckActivity, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C09541) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x00ee  */
        /* JADX WARN: Code duplicated, block: B:45:0x00fc  */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009e, code lost:
        
            if (r12 == r0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
        
            if (r12 == r0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0145, code lost:
        
            if (r12 == r0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0147, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.C09541.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$startApp$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp$startApp$2", f = "ToDusApp.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function1 {
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass2(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            NotificationManager instanceOrNull = NotificationManager.INSTANCE.getInstanceOrNull();
            if (instanceOrNull != null) {
                cb.b.a(instanceOrNull.checkForFirebasePushNotification());
            }
            return k0.f43947a;
        }
    }

    public ToDusApp() {
        te.b0 b0VarA = r0.a(new AppState(AppStateStep.LOADING, null, null, 0, 0L, 30, null));
        this._appState = b0VarA;
        this.appState = te.j.b(b0VarA);
        this.appVolatileState = AppVolatileState.INSTANCE.createInstance(new lb.a() { // from class: cu.todus.android.n
            @Override // lb.a
            public final Object invoke() {
                return ToDusApp.appVolatileState$lambda$0();
            }
        });
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        te.b0 b0VarA2 = r0.a(null);
        this._error = b0VarA2;
        this.error = te.j.b(b0VarA2);
        te.b0 b0VarA3 = r0.a(null);
        this._updateInfo = b0VarA3;
        this.updateInfo = te.j.b(b0VarA3);
        this.insideNotifications = new Z17MutableListFlow<>(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVolatileState appVolatileState$lambda$0() {
        return new AppVolatileState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x013e A[PHI: r1 r2 r5 r8 r10 r11 r12 r13 r14 r15
      0x013e: PHI (r1v8 boolean) = (r1v6 boolean), (r1v9 boolean) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r2v36 java.lang.Object) = (r2v35 java.lang.Object), (r2v1 java.lang.Object) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r5v13 boolean) = (r5v11 boolean), (r5v14 boolean) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r8v14 te.b0) = (r8v11 te.b0), (r8v17 te.b0) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r10v11 cu.z17.views.utils.Z17BasePictureHeaders) = (r10v8 cu.z17.views.utils.Z17BasePictureHeaders), (r10v14 cu.z17.views.utils.Z17BasePictureHeaders) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r11v11 cu.todus.android.di.PreferencesModule) = (r11v8 cu.todus.android.di.PreferencesModule), (r11v14 cu.todus.android.di.PreferencesModule) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r12v11 cu.todus.android.repositories.AuthRepository) = (r12v8 cu.todus.android.repositories.AuthRepository), (r12v14 cu.todus.android.repositories.AuthRepository) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r13v11 cu.todus.android.di.RetrofitModule) = (r13v8 cu.todus.android.di.RetrofitModule), (r13v14 cu.todus.android.di.RetrofitModule) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r14v11 cu.todus.android.di.DatabaseModule) = (r14v8 cu.todus.android.di.DatabaseModule), (r14v14 cu.todus.android.di.DatabaseModule) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r15v11 cu.todus.android.data.preferences.Owner) = (r15v8 cu.todus.android.data.preferences.Owner), (r15v14 cu.todus.android.data.preferences.Owner) binds: [B:34:0x02c5, B:18:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0268 A[PHI: r1 r2 r5 r8 r10 r11 r12 r13 r14 r15
      0x0268: PHI (r1v4 boolean) = (r1v2 boolean), (r1v5 boolean) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r2v22 java.lang.Object) = (r2v21 java.lang.Object), (r2v1 java.lang.Object) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r5v9 boolean) = (r5v7 boolean), (r5v10 boolean) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r8v6 cu.todus.android.volatileState.AppVolatileState) = (r8v3 cu.todus.android.volatileState.AppVolatileState), (r8v9 cu.todus.android.volatileState.AppVolatileState) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r10v5 cu.z17.views.utils.Z17BasePictureHeaders) = (r10v2 cu.z17.views.utils.Z17BasePictureHeaders), (r10v7 cu.z17.views.utils.Z17BasePictureHeaders) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r11v5 cu.todus.android.di.PreferencesModule) = (r11v2 cu.todus.android.di.PreferencesModule), (r11v7 cu.todus.android.di.PreferencesModule) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r12v5 cu.todus.android.repositories.AuthRepository) = (r12v2 cu.todus.android.repositories.AuthRepository), (r12v7 cu.todus.android.repositories.AuthRepository) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r13v5 cu.todus.android.di.RetrofitModule) = (r13v2 cu.todus.android.di.RetrofitModule), (r13v7 cu.todus.android.di.RetrofitModule) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r14v5 cu.todus.android.di.DatabaseModule) = (r14v2 cu.todus.android.di.DatabaseModule), (r14v7 cu.todus.android.di.DatabaseModule) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r15v5 cu.todus.android.data.preferences.Owner) = (r15v2 cu.todus.android.data.preferences.Owner), (r15v7 cu.todus.android.data.preferences.Owner) binds: [B:28:0x0264, B:21:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x0299 A[PHI: r1 r2 r5 r8 r10 r11 r12 r13 r14 r15
      0x0299: PHI (r1v6 boolean) = (r1v4 boolean), (r1v7 boolean) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r2v29 java.lang.Object) = (r2v28 java.lang.Object), (r2v1 java.lang.Object) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r5v11 boolean) = (r5v9 boolean), (r5v12 boolean) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r8v10 cu.todus.android.volatileState.AppVolatileState) = (r8v7 cu.todus.android.volatileState.AppVolatileState), (r8v13 cu.todus.android.volatileState.AppVolatileState) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r10v8 cu.z17.views.utils.Z17BasePictureHeaders) = (r10v5 cu.z17.views.utils.Z17BasePictureHeaders), (r10v10 cu.z17.views.utils.Z17BasePictureHeaders) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r11v8 cu.todus.android.di.PreferencesModule) = (r11v5 cu.todus.android.di.PreferencesModule), (r11v10 cu.todus.android.di.PreferencesModule) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r12v8 cu.todus.android.repositories.AuthRepository) = (r12v5 cu.todus.android.repositories.AuthRepository), (r12v10 cu.todus.android.repositories.AuthRepository) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r13v8 cu.todus.android.di.RetrofitModule) = (r13v5 cu.todus.android.di.RetrofitModule), (r13v10 cu.todus.android.di.RetrofitModule) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r14v8 cu.todus.android.di.DatabaseModule) = (r14v5 cu.todus.android.di.DatabaseModule), (r14v10 cu.todus.android.di.DatabaseModule) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0299: PHI (r15v8 cu.todus.android.data.preferences.Owner) = (r15v5 cu.todus.android.data.preferences.Owner), (r15v10 cu.todus.android.data.preferences.Owner) binds: [B:31:0x0295, B:20:0x0145] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:42:0x031a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0320  */
    /* JADX WARN: Code duplicated, block: B:48:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:52:0x042b A[PHI: r1 r5 r9 r10 r11 r12 r13 r14 r15
      0x042b: PHI (r1v14 boolean) = (r1v12 boolean), (r1v15 boolean) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r5v19 boolean) = (r5v17 boolean), (r5v20 boolean) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r9v8 cu.todus.android.repositories.MainRepository) = (r9v3 cu.todus.android.repositories.MainRepository), (r9v10 cu.todus.android.repositories.MainRepository) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r10v30 cu.z17.views.utils.Z17BasePictureHeaders) = (r10v27 cu.z17.views.utils.Z17BasePictureHeaders), (r10v32 cu.z17.views.utils.Z17BasePictureHeaders) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r11v22 cu.todus.android.di.PreferencesModule) = (r11v19 cu.todus.android.di.PreferencesModule), (r11v24 cu.todus.android.di.PreferencesModule) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r12v22 cu.todus.android.repositories.AuthRepository) = (r12v19 cu.todus.android.repositories.AuthRepository), (r12v24 cu.todus.android.repositories.AuthRepository) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r13v22 cu.todus.android.di.RetrofitModule) = (r13v19 cu.todus.android.di.RetrofitModule), (r13v24 cu.todus.android.di.RetrofitModule) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r14v22 cu.todus.android.di.DatabaseModule) = (r14v19 cu.todus.android.di.DatabaseModule), (r14v24 cu.todus.android.di.DatabaseModule) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x042b: PHI (r15v22 cu.todus.android.data.preferences.Owner) = (r15v19 cu.todus.android.data.preferences.Owner), (r15v24 cu.todus.android.data.preferences.Owner) binds: [B:50:0x0427, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x0461 A[PHI: r1 r2 r5 r9 r10 r11 r12 r13 r14 r15
      0x0461: PHI (r1v16 boolean) = (r1v14 boolean), (r1v18 boolean) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r2v76 java.lang.Object) = (r2v75 java.lang.Object), (r2v1 java.lang.Object) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r5v21 boolean) = (r5v19 boolean), (r5v22 boolean) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r9v11 cu.todus.android.repositories.MainRepository) = (r9v8 cu.todus.android.repositories.MainRepository), (r9v14 cu.todus.android.repositories.MainRepository) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r10v33 cu.z17.views.utils.Z17BasePictureHeaders) = (r10v30 cu.z17.views.utils.Z17BasePictureHeaders), (r10v36 cu.z17.views.utils.Z17BasePictureHeaders) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r11v25 cu.todus.android.di.PreferencesModule) = (r11v22 cu.todus.android.di.PreferencesModule), (r11v28 cu.todus.android.di.PreferencesModule) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r12v25 cu.todus.android.repositories.AuthRepository) = (r12v22 cu.todus.android.repositories.AuthRepository), (r12v28 cu.todus.android.repositories.AuthRepository) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r13v25 cu.todus.android.di.RetrofitModule) = (r13v22 cu.todus.android.di.RetrofitModule), (r13v28 cu.todus.android.di.RetrofitModule) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r14v25 cu.todus.android.di.DatabaseModule) = (r14v22 cu.todus.android.di.DatabaseModule), (r14v28 cu.todus.android.di.DatabaseModule) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]
      0x0461: PHI (r15v25 cu.todus.android.data.preferences.Owner) = (r15v22 cu.todus.android.data.preferences.Owner), (r15v27 cu.todus.android.data.preferences.Owner) binds: [B:53:0x045d, B:14:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x04e7, code lost:
    
        if (r1.initializeXMPP(r5, r3) == r4) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initializeCompleteApp(final cu.todus.android.data.preferences.Owner r18, boolean r19, boolean r20, ab.e<? super ua.k0> r21) throws cu.z17.singledi.SinglediException {
        /*
            Method dump skipped, instruction units count: 1302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.initializeCompleteApp(cu.todus.android.data.preferences.Owner, boolean, boolean, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object initializeCompleteApp$default(ToDusApp toDusApp, Owner owner, boolean z10, boolean z11, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return toDusApp.initializeCompleteApp(owner, z10, z11, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DatabaseModule initializeCompleteApp$lambda$0(ToDusApp toDusApp, Owner owner) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new DatabaseModule(applicationContext, owner.getNameWithDomain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactDataSource initializeCompleteApp$lambda$1(ToDusApp toDusApp, Owner owner) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new ContactDataSource(applicationContext, owner.getCountryCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomsRepository initializeCompleteApp$lambda$10(AuthRepository authRepository) {
        return new RoomsRepository(new ToDusApp$initializeCompleteApp$10$1(authRepository));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsersRepository initializeCompleteApp$lambda$11(AuthRepository authRepository) {
        return new UsersRepository(new ToDusApp$initializeCompleteApp$11$1(authRepository));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusRepository initializeCompleteApp$lambda$12(AuthRepository authRepository) {
        return new StatusRepository(new ToDusApp$initializeCompleteApp$12$1(authRepository));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WelcomeMessageRepository initializeCompleteApp$lambda$13() {
        return new WelcomeMessageRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactionsRepository initializeCompleteApp$lambda$15() {
        return new ReactionsRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BotShortcutRepository initializeCompleteApp$lambda$16() {
        return new BotShortcutRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MigrationsRepository initializeCompleteApp$lambda$17(AuthRepository authRepository) {
        return new MigrationsRepository(new ToDusApp$initializeCompleteApp$17$1(authRepository));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SentryDataSource initializeCompleteApp$lambda$2(DatabaseModule databaseModule, Owner owner, final PreferencesModule preferencesModule) {
        return new SentryDataSource(databaseModule.getRoomDao(), databaseModule.getMessageDao(), new lb.a() { // from class: cu.todus.android.m
            @Override // lb.a
            public final Object invoke() {
                return preferencesModule.getSentryState();
            }
        }, owner.getNameWithDomain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationDataSource initializeCompleteApp$lambda$3(ToDusApp toDusApp) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new LocationDataSource(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionManager initializeCompleteApp$lambda$4(ToDusApp toDusApp) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new ConnectionManager(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager initializeCompleteApp$lambda$5(ToDusApp toDusApp, Owner owner) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new NotificationManager(applicationContext, owner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainRepository initializeCompleteApp$lambda$6(ToDusApp toDusApp, final AuthRepository authRepository, boolean z10, final Z17BasePictureHeaders z17BasePictureHeaders) {
        Context applicationContext = toDusApp.getApplicationContext();
        kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
        return new MainRepository(applicationContext, new ToDusApp$initializeCompleteApp$mainRepository$1$1(authRepository), new Function1() { // from class: cu.todus.android.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToDusApp.initializeCompleteApp$lambda$6$0(z17BasePictureHeaders, authRepository, (Owner) obj);
            }
        }, new ToDusApp$initializeCompleteApp$mainRepository$1$3(toDusApp), new ToDusApp$initializeCompleteApp$mainRepository$1$4(authRepository, null), new ToDusApp$initializeCompleteApp$mainRepository$1$5(authRepository, null), z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 initializeCompleteApp$lambda$6$0(Z17BasePictureHeaders z17BasePictureHeaders, AuthRepository authRepository, Owner it) {
        kotlin.jvm.internal.y.i(it, "it");
        z17BasePictureHeaders.updateHeaders(TokenAuthenticator.INSTANCE.headerForImage("Pictures", true, it.getToken()));
        authRepository.updateOwner(it);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedDeviceRepository initializeCompleteApp$lambda$7(ToDusApp toDusApp) {
        return new LinkedDeviceRepository(new ToDusApp$initializeCompleteApp$7$1(toDusApp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CatalogueRepository initializeCompleteApp$lambda$8() {
        return new CatalogueRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickersRepository initializeCompleteApp$lambda$9() {
        return new StickersRepository();
    }

    public static /* synthetic */ void manageAlive$default(ToDusApp toDusApp, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        toDusApp.manageAlive(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean notificationDisplayed$lambda$0(String str, InsideNotificationState it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startApp() {
        Base64.setEncoder(new Base64.DefaultEncoder());
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C09551(null), 3, null);
        CoroutineUtilsKt.launchThrottling$default(this.coroutineScope, null, 1000L, 200L, new AnonymousClass2(null), 1, null);
    }

    public final void addNotification(InsideNotificationState newNotification) {
        kotlin.jvm.internal.y.i(newNotification, "newNotification");
        this.insideNotifications.add(newNotification);
    }

    public final void dismissUpdate() {
        this._updateInfo.setValue(null);
    }

    public final void errorRead() {
        this._error.setValue(null);
    }

    public final p0 getAppState() {
        return this.appState;
    }

    public final p0 getError() {
        return this.error;
    }

    public final Z17MutableListFlow<InsideNotificationState> getInsideNotifications() {
        return this.insideNotifications;
    }

    public final p0 getUpdateInfo() {
        return this.updateInfo;
    }

    public final void logout() {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C09531(null), 3, null);
    }

    public final void manageAlive(String actualBatteryPreference, boolean noCheckActivity) {
        kotlin.jvm.internal.y.i(actualBatteryPreference, "actualBatteryPreference");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C09541(actualBatteryPreference, noCheckActivity, null), 3, null);
    }

    public final List<InsideNotificationState> notificationDisplayed(final String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        return this.insideNotifications.removeAll(new Function1() { // from class: cu.todus.android.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ToDusApp.notificationDisplayed$lambda$0(id2, (InsideNotificationState) obj));
            }
        });
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        startApp();
    }

    public final void setError(ToDusException e10) {
        kotlin.jvm.internal.y.i(e10, "e");
        this._error.setValue(e10);
    }

    /* JADX INFO: renamed from: cu.todus.android.ToDusApp$startApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.ToDusApp$startApp$1", f = "ToDusApp.kt", l = {TsExtractor.TS_STREAM_TYPE_E_AC3, 136, 164, WebmConstants.MkvEbmlElement.CUE_TIME, 185, TsExtractor.TS_PACKET_SIZE, 190, 200, 216}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C09551 extends cb.m implements Function1 {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;

        public C09551(ab.e<? super C09551> eVar) {
            super(1, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DirectoryPaths invokeSuspend$lambda$0(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new DirectoryPaths(applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MainModule invokeSuspend$lambda$1(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new MainModule(applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthRepository invokeSuspend$lambda$10(ToDusApp toDusApp, y0 y0Var) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new AuthRepository(applicationContext, (Owner) y0Var.f36634c, new ToDusApp$startApp$1$9$1(toDusApp));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MediaModule invokeSuspend$lambda$11(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new MediaModule(applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PreferencesModule invokeSuspend$lambda$2(ToDusApp toDusApp, MainModule mainModule) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new PreferencesModule(applicationContext, mainModule.getGson());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RetrofitModule invokeSuspend$lambda$3(MainModule mainModule, ToDusApp toDusApp) {
            BaseDataSource baseDataSource = mainModule.getBaseDataSource();
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new RetrofitModule(baseDataSource, applicationContext, toDusApp.appVolatileState.getRootEnvironment());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Z17Markown invokeSuspend$lambda$4(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new Z17Markown(applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Z17CoilDecoders invokeSuspend$lambda$5(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new Z17CoilDecoders(applicationContext, RetrofitModule.INSTANCE.allowAllCertificated(), new Function1() { // from class: cu.todus.android.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ToDusApp.C09551.invokeSuspend$lambda$5$0((String) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$5$0(String str) {
            return HeadersChecker.INSTANCE.needHeaders(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Z17VideoModule invokeSuspend$lambda$6(ToDusApp toDusApp) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new Z17VideoModule(applicationContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Z17CameraModule invokeSuspend$lambda$7(ToDusApp toDusApp, String str) {
            Context applicationContext = toDusApp.getApplicationContext();
            kotlin.jvm.internal.y.h(applicationContext, "getApplicationContext(...)");
            return new Z17CameraModule(applicationContext, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Z17BasePictureHeaders invokeSuspend$lambda$8() {
            return new Z17BasePictureHeaders(null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PathsVolatileState invokeSuspend$lambda$9(DataPreferences dataPreferences) {
            return new PathsVolatileState(dataPreferences);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ToDusApp.this.new C09551(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C09551) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0198  */
        /* JADX WARN: Code duplicated, block: B:34:0x0202 A[PHI: r0 r4 r5 r6
          0x0202: PHI (r0v24 java.lang.Object) = (r0v17 java.lang.Object), (r0v29 java.lang.Object) binds: [B:32:0x01fe, B:12:0x00cb] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r4v15 boolean) = (r4v11 boolean), (r4v19 boolean) binds: [B:32:0x01fe, B:12:0x00cb] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r5v12 cu.todus.android.di.PreferencesModule) = (r5v9 cu.todus.android.di.PreferencesModule), (r5v15 cu.todus.android.di.PreferencesModule) binds: [B:32:0x01fe, B:12:0x00cb] A[DONT_GENERATE, DONT_INLINE]
          0x0202: PHI (r6v13 cu.todus.android.di.MainModule) = (r6v10 cu.todus.android.di.MainModule), (r6v14 cu.todus.android.di.MainModule) binds: [B:32:0x01fe, B:12:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:37:0x0249  */
        /* JADX WARN: Code duplicated, block: B:41:0x0284  */
        /* JADX WARN: Code duplicated, block: B:44:0x0290  */
        /* JADX WARN: Code duplicated, block: B:47:0x02b5  */
        /* JADX WARN: Code duplicated, block: B:50:0x02c3  */
        /* JADX WARN: Code duplicated, block: B:53:0x0314  */
        /* JADX WARN: Code duplicated, block: B:57:0x0366  */
        /* JADX WARN: Code duplicated, block: B:59:0x0370  */
        /* JADX WARN: Code duplicated, block: B:60:0x0372 A[PHI: r0 r5 r6 r7 r8 r10
          0x0372: PHI (r0v38 boolean) = (r0v32 boolean), (r0v34 boolean), (r0v41 boolean) binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]
          0x0372: PHI (r5v32 kotlin.jvm.internal.y0) = (r5v20 kotlin.jvm.internal.y0), (r5v23 kotlin.jvm.internal.y0), (r5v35 kotlin.jvm.internal.y0) binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]
          0x0372: PHI (r6v32 cu.todus.android.data.preferences.DataPreferences) = 
          (r6v19 cu.todus.android.data.preferences.DataPreferences)
          (r6v24 cu.todus.android.data.preferences.DataPreferences)
          (r6v35 cu.todus.android.data.preferences.DataPreferences)
         binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]
          0x0372: PHI (r7v41 java.lang.String) = (r7v29 java.lang.String), (r7v32 java.lang.String), (r7v44 java.lang.String) binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]
          0x0372: PHI (r8v38 cu.todus.android.di.PreferencesModule) = 
          (r8v13 cu.todus.android.di.PreferencesModule)
          (r8v18 cu.todus.android.di.PreferencesModule)
          (r8v40 cu.todus.android.di.PreferencesModule)
         binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]
          0x0372: PHI (r10v10 cu.todus.android.di.MainModule) = (r10v1 cu.todus.android.di.MainModule), (r10v3 cu.todus.android.di.MainModule), (r10v12 cu.todus.android.di.MainModule) binds: [B:43:0x028e, B:59:0x0370, B:58:0x036a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x03c8, code lost:
        
            if (r4.collect(r9, r27) == r2) goto L62;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 998
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.C09551.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cu.todus.android.ToDusApp$startApp$1$11, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass11<T> implements te.i {
            final /* synthetic */ y0 $existingOwner;
            final /* synthetic */ y0 $lastAppState;
            final /* synthetic */ PreferencesModule $preferencesModule;
            final /* synthetic */ ToDusApp this$0;

            public AnonymousClass11(y0 y0Var, ToDusApp toDusApp, y0 y0Var2, PreferencesModule preferencesModule) {
                this.$lastAppState = y0Var;
                this.this$0 = toDusApp;
                this.$existingOwner = y0Var2;
                this.$preferencesModule = preferencesModule;
            }

            /* JADX WARN: Code duplicated, block: B:28:0x0091  */
            /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
            /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
            /* JADX WARN: Code duplicated, block: B:35:0x00e4  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00f2, code lost:
            
                if (r6.initializeCompleteApp(r7, r5, false, r0) == r1) goto L38;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.data.preferences.AppState r14, ab.e<? super ua.k0> r15) {
                /*
                    Method dump skipped, instruction units count: 265
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.ToDusApp.C09551.AnonymousClass11.emit(cu.todus.android.data.preferences.AppState, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar) {
                return emit((AppState) obj, (ab.e<? super k0>) eVar);
            }
        }
    }
}
