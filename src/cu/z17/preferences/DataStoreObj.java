package cu.z17.preferences;

import android.content.Context;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.d1;
import pe.n0;
import pe.w2;
import va.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcu/z17/preferences/DataStoreObj;", "", "<init>", "()V", "SHARED_PREFERENCES_NAME", "", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "context", "Landroid/content/Context;", "preferences_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DataStoreObj {
    public static final DataStoreObj INSTANCE = new DataStoreObj();
    private static final String SHARED_PREFERENCES_NAME = "cu.todus.android.instance_state";

    private DataStoreObj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences dataStore$lambda$0(CorruptionException it) {
        y.i(it, "it");
        return PreferencesFactory.createEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File dataStore$lambda$1(Context context) {
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, "cu.todus.android.instance_state");
    }

    public final DataStore<Preferences> dataStore(final Context context) {
        y.i(context, "context");
        return PreferenceDataStoreFactory.INSTANCE.create(new ReplaceFileCorruptionHandler<>(new Function1() { // from class: cu.z17.preferences.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataStoreObj.dataStore$lambda$0((CorruptionException) obj);
            }
        }), v.e(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context, "cu.todus.android.instance_state", null, 4, null)), n0.a(d1.b().plus(w2.b(null, 1, null))), new lb.a() { // from class: cu.z17.preferences.b
            @Override // lb.a
            public final Object invoke() {
                return DataStoreObj.dataStore$lambda$1(context);
            }
        });
    }
}
