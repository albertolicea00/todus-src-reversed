package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CornerRadiusProperties;", "", "topStartPercent", "", "topEndPercent", "bottomStartPercent", "bottomEndPercent", "<init>", "(IIII)V", "getTopStartPercent", "()I", "getTopEndPercent", "getBottomStartPercent", "getBottomEndPercent", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CornerRadiusProperties {
    public static final int $stable = 0;
    private final int bottomEndPercent;
    private final int bottomStartPercent;
    private final int topEndPercent;
    private final int topStartPercent;

    public CornerRadiusProperties() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ CornerRadiusProperties copy$default(CornerRadiusProperties cornerRadiusProperties, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = cornerRadiusProperties.topStartPercent;
        }
        if ((i14 & 2) != 0) {
            i11 = cornerRadiusProperties.topEndPercent;
        }
        if ((i14 & 4) != 0) {
            i12 = cornerRadiusProperties.bottomStartPercent;
        }
        if ((i14 & 8) != 0) {
            i13 = cornerRadiusProperties.bottomEndPercent;
        }
        return cornerRadiusProperties.copy(i10, i11, i12, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTopStartPercent() {
        return this.topStartPercent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTopEndPercent() {
        return this.topEndPercent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBottomStartPercent() {
        return this.bottomStartPercent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBottomEndPercent() {
        return this.bottomEndPercent;
    }

    public final CornerRadiusProperties copy(int topStartPercent, int topEndPercent, int bottomStartPercent, int bottomEndPercent) {
        return new CornerRadiusProperties(topStartPercent, topEndPercent, bottomStartPercent, bottomEndPercent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CornerRadiusProperties)) {
            return false;
        }
        CornerRadiusProperties cornerRadiusProperties = (CornerRadiusProperties) other;
        return this.topStartPercent == cornerRadiusProperties.topStartPercent && this.topEndPercent == cornerRadiusProperties.topEndPercent && this.bottomStartPercent == cornerRadiusProperties.bottomStartPercent && this.bottomEndPercent == cornerRadiusProperties.bottomEndPercent;
    }

    public final int getBottomEndPercent() {
        return this.bottomEndPercent;
    }

    public final int getBottomStartPercent() {
        return this.bottomStartPercent;
    }

    public final int getTopEndPercent() {
        return this.topEndPercent;
    }

    public final int getTopStartPercent() {
        return this.topStartPercent;
    }

    public int hashCode() {
        return (((((this.topStartPercent * 31) + this.topEndPercent) * 31) + this.bottomStartPercent) * 31) + this.bottomEndPercent;
    }

    public String toString() {
        return "CornerRadiusProperties(topStartPercent=" + this.topStartPercent + ", topEndPercent=" + this.topEndPercent + ", bottomStartPercent=" + this.bottomStartPercent + ", bottomEndPercent=" + this.bottomEndPercent + ")";
    }

    public CornerRadiusProperties(int i10, int i11, int i12, int i13) {
        this.topStartPercent = i10;
        this.topEndPercent = i11;
        this.bottomStartPercent = i12;
        this.bottomEndPercent = i13;
    }

    public /* synthetic */ CornerRadiusProperties(int i10, int i11, int i12, int i13, int i14, p pVar) {
        this((i14 & 1) != 0 ? 20 : i10, (i14 & 2) != 0 ? 20 : i11, (i14 & 4) != 0 ? 20 : i12, (i14 & 8) != 0 ? 20 : i13);
    }
}
