package cu.todus.android.data.db.pojo;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import defpackage.l;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/data/db/pojo/MsgWithDate;", "", Room.COLUMN_LAST_MSG, "", "day", "createAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getMsgId", "()Ljava/lang/String;", "getDay", "getCreateAt", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MsgWithDate {
    public static final int $stable = 0;
    private final long createAt;
    private final String day;
    private final String msgId;

    public MsgWithDate(String msgId, String day, long j10) {
        y.i(msgId, "msgId");
        y.i(day, "day");
        this.msgId = msgId;
        this.day = day;
        this.createAt = j10;
    }

    public static /* synthetic */ MsgWithDate copy$default(MsgWithDate msgWithDate, String str, String str2, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = msgWithDate.msgId;
        }
        if ((i10 & 2) != 0) {
            str2 = msgWithDate.day;
        }
        if ((i10 & 4) != 0) {
            j10 = msgWithDate.createAt;
        }
        return msgWithDate.copy(str, str2, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCreateAt() {
        return this.createAt;
    }

    public final MsgWithDate copy(String msgId, String day, long createAt) {
        y.i(msgId, "msgId");
        y.i(day, "day");
        return new MsgWithDate(msgId, day, createAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgWithDate)) {
            return false;
        }
        MsgWithDate msgWithDate = (MsgWithDate) other;
        return y.d(this.msgId, msgWithDate.msgId) && y.d(this.day, msgWithDate.day) && this.createAt == msgWithDate.createAt;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        return (((this.msgId.hashCode() * 31) + this.day.hashCode()) * 31) + l.a(this.createAt);
    }

    public String toString() {
        return "MsgWithDate(msgId=" + this.msgId + ", day=" + this.day + ", createAt=" + this.createAt + ")";
    }
}
