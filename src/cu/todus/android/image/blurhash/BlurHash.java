package cu.todus.android.image.blurhash;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public final class BlurHash {
    private BlurHash() {
    }

    private static void applyBasisFunction(int[] iArr, int i10, int i11, double d10, int i12, int i13, double[][] dArr, int i14) {
        double d11 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d12 = 0.0d;
        double dSRGBToLinear = 0.0d;
        for (int i15 = 0; i15 < i10; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                double d13 = d11;
                double dCos = Math.cos(((((double) i12) * 3.141592653589793d) * ((double) i15)) / ((double) i10)) * d10 * Math.cos(((((double) i13) * 3.141592653589793d) * ((double) i16)) / ((double) i11));
                int i17 = iArr[(i16 * i10) + i15];
                double dSRGBToLinear2 = d13 + (Utils.sRGBToLinear((i17 >> 16) & 255) * dCos);
                double dSRGBToLinear3 = d12 + (Utils.sRGBToLinear((i17 >> 8) & 255) * dCos);
                dSRGBToLinear += dCos * Utils.sRGBToLinear(i17 & 255);
                i16++;
                d12 = dSRGBToLinear3;
                d11 = dSRGBToLinear2;
                i10 = i10;
                i11 = i11;
            }
        }
        double d14 = 1.0d / ((double) (i10 * i11));
        double[] dArr2 = dArr[i14];
        dArr2[0] = d11 * d14;
        dArr2[1] = d12 * d14;
        dArr2[2] = dSRGBToLinear * d14;
    }

    public static String encode(Bitmap bitmap) {
        return encode(bitmap, 4, 4);
    }

    private static long encodeAC(double[] dArr, double d10) {
        return Math.round((Math.floor(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(18.0d, Math.floor((Utils.signPow(dArr[0] / d10, 0.5d) * 9.0d) + 9.5d)))) * 19.0d * 19.0d) + (Math.floor(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(18.0d, Math.floor((Utils.signPow(dArr[1] / d10, 0.5d) * 9.0d) + 9.5d)))) * 19.0d) + Math.floor(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(18.0d, Math.floor((Utils.signPow(dArr[2] / d10, 0.5d) * 9.0d) + 9.5d)))));
    }

    private static long encodeDC(double[] dArr) {
        return (Utils.linearTosRGB(dArr[0]) << 16) + (Utils.linearTosRGB(dArr[1]) << 8) + Utils.linearTosRGB(dArr[2]);
    }

    public static String encode(Bitmap bitmap, int i10, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[height * width];
        bitmap.getPixels(iArr, 0, width, 0, 0, width - 1, height - 1);
        return encode(iArr, width, height, i10, i11);
    }

    public static String encode(int[] iArr, int i10, int i11, int i12, int i13) {
        double d10;
        if (i12 >= 1 && i12 <= 9 && i13 >= 1 && i13 <= 9) {
            int[] iArr2 = iArr;
            if (i10 * i11 == iArr2.length) {
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12 * i13, 3);
                int i14 = 0;
                while (true) {
                    d10 = 1.0d;
                    if (i14 >= i13) {
                        break;
                    }
                    int i15 = 0;
                    while (i15 < i12) {
                        applyBasisFunction(iArr2, i10, i11, (i15 == 0 && i14 == 0) ? 1.0d : 2.0d, i15, i14, dArr, (i14 * i12) + i15);
                        i15++;
                        iArr2 = iArr;
                    }
                    i14++;
                    iArr2 = iArr;
                }
                char[] cArr = new char[((dArr.length - 1) * 2) + 6];
                Base83.encode((i12 - 1) + ((i13 - 1) * 9), 1, cArr, 0);
                if (dArr.length > 1) {
                    double dFloor = Math.floor(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(82.0d, Math.floor((Utils.max(dArr, 1, dArr.length) * 166.0d) - 0.5d))));
                    d10 = (dFloor + 1.0d) / 166.0d;
                    Base83.encode(Math.round(dFloor), 1, cArr, 1);
                } else {
                    Base83.encode(0L, 1, cArr, 1);
                }
                double d11 = d10;
                Base83.encode(encodeDC(dArr[0]), 4, cArr, 2);
                for (int i16 = 1; i16 < dArr.length; i16++) {
                    Base83.encode(encodeAC(dArr[i16], d11), 2, cArr, ((i16 - 1) * 2) + 6);
                }
                return new String(cArr);
            }
            throw new IllegalArgumentException("Width and height must match the pixels array");
        }
        throw new IllegalArgumentException("Blur hash must have between 1 and 9 components");
    }
}
