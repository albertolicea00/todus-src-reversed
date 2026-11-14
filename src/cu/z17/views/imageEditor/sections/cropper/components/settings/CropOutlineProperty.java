package cu.z17.views.imageEditor.sections.cropper.components.settings;

import androidx.compose.runtime.Immutable;
import cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline;
import cu.z17.views.imageEditor.sections.cropper.components.model.OutlineType;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/settings/CropOutlineProperty;", "", "outlineType", "Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "cropOutline", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "<init>", "(Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;)V", "getOutlineType", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/OutlineType;", "getCropOutline", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutline;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropOutlineProperty {
    public static final int $stable = 0;
    private final CropOutline cropOutline;
    private final OutlineType outlineType;

    public CropOutlineProperty(OutlineType outlineType, CropOutline cropOutline) {
        y.i(outlineType, "outlineType");
        y.i(cropOutline, "cropOutline");
        this.outlineType = outlineType;
        this.cropOutline = cropOutline;
    }

    public static /* synthetic */ CropOutlineProperty copy$default(CropOutlineProperty cropOutlineProperty, OutlineType outlineType, CropOutline cropOutline, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            outlineType = cropOutlineProperty.outlineType;
        }
        if ((i10 & 2) != 0) {
            cropOutline = cropOutlineProperty.cropOutline;
        }
        return cropOutlineProperty.copy(outlineType, cropOutline);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OutlineType getOutlineType() {
        return this.outlineType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CropOutline getCropOutline() {
        return this.cropOutline;
    }

    public final CropOutlineProperty copy(OutlineType outlineType, CropOutline cropOutline) {
        y.i(outlineType, "outlineType");
        y.i(cropOutline, "cropOutline");
        return new CropOutlineProperty(outlineType, cropOutline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropOutlineProperty)) {
            return false;
        }
        CropOutlineProperty cropOutlineProperty = (CropOutlineProperty) other;
        return this.outlineType == cropOutlineProperty.outlineType && y.d(this.cropOutline, cropOutlineProperty.cropOutline);
    }

    public final CropOutline getCropOutline() {
        return this.cropOutline;
    }

    public final OutlineType getOutlineType() {
        return this.outlineType;
    }

    public int hashCode() {
        return (this.outlineType.hashCode() * 31) + this.cropOutline.hashCode();
    }

    public String toString() {
        return "CropOutlineProperty(outlineType=" + this.outlineType + ", cropOutline=" + this.cropOutline + ")";
    }
}
