package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcu/todus/android/data/db/pojo/content/RefreshToDusIdContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "userId", "", User.COLUMN_TODUS_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getToDusId", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class RefreshToDusIdContent extends Content {
    public static final int $stable = 0;
    private final String toDusId;
    private final String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshToDusIdContent(String userId, String toDusId) {
        super(28);
        y.i(userId, "userId");
        y.i(toDusId, "toDusId");
        this.userId = userId;
        this.toDusId = toDusId;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public final String getUserId() {
        return this.userId;
    }
}
