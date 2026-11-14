package cu.todus.android.s3.upload;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcu/todus/android/s3/upload/DirectUploadState;", "", "numBytes", "", "totalBytes", "percent", "", "speed", "status", "", "<init>", "(JJFFI)V", "getNumBytes", "()J", "setNumBytes", "(J)V", "getTotalBytes", "setTotalBytes", "getPercent", "()F", "setPercent", "(F)V", "getSpeed", "setSpeed", "getStatus", "()I", "setStatus", "(I)V", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DirectUploadState {
    public static final int CANCELED = 4;
    public static final int COMPLETE = 2;
    public static final int ERROR = 3;
    public static final int LOADING = 5;
    public static final int NOT_REQUESTED = -1;
    public static final int PROGRESS = 1;
    public static final int START = 0;
    private long numBytes;
    private float percent;
    private float speed;
    private int status;
    private long totalBytes;
    public static final int $stable = 8;

    public DirectUploadState() {
        this(0L, 0L, 0.0f, 0.0f, 0, 31, null);
    }

    public final long getNumBytes() {
        return this.numBytes;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void setNumBytes(long j10) {
        this.numBytes = j10;
    }

    public final void setPercent(float f10) {
        this.percent = f10;
    }

    public final void setSpeed(float f10) {
        this.speed = f10;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public final void setTotalBytes(long j10) {
        this.totalBytes = j10;
    }

    public DirectUploadState(long j10, long j11, float f10, float f11, int i10) {
        this.numBytes = j10;
        this.totalBytes = j11;
        this.percent = f10;
        this.speed = f11;
        this.status = i10;
    }

    public /* synthetic */ DirectUploadState(long j10, long j11, float f10, float f11, int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0L : j10, (i11 & 2) != 0 ? 0L : j11, (i11 & 4) != 0 ? 0.0f : f10, (i11 & 8) != 0 ? 0.0f : f11, (i11 & 16) != 0 ? 4 : i10);
    }
}
