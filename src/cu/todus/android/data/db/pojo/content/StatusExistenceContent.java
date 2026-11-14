package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/db/pojo/content/StatusExistenceContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "statusId", "", "createAt", "", Status.COLUMN_IS_DELETED, "", "<init>", "(Ljava/lang/String;JI)V", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "getCreateAt", "()J", "setCreateAt", "(J)V", "()I", "setDelete", "(I)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StatusExistenceContent extends Content {
    public static final int $stable = 0;
    private long createAt;
    private int isDelete;
    private String statusId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusExistenceContent(String statusId, long j10, int i10) {
        super(22);
        y.i(statusId, "statusId");
        this.statusId = statusId;
        this.createAt = j10;
        this.isDelete = i10;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    /* JADX INFO: renamed from: isDelete, reason: from getter */
    public final int getIsDelete() {
        return this.isDelete;
    }

    public final void setCreateAt(long j10) {
        this.createAt = j10;
    }

    public final void setDelete(int i10) {
        this.isDelete = i10;
    }

    public final void setStatusId(String str) {
        y.i(str, "<set-?>");
        this.statusId = str;
    }
}
