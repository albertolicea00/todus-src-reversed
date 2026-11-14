package cu.todus.android.data.wrapper;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import w5.c;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcu/todus/android/data/wrapper/ResponseBody;", ExifInterface.GPS_DIRECTION_TRUE, "", "responseCode", "", "message", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getResponseCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcu/todus/android/data/wrapper/ResponseBody;", "equals", "", "other", "hashCode", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ResponseBody<T> {
    public static final int $stable = 0;

    @c("data")
    private final T data;

    @c("message")
    private final String message;

    @c("code")
    private final int responseCode;

    public ResponseBody(int i10, String message, T t10) {
        y.i(message, "message");
        this.responseCode = i10;
        this.message = message;
        this.data = t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseBody copy$default(ResponseBody responseBody, int i10, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = responseBody.responseCode;
        }
        if ((i11 & 2) != 0) {
            str = responseBody.message;
        }
        if ((i11 & 4) != 0) {
            obj = responseBody.data;
        }
        return responseBody.copy(i10, str, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final T component3() {
        return this.data;
    }

    public final ResponseBody<T> copy(int responseCode, String message, T data) {
        y.i(message, "message");
        return new ResponseBody<>(responseCode, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseBody)) {
            return false;
        }
        ResponseBody responseBody = (ResponseBody) other;
        return this.responseCode == responseBody.responseCode && y.d(this.message, responseBody.message) && y.d(this.data, responseBody.data);
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public int hashCode() {
        int iHashCode = ((this.responseCode * 31) + this.message.hashCode()) * 31;
        T t10 = this.data;
        return iHashCode + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "ResponseBody(responseCode=" + this.responseCode + ", message=" + this.message + ", data=" + this.data + ")";
    }
}
