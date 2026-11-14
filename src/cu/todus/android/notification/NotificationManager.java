package cu.todus.android.notification;

import ab.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.util.SparseArray;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.SparseArrayKt;
import cb.f;
import cb.m;
import cu.todus.android.constants.CloudType;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.configs.Values;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.db.dao.notifications.ConfigDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.image.ImageLoader;
import cu.todus.android.notification.notifications.INotification;
import cu.todus.android.uiCompose.main.MainActivity;
import cu.todus.android.utils.ColorGenerator;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.NotificationEvents;
import cu.z17.singledi.SingletonInitializer;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ke.q;
import ke.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.b0;
import te.h;
import te.i;
import te.j;
import te.r0;
import ua.k0;
import ua.v;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 j2\u00020\u0001:\u0001jB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0010\u001a\u00020\u000f2$\u0010\u000e\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#J5\u0010+\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b-\u0010.J=\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b2\u0010.J\r\u00103\u001a\u00020\u0013¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u00020\u000f2\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u0004\u0018\u000105¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u000f2\u0006\u00106\u001a\u000205¢\u0006\u0004\b=\u00108J\u0015\u0010>\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b>\u0010?J\u001b\u0010>\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b>\u0010@J\r\u0010B\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\u0018\u0010E\u001a\u00020D2\u0006\u0010\u0012\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bE\u0010FJ#\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130H2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u0013¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\u000f¢\u0006\u0004\bK\u0010LJ\r\u0010N\u001a\u00020M¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\bP\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010QR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020M0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0]0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001c\u0010h\u001a\b\u0012\u0004\u0012\u0002050g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lcu/todus/android/notification/NotificationManager;", "", "Landroid/content/Context;", "context", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Landroid/content/Context;Lcu/todus/android/data/preferences/Owner;)V", "Lkotlin/Pair;", "Lcu/todus/android/data/db/entity/configs/Values;", "", "Lcu/todus/android/data/db/entity/configs/Heritage;", "", "Lcu/todus/android/notification/notifications/INotification;", CloudType.WORKER_NOTIFICATION, "Lua/k0;", "delegateNotify", "(Lkotlin/Pair;)V", Config.TABLE_NAME, "", "directNotification", "(Lcu/todus/android/data/db/entity/configs/Heritage;)Z", "Lcu/todus/android/data/db/entity/toDus/Room;", MarkerAction.COLUMN_ROOM, "Landroid/content/Intent;", "createDynamicShortcutIntent", "(Lcu/todus/android/data/db/entity/toDus/Room;)Landroid/content/Intent;", "", "Lcu/todus/android/data/db/pojo/RoomItemView;", Room.TABLE_NAME, "Landroidx/core/content/pm/ShortcutInfoCompat;", "createShortcuts", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/core/app/Person;", "createPerson", "(Lcu/todus/android/data/db/pojo/RoomItemView;)Landroidx/core/app/Person;", "", "attId", "fileName", "", "bytesUsed", "totalBytes", "isCompleted", "showDownloadProgress", "(Ljava/lang/String;Ljava/lang/String;JJZ)V", "dismissDownloadProgress", "(Ljava/lang/String;)V", Room.COLUMN_LAST_MSG, "showUploadProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZ)V", "dismissUploadProgress", "checkForFirebasePushNotification", "()Z", "Lcu/todus/android/notification/INotificationFilter;", "filter", "register", "(Lcu/todus/android/notification/INotificationFilter;)V", "cancelNotifications", "(Lcu/todus/android/data/db/entity/configs/Heritage;)V", "unregisterActualFilter", "()Lcu/todus/android/notification/INotificationFilter;", "unRegister", "notify", "(Lcu/todus/android/notification/notifications/INotification;)V", "(Ljava/util/List;)V", "Lcu/todus/android/notification/ConfigProcessor;", "configProcessor", "()Lcu/todus/android/notification/ConfigProcessor;", "Lcu/todus/android/data/db/entity/configs/Config;", "getOrCreateConfig", "(Lcu/todus/android/data/db/entity/configs/Heritage;Lab/e;)Ljava/lang/Object;", "b", "Lte/h;", "updateNotificationAlert", "(Lcu/todus/android/data/db/entity/configs/Heritage;Z)Lte/h;", "reNotify", "()V", "", "maxShortcut", "()I", "updateShortcut", "Landroid/content/Context;", "Lcu/todus/android/data/preferences/Owner;", "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "Landroidx/core/app/NotificationManagerCompat;", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "configDao", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "Lte/b0;", "notifications", "Lte/b0;", "j$/util/concurrent/ConcurrentHashMap", "", "notificationsMap", "Lj$/util/concurrent/ConcurrentHashMap;", "Lcu/todus/android/notification/SystemNotificationExecutor;", "executorNotification", "Lcu/todus/android/notification/SystemNotificationExecutor;", "Lcu/todus/android/notification/ConfigProcessor;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Landroid/util/SparseArray;", "filters", "Landroid/util/SparseArray;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NotificationManager {
    private final ConfigDao configDao;
    private final ConfigProcessor configProcessor;
    private final Context context;
    private final m0 coroutineScope;
    private SystemNotificationExecutor executorNotification;
    private SparseArray<INotificationFilter> filters;
    private final NotificationManagerCompat notificationManagerCompat;
    private final b0 notifications;
    private final ConcurrentHashMap<Heritage, Set<INotification>> notificationsMap;
    private final Owner owner;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/notification/NotificationManager$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/notification/NotificationManager;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<NotificationManager> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.NotificationManager$updateNotificationAlert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.NotificationManager$updateNotificationAlert$1", f = "NotificationManager.kt", l = {210, 211}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lte/i;", "", "Lua/k0;", "<anonymous>", "(Lte/i;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10141 extends m implements Function2 {
        final /* synthetic */ boolean $b;
        final /* synthetic */ Heritage $heritage;
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10141(Heritage heritage, boolean z10, e<? super C10141> eVar) {
            super(2, eVar);
            this.$heritage = heritage;
            this.$b = z10;
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            C10141 c10141 = NotificationManager.this.new C10141(this.$heritage, this.$b, eVar);
            c10141.L$0 = obj;
            return c10141;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        
            if (r0.emit(r2, r6) == r1) goto L15;
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
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                ua.v.b(r7)
                goto L59
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                ua.v.b(r7)
                goto L3e
            L22:
                ua.v.b(r7)
                cu.todus.android.notification.NotificationManager r7 = cu.todus.android.notification.NotificationManager.this
                cu.todus.android.notification.ConfigProcessor r7 = cu.todus.android.notification.NotificationManager.access$getConfigProcessor$p(r7)
                cu.todus.android.data.db.entity.configs.Heritage r2 = r6.$heritage
                boolean r5 = r6.$b
                te.h r7 = r7.updateNotificationAlert(r2, r5)
                r6.L$0 = r0
                r6.label = r4
                java.lang.Object r7 = te.j.x(r7, r6)
                if (r7 != r1) goto L3e
                goto L58
            L3e:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                java.lang.Boolean r2 = cb.b.a(r7)
                java.lang.Object r4 = cb.l.a(r0)
                r6.L$0 = r4
                r6.Z$0 = r7
                r6.label = r3
                java.lang.Object r7 = r0.emit(r2, r6)
                if (r7 != r1) goto L59
            L58:
                return r1
            L59:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.NotificationManager.C10141.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(i iVar, e<? super k0> eVar) {
            return ((C10141) create(iVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public NotificationManager(Context context, Owner owner) {
        y.i(context, "context");
        y.i(owner, "owner");
        this.context = context;
        this.owner = owner;
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        y.h(notificationManagerCompatFrom, "from(...)");
        this.notificationManagerCompat = notificationManagerCompatFrom;
        ConfigDao configDao = DatabaseModule.INSTANCE.getInstance().getConfigDao();
        this.configDao = configDao;
        this.notifications = r0.a(0);
        this.notificationsMap = new ConcurrentHashMap<>();
        this.executorNotification = new SystemNotificationExecutor(owner, context, notificationManagerCompatFrom);
        this.configProcessor = new ConfigProcessor(configDao);
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.coroutineScope = m0VarA;
        this.filters = new SparseArray<>();
        CoroutineUtilsKt.launchWithContext$default(m0VarA, null, null, new AnonymousClass1(null), 3, null);
    }

    private final Intent createDynamicShortcutIntent(Room room) {
        Intent data = new Intent(this.context, (Class<?>) MainActivity.class).setAction("android.intent.action.VIEW").setFlags(32768).setData(Uri.parse("https://chat.todus.cu/direct/" + (room != null ? room.getId() : null)));
        y.h(data, "setData(...)");
        return data;
    }

    private final Person createPerson(RoomItemView room) {
        Person personBuild = new Person.Builder().setName(room.getName()).setIcon(IconCompat.createWithAdaptiveBitmap(ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, room.getPhoto(), room.getName(), ColorGenerator.INSTANCE.getMATERIAL().getColor(room.getName()), false, 16, null))).setImportant(true).setKey(room.getRoom().getId()).setUri("https://chat.todus.cu/direct/" + room.getRoom().getId()).build();
        y.h(personBuild, "build(...)");
        return personBuild;
    }

    private final List<ShortcutInfoCompat> createShortcuts(List<RoomItemView> rooms) {
        if (Build.VERSION.SDK_INT < 29) {
            return w.n();
        }
        ArrayList arrayList = new ArrayList(x.y(rooms, 10));
        for (RoomItemView roomItemView : rooms) {
            arrayList.add(new ShortcutInfoCompat.Builder(this.context, roomItemView.getRoom().getId()).setActivity(new ComponentName(this.context, (Class<?>) MainActivity.class)).setShortLabel(roomItemView.getName()).setIcon(IconCompat.createWithAdaptiveBitmap(ImageLoader.getCircleImage$default(ImageLoader.INSTANCE, this.context, roomItemView.getPhoto(), roomItemView.getName(), ColorGenerator.INSTANCE.getMATERIAL().getColor(roomItemView.getName()), false, 16, null))).setLongLived(true).setIntent(createDynamicShortcutIntent(roomItemView.getRoom())).setPerson(createPerson(roomItemView)).build());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delegateNotify(final Pair<Values, ? extends Map.Entry<Heritage, ? extends Set<? extends INotification>>> notification) {
        if (u.a0(u.E(q.g(SparseArrayKt.valueIterator(this.filters)), new Function1() { // from class: cu.todus.android.notification.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NotificationManager.delegateNotify$lambda$0(notification, (INotificationFilter) obj));
            }
        })).isEmpty()) {
            this.executorNotification.notify(notification);
        } else {
            NotificationEvents.INSTANCE.playReceivedNotification();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean delegateNotify$lambda$0(Pair pair, INotificationFilter it) {
        y.i(it, "it");
        return it.apply((Heritage) ((Map.Entry) pair.getSecond()).getKey());
    }

    private final boolean directNotification(final Heritage heritage) {
        List listA0 = u.a0(u.E(q.g(SparseArrayKt.valueIterator(this.filters)), new Function1() { // from class: cu.todus.android.notification.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NotificationManager.directNotification$lambda$0(heritage, (INotificationFilter) obj));
            }
        }));
        if (!listA0.isEmpty()) {
            NotificationEvents.INSTANCE.playReceivedNotification();
        }
        return !listA0.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean directNotification$lambda$0(Heritage heritage, INotificationFilter it) {
        y.i(it, "it");
        return it.apply(heritage);
    }

    public final void cancelNotifications(Heritage heritage) {
        y.i(heritage, "heritage");
        this.executorNotification.cancel(heritage);
        this.notificationsMap.remove(heritage);
        this.notifications.setValue(Integer.valueOf(this.notificationsMap.size()));
    }

    public final boolean checkForFirebasePushNotification() {
        try {
            List<StatusBarNotification> activeNotifications = this.notificationManagerCompat.getActiveNotifications();
            y.h(activeNotifications, "getActiveNotifications(...)");
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification.getId() == 0) {
                    this.notificationManagerCompat.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: configProcessor, reason: from getter */
    public final ConfigProcessor getConfigProcessor() {
        return this.configProcessor;
    }

    public final void dismissDownloadProgress(String attId) {
        y.i(attId, "attId");
        this.executorNotification.dismissDirectDownload(attId);
    }

    public final void dismissUploadProgress(String attId) {
        y.i(attId, "attId");
        this.executorNotification.dismissDirectUpload(attId);
    }

    public final Object getOrCreateConfig(Heritage heritage, e<? super Config> eVar) {
        return j.x(this.configProcessor.getOrCreate(heritage), eVar);
    }

    public final int maxShortcut() {
        return ShortcutManagerCompat.getMaxShortcutCountPerActivity(this.context);
    }

    public final void notify(INotification notification) {
        y.i(notification, "notification");
        if (directNotification(notification.getHeritage())) {
            return;
        }
        if (this.notificationsMap.containsKey(notification.getHeritage())) {
            Set<INotification> set = this.notificationsMap.get(notification.getHeritage());
            if (set != null) {
                set.remove(notification);
            }
        } else {
            this.notificationsMap.put(notification.getHeritage(), new LinkedHashSet());
        }
        Set<INotification> set2 = this.notificationsMap.get(notification.getHeritage());
        if (y.d(set2 != null ? Boolean.valueOf(set2.add(notification)) : null, Boolean.TRUE)) {
            this.notifications.setValue(Integer.valueOf(this.notificationsMap.size()));
        }
    }

    public final void reNotify() {
        if (this.notificationsMap.isEmpty()) {
            return;
        }
        this.notifications.setValue(Integer.valueOf(this.notificationsMap.size()));
    }

    public final void register(INotificationFilter filter) {
        y.i(filter, "filter");
        this.filters.put(filter.hashCode(), filter);
        cancelNotifications(filter.heritage());
    }

    public final void showDownloadProgress(String attId, String fileName, long bytesUsed, long totalBytes, boolean isCompleted) {
        y.i(attId, "attId");
        y.i(fileName, "fileName");
        this.executorNotification.notifyShowDirectDownloadProgress(attId, fileName, bytesUsed, totalBytes, isCompleted);
    }

    public final void showUploadProgress(String msgId, String attId, String fileName, long bytesUsed, long totalBytes, boolean isCompleted) {
        y.i(msgId, "msgId");
        y.i(attId, "attId");
        y.i(fileName, "fileName");
        this.executorNotification.notifyShowDirectUploadProgress(msgId, attId, fileName, bytesUsed, totalBytes, isCompleted);
    }

    public final void unRegister(INotificationFilter filter) {
        y.i(filter, "filter");
        this.filters.remove(filter.hashCode());
        this.notifications.setValue(Integer.valueOf(this.notificationsMap.size()));
    }

    public final INotificationFilter unregisterActualFilter() {
        if (this.filters.size() == 0) {
            return null;
        }
        SparseArray<INotificationFilter> sparseArray = this.filters;
        INotificationFilter iNotificationFilter = sparseArray.get(sparseArray.keyAt(0));
        this.filters.removeAt(0);
        return iNotificationFilter;
    }

    public final h updateNotificationAlert(Heritage heritage, boolean b10) {
        y.i(heritage, "heritage");
        return j.B(new C10141(heritage, b10, null));
    }

    public final void updateShortcut(List<RoomItemView> rooms) {
        y.i(rooms, "rooms");
        try {
            List<ShortcutInfoCompat> listCreateShortcuts = createShortcuts(rooms);
            ShortcutManagerCompat.removeAllDynamicShortcuts(this.context);
            ShortcutManagerCompat.addDynamicShortcuts(this.context, listCreateShortcuts);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void notify(List<? extends INotification> notification) {
        y.i(notification, "notification");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : notification) {
            Heritage heritage = ((INotification) obj).getHeritage();
            Object arrayList = linkedHashMap.get(heritage);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(heritage, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!directNotification((Heritage) entry.getKey())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!this.notificationsMap.containsKey(entry2.getKey())) {
                this.notificationsMap.put((Heritage) entry2.getKey(), new LinkedHashSet());
            }
            Set<INotification> set = this.notificationsMap.get(entry2.getKey());
            if (set != null) {
                set.addAll((Collection) entry2.getValue());
            }
        }
        b0 b0Var = this.notifications;
        b0Var.setValue(Integer.valueOf(((Number) b0Var.getValue()).intValue() + this.notificationsMap.size()));
    }

    /* JADX INFO: renamed from: cu.todus.android.notification.NotificationManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.notification.NotificationManager$1", f = "NotificationManager.kt", l = {69}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function1 {
        int label;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final e<k0> create(e<?> eVar) {
            return NotificationManager.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                b0 b0Var = NotificationManager.this.notifications;
                C02031 c02031 = new C02031(NotificationManager.this);
                this.label = 1;
                if (b0Var.collect(c02031, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            throw new ua.j();
        }

        /* JADX INFO: renamed from: cu.todus.android.notification.NotificationManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class C02031<T> implements i {
            final /* synthetic */ NotificationManager this$0;

            public C02031(NotificationManager notificationManager) {
                this.this$0 = notificationManager;
            }

            /* JADX WARN: Code duplicated, block: B:26:0x009b  */
            /* JADX WARN: Code duplicated, block: B:29:0x00c2  */
            /* JADX WARN: Code duplicated, block: B:32:0x0104  */
            /* JADX WARN: Code duplicated, block: B:34:0x0111  */
            /* JADX WARN: Code duplicated, block: B:37:0x011f A[LOOP:0: B:35:0x0119->B:37:0x011f, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0088 -> B:23:0x008c). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0104 -> B:33:0x0105). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object emit(int r17, ab.e<? super ua.k0> r18) {
                /*
                    Method dump skipped, instruction units count: 315
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.notification.NotificationManager.AnonymousClass1.C02031.emit(int, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit(((Number) obj).intValue(), (e<? super k0>) eVar);
            }
        }
    }
}
