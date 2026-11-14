package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.XMPPInlinesKt;
import kotlin.Metadata;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0015\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcu/todus/android/xmpp/managers/PresenceManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "<init>", "(Llb/a;Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;)V", "Lorg/jivesoftware/smack/packet/Presence$Type;", "t", "", "status", "Lorg/jivesoftware/smack/packet/Presence$Mode;", "m", "sendPresence", "(Lorg/jivesoftware/smack/packet/Presence$Type;Ljava/lang/String;Lorg/jivesoftware/smack/packet/Presence$Mode;Lab/e;)Ljava/lang/Object;", "Lua/k0;", "sendAway", "(Lab/e;)Ljava/lang/Object;", "sendOnline", "sendAppClose", "Llb/a;", "getCanSend", "()Llb/a;", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "getMXMPPConnection", "()Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PresenceManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final XMPPTCPConnection mXMPPConnection;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.PresenceManager$sendPresence$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.PresenceManager", f = "PresenceManager.kt", l = {15}, m = "sendPresence", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
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
            return PresenceManager.this.sendPresence(null, null, null, this);
        }
    }

    public PresenceManager(lb.a canSend, XMPPTCPConnection xMPPTCPConnection) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        this.canSend = canSend;
        this.mXMPPConnection = xMPPTCPConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object sendPresence(Presence.Type type, String str, Presence.Mode mode, ab.e<? super Boolean> eVar) {
        AnonymousClass1 anonymousClass1;
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
        Object objSuspendSendStanzaAndWaitForConfirm = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        boolean z10 = true;
        if (i11 == 0) {
            ua.v.b(objSuspendSendStanzaAndWaitForConfirm);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = this.mXMPPConnection;
                if (xMPPTCPConnection != null) {
                    Presence presence = new Presence(type, str, 1, mode);
                    anonymousClass1.L$0 = cb.l.a(type);
                    anonymousClass1.L$1 = cb.l.a(str);
                    anonymousClass1.L$2 = cb.l.a(mode);
                    anonymousClass1.label = 1;
                    objSuspendSendStanzaAndWaitForConfirm = XMPPInlinesKt.suspendSendStanzaAndWaitForConfirm(xMPPTCPConnection, presence, anonymousClass1);
                    if (objSuspendSendStanzaAndWaitForConfirm == objG) {
                        return objG;
                    }
                }
            } else {
                z10 = false;
            }
            return cb.b.a(z10);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objSuspendSendStanzaAndWaitForConfirm);
        return cb.b.a(z10);
    }

    public static /* synthetic */ Object sendPresence$default(PresenceManager presenceManager, Presence.Type type, String str, Presence.Mode mode, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "";
        }
        if ((i10 & 4) != 0) {
            mode = Presence.Mode.away;
        }
        return presenceManager.sendPresence(type, str, mode, eVar);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final XMPPTCPConnection getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final Object sendAppClose(ab.e<? super k0> eVar) {
        Object objSendPresence$default = sendPresence$default(this, Presence.Type.available, null, Presence.Mode.xa, eVar, 2, null);
        return objSendPresence$default == bb.b.g() ? objSendPresence$default : k0.f43947a;
    }

    public final Object sendAway(ab.e<? super k0> eVar) {
        Object objSendPresence$default = sendPresence$default(this, Presence.Type.available, null, Presence.Mode.xa, eVar, 2, null);
        return objSendPresence$default == bb.b.g() ? objSendPresence$default : k0.f43947a;
    }

    public final Object sendOnline(ab.e<? super Boolean> eVar) {
        return sendPresence$default(this, Presence.Type.available, null, Presence.Mode.chat, eVar, 2, null);
    }
}
