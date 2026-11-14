package cu.z17.views.imageEditor.sections.cropper.components.state;

import ab.e;
import androidx.media3.muxer.WebmConstants;
import cb.f;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.z17.views.imageEditor.sections.cropper.components.state.CropState", f = "CropStateImpl.kt", l = {148, WebmConstants.MkvEbmlElement.BLOCK_DURATION, 168}, m = "updateProperties$suspendImpl")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class CropState$updateProperties$1 extends cb.d {
    float F$0;
    float F$1;
    float F$2;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CropState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropState$updateProperties$1(CropState cropState, e<? super CropState$updateProperties$1> eVar) {
        super(eVar);
        this.this$0 = cropState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CropState.updateProperties$suspendImpl(this.this$0, null, false, this);
    }
}
