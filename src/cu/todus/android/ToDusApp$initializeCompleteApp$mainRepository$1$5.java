package cu.todus.android;

import cu.todus.android.repositories.AuthRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.ToDusApp$initializeCompleteApp$mainRepository$1$5", f = "ToDusApp.kt", l = {399}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
public final class ToDusApp$initializeCompleteApp$mainRepository$1$5 extends cb.m implements Function1 {
    final /* synthetic */ AuthRepository $authRepository;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToDusApp$initializeCompleteApp$mainRepository$1$5(AuthRepository authRepository, ab.e<? super ToDusApp$initializeCompleteApp$mainRepository$1$5> eVar) {
        super(1, eVar);
        this.$authRepository = authRepository;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new ToDusApp$initializeCompleteApp$mainRepository$1$5(this.$authRepository, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super k0> eVar) {
        return ((ToDusApp$initializeCompleteApp$mainRepository$1$5) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            AuthRepository authRepository = this.$authRepository;
            this.label = 1;
            if (authRepository.retryVerify(this) == objG) {
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
}
