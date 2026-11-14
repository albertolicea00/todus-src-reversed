package cu.todus.android.uiCompose.main.screen.chat.preview;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class MsgPreviewKt$PinnedPreview$1$2$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableFloatState $horizontalDragging$delegate;
    final /* synthetic */ MutableState<Boolean> $isDragging$delegate;
    final /* synthetic */ lb.a $onCancel;
    final /* synthetic */ int $screenWidth;

    public MsgPreviewKt$PinnedPreview$1$2$1(MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, int i10, lb.a aVar) {
        this.$isDragging$delegate = mutableState;
        this.$horizontalDragging$delegate = mutableFloatState;
        this.$screenWidth = i10;
        this.$onCancel = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$0(MutableState mutableState, Offset offset) {
        MsgPreviewKt.PinnedPreview$lambda$0$5(mutableState, true);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$1(MutableState mutableState, MutableFloatState mutableFloatState) {
        if (MsgPreviewKt.PinnedPreview$lambda$0$4(mutableState)) {
            MsgPreviewKt.PinnedPreview$lambda$0$5(mutableState, false);
            mutableFloatState.setFloatValue(0.0f);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$2(MutableState mutableState) {
        MsgPreviewKt.PinnedPreview$lambda$0$5(mutableState, false);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 invoke$lambda$3(int i10, lb.a aVar, MutableState mutableState, MutableFloatState mutableFloatState, PointerInputChange change, float f10) {
        kotlin.jvm.internal.y.i(change, "change");
        if (MsgPreviewKt.PinnedPreview$lambda$0$4(mutableState)) {
            float fAbs = Math.abs(f10);
            if (Float.intBitsToFloat((int) (change.getPosition() >> 32)) > 0.0f && f10 > 0.0f) {
                mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + (fAbs / 2));
            } else if (Float.intBitsToFloat((int) (change.getPosition() >> 32)) > 0.0f && f10 < 0.0f && mutableFloatState.getFloatValue() > 0.0f) {
                mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() - (fAbs / 2));
            }
            if ((mutableFloatState.getFloatValue() / i10) * 100 > 70.0f) {
                MsgPreviewKt.PinnedPreview$lambda$0$5(mutableState, false);
                aVar.invoke();
            }
        }
        return k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super k0> eVar) {
        final MutableState<Boolean> mutableState = this.$isDragging$delegate;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MsgPreviewKt$PinnedPreview$1$2$1.invoke$lambda$0(mutableState, (Offset) obj);
            }
        };
        final MutableState<Boolean> mutableState2 = this.$isDragging$delegate;
        final MutableFloatState mutableFloatState = this.$horizontalDragging$delegate;
        lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.w
            @Override // lb.a
            public final Object invoke() {
                return MsgPreviewKt$PinnedPreview$1$2$1.invoke$lambda$1(mutableState2, mutableFloatState);
            }
        };
        final MutableState<Boolean> mutableState3 = this.$isDragging$delegate;
        lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.x
            @Override // lb.a
            public final Object invoke() {
                return MsgPreviewKt$PinnedPreview$1$2$1.invoke$lambda$2(mutableState3);
            }
        };
        final int i10 = this.$screenWidth;
        final lb.a aVar3 = this.$onCancel;
        final MutableState<Boolean> mutableState4 = this.$isDragging$delegate;
        final MutableFloatState mutableFloatState2 = this.$horizontalDragging$delegate;
        Object objDetectHorizontalDragGestures = DragGestureDetectorKt.detectHorizontalDragGestures(pointerInputScope, function1, aVar, aVar2, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.preview.y
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MsgPreviewKt$PinnedPreview$1$2$1.invoke$lambda$3(i10, aVar3, mutableState4, mutableFloatState2, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, eVar);
        return objDetectHorizontalDragGestures == bb.b.g() ? objDetectHorizontalDragGestures : k0.f43947a;
    }
}
