package cu.z17.views.label;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1 $onClick;
    final /* synthetic */ lb.a $onLongClick;

    public Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1(lb.a aVar, MutableState<TextLayoutResult> mutableState, Function1 function1) {
        this.$onLongClick = aVar;
        this.$layoutResult = mutableState;
        this.$onClick = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(lb.a aVar, Offset offset) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$2(MutableState mutableState, Function1 function1, Offset offset) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) mutableState.getValue();
        if (textLayoutResult != null) {
            function1.invoke(Integer.valueOf(textLayoutResult.m8228getOffsetForPositionk4lQ0M(offset.m5636unboximpl())));
        }
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final lb.a aVar = this.$onLongClick;
        Function1 function1 = new Function1() { // from class: cu.z17.views.label.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1.invoke$lambda$0(aVar, (Offset) obj);
            }
        };
        final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
        final Function1 function2 = this.$onClick;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, null, new Function1() { // from class: cu.z17.views.label.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Z17ClickableLabelKt$LongClickableText$pressIndicator$1$1.invoke$lambda$2(mutableState, function2, (Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
