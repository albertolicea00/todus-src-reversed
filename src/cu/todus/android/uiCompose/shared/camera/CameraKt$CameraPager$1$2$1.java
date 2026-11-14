package cu.todus.android.uiCompose.shared.camera;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.shared.camera.CameraKt$CameraPager$1$2$1", f = "Camera.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class CameraKt$CameraPager$1$2$1 extends cb.m implements Function2 {
    final /* synthetic */ MutableState<String> $imagePath$delegate;
    final /* synthetic */ lb.a $onError;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ MutableState<Pair<String, Long>> $videoPathAndDuration$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraKt$CameraPager$1$2$1(PagerState pagerState, lb.a aVar, MutableState<String> mutableState, MutableState<Pair<String, Long>> mutableState2, ab.e<? super CameraKt$CameraPager$1$2$1> eVar) {
        super(2, eVar);
        this.$pagerState = pagerState;
        this.$onError = aVar;
        this.$imagePath$delegate = mutableState;
        this.$videoPathAndDuration$delegate = mutableState2;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new CameraKt$CameraPager$1$2$1(this.$pagerState, this.$onError, this.$imagePath$delegate, this.$videoPathAndDuration$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        if (this.$pagerState.getCurrentPage() == 1 && CameraKt.CameraPager$lambda$0$2(this.$imagePath$delegate).length() == 0) {
            this.$onError.invoke();
        }
        if (this.$pagerState.getCurrentPage() == 2 && ((CharSequence) CameraKt.CameraPager$lambda$0$8(this.$videoPathAndDuration$delegate).getFirst()).length() == 0) {
            this.$onError.invoke();
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((CameraKt$CameraPager$1$2$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
