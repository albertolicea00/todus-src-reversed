package cu.todus.android.uiCompose.main.screen.chat.item;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class MessageContainerKt$ChatItemBox$2$1 implements PointerInputEventHandler {
    final /* synthetic */ boolean $canDrag;
    final /* synthetic */ HapticFeedback $hapticFeedback;
    final /* synthetic */ MutableFloatState $horizontalDragging$delegate;
    final /* synthetic */ MutableState<Boolean> $isDragging$delegate;
    final /* synthetic */ lb.a $onDragged;
    final /* synthetic */ int $screenWidth;

    public MessageContainerKt$ChatItemBox$2$1(boolean z10, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, int i10, HapticFeedback hapticFeedback, lb.a aVar) {
        this.$canDrag = z10;
        this.$isDragging$delegate = mutableState;
        this.$horizontalDragging$delegate = mutableFloatState;
        this.$screenWidth = i10;
        this.$hapticFeedback = hapticFeedback;
        this.$onDragged = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(boolean z10, MutableState mutableState, Offset offset) {
        if (z10) {
            MessageContainerKt.ChatItemBox$lambda$5(mutableState, true);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$1(boolean z10, MutableState mutableState, MutableFloatState mutableFloatState) {
        if (z10) {
            MessageContainerKt.ChatItemBox$lambda$5(mutableState, false);
            mutableFloatState.setFloatValue(0.0f);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$2(boolean z10, MutableState mutableState) {
        if (z10) {
            MessageContainerKt.ChatItemBox$lambda$5(mutableState, false);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$3(boolean z10, int i10, HapticFeedback hapticFeedback, lb.a aVar, MutableState mutableState, MutableFloatState mutableFloatState, PointerInputChange change, float f10) {
        kotlin.jvm.internal.y.i(change, "change");
        if (z10 && MessageContainerKt.ChatItemBox$lambda$4(mutableState)) {
            float fAbs = Math.abs(f10);
            if (Float.intBitsToFloat((int) (change.getPosition() >> 32)) > 0.0f && f10 > 0.0f) {
                mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + (fAbs / 2));
            } else if (Float.intBitsToFloat((int) (change.getPosition() >> 32)) > 0.0f && f10 < 0.0f && mutableFloatState.getFloatValue() > 0.0f) {
                mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() - (fAbs / 2));
            }
            if ((mutableFloatState.getFloatValue() / i10) * 100 > 45.0f) {
                hapticFeedback.mo6556performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6569getLongPress5zf0vsI());
                MessageContainerKt.ChatItemBox$lambda$5(mutableState, false);
                mutableFloatState.setFloatValue(0.0f);
                aVar.invoke();
            }
        }
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final boolean z10 = this.$canDrag;
        final MutableState<Boolean> mutableState = this.$isDragging$delegate;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageContainerKt$ChatItemBox$2$1.invoke$lambda$0(z10, mutableState, (Offset) obj);
            }
        };
        final boolean z11 = this.$canDrag;
        final MutableState<Boolean> mutableState2 = this.$isDragging$delegate;
        final MutableFloatState mutableFloatState = this.$horizontalDragging$delegate;
        lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.f
            @Override // lb.a
            public final Object invoke() {
                return MessageContainerKt$ChatItemBox$2$1.invoke$lambda$1(z11, mutableState2, mutableFloatState);
            }
        };
        final boolean z12 = this.$canDrag;
        final MutableState<Boolean> mutableState3 = this.$isDragging$delegate;
        lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.g
            @Override // lb.a
            public final Object invoke() {
                return MessageContainerKt$ChatItemBox$2$1.invoke$lambda$2(z12, mutableState3);
            }
        };
        final boolean z13 = this.$canDrag;
        final int i10 = this.$screenWidth;
        final HapticFeedback hapticFeedback = this.$hapticFeedback;
        final lb.a aVar3 = this.$onDragged;
        final MutableState<Boolean> mutableState4 = this.$isDragging$delegate;
        final MutableFloatState mutableFloatState2 = this.$horizontalDragging$delegate;
        Object objDetectHorizontalDragGestures = DragGestureDetectorKt.detectHorizontalDragGestures(pointerInputScope, function1, aVar, aVar2, new Function2() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MessageContainerKt$ChatItemBox$2$1.invoke$lambda$3(z13, i10, hapticFeedback, aVar3, mutableState4, mutableFloatState2, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, eVar);
        return objDetectHorizontalDragGestures == bb.b.g() ? objDetectHorizontalDragGestures : ua.k0.f43947a;
    }
}
