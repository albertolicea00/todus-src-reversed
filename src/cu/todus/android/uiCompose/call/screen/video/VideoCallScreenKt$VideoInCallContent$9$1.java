package cu.todus.android.uiCompose.call.screen.video;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import pe.w0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.call.screen.video.VideoCallScreenKt$VideoInCallContent$9$1", f = "VideoCallScreen.kt", l = {271}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class VideoCallScreenKt$VideoInCallContent$9$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<Boolean> $controlsVisible$delegate;
    final /* synthetic */ boolean $isConnected;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallScreenKt$VideoInCallContent$9$1(boolean z10, MutableState<Boolean> mutableState, ab.e<? super VideoCallScreenKt$VideoInCallContent$9$1> eVar) {
        super(2, eVar);
        this.$isConnected = z10;
        this.$controlsVisible$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new VideoCallScreenKt$VideoInCallContent$9$1(this.$isConnected, this.$controlsVisible$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            if (VideoCallScreenKt.VideoInCallContent$lambda$5(this.$controlsVisible$delegate) && this.$isConnected) {
                this.label = 1;
                if (w0.b(4000L, this) == objG) {
                    return objG;
                }
            }
            return k0.f43947a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        VideoCallScreenKt.VideoInCallContent$lambda$6(this.$controlsVisible$delegate, false);
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((VideoCallScreenKt$VideoInCallContent$9$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
