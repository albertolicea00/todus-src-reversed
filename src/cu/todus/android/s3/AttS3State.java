package cu.todus.android.s3;

import androidx.compose.runtime.Immutable;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcu/todus/android/s3/AttS3State;", "", "subItemId", "", "bytesUsed", "", "bytesTotal", "<init>", "(Ljava/lang/String;JJ)V", "getSubItemId", "()Ljava/lang/String;", "getBytesUsed", "()J", "getBytesTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AttS3State {
    public static final int $stable = 0;
    private final long bytesTotal;
    private final long bytesUsed;
    private final String subItemId;

    public AttS3State(String subItemId, long j10, long j11) {
        y.i(subItemId, "subItemId");
        this.subItemId = subItemId;
        this.bytesUsed = j10;
        this.bytesTotal = j11;
    }

    public static /* synthetic */ AttS3State copy$default(AttS3State attS3State, String str, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = attS3State.subItemId;
        }
        if ((i10 & 2) != 0) {
            j10 = attS3State.bytesUsed;
        }
        if ((i10 & 4) != 0) {
            j11 = attS3State.bytesTotal;
        }
        return attS3State.copy(str, j10, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubItemId() {
        return this.subItemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBytesUsed() {
        return this.bytesUsed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getBytesTotal() {
        return this.bytesTotal;
    }

    public final AttS3State copy(String subItemId, long bytesUsed, long bytesTotal) {
        y.i(subItemId, "subItemId");
        return new AttS3State(subItemId, bytesUsed, bytesTotal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttS3State)) {
            return false;
        }
        AttS3State attS3State = (AttS3State) other;
        return y.d(this.subItemId, attS3State.subItemId) && this.bytesUsed == attS3State.bytesUsed && this.bytesTotal == attS3State.bytesTotal;
    }

    public final long getBytesTotal() {
        return this.bytesTotal;
    }

    public final long getBytesUsed() {
        return this.bytesUsed;
    }

    public final String getSubItemId() {
        return this.subItemId;
    }

    public int hashCode() {
        return (((this.subItemId.hashCode() * 31) + l.a(this.bytesUsed)) * 31) + l.a(this.bytesTotal);
    }

    public String toString() {
        return "AttS3State(subItemId=" + this.subItemId + ", bytesUsed=" + this.bytesUsed + ", bytesTotal=" + this.bytesTotal + ")";
    }
}
