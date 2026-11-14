package cu.z17.views.imageEditor.sections.cropper.components.model;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/z17/views/imageEditor/sections/cropper/components/model/CustomPathOutline;", "Lcu/z17/views/imageEditor/sections/cropper/components/model/CropPath;", "id", "", "title", "", "path", "Landroidx/compose/ui/graphics/Path;", "<init>", "(ILjava/lang/String;Landroidx/compose/ui/graphics/Path;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CustomPathOutline implements CropPath {
    public static final int $stable = 0;
    private final int id;
    private final Path path;
    private final String title;

    public CustomPathOutline(int i10, String title, Path path) {
        y.i(title, "title");
        y.i(path, "path");
        this.id = i10;
        this.title = title;
        this.path = path;
    }

    public static /* synthetic */ CustomPathOutline copy$default(CustomPathOutline customPathOutline, int i10, String str, Path path, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = customPathOutline.id;
        }
        if ((i11 & 2) != 0) {
            str = customPathOutline.title;
        }
        if ((i11 & 4) != 0) {
            path = customPathOutline.path;
        }
        return customPathOutline.copy(i10, str, path);
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
    public final Path getPath() {
        return this.path;
    }

    public final CustomPathOutline copy(int id2, String title, Path path) {
        y.i(title, "title");
        y.i(path, "path");
        return new CustomPathOutline(id2, title, path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomPathOutline)) {
            return false;
        }
        CustomPathOutline customPathOutline = (CustomPathOutline) other;
        return this.id == customPathOutline.id && y.d(this.title, customPathOutline.title) && y.d(this.path, customPathOutline.path);
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public int getId() {
        return this.id;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropPath
    public Path getPath() {
        return this.path;
    }

    @Override // cu.z17.views.imageEditor.sections.cropper.components.model.CropOutline
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.id * 31) + this.title.hashCode()) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "CustomPathOutline(id=" + this.id + ", title=" + this.title + ", path=" + this.path + ")";
    }
}
