package cu.todus.android.db.dao.toDus;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.toDus.Sticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerDao_Impl;", "Lcu/todus/android/db/dao/toDus/StickerDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/Sticker;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "getFavoriteStickers", "()Landroidx/paging/PagingSource;", "getRecentStickers", "", "id", "", "status", "Lua/k0;", "onChangeStickerFavoriteStatus", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "date", "updateStickerLastUse", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfSticker", "Landroidx/room/EntityInsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StickerDao_Impl implements StickerDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Sticker> __insertAdapterOfSticker;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StickerDao_Impl$getFavoriteStickers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StickerDao_Impl$getFavoriteStickers$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09791 extends LimitOffsetPagingSource<Sticker> {
        final /* synthetic */ StickerDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09791(RoomRawQuery roomRawQuery, StickerDao_Impl stickerDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = stickerDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_PACK_NAME);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "folder");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_FAVORITE);
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_LAST_USE);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Sticker(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Sticker>> eVar) {
            return DBUtil.performSuspending(this.this$0.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.e7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StickerDao_Impl.C09791.convertRows$lambda$0(roomRawQuery, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StickerDao_Impl$getRecentStickers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StickerDao_Impl$getRecentStickers$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09801 extends LimitOffsetPagingSource<Sticker> {
        final /* synthetic */ StickerDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09801(RoomRawQuery roomRawQuery, StickerDao_Impl stickerDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = stickerDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_PACK_NAME);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "folder");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_FAVORITE);
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Sticker.COLUMN_LAST_USE);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Sticker(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow6)));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Sticker>> eVar) {
            return DBUtil.performSuspending(this.this$0.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StickerDao_Impl.C09801.convertRows$lambda$0(roomRawQuery, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public StickerDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfSticker = new EntityInsertAdapter<Sticker>() { // from class: cu.todus.android.db.dao.toDus.StickerDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `sticker` (`id`,`packName`,`name`,`folder`,`favorite`,`lastUse`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Sticker entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getPackName());
                statement.mo9387bindText(3, entity.getName());
                statement.mo9387bindText(4, entity.getFolder());
                statement.mo9385bindLong(5, entity.getFavorite() ? 1L : 0L);
                statement.mo9385bindLong(6, entity.getLastUse());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(StickerDao_Impl stickerDao_Impl, Sticker sticker, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return stickerDao_Impl.__insertAdapterOfSticker.insertAndReturnId(_connection, sticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 onChangeStickerFavoriteStatus$lambda$0(String str, boolean z10, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, z10 ? 1L : 0L);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateStickerLastUse$lambda$0(String str, long j10, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, j10);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // cu.todus.android.db.dao.toDus.StickerDao
    public PagingSource<Integer, Sticker> getFavoriteStickers() {
        return new C09791(new RoomRawQuery("SELECT * FROM sticker WHERE favorite = 1 ORDER BY lastUse", null, 2, null), this, this.__db, new String[]{"sticker"});
    }

    @Override // cu.todus.android.db.dao.toDus.StickerDao
    public PagingSource<Integer, Sticker> getRecentStickers() {
        return new C09801(new RoomRawQuery("SELECT * FROM sticker WHERE lastUse != 0 ORDER BY lastUse LIMIT 10", null, 2, null), this, this.__db, new String[]{"sticker"});
    }

    @Override // cu.todus.android.db.dao.toDus.StickerDao
    public Object insert(final Sticker sticker, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.c7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StickerDao_Impl.insert$lambda$0(this.f20338c, sticker, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StickerDao
    public Object onChangeStickerFavoriteStatus(final String str, final boolean z10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE sticker SET favorite = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.d7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerDao_Impl.onChangeStickerFavoriteStatus$lambda$0(str2, z10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StickerDao
    public Object updateStickerLastUse(final String str, final long j10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE sticker SET lastUse = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.b7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerDao_Impl.updateStickerLastUse$lambda$0(str2, j10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
