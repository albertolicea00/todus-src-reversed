package cu.todus.android.backup;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Backup encryption/decryption utility.
 *
 * <p>Note: Despite the class name {@code AESUtils}, the implementation uses
 * {@code Blowfish/CBC/PKCS5Padding} with the static 8-byte IV {@code "abcdefgh"}.
 *
 * @obfuscated_class cu.todus.android.backup.AESUtils
 */
public final class AESUtils {

    private static final String ALGORITHM = "Blowfish";
    private static final String MODE = "Blowfish/CBC/PKCS5Padding";
    private static final String IV = "abcdefgh";

    private final String key;

    public AESUtils(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String encrypt(String value)
            throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
                   NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
        byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeToString(encrypted, Base64.DEFAULT);
    }

    public String decrypt(String value)
            throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException,
                   NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] decoded = Base64.decode(value, Base64.DEFAULT);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
        return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
    }
}
