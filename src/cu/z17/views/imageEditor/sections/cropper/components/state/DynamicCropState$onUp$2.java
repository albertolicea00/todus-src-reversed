package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onUp$2", f = "DynamicCropState.kt", l = {173, 177}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 2, 0})
public final class DynamicCropState$onUp$2 extends m implements Function2 {
    boolean Z$0;
    int label;
    final /* synthetic */ DynamicCropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicCropState$onUp$2(DynamicCropState dynamicCropState, e<? super DynamicCropState$onUp$2> eVar) {
        super(2, eVar);
        this.this$0 = dynamicCropState;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new DynamicCropState$onUp$2(this.this$0, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release$default(r3, r4, true, null, r7, 4, null) == r0) goto L20;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L21
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            ua.v.b(r12)
            r7 = r11
            goto L79
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1b:
            boolean r1 = r11.Z$0
            ua.v.b(r12)
            goto L63
        L21:
            ua.v.b(r12)
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r11.this$0
            cu.z17.views.imageEditor.sections.cropper.components.TouchRegion r12 = r12.getTouchRegion()
            cu.z17.views.imageEditor.sections.cropper.components.TouchRegion r1 = cu.z17.views.imageEditor.sections.cropper.components.TouchRegion.None
            if (r12 == r1) goto L8a
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r11.this$0
            androidx.compose.ui.geometry.Rect r1 = r12.getOverlayRect()
            boolean r1 = r12.isRectInContainerBounds$views_release(r1)
            if (r1 != 0) goto L63
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r11.this$0
            androidx.compose.ui.geometry.Rect r4 = cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.access$getRectBounds$p(r12)
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r5 = r11.this$0
            androidx.compose.ui.geometry.Rect r5 = r5.getOverlayRect()
            androidx.compose.ui.geometry.Rect r4 = cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.access$calculateOverlayRectInBounds(r12, r4, r5)
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.access$setRectTemp$p(r12, r4)
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r5 = r11.this$0
            androidx.compose.ui.geometry.Rect r6 = cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.access$getRectTemp$p(r5)
            r11.Z$0 = r1
            r11.label = r3
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateOverlayRectTo$views_release$default(r5, r6, r7, r8, r9, r10)
            r7 = r8
            if (r12 != r0) goto L64
            goto L78
        L63:
            r7 = r11
        L64:
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r3 = r7.this$0
            androidx.compose.ui.geometry.Rect r4 = r3.getOverlayRect()
            r7.Z$0 = r1
            r7.label = r2
            r5 = 1
            r6 = 0
            r8 = 4
            r9 = 0
            java.lang.Object r12 = cu.z17.views.imageEditor.sections.cropper.components.state.CropState.animateTransformationToOverlayBounds$views_release$default(r3, r4, r5, r6, r7, r8, r9)
            if (r12 != r0) goto L79
        L78:
            return r0
        L79:
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r7.this$0
            androidx.compose.ui.geometry.Rect r0 = r12.updateImageDrawRectFromTransformation$views_release()
            r12.setDrawAreaRect(r0)
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r7.this$0
            cu.z17.views.imageEditor.sections.cropper.components.TouchRegion r0 = cu.z17.views.imageEditor.sections.cropper.components.TouchRegion.None
            r12.setTouchRegion(r0)
            goto L8b
        L8a:
            r7 = r11
        L8b:
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState r12 = r7.this$0
            r0 = 0
            cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState.access$setGestureInvoked$p(r12, r0)
            ua.k0 r12 = ua.k0.f43947a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.z17.views.imageEditor.sections.cropper.components.state.DynamicCropState$onUp$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((DynamicCropState$onUp$2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
