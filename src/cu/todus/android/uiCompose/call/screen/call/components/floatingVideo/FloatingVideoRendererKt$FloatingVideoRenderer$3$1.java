package cu.todus.android.uiCompose.call.screen.call.components.floatingVideo;

import ab.e;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import rb.k;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class FloatingVideoRendererKt$FloatingVideoRenderer$3$1 implements PointerInputEventHandler {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<Float> $offsetX$delegate;
    final /* synthetic */ MutableState<Float> $offsetY$delegate;
    final /* synthetic */ float $paddingOffset;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ long $parentBounds;
    final /* synthetic */ MutableState<IntSize> $videoSize$delegate;

    public FloatingVideoRendererKt$FloatingVideoRenderer$3$1(long j10, PaddingValues paddingValues, Density density, float f10, MutableState<Float> mutableState, MutableState<IntSize> mutableState2, MutableState<Float> mutableState3) {
        this.$parentBounds = j10;
        this.$paddingValues = paddingValues;
        this.$density = density;
        this.$paddingOffset = f10;
        this.$offsetX$delegate = mutableState;
        this.$videoSize$delegate = mutableState2;
        this.$offsetY$delegate = mutableState3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(long j10, PaddingValues paddingValues, Density density, float f10, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, PointerInputChange change, Offset offset) {
        y.i(change, "change");
        change.consume();
        float f11 = f10 * 2;
        float fI = k.i(k.d(FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$4(mutableState) + Float.intBitsToFloat((int) (offset.m5636unboximpl() >> 32)), -FloatingVideoRendererKt.m9821calculateHorizontalOffsetBounds7QRZqkg(j10, paddingValues, FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$1(mutableState2), density, f11)), 0.0f);
        float fI2 = k.i(k.d(FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$7(mutableState3) + Float.intBitsToFloat((int) (offset.m5636unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f), FloatingVideoRendererKt.m9822calculateVerticalOffsetBounds7QRZqkg(j10, paddingValues, FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$1(mutableState2), density, f11));
        FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$5(mutableState, fI);
        FloatingVideoRendererKt.FloatingVideoRenderer_JQ_Ljw8$lambda$8(mutableState3, fI2);
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, e<? super k0> eVar) {
        final long j10 = this.$parentBounds;
        final PaddingValues paddingValues = this.$paddingValues;
        final Density density = this.$density;
        final float f10 = this.$paddingOffset;
        final MutableState<Float> mutableState = this.$offsetX$delegate;
        final MutableState<IntSize> mutableState2 = this.$videoSize$delegate;
        final MutableState<Float> mutableState3 = this.$offsetY$delegate;
        Object objDetectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, null, null, new Function2() { // from class: cu.todus.android.uiCompose.call.screen.call.components.floatingVideo.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FloatingVideoRendererKt$FloatingVideoRenderer$3$1.invoke$lambda$0(j10, paddingValues, density, f10, mutableState, mutableState2, mutableState3, (PointerInputChange) obj, (Offset) obj2);
            }
        }, eVar, 7, null);
        return objDetectDragGestures$default == bb.b.g() ? objDetectDragGestures$default : k0.f43947a;
    }
}
