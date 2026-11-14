package cu.todus.android.uiCompose.call;

import cu.todus.android.repositories.MainRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import pe.m0;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.call.CallActivity$onCreate$1$1$1$3$1", f = "CallActivity.kt", l = {100}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class CallActivity$onCreate$1$1$1$3$1 extends cb.m implements Function2 {
    final /* synthetic */ CallParams $callParams;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActivity$onCreate$1$1$1$3$1(CallParams callParams, ab.e<? super CallActivity$onCreate$1$1$1$3$1> eVar) {
        super(2, eVar);
        this.$callParams = callParams;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new CallActivity$onCreate$1$1$1$3$1(this.$callParams, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        MainRepository instanceOrNull;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            v.b(obj);
            if (!y.d(this.$callParams.getPickId(), "") && (instanceOrNull = MainRepository.INSTANCE.getInstanceOrNull()) != null) {
                String pickId = this.$callParams.getPickId();
                lb.a aVar = new lb.a() { // from class: cu.todus.android.uiCompose.call.i
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.call.j
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.call.k
                    @Override // lb.a
                    public final Object invoke() {
                        return k0.f43947a;
                    }
                };
                this.label = 1;
                if (instanceOrNull.acceptCallProcess(pickId, aVar, aVar2, aVar3, this) == objG) {
                    return objG;
                }
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
    public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
        return ((CallActivity$onCreate$1$1$1$3$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
