package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import cu.todus.android.data.db.entity.toDus.StickerPack;
import cu.todus.android.data.db.pojo.StickerGroup;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerPackDao;", "", "Lcu/todus/android/data/db/entity/toDus/StickerPack;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/StickerPack;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/StickerGroup;", "getStickerGroups", "()Landroidx/paging/PagingSource;", "Lte/h;", "", "", "getStickerIds", "()Lte/h;", "id", "Lua/k0;", "deleteById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StickerPackDao {
    @Query("DELETE FROM 'stickerPack' WHERE name = :id")
    Object deleteById(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM stickerPack ORDER by createAt DESC")
    PagingSource<Integer, StickerGroup> getStickerGroups();

    @Query("SELECT name FROM stickerPack")
    te.h getStickerIds();

    @Insert(onConflict = 1)
    Object insert(StickerPack stickerPack, ab.e<? super Long> eVar);
}
