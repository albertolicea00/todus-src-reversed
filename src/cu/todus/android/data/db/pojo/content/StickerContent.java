package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.constants.Service;
import cu.todus.android.data.preferences.RootEnvironment;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJL\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\n\u0010\u0012\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/db/pojo/content/StickerContent;", "Lcu/todus/android/data/db/pojo/content/FileContent;", "folder", "", ExtensionSticker.TAG_JSON, "name", "path", "url", "size", "", "hash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getFolder", "()Ljava/lang/String;", "getJson", "rebuild", "urlFile", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StickerContent extends FileContent {
    public static final int $stable = 0;
    private final String folder;
    private final String json;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerContent(String folder, String json, String name, String path, String url, long j10, String hash) {
        super(name, path, url, j10, hash, 13);
        y.i(folder, "folder");
        y.i(json, "json");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.folder = folder;
        this.json = json;
    }

    public static /* synthetic */ StickerContent rebuild$default(StickerContent stickerContent, String str, String str2, String str3, String str4, String str5, long j10, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = stickerContent.folder;
        }
        if ((i10 & 2) != 0) {
            str2 = stickerContent.json;
        }
        if ((i10 & 4) != 0) {
            str3 = stickerContent.getName();
        }
        if ((i10 & 8) != 0) {
            str4 = stickerContent.getPath();
        }
        if ((i10 & 16) != 0) {
            str5 = stickerContent.getUrl();
        }
        if ((i10 & 32) != 0) {
            j10 = stickerContent.getSize();
        }
        if ((i10 & 64) != 0) {
            str6 = stickerContent.getHash();
        }
        String str7 = str6;
        long j11 = j10;
        String str8 = str5;
        String str9 = str3;
        return stickerContent.rebuild(str, str2, str9, str4, str8, j11, str7);
    }

    public final String getFolder() {
        return this.folder;
    }

    public final String getJson() {
        return this.json;
    }

    public final StickerContent rebuild(String folder, String json, String name, String path, String url, long size, String hash) {
        y.i(folder, "folder");
        y.i(json, "json");
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new StickerContent(folder, json, name, path, url, size, hash);
    }

    public String toString() {
        return getName() + " " + getPath() + " " + this.json;
    }

    public final String urlFile() {
        Service.ApplicationEnvironment applicationEnvironment;
        RootEnvironment rootEnvironment;
        Service service = Service.INSTANCE;
        AppVolatileState instanceOrNull = AppVolatileState.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (rootEnvironment = instanceOrNull.getRootEnvironment()) == null || (applicationEnvironment = rootEnvironment.getApplicationEnvironment()) == null) {
            applicationEnvironment = Service.ApplicationEnvironment.PROD_2;
        }
        return service.provideStickersUrl(applicationEnvironment) + this.folder + "/" + getName();
    }

    public /* synthetic */ StickerContent(String str, String str2, String str3, String str4, String str5, long j10, String str6, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, j10, (i10 & 64) != 0 ? "" : str6);
    }
}
