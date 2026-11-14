package cu.todus.android.uiCompose.main.screen.chat.component;

import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$2$1", f = "ChatViewModel.kt", l = {560, 564, 599}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "mwp"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class ChatViewModel$chatMsgs$2$1 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChatViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatViewModel$chatMsgs$2$1(ChatViewModel chatViewModel, ab.e<? super ChatViewModel$chatMsgs$2$1> eVar) {
        super(2, eVar);
        this.this$0 = chatViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        ChatViewModel$chatMsgs$2$1 chatViewModel$chatMsgs$2$1 = new ChatViewModel$chatMsgs$2$1(this.this$0, eVar);
        chatViewModel$chatMsgs$2$1.L$0 = obj;
        return chatViewModel$chatMsgs$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MessageWithPartnerWithReactions messageWithPartnerWithReactions, ab.e<? super MessageWithPartnerWithReactions> eVar) {
        return ((ChatViewModel$chatMsgs$2$1) create(messageWithPartnerWithReactions, eVar)).invokeSuspend(k0.f43947a);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:48:0x014c  */
    /* JADX WARN: Code duplicated, block: B:51:0x016f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0181  */
    /* JADX WARN: Code duplicated, block: B:98:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01f1, code lost:
    
        if (r3 == r1) goto L60;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instruction units count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
