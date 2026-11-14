package cu.todus.android.s3;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001d"}, d2 = {"Lcu/todus/android/s3/S3State;", "", "itemId", "", "run", "", "attList", "", "Lcu/todus/android/s3/AttS3State;", "folderPath", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getRun", "()Z", "getAttList", "()Ljava/util/List;", "getFolderPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class S3State {
    public static final int $stable = 0;
    private final List<AttS3State> attList;
    private final String folderPath;
    private final String itemId;
    private final boolean run;

    public S3State(String itemId, boolean z10, List<AttS3State> attList, String folderPath) {
        y.i(itemId, "itemId");
        y.i(attList, "attList");
        y.i(folderPath, "folderPath");
        this.itemId = itemId;
        this.run = z10;
        this.attList = attList;
        this.folderPath = folderPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ S3State copy$default(S3State s3State, String str, boolean z10, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = s3State.itemId;
        }
        if ((i10 & 2) != 0) {
            z10 = s3State.run;
        }
        if ((i10 & 4) != 0) {
            list = s3State.attList;
        }
        if ((i10 & 8) != 0) {
            str2 = s3State.folderPath;
        }
        return s3State.copy(str, z10, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRun() {
        return this.run;
    }

    public final List<AttS3State> component3() {
        return this.attList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFolderPath() {
        return this.folderPath;
    }

    public final S3State copy(String itemId, boolean run, List<AttS3State> attList, String folderPath) {
        y.i(itemId, "itemId");
        y.i(attList, "attList");
        y.i(folderPath, "folderPath");
        return new S3State(itemId, run, attList, folderPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3State)) {
            return false;
        }
        S3State s3State = (S3State) other;
        return y.d(this.itemId, s3State.itemId) && this.run == s3State.run && y.d(this.attList, s3State.attList) && y.d(this.folderPath, s3State.folderPath);
    }

    public final List<AttS3State> getAttList() {
        return this.attList;
    }

    public final String getFolderPath() {
        return this.folderPath;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final boolean getRun() {
        return this.run;
    }

    public int hashCode() {
        return (((((this.itemId.hashCode() * 31) + r.a(this.run)) * 31) + this.attList.hashCode()) * 31) + this.folderPath.hashCode();
    }

    public String toString() {
        return "S3State(itemId=" + this.itemId + ", run=" + this.run + ", attList=" + this.attList + ", folderPath=" + this.folderPath + ")";
    }

    public /* synthetic */ S3State(String str, boolean z10, List list, String str2, int i10, p pVar) {
        this(str, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? w.n() : list, (i10 & 8) != 0 ? "" : str2);
    }
}
