package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class CallContentKt$CallContent$1$1 implements PointerInputEventHandler {
    public static final CallContentKt$CallContent$1$1 INSTANCE = new CallContentKt$CallContent$1$1();

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(Offset offset) {
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$1(Offset offset) {
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CallContentKt$CallContent$1$1.invoke$lambda$0((Offset) obj);
            }
        }, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CallContentKt$CallContent$1$1.invoke$lambda$1((Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
