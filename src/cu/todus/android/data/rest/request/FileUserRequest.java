package cu.todus.android.data.rest.request;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcu/todus/android/data/rest/request/FileUserRequest;", "", "type", "", "<init>", "(I)V", "getType", "()I", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FileUserRequest {
    public static final int $stable = 0;
    private final int type;

    public FileUserRequest() {
        this(0, 1, null);
    }

    public final int getType() {
        return this.type;
    }

    public FileUserRequest(int i10) {
        this.type = i10;
    }

    public /* synthetic */ FileUserRequest(int i10, int i11, p pVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
