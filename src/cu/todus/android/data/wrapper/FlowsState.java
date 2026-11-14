package cu.todus.android.data.wrapper;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import cu.todus.android.uiCompose.navigation.NavLinks;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcu/todus/android/data/wrapper/FlowsState;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "Lcu/todus/android/data/wrapper/Status;", "data", "message", "", "<init>", "(Lcu/todus/android/data/wrapper/Status;Ljava/lang/Object;Ljava/lang/String;)V", "getStatus", "()Lcu/todus/android/data/wrapper/Status;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lcu/todus/android/data/wrapper/Status;Ljava/lang/Object;Ljava/lang/String;)Lcu/todus/android/data/wrapper/FlowsState;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FlowsState<T> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final String message;
    private final Status status;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006J)\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006J\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcu/todus/android/data/wrapper/FlowsState$Companion;", "", "<init>", "()V", "success", "Lcu/todus/android/data/wrapper/FlowsState;", ExifInterface.GPS_DIRECTION_TRUE, "data", "(Ljava/lang/Object;)Lcu/todus/android/data/wrapper/FlowsState;", "emptyData", "error", "msg", "", "(Ljava/lang/String;Ljava/lang/Object;)Lcu/todus/android/data/wrapper/FlowsState;", NavLinks.LOADING, "notRequested", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final <T> FlowsState<T> emptyData() {
            return new FlowsState<>(Status.EMPTY, null, null);
        }

        public final <T> FlowsState<T> error(String msg, T data) {
            y.i(msg, "msg");
            return new FlowsState<>(Status.ERROR, data, msg);
        }

        public final <T> FlowsState<T> loading() {
            return new FlowsState<>(Status.LOADING, null, null);
        }

        public final <T> FlowsState<T> notRequested() {
            return new FlowsState<>(Status.NOT_REQUESTED, null, null);
        }

        public final <T> FlowsState<T> success(T data) {
            return new FlowsState<>(Status.SUCCESS, data, null);
        }

        private Companion() {
        }
    }

    public FlowsState(Status status, T t10, String str) {
        y.i(status, "status");
        this.status = status;
        this.data = t10;
        this.message = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FlowsState copy$default(FlowsState flowsState, Status status, Object obj, String str, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            status = flowsState.status;
        }
        if ((i10 & 2) != 0) {
            obj = flowsState.data;
        }
        if ((i10 & 4) != 0) {
            str = flowsState.message;
        }
        return flowsState.copy(status, obj, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final T component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final FlowsState<T> copy(Status status, T data, String message) {
        y.i(status, "status");
        return new FlowsState<>(status, data, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowsState)) {
            return false;
        }
        FlowsState flowsState = (FlowsState) other;
        return this.status == flowsState.status && y.d(this.data, flowsState.data) && y.d(this.message, flowsState.message);
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        T t10 = this.data;
        int iHashCode2 = (iHashCode + (t10 == null ? 0 : t10.hashCode())) * 31;
        String str = this.message;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FlowsState(status=" + this.status + ", data=" + this.data + ", message=" + this.message + ")";
    }
}
