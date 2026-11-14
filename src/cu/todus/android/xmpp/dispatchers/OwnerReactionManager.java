package cu.todus.android.xmpp.dispatchers;

import ab.e;
import androidx.compose.runtime.ComposerImplKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.muxer.WebmConstants;
import bb.b;
import cb.d;
import cb.m;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.pojo.content.ReactionContent;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.xmpp.StanzaListenerManager;
import cu.todus.android.xmpp.XMPPUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.a0;
import org.jxmpp.stringprep.XmppStringprepException;
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
import v5.f;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcu/todus/android/xmpp/dispatchers/OwnerReactionManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "<init>", "(Llb/a;Llb/a;)V", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "reaction", "Lua/k0;", "send", "(Lcu/todus/android/data/db/entity/toDus/Reaction;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/Message;", "message", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", Attachment.TABLE_NAME, "", "reactionId", "sendReactionToChannel", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "attachment", "sendReaction", "startManager", "()V", "stopManager", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Lv5/f;", "gson", "Lv5/f;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lpe/m0;", "job", "Lpe/m0;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OwnerReactionManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final f gson;
    private m0 job;
    private a2 listener;
    private final lb.a mXMPPConnection;
    private final MessageDao messageDao;
    private final ReactionDao reactionDao;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerReactionManager$sendReaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerReactionManager", f = "OwnerReactionManager.kt", l = {137, 144, 147, WebmConstants.MkvEbmlElement.BLOCK_DURATION}, m = "sendReaction", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerReactionManager.this.sendReaction(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerReactionManager$sendReactionToChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerReactionManager", f = "OwnerReactionManager.kt", l = {WebmConstants.MkvEbmlElement.BLOCK, 119, ComposerImplKt.nodeKey}, m = "sendReactionToChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13911 extends d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C13911(e<? super C13911> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OwnerReactionManager.this.sendReactionToChannel(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1", f = "OwnerReactionManager.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13921 extends m implements Function2 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$1", f = "OwnerReactionManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/Reaction;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02731 extends m implements Function3 {
            int label;

            public C02731(e<? super C02731> eVar) {
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
                return new C02731(eVar).invokeSuspend(k0.f43947a);
            }
        }

        public C13921(e<? super C13921> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final e<k0> create(Object obj, e<?> eVar) {
            return OwnerReactionManager.this.new C13921(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                h hVarF = j.f(j.g(u.f(OwnerReactionManager.this.reactionDao.getUnsentReaction(), 2L, null, 2, null), new C02731(null)));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(OwnerReactionManager.this);
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
            return ((C13921) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class AnonymousClass2<T> implements i {
            final /* synthetic */ OwnerReactionManager this$0;

            public AnonymousClass2(OwnerReactionManager ownerReactionManager) {
                this.this$0 = ownerReactionManager;
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0080  */
            /* JADX WARN: Code duplicated, block: B:29:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
            
                if (r3.deleteById(r5, r0) == r1) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
            
                if (r5.send(r2, r0) == r1) goto L31;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.data.db.entity.toDus.Reaction r9, ab.e<? super ua.k0> r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2$emit$1
                    if (r0 == 0) goto L13
                    r0 = r10
                    cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2$emit$1 r0 = (cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2$emit$1 r0 = new cu.todus.android.xmpp.dispatchers.OwnerReactionManager$startManager$1$2$emit$1
                    r0.<init>(r8, r10)
                L18:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = bb.b.g()
                    int r2 = r0.label
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L55
                    if (r2 == r5) goto L41
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    goto L34
                L2c:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L34:
                    java.lang.Object r9 = r0.L$1
                    cu.todus.android.data.db.entity.toDus.Reaction r9 = (cu.todus.android.data.db.entity.toDus.Reaction) r9
                    java.lang.Object r9 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.Reaction r9 = (cu.todus.android.data.db.entity.toDus.Reaction) r9
                    ua.v.b(r10)
                    goto Lba
                L41:
                    int r9 = r0.I$0
                    java.lang.Object r2 = r0.L$2
                    cu.todus.android.data.db.entity.toDus.Reaction r2 = (cu.todus.android.data.db.entity.toDus.Reaction) r2
                    java.lang.Object r5 = r0.L$1
                    cu.todus.android.xmpp.dispatchers.OwnerReactionManager r5 = (cu.todus.android.xmpp.dispatchers.OwnerReactionManager) r5
                    java.lang.Object r6 = r0.L$0
                    cu.todus.android.data.db.entity.toDus.Reaction r6 = (cu.todus.android.data.db.entity.toDus.Reaction) r6
                    ua.v.b(r10)
                    r10 = r9
                    r9 = r6
                    goto L73
                L55:
                    ua.v.b(r10)
                    if (r9 == 0) goto Lba
                    cu.todus.android.xmpp.dispatchers.OwnerReactionManager r10 = r8.this$0
                    r0.L$0 = r9
                    r0.L$1 = r10
                    r0.L$2 = r9
                    r2 = 0
                    r0.I$0 = r2
                    r0.label = r5
                    r5 = 100
                    java.lang.Object r5 = pe.w0.b(r5, r0)
                    if (r5 != r1) goto L70
                    goto Lb9
                L70:
                    r5 = r10
                    r10 = r2
                    r2 = r9
                L73:
                    cu.todus.android.xmpp.XMPPUtils r6 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                    java.lang.String r7 = r9.getRoomId()
                    boolean r6 = r6.isChannel(r7)
                    r7 = 0
                    if (r6 == 0) goto La1
                    cu.todus.android.db.dao.toDus.ReactionDao r3 = cu.todus.android.xmpp.dispatchers.OwnerReactionManager.access$getReactionDao$p(r5)
                    java.lang.String r5 = r9.getId()
                    java.lang.Object r9 = cb.l.a(r9)
                    r0.L$0 = r9
                    java.lang.Object r9 = cb.l.a(r2)
                    r0.L$1 = r9
                    r0.L$2 = r7
                    r0.I$0 = r10
                    r0.label = r4
                    java.lang.Object r9 = r3.deleteById(r5, r0)
                    if (r9 != r1) goto Lba
                    goto Lb9
                La1:
                    java.lang.Object r9 = cb.l.a(r9)
                    r0.L$0 = r9
                    java.lang.Object r9 = cb.l.a(r2)
                    r0.L$1 = r9
                    r0.L$2 = r7
                    r0.I$0 = r10
                    r0.label = r3
                    java.lang.Object r9 = cu.todus.android.xmpp.dispatchers.OwnerReactionManager.access$send(r5, r2, r0)
                    if (r9 != r1) goto Lba
                Lb9:
                    return r1
                Lba:
                    ua.k0 r9 = ua.k0.f43947a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerReactionManager.C13921.AnonymousClass2.emit(cu.todus.android.data.db.entity.toDus.Reaction, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, e eVar) {
                return emit((Reaction) obj, (e<? super k0>) eVar);
            }
        }
    }

    public OwnerReactionManager(lb.a canSend, lb.a mXMPPConnection) {
        y.i(canSend, "canSend");
        y.i(mXMPPConnection, "mXMPPConnection");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.reactionDao = companion.getInstance().getReactionDao();
        this.messageDao = companion.getInstance().getMessageDao();
        this.job = n0.a(d1.b().plus(e2.b(null, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object send(Reaction reaction, e<? super k0> eVar) throws XmppStringprepException {
        Message message = new Message(reaction.getEntity(), reaction.getRoomId(), reaction.getUserId(), "", 0L, 0, null, null, null, 496, null);
        String string = UUID.randomUUID().toString();
        y.h(string, "toString(...)");
        Attachment attachment = new Attachment(a0.O(string, "-", "", false, 4, null), message.getId(), new ReactionContent(reaction.getEntity(), reaction.getReactionContent(), reaction.getCreatedAt()), 6, 23, false, 32, null);
        if (XMPPUtils.INSTANCE.isChannel(reaction.getRoomId())) {
            Object objSendReactionToChannel = sendReactionToChannel(message, va.v.e(attachment), Reaction.INSTANCE.buildId(reaction.getEntity(), reaction.getUserId()), eVar);
            return objSendReactionToChannel == b.g() ? objSendReactionToChannel : k0.f43947a;
        }
        Object objSendReaction = sendReaction(message, va.v.e(attachment), Reaction.INSTANCE.buildId(reaction.getEntity(), reaction.getUserId()), eVar);
        return objSendReaction == b.g() ? objSendReaction : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00df  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:43:0x0126  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011e, code lost:
    
        if (r3.setReactionAsSent(r13, r0) == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015b, code lost:
    
        if (r5.deleteById(r13, r0) == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendReaction(cu.todus.android.data.db.entity.toDus.Message r11, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r12, java.lang.String r13, ab.e<? super java.lang.Boolean> r14) throws org.jxmpp.stringprep.XmppStringprepException {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerReactionManager.sendReaction(cu.todus.android.data.db.entity.toDus.Message, java.util.List, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:33:0x0130 A[PHI: r4 r11 r12 r14
      0x0130: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v6 java.lang.String) binds: [B:32:0x012e, B:26:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r11v1 cu.todus.android.data.db.entity.toDus.Message) = (r11v0 cu.todus.android.data.db.entity.toDus.Message), (r11v2 cu.todus.android.data.db.entity.toDus.Message) binds: [B:32:0x012e, B:26:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r12v1 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r12v0 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r12v2 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:32:0x012e, B:26:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r14v4 java.lang.String) = (r14v0 java.lang.String), (r14v5 java.lang.String) binds: [B:32:0x012e, B:26:0x00fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0126, code lost:
    
        if (r5.setReactionAsSent(r14, r2) == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0167, code lost:
    
        if (r1.deleteById(r14, r2) == r3) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendReactionToChannel(cu.todus.android.data.db.entity.toDus.Message r17, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r18, java.lang.String r19, ab.e<? super java.lang.Boolean> r20) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.dispatchers.OwnerReactionManager.sendReactionToChannel(cu.todus.android.data.db.entity.toDus.Message, java.util.List, java.lang.String, ab.e):java.lang.Object");
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
        a2 a2VarD = k.d(m0VarA, null, o0.LAZY, new C13921(null), 1, null);
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
