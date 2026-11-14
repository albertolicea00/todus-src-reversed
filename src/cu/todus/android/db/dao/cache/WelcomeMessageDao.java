package cu.todus.android.db.dao.cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import cu.todus.android.data.db.entity.cache.WelcomeMessage;
import java.util.List;
import kotlin.Metadata;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH§@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH§@¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0005H§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bH§@¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\bH§@¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/cache/WelcomeMessageDao;", "", "", "Lcu/todus/android/data/db/entity/cache/WelcomeMessage;", "objs", "Lua/k0;", "insert", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "", "lastId", "getNextByLastId", "(ILab/e;)Ljava/lang/Object;", "id", "deleteById", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "getMessagesCant", "getMaxId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface WelcomeMessageDao {
    @Query("DELETE FROM welcome_message")
    Object deleteAll(ab.e<? super k0> eVar);

    @Query("DELETE FROM welcome_message WHERE id = :id")
    Object deleteById(int i10, ab.e<? super k0> eVar);

    @Query("SELECT MAX(id) FROM welcome_message")
    Object getMaxId(ab.e<? super Integer> eVar);

    @Query("SELECT COUNT(*) FROM welcome_message")
    Object getMessagesCant(ab.e<? super Integer> eVar);

    @Query("SELECT * FROM welcome_message WHERE id > :lastId LIMIT 1")
    Object getNextByLastId(int i10, ab.e<? super WelcomeMessage> eVar);

    @Insert(onConflict = 1)
    Object insert(List<WelcomeMessage> list, ab.e<? super k0> eVar);
}
