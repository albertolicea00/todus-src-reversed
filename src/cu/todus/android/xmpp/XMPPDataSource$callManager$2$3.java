package cu.todus.android.xmpp;

import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.xmpp.managers.RosterManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.XMPPDataSource$callManager$2$3", f = "XMPPDataSource.kt", l = {329}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcu/todus/android/data/db/entity/toDus/User;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
public final class XMPPDataSource$callManager$2$3 extends cb.m implements Function2 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ XMPPDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XMPPDataSource$callManager$2$3(XMPPDataSource xMPPDataSource, ab.e<? super XMPPDataSource$callManager$2$3> eVar) {
        super(2, eVar);
        this.this$0 = xMPPDataSource;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        XMPPDataSource$callManager$2$3 xMPPDataSource$callManager$2$3 = new XMPPDataSource$callManager$2$3(this.this$0, eVar);
        xMPPDataSource$callManager$2$3.L$0 = obj;
        return xMPPDataSource$callManager$2$3;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        Object objG = bb.b.g();
        int i10 = this.label;
        if (i10 == 0) {
            ua.v.b(obj);
            RosterManager rosterManager = this.this$0.getRosterManager();
            if (rosterManager == null) {
                return null;
            }
            this.L$0 = cb.l.a(str);
            this.label = 1;
            obj = rosterManager.reloadUser(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        }
        return (User) obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, ab.e<? super User> eVar) {
        return ((XMPPDataSource$callManager$2$3) create(str, eVar)).invokeSuspend(k0.f43947a);
    }
}
