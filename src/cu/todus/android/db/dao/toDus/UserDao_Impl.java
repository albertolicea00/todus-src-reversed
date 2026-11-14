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
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0015\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0096@¢\u0006\u0004\b\u0015\u0010\u0018J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u001d\u0010\u001bJ\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b\"\u0010\u001bJ \u0010$\u001a\u0004\u0018\u00010\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0096@¢\u0006\u0004\b$\u0010\u0018J\u001b\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00160\u001eH\u0016¢\u0006\u0004\b%\u0010&J\u001b\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0'H\u0016¢\u0006\u0004\b)\u0010*J+\u0010-\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0'2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010.J+\u0010/\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0'2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010.J \u00103\u001a\u00020\f2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\tH\u0096@¢\u0006\u0004\b3\u00104J \u00105\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0096@¢\u0006\u0004\b5\u00106R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserDao_Impl;", "Lcu/todus/android/db/dao/toDus/UserDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "_map", "Lua/k0;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/Room;", "__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom", "Lcu/todus/android/data/db/entity/toDus/User;", "user", "insert", "(Lcu/todus/android/data/db/entity/toDus/User;Lab/e;)Ljava/lang/Object;", "upsert", "", "users", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "userId", "getById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", User.COLUMN_TODUS_ID, "getByToDusId", "Lte/h;", "Lcu/todus/android/data/db/pojo/Partner;", "getPartnerByIdFlow", "(Ljava/lang/String;)Lte/h;", "getPartnerById", "numbers", "getUserByPossibleNumbers", "getAllBlocked", "()Lte/h;", "Landroidx/paging/PagingSource;", "", "getBlockedPartners", "()Landroidx/paging/PagingSource;", "filter", "ownerId", "getOtherUsers", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "getAllPartners", "", "newState", "uid", "changeBlockState", "(ZLjava/lang/String;Lab/e;)Ljava/lang/Object;", "updateToDusId", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfUser", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityUpsertAdapter;", "__upsertAdapterOfUser", "Landroidx/room/EntityUpsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UserDao_Impl implements UserDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<User> __insertAdapterOfUser;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityUpsertAdapter<User> __upsertAdapterOfUser;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.UserDao_Impl$getAllPartners$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/UserDao_Impl$getAllPartners$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/Partner;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09821 extends LimitOffsetPagingSource<Partner> {
        final /* synthetic */ UserDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09821(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = userDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, SQLiteConnection _connection) throws Throwable {
            SQLiteStatement sQLiteStatement;
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
                int i10 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
                userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    int i12 = columnIndexOrThrow4;
                    int i13 = i10;
                    User user = new User(text, text2, text3, sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(i13));
                    sQLiteStatement = sQLiteStatementPrepare;
                    try {
                        arrayList.add(new Partner(user, (Contact) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow3 = i11;
                        i10 = i13;
                        columnIndexOrThrow4 = i12;
                        sQLiteStatementPrepare = sQLiteStatement;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteStatement.close();
                        throw th;
                    }
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = sQLiteStatementPrepare;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Partner>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final UserDao_Impl userDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.a8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserDao_Impl.C09821.convertRows$lambda$0(roomRawQuery, userDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.UserDao_Impl$getBlockedPartners$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/UserDao_Impl$getBlockedPartners$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/Partner;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09831 extends LimitOffsetPagingSource<Partner> {
        final /* synthetic */ UserDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09831(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = userDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, SQLiteConnection _connection) throws Throwable {
            SQLiteStatement sQLiteStatement;
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
                int i10 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
                userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    int i12 = columnIndexOrThrow4;
                    int i13 = i10;
                    User user = new User(text, text2, text3, sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(i13));
                    sQLiteStatement = sQLiteStatementPrepare;
                    try {
                        arrayList.add(new Partner(user, (Contact) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow3 = i11;
                        i10 = i13;
                        columnIndexOrThrow4 = i12;
                        sQLiteStatementPrepare = sQLiteStatement;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteStatement.close();
                        throw th;
                    }
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = sQLiteStatementPrepare;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Partner>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final UserDao_Impl userDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.b8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserDao_Impl.C09831.convertRows$lambda$0(roomRawQuery, userDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.UserDao_Impl$getOtherUsers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/UserDao_Impl$getOtherUsers$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/Partner;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09841 extends LimitOffsetPagingSource<Partner> {
        final /* synthetic */ UserDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09841(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = userDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, UserDao_Impl userDao_Impl, SQLiteConnection _connection) throws Throwable {
            SQLiteStatement sQLiteStatement;
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                }
                int i10 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
                userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap2);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    int i12 = columnIndexOrThrow4;
                    int i13 = i10;
                    User user = new User(text, text2, text3, sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(i13));
                    sQLiteStatement = sQLiteStatementPrepare;
                    try {
                        arrayList.add(new Partner(user, (Contact) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow3 = i11;
                        i10 = i13;
                        columnIndexOrThrow4 = i12;
                        sQLiteStatementPrepare = sQLiteStatement;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteStatement.close();
                        throw th;
                    }
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = sQLiteStatementPrepare;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Partner>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final UserDao_Impl userDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.c8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserDao_Impl.C09841.convertRows$lambda$0(roomRawQuery, userDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public UserDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfUser = new EntityInsertAdapter<User>() { // from class: cu.todus.android.db.dao.toDus.UserDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `user` (`uid`,`username`,`alias`,`photoUrl`,`description`,`version`,`photoThumbnail`,`official`,`blocked`,`toDusId`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, User entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUid());
                statement.mo9387bindText(2, entity.getUsername());
                statement.mo9387bindText(3, entity.getAlias());
                statement.mo9387bindText(4, entity.getPhotoUrl());
                statement.mo9387bindText(5, entity.getDescription());
                statement.mo9385bindLong(6, entity.getVersion());
                statement.mo9387bindText(7, entity.getPhotoThumbnail());
                statement.mo9385bindLong(8, entity.getOfficial());
                statement.mo9385bindLong(9, entity.getBlocked() ? 1L : 0L);
                statement.mo9387bindText(10, entity.getToDusId());
            }
        };
        this.__upsertAdapterOfUser = new EntityUpsertAdapter<>(new EntityInsertAdapter<User>() { // from class: cu.todus.android.db.dao.toDus.UserDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT INTO `user` (`uid`,`username`,`alias`,`photoUrl`,`description`,`version`,`photoThumbnail`,`official`,`blocked`,`toDusId`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, User entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUid());
                statement.mo9387bindText(2, entity.getUsername());
                statement.mo9387bindText(3, entity.getAlias());
                statement.mo9387bindText(4, entity.getPhotoUrl());
                statement.mo9387bindText(5, entity.getDescription());
                statement.mo9385bindLong(6, entity.getVersion());
                statement.mo9387bindText(7, entity.getPhotoThumbnail());
                statement.mo9385bindLong(8, entity.getOfficial());
                statement.mo9385bindLong(9, entity.getBlocked() ? 1L : 0L);
                statement.mo9387bindText(10, entity.getToDusId());
            }
        }, new EntityDeleteOrUpdateAdapter<User>() { // from class: cu.todus.android.db.dao.toDus.UserDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE `user` SET `uid` = ?,`username` = ?,`alias` = ?,`photoUrl` = ?,`description` = ?,`version` = ?,`photoThumbnail` = ?,`official` = ?,`blocked` = ?,`toDusId` = ? WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, User entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getUid());
                statement.mo9387bindText(2, entity.getUsername());
                statement.mo9387bindText(3, entity.getAlias());
                statement.mo9387bindText(4, entity.getPhotoUrl());
                statement.mo9387bindText(5, entity.getDescription());
                statement.mo9385bindLong(6, entity.getVersion());
                statement.mo9387bindText(7, entity.getPhotoThumbnail());
                statement.mo9385bindLong(8, entity.getOfficial());
                statement.mo9385bindLong(9, entity.getBlocked() ? 1L : 0L);
                statement.mo9387bindText(10, entity.getToDusId());
                statement.mo9387bindText(11, entity.getUid());
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.m7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20554c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `phone`,`uid`,`fName`,`phoneType`,`photoUri`,`state` FROM `Contact` WHERE `phone` IN (");
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
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "phone");
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(UserDao_Impl userDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(final SQLiteConnection _connection, ArrayMap<String, Room> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        int i10 = 0;
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.l7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(this.f20534c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `id`,`name`,`type`,`version`,`subject`,`config`,`lastUpdate`,`unreadMessages`,`msgId`,`pined`,`secret`,`isMuted` FROM `rooms` WHERE `id` IN (");
        StringUtil.appendPlaceholders(sb2, setKeySet.size());
        sb2.append(")");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo9387bindText(i11, it.next());
            i11++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "id");
            if (columnIndex == -1) {
                sQLiteStatementPrepare.close();
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndex);
                if (_map.containsKey(text)) {
                    _map.put(text, new Room(sQLiteStatementPrepare.getText(i10), sQLiteStatementPrepare.getText(1), (int) sQLiteStatementPrepare.getLong(2), sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.getText(4), this.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(5)), sQLiteStatementPrepare.getLong(6), (int) sQLiteStatementPrepare.getLong(7), sQLiteStatementPrepare.getText(8), ((int) sQLiteStatementPrepare.getLong(9)) != 0, ((int) sQLiteStatementPrepare.getLong(10)) != 0, ((int) sQLiteStatementPrepare.getLong(11)) != 0));
                    i10 = 0;
                }
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(UserDao_Impl userDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 changeBlockState$lambda$0(String str, boolean z10, String str2, SQLiteConnection _connection) {
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
    public static final List getAllBlocked$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 getAllPartners$lambda$0(String str, String str2, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final User getById$lambda$0(String str, String str2, SQLiteConnection _connection) {
        User user;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
            if (sQLiteStatementPrepare.step()) {
                user = new User(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow10));
            } else {
                user = null;
            }
            return user;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final User getByToDusId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        User user;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
            if (sQLiteStatementPrepare.step()) {
                user = new User(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow10));
            } else {
                user = null;
            }
            return user;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getOtherUsers$lambda$0(String str, String str2, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str2);
        _stmt.mo9387bindText(3, str2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Partner getPartnerById$lambda$0(String str, String str2, UserDao_Impl userDao_Impl, SQLiteConnection _connection) {
        Partner partner;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
            ArrayMap<String, Contact> arrayMap = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap2 = new ArrayMap<>();
            while (true) {
                partner = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow10 = columnIndexOrThrow10;
            }
            int i10 = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
            userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap2);
            if (sQLiteStatementPrepare.step()) {
                partner = new Partner(new User(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(i10)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return partner;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Partner getPartnerByIdFlow$lambda$0(String str, String str2, UserDao_Impl userDao_Impl, SQLiteConnection _connection) {
        Partner partner;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
            ArrayMap<String, Contact> arrayMap = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap2 = new ArrayMap<>();
            while (true) {
                partner = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow10 = columnIndexOrThrow10;
            }
            int i10 = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            userDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap);
            userDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap2);
            if (sQLiteStatementPrepare.step()) {
                partner = new Partner(new User(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(i10)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return partner;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final User getUserByPossibleNumbers$lambda$0(String str, List list, SQLiteConnection _connection) {
        User user;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i10, (String) it.next());
                i10++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "username");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_ALIAS);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "photoUrl");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "description");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_PHOTO_THUMBNAIL);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "official");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "blocked");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, User.COLUMN_TODUS_ID);
            if (sQLiteStatementPrepare.step()) {
                user = new User(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow10));
            } else {
                user = null;
            }
            return user;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(UserDao_Impl userDao_Impl, User user, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userDao_Impl.__insertAdapterOfUser.insert(_connection, user);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateToDusId$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final ua.k0 upsert$lambda$0(UserDao_Impl userDao_Impl, User user, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userDao_Impl.__upsertAdapterOfUser.upsert(_connection, user);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 upsert$lambda$1(UserDao_Impl userDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        userDao_Impl.__upsertAdapterOfUser.upsert(_connection, list);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object changeBlockState(final boolean z10, final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE user SET blocked = ? WHERE uid = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.z7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.changeBlockState$lambda$0(str2, z10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public te.h getAllBlocked() {
        final String str = "SELECT uid FROM user WHERE blocked = 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"user"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.t7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getAllBlocked$lambda$0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public PagingSource<Integer, Partner> getAllPartners(final String filter, final String ownerId) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09821(new RoomRawQuery("SELECT * FROM user WHERE uid != ? AND  toDusId LIKE '%'||?||'%'", new Function1() { // from class: cu.todus.android.db.dao.toDus.u7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getAllPartners$lambda$0(ownerId, filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"Contact", Room.TABLE_NAME, "user"});
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public PagingSource<Integer, Partner> getBlockedPartners() {
        return new C09831(new RoomRawQuery("SELECT * FROM user WHERE blocked = 1", null, 2, null), this, this.__db, new String[]{"Contact", Room.TABLE_NAME, "user"});
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object getById(final String str, ab.e<? super User> eVar) {
        final String str2 = "SELECT * FROM user WHERE uid =?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.x7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object getByToDusId(final String str, ab.e<? super User> eVar) {
        final String str2 = "SELECT * FROM user WHERE toDusId =?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.w7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getByToDusId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public PagingSource<Integer, Partner> getOtherUsers(final String filter, final String ownerId) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09841(new RoomRawQuery("SELECT * FROM user WHERE uid != ? AND alias LIKE '%'||?||'%' OR toDusId LIKE '%'||?||'%'", new Function1() { // from class: cu.todus.android.db.dao.toDus.s7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getOtherUsers$lambda$0(ownerId, filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"Contact", Room.TABLE_NAME, "user"});
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object getPartnerById(final String str, ab.e<? super Partner> eVar) {
        final String str2 = "SELECT * FROM user WHERE uid =?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getPartnerById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public te.h getPartnerByIdFlow(final String userId) {
        kotlin.jvm.internal.y.i(userId, "userId");
        final String str = "SELECT * FROM user WHERE uid =?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"Contact", Room.TABLE_NAME, "user"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.r7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getPartnerByIdFlow$lambda$0(str, userId, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object getUserByPossibleNumbers(final List<String> list, ab.e<? super User> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM user WHERE username in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(") LIMIT 1");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.q7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.getUserByPossibleNumbers$lambda$0(string, list, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object insert(final User user, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.n7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.insert$lambda$0(this.f20575c, user, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object updateToDusId(final String str, final String str2, ab.e<? super ua.k0> eVar) {
        final String str3 = "UPDATE user SET toDusId = ? WHERE username = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.updateToDusId$lambda$0(str3, str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object upsert(final User user, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.o7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.upsert$lambda$0(this.f20596c, user, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.UserDao
    public Object upsert(final List<User> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.y7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDao_Impl.upsert$lambda$1(this.f20809c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
