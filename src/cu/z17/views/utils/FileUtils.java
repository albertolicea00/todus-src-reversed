package cu.z17.views.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0003J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0003J;\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u001b"}, d2 = {"Lcu/z17/views/utils/FileUtils;", "", "<init>", "()V", "getRealPath", "", "context", "Landroid/content/Context;", "fileUri", "Landroid/net/Uri;", "getRealPathFromURI_API11to18", "contentUri", "getRealPathFromURI_BelowAPI11", "getRealPathFromURI_API19", "uri", "getDataColumn", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "isExternalStorageDocument", "", "isDownloadsDocument", "isMediaDocument", "isGooglePhotosUri", "isPickerUri", "isPlainExternal", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileUtils {
    public static final int $stable = 0;
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    private final String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) throws Throwable {
        Throwable th2;
        String[] strArr = {"_data"};
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            y.f(uri);
            Cursor cursorQuery = contentResolver.query(uri, strArr, selection, selectionArgs, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    cursor = cursorQuery;
                    if (cursor == null) {
                        throw th2;
                    }
                    cursor.close();
                    throw th2;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    @SuppressLint({"NewApi"})
    private final String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        Cursor cursorLoadInBackground = new CursorLoader(context, contentUri, new String[]{"_data"}, null, null, null).loadInBackground();
        if (cursorLoadInBackground == null) {
            return null;
        }
        int columnIndexOrThrow = cursorLoadInBackground.getColumnIndexOrThrow("_data");
        cursorLoadInBackground.moveToFirst();
        String string = cursorLoadInBackground.getString(columnIndexOrThrow);
        cursorLoadInBackground.close();
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    private final String getRealPathFromURI_API19(Context context, Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        List listN;
        List listN2;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri) || isPlainExternal(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                y.f(documentId);
                List listO = new le.m(":").o(documentId, 0);
                if (!listO.isEmpty()) {
                    ListIterator listIterator = listO.listIterator(listO.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            listN = w.n();
                            break;
                        }
                        if (((String) listIterator.previous()).length() != 0) {
                            listN = g0.g1(listO, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } else {
                    listN = w.n();
                    break;
                }
                String[] strArr = (String[]) listN.toArray(new String[0]);
                if (a0.G("primary", strArr[0], true)) {
                    return Environment.getExternalStorageDirectory() + "/" + strArr[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    String documentId2 = DocumentsContract.getDocumentId(uri);
                    Uri uri3 = Uri.parse("content://downloads/public_downloads");
                    y.f(documentId2);
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uri3, Long.parseLong(documentId2));
                    y.h(uriWithAppendedId, "withAppendedId(...)");
                    return getDataColumn(context, uriWithAppendedId, null, null);
                }
                if (isMediaDocument(uri)) {
                    String documentId3 = DocumentsContract.getDocumentId(uri);
                    y.f(documentId3);
                    List listO2 = new le.m(":").o(documentId3, 0);
                    if (!listO2.isEmpty()) {
                        ListIterator listIterator2 = listO2.listIterator(listO2.size());
                        while (true) {
                            if (!listIterator2.hasPrevious()) {
                                listN2 = w.n();
                                break;
                            }
                            if (((String) listIterator2.previous()).length() != 0) {
                                listN2 = g0.g1(listO2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    } else {
                        listN2 = w.n();
                        break;
                    }
                    String[] strArr2 = (String[]) listN2.toArray(new String[0]);
                    String str = strArr2[0];
                    if (y.d("image", str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (y.d("video", str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (y.d("audio", str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArr2[1]});
                }
            }
        } else {
            if (a0.G("content", uri.getScheme(), true)) {
                return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
            }
            if (a0.G(ExtensionFile.ELEMENT, uri.getScheme(), true)) {
                return uri.getPath();
            }
            if (isPickerUri(uri)) {
                List<String> pathSegments = uri.getPathSegments();
                y.f(pathSegments);
                Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String) g0.I0(pathSegments)), new String[]{"_data"}, null, null, null);
                if (cursorQuery == null) {
                    return null;
                }
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    hb.c.a(cursorQuery, null);
                    return string;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        hb.c.a(cursorQuery, th2);
                        throw th3;
                    }
                }
            }
            if (isPlainExternal(uri)) {
                String str2 = uri.getPathSegments().get(uri.getPathSegments().size() - 3);
                if (str2 != null) {
                    int iHashCode = str2.hashCode();
                    if (iHashCode != 93166550) {
                        if (iHashCode != 100313435) {
                            if (iHashCode == 112202875 && str2.equals("video")) {
                                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            }
                        } else if (str2.equals("image")) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        }
                    } else if (str2.equals("audio")) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                }
                List<String> pathSegments2 = uri.getPathSegments();
                y.h(pathSegments2, "getPathSegments(...)");
                return getDataColumn(context, uri2, "_id=?", new String[]{g0.I0(pathSegments2)});
            }
        }
        return null;
    }

    private final String getRealPathFromURI_BelowAPI11(Context context, Uri contentUri) {
        ContentResolver contentResolver = context.getContentResolver();
        y.f(contentUri);
        Cursor cursorQuery = contentResolver.query(contentUri, new String[]{"_data"}, null, null, null);
        if (cursorQuery == null) {
            return "";
        }
        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndexOrThrow);
        y.h(string, "getString(...)");
        cursorQuery.close();
        return string;
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

    private final boolean isMediaDocument(Uri uri) {
        return y.d("com.android.providers.media.documents", uri.getAuthority());
    }

    private final boolean isPickerUri(Uri uri) {
        String string = uri.toString();
        y.h(string, "toString(...)");
        return a0.U(string, "/picker_get_content", false, 2, null);
    }

    private final boolean isPlainExternal(Uri uri) {
        String string = uri.toString();
        y.h(string, "toString(...)");
        return a0.U(string, "/external", false, 2, null);
    }

    public final String getRealPath(Context context, Uri fileUri) {
        y.i(context, "context");
        y.i(fileUri, "fileUri");
        return getRealPathFromURI_API19(context, fileUri);
    }
}
