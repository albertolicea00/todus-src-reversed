package cu.todus.android.db.dao.cache;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0014\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcu/todus/android/db/dao/cache/WelcomeMessageDao_Impl;", "Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "", "Lcu/todus/android/data/db/entity/cache/WelcomeMessage;", "objs", "Lua/k0;", "insert", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "", "lastId", "getNextByLastId", "(ILab/e;)Ljava/lang/Object;", "getMessagesCant", "(Lab/e;)Ljava/lang/Object;", "getMaxId", "id", "deleteById", "deleteAll", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfWelcomeMessage", "Landroidx/room/EntityInsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WelcomeMessageDao_Impl implements WelcomeMessageDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WelcomeMessage> __insertAdapterOfWelcomeMessage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/cache/WelcomeMessageDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final List<sb.d> getRequiredConverters() {
            return va.w.n();
        }

        private Companion() {
        }
    }

    public WelcomeMessageDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfWelcomeMessage = new EntityInsertAdapter<WelcomeMessage>() { // from class: cu.todus.android.db.dao.cache.WelcomeMessageDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `welcome_message` (`id`,`title`,`text`,`image`,`url`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, WelcomeMessage entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getTitle());
                statement.mo9387bindText(3, entity.getText());
                statement.mo9387bindText(4, entity.getImage());
                statement.mo9387bindText(5, entity.getUrl());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteAll$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteById$lambda$0(String str, int i10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMaxId$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMessagesCant$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WelcomeMessage getNextByLastId$lambda$0(String str, int i10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            return sQLiteStatementPrepare.step() ? new WelcomeMessage((int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "title")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "text")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "image")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "url"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 insert$lambda$0(WelcomeMessageDao_Impl welcomeMessageDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        welcomeMessageDao_Impl.__insertAdapterOfWelcomeMessage.insert(_connection, list);
        return k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object deleteAll(ab.e<? super k0> eVar) {
        final String str = "DELETE FROM welcome_message";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WelcomeMessageDao_Impl.deleteAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object deleteById(final int i10, ab.e<? super k0> eVar) {
        final String str = "DELETE FROM welcome_message WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WelcomeMessageDao_Impl.deleteById$lambda$0(str, i10, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object getMaxId(ab.e<? super Integer> eVar) {
        final String str = "SELECT MAX(id) FROM welcome_message";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(WelcomeMessageDao_Impl.getMaxId$lambda$0(str, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object getMessagesCant(ab.e<? super Integer> eVar) {
        final String str = "SELECT COUNT(*) FROM welcome_message";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(WelcomeMessageDao_Impl.getMessagesCant$lambda$0(str, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object getNextByLastId(final int i10, ab.e<? super WelcomeMessage> eVar) {
        final String str = "SELECT * FROM welcome_message WHERE id > ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WelcomeMessageDao_Impl.getNextByLastId$lambda$0(str, i10, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.WelcomeMessageDao
    public Object insert(final List<WelcomeMessage> list, ab.e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WelcomeMessageDao_Impl.insert$lambda$0(this.f20280c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }
}
