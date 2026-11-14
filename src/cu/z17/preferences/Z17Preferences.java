package cu.z17.preferences;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcu/z17/preferences/Z17Preferences;", "Lcu/z17/preferences/PreferencesRepositoryImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17Preferences extends PreferencesRepositoryImpl {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17Preferences(Context context) {
        super(context, DataStoreObj.INSTANCE.dataStore(context));
        y.i(context, "context");
        this.context = context;
    }
}
