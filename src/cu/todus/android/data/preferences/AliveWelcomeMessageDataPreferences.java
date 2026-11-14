package cu.todus.android.data.preferences;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcu/todus/android/data/preferences/AliveWelcomeMessageDataPreferences;", "", "mockupSaved", "", "lastShowed", "", "actualMax", "<init>", "(ZII)V", "getMockupSaved", "()Z", "getLastShowed", "()I", "getActualMax", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AliveWelcomeMessageDataPreferences {
    public static final int $stable = 0;
    private final int actualMax;
    private final int lastShowed;
    private final boolean mockupSaved;

    public AliveWelcomeMessageDataPreferences() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ AliveWelcomeMessageDataPreferences copy$default(AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferences, boolean z10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = aliveWelcomeMessageDataPreferences.mockupSaved;
        }
        if ((i12 & 2) != 0) {
            i10 = aliveWelcomeMessageDataPreferences.lastShowed;
        }
        if ((i12 & 4) != 0) {
            i11 = aliveWelcomeMessageDataPreferences.actualMax;
        }
        return aliveWelcomeMessageDataPreferences.copy(z10, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMockupSaved() {
        return this.mockupSaved;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLastShowed() {
        return this.lastShowed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getActualMax() {
        return this.actualMax;
    }

    public final AliveWelcomeMessageDataPreferences copy(boolean mockupSaved, int lastShowed, int actualMax) {
        return new AliveWelcomeMessageDataPreferences(mockupSaved, lastShowed, actualMax);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AliveWelcomeMessageDataPreferences)) {
            return false;
        }
        AliveWelcomeMessageDataPreferences aliveWelcomeMessageDataPreferences = (AliveWelcomeMessageDataPreferences) other;
        return this.mockupSaved == aliveWelcomeMessageDataPreferences.mockupSaved && this.lastShowed == aliveWelcomeMessageDataPreferences.lastShowed && this.actualMax == aliveWelcomeMessageDataPreferences.actualMax;
    }

    public final int getActualMax() {
        return this.actualMax;
    }

    public final int getLastShowed() {
        return this.lastShowed;
    }

    public final boolean getMockupSaved() {
        return this.mockupSaved;
    }

    public int hashCode() {
        return (((r.a(this.mockupSaved) * 31) + this.lastShowed) * 31) + this.actualMax;
    }

    public String toString() {
        return "AliveWelcomeMessageDataPreferences(mockupSaved=" + this.mockupSaved + ", lastShowed=" + this.lastShowed + ", actualMax=" + this.actualMax + ")";
    }

    public AliveWelcomeMessageDataPreferences(boolean z10, int i10, int i11) {
        this.mockupSaved = z10;
        this.lastShowed = i10;
        this.actualMax = i11;
    }

    public /* synthetic */ AliveWelcomeMessageDataPreferences(boolean z10, int i10, int i11, int i12, p pVar) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
