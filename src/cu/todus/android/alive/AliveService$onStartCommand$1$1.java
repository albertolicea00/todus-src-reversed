package cu.todus.android.alive;

import ab.e;
import cb.f;
import cb.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.x0;
import pe.m0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@f(c = "cu.todus.android.alive.AliveService$onStartCommand$1$1", f = "AliveService.kt", l = {98}, m = "invokeSuspend", v = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
public final class AliveService$onStartCommand$1$1 extends m implements Function2 {
    final /* synthetic */ x0 $mins;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AliveService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AliveService$onStartCommand$1$1(x0 x0Var, AliveService aliveService, e<? super AliveService$onStartCommand$1$1> eVar) {
        super(2, eVar);
        this.$mins = x0Var;
        this.this$0 = aliveService;
    }

    @Override // cb.a
    public final e<k0> create(Object obj, e<?> eVar) {
        AliveService$onStartCommand$1$1 aliveService$onStartCommand$1$1 = new AliveService$onStartCommand$1$1(this.$mins, this.this$0, eVar);
        aliveService$onStartCommand$1$1.L$0 = obj;
        return aliveService$onStartCommand$1$1;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    /* JADX WARN: Code duplicated, block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    /* JADX WARN: Code duplicated, block: B:17:0x0060  */
    /* JADX WARN: Code duplicated, block: B:20:0x006e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    /* JADX WARN: Code duplicated, block: B:23:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004d -> B:13:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x006e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // cb.a
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            pe.m0 r0 = (pe.m0) r0
            java.lang.Object r1 = bb.b.g()
            int r2 = r14.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L28
            if (r2 != r4) goto L20
            int r2 = r14.I$1
            int r5 = r14.I$0
            java.lang.Object r6 = r14.L$2
            cu.todus.android.alive.AliveService r6 = (cu.todus.android.alive.AliveService) r6
            java.lang.Object r7 = r14.L$1
            kotlin.jvm.internal.x0 r7 = (kotlin.jvm.internal.x0) r7
            ua.v.b(r15)
            goto L50
        L20:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L28:
            ua.v.b(r15)
            kotlin.jvm.internal.x0 r15 = r14.$mins
            cu.todus.android.alive.AliveService r2 = r14.this$0
            r5 = 2147483647(0x7fffffff, float:NaN)
            r7 = r15
            r6 = r2
            r2 = r3
        L35:
            if (r2 >= r5) goto L8e
            r14.L$0 = r0
            r14.L$1 = r7
            r14.L$2 = r6
            r14.I$0 = r5
            r14.I$1 = r2
            r14.I$2 = r2
            r14.I$3 = r3
            r14.label = r4
            r8 = 100
            java.lang.Object r15 = pe.w0.b(r8, r14)
            if (r15 != r1) goto L50
            return r1
        L50:
            long r8 = r7.f36633c
            r10 = 0
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 <= 0) goto L8c
            cu.todus.android.alive.AliveUtility r15 = cu.todus.android.alive.AliveUtility.INSTANCE
            boolean r8 = r15.appIsOnActivity(r6)
            if (r8 != 0) goto L68
            long r8 = r7.f36633c
            r12 = 100
            long r12 = (long) r12
            long r8 = r8 - r12
            r7.f36633c = r8
        L68:
            long r8 = r7.f36633c
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 > 0) goto L8c
            r6.stopSelf()
            boolean r15 = r15.appIsOnActivity(r6)
            if (r15 == 0) goto L80
            ab.i r15 = r0.getCoroutineContext()
            r8 = 0
            pe.d2.e(r15, r8, r4, r8)
            goto L8c
        L80:
            r15 = -1
            java.lang.System.exit(r15)
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "System.exit returned normally, while it was supposed to halt JVM."
            r15.<init>(r0)
            throw r15
        L8c:
            int r2 = r2 + r4
            goto L35
        L8e:
            ua.k0 r15 = ua.k0.f43947a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.alive.AliveService$onStartCommand$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m0 m0Var, e<? super k0> eVar) {
        return ((AliveService$onStartCommand$1$1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
    }
}
