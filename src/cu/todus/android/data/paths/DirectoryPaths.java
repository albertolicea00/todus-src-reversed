package cu.todus.android.data.paths;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.utils.IO;
import cu.z17.compress.UtilKt;
import cu.z17.singledi.SingletonInitializer;
import cu.z17.views.camera.Z17CameraModule;
import db.a;
import db.b;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.a0;
import va.r;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b!\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0010J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\nJ\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\nJ\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\"J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J'\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u001f\u0010/\u001a\n .*\u0004\u0018\u00010\b0\b8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0010R\u001c\u00102\u001a\n .*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00100R\u0014\u00104\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00100R\u0014\u00106\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00100R\u0014\u00107\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00100R\u0014\u00108\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00100R\u0017\u00109\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u0010\u0010R\u0014\u0010;\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00100R\u0014\u0010<\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00100R\u0014\u0010=\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00100R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00100R\u0014\u0010?\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u00100R\u0017\u0010@\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u0010\u0010R\u0014\u0010B\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00100R\u0014\u0010C\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00100R\u0014\u0010D\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00100R\u0014\u0010E\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u00100R\u0014\u0010F\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00100R\u0014\u0010G\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u00100R\u0014\u0010H\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u00100¨\u0006K"}, d2 = {"Lcu/todus/android/data/paths/DirectoryPaths;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcu/todus/android/data/paths/DirectoryPaths$TYPE;", "type", "Ljava/io/File;", "getFolder", "(Lcu/todus/android/data/paths/DirectoryPaths$TYPE;)Ljava/io/File;", "", "id", "getNewThumbnailFile", "(Ljava/lang/String;)Ljava/io/File;", "getNewRecordFile", "()Ljava/io/File;", "", "public", "getNewImageFile", "(Z)Ljava/io/File;", "getNewVideoFile", "getStreamVideoFile", "getPrivateFolder", "getPublicFolder", "", "getAllFolders", "()Ljava/util/List;", "name", "getNewFile", "(Ljava/lang/String;Lcu/todus/android/data/paths/DirectoryPaths$TYPE;)Ljava/io/File;", "newFileName", "(Lcu/todus/android/data/paths/DirectoryPaths$TYPE;)Ljava/lang/String;", "newGifName", "()Ljava/lang/String;", "newImageName", "newVoiceName", "newVideoName", "mimeType", "getNewFileName", "(Ljava/lang/String;)Ljava/lang/String;", "existingPath", "Lua/k0;", "saveToPublicFolder", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cache", "Ljava/io/File;", "getCache", "files", "imagesDirectory", "voiceDirectory", "documentDirectory", "videoDirectory", "audioDirectory", "stickerDirectory", "downloadsDirectoryPath", "getDownloadsDirectoryPath", "imagesDirectoryPublic", "voiceDirectoryPublic", "documentDirectoryPublic", "videoDirectoryPublic", "audioDirectoryPublic", "stickerPrivateDirectory", "getStickerPrivateDirectory", "imagesPrivateDirectory", "voicePrivateDirectory", "documentPrivateDirectory", "videoPrivateDirectory", "audioPrivateDirectory", "streamPrivateDirectory", "thumbnailPrivateDirectory", "Companion", "TYPE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DirectoryPaths {
    private static final String BLOB_EXTENSION = "blob";
    public static final String appFolder = "toDus";
    private static final String appFolderAudio = "Audio";
    private static final String appFolderDocument = "Document";
    private static final String appFolderImages = "Images";
    private static final String appFolderLogs = "Logs";
    private static final String appFolderSticker = "Sticker";
    private static final String appFolderStream = "Stream";
    private static final String appFolderVideo = "Video";
    private static final String appFolderVoice = "Voice";
    private static final String secret = ".extra";
    private static final String thumbnailFolder = ".thumbnail";
    private final File audioDirectory;
    private final File audioDirectoryPublic;
    private final File audioPrivateDirectory;
    private final File cache;
    private final Context context;
    private final File documentDirectory;
    private final File documentDirectoryPublic;
    private final File documentPrivateDirectory;
    private final File downloadsDirectoryPath;
    private final File files;
    private final File imagesDirectory;
    private final File imagesDirectoryPublic;
    private final File imagesPrivateDirectory;
    private final File stickerDirectory;
    private final File stickerPrivateDirectory;
    private final File streamPrivateDirectory;
    private final File thumbnailPrivateDirectory;
    private final File videoDirectory;
    private final File videoDirectoryPublic;
    private final File videoPrivateDirectory;
    private final File voiceDirectory;
    private final File voiceDirectoryPublic;
    private final File voicePrivateDirectory;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcu/todus/android/data/paths/DirectoryPaths$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/data/paths/DirectoryPaths;", "<init>", "()V", "appFolder", "", "appFolderImages", "appFolderVoice", "appFolderDocument", "appFolderVideo", "appFolderAudio", "appFolderSticker", "appFolderLogs", "thumbnailFolder", "BLOB_EXTENSION", "appFolderStream", Room.COLUMN_SECRET, "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<DirectoryPaths> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcu/todus/android/data/paths/DirectoryPaths$TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "GIF", "VOICE", "AUDIO", "VIDEO", FileContent.TYPE, "STICKER", "STREAM", "THUMBNAIL", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum TYPE {
        IMAGE,
        GIF,
        VOICE,
        AUDIO,
        VIDEO,
        FILE,
        STICKER,
        STREAM,
        THUMBNAIL;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TYPE.values().length];
            try {
                iArr[TYPE.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TYPE.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TYPE.VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TYPE.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TYPE.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TYPE.STICKER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TYPE.STREAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TYPE.THUMBNAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DirectoryPaths(Context context) {
        y.i(context, "context");
        this.context = context;
        this.cache = context.getCacheDir();
        this.files = context.getFilesDir();
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_PICTURES);
        y.h(externalFilesDirs, "getExternalFilesDirs(...)");
        this.imagesDirectory = new File((File) r.y0(externalFilesDirs), "toDus");
        File[] externalFilesDirs2 = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_PODCASTS);
        y.h(externalFilesDirs2, "getExternalFilesDirs(...)");
        this.voiceDirectory = new File((File) r.y0(externalFilesDirs2), "toDus");
        File[] externalFilesDirs3 = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_DOWNLOADS);
        y.h(externalFilesDirs3, "getExternalFilesDirs(...)");
        this.documentDirectory = new File((File) r.y0(externalFilesDirs3), "toDus");
        File[] externalFilesDirs4 = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_PICTURES);
        y.h(externalFilesDirs4, "getExternalFilesDirs(...)");
        this.videoDirectory = new File((File) r.y0(externalFilesDirs4), "toDus");
        File[] externalFilesDirs5 = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_MUSIC);
        y.h(externalFilesDirs5, "getExternalFilesDirs(...)");
        this.audioDirectory = new File((File) r.y0(externalFilesDirs5), "toDus");
        File[] externalFilesDirs6 = ContextCompat.getExternalFilesDirs(context, Environment.DIRECTORY_DOWNLOADS);
        y.h(externalFilesDirs6, "getExternalFilesDirs(...)");
        this.stickerDirectory = new File(new File((File) r.y0(externalFilesDirs6), "toDus"), appFolderSticker);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        y.h(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(...)");
        this.downloadsDirectoryPath = externalStoragePublicDirectory;
        this.imagesDirectoryPublic = new File(Environment.getExternalStorageDirectory(), "toDus/Images");
        this.voiceDirectoryPublic = new File(Environment.getExternalStorageDirectory(), "toDus/Voice");
        this.documentDirectoryPublic = new File(Environment.getExternalStorageDirectory(), "toDus/Document");
        this.videoDirectoryPublic = new File(Environment.getExternalStorageDirectory(), "toDus/Video");
        this.audioDirectoryPublic = new File(Environment.getExternalStorageDirectory(), "toDus/Audio");
        this.stickerPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderSticker);
        this.imagesPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderImages);
        this.voicePrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderVoice);
        this.documentPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderDocument);
        this.videoPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderVideo);
        this.audioPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderAudio);
        this.streamPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), appFolderStream);
        this.thumbnailPrivateDirectory = new File(new File(context.getFilesDir(), "toDus"), thumbnailFolder);
    }

    private final File getFolder(TYPE type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                return this.imagesDirectory;
            case 3:
                return this.voiceDirectory;
            case 4:
                return this.videoDirectory;
            case 5:
                return this.audioDirectory;
            case 6:
                return this.stickerPrivateDirectory;
            default:
                return this.documentDirectory;
        }
    }

    public static /* synthetic */ File getNewFile$default(DirectoryPaths directoryPaths, String str, TYPE type, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            type = TYPE.FILE;
        }
        return directoryPaths.getNewFile(str, type);
    }

    public static /* synthetic */ File getNewImageFile$default(DirectoryPaths directoryPaths, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return directoryPaths.getNewImageFile(z10);
    }

    public static /* synthetic */ File getNewVideoFile$default(DirectoryPaths directoryPaths, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return directoryPaths.getNewVideoFile(z10);
    }

    public static /* synthetic */ String newFileName$default(DirectoryPaths directoryPaths, TYPE type, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            type = TYPE.FILE;
        }
        return directoryPaths.newFileName(type);
    }

    public final List<File> getAllFolders() {
        File file = this.imagesPrivateDirectory;
        File file2 = this.voicePrivateDirectory;
        File file3 = this.videoPrivateDirectory;
        File file4 = this.audioPrivateDirectory;
        File file5 = this.stickerPrivateDirectory;
        return w.q(file, file2, file3, file4, file5, this.streamPrivateDirectory, this.thumbnailPrivateDirectory, this.documentPrivateDirectory, this.imagesDirectoryPublic, this.voiceDirectoryPublic, this.videoDirectoryPublic, this.audioDirectoryPublic, file5, this.documentDirectoryPublic);
    }

    public final File getCache() {
        return this.cache;
    }

    public final File getDownloadsDirectoryPath() {
        return this.downloadsDirectoryPath;
    }

    public final File getNewFile(String name, TYPE type) {
        File parentFile;
        y.i(name, "name");
        y.i(type, "type");
        File folder = getFolder(type);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (name.length() == 0) {
            return new File(folder, newFileName(type));
        }
        File file = new File(folder, name);
        File parentFile2 = file.getParentFile();
        if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        return file;
    }

    public final String getNewFileName(String mimeType) {
        y.i(mimeType, "mimeType");
        MediaUtil mediaUtil = MediaUtil.INSTANCE;
        if (mediaUtil.isGifType(mimeType)) {
            return newFileName(TYPE.GIF);
        }
        return mediaUtil.isImageType(mimeType) ? newFileName(TYPE.IMAGE) : newFileName(TYPE.FILE);
    }

    public final File getNewImageFile(boolean z10) {
        File publicFolder = z10 ? getPublicFolder(TYPE.IMAGE) : getPrivateFolder(TYPE.IMAGE);
        if (!publicFolder.exists()) {
            publicFolder.mkdirs();
        }
        return new File(publicFolder, newImageName());
    }

    public final File getNewRecordFile() {
        if (!this.voiceDirectory.exists()) {
            this.voiceDirectory.mkdirs();
        }
        return new File(this.voiceDirectory, newVoiceName());
    }

    public final File getNewThumbnailFile(String id2) {
        y.i(id2, "id");
        File privateFolder = getPrivateFolder(TYPE.THUMBNAIL);
        if (!privateFolder.exists()) {
            privateFolder.mkdirs();
        }
        return new File(privateFolder, "thumbnail_" + id2 + ".jpeg");
    }

    public final File getNewVideoFile(boolean z10) {
        File publicFolder = z10 ? getPublicFolder(TYPE.VIDEO) : getPrivateFolder(TYPE.VIDEO);
        if (!publicFolder.exists()) {
            publicFolder.mkdirs();
        }
        return new File(publicFolder, newVideoName());
    }

    public final File getPrivateFolder(TYPE type) {
        y.i(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                return this.imagesPrivateDirectory;
            case 3:
                return this.voicePrivateDirectory;
            case 4:
                return this.videoPrivateDirectory;
            case 5:
                return this.audioPrivateDirectory;
            case 6:
                return this.stickerPrivateDirectory;
            case 7:
                return this.streamPrivateDirectory;
            case 8:
                return this.thumbnailPrivateDirectory;
            default:
                return this.documentPrivateDirectory;
        }
    }

    public final File getPublicFolder(TYPE type) {
        y.i(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                return this.imagesDirectoryPublic;
            case 3:
                return this.voiceDirectoryPublic;
            case 4:
                return this.videoDirectoryPublic;
            case 5:
                return this.audioDirectoryPublic;
            case 6:
                return this.stickerPrivateDirectory;
            default:
                return this.documentDirectoryPublic;
        }
    }

    public final File getStickerPrivateDirectory() {
        return this.stickerPrivateDirectory;
    }

    public final File getStreamVideoFile() {
        File privateFolder = getPrivateFolder(TYPE.STREAM);
        if (!privateFolder.exists()) {
            privateFolder.mkdirs();
        }
        return new File(privateFolder, newVideoName());
    }

    public final String newFileName(TYPE type) {
        y.i(type, "type");
        int i10 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i10 == 1) {
            return newImageName();
        }
        if (i10 == 2) {
            return newGifName();
        }
        if (i10 == 3) {
            return newVoiceName();
        }
        if (i10 == 4) {
            return newVideoName();
        }
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        return a0.O(string, "-", "", false, 4, null);
    }

    public final String newGifName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date()) + ".gif";
    }

    public final String newImageName() {
        String strExtension;
        Bitmap.CompressFormat defaultFormat;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        Z17CameraModule instanceOrNull = Z17CameraModule.INSTANCE.getInstanceOrNull();
        if (instanceOrNull == null || (defaultFormat = instanceOrNull.getDefaultFormat()) == null || (strExtension = UtilKt.extension(defaultFormat)) == null) {
            strExtension = "webp";
        }
        return simpleDateFormat.format(new Date()) + "." + strExtension;
    }

    public final String newVideoName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date()) + ".mp4";
    }

    public final String newVoiceName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date()) + ".m4a";
    }

    public final void saveToPublicFolder(String existingPath, Context context, String name) {
        y.i(context, "context");
        y.i(name, "name");
        if (existingPath == null) {
            return;
        }
        try {
            File file = new File(this.downloadsDirectoryPath, "toDus_" + new Date().getTime() + "_" + name);
            file.createNewFile();
            IO.INSTANCE.copyFile(new File(existingPath), file);
            MediaScannerConnection.scanFile(context, new String[]{new File(this.downloadsDirectoryPath, "toDus_" + new Date().getTime() + "_" + name).getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: c7.a
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) {
                    DirectoryPaths.saveToPublicFolder$lambda$0(str, uri);
                }
            });
            Toast.makeText(context, "✅   💾", 1).show();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveToPublicFolder$lambda$0(String str, Uri uri) {
    }
}
