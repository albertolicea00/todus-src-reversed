package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\r¨\u0006!"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalProperties;", "", "", "startAngle", "sweepAngle", "Landroidx/compose/ui/geometry/Offset;", "offset", "<init>", "(FFJLkotlin/jvm/internal/p;)V", "component1", "()F", "component2", "component3-F1C5BW0", "()J", "component3", "copy-0AR0LA0", "(FFJ)Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalProperties;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getStartAngle", "getSweepAngle", "J", "getOffset-F1C5BW0", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OvalProperties {
    public static final int $stable = 0;
    private final long offset;
    private final float startAngle;
    private final float sweepAngle;

    public /* synthetic */ OvalProperties(float f10, float f11, long j10, p pVar) {
        this(f10, f11, j10);
    }

    /* JADX INFO: renamed from: copy-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ OvalProperties m10185copy0AR0LA0$default(OvalProperties ovalProperties, float f10, float f11, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = ovalProperties.startAngle;
        }
        if ((i10 & 2) != 0) {
            f11 = ovalProperties.sweepAngle;
        }
        if ((i10 & 4) != 0) {
            j10 = ovalProperties.offset;
        }
        return ovalProperties.m10187copy0AR0LA0(f10, f11, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getStartAngle() {
        return this.startAngle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSweepAngle() {
        return this.sweepAngle;
    }

    /* JADX INFO: renamed from: component3-F1C5BW0, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: copy-0AR0LA0, reason: not valid java name */
    public final OvalProperties m10187copy0AR0LA0(float startAngle, float sweepAngle, long offset) {
        return new OvalProperties(startAngle, sweepAngle, offset, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OvalProperties)) {
            return false;
        }
        OvalProperties ovalProperties = (OvalProperties) other;
        return Float.compare(this.startAngle, ovalProperties.startAngle) == 0 && Float.compare(this.sweepAngle, ovalProperties.sweepAngle) == 0 && Offset.m5623equalsimpl0(this.offset, ovalProperties.offset);
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m10188getOffsetF1C5BW0() {
        return this.offset;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }

    public final float getSweepAngle() {
        return this.sweepAngle;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.startAngle) * 31) + Float.floatToIntBits(this.sweepAngle)) * 31) + Offset.m5628hashCodeimpl(this.offset);
    }

    public String toString() {
        return "OvalProperties(startAngle=" + this.startAngle + ", sweepAngle=" + this.sweepAngle + ", offset=" + Offset.m5634toStringimpl(this.offset) + ")";
    }

    private OvalProperties(float f10, float f11, long j10) {
        this.startAngle = f10;
        this.sweepAngle = f11;
        this.offset = j10;
    }

    public /* synthetic */ OvalProperties(float f10, float f11, long j10, int i10, p pVar) {
        this((i10 & 1) != 0 ? 0.0f : f10, (i10 & 2) != 0 ? 360.0f : f11, (i10 & 4) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j10, null);
    }
}
