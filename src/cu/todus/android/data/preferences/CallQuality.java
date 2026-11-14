package cu.todus.android.data.preferences;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/preferences/CallQuality;", "", "sendQuality", "", "receivingQuality", "<init>", "(II)V", "getSendQuality", "()I", "getReceivingQuality", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CallQuality {
    public static final int $stable = 0;
    private final int receivingQuality;
    private final int sendQuality;

    /* JADX WARN: Illegal instructions before constructor call */
    public CallQuality() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public static /* synthetic */ CallQuality copy$default(CallQuality callQuality, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = callQuality.sendQuality;
        }
        if ((i12 & 2) != 0) {
            i11 = callQuality.receivingQuality;
        }
        return callQuality.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSendQuality() {
        return this.sendQuality;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getReceivingQuality() {
        return this.receivingQuality;
    }

    public final CallQuality copy(int sendQuality, int receivingQuality) {
        return new CallQuality(sendQuality, receivingQuality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallQuality)) {
            return false;
        }
        CallQuality callQuality = (CallQuality) other;
        return this.sendQuality == callQuality.sendQuality && this.receivingQuality == callQuality.receivingQuality;
    }

    public final int getReceivingQuality() {
        return this.receivingQuality;
    }

    public final int getSendQuality() {
        return this.sendQuality;
    }

    public int hashCode() {
        return (this.sendQuality * 31) + this.receivingQuality;
    }

    public String toString() {
        return "CallQuality(sendQuality=" + this.sendQuality + ", receivingQuality=" + this.receivingQuality + ")";
    }

    public CallQuality(int i10, int i11) {
        this.sendQuality = i10;
        this.receivingQuality = i11;
    }

    public /* synthetic */ CallQuality(int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? 2 : i10, (i12 & 2) != 0 ? 2 : i11);
    }
}
