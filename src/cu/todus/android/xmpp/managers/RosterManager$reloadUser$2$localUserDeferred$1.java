package cu.todus.android.xmpp.managers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import cu.todus.android.data.db.entity.toDus.User;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$reloadUser$2$localUserDeferred$1", f = "RosterManager.kt", l = {TypedValues.PositionType.TYPE_CURVE_FIT, TypedValues.PositionType.TYPE_CURVE_FIT}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lcu/todus/android/data/db/entity/toDus/User;", "<anonymous>", "(Lpe/m0;)Lcu/todus/android/data/db/entity/toDus/User;"}, k = 3, mv = {2, 3, 0})
public final class RosterManager$reloadUser$2$localUserDeferred$1 extends cb.m implements Function2 {
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ RosterManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterManager$reloadUser$2$localUserDeferred$1(RosterManager rosterManager, String str, ab.e<? super RosterManager$reloadUser$2$localUserDeferred$1> eVar) {
        super(2, eVar);
        this.this$0 = rosterManager;
        this.$uid = str;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        return new RosterManager$reloadUser$2$localUserDeferred$1(this.this$0, this.$uid, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r5 == r0) goto L17;
     */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = bb.b.g()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            ua.v.b(r5)
            goto L47
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            ua.v.b(r5)
            goto L32
        L1e:
            ua.v.b(r5)
            cu.todus.android.xmpp.managers.RosterManager r5 = r4.this$0
            cu.todus.android.db.dao.toDus.UserDao r5 = cu.todus.android.xmpp.managers.RosterManager.access$getUserDao$p(r5)
            java.lang.String r1 = r4.$uid
            r4.label = r3
            java.lang.Object r5 = r5.getById(r1, r4)
            if (r5 != r0) goto L32
            goto L46
        L32:
            cu.todus.android.data.db.entity.toDus.User r5 = (cu.todus.android.data.db.entity.toDus.User) r5
            if (r5 != 0) goto L49
            cu.todus.android.xmpp.managers.RosterManager r5 = r4.this$0
            cu.todus.android.db.dao.toDus.UserDao r5 = cu.todus.android.xmpp.managers.RosterManager.access$getUserDao$p(r5)
            java.lang.String r1 = r4.$uid
            r4.label = r2
            java.lang.Object r5 = r5.getByToDusId(r1, r4)
            if (r5 != r0) goto L47
        L46:
            return r0
        L47:
            cu.todus.android.data.db.entity.toDus.User r5 = (cu.todus.android.data.db.entity.toDus.User) r5
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.RosterManager$reloadUser$2$localUserDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super User> eVar) {
        return ((RosterManager$reloadUser$2$localUserDeferred$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
