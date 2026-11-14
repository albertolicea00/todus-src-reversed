package cu.todus.android.data.db.pojo.content.statusContent;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.pojo.content.FileContent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ`\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcu/todus/android/data/db/pojo/content/statusContent/StatusImageContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "thumbnail", "", "width", "", "height", "textContent", "name", "path", "url", "size", "hash", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getThumbnail", "()Ljava/lang/String;", "getWidth", "()J", "getHeight", "getTextContent", "rebuild", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusImageContent extends FileContent {
    public static final int $stable = 0;
    private final long height;
    private final String textContent;
    private final String thumbnail;
    private final long width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusImageContent(String thumbnail, long j10, long j11, String textContent, String name, String path, String url, long j12, String hash) {
        super(name, path, url, j12, hash, 27);
        y.i(thumbnail, "thumbnail");
        y.i(textContent, "textContent");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.thumbnail = thumbnail;
        this.width = j10;
        this.height = j11;
        this.textContent = textContent;
    }

    public static /* synthetic */ StatusImageContent rebuild$default(StatusImageContent statusImageContent, String str, long j10, long j11, String str2, String str3, String str4, String str5, long j12, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = statusImageContent.thumbnail;
        }
        if ((i10 & 2) != 0) {
            j10 = statusImageContent.width;
        }
        if ((i10 & 4) != 0) {
            j11 = statusImageContent.height;
        }
        if ((i10 & 8) != 0) {
            str2 = statusImageContent.textContent;
        }
        if ((i10 & 16) != 0) {
            str3 = statusImageContent.getName();
        }
        if ((i10 & 32) != 0) {
            str4 = statusImageContent.getPath();
        }
        if ((i10 & 64) != 0) {
            str5 = statusImageContent.getUrl();
        }
        if ((i10 & 128) != 0) {
            j12 = statusImageContent.getSize();
        }
        if ((i10 & 256) != 0) {
            str6 = statusImageContent.getHash();
        }
        String str7 = str6;
        long j13 = j12;
        long j14 = j11;
        return statusImageContent.rebuild(str, j10, j14, str2, str3, str4, str5, j13, str7);
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getWidth() {
        return this.width;
    }

    public final StatusImageContent rebuild(String thumbnail, long width, long height, String textContent, String name, String path, String url, long size, String hash) {
        y.i(thumbnail, "thumbnail");
        y.i(textContent, "textContent");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new StatusImageContent(thumbnail, width, height, textContent, name, path, url, size, hash);
    }

    public /* synthetic */ StatusImageContent(String str, long j10, long j11, String str2, String str3, String str4, String str5, long j12, String str6, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) == 0 ? j11 : 0L, (i10 & 8) != 0 ? "" : str2, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? "" : str5, j12, (i10 & 256) != 0 ? "" : str6);
    }
}
