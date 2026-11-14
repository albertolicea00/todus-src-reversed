package cu.todus.android.utils;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcu/todus/android/utils/ImageUtils;", "", "<init>", "()V", "saveToFile", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", ExtensionFile.ELEMENT, "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ImageUtils {
    public static final int $stable = 0;
    public static final ImageUtils INSTANCE = new ImageUtils();

    private ImageUtils() {
    }

    public final File saveToFile(Bitmap bitmap, File file) {
        y.i(bitmap, "bitmap");
        y.i(file, "file");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Exception e10) {
            e10.printStackTrace();
            return file;
        }
    }
}
