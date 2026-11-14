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
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ1\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ1\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\bH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ-\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001e\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001f\u0010\u001bJ1\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016¢\u0006\u0004\b&\u0010'J1\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016¢\u0006\u0004\b(\u0010'J#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b)\u0010*J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180!H\u0096@¢\u0006\u0004\b)\u0010+J#\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010*J#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010*J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020%0!H\u0096@¢\u0006\u0004\b.\u0010+J\u001a\u00100\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018022\u0006\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u00104J\u001a\u00105\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\b5\u00101J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180!H\u0096@¢\u0006\u0004\b6\u0010+J#\u00107\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b7\u0010*J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020%0!H\u0096@¢\u0006\u0004\b8\u0010+J#\u00109\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020%0$2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010*J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020\"02H\u0016¢\u0006\u0004\b:\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180!H\u0096@¢\u0006\u0004\b<\u0010+J\u0018\u0010=\u001a\u00020\f2\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\b=\u00101J(\u0010A\u001a\u00020\f2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u001cH\u0096@¢\u0006\u0004\bA\u0010BJ\u0018\u0010C\u001a\u00020\f2\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\bC\u00101J\u0018\u0010D\u001a\u00020\f2\u0006\u0010/\u001a\u00020\tH\u0096@¢\u0006\u0004\bD\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010HR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00180M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00180P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Lcu/todus/android/db/dao/toDus/RoomDao_Impl;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "_map", "Lua/k0;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/Contact;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions", "Lcu/todus/android/data/db/entity/toDus/Room;", MarkerAction.COLUMN_ROOM, "insert", "(Lcu/todus/android/data/db/entity/toDus/Room;Lab/e;)Ljava/lang/Object;", "", "insertIfNeed", DiscoverItems.Item.UPDATE_ACTION, "upsert", "filter", "", "", "types", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "getAllRooms", "(Ljava/lang/String;Ljava/util/List;)Landroidx/paging/PagingSource;", "getAllRoomsWithRequestModeOn", "getSecretRooms", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "(Lab/e;)Ljava/lang/Object;", "getMutedRooms", "getAllGroupsAndChannels", "getAllRoomList", "uid", "getRoomById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lte/h;", "getRoomByIdFlow", "(Ljava/lang/String;)Lte/h;", "getRoomItemViewById", "getMyChannels", "getOpenRooms", "getAllForSaves", "getRequestRooms", "getRequestRoomsCount", "()Lte/h;", "getAllChannels", "delete", "roomId", Room.COLUMN_LAST_MSG, Room.COLUMN_LAST_UPDATE, "updateLastMessage", "(Ljava/lang/String;Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "cleanRoomHistory", "togglePin", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfRoom", "Landroidx/room/EntityInsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__insertAdapterOfRoom_1", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfRoom", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Landroidx/room/EntityUpsertAdapter;", "__upsertAdapterOfRoom", "Landroidx/room/EntityUpsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RoomDao_Impl implements RoomDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Room> __insertAdapterOfRoom;
    private final EntityInsertAdapter<Room> __insertAdapterOfRoom_1;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityDeleteOrUpdateAdapter<Room> __updateAdapterOfRoom;
    private final EntityUpsertAdapter<Room> __upsertAdapterOfRoom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/RoomDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getAllGroupsAndChannels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getAllGroupsAndChannels$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09681 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09681(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.w4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09681.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getAllRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getAllRooms$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09691 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09691(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.x4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09691.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getAllRoomsWithRequestModeOn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getAllRoomsWithRequestModeOn$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09701 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09701(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09701.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getMutedRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getMutedRooms$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09711 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09711(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.z4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09711.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getOpenRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getOpenRooms$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09721 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09721(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.a5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09721.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getRequestRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getRequestRooms$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09731 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09731(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.b5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09731.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.RoomDao_Impl$getSecretRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/RoomDao_Impl$getSecretRooms$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09741 extends LimitOffsetPagingSource<RoomItemView> {
        final /* synthetic */ RoomDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09741(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = roomDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                    columnIndexOrThrow10 = columnIndexOrThrow10;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                }
                int i12 = columnIndexOrThrow9;
                int i13 = columnIndexOrThrow10;
                sQLiteStatementPrepare.reset();
                roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
                roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
                roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    int i17 = i12;
                    int i18 = columnIndexOrThrow5;
                    int i19 = i13;
                    int i20 = columnIndexOrThrow4;
                    int i21 = i11;
                    int i22 = columnIndexOrThrow6;
                    int i23 = i10;
                    int i24 = columnIndexOrThrow7;
                    arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), (MessageWithPartnerWithReactions) arrayMap.get(sQLiteStatementPrepare.getText(i17)), (User) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (Contact) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                    columnIndexOrThrow7 = i24;
                    columnIndexOrThrow2 = i15;
                    i10 = i23;
                    columnIndexOrThrow6 = i22;
                    columnIndexOrThrow5 = i18;
                    i12 = i17;
                    i11 = i21;
                    columnIndexOrThrow3 = i16;
                    columnIndexOrThrow4 = i20;
                    i13 = i19;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends RoomItemView>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final RoomDao_Impl roomDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.c5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.C09741.convertRows$lambda$0(roomRawQuery, roomDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public RoomDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfRoom = new EntityInsertAdapter<Room>() { // from class: cu.todus.android.db.dao.toDus.RoomDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `rooms` (`id`,`name`,`type`,`version`,`subject`,`config`,`lastUpdate`,`unreadMessages`,`msgId`,`pined`,`secret`,`isMuted`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Room entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getName());
                statement.mo9385bindLong(3, entity.getType());
                statement.mo9387bindText(4, entity.getVersion());
                statement.mo9387bindText(5, entity.getSubject());
                statement.mo9387bindText(6, RoomDao_Impl.this.__toDusTypeConverter.fromConfiguration(entity.getConfig()));
                statement.mo9385bindLong(7, entity.getLastUpdate());
                statement.mo9385bindLong(8, entity.getUnreadMessages());
                statement.mo9387bindText(9, entity.getMsgId());
                statement.mo9385bindLong(10, entity.getPined() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getSecret() ? 1L : 0L);
                statement.mo9385bindLong(12, entity.isMuted() ? 1L : 0L);
            }
        };
        this.__insertAdapterOfRoom_1 = new EntityInsertAdapter<Room>() { // from class: cu.todus.android.db.dao.toDus.RoomDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `rooms` (`id`,`name`,`type`,`version`,`subject`,`config`,`lastUpdate`,`unreadMessages`,`msgId`,`pined`,`secret`,`isMuted`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Room entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getName());
                statement.mo9385bindLong(3, entity.getType());
                statement.mo9387bindText(4, entity.getVersion());
                statement.mo9387bindText(5, entity.getSubject());
                statement.mo9387bindText(6, RoomDao_Impl.this.__toDusTypeConverter.fromConfiguration(entity.getConfig()));
                statement.mo9385bindLong(7, entity.getLastUpdate());
                statement.mo9385bindLong(8, entity.getUnreadMessages());
                statement.mo9387bindText(9, entity.getMsgId());
                statement.mo9385bindLong(10, entity.getPined() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getSecret() ? 1L : 0L);
                statement.mo9385bindLong(12, entity.isMuted() ? 1L : 0L);
            }
        };
        this.__updateAdapterOfRoom = new EntityDeleteOrUpdateAdapter<Room>() { // from class: cu.todus.android.db.dao.toDus.RoomDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `rooms` SET `id` = ?,`name` = ?,`type` = ?,`version` = ?,`subject` = ?,`config` = ?,`lastUpdate` = ?,`unreadMessages` = ?,`msgId` = ?,`pined` = ?,`secret` = ?,`isMuted` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Room entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getName());
                statement.mo9385bindLong(3, entity.getType());
                statement.mo9387bindText(4, entity.getVersion());
                statement.mo9387bindText(5, entity.getSubject());
                statement.mo9387bindText(6, RoomDao_Impl.this.__toDusTypeConverter.fromConfiguration(entity.getConfig()));
                statement.mo9385bindLong(7, entity.getLastUpdate());
                statement.mo9385bindLong(8, entity.getUnreadMessages());
                statement.mo9387bindText(9, entity.getMsgId());
                statement.mo9385bindLong(10, entity.getPined() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getSecret() ? 1L : 0L);
                statement.mo9385bindLong(12, entity.isMuted() ? 1L : 0L);
                statement.mo9387bindText(13, entity.getId());
            }
        };
        this.__upsertAdapterOfRoom = new EntityUpsertAdapter<>(new EntityInsertAdapter<Room>() { // from class: cu.todus.android.db.dao.toDus.RoomDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT INTO `rooms` (`id`,`name`,`type`,`version`,`subject`,`config`,`lastUpdate`,`unreadMessages`,`msgId`,`pined`,`secret`,`isMuted`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Room entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getName());
                statement.mo9385bindLong(3, entity.getType());
                statement.mo9387bindText(4, entity.getVersion());
                statement.mo9387bindText(5, entity.getSubject());
                statement.mo9387bindText(6, RoomDao_Impl.this.__toDusTypeConverter.fromConfiguration(entity.getConfig()));
                statement.mo9385bindLong(7, entity.getLastUpdate());
                statement.mo9385bindLong(8, entity.getUnreadMessages());
                statement.mo9387bindText(9, entity.getMsgId());
                statement.mo9385bindLong(10, entity.getPined() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getSecret() ? 1L : 0L);
                statement.mo9385bindLong(12, entity.isMuted() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<Room>() { // from class: cu.todus.android.db.dao.toDus.RoomDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE `rooms` SET `id` = ?,`name` = ?,`type` = ?,`version` = ?,`subject` = ?,`config` = ?,`lastUpdate` = ?,`unreadMessages` = ?,`msgId` = ?,`pined` = ?,`secret` = ?,`isMuted` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Room entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getName());
                statement.mo9385bindLong(3, entity.getType());
                statement.mo9387bindText(4, entity.getVersion());
                statement.mo9387bindText(5, entity.getSubject());
                statement.mo9387bindText(6, RoomDao_Impl.this.__toDusTypeConverter.fromConfiguration(entity.getConfig()));
                statement.mo9385bindLong(7, entity.getLastUpdate());
                statement.mo9385bindLong(8, entity.getUnreadMessages());
                statement.mo9387bindText(9, entity.getMsgId());
                statement.mo9385bindLong(10, entity.getPined() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getSecret() ? 1L : 0L);
                statement.mo9385bindLong(12, entity.isMuted() ? 1L : 0L);
                statement.mo9387bindText(13, entity.getId());
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.m4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20548c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(RoomDao_Impl roomDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    private final void __fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(final SQLiteConnection _connection, ArrayMap<String, List<Attachment>> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment$lambda$0(this.f20612c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `id`,`msg`,`content`,`state`,`type`,`persistent` FROM `attachments` WHERE `msg` IN (");
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
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "msg");
            if (columnIndex == -1) {
                sQLiteStatementPrepare.close();
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                List<Attachment> list = _map.get(sQLiteStatementPrepare.getText(columnIndex));
                if (list != null) {
                    list.add(new Attachment(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), this.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(2)), (int) sQLiteStatementPrepare.getLong(3), (int) sQLiteStatementPrepare.getLong(4), ((int) sQLiteStatementPrepare.getLong(5)) != 0));
                }
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment$lambda$0(RoomDao_Impl roomDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        roomDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(final SQLiteConnection _connection, ArrayMap<String, MessageWithPartnerWithReactions> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        int i10 = 0;
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.t4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions$lambda$0(this.f20704c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `id`,`roomId`,`userSender`,`content`,`createAt`,`state`,`payload`,`messageEntities`,`publId` FROM `messages` WHERE `id` IN (");
        StringUtil.appendPlaceholders(sb2, setKeySet.size());
        sb2.append(")");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(string);
        Iterator<String> it = setKeySet.iterator();
        int i11 = 1;
        int i12 = 1;
        while (it.hasNext()) {
            sQLiteStatementPrepare.mo9387bindText(i12, it.next());
            i12++;
        }
        try {
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, "id");
            if (columnIndex == -1) {
                return;
            }
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            ArrayMap<String, List<Reaction>> arrayMap4 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                arrayMap.put(sQLiteStatementPrepare.getText(2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(2), null);
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(0);
                if (!arrayMap4.containsKey(text2)) {
                    arrayMap4.put(text2, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            __fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            __fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap4);
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndex);
                if (_map.containsKey(text3)) {
                    String text4 = sQLiteStatementPrepare.getText(i10);
                    String text5 = sQLiteStatementPrepare.getText(i11);
                    String text6 = sQLiteStatementPrepare.getText(2);
                    String text7 = sQLiteStatementPrepare.getText(3);
                    long j10 = sQLiteStatementPrepare.getLong(4);
                    int i13 = (int) sQLiteStatementPrepare.getLong(5);
                    String text8 = sQLiteStatementPrepare.isNull(6) ? null : sQLiteStatementPrepare.getText(6);
                    Message message = new Message(text4, text5, text6, text7, j10, i13, text8 == null ? null : this.__toDusTypeConverter.toMessagePayload(text8), this.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(7)), sQLiteStatementPrepare.isNull(8) ? null : sQLiteStatementPrepare.getText(8));
                    User user = arrayMap.get(sQLiteStatementPrepare.getText(2));
                    Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(2));
                    Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(0));
                    kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                    List list = (List) objJ;
                    Object objJ2 = va.w0.j(arrayMap4, sQLiteStatementPrepare.getText(0));
                    kotlin.jvm.internal.y.h(objJ2, "getValue(...)");
                    _map.put(text3, new MessageWithPartnerWithReactions(message, user, contact, list, (List) objJ2));
                    i10 = 0;
                    i11 = 1;
                }
            }
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions$lambda$0(RoomDao_Impl roomDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    private final void __fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(final SQLiteConnection _connection, ArrayMap<String, List<Reaction>> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.c4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction$lambda$0(this.f20332c, _connection, (ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT `id`,`entity`,`userId`,`roomId`,`reactionContent`,`reactionState`,`createdAt` FROM `reaction` WHERE `entity` IN (");
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
            int columnIndex = SQLiteStatementUtil.getColumnIndex(sQLiteStatementPrepare, Reaction.COLUMN_ENTITY);
            if (columnIndex == -1) {
                sQLiteStatementPrepare.close();
                return;
            }
            while (sQLiteStatementPrepare.step()) {
                List<Reaction> list = _map.get(sQLiteStatementPrepare.getText(columnIndex));
                if (list != null) {
                    list.add(new Reaction(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.getText(2), sQLiteStatementPrepare.getText(3), sQLiteStatementPrepare.getText(4), (int) sQLiteStatementPrepare.getLong(5), sQLiteStatementPrepare.getLong(6)));
                }
            }
            sQLiteStatementPrepare.close();
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 __fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction$lambda$0(RoomDao_Impl roomDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        roomDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RoomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20743c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(RoomDao_Impl roomDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 cleanRoomHistory$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 delete$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final List getAllChannels$lambda$0(String str, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                int i12 = columnIndexOrThrow3;
                int i13 = columnIndexOrThrow4;
                arrayList.add(new Room(text, text2, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0));
                columnIndexOrThrow = i10;
                columnIndexOrThrow4 = i13;
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow2 = i11;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllForSaves$lambda$0(String str, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        RoomDao_Impl roomDao_Impl2 = roomDao_Impl;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayMap<String, MessageWithPartnerWithReactions> arrayMap = new ArrayMap<>();
            int i10 = columnIndexOrThrow12;
            ArrayMap<String, User> arrayMap2 = new ArrayMap<>();
            int i11 = columnIndexOrThrow11;
            ArrayMap<String, Contact> arrayMap3 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow10 = columnIndexOrThrow10;
                columnIndexOrThrow9 = columnIndexOrThrow9;
            }
            int i12 = columnIndexOrThrow9;
            int i13 = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            roomDao_Impl2.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
            roomDao_Impl2.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
            roomDao_Impl2.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                int i15 = columnIndexOrThrow2;
                Map<String, String> configuration = roomDao_Impl2.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6));
                int i16 = columnIndexOrThrow3;
                int i17 = i12;
                int i18 = columnIndexOrThrow5;
                int i19 = i13;
                int i20 = columnIndexOrThrow4;
                int i21 = i11;
                int i22 = columnIndexOrThrow6;
                int i23 = i10;
                int i24 = columnIndexOrThrow7;
                arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, configuration, sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), arrayMap.get(sQLiteStatementPrepare.getText(i17)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow7 = i24;
                roomDao_Impl2 = roomDao_Impl;
                i10 = i23;
                columnIndexOrThrow6 = i22;
                columnIndexOrThrow5 = i18;
                columnIndexOrThrow2 = i15;
                i12 = i17;
                i11 = i21;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow4 = i20;
                i13 = i19;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getAllGroupsAndChannels$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllRoomList$lambda$0(String str, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        RoomDao_Impl roomDao_Impl2 = roomDao_Impl;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayMap<String, MessageWithPartnerWithReactions> arrayMap = new ArrayMap<>();
            int i10 = columnIndexOrThrow12;
            ArrayMap<String, User> arrayMap2 = new ArrayMap<>();
            int i11 = columnIndexOrThrow11;
            ArrayMap<String, Contact> arrayMap3 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow10 = columnIndexOrThrow10;
                columnIndexOrThrow9 = columnIndexOrThrow9;
            }
            int i12 = columnIndexOrThrow9;
            int i13 = columnIndexOrThrow10;
            sQLiteStatementPrepare.reset();
            roomDao_Impl2.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
            roomDao_Impl2.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
            roomDao_Impl2.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                int i15 = columnIndexOrThrow2;
                Map<String, String> configuration = roomDao_Impl2.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6));
                int i16 = columnIndexOrThrow3;
                int i17 = i12;
                int i18 = columnIndexOrThrow5;
                int i19 = i13;
                int i20 = columnIndexOrThrow4;
                int i21 = i11;
                int i22 = columnIndexOrThrow6;
                int i23 = i10;
                int i24 = columnIndexOrThrow7;
                arrayList.add(new RoomItemView(new Room(text, text2, i14, text3, text4, configuration, sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(i17), ((int) sQLiteStatementPrepare.getLong(i19)) != 0, ((int) sQLiteStatementPrepare.getLong(i21)) != 0, ((int) sQLiteStatementPrepare.getLong(i23)) != 0), arrayMap.get(sQLiteStatementPrepare.getText(i17)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                columnIndexOrThrow7 = i24;
                roomDao_Impl2 = roomDao_Impl;
                i10 = i23;
                columnIndexOrThrow6 = i22;
                columnIndexOrThrow5 = i18;
                columnIndexOrThrow2 = i15;
                i12 = i17;
                i11 = i21;
                columnIndexOrThrow3 = i16;
                columnIndexOrThrow4 = i20;
                i13 = i19;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getAllRooms$lambda$0(List list, int i10, String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            _stmt.mo9385bindLong(i11, ((Number) it.next()).intValue());
            i11++;
        }
        _stmt.mo9387bindText(i10 + 1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getAllRoomsWithRequestModeOn$lambda$0(List list, int i10, String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            _stmt.mo9385bindLong(i11, ((Number) it.next()).intValue());
            i11++;
        }
        _stmt.mo9387bindText(i10 + 1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getMutedRooms$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getMyChannels$lambda$0(String str, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                int i12 = columnIndexOrThrow3;
                int i13 = columnIndexOrThrow4;
                arrayList.add(new Room(text, text2, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0));
                columnIndexOrThrow = i10;
                columnIndexOrThrow4 = i13;
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow2 = i11;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getOpenRooms$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getRequestRooms$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getRequestRoomsCount$lambda$0(String str, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room getRoomById$lambda$0(String str, String str2, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        Room room;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            if (sQLiteStatementPrepare.step()) {
                room = new Room(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0);
            } else {
                room = null;
            }
            return room;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room getRoomByIdFlow$lambda$0(String str, String str2, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        Room room;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            if (sQLiteStatementPrepare.step()) {
                room = new Room(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0);
            } else {
                room = null;
            }
            return room;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomItemView getRoomItemViewById$lambda$0(String str, String str2, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        int i10;
        RoomItemView roomItemView;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayMap<String, MessageWithPartnerWithReactions> arrayMap = new ArrayMap<>();
            ArrayMap<String, User> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap3 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow10;
                roomItemView = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow9), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), null);
                columnIndexOrThrow8 = columnIndexOrThrow8;
                columnIndexOrThrow10 = i10;
            }
            int i11 = columnIndexOrThrow8;
            sQLiteStatementPrepare.reset();
            roomDao_Impl.__fetchRelationshipmessagesAscuTodusAndroidDataDbPojoMessageWithPartnerWithReactions(_connection, arrayMap);
            roomDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap2);
            roomDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap3);
            if (sQLiteStatementPrepare.step()) {
                roomItemView = new RoomItemView(new Room(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(i11), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(i10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)));
            }
            return roomItemView;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getSecretRooms$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getSecretRooms$lambda$1(String str, RoomDao_Impl roomDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "name");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "subject");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.CONFIG_CONFIG);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_UPDATE);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_UNREAD);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_LAST_MSG);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_PINED);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_SECRET);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Room.COLUMN_MUTED);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                int i12 = columnIndexOrThrow3;
                int i13 = columnIndexOrThrow4;
                arrayList.add(new Room(text, text2, (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), roomDao_Impl.__toDusTypeConverter.toConfiguration(sQLiteStatementPrepare.getText(columnIndexOrThrow6)), sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.getText(columnIndexOrThrow9), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0));
                columnIndexOrThrow = i10;
                columnIndexOrThrow4 = i13;
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow2 = i11;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(RoomDao_Impl roomDao_Impl, Room room, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        roomDao_Impl.__insertAdapterOfRoom.insert(_connection, room);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertIfNeed$lambda$0(RoomDao_Impl roomDao_Impl, Room room, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return roomDao_Impl.__insertAdapterOfRoom_1.insertAndReturnId(_connection, room);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 togglePin$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 update$lambda$0(RoomDao_Impl roomDao_Impl, Room room, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        roomDao_Impl.__updateAdapterOfRoom.handle(_connection, room);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateLastMessage$lambda$0(String str, String str2, long j10, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9385bindLong(2, j10);
            sQLiteStatementPrepare.mo9387bindText(3, str3);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 upsert$lambda$0(RoomDao_Impl roomDao_Impl, Room room, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        roomDao_Impl.__upsertAdapterOfRoom.upsert(_connection, room);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object cleanRoomHistory(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE rooms SET msgId = '', unreadMessages = 0  WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.u4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.cleanRoomHistory$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object delete(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM rooms WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.t3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.delete$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getAllChannels(ab.e<? super List<Room>> eVar) {
        final String str = "SELECT * FROM rooms r WHERE r.type == 2";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.e4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllChannels$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getAllForSaves(ab.e<? super List<RoomItemView>> eVar) {
        final String str = "SELECT * FROM rooms WHERE type != 2";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllForSaves$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getAllGroupsAndChannels(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09681(new RoomRawQuery("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type != 0 AND r.name LIKE '%'||?||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.j4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllGroupsAndChannels$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getAllRoomList(ab.e<? super List<RoomItemView>> eVar) {
        final String str = "SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1))) order by r.lastUpdate desc";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllRoomList$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getAllRooms(final String filter, final List<Integer> types) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(types, "types");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type in (");
        final int size = types.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb2.append(") AND (r.secret != 1 AND r.name LIKE '%'||");
        sb2.append("?");
        sb2.append("||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return new C09691(new RoomRawQuery(string, new Function1() { // from class: cu.todus.android.db.dao.toDus.q4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllRooms$lambda$0(types, size, filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getAllRoomsWithRequestModeOn(final String filter, final List<Integer> types) {
        kotlin.jvm.internal.y.i(filter, "filter");
        kotlin.jvm.internal.y.i(types, "types");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type in (");
        final int size = types.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb2.append(") AND ((r.type != 0 OR (r.config LIKE '%'||'unknown_ROOM'||'%' OR (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 1)) AND r.secret != 1 AND r.name LIKE '%'||");
        sb2.append("?");
        sb2.append("||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc");
        String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return new C09701(new RoomRawQuery(string, new Function1() { // from class: cu.todus.android.db.dao.toDus.b4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getAllRoomsWithRequestModeOn$lambda$0(types, size, filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME, "contact"});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getMutedRooms(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09711(new RoomRawQuery("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.isMuted == 1 AND r.name LIKE '%'||?||'%' order by r.pined desc, r.lastUpdate desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.x3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getMutedRooms$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getMyChannels(ab.e<? super List<Room>> eVar) {
        final String str = "SELECT * FROM rooms WHERE type = 2";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.u3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getMyChannels$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getOpenRooms(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09721(new RoomRawQuery("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.name LIKE '%'||?||'%' AND ? != '' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.i4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getOpenRooms$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getRequestRooms(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09731(new RoomRawQuery("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE (r.type == 0 AND (r.config NOT LIKE '%'||'unknown_ROOM'||'%' AND (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 0)) AND (r.secret != 1 AND r.name LIKE '%'||?||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.s4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getRequestRooms$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME, "contact"});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public te.h getRequestRoomsCount() {
        final String str = "SELECT COUNT(r.id) FROM rooms r WHERE (r.type == 0 AND (r.config NOT LIKE '%'||'unknown_ROOM'||'%' AND (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 0)) AND (r.secret != 1 AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc";
        return FlowUtil.createFlow(this.__db, false, new String[]{Room.TABLE_NAME, "contact"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.v3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(RoomDao_Impl.getRequestRoomsCount$lambda$0(str, (SQLiteConnection) obj));
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getRoomById(final String str, ab.e<? super Room> eVar) {
        final String str2 = "SELECT * FROM rooms WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.o4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getRoomById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public te.h getRoomByIdFlow(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        final String str = "SELECT * FROM rooms WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{Room.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.z3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getRoomByIdFlow$lambda$0(str, uid, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getRoomItemViewById(final String str, ab.e<? super RoomItemView> eVar) {
        final String str2 = "SELECT * FROM rooms WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.h4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getRoomItemViewById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public PagingSource<Integer, RoomItemView> getSecretRooms(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09741(new RoomRawQuery("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.secret == 1 AND r.name LIKE '%'||?||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.a4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getSecretRooms$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME, Room.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object insert(final Room room, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.f4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.insert$lambda$0(this.f20398c, room, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object insertIfNeed(final Room room, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.g4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(RoomDao_Impl.insertIfNeed$lambda$0(this.f20418c, room, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object togglePin(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE rooms SET pined = NOT pined  WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.d4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.togglePin$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object update(final Room room, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.r4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.update$lambda$0(this.f20662c, room, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object updateLastMessage(final String str, final String str2, final long j10, ab.e<? super ua.k0> eVar) {
        final String str3 = "UPDATE rooms SET msgId = ? , lastUpdate = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.l4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.updateLastMessage$lambda$0(str3, str2, j10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object upsert(final Room room, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.w3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.upsert$lambda$0(this.f20761c, room, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.RoomDao
    public Object getSecretRooms(ab.e<? super List<Room>> eVar) {
        final String str = "SELECT * FROM rooms WHERE secret = 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RoomDao_Impl.getSecretRooms$lambda$1(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }
}
