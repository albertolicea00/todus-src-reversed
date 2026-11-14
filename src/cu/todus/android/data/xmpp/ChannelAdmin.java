package cu.todus.android.data.xmpp;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/data/xmpp/ChannelAdmin;", "", "id", "", Room.CONFIG_ROLE, "rights", "promotedBy", "promotedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getRole", "getRights", "getPromotedBy", "getPromotedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ChannelAdmin {
    public static final int $stable = 0;
    private final String id;
    private final String promotedAt;
    private final String promotedBy;
    private final String rights;
    private final String role;

    public ChannelAdmin(String id2, String role, String rights, String promotedBy, String promotedAt) {
        y.i(id2, "id");
        y.i(role, "role");
        y.i(rights, "rights");
        y.i(promotedBy, "promotedBy");
        y.i(promotedAt, "promotedAt");
        this.id = id2;
        this.role = role;
        this.rights = rights;
        this.promotedBy = promotedBy;
        this.promotedAt = promotedAt;
    }

    public static /* synthetic */ ChannelAdmin copy$default(ChannelAdmin channelAdmin, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = channelAdmin.id;
        }
        if ((i10 & 2) != 0) {
            str2 = channelAdmin.role;
        }
        if ((i10 & 4) != 0) {
            str3 = channelAdmin.rights;
        }
        if ((i10 & 8) != 0) {
            str4 = channelAdmin.promotedBy;
        }
        if ((i10 & 16) != 0) {
            str5 = channelAdmin.promotedAt;
        }
        String str6 = str5;
        String str7 = str3;
        return channelAdmin.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRights() {
        return this.rights;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromotedBy() {
        return this.promotedBy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPromotedAt() {
        return this.promotedAt;
    }

    public final ChannelAdmin copy(String id2, String role, String rights, String promotedBy, String promotedAt) {
        y.i(id2, "id");
        y.i(role, "role");
        y.i(rights, "rights");
        y.i(promotedBy, "promotedBy");
        y.i(promotedAt, "promotedAt");
        return new ChannelAdmin(id2, role, rights, promotedBy, promotedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelAdmin)) {
            return false;
        }
        ChannelAdmin channelAdmin = (ChannelAdmin) other;
        return y.d(this.id, channelAdmin.id) && y.d(this.role, channelAdmin.role) && y.d(this.rights, channelAdmin.rights) && y.d(this.promotedBy, channelAdmin.promotedBy) && y.d(this.promotedAt, channelAdmin.promotedAt);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPromotedAt() {
        return this.promotedAt;
    }

    public final String getPromotedBy() {
        return this.promotedBy;
    }

    public final String getRights() {
        return this.rights;
    }

    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.role.hashCode()) * 31) + this.rights.hashCode()) * 31) + this.promotedBy.hashCode()) * 31) + this.promotedAt.hashCode();
    }

    public String toString() {
        return "ChannelAdmin(id=" + this.id + ", role=" + this.role + ", rights=" + this.rights + ", promotedBy=" + this.promotedBy + ", promotedAt=" + this.promotedAt + ")";
    }
}
