package cu.todus.android.data.xmpp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import db.a;
import db.b;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcu/todus/android/data/xmpp/GroupAffiliation;", "", "<init>", "(Ljava/lang/String;I)V", UserRoomJoin.AFFILIATION_OWNER, UserRoomJoin.AFFILIATION_MEMBER, "admin", "none", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum GroupAffiliation {
    owner,
    member,
    admin,
    none;

    private static final /* synthetic */ a $ENTRIES = b.a(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/xmpp/GroupAffiliation$Companion;", "", "<init>", "()V", "fromString", "Lcu/todus/android/data/xmpp/GroupAffiliation;", TypedValues.Custom.S_STRING, "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final GroupAffiliation fromString(String string) {
            if (string == null) {
                return null;
            }
            String lowerCase = string.toLowerCase(Locale.ROOT);
            y.h(lowerCase, "toLowerCase(...)");
            return GroupAffiliation.valueOf(lowerCase);
        }

        private Companion() {
        }
    }

    public static a getEntries() {
        return $ENTRIES;
    }
}
