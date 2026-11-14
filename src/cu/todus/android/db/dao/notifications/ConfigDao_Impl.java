package cu.todus.android.db.dao.notifications;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import bb.b;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Values;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.db.dao.notifications.ConfigDao_Impl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import sb.d;
import ua.k0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\nJ\u001e\u0010\u0010\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0011\u0010\nJ\u001e\u0010\u0012\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u000eJ\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006#"}, d2 = {"Lcu/todus/android/db/dao/notifications/ConfigDao_Impl;", "Lcu/todus/android/db/dao/notifications/ConfigDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/configs/Config;", Room.CONFIG_CONFIG, "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/configs/Config;Lab/e;)Ljava/lang/Object;", "", "configs", "insertAll", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "delete", "deleteAll", DiscoverItems.Item.UPDATE_ACTION, "updateAll", "allNotificationRx", "(Lab/e;)Ljava/lang/Object;", "", "tag", "getConfig", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfConfig", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfConfig_1", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfConfig", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfConfig", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigDao_Impl implements ConfigDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<Config> __deleteAdapterOfConfig;
    private final EntityInsertAdapter<Config> __insertAdapterOfConfig;
    private final EntityInsertAdapter<Config> __insertAdapterOfConfig_1;
    private final EntityDeleteOrUpdateAdapter<Config> __updateAdapterOfConfig;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/notifications/ConfigDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final List<d> getRequiredConverters() {
            return w.n();
        }

        private Companion() {
        }
    }

    public ConfigDao_Impl(RoomDatabase __db) {
        y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfConfig = new EntityInsertAdapter<Config>() { // from class: cu.todus.android.db.dao.notifications.ConfigDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `heritage` (`tag`,`alert`,`sound`,`priority`,`color`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Config entity) {
                y.i(statement, "statement");
                y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getTag());
                Values values = entity.getValues();
                statement.mo9385bindLong(2, values.getAlert() ? 1L : 0L);
                statement.mo9387bindText(3, values.getSound());
                statement.mo9385bindLong(4, values.getPriority());
                statement.mo9385bindLong(5, values.getColor());
            }
        };
        this.__insertAdapterOfConfig_1 = new EntityInsertAdapter<Config>() { // from class: cu.todus.android.db.dao.notifications.ConfigDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `heritage` (`tag`,`alert`,`sound`,`priority`,`color`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Config entity) {
                y.i(statement, "statement");
                y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getTag());
                Values values = entity.getValues();
                statement.mo9385bindLong(2, values.getAlert() ? 1L : 0L);
                statement.mo9387bindText(3, values.getSound());
                statement.mo9385bindLong(4, values.getPriority());
                statement.mo9385bindLong(5, values.getColor());
            }
        };
        this.__deleteAdapterOfConfig = new EntityDeleteOrUpdateAdapter<Config>() { // from class: cu.todus.android.db.dao.notifications.ConfigDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "DELETE FROM `heritage` WHERE `tag` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Config entity) {
                y.i(statement, "statement");
                y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getTag());
            }
        };
        this.__updateAdapterOfConfig = new EntityDeleteOrUpdateAdapter<Config>() { // from class: cu.todus.android.db.dao.notifications.ConfigDao_Impl.4
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR REPLACE `heritage` SET `tag` = ?,`alert` = ?,`sound` = ?,`priority` = ?,`color` = ? WHERE `tag` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Config entity) {
                y.i(statement, "statement");
                y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getTag());
                Values values = entity.getValues();
                statement.mo9385bindLong(2, values.getAlert() ? 1L : 0L);
                statement.mo9387bindText(3, values.getSound());
                statement.mo9385bindLong(4, values.getPriority());
                statement.mo9385bindLong(5, values.getColor());
                statement.mo9387bindText(6, entity.getTag());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allNotificationRx$lambda$0(String str, SQLiteConnection _connection) {
        y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tag");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "alert");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sound");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "priority");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "color");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new Config(sQLiteStatementPrepare.getText(columnIndexOrThrow), new Values(((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5))));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 delete$lambda$0(ConfigDao_Impl configDao_Impl, Config config, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__deleteAdapterOfConfig.handle(_connection, config);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteAll$lambda$0(ConfigDao_Impl configDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__deleteAdapterOfConfig.handleMultiple(_connection, list);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Config getConfig$lambda$0(String str, String str2, SQLiteConnection _connection) {
        Config config;
        y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        boolean z10 = true;
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tag");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "alert");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "sound");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "priority");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "color");
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow2)) == 0) {
                    z10 = false;
                }
                config = new Config(text, new Values(z10, sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
            } else {
                config = null;
            }
            return config;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 insert$lambda$0(ConfigDao_Impl configDao_Impl, Config config, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__insertAdapterOfConfig.insert(_connection, config);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 insertAll$lambda$0(ConfigDao_Impl configDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__insertAdapterOfConfig_1.insert(_connection, list);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 update$lambda$0(ConfigDao_Impl configDao_Impl, Config config, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__updateAdapterOfConfig.handle(_connection, config);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 updateAll$lambda$0(ConfigDao_Impl configDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        y.i(_connection, "_connection");
        configDao_Impl.__updateAdapterOfConfig.handleMultiple(_connection, list);
        return k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object allNotificationRx(e<? super List<Config>> eVar) {
        final String str = "SELECT * FROM heritage";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: e7.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.allNotificationRx$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object delete(final Config config, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.delete$lambda$0(this.f30861c, config, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object deleteAll(final List<Config> list, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.deleteAll$lambda$0(this.f30855c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object getConfig(final String str, e<? super Config> eVar) {
        final String str2 = "SELECT * FROM heritage WHERE tag = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: e7.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.getConfig$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object insert(final Config config, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.insert$lambda$0(this.f30866c, config, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object insertAll(final List<Config> list, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.insertAll$lambda$0(this.f30864c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object update(final Config config, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.update$lambda$0(this.f30859c, config, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.notifications.ConfigDao
    public Object updateAll(final List<Config> list, e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: e7.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConfigDao_Impl.updateAll$lambda$0(this.f30857c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == b.g() ? objPerformSuspending : k0.f43947a;
    }
}
