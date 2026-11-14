package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Shape;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CropAspectRatio;", "", "title", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "aspectRatio", "Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "icons", "", "", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/Shape;Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getAspectRatio", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/AspectRatio;", "getIcons", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropAspectRatio {
    public static final int $stable = 0;
    private final AspectRatio aspectRatio;
    private final List<Integer> icons;
    private final Shape shape;
    private final String title;

    public CropAspectRatio(String title, Shape shape, AspectRatio aspectRatio, List<Integer> icons) {
        y.i(title, "title");
        y.i(shape, "shape");
        y.i(aspectRatio, "aspectRatio");
        y.i(icons, "icons");
        this.title = title;
        this.shape = shape;
        this.aspectRatio = aspectRatio;
        this.icons = icons;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CropAspectRatio copy$default(CropAspectRatio cropAspectRatio, String str, Shape shape, AspectRatio aspectRatio, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cropAspectRatio.title;
        }
        if ((i10 & 2) != 0) {
            shape = cropAspectRatio.shape;
        }
        if ((i10 & 4) != 0) {
            aspectRatio = cropAspectRatio.aspectRatio;
        }
        if ((i10 & 8) != 0) {
            list = cropAspectRatio.icons;
        }
        return cropAspectRatio.copy(str, shape, aspectRatio, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    public final List<Integer> component4() {
        return this.icons;
    }

    public final CropAspectRatio copy(String title, Shape shape, AspectRatio aspectRatio, List<Integer> icons) {
        y.i(title, "title");
        y.i(shape, "shape");
        y.i(aspectRatio, "aspectRatio");
        y.i(icons, "icons");
        return new CropAspectRatio(title, shape, aspectRatio, icons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropAspectRatio)) {
            return false;
        }
        CropAspectRatio cropAspectRatio = (CropAspectRatio) other;
        return y.d(this.title, cropAspectRatio.title) && y.d(this.shape, cropAspectRatio.shape) && y.d(this.aspectRatio, cropAspectRatio.aspectRatio) && y.d(this.icons, cropAspectRatio.icons);
    }

    public final AspectRatio getAspectRatio() {
        return this.aspectRatio;
    }

    public final List<Integer> getIcons() {
        return this.icons;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.shape.hashCode()) * 31) + this.aspectRatio.hashCode()) * 31) + this.icons.hashCode();
    }

    public String toString() {
        return "CropAspectRatio(title=" + this.title + ", shape=" + this.shape + ", aspectRatio=" + this.aspectRatio + ", icons=" + this.icons + ")";
    }

    public /* synthetic */ CropAspectRatio(String str, Shape shape, AspectRatio aspectRatio, List list, int i10, p pVar) {
        this(str, shape, (i10 & 4) != 0 ? AspectRatio.INSTANCE.getOriginal() : aspectRatio, (i10 & 8) != 0 ? w.n() : list);
    }
}
