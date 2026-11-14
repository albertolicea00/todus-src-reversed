package cu.todus.android.xmpp.managers;

import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$reloadUser$2$serverUserDeferred$1", f = "RosterManager.kt", l = {509}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/db/entity/toDus/User;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/db/entity/toDus/User;"}, k = 3, mv = {2, 3, 0})
public final class RosterManager$reloadUser$2$serverUserDeferred$1 extends cb.m implements Function2 {
    final /* synthetic */ String $cleanUid;
    int label;
    final /* synthetic */ RosterManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterManager$reloadUser$2$serverUserDeferred$1(RosterManager rosterManager, String str, ab.e<? super RosterManager$reloadUser$2$serverUserDeferred$1> eVar) {
        super(2, eVar);
        this.this$0 = rosterManager;
        this.$cleanUid = str;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new RosterManager$reloadUser$2$serverUserDeferred$1(this.this$0, this.$cleanUid, eVar);
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
        RosterManager rosterManager = this.this$0;
        String str = this.$cleanUid;
        this.label = 1;
        Object userInfo = rosterManager.getUserInfo(str, this);
        return userInfo == objG ? objG : userInfo;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super User> eVar) {
        return ((RosterManager$reloadUser$2$serverUserDeferred$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
