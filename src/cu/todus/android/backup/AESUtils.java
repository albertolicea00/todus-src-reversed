package cu.todus.android.backup;

import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import le.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcu/todus/android/backup/AESUtils;", "", "KEY", "", "<init>", "(Ljava/lang/String;)V", "getKEY", "()Ljava/lang/String;", "ALGORITHM", "MODE", "IV", "encrypt", AppMeasurementSdk.ConditionalUserProperty.VALUE, "decrypt", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AESUtils {
    public static final int $stable = 0;
    private final String ALGORITHM;
    private final String IV;
    private final String KEY;
    private final String MODE;

    public AESUtils(String KEY) {
        y.i(KEY, "KEY");
        this.KEY = KEY;
        this.ALGORITHM = "Blowfish";
        this.MODE = "Blowfish/CBC/PKCS5Padding";
        this.IV = "abcdefgh";
    }

    public final String decrypt(String value) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrDecode = Base64.decode(value, 0);
        String str = this.KEY;
        Charset charset = c.f37236b;
        byte[] bytes = str.getBytes(charset);
        y.h(bytes, "getBytes(...)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, this.ALGORITHM);
        Cipher cipher = Cipher.getInstance(this.MODE);
        byte[] bytes2 = this.IV.getBytes(charset);
        y.h(bytes2, "getBytes(...)");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bytes2));
        byte[] bArrDoFinal = cipher.doFinal(bArrDecode);
        y.h(bArrDoFinal, "doFinal(...)");
        return new String(bArrDoFinal, charset);
    }

    public final String encrypt(String value) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        y.i(value, "value");
        String str = this.KEY;
        Charset charset = c.f37236b;
        byte[] bytes = str.getBytes(charset);
        y.h(bytes, "getBytes(...)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, this.ALGORITHM);
        Cipher cipher = Cipher.getInstance(this.MODE);
        byte[] bytes2 = this.IV.getBytes(charset);
        y.h(bytes2, "getBytes(...)");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bytes2));
        byte[] bytes3 = value.getBytes(charset);
        y.h(bytes3, "getBytes(...)");
        return Base64.encodeToString(cipher.doFinal(bytes3), 0);
    }

    public final String getKEY() {
        return this.KEY;
    }
}
