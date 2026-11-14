package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.pojo.StatusWithPartnersOrRooms;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH§@¢\u0006\u0004\b\u000e\u0010\fJ#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0016\u001a\u00020\tH'¢\u0006\u0004\b\u0017\u0010\u0014J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b\u0018\u0010\u0014J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b\u0019\u0010\fJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\tH§@¢\u0006\u0004\b \u0010\fJ\u0010\u0010!\u001a\u00020\u0007H§@¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001aH'¢\u0006\u0004\b#\u0010\u001eJ \u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0011H§@¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\tH§@¢\u0006\u0004\b(\u0010\fJ\u001a\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\tH§@¢\u0006\u0004\b)\u0010\fJ\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b*\u0010\fJ\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0004H§@¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b.\u0010\u001cJ\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001a2\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b/\u0010\u001cJ\u0018\u00100\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b0\u0010\fJ\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b2\u0010\fJ\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b3\u0010\u001cJ#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t010\u001a2\u0006\u0010\u000f\u001a\u00020\tH'¢\u0006\u0004\b4\u0010\u001cJ\u001a\u00105\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH§@¢\u0006\u0004\b5\u0010\fJ\u001a\u00106\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\tH§@¢\u0006\u0004\b6\u0010\fJ\u0018\u00107\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b7\u0010\fJ\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u0002012\u0006\u0010+\u001a\u00020\u0004H§@¢\u0006\u0004\b8\u0010-J \u00109\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH§@¢\u0006\u0004\b9\u0010:J \u0010;\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH§@¢\u0006\u0004\b;\u0010:J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b<\u0010\fJ\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020\t012\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0004\b=\u0010\fJ6\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0012012\u0006\u0010>\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0011H§@¢\u0006\u0004\bA\u0010B¨\u0006CÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/StatusDao;", "", "Lcu/todus/android/data/db/entity/toDus/Status;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/Status;Lab/e;)Ljava/lang/Object;", "Lua/k0;", DiscoverItems.Item.UPDATE_ACTION, "", "id", "deleteById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", Status.COLUMN_REPLIED_ID, "deleteByRepliedId", "ownerId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StatusWithPartnersOrRooms;", "otherStatusPaging", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "otherStatusPagingInverted", "profileUid", "profileStatusPaging", "ownerStatusPaging", "myLastStatus", "Lte/h;", "statusToUpload", "(Ljava/lang/String;)Lte/h;", "statusToDownload", "()Lte/h;", "statusId", "setAsSeen", "setAsClosed", "(Lab/e;)Ljava/lang/Object;", "getUnsentStatus", "newSate", "changeStatusState", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "getUrl", "getVideoStatusNotProcessed", "getStatusById", "prepareToSendStatusWithError", "actualTime", "deleteAfter", "(JLab/e;)Ljava/lang/Object;", "otherStatusCount", "ownerLastStatus", "prepareToRetryStatusWithError", "", "getWaitingForUploadStatuses", "getIfThereAreNewUnseenStatus", "getRoomsWithStatusUnseen", "getLastStatusId", "getStatusFullDataById", "setAsDeleted", "getAfter", "getOtherStatusPosition", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getOwnerStatusPosition", "getOtherStatusList", "getOwnerStatusList", "first", "limit", "offset", "getOtherStatusListPaginated", "(Ljava/lang/String;Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StatusDao {
    @Query("UPDATE status SET uploadState = :newSate WHERE id = :id")
    Object changeStatusState(String str, int i10, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM status WHERE createdAt <= :actualTime")
    Object deleteAfter(long j10, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM status WHERE id = :id")
    Object deleteById(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM status WHERE repliedId = :repliedId")
    Object deleteByRepliedId(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM status WHERE createdAt <= :actualTime")
    Object getAfter(long j10, ab.e<? super List<Status>> eVar);

    @Query("SELECT COUNT(*) FROM status WHERE seen = 0 AND repliedId != :ownerId")
    te.h getIfThereAreNewUnseenStatus(String ownerId);

    @Query("SELECT id FROM status WHERE repliedId == :repliedId ORDER BY seen, createdAt DESC LIMIT 1")
    Object getLastStatusId(String str, ab.e<? super String> eVar);

    @Query("SELECT id FROM status WHERE uploadState == 6 AND repliedId != :ownerId ORDER BY closed DESC, createdAt ASC")
    Object getOtherStatusList(String str, ab.e<? super List<String>> eVar);

    @Query("SELECT * FROM (SELECT * FROM status WHERE id != :first AND uploadState == 6 AND repliedId != :ownerId AND closed = 0 \nUNION ALL\nSELECT * FROM status WHERE id != :first AND uploadState == 6 AND repliedId != :ownerId AND closed = 1) LIMIT :limit OFFSET :offset")
    Object getOtherStatusListPaginated(String str, String str2, int i10, int i11, ab.e<? super List<StatusWithPartnersOrRooms>> eVar);

    @Query("SELECT (SELECT COUNT(*) FROM status WHERE repliedId != :ownerId) - COUNT(*) FROM status WHERE repliedId != :ownerId AND createdAt >= (SELECT createdAt FROM status WHERE repliedId != :ownerId AND id = :statusId ORDER BY closed, createdAt DESC LIMIT 1)")
    Object getOtherStatusPosition(String str, String str2, ab.e<? super Integer> eVar);

    @Query("SELECT id FROM status WHERE repliedId = :ownerId ORDER BY createdAt DESC")
    Object getOwnerStatusList(String str, ab.e<? super List<String>> eVar);

    @Query("SELECT COUNT(*) FROM status WHERE repliedId == :ownerId AND createdAt >= (SELECT createdAt FROM status WHERE repliedId == :ownerId AND id = :statusId ORDER BY createdAt ASC LIMIT 1)")
    Object getOwnerStatusPosition(String str, String str2, ab.e<? super Integer> eVar);

    @Query("SELECT repliedId FROM status WHERE seen = 0 AND repliedId != :ownerId LIMIT 50")
    te.h getRoomsWithStatusUnseen(String ownerId);

    @Query("SELECT * FROM status WHERE uploadState != 7 AND id = :statusId LIMIT 1")
    Object getStatusById(String str, ab.e<? super Status> eVar);

    @Query("SELECT * FROM status WHERE id == :statusId LIMIT 1")
    Object getStatusFullDataById(String str, ab.e<? super StatusWithPartnersOrRooms> eVar);

    @Query("SELECT * FROM status WHERE uploadState = 1 LIMIT 1")
    te.h getUnsentStatus();

    @Query("SELECT * FROM status WHERE uploadState = 5 AND content LIKE '%'||:getUrl||'%' AND type = 'video_type' LIMIT 1")
    Object getVideoStatusNotProcessed(String str, ab.e<? super Status> eVar);

    @Query("SELECT id FROM status WHERE uploadState = 2 AND repliedId = :ownerId AND type not in ('text_type')")
    Object getWaitingForUploadStatuses(String str, ab.e<? super List<String>> eVar);

    @Insert(onConflict = 1)
    Object insert(Status status, ab.e<? super Long> eVar);

    @Query("SELECT * FROM status WHERE repliedId = :ownerId ORDER BY createdAt DESC LIMIT 1")
    Object myLastStatus(String str, ab.e<? super Status> eVar);

    @Query("SELECT COUNT(*) FROM status WHERE uploadState != 7 AND repliedId != :ownerId")
    te.h otherStatusCount(String ownerId);

    @Query("SELECT * FROM status WHERE uploadState == 6 AND repliedId != :ownerId ORDER BY closed, createdAt DESC")
    PagingSource<Integer, StatusWithPartnersOrRooms> otherStatusPaging(String ownerId);

    @Query("SELECT * FROM status WHERE uploadState == 6 AND repliedId != :ownerId ORDER BY closed DESC, createdAt ASC")
    PagingSource<Integer, StatusWithPartnersOrRooms> otherStatusPagingInverted(String ownerId);

    @Query("SELECT * FROM status WHERE uploadState != 7 AND repliedId = :ownerId ORDER BY createdAt DESC LIMIT 1")
    te.h ownerLastStatus(String ownerId);

    @Query("SELECT * FROM status WHERE repliedId = :ownerId ORDER BY createdAt DESC")
    PagingSource<Integer, StatusWithPartnersOrRooms> ownerStatusPaging(String ownerId);

    @Query("UPDATE status SET uploadState = 7 WHERE uploadState = 3 AND repliedId != :ownerId")
    Object prepareToRetryStatusWithError(String str, ab.e<? super ua.k0> eVar);

    @Query("UPDATE status SET uploadState = 2 WHERE (uploadState = 3 OR uploadState = 4) AND repliedId = :ownerId AND type not in ('text_type')")
    Object prepareToSendStatusWithError(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM status WHERE uploadState == 6 AND repliedId == :profileUid ORDER BY closed, createdAt DESC")
    PagingSource<Integer, StatusWithPartnersOrRooms> profileStatusPaging(String profileUid);

    @Query("UPDATE status SET closed = seen WHERE closed != seen")
    Object setAsClosed(ab.e<? super ua.k0> eVar);

    @Query("UPDATE status SET isDelete = 1, uploadState = 1 WHERE id = :id")
    Object setAsDeleted(String str, ab.e<? super ua.k0> eVar);

    @Query("UPDATE status SET seen = 1 WHERE id = :statusId")
    Object setAsSeen(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM status WHERE uploadState == 7 ORDER BY createdAt DESC LIMIT 1")
    te.h statusToDownload();

    @Query("SELECT * FROM status WHERE repliedId = :ownerId AND uploadState = 1 ORDER BY createdAt DESC LIMIT 1")
    te.h statusToUpload(String ownerId);

    @Update
    Object update(Status status, ab.e<? super ua.k0> eVar);
}
