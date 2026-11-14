package cu.todus.android.uiCompose.main.screen.statusPreview;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/statusPreview/StatusPreviewParams;", "", "fromOwner", "", "startPoint", "", "startId", "", "<init>", "(ZILjava/lang/String;)V", "getFromOwner", "()Z", "getStartPoint", "()I", "getStartId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StatusPreviewParams {
    public static final int $stable = 0;
    private final boolean fromOwner;
    private final String startId;
    private final int startPoint;

    public StatusPreviewParams(boolean z10, int i10, String startId) {
        kotlin.jvm.internal.y.i(startId, "startId");
        this.fromOwner = z10;
        this.startPoint = i10;
        this.startId = startId;
    }

    public static /* synthetic */ StatusPreviewParams copy$default(StatusPreviewParams statusPreviewParams, boolean z10, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = statusPreviewParams.fromOwner;
        }
        if ((i11 & 2) != 0) {
            i10 = statusPreviewParams.startPoint;
        }
        if ((i11 & 4) != 0) {
            str = statusPreviewParams.startId;
        }
        return statusPreviewParams.copy(z10, i10, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getFromOwner() {
        return this.fromOwner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStartPoint() {
        return this.startPoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStartId() {
        return this.startId;
    }

    public final StatusPreviewParams copy(boolean fromOwner, int startPoint, String startId) {
        kotlin.jvm.internal.y.i(startId, "startId");
        return new StatusPreviewParams(fromOwner, startPoint, startId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusPreviewParams)) {
            return false;
        }
        StatusPreviewParams statusPreviewParams = (StatusPreviewParams) other;
        return this.fromOwner == statusPreviewParams.fromOwner && this.startPoint == statusPreviewParams.startPoint && kotlin.jvm.internal.y.d(this.startId, statusPreviewParams.startId);
    }

    public final boolean getFromOwner() {
        return this.fromOwner;
    }

    public final String getStartId() {
        return this.startId;
    }

    public final int getStartPoint() {
        return this.startPoint;
    }

    public int hashCode() {
        return (((androidx.camera.camera2.adapter.r.a(this.fromOwner) * 31) + this.startPoint) * 31) + this.startId.hashCode();
    }

    public String toString() {
        return "StatusPreviewParams(fromOwner=" + this.fromOwner + ", startPoint=" + this.startPoint + ", startId=" + this.startId + ")";
    }

    public /* synthetic */ StatusPreviewParams(boolean z10, int i10, String str, int i11, kotlin.jvm.internal.p pVar) {
        this((i11 & 1) != 0 ? false : z10, i10, str);
    }
}
