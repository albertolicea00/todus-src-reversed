package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;
import androidx.room.Upsert;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.RoomMember;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J\u001e\u0010\b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH§@¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\u0006J#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u00102\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH'¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH'¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eH§@¢\u0006\u0004\b\u001e\u0010\u001aJ\"\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eH§@¢\u0006\u0004\b\u001f\u0010\u001aJ&\u0010\"\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 H§@¢\u0006\u0004\b\"\u0010#J \u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH§@¢\u0006\u0004\b%\u0010\u001aJ&\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH§@¢\u0006\u0004\b&\u0010\u001aJ\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH§@¢\u0006\u0004\b'\u0010(¨\u0006)À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "userRoomJoin", "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "upsert", "", Service.Endpoint.LINKED_DEVICES_LIST, "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "affiliations", "insertIfNeedIgnore", "", "roomId", "Lte/h;", "groupMemberIds", "(Ljava/lang/String;)Lte/h;", "ownerId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/RoomMember;", "roomMembers", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "getAffiliationByRoom", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getAffiliationByRoomFlow", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "currentUser", "userInRoom", "userInRoomDirect", "", "usersId", "deleteNotIn", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "userId", "setAffiliationToNone", "groupMembers", "getUsersForLoad", "(Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface UserRoomJoinDao {
    @Query("DELETE FROM user_room_join WHERE roomId = :roomId and userId not in (:usersId)")
    Object deleteNotIn(String str, List<String> list, ab.e<? super ua.k0> eVar);

    @Query("SELECT affiliation FROM user_room_join WHERE roomId =:roomId AND userId = :ownerId")
    Object getAffiliationByRoom(String str, String str2, ab.e<? super String> eVar);

    @Query("SELECT affiliation FROM user_room_join WHERE roomId =:roomId AND userId = :ownerId")
    te.h getAffiliationByRoomFlow(String roomId, String ownerId);

    @Query("SELECT urj.userId FROM user_room_join AS urj LEFT JOIN user AS u ON urj.userId = u.uid WHERE u.uid IS NULL")
    Object getUsersForLoad(ab.e<? super List<String>> eVar);

    @Query("SELECT userId FROM user_room_join WHERE roomId = :roomId AND affiliation != 'none' ")
    te.h groupMemberIds(String roomId);

    @Query("SELECT * FROM user_room_join WHERE roomId =:roomId AND userId != :ownerId AND affiliation != 'none'")
    Object groupMembers(String str, String str2, ab.e<? super List<RoomMember>> eVar);

    @Insert(onConflict = 1)
    Object insert(UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 5)
    Object insertIfNeedIgnore(UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM user_room_join WHERE roomId =:roomId AND userId != :ownerId AND affiliation != 'none' ORDER BY affiliation")
    PagingSource<Integer, RoomMember> roomMembers(String roomId, String ownerId);

    @Query("UPDATE user_room_join SET affiliation = 'none' where roomId = :roomId and userId = :userId")
    Object setAffiliationToNone(String str, String str2, ab.e<? super ua.k0> eVar);

    @Update
    Object update(UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(UserRoomJoin userRoomJoin, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(List<UserRoomJoin> list, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM user_room_join WHERE roomId = :roomId AND userId = :currentUser")
    Object userInRoom(String str, String str2, ab.e<? super UserRoomJoin> eVar);

    @Query("SELECT * FROM user_room_join WHERE roomId = :roomId AND userId = :currentUser")
    Object userInRoomDirect(String str, String str2, ab.e<? super UserRoomJoin> eVar);
}
