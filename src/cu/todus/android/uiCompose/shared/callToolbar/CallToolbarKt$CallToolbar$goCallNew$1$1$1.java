package cu.todus.android.uiCompose.shared.callToolbar;

import android.content.Context;
import cu.todus.android.uiCompose.call.AudioCallActivity;
import cu.todus.android.uiCompose.call.VideoCallActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.shared.callToolbar.CallToolbarKt$CallToolbar$goCallNew$1$1$1", f = "CallToolbar.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class CallToolbarKt$CallToolbar$goCallNew$1$1$1 extends cb.m implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isVideoCall;
    final /* synthetic */ String $uid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallToolbarKt$CallToolbar$goCallNew$1$1$1(boolean z10, Context context, String str, ab.e<? super CallToolbarKt$CallToolbar$goCallNew$1$1$1> eVar) {
        super(2, eVar);
        this.$isVideoCall = z10;
        this.$context = context;
        this.$uid = str;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CallToolbarKt$CallToolbar$goCallNew$1$1$1(this.$isVideoCall, this.$context, this.$uid, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (this.$isVideoCall) {
            VideoCallActivity.INSTANCE.start(this.$context, this.$uid);
        } else {
            AudioCallActivity.INSTANCE.start(this.$context, this.$uid);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CallToolbarKt$CallToolbar$goCallNew$1$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
