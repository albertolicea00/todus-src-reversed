package cu.todus.android;

import cu.todus.android.repositories.AuthRepository;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.ToDusApp$initializeCompleteApp$mainRepository$1$4", f = "ToDusApp.kt", l = {396}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class ToDusApp$initializeCompleteApp$mainRepository$1$4 extends cb.m implements Function1 {
    final /* synthetic */ AuthRepository $authRepository;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToDusApp$initializeCompleteApp$mainRepository$1$4(AuthRepository authRepository, ab.e<? super ToDusApp$initializeCompleteApp$mainRepository$1$4> eVar) {
        super(1, eVar);
        this.$authRepository = authRepository;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new ToDusApp$initializeCompleteApp$mainRepository$1$4(this.$authRepository, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super Pair<Integer, String>> eVar) {
        return ((ToDusApp$initializeCompleteApp$mainRepository$1$4) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return obj;
        }
        ua.v.b(obj);
        AuthRepository authRepository = this.$authRepository;
        this.label = 1;
        Object objNewTokenLive = authRepository.newTokenLive(this);
        return objNewTokenLive == objG ? objG : objNewTokenLive;
    }
}
