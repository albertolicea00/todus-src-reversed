package cu.todus.android.xmpp.managers;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.packet.Stanza;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.managers.IMManager$stanzaListener$1$1", f = "IMManager.kt", l = {59}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class IMManager$stanzaListener$1$1 extends cb.m implements Function2 {
    final /* synthetic */ Stanza $stanza;
    int label;
    final /* synthetic */ IMManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMManager$stanzaListener$1$1(IMManager iMManager, Stanza stanza, ab.e<? super IMManager$stanzaListener$1$1> eVar) {
        super(2, eVar);
        this.this$0 = iMManager;
        this.$stanza = stanza;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new IMManager$stanzaListener$1$1(this.this$0, this.$stanza, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            re.g gVar = this.this$0.stanzaQueue;
            Stanza stanza = this.$stanza;
            kotlin.jvm.internal.y.f(stanza);
            this.label = 1;
            if (gVar.send(stanza, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((IMManager$stanzaListener$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
