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
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00172\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010&J\u001a\u0010'\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\tH\u0096@¢\u0006\u0004\b'\u0010\"J\u001f\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00172\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\u0018\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\tH\u0096@¢\u0006\u0004\b+\u0010\"J\u0018\u0010,\u001a\u00020\f2\u0006\u0010*\u001a\u00020\tH\u0096@¢\u0006\u0004\b,\u0010\"J\u0018\u0010-\u001a\u00020\f2\u0006\u0010#\u001a\u00020\tH\u0096@¢\u0006\u0004\b-\u0010\"J \u00100\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\fH\u0096@¢\u0006\u0004\b2\u00103R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0011058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0011058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107¨\u0006:"}, d2 = {"Lcu/todus/android/db/dao/toDus/ReactionDao_Impl;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "_map", "Lua/k0;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/Contact;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "obj", "", "insertOrIgnore", "(Lcu/todus/android/data/db/entity/toDus/Reaction;Lab/e;)Ljava/lang/Object;", "insert", "Lte/h;", "getUnsentReaction", "()Lte/h;", "entityId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "getReactionsByEntityId", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "reactionId", "getReactionsById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", Reaction.COLUMN_ENTITY, "ownerId", "getReactionsByEntityFlow", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "getReactionByEntity", "getReactionsCountByEntityFlow", "(Ljava/lang/String;)Lte/h;", "id", "setReactionAsSent", "deleteById", "deleteByEntity", "actualTime", XHTMLText.Q, "deleteAfter", "(JLjava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfReaction", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfReaction_1", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReactionDao_Impl implements ReactionDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Reaction> __insertAdapterOfReaction;
    private final EntityInsertAdapter<Reaction> __insertAdapterOfReaction_1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/ReactionDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.ReactionDao_Impl$getReactionsByEntityId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/ReactionDao_Impl$getReactionsByEntityId$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09671 extends LimitOffsetPagingSource<ReactionWithPartner> {
        final /* synthetic */ ReactionDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09671(RoomRawQuery roomRawQuery, ReactionDao_Impl reactionDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = reactionDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, ReactionDao_Impl reactionDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "reactionContent");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_REACTION_STATE);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                }
                sQLiteStatementPrepare.reset();
                reactionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                reactionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    int i10 = columnIndexOrThrow;
                    int i11 = columnIndexOrThrow2;
                    arrayList.add(new ReactionWithPartner(new Reaction(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getLong(columnIndexOrThrow7)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                    columnIndexOrThrow = i10;
                    columnIndexOrThrow2 = i11;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends ReactionWithPartner>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final ReactionDao_Impl reactionDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.s3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ReactionDao_Impl.C09671.convertRows$lambda$0(roomRawQuery, reactionDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public ReactionDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfReaction = new EntityInsertAdapter<Reaction>() { // from class: cu.todus.android.db.dao.toDus.ReactionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `reaction` (`id`,`entity`,`userId`,`roomId`,`reactionContent`,`reactionState`,`createdAt`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Reaction entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getEntity());
                statement.mo9387bindText(3, entity.getUserId());
                statement.mo9387bindText(4, entity.getRoomId());
                statement.mo9387bindText(5, entity.getReactionContent());
                statement.mo9385bindLong(6, entity.getReactionState());
                statement.mo9385bindLong(7, entity.getCreatedAt());
            }
        };
        this.__insertAdapterOfReaction_1 = new EntityInsertAdapter<Reaction>() { // from class: cu.todus.android.db.dao.toDus.ReactionDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `reaction` (`id`,`entity`,`userId`,`roomId`,`reactionContent`,`reactionState`,`createdAt`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Reaction entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getEntity());
                statement.mo9387bindText(3, entity.getUserId());
                statement.mo9387bindText(4, entity.getRoomId());
                statement.mo9387bindText(5, entity.getReactionContent());
                statement.mo9385bindLong(6, entity.getReactionState());
                statement.mo9385bindLong(7, entity.getCreatedAt());
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.g3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ReactionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20416c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(ReactionDao_Impl reactionDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        reactionDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.j3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ReactionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20485c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(ReactionDao_Impl reactionDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        reactionDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteAfter$lambda$0(String str, long j10, String str2, SQLiteConnection _connection) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteAll$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 deleteByEntity$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final Reaction getReactionByEntity$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            return sQLiteStatementPrepare.step() ? new Reaction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY)), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "reactionContent")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_REACTION_STATE)), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Reaction getReactionsByEntityFlow$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            return sQLiteStatementPrepare.step() ? new Reaction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY)), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "reactionContent")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_REACTION_STATE)), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getReactionsByEntityId$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Reaction getReactionsById$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            return sQLiteStatementPrepare.step() ? new Reaction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY)), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "reactionContent")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_REACTION_STATE)), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getReactionsCountByEntityFlow$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            Integer numValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                numValueOf = Integer.valueOf((int) sQLiteStatementPrepare.getLong(0));
            }
            return numValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Reaction getUnsentReaction$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? new Reaction(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY)), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "reactionContent")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Reaction.COLUMN_REACTION_STATE)), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(ReactionDao_Impl reactionDao_Impl, Reaction reaction, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return reactionDao_Impl.__insertAdapterOfReaction_1.insertAndReturnId(_connection, reaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertOrIgnore$lambda$0(ReactionDao_Impl reactionDao_Impl, Reaction reaction, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return reactionDao_Impl.__insertAdapterOfReaction.insertAndReturnId(_connection, reaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 setReactionAsSent$lambda$0(String str, String str2, SQLiteConnection _connection) {
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

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object deleteAfter(final long j10, final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM reaction WHERE createdAt <= ? AND entity LIKE '%'||?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.d3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.deleteAfter$lambda$0(str2, j10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object deleteAll(ab.e<? super ua.k0> eVar) {
        final String str = "DELETE FROM reaction";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.deleteAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object deleteByEntity(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM reaction WHERE entity = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.n3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.deleteByEntity$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object deleteById(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM reaction WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.l3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.deleteById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object getReactionByEntity(final String str, ab.e<? super Reaction> eVar) {
        final String str2 = "SELECT * FROM reaction WHERE entity = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.e3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getReactionByEntity$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public te.h getReactionsByEntityFlow(final String entity, final String ownerId) {
        kotlin.jvm.internal.y.i(entity, "entity");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT * FROM reaction WHERE entity = ? AND userId = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"reaction"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.r3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getReactionsByEntityFlow$lambda$0(str, entity, ownerId, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public PagingSource<Integer, ReactionWithPartner> getReactionsByEntityId(final String entityId) {
        kotlin.jvm.internal.y.i(entityId, "entityId");
        return new C09671(new RoomRawQuery("SELECT * FROM reaction WHERE entity = ? order by createdAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.o3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getReactionsByEntityId$lambda$0(entityId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", "reaction"});
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object getReactionsById(final String str, ab.e<? super Reaction> eVar) {
        final String str2 = "SELECT * FROM reaction WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getReactionsById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public te.h getReactionsCountByEntityFlow(final String entity) {
        kotlin.jvm.internal.y.i(entity, "entity");
        final String str = "SELECT COUNT(*) FROM reaction WHERE entity = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"reaction"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.q3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getReactionsCountByEntityFlow$lambda$0(str, entity, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public te.h getUnsentReaction() {
        final String str = "SELECT * FROM reaction WHERE reactionState = 1 LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"reaction"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.i3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.getUnsentReaction$lambda$0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object insert(final Reaction reaction, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ReactionDao_Impl.insert$lambda$0(this.f20441c, reaction, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object insertOrIgnore(final Reaction reaction, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.f3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ReactionDao_Impl.insertOrIgnore$lambda$0(this.f20396c, reaction, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ReactionDao
    public Object setReactionAsSent(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE reaction SET reactionState = 0 WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactionDao_Impl.setReactionAsSent$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
