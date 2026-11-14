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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/ImageMaskOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropOutlineContainer;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/ImageMaskOutline;", "selectedIndex", "", "outlines", "", "<init>", "(ILjava/util/List;)V", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "getOutlines", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageMaskOutlineContainer implements CropOutlineContainer<ImageMaskOutline> {
    public static final int $stable = 8;
    private final List<ImageMaskOutline> outlines;
    private int selectedIndex;

    public ImageMaskOutlineContainer(int i10, List<ImageMaskOutline> outlines) {
        y.i(outlines, "outlines");
        this.selectedIndex = i10;
        this.outlines = outlines;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageMaskOutlineContainer copy$default(ImageMaskOutlineContainer imageMaskOutlineContainer, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = imageMaskOutlineContainer.selectedIndex;
        }
        if ((i11 & 2) != 0) {
            list = imageMaskOutlineContainer.outlines;
        }
        return imageMaskOutlineContainer.copy(i10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final List<ImageMaskOutline> component2() {
        return this.outlines;
    }

    public final ImageMaskOutlineContainer copy(int selectedIndex, List<ImageMaskOutline> outlines) {
        y.i(outlines, "outlines");
        return new ImageMaskOutlineContainer(selectedIndex, outlines);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageMaskOutlineContainer)) {
            return false;
        }
        ImageMaskOutlineContainer imageMaskOutlineContainer = (ImageMaskOutlineContainer) other;
        return this.selectedIndex == imageMaskOutlineContainer.selectedIndex && y.d(this.outlines, imageMaskOutlineContainer.outlines);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public List<ImageMaskOutline> getOutlines() {
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
        return "ImageMaskOutlineContainer(selectedIndex=" + this.selectedIndex + ", outlines=" + this.outlines + ")";
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutlineContainer
    public ImageMaskOutline getSelectedItem() {
        return (ImageMaskOutline) a.a(this);
    }

    public /* synthetic */ ImageMaskOutlineContainer(int i10, List list, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10, list);
    }
}
