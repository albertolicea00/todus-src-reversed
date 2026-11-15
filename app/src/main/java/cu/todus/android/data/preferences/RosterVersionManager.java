package cu.todus.android.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;

/**
 * SharedPreferences manager for tracking local and synced XMPP roster versions.
 *
 * @obfuscated_class cu.todus.android.data.preferences.RosterVersionManager
 */
public final class RosterVersionManager {
    private static final String KEY_LAST_LOCAL_VERSION = "last_local_version";
    private static final String KEY_LAST_SYNCED_VERSION = "last_synced_roster_version";
    private static final String PREFS_NAME = "roster_version_prefs";

    private final SharedPreferences prefs;

    public RosterVersionManager(Context context) {
        Objects.requireNonNull(context, "context");
        this.prefs = Objects.requireNonNull(
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE),
                "prefs"
        );
    }

    public int getLastSyncedVersion() {
        return this.prefs.getInt(KEY_LAST_SYNCED_VERSION, 0);
    }

    public void updateLastSyncedVersion(int version) {
        this.prefs.edit().putInt(KEY_LAST_SYNCED_VERSION, version).apply();
    }

    public int getLastLocalVersion() {
        return this.prefs.getInt(KEY_LAST_LOCAL_VERSION, 0);
    }

    public void updateLastLocalVersion(int version) {
        this.prefs.edit().putInt(KEY_LAST_LOCAL_VERSION, version).apply();
    }
}
