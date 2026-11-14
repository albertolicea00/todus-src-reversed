package cu.z17.preferences.encription;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public class Encryption {
    private final Builder mBuilder;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static class Builder {
        private String mAlgorithm;
        private int mBase64Mode;
        private String mCharsetName;
        private String mDigestAlgorithm;
        private int mIterationCount;
        private byte[] mIv;
        private IvParameterSpec mIvParameterSpec;
        private String mKey;
        private String mKeyAlgorithm;
        private int mKeyLength;
        private String mSalt;
        private String mSecretKeyType;
        private SecureRandom mSecureRandom;
        private String mSecureRandomAlgorithm;

        /* JADX INFO: Access modifiers changed from: private */
        public String getAlgorithm() {
            return this.mAlgorithm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getBase64Mode() {
            return this.mBase64Mode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getCharsetName() {
            return this.mCharsetName;
        }

        public static Builder getDefaultBuilder(String str, String str2, byte[] bArr) {
            return new Builder().setIv(bArr).setKey(str).setSalt(str2).setKeyLength(128).setKeyAlgorithm("AES").setCharsetName("UTF8").setIterationCount(1).setDigestAlgorithm("SHA1").setBase64Mode(0).setAlgorithm("AES/CBC/PKCS5Padding").setSecureRandomAlgorithm("SHA1PRNG").setSecretKeyType("PBKDF2WithHmacSHA1");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getDigestAlgorithm() {
            return this.mDigestAlgorithm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getIterationCount() {
            return this.mIterationCount;
        }

        private byte[] getIv() {
            return this.mIv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public IvParameterSpec getIvParameterSpec() {
            return this.mIvParameterSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getKey() {
            return this.mKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getKeyAlgorithm() {
            return this.mKeyAlgorithm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getKeyLength() {
            return this.mKeyLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getSalt() {
            return this.mSalt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getSecretKeyType() {
            return this.mSecretKeyType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SecureRandom getSecureRandom() {
            return this.mSecureRandom;
        }

        private String getSecureRandomAlgorithm() {
            return this.mSecureRandomAlgorithm;
        }

        public Encryption build() throws NoSuchAlgorithmException {
            setSecureRandom(SecureRandom.getInstance(getSecureRandomAlgorithm()));
            setIvParameterSpec(new IvParameterSpec(getIv()));
            return new Encryption(this);
        }

        public Builder setAlgorithm(String str) {
            this.mAlgorithm = str;
            return this;
        }

        public Builder setBase64Mode(int i10) {
            this.mBase64Mode = i10;
            return this;
        }

        public Builder setCharsetName(String str) {
            this.mCharsetName = str;
            return this;
        }

        public Builder setDigestAlgorithm(String str) {
            this.mDigestAlgorithm = str;
            return this;
        }

        public Builder setIterationCount(int i10) {
            this.mIterationCount = i10;
            return this;
        }

        public Builder setIv(byte[] bArr) {
            this.mIv = bArr;
            return this;
        }

        public Builder setIvParameterSpec(IvParameterSpec ivParameterSpec) {
            this.mIvParameterSpec = ivParameterSpec;
            return this;
        }

        public Builder setKey(String str) {
            this.mKey = str;
            return this;
        }

        public Builder setKeyAlgorithm(String str) {
            this.mKeyAlgorithm = str;
            return this;
        }

        public Builder setKeyLength(int i10) {
            this.mKeyLength = i10;
            return this;
        }

        public Builder setSalt(String str) {
            this.mSalt = str;
            return this;
        }

        public Builder setSecretKeyType(String str) {
            this.mSecretKeyType = str;
            return this;
        }

        public Builder setSecureRandom(SecureRandom secureRandom) {
            this.mSecureRandom = secureRandom;
            return this;
        }

        public Builder setSecureRandomAlgorithm(String str) {
            this.mSecureRandomAlgorithm = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public interface Callback {
        void onError(Exception exc);

        void onSuccess(String str);
    }

    public static Encryption getDefault(String str, String str2, byte[] bArr) {
        try {
            return Builder.getDefaultBuilder(str, str2, bArr).build();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private SecretKey getSecretKey(char[] cArr) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return new SecretKeySpec(SecretKeyFactory.getInstance(this.mBuilder.getSecretKeyType()).generateSecret(new PBEKeySpec(cArr, this.mBuilder.getSalt().getBytes(this.mBuilder.getCharsetName()), this.mBuilder.getIterationCount(), this.mBuilder.getKeyLength())).getEncoded(), this.mBuilder.getKeyAlgorithm());
    }

    private char[] hashTheKey(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance(this.mBuilder.getDigestAlgorithm());
        messageDigest.update(str.getBytes(this.mBuilder.getCharsetName()));
        return Base64.encodeToString(messageDigest.digest(), 1).toCharArray();
    }

    public String decrypt(String str) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        if (str == null) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, this.mBuilder.getBase64Mode());
        SecretKey secretKey = getSecretKey(hashTheKey(this.mBuilder.getKey()));
        Cipher cipher = Cipher.getInstance(this.mBuilder.getAlgorithm());
        cipher.init(2, secretKey, this.mBuilder.getIvParameterSpec(), this.mBuilder.getSecureRandom());
        return new String(cipher.doFinal(bArrDecode));
    }

    public void decryptAsync(final String str, final Callback callback) {
        if (callback == null) {
            return;
        }
        new Thread(new Runnable() { // from class: cu.z17.preferences.encription.Encryption.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strDecrypt = Encryption.this.decrypt(str);
                    if (strDecrypt == null) {
                        callback.onError(new Exception("Decrypt return null, it normally occurs when you send a null data"));
                    }
                    callback.onSuccess(strDecrypt);
                } catch (Exception e10) {
                    callback.onError(e10);
                }
            }
        }).start();
    }

    public String decryptOrNull(String str) {
        try {
            return decrypt(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String encrypt(String str) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        if (str == null) {
            return null;
        }
        SecretKey secretKey = getSecretKey(hashTheKey(this.mBuilder.getKey()));
        byte[] bytes = str.getBytes(this.mBuilder.getCharsetName());
        Cipher cipher = Cipher.getInstance(this.mBuilder.getAlgorithm());
        cipher.init(1, secretKey, this.mBuilder.getIvParameterSpec(), this.mBuilder.getSecureRandom());
        return Base64.encodeToString(cipher.doFinal(bytes), this.mBuilder.getBase64Mode());
    }

    public void encryptAsync(final String str, final Callback callback) {
        if (callback == null) {
            return;
        }
        new Thread(new Runnable() { // from class: cu.z17.preferences.encription.Encryption.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strEncrypt = Encryption.this.encrypt(str);
                    if (strEncrypt == null) {
                        callback.onError(new Exception("Encrypt return null, it normally occurs when you send a null data"));
                    }
                    callback.onSuccess(strEncrypt);
                } catch (Exception e10) {
                    callback.onError(e10);
                }
            }
        }).start();
    }

    public String encryptOrNull(String str) {
        try {
            return encrypt(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private Encryption(Builder builder) {
        this.mBuilder = builder;
    }
}
