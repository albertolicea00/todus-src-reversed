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
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
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
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ-\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u001eJ#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u001eJ\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130%H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130%H\u0016¢\u0006\u0004\b*\u0010)J\u001a\u0010,\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\tH\u0096@¢\u0006\u0004\b,\u0010$J\u001a\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\b.\u0010$J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0%2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010'J\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0%2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u0010'J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b2\u0010$J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0%2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u0010'J#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t010%2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b4\u0010'J\u001a\u00106\u001a\u0004\u0018\u00010\t2\u0006\u00105\u001a\u00020\tH\u0096@¢\u0006\u0004\b6\u0010$J\u001a\u00107\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\b7\u0010$J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u0013012\u0006\u00108\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b9\u0010:J \u0010;\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\b;\u0010<J \u0010=\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\b=\u0010<J\u001e\u0010>\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b>\u0010$J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\b?\u0010$J6\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c012\u0006\u0010@\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u001bH\u0096@¢\u0006\u0004\bC\u0010DJ\u0018\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\tH\u0096@¢\u0006\u0004\bF\u0010$J\u0018\u0010G\u001a\u00020\f2\u0006\u00105\u001a\u00020\tH\u0096@¢\u0006\u0004\bG\u0010$J\u0018\u0010H\u001a\u00020\f2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\bH\u0010$J\u0010\u0010I\u001a\u00020\fH\u0096@¢\u0006\u0004\bI\u0010JJ \u0010L\u001a\u00020\f2\u0006\u0010E\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u001bH\u0096@¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\bN\u0010$J\u0018\u0010O\u001a\u00020\f2\u0006\u00108\u001a\u00020\u0015H\u0096@¢\u0006\u0004\bO\u0010:J\u0018\u0010P\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tH\u0096@¢\u0006\u0004\bP\u0010$J\u0018\u0010Q\u001a\u00020\f2\u0006\u0010E\u001a\u00020\tH\u0096@¢\u0006\u0004\bQ\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010RR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00130S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00130Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Lcu/todus/android/db/dao/toDus/StatusDao_Impl;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "_map", "Lua/k0;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/Contact;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "Lcu/todus/android/data/db/entity/toDus/Room;", "__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom", "Lcu/todus/android/data/db/entity/toDus/Status;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/Status;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "ownerId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "otherStatusPaging", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "otherStatusPagingInverted", "profileUid", "profileStatusPaging", "ownerStatusPaging", "myLastStatus", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lte/h;", "statusToUpload", "(Ljava/lang/String;)Lte/h;", "statusToDownload", "()Lte/h;", "getUnsentStatus", "getUrl", "getVideoStatusNotProcessed", "statusId", "getStatusById", "otherStatusCount", "ownerLastStatus", "", "getWaitingForUploadStatuses", "getIfThereAreNewUnseenStatus", "getRoomsWithStatusUnseen", Status.COLUMN_REPLIED_ID, "getLastStatusId", "getStatusFullDataById", "actualTime", "getAfter", "(JLab/e;)Ljava/lang/Object;", "getOtherStatusPosition", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getOwnerStatusPosition", "getOtherStatusList", "getOwnerStatusList", "first", "limit", "offset", "getOtherStatusListPaginated", "(Ljava/lang/String;Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "id", "deleteById", "deleteByRepliedId", "setAsSeen", "setAsClosed", "(Lab/e;)Ljava/lang/Object;", "newSate", "changeStatusState", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "prepareToSendStatusWithError", "deleteAfter", "prepareToRetryStatusWithError", "setAsDeleted", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfStatus", "Landroidx/room/EntityInsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfStatus", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusDao_Impl implements StatusDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Status> __insertAdapterOfStatus;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityDeleteOrUpdateAdapter<Status> __updateAdapterOfStatus;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/StatusDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StatusDao_Impl$otherStatusPaging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StatusDao_Impl$otherStatusPaging$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09751 extends LimitOffsetPagingSource<StatusWithPartnersOrRooms> {
        final /* synthetic */ StatusDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09751(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = statusDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
                int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
                int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
                int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                int i12 = columnIndexOrThrow10;
                ArrayMap arrayMap4 = new ArrayMap();
                int i13 = columnIndexOrThrow9;
                ArrayMap arrayMap5 = new ArrayMap();
                int i14 = columnIndexOrThrow8;
                ArrayMap arrayMap6 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    columnIndexOrThrow7 = columnIndexOrThrow7;
                    columnIndexOrThrow6 = columnIndexOrThrow6;
                }
                int i15 = columnIndexOrThrow6;
                int i16 = columnIndexOrThrow7;
                sQLiteStatementPrepare.reset();
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                    boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                    int i17 = i15;
                    ArrayMap arrayMap7 = arrayMap6;
                    boolean z11 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                    int i18 = columnIndexOrThrow4;
                    int i19 = i16;
                    int i20 = columnIndexOrThrow5;
                    boolean z12 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                    int i21 = i14;
                    String text4 = sQLiteStatementPrepare.getText(i21);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    Content attachmentContent = statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(i22));
                    i14 = i21;
                    int i24 = i12;
                    boolean z13 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                    int i25 = i11;
                    boolean z14 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                    int i26 = i10;
                    i12 = i24;
                    List<MessageEntity> messageEntity = statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i26));
                    int i27 = columnIndexOrThrow13;
                    i10 = i26;
                    columnIndexOrThrow13 = i27;
                    int i28 = columnIndexOrThrow15;
                    int i29 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i29;
                    int i30 = columnIndexOrThrow17;
                    arrayList.add(new StatusWithPartnersOrRooms(new Status(text, text2, text3, j10, z10, z11, z12, text4, attachmentContent, z13, z14, messageEntity, (int) sQLiteStatementPrepare.getLong(i27), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(i28), (int) sQLiteStatementPrepare.getLong(i29), (int) sQLiteStatementPrepare.getLong(i30)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (User) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Contact) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Room) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap7.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                    i13 = i22;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow17 = i30;
                    columnIndexOrThrow4 = i18;
                    i15 = i17;
                    i11 = i25;
                    arrayMap6 = arrayMap7;
                    columnIndexOrThrow5 = i20;
                    i16 = i19;
                    columnIndexOrThrow15 = i28;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends StatusWithPartnersOrRooms>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final StatusDao_Impl statusDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.w6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.C09751.convertRows$lambda$0(roomRawQuery, statusDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StatusDao_Impl$otherStatusPagingInverted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StatusDao_Impl$otherStatusPagingInverted$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09761 extends LimitOffsetPagingSource<StatusWithPartnersOrRooms> {
        final /* synthetic */ StatusDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09761(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = statusDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
                int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
                int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
                int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                int i12 = columnIndexOrThrow10;
                ArrayMap arrayMap4 = new ArrayMap();
                int i13 = columnIndexOrThrow9;
                ArrayMap arrayMap5 = new ArrayMap();
                int i14 = columnIndexOrThrow8;
                ArrayMap arrayMap6 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    columnIndexOrThrow7 = columnIndexOrThrow7;
                    columnIndexOrThrow6 = columnIndexOrThrow6;
                }
                int i15 = columnIndexOrThrow6;
                int i16 = columnIndexOrThrow7;
                sQLiteStatementPrepare.reset();
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                    boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                    int i17 = i15;
                    ArrayMap arrayMap7 = arrayMap6;
                    boolean z11 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                    int i18 = columnIndexOrThrow4;
                    int i19 = i16;
                    int i20 = columnIndexOrThrow5;
                    boolean z12 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                    int i21 = i14;
                    String text4 = sQLiteStatementPrepare.getText(i21);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    Content attachmentContent = statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(i22));
                    i14 = i21;
                    int i24 = i12;
                    boolean z13 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                    int i25 = i11;
                    boolean z14 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                    int i26 = i10;
                    i12 = i24;
                    List<MessageEntity> messageEntity = statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i26));
                    int i27 = columnIndexOrThrow13;
                    i10 = i26;
                    columnIndexOrThrow13 = i27;
                    int i28 = columnIndexOrThrow15;
                    int i29 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i29;
                    int i30 = columnIndexOrThrow17;
                    arrayList.add(new StatusWithPartnersOrRooms(new Status(text, text2, text3, j10, z10, z11, z12, text4, attachmentContent, z13, z14, messageEntity, (int) sQLiteStatementPrepare.getLong(i27), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(i28), (int) sQLiteStatementPrepare.getLong(i29), (int) sQLiteStatementPrepare.getLong(i30)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (User) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Contact) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Room) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap7.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                    i13 = i22;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow17 = i30;
                    columnIndexOrThrow4 = i18;
                    i15 = i17;
                    i11 = i25;
                    arrayMap6 = arrayMap7;
                    columnIndexOrThrow5 = i20;
                    i16 = i19;
                    columnIndexOrThrow15 = i28;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends StatusWithPartnersOrRooms>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final StatusDao_Impl statusDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.x6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.C09761.convertRows$lambda$0(roomRawQuery, statusDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StatusDao_Impl$ownerStatusPaging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StatusDao_Impl$ownerStatusPaging$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09771 extends LimitOffsetPagingSource<StatusWithPartnersOrRooms> {
        final /* synthetic */ StatusDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09771(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = statusDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
                int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
                int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
                int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                int i12 = columnIndexOrThrow10;
                ArrayMap arrayMap4 = new ArrayMap();
                int i13 = columnIndexOrThrow9;
                ArrayMap arrayMap5 = new ArrayMap();
                int i14 = columnIndexOrThrow8;
                ArrayMap arrayMap6 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    columnIndexOrThrow7 = columnIndexOrThrow7;
                    columnIndexOrThrow6 = columnIndexOrThrow6;
                }
                int i15 = columnIndexOrThrow6;
                int i16 = columnIndexOrThrow7;
                sQLiteStatementPrepare.reset();
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                    boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                    int i17 = i15;
                    ArrayMap arrayMap7 = arrayMap6;
                    boolean z11 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                    int i18 = columnIndexOrThrow4;
                    int i19 = i16;
                    int i20 = columnIndexOrThrow5;
                    boolean z12 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                    int i21 = i14;
                    String text4 = sQLiteStatementPrepare.getText(i21);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    Content attachmentContent = statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(i22));
                    i14 = i21;
                    int i24 = i12;
                    boolean z13 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                    int i25 = i11;
                    boolean z14 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                    int i26 = i10;
                    i12 = i24;
                    List<MessageEntity> messageEntity = statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i26));
                    int i27 = columnIndexOrThrow13;
                    i10 = i26;
                    columnIndexOrThrow13 = i27;
                    int i28 = columnIndexOrThrow15;
                    int i29 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i29;
                    int i30 = columnIndexOrThrow17;
                    arrayList.add(new StatusWithPartnersOrRooms(new Status(text, text2, text3, j10, z10, z11, z12, text4, attachmentContent, z13, z14, messageEntity, (int) sQLiteStatementPrepare.getLong(i27), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(i28), (int) sQLiteStatementPrepare.getLong(i29), (int) sQLiteStatementPrepare.getLong(i30)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (User) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Contact) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Room) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap7.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                    i13 = i22;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow17 = i30;
                    columnIndexOrThrow4 = i18;
                    i15 = i17;
                    i11 = i25;
                    arrayMap6 = arrayMap7;
                    columnIndexOrThrow5 = i20;
                    i16 = i19;
                    columnIndexOrThrow15 = i28;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends StatusWithPartnersOrRooms>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final StatusDao_Impl statusDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.C09771.convertRows$lambda$0(roomRawQuery, statusDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.StatusDao_Impl$profileStatusPaging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/StatusDao_Impl$profileStatusPaging$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09781 extends LimitOffsetPagingSource<StatusWithPartnersOrRooms> {
        final /* synthetic */ StatusDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09781(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = statusDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
                int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
                int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
                int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
                int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
                int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
                int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
                ArrayMap arrayMap = new ArrayMap();
                int i10 = columnIndexOrThrow12;
                ArrayMap arrayMap2 = new ArrayMap();
                int i11 = columnIndexOrThrow11;
                ArrayMap arrayMap3 = new ArrayMap();
                int i12 = columnIndexOrThrow10;
                ArrayMap arrayMap4 = new ArrayMap();
                int i13 = columnIndexOrThrow9;
                ArrayMap arrayMap5 = new ArrayMap();
                int i14 = columnIndexOrThrow8;
                ArrayMap arrayMap6 = new ArrayMap();
                while (sQLiteStatementPrepare.step()) {
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    columnIndexOrThrow7 = columnIndexOrThrow7;
                    columnIndexOrThrow6 = columnIndexOrThrow6;
                }
                int i15 = columnIndexOrThrow6;
                int i16 = columnIndexOrThrow7;
                sQLiteStatementPrepare.reset();
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
                statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
                statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                    boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                    int i17 = i15;
                    ArrayMap arrayMap7 = arrayMap6;
                    boolean z11 = ((int) sQLiteStatementPrepare.getLong(i17)) != 0;
                    int i18 = columnIndexOrThrow4;
                    int i19 = i16;
                    int i20 = columnIndexOrThrow5;
                    boolean z12 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                    int i21 = i14;
                    String text4 = sQLiteStatementPrepare.getText(i21);
                    int i22 = i13;
                    int i23 = columnIndexOrThrow;
                    Content attachmentContent = statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(i22));
                    i14 = i21;
                    int i24 = i12;
                    boolean z13 = ((int) sQLiteStatementPrepare.getLong(i24)) != 0;
                    int i25 = i11;
                    boolean z14 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                    int i26 = i10;
                    i12 = i24;
                    List<MessageEntity> messageEntity = statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i26));
                    int i27 = columnIndexOrThrow13;
                    i10 = i26;
                    columnIndexOrThrow13 = i27;
                    int i28 = columnIndexOrThrow15;
                    int i29 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i29;
                    int i30 = columnIndexOrThrow17;
                    arrayList.add(new StatusWithPartnersOrRooms(new Status(text, text2, text3, j10, z10, z11, z12, text4, attachmentContent, z13, z14, messageEntity, (int) sQLiteStatementPrepare.getLong(i27), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(i28), (int) sQLiteStatementPrepare.getLong(i29), (int) sQLiteStatementPrepare.getLong(i30)), (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (User) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Contact) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (Room) arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), (Room) arrayMap7.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                    i13 = i22;
                    columnIndexOrThrow = i23;
                    columnIndexOrThrow17 = i30;
                    columnIndexOrThrow4 = i18;
                    i15 = i17;
                    i11 = i25;
                    arrayMap6 = arrayMap7;
                    columnIndexOrThrow5 = i20;
                    i16 = i19;
                    columnIndexOrThrow15 = i28;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends StatusWithPartnersOrRooms>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final StatusDao_Impl statusDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.z6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.C09781.convertRows$lambda$0(roomRawQuery, statusDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public StatusDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfStatus = new EntityInsertAdapter<Status>() { // from class: cu.todus.android.db.dao.toDus.StatusDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `status` (`id`,`creatorId`,`repliedId`,`createdAt`,`isPublic`,`isDelete`,`canRespond`,`type`,`content`,`seen`,`closed`,`messageEntities`,`uploadState`,`location`,`viewCount`,`interactCount`,`shareCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Status entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getCreatorId());
                statement.mo9387bindText(3, entity.getRepliedId());
                statement.mo9385bindLong(4, entity.getCreatedAt());
                statement.mo9385bindLong(5, entity.isPublic() ? 1L : 0L);
                statement.mo9385bindLong(6, entity.isDelete() ? 1L : 0L);
                statement.mo9385bindLong(7, entity.getCanRespond() ? 1L : 0L);
                statement.mo9387bindText(8, entity.getType());
                statement.mo9387bindText(9, StatusDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(10, entity.getSeen() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getClosed() ? 1L : 0L);
                statement.mo9387bindText(12, StatusDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                statement.mo9385bindLong(13, entity.getUploadState());
                statement.mo9387bindText(14, entity.getLocation());
                statement.mo9385bindLong(15, entity.getViewCount());
                statement.mo9385bindLong(16, entity.getInteractCount());
                statement.mo9385bindLong(17, entity.getShareCount());
            }
        };
        this.__updateAdapterOfStatus = new EntityDeleteOrUpdateAdapter<Status>() { // from class: cu.todus.android.db.dao.toDus.StatusDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `status` SET `id` = ?,`creatorId` = ?,`repliedId` = ?,`createdAt` = ?,`isPublic` = ?,`isDelete` = ?,`canRespond` = ?,`type` = ?,`content` = ?,`seen` = ?,`closed` = ?,`messageEntities` = ?,`uploadState` = ?,`location` = ?,`viewCount` = ?,`interactCount` = ?,`shareCount` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Status entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getCreatorId());
                statement.mo9387bindText(3, entity.getRepliedId());
                statement.mo9385bindLong(4, entity.getCreatedAt());
                statement.mo9385bindLong(5, entity.isPublic() ? 1L : 0L);
                statement.mo9385bindLong(6, entity.isDelete() ? 1L : 0L);
                statement.mo9385bindLong(7, entity.getCanRespond() ? 1L : 0L);
                statement.mo9387bindText(8, entity.getType());
                statement.mo9387bindText(9, StatusDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(10, entity.getSeen() ? 1L : 0L);
                statement.mo9385bindLong(11, entity.getClosed() ? 1L : 0L);
                statement.mo9387bindText(12, StatusDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                statement.mo9385bindLong(13, entity.getUploadState());
                statement.mo9387bindText(14, entity.getLocation());
                statement.mo9385bindLong(15, entity.getViewCount());
                statement.mo9385bindLong(16, entity.getInteractCount());
                statement.mo9385bindLong(17, entity.getShareCount());
                statement.mo9387bindText(18, entity.getId());
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20570c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(StatusDao_Impl statusDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.t6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(this.f20708c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(StatusDao_Impl statusDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.z5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20826c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(StatusDao_Impl statusDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 changeStatusState$lambda$0(String str, int i10, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteAfter$lambda$0(String str, long j10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, j10);
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
    public static final ua.k0 deleteByRepliedId$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final List getAfter$lambda$0(String str, long j10, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, j10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                int i10 = columnIndexOrThrow;
                int i11 = columnIndexOrThrow2;
                int i12 = columnIndexOrThrow3;
                int i13 = columnIndexOrThrow14;
                int i14 = columnIndexOrThrow15;
                int i15 = columnIndexOrThrow16;
                int i16 = columnIndexOrThrow4;
                int i17 = columnIndexOrThrow17;
                arrayList.add(new Status(text, text2, text3, j11, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(i13), (int) sQLiteStatementPrepare.getLong(i14), (int) sQLiteStatementPrepare.getLong(i15), (int) sQLiteStatementPrepare.getLong(i17)));
                columnIndexOrThrow3 = i12;
                columnIndexOrThrow14 = i13;
                columnIndexOrThrow16 = i15;
                columnIndexOrThrow = i10;
                columnIndexOrThrow2 = i11;
                columnIndexOrThrow17 = i17;
                columnIndexOrThrow4 = i16;
                columnIndexOrThrow15 = i14;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getIfThereAreNewUnseenStatus$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getLastStatusId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
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
    public static final List getOtherStatusList$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final List getOtherStatusListPaginated$lambda$0(String str, String str2, String str3, int i10, int i11, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            sQLiteStatementPrepare.mo9387bindText(3, str2);
            sQLiteStatementPrepare.mo9387bindText(4, str3);
            sQLiteStatementPrepare.mo9385bindLong(5, i10);
            sQLiteStatementPrepare.mo9385bindLong(6, i11);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            int i12 = columnIndexOrThrow12;
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            int i13 = columnIndexOrThrow11;
            ArrayMap<String, User> arrayMap3 = new ArrayMap<>();
            int i14 = columnIndexOrThrow10;
            ArrayMap<String, Contact> arrayMap4 = new ArrayMap<>();
            int i15 = columnIndexOrThrow9;
            ArrayMap<String, Room> arrayMap5 = new ArrayMap<>();
            int i16 = columnIndexOrThrow8;
            ArrayMap<String, Room> arrayMap6 = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                columnIndexOrThrow7 = columnIndexOrThrow7;
                columnIndexOrThrow6 = columnIndexOrThrow6;
            }
            int i17 = columnIndexOrThrow6;
            int i18 = columnIndexOrThrow7;
            sQLiteStatementPrepare.reset();
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow4);
                boolean z10 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                int i19 = i17;
                ArrayMap<String, Room> arrayMap7 = arrayMap6;
                boolean z11 = ((int) sQLiteStatementPrepare.getLong(i19)) != 0;
                int i20 = columnIndexOrThrow4;
                int i21 = i18;
                int i22 = columnIndexOrThrow5;
                boolean z12 = ((int) sQLiteStatementPrepare.getLong(i21)) != 0;
                int i23 = i16;
                String text4 = sQLiteStatementPrepare.getText(i23);
                int i24 = i15;
                int i25 = columnIndexOrThrow;
                i16 = i23;
                Content attachmentContent = statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(i24));
                int i26 = i14;
                boolean z13 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                int i27 = i13;
                boolean z14 = ((int) sQLiteStatementPrepare.getLong(i27)) != 0;
                int i28 = i12;
                List<MessageEntity> messageEntity = statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i28));
                int i29 = columnIndexOrThrow13;
                int i30 = columnIndexOrThrow14;
                int i31 = columnIndexOrThrow15;
                int i32 = columnIndexOrThrow16;
                int i33 = columnIndexOrThrow17;
                arrayList.add(new StatusWithPartnersOrRooms(new Status(text, text2, text3, j10, z10, z11, z12, text4, attachmentContent, z13, z14, messageEntity, (int) sQLiteStatementPrepare.getLong(i29), sQLiteStatementPrepare.getText(i30), (int) sQLiteStatementPrepare.getLong(i31), (int) sQLiteStatementPrepare.getLong(i32), (int) sQLiteStatementPrepare.getLong(i33)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap7.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3))));
                i12 = i28;
                columnIndexOrThrow13 = i29;
                columnIndexOrThrow14 = i30;
                columnIndexOrThrow15 = i31;
                columnIndexOrThrow = i25;
                i15 = i24;
                i14 = i26;
                columnIndexOrThrow4 = i20;
                i17 = i19;
                i13 = i27;
                arrayMap6 = arrayMap7;
                columnIndexOrThrow5 = i22;
                i18 = i21;
                columnIndexOrThrow16 = i32;
                columnIndexOrThrow17 = i33;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOtherStatusPosition$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.mo9387bindText(3, str2);
            sQLiteStatementPrepare.mo9387bindText(4, str3);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getOwnerStatusList$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final int getOwnerStatusPosition$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.mo9387bindText(3, str3);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getRoomsWithStatusUnseen$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final Status getStatusById$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        Status status;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (sQLiteStatementPrepare.step()) {
                status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            } else {
                status = null;
            }
            return status;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusWithPartnersOrRooms getStatusFullDataById$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        int i10;
        StatusWithPartnersOrRooms statusWithPartnersOrRooms;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, User> arrayMap3 = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap4 = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap5 = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap6 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow7;
                statusWithPartnersOrRooms = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                columnIndexOrThrow6 = columnIndexOrThrow6;
                columnIndexOrThrow7 = i10;
            }
            int i11 = columnIndexOrThrow6;
            sQLiteStatementPrepare.reset();
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
            if (sQLiteStatementPrepare.step()) {
                statusWithPartnersOrRooms = new StatusWithPartnersOrRooms(new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(i11)) != 0, ((int) sQLiteStatementPrepare.getLong(i10)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap6.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)));
            }
            return statusWithPartnersOrRooms;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status getUnsentStatus$lambda$0(String str, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        Status status;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (sQLiteStatementPrepare.step()) {
                status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            } else {
                status = null;
            }
            return status;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status getVideoStatusNotProcessed$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        Status status;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (sQLiteStatementPrepare.step()) {
                status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            } else {
                status = null;
            }
            return status;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWaitingForUploadStatuses$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final long insert$lambda$0(StatusDao_Impl statusDao_Impl, Status status, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        return statusDao_Impl.__insertAdapterOfStatus.insertAndReturnId(_connection, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status myLastStatus$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (!sQLiteStatementPrepare.step()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cu.todus.android.`data`.db.entity.toDus.Status'.");
            }
            Status status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            sQLiteStatementPrepare.close();
            return status;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int otherStatusCount$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 otherStatusPaging$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 otherStatusPagingInverted$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusWithPartnersOrRooms ownerLastStatus$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        int i10;
        StatusWithPartnersOrRooms statusWithPartnersOrRooms;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, User> arrayMap3 = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap4 = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap5 = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap6 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow7;
                statusWithPartnersOrRooms = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap5.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                arrayMap6.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                columnIndexOrThrow6 = columnIndexOrThrow6;
                columnIndexOrThrow7 = i10;
            }
            int i11 = columnIndexOrThrow6;
            sQLiteStatementPrepare.reset();
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            statusDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap3);
            statusDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap4);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap5);
            statusDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap6);
            if (sQLiteStatementPrepare.step()) {
                statusWithPartnersOrRooms = new StatusWithPartnersOrRooms(new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(i11)) != 0, ((int) sQLiteStatementPrepare.getLong(i10)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17)), arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2)), arrayMap6.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3)));
            }
            return statusWithPartnersOrRooms;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 ownerStatusPaging$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 prepareToRetryStatusWithError$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 prepareToSendStatusWithError$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 profileStatusPaging$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 setAsClosed$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 setAsDeleted$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 setAsSeen$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final Status statusToDownload$lambda$0(String str, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        Status status;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (sQLiteStatementPrepare.step()) {
                status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            } else {
                status = null;
            }
            return status;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status statusToUpload$lambda$0(String str, String str2, StatusDao_Impl statusDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CREATOR_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_REPLIED_ID);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createdAt");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPublic");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_IS_DELETED);
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "canRespond");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_SEEN);
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_CLOSED);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_UPLOAD_STATE);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "location");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Status.COLUMN_VIEW_COUNT);
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "interactCount");
            int columnIndexOrThrow17 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "shareCount");
            if (!sQLiteStatementPrepare.step()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cu.todus.android.`data`.db.entity.toDus.Status'.");
            }
            Status status = new Status(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow8), statusDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow9)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11)) != 0, statusDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow12)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow15), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
            sQLiteStatementPrepare.close();
            return status;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 update$lambda$0(StatusDao_Impl statusDao_Impl, Status status, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        statusDao_Impl.__updateAdapterOfStatus.handle(_connection, status);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object changeStatusState(final String str, final int i10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE status SET uploadState = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.w5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.changeStatusState$lambda$0(str2, i10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object deleteAfter(final long j10, ab.e<? super ua.k0> eVar) {
        final String str = "DELETE FROM status WHERE createdAt <= ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.deleteAfter$lambda$0(str, j10, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object deleteById(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM status WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.f6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.deleteById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object deleteByRepliedId(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM status WHERE repliedId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.t5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.deleteByRepliedId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getAfter(final long j10, ab.e<? super List<Status>> eVar) {
        final String str = "SELECT * FROM status WHERE createdAt <= ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.r6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getAfter$lambda$0(str, j10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h getIfThereAreNewUnseenStatus(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT COUNT(*) FROM status WHERE seen = 0 AND repliedId != ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.i6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StatusDao_Impl.getIfThereAreNewUnseenStatus$lambda$0(str, ownerId, (SQLiteConnection) obj));
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getLastStatusId(final String str, ab.e<? super String> eVar) {
        final String str2 = "SELECT id FROM status WHERE repliedId == ? ORDER BY seen, createdAt DESC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.l6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getLastStatusId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getOtherStatusList(final String str, ab.e<? super List<String>> eVar) {
        final String str2 = "SELECT id FROM status WHERE uploadState == 6 AND repliedId != ? ORDER BY closed DESC, createdAt ASC";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getOtherStatusList$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getOtherStatusListPaginated(final String str, final String str2, final int i10, final int i11, ab.e<? super List<StatusWithPartnersOrRooms>> eVar) {
        final String str3 = "SELECT * FROM (SELECT * FROM status WHERE id != ? AND uploadState == 6 AND repliedId != ? AND closed = 0 \nUNION ALL\nSELECT * FROM status WHERE id != ? AND uploadState == 6 AND repliedId != ? AND closed = 1) LIMIT ? OFFSET ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.p5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getOtherStatusListPaginated$lambda$0(str3, str, str2, i10, i11, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getOtherStatusPosition(final String str, final String str2, ab.e<? super Integer> eVar) {
        final String str3 = "SELECT (SELECT COUNT(*) FROM status WHERE repliedId != ?) - COUNT(*) FROM status WHERE repliedId != ? AND createdAt >= (SELECT createdAt FROM status WHERE repliedId != ? AND id = ? ORDER BY closed, createdAt DESC LIMIT 1)";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StatusDao_Impl.getOtherStatusPosition$lambda$0(str3, str, str2, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getOwnerStatusList(final String str, ab.e<? super List<String>> eVar) {
        final String str2 = "SELECT id FROM status WHERE repliedId = ? ORDER BY createdAt DESC";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.e6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getOwnerStatusList$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getOwnerStatusPosition(final String str, final String str2, ab.e<? super Integer> eVar) {
        final String str3 = "SELECT COUNT(*) FROM status WHERE repliedId == ? AND createdAt >= (SELECT createdAt FROM status WHERE repliedId == ? AND id = ? ORDER BY createdAt ASC LIMIT 1)";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StatusDao_Impl.getOwnerStatusPosition$lambda$0(str3, str, str2, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h getRoomsWithStatusUnseen(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT repliedId FROM status WHERE seen = 0 AND repliedId != ? LIMIT 50";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.h6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getRoomsWithStatusUnseen$lambda$0(str, ownerId, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getStatusById(final String str, ab.e<? super Status> eVar) {
        final String str2 = "SELECT * FROM status WHERE uploadState != 7 AND id = ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.q6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getStatusById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getStatusFullDataById(final String str, ab.e<? super StatusWithPartnersOrRooms> eVar) {
        final String str2 = "SELECT * FROM status WHERE id == ? LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getStatusFullDataById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h getUnsentStatus() {
        final String str = "SELECT * FROM status WHERE uploadState = 1 LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.u5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getUnsentStatus$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getVideoStatusNotProcessed(final String str, ab.e<? super Status> eVar) {
        final String str2 = "SELECT * FROM status WHERE uploadState = 5 AND content LIKE '%'||?||'%' AND type = 'video_type' LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.x5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getVideoStatusNotProcessed$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object getWaitingForUploadStatuses(final String str, ab.e<? super List<String>> eVar) {
        final String str2 = "SELECT id FROM status WHERE uploadState = 2 AND repliedId = ? AND type not in ('text_type')";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.r5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.getWaitingForUploadStatuses$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object insert(final Status status, ab.e<? super Long> eVar) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StatusDao_Impl.insert$lambda$0(this.f20620c, status, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object myLastStatus(final String str, ab.e<? super Status> eVar) {
        final String str2 = "SELECT * FROM status WHERE repliedId = ? ORDER BY createdAt DESC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.g6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.myLastStatus$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h otherStatusCount(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT COUNT(*) FROM status WHERE uploadState != 7 AND repliedId != ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.s6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StatusDao_Impl.otherStatusCount$lambda$0(str, ownerId, (SQLiteConnection) obj));
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public PagingSource<Integer, StatusWithPartnersOrRooms> otherStatusPaging(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09751(new RoomRawQuery("SELECT * FROM status WHERE uploadState == 6 AND repliedId != ? ORDER BY closed, createdAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.a6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.otherStatusPaging$lambda$0(ownerId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Room.TABLE_NAME, "status"});
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public PagingSource<Integer, StatusWithPartnersOrRooms> otherStatusPagingInverted(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09761(new RoomRawQuery("SELECT * FROM status WHERE uploadState == 6 AND repliedId != ? ORDER BY closed DESC, createdAt ASC", new Function1() { // from class: cu.todus.android.db.dao.toDus.o6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.otherStatusPagingInverted$lambda$0(ownerId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Room.TABLE_NAME, "status"});
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h ownerLastStatus(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT * FROM status WHERE uploadState != 7 AND repliedId = ? ORDER BY createdAt DESC LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"user", "Contact", Room.TABLE_NAME, "status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.b6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.ownerLastStatus$lambda$0(str, ownerId, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public PagingSource<Integer, StatusWithPartnersOrRooms> ownerStatusPaging(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        return new C09771(new RoomRawQuery("SELECT * FROM status WHERE repliedId = ? ORDER BY createdAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.d6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.ownerStatusPaging$lambda$0(ownerId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Room.TABLE_NAME, "status"});
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object prepareToRetryStatusWithError(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE status SET uploadState = 7 WHERE uploadState = 3 AND repliedId != ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.c6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.prepareToRetryStatusWithError$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object prepareToSendStatusWithError(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE status SET uploadState = 2 WHERE (uploadState = 3 OR uploadState = 4) AND repliedId = ? AND type not in ('text_type')";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.prepareToSendStatusWithError$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public PagingSource<Integer, StatusWithPartnersOrRooms> profileStatusPaging(final String profileUid) {
        kotlin.jvm.internal.y.i(profileUid, "profileUid");
        return new C09781(new RoomRawQuery("SELECT * FROM status WHERE uploadState == 6 AND repliedId == ? ORDER BY closed, createdAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.s5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.profileStatusPaging$lambda$0(profileUid, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Room.TABLE_NAME, "status"});
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object setAsClosed(ab.e<? super ua.k0> eVar) {
        final String str = "UPDATE status SET closed = seen WHERE closed != seen";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.l5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.setAsClosed$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object setAsDeleted(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE status SET isDelete = 1, uploadState = 1 WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.q5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.setAsDeleted$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object setAsSeen(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE status SET seen = 1 WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.u6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.setAsSeen$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h statusToDownload() {
        final String str = "SELECT * FROM status WHERE uploadState == 7 ORDER BY createdAt DESC LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.o5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.statusToDownload$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public te.h statusToUpload(final String ownerId) {
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        final String str = "SELECT * FROM status WHERE repliedId = ? AND uploadState = 1 ORDER BY createdAt DESC LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{"status"}, new Function1() { // from class: cu.todus.android.db.dao.toDus.j6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.statusToUpload$lambda$0(str, ownerId, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.StatusDao
    public Object update(final Status status, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.v6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatusDao_Impl.update$lambda$0(this.f20748c, status, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
