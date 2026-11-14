package cu.z17.preferences.encription;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    private static final int NO_WRAP = 2;
    private static final int URL_SAFE = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static abstract class Coder {
        int op;
        byte[] output;

        private Coder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i10, byte[] bArr) {
            super();
            this.output = bArr;
            this.alphabet = (i10 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        /* JADX WARN: Code duplicated, block: B:42:0x00c0  */
        public boolean process(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.state;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i15 = 0;
            int i16 = i14;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i16 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i15 + 2] = (byte) i16;
                        bArr2[i15 + 1] = (byte) (i16 >> 8);
                        bArr2[i15] = (byte) (i16 >> 16);
                        i15 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                int i20 = i18 + 1;
                int i21 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 != 3) {
                                if (i17 != 4) {
                                    if (i17 == 5 && i21 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                } else if (i21 == -2) {
                                    i17++;
                                } else if (i21 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i21 >= 0) {
                                int i22 = i21 | (i16 << 6);
                                bArr2[i15 + 2] = (byte) i22;
                                bArr2[i15 + 1] = (byte) (i22 >> 8);
                                bArr2[i15] = (byte) (i22 >> 16);
                                i15 += 3;
                                i16 = i22;
                                i17 = 0;
                            } else if (i21 == -2) {
                                bArr2[i15 + 1] = (byte) (i16 >> 2);
                                bArr2[i15] = (byte) (i16 >> 10);
                                i15 += 2;
                                i17 = 5;
                            } else if (i21 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i21 >= 0) {
                            i21 |= i16 << 6;
                            i17++;
                            i16 = i21;
                        } else if (i21 == -2) {
                            bArr2[i15] = (byte) (i16 >> 4);
                            i15++;
                            i17 = 4;
                        } else if (i21 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i21 >= 0) {
                        i21 |= i16 << 6;
                        i17++;
                        i16 = i21;
                    } else if (i21 != -1) {
                        this.state = 6;
                        return false;
                    }
                } else if (i21 >= 0) {
                    i17++;
                    i16 = i21;
                } else if (i21 != -1) {
                    this.state = 6;
                    return false;
                }
                i18 = i20;
            }
            if (!z10) {
                this.state = i17;
                this.value = i16;
                this.op = i15;
                return true;
            }
            if (i17 == 1) {
                this.state = 6;
                return false;
            }
            if (i17 == 2) {
                bArr2[i15] = (byte) (i16 >> 4);
                i15++;
            } else if (i17 == 3) {
                int i23 = i15 + 1;
                bArr2[i15] = (byte) (i16 >> 10);
                i15 += 2;
                bArr2[i23] = (byte) (i16 >> 2);
            } else if (i17 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i17;
            this.op = i15;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        final boolean do_cr;
        final boolean do_newline;
        final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i10, byte[] bArr) {
            super();
            this.output = bArr;
            this.do_padding = (i10 & 1) == 0;
            boolean z10 = (i10 & 2) == 0;
            this.do_newline = z10;
            this.do_cr = (i10 & 4) != 0;
            this.alphabet = (i10 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z10 ? 19 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0050  */
        public void process(byte[] bArr, int i10, int i11, boolean z10) {
            int i12;
            int i13;
            int i14;
            int i15;
            byte b10;
            byte b11;
            byte b12;
            int i16;
            int i17;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i18 = this.count;
            int i19 = i11 + i10;
            int i20 = this.tailLen;
            char c10 = 2;
            int i21 = 0;
            if (i20 != 1) {
                if (i20 == 2 && (i17 = i10 + 1) <= i19) {
                    byte[] bArr4 = this.tail;
                    i13 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i10] & 255);
                    this.tailLen = 0;
                    i12 = i17;
                } else {
                    i12 = i10;
                    i13 = -1;
                }
            } else if (i10 + 2 <= i19) {
                i12 = i10 + 2;
                i13 = (bArr[i10 + 1] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i10] & 255) << 8);
                this.tailLen = 0;
            } else {
                i12 = i10;
                i13 = -1;
            }
            if (i13 != -1) {
                bArr3[0] = bArr2[(i13 >> 18) & 63];
                bArr3[1] = bArr2[(i13 >> 12) & 63];
                bArr3[2] = bArr2[(i13 >> 6) & 63];
                bArr3[3] = bArr2[i13 & 63];
                i18--;
                if (i18 == 0) {
                    if (this.do_cr) {
                        bArr3[4] = Ascii.CR;
                        i16 = 5;
                    } else {
                        i16 = 4;
                    }
                    i14 = i16 + 1;
                    bArr3[i16] = 10;
                    i18 = 19;
                } else {
                    i14 = 4;
                }
            } else {
                i14 = 0;
            }
            while (true) {
                i12 += 3;
                if (i12 > i19) {
                    break;
                }
                c10 = c10;
                int i22 = ((bArr[i12 + 1] & 255) << 8) | ((bArr[i12] & 255) << 16) | (bArr[i12 + 2] & 255);
                bArr3[i14] = bArr2[(i22 >> 18) & 63];
                bArr3[i14 + 1] = bArr2[(i22 >> 12) & 63];
                bArr3[i14 + 2] = bArr2[(i22 >> 6) & 63];
                bArr3[i14 + 3] = bArr2[i22 & 63];
                int i23 = i14 + 4;
                i18--;
                if (i18 == 0) {
                    if (this.do_cr) {
                        bArr3[i23] = Ascii.CR;
                        i23 = i14 + 5;
                    }
                    i14 = i23 + 1;
                    bArr3[i23] = 10;
                    i18 = 19;
                } else {
                    i14 = i23;
                }
            }
            if (z10) {
                int i24 = this.tailLen;
                if (i12 - i24 == i19 - 1) {
                    if (i24 > 0) {
                        b12 = this.tail[0];
                        i21 = 1;
                    } else {
                        b12 = bArr[i12];
                    }
                    int i25 = (b12 & 255) << 4;
                    this.tailLen = i24 - i21;
                    bArr3[i14] = bArr2[(i25 >> 6) & 63];
                    int i26 = i14 + 2;
                    bArr3[i14 + 1] = bArr2[i25 & 63];
                    if (this.do_padding) {
                        bArr3[i26] = 61;
                        i26 = i14 + 4;
                        bArr3[i14 + 3] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i26] = Ascii.CR;
                            i26++;
                        }
                        i15 = i26 + 1;
                        bArr3[i26] = 10;
                        i14 = i15;
                    } else {
                        i14 = i26;
                    }
                } else if (i12 - i24 == i19 - 2) {
                    if (i24 > 1) {
                        b10 = this.tail[0];
                        i21 = 1;
                    } else {
                        byte b13 = bArr[i12];
                        i12++;
                        b10 = b13;
                    }
                    int i27 = (b10 & 255) << 10;
                    if (i24 > 0) {
                        b11 = this.tail[i21];
                        i21++;
                    } else {
                        b11 = bArr[i12];
                    }
                    int i28 = i27 | ((b11 & 255) << 2);
                    this.tailLen = i24 - i21;
                    bArr3[i14] = bArr2[(i28 >> 12) & 63];
                    bArr3[i14 + 1] = bArr2[(i28 >> 6) & 63];
                    int i29 = i14 + 3;
                    bArr3[i14 + 2] = bArr2[i28 & 63];
                    if (this.do_padding) {
                        bArr3[i29] = 61;
                        i29 = i14 + 4;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i29] = Ascii.CR;
                            i29++;
                        }
                        i15 = i29 + 1;
                        bArr3[i29] = 10;
                        i14 = i15;
                    } else {
                        i14 = i29;
                    }
                } else if (this.do_newline && i14 > 0 && i18 != 19) {
                    if (this.do_cr) {
                        bArr3[i14] = Ascii.CR;
                        i14++;
                    }
                    i15 = i14 + 1;
                    bArr3[i14] = 10;
                    i14 = i15;
                }
            } else if (i12 == i19 - 1) {
                byte[] bArr5 = this.tail;
                int i30 = this.tailLen;
                this.tailLen = i30 + 1;
                bArr5[i30] = bArr[i12];
            } else if (i12 == i19 - 2) {
                byte[] bArr6 = this.tail;
                int i31 = this.tailLen;
                int i32 = i31 + 1;
                this.tailLen = i32;
                bArr6[i31] = bArr[i12];
                this.tailLen = i31 + 2;
                bArr6[i32] = bArr[i12 + 1];
            }
            this.op = i14;
            this.count = i18;
        }
    }

    private Base64() {
    }

    public static byte[] decode(String str, int i10) {
        return decode(str.getBytes(), i10);
    }

    private static byte[] encode(byte[] bArr, int i10) {
        return encode(bArr, 0, bArr.length, i10);
    }

    public static String encodeToString(byte[] bArr, int i10) {
        try {
            return new String(encode(bArr, i10), StringUtils.USASCII);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    private static byte[] decode(byte[] bArr, int i10) {
        return decode(bArr, 0, bArr.length, i10);
    }

    private static byte[] encode(byte[] bArr, int i10, int i11, int i12) {
        Encoder encoder = new Encoder(i12, null);
        int i13 = (i11 / 3) * 4;
        if (!encoder.do_padding) {
            int i14 = i11 % 3;
            if (i14 == 1) {
                i13 += 2;
            } else if (i14 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (encoder.do_newline && i11 > 0) {
            i13 += (((i11 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i13];
        encoder.process(bArr, i10, i11, true);
        return encoder.output;
    }

    private static byte[] decode(byte[] bArr, int i10, int i11, int i12) {
        Decoder decoder = new Decoder(i12, new byte[(i11 * 3) / 4]);
        if (decoder.process(bArr, i10, i11, true)) {
            int i13 = decoder.op;
            byte[] bArr2 = decoder.output;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
