package cu.todus.android.uiCompose.main.screen.linkedDevice.deviceItem;

import androidx.constraintlayout.compose.ConstraintSet;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lua/k0;", "invoke", "()V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$3$1", "<anonymous>"}, k = 3, mv = {2, 3, 0})
public final class DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$1 extends e0 implements lb.a {
    final /* synthetic */ re.g $channel;
    final /* synthetic */ ConstraintSet $constraintSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceItemKt$DeviceItem$lambda$1$$inlined$ConstraintLayout$1(re.g gVar, ConstraintSet constraintSet) {
        super(0);
        this.$channel = gVar;
        this.$constraintSet = constraintSet;
    }

    @Override // lb.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m9940invoke();
        return k0.f43947a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9940invoke() {
        this.$channel.mo9376trySendJP2dKIU(this.$constraintSet);
    }
}
