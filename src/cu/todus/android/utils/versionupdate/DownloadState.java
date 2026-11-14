package cu.todus.android.utils.versionupdate;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadState;", "", "<init>", "()V", "Idle", "Progress", "Success", "Error", "Lcu/todus/android/utils/versionupdate/DownloadState$Error;", "Lcu/todus/android/utils/versionupdate/DownloadState$Idle;", "Lcu/todus/android/utils/versionupdate/DownloadState$Progress;", "Lcu/todus/android/utils/versionupdate/DownloadState$Success;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DownloadState {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadState$Error;", "Lcu/todus/android/utils/versionupdate/DownloadState;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Error extends DownloadState {
        public static final int $stable = 0;
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadState$Idle;", "Lcu/todus/android/utils/versionupdate/DownloadState;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Idle extends DownloadState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadState$Progress;", "Lcu/todus/android/utils/versionupdate/DownloadState;", "percent", "", "currentMb", "", "totalMb", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getPercent", "()I", "getCurrentMb", "()Ljava/lang/String;", "getTotalMb", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Progress extends DownloadState {
        public static final int $stable = 0;
        private final String currentMb;
        private final int percent;
        private final String totalMb;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Progress(int i10, String currentMb, String totalMb) {
            super(null);
            y.i(currentMb, "currentMb");
            y.i(totalMb, "totalMb");
            this.percent = i10;
            this.currentMb = currentMb;
            this.totalMb = totalMb;
        }

        public static /* synthetic */ Progress copy$default(Progress progress, int i10, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = progress.percent;
            }
            if ((i11 & 2) != 0) {
                str = progress.currentMb;
            }
            if ((i11 & 4) != 0) {
                str2 = progress.totalMb;
            }
            return progress.copy(i10, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrentMb() {
            return this.currentMb;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTotalMb() {
            return this.totalMb;
        }

        public final Progress copy(int percent, String currentMb, String totalMb) {
            y.i(currentMb, "currentMb");
            y.i(totalMb, "totalMb");
            return new Progress(percent, currentMb, totalMb);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return this.percent == progress.percent && y.d(this.currentMb, progress.currentMb) && y.d(this.totalMb, progress.totalMb);
        }

        public final String getCurrentMb() {
            return this.currentMb;
        }

        public final int getPercent() {
            return this.percent;
        }

        public final String getTotalMb() {
            return this.totalMb;
        }

        public int hashCode() {
            return (((this.percent * 31) + this.currentMb.hashCode()) * 31) + this.totalMb.hashCode();
        }

        public String toString() {
            return "Progress(percent=" + this.percent + ", currentMb=" + this.currentMb + ", totalMb=" + this.totalMb + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadState$Success;", "Lcu/todus/android/utils/versionupdate/DownloadState;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Success extends DownloadState {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    public /* synthetic */ DownloadState(p pVar) {
        this();
    }

    private DownloadState() {
    }
}
