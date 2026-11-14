package cu.todus.android.uiCompose.call;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcu/todus/android/uiCompose/call/CallParams;", "", "pickId", "", "isVideoCall", "", "<init>", "(Ljava/lang/String;Z)V", "getPickId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CallParams {
    public static final int $stable = 0;
    private final boolean isVideoCall;
    private final String pickId;

    public CallParams(String pickId, boolean z10) {
        y.i(pickId, "pickId");
        this.pickId = pickId;
        this.isVideoCall = z10;
    }

    public static /* synthetic */ CallParams copy$default(CallParams callParams, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = callParams.pickId;
        }
        if ((i10 & 2) != 0) {
            z10 = callParams.isVideoCall;
        }
        return callParams.copy(str, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPickId() {
        return this.pickId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public final CallParams copy(String pickId, boolean isVideoCall) {
        y.i(pickId, "pickId");
        return new CallParams(pickId, isVideoCall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallParams)) {
            return false;
        }
        CallParams callParams = (CallParams) other;
        return y.d(this.pickId, callParams.pickId) && this.isVideoCall == callParams.isVideoCall;
    }

    public final String getPickId() {
        return this.pickId;
    }

    public int hashCode() {
        return (this.pickId.hashCode() * 31) + androidx.camera.camera2.adapter.r.a(this.isVideoCall);
    }

    public final boolean isVideoCall() {
        return this.isVideoCall;
    }

    public String toString() {
        return "CallParams(pickId=" + this.pickId + ", isVideoCall=" + this.isVideoCall + ")";
    }

    public /* synthetic */ CallParams(String str, boolean z10, int i10, kotlin.jvm.internal.p pVar) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
