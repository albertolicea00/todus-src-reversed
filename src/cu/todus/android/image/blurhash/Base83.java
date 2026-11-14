package cu.todus.android.image.blurhash;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0011\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcu/todus/android/image/blurhash/Base83;", "", "<init>", "()V", "", "a", "", "key", "", "indexOf", "([CC)I", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "length", "buffer", "offset", "Lua/k0;", "encode", "(JI[CI)V", "", "(JI)Ljava/lang/String;", "decode", "(Ljava/lang/String;)I", "ALPHABET", "[C", "getALPHABET", "()[C", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Base83 {
    public static final int $stable;
    private static final char[] ALPHABET;
    public static final Base83 INSTANCE = new Base83();

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%*+,-.:;=?@[]^_{|}~".toCharArray();
        y.h(charArray, "toCharArray(...)");
        ALPHABET = charArray;
        $stable = 8;
    }

    private Base83() {
    }

    private final int indexOf(char[] a10, char key) {
        int length = a10.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (a10[i10] == key) {
                return i10;
            }
        }
        return -1;
    }

    public final int decode(String value) {
        y.i(value, "value");
        char[] charArray = value.toCharArray();
        y.h(charArray, "toCharArray(...)");
        int iIndexOf = 0;
        for (char c10 : charArray) {
            iIndexOf = (iIndexOf * 83) + indexOf(ALPHABET, c10);
        }
        return iIndexOf;
    }

    public final String encode(long value, int length) {
        char[] cArr = new char[length];
        encode(value, length, cArr, 0);
        return new String(cArr);
    }

    public final char[] getALPHABET() {
        return ALPHABET;
    }

    public static final void encode(long value, int length, char[] buffer, int offset) {
        y.i(buffer, "buffer");
        int i10 = 1;
        int i11 = 1;
        while (i10 <= length) {
            buffer[(offset + length) - i10] = ALPHABET[(int) ((value / ((long) i11)) % ((long) 83))];
            i10++;
            i11 *= 83;
        }
    }
}
