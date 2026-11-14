package cu.todus.android.db.dao.toDus;

import androidx.collection.ArrayMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.data.db.pojo.StickerGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerPackDao_Impl;", "Lcu/todus/android/db/dao/toDus/StickerPackDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "_map", "Lua/k0;", "__fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/StickerPack;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/StickerPack;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StickerGroup;", "getStickerGroups", "()Landroidx/paging/PagingSource;", "Lte/h;", "", "getStickerIds", "()Lte/h;", "id", "deleteById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfStickerPack", "Landroidx/room/EntityInsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StickerPackDao_Impl implements StickerPackDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<StickerPack> __insertAdapterOfStickerPack;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerPackDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StickerPackDao_Impl$getStickerGroups$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StickerPackDao_Impl$getStickerGroups$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/StickerGroup;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09811 extends LimitOffsetPagingSource<StickerGroup> {
        final /* synthetic */ StickerPackDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09811(RoomRawQuery roomRawQuery, StickerPackDao_Impl stickerPackDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = stickerPackDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, StickerPackDao_Impl stickerPackDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "title");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumb");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
                ArrayMap arrayMap = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    if (!arrayMap.containsKey(text)) {
                        arrayMap.put(text, new ArrayList());
                    }
                }
                sQLiteStatementPrepare.reset();
                stickerPackDao_Impl.__fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker(_connection, arrayMap);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    StickerPack stickerPack = new StickerPack(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                    Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                    kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                    arrayList.add(new StickerGroup(stickerPack, (List) objJ));
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends StickerGroup>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final StickerPackDao_Impl stickerPackDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StickerPackDao_Impl.C09811.convertRows$lambda$0(roomRawQuery, stickerPackDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public StickerPackDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfStickerPack = new EntityInsertAdapter<StickerPack>() { // from class: cu.todus.android.db.dao.toDus.StickerPackDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `stickerPack` (`name`,`title`,`thumb`,`createAt`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, StickerPack entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getName());
                statement.mo9387bindText(2, entity.getTitle());
                statement.mo9387bindText(3, entity.getThumb());
                statement.mo9385bindLong(4, entity.getCreateAt());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker(final SQLiteConnection _connection, ArrayMap<String, List<Sticker>> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.j7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StickerPackDao_Impl.__fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker$lambda$0(this.f20492c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `id`,`packName`,`name`,`folder`,`favorite`,`lastUse` FROM `sticker` WHERE `packName` IN (");
        StringUtil.appendPlaceholders(sb2, setKeySet.size());
        sb2.append(")");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo9387bindText(i10, it.next());
            i10++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, Sticker.COLUMN_PACK_NAME);
            if (columnIndex == -1) {
                sQLiteStatementPrepare.close();
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                List<Sticker> list = _map.get(sQLiteStatementPrepare.getText(columnIndex));
                if (list != null) {
                    list.add(new Sticker(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.getText(3), ((int) sQLiteStatementPrepare.getLong(4)) != 0, sQLiteStatementPrepare.getLong(5)));
                }
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker$lambda$0(StickerPackDao_Impl stickerPackDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        stickerPackDao_Impl.__fetchRelationshipstickerAscuTodusAndroidDataDbEntityToDusSticker(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteById$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getStickerIds$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(StickerPackDao_Impl stickerPackDao_Impl, StickerPack stickerPack, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return stickerPackDao_Impl.__insertAdapterOfStickerPack.insertAndReturnId(_connection, stickerPack);
    }

    @Override // cu.todus.android.db.dao.toDus.StickerPackDao
    public Object deleteById(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM 'stickerPack' WHERE name = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerPackDao_Impl.deleteById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StickerPackDao
    public PagingSource<Integer, StickerGroup> getStickerGroups() {
        return new C09811(new RoomRawQuery("SELECT * FROM stickerPack ORDER by createAt DESC", null, 2, null), this, this.__db, new String[]{"sticker", StickerPack.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.StickerPackDao
    public te.h getStickerIds() {
        final String str = "SELECT name FROM stickerPack";
        return FlowUtil.createFlow(this.__db, false, new String[]{StickerPack.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.i7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerPackDao_Impl.getStickerIds$lambda$0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StickerPackDao
    public Object insert(final StickerPack stickerPack, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.g7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StickerPackDao_Impl.insert$lambda$0(this.f20425c, stickerPack, (SQLiteConnection) obj));
            }
        }, eVar);
    }
}
