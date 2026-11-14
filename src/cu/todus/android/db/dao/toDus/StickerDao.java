package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import cu.todus.android.data.db.entity.toDus.Sticker;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH§@¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/StickerDao;", "", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/toDus/Sticker;Lab/e;)Ljava/lang/Object;", "Landroidx/paging/PagingSource;", "", "getFavoriteStickers", "()Landroidx/paging/PagingSource;", "getRecentStickers", "", "id", "", "status", "Lua/k0;", "onChangeStickerFavoriteStatus", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "date", "updateStickerLastUse", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StickerDao {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Query("SELECT * FROM sticker WHERE favorite = 1 ORDER BY lastUse")
    PagingSource<Integer, Sticker> getFavoriteStickers();

    @Query("SELECT * FROM sticker WHERE lastUse != 0 ORDER BY lastUse LIMIT 10")
    PagingSource<Integer, Sticker> getRecentStickers();

    @Insert(onConflict = 1)
    Object insert(Sticker sticker, ab.e<? super Long> eVar);

    @Query("UPDATE sticker SET favorite = :status WHERE id = :id")
    Object onChangeStickerFavoriteStatus(String str, boolean z10, ab.e<? super ua.k0> eVar);

    @Query("UPDATE sticker SET lastUse = :date WHERE id = :id")
    Object updateStickerLastUse(String str, long j10, ab.e<? super ua.k0> eVar);
}
