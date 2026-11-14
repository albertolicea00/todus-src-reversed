package cu.todus.android.db.dao.toDus;

import androidx.collection.ArrayMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityDeleteOrUpdateAdapter;
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
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MarkerWithPartner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0096@¢\u0006\u0004\b\u0013\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\tH\u0096@¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcu/todus/android/db/dao/toDus/MarkerActionDao_Impl;", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "_map", "Lua/k0;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/User;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "markerAction", "insertOrReplace", "(Lcu/todus/android/data/db/entity/toDus/MarkerAction;Lab/e;)Ljava/lang/Object;", "", "markerActions", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "delete", "Lte/h;", "getMarkerToSend", "()Lte/h;", Room.COLUMN_LAST_MSG, "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "getMarkerFromMsg", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "uid", "getMarker", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfMarkerAction", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfMarkerAction", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MarkerActionDao_Impl implements MarkerActionDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<MarkerAction> __deleteAdapterOfMarkerAction;
    private final EntityInsertAdapter<MarkerAction> __insertAdapterOfMarkerAction;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/MarkerActionDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.MarkerActionDao_Impl$getMarkerFromMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/MarkerActionDao_Impl$getMarkerFromMsg$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09641 extends LimitOffsetPagingSource<MarkerWithPartner> {
        final /* synthetic */ MarkerActionDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09641(RoomRawQuery roomRawQuery, MarkerActionDao_Impl markerActionDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = markerActionDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, MarkerActionDao_Impl markerActionDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MarkerAction.COLUMN_ROOM);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "marker");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                }
                sQLiteStatementPrepare.reset();
                markerActionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
                markerActionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new MarkerWithPartner(new MarkerAction(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), (Contact) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends MarkerWithPartner>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final MarkerActionDao_Impl markerActionDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.c1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MarkerActionDao_Impl.C09641.convertRows$lambda$0(roomRawQuery, markerActionDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public MarkerActionDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfMarkerAction = new EntityInsertAdapter<MarkerAction>() { // from class: cu.todus.android.db.dao.toDus.MarkerActionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `marker` (`uid`,`msg`,`room`,`marker`,`createdAt`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, MarkerAction entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUid());
                statement.mo9387bindText(2, entity.getMsg());
                statement.mo9387bindText(3, entity.getRoom());
                statement.mo9385bindLong(4, entity.getMarker());
                statement.mo9385bindLong(5, entity.getCreatedAt());
            }
        };
        this.__deleteAdapterOfMarkerAction = new EntityDeleteOrUpdateAdapter<MarkerAction>() { // from class: cu.todus.android.db.dao.toDus.MarkerActionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "DELETE FROM `marker` WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, MarkerAction entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUid());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(final SQLiteConnection _connection, ArrayMap<String, Contact> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MarkerActionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20792c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `phone`,`uid`,`fName`,`phoneType`,`photoUri`,`state` FROM `Contact` WHERE `uid` IN (");
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
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "uid");
            if (columnIndex == -1) {
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (_map.containsKey(text)) {
                    _map.put(text, new Contact(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.getText(4), sQLiteStatementPrepare.isNull(5) ? null : sQLiteStatementPrepare.getText(5)));
                }
            }
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(MarkerActionDao_Impl markerActionDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        markerActionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MarkerActionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20735c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `uid`,`username`,`alias`,`photoUrl`,`description`,`version`,`photoThumbnail`,`official`,`blocked`,`toDusId` FROM `user` WHERE `uid` IN (");
        StringUtil.appendPlaceholders(sb2, setKeySet.size());
        sb2.append(")");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i10 = 1;
        int i11 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo9387bindText(i11, it.next());
            i11++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "uid");
            if (columnIndex == -1) {
                sQLiteStatementPrepare.close();
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (_map.containsKey(text)) {
                    _map.put(text, new User(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(i10), sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.getText(4), (int) sQLiteStatementPrepare.getLong(5), sQLiteStatementPrepare.getText(6), (int) sQLiteStatementPrepare.getLong(7), ((int) sQLiteStatementPrepare.getLong(8)) != 0, sQLiteStatementPrepare.getText(9)));
                    i10 = 1;
                }
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(MarkerActionDao_Impl markerActionDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        markerActionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 delete$lambda$0(MarkerActionDao_Impl markerActionDao_Impl, MarkerAction markerAction, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        markerActionDao_Impl.__deleteAdapterOfMarkerAction.handle(_connection, markerAction);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MarkerAction getMarker$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            return sQLiteStatementPrepare.step() ? new MarkerAction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MarkerAction.COLUMN_ROOM)), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "marker")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getMarkerFromMsg$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MarkerAction getMarkerToSend$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? new MarkerAction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, MarkerAction.COLUMN_ROOM)), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "marker")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insertOrReplace$lambda$0(MarkerActionDao_Impl markerActionDao_Impl, MarkerAction markerAction, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        markerActionDao_Impl.__insertAdapterOfMarkerAction.insert(_connection, markerAction);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insertOrReplace$lambda$1(MarkerActionDao_Impl markerActionDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        markerActionDao_Impl.__insertAdapterOfMarkerAction.insert(_connection, list);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public Object delete(final MarkerAction markerAction, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.delete$lambda$0(this.f20714c, markerAction, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public Object getMarker(final String str, ab.e<? super MarkerAction> eVar) {
        final String str2 = "SELECT * FROM marker WHERE uid = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.getMarker$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public PagingSource<Integer, MarkerWithPartner> getMarkerFromMsg(final String msgId) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        return new C09641(new RoomRawQuery("SELECT * FROM marker WHERE msg = ? AND marker IN (4, 5) ORDER BY marker DESC, createdAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.getMarkerFromMsg$lambda$0(msgId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"Contact", "user", "marker"});
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public te.h getMarkerToSend() {
        final String str = "SELECT * FROM marker WHERE marker NOT IN (4, 5) LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"marker"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.getMarkerToSend$lambda$0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public Object insertOrReplace(final MarkerAction markerAction, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.insertOrReplace$lambda$0(this.f20305c, markerAction, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MarkerActionDao
    public Object insertOrReplace(final List<MarkerAction> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MarkerActionDao_Impl.insertOrReplace$lambda$1(this.f20813c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
