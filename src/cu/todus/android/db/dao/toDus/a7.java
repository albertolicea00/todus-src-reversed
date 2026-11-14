package cu.todus.android.db.dao.toDus;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class a7 {
    public static /* synthetic */ Object a(StickerDao stickerDao, String str, long j10, ab.e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStickerLastUse");
        }
        if ((i10 & 2) != 0) {
            j10 = new Date().getTime();
        }
        return stickerDao.updateStickerLastUse(str, j10, eVar);
    }
}
