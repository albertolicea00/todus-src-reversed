package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.MarkerWithPartner;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "markerAction", "Lua/k0;", "insertOrReplace", "(Lcu/todus/android/data/db/entity/toDus/MarkerAction;Lab/e;)Ljava/lang/Object;", "", "markerActions", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "delete", "Lte/h;", "getMarkerToSend", "()Lte/h;", "", Room.COLUMN_LAST_MSG, "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "getMarkerFromMsg", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "uid", "getMarker", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface MarkerActionDao {
    @Delete
    Object delete(MarkerAction markerAction, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM marker WHERE uid = :uid")
    Object getMarker(String str, ab.e<? super MarkerAction> eVar);

    @Query("SELECT * FROM marker WHERE msg = :msgId AND marker IN (4, 5) ORDER BY marker DESC, createdAt DESC")
    PagingSource<Integer, MarkerWithPartner> getMarkerFromMsg(String msgId);

    @Query("SELECT * FROM marker WHERE marker NOT IN (4, 5) LIMIT 1")
    te.h getMarkerToSend();

    @Insert(onConflict = 1)
    Object insertOrReplace(MarkerAction markerAction, ab.e<? super ua.k0> eVar);

    @Insert(onConflict = 1)
    Object insertOrReplace(List<MarkerAction> list, ab.e<? super ua.k0> eVar);
}
