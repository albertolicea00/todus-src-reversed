package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/xmpp/TurnUri;", "", "uri", "", "proto", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getProto", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TurnUri {
    public static final int $stable = 0;
    private final String proto;
    private final String uri;

    public TurnUri(String uri, String proto) {
        y.i(uri, "uri");
        y.i(proto, "proto");
        this.uri = uri;
        this.proto = proto;
    }

    public static /* synthetic */ TurnUri copy$default(TurnUri turnUri, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = turnUri.uri;
        }
        if ((i10 & 2) != 0) {
            str2 = turnUri.proto;
        }
        return turnUri.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProto() {
        return this.proto;
    }

    public final TurnUri copy(String uri, String proto) {
        y.i(uri, "uri");
        y.i(proto, "proto");
        return new TurnUri(uri, proto);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TurnUri)) {
            return false;
        }
        TurnUri turnUri = (TurnUri) other;
        return y.d(this.uri, turnUri.uri) && y.d(this.proto, turnUri.proto);
    }

    public final String getProto() {
        return this.proto;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.proto.hashCode();
    }

    public String toString() {
        return "TurnUri(uri=" + this.uri + ", proto=" + this.proto + ")";
    }
}
