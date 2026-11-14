package cu.z17.views.videoPlayer.uri;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.media3.datasource.AssetDataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.RawResourceDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import ua.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¨\u0006\u0005"}, d2 = {"toUri", "Landroid/net/Uri;", "Lcu/z17/views/videoPlayer/uri/VideoPlayerMediaItem;", "context", "Landroid/content/Context;", "views_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoPlayerMediaItemConverterKt {
    @SuppressLint({"UnsafeOptInUsageError"})
    public static final Uri toUri(VideoPlayerMediaItem videoPlayerMediaItem, Context context) {
        Uri uri;
        y.i(videoPlayerMediaItem, "<this>");
        y.i(context, "context");
        if (videoPlayerMediaItem instanceof VideoPlayerMediaItem.RawResourceMediaItem) {
            Uri uriBuildRawResourceUri = RawResourceDataSource.buildRawResourceUri(((VideoPlayerMediaItem.RawResourceMediaItem) videoPlayerMediaItem).getResourceId());
            y.f(uriBuildRawResourceUri);
            return uriBuildRawResourceUri;
        }
        if (videoPlayerMediaItem instanceof VideoPlayerMediaItem.AssetFileMediaItem) {
            DataSpec dataSpec = new DataSpec(Uri.parse("asset:///" + ((VideoPlayerMediaItem.AssetFileMediaItem) videoPlayerMediaItem).getAssetPath()));
            AssetDataSource assetDataSource = new AssetDataSource(context);
            try {
                assetDataSource.open(dataSpec);
            } catch (AssetDataSource.AssetDataSourceException e10) {
                e10.printStackTrace();
            }
            uri = assetDataSource.getUri();
            if (uri == null) {
                uri = Uri.EMPTY;
            }
            y.f(uri);
        } else {
            if (videoPlayerMediaItem instanceof VideoPlayerMediaItem.NetworkMediaItem) {
                Uri uri2 = Uri.parse(((VideoPlayerMediaItem.NetworkMediaItem) videoPlayerMediaItem).getUrl());
                y.f(uri2);
                return uri2;
            }
            if (!(videoPlayerMediaItem instanceof VideoPlayerMediaItem.StorageMediaItem)) {
                throw new r();
            }
            DataSpec dataSpec2 = new DataSpec(((VideoPlayerMediaItem.StorageMediaItem) videoPlayerMediaItem).getStorageUri());
            FileDataSource fileDataSource = new FileDataSource();
            try {
                fileDataSource.open(dataSpec2);
            } catch (FileDataSource.FileDataSourceException e11) {
                e11.printStackTrace();
            }
            uri = fileDataSource.getUri();
            if (uri == null) {
                uri = Uri.EMPTY;
            }
            y.f(uri);
        }
        return uri;
    }
}
