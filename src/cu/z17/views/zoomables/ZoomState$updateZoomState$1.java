package cu.z17.views.zoomables;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material.MenuKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@cb.f(c = "cu.z17.views.zoomables.ZoomState", f = "ZoomStateImpl.kt", l = {103, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 119, MenuKt.InTransitionDuration}, m = "updateZoomState-IUXd7x4$suspendImpl")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ZoomState$updateZoomState$1 extends cb.d {
    float F$0;
    float F$1;
    float F$2;
    float F$3;
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZoomState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomState$updateZoomState$1(ZoomState zoomState, ab.e<? super ZoomState$updateZoomState$1> eVar) {
        super(eVar);
        this.this$0 = zoomState;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ZoomState.m10342updateZoomStateIUXd7x4$suspendImpl(this.this$0, 0L, 0L, 0.0f, 0.0f, this);
    }
}
