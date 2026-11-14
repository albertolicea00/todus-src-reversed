package cu.todus.android.exceptions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import lb.a;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/exceptions/ToDusException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "Lkotlin/Function0;", "Lua/k0;", "retryFunction", "", "canRetry", "<init>", "(Ljava/lang/String;Llb/a;Z)V", "Llb/a;", "getRetryFunction", "()Llb/a;", "Z", "getCanRetry", "()Z", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ToDusException extends Exception {
    public static final int $stable = 8;
    private final boolean canRetry;
    private final a retryFunction;

    public ToDusException() {
        this(null, null, false, 7, null);
    }

    public final boolean getCanRetry() {
        return this.canRetry;
    }

    public final a getRetryFunction() {
        return this.retryFunction;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToDusException(String message, a retryFunction, boolean z10) {
        super(message);
        y.i(message, "message");
        y.i(retryFunction, "retryFunction");
        this.retryFunction = retryFunction;
        this.canRetry = z10;
    }

    public /* synthetic */ ToDusException(String str, a aVar, boolean z10, int i10, p pVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? new a() { // from class: f7.a
            @Override // lb.a
            public final Object invoke() {
                return k0.f43947a;
            }
        } : aVar, (i10 & 4) != 0 ? false : z10);
    }
}
