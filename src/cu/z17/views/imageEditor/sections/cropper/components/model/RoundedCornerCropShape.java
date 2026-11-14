package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/RoundedCornerCropShape;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropShape;", "id", "", "title", "", "cornerRadius", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CornerRadiusProperties;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "<init>", "(ILjava/lang/String;Lcu/z17/views/imageEditor/sections/cropper/components/model/CornerRadiusProperties;Landroidx/compose/foundation/shape/RoundedCornerShape;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getCornerRadius", "()Lcu/z17/views/imageEditor/sections/cropper/components/model/CornerRadiusProperties;", "getShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RoundedCornerCropShape implements CropShape {
    public static final int $stable = 0;
    private final CornerRadiusProperties cornerRadius;
    private final int id;
    private final RoundedCornerShape shape;
    private final String title;

    public RoundedCornerCropShape(int i10, String title, CornerRadiusProperties cornerRadius, RoundedCornerShape shape) {
        y.i(title, "title");
        y.i(cornerRadius, "cornerRadius");
        y.i(shape, "shape");
        this.id = i10;
        this.title = title;
        this.cornerRadius = cornerRadius;
        this.shape = shape;
    }

    public static /* synthetic */ RoundedCornerCropShape copy$default(RoundedCornerCropShape roundedCornerCropShape, int i10, String str, CornerRadiusProperties cornerRadiusProperties, RoundedCornerShape roundedCornerShape, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = roundedCornerCropShape.id;
        }
        if ((i11 & 2) != 0) {
            str = roundedCornerCropShape.title;
        }
        if ((i11 & 4) != 0) {
            cornerRadiusProperties = roundedCornerCropShape.cornerRadius;
        }
        if ((i11 & 8) != 0) {
            roundedCornerShape = roundedCornerCropShape.shape;
        }
        return roundedCornerCropShape.copy(i10, str, cornerRadiusProperties, roundedCornerShape);
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
    public final CornerRadiusProperties getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RoundedCornerShape getShape() {
        return this.shape;
    }

    public final RoundedCornerCropShape copy(int id2, String title, CornerRadiusProperties cornerRadius, RoundedCornerShape shape) {
        y.i(title, "title");
        y.i(cornerRadius, "cornerRadius");
        y.i(shape, "shape");
        return new RoundedCornerCropShape(id2, title, cornerRadius, shape);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundedCornerCropShape)) {
            return false;
        }
        RoundedCornerCropShape roundedCornerCropShape = (RoundedCornerCropShape) other;
        return this.id == roundedCornerCropShape.id && y.d(this.title, roundedCornerCropShape.title) && y.d(this.cornerRadius, roundedCornerCropShape.cornerRadius) && y.d(this.shape, roundedCornerCropShape.shape);
    }

    public final CornerRadiusProperties getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public int getId() {
        return this.id;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.title.hashCode()) * 31) + this.cornerRadius.hashCode()) * 31) + this.shape.hashCode();
    }

    public String toString() {
        return "RoundedCornerCropShape(id=" + this.id + ", title=" + this.title + ", cornerRadius=" + this.cornerRadius + ", shape=" + this.shape + ")";
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropShape
    public RoundedCornerShape getShape() {
        return this.shape;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RoundedCornerCropShape(int i10, String str, CornerRadiusProperties cornerRadiusProperties, RoundedCornerShape roundedCornerShape, int i11, p pVar) {
        cornerRadiusProperties = (i11 & 4) != 0 ? new CornerRadiusProperties(0, 0, 0, 0, 15, null) : cornerRadiusProperties;
        this(i10, str, cornerRadiusProperties, (i11 & 8) != 0 ? RoundedCornerShapeKt.RoundedCornerShape(cornerRadiusProperties.getTopStartPercent(), cornerRadiusProperties.getTopEndPercent(), cornerRadiusProperties.getBottomEndPercent(), cornerRadiusProperties.getBottomStartPercent()) : roundedCornerShape);
    }
}
