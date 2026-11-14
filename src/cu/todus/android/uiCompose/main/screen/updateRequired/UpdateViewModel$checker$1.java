package cu.todus.android.uiCompose.main.screen.updateRequired;

import cb.m;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.xmpp.iq.version.GetUpdateInfoIQ;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.uiCompose.main.screen.updateRequired.UpdateViewModel$checker$1", f = "UpdateViewModel.kt", l = {21}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class UpdateViewModel$checker$1 extends m implements Function1 {
    int label;
    final /* synthetic */ UpdateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateViewModel$checker$1(UpdateViewModel updateViewModel, ab.e<? super UpdateViewModel$checker$1> eVar) {
        super(1, eVar);
        this.this$0 = updateViewModel;
    }

    @Override // cb.a
    public final ab.e<k0> create(ab.e<?> eVar) {
        return new UpdateViewModel$checker$1(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(ab.e<? super GetUpdateInfoIQ> eVar) {
        return ((UpdateViewModel$checker$1) create(eVar)).invokeSuspend(k0.f43947a);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            return obj;
        }
        v.b(obj);
        MainRepository mainRepository = this.this$0.mainRepository;
        this.label = 1;
        Object objRequestUpdateInfo = mainRepository.requestUpdateInfo(this);
        return objRequestUpdateInfo == objG ? objG : objRequestUpdateInfo;
    }
}
