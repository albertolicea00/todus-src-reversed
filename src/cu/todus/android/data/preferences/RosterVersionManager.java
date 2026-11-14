package cu.todus.android.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcu/todus/android/data/preferences/RosterVersionManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getLastSyncedVersion", "()I", "version", "Lua/k0;", "updateLastSyncedVersion", "(I)V", "getLastLocalVersion", "updateLastLocalVersion", "Landroid/content/SharedPreferences;", MamPrefsIQ.ELEMENT, "Landroid/content/SharedPreferences;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RosterVersionManager {
    private static final String KEY_LAST_LOCAL_VERSION = "last_local_version";
    private static final String KEY_LAST_SYNCED_VERSION = "last_synced_roster_version";
    private static final String PREFS_NAME = "roster_version_prefs";
    private final SharedPreferences prefs;
    public static final int $stable = 8;

    public RosterVersionManager(Context context) {
        y.i(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        y.h(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
    }

    public final int getLastLocalVersion() {
        return this.prefs.getInt(KEY_LAST_LOCAL_VERSION, 0);
    }

    public final int getLastSyncedVersion() {
        return this.prefs.getInt(KEY_LAST_SYNCED_VERSION, 0);
    }

    public final void updateLastLocalVersion(int version) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.putInt(KEY_LAST_LOCAL_VERSION, version);
        editorEdit.apply();
    }

    public final void updateLastSyncedVersion(int version) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.putInt(KEY_LAST_SYNCED_VERSION, version);
        editorEdit.apply();
    }
}
