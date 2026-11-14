package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.a;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcu/todus/android/data/rest/request/MucInfoRequest;", "", "shareid", "", "<init>", "(Ljava/lang/String;)V", "getShareid", "()Ljava/lang/String;", "setShareid", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MucInfoRequest {
    public static final int $stable = 8;

    @a
    @c("shareid")
    private String shareid;

    public MucInfoRequest(String shareid) {
        y.i(shareid, "shareid");
        this.shareid = shareid;
    }

    public final String getShareid() {
        return this.shareid;
    }

    public final void setShareid(String str) {
        y.i(str, "<set-?>");
        this.shareid = str;
    }
}
