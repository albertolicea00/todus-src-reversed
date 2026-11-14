package cu.todus.android.xmpp.dispatchers;

import ab.e;
import androidx.compose.runtime.internal.StabilityInferred;
import bb.b;
import cb.d;
import cb.f;
import cb.m;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.xmpp.StanzaListenerManager;
import java.util.List;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcu/todus/android/xmpp/dispatchers/OwnerDeleteMessageManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;Llb/a;Llb/a;)V", "", "roomId", "Lua/k0;", "removeDateMsg", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "startManager", "()V", "stopManager", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lpe/m0;", "job", "Lpe/m0;", "Lpe/a2;", "deleteListener", "Lpe/a2;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OwnerDeleteMessageManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private a2 deleteListener;
    private m0 job;
    private final lb.a mXMPPConnection;
    private final MessageDao messageDao;
    private final lb.a owner;
    private final RoomDao roomDao;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$removeDateMsg$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager", f = "OwnerDeleteMessageManager.kt", l = {33, 36}, m = "removeDateMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
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
            return OwnerDeleteMessageManager.this.removeDateMsg(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1", f = "OwnerDeleteMessageManager.kt", l = {43}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13851 extends m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @f(c = "cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$1", f = "OwnerDeleteMessageManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lte/i;", "", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02711 extends m implements Function3 {
            int label;

            public C02711(e<? super C02711> eVar) {
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
                return new C02711(eVar).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass2<T> implements i {
            final /* synthetic */ OwnerDeleteMessageManager this$0;

            public AnonymousClass2(OwnerDeleteMessageManager ownerDeleteMessageManager) {
                this.this$0 = ownerDeleteMessageManager;
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit((List<MessageWithAttachments>) obj, (e<? super k0>) eVar);
            }

            /* JADX WARN: Code duplicated, block: B:21:0x00c2 A[PHI: r2 r4 r5 r6 r7 r9 r10 r11 r12 r13 r14 r15
              0x00c2: PHI (r2v10 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$2$emit$1) = 
              (r2v11 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$2$emit$1)
              (r2v2 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$startManager$1$2$emit$1)
             binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r4v8 int) = (r4v9 int), (r4v15 int) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r5v8 int) = (r5v11 int), (r5v15 int) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r6v6 cu.todus.android.data.db.pojo.MessageWithAttachments) = 
              (r6v9 cu.todus.android.data.db.pojo.MessageWithAttachments)
              (r6v16 cu.todus.android.data.db.pojo.MessageWithAttachments)
             binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r7v6 java.lang.Object) = (r7v9 java.lang.Object), (r7v12 java.lang.Object) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r9v4 java.lang.Object) = (r9v6 java.lang.Object), (r9v0 java.lang.Object) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r10v10 int) = (r10v19 int), (r10v0 int) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r11v4 boolean) = (r11v9 boolean), (r11v17 boolean) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r12v6 java.util.Iterator<T>) = (r12v9 java.util.Iterator<T>), (r12v18 java.util.Iterator<T>) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r13v5 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager) = 
              (r13v8 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager)
              (r13v15 cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager)
             binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r14v4 java.lang.Iterable) = (r14v7 java.lang.Iterable), (r14v15 java.lang.Iterable) binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]
              0x00c2: PHI (r15v5 java.util.List<cu.todus.android.data.db.pojo.MessageWithAttachments>) = 
              (r15v8 java.util.List<cu.todus.android.data.db.pojo.MessageWithAttachments>)
              (r15v18 java.util.List<cu.todus.android.data.db.pojo.MessageWithAttachments>)
             binds: [B:31:0x016e, B:20:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:26:0x0102  */
            /* JADX WARN: Code duplicated, block: B:29:0x013f  */
            /* JADX WARN: Code duplicated, block: B:35:0x0182  */
            /* JADX WARN: Code duplicated, block: B:38:0x01b5  */
            /* JADX WARN: Code duplicated, block: B:45:0x020d  */
            /* JADX WARN: Code duplicated, block: B:47:0x021c  */
            /* JADX WARN: Code duplicated, block: B:50:0x026f  */
            /* JADX WARN: Code duplicated, block: B:52:0x0278  */
            /* JADX WARN: Code duplicated, block: B:54:0x027e  */
            /* JADX WARN: Code duplicated, block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x026f -> B:51:0x0273). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0278 -> B:53:0x027a). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x027e -> B:53:0x027a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object emit(java.util.List<cu.todus.android.data.db.pojo.MessageWithAttachments> r21, ab.e<? super ua.k0> r22) {
                /*
                    Method dump skipped, instruction units count: 655
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager.C13851.AnonymousClass2.emit(java.util.List, ab.e):java.lang.Object");
            }
        }

        public C13851(e<? super C13851> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerDeleteMessageManager.this.new C13851(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                h hVarG = j.g(u.f(OwnerDeleteMessageManager.this.messageDao.messagesToDelete(), 2L, null, 2, null), new C02711(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(OwnerDeleteMessageManager.this);
                this.label = 1;
                if (hVarG.collect(anonymousClass2, this) == objG) {
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
            return ((C13851) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public OwnerDeleteMessageManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner) {
        y.i(canSend, "canSend");
        y.i(mXMPPConnection, "mXMPPConnection");
        y.i(owner, "owner");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.messageDao = companion.getInstance().getMessageDao();
        this.roomDao = companion.getInstance().getRoomDao();
        this.job = n0.a(d1.b().plus(e2.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
    
        if (r2.removeById(r4, r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object removeDateMsg(java.lang.String r6, ab.e<? super ua.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$removeDateMsg$1 r0 = (cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$removeDateMsg$1 r0 = new cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager$removeDateMsg$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            cu.todus.android.data.db.entity.toDus.Message r6 = (cu.todus.android.data.db.entity.toDus.Message) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L58
        L44:
            ua.v.b(r7)
            cu.todus.android.db.dao.toDus.MessageDao r7 = r5.messageDao
            java.lang.Object r2 = cb.l.a(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getLastMessageOfRoomWithPayloadsIncluded(r6, r0)
            if (r7 != r1) goto L58
            goto L80
        L58:
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            if (r7 == 0) goto L61
            cu.todus.android.data.db.pojo.info.MessagePayload r2 = r7.getPayload()
            goto L62
        L61:
            r2 = 0
        L62:
            boolean r2 = r2 instanceof cu.todus.android.data.db.pojo.info.DatePayload
            if (r2 == 0) goto L84
            cu.todus.android.db.dao.toDus.MessageDao r2 = r5.messageDao
            java.lang.String r4 = r7.getId()
            java.lang.Object r6 = cb.l.a(r6)
            r0.L$0 = r6
            java.lang.Object r6 = cb.l.a(r7)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r2.removeById(r4, r0)
            if (r6 != r1) goto L81
        L80:
            return r1
        L81:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        L84:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerDeleteMessageManager.removeDateMsg(java.lang.String, ab.e):java.lang.Object");
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

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.job = m0VarA;
        a2 a2VarD = k.d(m0VarA, null, o0.LAZY, new C13851(null), 1, null);
        this.deleteListener = a2VarD;
        if (a2VarD != null) {
            a2VarD.start();
        }
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        a2 a2Var = this.deleteListener;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
    }
}
