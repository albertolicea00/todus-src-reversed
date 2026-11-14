package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.TransformState", f = "TransformState.kt", l = {113, 119, 123, 124}, m = "updateTransformState-IUXd7x4$suspendImpl")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class TransformState$updateTransformState$1 extends cb.d {
    float F$0;
    float F$1;
    float F$2;
    float F$3;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransformState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformState$updateTransformState$1(TransformState transformState, e<? super TransformState$updateTransformState$1> eVar) {
        super(eVar);
        this.this$0 = transformState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TransformState.m10221updateTransformStateIUXd7x4$suspendImpl(this.this$0, 0L, 0L, 0.0f, 0.0f, this);
    }
}
