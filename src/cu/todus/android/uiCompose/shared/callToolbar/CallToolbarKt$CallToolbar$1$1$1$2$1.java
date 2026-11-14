package cu.todus.android.uiCompose.shared.callToolbar;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class CallToolbarKt$CallToolbar$1$1$1$2$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ m0 $coroutineScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallToolbarKt$CallToolbar$1$1$1$2$1(m0 m0Var) {
        super(1, y.a.class, "rejectCall", "CallToolbar$rejectCall(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", 0);
        this.$coroutineScope = m0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return k0.f43947a;
    }

    public final void invoke(String p10) {
        y.i(p10, "p0");
        CallToolbarKt.CallToolbar$rejectCall(this.$coroutineScope, p10);
    }
}
