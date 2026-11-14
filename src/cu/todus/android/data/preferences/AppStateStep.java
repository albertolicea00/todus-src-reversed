package cu.todus.android.data.preferences;

import db.a;
import db.b;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcu/todus/android/data/preferences/AppStateStep;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "NEW_USER", "BANNED", "WRONG_AUTH", "WAITING_VERIFY", "WAITING_REGISTER", "WAITING_COMPLETE_PROFILE", "UPDATE_REQUIRED", "LOGIN_COMPLETED", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AppStateStep {
    LOADING,
    NEW_USER,
    BANNED,
    WRONG_AUTH,
    WAITING_VERIFY,
    WAITING_REGISTER,
    WAITING_COMPLETE_PROFILE,
    UPDATE_REQUIRED,
    LOGIN_COMPLETED;

    private static final /* synthetic */ a $ENTRIES = b.a(values());

    public static a getEntries() {
        return $ENTRIES;
    }
}
