package cu.z17.views.dialogs;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import cu.z17.views.utils.Z17MutableListFlow;
import kotlin.Metadata;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcu/z17/views/dialogs/Z17DialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "listResult", "Lcu/z17/views/utils/Z17MutableListFlow;", "", "getListResult", "()Lcu/z17/views/utils/Z17MutableListFlow;", "views_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Z17DialogViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Z17MutableListFlow<String> listResult = new Z17MutableListFlow<>(w.n());

    public final Z17MutableListFlow<String> getListResult() {
        return this.listResult;
    }
}
