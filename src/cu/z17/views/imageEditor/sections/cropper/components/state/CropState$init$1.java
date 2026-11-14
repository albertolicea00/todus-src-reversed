package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.CropState", f = "CropStateImpl.kt", l = {106}, m = "init$views_release")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class CropState$init$1 extends cb.d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropState$init$1(CropState cropState, e<? super CropState$init$1> eVar) {
        super(eVar);
        this.this$0 = cropState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.init$views_release(this);
    }
}
