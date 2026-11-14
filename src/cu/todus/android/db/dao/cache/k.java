package cu.todus.android.db.dao.cache;

import androidx.paging.PagingSource;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class k {
    public static /* synthetic */ PagingSource a(ProductDao productDao, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyProductsPagingFiltered");
        }
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return productDao.getMyProductsPagingFiltered(str, str2);
    }
}
