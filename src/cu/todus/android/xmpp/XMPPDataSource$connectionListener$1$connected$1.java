package cu.todus.android.xmpp;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smack.XMPPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$connectionListener$1$connected$1", f = "XMPPDataSource.kt", l = {1394}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class XMPPDataSource$connectionListener$1$connected$1 extends cb.m implements Function1 {
    final /* synthetic */ XMPPConnection $connection;
    int label;
    final /* synthetic */ XMPPDataSource$connectionListener$1 this$0;
    final /* synthetic */ XMPPDataSource this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XMPPDataSource$connectionListener$1$connected$1(XMPPConnection xMPPConnection, XMPPDataSource$connectionListener$1 xMPPDataSource$connectionListener$1, XMPPDataSource xMPPDataSource, ab.e<? super XMPPDataSource$connectionListener$1$connected$1> eVar) {
        super(1, eVar);
        this.$connection = xMPPConnection;
        this.this$0 = xMPPDataSource$connectionListener$1;
        this.this$1 = xMPPDataSource;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new XMPPDataSource$connectionListener$1$connected$1(this.$connection, this.this$0, this.this$1, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((XMPPDataSource$connectionListener$1$connected$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            XMPPConnection xMPPConnection = this.$connection;
            if (xMPPConnection == null || xMPPConnection.isAuthenticated()) {
                Log.w(this.this$0.TAG, "⚠️ Conexión ya autenticada o nula, reiniciando actividad");
                this.this$1.getRestartActivity().invoke();
            } else {
                String unused = this.this$0.TAG;
                XMPPDataSource xMPPDataSource = this.this$1;
                XMPPConnection xMPPConnection2 = this.$connection;
                this.label = 1;
                if (xMPPDataSource.initConnectWithIM(xMPPConnection2, this) == objG) {
                    return objG;
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return k0.f43947a;
    }
}
