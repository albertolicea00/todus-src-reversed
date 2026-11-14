package cu.todus.android.data.db.pojo.info;

import androidx.compose.runtime.Immutable;
import db.a;
import db.b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel;", "Lcu/todus/android/data/db/pojo/info/MessagePayload;", "userId", "", "privileges", "Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel$PRIVILEGES;", "beforePrivileges", "<init>", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel$PRIVILEGES;Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel$PRIVILEGES;)V", "getUserId", "()Ljava/lang/String;", "getPrivileges", "()Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel$PRIVILEGES;", "getBeforePrivileges", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "PRIVILEGES", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PrivilegesChangeInChannel extends MessagePayload {
    public static final int $stable = 0;
    private final PRIVILEGES beforePrivileges;
    private final PRIVILEGES privileges;
    private final String userId;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInChannel$PRIVILEGES;", "", "<init>", "(Ljava/lang/String;I)V", "OWNER", "ADMIN", "MEMBER", "NONE", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum PRIVILEGES {
        OWNER,
        ADMIN,
        MEMBER,
        NONE;

        private static final /* synthetic */ a $ENTRIES = b.a(values());

        public static a getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ PrivilegesChangeInChannel(String str, PRIVILEGES privileges, PRIVILEGES privileges2, int i10, p pVar) {
        this(str, privileges, (i10 & 4) != 0 ? PRIVILEGES.NONE : privileges2);
    }

    public static /* synthetic */ PrivilegesChangeInChannel copy$default(PrivilegesChangeInChannel privilegesChangeInChannel, String str, PRIVILEGES privileges, PRIVILEGES privileges2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = privilegesChangeInChannel.userId;
        }
        if ((i10 & 2) != 0) {
            privileges = privilegesChangeInChannel.privileges;
        }
        if ((i10 & 4) != 0) {
            privileges2 = privilegesChangeInChannel.beforePrivileges;
        }
        return privilegesChangeInChannel.copy(str, privileges, privileges2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PRIVILEGES getPrivileges() {
        return this.privileges;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PRIVILEGES getBeforePrivileges() {
        return this.beforePrivileges;
    }

    public final PrivilegesChangeInChannel copy(String userId, PRIVILEGES privileges, PRIVILEGES beforePrivileges) {
        y.i(userId, "userId");
        y.i(privileges, "privileges");
        y.i(beforePrivileges, "beforePrivileges");
        return new PrivilegesChangeInChannel(userId, privileges, beforePrivileges);
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivilegesChangeInChannel)) {
            return false;
        }
        PrivilegesChangeInChannel privilegesChangeInChannel = (PrivilegesChangeInChannel) other;
        return y.d(this.userId, privilegesChangeInChannel.userId) && this.privileges == privilegesChangeInChannel.privileges && this.beforePrivileges == privilegesChangeInChannel.beforePrivileges;
    }

    public final PRIVILEGES getBeforePrivileges() {
        return this.beforePrivileges;
    }

    public final PRIVILEGES getPrivileges() {
        return this.privileges;
    }

    public final String getUserId() {
        return this.userId;
    }

    @Override // cu.todus.android.data.db.pojo.info.MessagePayload
    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.privileges.hashCode()) * 31) + this.beforePrivileges.hashCode();
    }

    public String toString() {
        return "PrivilegesChangeInChannel(userId=" + this.userId + ", privileges=" + this.privileges + ", beforePrivileges=" + this.beforePrivileges + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegesChangeInChannel(String userId, PRIVILEGES privileges, PRIVILEGES beforePrivileges) {
        super(MessagePayload.TYPE.PRIVILEGES_CHANGE_IN_CHANNEL);
        y.i(userId, "userId");
        y.i(privileges, "privileges");
        y.i(beforePrivileges, "beforePrivileges");
        this.userId = userId;
        this.privileges = privileges;
        this.beforePrivileges = beforePrivileges;
    }
}
