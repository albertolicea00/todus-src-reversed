package cu.todus.android.uiCompose.call.screen.call.components.controls;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "", "<init>", "()V", "ToggleMicroPhone", "ToggleCamera", "FlipCamera", "LeaveCall", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$FlipCamera;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$LeaveCall;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$ToggleCamera;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$ToggleMicroPhone;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CallAction {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$FlipCamera;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FlipCamera extends CallAction {
        public static final int $stable = 0;
        public static final FlipCamera INSTANCE = new FlipCamera();

        private FlipCamera() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$LeaveCall;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class LeaveCall extends CallAction {
        public static final int $stable = 0;
        public static final LeaveCall INSTANCE = new LeaveCall();

        private LeaveCall() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$ToggleCamera;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "isEnabled", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ToggleCamera extends CallAction {
        public static final int $stable = 0;
        private final boolean isEnabled;

        public ToggleCamera(boolean z10) {
            super(null);
            this.isEnabled = z10;
        }

        public static /* synthetic */ ToggleCamera copy$default(ToggleCamera toggleCamera, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = toggleCamera.isEnabled;
            }
            return toggleCamera.copy(z10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final ToggleCamera copy(boolean isEnabled) {
            return new ToggleCamera(isEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ToggleCamera) && this.isEnabled == ((ToggleCamera) other).isEnabled;
        }

        public int hashCode() {
            return r.a(this.isEnabled);
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public String toString() {
            return "ToggleCamera(isEnabled=" + this.isEnabled + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction$ToggleMicroPhone;", "Lcu/todus/android/uiCompose/call/screen/call/components/controls/CallAction;", "isEnabled", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ToggleMicroPhone extends CallAction {
        public static final int $stable = 0;
        private final boolean isEnabled;

        public ToggleMicroPhone(boolean z10) {
            super(null);
            this.isEnabled = z10;
        }

        public static /* synthetic */ ToggleMicroPhone copy$default(ToggleMicroPhone toggleMicroPhone, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = toggleMicroPhone.isEnabled;
            }
            return toggleMicroPhone.copy(z10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final ToggleMicroPhone copy(boolean isEnabled) {
            return new ToggleMicroPhone(isEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ToggleMicroPhone) && this.isEnabled == ((ToggleMicroPhone) other).isEnabled;
        }

        public int hashCode() {
            return r.a(this.isEnabled);
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public String toString() {
            return "ToggleMicroPhone(isEnabled=" + this.isEnabled + ")";
        }
    }

    public /* synthetic */ CallAction(p pVar) {
        this();
    }

    private CallAction() {
    }
}
