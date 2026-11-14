package cu.todus.android.repositories;

import androidx.compose.runtime.ComposerKt;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.db.dao.toDus.StatusDao;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$uploadStatusDataSource$3", f = "MainRepository.kt", l = {ComposerKt.reuseKey}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/Status;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class MainRepository$uploadStatusDataSource$3 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$uploadStatusDataSource$3(MainRepository mainRepository, ab.e<? super MainRepository$uploadStatusDataSource$3> eVar) {
        super(2, eVar);
        this.this$0 = mainRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        MainRepository$uploadStatusDataSource$3 mainRepository$uploadStatusDataSource$3 = new MainRepository$uploadStatusDataSource$3(this.this$0, eVar);
        mainRepository$uploadStatusDataSource$3.L$0 = obj;
        return mainRepository$uploadStatusDataSource$3;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
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
        StatusDao statusDao = this.this$0.statusDao;
        this.L$0 = cb.l.a(str);
        this.label = 1;
        Object statusById = statusDao.getStatusById(str, this);
        return statusById == objG ? objG : statusById;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super Status> eVar) {
        return ((MainRepository$uploadStatusDataSource$3) create(str, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
