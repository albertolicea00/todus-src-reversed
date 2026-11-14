package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Upsert;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.MsgWithDate;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u0006J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u0018\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0017\u001a\u00020\u0016H§@¢\u0006\u0004\b\u0018\u0010\u001cJ \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H§@¢\u0006\u0004\b\u001d\u0010\u0019J&\u0010\u001f\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u001e\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH§@¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u001a0$2\u0006\u0010#\u001a\u00020\u000bH'¢\u0006\u0004\b&\u0010'J#\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020%0(2\u0006\u0010#\u001a\u00020\u000bH'¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110$H'¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004H§@¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0004H§@¢\u0006\u0004\b/\u0010.J&\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010#\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH§@¢\u0006\u0004\b1\u0010\u000fJ \u00102\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH§@¢\u0006\u0004\b2\u0010\u000fJ\u0018\u00103\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000bH§@¢\u0006\u0004\b3\u0010\u0013J\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0004\b4\u0010\u0013J\u001e\u00104\u001a\u00020\u00042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH§@¢\u0006\u0004\b4\u0010\"J\u0018\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u000bH§@¢\u0006\u0004\b7\u0010\u0013J&\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u000b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH§@¢\u0006\u0004\b7\u0010:J$\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH§@¢\u0006\u0004\b;\u0010\"J\u001a\u0010<\u001a\u0004\u0018\u00010%2\u0006\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0004\b<\u0010\u0013J\u001a\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010\u0010\u001a\u00020\u000bH§@¢\u0006\u0004\b>\u0010\u0013J$\u0010@\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH§@¢\u0006\u0004\b@\u0010\"J\"\u0010D\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020BH§@¢\u0006\u0004\bD\u0010EJ\"\u0010F\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020BH§@¢\u0006\u0004\bF\u0010EJ\u001a\u0010G\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u000bH§@¢\u0006\u0004\bG\u0010\u0013J\u001c\u0010H\u001a\u0004\u0018\u00010\u00022\b\u0010A\u001a\u0004\u0018\u00010\u000bH§@¢\u0006\u0004\bH\u0010\u0013J\u001c\u0010I\u001a\u0004\u0018\u00010\u00022\b\u0010A\u001a\u0004\u0018\u00010\u000bH§@¢\u0006\u0004\bI\u0010\u0013J\u001b\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0$H'¢\u0006\u0004\bJ\u0010,J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020=0\u001a2\u0006\u0010#\u001a\u00020\u000bH§@¢\u0006\u0004\bK\u0010\u0013J#\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020=0(2\u0006\u0010L\u001a\u00020\u000bH'¢\u0006\u0004\bM\u0010*J \u0010O\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH§@¢\u0006\u0004\bO\u0010\u000fJ \u0010Q\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000bH§@¢\u0006\u0004\bQ\u0010\u000fJ\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aH§@¢\u0006\u0004\bR\u0010.J\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\u0006\u0010#\u001a\u00020\u000bH§@¢\u0006\u0004\bS\u0010\u0013J&\u0010V\u001a\b\u0012\u0004\u0012\u00020U0\u001a2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020BH§@¢\u0006\u0004\bV\u0010EJ\u0018\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u000bH§@¢\u0006\u0004\bX\u0010\u0013J\u0010\u0010Y\u001a\u00020\u0004H§@¢\u0006\u0004\bY\u0010.J\u001f\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020$2\u0006\u0010\u0010\u001a\u00020\u000bH'¢\u0006\u0004\bZ\u0010'¨\u0006[À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/MessageDao;", "", "Lcu/todus/android/data/db/entity/toDus/Message;", "message", "Lua/k0;", "insertOrIgnore", "(Lcu/todus/android/data/db/entity/toDus/Message;Lab/e;)Ljava/lang/Object;", "insert", "upsert", "msg", DiscoverItems.Item.UPDATE_ACTION, "", "oldId", "newId", "updateChannelMessageId", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "uid", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "messageAndAttachmentsById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "messageById", "id", "", "state", "updateStatusProgressive", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "", "ids", "(Ljava/util/List;ILab/e;)Ljava/lang/Object;", "forceUpdateStatus", "me", "getMessagesNotMy", "(Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getNoSent", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "roomId", "Lte/h;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "getAllByRoomFlow", "(Ljava/lang/String;)Lte/h;", "Landroidx/paging/PagingSource;", "getAllByRoom", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getUnsentMessage", "()Lte/h;", "prepareToSendMsgsWithError", "(Lab/e;)Ljava/lang/Object;", "prepareToSendMsgsWithTimeout", "userId", "unreadMessageByRoom", "unreadPositionMessageByRoom", "cleanRoomHistory", "removeById", "uids", "pubId", "removeByPubIdInChannel", "chId", "pubIds", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "allByIds", "messageWithUserById", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "fullMsgDataById", Service.Endpoint.LINKED_DEVICES_LIST, "getMsgsByIdIn", MarkerAction.COLUMN_ROOM, "", "actualDate", "getLastMessageOfRoom", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "getLastMessageToCheckDate", "getLastMessageOfRoomWithPayloadsIncluded", "getLastMessageOfChannel", "getFirstMessageOfChannel", "messagesToDelete", "getMessagesForNotifications", "filter", "getAllWithFilter", Room.COLUMN_LAST_MSG, "getMsgPosition", "newContent", "updateContent", "getWaitingForUploadMessages", "getAllByRoomForSave", "until", "Lcu/todus/android/data/db/pojo/MsgWithDate;", "getDatesAfter", "ownerId", "removedSelfMsgs", "deleteBadResentMsgs", "callMsgState", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface MessageDao {
    @Query("SELECT * FROM messages WHERE id in(:message)")
    Object allByIds(List<String> list, ab.e<? super List<MessageWithAttachments>> eVar);

    @Query("SELECT * FROM messages WHERE roomId = :uid order by createAt desc LIMIT 1")
    te.h callMsgState(String uid);

    @Query("DELETE FROM messages WHERE roomId = :roomId")
    Object cleanRoomHistory(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE state = -1 OR state = 4")
    Object deleteBadResentMsgs(ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET state = :state WHERE id = :id")
    Object forceUpdateStatus(String str, int i10, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM messages WHERE id = :uid")
    Object fullMsgDataById(String str, ab.e<? super MessageWithPartnerWithRoomWithReactions> eVar);

    @Query("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE roomId = :roomId order by createAt desc")
    PagingSource<Integer, MessageWithPartnerWithReactions> getAllByRoom(String roomId);

    @Query("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE roomId = :roomId order by createAt desc")
    te.h getAllByRoomFlow(String roomId);

    @Query("SELECT * FROM messages WHERE roomId = :roomId")
    Object getAllByRoomForSave(String str, ab.e<? super List<MessageWithAttachments>> eVar);

    @Query("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE content LIKE '%'||:filter||'%' AND :filter != '' order by createAt desc")
    PagingSource<Integer, MessageWithPartnerWithRoomWithReactions> getAllWithFilter(String filter);

    @Query("SELECT id as msgId, strftime('%d', datetime(createAt/1000, 'unixepoch')) as day, createAt FROM messages WHERE roomId = :roomId AND createAt >= :until AND payload = '' ORDER BY createAt")
    Object getDatesAfter(String str, long j10, ab.e<? super List<MsgWithDate>> eVar);

    @Query("SELECT * FROM messages WHERE publId = (SELECT MIN(publId) FROM messages WHERE roomId = :room) AND roomId = :room")
    Object getFirstMessageOfChannel(String str, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages WHERE publId = (SELECT MAX(publId) FROM messages WHERE roomId = :room) AND roomId = :room")
    Object getLastMessageOfChannel(String str, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages WHERE roomId = :room AND createAt < :actualDate AND payload = '' ORDER BY createAt DESC LIMIT 1")
    Object getLastMessageOfRoom(String str, long j10, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages WHERE roomId = :room ORDER BY createAt DESC LIMIT 1")
    Object getLastMessageOfRoomWithPayloadsIncluded(String str, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages WHERE roomId = :room AND createAt <= :actualDate ORDER BY createAt DESC LIMIT 1")
    Object getLastMessageToCheckDate(String str, long j10, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE payload = '' and roomId = :roomId ORDER BY createAt desc LIMIT 3")
    Object getMessagesForNotifications(String str, ab.e<? super List<MessageWithPartnerWithRoomWithReactions>> eVar);

    @Query("SELECT COUNT (*) FROM messages WHERE id in (:ids) AND userSender != :me")
    Object getMessagesNotMy(List<String> list, String str, ab.e<? super Integer> eVar);

    @Query("SELECT COUNT(*) FROM messages WHERE roomId = :roomId AND createAt >= (SELECT createAt FROM messages INDEXED BY messages_createAt_index WHERE roomId = :roomId AND id = :msgId ORDER BY createAt ASC LIMIT 1 )")
    Object getMsgPosition(String str, String str2, ab.e<? super Integer> eVar);

    @Query("SELECT * FROM messages WHERE id in (:list) OR publId in (:list) ORDER BY createAt")
    Object getMsgsByIdIn(List<String> list, ab.e<? super List<MessageWithPartnerWithReactions>> eVar);

    @Query("SELECT COUNT (*) FROM messages WHERE id in (:ids) AND state != 1 AND state != 2 AND state != 3")
    Object getNoSent(List<String> list, ab.e<? super Integer> eVar);

    @Query("SELECT * FROM messages WHERE state = 0 order by createAt asc LIMIT 1")
    te.h getUnsentMessage();

    @Query("SELECT * FROM messages INDEXED BY messages_createAt_index WHERE state = -1 order by createAt asc")
    Object getWaitingForUploadMessages(ab.e<? super List<MessageWithAttachments>> eVar);

    @Insert(onConflict = 1)
    Object insert(Message message, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 5)
    Object insertOrIgnore(Message message, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM messages WHERE id = :uid")
    Object messageAndAttachmentsById(String str, ab.e<? super MessageWithAttachments> eVar);

    @Query("SELECT * FROM messages WHERE id = :uid")
    Object messageById(String str, ab.e<? super Message> eVar);

    @Query("SELECT * FROM messages WHERE id = :uid")
    Object messageWithUserById(String str, ab.e<? super MessageWithPartnerWithReactions> eVar);

    @Query("SELECT m.id, m.roomId, m.userSender, m.content, m.createAt, m.state, m.payload, m.messageEntities, m.publId FROM messages m INNER JOIN attachments a ON m.id = a.msg WHERE ((a.type = 16) AND (m.state == 1 OR m.state == 2 OR m.state == 3)) AND (m.roomId NOT LIKE '%ch')")
    te.h messagesToDelete();

    @Query("UPDATE messages SET state = 0 WHERE state = 4")
    Object prepareToSendMsgsWithError(ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET state = 0 WHERE  state = 7")
    Object prepareToSendMsgsWithTimeout(ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE id = :uid")
    Object removeById(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE id in (:uids)")
    Object removeById(List<String> list, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE publId = :pubId")
    Object removeByPubIdInChannel(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE roomId = :chId AND publId in (:pubIds)")
    Object removeByPubIdInChannel(String str, List<String> list, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM messages WHERE userSender = :ownerId AND roomId = :ownerId")
    Object removedSelfMsgs(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM messages WHERE userSender != :userId and state = 2 and roomId == :roomId")
    Object unreadMessageByRoom(String str, String str2, ab.e<? super List<Message>> eVar);

    @Query("SELECT COUNT(*) FROM messages WHERE roomId = :roomId AND createAt >= (SELECT createAt FROM  messages INDEXED BY messages_createAt_index WHERE payload = '' AND userSender != :userId and state = 2 and roomId = :roomId ORDER BY createAt ASC LIMIT 1 )")
    Object unreadPositionMessageByRoom(String str, String str2, ab.e<? super Integer> eVar);

    @Update(onConflict = 1)
    Object update(Message message, ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET publId = :newId, state = 1 WHERE id = :oldId")
    Object updateChannelMessageId(String str, String str2, ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET content = :newContent WHERE id = :id")
    Object updateContent(String str, String str2, ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET state = :state WHERE id = :id and state < :state")
    Object updateStatusProgressive(String str, int i10, ab.e<? super ua.k0> eVar);

    @Query("UPDATE messages SET state = :state WHERE id in (:ids) and state < :state")
    Object updateStatusProgressive(List<String> list, int i10, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(Message message, ab.e<? super ua.k0> eVar);
}
