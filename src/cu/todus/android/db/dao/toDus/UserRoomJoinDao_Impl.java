package cu.todus.android.db.dao.toDus;

import androidx.collection.ArrayMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
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
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.RoomMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0017\u0010\u0014J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0018\u0010\u0014J\u001e\u0010\u0018\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0096@¢\u0006\u0004\b\u0018\u0010\u001bJ#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u001d2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010%J\"\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\"\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0096@¢\u0006\u0004\b+\u0010'J\"\u0010,\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0096@¢\u0006\u0004\b,\u0010'J&\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b-\u0010'J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0096@¢\u0006\u0004\b.\u0010/J&\u00102\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\t00H\u0096@¢\u0006\u0004\b2\u00103J \u00105\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0096@¢\u0006\u0004\b5\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0011078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0011078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserRoomJoinDao_Impl;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "_map", "Lua/k0;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/Contact;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "userRoomJoin", "insert", "(Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;Lab/e;)Ljava/lang/Object;", "affiliations", "insertIfNeedIgnore", DiscoverItems.Item.UPDATE_ACTION, "upsert", "", Service.Endpoint.LINKED_DEVICES_LIST, "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "roomId", "Lte/h;", "groupMemberIds", "(Ljava/lang/String;)Lte/h;", "ownerId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/RoomMember;", "roomMembers", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "getAffiliationByRoom", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getAffiliationByRoomFlow", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "currentUser", "userInRoom", "userInRoomDirect", "groupMembers", "getUsersForLoad", "(Lab/e;)Ljava/lang/Object;", "", "usersId", "deleteNotIn", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "userId", "setAffiliationToNone", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfUserRoomJoin", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfUserRoomJoin_1", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfUserRoomJoin", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Landroidx/room/EntityUpsertAdapter;", "__upsertAdapterOfUserRoomJoin", "Landroidx/room/EntityUpsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UserRoomJoinDao_Impl implements UserRoomJoinDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<UserRoomJoin> __insertAdapterOfUserRoomJoin;
    private final EntityInsertAdapter<UserRoomJoin> __insertAdapterOfUserRoomJoin_1;
    private final EntityDeleteOrUpdateAdapter<UserRoomJoin> __updateAdapterOfUserRoomJoin;
    private final EntityUpsertAdapter<UserRoomJoin> __upsertAdapterOfUserRoomJoin;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserRoomJoinDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl$roomMembers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/UserRoomJoinDao_Impl$roomMembers$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomMember;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09851 extends LimitOffsetPagingSource<RoomMember> {
        final /* synthetic */ UserRoomJoinDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09851(RoomRawQuery roomRawQuery, UserRoomJoinDao_Impl userRoomJoinDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = userRoomJoinDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, UserRoomJoinDao_Impl userRoomJoinDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, UserRoomJoin.COLUMN_AFFILIATION);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                }
                sQLiteStatementPrepare.reset();
                userRoomJoinDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                userRoomJoinDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new RoomMember(new UserRoomJoin(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomMember>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final UserRoomJoinDao_Impl userRoomJoinDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.u8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserRoomJoinDao_Impl.C09851.convertRows$lambda$0(roomRawQuery, userRoomJoinDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public UserRoomJoinDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfUserRoomJoin = new EntityInsertAdapter<UserRoomJoin>() { // from class: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `user_room_join` (`userId`,`roomId`,`affiliation`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, UserRoomJoin entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUserId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getAffiliation());
            }
        };
        this.__insertAdapterOfUserRoomJoin_1 = new EntityInsertAdapter<UserRoomJoin>() { // from class: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `user_room_join` (`userId`,`roomId`,`affiliation`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, UserRoomJoin entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUserId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getAffiliation());
            }
        };
        this.__updateAdapterOfUserRoomJoin = new EntityDeleteOrUpdateAdapter<UserRoomJoin>() { // from class: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `user_room_join` SET `userId` = ?,`roomId` = ?,`affiliation` = ? WHERE `userId` = ? AND `roomId` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, UserRoomJoin entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUserId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getAffiliation());
                statement.mo9387bindText(4, entity.getUserId());
                statement.mo9387bindText(5, entity.getRoomId());
            }
        };
        this.__upsertAdapterOfUserRoomJoin = new EntityUpsertAdapter<>(new EntityInsertAdapter<UserRoomJoin>() { // from class: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT INTO `user_room_join` (`userId`,`roomId`,`affiliation`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, UserRoomJoin entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUserId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getAffiliation());
            }
        }, new EntityDeleteOrUpdateAdapter<UserRoomJoin>() { // from class: cu.todus.android.db.dao.toDus.UserRoomJoinDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE `user_room_join` SET `userId` = ?,`roomId` = ?,`affiliation` = ? WHERE `userId` = ? AND `roomId` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, UserRoomJoin entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUserId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getAffiliation());
                statement.mo9387bindText(4, entity.getUserId());
                statement.mo9387bindText(5, entity.getRoomId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(final SQLiteConnection _connection, ArrayMap<String, Contact> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.q8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserRoomJoinDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20648c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        userRoomJoinDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.s8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserRoomJoinDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20691c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        userRoomJoinDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteNotIn$lambda$0(String str, String str2, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            Iterator it = list.iterator();
            int i10 = 2;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i10, (String) it.next());
                i10++;
            }
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getAffiliationByRoom$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            String text = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                text = sQLiteStatementPrepare.getText(0);
            }
            return text;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getAffiliationByRoomFlow$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            String text = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                text = sQLiteStatementPrepare.getText(0);
            }
            return text;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getUsersForLoad$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final List groupMemberIds$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
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
    public static final List groupMembers$lambda$0(String str, String str2, String str3, UserRoomJoinDao_Impl userRoomJoinDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, UserRoomJoin.COLUMN_AFFILIATION);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
            }
            sQLiteStatementPrepare.reset();
            userRoomJoinDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            userRoomJoinDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new RoomMember(new UserRoomJoin(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, UserRoomJoin userRoomJoin, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userRoomJoinDao_Impl.__insertAdapterOfUserRoomJoin.insert(_connection, userRoomJoin);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insertIfNeedIgnore$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, UserRoomJoin userRoomJoin, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userRoomJoinDao_Impl.__insertAdapterOfUserRoomJoin_1.insert(_connection, userRoomJoin);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 roomMembers$lambda$0(String str, String str2, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 setAffiliationToNone$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 update$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, UserRoomJoin userRoomJoin, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userRoomJoinDao_Impl.__updateAdapterOfUserRoomJoin.handle(_connection, userRoomJoin);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 upsert$lambda$0(UserRoomJoinDao_Impl userRoomJoinDao_Impl, UserRoomJoin userRoomJoin, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userRoomJoinDao_Impl.__upsertAdapterOfUserRoomJoin.upsert(_connection, userRoomJoin);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 upsert$lambda$1(UserRoomJoinDao_Impl userRoomJoinDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userRoomJoinDao_Impl.__upsertAdapterOfUserRoomJoin.upsert(_connection, list);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserRoomJoin userInRoom$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            return sQLiteStatementPrepare.step() ? new UserRoomJoin(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, UserRoomJoin.COLUMN_AFFILIATION))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserRoomJoin userInRoomDirect$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            return sQLiteStatementPrepare.step() ? new UserRoomJoin(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, UserRoomJoin.COLUMN_AFFILIATION))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object deleteNotIn(final String str, final List<String> list, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM user_room_join WHERE roomId = ");
        sb2.append("?");
        sb2.append(" and userId not in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.l8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.deleteNotIn$lambda$0(string, str, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object getAffiliationByRoom(final String str, final String str2, ab.e<? super String> eVar) {
        final String str3 = "SELECT affiliation FROM user_room_join WHERE roomId =? AND userId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.e8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.getAffiliationByRoom$lambda$0(str3, str, str2, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public te.h getAffiliationByRoomFlow(final String roomId, final String ownerId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT affiliation FROM user_room_join WHERE roomId =? AND userId = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{UserRoomJoin.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.p8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.getAffiliationByRoomFlow$lambda$0(str, roomId, ownerId, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object getUsersForLoad(ab.e<? super List<String>> eVar) {
        final String str = "SELECT urj.userId FROM user_room_join AS urj LEFT JOIN user AS u ON urj.userId = u.uid WHERE u.uid IS NULL";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.t8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.getUsersForLoad$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public te.h groupMemberIds(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        final String str = "SELECT userId FROM user_room_join WHERE roomId = ? AND affiliation != 'none' ";
        return FlowUtil.createFlow(this.__db, false, new String[]{UserRoomJoin.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.k8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.groupMemberIds$lambda$0(str, roomId, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object groupMembers(final String str, final String str2, ab.e<? super List<RoomMember>> eVar) {
        final String str3 = "SELECT * FROM user_room_join WHERE roomId =? AND userId != ? AND affiliation != 'none'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.groupMembers$lambda$0(str3, str, str2, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object insert(final UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.j8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.insert$lambda$0(this.f20494c, userRoomJoin, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object insertIfNeedIgnore(final UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.r8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.insertIfNeedIgnore$lambda$0(this.f20672c, userRoomJoin, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public PagingSource<Integer, RoomMember> roomMembers(final String roomId, final String ownerId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09851(new RoomRawQuery("SELECT * FROM user_room_join WHERE roomId =? AND userId != ? AND affiliation != 'none' ORDER BY affiliation", new Function1() { // from class: cu.todus.android.db.dao.toDus.g8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.roomMembers$lambda$0(roomId, ownerId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", UserRoomJoin.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object setAffiliationToNone(final String str, final String str2, ab.e<? super ua.k0> eVar) {
        final String str3 = "UPDATE user_room_join SET affiliation = 'none' where roomId = ? and userId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.i8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.setAffiliationToNone$lambda$0(str3, str, str2, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object update(final UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.update$lambda$0(this.f20556c, userRoomJoin, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object upsert(final UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.upsert$lambda$0(this.f20451c, userRoomJoin, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object userInRoom(final String str, final String str2, ab.e<? super UserRoomJoin> eVar) {
        final String str3 = "SELECT * FROM user_room_join WHERE roomId = ? AND userId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.userInRoom$lambda$0(str3, str, str2, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object userInRoomDirect(final String str, final String str2, ab.e<? super UserRoomJoin> eVar) {
        final String str3 = "SELECT * FROM user_room_join WHERE roomId = ? AND userId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.d8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.userInRoomDirect$lambda$0(str3, str, str2, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserRoomJoinDao
    public Object upsert(final List<UserRoomJoin> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.o8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserRoomJoinDao_Impl.upsert$lambda$1(this.f20598c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
