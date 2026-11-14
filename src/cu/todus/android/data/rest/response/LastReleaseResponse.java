package cu.todus.android.data.rest.response;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.rest.entity.LastRelease;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcu/todus/android/data/rest/response/LastReleaseResponse;", "", "id", "", "last_release", "Lcu/todus/android/data/rest/entity/LastRelease;", "<init>", "(JLcu/todus/android/data/rest/entity/LastRelease;)V", "getId", "()J", "getLast_release", "()Lcu/todus/android/data/rest/entity/LastRelease;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LastReleaseResponse {
    public static final int $stable = 0;
    public static final String url = "https://www.apklis.cu/application/cu.todus.android";
    private final long id;
    private final LastRelease last_release;

    public LastReleaseResponse(long j10, LastRelease last_release) {
        y.i(last_release, "last_release");
        this.id = j10;
        this.last_release = last_release;
    }

    public final long getId() {
        return this.id;
    }

    public final LastRelease getLast_release() {
        return this.last_release;
    }
}
