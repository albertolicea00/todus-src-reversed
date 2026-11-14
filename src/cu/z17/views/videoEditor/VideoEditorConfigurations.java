package cu.z17.views.videoEditor;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/z17/views/videoEditor/VideoEditorConfigurations;", "", "allowCrop", "", "allowFilters", "forceCrop", "", "<init>", "(ZZJ)V", "getAllowCrop", "()Z", "getAllowFilters", "getForceCrop", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VideoEditorConfigurations {
    public static final int $stable = 0;
    private final boolean allowCrop;
    private final boolean allowFilters;
    private final long forceCrop;

    public VideoEditorConfigurations() {
        this(false, false, 0L, 7, null);
    }

    public static /* synthetic */ VideoEditorConfigurations copy$default(VideoEditorConfigurations videoEditorConfigurations, boolean z10, boolean z11, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = videoEditorConfigurations.allowCrop;
        }
        if ((i10 & 2) != 0) {
            z11 = videoEditorConfigurations.allowFilters;
        }
        if ((i10 & 4) != 0) {
            j10 = videoEditorConfigurations.forceCrop;
        }
        return videoEditorConfigurations.copy(z10, z11, j10);
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
    public final long getForceCrop() {
        return this.forceCrop;
    }

    public final VideoEditorConfigurations copy(boolean allowCrop, boolean allowFilters, long forceCrop) {
        return new VideoEditorConfigurations(allowCrop, allowFilters, forceCrop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoEditorConfigurations)) {
            return false;
        }
        VideoEditorConfigurations videoEditorConfigurations = (VideoEditorConfigurations) other;
        return this.allowCrop == videoEditorConfigurations.allowCrop && this.allowFilters == videoEditorConfigurations.allowFilters && this.forceCrop == videoEditorConfigurations.forceCrop;
    }

    public final boolean getAllowCrop() {
        return this.allowCrop;
    }

    public final boolean getAllowFilters() {
        return this.allowFilters;
    }

    public final long getForceCrop() {
        return this.forceCrop;
    }

    public int hashCode() {
        return (((androidx.camera.camera2.adapter.r.a(this.allowCrop) * 31) + androidx.camera.camera2.adapter.r.a(this.allowFilters)) * 31) + defpackage.l.a(this.forceCrop);
    }

    public String toString() {
        return "VideoEditorConfigurations(allowCrop=" + this.allowCrop + ", allowFilters=" + this.allowFilters + ", forceCrop=" + this.forceCrop + ")";
    }

    public VideoEditorConfigurations(boolean z10, boolean z11, long j10) {
        this.allowCrop = z10;
        this.allowFilters = z11;
        this.forceCrop = j10;
    }

    public /* synthetic */ VideoEditorConfigurations(boolean z10, boolean z11, long j10, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? Long.MAX_VALUE : j10);
    }
}
