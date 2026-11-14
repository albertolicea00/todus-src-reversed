package cu.todus.android.uiCompose.main.screen.nearPeople;

import cu.todus.android.data.db.pojo.NearPartner;
import cu.todus.android.repositories.MainRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.nearPeople.NearPeopleViewModel$nearPeople$1$pagingSource$1", f = "NearPeopleViewModel.kt", l = {44}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcu/todus/android/data/db/pojo/NearPartner;", "offset", "", "limit"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class NearPeopleViewModel$nearPeople$1$pagingSource$1 extends cb.m implements Function3 {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    int label;
    final /* synthetic */ NearPeopleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearPeopleViewModel$nearPeople$1$pagingSource$1(NearPeopleViewModel nearPeopleViewModel, ab.e<? super NearPeopleViewModel$nearPeople$1$pagingSource$1> eVar) {
        super(3, eVar);
        this.this$0 = nearPeopleViewModel;
    }

    public final Object invoke(int i10, int i11, ab.e<? super List<NearPartner>> eVar) {
        NearPeopleViewModel$nearPeople$1$pagingSource$1 nearPeopleViewModel$nearPeople$1$pagingSource$1 = new NearPeopleViewModel$nearPeople$1$pagingSource$1(this.this$0, eVar);
        nearPeopleViewModel$nearPeople$1$pagingSource$1.I$0 = i10;
        nearPeopleViewModel$nearPeople$1$pagingSource$1.I$1 = i11;
        return nearPeopleViewModel$nearPeople$1$pagingSource$1.invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.I$0;
        int i11 = this.I$1;
        Object objG = bb.b.g();
        int i12 = this.label;
        if (i12 != 0) {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            return obj;
        }
        v.b(obj);
        MainRepository mainRepository = this.this$0.mainRepository;
        this.I$0 = i10;
        this.I$1 = i11;
        this.label = 1;
        Object nearPage = mainRepository.getNearPage(i10, i11, this);
        return nearPage == objG ? objG : nearPage;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<NearPartner>>) obj3);
    }
}
