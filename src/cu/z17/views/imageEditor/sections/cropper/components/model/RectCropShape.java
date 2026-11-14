package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/RectCropShape;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropShape;", "id", "", "title", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RectCropShape implements CropShape {
    public static final int $stable = 0;
    private final int id;
    private final Shape shape;
    private final String title;

    public RectCropShape(int i10, String title) {
        y.i(title, "title");
        this.id = i10;
        this.title = title;
        this.shape = RectangleShapeKt.getRectangleShape();
    }

    public static /* synthetic */ RectCropShape copy$default(RectCropShape rectCropShape, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = rectCropShape.id;
        }
        if ((i11 & 2) != 0) {
            str = rectCropShape.title;
        }
        return rectCropShape.copy(i10, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final RectCropShape copy(int id2, String title) {
        y.i(title, "title");
        return new RectCropShape(id2, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RectCropShape)) {
            return false;
        }
        RectCropShape rectCropShape = (RectCropShape) other;
        return this.id == rectCropShape.id && y.d(this.title, rectCropShape.title);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public int getId() {
        return this.id;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropShape
    public Shape getShape() {
        return this.shape;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.id * 31) + this.title.hashCode();
    }

    public String toString() {
        return "RectCropShape(id=" + this.id + ", title=" + this.title + ")";
    }
}
