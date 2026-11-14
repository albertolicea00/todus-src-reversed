package cu.todus.android.data.db.entity.toDus;

import androidx.compose.runtime.Immutable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Entity(foreignKeys = {@ForeignKey(childColumns = {"msg"}, entity = Message.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"msg"})}, tableName = "marker")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "", "uid", "", "msg", MarkerAction.COLUMN_ROOM, "marker", "", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "getUid", "()Ljava/lang/String;", "getMsg", "getRoom", "getMarker", "()I", "getCreatedAt", "()J", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MarkerAction {
    public static final int $stable = 0;
    public static final int ACKNOWLEDGED = 3;
    public static final String COLUMN_CREATE_AT = "createdAt";
    public static final String COLUMN_MARKER = "marker";
    public static final String COLUMN_MSG = "msg";
    public static final String COLUMN_ROOM = "room";
    public static final String COLUMN_UID = "uid";
    public static final int DISPLAYED = 2;
    public static final int READ_FROM_TARGET = 5;
    public static final int RECEIVED = 1;
    public static final int RECEIVED_FROM_TARGET = 4;
    public static final String TABLE_NAME = "marker";
    private final long createdAt;
    private final int marker;
    private final String msg;
    private final String room;

    @PrimaryKey
    private final String uid;

    public MarkerAction(String uid, String msg, String room, int i10, long j10) {
        y.i(uid, "uid");
        y.i(msg, "msg");
        y.i(room, "room");
        this.uid = uid;
        this.msg = msg;
        this.room = room;
        this.marker = i10;
        this.createdAt = j10;
    }

    public static /* synthetic */ MarkerAction copy$default(MarkerAction markerAction, String str, String str2, String str3, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = markerAction.uid;
        }
        if ((i11 & 2) != 0) {
            str2 = markerAction.msg;
        }
        if ((i11 & 4) != 0) {
            str3 = markerAction.room;
        }
        if ((i11 & 8) != 0) {
            i10 = markerAction.marker;
        }
        if ((i11 & 16) != 0) {
            j10 = markerAction.createdAt;
        }
        long j11 = j10;
        return markerAction.copy(str, str2, str3, i10, j11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRoom() {
        return this.room;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMarker() {
        return this.marker;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final MarkerAction copy(String uid, String msg, String room, int marker, long createdAt) {
        y.i(uid, "uid");
        y.i(msg, "msg");
        y.i(room, "room");
        return new MarkerAction(uid, msg, room, marker, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!y.d(MarkerAction.class, other != null ? other.getClass() : null)) {
            return false;
        }
        y.g(other, "null cannot be cast to non-null type cu.todus.android.data.db.entity.toDus.MarkerAction");
        MarkerAction markerAction = (MarkerAction) other;
        return y.d(this.msg, markerAction.msg) && y.d(this.room, markerAction.room) && this.marker == markerAction.marker;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getMarker() {
        return this.marker;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getRoom() {
        return this.room;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((this.msg.hashCode() * 31) + this.room.hashCode()) * 31) + this.marker;
    }

    public String toString() {
        return "MarkerAction(uid=" + this.uid + ", msg=" + this.msg + ", room=" + this.room + ", marker=" + this.marker + ", createdAt=" + this.createdAt + ")";
    }

    public /* synthetic */ MarkerAction(String str, String str2, String str3, int i10, long j10, int i11, p pVar) {
        this(str, str2, str3, i10, (i11 & 16) != 0 ? new Date().getTime() : j10);
    }
}
