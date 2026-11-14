package cu.todus.android.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.util.StringUtils;
import va.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u00020\u0005*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0005J\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcu/todus/android/utils/HashUtils;", "", "<init>", "()V", "sha512", "", "input", "sha256", "sha1", "md5", "hashString", "type", "getFileHash", "Ljava/io/File;", "algorithm", "toHex", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HashUtils {
    public static final int $stable = 0;
    public static final HashUtils INSTANCE = new HashUtils();

    private HashUtils() {
    }

    public static /* synthetic */ String getFileHash$default(HashUtils hashUtils, File file, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "SHA-256";
        }
        return hashUtils.getFileHash(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getFileHash$lambda$0(byte b10) {
        e1 e1Var = e1.f36604a;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        y.h(str, "format(...)");
        return str;
    }

    private final String hashString(String type, String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(type);
        byte[] bytes = input.getBytes(le.c.f37236b);
        y.h(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
        y.f(bArrDigest);
        for (byte b10 : bArrDigest) {
            sb2.append("0123456789ABCDEF".charAt((b10 >> 4) & 15));
            sb2.append("0123456789ABCDEF".charAt(b10 & Ascii.SI));
        }
        String string = sb2.toString();
        y.h(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$0(byte b10) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        y.h(str, "format(...)");
        return str;
    }

    public final String getFileHash(File file, String algorithm) throws NoSuchAlgorithmException, IOException {
        y.i(file, "<this>");
        y.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        for (int i10 = fileInputStream.read(bArr); i10 != -1; i10 = fileInputStream.read(bArr)) {
            messageDigest.update(bArr, 0, i10);
        }
        fileInputStream.close();
        byte[] bArrDigest = messageDigest.digest();
        y.f(bArrDigest);
        return r.U0(bArrDigest, "", null, null, 0, null, new Function1() { // from class: cu.todus.android.utils.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HashUtils.getFileHash$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, null);
    }

    public final String md5(String input) {
        y.i(input, "input");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringUtils.MD5);
            byte[] bytes = input.getBytes(le.c.f37236b);
            y.h(bytes, "getBytes(...)");
            StringBuilder sb2 = new StringBuilder(new BigInteger(1, messageDigest.digest(bytes)).toString(16));
            while (sb2.length() < 32) {
                sb2.insert(0, "0");
            }
            String string = sb2.toString();
            y.f(string);
            return string;
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public final String sha1(String input) {
        y.i(input, "input");
        return hashString(StringUtils.SHA1, input);
    }

    public final String sha256(String input) {
        y.i(input, "input");
        return hashString("SHA-256", input);
    }

    public final String sha512(String input) {
        y.i(input, "input");
        return hashString("SHA-512", input);
    }

    public final String toHex(byte[] bArr) {
        y.i(bArr, "<this>");
        return r.U0(bArr, "", null, null, 0, null, new Function1() { // from class: cu.todus.android.utils.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HashUtils.toHex$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, null);
    }
}
