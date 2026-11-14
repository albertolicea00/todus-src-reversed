package cu.todus.android.data.db.pojo.messageentity;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcu/todus/android/data/db/pojo/messageentity/MentionName;", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "userId", "", User.COLUMN_TODUS_ID, ExtensionMention.TAG_OFFSET, "", "l", StreamManagement.Resume.ELEMENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getToDusId", "getO", "()I", "getL", "getU", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MentionName extends MessageEntity {
    public static final int $stable = 0;
    private final int l;
    private final int o;
    private final String toDusId;
    private final String u;
    private final String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MentionName(String userId, String str, int i10, int i11, String str2) {
        super(1, i10, i11, str2);
        y.i(userId, "userId");
        this.userId = userId;
        this.toDusId = str;
        this.o = i10;
        this.l = i11;
        this.u = str2;
    }

    public static /* synthetic */ MentionName copy$default(MentionName mentionName, String str, String str2, int i10, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = mentionName.userId;
        }
        if ((i12 & 2) != 0) {
            str2 = mentionName.toDusId;
        }
        if ((i12 & 4) != 0) {
            i10 = mentionName.o;
        }
        if ((i12 & 8) != 0) {
            i11 = mentionName.l;
        }
        if ((i12 & 16) != 0) {
            str3 = mentionName.u;
        }
        String str4 = str3;
        int i13 = i10;
        return mentionName.copy(str, str2, i13, i11, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToDusId() {
        return this.toDusId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getO() {
        return this.o;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getL() {
        return this.l;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getU() {
        return this.u;
    }

    public final MentionName copy(String userId, String toDusId, int o10, int l10, String u10) {
        y.i(userId, "userId");
        return new MentionName(userId, toDusId, o10, l10, u10);
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionName)) {
            return false;
        }
        MentionName mentionName = (MentionName) other;
        return y.d(this.userId, mentionName.userId) && y.d(this.toDusId, mentionName.toDusId) && this.o == mentionName.o && this.l == mentionName.l && y.d(this.u, mentionName.u);
    }

    public final int getL() {
        return this.l;
    }

    public final int getO() {
        return this.o;
    }

    public final String getToDusId() {
        return this.toDusId;
    }

    public final String getU() {
        return this.u;
    }

    public final String getUserId() {
        return this.userId;
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public int hashCode() {
        int iHashCode = this.userId.hashCode() * 31;
        String str = this.toDusId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.o) * 31) + this.l) * 31;
        String str2 = this.u;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public String toString() {
        return "MentionName(userId=" + this.userId + ", toDusId=" + this.toDusId + ", o=" + this.o + ", l=" + this.l + ", u=" + this.u + ")";
    }

    public /* synthetic */ MentionName(String str, String str2, int i10, int i11, String str3, int i12, p pVar) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11, (i12 & 16) != 0 ? null : str3);
    }
}
