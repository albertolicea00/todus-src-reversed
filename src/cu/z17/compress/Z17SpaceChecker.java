package cu.z17.compress;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import defpackage.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@RequiresApi(26)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000  2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006\""}, d2 = {"Lcu/z17/compress/Z17SpaceChecker;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lua/k0;", "getVolumeStats", "()V", "showVolumeStats", "", "x", "Lkotlin/Pair;", "", "getShiftUnits", "(J)Lkotlin/Pair;", "selectKbValue", "Landroid/content/Context;", "Landroid/os/storage/StorageManager;", "mStorageManager", "Landroid/os/storage/StorageManager;", "", "Lcu/z17/compress/Z17SpaceChecker$VolumeStats;", "mStorageVolumesByExtDir", "Ljava/util/List;", "", "mKbToggleValue", "Z", "kbToUse", "J", "mbToUse", "gbToUse", "Companion", "VolumeStats", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17SpaceChecker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long GB = 1000000000;
    public static final long GiB = 1073741824;
    public static final long KB = 1000;
    public static final long KiB = 1024;
    public static final long MB = 1000000;
    public static final long MiB = 1048576;
    public static final String PRIMARY_STORAGE_LABEL = "Internal Storage";
    public static final String TAG = "MainActivity";
    private final Context context;
    private long gbToUse;
    private long kbToUse;
    private boolean mKbToggleValue;
    private StorageManager mStorageManager;
    private final List<VolumeStats> mStorageVolumesByExtDir;
    private long mbToUse;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\n\u0010\t\u001a\u00020\u0005*\u00020\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcu/z17/compress/Z17SpaceChecker$Companion;", "", "<init>", "()V", "nice", "", "", "fieldLength", "", "getStorageVolumePath", "Landroid/os/storage/StorageVolume;", "KB", "", "MB", "GB", "KiB", "MiB", "GiB", "PRIMARY_STORAGE_LABEL", "TAG", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public static /* synthetic */ String nice$default(Companion companion, float f10, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = 6;
            }
            return companion.nice(f10, i10);
        }

        public final String getStorageVolumePath(StorageVolume storageVolume) {
            y.i(storageVolume, "<this>");
            try {
                Object objInvoke = storageVolume.getClass().getMethod("getPath", null).invoke(storageVolume, null);
                y.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
                return (String) objInvoke;
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }

        public final String nice(float f10, int i10) {
            e1 e1Var = e1.f36604a;
            String str = String.format(Locale.US, "%" + i10 + ".2f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
            y.h(str, "format(...)");
            return str;
        }

        private Companion() {
        }
    }

    public Z17SpaceChecker(Context context) {
        y.i(context, "context");
        this.context = context;
        this.mStorageVolumesByExtDir = new ArrayList();
        this.mKbToggleValue = true;
        this.kbToUse = 1000L;
        this.mbToUse = 1000000L;
        this.gbToUse = 1000000000L;
    }

    private final Pair<Long, String> getShiftUnits(long x10) {
        String str;
        long j10 = this.kbToUse;
        if (x10 < j10) {
            str = "Bytes";
            j10 = 1;
        } else {
            long j11 = this.mbToUse;
            if (x10 < j11) {
                str = "KB";
            } else {
                j10 = this.gbToUse;
                if (x10 < j10) {
                    str = "MB";
                    j10 = j11;
                } else {
                    str = "GB";
                }
            }
        }
        return new Pair<>(Long.valueOf(j10), str);
    }

    private final void getVolumeStats() throws IOException {
        long totalSpace;
        long freeSpace;
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(this.context, null);
        y.h(externalFilesDirs, "getExternalFilesDirs(...)");
        this.mStorageVolumesByExtDir.clear();
        for (File file : externalFilesDirs) {
            StorageManager storageManager = this.mStorageManager;
            if (storageManager == null) {
                y.w("mStorageManager");
                storageManager = null;
            }
            StorageVolume storageVolume = storageManager.getStorageVolume(file);
            if (storageVolume == null) {
                file.getPath();
            } else {
                if (storageVolume.isPrimary()) {
                    UUID uuid = StorageManager.UUID_DEFAULT;
                    Object systemService = this.context.getSystemService("storagestats");
                    y.g(systemService, "null cannot be cast to non-null type android.app.usage.StorageStatsManager");
                    StorageStatsManager storageStatsManagerA = e.a(systemService);
                    totalSpace = (storageStatsManagerA.getTotalBytes(uuid) / ((long) 1000000000)) * this.gbToUse;
                    freeSpace = storageStatsManagerA.getFreeBytes(uuid);
                } else {
                    totalSpace = file.getTotalSpace();
                    freeSpace = file.getFreeSpace();
                }
                this.mStorageVolumesByExtDir.add(new VolumeStats(storageVolume, totalSpace, totalSpace - freeSpace));
            }
        }
    }

    private final void selectKbValue() {
        if (this.mKbToggleValue) {
            this.kbToUse = 1000L;
            this.mbToUse = 1000000L;
            this.gbToUse = 1000000000L;
        } else {
            this.kbToUse = 1024L;
            this.mbToUse = 1048576L;
            this.gbToUse = GiB;
        }
    }

    private final void showVolumeStats() {
        for (VolumeStats volumeStats : this.mStorageVolumesByExtDir) {
            Pair<Long, String> shiftUnits = getShiftUnits(volumeStats.getMUsedSpace());
            long jLongValue = shiftUnits.component1().longValue();
            shiftUnits.component2();
            nb.c.f((volumeStats.getMUsedSpace() * 100.0f) / jLongValue);
            Pair<Long, String> shiftUnits2 = getShiftUnits(volumeStats.getMTotalSpace());
            long jLongValue2 = shiftUnits2.component1().longValue();
            shiftUnits2.component2();
            nb.c.f((volumeStats.getMTotalSpace() * 100.0f) / jLongValue2);
            if (!volumeStats.getMStorageVolume().isPrimary()) {
                volumeStats.getMStorageVolume().getUuid();
                volumeStats.getMStorageVolume().getDescription(this.context);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcu/z17/compress/Z17SpaceChecker$VolumeStats;", "", "mStorageVolume", "Landroid/os/storage/StorageVolume;", "mTotalSpace", "", "mUsedSpace", "<init>", "(Landroid/os/storage/StorageVolume;JJ)V", "getMStorageVolume", "()Landroid/os/storage/StorageVolume;", "getMTotalSpace", "()J", "setMTotalSpace", "(J)V", "getMUsedSpace", "setMUsedSpace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "compress_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VolumeStats {
        private final StorageVolume mStorageVolume;
        private long mTotalSpace;
        private long mUsedSpace;

        public VolumeStats(StorageVolume mStorageVolume, long j10, long j11) {
            y.i(mStorageVolume, "mStorageVolume");
            this.mStorageVolume = mStorageVolume;
            this.mTotalSpace = j10;
            this.mUsedSpace = j11;
        }

        public static /* synthetic */ VolumeStats copy$default(VolumeStats volumeStats, StorageVolume storageVolume, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                storageVolume = volumeStats.mStorageVolume;
            }
            if ((i10 & 2) != 0) {
                j10 = volumeStats.mTotalSpace;
            }
            if ((i10 & 4) != 0) {
                j11 = volumeStats.mUsedSpace;
            }
            return volumeStats.copy(storageVolume, j10, j11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StorageVolume getMStorageVolume() {
            return this.mStorageVolume;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getMTotalSpace() {
            return this.mTotalSpace;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getMUsedSpace() {
            return this.mUsedSpace;
        }

        public final VolumeStats copy(StorageVolume mStorageVolume, long mTotalSpace, long mUsedSpace) {
            y.i(mStorageVolume, "mStorageVolume");
            return new VolumeStats(mStorageVolume, mTotalSpace, mUsedSpace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VolumeStats)) {
                return false;
            }
            VolumeStats volumeStats = (VolumeStats) other;
            return y.d(this.mStorageVolume, volumeStats.mStorageVolume) && this.mTotalSpace == volumeStats.mTotalSpace && this.mUsedSpace == volumeStats.mUsedSpace;
        }

        public final StorageVolume getMStorageVolume() {
            return this.mStorageVolume;
        }

        public final long getMTotalSpace() {
            return this.mTotalSpace;
        }

        public final long getMUsedSpace() {
            return this.mUsedSpace;
        }

        public int hashCode() {
            return (((this.mStorageVolume.hashCode() * 31) + l.a(this.mTotalSpace)) * 31) + l.a(this.mUsedSpace);
        }

        public final void setMTotalSpace(long j10) {
            this.mTotalSpace = j10;
        }

        public final void setMUsedSpace(long j10) {
            this.mUsedSpace = j10;
        }

        public String toString() {
            return "VolumeStats(mStorageVolume=" + this.mStorageVolume + ", mTotalSpace=" + this.mTotalSpace + ", mUsedSpace=" + this.mUsedSpace + ")";
        }

        public /* synthetic */ VolumeStats(StorageVolume storageVolume, long j10, long j11, int i10, p pVar) {
            this(storageVolume, (i10 & 2) != 0 ? 0L : j10, (i10 & 4) != 0 ? 0L : j11);
        }
    }
}
