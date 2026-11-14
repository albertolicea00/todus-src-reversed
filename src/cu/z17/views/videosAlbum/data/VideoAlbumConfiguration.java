package cu.z17.views.videosAlbum.data;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcu/z17/views/videosAlbum/data/VideoAlbumConfiguration;", "", "multipleVideosAllowed", "", "<init>", "(Z)V", "getMultipleVideosAllowed", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VideoAlbumConfiguration {
    public static final int $stable = 0;
    private final boolean multipleVideosAllowed;

    public VideoAlbumConfiguration() {
        this(false, 1, null);
    }

    public static /* synthetic */ VideoAlbumConfiguration copy$default(VideoAlbumConfiguration videoAlbumConfiguration, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = videoAlbumConfiguration.multipleVideosAllowed;
        }
        return videoAlbumConfiguration.copy(z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMultipleVideosAllowed() {
        return this.multipleVideosAllowed;
    }

    public final VideoAlbumConfiguration copy(boolean multipleVideosAllowed) {
        return new VideoAlbumConfiguration(multipleVideosAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VideoAlbumConfiguration) && this.multipleVideosAllowed == ((VideoAlbumConfiguration) other).multipleVideosAllowed;
    }

    public final boolean getMultipleVideosAllowed() {
        return this.multipleVideosAllowed;
    }

    public int hashCode() {
        return r.a(this.multipleVideosAllowed);
    }

    public String toString() {
        return "VideoAlbumConfiguration(multipleVideosAllowed=" + this.multipleVideosAllowed + ")";
    }

    public VideoAlbumConfiguration(boolean z10) {
        this.multipleVideosAllowed = z10;
    }

    public /* synthetic */ VideoAlbumConfiguration(boolean z10, int i10, p pVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
