package cu.todus.android.repositories;

import cu.todus.android.xmpp.XMPPDataSource;
import cu.todus.android.xmpp.managers.UrlManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$downloadDataSource$1", f = "MainRepository.kt", l = {170}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "url"}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class MainRepository$downloadDataSource$1 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$downloadDataSource$1(MainRepository mainRepository, ab.e<? super MainRepository$downloadDataSource$1> eVar) {
        super(2, eVar);
        this.this$0 = mainRepository;
    }

    @Override // cb.a
    public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
        MainRepository$downloadDataSource$1 mainRepository$downloadDataSource$1 = new MainRepository$downloadDataSource$1(this.this$0, eVar);
        mainRepository$downloadDataSource$1.L$0 = obj;
        return mainRepository$downloadDataSource$1;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        UrlManager urlManager;
        String str = (String) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            XMPPDataSource xMPPDataSource = this.this$0.mXMPPDataSource;
            if (xMPPDataSource == null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                return null;
            }
            this.L$0 = cb.l.a(str);
            this.label = 1;
            obj = urlManager.getUrl(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return (String) obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super String> eVar) {
        return ((MainRepository$downloadDataSource$1) create(str, eVar)).invokeSuspend(ua.k0.f43947a);
    }
}
