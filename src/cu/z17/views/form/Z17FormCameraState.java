package cu.z17.views.form;

import androidx.compose.runtime.Immutable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcu/z17/views/form/Z17FormCameraState;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "type", "", "step", "Lcu/z17/views/form/Z17FormCameraStep;", "<init>", "(Ljava/lang/String;ILcu/z17/views/form/Z17FormCameraStep;)V", "getValue", "()Ljava/lang/String;", "getType", "()I", "getStep", "()Lcu/z17/views/form/Z17FormCameraStep;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Z17FormCameraState {
    public static final int $stable = 0;
    private final Z17FormCameraStep step;
    private final int type;
    private final String value;

    public Z17FormCameraState(String value, int i10, Z17FormCameraStep step) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(step, "step");
        this.value = value;
        this.type = i10;
        this.step = step;
    }

    public static /* synthetic */ Z17FormCameraState copy$default(Z17FormCameraState z17FormCameraState, String str, int i10, Z17FormCameraStep z17FormCameraStep, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = z17FormCameraState.value;
        }
        if ((i11 & 2) != 0) {
            i10 = z17FormCameraState.type;
        }
        if ((i11 & 4) != 0) {
            z17FormCameraStep = z17FormCameraState.step;
        }
        return z17FormCameraState.copy(str, i10, z17FormCameraStep);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Z17FormCameraStep getStep() {
        return this.step;
    }

    public final Z17FormCameraState copy(String value, int type, Z17FormCameraStep step) {
        kotlin.jvm.internal.y.i(value, "value");
        kotlin.jvm.internal.y.i(step, "step");
        return new Z17FormCameraState(value, type, step);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Z17FormCameraState)) {
            return false;
        }
        Z17FormCameraState z17FormCameraState = (Z17FormCameraState) other;
        return kotlin.jvm.internal.y.d(this.value, z17FormCameraState.value) && this.type == z17FormCameraState.type && this.step == z17FormCameraState.step;
    }

    public final Z17FormCameraStep getStep() {
        return this.step;
    }

    public final int getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.value.hashCode() * 31) + this.type) * 31) + this.step.hashCode();
    }

    public String toString() {
        return "Z17FormCameraState(value=" + this.value + ", type=" + this.type + ", step=" + this.step + ")";
    }

    public /* synthetic */ Z17FormCameraState(String str, int i10, Z17FormCameraStep z17FormCameraStep, int i11, kotlin.jvm.internal.p pVar) {
        this(str, i10, (i11 & 4) != 0 ? Z17FormCameraStep.SHOOTING : z17FormCameraStep);
    }
}
