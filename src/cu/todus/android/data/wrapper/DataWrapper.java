package cu.todus.android.data.wrapper;

import androidx.camera.camera2.adapter.r;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J@\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010!\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcu/todus/android/data/wrapper/DataWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "responseBody", "throwable", "", "responseOkButNull", "", "code", "", "<init>", "(Ljava/lang/Object;Ljava/lang/Throwable;ZI)V", "getResponseBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getThrowable", "()Ljava/lang/Throwable;", "getResponseOkButNull", "()Z", "setResponseOkButNull", "(Z)V", "getCode", "()I", "setCode", "(I)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Throwable;ZI)Lcu/todus/android/data/wrapper/DataWrapper;", "equals", "other", "hashCode", "toString", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DataWrapper<T> {
    public static final int $stable = 8;
    private int code;
    private final T responseBody;
    private boolean responseOkButNull;
    private final Throwable throwable;

    public DataWrapper(T t10, Throwable th2, boolean z10, int i10) {
        this.responseBody = t10;
        this.throwable = th2;
        this.responseOkButNull = z10;
        this.code = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataWrapper copy$default(DataWrapper dataWrapper, Object obj, Throwable th2, boolean z10, int i10, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = dataWrapper.responseBody;
        }
        if ((i11 & 2) != 0) {
            th2 = dataWrapper.throwable;
        }
        if ((i11 & 4) != 0) {
            z10 = dataWrapper.responseOkButNull;
        }
        if ((i11 & 8) != 0) {
            i10 = dataWrapper.code;
        }
        return dataWrapper.copy(obj, th2, z10, i10);
    }

    public final T component1() {
        return this.responseBody;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getResponseOkButNull() {
        return this.responseOkButNull;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final DataWrapper<T> copy(T responseBody, Throwable throwable, boolean responseOkButNull, int code) {
        return new DataWrapper<>(responseBody, throwable, responseOkButNull, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataWrapper)) {
            return false;
        }
        DataWrapper dataWrapper = (DataWrapper) other;
        return y.d(this.responseBody, dataWrapper.responseBody) && y.d(this.throwable, dataWrapper.throwable) && this.responseOkButNull == dataWrapper.responseOkButNull && this.code == dataWrapper.code;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getResponseBody() {
        return this.responseBody;
    }

    public final boolean getResponseOkButNull() {
        return this.responseOkButNull;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        T t10 = this.responseBody;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        Throwable th2 = this.throwable;
        return ((((iHashCode + (th2 != null ? th2.hashCode() : 0)) * 31) + r.a(this.responseOkButNull)) * 31) + this.code;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setResponseOkButNull(boolean z10) {
        this.responseOkButNull = z10;
    }

    public String toString() {
        return "DataWrapper(responseBody=" + this.responseBody + ", throwable=" + this.throwable + ", responseOkButNull=" + this.responseOkButNull + ", code=" + this.code + ")";
    }

    public /* synthetic */ DataWrapper(Object obj, Throwable th2, boolean z10, int i10, int i11, p pVar) {
        this(obj, th2, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? 200 : i10);
    }
}
