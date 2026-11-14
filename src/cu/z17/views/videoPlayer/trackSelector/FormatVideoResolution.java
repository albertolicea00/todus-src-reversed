package cu.z17.views.videoPlayer.trackSelector;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/FormatVideoResolution;", "Lcu/z17/views/videoPlayer/trackSelector/FormatData;", "width", "", "height", "<init>", "(II)V", "getWidth", "()I", "getHeight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FormatVideoResolution extends FormatData {
    public static final int $stable = 0;
    private final int height;
    private final int width;

    public FormatVideoResolution(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public static /* synthetic */ FormatVideoResolution copy$default(FormatVideoResolution formatVideoResolution, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = formatVideoResolution.width;
        }
        if ((i12 & 2) != 0) {
            i11 = formatVideoResolution.height;
        }
        return formatVideoResolution.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final FormatVideoResolution copy(int width, int height) {
        return new FormatVideoResolution(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormatVideoResolution)) {
            return false;
        }
        FormatVideoResolution formatVideoResolution = (FormatVideoResolution) other;
        return this.width == formatVideoResolution.width && this.height == formatVideoResolution.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "FormatVideoResolution(width=" + this.width + ", height=" + this.height + ")";
    }
}
