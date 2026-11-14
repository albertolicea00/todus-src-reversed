package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.block.GetBlockListPaginatedIQ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcu/todus/android/xmpp/managers/BlocksManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;Llb/a;Llb/a;)V", "", "", "blocksId", "Lua/k0;", "updateBlocks", "(Ljava/util/List;)V", "uid", "blockUser", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "unBlockUser", "loadUsersBlock", "(Lab/e;)Ljava/lang/Object;", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BlocksManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final m0 coroutineScope;
    private final DatabaseModule databaseModule;
    private final lb.a mXMPPConnection;
    private final lb.a owner;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.BlocksManager$blockUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.BlocksManager", f = "BlocksManager.kt", l = {121, 60}, m = "blockUser", v = 2)
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
            return BlocksManager.this.blockUser(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.BlocksManager$loadUsersBlock$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.BlocksManager$loadUsersBlock$2", f = "BlocksManager.kt", l = {121}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", DataLayout.ELEMENT, "", "pageSize"}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, int i11, ab.e<? super List<String>> eVar) {
            AnonymousClass2 anonymousClass2 = BlocksManager.this.new AnonymousClass2(eVar);
            anonymousClass2.I$0 = i10;
            anonymousClass2.I$1 = i11;
            return anonymousClass2.invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = bb.b.g();
            int i12 = this.label;
            if (i12 == 0) {
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) BlocksManager.this.getMXMPPConnection().invoke();
                if (xMPPTCPConnection == null) {
                    return null;
                }
                GetBlockListPaginatedIQ getBlockListPaginatedIQ = new GetBlockListPaginatedIQ(null, null, i11, i10, 3, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getBlockListPaginatedIQ);
                this.L$0 = cb.l.a(xMPPTCPConnection);
                this.L$1 = cb.l.a(getBlockListPaginatedIQ);
                this.I$0 = i10;
                this.I$1 = i11;
                this.I$2 = 0;
                this.label = 1;
                obj = te.j.x(hVarSendIQFlow, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            GetBlockListPaginatedIQ getBlockListPaginatedIQ2 = (GetBlockListPaginatedIQ) ((IQ) obj);
            if (getBlockListPaginatedIQ2 != null) {
                return getBlockListPaginatedIQ2.getBlock();
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<String>>) obj3);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.BlocksManager$loadUsersBlock$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.BlocksManager$loadUsersBlock$3", f = "BlocksManager.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "blocksInPage", "Lua/k0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass3 anonymousClass3 = BlocksManager.this.new AnonymousClass3(eVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            BlocksManager blocksManager = BlocksManager.this;
            ArrayList arrayList = new ArrayList(va.x.y(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((String) it.next()) + "@im.todus.cu");
            }
            blocksManager.updateBlocks(arrayList);
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List<String> list, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(list, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.BlocksManager$unBlockUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.BlocksManager", f = "BlocksManager.kt", l = {121, 83}, m = "unBlockUser", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13951 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13951(ab.e<? super C13951> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BlocksManager.this.unBlockUser(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.BlocksManager$updateBlocks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.BlocksManager$updateBlocks$1", f = "BlocksManager.kt", l = {34, 37, 44}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13961 extends cb.m implements Function2 {
        final /* synthetic */ List<String> $blocksId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13961(List<String> list, ab.e<? super C13961> eVar) {
            super(2, eVar);
            this.$blocksId = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return BlocksManager.this.new C13961(this.$blocksId, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x008d  */
        /* JADX WARN: Code duplicated, block: B:22:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:25:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:31:0x011b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:? A[LOOP:0: B:23:0x00da->B:33:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
        
            if (r2 == r1) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00c8, code lost:
        
            if (r14.changeBlockState(r15, r13, r16) == r1) goto L27;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c8 -> B:21:0x00cb). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.BlocksManager.C13961.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13961) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public BlocksManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(owner, "owner");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBlocks(List<String> blocksId) {
        pe.k.d(this.coroutineScope, null, null, new C13961(blocksId, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        if (r12 == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        if (loadUsersBlock(r0) == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object blockUser(java.lang.String r11, ab.e<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.BlocksManager.blockUser(java.lang.String, ab.e):java.lang.Object");
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

    public final Object loadUsersBlock(ab.e<? super k0> eVar) {
        if (!((Boolean) this.canSend.invoke()).booleanValue()) {
            return k0.f43947a;
        }
        Object objRecursivePagingRequest$default = XMPPInlinesKt.recursivePagingRequest$default(new AnonymousClass2(null), 0, 10, 0L, new AnonymousClass3(null), new lb.a() { // from class: cu.todus.android.xmpp.managers.a
            @Override // lb.a
            public final Object invoke() {
                return k0.f43947a;
            }
        }, null, eVar, 72, null);
        return objRecursivePagingRequest$default == bb.b.g() ? objRecursivePagingRequest$default : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        if (r12 == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        if (loadUsersBlock(r0) == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object unBlockUser(java.lang.String r11, ab.e<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.BlocksManager.unBlockUser(java.lang.String, ab.e):java.lang.Object");
    }
}
