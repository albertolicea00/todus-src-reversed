package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ`\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0082\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/db/pojo/content/VideoContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "thumbnail", "", TypedValues.TransitionType.S_DURATION, "", "width", "height", "name", "path", "url", "size", "hash", "<init>", "(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getThumbnail", "()Ljava/lang/String;", "getDuration", "()J", "getWidth", "getHeight", "rebuild", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class VideoContent extends FileContent {
    public static final int $stable = 0;
    private final long duration;
    private final long height;
    private final String thumbnail;
    private final long width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoContent(String thumbnail, long j10, long j11, long j12, String name, String path, String url, long j13, String hash) {
        super(name, path, url, j13, hash, 2);
        y.i(thumbnail, "thumbnail");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.thumbnail = thumbnail;
        this.duration = j10;
        this.width = j11;
        this.height = j12;
    }

    public static /* synthetic */ VideoContent rebuild$default(VideoContent videoContent, String str, long j10, long j11, long j12, String str2, String str3, String str4, long j13, String str5, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rebuild");
        }
        if ((i10 & 1) != 0) {
            str = videoContent.thumbnail;
        }
        return videoContent.rebuild(str, (i10 & 2) != 0 ? videoContent.duration : j10, (i10 & 4) != 0 ? videoContent.width : j11, (i10 & 8) != 0 ? videoContent.height : j12, (i10 & 16) != 0 ? videoContent.getName() : str2, (i10 & 32) != 0 ? videoContent.getPath() : str3, (i10 & 64) != 0 ? videoContent.getUrl() : str4, (i10 & 128) != 0 ? videoContent.getSize() : j13, (i10 & 256) != 0 ? videoContent.getHash() : str5);
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoContent) || !super.equals(other)) {
            return false;
        }
        VideoContent videoContent = (VideoContent) other;
        return y.d(this.thumbnail, videoContent.thumbnail) && this.duration == videoContent.duration;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getWidth() {
        return this.width;
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public int hashCode() {
        return (((super.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + l.a(this.duration);
    }

    public final VideoContent rebuild(String thumbnail, long duration, long width, long height, String name, String path, String url, long size, String hash) {
        y.i(thumbnail, "thumbnail");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new VideoContent(thumbnail, duration, width, height, name, path, url, size, hash);
    }

    public /* synthetic */ VideoContent(String str, long j10, long j11, long j12, String str2, String str3, String str4, long j13, String str5, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) != 0 ? 0L : j11, (i10 & 8) == 0 ? j12 : 0L, (i10 & 16) != 0 ? "" : str2, (i10 & 32) != 0 ? "" : str3, (i10 & 64) != 0 ? "" : str4, j13, (i10 & 256) != 0 ? "" : str5);
    }
}
