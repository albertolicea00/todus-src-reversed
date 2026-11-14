package cu.todus.android.db.dao.toDus;

import androidx.collection.ArrayMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingSource;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
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
import cu.todus.android.data.db.pojo.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u0019\u0010\u0015J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u001a\u0010\u0015J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0004\b\u001b\u0010\u0015J\u001e\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0096@¢\u0006\u0004\b\u001e\u0010\u0013J+\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\tH\u0096@¢\u0006\u0004\b&\u0010\u0018J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b'\u0010\u0018J\u001e\u0010)\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0096@¢\u0006\u0004\b)\u0010\u0013J\u001e\u0010+\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0096@¢\u0006\u0004\b+\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcu/todus/android/db/dao/toDus/ContactDao_Impl;", "Lcu/todus/android/db/dao/toDus/ContactDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "_map", "Lua/k0;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "", "Lcu/todus/android/data/db/entity/toDus/Contact;", "contacts", "insert", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "getAll", "(Lab/e;)Ljava/lang/Object;", "phone", "getByPhone", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getAllUploaded", "getAllWaiting", "getContactsNotInUser", Service.Endpoint.LINKED_DEVICES_LIST, "", "getIn", "filter", "ownerId", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/Friend;", "getFriends", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "friendId", "getFriendById", "getFriendsIds", "contactPhones", "updatedToUploaded", "phones", "deleteByPhones", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfContact", "Landroidx/room/EntityInsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContactDao_Impl implements ContactDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Contact> __insertAdapterOfContact;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/ContactDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.ContactDao_Impl$getFriends$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/ContactDao_Impl$getFriends$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/Friend;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09621 extends LimitOffsetPagingSource<Friend> {
        final /* synthetic */ ContactDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09621(RoomRawQuery roomRawQuery, ContactDao_Impl contactDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = contactDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, ContactDao_Impl contactDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                ArrayMap arrayMap = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                }
                sQLiteStatementPrepare.reset();
                contactDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Friend(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Friend>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final ContactDao_Impl contactDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ContactDao_Impl.C09621.convertRows$lambda$0(roomRawQuery, contactDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public ContactDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfContact = new EntityInsertAdapter<Contact>() { // from class: cu.todus.android.db.dao.toDus.ContactDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Contact` (`phone`,`uid`,`fName`,`phoneType`,`photoUri`,`state`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Contact entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getPhone());
                statement.mo9387bindText(2, entity.getUid());
                statement.mo9387bindText(3, entity.getFName());
                statement.mo9387bindText(4, entity.getPhoneType());
                statement.mo9387bindText(5, entity.getPhotoUri());
                String state = entity.getState();
                if (state == null) {
                    statement.mo9386bindNull(6);
                } else {
                    statement.mo9387bindText(6, state);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ContactDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20497c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `uid`,`username`,`alias`,`photoUrl`,`description`,`version`,`photoThumbnail`,`official`,`blocked`,`toDusId` FROM `user` WHERE `username` IN (");
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
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "username");
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(ContactDao_Impl contactDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        contactDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteByPhones$lambda$0(String str, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
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
    public static final List getAll$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllUploaded$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllWaiting$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Contact getByPhone$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            Contact contact = null;
            if (sQLiteStatementPrepare.step()) {
                contact = new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6));
            }
            return contact;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getContactsNotInUser$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Friend getFriendById$lambda$0(String str, String str2, ContactDao_Impl contactDao_Impl, SQLiteConnection _connection) {
        Friend friend;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "phone");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uid");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_FULL_NAME);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHONE_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Contact.COLUMN_PHOTO_URI);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            while (true) {
                friend = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
            }
            sQLiteStatementPrepare.reset();
            contactDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            if (sQLiteStatementPrepare.step()) {
                friend = new Friend(new Contact(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return friend;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getFriends$lambda$0(String str, String str2, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str2);
        _stmt.mo9387bindText(3, str2);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getFriendsIds$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final int getIn$lambda$0(String str, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i10, (String) it.next());
                i10++;
            }
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(ContactDao_Impl contactDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        contactDao_Impl.__insertAdapterOfContact.insert(_connection, list);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updatedToUploaded$lambda$0(String str, List list, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
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

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object deleteByPhones(final List<String> list, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM contact WHERE phone IN (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.deleteByPhones$lambda$0(string, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getAll(ab.e<? super List<Contact>> eVar) {
        final String str = "SELECT * FROM contact";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getAll$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getAllUploaded(ab.e<? super List<Contact>> eVar) {
        final String str = "SELECT * FROM contact WHERE state = 'uploaded'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getAllUploaded$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getAllWaiting(ab.e<? super List<Contact>> eVar) {
        final String str = "SELECT * FROM contact WHERE state = 'waiting'";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getAllWaiting$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getByPhone(final String str, ab.e<? super Contact> eVar) {
        final String str2 = "SELECT * FROM contact WHERE phone = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getByPhone$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getContactsNotInUser(ab.e<? super List<Contact>> eVar) {
        final String str = "\n        SELECT * FROM contact \n        WHERE NOT EXISTS (\n            SELECT 1 FROM user \n            WHERE user.username = contact.phone\n        )\n    ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getContactsNotInUser$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getFriendById(final String str, ab.e<? super Friend> eVar) {
        final String str2 = "SELECT * FROM contact WHERE uid = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getFriendById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public PagingSource<Integer, Friend> getFriends(final String filter, final String ownerId) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09621(new RoomRawQuery("\n        SELECT c.* FROM contact as c \n        JOIN user as u ON c.uid = u.uid \n        WHERE c.uid != ? \n        AND u.uid IS NOT NULL \n        AND (c.fName LIKE '%' || ? || '%' OR c.phone LIKE '%' || ? || '%') \n        ORDER BY c.fName COLLATE NOCASE ASC\n    ", new Function1() { // from class: cu.todus.android.db.dao.toDus.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getFriends$lambda$0(ownerId, filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "contact"});
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getFriendsIds(final String str, ab.e<? super List<String>> eVar) {
        final String str2 = "SELECT c.uid FROM contact c, user u WHERE u.uid == c.uid AND u.uid != ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.getFriendsIds$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object getIn(final List<String> list, ab.e<? super Integer> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT COUNT(*) FROM contact WHERE phone IN (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ContactDao_Impl.getIn$lambda$0(string, list, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object insert(final List<Contact> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.insert$lambda$0(this.f20345c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.ContactDao
    public Object updatedToUploaded(final List<String> list, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE contact SET state = 'uploaded' WHERE phone IN (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContactDao_Impl.updatedToUploaded$lambda$0(string, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
