package cu.todus.android.notification;

import ab.e;
import android.R;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.configs.Values;
import cu.todus.android.db.dao.notifications.ConfigDao;
import cu.todus.android.webrtc.notification.IncomingCallNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import te.h;
import te.i;
import te.j;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000bJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcu/todus/android/notification/ConfigProcessor;", "", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "configDao", "<init>", "(Lcu/todus/android/db/dao/notifications/ConfigDao;)V", "Lcu/todus/android/data/db/entity/configs/Heritage;", Config.TABLE_NAME, "Lte/h;", "Lcu/todus/android/data/db/entity/configs/Values;", "getConfigByUID", "(Lcu/todus/android/data/db/entity/configs/Heritage;)Lte/h;", "getConfig", "(Lcu/todus/android/data/db/entity/configs/Heritage;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/configs/Config;", "getOrCreate", "", "b", "updateNotificationAlert", "(Lcu/todus/android/data/db/entity/configs/Heritage;Z)Lte/h;", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "getConfigDao", "()Lcu/todus/android/db/dao/notifications/ConfigDao;", "setConfigDao", "defaultConfig", "Lcu/todus/android/data/db/entity/configs/Values;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigProcessor {
    public static final String NOTIFICATION_CHANNEL_DOWNLOAD = "notification_channel_download_v2";
    public static final String NOTIFICATION_CHANNEL_FIREBASE = "notification_channel_firebase";
    public static final String NOTIFICATION_CHANNEL_GENERAL_NOTIFY = "notification_general";
    public static final String NOTIFICATION_CHANNEL_GROUP = "notification_channel_group_id";
    public static final String NOTIFICATION_CHANNEL_PRIVATE_CHAT = "notification_channel_per_to_per_id";
    public static final String NOTIFICATION_CHANNEL_UPLOAD = "notification_channel_upload_v2";
    private ConfigDao configDao;
    private final Values defaultConfig;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcu/todus/android/notification/ConfigProcessor$Companion;", "", "<init>", "()V", "NOTIFICATION_CHANNEL_GROUP", "", "NOTIFICATION_CHANNEL_DOWNLOAD", "NOTIFICATION_CHANNEL_UPLOAD", "NOTIFICATION_CHANNEL_FIREBASE", "NOTIFICATION_CHANNEL_PRIVATE_CHAT", "NOTIFICATION_CHANNEL_GENERAL_NOTIFY", "buildHeritageGroup", "Lcu/todus/android/data/db/entity/configs/Heritage;", "roomId", "buildHeritagePrivateChat", "buildHeritageGeneral", "buildHeritageFirebase", "buildHeritageDownload", "workerHash", "buildHeritageUpload", "buildHeritagePrivateCall", "id", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final Heritage buildHeritageDownload(String workerHash) {
            y.i(workerHash, "workerHash");
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_DOWNLOAD, new Heritage(workerHash, null, 2, null));
        }

        public final Heritage buildHeritageFirebase() {
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_FIREBASE, null, 2, null);
        }

        public final Heritage buildHeritageGeneral() {
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_GENERAL_NOTIFY, null, 2, null);
        }

        public final Heritage buildHeritageGroup(String roomId) {
            y.i(roomId, "roomId");
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_GROUP, new Heritage(roomId, null, 2, null));
        }

        public final Heritage buildHeritagePrivateCall(String id2) {
            y.i(id2, "id");
            return new Heritage(IncomingCallNotificationBuilder.NOTIFICATION_CALL_CHANEL_ID, new Heritage("call_" + id2, null, 2, null));
        }

        public final Heritage buildHeritagePrivateChat(String roomId) {
            y.i(roomId, "roomId");
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_PRIVATE_CHAT, new Heritage(roomId, null, 2, null));
        }

        public final Heritage buildHeritageUpload(String workerHash) {
            y.i(workerHash, "workerHash");
            return new Heritage(ConfigProcessor.NOTIFICATION_CHANNEL_UPLOAD, new Heritage(workerHash, null, 2, null));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.ConfigProcessor$getConfigByUID$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.ConfigProcessor$getConfigByUID$1", f = "ConfigProcessor.kt", l = {24, 25, 26}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/configs/Values;", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        final /* synthetic */ Heritage $heritage;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Heritage heritage, e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$heritage = heritage;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            AnonymousClass1 anonymousClass1 = ConfigProcessor.this.new AnonymousClass1(this.$heritage, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        
            if (r0.emit(r2, r6) == r1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
        
            if (r0.emit(r2, r6) == r1) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                te.i r0 = (te.i) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r6.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2a
                if (r2 == r5) goto L26
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r0 = r6.L$1
                cu.todus.android.data.db.entity.configs.Config r0 = (cu.todus.android.data.db.entity.configs.Config) r0
                ua.v.b(r7)
                goto L7c
            L26:
                ua.v.b(r7)
                goto L44
            L2a:
                ua.v.b(r7)
                cu.todus.android.notification.ConfigProcessor r7 = cu.todus.android.notification.ConfigProcessor.this
                cu.todus.android.db.dao.notifications.ConfigDao r7 = r7.getConfigDao()
                cu.todus.android.data.db.entity.configs.Heritage r2 = r6.$heritage
                java.lang.String r2 = r2.getTag()
                r6.L$0 = r0
                r6.label = r5
                java.lang.Object r7 = r7.getConfig(r2, r6)
                if (r7 != r1) goto L44
                goto L7b
            L44:
                cu.todus.android.data.db.entity.configs.Config r7 = (cu.todus.android.data.db.entity.configs.Config) r7
                if (r7 == 0) goto L61
                cu.todus.android.data.db.entity.configs.Values r2 = r7.getValues()
                java.lang.Object r3 = cb.l.a(r0)
                r6.L$0 = r3
                java.lang.Object r7 = cb.l.a(r7)
                r6.L$1 = r7
                r6.label = r4
                java.lang.Object r7 = r0.emit(r2, r6)
                if (r7 != r1) goto L7c
                goto L7b
            L61:
                cu.todus.android.notification.ConfigProcessor r2 = cu.todus.android.notification.ConfigProcessor.this
                cu.todus.android.data.db.entity.configs.Values r2 = cu.todus.android.notification.ConfigProcessor.access$getDefaultConfig$p(r2)
                java.lang.Object r4 = cb.l.a(r0)
                r6.L$0 = r4
                java.lang.Object r7 = cb.l.a(r7)
                r6.L$1 = r7
                r6.label = r3
                java.lang.Object r7 = r0.emit(r2, r6)
                if (r7 != r1) goto L7c
            L7b:
                return r1
            L7c:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.ConfigProcessor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(i iVar, e<? super k0> eVar) {
            return ((AnonymousClass1) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.ConfigProcessor$getOrCreate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.ConfigProcessor$getOrCreate$1", f = "ConfigProcessor.kt", l = {32, 35, 39, 41}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/configs/Config;", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10121 extends m implements Function2 {
        final /* synthetic */ Heritage $heritage;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ConfigProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10121(Heritage heritage, ConfigProcessor configProcessor, e<? super C10121> eVar) {
            super(2, eVar);
            this.$heritage = heritage;
            this.this$0 = configProcessor;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            C10121 c10121 = new C10121(this.$heritage, this.this$0, eVar);
            c10121.L$0 = obj;
            return c10121;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00b1  */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
        
            if (r0.emit(r9, r8) == r1) goto L29;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.ConfigProcessor.C10121.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(i iVar, e<? super k0> eVar) {
            return ((C10121) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.ConfigProcessor$updateNotificationAlert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.ConfigProcessor$updateNotificationAlert$1", f = "ConfigProcessor.kt", l = {45, 54, 56, 58}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10131 extends m implements Function2 {
        final /* synthetic */ boolean $b;
        final /* synthetic */ Heritage $heritage;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10131(Heritage heritage, boolean z10, e<? super C10131> eVar) {
            super(2, eVar);
            this.$heritage = heritage;
            this.$b = z10;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            C10131 c10131 = ConfigProcessor.this.new C10131(this.$heritage, this.$b, eVar);
            c10131.L$0 = obj;
            return c10131;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
        
            if (r1.emit(r9, r19) == r2) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00f8, code lost:
        
            if (r1.emit(r3, r19) == r2) goto L29;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.ConfigProcessor.C10131.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(i iVar, e<? super k0> eVar) {
            return ((C10131) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public ConfigProcessor(ConfigDao configDao) {
        y.i(configDao, "configDao");
        this.configDao = configDao;
        this.defaultConfig = new Values(true, Config.INSTANCE.getSOUND_DEFAULT(), 3, R.color.white);
    }

    private final h getConfigByUID(Heritage heritage) {
        return j.B(new AnonymousClass1(heritage, null));
    }

    public final Object getConfig(Heritage heritage, e<? super Values> eVar) {
        return j.x(getConfigByUID(heritage), eVar);
    }

    public final ConfigDao getConfigDao() {
        return this.configDao;
    }

    public final h getOrCreate(Heritage heritage) {
        y.i(heritage, "heritage");
        return j.B(new C10121(heritage, this, null));
    }

    public final void setConfigDao(ConfigDao configDao) {
        y.i(configDao, "<set-?>");
        this.configDao = configDao;
    }

    public final h updateNotificationAlert(Heritage heritage, boolean b10) {
        y.i(heritage, "heritage");
        return j.B(new C10131(heritage, b10, null));
    }
}
