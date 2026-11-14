package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcu/todus/android/exceptions/HTTPException;", "Lcu/todus/android/exceptions/ToDusException;", "code", "", "type", "Lcu/todus/android/exceptions/HTTPException$Companion$TYPE;", "<init>", "(ILcu/todus/android/exceptions/HTTPException$Companion$TYPE;)V", "getCode", "()I", "getType", "()Lcu/todus/android/exceptions/HTTPException$Companion$TYPE;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HTTPException extends ToDusException {
    private final int code;
    private final Companion.TYPE type;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HTTPException(int i10, Companion.TYPE type) {
        super("http error code: " + i10, null, false, 6, null);
        y.i(type, "type");
        this.code = i10;
        this.type = type;
    }

    public static /* synthetic */ HTTPException copy$default(HTTPException hTTPException, int i10, Companion.TYPE type, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = hTTPException.code;
        }
        if ((i11 & 2) != 0) {
            type = hTTPException.type;
        }
        return hTTPException.copy(i10, type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Companion.TYPE getType() {
        return this.type;
    }

    public final HTTPException copy(int code, Companion.TYPE type) {
        y.i(type, "type");
        return new HTTPException(code, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPException)) {
            return false;
        }
        HTTPException hTTPException = (HTTPException) other;
        return this.code == hTTPException.code && this.type == hTTPException.type;
    }

    public final int getCode() {
        return this.code;
    }

    public final Companion.TYPE getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.code * 31) + this.type.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "HTTPException(code=" + this.code + ", type=" + this.type + ")";
    }
}
