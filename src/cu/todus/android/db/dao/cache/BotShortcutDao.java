package cu.todus.android.db.dao.cache;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0005\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0005\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\u0006J\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tH§@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0019\u0010\u0018J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0010H§@¢\u0006\u0004\b\u001b\u0010\u0018¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/cache/BotShortcutDao;", "", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/cache/BotShortcut;Lab/e;)Ljava/lang/Object;", "", "objs", "Lua/k0;", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "Landroidx/paging/PagingSource;", "", "getBotShortcutsPaging", "()Landroidx/paging/PagingSource;", "", "roomId", "getBotShortcutsByRoomIdPaging", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "id", "deleteById", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteByRoomId", "location", "getShortcutsByLocation", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BotShortcutDao {
    @Query("DELETE FROM bot_shortcut")
    Object deleteAll(ab.e<? super k0> eVar);

    @Query("DELETE FROM bot_shortcut WHERE id = :id")
    Object deleteById(String str, ab.e<? super k0> eVar);

    @Query("DELETE FROM bot_shortcut WHERE roomId = :roomId")
    Object deleteByRoomId(String str, ab.e<? super k0> eVar);

    @Query("SELECT * FROM bot_shortcut WHERE roomId = :roomId")
    PagingSource<Integer, BotShortcut> getBotShortcutsByRoomIdPaging(String roomId);

    @Query("SELECT * FROM bot_shortcut")
    PagingSource<Integer, BotShortcut> getBotShortcutsPaging();

    @Query("SELECT * FROM bot_shortcut WHERE location = :location")
    Object getShortcutsByLocation(String str, ab.e<? super List<BotShortcut>> eVar);

    @Insert(onConflict = 1)
    Object insert(BotShortcut botShortcut, ab.e<? super Long> eVar);

    @Insert(onConflict = 1)
    Object insert(List<BotShortcut> list, ab.e<? super k0> eVar);

    @Update
    Object update(BotShortcut botShortcut, ab.e<? super k0> eVar);
}
