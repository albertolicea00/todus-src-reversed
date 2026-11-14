package cu.todus.android.connection;

import ab.e;
import bb.b;
import cb.f;
import cb.m;
import j$.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import te.a0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.connection.NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1", f = "NetworkChangeMonitor.kt", l = {114}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1 extends m implements Function2 {
    final /* synthetic */ NetworkChangeMonitor.ConnectionType $connectionType;
    final /* synthetic */ NetworkChangeMonitor.NetworkType $newType;
    int label;
    final /* synthetic */ NetworkChangeMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1(NetworkChangeMonitor.NetworkType networkType, NetworkChangeMonitor.ConnectionType connectionType, NetworkChangeMonitor networkChangeMonitor, e<? super NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1> eVar) {
        super(2, eVar);
        this.$newType = networkType;
        this.$connectionType = connectionType;
        this.this$0 = networkChangeMonitor;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        return new NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1(this.$newType, this.$connectionType, this.this$0, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            NetworkChangeMonitor.NetworkType networkType = this.$newType;
            NetworkChangeMonitor.ConnectionType connectionType = this.$connectionType;
            Objects.toString(networkType);
            Objects.toString(connectionType);
            a0 a0Var = this.this$0._networkChangeFlow;
            NetworkChangeMonitor.NetworkChangeEvent networkChangeEvent = new NetworkChangeMonitor.NetworkChangeEvent(this.$newType, true, this.$connectionType, 0L, 8, null);
            this.label = 1;
            if (a0Var.emit(networkChangeEvent, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
        }
        return k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((NetworkChangeMonitor$NetworkCallbackImpl$onAvailable$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
