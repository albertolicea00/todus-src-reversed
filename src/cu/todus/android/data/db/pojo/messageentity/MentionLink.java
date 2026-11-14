package cu.todus.android.data.db.pojo.messageentity;

import androidx.compose.runtime.Immutable;
import cu.todus.android.xmpp.extension.mention.ExtensionMention;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/data/db/pojo/messageentity/MentionLink;", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", ExtensionMention.TAG_OFFSET, "", "l", StreamManagement.Resume.ELEMENT, "", "<init>", "(IILjava/lang/String;)V", "getO", "()I", "getL", "getU", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MentionLink extends MessageEntity {
    public static final int $stable = 0;
    private final int l;
    private final int o;
    private final String u;

    public MentionLink() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ MentionLink copy$default(MentionLink mentionLink, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = mentionLink.o;
        }
        if ((i12 & 2) != 0) {
            i11 = mentionLink.l;
        }
        if ((i12 & 4) != 0) {
            str = mentionLink.u;
        }
        return mentionLink.copy(i10, i11, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getO() {
        return this.o;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getL() {
        return this.l;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getU() {
        return this.u;
    }

    public final MentionLink copy(int o10, int l10, String u10) {
        return new MentionLink(o10, l10, u10);
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionLink)) {
            return false;
        }
        MentionLink mentionLink = (MentionLink) other;
        return this.o == mentionLink.o && this.l == mentionLink.l && y.d(this.u, mentionLink.u);
    }

    public final int getL() {
        return this.l;
    }

    public final int getO() {
        return this.o;
    }

    public final String getU() {
        return this.u;
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public int hashCode() {
        int i10 = ((this.o * 31) + this.l) * 31;
        String str = this.u;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @Override // cu.todus.android.data.db.pojo.messageentity.MessageEntity
    public String toString() {
        return "MentionLink(o=" + this.o + ", l=" + this.l + ", u=" + this.u + ")";
    }

    public MentionLink(int i10, int i11, String str) {
        super(2, i10, i11, str);
        this.o = i10;
        this.l = i11;
        this.u = str;
    }

    public /* synthetic */ MentionLink(int i10, int i11, String str, int i12, p pVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? null : str);
    }
}
