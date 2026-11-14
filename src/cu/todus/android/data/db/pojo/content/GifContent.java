package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJV\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0082\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/content/GifContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "thumbnail", "", "width", "", "height", "name", "path", "url", "size", "hash", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getThumbnail", "()Ljava/lang/String;", "getWidth", "()J", "getHeight", "rebuild", "equals", "", "other", "", "hashCode", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GifContent extends FileContent {
    public static final int $stable = 0;
    private final long height;
    private final String thumbnail;
    private final long width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifContent(String thumbnail, long j10, long j11, String name, String path, String url, long j12, String hash) {
        super(name, path, url, j12, hash, 7);
        y.i(thumbnail, "thumbnail");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.thumbnail = thumbnail;
        this.width = j10;
        this.height = j11;
    }

    public static /* synthetic */ GifContent rebuild$default(GifContent gifContent, String str, long j10, long j11, String str2, String str3, String str4, long j12, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = gifContent.thumbnail;
        }
        if ((i10 & 2) != 0) {
            j10 = gifContent.width;
        }
        if ((i10 & 4) != 0) {
            j11 = gifContent.height;
        }
        if ((i10 & 8) != 0) {
            str2 = gifContent.getName();
        }
        if ((i10 & 16) != 0) {
            str3 = gifContent.getPath();
        }
        if ((i10 & 32) != 0) {
            str4 = gifContent.getUrl();
        }
        if ((i10 & 64) != 0) {
            j12 = gifContent.getSize();
        }
        if ((i10 & 128) != 0) {
            str5 = gifContent.getHash();
        }
        String str6 = str5;
        String str7 = str4;
        String str8 = str2;
        long j13 = j11;
        return gifContent.rebuild(str, j10, j13, str8, str3, str7, j12, str6);
    }

    @Override // cu.todus.android.data.db.pojo.content.FileContent
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifContent) || !super.equals(other)) {
            return false;
        }
        GifContent gifContent = (GifContent) other;
        return y.d(this.thumbnail, gifContent.thumbnail) && this.width == gifContent.width && this.height == gifContent.height;
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
        return (((((super.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + l.a(this.width)) * 31) + l.a(this.height);
    }

    public final GifContent rebuild(String thumbnail, long width, long height, String name, String path, String url, long size, String hash) {
        y.i(thumbnail, "thumbnail");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new GifContent(thumbnail, width, height, name, path, url, size, hash);
    }

    public /* synthetic */ GifContent(String str, long j10, long j11, String str2, String str3, String str4, long j12, String str5, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) == 0 ? j11 : 0L, (i10 & 8) != 0 ? "" : str2, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, j12, (i10 & 128) != 0 ? "" : str5);
    }
}
