package cu.z17.views.imageEditor.sections.cropper.components;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.z17.views.imageEditor.sections.cropper.components.state.CropState;
import cu.z17.views.imageEditor.sections.cropper.components.util.ZoomLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class CropModifierKt$crop$2$tapModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ m0 $coroutineScope;
    final /* synthetic */ CropState $cropState;
    final /* synthetic */ Function1 $onGestureEnd;
    final /* synthetic */ MutableState<ZoomLevel> $zoomLevel$delegate;
    final /* synthetic */ Function1 $zoomOnDoubleTap;

    public CropModifierKt$crop$2$tapModifier$1$1(m0 m0Var, Function1 function1, CropState cropState, MutableState<ZoomLevel> mutableState, Function1 function2) {
        this.$coroutineScope = m0Var;
        this.$zoomOnDoubleTap = function1;
        this.$cropState = cropState;
        this.$zoomLevel$delegate = mutableState;
        this.$onGestureEnd = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(m0 m0Var, Function1 function1, CropState cropState, MutableState mutableState, Function1 function2, Offset offset) {
        pe.k.d(m0Var, null, null, new CropModifierKt$crop$2$tapModifier$1$1$1$1(function1, cropState, offset, mutableState, function2, null), 3, null);
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final m0 m0Var = this.$coroutineScope;
        final Function1 function1 = this.$zoomOnDoubleTap;
        final CropState cropState = this.$cropState;
        final MutableState<ZoomLevel> mutableState = this.$zoomLevel$delegate;
        final Function1 function2 = this.$onGestureEnd;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, new Function1() { // from class: cu.z17.views.imageEditor.sections.cropper.components.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropModifierKt$crop$2$tapModifier$1$1.invoke$lambda$0(m0Var, function1, cropState, mutableState, function2, (Offset) obj);
            }
        }, null, null, null, eVar, 14, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : k0.f43947a;
    }
}
