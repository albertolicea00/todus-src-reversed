package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013JB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b&\u0010\rR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CropData;", "", "", "zoom", "Landroidx/compose/ui/geometry/Offset;", "pan", Key.ROTATION, "Landroidx/compose/ui/geometry/Rect;", "overlayRect", "cropRect", "<init>", "(FJFLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/internal/p;)V", "component1", "()F", "component2-F1C5BW0", "()J", "component2", "component3", "component4", "()Landroidx/compose/ui/geometry/Rect;", "component5", "copy-YqVAtuI", "(FJFLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)Lcu/z17/views/imageEditor/sections/cropper/components/model/CropData;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "getZoom", "J", "getPan-F1C5BW0", "getRotation", "Landroidx/compose/ui/geometry/Rect;", "getOverlayRect", "getCropRect", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropData {
    public static final int $stable = 0;
    private final Rect cropRect;
    private final Rect overlayRect;
    private final long pan;
    private final float rotation;
    private final float zoom;

    public /* synthetic */ CropData(float f10, long j10, float f11, Rect rect, Rect rect2, p pVar) {
        this(f10, j10, f11, rect, rect2);
    }

    /* JADX INFO: renamed from: copy-YqVAtuI$default, reason: not valid java name */
    public static /* synthetic */ CropData m10181copyYqVAtuI$default(CropData cropData, float f10, long j10, float f11, Rect rect, Rect rect2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = cropData.zoom;
        }
        if ((i10 & 2) != 0) {
            j10 = cropData.pan;
        }
        if ((i10 & 4) != 0) {
            f11 = cropData.rotation;
        }
        if ((i10 & 8) != 0) {
            rect = cropData.overlayRect;
        }
        if ((i10 & 16) != 0) {
            rect2 = cropData.cropRect;
        }
        Rect rect3 = rect2;
        float f12 = f11;
        return cropData.m10183copyYqVAtuI(f10, j10, f12, rect, rect3);
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
    public final Rect getOverlayRect() {
        return this.overlayRect;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Rect getCropRect() {
        return this.cropRect;
    }

    /* JADX INFO: renamed from: copy-YqVAtuI, reason: not valid java name */
    public final CropData m10183copyYqVAtuI(float zoom, long pan, float rotation, Rect overlayRect, Rect cropRect) {
        y.i(overlayRect, "overlayRect");
        y.i(cropRect, "cropRect");
        return new CropData(zoom, pan, rotation, overlayRect, cropRect, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropData)) {
            return false;
        }
        CropData cropData = (CropData) other;
        return Float.compare(this.zoom, cropData.zoom) == 0 && Offset.m5623equalsimpl0(this.pan, cropData.pan) && Float.compare(this.rotation, cropData.rotation) == 0 && y.d(this.overlayRect, cropData.overlayRect) && y.d(this.cropRect, cropData.cropRect);
    }

    public final Rect getCropRect() {
        return this.cropRect;
    }

    public final Rect getOverlayRect() {
        return this.overlayRect;
    }

    /* JADX INFO: renamed from: getPan-F1C5BW0, reason: not valid java name */
    public final long m10184getPanF1C5BW0() {
        return this.pan;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.zoom) * 31) + Offset.m5628hashCodeimpl(this.pan)) * 31) + Float.floatToIntBits(this.rotation)) * 31) + this.overlayRect.hashCode()) * 31) + this.cropRect.hashCode();
    }

    public String toString() {
        return "CropData(zoom=" + this.zoom + ", pan=" + Offset.m5634toStringimpl(this.pan) + ", rotation=" + this.rotation + ", overlayRect=" + this.overlayRect + ", cropRect=" + this.cropRect + ")";
    }

    private CropData(float f10, long j10, float f11, Rect overlayRect, Rect cropRect) {
        y.i(overlayRect, "overlayRect");
        y.i(cropRect, "cropRect");
        this.zoom = f10;
        this.pan = j10;
        this.rotation = f11;
        this.overlayRect = overlayRect;
        this.cropRect = cropRect;
    }

    public /* synthetic */ CropData(float f10, long j10, float f11, Rect rect, Rect rect2, int i10, p pVar) {
        this((i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? Offset.INSTANCE.m5642getZeroF1C5BW0() : j10, (i10 & 4) != 0 ? 0.0f : f11, rect, rect2, null);
    }
}
