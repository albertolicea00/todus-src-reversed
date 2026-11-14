package cu.todus.android.uiCompose.main.screen.chat.item.content;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.todus.android.uiCompose.main.screen.chat.item.MessageAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class VoiceContentKt$VoiceContent$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function2 $onClick;
    final /* synthetic */ Function2 $onLongClick;

    public VoiceContentKt$VoiceContent$1$1(Function2 function2, Function2 function3) {
        this.$onLongClick = function2;
        this.$onClick = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(Function2 function2, Offset offset) {
        function2.invoke(MessageAction.REGULAR_LONG_CLICK, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$1(Function2 function2, Offset offset) {
        function2.invoke(MessageAction.REGULAR_CLICK, 0);
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final Function2 function2 = this.$onLongClick;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.k3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VoiceContentKt$VoiceContent$1$1.invoke$lambda$0(function2, (Offset) obj);
            }
        };
        final Function2 function3 = this.$onClick;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.content.l3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VoiceContentKt$VoiceContent$1$1.invoke$lambda$1(function3, (Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
