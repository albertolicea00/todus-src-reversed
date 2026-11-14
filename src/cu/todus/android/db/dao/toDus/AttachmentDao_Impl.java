package cu.todus.android.db.dao.toDus;

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
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.db.typeconverter.ToDusTypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\t\u0010\rJ\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\rJ\u001e\u0010\u000f\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u000f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0010\u0010\nJ\u001e\u0010\u0011\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\u0011\u0010\rJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0004\b\u001e\u0010\u0015J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016¢\u0006\u0004\b\"\u0010#J#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010'J#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010'J \u0010+\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b+\u0010\u001dJ\u0018\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b-\u0010\u0015J\u0018\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b/\u0010\u0015J\u0018\u00100\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b0\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0006028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcu/todus/android/db/dao/toDus/AttachmentDao_Impl;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/Attachment;Lab/e;)Ljava/lang/Object;", "", Attachment.TABLE_NAME, "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "insertAllIfNeeded", "deleteAll", DiscoverItems.Item.UPDATE_ACTION, "upsert", "", "attachmentId", "getAttachmentById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lte/h;", "getAttachmentByIdFlow", "(Ljava/lang/String;)Lte/h;", "messageId", "", "type", "getByMessageIdAndType", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "getByMessageId", "getByType", "(ILab/e;)Ljava/lang/Object;", "ids", "getAttachmentsFlow", "(Ljava/util/List;)Lte/h;", "roomId", "Landroidx/paging/PagingSource;", "getImagesAttachmentsByRoomId", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getVideosAttachmentsByRoomId", "getLinksAttachmentsByRoomId", "state", "updateAttachmentState", "uid", "removeById", XHTMLText.Q, "fixAttachmentsBadSaved", "deleteByMsgId", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfAttachment", "Landroidx/room/EntityInsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfAttachment", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfAttachment", "Landroidx/room/EntityUpsertAdapter;", "__upsertAdapterOfAttachment", "Landroidx/room/EntityUpsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AttachmentDao_Impl implements AttachmentDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<Attachment> __deleteAdapterOfAttachment;
    private final EntityInsertAdapter<Attachment> __insertAdapterOfAttachment;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityDeleteOrUpdateAdapter<Attachment> __updateAdapterOfAttachment;
    private final EntityUpsertAdapter<Attachment> __upsertAdapterOfAttachment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/AttachmentDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.AttachmentDao_Impl$getImagesAttachmentsByRoomId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/AttachmentDao_Impl$getImagesAttachmentsByRoomId$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09591 extends LimitOffsetPagingSource<Attachment> {
        final /* synthetic */ AttachmentDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09591(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = attachmentDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Attachment>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final AttachmentDao_Impl attachmentDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AttachmentDao_Impl.C09591.convertRows$lambda$0(roomRawQuery, attachmentDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.AttachmentDao_Impl$getLinksAttachmentsByRoomId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/AttachmentDao_Impl$getLinksAttachmentsByRoomId$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09601 extends LimitOffsetPagingSource<Attachment> {
        final /* synthetic */ AttachmentDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09601(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = attachmentDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Attachment>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final AttachmentDao_Impl attachmentDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AttachmentDao_Impl.C09601.convertRows$lambda$0(roomRawQuery, attachmentDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.AttachmentDao_Impl$getVideosAttachmentsByRoomId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/AttachmentDao_Impl$getVideosAttachmentsByRoomId$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09611 extends LimitOffsetPagingSource<Attachment> {
        final /* synthetic */ AttachmentDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09611(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = attachmentDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                }
                sQLiteStatementPrepare.close();
                return arrayList;
            } catch (Throwable th2) {
                sQLiteStatementPrepare.close();
                throw th2;
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends Attachment>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final AttachmentDao_Impl attachmentDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AttachmentDao_Impl.C09611.convertRows$lambda$0(roomRawQuery, attachmentDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public AttachmentDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfAttachment = new EntityInsertAdapter<Attachment>() { // from class: cu.todus.android.db.dao.toDus.AttachmentDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `attachments` (`id`,`msg`,`content`,`state`,`type`,`persistent`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Attachment entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getMsg());
                statement.mo9387bindText(3, AttachmentDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(4, entity.getState());
                statement.mo9385bindLong(5, entity.getType());
                statement.mo9385bindLong(6, entity.getPersistent() ? 1L : 0L);
            }
        };
        this.__deleteAdapterOfAttachment = new EntityDeleteOrUpdateAdapter<Attachment>() { // from class: cu.todus.android.db.dao.toDus.AttachmentDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "DELETE FROM `attachments` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Attachment entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
            }
        };
        this.__updateAdapterOfAttachment = new EntityDeleteOrUpdateAdapter<Attachment>() { // from class: cu.todus.android.db.dao.toDus.AttachmentDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `attachments` SET `id` = ?,`msg` = ?,`content` = ?,`state` = ?,`type` = ?,`persistent` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Attachment entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getMsg());
                statement.mo9387bindText(3, AttachmentDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(4, entity.getState());
                statement.mo9385bindLong(5, entity.getType());
                statement.mo9385bindLong(6, entity.getPersistent() ? 1L : 0L);
                statement.mo9387bindText(7, entity.getId());
            }
        };
        this.__upsertAdapterOfAttachment = new EntityUpsertAdapter<>(new EntityInsertAdapter<Attachment>() { // from class: cu.todus.android.db.dao.toDus.AttachmentDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT INTO `attachments` (`id`,`msg`,`content`,`state`,`type`,`persistent`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Attachment entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getMsg());
                statement.mo9387bindText(3, AttachmentDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(4, entity.getState());
                statement.mo9385bindLong(5, entity.getType());
                statement.mo9385bindLong(6, entity.getPersistent() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<Attachment>() { // from class: cu.todus.android.db.dao.toDus.AttachmentDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE `attachments` SET `id` = ?,`msg` = ?,`content` = ?,`state` = ?,`type` = ?,`persistent` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Attachment entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getMsg());
                statement.mo9387bindText(3, AttachmentDao_Impl.this.__toDusTypeConverter.fromAttachmentContent(entity.getContent()));
                statement.mo9385bindLong(4, entity.getState());
                statement.mo9385bindLong(5, entity.getType());
                statement.mo9385bindLong(6, entity.getPersistent() ? 1L : 0L);
                statement.mo9387bindText(7, entity.getId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteAll$lambda$0(AttachmentDao_Impl attachmentDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__deleteAdapterOfAttachment.handleMultiple(_connection, list);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 deleteByMsgId$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 fixAttachmentsBadSaved$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final Attachment getAttachmentById$lambda$0(String str, String str2, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        Attachment attachment;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            if (sQLiteStatementPrepare.step()) {
                attachment = new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0);
            } else {
                attachment = null;
            }
            return attachment;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Attachment getAttachmentByIdFlow$lambda$0(String str, String str2, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        Attachment attachment;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            if (sQLiteStatementPrepare.step()) {
                attachment = new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0);
            } else {
                attachment = null;
            }
            return attachment;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAttachmentsFlow$lambda$0(String str, List list, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i10, (String) it.next());
                i10++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i11 = columnIndexOrThrow2;
                arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                columnIndexOrThrow2 = i11;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getByMessageId$lambda$0(String str, String str2, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(1);
            } else {
                sQLiteStatementPrepare.mo9387bindText(1, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i10 = columnIndexOrThrow2;
                arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                columnIndexOrThrow2 = i10;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getByMessageIdAndType$lambda$0(String str, String str2, int i10, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(1);
            } else {
                sQLiteStatementPrepare.mo9387bindText(1, str2);
            }
            sQLiteStatementPrepare.mo9385bindLong(2, i10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i11 = columnIndexOrThrow2;
                arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
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
    public static final List getByType$lambda$0(String str, int i10, AttachmentDao_Impl attachmentDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, i10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "msg");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "type");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Attachment.COLUMN_PERSISTENT);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i11 = columnIndexOrThrow;
                int i12 = columnIndexOrThrow2;
                arrayList.add(new Attachment(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), attachmentDao_Impl.__toDusTypeConverter.toAttachmentContent(sQLiteStatementPrepare.getText(columnIndexOrThrow3)), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0));
                columnIndexOrThrow = i11;
                columnIndexOrThrow2 = i12;
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getImagesAttachmentsByRoomId$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getLinksAttachmentsByRoomId$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getVideosAttachmentsByRoomId$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(AttachmentDao_Impl attachmentDao_Impl, Attachment attachment, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__insertAdapterOfAttachment.insert(_connection, attachment);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$1(AttachmentDao_Impl attachmentDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__insertAdapterOfAttachment.insert(_connection, list);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insertAllIfNeeded$lambda$0(AttachmentDao_Impl attachmentDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__insertAdapterOfAttachment.insert(_connection, list);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 removeById$lambda$0(String str, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 update$lambda$0(AttachmentDao_Impl attachmentDao_Impl, Attachment attachment, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__updateAdapterOfAttachment.handle(_connection, attachment);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateAttachmentState$lambda$0(String str, int i10, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 upsert$lambda$0(AttachmentDao_Impl attachmentDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        attachmentDao_Impl.__upsertAdapterOfAttachment.upsert(_connection, list);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object deleteAll(final List<Attachment> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.deleteAll$lambda$0(this.f20650c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object deleteByMsgId(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM attachments WHERE msg = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.deleteByMsgId$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object fixAttachmentsBadSaved(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE attachments SET state = 4 WHERE state = 6 AND type = 5 AND content LIKE '%'||?||'%'";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.fixAttachmentsBadSaved$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object getAttachmentById(final String str, ab.e<? super Attachment> eVar) {
        final String str2 = "SELECT * FROM attachments WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getAttachmentById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public te.h getAttachmentByIdFlow(final String attachmentId) {
        kotlin.jvm.internal.y.i(attachmentId, "attachmentId");
        final String str = "SELECT * FROM attachments WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{Attachment.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getAttachmentByIdFlow$lambda$0(str, attachmentId, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public te.h getAttachmentsFlow(final List<String> ids) {
        kotlin.jvm.internal.y.i(ids, "ids");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM attachments WHERE id in (");
        StringUtil.appendPlaceholders(sb2, ids.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return FlowUtil.createFlow(this.__db, false, new String[]{Attachment.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getAttachmentsFlow$lambda$0(string, ids, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object getByMessageId(final String str, ab.e<? super List<Attachment>> eVar) {
        final String str2 = "SELECT * FROM attachments WHERE msg = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getByMessageId$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object getByMessageIdAndType(final String str, final int i10, ab.e<? super List<Attachment>> eVar) {
        final String str2 = "SELECT * FROM attachments WHERE msg = ? AND type = ? ";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getByMessageIdAndType$lambda$0(str2, str, i10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object getByType(final int i10, ab.e<? super List<Attachment>> eVar) {
        final String str = "SELECT * FROM attachments WHERE type = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getByType$lambda$0(str, i10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public PagingSource<Integer, Attachment> getImagesAttachmentsByRoomId(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new C09591(new RoomRawQuery("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = ? AND a.type = 1 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getImagesAttachmentsByRoomId$lambda$0(roomId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{Message.TABLE_NAME, Attachment.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public PagingSource<Integer, Attachment> getLinksAttachmentsByRoomId(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new C09601(new RoomRawQuery("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = ? AND a.type = 20 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getLinksAttachmentsByRoomId$lambda$0(roomId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{Message.TABLE_NAME, Attachment.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public PagingSource<Integer, Attachment> getVideosAttachmentsByRoomId(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new C09611(new RoomRawQuery("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = ? AND a.type = 2 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC", new Function1() { // from class: cu.todus.android.db.dao.toDus.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.getVideosAttachmentsByRoomId$lambda$0(roomId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{Message.TABLE_NAME, Attachment.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object insert(final Attachment attachment, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.insert$lambda$0(this.f20539c, attachment, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object insertAllIfNeeded(final List<Attachment> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.insertAllIfNeeded$lambda$0(this.f20580c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object removeById(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM attachments WHERE id = ? OR msg = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.removeById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object update(final Attachment attachment, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.update$lambda$0(this.f20693c, attachment, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object updateAttachmentState(final String str, final int i10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE attachments SET state =? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.updateAttachmentState$lambda$0(str2, i10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object upsert(final List<Attachment> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.upsert$lambda$0(this.f20387c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.AttachmentDao
    public Object insert(final List<Attachment> list, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AttachmentDao_Impl.insert$lambda$1(this.f20324c, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
