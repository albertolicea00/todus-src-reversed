package cu.todus.android.repositories;

import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.db.dao.toDus.StatusDao;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$uploadStatusDataSource$2", f = "MainRepository.kt", l = {204}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/data/db/entity/toDus/Status;", "it", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/data/db/entity/toDus/Status;)V"}, k = 3, mv = {2, 3, 0})
public final class MainRepository$uploadStatusDataSource$2 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$uploadStatusDataSource$2(MainRepository mainRepository, ab.e<? super MainRepository$uploadStatusDataSource$2> eVar) {
        super(2, eVar);
        this.this$0 = mainRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        MainRepository$uploadStatusDataSource$2 mainRepository$uploadStatusDataSource$2 = new MainRepository$uploadStatusDataSource$2(this.this$0, eVar);
        mainRepository$uploadStatusDataSource$2.L$0 = obj;
        return mainRepository$uploadStatusDataSource$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Status status, ab.e<? super ua.k0> eVar) {
        return ((MainRepository$uploadStatusDataSource$2) create(status, eVar)).invokeSuspend(ua.k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Status status = (Status) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            StatusDao statusDao = this.this$0.statusDao;
            this.L$0 = cb.l.a(status);
            this.label = 1;
            if (statusDao.update(status, this) == objG) {
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
}
