package cu.todus.android.repositories;

import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.xmpp.XMPPDataSource;
import cu.todus.android.xmpp.managers.UrlManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.repositories.MainRepository$uploadDataSource$1", f = "MainRepository.kt", l = {182}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "roomId", "", "type", "", "size", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class MainRepository$uploadDataSource$1 extends cb.m implements lb.o {
    /* synthetic */ int I$0;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRepository$uploadDataSource$1(MainRepository mainRepository, ab.e<? super MainRepository$uploadDataSource$1> eVar) {
        super(4, eVar);
        this.this$0 = mainRepository;
    }

    @Override // lb.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).longValue(), (ab.e<? super FileResponse.FileResult>) obj4);
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        UrlManager urlManager;
        String str = (String) this.L$0;
        int i10 = this.I$0;
        long j10 = this.J$0;
        Object objG = bb.b.g();
        int i11 = this.label;
        if (i11 == 0) {
            ua.v.b(obj);
            XMPPDataSource xMPPDataSource = this.this$0.mXMPPDataSource;
            if (xMPPDataSource == null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                return null;
            }
            this.L$0 = cb.l.a(str);
            this.I$0 = i10;
            this.J$0 = j10;
            this.label = 1;
            obj = UrlManager.getPutUrl$default(urlManager, str, i10, j10, false, this, 8, null);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return (FileResponse.FileResult) obj;
    }

    public final Object invoke(String str, int i10, long j10, ab.e<? super FileResponse.FileResult> eVar) {
        MainRepository$uploadDataSource$1 mainRepository$uploadDataSource$1 = new MainRepository$uploadDataSource$1(this.this$0, eVar);
        mainRepository$uploadDataSource$1.L$0 = str;
        mainRepository$uploadDataSource$1.I$0 = i10;
        mainRepository$uploadDataSource$1.J$0 = j10;
        return mainRepository$uploadDataSource$1.invokeSuspend(ua.k0.f43947a);
    }
}
