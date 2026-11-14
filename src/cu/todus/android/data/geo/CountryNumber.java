package cu.todus.android.data.geo;

import androidx.compose.runtime.Immutable;
import cu.todus.android.xmpp.extension.sticker.ExtensionSticker;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/geo/CountryNumber;", "", "flag", "", "dialCode", "code", "countryName", "pattern", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFlag", "()Ljava/lang/String;", "getDialCode", "getCode", "getCountryName", "getPattern", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CountryNumber {
    public static final int $stable = 0;

    @c("co")
    private final String code;

    @c("cn")
    private final String countryName;

    @c("dc")
    private final String dialCode;

    @c(ExtensionSticker.TAG_FOLDER)
    private final String flag;

    @c("p")
    private final String pattern;

    public CountryNumber(String flag, String dialCode, String code, String countryName, String pattern) {
        y.i(flag, "flag");
        y.i(dialCode, "dialCode");
        y.i(code, "code");
        y.i(countryName, "countryName");
        y.i(pattern, "pattern");
        this.flag = flag;
        this.dialCode = dialCode;
        this.code = code;
        this.countryName = countryName;
        this.pattern = pattern;
    }

    public static /* synthetic */ CountryNumber copy$default(CountryNumber countryNumber, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = countryNumber.flag;
        }
        if ((i10 & 2) != 0) {
            str2 = countryNumber.dialCode;
        }
        if ((i10 & 4) != 0) {
            str3 = countryNumber.code;
        }
        if ((i10 & 8) != 0) {
            str4 = countryNumber.countryName;
        }
        if ((i10 & 16) != 0) {
            str5 = countryNumber.pattern;
        }
        String str6 = str5;
        String str7 = str3;
        return countryNumber.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFlag() {
        return this.flag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDialCode() {
        return this.dialCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    public final CountryNumber copy(String flag, String dialCode, String code, String countryName, String pattern) {
        y.i(flag, "flag");
        y.i(dialCode, "dialCode");
        y.i(code, "code");
        y.i(countryName, "countryName");
        y.i(pattern, "pattern");
        return new CountryNumber(flag, dialCode, code, countryName, pattern);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryNumber)) {
            return false;
        }
        CountryNumber countryNumber = (CountryNumber) other;
        return y.d(this.flag, countryNumber.flag) && y.d(this.dialCode, countryNumber.dialCode) && y.d(this.code, countryNumber.code) && y.d(this.countryName, countryNumber.countryName) && y.d(this.pattern, countryNumber.pattern);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getDialCode() {
        return this.dialCode;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public int hashCode() {
        return (((((((this.flag.hashCode() * 31) + this.dialCode.hashCode()) * 31) + this.code.hashCode()) * 31) + this.countryName.hashCode()) * 31) + this.pattern.hashCode();
    }

    public String toString() {
        return "CountryNumber(flag=" + this.flag + ", dialCode=" + this.dialCode + ", code=" + this.code + ", countryName=" + this.countryName + ", pattern=" + this.pattern + ")";
    }
}
