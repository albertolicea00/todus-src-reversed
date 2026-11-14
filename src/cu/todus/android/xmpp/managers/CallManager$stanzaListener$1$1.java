package cu.todus.android.xmpp.managers;

import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.xmpp.iq.call.CallStatusIQ;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smack.packet.Stanza;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.managers.CallManager$stanzaListener$1$1", f = "CallManager.kt", l = {98}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class CallManager$stanzaListener$1$1 extends cb.m implements Function1 {
    final /* synthetic */ Stanza $packet;
    Object L$0;
    int label;
    final /* synthetic */ CallManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallManager$stanzaListener$1$1(Stanza stanza, CallManager callManager, ab.e<? super CallManager$stanzaListener$1$1> eVar) {
        super(1, eVar);
        this.$packet = stanza;
        this.this$0 = callManager;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new CallManager$stanzaListener$1$1(this.$packet, this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((CallManager$stanzaListener$1$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008a A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:6:0x0013, B:13:0x0026, B:15:0x0037, B:17:0x0056, B:19:0x005a, B:24:0x0064, B:26:0x0070, B:27:0x0078, B:30:0x00ab, B:29:0x008a), top: B:36:0x000b }] */
    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        CallContent callContent;
        String msgId;
        String str = "";
        Object objG = bb.b.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ua.v.b(obj);
                CallContent callContent2 = !kotlin.jvm.internal.y.d(((CallStatusIQ) this.$packet).getContent(), "") ? (CallContent) this.this$0.gson.j(Base64Util.decodedMessage$default(Base64Util.INSTANCE, ((CallStatusIQ) this.$packet).getContent(), 0, 2, null), CallContent.class) : null;
                CallManager callManager = this.this$0;
                if (callContent2 != null && (msgId = callContent2.getMsgId()) != null) {
                    str = msgId;
                }
                if (callContent2 == null) {
                    callContent = new CallContent(((CallStatusIQ) this.$packet).getFromUser(), "", ((CallStatusIQ) this.$packet).getStatus(), null, 0L, 0L, 56, null);
                } else {
                    String strDecodedMessage$default = Base64Util.decodedMessage$default(Base64Util.INSTANCE, callContent2.getState(), 0, 2, null);
                    if (strDecodedMessage$default == null) {
                        strDecodedMessage$default = ((CallStatusIQ) this.$packet).getStatus();
                    }
                    callContent = CallContent.rebuild$default(callContent2, null, null, strDecodedMessage$default, null, 0L, 0L, 59, null);
                    if (callContent == null) {
                        callContent = new CallContent(((CallStatusIQ) this.$packet).getFromUser(), "", ((CallStatusIQ) this.$packet).getStatus(), null, 0L, 0L, 56, null);
                    }
                }
                this.L$0 = cb.l.a(callContent2);
                this.label = 1;
                if (callManager.onCallMessage(str, callContent, false, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }
}
