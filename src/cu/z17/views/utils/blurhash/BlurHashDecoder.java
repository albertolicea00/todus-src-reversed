package cu.z17.views.utils.blurhash;

import ab.e;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cb.b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;
import rb.k;
import ua.z;
import va.w;
import va.w0;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJF\u0010(\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130#2\u0006\u0010&\u001a\u00020%H\u0082@¢\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020+2\u0006\u0010*\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010-J;\u00104\u001a\u000203*\u00020+2\u0006\u0010*\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u00107J\r\u00109\u001a\u000208¢\u0006\u0004\b9\u0010\u0003J@\u0010<\u001a\u0004\u0018\u00010'2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020%H\u0086@¢\u0006\u0004\b<\u0010=R0\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0>j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+`?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR0\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0>j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+`?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010AR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00040C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcu/z17/views/utils/blurhash/BlurHashDecoder;", "", "<init>", "()V", "", "sourceWidth", "sourceHeight", "dWidth", "dHeight", "Lkotlin/Pair;", "getSizeAdjustedToAspectRatio", "(IIII)Lkotlin/Pair;", "", "str", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "decode83", "(Ljava/lang/String;II)I", "colorEnc", "", "decodeDc", "(I)[F", "", "srgbToLinear", "(I)F", AppMeasurementSdk.ConditionalUserProperty.VALUE, "maxAc", "decodeAc", "(IF)[F", "signedPow2", "(F)F", "width", "height", "numCompX", "numCompY", "", "colors", "", "useCache", "Landroid/graphics/Bitmap;", "composeBitmap", "(IIII[[FZLab/e;)Ljava/lang/Object;", "calculate", "", "getArrayForCosinesY", "(ZII)[D", "getArrayForCosinesX", "x", "numComp", "y", "size", "", "getCos", "([DZIIII)D", "linearToSrgb", "(F)I", "Lua/k0;", "clearCache", "blurHash", "punch", "decode", "(Ljava/lang/String;IIFZLab/e;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cacheCosinesX", "Ljava/util/HashMap;", "cacheCosinesY", "", "", "charMap", "Ljava/util/Map;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BlurHashDecoder {
    public static final int $stable;
    public static final BlurHashDecoder INSTANCE = new BlurHashDecoder();
    private static final HashMap<Integer, double[]> cacheCosinesX = new HashMap<>();
    private static final HashMap<Integer, double[]> cacheCosinesY = new HashMap<>();
    private static final Map<Character, Integer> charMap;

    static {
        List listQ = w.q('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~');
        ArrayList arrayList = new ArrayList(x.y(listQ, 10));
        int i10 = 0;
        for (Object obj : listQ) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                w.x();
            }
            Character ch2 = (Character) obj;
            ch2.charValue();
            arrayList.add(z.a(ch2, Integer.valueOf(i10)));
            i10 = i11;
        }
        charMap = w0.t(arrayList);
        $stable = 8;
    }

    private BlurHashDecoder() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object composeBitmap(int i10, int i11, int i12, int i13, float[][] fArr, boolean z10, e<? super Bitmap> eVar) {
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int[] iArr = new int[i14 * i15];
        boolean z11 = (z10 && cacheCosinesX.containsKey(b.d(i14 * i16))) ? false : true;
        double[] arrayForCosinesX = getArrayForCosinesX(z11, i14, i16);
        boolean z12 = (z10 && cacheCosinesY.containsKey(b.d(i15 * i17))) ? false : true;
        double[] arrayForCosinesY = getArrayForCosinesY(z12, i15, i17);
        int i18 = 0;
        while (i18 < i15) {
            int i19 = 0;
            while (i19 < i14) {
                float f10 = 0.0f;
                float f11 = 0.0f;
                float f12 = 0.0f;
                int i20 = 0;
                while (i20 < i17) {
                    float f13 = f12;
                    float f14 = f11;
                    float f15 = f10;
                    int i21 = 0;
                    while (i21 < i16) {
                        double cos = getCos(arrayForCosinesX, z11, i21, i16, i19, i14);
                        int i22 = i15;
                        int i23 = i17;
                        double[] dArr = arrayForCosinesX;
                        double[] dArr2 = arrayForCosinesY;
                        int i24 = i21;
                        int i25 = i20;
                        boolean z13 = z11;
                        boolean z14 = z12;
                        int i26 = i19;
                        int i27 = i18;
                        float cos2 = (float) (cos * getCos(dArr2, z14, i25, i23, i27, i22));
                        float[] fArr2 = fArr[(i25 * i12) + i24];
                        f15 += fArr2[0] * cos2;
                        f13 += fArr2[1] * cos2;
                        f14 += fArr2[2] * cos2;
                        int i28 = i24 + 1;
                        i15 = i22;
                        i14 = i14;
                        arrayForCosinesY = dArr2;
                        i18 = i27;
                        z11 = z13;
                        i19 = i26;
                        i16 = i12;
                        z12 = z14;
                        i20 = i25;
                        i21 = i28;
                        arrayForCosinesX = dArr;
                        i17 = i13;
                    }
                    i15 = i15;
                    i14 = i14;
                    f10 = f15;
                    z11 = z11;
                    i19 = i19;
                    f11 = f14;
                    f12 = f13;
                    i16 = i12;
                    z12 = z12;
                    i20++;
                    arrayForCosinesX = arrayForCosinesX;
                    i17 = i13;
                }
                int i29 = i15;
                int i30 = i14;
                double[] dArr3 = arrayForCosinesX;
                boolean z15 = z12;
                int i31 = i19;
                iArr[(i30 * i18) + i31] = Color.rgb(linearToSrgb(f10), linearToSrgb(f12), linearToSrgb(f11));
                int i32 = i31 + 1;
                i15 = i29;
                i14 = i30;
                z12 = z15;
                z11 = z11;
                i16 = i12;
                i19 = i32;
                arrayForCosinesX = dArr3;
                i17 = i13;
            }
            i18++;
            i15 = i15;
            i14 = i14;
            arrayForCosinesX = arrayForCosinesX;
            i16 = i12;
            i17 = i13;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, i14, i15, Bitmap.Config.ARGB_8888);
        y.h(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Object decode$default(BlurHashDecoder blurHashDecoder, String str, int i10, int i11, float f10, boolean z10, e eVar, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            f10 = 1.0f;
        }
        float f11 = f10;
        if ((i12 & 16) != 0) {
            z10 = true;
        }
        return blurHashDecoder.decode(str, i10, i11, f11, z10, eVar);
    }

    private final int decode83(String str, int from, int to) {
        int i10 = 0;
        while (from < to) {
            Integer num = charMap.get(Character.valueOf(str.charAt(from)));
            int iIntValue = num != null ? num.intValue() : -1;
            if (iIntValue != -1) {
                i10 = (i10 * 83) + iIntValue;
            }
            from++;
        }
        return i10;
    }

    public static /* synthetic */ int decode83$default(BlurHashDecoder blurHashDecoder, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return blurHashDecoder.decode83(str, i10, i11);
    }

    private final float[] decodeAc(int value, float maxAc) {
        return new float[]{signedPow2(((value / 361) - 9) / 9.0f) * maxAc, signedPow2((((value / 19) % 19) - 9) / 9.0f) * maxAc, signedPow2(((value % 19) - 9) / 9.0f) * maxAc};
    }

    private final float[] decodeDc(int colorEnc) {
        return new float[]{srgbToLinear(colorEnc >> 16), srgbToLinear((colorEnc >> 8) & 255), srgbToLinear(colorEnc & 255)};
    }

    private final double[] getArrayForCosinesX(boolean calculate, int width, int numCompX) {
        if (!calculate) {
            double[] dArr = cacheCosinesX.get(Integer.valueOf(width * numCompX));
            y.f(dArr);
            return dArr;
        }
        int i10 = width * numCompX;
        double[] dArr2 = new double[i10];
        cacheCosinesX.put(Integer.valueOf(i10), dArr2);
        return dArr2;
    }

    private final double[] getArrayForCosinesY(boolean calculate, int height, int numCompY) {
        if (!calculate) {
            double[] dArr = cacheCosinesY.get(Integer.valueOf(height * numCompY));
            y.f(dArr);
            return dArr;
        }
        int i10 = height * numCompY;
        double[] dArr2 = new double[i10];
        cacheCosinesY.put(Integer.valueOf(i10), dArr2);
        return dArr2;
    }

    private final double getCos(double[] dArr, boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            dArr[(i11 * i12) + i10] = Math.cos(((((double) i12) * 3.141592653589793d) * ((double) i10)) / ((double) i13));
        }
        return dArr[i10 + (i11 * i12)];
    }

    private final Pair<Integer, Integer> getSizeAdjustedToAspectRatio(int sourceWidth, int sourceHeight, int dWidth, int dHeight) {
        if (sourceWidth > sourceHeight) {
            dHeight = (sourceHeight * dWidth) / sourceWidth;
        } else {
            dWidth = (sourceWidth * dHeight) / sourceHeight;
        }
        return z.a(Integer.valueOf(dWidth), Integer.valueOf(dHeight));
    }

    public static /* synthetic */ Pair getSizeAdjustedToAspectRatio$default(BlurHashDecoder blurHashDecoder, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i12 = 150;
        }
        if ((i14 & 8) != 0) {
            i13 = 150;
        }
        return blurHashDecoder.getSizeAdjustedToAspectRatio(i10, i11, i12, i13);
    }

    private final int linearToSrgb(float value) {
        float fPow;
        float f10;
        float fN = k.n(value, 0.0f, 1.0f);
        if (fN <= 0.0031308f) {
            fPow = fN * 12.92f;
            f10 = 255.0f;
        } else {
            fPow = (((float) Math.pow(fN, 0.41666666f)) * 1.055f) - 0.055f;
            f10 = 255;
        }
        return (int) ((fPow * f10) + 0.5f);
    }

    private final float signedPow2(float value) {
        return Math.copySign((float) Math.pow(value, 2.0f), value);
    }

    private final float srgbToLinear(int colorEnc) {
        float f10 = colorEnc / 255.0f;
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4f);
    }

    public final void clearCache() {
        cacheCosinesX.clear();
        cacheCosinesY.clear();
    }

    public final Object decode(String str, int i10, int i11, float f10, boolean z10, e<? super Bitmap> eVar) {
        float[] fArrDecodeAc;
        if (str == null || str.length() < 6) {
            return null;
        }
        int iDecode83 = decode83(str, 0, 1);
        int i12 = (iDecode83 % 9) + 1;
        int i13 = (iDecode83 / 9) + 1;
        if (str.length() != (i12 * 2 * i13) + 4) {
            return null;
        }
        float fDecode83 = (decode83(str, 1, 2) + 1) / 166.0f;
        int i14 = i12 * i13;
        float[][] fArr = new float[i14][];
        for (int i15 = 0; i15 < i14; i15++) {
            if (i15 == 0) {
                BlurHashDecoder blurHashDecoder = INSTANCE;
                fArrDecodeAc = blurHashDecoder.decodeDc(blurHashDecoder.decode83(str, 2, 6));
            } else {
                int i16 = i15 * 2;
                BlurHashDecoder blurHashDecoder2 = INSTANCE;
                fArrDecodeAc = blurHashDecoder2.decodeAc(blurHashDecoder2.decode83(str, i16 + 4, i16 + 6), fDecode83 * f10);
            }
            fArr[i15] = fArrDecodeAc;
        }
        Pair sizeAdjustedToAspectRatio$default = getSizeAdjustedToAspectRatio$default(this, i10, i11, 0, 0, 12, null);
        return composeBitmap(((Number) sizeAdjustedToAspectRatio$default.getFirst()).intValue(), ((Number) sizeAdjustedToAspectRatio$default.getSecond()).intValue(), i12, i13, fArr, z10, eVar);
    }
}
