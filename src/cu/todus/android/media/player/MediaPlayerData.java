package cu.todus.android.media.player;

import android.net.Uri;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcu/todus/android/media/player/MediaPlayerData;", "", "uri", "Landroid/net/Uri;", "name", "", "mediaId", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "getName", "()Ljava/lang/String;", "getMediaId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MediaPlayerData {
    public static final int $stable = 0;
    private final String mediaId;
    private final String name;
    private final Uri uri;

    public MediaPlayerData(Uri uri, String name, String mediaId) {
        y.i(name, "name");
        y.i(mediaId, "mediaId");
        this.uri = uri;
        this.name = name;
        this.mediaId = mediaId;
    }

    public static /* synthetic */ MediaPlayerData copy$default(MediaPlayerData mediaPlayerData, Uri uri, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            uri = mediaPlayerData.uri;
        }
        if ((i10 & 2) != 0) {
            str = mediaPlayerData.name;
        }
        if ((i10 & 4) != 0) {
            str2 = mediaPlayerData.mediaId;
        }
        return mediaPlayerData.copy(uri, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    public final MediaPlayerData copy(Uri uri, String name, String mediaId) {
        y.i(name, "name");
        y.i(mediaId, "mediaId");
        return new MediaPlayerData(uri, name, mediaId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaPlayerData)) {
            return false;
        }
        MediaPlayerData mediaPlayerData = (MediaPlayerData) other;
        return y.d(this.uri, mediaPlayerData.uri) && y.d(this.name, mediaPlayerData.name) && y.d(this.mediaId, mediaPlayerData.mediaId);
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        Uri uri = this.uri;
        return ((((uri == null ? 0 : uri.hashCode()) * 31) + this.name.hashCode()) * 31) + this.mediaId.hashCode();
    }

    public String toString() {
        return "MediaPlayerData(uri=" + this.uri + ", name=" + this.name + ", mediaId=" + this.mediaId + ")";
    }
}
