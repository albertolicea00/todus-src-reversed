package cu.todus.android.xmpp.dispatchers;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb.b;
import cb.d;
import cb.f;
import cb.m;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.xmpp.StanzaListenerManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.k;
import pe.m0;
import pe.n0;
import pe.o0;
import te.h;
import te.i;
import te.j;
import te.u;
import ua.k0;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcu/todus/android/xmpp/dispatchers/OwnerMarkersManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "<init>", "(Llb/a;Llb/a;)V", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "markerAction", "Lua/k0;", "send", "(Lcu/todus/android/data/db/entity/toDus/MarkerAction;Lab/e;)Ljava/lang/Object;", "startManager", "()V", "stopManager", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "markerActionDao", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "Lpe/m0;", "job", "Lpe/m0;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OwnerMarkersManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private m0 job;
    private a2 listener;
    private final lb.a mXMPPConnection;
    private final MarkerActionDao markerActionDao;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.xmpp.dispatchers.OwnerMarkersManager", f = "OwnerMarkersManager.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 56}, m = "send", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerMarkersManager.this.send(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1", f = "OwnerMarkersManager.kt", l = {35}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13861 extends m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$1", f = "OwnerMarkersManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/MarkerAction;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02721 extends m implements Function3 {
            int label;

            public C02721(e<? super C02721> eVar) {
                super(3, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(i iVar, Throwable th2, e<? super k0> eVar) {
                return new C02721(eVar).invokeSuspend(k0.f43947a);
            }
        }

        public C13861(e<? super C13861> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerMarkersManager.this.new C13861(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                h hVarF = j.f(j.g(u.f(OwnerMarkersManager.this.markerActionDao.getMarkerToSend(), 2L, null, 2, null), new C02721(null)));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(OwnerMarkersManager.this);
                this.label = 1;
                if (hVarF.collect(anonymousClass2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((C13861) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass2<T> implements i {
            final /* synthetic */ OwnerMarkersManager this$0;

            public AnonymousClass2(OwnerMarkersManager ownerMarkersManager) {
                this.this$0 = ownerMarkersManager;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
            
                if (r4.send(r8, r0) == r1) goto L24;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.data.db.entity.toDus.MarkerAction r8, ab.e<? super ua.k0> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2$emit$1 r0 = (cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2$emit$1 r0 = new cu.todus.android.xmpp.dispatchers.OwnerMarkersManager$startManager$1$2$emit$1
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = bb.b.g()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L51
                    if (r2 == r4) goto L3c
                    if (r2 != r3) goto L34
                    java.lang.Object r8 = r0.L$1
                    cu.todus.android.data.db.entity.toDus.MarkerAction r8 = (cu.todus.android.data.db.entity.toDus.MarkerAction) r8
                    java.lang.Object r8 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.MarkerAction r8 = (cu.todus.android.data.db.entity.toDus.MarkerAction) r8
                    ua.v.b(r9)
                    goto L8c
                L34:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3c:
                    int r8 = r0.I$0
                    java.lang.Object r2 = r0.L$2
                    cu.todus.android.data.db.entity.toDus.MarkerAction r2 = (cu.todus.android.data.db.entity.toDus.MarkerAction) r2
                    java.lang.Object r4 = r0.L$1
                    cu.todus.android.xmpp.dispatchers.OwnerMarkersManager r4 = (cu.todus.android.xmpp.dispatchers.OwnerMarkersManager) r4
                    java.lang.Object r5 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.MarkerAction r5 = (cu.todus.android.data.db.entity.toDus.MarkerAction) r5
                    ua.v.b(r9)
                    r6 = r2
                    r2 = r8
                    r8 = r6
                    goto L72
                L51:
                    ua.v.b(r9)
                    if (r8 == 0) goto L8c
                    cu.todus.android.xmpp.dispatchers.OwnerMarkersManager r9 = r7.this$0
                    java.lang.Object r2 = cb.l.a(r8)
                    r0.L$0 = r2
                    r0.L$1 = r9
                    r0.L$2 = r8
                    r2 = 0
                    r0.I$0 = r2
                    r0.label = r4
                    r4 = 100
                    java.lang.Object r4 = pe.w0.b(r4, r0)
                    if (r4 != r1) goto L70
                    goto L8b
                L70:
                    r5 = r8
                    r4 = r9
                L72:
                    java.lang.Object r9 = cb.l.a(r5)
                    r0.L$0 = r9
                    java.lang.Object r9 = cb.l.a(r8)
                    r0.L$1 = r9
                    r9 = 0
                    r0.L$2 = r9
                    r0.I$0 = r2
                    r0.label = r3
                    java.lang.Object r8 = cu.todus.android.xmpp.dispatchers.OwnerMarkersManager.access$send(r4, r8, r0)
                    if (r8 != r1) goto L8c
                L8b:
                    return r1
                L8c:
                    ua.k0 r8 = ua.k0.f43947a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager.C13861.AnonymousClass2.emit(cu.todus.android.data.db.entity.toDus.MarkerAction, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit((MarkerAction) obj, (e<? super k0>) eVar);
            }
        }
    }

    public OwnerMarkersManager(lb.a canSend, lb.a mXMPPConnection) {
        y.i(canSend, "canSend");
        y.i(mXMPPConnection, "mXMPPConnection");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.markerActionDao = DatabaseModule.INSTANCE.getInstance().getMarkerActionDao();
        this.job = n0.a(d1.b().plus(e2.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        if (r2 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
    
        if (r11.insertOrReplace(r4, r0) == r1) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object send(cu.todus.android.data.db.entity.toDus.MarkerAction r10, ab.e<? super ua.k0> r11) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerMarkersManager.send(cu.todus.android.data.db.entity.toDus.MarkerAction, ab.e):java.lang.Object");
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.job = m0VarA;
        a2 a2VarD = k.d(m0VarA, null, o0.LAZY, new C13861(null), 1, null);
        this.listener = a2VarD;
        if (a2VarD != null) {
            a2VarD.start();
        }
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        a2 a2Var = this.listener;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
    }
}
