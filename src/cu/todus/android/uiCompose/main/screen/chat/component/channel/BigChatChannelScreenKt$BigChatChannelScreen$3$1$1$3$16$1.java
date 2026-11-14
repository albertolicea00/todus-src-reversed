package cu.todus.android.uiCompose.main.screen.chat.component.channel;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableIntState;
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
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.channel.BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1", f = "BigChatChannelScreen.kt", l = {}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1 extends cb.m implements Function2 {
    final /* synthetic */ ChatParams $chatParams;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableIntState $newCount$delegate;
    final /* synthetic */ MutableState<Function1> $scrollBottom$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1(ChatParams chatParams, LazyListState lazyListState, MutableState<Function1> mutableState, MutableIntState mutableIntState, ab.e<? super BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1> eVar) {
        super(2, eVar);
        this.$chatParams = chatParams;
        this.$listState = lazyListState;
        this.$scrollBottom$delegate = mutableState;
        this.$newCount$delegate = mutableIntState;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1(this.$chatParams, this.$listState, this.$scrollBottom$delegate, this.$newCount$delegate, eVar);
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
        final MutableIntState mutableIntState = this.$newCount$delegate;
        singletonInitializer.setOnNewMessageListener(new MsgListenerFor() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.channel.BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1.1
            @Override // cu.todus.android.volatileState.MsgListenerFor
            public void received(String uid) {
                kotlin.jvm.internal.y.i(uid, "uid");
                if (!kotlin.jvm.internal.y.d(uid, chatParams.getUid()) || lazyListState.getFirstVisibleItemIndex() >= 3) {
                    if (kotlin.jvm.internal.y.d(uid, chatParams.getUid())) {
                        MutableIntState mutableIntState2 = mutableIntState;
                        mutableIntState2.setIntValue(mutableIntState2.getIntValue() + 1);
                        return;
                    }
                    return;
                }
                Function1 function1BigChatChannelScreen$lambda$9 = BigChatChannelScreenKt.BigChatChannelScreen$lambda$9(mutableState);
                if (function1BigChatChannelScreen$lambda$9 != null) {
                    function1BigChatChannelScreen$lambda$9.invoke(Boolean.TRUE);
                }
            }
        });
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
        return ((BigChatChannelScreenKt$BigChatChannelScreen$3$1$1$3$16$1) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
