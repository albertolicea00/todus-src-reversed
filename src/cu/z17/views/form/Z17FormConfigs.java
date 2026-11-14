package cu.z17.views.form;

import androidx.compose.runtime.Immutable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J%\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcu/z17/views/form/Z17FormConfigs;", "", "makeRequest", "", "postRoot", "", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(ZLjava/lang/String;Ljava/util/HashMap;)V", "getMakeRequest", "()Z", "getPostRoot", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Z17FormConfigs {
    public static final int $stable = 0;
    private final HashMap<String, String> headers;
    private final boolean makeRequest;
    private final String postRoot;

    public Z17FormConfigs() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Z17FormConfigs copy$default(Z17FormConfigs z17FormConfigs, boolean z10, String str, HashMap map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = z17FormConfigs.makeRequest;
        }
        if ((i10 & 2) != 0) {
            str = z17FormConfigs.postRoot;
        }
        if ((i10 & 4) != 0) {
            map = z17FormConfigs.headers;
        }
        return z17FormConfigs.copy(z10, str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMakeRequest() {
        return this.makeRequest;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPostRoot() {
        return this.postRoot;
    }

    public final HashMap<String, String> component3() {
        return this.headers;
    }

    public final Z17FormConfigs copy(boolean makeRequest, String postRoot, HashMap<String, String> headers) {
        kotlin.jvm.internal.y.i(postRoot, "postRoot");
        kotlin.jvm.internal.y.i(headers, "headers");
        return new Z17FormConfigs(makeRequest, postRoot, headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Z17FormConfigs)) {
            return false;
        }
        Z17FormConfigs z17FormConfigs = (Z17FormConfigs) other;
        return this.makeRequest == z17FormConfigs.makeRequest && kotlin.jvm.internal.y.d(this.postRoot, z17FormConfigs.postRoot) && kotlin.jvm.internal.y.d(this.headers, z17FormConfigs.headers);
    }

    public final HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final boolean getMakeRequest() {
        return this.makeRequest;
    }

    public final String getPostRoot() {
        return this.postRoot;
    }

    public int hashCode() {
        return (((androidx.camera.camera2.adapter.r.a(this.makeRequest) * 31) + this.postRoot.hashCode()) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "Z17FormConfigs(makeRequest=" + this.makeRequest + ", postRoot=" + this.postRoot + ", headers=" + this.headers + ")";
    }

    public Z17FormConfigs(boolean z10, String postRoot, HashMap<String, String> headers) {
        kotlin.jvm.internal.y.i(postRoot, "postRoot");
        kotlin.jvm.internal.y.i(headers, "headers");
        this.makeRequest = z10;
        this.postRoot = postRoot;
        this.headers = headers;
    }

    public /* synthetic */ Z17FormConfigs(boolean z10, String str, HashMap map, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? new HashMap() : map);
    }
}
