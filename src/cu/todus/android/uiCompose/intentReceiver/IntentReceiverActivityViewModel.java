package cu.todus.android.uiCompose.intentReceiver;

import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.p001lifecycle.ViewModel;
import cu.todus.android.data.wrapper.FlowsState;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import te.b0;
import te.p0;
import te.r0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcu/todus/android/uiCompose/intentReceiver/IntentReceiverActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lua/k0;", "addNewIntent", "(Landroid/content/Intent;)V", "resetIntent", "Lte/b0;", "Lcu/todus/android/data/wrapper/FlowsState;", "_newIntent", "Lte/b0;", "Lte/p0;", "newIntent", "Lte/p0;", "getNewIntent", "()Lte/p0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntentReceiverActivityViewModel extends ViewModel {
    public static final int $stable = 8;
    private final b0 _newIntent;
    private final p0 newIntent;

    public IntentReceiverActivityViewModel() {
        b0 b0VarA = r0.a(FlowsState.INSTANCE.notRequested());
        this._newIntent = b0VarA;
        this.newIntent = te.j.b(b0VarA);
    }

    public final void addNewIntent(Intent intent) {
        y.i(intent, "intent");
        this._newIntent.setValue(FlowsState.INSTANCE.success(intent));
    }

    public final p0 getNewIntent() {
        return this.newIntent;
    }

    public final void resetIntent() {
        this._newIntent.setValue(FlowsState.INSTANCE.notRequested());
    }
}
