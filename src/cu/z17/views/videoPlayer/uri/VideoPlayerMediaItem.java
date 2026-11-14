package cu.z17.views.videoPlayer.uri;

import android.net.Uri;
import androidx.annotation.RawRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "Lcu/z17/views/videoPlayer/uri/BaseVideoPlayerMediaItem;", "RawResourceMediaItem", "AssetFileMediaItem", "StorageMediaItem", "NetworkMediaItem", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$AssetFileMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$NetworkMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$RawResourceMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$StorageMediaItem;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VideoPlayerMediaItem extends BaseVideoPlayerMediaItem {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$AssetFileMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "assetPath", "", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "mimeType", "<init>", "(Ljava/lang/String;Landroidx/media3/common/MediaMetadata;Ljava/lang/String;)V", "getAssetPath", "()Ljava/lang/String;", "getMediaMetadata", "()Landroidx/media3/common/MediaMetadata;", "getMimeType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AssetFileMediaItem implements VideoPlayerMediaItem {
        public static final int $stable = 8;
        private final String assetPath;
        private final MediaMetadata mediaMetadata;
        private final String mimeType;

        public AssetFileMediaItem(String assetPath, MediaMetadata mediaMetadata, String mimeType) {
            y.i(assetPath, "assetPath");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            this.assetPath = assetPath;
            this.mediaMetadata = mediaMetadata;
            this.mimeType = mimeType;
        }

        public static /* synthetic */ AssetFileMediaItem copy$default(AssetFileMediaItem assetFileMediaItem, String str, MediaMetadata mediaMetadata, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = assetFileMediaItem.assetPath;
            }
            if ((i10 & 2) != 0) {
                mediaMetadata = assetFileMediaItem.mediaMetadata;
            }
            if ((i10 & 4) != 0) {
                str2 = assetFileMediaItem.mimeType;
            }
            return assetFileMediaItem.copy(str, mediaMetadata, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAssetPath() {
            return this.assetPath;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final AssetFileMediaItem copy(String assetPath, MediaMetadata mediaMetadata, String mimeType) {
            y.i(assetPath, "assetPath");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            return new AssetFileMediaItem(assetPath, mediaMetadata, mimeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssetFileMediaItem)) {
                return false;
            }
            AssetFileMediaItem assetFileMediaItem = (AssetFileMediaItem) other;
            return y.d(this.assetPath, assetFileMediaItem.assetPath) && y.d(this.mediaMetadata, assetFileMediaItem.mediaMetadata) && y.d(this.mimeType, assetFileMediaItem.mimeType);
        }

        public final String getAssetPath() {
            return this.assetPath;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public String getMimeType() {
            return this.mimeType;
        }

        public int hashCode() {
            return (((this.assetPath.hashCode() * 31) + this.mediaMetadata.hashCode()) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "AssetFileMediaItem(assetPath=" + this.assetPath + ", mediaMetadata=" + this.mediaMetadata + ", mimeType=" + this.mimeType + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ AssetFileMediaItem(String str, MediaMetadata EMPTY, String str2, int i10, p pVar) {
            if ((i10 & 2) != 0) {
                EMPTY = MediaMetadata.EMPTY;
                y.h(EMPTY, "EMPTY");
            }
            this(str, EMPTY, (i10 & 4) != 0 ? "" : str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$RawResourceMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "resourceId", "", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "mimeType", "", "<init>", "(ILandroidx/media3/common/MediaMetadata;Ljava/lang/String;)V", "getResourceId", "()I", "getMediaMetadata", "()Landroidx/media3/common/MediaMetadata;", "getMimeType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RawResourceMediaItem implements VideoPlayerMediaItem {
        public static final int $stable = 8;
        private final MediaMetadata mediaMetadata;
        private final String mimeType;
        private final int resourceId;

        public RawResourceMediaItem(@RawRes int i10, MediaMetadata mediaMetadata, String mimeType) {
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            this.resourceId = i10;
            this.mediaMetadata = mediaMetadata;
            this.mimeType = mimeType;
        }

        public static /* synthetic */ RawResourceMediaItem copy$default(RawResourceMediaItem rawResourceMediaItem, int i10, MediaMetadata mediaMetadata, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = rawResourceMediaItem.resourceId;
            }
            if ((i11 & 2) != 0) {
                mediaMetadata = rawResourceMediaItem.mediaMetadata;
            }
            if ((i11 & 4) != 0) {
                str = rawResourceMediaItem.mimeType;
            }
            return rawResourceMediaItem.copy(i10, mediaMetadata, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final RawResourceMediaItem copy(@RawRes int resourceId, MediaMetadata mediaMetadata, String mimeType) {
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            return new RawResourceMediaItem(resourceId, mediaMetadata, mimeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RawResourceMediaItem)) {
                return false;
            }
            RawResourceMediaItem rawResourceMediaItem = (RawResourceMediaItem) other;
            return this.resourceId == rawResourceMediaItem.resourceId && y.d(this.mediaMetadata, rawResourceMediaItem.mediaMetadata) && y.d(this.mimeType, rawResourceMediaItem.mimeType);
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public String getMimeType() {
            return this.mimeType;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public int hashCode() {
            return (((this.resourceId * 31) + this.mediaMetadata.hashCode()) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "RawResourceMediaItem(resourceId=" + this.resourceId + ", mediaMetadata=" + this.mediaMetadata + ", mimeType=" + this.mimeType + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ RawResourceMediaItem(int i10, MediaMetadata EMPTY, String str, int i11, p pVar) {
            if ((i11 & 2) != 0) {
                EMPTY = MediaMetadata.EMPTY;
                y.h(EMPTY, "EMPTY");
            }
            this(i10, EMPTY, (i11 & 4) != 0 ? "" : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$StorageMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "storageUri", "Landroid/net/Uri;", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "mimeType", "", "<init>", "(Landroid/net/Uri;Landroidx/media3/common/MediaMetadata;Ljava/lang/String;)V", "getStorageUri", "()Landroid/net/Uri;", "getMediaMetadata", "()Landroidx/media3/common/MediaMetadata;", "getMimeType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StorageMediaItem implements VideoPlayerMediaItem {
        public static final int $stable = 8;
        private final MediaMetadata mediaMetadata;
        private final String mimeType;
        private final Uri storageUri;

        public StorageMediaItem(Uri storageUri, MediaMetadata mediaMetadata, String mimeType) {
            y.i(storageUri, "storageUri");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            this.storageUri = storageUri;
            this.mediaMetadata = mediaMetadata;
            this.mimeType = mimeType;
        }

        public static /* synthetic */ StorageMediaItem copy$default(StorageMediaItem storageMediaItem, Uri uri, MediaMetadata mediaMetadata, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                uri = storageMediaItem.storageUri;
            }
            if ((i10 & 2) != 0) {
                mediaMetadata = storageMediaItem.mediaMetadata;
            }
            if ((i10 & 4) != 0) {
                str = storageMediaItem.mimeType;
            }
            return storageMediaItem.copy(uri, mediaMetadata, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getStorageUri() {
            return this.storageUri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final StorageMediaItem copy(Uri storageUri, MediaMetadata mediaMetadata, String mimeType) {
            y.i(storageUri, "storageUri");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            return new StorageMediaItem(storageUri, mediaMetadata, mimeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StorageMediaItem)) {
                return false;
            }
            StorageMediaItem storageMediaItem = (StorageMediaItem) other;
            return y.d(this.storageUri, storageMediaItem.storageUri) && y.d(this.mediaMetadata, storageMediaItem.mediaMetadata) && y.d(this.mimeType, storageMediaItem.mimeType);
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public String getMimeType() {
            return this.mimeType;
        }

        public final Uri getStorageUri() {
            return this.storageUri;
        }

        public int hashCode() {
            return (((this.storageUri.hashCode() * 31) + this.mediaMetadata.hashCode()) * 31) + this.mimeType.hashCode();
        }

        public String toString() {
            return "StorageMediaItem(storageUri=" + this.storageUri + ", mediaMetadata=" + this.mediaMetadata + ", mimeType=" + this.mimeType + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ StorageMediaItem(Uri uri, MediaMetadata EMPTY, String str, int i10, p pVar) {
            if ((i10 & 2) != 0) {
                EMPTY = MediaMetadata.EMPTY;
                y.h(EMPTY, "EMPTY");
            }
            this(uri, EMPTY, (i10 & 4) != 0 ? "" : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem$NetworkMediaItem;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "url", "", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "mimeType", "drmConfiguration", "Landroidx/media3/common/MediaItem$DrmConfiguration;", "<init>", "(Ljava/lang/String;Landroidx/media3/common/MediaMetadata;Ljava/lang/String;Landroidx/media3/common/MediaItem$DrmConfiguration;)V", "getUrl", "()Ljava/lang/String;", "getMediaMetadata", "()Landroidx/media3/common/MediaMetadata;", "getMimeType", "getDrmConfiguration", "()Landroidx/media3/common/MediaItem$DrmConfiguration;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NetworkMediaItem implements VideoPlayerMediaItem {
        public static final int $stable = 8;
        private final MediaItem.DrmConfiguration drmConfiguration;
        private final MediaMetadata mediaMetadata;
        private final String mimeType;
        private final String url;

        public NetworkMediaItem(String url, MediaMetadata mediaMetadata, String mimeType, MediaItem.DrmConfiguration drmConfiguration) {
            y.i(url, "url");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            this.url = url;
            this.mediaMetadata = mediaMetadata;
            this.mimeType = mimeType;
            this.drmConfiguration = drmConfiguration;
        }

        public static /* synthetic */ NetworkMediaItem copy$default(NetworkMediaItem networkMediaItem, String str, MediaMetadata mediaMetadata, String str2, MediaItem.DrmConfiguration drmConfiguration, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = networkMediaItem.url;
            }
            if ((i10 & 2) != 0) {
                mediaMetadata = networkMediaItem.mediaMetadata;
            }
            if ((i10 & 4) != 0) {
                str2 = networkMediaItem.mimeType;
            }
            if ((i10 & 8) != 0) {
                drmConfiguration = networkMediaItem.drmConfiguration;
            }
            return networkMediaItem.copy(str, mediaMetadata, str2, drmConfiguration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MediaItem.DrmConfiguration getDrmConfiguration() {
            return this.drmConfiguration;
        }

        public final NetworkMediaItem copy(String url, MediaMetadata mediaMetadata, String mimeType, MediaItem.DrmConfiguration drmConfiguration) {
            y.i(url, "url");
            y.i(mediaMetadata, "mediaMetadata");
            y.i(mimeType, "mimeType");
            return new NetworkMediaItem(url, mediaMetadata, mimeType, drmConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkMediaItem)) {
                return false;
            }
            NetworkMediaItem networkMediaItem = (NetworkMediaItem) other;
            return y.d(this.url, networkMediaItem.url) && y.d(this.mediaMetadata, networkMediaItem.mediaMetadata) && y.d(this.mimeType, networkMediaItem.mimeType) && y.d(this.drmConfiguration, networkMediaItem.drmConfiguration);
        }

        public final MediaItem.DrmConfiguration getDrmConfiguration() {
            return this.drmConfiguration;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public MediaMetadata getMediaMetadata() {
            return this.mediaMetadata;
        }

        @Override // cu.z17.views.videoPlayer.uri.BaseVideoPlayerMediaItem
        public String getMimeType() {
            return this.mimeType;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = ((((this.url.hashCode() * 31) + this.mediaMetadata.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
            MediaItem.DrmConfiguration drmConfiguration = this.drmConfiguration;
            return iHashCode + (drmConfiguration == null ? 0 : drmConfiguration.hashCode());
        }

        public String toString() {
            return "NetworkMediaItem(url=" + this.url + ", mediaMetadata=" + this.mediaMetadata + ", mimeType=" + this.mimeType + ", drmConfiguration=" + this.drmConfiguration + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ NetworkMediaItem(String str, MediaMetadata EMPTY, String str2, MediaItem.DrmConfiguration drmConfiguration, int i10, p pVar) {
            if ((i10 & 2) != 0) {
                EMPTY = MediaMetadata.EMPTY;
                y.h(EMPTY, "EMPTY");
            }
            this(str, EMPTY, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? null : drmConfiguration);
        }
    }
}
