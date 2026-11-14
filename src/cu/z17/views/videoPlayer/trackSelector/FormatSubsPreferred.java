package cu.z17.views.videoPlayer.trackSelector;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcu/z17/views/videoPlayer/trackSelector/FormatSubsPreferred;", "Lcu/z17/views/videoPlayer/trackSelector/FormatData;", "language", "", "<init>", "(Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FormatSubsPreferred extends FormatData {
    public static final int $stable = 0;
    private final String language;

    public FormatSubsPreferred(String language) {
        y.i(language, "language");
        this.language = language;
    }

    public static /* synthetic */ FormatSubsPreferred copy$default(FormatSubsPreferred formatSubsPreferred, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = formatSubsPreferred.language;
        }
        return formatSubsPreferred.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final FormatSubsPreferred copy(String language) {
        y.i(language, "language");
        return new FormatSubsPreferred(language);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FormatSubsPreferred) && y.d(this.language, ((FormatSubsPreferred) other).language);
    }

    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        return this.language.hashCode();
    }

    public String toString() {
        return "FormatSubsPreferred(language=" + this.language + ")";
    }
}
