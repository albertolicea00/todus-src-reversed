package cu.todus.android.xmpp;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$connectionListener$1$authenticated$1", f = "XMPPDataSource.kt", l = {1473}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class XMPPDataSource$connectionListener$1$authenticated$1 extends cb.m implements Function1 {
    int label;
    final /* synthetic */ XMPPDataSource this$0;
    final /* synthetic */ XMPPDataSource$connectionListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XMPPDataSource$connectionListener$1$authenticated$1(XMPPDataSource xMPPDataSource, XMPPDataSource$connectionListener$1 xMPPDataSource$connectionListener$1, ab.e<? super XMPPDataSource$connectionListener$1$authenticated$1> eVar) {
        super(1, eVar);
        this.this$0 = xMPPDataSource;
        this.this$1 = xMPPDataSource$connectionListener$1;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new XMPPDataSource$connectionListener$1$authenticated$1(this.this$0, this.this$1, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((XMPPDataSource$connectionListener$1$authenticated$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ua.v.b(obj);
                try {
                    this.this$0.initPingManager();
                    String unused = this.this$1.TAG;
                } catch (Exception e10) {
                    Log.e(this.this$1.TAG, "❌ Error inicializando PingManager: " + e10.getMessage(), e10);
                }
                String unused2 = this.this$1.TAG;
                this.this$0.setConnectionState(ConnectionState.CONNECTED);
                String unused3 = this.this$1.TAG;
                XMPPDataSource xMPPDataSource = this.this$0;
                this.label = 1;
                if (xMPPDataSource.initListeners(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            String unused4 = this.this$1.TAG;
        } catch (Exception e11) {
            Log.e(this.this$1.TAG, "❌ Error durante inicialización de managers: " + e11.getMessage(), e11);
        }
        String unused5 = this.this$1.TAG;
        return k0.f43947a;
    }
}
