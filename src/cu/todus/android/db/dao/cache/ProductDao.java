package cu.todus.android.db.dao.cache;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import cu.todus.android.data.db.entity.cache.Product;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Dao
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0005\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\u0005\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\u0006J-\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH'¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H§@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0010H§@¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\tH§@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0010H§@¢\u0006\u0004\b\u001e\u0010\u001d¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/db/dao/cache/ProductDao;", "", "Lcu/todus/android/data/db/entity/cache/Product;", "obj", "", "insert", "(Lcu/todus/android/data/db/entity/cache/Product;Lab/e;)Ljava/lang/Object;", "", "objs", "Lua/k0;", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", DiscoverItems.Item.UPDATE_ACTION, "", "tag", "filter", "Landroidx/paging/PagingSource;", "", "getMyProductsPagingFiltered", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/paging/PagingSource;", "", "visibility", "productId", "setProductVisibility", "(ZILab/e;)Ljava/lang/Object;", "id", "getProductById", "(ILab/e;)Ljava/lang/Object;", "deleteById", "deleteAll", "(Lab/e;)Ljava/lang/Object;", "getPublicCant", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ProductDao {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Query("DELETE FROM product")
    Object deleteAll(ab.e<? super k0> eVar);

    @Query("DELETE FROM product WHERE id = :id")
    Object deleteById(int i10, ab.e<? super k0> eVar);

    @Query("SELECT * FROM product WHERE (name LIKE '%'||:filter||'%' OR description LIKE '%'||:filter||'%') OR (info is not null AND info LIKE '%'||:tag||'%')")
    PagingSource<Integer, Product> getMyProductsPagingFiltered(String tag, String filter);

    @Query("SELECT * FROM product WHERE id = :id")
    Object getProductById(int i10, ab.e<? super Product> eVar);

    @Query("SELECT COUNT(*) FROM product WHERE isPublic = 1")
    Object getPublicCant(ab.e<? super Integer> eVar);

    @Insert(onConflict = 1)
    Object insert(Product product, ab.e<? super Long> eVar);

    @Insert(onConflict = 1)
    Object insert(List<Product> list, ab.e<? super k0> eVar);

    @Query("UPDATE product SET isPublic = :visibility WHERE id = :productId")
    Object setProductVisibility(boolean z10, int i10, ab.e<? super k0> eVar);

    @Update
    Object update(Product product, ab.e<? super k0> eVar);
}
