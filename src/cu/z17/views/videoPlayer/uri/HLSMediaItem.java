package cu.z17.views.videoPlayer.uri;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcu/z17/views/videoPlayer/uri/HLSMediaItem;", "", "url", "", "mediaMetadata", "Landroidx/media3/common/MediaMetadata;", "mimeType", "drmConfiguration", "Landroidx/media3/common/MediaItem$DrmConfiguration;", "itemUniqueId", "<init>", "(Ljava/lang/String;Landroidx/media3/common/MediaMetadata;Ljava/lang/String;Landroidx/media3/common/MediaItem$DrmConfiguration;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getMediaMetadata", "()Landroidx/media3/common/MediaMetadata;", "getMimeType", "getDrmConfiguration", "()Landroidx/media3/common/MediaItem$DrmConfiguration;", "getItemUniqueId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HLSMediaItem {
    public static final int $stable = 8;
    private final MediaItem.DrmConfiguration drmConfiguration;
    private final String itemUniqueId;
    private final MediaMetadata mediaMetadata;
    private final String mimeType;
    private final String url;

    public HLSMediaItem(String url, MediaMetadata mediaMetadata, String mimeType, MediaItem.DrmConfiguration drmConfiguration, String itemUniqueId) {
        y.i(url, "url");
        y.i(mediaMetadata, "mediaMetadata");
        y.i(mimeType, "mimeType");
        y.i(itemUniqueId, "itemUniqueId");
        this.url = url;
        this.mediaMetadata = mediaMetadata;
        this.mimeType = mimeType;
        this.drmConfiguration = drmConfiguration;
        this.itemUniqueId = itemUniqueId;
    }

    public static /* synthetic */ HLSMediaItem copy$default(HLSMediaItem hLSMediaItem, String str, MediaMetadata mediaMetadata, String str2, MediaItem.DrmConfiguration drmConfiguration, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hLSMediaItem.url;
        }
        if ((i10 & 2) != 0) {
            mediaMetadata = hLSMediaItem.mediaMetadata;
        }
        if ((i10 & 4) != 0) {
            str2 = hLSMediaItem.mimeType;
        }
        if ((i10 & 8) != 0) {
            drmConfiguration = hLSMediaItem.drmConfiguration;
        }
        if ((i10 & 16) != 0) {
            str3 = hLSMediaItem.itemUniqueId;
        }
        String str4 = str3;
        String str5 = str2;
        return hLSMediaItem.copy(str, mediaMetadata, str5, drmConfiguration, str4);
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getItemUniqueId() {
        return this.itemUniqueId;
    }

    public final HLSMediaItem copy(String url, MediaMetadata mediaMetadata, String mimeType, MediaItem.DrmConfiguration drmConfiguration, String itemUniqueId) {
        y.i(url, "url");
        y.i(mediaMetadata, "mediaMetadata");
        y.i(mimeType, "mimeType");
        y.i(itemUniqueId, "itemUniqueId");
        return new HLSMediaItem(url, mediaMetadata, mimeType, drmConfiguration, itemUniqueId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HLSMediaItem)) {
            return false;
        }
        HLSMediaItem hLSMediaItem = (HLSMediaItem) other;
        return y.d(this.url, hLSMediaItem.url) && y.d(this.mediaMetadata, hLSMediaItem.mediaMetadata) && y.d(this.mimeType, hLSMediaItem.mimeType) && y.d(this.drmConfiguration, hLSMediaItem.drmConfiguration) && y.d(this.itemUniqueId, hLSMediaItem.itemUniqueId);
    }

    public final MediaItem.DrmConfiguration getDrmConfiguration() {
        return this.drmConfiguration;
    }

    public final String getItemUniqueId() {
        return this.itemUniqueId;
    }

    public final MediaMetadata getMediaMetadata() {
        return this.mediaMetadata;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((((this.url.hashCode() * 31) + this.mediaMetadata.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
        MediaItem.DrmConfiguration drmConfiguration = this.drmConfiguration;
        return ((iHashCode + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31) + this.itemUniqueId.hashCode();
    }

    public String toString() {
        return "HLSMediaItem(url=" + this.url + ", mediaMetadata=" + this.mediaMetadata + ", mimeType=" + this.mimeType + ", drmConfiguration=" + this.drmConfiguration + ", itemUniqueId=" + this.itemUniqueId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HLSMediaItem(String str, MediaMetadata EMPTY, String str2, MediaItem.DrmConfiguration drmConfiguration, String str3, int i10, p pVar) {
        if ((i10 & 2) != 0) {
            EMPTY = MediaMetadata.EMPTY;
            y.h(EMPTY, "EMPTY");
        }
        this(str, EMPTY, (i10 & 4) != 0 ? MimeTypes.APPLICATION_M3U8 : str2, (i10 & 8) != 0 ? null : drmConfiguration, (i10 & 16) != 0 ? "" : str3);
    }
}
