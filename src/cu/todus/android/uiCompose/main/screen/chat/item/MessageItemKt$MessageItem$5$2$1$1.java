package cu.todus.android.uiCompose.main.screen.chat.item;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class MessageItemKt$MessageItem$5$2$1$1 implements PointerInputEventHandler {
    final /* synthetic */ boolean $canReact;
    final /* synthetic */ MessageWithPartnerWithReactions $msg;
    final /* synthetic */ Function1 $onGroupMemberNameClicked;
    final /* synthetic */ Function2 $onLongClick;
    final /* synthetic */ MutableState<Boolean> $showReaction$delegate;

    public MessageItemKt$MessageItem$5$2$1$1(boolean z10, Function2 function2, MessageWithPartnerWithReactions messageWithPartnerWithReactions, MutableState<Boolean> mutableState, Function1 function1) {
        this.$canReact = z10;
        this.$onLongClick = function2;
        this.$msg = messageWithPartnerWithReactions;
        this.$showReaction$delegate = mutableState;
        this.$onGroupMemberNameClicked = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$0(boolean z10, Function2 function2, MessageWithPartnerWithReactions messageWithPartnerWithReactions, MutableState mutableState, Offset offset) {
        if (z10) {
            MessageItemKt.MessageItem$lambda$4$2(mutableState, true);
        }
        function2.invoke(messageWithPartnerWithReactions, 0);
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 invoke$lambda$1(Function1 function1, MessageWithPartnerWithReactions messageWithPartnerWithReactions, Offset offset) {
        function1.invoke(messageWithPartnerWithReactions.getMessage().getUserSender());
        return ua.k0.f43947a;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, ab.e<? super ua.k0> eVar) {
        final boolean z10 = this.$canReact;
        final Function2 function2 = this.$onLongClick;
        final MessageWithPartnerWithReactions messageWithPartnerWithReactions = this.$msg;
        final MutableState<Boolean> mutableState = this.$showReaction$delegate;
        Function1 function1 = new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageItemKt$MessageItem$5$2$1$1.invoke$lambda$0(z10, function2, messageWithPartnerWithReactions, mutableState, (Offset) obj);
            }
        };
        final Function1 function3 = this.$onGroupMemberNameClicked;
        final MessageWithPartnerWithReactions messageWithPartnerWithReactions2 = this.$msg;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, null, new Function1() { // from class: cu.todus.android.uiCompose.main.screen.chat.item.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageItemKt$MessageItem$5$2$1$1.invoke$lambda$1(function3, messageWithPartnerWithReactions2, (Offset) obj);
            }
        }, eVar, 5, null);
        return objDetectTapGestures$default == bb.b.g() ? objDetectTapGestures$default : ua.k0.f43947a;
    }
}
