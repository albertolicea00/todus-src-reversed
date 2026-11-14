package cu.todus.android.xmpp.managers;

import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.db.dao.toDus.UserDao;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.xmpp.managers.RosterManager$loadUsersInfoParallel$2$1$1", f = "RosterManager.kt", l = {618, 576, 576}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lpe/m0;", "Lua/u;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)Lua/u;"}, k = 3, mv = {2, 3, 0})
public final class RosterManager$loadUsersInfoParallel$2$1$1 extends cb.m implements Function2 {
    final /* synthetic */ List<String> $batch;
    final /* synthetic */ af.h $semaphore;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ RosterManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RosterManager$loadUsersInfoParallel$2$1$1(af.h hVar, RosterManager rosterManager, List<String> list, ab.e<? super RosterManager$loadUsersInfoParallel$2$1$1> eVar) {
        super(2, eVar);
        this.$semaphore = hVar;
        this.this$0 = rosterManager;
        this.$batch = list;
    }

    @Override // cb.a
    public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
        RosterManager$loadUsersInfoParallel$2$1$1 rosterManager$loadUsersInfoParallel$2$1$1 = new RosterManager$loadUsersInfoParallel$2$1$1(this.$semaphore, this.this$0, this.$batch, eVar);
        rosterManager$loadUsersInfoParallel$2$1$1.L$0 = obj;
        return rosterManager$loadUsersInfoParallel$2$1$1;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ab A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:15:0x0044, B:28:0x00a7, B:30:0x00ab), top: B:51:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d8  */
    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        af.h hVar;
        RosterManager rosterManager;
        int i10;
        List<String> list;
        af.h hVar2;
        Throwable th2;
        af.h hVar3;
        m0 m0Var;
        int i11;
        int i12;
        int i13;
        List<User> list2;
        k0 k0Var;
        UserDao userDao;
        Object objB;
        m0 m0Var2 = (m0) this.L$0;
        Object objG = bb.b.g();
        int i14 = this.label;
        try {
            if (i14 == 0) {
                ua.v.b(obj);
                hVar = this.$semaphore;
                RosterManager rosterManager2 = this.this$0;
                List<String> list3 = this.$batch;
                this.L$0 = m0Var2;
                this.L$1 = hVar;
                this.L$2 = rosterManager2;
                this.L$3 = list3;
                this.I$0 = 0;
                this.label = 1;
                if (hVar.b(this) != objG) {
                    rosterManager = rosterManager2;
                    i10 = 0;
                    list = list3;
                }
                return objG;
            }
            if (i14 != 1) {
                if (i14 != 2) {
                    if (i14 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hVar2 = (af.h) this.L$1;
                    try {
                        ua.v.b(obj);
                        k0Var = k0.f43947a;
                        objB = ua.u.b(k0Var);
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            ua.u.a aVar = ua.u.f43963f;
                            objB = ua.u.b(ua.v.a(th2));
                        } finally {
                            hVar2.release();
                        }
                    }
                    return ua.u.a(objB);
                }
                i12 = this.I$2;
                i13 = this.I$1;
                i11 = this.I$0;
                m0Var = (m0) this.L$3;
                rosterManager = (RosterManager) this.L$2;
                hVar3 = (af.h) this.L$1;
                try {
                    ua.v.b(obj);
                    list2 = (List) obj;
                    if (list2 != null) {
                        userDao = rosterManager.userDao;
                        this.L$0 = cb.l.a(m0Var2);
                        this.L$1 = hVar3;
                        this.L$2 = cb.l.a(m0Var);
                        this.L$3 = cb.l.a(list2);
                        this.I$0 = i11;
                        this.I$1 = i13;
                        this.I$2 = i12;
                        this.I$3 = 0;
                        this.label = 3;
                        if (userDao.upsert(list2, this) != objG) {
                            hVar2 = hVar3;
                            k0Var = k0.f43947a;
                        }
                        return objG;
                    }
                    k0Var = null;
                    hVar2 = hVar3;
                    objB = ua.u.b(k0Var);
                } catch (Throwable th4) {
                    th2 = th4;
                    hVar2 = hVar3;
                    ua.u.a aVar2 = ua.u.f43963f;
                    objB = ua.u.b(ua.v.a(th2));
                }
                return ua.u.a(objB);
            }
            i10 = this.I$0;
            list = (List) this.L$3;
            RosterManager rosterManager3 = (RosterManager) this.L$2;
            af.h hVar4 = (af.h) this.L$1;
            ua.v.b(obj);
            hVar = hVar4;
            rosterManager = rosterManager3;
            ua.u.a aVar3 = ua.u.f43963f;
            this.L$0 = cb.l.a(m0Var2);
            this.L$1 = hVar;
            this.L$2 = rosterManager;
            this.L$3 = cb.l.a(m0Var2);
            this.I$0 = i10;
            this.I$1 = 0;
            this.I$2 = 0;
            this.label = 2;
            Object usersInfo = rosterManager.getUsersInfo(list, this);
            if (usersInfo != objG) {
                hVar3 = hVar;
                m0Var = m0Var2;
                i11 = i10;
                obj = usersInfo;
                i12 = 0;
                i13 = 0;
                list2 = (List) obj;
                if (list2 != null) {
                    userDao = rosterManager.userDao;
                    this.L$0 = cb.l.a(m0Var2);
                    this.L$1 = hVar3;
                    this.L$2 = cb.l.a(m0Var);
                    this.L$3 = cb.l.a(list2);
                    this.I$0 = i11;
                    this.I$1 = i13;
                    this.I$2 = i12;
                    this.I$3 = 0;
                    this.label = 3;
                    if (userDao.upsert(list2, this) != objG) {
                        hVar2 = hVar3;
                        k0Var = k0.f43947a;
                    }
                } else {
                    k0Var = null;
                    hVar2 = hVar3;
                }
                objB = ua.u.b(k0Var);
                return ua.u.a(objB);
            }
            return objG;
        } catch (Throwable th5) {
            hVar2 = hVar;
            th2 = th5;
            ua.u.a aVar4 = ua.u.f43963f;
            objB = ua.u.b(ua.v.a(th2));
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, ab.e<? super ua.u> eVar) {
        return ((RosterManager$loadUsersInfoParallel$2$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
