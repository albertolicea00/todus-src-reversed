package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/ImageMaskOutline;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropImageMask;", "id", "", "title", "", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(ILjava/lang/String;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageMaskOutline implements CropImageMask {
    public static final int $stable = 0;
    private final int id;
    private final ImageBitmap image;
    private final String title;

    public ImageMaskOutline(int i10, String title, ImageBitmap image) {
        y.i(title, "title");
        y.i(image, "image");
        this.id = i10;
        this.title = title;
        this.image = image;
    }

    public static /* synthetic */ ImageMaskOutline copy$default(ImageMaskOutline imageMaskOutline, int i10, String str, ImageBitmap imageBitmap, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = imageMaskOutline.id;
        }
        if ((i11 & 2) != 0) {
            str = imageMaskOutline.title;
        }
        if ((i11 & 4) != 0) {
            imageBitmap = imageMaskOutline.image;
        }
        return imageMaskOutline.copy(i10, str, imageBitmap);
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
    public final ImageBitmap getImage() {
        return this.image;
    }

    public final ImageMaskOutline copy(int id2, String title, ImageBitmap image) {
        y.i(title, "title");
        y.i(image, "image");
        return new ImageMaskOutline(id2, title, image);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageMaskOutline)) {
            return false;
        }
        ImageMaskOutline imageMaskOutline = (ImageMaskOutline) other;
        return this.id == imageMaskOutline.id && y.d(this.title, imageMaskOutline.title) && y.d(this.image, imageMaskOutline.image);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public int getId() {
        return this.id;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropImageMask
    public ImageBitmap getImage() {
        return this.image;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.id * 31) + this.title.hashCode()) * 31) + this.image.hashCode();
    }

    public String toString() {
        return "ImageMaskOutline(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ")";
    }
}
