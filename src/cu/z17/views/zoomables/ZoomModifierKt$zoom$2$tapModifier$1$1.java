package cu.z17.views.zoomables;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ZoomModifierKt$zoom$2$tapModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ MutableState<ZoomLevel> $zoomLevel$delegate;
    final /* synthetic */ ZoomState $zoomState;

    public ZoomModifierKt$zoom$2$tapModifier$1$1(ZoomState zoomState, m0 m0Var, MutableState<ZoomLevel> mutableState) {
        this.$zoomState = zoomState;
        this.$coroutineScope = m0Var;
        this.$zoomLevel$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(ZoomState zoomState, m0 m0Var, MutableState mutableState, Offset offset) {
        Pair<ZoomLevel, Float> pairCalculateZoom = ZoomUtilKt.calculateZoom(ZoomModifierKt.zoom$lambda$8$lambda$2(mutableState), zoomState.getZoomInitial(), zoomState.getZoomMin(), zoomState.getZoomMax());
        ZoomLevel zoomLevelComponent1 = pairCalculateZoom.component1();
        float fFloatValue = pairCalculateZoom.component2().floatValue();
        mutableState.setValue(zoomLevelComponent1);
        pe.k.d(m0Var, null, null, new ZoomModifierKt$zoom$2$tapModifier$1$1$1$1(zoomState, fFloatValue, null), 3, null);
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        this.$zoomState.m10348setSizeozmzZPI$views_release(pointerInputScope.getBoundsSize());
        final ZoomState zoomState = this.$zoomState;
        final m0 m0Var = this.$coroutineScope;
        final MutableState<ZoomLevel> mutableState = this.$zoomLevel$delegate;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, new Function1() { // from class: cu.z17.views.zoomables.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ZoomModifierKt$zoom$2$tapModifier$1$1.invoke$lambda$0(zoomState, m0Var, mutableState, (Offset) obj);
            }
        }, null, null, null, eVar, 14, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : k0.f43947a;
    }
}
