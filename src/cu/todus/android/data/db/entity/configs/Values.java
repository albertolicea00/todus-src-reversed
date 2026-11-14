package cu.todus.android.data.db.entity.configs;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcu/todus/android/data/db/entity/configs/Values;", "", "alert", "", "sound", "", "priority", "", "color", "<init>", "(ZLjava/lang/String;II)V", "getAlert", "()Z", "getSound", "()Ljava/lang/String;", "getPriority", "()I", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Values {
    public static final int $stable = 0;
    private final boolean alert;
    private final int color;
    private final int priority;
    private final String sound;

    public Values(boolean z10, String sound, int i10, int i11) {
        y.i(sound, "sound");
        this.alert = z10;
        this.sound = sound;
        this.priority = i10;
        this.color = i11;
    }

    public static /* synthetic */ Values copy$default(Values values, boolean z10, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = values.alert;
        }
        if ((i12 & 2) != 0) {
            str = values.sound;
        }
        if ((i12 & 4) != 0) {
            i10 = values.priority;
        }
        if ((i12 & 8) != 0) {
            i11 = values.color;
        }
        return values.copy(z10, str, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAlert() {
        return this.alert;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSound() {
        return this.sound;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final Values copy(boolean alert, String sound, int priority, int color) {
        y.i(sound, "sound");
        return new Values(alert, sound, priority, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Values)) {
            return false;
        }
        Values values = (Values) other;
        return this.alert == values.alert && y.d(this.sound, values.sound) && this.priority == values.priority && this.color == values.color;
    }

    public final boolean getAlert() {
        return this.alert;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getSound() {
        return this.sound;
    }

    public int hashCode() {
        return (((((r.a(this.alert) * 31) + this.sound.hashCode()) * 31) + this.priority) * 31) + this.color;
    }

    public String toString() {
        return "Values(alert=" + this.alert + ", sound=" + this.sound + ", priority=" + this.priority + ", color=" + this.color + ")";
    }
}
