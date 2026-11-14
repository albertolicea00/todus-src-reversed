package cu.z17.views.imageEditor;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcu/z17/views/imageEditor/ImageEditorConfigurations;", "", "allowCrop", "", "allowFilters", "allowText", "allowRotate", "allowLowerSize", "<init>", "(ZZZZZ)V", "getAllowCrop", "()Z", "getAllowFilters", "getAllowText", "getAllowRotate", "getAllowLowerSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageEditorConfigurations {
    public static final int $stable = 0;
    private final boolean allowCrop;
    private final boolean allowFilters;
    private final boolean allowLowerSize;
    private final boolean allowRotate;
    private final boolean allowText;

    public ImageEditorConfigurations() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ ImageEditorConfigurations copy$default(ImageEditorConfigurations imageEditorConfigurations, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = imageEditorConfigurations.allowCrop;
        }
        if ((i10 & 2) != 0) {
            z11 = imageEditorConfigurations.allowFilters;
        }
        if ((i10 & 4) != 0) {
            z12 = imageEditorConfigurations.allowText;
        }
        if ((i10 & 8) != 0) {
            z13 = imageEditorConfigurations.allowRotate;
        }
        if ((i10 & 16) != 0) {
            z14 = imageEditorConfigurations.allowLowerSize;
        }
        boolean z15 = z14;
        boolean z16 = z12;
        return imageEditorConfigurations.copy(z10, z11, z16, z13, z15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAllowCrop() {
        return this.allowCrop;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAllowFilters() {
        return this.allowFilters;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAllowText() {
        return this.allowText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAllowRotate() {
        return this.allowRotate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAllowLowerSize() {
        return this.allowLowerSize;
    }

    public final ImageEditorConfigurations copy(boolean allowCrop, boolean allowFilters, boolean allowText, boolean allowRotate, boolean allowLowerSize) {
        return new ImageEditorConfigurations(allowCrop, allowFilters, allowText, allowRotate, allowLowerSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageEditorConfigurations)) {
            return false;
        }
        ImageEditorConfigurations imageEditorConfigurations = (ImageEditorConfigurations) other;
        return this.allowCrop == imageEditorConfigurations.allowCrop && this.allowFilters == imageEditorConfigurations.allowFilters && this.allowText == imageEditorConfigurations.allowText && this.allowRotate == imageEditorConfigurations.allowRotate && this.allowLowerSize == imageEditorConfigurations.allowLowerSize;
    }

    public final boolean getAllowCrop() {
        return this.allowCrop;
    }

    public final boolean getAllowFilters() {
        return this.allowFilters;
    }

    public final boolean getAllowLowerSize() {
        return this.allowLowerSize;
    }

    public final boolean getAllowRotate() {
        return this.allowRotate;
    }

    public final boolean getAllowText() {
        return this.allowText;
    }

    public int hashCode() {
        return (((((((androidx.camera.camera2.adapter.r.a(this.allowCrop) * 31) + androidx.camera.camera2.adapter.r.a(this.allowFilters)) * 31) + androidx.camera.camera2.adapter.r.a(this.allowText)) * 31) + androidx.camera.camera2.adapter.r.a(this.allowRotate)) * 31) + androidx.camera.camera2.adapter.r.a(this.allowLowerSize);
    }

    public String toString() {
        return "ImageEditorConfigurations(allowCrop=" + this.allowCrop + ", allowFilters=" + this.allowFilters + ", allowText=" + this.allowText + ", allowRotate=" + this.allowRotate + ", allowLowerSize=" + this.allowLowerSize + ")";
    }

    public ImageEditorConfigurations(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.allowCrop = z10;
        this.allowFilters = z11;
        this.allowText = z12;
        this.allowRotate = z13;
        this.allowLowerSize = z14;
    }

    public /* synthetic */ ImageEditorConfigurations(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? true : z13, (i10 & 16) != 0 ? true : z14);
    }
}
