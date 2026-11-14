package cu.todus.android.uiCompose.call.screen.call;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class CallScreenKt$CallScreen$1$2$2$1$1 extends v implements Function1 {
    public CallScreenKt$CallScreen$1$2$2$1$1(Object obj) {
        super(1, obj, CallViewModel.class, "acceptCall", "acceptCall(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return k0.f43947a;
    }

    public final void invoke(String p10) {
        y.i(p10, "p0");
        ((CallViewModel) this.receiver).acceptCall(p10);
    }
}
