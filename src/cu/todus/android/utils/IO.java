package cu.todus.android.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\fJ!\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0013J%\u0010\u0017\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010!¨\u0006\""}, d2 = {"Lcu/todus/android/utils/IO;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "name", "Ljava/io/InputStream;", "stream", "", "save", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/InputStream;)Z", "saveExternal", "Ljava/io/FileOutputStream;", ExtensionFile.ELEMENT, "(Ljava/io/InputStream;Ljava/io/FileOutputStream;)Z", "Landroid/net/Uri;", "getPath", "(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;", "getExternalPath", "is", "charsetName", "readStream", "(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/File;", "sourceLocation", "targetLocation", "Lua/k0;", "copyFile", "(Ljava/io/File;Ljava/io/File;)V", "Ljava/io/OutputStream;", "out", "(Ljava/io/File;Ljava/io/OutputStream;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IO {
    public static final int $stable = 0;
    public static final IO INSTANCE = new IO();

    private IO() {
    }

    public static /* synthetic */ String readStream$default(IO io2, InputStream inputStream, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = StringUtils.UTF8;
        }
        return io2.readStream(inputStream, str);
    }

    public final void copyFile(File sourceLocation, File targetLocation) throws IOException {
        y.i(targetLocation, "targetLocation");
        if (!targetLocation.exists()) {
            targetLocation.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(sourceLocation);
        FileOutputStream fileOutputStream = new FileOutputStream(targetLocation);
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = fileInputStream.read(bArr);
            if (i10 <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i10);
        }
    }

    public final Uri getExternalPath(Context context, String name) {
        y.i(context, "context");
        Uri uriFromFile = Uri.fromFile(new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), name));
        y.h(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public final Uri getPath(Context context, String name) {
        y.i(context, "context");
        Uri uriFromFile = Uri.fromFile(context.getFileStreamPath(name));
        y.h(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public final String readStream(InputStream inputStream) {
        return readStream$default(this, inputStream, null, 2, null);
    }

    public final boolean save(Context context, String name, InputStream stream) {
        y.i(context, "context");
        if (stream == null) {
            return false;
        }
        try {
            return save(stream, context.openFileOutput(name, 0));
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final boolean saveExternal(Context context, String name, InputStream stream) {
        y.i(context, "context");
        y.i(name, "name");
        if (stream == null) {
            return false;
        }
        try {
            return save(stream, new FileOutputStream(new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), name)));
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final String readStream(InputStream is, String charsetName) {
        if (is == null) {
            return "";
        }
        try {
            String next = new Scanner(is, charsetName).useDelimiter("\\A").next();
            y.h(next, "next(...)");
            int length = next.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = y.j(next.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    }
                    length--;
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            return next.subSequence(i10, length + 1).toString();
        } catch (NoSuchElementException unused) {
            return "";
        }
    }

    public final boolean save(InputStream stream, FileOutputStream file) throws Exception {
        try {
            if (stream != null) {
                byte[] bArr = new byte[32768];
                while (true) {
                    int i10 = stream.read(bArr);
                    if (i10 == -1) {
                        y.f(file);
                        file.flush();
                        stream.close();
                        file.close();
                        return true;
                    }
                    y.f(file);
                    file.write(bArr, 0, i10);
                }
            } else {
                throw new Exception();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final void copyFile(File sourceLocation, OutputStream out) throws IOException {
        y.i(out, "out");
        FileInputStream fileInputStream = new FileInputStream(sourceLocation);
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = fileInputStream.read(bArr);
            if (i10 > 0) {
                out.write(bArr, 0, i10);
            } else {
                fileInputStream.close();
                out.close();
                return;
            }
        }
    }
}
