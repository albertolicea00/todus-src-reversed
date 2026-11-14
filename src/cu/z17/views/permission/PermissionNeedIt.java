package cu.z17.views.permission;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcu/z17/views/permission/PermissionNeedIt;", "", "<init>", "(Ljava/lang/String;I)V", "CONTACT", "STORAGE", "CAMERA", CodePackage.LOCATION, "READ_SMS", "CALLS", "RECORD_AUDIO", "NOTIFICATIONS", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum PermissionNeedIt {
    CONTACT,
    STORAGE,
    CAMERA,
    LOCATION,
    READ_SMS,
    CALLS,
    RECORD_AUDIO,
    NOTIFICATIONS;

    private static final /* synthetic */ db.a $ENTRIES = db.b.a(values());

    public static db.a getEntries() {
        return $ENTRIES;
    }
}
