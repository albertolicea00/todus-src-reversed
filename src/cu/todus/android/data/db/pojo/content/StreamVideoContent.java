package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcu/todus/android/data/db/pojo/content/StreamVideoContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "getUrl", "", "streamUrl", "downloadUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGetUrl", "()Ljava/lang/String;", "getStreamUrl", "getDownloadUrl", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StreamVideoContent extends Content {
    public static final int $stable = 0;
    private final String downloadUrl;
    private final String getUrl;
    private final String streamUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamVideoContent(String getUrl, String streamUrl, String downloadUrl) {
        super(31);
        y.i(getUrl, "getUrl");
        y.i(streamUrl, "streamUrl");
        y.i(downloadUrl, "downloadUrl");
        this.getUrl = getUrl;
        this.streamUrl = streamUrl;
        this.downloadUrl = downloadUrl;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getGetUrl() {
        return this.getUrl;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }
}
