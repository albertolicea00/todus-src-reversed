package cu.todus.android.connection;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lcu/todus/android/connection/ConnectionStatus;", "", "download", "Lcu/todus/android/connection/SpeedResult;", "upload", "<init>", "(Lcu/todus/android/connection/SpeedResult;Lcu/todus/android/connection/SpeedResult;)V", "getDownload", "()Lcu/todus/android/connection/SpeedResult;", "getUpload", "getDownloadQuality", "Lcu/todus/android/connection/Quality;", "getUploadQuality", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConnectionStatus {
    public static final int $stable = 0;
    private final SpeedResult download;
    private final SpeedResult upload;

    public ConnectionStatus(SpeedResult download, SpeedResult upload) {
        y.i(download, "download");
        y.i(upload, "upload");
        this.download = download;
        this.upload = upload;
    }

    public static /* synthetic */ ConnectionStatus copy$default(ConnectionStatus connectionStatus, SpeedResult speedResult, SpeedResult speedResult2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            speedResult = connectionStatus.download;
        }
        if ((i10 & 2) != 0) {
            speedResult2 = connectionStatus.upload;
        }
        return connectionStatus.copy(speedResult, speedResult2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SpeedResult getDownload() {
        return this.download;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SpeedResult getUpload() {
        return this.upload;
    }

    public final ConnectionStatus copy(SpeedResult download, SpeedResult upload) {
        y.i(download, "download");
        y.i(upload, "upload");
        return new ConnectionStatus(download, upload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionStatus)) {
            return false;
        }
        ConnectionStatus connectionStatus = (ConnectionStatus) other;
        return this.download == connectionStatus.download && this.upload == connectionStatus.upload;
    }

    public final SpeedResult getDownload() {
        return this.download;
    }

    public final Quality getDownloadQuality() {
        return this.download.getGetQuality();
    }

    public final SpeedResult getUpload() {
        return this.upload;
    }

    public final Quality getUploadQuality() {
        return this.upload.getGetQuality();
    }

    public int hashCode() {
        return (this.download.hashCode() * 31) + this.upload.hashCode();
    }

    public String toString() {
        return "ConnectionStatus(download=" + this.download + ", upload=" + this.upload + ")";
    }
}
