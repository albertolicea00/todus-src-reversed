package cu.todus.android.utils.versionupdate;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import te.b0;
import te.j;
import te.p0;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcu/todus/android/utils/versionupdate/DownloadStateBus;", "", "<init>", "()V", "Lcu/todus/android/utils/versionupdate/DownloadState;", "state", "Lua/k0;", DiscoverItems.Item.UPDATE_ACTION, "(Lcu/todus/android/utils/versionupdate/DownloadState;)V", "Lte/b0;", "_state", "Lte/b0;", "Lte/p0;", "Lte/p0;", "getState", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DownloadStateBus {
    public static final int $stable;
    public static final DownloadStateBus INSTANCE = new DownloadStateBus();
    private static final b0 _state;
    private static final p0 state;

    static {
        b0 b0VarA = r0.a(DownloadState.Idle.INSTANCE);
        _state = b0VarA;
        state = j.b(b0VarA);
        $stable = 8;
    }

    private DownloadStateBus() {
    }

    public final p0 getState() {
        return state;
    }

    public final void update(DownloadState state2) {
        y.i(state2, "state");
        _state.setValue(state2);
    }
}
