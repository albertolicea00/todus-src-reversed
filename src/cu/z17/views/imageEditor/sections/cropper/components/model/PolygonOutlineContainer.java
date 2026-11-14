package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.internal.StabilityInferred;
import i9.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/PolygonOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/PolygonCropShape;", "selectedIndex", "", "outlines", "", "<init>", "(ILjava/util/List;)V", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "getOutlines", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PolygonOutlineContainer implements CropOutlineContainer<PolygonCropShape> {
    public static final int $stable = 8;
    private final List<PolygonCropShape> outlines;
    private int selectedIndex;

    public PolygonOutlineContainer(int i10, List<PolygonCropShape> outlines) {
        y.i(outlines, "outlines");
        this.selectedIndex = i10;
        this.outlines = outlines;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PolygonOutlineContainer copy$default(PolygonOutlineContainer polygonOutlineContainer, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = polygonOutlineContainer.selectedIndex;
        }
        if ((i11 & 2) != 0) {
            list = polygonOutlineContainer.outlines;
        }
        return polygonOutlineContainer.copy(i10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final List<PolygonCropShape> component2() {
        return this.outlines;
    }

    public final PolygonOutlineContainer copy(int selectedIndex, List<PolygonCropShape> outlines) {
        y.i(outlines, "outlines");
        return new PolygonOutlineContainer(selectedIndex, outlines);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolygonOutlineContainer)) {
            return false;
        }
        PolygonOutlineContainer polygonOutlineContainer = (PolygonOutlineContainer) other;
        return this.selectedIndex == polygonOutlineContainer.selectedIndex && y.d(this.outlines, polygonOutlineContainer.outlines);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public List<PolygonCropShape> getOutlines() {
        return this.outlines;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public int getSize() {
        return a.b(this);
    }

    public int hashCode() {
        return (this.selectedIndex * 31) + this.outlines.hashCode();
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public void setSelectedIndex(int i10) {
        this.selectedIndex = i10;
    }

    public String toString() {
        return "PolygonOutlineContainer(selectedIndex=" + this.selectedIndex + ", outlines=" + this.outlines + ")";
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public PolygonCropShape getSelectedItem() {
        return (PolygonCropShape) a.a(this);
    }

    public /* synthetic */ PolygonOutlineContainer(int i10, List list, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, list);
    }
}
