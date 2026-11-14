package cu.z17.views.zoomables;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\n¨\u0006!"}, d2 = {"Lcu/z17/views/zoomables/ZoomData;", "", "", "zoom", "Landroidx/compose/ui/geometry/Offset;", "pan", Key.ROTATION, "<init>", "(FJFLkotlin/jvm/internal/p;)V", "component1", "()F", "component2-F1C5BW0", "()J", "component2", "component3", "copy-d-4ec7I", "(FJF)Lcu/z17/views/zoomables/ZoomData;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getZoom", "J", "getPan-F1C5BW0", "getRotation", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ZoomData {
    public static final int $stable = 0;
    private final long pan;
    private final float rotation;
    private final float zoom;

    public /* synthetic */ ZoomData(float f10, long j10, float f11, kotlin.jvm.internal.p pVar) {
        this(f10, j10, f11);
    }

    /* JADX INFO: renamed from: copy-d-4ec7I$default, reason: not valid java name */
    public static /* synthetic */ ZoomData m10335copyd4ec7I$default(ZoomData zoomData, float f10, long j10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = zoomData.zoom;
        }
        if ((i10 & 2) != 0) {
            j10 = zoomData.pan;
        }
        if ((i10 & 4) != 0) {
            f11 = zoomData.rotation;
        }
        return zoomData.m10337copyd4ec7I(f10, j10, f11);
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

    /* JADX INFO: renamed from: copy-d-4ec7I, reason: not valid java name */
    public final ZoomData m10337copyd4ec7I(float zoom, long pan, float rotation) {
        return new ZoomData(zoom, pan, rotation, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZoomData)) {
            return false;
        }
        ZoomData zoomData = (ZoomData) other;
        return Float.compare(this.zoom, zoomData.zoom) == 0 && Offset.m5623equalsimpl0(this.pan, zoomData.pan) && Float.compare(this.rotation, zoomData.rotation) == 0;
    }

    /* JADX INFO: renamed from: getPan-F1C5BW0, reason: not valid java name */
    public final long m10338getPanF1C5BW0() {
        return this.pan;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.zoom) * 31) + Offset.m5628hashCodeimpl(this.pan)) * 31) + Float.floatToIntBits(this.rotation);
    }

    public String toString() {
        return "ZoomData(zoom=" + this.zoom + ", pan=" + Offset.m5634toStringimpl(this.pan) + ", rotation=" + this.rotation + ")";
    }

    private ZoomData(float f10, long j10, float f11) {
        this.zoom = f10;
        this.pan = j10;
        this.rotation = f11;
    }

    public /* synthetic */ ZoomData(float f10, long j10, float f11, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j10, (i10 & 4) != 0 ? 0.0f : f11, null);
    }
}
