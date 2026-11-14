package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcu/todus/android/data/rest/response/UrlResponse;", "", "url", "", "version", "", "<init>", "(Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UrlResponse {
    public static final int $stable = 0;
    private final String url;
    private final int version;

    public UrlResponse(String url, int i10) {
        y.i(url, "url");
        this.url = url;
        this.version = i10;
    }

    public static /* synthetic */ UrlResponse copy$default(UrlResponse urlResponse, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = urlResponse.url;
        }
        if ((i11 & 2) != 0) {
            i10 = urlResponse.version;
        }
        return urlResponse.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final UrlResponse copy(String url, int version) {
        y.i(url, "url");
        return new UrlResponse(url, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UrlResponse)) {
            return false;
        }
        UrlResponse urlResponse = (UrlResponse) other;
        return y.d(this.url, urlResponse.url) && this.version == urlResponse.version;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.version;
    }

    public String toString() {
        return "UrlResponse(url=" + this.url + ", version=" + this.version + ")";
    }

    public /* synthetic */ UrlResponse(String str, int i10, int i11, p pVar) {
        this(str, (i11 & 2) != 0 ? 0 : i10);
    }
}
