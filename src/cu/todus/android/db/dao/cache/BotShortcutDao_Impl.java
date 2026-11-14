package cu.todus.android.db.dao.cache;

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
import cu.todus.android.data.db.entity.cache.BotShortcut;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\t\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\t\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u000f\u0010\nJ\u001b\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001e\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001f\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcu/todus/android/db/dao/cache/BotShortcutDao_Impl;", "Lcu/todus/android/db/dao/cache/BotShortcutDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/cache/BotShortcut;Lab/e;)Ljava/lang/Object;", "", "objs", "Lua/k0;", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "Landroidx/paging/PagingSource;", "", "getBotShortcutsPaging", "()Landroidx/paging/PagingSource;", "", "roomId", "getBotShortcutsByRoomIdPaging", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "location", "getShortcutsByLocation", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "id", "deleteById", "deleteByRoomId", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfBotShortcut", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfBotShortcut", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BotShortcutDao_Impl implements BotShortcutDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<BotShortcut> __insertAdapterOfBotShortcut;
    private final EntityDeleteOrUpdateAdapter<BotShortcut> __updateAdapterOfBotShortcut;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/cache/BotShortcutDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.cache.BotShortcutDao_Impl$getBotShortcutsByRoomIdPaging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/cache/BotShortcutDao_Impl$getBotShortcutsByRoomIdPaging$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09561 extends LimitOffsetPagingSource<BotShortcut> {
        final /* synthetic */ BotShortcutDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09561(RoomRawQuery roomRawQuery, BotShortcutDao_Impl botShortcutDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = botShortcutDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "icon");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "label");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnColor");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnContent");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new BotShortcut((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.getLong(columnIndexOrThrow9)));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends BotShortcut>> eVar) {
            return DBUtil.performSuspending(this.this$0.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BotShortcutDao_Impl.C09561.convertRows$lambda$0(roomRawQuery, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.cache.BotShortcutDao_Impl$getBotShortcutsPaging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/cache/BotShortcutDao_Impl$getBotShortcutsPaging$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09571 extends LimitOffsetPagingSource<BotShortcut> {
        final /* synthetic */ BotShortcutDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09571(RoomRawQuery roomRawQuery, BotShortcutDao_Impl botShortcutDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = botShortcutDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "icon");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "label");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnColor");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnContent");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new BotShortcut((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.getLong(columnIndexOrThrow9)));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends BotShortcut>> eVar) {
            return DBUtil.performSuspending(this.this$0.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BotShortcutDao_Impl.C09571.convertRows$lambda$0(roomRawQuery, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public BotShortcutDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfBotShortcut = new EntityInsertAdapter<BotShortcut>() { // from class: cu.todus.android.db.dao.cache.BotShortcutDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `bot_shortcut` (`id`,`roomId`,`location`,`icon`,`label`,`description`,`btnColor`,`btnContent`,`createAt`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, BotShortcut entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getLocation());
                statement.mo9387bindText(4, entity.getIcon());
                statement.mo9387bindText(5, entity.getLabel());
                statement.mo9387bindText(6, entity.getDescription());
                statement.mo9387bindText(7, entity.getBtnColor());
                statement.mo9387bindText(8, entity.getBtnContent());
                statement.mo9385bindLong(9, entity.getCreateAt());
            }
        };
        this.__updateAdapterOfBotShortcut = new EntityDeleteOrUpdateAdapter<BotShortcut>() { // from class: cu.todus.android.db.dao.cache.BotShortcutDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `bot_shortcut` SET `id` = ?,`roomId` = ?,`location` = ?,`icon` = ?,`label` = ?,`description` = ?,`btnColor` = ?,`btnContent` = ?,`createAt` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, BotShortcut entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9385bindLong(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getLocation());
                statement.mo9387bindText(4, entity.getIcon());
                statement.mo9387bindText(5, entity.getLabel());
                statement.mo9387bindText(6, entity.getDescription());
                statement.mo9387bindText(7, entity.getBtnColor());
                statement.mo9387bindText(8, entity.getBtnContent());
                statement.mo9385bindLong(9, entity.getCreateAt());
                statement.mo9385bindLong(10, entity.getId());
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
    public static final k0 deleteById$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 deleteByRoomId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.step();
            return k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 getBotShortcutsByRoomIdPaging$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getShortcutsByLocation$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "icon");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "label");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnColor");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "btnContent");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new BotShortcut((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), sQLiteStatementPrepare.getLong(columnIndexOrThrow9)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(BotShortcutDao_Impl botShortcutDao_Impl, BotShortcut botShortcut, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return botShortcutDao_Impl.__insertAdapterOfBotShortcut.insertAndReturnId(_connection, botShortcut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 insert$lambda$1(BotShortcutDao_Impl botShortcutDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        botShortcutDao_Impl.__insertAdapterOfBotShortcut.insert(_connection, list);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 update$lambda$0(BotShortcutDao_Impl botShortcutDao_Impl, BotShortcut botShortcut, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        botShortcutDao_Impl.__updateAdapterOfBotShortcut.handle(_connection, botShortcut);
        return k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object deleteAll(ab.e<? super k0> eVar) {
        final String str = "DELETE FROM bot_shortcut";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.deleteAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object deleteById(final String str, ab.e<? super k0> eVar) {
        final String str2 = "DELETE FROM bot_shortcut WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.deleteById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object deleteByRoomId(final String str, ab.e<? super k0> eVar) {
        final String str2 = "DELETE FROM bot_shortcut WHERE roomId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.deleteByRoomId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public PagingSource<Integer, BotShortcut> getBotShortcutsByRoomIdPaging(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new C09561(new RoomRawQuery("SELECT * FROM bot_shortcut WHERE roomId = ?", new Function1() { // from class: cu.todus.android.db.dao.cache.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.getBotShortcutsByRoomIdPaging$lambda$0(roomId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{BotShortcut.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public PagingSource<Integer, BotShortcut> getBotShortcutsPaging() {
        return new C09571(new RoomRawQuery("SELECT * FROM bot_shortcut", null, 2, null), this, this.__db, new String[]{BotShortcut.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object getShortcutsByLocation(final String str, ab.e<? super List<BotShortcut>> eVar) {
        final String str2 = "SELECT * FROM bot_shortcut WHERE location = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.cache.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.getShortcutsByLocation$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object insert(final BotShortcut botShortcut, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(BotShortcutDao_Impl.insert$lambda$0(this.f20255c, botShortcut, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object update(final BotShortcut botShortcut, ab.e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.update$lambda$0(this.f20243c, botShortcut, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.cache.BotShortcutDao
    public Object insert(final List<BotShortcut> list, ab.e<? super k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.cache.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BotShortcutDao_Impl.insert$lambda$1(this.f20246c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : k0.f43947a;
    }
}
