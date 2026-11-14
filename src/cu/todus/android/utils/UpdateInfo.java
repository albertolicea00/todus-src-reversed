package cu.todus.android.utils;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006$"}, d2 = {"Lcu/todus/android/utils/UpdateInfo;", "", "remoteVersionCode", "", "remoteVersionName", "", "apkUrl", "minRequiredVersionCode", "packageName", "publishedAt", "isBlocking", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Z)V", "getRemoteVersionCode", "()J", "getRemoteVersionName", "()Ljava/lang/String;", "getApkUrl", "getMinRequiredVersionCode", "getPackageName", "getPublishedAt", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdateInfo {
    public static final int $stable = 0;
    private final String apkUrl;
    private final boolean isBlocking;
    private final long minRequiredVersionCode;
    private final String packageName;
    private final String publishedAt;
    private final long remoteVersionCode;
    private final String remoteVersionName;

    public UpdateInfo(long j10, String remoteVersionName, String apkUrl, long j11, String packageName, String publishedAt, boolean z10) {
        y.i(remoteVersionName, "remoteVersionName");
        y.i(apkUrl, "apkUrl");
        y.i(packageName, "packageName");
        y.i(publishedAt, "publishedAt");
        this.remoteVersionCode = j10;
        this.remoteVersionName = remoteVersionName;
        this.apkUrl = apkUrl;
        this.minRequiredVersionCode = j11;
        this.packageName = packageName;
        this.publishedAt = publishedAt;
        this.isBlocking = z10;
    }

    public static /* synthetic */ UpdateInfo copy$default(UpdateInfo updateInfo, long j10, String str, String str2, long j11, String str3, String str4, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = updateInfo.remoteVersionCode;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = updateInfo.remoteVersionName;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = updateInfo.apkUrl;
        }
        return updateInfo.copy(j12, str5, str2, (i10 & 8) != 0 ? updateInfo.minRequiredVersionCode : j11, (i10 & 16) != 0 ? updateInfo.packageName : str3, (i10 & 32) != 0 ? updateInfo.publishedAt : str4, (i10 & 64) != 0 ? updateInfo.isBlocking : z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRemoteVersionCode() {
        return this.remoteVersionCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRemoteVersionName() {
        return this.remoteVersionName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getApkUrl() {
        return this.apkUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMinRequiredVersionCode() {
        return this.minRequiredVersionCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPublishedAt() {
        return this.publishedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsBlocking() {
        return this.isBlocking;
    }

    public final UpdateInfo copy(long remoteVersionCode, String remoteVersionName, String apkUrl, long minRequiredVersionCode, String packageName, String publishedAt, boolean isBlocking) {
        y.i(remoteVersionName, "remoteVersionName");
        y.i(apkUrl, "apkUrl");
        y.i(packageName, "packageName");
        y.i(publishedAt, "publishedAt");
        return new UpdateInfo(remoteVersionCode, remoteVersionName, apkUrl, minRequiredVersionCode, packageName, publishedAt, isBlocking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateInfo)) {
            return false;
        }
        UpdateInfo updateInfo = (UpdateInfo) other;
        return this.remoteVersionCode == updateInfo.remoteVersionCode && y.d(this.remoteVersionName, updateInfo.remoteVersionName) && y.d(this.apkUrl, updateInfo.apkUrl) && this.minRequiredVersionCode == updateInfo.minRequiredVersionCode && y.d(this.packageName, updateInfo.packageName) && y.d(this.publishedAt, updateInfo.publishedAt) && this.isBlocking == updateInfo.isBlocking;
    }

    public final String getApkUrl() {
        return this.apkUrl;
    }

    public final long getMinRequiredVersionCode() {
        return this.minRequiredVersionCode;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPublishedAt() {
        return this.publishedAt;
    }

    public final long getRemoteVersionCode() {
        return this.remoteVersionCode;
    }

    public final String getRemoteVersionName() {
        return this.remoteVersionName;
    }

    public int hashCode() {
        return (((((((((((defpackage.l.a(this.remoteVersionCode) * 31) + this.remoteVersionName.hashCode()) * 31) + this.apkUrl.hashCode()) * 31) + defpackage.l.a(this.minRequiredVersionCode)) * 31) + this.packageName.hashCode()) * 31) + this.publishedAt.hashCode()) * 31) + r.a(this.isBlocking);
    }

    public final boolean isBlocking() {
        return this.isBlocking;
    }

    public String toString() {
        return "UpdateInfo(remoteVersionCode=" + this.remoteVersionCode + ", remoteVersionName=" + this.remoteVersionName + ", apkUrl=" + this.apkUrl + ", minRequiredVersionCode=" + this.minRequiredVersionCode + ", packageName=" + this.packageName + ", publishedAt=" + this.publishedAt + ", isBlocking=" + this.isBlocking + ")";
    }

    public /* synthetic */ UpdateInfo(long j10, String str, String str2, long j11, String str3, String str4, boolean z10, int i10, p pVar) {
        this(j10, str, str2, (i10 & 8) != 0 ? -1L : j11, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? false : z10);
    }
}
