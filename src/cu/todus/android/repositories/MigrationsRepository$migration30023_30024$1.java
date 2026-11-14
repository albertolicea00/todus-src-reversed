package cu.todus.android.repositories;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MigrationsRepository$migration30023_30024$1", f = "MigrationsRepository.kt", l = {42}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "Lua/k0;", "it", "<anonymous>", "(Llb/a;)V"}, k = 3, mv = {2, 3, 0})
public final class MigrationsRepository$migration30023_30024$1 extends cb.m implements Function2 {
    int label;
    final /* synthetic */ MigrationsRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationsRepository$migration30023_30024$1(MigrationsRepository migrationsRepository, ab.e<? super MigrationsRepository$migration30023_30024$1> eVar) {
        super(2, eVar);
        this.this$0 = migrationsRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        return new MigrationsRepository$migration30023_30024$1(this.this$0, eVar);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            MigrationsRepository migrationsRepository = this.this$0;
            this.label = 1;
            if (migrationsRepository.fixRoomTypes(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return ua.k0.f43947a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(lb.a aVar, ab.e<? super ua.k0> eVar) {
        return ((MigrationsRepository$migration30023_30024$1) create(aVar, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
