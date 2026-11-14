package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalCropShape;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropShape;", "id", "", "title", "", "ovalProperties", "Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(ILjava/lang/String;Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalProperties;Landroidx/compose/ui/graphics/Shape;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getOvalProperties", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/OvalProperties;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OvalCropShape implements CropShape {
    public static final int $stable = 0;
    private final int id;
    private final OvalProperties ovalProperties;
    private final Shape shape;
    private final String title;

    public OvalCropShape(int i10, String title, OvalProperties ovalProperties, Shape shape) {
        y.i(title, "title");
        y.i(ovalProperties, "ovalProperties");
        y.i(shape, "shape");
        this.id = i10;
        this.title = title;
        this.ovalProperties = ovalProperties;
        this.shape = shape;
    }

    public static /* synthetic */ OvalCropShape copy$default(OvalCropShape ovalCropShape, int i10, String str, OvalProperties ovalProperties, Shape shape, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = ovalCropShape.id;
        }
        if ((i11 & 2) != 0) {
            str = ovalCropShape.title;
        }
        if ((i11 & 4) != 0) {
            ovalProperties = ovalCropShape.ovalProperties;
        }
        if ((i11 & 8) != 0) {
            shape = ovalCropShape.shape;
        }
        return ovalCropShape.copy(i10, str, ovalProperties, shape);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OvalProperties getOvalProperties() {
        return this.ovalProperties;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    public final OvalCropShape copy(int id2, String title, OvalProperties ovalProperties, Shape shape) {
        y.i(title, "title");
        y.i(ovalProperties, "ovalProperties");
        y.i(shape, "shape");
        return new OvalCropShape(id2, title, ovalProperties, shape);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OvalCropShape)) {
            return false;
        }
        OvalCropShape ovalCropShape = (OvalCropShape) other;
        return this.id == ovalCropShape.id && y.d(this.title, ovalCropShape.title) && y.d(this.ovalProperties, ovalCropShape.ovalProperties) && y.d(this.shape, ovalCropShape.shape);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public int getId() {
        return this.id;
    }

    public final OvalProperties getOvalProperties() {
        return this.ovalProperties;
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
        return (((((this.id * 31) + this.title.hashCode()) * 31) + this.ovalProperties.hashCode()) * 31) + this.shape.hashCode();
    }

    public String toString() {
        return "OvalCropShape(id=" + this.id + ", title=" + this.title + ", ovalProperties=" + this.ovalProperties + ", shape=" + this.shape + ")";
    }

    public /* synthetic */ OvalCropShape(int i10, String str, OvalProperties ovalProperties, Shape shape, int i11, p pVar) {
        this(i10, str, (i11 & 4) != 0 ? new OvalProperties(0.0f, 0.0f, 0L, 7, null) : ovalProperties, (i11 & 8) != 0 ? RoundedCornerShapeKt.getCircleShape() : shape);
    }
}
