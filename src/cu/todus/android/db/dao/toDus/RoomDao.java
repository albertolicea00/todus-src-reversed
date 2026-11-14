package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;
import androidx.room.Upsert;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.RoomItemView;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'¢\u0006\u0004\b\u0017\u0010\u0016J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b\u001a\u0010\u0019J#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b\u001b\u0010\u0019J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H§@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001e\u0010\u000eJ\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\"\u0010\u000eJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H§@¢\u0006\u0004\b#\u0010\u001dJ(\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0007H§@¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b)\u0010\u000eJ\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b*\u0010\u000eJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H§@¢\u0006\u0004\b\u0018\u0010\u001dJ#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b+\u0010\u0019J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H§@¢\u0006\u0004\b,\u0010\u001dJ#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b-\u0010\u0019J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u001fH'¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H§@¢\u0006\u0004\b0\u0010\u001d¨\u00061À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/RoomDao;", "", "Lcu/todus/android/data/db/entity/toDus/Room;", MarkerAction.COLUMN_ROOM, "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/Room;Lab/e;)Ljava/lang/Object;", "", "insertIfNeed", DiscoverItems.Item.UPDATE_ACTION, "upsert", "", "uid", "delete", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "filter", "", "", "types", "Landroidx/paging/PagingSource;", "Lcu/todus/android/data/db/pojo/RoomItemView;", "getAllRooms", "(Ljava/lang/String;Ljava/util/List;)Landroidx/paging/PagingSource;", "getAllRoomsWithRequestModeOn", "getSecretRooms", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "getMutedRooms", "getAllGroupsAndChannels", "getAllRoomList", "(Lab/e;)Ljava/lang/Object;", "getRoomById", "Lte/h;", "getRoomByIdFlow", "(Ljava/lang/String;)Lte/h;", "getRoomItemViewById", "getMyChannels", "roomId", Room.COLUMN_LAST_MSG, Room.COLUMN_LAST_UPDATE, "updateLastMessage", "(Ljava/lang/String;Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "cleanRoomHistory", "togglePin", "getOpenRooms", "getAllForSaves", "getRequestRooms", "getRequestRoomsCount", "()Lte/h;", "getAllChannels", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface RoomDao {
    @Query("UPDATE rooms SET msgId = '', unreadMessages = 0  WHERE id = :uid")
    Object cleanRoomHistory(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM rooms WHERE id = :uid")
    Object delete(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM rooms r WHERE r.type == 2")
    Object getAllChannels(ab.e<? super List<Room>> eVar);

    @Query("SELECT * FROM rooms WHERE type != 2")
    Object getAllForSaves(ab.e<? super List<RoomItemView>> eVar);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type != 0 AND r.name LIKE '%'||:filter||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getAllGroupsAndChannels(String filter);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1))) order by r.lastUpdate desc")
    Object getAllRoomList(ab.e<? super List<RoomItemView>> eVar);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type in (:types) AND (r.secret != 1 AND r.name LIKE '%'||:filter||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getAllRooms(String filter, List<Integer> types);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.type in (:types) AND ((r.type != 0 OR (r.config LIKE '%'||'unknown_ROOM'||'%' OR (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 1)) AND r.secret != 1 AND r.name LIKE '%'||:filter||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getAllRoomsWithRequestModeOn(String filter, List<Integer> types);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.isMuted == 1 AND r.name LIKE '%'||:filter||'%' order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getMutedRooms(String filter);

    @Query("SELECT * FROM rooms WHERE type = 2")
    Object getMyChannels(ab.e<? super List<Room>> eVar);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.name LIKE '%'||:filter||'%' AND :filter != '' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getOpenRooms(String filter);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE (r.type == 0 AND (r.config NOT LIKE '%'||'unknown_ROOM'||'%' AND (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 0)) AND (r.secret != 1 AND r.name LIKE '%'||:filter||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getRequestRooms(String filter);

    @Query("SELECT COUNT(r.id) FROM rooms r WHERE (r.type == 0 AND (r.config NOT LIKE '%'||'unknown_ROOM'||'%' AND (SELECT EXISTS(SELECT * FROM contact c WHERE c.uid = r.id)) = 0)) AND (r.secret != 1 AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1)))) order by r.pined desc, r.lastUpdate desc")
    te.h getRequestRoomsCount();

    @Query("SELECT * FROM rooms WHERE id = :uid")
    Object getRoomById(String str, ab.e<? super Room> eVar);

    @Query("SELECT * FROM rooms WHERE id = :uid")
    te.h getRoomByIdFlow(String uid);

    @Query("SELECT * FROM rooms WHERE id = :uid")
    Object getRoomItemViewById(String str, ab.e<? super RoomItemView> eVar);

    @Query("SELECT * FROM rooms r INDEXED BY rooms_pined_lastUpdate_index WHERE r.secret == 1 AND r.name LIKE '%'||:filter||'%' AND ((r.msgId is not null AND not r.msgId ='') or ( r.type in (1, 2, 3) AND not (r.version ='' AND r.type = 1))) order by r.pined desc, r.lastUpdate desc")
    PagingSource<Integer, RoomItemView> getSecretRooms(String filter);

    @Query("SELECT * FROM rooms WHERE secret = 1")
    Object getSecretRooms(ab.e<? super List<Room>> eVar);

    @Insert(onConflict = 1)
    Object insert(Room room, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 5)
    Object insertIfNeed(Room room, ab.e<? super Long> eVar);

    @Query("UPDATE rooms SET pined = NOT pined  WHERE id = :uid")
    Object togglePin(String str, ab.e<? super ua.k0> eVar);

    @Update
    Object update(Room room, ab.e<? super ua.k0> eVar);

    @Query("UPDATE rooms SET msgId = :msgId , lastUpdate = :lastUpdate WHERE id = :roomId")
    Object updateLastMessage(String str, String str2, long j10, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(Room room, ab.e<? super ua.k0> eVar);
}
