package cu.todus.android;

import cu.todus.android.exceptions.ToDusException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ToDusApp$initializeCompleteApp$mainRepository$1$3 extends kotlin.jvm.internal.v implements Function1 {
    public ToDusApp$initializeCompleteApp$mainRepository$1$3(Object obj) {
        super(1, obj, ToDusApp.class, "setError", "setError(Lcu/todus/android/exceptions/ToDusException;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ToDusException) obj);
        return k0.f43947a;
    }

    public final void invoke(ToDusException p10) {
        kotlin.jvm.internal.y.i(p10, "p0");
        ((ToDusApp) this.receiver).setError(p10);
    }
}
