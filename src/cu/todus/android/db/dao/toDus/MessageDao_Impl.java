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
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.MsgWithDate;
import cu.todus.android.data.db.pojo.info.MessagePayload;
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
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 }2\u00020\u0001:\u0001}B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00100\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ-\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\bH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ-\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001c\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001e\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001f\u0010\u001bJ\u001a\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b$\u0010#J&\u0010)\u001a\u00020(2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010'\u001a\u00020\tH\u0096@¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u00020(2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0096@¢\u0006\u0004\b+\u0010,J%\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0%0.2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u00101J#\u00103\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020/022\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0.H\u0016¢\u0006\u0004\b5\u00106J&\u00108\u001a\b\u0012\u0004\u0012\u00020\u00180%2\u0006\u0010-\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0096@¢\u0006\u0004\b8\u00109J \u0010:\u001a\u00020(2\u0006\u0010-\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0096@¢\u0006\u0004\b:\u00109J$\u0010;\u001a\b\u0012\u0004\u0012\u00020!0%2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0096@¢\u0006\u0004\b;\u0010,J\u001a\u0010<\u001a\u0004\u0018\u00010/2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b<\u0010#J\u001a\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\b>\u0010#J$\u0010@\u001a\b\u0012\u0004\u0012\u00020/0%2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0096@¢\u0006\u0004\b@\u0010,J\"\u0010D\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0096@¢\u0006\u0004\bD\u0010EJ\"\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0096@¢\u0006\u0004\bF\u0010EJ\u001a\u0010G\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\tH\u0096@¢\u0006\u0004\bG\u0010#J\u001c\u0010H\u001a\u0004\u0018\u00010\u00182\b\u0010A\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\bH\u0010#J\u001c\u0010I\u001a\u0004\u0018\u00010\u00182\b\u0010A\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0004\bI\u0010#J\u001b\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0%0.H\u0016¢\u0006\u0004\bJ\u00106J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020=0%2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\bK\u0010#J#\u0010M\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020=022\u0006\u0010L\u001a\u00020\tH\u0016¢\u0006\u0004\bM\u00104J \u0010O\u001a\u00020(2\u0006\u0010-\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH\u0096@¢\u0006\u0004\bO\u00109J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020!0%H\u0096@¢\u0006\u0004\bP\u0010QJ\u001e\u0010R\u001a\b\u0012\u0004\u0012\u00020!0%2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\bR\u0010#J&\u0010U\u001a\b\u0012\u0004\u0012\u00020T0%2\u0006\u0010-\u001a\u00020\t2\u0006\u0010S\u001a\u00020BH\u0096@¢\u0006\u0004\bU\u0010EJ\u001f\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180.2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\bV\u00101J \u0010Y\u001a\u00020\r2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tH\u0096@¢\u0006\u0004\bY\u00109J \u0010\\\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020(H\u0096@¢\u0006\u0004\b\\\u0010]J&\u0010\\\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010[\u001a\u00020(H\u0096@¢\u0006\u0004\b\\\u0010^J \u0010_\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020(H\u0096@¢\u0006\u0004\b_\u0010]J\u0010\u0010`\u001a\u00020\rH\u0096@¢\u0006\u0004\b`\u0010QJ\u0010\u0010a\u001a\u00020\rH\u0096@¢\u0006\u0004\ba\u0010QJ\u0018\u0010b\u001a\u00020\r2\u0006\u0010-\u001a\u00020\tH\u0096@¢\u0006\u0004\bb\u0010#J\u0018\u0010c\u001a\u00020\r2\u0006\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0004\bc\u0010#J\u001e\u0010c\u001a\u00020\r2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0096@¢\u0006\u0004\bc\u0010,J\u0018\u0010f\u001a\u00020\r2\u0006\u0010e\u001a\u00020\tH\u0096@¢\u0006\u0004\bf\u0010#J&\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\t2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\t0%H\u0096@¢\u0006\u0004\bf\u0010iJ \u0010k\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010j\u001a\u00020\tH\u0096@¢\u0006\u0004\bk\u00109J\u0018\u0010m\u001a\u00020\r2\u0006\u0010l\u001a\u00020\tH\u0096@¢\u0006\u0004\bm\u0010#J\u0010\u0010n\u001a\u00020\rH\u0096@¢\u0006\u0004\bn\u0010QR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010oR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00180p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00180p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010rR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00180w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00180z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006~"}, d2 = {"Lcu/todus/android/db/dao/toDus/MessageDao_Impl;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Landroidx/sqlite/SQLiteConnection;", "_connection", "Landroidx/collection/ArrayMap;", "", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "_map", "Lua/k0;", "__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment", "(Landroidx/sqlite/SQLiteConnection;Landroidx/collection/ArrayMap;)V", "Lcu/todus/android/data/db/entity/toDus/User;", "__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser", "Lcu/todus/android/data/db/entity/toDus/Contact;", "__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction", "Lcu/todus/android/data/db/entity/toDus/Room;", "__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom", "Lcu/todus/android/data/db/entity/toDus/Message;", "message", "insertOrIgnore", "(Lcu/todus/android/data/db/entity/toDus/Message;Lab/e;)Ljava/lang/Object;", "insert", "msg", DiscoverItems.Item.UPDATE_ACTION, "upsert", "uid", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "messageAndAttachmentsById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "messageById", "", "ids", "me", "", "getMessagesNotMy", "(Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getNoSent", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "roomId", "Lte/h;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "getAllByRoomFlow", "(Ljava/lang/String;)Lte/h;", "Landroidx/paging/PagingSource;", "getAllByRoom", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getUnsentMessage", "()Lte/h;", "userId", "unreadMessageByRoom", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "unreadPositionMessageByRoom", "allByIds", "messageWithUserById", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "fullMsgDataById", Service.Endpoint.LINKED_DEVICES_LIST, "getMsgsByIdIn", MarkerAction.COLUMN_ROOM, "", "actualDate", "getLastMessageOfRoom", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "getLastMessageToCheckDate", "getLastMessageOfRoomWithPayloadsIncluded", "getLastMessageOfChannel", "getFirstMessageOfChannel", "messagesToDelete", "getMessagesForNotifications", "filter", "getAllWithFilter", Room.COLUMN_LAST_MSG, "getMsgPosition", "getWaitingForUploadMessages", "(Lab/e;)Ljava/lang/Object;", "getAllByRoomForSave", "until", "Lcu/todus/android/data/db/pojo/MsgWithDate;", "getDatesAfter", "callMsgState", "oldId", "newId", "updateChannelMessageId", "id", "state", "updateStatusProgressive", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "(Ljava/util/List;ILab/e;)Ljava/lang/Object;", "forceUpdateStatus", "prepareToSendMsgsWithError", "prepareToSendMsgsWithTimeout", "cleanRoomHistory", "removeById", "uids", "pubId", "removeByPubIdInChannel", "chId", "pubIds", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "newContent", "updateContent", "ownerId", "removedSelfMsgs", "deleteBadResentMsgs", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfMessage", "Landroidx/room/EntityInsertAdapter;", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__toDusTypeConverter", "Lcu/todus/android/db/typeconverter/ToDusTypeConverter;", "__insertAdapterOfMessage_1", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfMessage", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Landroidx/room/EntityUpsertAdapter;", "__upsertAdapterOfMessage", "Landroidx/room/EntityUpsertAdapter;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageDao_Impl implements MessageDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Message> __insertAdapterOfMessage;
    private final EntityInsertAdapter<Message> __insertAdapterOfMessage_1;
    private final ToDusTypeConverter __toDusTypeConverter;
    private final EntityDeleteOrUpdateAdapter<Message> __updateAdapterOfMessage;
    private final EntityUpsertAdapter<Message> __upsertAdapterOfMessage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/db/dao/toDus/MessageDao_Impl$Companion;", "", "<init>", "()V", "", "Lsb/d;", "getRequiredConverters", "()Ljava/util/List;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.MessageDao_Impl$getAllByRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/MessageDao_Impl$getAllByRoom$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09651 extends LimitOffsetPagingSource<MessageWithPartnerWithReactions> {
        final /* synthetic */ MessageDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09651(RoomRawQuery roomRawQuery, MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = messageDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
            int i10;
            MessageDao_Impl messageDao_Impl2 = messageDao_Impl;
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                ArrayMap arrayMap3 = new ArrayMap();
                String str = "getValue(...)";
                ArrayMap arrayMap4 = new ArrayMap();
                while (true) {
                    i10 = columnIndexOrThrow9;
                    if (!sQLiteStatementPrepare.step()) {
                        break;
                    }
                    int i11 = columnIndexOrThrow8;
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    if (!arrayMap3.containsKey(text)) {
                        arrayMap3.put(text, new ArrayList());
                    }
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    if (!arrayMap4.containsKey(text2)) {
                        arrayMap4.put(text2, new ArrayList());
                    }
                    columnIndexOrThrow9 = i10;
                    columnIndexOrThrow8 = i11;
                }
                int i12 = columnIndexOrThrow8;
                sQLiteStatementPrepare.reset();
                messageDao_Impl2.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                messageDao_Impl2.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                messageDao_Impl2.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
                messageDao_Impl2.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap4);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                    ArrayMap arrayMap5 = arrayMap;
                    int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                    String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                    MessagePayload messagePayload = text7 == null ? null : messageDao_Impl2.__toDusTypeConverter.toMessagePayload(text7);
                    int i14 = i12;
                    int i15 = i10;
                    Message message = new Message(text3, text4, text5, text6, j10, i13, messagePayload, messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i14)), sQLiteStatementPrepare.isNull(i15) ? null : sQLiteStatementPrepare.getText(i15));
                    arrayMap = arrayMap5;
                    User user = (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                    Contact contact = (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                    Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                    i10 = i15;
                    String str2 = str;
                    kotlin.jvm.internal.y.h(objJ, str2);
                    List list = (List) objJ;
                    Object objJ2 = va.w0.j(arrayMap4, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                    kotlin.jvm.internal.y.h(objJ2, str2);
                    arrayList.add(new MessageWithPartnerWithReactions(message, user, contact, list, (List) objJ2));
                    str = str2;
                    i12 = i14;
                    messageDao_Impl2 = messageDao_Impl;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends MessageWithPartnerWithReactions>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final MessageDao_Impl messageDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.a3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.C09651.convertRows$lambda$0(roomRawQuery, messageDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.db.dao.toDus.MessageDao_Impl$getAllWithFilter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0094@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"cu/todus/android/db/dao/toDus/MessageDao_Impl$getAllWithFilter$1", "Landroidx/room/paging/LimitOffsetPagingSource;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "Landroidx/room/RoomRawQuery;", "limitOffsetQuery", "", "itemCount", "", "convertRows", "(Landroidx/room/RoomRawQuery;ILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class C09661 extends LimitOffsetPagingSource<MessageWithPartnerWithRoomWithReactions> {
        final /* synthetic */ MessageDao_Impl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09661(RoomRawQuery roomRawQuery, MessageDao_Impl messageDao_Impl, RoomDatabase roomDatabase, String[] strArr) {
            super(roomRawQuery, roomDatabase, strArr);
            this.this$0 = messageDao_Impl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List convertRows$lambda$0(RoomRawQuery roomRawQuery, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
            int i10;
            kotlin.jvm.internal.y.i(_connection, "_connection");
            SQLiteStatement sQLiteStatementPrepare = _connection.prepare(roomRawQuery.getSql());
            roomRawQuery.getBindingFunction().invoke(sQLiteStatementPrepare);
            try {
                int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
                int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
                int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
                int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
                int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
                int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
                int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
                int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                ArrayMap arrayMap3 = new ArrayMap();
                String str = "getValue(...)";
                ArrayMap arrayMap4 = new ArrayMap();
                int i11 = columnIndexOrThrow9;
                ArrayMap arrayMap5 = new ArrayMap();
                while (true) {
                    i10 = columnIndexOrThrow8;
                    if (!sQLiteStatementPrepare.step()) {
                        break;
                    }
                    int i12 = columnIndexOrThrow7;
                    arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                    String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    if (!arrayMap3.containsKey(text)) {
                        arrayMap3.put(text, new ArrayList());
                    }
                    arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    if (!arrayMap5.containsKey(text2)) {
                        arrayMap5.put(text2, new ArrayList());
                    }
                    columnIndexOrThrow7 = i12;
                    columnIndexOrThrow8 = i10;
                }
                int i13 = columnIndexOrThrow7;
                sQLiteStatementPrepare.reset();
                messageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
                messageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
                messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
                messageDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap4);
                messageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap5);
                ArrayList arrayList = new ArrayList();
                while (sQLiteStatementPrepare.step()) {
                    String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                    String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                    String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                    String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                    long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                    ArrayMap arrayMap6 = arrayMap5;
                    int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                    int i15 = i13;
                    String text7 = sQLiteStatementPrepare.isNull(i15) ? null : sQLiteStatementPrepare.getText(i15);
                    MessagePayload messagePayload = text7 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text7);
                    int i16 = i10;
                    i10 = i16;
                    List<MessageEntity> messageEntity = messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i16));
                    int i17 = i11;
                    Message message = new Message(text3, text4, text5, text6, j10, i14, messagePayload, messageEntity, sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17));
                    User user = (User) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                    Contact contact = (Contact) arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                    Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                    String str2 = str;
                    kotlin.jvm.internal.y.h(objJ, str2);
                    List list = (List) objJ;
                    Room room = (Room) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                    i11 = i17;
                    Object objJ2 = va.w0.j(arrayMap6, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                    kotlin.jvm.internal.y.h(objJ2, str2);
                    arrayList.add(new MessageWithPartnerWithRoomWithReactions(message, user, contact, list, room, (List) objJ2));
                    str = str2;
                    i13 = i15;
                    arrayMap5 = arrayMap6;
                }
                return arrayList;
            } finally {
                sQLiteStatementPrepare.close();
            }
        }

        @Override // androidx.room.paging.LimitOffsetPagingSource
        public Object convertRows(final RoomRawQuery roomRawQuery, int i10, ab.e<? super List<? extends MessageWithPartnerWithRoomWithReactions>> eVar) {
            RoomDatabase roomDatabase = this.this$0.__db;
            final MessageDao_Impl messageDao_Impl = this.this$0;
            return DBUtil.performSuspending(roomDatabase, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.b3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.C09661.convertRows$lambda$0(roomRawQuery, messageDao_Impl, (SQLiteConnection) obj);
                }
            }, eVar);
        }
    }

    public MessageDao_Impl(RoomDatabase __db) {
        kotlin.jvm.internal.y.i(__db, "__db");
        this.__toDusTypeConverter = new ToDusTypeConverter();
        this.__db = __db;
        this.__insertAdapterOfMessage = new EntityInsertAdapter<Message>() { // from class: cu.todus.android.db.dao.toDus.MessageDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR IGNORE INTO `messages` (`id`,`roomId`,`userSender`,`content`,`createAt`,`state`,`payload`,`messageEntities`,`publId`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Message entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getUserSender());
                statement.mo9387bindText(4, entity.getContent());
                statement.mo9385bindLong(5, entity.getCreateAt());
                statement.mo9385bindLong(6, entity.getState());
                String strFromMessagePayload = MessageDao_Impl.this.__toDusTypeConverter.fromMessagePayload(entity.getPayload());
                if (strFromMessagePayload == null) {
                    statement.mo9386bindNull(7);
                } else {
                    statement.mo9387bindText(7, strFromMessagePayload);
                }
                statement.mo9387bindText(8, MessageDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                String publId = entity.getPublId();
                if (publId == null) {
                    statement.mo9386bindNull(9);
                } else {
                    statement.mo9387bindText(9, publId);
                }
            }
        };
        this.__insertAdapterOfMessage_1 = new EntityInsertAdapter<Message>() { // from class: cu.todus.android.db.dao.toDus.MessageDao_Impl.2
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `messages` (`id`,`roomId`,`userSender`,`content`,`createAt`,`state`,`payload`,`messageEntities`,`publId`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Message entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getUserSender());
                statement.mo9387bindText(4, entity.getContent());
                statement.mo9385bindLong(5, entity.getCreateAt());
                statement.mo9385bindLong(6, entity.getState());
                String strFromMessagePayload = MessageDao_Impl.this.__toDusTypeConverter.fromMessagePayload(entity.getPayload());
                if (strFromMessagePayload == null) {
                    statement.mo9386bindNull(7);
                } else {
                    statement.mo9387bindText(7, strFromMessagePayload);
                }
                statement.mo9387bindText(8, MessageDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                String publId = entity.getPublId();
                if (publId == null) {
                    statement.mo9386bindNull(9);
                } else {
                    statement.mo9387bindText(9, publId);
                }
            }
        };
        this.__updateAdapterOfMessage = new EntityDeleteOrUpdateAdapter<Message>() { // from class: cu.todus.android.db.dao.toDus.MessageDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR REPLACE `messages` SET `id` = ?,`roomId` = ?,`userSender` = ?,`content` = ?,`createAt` = ?,`state` = ?,`payload` = ?,`messageEntities` = ?,`publId` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Message entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getUserSender());
                statement.mo9387bindText(4, entity.getContent());
                statement.mo9385bindLong(5, entity.getCreateAt());
                statement.mo9385bindLong(6, entity.getState());
                String strFromMessagePayload = MessageDao_Impl.this.__toDusTypeConverter.fromMessagePayload(entity.getPayload());
                if (strFromMessagePayload == null) {
                    statement.mo9386bindNull(7);
                } else {
                    statement.mo9387bindText(7, strFromMessagePayload);
                }
                statement.mo9387bindText(8, MessageDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                String publId = entity.getPublId();
                if (publId == null) {
                    statement.mo9386bindNull(9);
                } else {
                    statement.mo9387bindText(9, publId);
                }
                statement.mo9387bindText(10, entity.getId());
            }
        };
        this.__upsertAdapterOfMessage = new EntityUpsertAdapter<>(new EntityInsertAdapter<Message>() { // from class: cu.todus.android.db.dao.toDus.MessageDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT INTO `messages` (`id`,`roomId`,`userSender`,`content`,`createAt`,`state`,`payload`,`messageEntities`,`publId`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, Message entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getUserSender());
                statement.mo9387bindText(4, entity.getContent());
                statement.mo9385bindLong(5, entity.getCreateAt());
                statement.mo9385bindLong(6, entity.getState());
                String strFromMessagePayload = MessageDao_Impl.this.__toDusTypeConverter.fromMessagePayload(entity.getPayload());
                if (strFromMessagePayload == null) {
                    statement.mo9386bindNull(7);
                } else {
                    statement.mo9387bindText(7, strFromMessagePayload);
                }
                statement.mo9387bindText(8, MessageDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                String publId = entity.getPublId();
                if (publId == null) {
                    statement.mo9386bindNull(9);
                } else {
                    statement.mo9387bindText(9, publId);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<Message>() { // from class: cu.todus.android.db.dao.toDus.MessageDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public String createQuery() {
                return "UPDATE `messages` SET `id` = ?,`roomId` = ?,`userSender` = ?,`content` = ?,`createAt` = ?,`state` = ?,`payload` = ?,`messageEntities` = ?,`publId` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, Message entity) {
                kotlin.jvm.internal.y.i(statement, "statement");
                kotlin.jvm.internal.y.i(entity, "entity");
                statement.mo9387bindText(1, entity.getId());
                statement.mo9387bindText(2, entity.getRoomId());
                statement.mo9387bindText(3, entity.getUserSender());
                statement.mo9387bindText(4, entity.getContent());
                statement.mo9385bindLong(5, entity.getCreateAt());
                statement.mo9385bindLong(6, entity.getState());
                String strFromMessagePayload = MessageDao_Impl.this.__toDusTypeConverter.fromMessagePayload(entity.getPayload());
                if (strFromMessagePayload == null) {
                    statement.mo9386bindNull(7);
                } else {
                    statement.mo9387bindText(7, strFromMessagePayload);
                }
                statement.mo9387bindText(8, MessageDao_Impl.this.__toDusTypeConverter.fromMessageEntity(entity.getMessageEntities()));
                String publId = entity.getPublId();
                if (publId == null) {
                    statement.mo9386bindNull(9);
                } else {
                    statement.mo9387bindText(9, publId);
                }
                statement.mo9387bindText(10, entity.getId());
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.j2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(this.f20483c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact$lambda$0(MessageDao_Impl messageDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        messageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(final SQLiteConnection _connection, ArrayMap<String, List<Attachment>> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.a2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment$lambda$0(this.f20292c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment$lambda$0(MessageDao_Impl messageDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(final SQLiteConnection _connection, ArrayMap<String, List<Reaction>> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.d1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction$lambda$0(this.f20347c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction$lambda$0(MessageDao_Impl messageDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        messageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(sQLiteConnection, _tmpMap);
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
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.m2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(this.f20545c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom$lambda$0(MessageDao_Impl messageDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        messageDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(final SQLiteConnection _connection, ArrayMap<String, User> _map) {
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.g2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MessageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(this.f20414c, _connection, (ArrayMap) obj);
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
    public static final ua.k0 __fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser$lambda$0(MessageDao_Impl messageDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap _tmpMap) {
        kotlin.jvm.internal.y.i(_tmpMap, "_tmpMap");
        messageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(sQLiteConnection, _tmpMap);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allByIds$lambda$0(String str, List list, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
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
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text2, text3, text4, text5, j10, i11, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                arrayList.add(new MessageWithAttachments(message, (List) objJ));
                columnIndexOrThrow2 = columnIndexOrThrow2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message callMsgState$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            return message;
        } finally {
            sQLiteStatementPrepare.close();
        }
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
    public static final ua.k0 deleteBadResentMsgs$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 forceUpdateStatus$lambda$0(String str, int i10, String str2, SQLiteConnection _connection) {
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
    public static final MessageWithPartnerWithRoomWithReactions fullMsgDataById$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        int i10;
        MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            ArrayMap<String, Room> arrayMap4 = new ArrayMap<>();
            ArrayMap<String, List<Reaction>> arrayMap5 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow8;
                messageWithPartnerWithRoomWithReactions = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                int i11 = columnIndexOrThrow7;
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap5.containsKey(text2)) {
                    arrayMap5.put(text2, new ArrayList());
                }
                columnIndexOrThrow8 = i10;
                columnIndexOrThrow7 = i11;
            }
            int i12 = columnIndexOrThrow7;
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            messageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            messageDao_Impl.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap4);
            messageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap5);
            if (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(i12) ? null : sQLiteStatementPrepare.getText(i12);
                Message message = new Message(text3, text4, text5, text6, j10, i13, text7 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text7), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i10)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                User user = arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                List list = (List) objJ;
                Room room = arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                Object objJ2 = va.w0.j(arrayMap5, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ2, "getValue(...)");
                messageWithPartnerWithRoomWithReactions = new MessageWithPartnerWithRoomWithReactions(message, user, contact, list, room, (List) objJ2);
            }
            return messageWithPartnerWithRoomWithReactions;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getAllByRoom$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllByRoomFlow$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        int i10;
        MessageDao_Impl messageDao_Impl2 = messageDao_Impl;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            String str3 = "getValue(...)";
            ArrayMap<String, List<Reaction>> arrayMap4 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow9;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                int i11 = columnIndexOrThrow8;
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap4.containsKey(text2)) {
                    arrayMap4.put(text2, new ArrayList());
                }
                columnIndexOrThrow9 = i10;
                columnIndexOrThrow8 = i11;
            }
            int i12 = columnIndexOrThrow8;
            sQLiteStatementPrepare.reset();
            messageDao_Impl2.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            messageDao_Impl2.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            messageDao_Impl2.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            messageDao_Impl2.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                ArrayMap<String, User> arrayMap5 = arrayMap;
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                int i14 = i12;
                int i15 = columnIndexOrThrow2;
                int i16 = i10;
                Message message = new Message(text3, text4, text5, text6, j10, i13, text7 == null ? null : messageDao_Impl2.__toDusTypeConverter.toMessagePayload(text7), messageDao_Impl2.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i14)), sQLiteStatementPrepare.isNull(i16) ? null : sQLiteStatementPrepare.getText(i16));
                arrayMap = arrayMap5;
                User user = arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                String str4 = str3;
                kotlin.jvm.internal.y.h(objJ, str4);
                List list = (List) objJ;
                Object objJ2 = va.w0.j(arrayMap4, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ2, str4);
                arrayList.add(new MessageWithPartnerWithReactions(message, user, contact, list, (List) objJ2));
                str3 = str4;
                i10 = i16;
                columnIndexOrThrow2 = i15;
                messageDao_Impl2 = messageDao_Impl;
                i12 = i14;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllByRoomForSave$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text2, text3, text4, text5, j10, i10, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                arrayList.add(new MessageWithAttachments(message, (List) objJ));
                columnIndexOrThrow2 = columnIndexOrThrow2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 getAllWithFilter$lambda$0(String str, SQLiteStatement _stmt) {
        kotlin.jvm.internal.y.i(_stmt, "_stmt");
        _stmt.mo9387bindText(1, str);
        _stmt.mo9387bindText(2, str);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getDatesAfter$lambda$0(String str, String str2, long j10, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9385bindLong(2, j10);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new MsgWithDate(sQLiteStatementPrepare.getText(0), sQLiteStatementPrepare.getText(1), sQLiteStatementPrepare.getLong(2)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getFirstMessageOfChannel$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(1);
            } else {
                sQLiteStatementPrepare.mo9387bindText(1, str2);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(2);
            } else {
                sQLiteStatementPrepare.mo9387bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            sQLiteStatementPrepare.close();
            return message;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getLastMessageOfChannel$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(1);
            } else {
                sQLiteStatementPrepare.mo9387bindText(1, str2);
            }
            if (str2 == null) {
                sQLiteStatementPrepare.mo9386bindNull(2);
            } else {
                sQLiteStatementPrepare.mo9387bindText(2, str2);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            sQLiteStatementPrepare.close();
            return message;
        } catch (Throwable th2) {
            sQLiteStatementPrepare.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getLastMessageOfRoom$lambda$0(String str, String str2, long j10, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9385bindLong(2, j10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j11, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            return message;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getLastMessageOfRoomWithPayloadsIncluded$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            return message;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getLastMessageToCheckDate$lambda$0(String str, String str2, long j10, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9385bindLong(2, j10);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j11 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j11, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            return message;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getMessagesForNotifications$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        int i10;
        MessageDao_Impl messageDao_Impl2 = messageDao_Impl;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            String str3 = "getValue(...)";
            ArrayMap<String, Room> arrayMap4 = new ArrayMap<>();
            int i11 = columnIndexOrThrow9;
            ArrayMap<String, List<Reaction>> arrayMap5 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow8;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                int i12 = columnIndexOrThrow7;
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap5.containsKey(text2)) {
                    arrayMap5.put(text2, new ArrayList());
                }
                columnIndexOrThrow8 = i10;
                columnIndexOrThrow7 = i12;
            }
            int i13 = columnIndexOrThrow7;
            sQLiteStatementPrepare.reset();
            messageDao_Impl2.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            messageDao_Impl2.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            messageDao_Impl2.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            messageDao_Impl2.__fetchRelationshiproomsAscuTodusAndroidDataDbEntityToDusRoom(_connection, arrayMap4);
            messageDao_Impl2.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap5);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                ArrayMap<String, List<Reaction>> arrayMap6 = arrayMap5;
                int i14 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                int i15 = i13;
                String text7 = sQLiteStatementPrepare.isNull(i15) ? null : sQLiteStatementPrepare.getText(i15);
                MessagePayload messagePayload = text7 == null ? null : messageDao_Impl2.__toDusTypeConverter.toMessagePayload(text7);
                int i16 = i10;
                i10 = i16;
                List<MessageEntity> messageEntity = messageDao_Impl2.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i16));
                int i17 = i11;
                Message message = new Message(text3, text4, text5, text6, j10, i14, messagePayload, messageEntity, sQLiteStatementPrepare.isNull(i17) ? null : sQLiteStatementPrepare.getText(i17));
                User user = arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                String str4 = str3;
                kotlin.jvm.internal.y.h(objJ, str4);
                List list = (List) objJ;
                Room room = arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                Object objJ2 = va.w0.j(arrayMap6, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ2, str4);
                arrayList.add(new MessageWithPartnerWithRoomWithReactions(message, user, contact, list, room, (List) objJ2));
                i11 = i17;
                str3 = str4;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                i13 = i15;
                arrayMap5 = arrayMap6;
                messageDao_Impl2 = messageDao_Impl;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMessagesNotMy$lambda$0(String str, List list, int i10, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i11 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i11, (String) it.next());
                i11++;
            }
            sQLiteStatementPrepare.mo9387bindText(i10 + 1, str2);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMsgPosition$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final List getMsgsByIdIn$lambda$0(String str, List list, int i10, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        int i11;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i12 = 1;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i12, (String) it.next());
                i12++;
            }
            int i13 = i10 + 1;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i13, (String) it2.next());
                i13++;
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            String str2 = "getValue(...)";
            ArrayMap<String, List<Reaction>> arrayMap4 = new ArrayMap<>();
            while (true) {
                i11 = columnIndexOrThrow9;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                int i14 = columnIndexOrThrow8;
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap4.containsKey(text2)) {
                    arrayMap4.put(text2, new ArrayList());
                }
                columnIndexOrThrow9 = i11;
                columnIndexOrThrow8 = i14;
            }
            int i15 = columnIndexOrThrow8;
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            messageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            messageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                ArrayMap<String, User> arrayMap5 = arrayMap;
                int i16 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                MessagePayload messagePayload = text7 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text7);
                int i17 = i15;
                i15 = i17;
                List<MessageEntity> messageEntity = messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i17));
                int i18 = i11;
                Message message = new Message(text3, text4, text5, text6, j10, i16, messagePayload, messageEntity, sQLiteStatementPrepare.isNull(i18) ? null : sQLiteStatementPrepare.getText(i18));
                User user = arrayMap5.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                String str3 = str2;
                kotlin.jvm.internal.y.h(objJ, str3);
                List list2 = (List) objJ;
                Object objJ2 = va.w0.j(arrayMap4, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ2, str3);
                arrayList.add(new MessageWithPartnerWithReactions(message, user, contact, list2, (List) objJ2));
                i11 = i18;
                str2 = str3;
                columnIndexOrThrow2 = columnIndexOrThrow2;
                arrayMap = arrayMap5;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getNoSent$lambda$0(String str, List list, SQLiteConnection _connection) {
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
    public static final MessageWithAttachments getUnsentMessage$lambda$0(String str, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            MessageWithAttachments messageWithAttachments = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text2, text3, text4, text5, j10, i10, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                messageWithAttachments = new MessageWithAttachments(message, (List) objJ);
            }
            return messageWithAttachments;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWaitingForUploadMessages$lambda$0(String str, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text2, text3, text4, text5, j10, i10, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                arrayList.add(new MessageWithAttachments(message, (List) objJ));
                columnIndexOrThrow2 = columnIndexOrThrow2;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insert$lambda$0(MessageDao_Impl messageDao_Impl, Message message, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        messageDao_Impl.__insertAdapterOfMessage_1.insert(_connection, message);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 insertOrIgnore$lambda$0(MessageDao_Impl messageDao_Impl, Message message, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        messageDao_Impl.__insertAdapterOfMessage.insert(_connection, message);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageWithAttachments messageAndAttachmentsById$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            MessageWithAttachments messageWithAttachments = null;
            if (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text2, text3, text4, text5, j10, i10, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                messageWithAttachments = new MessageWithAttachments(message, (List) objJ);
            }
            return messageWithAttachments;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message messageById$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            Message message = null;
            if (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                message = new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9));
            }
            return message;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageWithPartnerWithReactions messageWithUserById$lambda$0(String str, String str2, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        int i10;
        MessageWithPartnerWithReactions messageWithPartnerWithReactions;
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayMap<String, User> arrayMap = new ArrayMap<>();
            ArrayMap<String, Contact> arrayMap2 = new ArrayMap<>();
            ArrayMap<String, List<Attachment>> arrayMap3 = new ArrayMap<>();
            ArrayMap<String, List<Reaction>> arrayMap4 = new ArrayMap<>();
            while (true) {
                i10 = columnIndexOrThrow9;
                messageWithPartnerWithReactions = null;
                if (!sQLiteStatementPrepare.step()) {
                    break;
                }
                int i11 = columnIndexOrThrow8;
                arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                arrayMap2.put(sQLiteStatementPrepare.getText(columnIndexOrThrow3), null);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap3.containsKey(text)) {
                    arrayMap3.put(text, new ArrayList());
                }
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                if (!arrayMap4.containsKey(text2)) {
                    arrayMap4.put(text2, new ArrayList());
                }
                columnIndexOrThrow9 = i10;
                columnIndexOrThrow8 = i11;
            }
            int i12 = columnIndexOrThrow8;
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipuserAscuTodusAndroidDataDbEntityToDusUser(_connection, arrayMap);
            messageDao_Impl.__fetchRelationshipContactAscuTodusAndroidDataDbEntityToDusContact(_connection, arrayMap2);
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap3);
            messageDao_Impl.__fetchRelationshipreactionAscuTodusAndroidDataDbEntityToDusReaction(_connection, arrayMap4);
            if (sQLiteStatementPrepare.step()) {
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text5 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text6 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i13 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                Message message = new Message(text3, text4, text5, text6, j10, i13, text7 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text7), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(i12)), sQLiteStatementPrepare.isNull(i10) ? null : sQLiteStatementPrepare.getText(i10));
                User user = arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Contact contact = arrayMap2.get(sQLiteStatementPrepare.getText(columnIndexOrThrow3));
                Object objJ = va.w0.j(arrayMap3, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                List list = (List) objJ;
                Object objJ2 = va.w0.j(arrayMap4, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                kotlin.jvm.internal.y.h(objJ2, "getValue(...)");
                messageWithPartnerWithReactions = new MessageWithPartnerWithReactions(message, user, contact, list, (List) objJ2);
            }
            return messageWithPartnerWithReactions;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List messagesToDelete$lambda$0(String str, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            ArrayMap<String, List<Attachment>> arrayMap = new ArrayMap<>();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(0);
                if (!arrayMap.containsKey(text)) {
                    arrayMap.put(text, new ArrayList());
                }
            }
            sQLiteStatementPrepare.reset();
            messageDao_Impl.__fetchRelationshipattachmentsAscuTodusAndroidDataDbEntityToDusAttachment(_connection, arrayMap);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text2 = sQLiteStatementPrepare.getText(0);
                String text3 = sQLiteStatementPrepare.getText(1);
                String text4 = sQLiteStatementPrepare.getText(2);
                String text5 = sQLiteStatementPrepare.getText(3);
                long j10 = sQLiteStatementPrepare.getLong(4);
                int i10 = (int) sQLiteStatementPrepare.getLong(5);
                String text6 = sQLiteStatementPrepare.isNull(6) ? null : sQLiteStatementPrepare.getText(6);
                Message message = new Message(text2, text3, text4, text5, j10, i10, text6 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text6), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(7)), sQLiteStatementPrepare.isNull(8) ? null : sQLiteStatementPrepare.getText(8));
                Object objJ = va.w0.j(arrayMap, sQLiteStatementPrepare.getText(0));
                kotlin.jvm.internal.y.h(objJ, "getValue(...)");
                arrayList.add(new MessageWithAttachments(message, (List) objJ));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 prepareToSendMsgsWithError$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 prepareToSendMsgsWithTimeout$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final ua.k0 removeById$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 removeById$lambda$1(String str, List list, SQLiteConnection _connection) {
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
    public static final ua.k0 removeByPubIdInChannel$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final ua.k0 removeByPubIdInChannel$lambda$1(String str, String str2, List list, SQLiteConnection _connection) {
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
    public static final ua.k0 removedSelfMsgs$lambda$0(String str, String str2, SQLiteConnection _connection) {
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
    public static final List unreadMessageByRoom$lambda$0(String str, String str2, String str3, MessageDao_Impl messageDao_Impl, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "roomId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_USER_SENDER);
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "content");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createAt");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "state");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_PAYLOAD);
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_ENTITIES);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Message.COLUMN_MESSAGE_PUBL_ID);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                long j10 = sQLiteStatementPrepare.getLong(columnIndexOrThrow5);
                int i10 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7);
                arrayList.add(new Message(text, text2, text3, text4, j10, i10, text5 == null ? null : messageDao_Impl.__toDusTypeConverter.toMessagePayload(text5), messageDao_Impl.__toDusTypeConverter.toMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow8)), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)));
                columnIndexOrThrow = columnIndexOrThrow;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int unreadPositionMessageByRoom$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9387bindText(1, str2);
            sQLiteStatementPrepare.mo9387bindText(2, str3);
            sQLiteStatementPrepare.mo9387bindText(3, str2);
            return sQLiteStatementPrepare.step() ? (int) sQLiteStatementPrepare.getLong(0) : 0;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 update$lambda$0(MessageDao_Impl messageDao_Impl, Message message, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        messageDao_Impl.__updateAdapterOfMessage.handle(_connection, message);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateChannelMessageId$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final ua.k0 updateContent$lambda$0(String str, String str2, String str3, SQLiteConnection _connection) {
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
    public static final ua.k0 updateStatusProgressive$lambda$0(String str, int i10, String str2, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        long j10 = i10;
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, j10);
            sQLiteStatementPrepare.mo9387bindText(2, str2);
            sQLiteStatementPrepare.mo9385bindLong(3, j10);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateStatusProgressive$lambda$1(String str, int i10, List list, int i11, SQLiteConnection _connection) {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        long j10 = i10;
        try {
            sQLiteStatementPrepare.mo9385bindLong(1, j10);
            Iterator it = list.iterator();
            int i12 = 2;
            while (it.hasNext()) {
                sQLiteStatementPrepare.mo9387bindText(i12, (String) it.next());
                i12++;
            }
            sQLiteStatementPrepare.mo9385bindLong(i11 + 2, j10);
            sQLiteStatementPrepare.step();
            return ua.k0.f43947a;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 upsert$lambda$0(MessageDao_Impl messageDao_Impl, Message message, SQLiteConnection _connection) throws Exception {
        kotlin.jvm.internal.y.i(_connection, "_connection");
        messageDao_Impl.__upsertAdapterOfMessage.upsert(_connection, message);
        return ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object allByIds(final List<String> list, ab.e<? super List<MessageWithAttachments>> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM messages WHERE id in(");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.s2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.allByIds$lambda$0(string, list, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public te.h callMsgState(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        final String str = "SELECT * FROM messages WHERE roomId = ? order by createAt desc LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{Message.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.callMsgState$lambda$0(str, uid, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object cleanRoomHistory(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM messages WHERE roomId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.cleanRoomHistory$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object deleteBadResentMsgs(ab.e<? super ua.k0> eVar) {
        final String str = "DELETE FROM messages WHERE state = -1 OR state = 4";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.deleteBadResentMsgs$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object forceUpdateStatus(final String str, final int i10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE messages SET state = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.e2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.forceUpdateStatus$lambda$0(str2, i10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object fullMsgDataById(final String str, ab.e<? super MessageWithPartnerWithRoomWithReactions> eVar) {
        final String str2 = "SELECT * FROM messages WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.fullMsgDataById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public PagingSource<Integer, MessageWithPartnerWithReactions> getAllByRoom(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return new C09651(new RoomRawQuery("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE roomId = ? order by createAt desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getAllByRoom$lambda$0(roomId, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public te.h getAllByRoomFlow(final String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        final String str = "SELECT * FROM messages INDEXED BY messages_createAt_index WHERE roomId = ? order by createAt desc";
        return FlowUtil.createFlow(this.__db, false, new String[]{"user", "Contact", Attachment.TABLE_NAME, "reaction", Message.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.c2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getAllByRoomFlow$lambda$0(str, roomId, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getAllByRoomForSave(final String str, ab.e<? super List<MessageWithAttachments>> eVar) {
        final String str2 = "SELECT * FROM messages WHERE roomId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.z1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getAllByRoomForSave$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public PagingSource<Integer, MessageWithPartnerWithRoomWithReactions> getAllWithFilter(final String filter) {
        kotlin.jvm.internal.y.i(filter, "filter");
        return new C09661(new RoomRawQuery("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE content LIKE '%'||?||'%' AND ? != '' order by createAt desc", new Function1() { // from class: cu.todus.android.db.dao.toDus.l2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getAllWithFilter$lambda$0(filter, (SQLiteStatement) obj);
            }
        }), this, this.__db, new String[]{"user", "Contact", Attachment.TABLE_NAME, Room.TABLE_NAME, "reaction", Message.TABLE_NAME});
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getDatesAfter(final String str, final long j10, ab.e<? super List<MsgWithDate>> eVar) {
        final String str2 = "SELECT id as msgId, strftime('%d', datetime(createAt/1000, 'unixepoch')) as day, createAt FROM messages WHERE roomId = ? AND createAt >= ? AND payload = '' ORDER BY createAt";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.x2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getDatesAfter$lambda$0(str2, str, j10, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getFirstMessageOfChannel(final String str, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE publId = (SELECT MIN(publId) FROM messages WHERE roomId = ?) AND roomId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getFirstMessageOfChannel$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getLastMessageOfChannel(final String str, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE publId = (SELECT MAX(publId) FROM messages WHERE roomId = ?) AND roomId = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getLastMessageOfChannel$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getLastMessageOfRoom(final String str, final long j10, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE roomId = ? AND createAt < ? AND payload = '' ORDER BY createAt DESC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getLastMessageOfRoom$lambda$0(str2, str, j10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getLastMessageOfRoomWithPayloadsIncluded(final String str, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE roomId = ? ORDER BY createAt DESC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getLastMessageOfRoomWithPayloadsIncluded$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getLastMessageToCheckDate(final String str, final long j10, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE roomId = ? AND createAt <= ? ORDER BY createAt DESC LIMIT 1";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.t2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getLastMessageToCheckDate$lambda$0(str2, str, j10, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getMessagesForNotifications(final String str, ab.e<? super List<MessageWithPartnerWithRoomWithReactions>> eVar) {
        final String str2 = "SELECT * FROM messages INDEXED BY messages_createAt_index WHERE payload = '' and roomId = ? ORDER BY createAt desc LIMIT 3";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getMessagesForNotifications$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getMessagesNotMy(final List<String> list, final String str, ab.e<? super Integer> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT COUNT (*) FROM messages WHERE id in (");
        final int size = list.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb2.append(") AND userSender != ");
        sb2.append("?");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.y2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MessageDao_Impl.getMessagesNotMy$lambda$0(string, list, size, str, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getMsgPosition(final String str, final String str2, ab.e<? super Integer> eVar) {
        final String str3 = "SELECT COUNT(*) FROM messages WHERE roomId = ? AND createAt >= (SELECT createAt FROM messages INDEXED BY messages_createAt_index WHERE roomId = ? AND id = ? ORDER BY createAt ASC LIMIT 1 )";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.o2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MessageDao_Impl.getMsgPosition$lambda$0(str3, str, str2, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getMsgsByIdIn(final List<String> list, ab.e<? super List<MessageWithPartnerWithReactions>> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT * FROM messages WHERE id in (");
        final int size = list.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb2.append(") OR publId in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(") ORDER BY createAt");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getMsgsByIdIn$lambda$0(string, list, size, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getNoSent(final List<String> list, ab.e<? super Integer> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT COUNT (*) FROM messages WHERE id in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(") AND state != 1 AND state != 2 AND state != 3");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MessageDao_Impl.getNoSent$lambda$0(string, list, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public te.h getUnsentMessage() {
        final String str = "SELECT * FROM messages WHERE state = 0 order by createAt asc LIMIT 1";
        return FlowUtil.createFlow(this.__db, false, new String[]{Attachment.TABLE_NAME, Message.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.b2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getUnsentMessage$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object getWaitingForUploadMessages(ab.e<? super List<MessageWithAttachments>> eVar) {
        final String str = "SELECT * FROM messages INDEXED BY messages_createAt_index WHERE state = -1 order by createAt asc";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.getWaitingForUploadMessages$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object insert(final Message message, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.insert$lambda$0(this.f20481c, message, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object insertOrIgnore(final Message message, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.insertOrIgnore$lambda$0(this.f20543c, message, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object messageAndAttachmentsById(final String str, ab.e<? super MessageWithAttachments> eVar) {
        final String str2 = "SELECT * FROM messages WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.messageAndAttachmentsById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object messageById(final String str, ab.e<? super Message> eVar) {
        final String str2 = "SELECT * FROM messages WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.d2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.messageById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object messageWithUserById(final String str, ab.e<? super MessageWithPartnerWithReactions> eVar) {
        final String str2 = "SELECT * FROM messages WHERE id = ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.w1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.messageWithUserById$lambda$0(str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public te.h messagesToDelete() {
        final String str = "SELECT m.id, m.roomId, m.userSender, m.content, m.createAt, m.state, m.payload, m.messageEntities, m.publId FROM messages m INNER JOIN attachments a ON m.id = a.msg WHERE ((a.type = 16) AND (m.state == 1 OR m.state == 2 OR m.state == 3)) AND (m.roomId NOT LIKE '%ch')";
        return FlowUtil.createFlow(this.__db, false, new String[]{Attachment.TABLE_NAME, Message.TABLE_NAME}, new Function1() { // from class: cu.todus.android.db.dao.toDus.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.messagesToDelete$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object prepareToSendMsgsWithError(ab.e<? super ua.k0> eVar) {
        final String str = "UPDATE messages SET state = 0 WHERE state = 4";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.prepareToSendMsgsWithError$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object prepareToSendMsgsWithTimeout(ab.e<? super ua.k0> eVar) {
        final String str = "UPDATE messages SET state = 0 WHERE  state = 7";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.prepareToSendMsgsWithTimeout$lambda$0(str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object removeById(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM messages WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.removeById$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object removeByPubIdInChannel(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM messages WHERE publId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.removeByPubIdInChannel$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object removedSelfMsgs(final String str, ab.e<? super ua.k0> eVar) {
        final String str2 = "DELETE FROM messages WHERE userSender = ? AND roomId = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.t1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.removedSelfMsgs$lambda$0(str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object unreadMessageByRoom(final String str, final String str2, ab.e<? super List<Message>> eVar) {
        final String str3 = "SELECT * FROM messages WHERE userSender != ? and state = 2 and roomId == ?";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.unreadMessageByRoom$lambda$0(str3, str2, str, this, (SQLiteConnection) obj);
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object unreadPositionMessageByRoom(final String str, final String str2, ab.e<? super Integer> eVar) {
        final String str3 = "SELECT COUNT(*) FROM messages WHERE roomId = ? AND createAt >= (SELECT createAt FROM  messages INDEXED BY messages_createAt_index WHERE payload = '' AND userSender != ? and state = 2 and roomId = ? ORDER BY createAt ASC LIMIT 1 )";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: cu.todus.android.db.dao.toDus.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MessageDao_Impl.unreadPositionMessageByRoom$lambda$0(str3, str, str2, (SQLiteConnection) obj));
            }
        }, eVar);
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object update(final Message message, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.x1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.update$lambda$0(this.f20775c, message, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object updateChannelMessageId(final String str, final String str2, ab.e<? super ua.k0> eVar) {
        final String str3 = "UPDATE messages SET publId = ?, state = 1 WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.p2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.updateChannelMessageId$lambda$0(str3, str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object updateContent(final String str, final String str2, ab.e<? super ua.k0> eVar) {
        final String str3 = "UPDATE messages SET content = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.updateContent$lambda$0(str3, str2, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object updateStatusProgressive(final String str, final int i10, ab.e<? super ua.k0> eVar) {
        final String str2 = "UPDATE messages SET state = ? WHERE id = ? and state < ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.updateStatusProgressive$lambda$0(str2, i10, str, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object upsert(final Message message, ab.e<? super ua.k0> eVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.h2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.upsert$lambda$0(this.f20439c, message, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object removeById(final List<String> list, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM messages WHERE id in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.g1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.removeById$lambda$1(string, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object removeByPubIdInChannel(final String str, final List<String> list, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM messages WHERE roomId = ");
        sb2.append("?");
        sb2.append(" AND publId in (");
        StringUtil.appendPlaceholders(sb2, list.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.z2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.removeByPubIdInChannel$lambda$1(string, str, list, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }

    @Override // cu.todus.android.db.dao.toDus.MessageDao
    public Object updateStatusProgressive(final List<String> list, final int i10, ab.e<? super ua.k0> eVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE messages SET state = ");
        sb2.append("?");
        sb2.append(" WHERE id in (");
        final int size = list.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb2.append(") and state < ");
        sb2.append("?");
        final String string = sb2.toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: cu.todus.android.db.dao.toDus.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageDao_Impl.updateStatusProgressive$lambda$1(string, i10, list, size, (SQLiteConnection) obj);
            }
        }, eVar);
        return objPerformSuspending == bb.b.g() ? objPerformSuspending : ua.k0.f43947a;
    }
}
