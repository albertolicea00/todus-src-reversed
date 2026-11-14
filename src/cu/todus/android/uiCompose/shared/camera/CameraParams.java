package cu.todus.android.uiCompose.shared.camera;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcu/todus/android/uiCompose/shared/camera/CameraParams;", "", "type", "", "initialPath", "", "videoDuration", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;J)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInitialPath", "()Ljava/lang/String;", "getVideoDuration", "()J", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;J)Lcu/todus/android/uiCompose/shared/camera/CameraParams;", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CameraParams {
    public static final int $stable = 0;
    private final String initialPath;
    private final Integer type;
    private final long videoDuration;

    public CameraParams() {
        this(null, null, 0L, 7, null);
    }

    public static /* synthetic */ CameraParams copy$default(CameraParams cameraParams, Integer num, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = cameraParams.type;
        }
        if ((i10 & 2) != 0) {
            str = cameraParams.initialPath;
        }
        if ((i10 & 4) != 0) {
            j10 = cameraParams.videoDuration;
        }
        return cameraParams.copy(num, str, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInitialPath() {
        return this.initialPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getVideoDuration() {
        return this.videoDuration;
    }

    public final CameraParams copy(Integer type, String initialPath, long videoDuration) {
        return new CameraParams(type, initialPath, videoDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraParams)) {
            return false;
        }
        CameraParams cameraParams = (CameraParams) other;
        return kotlin.jvm.internal.y.d(this.type, cameraParams.type) && kotlin.jvm.internal.y.d(this.initialPath, cameraParams.initialPath) && this.videoDuration == cameraParams.videoDuration;
    }

    public final String getInitialPath() {
        return this.initialPath;
    }

    public final Integer getType() {
        return this.type;
    }

    public final long getVideoDuration() {
        return this.videoDuration;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.initialPath;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + defpackage.l.a(this.videoDuration);
    }

    public String toString() {
        return "CameraParams(type=" + this.type + ", initialPath=" + this.initialPath + ", videoDuration=" + this.videoDuration + ")";
    }

    public CameraParams(Integer num, String str, long j10) {
        this.type = num;
        this.initialPath = str;
        this.videoDuration = j10;
    }

    public /* synthetic */ CameraParams(Integer num, String str, long j10, int i10, kotlin.jvm.internal.p pVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? 0L : j10);
    }
}
