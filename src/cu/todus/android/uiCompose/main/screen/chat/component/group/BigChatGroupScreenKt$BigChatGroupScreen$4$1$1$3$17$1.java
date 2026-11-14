package cu.todus.android.uiCompose.main.screen.chat.component.group;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.volatileState.MsgListenerFor;
import cu.z17.singledi.SinglediException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.group.BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1", f = "BigChatGroupScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1 extends cb.m implements Function2 {
    final /* synthetic */ ChatParams $chatParams;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableState<Function1> $scrollBottom$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1(ChatParams chatParams, LazyListState lazyListState, MutableState<Function1> mutableState, ab.e<? super BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1> eVar) {
        super(2, eVar);
        this.$chatParams = chatParams;
        this.$listState = lazyListState;
        this.$scrollBottom$delegate = mutableState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1(this.$chatParams, this.$listState, this.$scrollBottom$delegate, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) throws SinglediException {
        bb.b.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(obj);
        AppVolatileState singletonInitializer = AppVolatileState.INSTANCE.getInstance();
        final ChatParams chatParams = this.$chatParams;
        final LazyListState lazyListState = this.$listState;
        final MutableState<Function1> mutableState = this.$scrollBottom$delegate;
        singletonInitializer.setOnNewMessageListener(new MsgListenerFor() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.group.BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1.1
            @Override // cu.todus.android.volatileState.MsgListenerFor
            public void received(String uid) {
                kotlin.jvm.internal.y.i(uid, "uid");
                if (!kotlin.jvm.internal.y.d(uid, chatParams.getUid()) || lazyListState.getFirstVisibleItemIndex() >= 3) {
                    kotlin.jvm.internal.y.d(uid, chatParams.getUid());
                    return;
                }
                Function1 function1BigChatGroupScreen$lambda$9 = BigChatGroupScreenKt.BigChatGroupScreen$lambda$9(mutableState);
                if (function1BigChatGroupScreen$lambda$9 != null) {
                    function1BigChatGroupScreen$lambda$9.invoke(Boolean.TRUE);
                }
            }
        });
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((BigChatGroupScreenKt$BigChatGroupScreen$4$1$1$3$17$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
