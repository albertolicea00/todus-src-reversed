package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.compose.runtime.ComposerKt;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState", f = "DynamicCropState.kt", l = {ComposerKt.compositionLocalMapKey}, m = "onGesture-t6rOp4E$views_release")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class DynamicCropState$onGesture$1 extends cb.d {
    float F$0;
    float F$1;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DynamicCropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicCropState$onGesture$1(DynamicCropState dynamicCropState, e<? super DynamicCropState$onGesture$1> eVar) {
        super(eVar);
        this.this$0 = dynamicCropState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo10215onGesturet6rOp4E$views_release(0L, 0L, 0.0f, 0.0f, null, null, this);
    }
}
