package cu.todus.android.uiCompose.main.screen.chat.component.group;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.runtime.State;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatScreenState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.group.ChatGroupScreenKt$ChatGroupScreen$4$5$1", f = "ChatGroupScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class ChatGroupScreenKt$ChatGroupScreen$4$5$1 extends cb.m implements Function2 {
    final /* synthetic */ State<ChatScreenState> $chatScreenState$delegate;
    final /* synthetic */ TextFieldState $input;
    final /* synthetic */ ChatViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatGroupScreenKt$ChatGroupScreen$4$5$1(TextFieldState textFieldState, ChatViewModel chatViewModel, State<ChatScreenState> state, ab.e<? super ChatGroupScreenKt$ChatGroupScreen$4$5$1> eVar) {
        super(2, eVar);
        this.$input = textFieldState;
        this.$viewModel = chatViewModel;
        this.$chatScreenState$delegate = state;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new ChatGroupScreenKt$ChatGroupScreen$4$5$1(this.$input, this.$viewModel, this.$chatScreenState$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        String draft;
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        ChatScreenState chatScreenStateChatGroupScreen$lambda$6 = ChatGroupScreenKt.ChatGroupScreen$lambda$6(this.$chatScreenState$delegate);
        if (chatScreenStateChatGroupScreen$lambda$6 != null && (draft = chatScreenStateChatGroupScreen$lambda$6.getDraft()) != null && (!le.d0.q0(draft)) && le.d0.q0(this.$input.getText())) {
            TextFieldState textFieldState = this.$input;
            ChatScreenState chatScreenStateChatGroupScreen$lambda$7 = ChatGroupScreenKt.ChatGroupScreen$lambda$6(this.$chatScreenState$delegate);
            kotlin.jvm.internal.y.f(chatScreenStateChatGroupScreen$lambda$7);
            TextFieldStateKt.setTextAndPlaceCursorAtEnd(textFieldState, chatScreenStateChatGroupScreen$lambda$7.getDraft());
            ChatViewModel chatViewModel = this.$viewModel;
            ChatScreenState chatScreenStateChatGroupScreen$lambda$8 = ChatGroupScreenKt.ChatGroupScreen$lambda$6(this.$chatScreenState$delegate);
            kotlin.jvm.internal.y.f(chatScreenStateChatGroupScreen$lambda$8);
            chatViewModel.clearRoomDraft(chatScreenStateChatGroupScreen$lambda$8.getId());
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((ChatGroupScreenKt$ChatGroupScreen$4$5$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
