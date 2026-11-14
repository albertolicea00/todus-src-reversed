package cu.todus.android.db.dao.toDus;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class c3 {
    public static /* synthetic */ Object a(ReactionDao reactionDao, long j10, String str, ab.e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteAfter");
        }
        if ((i10 & 2) != 0) {
            str = "status";
        }
        return reactionDao.deleteAfter(j10, str, eVar);
    }
}
