package cu.todus.android.uiCompose.main.screen.updateRequired;

import android.app.Application;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.common.MimeTypes;
import androidx.p001lifecycle.AndroidViewModel;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.service.UpdateDownloadService;
import cu.todus.android.utils.UpdateChecker;
import cu.todus.android.utils.versionupdate.DownloadState;
import cu.todus.android.utils.versionupdate.DownloadStateBus;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import te.b0;
import te.p0;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001f\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001b8\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001a¨\u0006("}, d2 = {"Lcu/todus/android/uiCompose/main/screen/updateRequired/UpdateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;)V", "", "url", "", "targetVersionCode", "Lua/k0;", "startDownload", "(Ljava/lang/String;J)V", "startDownloadIfNeeded", "checkExistingUpdate", "(J)V", "cancelDownload", "()V", "installApk", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/utils/UpdateChecker;", "checker", "Lcu/todus/android/utils/UpdateChecker;", "TAG", "Ljava/lang/String;", "Lte/p0;", "Lcu/todus/android/utils/versionupdate/DownloadState;", "downloadState", "Lte/p0;", "getDownloadState", "()Lte/p0;", "Lte/b0;", "Lcu/todus/android/utils/UpdateInfo;", "_updateInfo", "Lte/b0;", "updateInfo", "getUpdateInfo", "currentDownloadUrl", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final b0 _updateInfo;
    private final UpdateChecker checker;
    private String currentDownloadUrl;
    private final p0 downloadState;
    private final MainRepository mainRepository;
    private final p0 updateInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateViewModel(Application application) {
        super(application);
        y.i(application, "application");
        this.mainRepository = MainRepository.INSTANCE.getInstance();
        this.checker = new UpdateChecker(application, new UpdateViewModel$checker$1(this, null));
        this.TAG = "UpdateViewModel";
        this.downloadState = DownloadStateBus.INSTANCE.getState();
        b0 b0VarA = r0.a(null);
        this._updateInfo = b0VarA;
        this.updateInfo = te.j.b(b0VarA);
        this.currentDownloadUrl = "https://s3.todus.cu/official/todus/release/rel/toDus_latest.apk";
    }

    public final void cancelDownload() {
        UpdateDownloadService.INSTANCE.cancel(getApplication());
    }

    public final void checkExistingUpdate(long targetVersionCode) {
        if (this.checker.isApkFullyDownloaded(targetVersionCode)) {
            DownloadStateBus.INSTANCE.update(DownloadState.Success.INSTANCE);
        } else {
            DownloadStateBus.INSTANCE.update(DownloadState.Idle.INSTANCE);
        }
    }

    public final p0 getDownloadState() {
        return this.downloadState;
    }

    public final p0 getUpdateInfo() {
        return this.updateInfo;
    }

    public final void installApk() {
        this.checker.installApk();
    }

    public final void startDownload(String url, long targetVersionCode) {
        y.i(url, "url");
        this.currentDownloadUrl = url;
        this.checker.markDownloadStarted(targetVersionCode);
        DownloadStateBus.INSTANCE.update(DownloadState.Idle.INSTANCE);
        UpdateDownloadService.INSTANCE.start(getApplication(), url, targetVersionCode);
    }

    public final void startDownloadIfNeeded(String url, long targetVersionCode) {
        y.i(url, "url");
        if (this.checker.isApkFullyDownloaded(targetVersionCode)) {
            DownloadStateBus.INSTANCE.update(DownloadState.Success.INSTANCE);
        } else if (this.checker.isPartialDownloadResumable(targetVersionCode)) {
            startDownload(url, targetVersionCode);
        } else {
            this.checker.clearApkAndMetadata();
            startDownload(url, targetVersionCode);
        }
    }
}
