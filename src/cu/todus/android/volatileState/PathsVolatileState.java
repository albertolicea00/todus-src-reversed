package cu.todus.android.volatileState;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.preferences.DataPreferences;
import cu.z17.singledi.SingletonInitializer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bJ\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcu/todus/android/volatileState/PathsVolatileState;", "", "Lcu/todus/android/data/preferences/DataPreferences;", "initialDataPreferences", "<init>", "(Lcu/todus/android/data/preferences/DataPreferences;)V", "", "autoDownloadImages", "()Z", "autoDownloadVideos", "autoDownloadAudios", "autoDownloadVoice", "autoDownloadFiles", "publicImages", "publicVideos", "publicAudios", "publicVoice", "publicFiles", "newDataPreferences", "Lua/k0;", "updateDataPreferences", "Landroidx/compose/runtime/MutableState;", "dataPreferences", "Landroidx/compose/runtime/MutableState;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PathsVolatileState {
    private MutableState<DataPreferences> dataPreferences;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/volatileState/PathsVolatileState$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/volatileState/PathsVolatileState;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<PathsVolatileState> {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        private Companion() {
        }
    }

    public PathsVolatileState(DataPreferences initialDataPreferences) {
        y.i(initialDataPreferences, "initialDataPreferences");
        this.dataPreferences = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialDataPreferences, null, 2, null);
    }

    public final boolean autoDownloadAudios() {
        return this.dataPreferences.getValue().getAutoDownloadAudios();
    }

    public final boolean autoDownloadFiles() {
        return this.dataPreferences.getValue().getAutoDownloadFiles();
    }

    public final boolean autoDownloadImages() {
        return this.dataPreferences.getValue().getAutoDownloadImages();
    }

    public final boolean autoDownloadVideos() {
        return this.dataPreferences.getValue().getAutoDownloadVideos();
    }

    public final boolean autoDownloadVoice() {
        return this.dataPreferences.getValue().getAutoDownloadVoice();
    }

    public final boolean publicAudios() {
        return this.dataPreferences.getValue().getPublicAudios();
    }

    public final boolean publicFiles() {
        return this.dataPreferences.getValue().getPublicFiles();
    }

    public final boolean publicImages() {
        return this.dataPreferences.getValue().getPublicImages();
    }

    public final boolean publicVideos() {
        return this.dataPreferences.getValue().getPublicVideos();
    }

    public final boolean publicVoice() {
        return this.dataPreferences.getValue().getPublicVoice();
    }

    public final void updateDataPreferences(DataPreferences newDataPreferences) {
        y.i(newDataPreferences, "newDataPreferences");
        this.dataPreferences.setValue(newDataPreferences);
    }
}
