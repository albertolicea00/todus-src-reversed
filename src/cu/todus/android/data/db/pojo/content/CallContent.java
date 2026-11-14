package cu.todus.android.data.db.pojo.content;

import androidx.compose.runtime.Immutable;
import cu.todus.android.data.db.entity.toDus.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcu/todus/android/data/db/pojo/content/CallContent;", "Lcu/todus/android/data/db/pojo/content/Content;", "userId", "", "callId", "state", Room.COLUMN_LAST_MSG, "startTime", "", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getUserId", "()Ljava/lang/String;", "getCallId", "getState", "getMsgId", "getStartTime", "()J", "getEndTime", "rebuild", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class CallContent extends Content {
    public static final int $stable = 0;
    private final String callId;
    private final long endTime;
    private final String msgId;
    private final long startTime;
    private final String state;
    private final String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallContent(String userId, String callId, String state, String msgId, long j10, long j11) {
        super(32);
        y.i(userId, "userId");
        y.i(callId, "callId");
        y.i(state, "state");
        y.i(msgId, "msgId");
        this.userId = userId;
        this.callId = callId;
        this.state = state;
        this.msgId = msgId;
        this.startTime = j10;
        this.endTime = j11;
    }

    public static /* synthetic */ CallContent rebuild$default(CallContent callContent, String str, String str2, String str3, String str4, long j10, long j11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rebuild");
        }
        if ((i10 & 1) != 0) {
            str = callContent.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = callContent.callId;
        }
        if ((i10 & 4) != 0) {
            str3 = callContent.state;
        }
        if ((i10 & 8) != 0) {
            str4 = callContent.msgId;
        }
        if ((i10 & 16) != 0) {
            j10 = callContent.startTime;
        }
        if ((i10 & 32) != 0) {
            j11 = callContent.endTime;
        }
        long j12 = j11;
        long j13 = j10;
        return callContent.rebuild(str, str2, str3, str4, j13, j12);
    }

    public final String getCallId() {
        return this.callId;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getState() {
        return this.state;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final CallContent rebuild(String userId, String callId, String state, String msgId, long startTime, long endTime) {
        y.i(userId, "userId");
        y.i(callId, "callId");
        y.i(state, "state");
        y.i(msgId, "msgId");
        return new CallContent(userId, callId, state, msgId, startTime, endTime);
    }

    public /* synthetic */ CallContent(String str, String str2, String str3, String str4, long j10, long j11, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? -1L : j10, (i10 & 32) != 0 ? -1L : j11);
    }
}
