package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;
import androidx.room.Upsert;
import cu.todus.android.data.db.entity.toDus.Attachment;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0005\u0010\tJ\u001e\u0010\n\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\u0006J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\f\u0010\tJ \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH§@¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0018\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH§@¢\u0006\u0004\b\u001a\u0010\u0014J(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u000fH§@¢\u0006\u0004\b\u001d\u0010\u0012J \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\rH§@¢\u0006\u0004\b\u001e\u0010\u0014J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000fH§@¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H'¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\rH§@¢\u0006\u0004\b%\u0010\u0014J#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020'2\u0006\u0010&\u001a\u00020\rH'¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020'2\u0006\u0010&\u001a\u00020\rH'¢\u0006\u0004\b*\u0010)J#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020'2\u0006\u0010&\u001a\u00020\rH'¢\u0006\u0004\b+\u0010)J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rH§@¢\u0006\u0004\b,\u0010\u0014¨\u0006-À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/AttachmentDao;", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "attachment", "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/Attachment;Lab/e;)Ljava/lang/Object;", "", Attachment.TABLE_NAME, "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "insertAllIfNeeded", DiscoverItems.Item.UPDATE_ACTION, "upsert", "", "attachmentId", "", "state", "updateAttachmentState", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "getAttachmentById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lte/h;", "getAttachmentByIdFlow", "(Ljava/lang/String;)Lte/h;", "deleteAll", "uid", "removeById", "messageId", "type", "getByMessageIdAndType", "getByMessageId", "getByType", "(ILab/e;)Ljava/lang/Object;", "ids", "getAttachmentsFlow", "(Ljava/util/List;)Lte/h;", XHTMLText.Q, "fixAttachmentsBadSaved", "roomId", "Landroidx/paging/PagingSource;", "getImagesAttachmentsByRoomId", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getVideosAttachmentsByRoomId", "getLinksAttachmentsByRoomId", "deleteByMsgId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface AttachmentDao {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Delete
    Object deleteAll(List<Attachment> list, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM attachments WHERE msg = :messageId")
    Object deleteByMsgId(String str, ab.e<? super ua.k0> eVar);

    @Query("UPDATE attachments SET state = 4 WHERE state = 6 AND type = 5 AND content LIKE '%'||:q||'%'")
    Object fixAttachmentsBadSaved(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM attachments WHERE id = :attachmentId")
    Object getAttachmentById(String str, ab.e<? super Attachment> eVar);

    @Query("SELECT * FROM attachments WHERE id = :attachmentId")
    te.h getAttachmentByIdFlow(String attachmentId);

    @Query("SELECT * FROM attachments WHERE id in (:ids)")
    te.h getAttachmentsFlow(List<String> ids);

    @Query("SELECT * FROM attachments WHERE msg = :messageId")
    Object getByMessageId(String str, ab.e<? super List<Attachment>> eVar);

    @Query("SELECT * FROM attachments WHERE msg = :messageId AND type = :type ")
    Object getByMessageIdAndType(String str, int i10, ab.e<? super List<Attachment>> eVar);

    @Query("SELECT * FROM attachments WHERE type = :type")
    Object getByType(int i10, ab.e<? super List<Attachment>> eVar);

    @Query("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = :roomId AND a.type = 1 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC")
    PagingSource<Integer, Attachment> getImagesAttachmentsByRoomId(String roomId);

    @Query("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = :roomId AND a.type = 20 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC")
    PagingSource<Integer, Attachment> getLinksAttachmentsByRoomId(String roomId);

    @Query("SELECT a.* FROM messages as m, attachments as a WHERE a.msg = m.id AND m.roomId = :roomId AND a.type = 2 AND (a.state = 6 OR a.state = 2) ORDER BY m.createAt DESC")
    PagingSource<Integer, Attachment> getVideosAttachmentsByRoomId(String roomId);

    @Insert(onConflict = 5)
    Object insert(Attachment attachment, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 5)
    Object insert(List<Attachment> list, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 5)
    Object insertAllIfNeeded(List<Attachment> list, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM attachments WHERE id = :uid OR msg = :uid")
    Object removeById(String str, ab.e<? super ua.k0> eVar);

    @Update
    Object update(Attachment attachment, ab.e<? super ua.k0> eVar);

    @Query("UPDATE attachments SET state =:state WHERE id = :attachmentId")
    Object updateAttachmentState(String str, int i10, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(List<Attachment> list, ab.e<? super ua.k0> eVar);
}
