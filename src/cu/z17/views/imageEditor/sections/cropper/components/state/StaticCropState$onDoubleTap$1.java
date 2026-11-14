package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.StaticCropState", f = "StaticCropState.kt", l = {122, 124}, m = "onDoubleTap-M_7yMNQ$views_release")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StaticCropState$onDoubleTap$1 extends cb.d {
    float F$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StaticCropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticCropState$onDoubleTap$1(StaticCropState staticCropState, e<? super StaticCropState$onDoubleTap$1> eVar) {
        super(eVar);
        this.this$0 = staticCropState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo10214onDoubleTapM_7yMNQ$views_release(0L, 0.0f, null, this);
    }
}
