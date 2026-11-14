package cu.z17.views.zoomables;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u0014R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b,\u0010\u0016¨\u0006-"}, d2 = {"Lcu/z17/views/zoomables/EnhancedZoomData;", "", "", "zoom", "Landroidx/compose/ui/geometry/Offset;", "pan", Key.ROTATION, "Landroidx/compose/ui/geometry/Rect;", "imageRegion", "Landroidx/compose/ui/unit/IntRect;", "visibleRegion", "<init>", "(FJFLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/unit/IntRect;Lkotlin/jvm/internal/p;)V", "component1", "()F", "component2-F1C5BW0", "()J", "component2", "component3", "component4", "()Landroidx/compose/ui/geometry/Rect;", "component5", "()Landroidx/compose/ui/unit/IntRect;", "copy-YqVAtuI", "(FJFLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/unit/IntRect;)Lcu/z17/views/zoomables/EnhancedZoomData;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getZoom", "J", "getPan-F1C5BW0", "getRotation", "Landroidx/compose/ui/geometry/Rect;", "getImageRegion", "Landroidx/compose/ui/unit/IntRect;", "getVisibleRegion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EnhancedZoomData {
    public static final int $stable = 0;
    private final Rect imageRegion;
    private final long pan;
    private final float rotation;
    private final IntRect visibleRegion;
    private final float zoom;

    public /* synthetic */ EnhancedZoomData(float f10, long j10, float f11, Rect rect, IntRect intRect, kotlin.jvm.internal.p pVar) {
        this(f10, j10, f11, rect, intRect);
    }

    /* JADX INFO: renamed from: copy-YqVAtuI$default, reason: not valid java name */
    public static /* synthetic */ EnhancedZoomData m10331copyYqVAtuI$default(EnhancedZoomData enhancedZoomData, float f10, long j10, float f11, Rect rect, IntRect intRect, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = enhancedZoomData.zoom;
        }
        if ((i10 & 2) != 0) {
            j10 = enhancedZoomData.pan;
        }
        if ((i10 & 4) != 0) {
            f11 = enhancedZoomData.rotation;
        }
        if ((i10 & 8) != 0) {
            rect = enhancedZoomData.imageRegion;
        }
        if ((i10 & 16) != 0) {
            intRect = enhancedZoomData.visibleRegion;
        }
        IntRect intRect2 = intRect;
        float f12 = f11;
        return enhancedZoomData.m10333copyYqVAtuI(f10, j10, f12, rect, intRect2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getZoom() {
        return this.zoom;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name and from getter */
    public final long getPan() {
        return this.pan;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRotation() {
        return this.rotation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Rect getImageRegion() {
        return this.imageRegion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final IntRect getVisibleRegion() {
        return this.visibleRegion;
    }

    /* JADX INFO: renamed from: copy-YqVAtuI, reason: not valid java name */
    public final EnhancedZoomData m10333copyYqVAtuI(float zoom, long pan, float rotation, Rect imageRegion, IntRect visibleRegion) {
        y.i(imageRegion, "imageRegion");
        y.i(visibleRegion, "visibleRegion");
        return new EnhancedZoomData(zoom, pan, rotation, imageRegion, visibleRegion, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnhancedZoomData)) {
            return false;
        }
        EnhancedZoomData enhancedZoomData = (EnhancedZoomData) other;
        return Float.compare(this.zoom, enhancedZoomData.zoom) == 0 && Offset.m5623equalsimpl0(this.pan, enhancedZoomData.pan) && Float.compare(this.rotation, enhancedZoomData.rotation) == 0 && y.d(this.imageRegion, enhancedZoomData.imageRegion) && y.d(this.visibleRegion, enhancedZoomData.visibleRegion);
    }

    public final Rect getImageRegion() {
        return this.imageRegion;
    }

    /* JADX INFO: renamed from: getPan-F1C5BW0, reason: not valid java name */
    public final long m10334getPanF1C5BW0() {
        return this.pan;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final IntRect getVisibleRegion() {
        return this.visibleRegion;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.zoom) * 31) + Offset.m5628hashCodeimpl(this.pan)) * 31) + Float.floatToIntBits(this.rotation)) * 31) + this.imageRegion.hashCode()) * 31) + this.visibleRegion.hashCode();
    }

    public String toString() {
        return "EnhancedZoomData(zoom=" + this.zoom + ", pan=" + Offset.m5634toStringimpl(this.pan) + ", rotation=" + this.rotation + ", imageRegion=" + this.imageRegion + ", visibleRegion=" + this.visibleRegion + ")";
    }

    private EnhancedZoomData(float f10, long j10, float f11, Rect imageRegion, IntRect visibleRegion) {
        y.i(imageRegion, "imageRegion");
        y.i(visibleRegion, "visibleRegion");
        this.zoom = f10;
        this.pan = j10;
        this.rotation = f11;
        this.imageRegion = imageRegion;
        this.visibleRegion = visibleRegion;
    }

    public /* synthetic */ EnhancedZoomData(float f10, long j10, float f11, Rect rect, IntRect intRect, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j10, (i10 & 4) != 0 ? 0.0f : f11, rect, intRect, null);
    }
}
