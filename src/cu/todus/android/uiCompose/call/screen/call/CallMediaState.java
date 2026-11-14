package cu.todus.android.uiCompose.call.screen.call;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "", "isMicrophoneEnabled", "", "isCameraEnabled", "isSoundEnable", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CallMediaState {
    public static final int $stable = 0;
    private final boolean isCameraEnabled;
    private final boolean isMicrophoneEnabled;
    private final boolean isSoundEnable;

    public CallMediaState() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ CallMediaState copy$default(CallMediaState callMediaState, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = callMediaState.isMicrophoneEnabled;
        }
        if ((i10 & 2) != 0) {
            z11 = callMediaState.isCameraEnabled;
        }
        if ((i10 & 4) != 0) {
            z12 = callMediaState.isSoundEnable;
        }
        return callMediaState.copy(z10, z11, z12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMicrophoneEnabled() {
        return this.isMicrophoneEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsCameraEnabled() {
        return this.isCameraEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSoundEnable() {
        return this.isSoundEnable;
    }

    public final CallMediaState copy(boolean isMicrophoneEnabled, boolean isCameraEnabled, boolean isSoundEnable) {
        return new CallMediaState(isMicrophoneEnabled, isCameraEnabled, isSoundEnable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallMediaState)) {
            return false;
        }
        CallMediaState callMediaState = (CallMediaState) other;
        return this.isMicrophoneEnabled == callMediaState.isMicrophoneEnabled && this.isCameraEnabled == callMediaState.isCameraEnabled && this.isSoundEnable == callMediaState.isSoundEnable;
    }

    public int hashCode() {
        return (((androidx.camera.camera2.adapter.r.a(this.isMicrophoneEnabled) * 31) + androidx.camera.camera2.adapter.r.a(this.isCameraEnabled)) * 31) + androidx.camera.camera2.adapter.r.a(this.isSoundEnable);
    }

    public final boolean isCameraEnabled() {
        return this.isCameraEnabled;
    }

    public final boolean isMicrophoneEnabled() {
        return this.isMicrophoneEnabled;
    }

    public final boolean isSoundEnable() {
        return this.isSoundEnable;
    }

    public String toString() {
        return "CallMediaState(isMicrophoneEnabled=" + this.isMicrophoneEnabled + ", isCameraEnabled=" + this.isCameraEnabled + ", isSoundEnable=" + this.isSoundEnable + ")";
    }

    public CallMediaState(boolean z10, boolean z11, boolean z12) {
        this.isMicrophoneEnabled = z10;
        this.isCameraEnabled = z11;
        this.isSoundEnable = z12;
    }

    public /* synthetic */ CallMediaState(boolean z10, boolean z11, boolean z12, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12);
    }
}
