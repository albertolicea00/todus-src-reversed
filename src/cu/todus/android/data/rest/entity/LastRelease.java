package cu.todus.android.data.rest.entity;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"Lcu/todus/android/data/rest/entity/LastRelease;", "", "id", "", "apk_file", "", "version_code", "version_name", "changelog", "human_readable_size", "sha256", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getApk_file", "()Ljava/lang/String;", "getVersion_code", "getVersion_name", "getChangelog", "getHuman_readable_size", "getSha256", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LastRelease {
    public static final int $stable = 0;
    private final String apk_file;
    private final String changelog;
    private final String human_readable_size;
    private final long id;
    private final String sha256;
    private final long version_code;
    private final String version_name;

    public LastRelease(long j10, String apk_file, long j11, String version_name, String changelog, String human_readable_size, String sha256) {
        y.i(apk_file, "apk_file");
        y.i(version_name, "version_name");
        y.i(changelog, "changelog");
        y.i(human_readable_size, "human_readable_size");
        y.i(sha256, "sha256");
        this.id = j10;
        this.apk_file = apk_file;
        this.version_code = j11;
        this.version_name = version_name;
        this.changelog = changelog;
        this.human_readable_size = human_readable_size;
        this.sha256 = sha256;
    }

    public static /* synthetic */ LastRelease copy$default(LastRelease lastRelease, long j10, String str, long j11, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = lastRelease.id;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = lastRelease.apk_file;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            j11 = lastRelease.version_code;
        }
        return lastRelease.copy(j12, str6, j11, (i10 & 8) != 0 ? lastRelease.version_name : str2, (i10 & 16) != 0 ? lastRelease.changelog : str3, (i10 & 32) != 0 ? lastRelease.human_readable_size : str4, (i10 & 64) != 0 ? lastRelease.sha256 : str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApk_file() {
        return this.apk_file;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getVersion_code() {
        return this.version_code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion_name() {
        return this.version_name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getChangelog() {
        return this.changelog;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getHuman_readable_size() {
        return this.human_readable_size;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    public final LastRelease copy(long id2, String apk_file, long version_code, String version_name, String changelog, String human_readable_size, String sha256) {
        y.i(apk_file, "apk_file");
        y.i(version_name, "version_name");
        y.i(changelog, "changelog");
        y.i(human_readable_size, "human_readable_size");
        y.i(sha256, "sha256");
        return new LastRelease(id2, apk_file, version_code, version_name, changelog, human_readable_size, sha256);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LastRelease)) {
            return false;
        }
        LastRelease lastRelease = (LastRelease) other;
        return this.id == lastRelease.id && y.d(this.apk_file, lastRelease.apk_file) && this.version_code == lastRelease.version_code && y.d(this.version_name, lastRelease.version_name) && y.d(this.changelog, lastRelease.changelog) && y.d(this.human_readable_size, lastRelease.human_readable_size) && y.d(this.sha256, lastRelease.sha256);
    }

    public final String getApk_file() {
        return this.apk_file;
    }

    public final String getChangelog() {
        return this.changelog;
    }

    public final String getHuman_readable_size() {
        return this.human_readable_size;
    }

    public final long getId() {
        return this.id;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final long getVersion_code() {
        return this.version_code;
    }

    public final String getVersion_name() {
        return this.version_name;
    }

    public int hashCode() {
        return (((((((((((l.a(this.id) * 31) + this.apk_file.hashCode()) * 31) + l.a(this.version_code)) * 31) + this.version_name.hashCode()) * 31) + this.changelog.hashCode()) * 31) + this.human_readable_size.hashCode()) * 31) + this.sha256.hashCode();
    }

    public String toString() {
        return "LastRelease(id=" + this.id + ", apk_file=" + this.apk_file + ", version_code=" + this.version_code + ", version_name=" + this.version_name + ", changelog=" + this.changelog + ", human_readable_size=" + this.human_readable_size + ", sha256=" + this.sha256 + ")";
    }
}
