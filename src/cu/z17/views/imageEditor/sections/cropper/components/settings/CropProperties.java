package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.IntSize;
import cu.z17.views.imageEditor.sections.cropper.components.model.AspectRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b&\u0010%J\u0010\u0010'\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b'\u0010%J\u0010\u0010(\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b(\u0010%J\u0010\u0010)\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b)\u0010\u001cJ\u0010\u0010*\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b*\u0010%J\u0012\u0010-\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010/\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b.\u0010,J \u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010>\u001a\u0004\b?\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bA\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010 R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010D\u001a\u0004\bE\u0010\"R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010>\u001a\u0004\bF\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010G\u001a\u0004\bH\u0010%R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010G\u001a\u0004\bI\u0010%R\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010G\u001a\u0004\bJ\u0010%R\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010G\u001a\u0004\bK\u0010%R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\bL\u0010\u001cR\u0017\u0010\u0013\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0013\u0010G\u001a\u0004\bM\u0010%R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010N\u001a\u0004\bO\u0010,R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010N\u001a\u0004\bP\u0010,¨\u0006Q"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;", "cropType", "", "handleSize", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;", "cropOutlineProperty", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "aspectRatio", "overlayRatio", "", "pannable", "fling", "rotatable", "zoomable", "maxZoom", "fixedAspectRatio", "Landroidx/compose/ui/unit/IntSize;", "requiredSize", "minDimension", "<init>", "(Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;FLandroidx/compose/ui/layout/ContentScale;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FZZZZFZLandroidx/compose/ui/unit/IntSize;Landroidx/compose/ui/unit/IntSize;Lkotlin/jvm/internal/p;)V", "component1", "()Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;", "component2", "()F", "component3", "()Landroidx/compose/ui/layout/ContentScale;", "component4", "()Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;", "component5", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "component6", "component7", "()Z", "component8", "component9", "component10", "component11", "component12", "component13-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "component13", "component14-bOM6tXw", "component14", "copy-7YnJbbk", "(Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;FLandroidx/compose/ui/layout/ContentScale;Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;FZZZZFZLandroidx/compose/ui/unit/IntSize;Landroidx/compose/ui/unit/IntSize;)Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropProperties;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropType;", "getCropType", "F", "getHandleSize", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;", "getCropOutlineProperty", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "getAspectRatio", "getOverlayRatio", "Z", "getPannable", "getFling", "getRotatable", "getZoomable", "getMaxZoom", "getFixedAspectRatio", "Landroidx/compose/ui/unit/IntSize;", "getRequiredSize-bOM6tXw", "getMinDimension-bOM6tXw", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropProperties {
    public static final int $stable = 0;
    private final AspectRatio aspectRatio;
    private final ContentScale contentScale;
    private final CropOutlineProperty cropOutlineProperty;
    private final CropType cropType;
    private final boolean fixedAspectRatio;
    private final boolean fling;
    private final float handleSize;
    private final float maxZoom;
    private final IntSize minDimension;
    private final float overlayRatio;
    private final boolean pannable;
    private final IntSize requiredSize;
    private final boolean rotatable;
    private final boolean zoomable;

    public /* synthetic */ CropProperties(CropType cropType, float f10, ContentScale contentScale, CropOutlineProperty cropOutlineProperty, AspectRatio aspectRatio, float f11, boolean z10, boolean z11, boolean z12, boolean z13, float f12, boolean z14, IntSize intSize, IntSize intSize2, p pVar) {
        this(cropType, f10, contentScale, cropOutlineProperty, aspectRatio, f11, z10, z11, z12, z13, f12, z14, intSize, intSize2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CropType getCropType() {
        return this.cropType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getZoomable() {
        return this.zoomable;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getMaxZoom() {
        return this.maxZoom;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getFixedAspectRatio() {
        return this.fixedAspectRatio;
    }

    /* JADX INFO: renamed from: component13-bOM6tXw, reason: not valid java name and from getter */
    public final IntSize getRequiredSize() {
        return this.requiredSize;
    }

    /* JADX INFO: renamed from: component14-bOM6tXw, reason: not valid java name and from getter */
    public final IntSize getMinDimension() {
        return this.minDimension;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getHandleSize() {
        return this.handleSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CropOutlineProperty getCropOutlineProperty() {
        return this.cropOutlineProperty;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getOverlayRatio() {
        return this.overlayRatio;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getPannable() {
        return this.pannable;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getFling() {
        return this.fling;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getRotatable() {
        return this.rotatable;
    }

    /* JADX INFO: renamed from: copy-7YnJbbk, reason: not valid java name */
    public final CropProperties m10200copy7YnJbbk(CropType cropType, float handleSize, ContentScale contentScale, CropOutlineProperty cropOutlineProperty, AspectRatio aspectRatio, float overlayRatio, boolean pannable, boolean fling, boolean rotatable, boolean zoomable, float maxZoom, boolean fixedAspectRatio, IntSize requiredSize, IntSize minDimension) {
        y.i(cropType, "cropType");
        y.i(contentScale, "contentScale");
        y.i(cropOutlineProperty, "cropOutlineProperty");
        y.i(aspectRatio, "aspectRatio");
        return new CropProperties(cropType, handleSize, contentScale, cropOutlineProperty, aspectRatio, overlayRatio, pannable, fling, rotatable, zoomable, maxZoom, fixedAspectRatio, requiredSize, minDimension, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropProperties)) {
            return false;
        }
        CropProperties cropProperties = (CropProperties) other;
        return this.cropType == cropProperties.cropType && Float.compare(this.handleSize, cropProperties.handleSize) == 0 && y.d(this.contentScale, cropProperties.contentScale) && y.d(this.cropOutlineProperty, cropProperties.cropOutlineProperty) && y.d(this.aspectRatio, cropProperties.aspectRatio) && Float.compare(this.overlayRatio, cropProperties.overlayRatio) == 0 && this.pannable == cropProperties.pannable && this.fling == cropProperties.fling && this.rotatable == cropProperties.rotatable && this.zoomable == cropProperties.zoomable && Float.compare(this.maxZoom, cropProperties.maxZoom) == 0 && this.fixedAspectRatio == cropProperties.fixedAspectRatio && y.d(this.requiredSize, cropProperties.requiredSize) && y.d(this.minDimension, cropProperties.minDimension);
    }

    public final AspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final CropOutlineProperty getCropOutlineProperty() {
        return this.cropOutlineProperty;
    }

    public final CropType getCropType() {
        return this.cropType;
    }

    public final boolean getFixedAspectRatio() {
        return this.fixedAspectRatio;
    }

    public final boolean getFling() {
        return this.fling;
    }

    public final float getHandleSize() {
        return this.handleSize;
    }

    public final float getMaxZoom() {
        return this.maxZoom;
    }

    /* JADX INFO: renamed from: getMinDimension-bOM6tXw, reason: not valid java name */
    public final IntSize m10201getMinDimensionbOM6tXw() {
        return this.minDimension;
    }

    public final float getOverlayRatio() {
        return this.overlayRatio;
    }

    public final boolean getPannable() {
        return this.pannable;
    }

    /* JADX INFO: renamed from: getRequiredSize-bOM6tXw, reason: not valid java name */
    public final IntSize m10202getRequiredSizebOM6tXw() {
        return this.requiredSize;
    }

    public final boolean getRotatable() {
        return this.rotatable;
    }

    public final boolean getZoomable() {
        return this.zoomable;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((this.cropType.hashCode() * 31) + Float.floatToIntBits(this.handleSize)) * 31) + this.contentScale.hashCode()) * 31) + this.cropOutlineProperty.hashCode()) * 31) + this.aspectRatio.hashCode()) * 31) + Float.floatToIntBits(this.overlayRatio)) * 31) + r.a(this.pannable)) * 31) + r.a(this.fling)) * 31) + r.a(this.rotatable)) * 31) + r.a(this.zoomable)) * 31) + Float.floatToIntBits(this.maxZoom)) * 31) + r.a(this.fixedAspectRatio)) * 31;
        IntSize intSize = this.requiredSize;
        int iM8991hashCodeimpl = (iHashCode + (intSize == null ? 0 : IntSize.m8991hashCodeimpl(intSize.m8994unboximpl()))) * 31;
        IntSize intSize2 = this.minDimension;
        return iM8991hashCodeimpl + (intSize2 != null ? IntSize.m8991hashCodeimpl(intSize2.m8994unboximpl()) : 0);
    }

    public String toString() {
        return "CropProperties(cropType=" + this.cropType + ", handleSize=" + this.handleSize + ", contentScale=" + this.contentScale + ", cropOutlineProperty=" + this.cropOutlineProperty + ", aspectRatio=" + this.aspectRatio + ", overlayRatio=" + this.overlayRatio + ", pannable=" + this.pannable + ", fling=" + this.fling + ", rotatable=" + this.rotatable + ", zoomable=" + this.zoomable + ", maxZoom=" + this.maxZoom + ", fixedAspectRatio=" + this.fixedAspectRatio + ", requiredSize=" + this.requiredSize + ", minDimension=" + this.minDimension + ")";
    }

    private CropProperties(CropType cropType, float f10, ContentScale contentScale, CropOutlineProperty cropOutlineProperty, AspectRatio aspectRatio, float f11, boolean z10, boolean z11, boolean z12, boolean z13, float f12, boolean z14, IntSize intSize, IntSize intSize2) {
        y.i(cropType, "cropType");
        y.i(contentScale, "contentScale");
        y.i(cropOutlineProperty, "cropOutlineProperty");
        y.i(aspectRatio, "aspectRatio");
        this.cropType = cropType;
        this.handleSize = f10;
        this.contentScale = contentScale;
        this.cropOutlineProperty = cropOutlineProperty;
        this.aspectRatio = aspectRatio;
        this.overlayRatio = f11;
        this.pannable = z10;
        this.fling = z11;
        this.rotatable = z12;
        this.zoomable = z13;
        this.maxZoom = f12;
        this.fixedAspectRatio = z14;
        this.requiredSize = intSize;
        this.minDimension = intSize2;
    }

    public /* synthetic */ CropProperties(CropType cropType, float f10, ContentScale contentScale, CropOutlineProperty cropOutlineProperty, AspectRatio aspectRatio, float f11, boolean z10, boolean z11, boolean z12, boolean z13, float f12, boolean z14, IntSize intSize, IntSize intSize2, int i10, p pVar) {
        this(cropType, f10, contentScale, cropOutlineProperty, aspectRatio, f11, z10, z11, z12, z13, f12, (i10 & 2048) != 0 ? false : z14, (i10 & 4096) != 0 ? null : intSize, (i10 & 8192) != 0 ? null : intSize2, null);
    }
}
