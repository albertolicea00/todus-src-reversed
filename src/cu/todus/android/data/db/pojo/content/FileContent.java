package cu.todus.android.data.db.pojo.content;

import android.net.Uri;
import androidx.compose.runtime.Immutable;
import androidx.core.net.UriKt;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.utils.TextUtilsKt;
import defpackage.l;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;
import le.m;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nJ\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\nH\u0096\u0080\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/pojo/content/FileContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "name", "", "path", "url", "size", "", "hash", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getPath", "getUrl", "getSize", "()J", "getHash", "rebuild", "getFolderPath", "Lkotlin/Pair;", "public", "", "equals", "other", "", "hashCode", "getToDus2Uri", "Landroid/net/Uri;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class FileContent extends Content {
    public static final int $stable = 0;
    public static final String TYPE = "FILE";
    private final String hash;
    private final String name;
    private final String path;
    private final long size;
    private final String url;

    public FileContent() {
        this(null, null, null, 0L, null, 0, 63, null);
    }

    public static /* synthetic */ Pair getFolderPath$default(FileContent fileContent, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFolderPath");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return fileContent.getFolderPath(z10);
    }

    public static /* synthetic */ Uri getToDus2Uri$default(FileContent fileContent, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getToDus2Uri");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return fileContent.getToDus2Uri(z10);
    }

    public static /* synthetic */ FileContent rebuild$default(FileContent fileContent, String str, String str2, String str3, long j10, String str4, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rebuild");
        }
        if ((i11 & 1) != 0) {
            str = fileContent.name;
        }
        if ((i11 & 2) != 0) {
            str2 = fileContent.path;
        }
        if ((i11 & 4) != 0) {
            str3 = fileContent.url;
        }
        if ((i11 & 8) != 0) {
            j10 = fileContent.size;
        }
        if ((i11 & 16) != 0) {
            str4 = fileContent.hash;
        }
        if ((i11 & 32) != 0) {
            i10 = fileContent.getType();
        }
        long j11 = j10;
        String str5 = str3;
        return fileContent.rebuild(str, str2, str5, j11, str4, i10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileContent)) {
            return false;
        }
        FileContent fileContent = (FileContent) other;
        if (y.d(this.name, fileContent.name) && y.d(this.path, fileContent.path) && y.d(this.url, fileContent.url) && this.size == fileContent.size) {
            return y.d(this.hash, fileContent.hash);
        }
        return false;
    }

    public final Pair<String, String> getFolderPath(boolean z10) {
        if (this instanceof StickerContent) {
            File file = new File(DirectoryPaths.INSTANCE.getInstance().getStickerPrivateDirectory(), ((StickerContent) this).getFolder());
            if (!file.exists()) {
                file.mkdirs();
            }
            return z.a(this.name, file.getPath());
        }
        if (this instanceof ImageContent) {
            return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.IMAGE).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.IMAGE).getPath());
        }
        if (this instanceof GifContent) {
            return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.GIF).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.GIF).getPath());
        }
        if (this instanceof VideoContent) {
            return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.VIDEO).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.VIDEO).getPath());
        }
        if (this instanceof AudioContent) {
            return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.AUDIO).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.AUDIO).getPath());
        }
        if (this instanceof VoiceContent) {
            return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.VOICE).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.VOICE).getPath());
        }
        return z.a(this.name, z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(DirectoryPaths.TYPE.FILE).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(DirectoryPaths.TYPE.FILE).getPath());
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final Uri getToDus2Uri(boolean z10) {
        DirectoryPaths.TYPE type;
        try {
            Uri uri = Uri.parse(this.path);
            y.f(uri);
            File file = UriKt.toFile(uri);
            if (file.exists()) {
                return Uri.parse(file.getPath());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int type2 = getType();
        if (type2 == 1) {
            type = DirectoryPaths.TYPE.IMAGE;
        } else if (type2 == 2) {
            type = DirectoryPaths.TYPE.VIDEO;
        } else if (type2 == 3) {
            type = DirectoryPaths.TYPE.AUDIO;
        } else if (type2 != 4) {
            type = type2 != 7 ? DirectoryPaths.TYPE.FILE : DirectoryPaths.TYPE.GIF;
        } else {
            type = DirectoryPaths.TYPE.VOICE;
        }
        File file2 = new File(z10 ? DirectoryPaths.INSTANCE.getInstance().getPublicFolder(type).getPath() : DirectoryPaths.INSTANCE.getInstance().getPrivateFolder(type).getPath());
        List listS0 = d0.S0(this.name, new String[]{"."}, false, 0, 6, null);
        File file3 = new File(file2, new m("[\r\n]").l(TextUtilsKt.get256Hash(this.url) + "." + listS0.get(listS0.size() - 1), ""));
        if (file3.exists()) {
            return Uri.parse(file3.getPath());
        }
        return null;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + this.url.hashCode()) * 31) + l.a(this.size)) * 31) + this.hash.hashCode();
    }

    public final FileContent rebuild(String name, String path, String url, long size, String hash, int type) {
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        return new FileContent(name, path, url, size, hash, type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileContent(String name, String path, String url, long j10, String hash, int i10) {
        super(i10);
        y.i(name, "name");
        y.i(path, "path");
        y.i(url, "url");
        y.i(hash, "hash");
        this.name = name;
        this.path = path;
        this.url = url;
        this.size = j10;
        this.hash = hash;
    }

    public /* synthetic */ FileContent(String str, String str2, String str3, long j10, String str4, int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? 0L : j10, (i11 & 16) != 0 ? "" : str4, (i11 & 32) != 0 ? 5 : i10);
    }
}
