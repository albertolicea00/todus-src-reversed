package cu.todus.android.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.FileProvider;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.xmpp.iq.version.GetUpdateInfoIQ;
import j$.util.Objects;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import le.d0;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012 \b\u0002\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u0019J\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\fJ\u0015\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\u0019J\u0012\u0010!\u001a\u0004\u0018\u00010 H\u0086@¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0013¢\u0006\u0004\b#\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R,\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010)\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcu/todus/android/utils/UpdateChecker;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lab/e;", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;", "requestUpdateInfo", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "", "getCompletedVersion", "()J", "getDownloadingVersion", "", "apkPath", "getApkVersionCode", "(Ljava/lang/String;)J", "targetVersionCode", "Lua/k0;", "markDownloadStarted", "(J)V", "markDownloadCompleted", "", "isApkFullyDownloaded", "(J)Z", "isPartialDownloadResumable", "clearApkAndMetadata", "()V", "isApkCachedAndValid", "getCachedApkVersionCode", "clearCacheIfStale", "Lcu/todus/android/utils/UpdateInfo;", "checkForUpdate", "(Lab/e;)Ljava/lang/Object;", "installApk", "Landroid/content/Context;", "Lkotlin/jvm/functions/Function1;", "Ljava/io/File;", "getCachedApk", "()Ljava/io/File;", "cachedApk", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", MamPrefsIQ.ELEMENT, "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateChecker {
    private static final String APK_URL = "https://s3.todus.cu/official/todus/release/rel/toDus_latest.apk";
    public static final String CACHED_APK_NAME = "todus_latest.apk";
    private static final String KEY_COMPLETED_VERSION = "completed_version";
    private static final String KEY_DOWNLOADING_VERSION = "downloading_version";
    private static final String PREFS_NAME = "update_download_prefs";
    private static final String TAG = "UpdateChecker";
    private static final long TARGET_VERSION_CODE = 30100;
    private static final String TARGET_VERSION_NAME = "2.1.0";
    private final Context context;
    private final Function1 requestUpdateInfo;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.utils.UpdateChecker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.UpdateChecker$1", f = "UpdateChecker.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super GetUpdateInfoIQ> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            return null;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.utils.UpdateChecker$checkForUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.utils.UpdateChecker", f = "UpdateChecker.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "checkForUpdate", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13421 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C13421(ab.e<? super C13421> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateChecker.this.checkForUpdate(this);
        }
    }

    public UpdateChecker(Context context, Function1 requestUpdateInfo) {
        y.i(context, "context");
        y.i(requestUpdateInfo, "requestUpdateInfo");
        this.context = context;
        this.requestUpdateInfo = requestUpdateInfo;
    }

    private final long getApkVersionCode(String apkPath) {
        try {
            PackageManager packageManager = this.context.getPackageManager();
            int i10 = Build.VERSION.SDK_INT;
            PackageInfo packageArchiveInfo = i10 >= 33 ? packageManager.getPackageArchiveInfo(apkPath, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageArchiveInfo(apkPath, 0);
            if (i10 >= 28) {
                if (packageArchiveInfo != null) {
                    return packageArchiveInfo.getLongVersionCode();
                }
                return -1L;
            }
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return -1L;
        } catch (Exception e10) {
            Log.e(TAG, "Error getting version code: " + e10.getMessage());
            return -1L;
        }
    }

    private final File getCachedApk() {
        return new File(this.context.getCacheDir(), CACHED_APK_NAME);
    }

    private final long getCompletedVersion() {
        return getPrefs().getLong(KEY_COMPLETED_VERSION, -1L);
    }

    private final long getDownloadingVersion() {
        return getPrefs().getLong(KEY_DOWNLOADING_VERSION, -1L);
    }

    private final SharedPreferences getPrefs() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREFS_NAME, 0);
        y.h(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object checkForUpdate(ab.e<? super UpdateInfo> eVar) {
        C13421 c13421;
        GetUpdateInfoIQ getUpdateInfoIQ;
        if (eVar instanceof C13421) {
            c13421 = (C13421) eVar;
            int i10 = c13421.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13421.label = i10 - Integer.MIN_VALUE;
            } else {
                c13421 = new C13421(eVar);
            }
        } else {
            c13421 = new C13421(eVar);
        }
        Object objInvoke = c13421.result;
        Object objG = bb.b.g();
        int i11 = c13421.label;
        try {
            if (i11 == 0) {
                v.b(objInvoke);
                Function1 function1 = this.requestUpdateInfo;
                c13421.label = 1;
                objInvoke = function1.invoke(c13421);
                if (objInvoke == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(objInvoke);
            }
            getUpdateInfoIQ = (GetUpdateInfoIQ) objInvoke;
            Objects.toString(getUpdateInfoIQ);
        } catch (Exception e10) {
            Log.e(TAG, "Exception in requestUpdateInfo", e10);
            getUpdateInfoIQ = null;
        }
        if (getUpdateInfoIQ == null || getUpdateInfoIQ.getVersionCode() <= 0) {
            Log.w(TAG, "❌ IQ unavailable or invalid (iqResponse=" + getUpdateInfoIQ + "), using fallback");
            return null;
        }
        if (30102 >= getUpdateInfoIQ.getVersionCode()) {
            Log.i(TAG, "App is up to date (current=30102, remote=" + getUpdateInfoIQ.getVersionCode() + ")");
            return null;
        }
        boolean z10 = 30102 < getUpdateInfoIQ.getMinRequiredVersionCode();
        Log.i(TAG, "✅ IQ success: vc=" + getUpdateInfoIQ.getVersionCode() + ", blocking=" + z10);
        long versionCode = getUpdateInfoIQ.getVersionCode();
        String versionName = getUpdateInfoIQ.getVersionName();
        String downloadUrl = getUpdateInfoIQ.getDownloadUrl();
        if (d0.q0(downloadUrl)) {
            downloadUrl = APK_URL;
        }
        return new UpdateInfo(versionCode, versionName, downloadUrl, getUpdateInfoIQ.getMinRequiredVersionCode(), getUpdateInfoIQ.getPackageName(), getUpdateInfoIQ.getPublishedAt(), z10);
    }

    public final void clearApkAndMetadata() {
        if (getCachedApk().exists()) {
            getCachedApk().delete();
            Log.w(TAG, "APK deleted from cache");
        }
        getPrefs().edit().remove(KEY_DOWNLOADING_VERSION).remove(KEY_COMPLETED_VERSION).apply();
    }

    public final boolean clearCacheIfStale(long targetVersionCode) {
        long cachedApkVersionCode = getCachedApkVersionCode();
        if (cachedApkVersionCode <= 0 || cachedApkVersionCode == targetVersionCode) {
            return false;
        }
        Log.w(TAG, "Stale APK detected (cached=" + cachedApkVersionCode + ", target=" + targetVersionCode + "). Deleting.");
        getCachedApk().delete();
        return true;
    }

    public final long getCachedApkVersionCode() {
        if (!getCachedApk().exists()) {
            return -1L;
        }
        String absolutePath = getCachedApk().getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        return getApkVersionCode(absolutePath);
    }

    public final void installApk() {
        try {
            getCachedApk().getAbsolutePath();
            if (!getCachedApk().exists()) {
                Log.e(TAG, "APK not found for installation at " + getCachedApk().getAbsolutePath());
                return;
            }
            Context context = this.context;
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", getCachedApk());
            y.h(uriForFile, "getUriForFile(...)");
            Objects.toString(uriForFile);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            intent.addFlags(1);
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to install APK", e10);
        }
    }

    public final boolean isApkCachedAndValid(long targetVersionCode) {
        if (!getCachedApk().exists()) {
            getCachedApk().getAbsolutePath();
            return false;
        }
        String absolutePath = getCachedApk().getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        boolean z10 = getApkVersionCode(absolutePath) == targetVersionCode;
        getCachedApk().getAbsolutePath();
        return z10;
    }

    public final boolean isApkFullyDownloaded(long targetVersionCode) {
        if (!getCachedApk().exists()) {
            return false;
        }
        if (getCompletedVersion() != targetVersionCode) {
            getCompletedVersion();
            return false;
        }
        String absolutePath = getCachedApk().getAbsolutePath();
        y.h(absolutePath, "getAbsolutePath(...)");
        return getApkVersionCode(absolutePath) == targetVersionCode;
    }

    public final boolean isPartialDownloadResumable(long targetVersionCode) {
        boolean z10 = false;
        if (getCachedApk().exists() && getCachedApk().length() >= 1048576) {
            z10 = getDownloadingVersion() == targetVersionCode;
            getDownloadingVersion();
            getCachedApk().length();
        }
        return z10;
    }

    public final void markDownloadCompleted(long targetVersionCode) {
        getPrefs().edit().putLong(KEY_COMPLETED_VERSION, targetVersionCode).putLong(KEY_DOWNLOADING_VERSION, -1L).apply();
    }

    public final void markDownloadStarted(long targetVersionCode) {
        getPrefs().edit().putLong(KEY_DOWNLOADING_VERSION, targetVersionCode).remove(KEY_COMPLETED_VERSION).apply();
    }

    public /* synthetic */ UpdateChecker(Context context, Function1 function1, int i10, p pVar) {
        this(context, (i10 & 2) != 0 ? new AnonymousClass1(null) : function1);
    }
}
