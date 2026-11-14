package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import cu.todus.android.data.db.entity.toDus.LinkedDevice;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\f\u001a\u00020\nH§@¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/LinkedDeviceDao;", "", "Lcu/todus/android/data/db/entity/toDus/LinkedDevice;", "linkedDevice", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/LinkedDevice;Lab/e;)Ljava/lang/Object;", "", "linkedDevices", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lua/k0;", "delete", "cleanTable", "(Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "getAll", "()Landroidx/paging/PagingSource;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface LinkedDeviceDao {
    @Query("DELETE FROM 'linked_device'")
    Object cleanTable(ab.e<? super ua.k0> eVar);

    @Delete
    Object delete(LinkedDevice linkedDevice, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM 'linked_device' ORDER BY 'last_time' DESC")
    PagingSource<Integer, LinkedDevice> getAll();

    @Insert(onConflict = 1)
    Object insert(LinkedDevice linkedDevice, ab.e<? super Long> eVar);

    @Insert(onConflict = 1)
    Object insert(List<LinkedDevice> list, ab.e<? super List<Long>> eVar);
}
