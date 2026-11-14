package cu.todus.android.xmpp.dispatchers;

import ab.e;
import androidx.compose.runtime.ComposerImplKt;
import androidx.compose.runtime.internal.StabilityInferred;
import bb.b;
import cb.d;
import cb.m;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.xmpp.StatusContent;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.s3.upload.UploadStatusDataSource;
import cu.todus.android.utils.Base64Util;
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
import te.i;
import ua.k0;
import ua.v;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcu/todus/android/xmpp/dispatchers/OwnerStatusManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "uploadStatusDataSource", "<init>", "(Llb/a;Llb/a;Llb/a;Lcu/todus/android/s3/upload/UploadStatusDataSource;)V", "Lcu/todus/android/data/db/entity/toDus/Status;", "status", "Lua/k0;", "send", "(Lcu/todus/android/data/db/entity/toDus/Status;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/StatusContent;", "statusContent", "", "statusId", "sendStatus", "(Lcu/todus/android/data/xmpp/StatusContent;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "deleteStatus", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "startManager", "()V", "stopManager", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "getUploadStatusDataSource", "()Lcu/todus/android/s3/upload/UploadStatusDataSource;", "Lv5/f;", "gson", "Lv5/f;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "Lpe/m0;", "job", "Lpe/m0;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OwnerStatusManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final f gson;
    private m0 job;
    private a2 listener;
    private final lb.a mXMPPConnection;
    private final lb.a owner;
    private final StatusDao statusDao;
    private final UploadStatusDataSource uploadStatusDataSource;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerStatusManager$deleteStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerStatusManager", f = "OwnerStatusManager.kt", l = {ComposerImplKt.nodeKey, 115, 118}, m = "deleteStatus", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerStatusManager.this.deleteStatus(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerStatusManager$sendStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerStatusManager", f = "OwnerStatusManager.kt", l = {ComposerImplKt.nodeKey, 95, 99}, m = "sendStatus", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13931 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13931(e<? super C13931> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerStatusManager.this.sendStatus(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1", f = "OwnerStatusManager.kt", l = {46, 48, 54}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13941 extends m implements Function2 {
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$2", f = "OwnerStatusManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/Status;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends m implements Function3 {
            int label;

            public AnonymousClass2(e<? super AnonymousClass2> eVar) {
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
                return new AnonymousClass2(eVar).invokeSuspend(k0.f43947a);
            }
        }

        public C13941(e<? super C13941> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerStatusManager.this.new C13941(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0079 A[LOOP:0: B:19:0x0073->B:21:0x0079, LOOP_END] */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00bb, code lost:
        
            if (r1.collect(r3, r9) == r0) goto L24;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L26
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r9.L$0
                java.util.List r0 = (java.util.List) r0
                ua.v.b(r10)
                goto Lbe
            L1a:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L22:
                ua.v.b(r10)
                goto L6b
            L26:
                ua.v.b(r10)
                goto L4c
            L2a:
                ua.v.b(r10)
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r10 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                cu.todus.android.db.dao.toDus.StatusDao r10 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.access$getStatusDao$p(r10)
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r1 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                lb.a r1 = r1.getOwner()
                java.lang.Object r1 = r1.invoke()
                cu.todus.android.data.preferences.Owner r1 = (cu.todus.android.data.preferences.Owner) r1
                java.lang.String r1 = r1.getNameWithDomain()
                r9.label = r4
                java.lang.Object r10 = r10.prepareToSendStatusWithError(r1, r9)
                if (r10 != r0) goto L4c
                goto Lbd
            L4c:
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r10 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                cu.todus.android.db.dao.toDus.StatusDao r10 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.access$getStatusDao$p(r10)
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r1 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                lb.a r1 = r1.getOwner()
                java.lang.Object r1 = r1.invoke()
                cu.todus.android.data.preferences.Owner r1 = (cu.todus.android.data.preferences.Owner) r1
                java.lang.String r1 = r1.getNameWithDomain()
                r9.label = r3
                java.lang.Object r10 = r10.getWaitingForUploadStatuses(r1, r9)
                if (r10 != r0) goto L6b
                goto Lbd
            L6b:
                java.util.List r10 = (java.util.List) r10
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r1 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                java.util.Iterator r3 = r10.iterator()
            L73:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L87
                java.lang.Object r4 = r3.next()
                java.lang.String r4 = (java.lang.String) r4
                cu.todus.android.s3.upload.UploadStatusDataSource r5 = r1.getUploadStatusDataSource()
                r5.putStatusInUploadQueue(r4)
                goto L73
            L87:
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r1 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                cu.todus.android.db.dao.toDus.StatusDao r1 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.access$getStatusDao$p(r1)
                te.h r3 = r1.getUnsentStatus()
                r7 = 2
                r8 = 0
                r4 = 2
                r6 = 0
                te.h r1 = te.j.O(r3, r4, r6, r7, r8)
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$2 r3 = new cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$2
                r4 = 0
                r3.<init>(r4)
                te.h r1 = te.j.g(r1, r3)
                te.h r1 = te.j.f(r1)
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3 r3 = new cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3
                cu.todus.android.xmpp.dispatchers.OwnerStatusManager r4 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.this
                r3.<init>(r4)
                java.lang.Object r10 = cb.l.a(r10)
                r9.L$0 = r10
                r9.label = r2
                java.lang.Object r10 = r1.collect(r3, r9)
                if (r10 != r0) goto Lbe
            Lbd:
                return r0
            Lbe:
                ua.k0 r10 = ua.k0.f43947a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerStatusManager.C13941.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, e<? super k0> eVar) {
            return ((C13941) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass3<T> implements i {
            final /* synthetic */ OwnerStatusManager this$0;

            public AnonymousClass3(OwnerStatusManager ownerStatusManager) {
                this.this$0 = ownerStatusManager;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
            
                if (r4.send(r8, r0) == r1) goto L24;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.data.db.entity.toDus.Status r8, ab.e<? super ua.k0> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3$emit$1 r0 = (cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3$emit$1 r0 = new cu.todus.android.xmpp.dispatchers.OwnerStatusManager$startManager$1$3$emit$1
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
                    cu.todus.android.data.db.entity.toDus.Status r8 = (cu.todus.android.data.db.entity.toDus.Status) r8
                    java.lang.Object r8 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.Status r8 = (cu.todus.android.data.db.entity.toDus.Status) r8
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
                    cu.todus.android.data.db.entity.toDus.Status r2 = (cu.todus.android.data.db.entity.toDus.Status) r2
                    java.lang.Object r4 = r0.L$1
                    cu.todus.android.xmpp.dispatchers.OwnerStatusManager r4 = (cu.todus.android.xmpp.dispatchers.OwnerStatusManager) r4
                    java.lang.Object r5 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.Status r5 = (cu.todus.android.data.db.entity.toDus.Status) r5
                    ua.v.b(r9)
                    r6 = r2
                    r2 = r8
                    r8 = r6
                    goto L72
                L51:
                    ua.v.b(r9)
                    if (r8 == 0) goto L8c
                    cu.todus.android.xmpp.dispatchers.OwnerStatusManager r9 = r7.this$0
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
                    java.lang.Object r8 = cu.todus.android.xmpp.dispatchers.OwnerStatusManager.access$send(r4, r8, r0)
                    if (r8 != r1) goto L8c
                L8b:
                    return r1
                L8c:
                    ua.k0 r8 = ua.k0.f43947a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerStatusManager.C13941.AnonymousClass3.emit(cu.todus.android.data.db.entity.toDus.Status, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit((Status) obj, (e<? super k0>) eVar);
            }
        }
    }

    public OwnerStatusManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner, UploadStatusDataSource uploadStatusDataSource) {
        y.i(canSend, "canSend");
        y.i(mXMPPConnection, "mXMPPConnection");
        y.i(owner, "owner");
        y.i(uploadStatusDataSource, "uploadStatusDataSource");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        this.uploadStatusDataSource = uploadStatusDataSource;
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.statusDao = DatabaseModule.INSTANCE.getInstance().getStatusDao();
        this.job = n0.a(d1.b().plus(e2.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
    
        if (r2.deleteById(r10, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e4, code lost:
    
        if (r2.changeStatusState(r10, 3, r0) == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteStatus(java.lang.String r10, ab.e<? super java.lang.Boolean> r11) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerStatusManager.deleteStatus(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object send(Status status, e<? super k0> eVar) {
        String id2 = status.getId();
        String creatorId = status.getCreatorId();
        long createdAt = status.getCreatedAt();
        boolean zIsPublic = status.isPublic();
        boolean canRespond = status.getCanRespond();
        String type = status.getType();
        Base64Util base64Util = Base64Util.INSTANCE;
        String strT = this.gson.t(status.getMessageEntities());
        y.h(strT, "toJson(...)");
        String strEncodedMessage$default = Base64Util.encodedMessage$default(base64Util, strT, 0, 2, (Object) null);
        String strT2 = this.gson.t(status.getContent());
        y.h(strT2, "toJson(...)");
        StatusContent statusContent = new StatusContent(id2, creatorId, null, createdAt, zIsPublic, canRespond, type, strEncodedMessage$default, Base64Util.encodedMessage$default(base64Util, strT2, 0, 2, (Object) null), status.getLocation(), 4, null);
        if (status.isDelete()) {
            Object objDeleteStatus = deleteStatus(status.getId(), eVar);
            return objDeleteStatus == b.g() ? objDeleteStatus : k0.f43947a;
        }
        Object objSendStatus = sendStatus(statusContent, status.getId(), eVar);
        return objSendStatus == b.g() ? objSendStatus : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r13 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ea, code lost:
    
        if (r2.changeStatusState(r12, 0, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0117, code lost:
    
        if (r2.changeStatusState(r12, 3, r0) == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendStatus(cu.todus.android.data.xmpp.StatusContent r11, java.lang.String r12, ab.e<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerStatusManager.sendStatus(cu.todus.android.data.xmpp.StatusContent, java.lang.String, ab.e):java.lang.Object");
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final UploadStatusDataSource getUploadStatusDataSource() {
        return this.uploadStatusDataSource;
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.job = m0VarA;
        a2 a2VarD = k.d(m0VarA, null, o0.LAZY, new C13941(null), 1, null);
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
