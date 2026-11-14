package cu.todus.android.data.db.pojo.content.statusContent;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.pojo.content.FileContent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jj\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/content/statusContent/StatusVideoContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "thumbnail", "", TypedValues.TransitionType.S_DURATION, "", "textContent", "wasProcessed", "", "streamUrl", "name", "path", "url", "size", "hash", "<init>", "(Ljava/lang/String;JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getThumbnail", "()Ljava/lang/String;", "getDuration", "()J", "getTextContent", "getWasProcessed", "()Z", "getStreamUrl", "rebuild", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusVideoContent extends FileContent {
    public static final int $stable = 0;
    private final long duration;
    private final String streamUrl;
    private final String textContent;
    private final String thumbnail;
    private final boolean wasProcessed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusVideoContent(String thumbnail, long j10, String textContent, boolean z10, String streamUrl, String name, String path, String url, long j11, String hash) {
        super(name, path, url, j11, hash, 30);
        y.i(thumbnail, "thumbnail");
        y.i(textContent, "textContent");
        y.i(streamUrl, "streamUrl");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.thumbnail = thumbnail;
        this.duration = j10;
        this.textContent = textContent;
        this.wasProcessed = z10;
        this.streamUrl = streamUrl;
    }

    public static /* synthetic */ StatusVideoContent rebuild$default(StatusVideoContent statusVideoContent, String str, long j10, String str2, boolean z10, String str3, String str4, String str5, String str6, long j11, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = statusVideoContent.thumbnail;
        }
        if ((i10 & 2) != 0) {
            j10 = statusVideoContent.duration;
        }
        if ((i10 & 4) != 0) {
            str2 = statusVideoContent.textContent;
        }
        if ((i10 & 8) != 0) {
            z10 = statusVideoContent.wasProcessed;
        }
        if ((i10 & 16) != 0) {
            str3 = statusVideoContent.streamUrl;
        }
        if ((i10 & 32) != 0) {
            str4 = statusVideoContent.getName();
        }
        if ((i10 & 64) != 0) {
            str5 = statusVideoContent.getPath();
        }
        if ((i10 & 128) != 0) {
            str6 = statusVideoContent.getUrl();
        }
        if ((i10 & 256) != 0) {
            j11 = statusVideoContent.getSize();
        }
        if ((i10 & 512) != 0) {
            str7 = statusVideoContent.getHash();
        }
        String str8 = str7;
        long j12 = j11;
        String str9 = str5;
        String str10 = str6;
        return statusVideoContent.rebuild(str, j10, str2, z10, str3, str4, str9, str10, j12, str8);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final boolean getWasProcessed() {
        return this.wasProcessed;
    }

    public final StatusVideoContent rebuild(String thumbnail, long duration, String textContent, boolean wasProcessed, String streamUrl, String name, String path, String url, long size, String hash) {
        y.i(thumbnail, "thumbnail");
        y.i(textContent, "textContent");
        y.i(streamUrl, "streamUrl");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new StatusVideoContent(thumbnail, duration, textContent, wasProcessed, streamUrl, name, path, url, size, hash);
    }

    public /* synthetic */ StatusVideoContent(String str, long j10, String str2, boolean z10, String str3, String str4, String str5, String str6, long j11, String str7, int i10, p pVar) {
        this(str, j10, str2, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? "" : str5, (i10 & 128) != 0 ? "" : str6, j11, (i10 & 512) != 0 ? "" : str7);
    }
}
