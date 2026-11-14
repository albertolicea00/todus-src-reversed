package cu.todus.android.uiCompose.main.screen.chat.pagerDialog;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/pagerDialog/PagerDialogViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "cant", "Lua/k0;", "setInitSteps", "(I)V", "close", "Lcu/z17/views/utils/Z17MutableListFlow;", "", "stepsData", "Lcu/z17/views/utils/Z17MutableListFlow;", "getStepsData", "()Lcu/z17/views/utils/Z17MutableListFlow;", "setStepsData", "(Lcu/z17/views/utils/Z17MutableListFlow;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PagerDialogViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private Z17MutableListFlow<String> stepsData;

    public final void close() {
        this.stepsData = null;
    }

    public final Z17MutableListFlow<String> getStepsData() {
        return this.stepsData;
    }

    public final void setInitSteps(int cant) {
        ArrayList arrayList = new ArrayList(cant);
        for (int i10 = 0; i10 < cant; i10++) {
            arrayList.add("");
        }
        this.stepsData = new Z17MutableListFlow<>(arrayList);
    }

    public final void setStepsData(Z17MutableListFlow<String> z17MutableListFlow) {
        this.stepsData = z17MutableListFlow;
    }
}
