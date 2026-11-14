package cu.todus.android.viewModel;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import androidx.p001lifecycle.ViewModelKt;
import kotlin.Metadata;
import pe.e2;
import pe.n0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcu/todus/android/viewModel/ToDusViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Lua/k0;", "onCleared", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ToDusViewModel extends ViewModel {
    public static final int $stable = 8;

    @Override // androidx.p001lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        n0.d(ViewModelKt.getViewModelScope(this), null, 1, null);
        e2.e(ViewModelKt.getViewModelScope(this).getCoroutineContext(), null, 1, null);
    }
}
