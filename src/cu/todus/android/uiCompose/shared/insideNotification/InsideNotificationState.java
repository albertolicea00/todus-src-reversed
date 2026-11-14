package cu.todus.android.uiCompose.shared.insideNotification;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "", "id", "", "cause", "Lcu/todus/android/uiCompose/shared/insideNotification/Cause;", "msg", "<init>", "(Ljava/lang/String;Lcu/todus/android/uiCompose/shared/insideNotification/Cause;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getCause", "()Lcu/todus/android/uiCompose/shared/insideNotification/Cause;", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class InsideNotificationState {
    public static final int $stable = 0;
    private final Cause cause;
    private final String id;
    private final String msg;

    public InsideNotificationState(String id2, Cause cause, String msg) {
        y.i(id2, "id");
        y.i(cause, "cause");
        y.i(msg, "msg");
        this.id = id2;
        this.cause = cause;
        this.msg = msg;
    }

    public static /* synthetic */ InsideNotificationState copy$default(InsideNotificationState insideNotificationState, String str, Cause cause, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = insideNotificationState.id;
        }
        if ((i10 & 2) != 0) {
            cause = insideNotificationState.cause;
        }
        if ((i10 & 4) != 0) {
            str2 = insideNotificationState.msg;
        }
        return insideNotificationState.copy(str, cause, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Cause getCause() {
        return this.cause;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final InsideNotificationState copy(String id2, Cause cause, String msg) {
        y.i(id2, "id");
        y.i(cause, "cause");
        y.i(msg, "msg");
        return new InsideNotificationState(id2, cause, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InsideNotificationState)) {
            return false;
        }
        InsideNotificationState insideNotificationState = (InsideNotificationState) other;
        return y.d(this.id, insideNotificationState.id) && this.cause == insideNotificationState.cause && y.d(this.msg, insideNotificationState.msg);
    }

    public final Cause getCause() {
        return this.cause;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.cause.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "InsideNotificationState(id=" + this.id + ", cause=" + this.cause + ", msg=" + this.msg + ")";
    }
}
