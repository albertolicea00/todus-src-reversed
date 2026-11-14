package cu.todus.android.db.dao.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.toDus.RosterChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\f\u0010\nJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0016\u0010\u0013J&\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0018\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u001b\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcu/todus/android/db/dao/toDus/RosterChangeDao_Impl;", "Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/toDus/RosterChange;", "change", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/RosterChange;Lab/e;)Ljava/lang/Object;", "Lua/k0;", DiscoverItems.Item.UPDATE_ACTION, "", "getPendingChanges", "(Lab/e;)Ljava/lang/Object;", "", "phone", "getPendingChangeForPhone", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "", "getPendingCount", "getPendingDeleteByPhone", "ids", "version", "markAsSynced", "(Ljava/util/List;ILab/e;)Ljava/lang/Object;", "clearSynced", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfRosterChange", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfRosterChange", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterChangeDao_Impl implements RosterChangeDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<RosterChange> __insertAdapterOfRosterChange;
    private final EntityDeleteOrUpdateAdapter<RosterChange> __updateAdapterOfRosterChange;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/RosterChangeDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    public RosterChangeDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRosterChange = new EntityInsertAdapter<RosterChange>() { // from class: cu.todus.android.db.dao.toDus.RosterChangeDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR ABORT INTO `roster_change` (`id`,`phone`,`changeType`,`timestamp`,`previousName`,`currentName`,`synced`,`targetVersion`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, RosterChange entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getPhone());
                statement.mo9387bindText(3, entity.getChangeType());
                statement.mo9385bindLong(4, entity.getTimestamp());
                String previousName = entity.getPreviousName();
                if (previousName == null) {
                    statement.mo9386bindNull(5);
                } else {
                    statement.mo9387bindText(5, previousName);
                }
                String currentName = entity.getCurrentName();
                if (currentName == null) {
                    statement.mo9386bindNull(6);
                } else {
                    statement.mo9387bindText(6, currentName);
                }
                statement.mo9385bindLong(7, entity.getSynced() ? 1L : 0L);
                Integer targetVersion = entity.getTargetVersion();
                if (targetVersion == null) {
                    statement.mo9386bindNull(8);
                } else {
                    statement.mo9385bindLong(8, targetVersion.intValue());
                }
            }
        };
        this.__updateAdapterOfRosterChange = new EntityDeleteOrUpdateAdapter<RosterChange>() { // from class: cu.todus.android.db.dao.toDus.RosterChangeDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `roster_change` SET `id` = ?,`phone` = ?,`changeType` = ?,`timestamp` = ?,`previousName` = ?,`currentName` = ?,`synced` = ?,`targetVersion` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, RosterChange entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getPhone());
                statement.mo9387bindText(3, entity.getChangeType());
                statement.mo9385bindLong(4, entity.getTimestamp());
                String previousName = entity.getPreviousName();
                if (previousName == null) {
                    statement.mo9386bindNull(5);
                } else {
                    statement.mo9387bindText(5, previousName);
                }
                String currentName = entity.getCurrentName();
                if (currentName == null) {
                    statement.mo9386bindNull(6);
                } else {
                    statement.mo9387bindText(6, currentName);
                }
                statement.mo9385bindLong(7, entity.getSynced() ? 1L : 0L);
                Integer targetVersion = entity.getTargetVersion();
                if (targetVersion == null) {
                    statement.mo9386bindNull(8);
                } else {
                    statement.mo9385bindLong(8, targetVersion.intValue());
                }
                statement.mo9385bindLong(9, entity.getId());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 clearSynced$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RosterChange getPendingChangeForPhone$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "changeType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "previousName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currentName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "synced");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "targetVersion");
            RosterChange rosterChange = null;
            if (sQLiteStatementPrepare.step()) {
                rosterChange = new RosterChange(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
            }
            return rosterChange;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPendingChanges$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "changeType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "previousName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currentName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "synced");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "targetVersion");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new RosterChange(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8))));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getPendingCount$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RosterChange getPendingDeleteByPhone$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "changeType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "previousName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currentName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "synced");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "targetVersion");
            RosterChange rosterChange = null;
            if (sQLiteStatementPrepare.step()) {
                rosterChange = new RosterChange(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
            }
            return rosterChange;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(RosterChangeDao_Impl rosterChangeDao_Impl, RosterChange rosterChange, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return rosterChangeDao_Impl.__insertAdapterOfRosterChange.insertAndReturnId(_connection, rosterChange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 markAsSynced$lambda$0(String str, int i10, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            Iterator it = list.iterator();
            int i11 = 2;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9385bindLong(i11, ((Number) it.next()).longValue());
                i11++;
            }
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 update$lambda$0(RosterChangeDao_Impl rosterChangeDao_Impl, RosterChange rosterChange, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        rosterChangeDao_Impl.__updateAdapterOfRosterChange.handle(_connection, rosterChange);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object clearSynced(ab.e<? super ua.k0> eVar) {
        final String str = "DELETE FROM roster_change WHERE synced = 1";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.clearSynced$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object getPendingChangeForPhone(final String str, ab.e<? super RosterChange> eVar) {
        final String str2 = "SELECT * FROM roster_change WHERE phone = ? AND synced = 0 LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.d5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.getPendingChangeForPhone$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object getPendingChanges(ab.e<? super List<RosterChange>> eVar) {
        final String str = "SELECT * FROM roster_change WHERE synced = 0 ORDER BY timestamp ASC";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.j5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.getPendingChanges$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object getPendingCount(ab.e<? super Integer> eVar) {
        final String str = "SELECT COUNT(*) FROM roster_change WHERE synced = 0";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(RosterChangeDao_Impl.getPendingCount$lambda$0(str, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object getPendingDeleteByPhone(final String str, ab.e<? super RosterChange> eVar) {
        final String str2 = "SELECT * FROM roster_change WHERE phone = ? AND changeType = 'delete' AND synced = 0 LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.getPendingDeleteByPhone$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object insert(final RosterChange rosterChange, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.e5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(RosterChangeDao_Impl.insert$lambda$0(this.f20379c, rosterChange, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object markAsSynced(final List<Long> list, final int i10, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE roster_change SET synced = 1, targetVersion = ");
        sb2.append("?");
        sb2.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.i5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.markAsSynced$lambda$0(string, i10, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RosterChangeDao
    public Object update(final RosterChange rosterChange, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.g5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RosterChangeDao_Impl.update$lambda$0(this.f20420c, rosterChange, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
