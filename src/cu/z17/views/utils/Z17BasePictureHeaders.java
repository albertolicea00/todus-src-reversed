package cu.z17.views.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.z17.singledi.SingletonInitializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import nf.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcu/z17/views/utils/Z17BasePictureHeaders;", "", "", "", "headers", "<init>", "(Ljava/util/Map;)V", "Lnf/x;", "getHeaders", "()Lnf/x;", "newHeaders", "Lua/k0;", "updateHeaders", "", "thereAreHeaders", "()Z", "Ljava/util/Map;", "_h", "Lnf/x;", "Companion", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17BasePictureHeaders {
    private x _h;
    private final Map<String, String> headers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcu/z17/views/utils/Z17BasePictureHeaders$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/z17/views/utils/Z17BasePictureHeaders;", "<init>", "()V", "", "", "map", "Lnf/x;", "fromMapToHeaders", "(Ljava/util/Map;)Lnf/x;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<Z17BasePictureHeaders> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final x fromMapToHeaders(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            x.a aVar = new x.a();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
            return aVar.f();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Z17BasePictureHeaders() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: getHeaders, reason: from getter */
    public final x get_h() {
        return this._h;
    }

    public final boolean thereAreHeaders() {
        return this._h != null;
    }

    public final void updateHeaders(Map<String, String> newHeaders) {
        y.i(newHeaders, "newHeaders");
        this._h = INSTANCE.fromMapToHeaders(newHeaders);
    }

    public Z17BasePictureHeaders(Map<String, String> map) {
        this.headers = map;
        if (map != null) {
            updateHeaders(map);
        }
    }

    public /* synthetic */ Z17BasePictureHeaders(Map map, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? null : map);
    }
}
