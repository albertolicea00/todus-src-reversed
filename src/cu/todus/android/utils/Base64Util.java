package cu.todus.android.utils;

import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcu/todus/android/utils/Base64Util;", "", "<init>", "()V", "decodedMessage", "", "message", "flag", "", "encodedMessage", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Base64Util {
    public static final int $stable = 0;
    public static final Base64Util INSTANCE = new Base64Util();

    private Base64Util() {
    }

    public static /* synthetic */ String decodedMessage$default(Base64Util base64Util, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8;
        }
        return base64Util.decodedMessage(str, i10);
    }

    public static /* synthetic */ String encodedMessage$default(Base64Util base64Util, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8;
        }
        return base64Util.encodedMessage(str, i10);
    }

    public final String decodedMessage(String message, int flag) {
        if (message != null) {
            try {
                if (a0.U(message, "{", false, 2, null)) {
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
        }
        byte[] bArrDecode = Base64.decode(message, flag);
        y.h(bArrDecode, "decode(...)");
        return a0.C(bArrDecode);
    }

    public final String encodedMessage(String message, int flag) {
        y.i(message, "message");
        byte[] bytes = message.getBytes(le.c.f37236b);
        y.h(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, flag);
        y.h(strEncodeToString, "encodeToString(...)");
        return a0.O(d0.q1(strEncodeToString).toString(), "\n", "", false, 4, null);
    }

    public static /* synthetic */ String encodedMessage$default(Base64Util base64Util, byte[] bArr, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8;
        }
        return base64Util.encodedMessage(bArr, i10);
    }

    public final String encodedMessage(byte[] message, int flag) {
        y.i(message, "message");
        String strEncodeToString = Base64.encodeToString(message, flag);
        y.h(strEncodeToString, "encodeToString(...)");
        return a0.O(d0.q1(strEncodeToString).toString(), "\n", "", false, 4, null);
    }
}
