package cu.todus.android.data.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.webkit.MimeTypeMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import cu.todus.android.data.paths.DirectoryPaths;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.utils.IO;
import cu.todus.android.utils.MimeUtils;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import hb.b;
import hb.c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.y;
import lb.a;
import le.a0;
import le.d0;
import ua.k0;
import ua.n;
import ua.o;
import ua.z;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010\u0018J=\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0003¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u000bJ\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00103\u001a\u0002022\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b3\u00104J'\u00103\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b3\u00106J\u0015\u00108\u001a\u0002022\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;0:2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020;¢\u0006\u0004\b?\u0010@J\u001d\u0010A\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bA\u0010\u0011J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0004\bA\u0010\u000bJ\u0015\u0010D\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0004¢\u0006\u0004\bD\u0010\u0016J\u0015\u0010E\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0004¢\u0006\u0004\bE\u0010\u0016J\u0015\u0010F\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0004¢\u0006\u0004\bF\u0010\u0016J\u0015\u0010G\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u0016J\u0015\u0010H\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0004¢\u0006\u0004\bH\u0010\u0016J\u001f\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bI\u0010\u0011J\u0017\u0010M\u001a\u00020L2\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020;2\u0006\u0010\r\u001a\u00020\f2\u0006\u00107\u001a\u00020.¢\u0006\u0004\bO\u0010PJ\u0015\u0010Q\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\bQ\u0010\u000bJ-\u0010V\u001a\u00020\u00062\u0006\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020;2\u0006\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020;¢\u0006\u0004\bV\u0010WJ\u0019\u0010Z\u001a\u00020L*\u00020.2\u0006\u0010Y\u001a\u00020X¢\u0006\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010]R\u0014\u0010_\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010]R\u0014\u0010`\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010]R\u0014\u0010a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010]R\u0014\u0010b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010]R\u0014\u0010c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bc\u0010]R\u0014\u0010d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bd\u0010]R\u0014\u0010e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\be\u0010]R\u0014\u0010f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bf\u0010]R\u0014\u0010g\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bg\u0010]R\u0014\u0010h\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k²\u0006\f\u0010j\u001a\u0002028\nX\u008a\u0084\u0002²\u0006\f\u0010j\u001a\u0002028\nX\u008a\u0084\u0002"}, d2 = {"Lcu/todus/android/data/util/MediaUtil;", "", "<init>", "()V", "", "imageFile", "", "getCameraPhotoOrientation", "(Ljava/lang/String;)I", "mimeType", "getCorrectedMimeType", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "getPathFromContent", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "getFileNameByUri", "url", "", "isLocal", "(Ljava/lang/String;)Z", "isLocalStorageDocument", "(Landroid/net/Uri;)Z", "isExternalStorageDocument", "isDownloadsDocument", "isMediaDocument", "isGooglePhotosUri", "uriPath", "isPickerUri", "isPlainExternal", "selection", "", "selectionArgs", "getDataColumn", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "filename", "createChecksum", "", "data", "printableHexString", "([B)Ljava/lang/String;", "Ljava/io/ByteArrayOutputStream;", "generateChecksum", "(Ljava/io/ByteArrayOutputStream;)Ljava/lang/String;", "Ljava/io/File;", ExtensionFile.ELEMENT, "", "size", "Landroid/graphics/Bitmap;", "generateImageThumbnail", "(Ljava/io/File;F)Landroid/graphics/Bitmap;", "bitmap", "(Landroid/graphics/Bitmap;Ljava/io/File;F)Landroid/graphics/Bitmap;", "path", "generateVideoThumbnail", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "Lkotlin/Pair;", "", "getImageWidthHeight", "(Ljava/lang/String;)Lkotlin/Pair;", TypedValues.TransitionType.S_DURATION, "getHumanDuration", "(J)Ljava/lang/String;", "getMimeType", "extension", "contentType", "isImageType", "isVideoType", "isFileType", "isAudioType", "isGifType", "getPath", "Ljava/io/Closeable;", "stream", "Lua/k0;", "close", "(Ljava/io/Closeable;)V", "getDurationFromFile", "(Landroid/content/Context;Ljava/io/File;)J", "getChecksum", "oldWidth", "oldHeight", "newWidth", "newHeight", "aspectRatio", "(JJJJ)I", "Ljava/io/InputStream;", "inputStream", "copyInputStreamToFile", "(Ljava/io/File;Ljava/io/InputStream;)V", "IMAGE_PNG", "Ljava/lang/String;", "IMAGE_JPEG", "IMAGE_GIF", "AUDIO_AAC", "AUDIO_UNSPECIFIED", "VIDEO_UNSPECIFIED", "ALL_IMAGE", "ALL_AUDIO", "ALL_VIDEO", "ALL_FILES", "TEXT", "DEBUG", "Z", "bitmapCompressed", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaUtil {
    public static final int $stable = 0;
    public static final String ALL_AUDIO = "audio/";
    public static final String ALL_FILES = "application/";
    public static final String ALL_IMAGE = "image/";
    public static final String ALL_VIDEO = "video/";
    public static final String AUDIO_AAC = "audio/aac";
    public static final String AUDIO_UNSPECIFIED = "audio/*";
    private static final boolean DEBUG = false;
    public static final String IMAGE_GIF = "image/gif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PNG = "image/png";
    public static final MediaUtil INSTANCE = new MediaUtil();
    public static final String TEXT = "text/plain";
    public static final String VIDEO_UNSPECIFIED = "cu/todus/android/adapter/message/delegate/video/*";

    private MediaUtil() {
    }

    private final String createChecksum(String filename) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = fileInputStream.read(bArr);
            if (i10 == -1) {
                fileInputStream.close();
                return generateChecksum(byteArrayOutputStream);
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    private final String generateChecksum(ByteArrayOutputStream data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            y.h(messageDigest, "getInstance(...)");
            byte[] bArrDigest = messageDigest.digest(data.toByteArray());
            y.h(bArrDigest, "digest(...)");
            return printableHexString(bArrDigest);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static /* synthetic */ Bitmap generateImageThumbnail$default(MediaUtil mediaUtil, File file, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 15.0f;
        }
        return mediaUtil.generateImageThumbnail(file, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap generateImageThumbnail$lambda$0(File file, float f10) {
        boolean z10;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getPath());
        MediaUtil mediaUtil = INSTANCE;
        String absolutePath = file.getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        int cameraPhotoOrientation = mediaUtil.getCameraPhotoOrientation(absolutePath);
        Matrix matrix = new Matrix();
        matrix.postRotate(cameraPhotoOrientation);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
        float width = bitmapCreateBitmap.getWidth();
        float height = bitmapCreateBitmap.getHeight();
        if (height > width) {
            z10 = true;
        } else {
            z10 = false;
            height = width;
            width = height;
        }
        float f11 = (width / height) * f10;
        if (f11 < f10 && z10) {
            f11 = f10;
            f10 = f11;
        }
        return ThumbnailUtils.extractThumbnail(bitmapCreateBitmap, (int) f10, (int) f11);
    }

    private static final Bitmap generateImageThumbnail$lambda$1(n nVar) {
        Object value = nVar.getValue();
        y.h(value, "getValue(...)");
        return (Bitmap) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap generateImageThumbnail$lambda$2(Bitmap bitmap, File file, float f10) {
        boolean z10;
        MediaUtil mediaUtil = INSTANCE;
        String absolutePath = file.getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        int cameraPhotoOrientation = mediaUtil.getCameraPhotoOrientation(absolutePath);
        Matrix matrix = new Matrix();
        matrix.postRotate(cameraPhotoOrientation);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        float width = bitmapCreateBitmap.getWidth();
        float height = bitmapCreateBitmap.getHeight();
        if (height > width) {
            z10 = true;
        } else {
            z10 = false;
            height = width;
            width = height;
        }
        float f11 = (width / height) * f10;
        if (f11 < f10 && z10) {
            f10 = f11;
            f11 = f10;
        }
        return ThumbnailUtils.extractThumbnail(bitmapCreateBitmap, (int) f10, (int) f11);
    }

    private static final Bitmap generateImageThumbnail$lambda$3(n nVar) {
        Object value = nVar.getValue();
        y.h(value, "getValue(...)");
        return (Bitmap) value;
    }

    private final int getCameraPhotoOrientation(String imageFile) {
        try {
            int attributeInt = new ExifInterface(imageFile).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception unused) {
            return 0;
        }
    }

    private final String getCorrectedMimeType(String mimeType) {
        if (y.d(mimeType, "image/jpg")) {
            return MimeTypeMap.getSingleton().hasMimeType("image/jpeg") ? "image/jpeg" : mimeType;
        }
        return mimeType == null ? "" : mimeType;
    }

    @SuppressLint({"Recycle"})
    private final String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) throws IllegalAccessException, IOException, InvocationTargetException {
        ContentResolver contentResolver = context.getContentResolver();
        y.f(uri);
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_data"}, selection, selectionArgs, null);
        y.f(cursorQuery);
        try {
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                c.a(cursorQuery, null);
                return string;
            }
            k0 k0Var = k0.f43947a;
            c.a(cursorQuery, null);
            return null;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(cursorQuery, th2);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    private final String getFileNameByUri(Context context, Uri uri) {
        Exception exc;
        Uri uri2;
        String string;
        Integer numValueOf;
        Throwable th2;
        String str = null;
        try {
            if (a0.H(uri.getScheme(), "content", false, 2, null)) {
                uri2 = uri;
                Cursor cursorQuery = context.getContentResolver().query(uri2, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        } else {
                            string = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        try {
                            throw th2;
                        } catch (Throwable th4) {
                            c.a(cursorQuery, th2);
                            throw th4;
                        }
                    }
                } else {
                    string = null;
                }
                try {
                    k0 k0Var = k0.f43947a;
                    try {
                        c.a(cursorQuery, null);
                    } catch (Exception e10) {
                        exc = e10;
                        str = string;
                        exc.printStackTrace();
                        return str;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = string;
                    th2 = th;
                    throw th2;
                }
            } else {
                uri2 = uri;
                string = null;
            }
            if (string != null) {
                return string;
            }
            String path = uri2.getPath();
            if (path != null) {
                try {
                    numValueOf = Integer.valueOf(d0.u0(path, '/', 0, false, 6, null));
                } catch (Exception e11) {
                    exc = e11;
                    str = path;
                    exc.printStackTrace();
                    return str;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf == null || numValueOf.intValue() == -1) {
                return path;
            }
            if (path == null) {
                return null;
            }
            String strSubstring = path.substring(numValueOf.intValue() + 1);
            y.h(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception e12) {
            exc = e12;
            exc.printStackTrace();
            return str;
        }
    }

    private final String getPathFromContent(Context context, Uri uri) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        String strGuessMimeTypeFromUri = MimeUtils.INSTANCE.guessMimeTypeFromUri(context, uri);
        File externalCacheDir = context.getExternalCacheDir();
        String fileNameByUri = getFileNameByUri(context, uri);
        if (fileNameByUri == null) {
            fileNameByUri = DirectoryPaths.INSTANCE.getInstance().getNewFileName(strGuessMimeTypeFromUri);
        }
        File file = new File(externalCacheDir, fileNameByUri);
        if (IO.INSTANCE.save(inputStreamOpenInputStream, new FileOutputStream(file))) {
            return file.getPath();
        }
        return null;
    }

    private final boolean isDownloadsDocument(Uri uri) {
        return y.d("com.android.providers.downloads.documents", uri.getAuthority());
    }

    private final boolean isExternalStorageDocument(Uri uri) {
        return y.d("com.android.externalstorage.documents", uri.getAuthority());
    }

    private final boolean isGooglePhotosUri(Uri uri) {
        return y.d("com.google.android.apps.photos.content", uri.getAuthority());
    }

    private final boolean isLocal(String url) {
        return (url == null || a0.U(url, "http://", false, 2, null) || a0.U(url, "https://", false, 2, null)) ? false : true;
    }

    private final boolean isLocalStorageDocument(Uri uri) {
        return y.d("com.ianhanniballake.localstorage.documents", uri.getAuthority());
    }

    private final boolean isMediaDocument(Uri uri) {
        return y.d("com.android.providers.media.documents", uri.getAuthority());
    }

    private final boolean isPickerUri(String uriPath) {
        return a0.U(uriPath, "/picker_get_content", false, 2, null);
    }

    private final boolean isPlainExternal(Uri uri) {
        String string = uri.toString();
        y.h(string, "toString(...)");
        return a0.U(string, "/external", false, 2, null);
    }

    private final String printableHexString(byte[] data) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : data) {
            String hexString = Integer.toHexString(b10 & 255);
            y.h(hexString, "toHexString(...)");
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        y.h(string, "toString(...)");
        return string;
    }

    public final int aspectRatio(long oldWidth, long oldHeight, long newWidth, long newHeight) {
        return (int) (oldHeight * (newWidth / oldWidth));
    }

    public final void close(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void copyInputStreamToFile(File file, InputStream inputStream) throws IllegalAccessException, IOException, InvocationTargetException {
        y.i(file, "<this>");
        y.i(inputStream, "inputStream");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                b.b(inputStream, fileOutputStream, 0, 2, null);
                c.a(fileOutputStream, null);
                c.a(inputStream, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    c.a(fileOutputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                c.a(inputStream, th4);
                throw th5;
            }
        }
    }

    public final Bitmap generateImageThumbnail(final File file, final float size) {
        y.i(file, "file");
        return generateImageThumbnail$lambda$1(o.a(new a() { // from class: d7.a
            @Override // lb.a
            public final Object invoke() {
                return MediaUtil.generateImageThumbnail$lambda$0(file, size);
            }
        }));
    }

    public final Bitmap generateVideoThumbnail(String path) throws IOException {
        y.i(path, "path");
        if (Build.VERSION.SDK_INT >= 29) {
            Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(new File(path), new Size(100, 200), null);
            y.h(bitmapCreateVideoThumbnail, "createVideoThumbnail(...)");
            return generateImageThumbnail$default(this, bitmapCreateVideoThumbnail, new File(path), 0.0f, 4, null);
        }
        Bitmap bitmapCreateVideoThumbnail2 = ThumbnailUtils.createVideoThumbnail(new File(path).toString(), 1);
        y.f(bitmapCreateVideoThumbnail2);
        return generateImageThumbnail$default(this, bitmapCreateVideoThumbnail2, new File(path), 0.0f, 4, null);
    }

    public final String getChecksum(String filename) throws Exception {
        y.i(filename, "filename");
        return createChecksum(filename);
    }

    public final long getDurationFromFile(Context context, File path) {
        y.i(context, "context");
        y.i(path, "path");
        Uri uriFromFile = Uri.fromFile(path);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, uriFromFile);
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (strExtractMetadata == null) {
            strExtractMetadata = "0";
        }
        return TimeUnit.MILLISECONDS.toSeconds(Integer.parseInt(strExtractMetadata));
    }

    public final String getHumanDuration(long duration) {
        e1 e1Var = e1.f36604a;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toMinutes(duration)), Long.valueOf(timeUnit.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(duration)))}, 2));
        y.h(str, "format(...)");
        return str;
    }

    public final Pair<Long, Long> getImageWidthHeight(String imageFile) {
        y.i(imageFile, "imageFile");
        int cameraPhotoOrientation = getCameraPhotoOrientation(imageFile);
        Matrix matrix = new Matrix();
        matrix.postRotate(cameraPhotoOrientation);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(imageFile);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        return z.a(Long.valueOf(bitmapCreateBitmap.getWidth()), Long.valueOf(bitmapCreateBitmap.getHeight()));
    }

    public final String getMimeType(Context context, Uri uri) {
        y.i(context, "context");
        y.i(uri, "uri");
        String type = context.getContentResolver().getType(uri);
        if (type == null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            y.f(fileExtensionFromUrl);
            Locale ROOT = Locale.ROOT;
            y.h(ROOT, "ROOT");
            String lowerCase = fileExtensionFromUrl.toLowerCase(ROOT);
            y.h(lowerCase, "toLowerCase(...)");
            type = singleton.getMimeTypeFromExtension(lowerCase);
        }
        return getCorrectedMimeType(type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getPath(Context context, Uri uri) {
        String str;
        String string;
        y.i(context, "context");
        y.i(uri, "uri");
        Log.i("MEDIA-INIT", String.valueOf(uri.getPath()));
        String path = uri.getPath();
        if (path == null) {
            path = uri.toString();
            y.h(path, "toString(...)");
        }
        Uri uri2 = null;
        String str2 = null;
        uri2 = null;
        uri2 = null;
        uri2 = null;
        uri2 = null;
        if (isPickerUri(path)) {
            Log.i("MEDIA", "isPickerUri: " + uri);
            try {
                Log.i("MEDIA", "isPickerUri: trying image");
                List<String> pathSegments = uri.getPathSegments();
                y.f(pathSegments);
                Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String) g0.I0(pathSegments)), new String[]{"_data"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(columnIndexOrThrow);
                        c.a(cursorQuery, null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            c.a(cursorQuery, th2);
                            throw th3;
                        }
                    }
                } else {
                    string = null;
                }
                str = string;
            } catch (Exception e10) {
                e10.printStackTrace();
                str = null;
            }
            try {
                Log.i("MEDIA", "isPickerUri: trying image");
                List<String> pathSegments2 = uri.getPathSegments();
                y.f(pathSegments2);
                Cursor cursorQuery2 = context.getContentResolver().query(Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (String) g0.I0(pathSegments2)), new String[]{"_data"}, null, null, null);
                if (cursorQuery2 != null) {
                    try {
                        int columnIndexOrThrow2 = cursorQuery2.getColumnIndexOrThrow("_data");
                        cursorQuery2.moveToFirst();
                        String string2 = cursorQuery2.getString(columnIndexOrThrow2);
                        c.a(cursorQuery2, null);
                        str = string2;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            c.a(cursorQuery2, th4);
                            throw th5;
                        }
                    }
                } else {
                    str = null;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                Log.i("MEDIA", "isPickerUri: trying audio");
                List<String> pathSegments3 = uri.getPathSegments();
                y.f(pathSegments3);
                Cursor cursorQuery3 = context.getContentResolver().query(Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (String) g0.I0(pathSegments3)), new String[]{"_data"}, null, null, null);
                if (cursorQuery3 != null) {
                    try {
                        int columnIndexOrThrow3 = cursorQuery3.getColumnIndexOrThrow("_data");
                        cursorQuery3.moveToFirst();
                        String string3 = cursorQuery3.getString(columnIndexOrThrow3);
                        c.a(cursorQuery3, null);
                        str2 = string3;
                    } catch (Throwable th6) {
                        try {
                            throw th6;
                        } catch (Throwable th7) {
                            c.a(cursorQuery3, th6);
                            throw th7;
                        }
                    }
                }
                return str2;
            } catch (Exception e12) {
                e12.printStackTrace();
                return str;
            }
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            Log.i("MEDIA", "DocumentProvider: " + uri);
            if (!DocumentsContract.isDocumentUri(context, uri)) {
                String scheme = uri.getScheme();
                y.f(scheme);
                if (a0.G("content", scheme, true)) {
                    return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
                }
                String scheme2 = uri.getScheme();
                y.f(scheme2);
                if (a0.G(ExtensionFile.ELEMENT, scheme2, true)) {
                    return uri.getPath();
                }
            } else {
                if (isLocalStorageDocument(uri)) {
                    return DocumentsContract.getDocumentId(uri);
                }
                if (isExternalStorageDocument(uri) || isDownloadsDocument(uri) || isMediaDocument(uri)) {
                    return getPathFromContent(context, uri);
                }
            }
            return getPathFromContent(context, uri);
        }
        if (a0.G("content", uri.getScheme(), true)) {
            Log.i("MEDIA", "content: " + uri);
            return getPathFromContent(context, uri);
        }
        if (a0.G(ExtensionFile.ELEMENT, uri.getScheme(), true)) {
            Log.i("MEDIA", "file: " + uri);
            return uri.getPath();
        }
        if (!isPlainExternal(uri)) {
            String string4 = uri.toString();
            y.h(string4, "toString(...)");
            if (a0.U(string4, "/document/", false, 2, null)) {
                Log.i("MEDIA-INIT", "5");
                return uri.toString();
            }
            Log.i("MEDIA", "NO-ONE: " + uri);
            return uri.toString();
        }
        Log.i("MEDIA", "isPlainExternal: " + uri);
        try {
            String str3 = uri.getPathSegments().get(uri.getPathSegments().size() - 3);
            if (str3 != null) {
                int iHashCode = str3.hashCode();
                if (iHashCode != 93166550) {
                    if (iHashCode != 100313435) {
                        if (iHashCode == 112202875 && str3.equals("video")) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        }
                    } else if (str3.equals("image")) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    }
                } else if (str3.equals("audio")) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
            }
            List<String> pathSegments4 = uri.getPathSegments();
            y.h(pathSegments4, "getPathSegments(...)");
            return getDataColumn(context, uri2, "_id=?", new String[]{g0.I0(pathSegments4)});
        } catch (Exception e13) {
            e13.printStackTrace();
            return "";
        }
    }

    public final boolean isAudioType(String contentType) {
        y.i(contentType, "contentType");
        return a0.U(contentType, ALL_AUDIO, false, 2, null);
    }

    public final boolean isFileType(String contentType) {
        y.i(contentType, "contentType");
        return a0.U(contentType, "*/", false, 2, null);
    }

    public final boolean isGifType(String contentType) {
        y.i(contentType, "contentType");
        return d0.a0(contentType, IMAGE_GIF, false, 2, null);
    }

    public final boolean isImageType(String contentType) {
        y.i(contentType, "contentType");
        return a0.U(contentType, ALL_IMAGE, false, 2, null);
    }

    public final boolean isVideoType(String contentType) {
        y.i(contentType, "contentType");
        return a0.U(contentType, ALL_VIDEO, false, 2, null);
    }

    public static /* synthetic */ Bitmap generateImageThumbnail$default(MediaUtil mediaUtil, Bitmap bitmap, File file, float f10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f10 = 15.0f;
        }
        return mediaUtil.generateImageThumbnail(bitmap, file, f10);
    }

    public final Bitmap generateImageThumbnail(final Bitmap bitmap, final File file, final float size) {
        y.i(bitmap, "bitmap");
        y.i(file, "file");
        return generateImageThumbnail$lambda$3(o.a(new a() { // from class: d7.b
            @Override // lb.a
            public final Object invoke() {
                return MediaUtil.generateImageThumbnail$lambda$2(bitmap, file, size);
            }
        }));
    }

    public final String getMimeType(String extension) {
        y.i(extension, "extension");
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Locale ROOT = Locale.ROOT;
        y.h(ROOT, "ROOT");
        String lowerCase = extension.toLowerCase(ROOT);
        y.h(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? "" : mimeTypeFromExtension;
    }
}
