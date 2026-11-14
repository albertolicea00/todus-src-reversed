package cu.todus.android.db.dao.notifications;

import ab.e;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\u0006J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\u0006J\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u000e\u0010\nJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/notifications/ConfigDao;", "", "Lcu/todus/android/data/db/entity/configs/Config;", Room.CONFIG_CONFIG, "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/configs/Config;Lab/e;)Ljava/lang/Object;", "", "configs", "insertAll", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "updateAll", "delete", "deleteAll", "allNotificationRx", "(Lab/e;)Ljava/lang/Object;", "", "tag", "getConfig", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ConfigDao {
    @Query("SELECT * FROM heritage")
    Object allNotificationRx(e<? super List<Config>> eVar);

    @Delete
    Object delete(Config config, e<? super k0> eVar);

    @Delete
    Object deleteAll(List<Config> list, e<? super k0> eVar);

    @Query("SELECT * FROM heritage WHERE tag = :tag")
    Object getConfig(String str, e<? super Config> eVar);

    @Insert(onConflict = 1)
    Object insert(Config config, e<? super k0> eVar);

    @Insert(onConflict = 5)
    Object insertAll(List<Config> list, e<? super k0> eVar);

    @Update(onConflict = 1)
    Object update(Config config, e<? super k0> eVar);

    @Update(onConflict = 1)
    Object updateAll(List<Config> list, e<? super k0> eVar);
}
