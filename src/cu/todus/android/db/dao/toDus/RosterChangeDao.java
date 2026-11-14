package cu.todus.android.db.dao.toDus;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import cu.todus.android.data.db.entity.toDus.RosterChange;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H§@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0003H§@¢\u0006\u0004\b\u000f\u0010\rJ&\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0016\u0010\u0005J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0004\b\u0017\u0010\t¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/RosterChangeDao;", "", "", "Lcu/todus/android/data/db/entity/toDus/RosterChange;", "getPendingChanges", "(Lab/e;)Ljava/lang/Object;", "", "phone", "getPendingChangeForPhone", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "change", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/RosterChange;Lab/e;)Ljava/lang/Object;", "Lua/k0;", DiscoverItems.Item.UPDATE_ACTION, "ids", "", "version", "markAsSynced", "(Ljava/util/List;ILab/e;)Ljava/lang/Object;", "clearSynced", "getPendingCount", "getPendingDeleteByPhone", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface RosterChangeDao {
    @Query("DELETE FROM roster_change WHERE synced = 1")
    Object clearSynced(ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM roster_change WHERE phone = :phone AND synced = 0 LIMIT 1")
    Object getPendingChangeForPhone(String str, ab.e<? super RosterChange> eVar);

    @Query("SELECT * FROM roster_change WHERE synced = 0 ORDER BY timestamp ASC")
    Object getPendingChanges(ab.e<? super List<RosterChange>> eVar);

    @Query("SELECT COUNT(*) FROM roster_change WHERE synced = 0")
    Object getPendingCount(ab.e<? super Integer> eVar);

    @Query("SELECT * FROM roster_change WHERE phone = :phone AND changeType = 'delete' AND synced = 0 LIMIT 1")
    Object getPendingDeleteByPhone(String str, ab.e<? super RosterChange> eVar);

    @Insert
    Object insert(RosterChange rosterChange, ab.e<? super Long> eVar);

    @Query("UPDATE roster_change SET synced = 1, targetVersion = :version WHERE id IN (:ids)")
    Object markAsSynced(List<Long> list, int i10, ab.e<? super ua.k0> eVar);

    @Update
    Object update(RosterChange rosterChange, ab.e<? super ua.k0> eVar);
}
