package cu.z17.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import cu.todus.android.webrtc.sessions.ConstraintsKeys;
import hb.l;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import le.d0;
import ua.z;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u0006\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014\u001a%\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018\u001a1\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010\"\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#\u001a1\u0010&\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'\"\u001c\u0010)\u001a\n (*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroid/content/Context;", "context", "", "cachePath", "(Landroid/content/Context;)Ljava/lang/String;", "Landroid/graphics/Bitmap$CompressFormat;", "compressFormat", "(Ljava/lang/String;)Landroid/graphics/Bitmap$CompressFormat;", "Ljava/io/File;", "(Ljava/io/File;)Landroid/graphics/Bitmap$CompressFormat;", "extension", "(Landroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;", "imageFile", "Landroid/graphics/Bitmap;", "loadBitmap", "(Ljava/io/File;)Landroid/graphics/Bitmap;", "", "reqWidth", "reqHeight", "decodeSampledBitmapFromFile", "(Ljava/io/File;II)Landroid/graphics/Bitmap;", "Landroid/graphics/BitmapFactory$Options;", "options", "calculateInSampleSize", "(Landroid/graphics/BitmapFactory$Options;II)I", "bitmap", ConstraintsKeys.KEY_MAX_HEIGHT, ConstraintsKeys.KEY_MAX_WIDTH, "determineImageRotation", "(Ljava/io/File;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "copyToCache", "(Landroid/content/Context;Ljava/io/File;)Ljava/io/File;", "format", "quality", "overWrite", "(Ljava/io/File;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;I)Ljava/io/File;", "destination", "Lua/k0;", "saveBitmap", "(Landroid/graphics/Bitmap;Ljava/io/File;Landroid/graphics/Bitmap$CompressFormat;I)V", "kotlin.jvm.PlatformType", "separator", "Ljava/lang/String;", "compress_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilKt {
    private static final String separator = File.separator;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final String cachePath(Context context) {
        String path = context.getCacheDir().getPath();
        String str = separator;
        return path + str + "compressor" + str;
    }

    public static final int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        y.i(options, "options");
        Pair pairA = z.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) pairA.component1()).intValue();
        int iIntValue2 = ((Number) pairA.component2()).intValue();
        int i12 = 1;
        if (iIntValue <= i11 && iIntValue2 <= i10) {
            return 1;
        }
        int i13 = iIntValue / 2;
        int i14 = iIntValue2 / 2;
        while (i13 / i12 >= i11 && i14 / i12 >= i10) {
            i12 *= 2;
        }
        return i12;
    }

    public static final Bitmap.CompressFormat compressFormat(String str) {
        y.i(str, "<this>");
        if (y.d(str, "png")) {
            return Bitmap.CompressFormat.PNG;
        }
        if (y.d(str, "webp")) {
            return Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static final File copyToCache(Context context, File imageFile) {
        y.i(context, "context");
        y.i(imageFile, "imageFile");
        return l.f(imageFile, new File(cachePath(context) + imageFile.getName()), true, 0, 4, null);
    }

    public static final Bitmap decodeSampledBitmapFromFile(File imageFile, int i10, int i11) {
        y.i(imageFile, "imageFile");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        y.h(bitmapDecodeFile, "run(...)");
        return bitmapDecodeFile;
    }

    public static final Bitmap determineImageRotation(File imageFile, Bitmap bitmap, int i10, int i11) {
        int height;
        int width;
        y.i(imageFile, "imageFile");
        y.i(bitmap, "bitmap");
        boolean z10 = false;
        int attributeInt = new ExifInterface(imageFile.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
        Matrix matrix = new Matrix();
        if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        boolean z11 = true;
        if (i10 > bitmap.getHeight()) {
            height = bitmap.getHeight();
        } else {
            height = 1920;
            z10 = true;
        }
        if (i11 > bitmap.getWidth()) {
            width = bitmap.getWidth();
            z11 = z10;
        } else {
            width = 1080;
        }
        if (z11) {
            return decodeSampledBitmapFromFile(imageFile, width, height);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap determineImageRotation$default(File file, Bitmap bitmap, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 3000;
        }
        if ((i12 & 8) != 0) {
            i11 = 3000;
        }
        return determineImageRotation(file, bitmap, i10, i11);
    }

    public static final String extension(Bitmap.CompressFormat compressFormat) {
        y.i(compressFormat, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i10 == 1) {
            return "png";
        }
        return (compressFormat == (Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP) || i10 == 2) ? "webp" : "jpeg";
    }

    public static final Bitmap loadBitmap(File imageFile) {
        y.i(imageFile, "imageFile");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        y.f(bitmapDecodeFile);
        return determineImageRotation$default(imageFile, bitmapDecodeFile, 0, 0, 12, null);
    }

    public static final File overWrite(File imageFile, Bitmap bitmap, Bitmap.CompressFormat format, int i10) throws Throwable {
        File file;
        y.i(imageFile, "imageFile");
        y.i(bitmap, "bitmap");
        y.i(format, "format");
        if (format == compressFormat(imageFile)) {
            file = imageFile;
        } else {
            String absolutePath = imageFile.getAbsolutePath();
            y.h(absolutePath, "getAbsolutePath(...)");
            file = new File(d0.o1(absolutePath, ".", null, 2, null) + "." + extension(format));
        }
        imageFile.delete();
        saveBitmap(bitmap, file, format, i10);
        return file;
    }

    public static /* synthetic */ File overWrite$default(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            compressFormat = compressFormat(file);
        }
        if ((i11 & 8) != 0) {
            i10 = 100;
        }
        return overWrite(file, bitmap, compressFormat, i10);
    }

    public static final void saveBitmap(Bitmap bitmap, File destination, Bitmap.CompressFormat format, int i10) throws Throwable {
        y.i(bitmap, "bitmap");
        y.i(destination, "destination");
        y.i(format, "format");
        File parentFile = destination.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(destination.getAbsolutePath());
            try {
                bitmap.compress(format, i10, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static /* synthetic */ void saveBitmap$default(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i10, int i11, Object obj) throws Throwable {
        if ((i11 & 4) != 0) {
            compressFormat = compressFormat(file);
        }
        if ((i11 & 8) != 0) {
            i10 = 100;
        }
        saveBitmap(bitmap, file, compressFormat, i10);
    }

    public static final Bitmap.CompressFormat compressFormat(File file) {
        y.i(file, "<this>");
        String lowerCase = l.h(file).toLowerCase(Locale.ROOT);
        y.h(lowerCase, "toLowerCase(...)");
        if (y.d(lowerCase, "png")) {
            return Bitmap.CompressFormat.PNG;
        }
        if (y.d(lowerCase, "webp")) {
            return Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
