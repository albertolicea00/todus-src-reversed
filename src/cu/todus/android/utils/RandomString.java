package cu.todus.android.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcu/todus/android/utils/RandomString;", "", "length", "", "random", "Ljava/util/Random;", "symbols", "", "<init>", "(ILjava/util/Random;Ljava/lang/String;)V", "", "buf", "nextString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RandomString {
    private static final String alphanum;
    public static final String digits = "0123456789";
    private static final String lower;
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] buf;
    private final Random random;
    private final char[] symbols;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcu/todus/android/utils/RandomString$Companion;", "", "<init>", "()V", "upper", "", "lower", "digits", "alphanum", "getAlphanum", "()Ljava/lang/String;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final String getAlphanum() {
            return RandomString.alphanum;
        }

        private Companion() {
        }
    }

    static {
        Locale ROOT = Locale.ROOT;
        y.h(ROOT, "ROOT");
        String lowerCase = upper.toLowerCase(ROOT);
        y.h(lowerCase, "toLowerCase(...)");
        lower = lowerCase;
        alphanum = upper + lowerCase + digits;
    }

    public RandomString() {
        this(0, null, null, 7, null);
    }

    public final String nextString() {
        int length = this.buf.length;
        for (int i10 = 0; i10 < length; i10++) {
            char[] cArr = this.buf;
            char[] cArr2 = this.symbols;
            cArr[i10] = cArr2[this.random.nextInt(cArr2.length)];
        }
        return new String(this.buf);
    }

    public RandomString(int i10) {
        this(i10, null, null, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RandomString(int i10, Random random) {
        this(i10, random, null, 4, null);
        y.i(random, "random");
    }

    public RandomString(int i10, Random random, String symbols) {
        y.i(random, "random");
        y.i(symbols, "symbols");
        if (i10 >= 1) {
            if (symbols.length() >= 2) {
                this.random = random;
                char[] charArray = symbols.toCharArray();
                y.h(charArray, "toCharArray(...)");
                this.symbols = charArray;
                this.buf = new char[i10];
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public /* synthetic */ RandomString(int i10, Random random, String str, int i11, p pVar) {
        this((i11 & 1) != 0 ? 21 : i10, (i11 & 2) != 0 ? new SecureRandom() : random, (i11 & 4) != 0 ? alphanum : str);
    }
}
