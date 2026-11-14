package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class StickerContentKt$StickerViewForList$1$3$1 implements PointerInputEventHandler {
    final /* synthetic */ lb.a $onClick;
    final /* synthetic */ lb.a $onLongClick;
    final /* synthetic */ MutableState<Boolean> $showContextAction$delegate;

    public StickerContentKt$StickerViewForList$1$3$1(lb.a aVar, MutableState<Boolean> mutableState, lb.a aVar2) {
        this.$onLongClick = aVar;
        this.$showContextAction$delegate = mutableState;
        this.$onClick = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(lb.a aVar, MutableState mutableState, Offset offset) {
        StickerContentKt.StickerViewForList$lambda$0$2(mutableState, true);
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$1(lb.a aVar, Offset offset) {
        aVar.invoke();
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final lb.a aVar = this.$onLongClick;
        final MutableState<Boolean> mutableState = this.$showContextAction$delegate;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerContentKt$StickerViewForList$1$3$1.invoke$lambda$0(aVar, mutableState, (Offset) obj);
            }
        };
        final lb.a aVar2 = this.$onClick;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StickerContentKt$StickerViewForList$1$3$1.invoke$lambda$1(aVar2, (Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
