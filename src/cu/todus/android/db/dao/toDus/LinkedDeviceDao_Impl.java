package cu.todus.android.db.dao.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\nJ\u001b\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcu/todus/android/db/dao/toDus/LinkedDeviceDao_Impl;", "Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "linkedDevice", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/LinkedDevice;Lab/e;)Ljava/lang/Object;", "", "linkedDevices", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lua/k0;", "delete", "Landroidx/paging/PagingSource;", "", "getAll", "()Landroidx/paging/PagingSource;", "cleanTable", "(Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfLinkedDevice", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfLinkedDevice", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LinkedDeviceDao_Impl implements LinkedDeviceDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<LinkedDevice> __deleteAdapterOfLinkedDevice;
    private final EntityInsertAdapter<LinkedDevice> __insertAdapterOfLinkedDevice;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/LinkedDeviceDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.LinkedDeviceDao_Impl$getAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/LinkedDeviceDao_Impl$getAll$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09631 extends LimitOffsetPagingSource<LinkedDevice> {
        final /* synthetic */ LinkedDeviceDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09631(RoomRawQuery roomRawQuery, LinkedDeviceDao_Impl linkedDeviceDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = linkedDeviceDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkedDevice.COLUMN_ID);
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkedDevice.COLUMN_DEVICE);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "url");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkedDevice.COLUMN_LAST_TIME);
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new LinkedDevice(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends LinkedDevice>> eVar) {
            return DBUtil.performSuspending(this.this$0.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.t0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LinkedDeviceDao_Impl.C09631.convertRows$lambda$0(roomRawQuery, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public LinkedDeviceDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfLinkedDevice = new EntityInsertAdapter<LinkedDevice>() { // from class: cu.todus.android.db.dao.toDus.LinkedDeviceDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `linked_device` (`session_id`,`device`,`url`,`last_time`,`state`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, LinkedDevice entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getDevice());
                statement.mo9387bindText(3, entity.getUrl());
                statement.mo9385bindLong(4, entity.getDate());
                statement.mo9385bindLong(5, entity.getState());
            }
        };
        this.__deleteAdapterOfLinkedDevice = new EntityDeleteOrUpdateAdapter<LinkedDevice>() { // from class: cu.todus.android.db.dao.toDus.LinkedDeviceDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "DELETE FROM `linked_device` WHERE `session_id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, LinkedDevice entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 cleanTable$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 delete$lambda$0(LinkedDeviceDao_Impl linkedDeviceDao_Impl, LinkedDevice linkedDevice, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        linkedDeviceDao_Impl.__deleteAdapterOfLinkedDevice.handle(_connection, linkedDevice);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(LinkedDeviceDao_Impl linkedDeviceDao_Impl, LinkedDevice linkedDevice, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return linkedDeviceDao_Impl.__insertAdapterOfLinkedDevice.insertAndReturnId(_connection, linkedDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List insert$lambda$1(LinkedDeviceDao_Impl linkedDeviceDao_Impl, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return linkedDeviceDao_Impl.__insertAdapterOfLinkedDevice.insertAndReturnIdsList(_connection, list);
    }

    @Override // cu.todus.android.db.dao.toDus.LinkedDeviceDao
    public Object cleanTable(ab.e<? super ua.k0> eVar) {
        final String str = "DELETE FROM 'linked_device'";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedDeviceDao_Impl.cleanTable$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.LinkedDeviceDao
    public Object delete(final LinkedDevice linkedDevice, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedDeviceDao_Impl.delete$lambda$0(this.f20676c, linkedDevice, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.LinkedDeviceDao
    public PagingSource<Integer, LinkedDevice> getAll() {
        return new C09631(new RoomRawQuery("SELECT * FROM 'linked_device' ORDER BY 'last_time' DESC", null, 2, null), this, this.__db, new String[]{"linked_device"});
    }

    @Override // cu.todus.android.db.dao.toDus.LinkedDeviceDao
    public Object insert(final LinkedDevice linkedDevice, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(LinkedDeviceDao_Impl.insert$lambda$0(this.f20603c, linkedDevice, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.LinkedDeviceDao
    public Object insert(final List<LinkedDevice> list, ab.e<? super List<Long>> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedDeviceDao_Impl.insert$lambda$1(this.f20630c, list, (SQLiteConnection) obj);
            }
        }, eVar);
    }
}
