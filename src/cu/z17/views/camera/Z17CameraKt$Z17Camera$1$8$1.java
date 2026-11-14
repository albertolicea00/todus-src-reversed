package cu.z17.views.camera;

import androidx.camera.view.PreviewView;
import androidx.p001lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes5.dex */
@cb.f(c = "cu.z17.views.camera.Z17CameraKt$Z17Camera$1$8$1", f = "Z17Camera.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class Z17CameraKt$Z17Camera$1$8$1 extends cb.m implements Function2 {
    final /* synthetic */ boolean $isVideo;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ PreviewView $previewView;
    final /* synthetic */ Z17CameraViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z17CameraKt$Z17Camera$1$8$1(boolean z10, Z17CameraViewModel z17CameraViewModel, PreviewView previewView, LifecycleOwner lifecycleOwner, ab.e<? super Z17CameraKt$Z17Camera$1$8$1> eVar) {
        super(2, eVar);
        this.$isVideo = z10;
        this.$viewModel = z17CameraViewModel;
        this.$previewView = previewView;
        this.$lifecycleOwner = lifecycleOwner;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new Z17CameraKt$Z17Camera$1$8$1(this.$isVideo, this.$viewModel, this.$previewView, this.$lifecycleOwner, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.b(obj);
        Z17CameraModule.INSTANCE.getInstance().getImageCapture().setFlashMode(2);
        if (this.$isVideo) {
            this.$viewModel.showVideoCamera(this.$previewView, this.$lifecycleOwner);
        } else {
            this.$viewModel.showCamera(this.$previewView, this.$lifecycleOwner);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((Z17CameraKt$Z17Camera$1$8$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
