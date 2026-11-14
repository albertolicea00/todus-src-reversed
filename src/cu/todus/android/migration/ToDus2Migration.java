package cu.todus.android.migration;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.migration.legacy.SharedPreferencesStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcu/todus/android/migration/ToDus2Migration;", "", "<init>", "()V", "Landroid/content/Context;", "appContext", "", "isFromLegacy", "(Landroid/content/Context;)Z", "Lua/k0;", "removeLegacyPreferences", "(Landroid/content/Context;)V", "", "SHARED_PREFERENCES_NAME_1", "Ljava/lang/String;", "SHARED_PREFERENCES_NAME_2", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ToDus2Migration {
    public static final int $stable = 0;
    public static final ToDus2Migration INSTANCE = new ToDus2Migration();
    public static final String SHARED_PREFERENCES_NAME_1 = "cu.todus.android.instance_state";
    public static final String SHARED_PREFERENCES_NAME_2 = "cu.todus.android.last_view_by_room";

    private ToDus2Migration() {
    }

    public final boolean isFromLegacy(Context appContext) {
        y.i(appContext, "appContext");
        SharedPreferencesStorage sharedPreferencesStorage = new SharedPreferencesStorage(appContext, SHARED_PREFERENCES_NAME_1);
        Boolean boolRetrieveBoolean = sharedPreferencesStorage.retrieveBoolean("isToDus2");
        if (boolRetrieveBoolean != null && y.d(boolRetrieveBoolean, Boolean.TRUE)) {
            return true;
        }
        sharedPreferencesStorage.store("isToDus2", Boolean.TRUE);
        return false;
    }

    public final void removeLegacyPreferences(Context appContext) {
        y.i(appContext, "appContext");
        new SharedPreferencesStorage(appContext, SHARED_PREFERENCES_NAME_1).clean();
        new SharedPreferencesStorage(appContext, SHARED_PREFERENCES_NAME_2).clean();
    }
}
