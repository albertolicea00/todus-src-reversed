package cu.todus.android.db.dao.toDus;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import kotlin.Metadata;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0011\u001a\u00020\u000bH'¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u000bH§@¢\u0006\u0004\b\u0018\u0010\u000fJ'\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001d\u0010\u000fJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000bH§@¢\u0006\u0004\b\u001e\u0010\u000fJ\"\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u000bH§@¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\rH§@¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\b2\u0006\u0010\u0019\u001a\u00020\u000bH'¢\u0006\u0004\b%\u0010&¨\u0006'À\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/toDus/ReactionDao;", "", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "obj", "", "insertOrIgnore", "(Lcu/todus/android/data/db/entity/toDus/Reaction;Lab/e;)Ljava/lang/Object;", "insert", "Lte/h;", "getUnsentReaction", "()Lte/h;", "", "id", "Lua/k0;", "setReactionAsSent", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteById", "entityId", "Landroidx/paging/PagingSource;", "", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "getReactionsByEntityId", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "reactionId", "getReactionsById", Reaction.COLUMN_ENTITY, "ownerId", "getReactionsByEntityFlow", "(Ljava/lang/String;Ljava/lang/String;)Lte/h;", "getReactionByEntity", "deleteByEntity", "actualTime", XHTMLText.Q, "deleteAfter", "(JLjava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "getReactionsCountByEntityFlow", "(Ljava/lang/String;)Lte/h;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ReactionDao {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Query("DELETE FROM reaction WHERE createdAt <= :actualTime AND entity LIKE '%'||:q")
    Object deleteAfter(long j10, String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM reaction")
    Object deleteAll(ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM reaction WHERE entity = :entity")
    Object deleteByEntity(String str, ab.e<? super ua.k0> eVar);

    @Query("DELETE FROM reaction WHERE id = :id")
    Object deleteById(String str, ab.e<? super ua.k0> eVar);

    @Query("SELECT * FROM reaction WHERE entity = :entity")
    Object getReactionByEntity(String str, ab.e<? super Reaction> eVar);

    @Query("SELECT * FROM reaction WHERE entity = :entity AND userId = :ownerId")
    te.h getReactionsByEntityFlow(String entity, String ownerId);

    @Query("SELECT * FROM reaction WHERE entity = :entityId order by createdAt DESC")
    PagingSource<Integer, ReactionWithPartner> getReactionsByEntityId(String entityId);

    @Query("SELECT * FROM reaction WHERE id = :reactionId")
    Object getReactionsById(String str, ab.e<? super Reaction> eVar);

    @Query("SELECT COUNT(*) FROM reaction WHERE entity = :entity")
    te.h getReactionsCountByEntityFlow(String entity);

    @Query("SELECT * FROM reaction WHERE reactionState = 1 LIMIT 1")
    te.h getUnsentReaction();

    @Insert(onConflict = 1)
    Object insert(Reaction reaction, ab.e<? super Long> eVar);

    @Insert(onConflict = 5)
    Object insertOrIgnore(Reaction reaction, ab.e<? super Long> eVar);

    @Query("UPDATE reaction SET reactionState = 0 WHERE id = :id")
    Object setReactionAsSent(String str, ab.e<? super ua.k0> eVar);
}
