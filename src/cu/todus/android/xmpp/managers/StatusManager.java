package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import cu.todus.android.data.db.entity.toDus.Status;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.StatusExistenceContent;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.xmpp.StanzaListenerManager;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.status.FollowIQ;
import cu.todus.android.xmpp.iq.status.GetFollowInfoIQ;
import cu.todus.android.xmpp.iq.status.UnFollowIQ;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import le.d0;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import pe.o0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B}\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u0012$\u0010\u0010\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J0\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b \u0010!J0\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\"\u0010!J\u001a\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0086@¢\u0006\u0004\b%\u0010$J\u001a\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001a\u001a\u00020\nH\u0086@¢\u0006\u0004\b'\u0010$R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b)\u0010*R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b+\u0010*R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b,\u0010*R3\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b.\u0010/R5\u0010\u0010\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b0\u0010/R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006="}, d2 = {"Lcu/todus/android/xmpp/managers/StatusManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function2;", "", "Lab/e;", "Lua/k0;", "", "reloadUser", "Lcu/todus/android/data/db/entity/toDus/User;", "getUserInfo", "<init>", "(Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lcu/todus/android/data/db/pojo/content/StatusExistenceContent;", "statusExistenceContent", "handleStatusExistence", "(Lcu/todus/android/data/db/pojo/content/StatusExistenceContent;)V", "startManager", "()V", "stopManager", "uid", "", DataLayout.ELEMENT, "pageSize", "", "Lcu/todus/android/data/db/pojo/FollowPartner;", "getFollowerPage", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "getFollowingPage", "follow", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "unFollow", "Lcu/todus/android/data/xmpp/FollowState;", "followState", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lkotlin/jvm/functions/Function2;", "getReloadUser", "()Lkotlin/jvm/functions/Function2;", "getGetUserInfo", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lv5/f;", "gson", "Lv5/f;", "Lpe/a2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lpe/a2;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatusManager implements StanzaListenerManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private m0 coroutineScope;
    private final DatabaseModule databaseModule;
    private final Function2 getUserInfo;
    private final v5.f gson;
    private a2 listener;
    private final lb.a mXMPPConnection;
    private final lb.a owner;
    private final Function2 reloadUser;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$follow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager", f = "StatusManager.kt", l = {310}, m = "follow", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusManager.this.follow(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$followState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager", f = "StatusManager.kt", l = {310}, m = "followState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15081 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15081(ab.e<? super C15081> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusManager.this.followState(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$getFollowerPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager", f = "StatusManager.kt", l = {310, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT}, m = "getFollowerPage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15091 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C15091(ab.e<? super C15091> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusManager.this.getFollowerPage(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$getFollowingPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager", f = "StatusManager.kt", l = {310, WebmConstants.MkvEbmlElement.TIMESTAMP, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION}, m = "getFollowingPage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15101 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C15101(ab.e<? super C15101> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusManager.this.getFollowingPage(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$handleStatusExistence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager$handleStatusExistence$1", f = "StatusManager.kt", l = {69}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C15111 extends cb.m implements Function1 {
        final /* synthetic */ StatusExistenceContent $statusExistenceContent;
        Object L$0;
        int label;
        final /* synthetic */ StatusManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15111(StatusExistenceContent statusExistenceContent, StatusManager statusManager, ab.e<? super C15111> eVar) {
            super(1, eVar);
            this.$statusExistenceContent = statusExistenceContent;
            this.this$0 = statusManager;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C15111(this.$statusExistenceContent, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C15111) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                Status status = new Status(this.$statusExistenceContent.getStatusId(), "", "", this.$statusExistenceContent.getCreateAt(), false, this.$statusExistenceContent.getIsDelete() == 1, false, "", new DeletedContent(), false, false, va.w.n(), 7, "", 0, 0, 0, 115712, null);
                StatusDao statusDao = this.this$0.databaseModule.getStatusDao();
                this.L$0 = cb.l.a(status);
                this.label = 1;
                if (statusDao.insert(status, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager$startManager$1", f = "StatusManager.kt", l = {77, 79}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C15121 extends cb.m implements Function2 {
        int label;

        public C15121(ab.e<? super C15121> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return StatusManager.this.new C15121(eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        
            if (r5.collect(r1, r4) == r0) goto L15;
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
                goto L66
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ua.v.b(r5)
                goto L44
            L1e:
                ua.v.b(r5)
                cu.todus.android.xmpp.managers.StatusManager r5 = cu.todus.android.xmpp.managers.StatusManager.this
                cu.todus.android.di.DatabaseModule r5 = cu.todus.android.xmpp.managers.StatusManager.access$getDatabaseModule$p(r5)
                cu.todus.android.db.dao.toDus.StatusDao r5 = r5.getStatusDao()
                cu.todus.android.xmpp.managers.StatusManager r1 = cu.todus.android.xmpp.managers.StatusManager.this
                lb.a r1 = r1.getOwner()
                java.lang.Object r1 = r1.invoke()
                cu.todus.android.data.preferences.Owner r1 = (cu.todus.android.data.preferences.Owner) r1
                java.lang.String r1 = r1.getNameWithDomain()
                r4.label = r3
                java.lang.Object r5 = r5.prepareToRetryStatusWithError(r1, r4)
                if (r5 != r0) goto L44
                goto L65
            L44:
                cu.todus.android.xmpp.managers.StatusManager r5 = cu.todus.android.xmpp.managers.StatusManager.this
                cu.todus.android.di.DatabaseModule r5 = cu.todus.android.xmpp.managers.StatusManager.access$getDatabaseModule$p(r5)
                cu.todus.android.db.dao.toDus.StatusDao r5 = r5.getStatusDao()
                te.h r5 = r5.statusToDownload()
                te.h r5 = te.j.f(r5)
                cu.todus.android.xmpp.managers.StatusManager$startManager$1$1 r1 = new cu.todus.android.xmpp.managers.StatusManager$startManager$1$1
                cu.todus.android.xmpp.managers.StatusManager r3 = cu.todus.android.xmpp.managers.StatusManager.this
                r1.<init>(r3)
                r4.label = r2
                java.lang.Object r5 = r5.collect(r1, r4)
                if (r5 != r0) goto L66
            L65:
                return r0
            L66:
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.StatusManager.C15121.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C15121) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$startManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class C02741<T> implements te.i {
            final /* synthetic */ StatusManager this$0;

            public C02741(StatusManager statusManager) {
                this.this$0 = statusManager;
            }

            /* JADX WARN: Code duplicated, block: B:63:0x025b  */
            /* JADX WARN: Code duplicated, block: B:65:0x025f  */
            /* JADX WARN: Code duplicated, block: B:66:0x0264  */
            /* JADX WARN: Code duplicated, block: B:69:0x026d  */
            /* JADX WARN: Code duplicated, block: B:72:0x028f  */
            /* JADX WARN: Code duplicated, block: B:78:0x02b9  */
            /* JADX WARN: Code duplicated, block: B:7:0x001b  */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00ee, code lost:
            
                if (r2.deleteById(r3, r4) == r5) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x012c, code lost:
            
                if (r2 == r5) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x021b, code lost:
            
                if (r0.update(r12, r4) == r5) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x0257, code lost:
            
                if (r2.changeStatusState(r7, 3, r4) == r5) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x02b3, code lost:
            
                if (r2.deleteById(r6, r4) == r5) goto L80;
             */
            /* JADX WARN: Code restructure failed: missing block: B:79:0x02de, code lost:
            
                if (r0.changeStatusState(r3, 3, r4) == r5) goto L80;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.data.db.entity.toDus.Status r35, ab.e<? super ua.k0> r36) {
                /*
                    Method dump skipped, instruction units count: 766
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.StatusManager.C15121.C02741.emit(cu.todus.android.data.db.entity.toDus.Status, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar) {
                return emit((Status) obj, (ab.e<? super k0>) eVar);
            }
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.StatusManager$unFollow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.StatusManager", f = "StatusManager.kt", l = {310}, m = "unFollow", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15131 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15131(ab.e<? super C15131> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatusManager.this.unFollow(null, this);
        }
    }

    public StatusManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner, Function2 reloadUser, Function2 getUserInfo) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(reloadUser, "reloadUser");
        kotlin.jvm.internal.y.i(getUserInfo, "getUserInfo");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        this.reloadUser = reloadUser;
        this.getUserInfo = getUserInfo;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object follow(String str, ab.e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
        FollowIQ followIQ;
        String code;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object objX = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    FollowIQ followIQ2 = new FollowIQ(str, null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, followIQ2);
                    anonymousClass1.L$0 = cb.l.a(str);
                    anonymousClass1.L$1 = cb.l.a(xMPPTCPConnection);
                    anonymousClass1.L$2 = cb.l.a(followIQ2);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    objX = te.j.x(hVarSendIQFlow, anonymousClass1);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    followIQ = null;
                }
                if (followIQ != null && (code = followIQ.getCode()) != null) {
                    return cb.b.a(d0.q0(code));
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        followIQ = (FollowIQ) ((IQ) objX);
        if (followIQ != null) {
            return cb.b.a(d0.q0(code));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0094  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object followState(String str, ab.e<? super FollowState> eVar) {
        C15081 c15081;
        GetFollowInfoIQ getFollowInfoIQ;
        Pair<Boolean, Boolean> state;
        if (eVar instanceof C15081) {
            c15081 = (C15081) eVar;
            int i10 = c15081.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15081.label = i10 - Integer.MIN_VALUE;
            } else {
                c15081 = new C15081(eVar);
            }
        } else {
            c15081 = new C15081(eVar);
        }
        Object objX = c15081.result;
        Object objG = bb.b.g();
        int i11 = c15081.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    GetFollowInfoIQ getFollowInfoIQ2 = new GetFollowInfoIQ(str, null, null, null, 14, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getFollowInfoIQ2);
                    c15081.L$0 = cb.l.a(str);
                    c15081.L$1 = cb.l.a(xMPPTCPConnection);
                    c15081.L$2 = cb.l.a(getFollowInfoIQ2);
                    c15081.I$0 = 0;
                    c15081.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c15081);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    getFollowInfoIQ = null;
                }
                if (getFollowInfoIQ != null) {
                    state = getFollowInfoIQ.getState();
                } else {
                    state = null;
                }
                if (state != null && getFollowInfoIQ.getFollowsCount() != null) {
                    return new FollowState(getFollowInfoIQ.getState().getFirst().booleanValue(), getFollowInfoIQ.getState().getSecond().booleanValue(), getFollowInfoIQ.getFollowsCount().getFirst().intValue(), getFollowInfoIQ.getFollowsCount().getSecond().intValue());
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        getFollowInfoIQ = (GetFollowInfoIQ) ((IQ) objX);
        if (getFollowInfoIQ != null) {
            state = getFollowInfoIQ.getState();
        } else {
            state = null;
        }
        if (state != null) {
            return new FollowState(getFollowInfoIQ.getState().getFirst().booleanValue(), getFollowInfoIQ.getState().getSecond().booleanValue(), getFollowInfoIQ.getFollowsCount().getFirst().intValue(), getFollowInfoIQ.getFollowsCount().getSecond().intValue());
        }
        return null;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x015b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0163  */
    /* JADX WARN: Code duplicated, block: B:40:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01c1 -> B:53:0x028a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x021e -> B:48:0x0227). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getFollowerPage(java.lang.String r31, int r32, int r33, ab.e<? super java.util.List<cu.todus.android.data.db.pojo.FollowPartner>> r34) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.StatusManager.getFollowerPage(java.lang.String, int, int, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x015b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0163  */
    /* JADX WARN: Code duplicated, block: B:40:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01c1 -> B:53:0x028a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x021e -> B:48:0x0227). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getFollowingPage(java.lang.String r31, int r32, int r33, ab.e<? super java.util.List<cu.todus.android.data.db.pojo.FollowPartner>> r34) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.StatusManager.getFollowingPage(java.lang.String, int, int, ab.e):java.lang.Object");
    }

    public final Function2 getGetUserInfo() {
        return this.getUserInfo;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final Function2 getReloadUser() {
        return this.reloadUser;
    }

    public final void handleStatusExistence(StatusExistenceContent statusExistenceContent) {
        kotlin.jvm.internal.y.i(statusExistenceContent, "statusExistenceContent");
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C15111(statusExistenceContent, this, null), 3, null);
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.coroutineScope = m0VarA;
        a2 a2VarD = pe.k.d(m0VarA, null, o0.LAZY, new C15121(null), 1, null);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object unFollow(String str, ab.e<? super Boolean> eVar) {
        C15131 c15131;
        UnFollowIQ unFollowIQ;
        String code;
        if (eVar instanceof C15131) {
            c15131 = (C15131) eVar;
            int i10 = c15131.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15131.label = i10 - Integer.MIN_VALUE;
            } else {
                c15131 = new C15131(eVar);
            }
        } else {
            c15131 = new C15131(eVar);
        }
        Object objX = c15131.result;
        Object objG = bb.b.g();
        int i11 = c15131.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    UnFollowIQ unFollowIQ2 = new UnFollowIQ(str, null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, unFollowIQ2);
                    c15131.L$0 = cb.l.a(str);
                    c15131.L$1 = cb.l.a(xMPPTCPConnection);
                    c15131.L$2 = cb.l.a(unFollowIQ2);
                    c15131.I$0 = 0;
                    c15131.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c15131);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    unFollowIQ = null;
                }
                if (unFollowIQ != null && (code = unFollowIQ.getCode()) != null) {
                    return cb.b.a(d0.q0(code));
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        unFollowIQ = (UnFollowIQ) ((IQ) objX);
        if (unFollowIQ != null) {
            return cb.b.a(d0.q0(code));
        }
        return null;
    }
}
