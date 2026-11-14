package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Upsert;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Partner;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH§@¢\u0006\u0004\b\u0007\u0010\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0015\u0010\u000eJ \u0010\u0017\u001a\u0004\u0018\u00010\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH§@¢\u0006\u0004\b\u0017\u0010\nJ\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0011H'¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u001fH'¢\u0006\u0004\b!\u0010\"J \u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH§@¢\u0006\u0004\b#\u0010$J+\u0010'\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u001f2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH'¢\u0006\u0004\b'\u0010(J+\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u001f2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH'¢\u0006\u0004\b)\u0010(¨\u0006*À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/UserDao;", "", "Lcu/todus/android/data/db/entity/toDus/User;", "user", "Lua/k0;", "insert", "(Lcu/todus/android/data/db/entity/toDus/User;Lab/e;)Ljava/lang/Object;", "upsert", "", "users", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "", "userId", "getById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", User.COLUMN_TODUS_ID, "getByToDusId", "Lte/h;", "Lcu/todus/android/data/db/pojo/Partner;", "getPartnerByIdFlow", "(Ljava/lang/String;)Lte/h;", "getPartnerById", "numbers", "getUserByPossibleNumbers", "getAllBlocked", "()Lte/h;", "", "newState", "uid", "changeBlockState", "(ZLjava/lang/String;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "getBlockedPartners", "()Landroidx/paging/PagingSource;", "updateToDusId", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "filter", "ownerId", "getOtherUsers", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "getAllPartners", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
@RewriteQueriesToDropUnusedColumns
public interface UserDao {
    @Query("UPDATE user SET blocked = :newState WHERE uid = :uid")
    Object changeBlockState(boolean z10, String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT uid FROM user WHERE blocked = 1")
    te.h getAllBlocked();

    @Query("SELECT * FROM user WHERE uid != :ownerId AND  toDusId LIKE '%'||:filter||'%'")
    PagingSource<Integer, Partner> getAllPartners(String filter, String ownerId);

    @Query("SELECT * FROM user WHERE blocked = 1")
    PagingSource<Integer, Partner> getBlockedPartners();

    @Query("SELECT * FROM user WHERE uid =:userId")
    Object getById(String str, ab.e<? super User> eVar);

    @Query("SELECT * FROM user WHERE toDusId =:toDusId")
    Object getByToDusId(String str, ab.e<? super User> eVar);

    @Query("SELECT * FROM user WHERE uid != :ownerId AND alias LIKE '%'||:filter||'%' OR toDusId LIKE '%'||:filter||'%'")
    PagingSource<Integer, Partner> getOtherUsers(String filter, String ownerId);

    @Query("SELECT * FROM user WHERE uid =:userId")
    Object getPartnerById(String str, ab.e<? super Partner> eVar);

    @Query("SELECT * FROM user WHERE uid =:userId")
    te.h getPartnerByIdFlow(String userId);

    @Query("SELECT * FROM user WHERE username in (:numbers) LIMIT 1")
    Object getUserByPossibleNumbers(List<String> list, ab.e<? super User> eVar);

    @Insert(onConflict = 5)
    Object insert(User user, ab.e<? super ua.k0> eVar);

    @Query("UPDATE user SET toDusId = :toDusId WHERE username = :userId")
    Object updateToDusId(String str, String str2, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(User user, ab.e<? super ua.k0> eVar);

    @Upsert
    Object upsert(List<User> list, ab.e<? super ua.k0> eVar);
}
