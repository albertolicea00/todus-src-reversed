package cu.todus.android.uiCompose.main.screen.chat.component.group;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ChatGroupScreenKt$ChatGroupScreen$4$1$3$9$1 extends kotlin.jvm.internal.v implements Function1 {
    final /* synthetic */ MutableState<Function1> $scrollToPosition$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatGroupScreenKt$ChatGroupScreen$4$1$3$9$1(MutableState<Function1> mutableState) {
        super(1, kotlin.jvm.internal.y.a.class, "goReply", "ChatGroupScreen$lambda$83$0$goReply(Landroidx/compose/runtime/MutableState;I)V", 0);
        this.$scrollToPosition$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return ua.k0.f43947a;
    }

    public final void invoke(int i10) {
        ChatGroupScreenKt.ChatGroupScreen$lambda$83$0$goReply(this.$scrollToPosition$delegate, i10);
    }
}
