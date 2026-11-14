package cu.todus.android.db.dao.toDus;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import cu.todus.android.data.db.entity.toDus.ChunkEntity;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.xmpp.extension.chunk.ExtensionChunk;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\u000e\u0010\u000b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/ChunkDao;", "", "Lcu/todus/android/data/db/entity/toDus/ChunkEntity;", ExtensionChunk.ELEMENT, "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/ChunkEntity;Lab/e;)Ljava/lang/Object;", "", Room.COLUMN_LAST_MSG, "", "countChunksForMsg", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "", "getAllChunksOrdered", "deleteChunksByMsgId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface ChunkDao {
    @Query("SELECT COUNT(*) FROM message_chunks WHERE originalMsgId = :msgId")
    Object countChunksForMsg(String str, ab.e<? super Integer> eVar);

    @Query("DELETE FROM message_chunks WHERE originalMsgId = :msgId")
    Object deleteChunksByMsgId(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT textContent FROM message_chunks WHERE originalMsgId = :msgId ORDER BY chunkIndex ASC")
    Object getAllChunksOrdered(String str, ab.e<? super List<String>> eVar);

    @Insert(onConflict = 1)
    Object insert(ChunkEntity chunkEntity, ab.e<? super ua.k0> eVar);
}
