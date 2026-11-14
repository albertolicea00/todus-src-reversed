package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.last.LastIQ;
import kotlin.Metadata;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcu/todus/android/xmpp/managers/LastManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "<init>", "(Llb/a;Llb/a;)V", "", "uid", "Lcu/todus/android/xmpp/iq/last/LastIQ;", "getLast", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LastManager {
    public static final int $stable = 0;
    private final lb.a canSend;
    private final lb.a mXMPPConnection;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LastManager$getLast$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LastManager", f = "LastManager.kt", l = {22}, m = "getLast", v = 2)
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
            return LastManager.this.getLast(null, this);
        }
    }

    public LastManager(lb.a canSend, lb.a mXMPPConnection) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getLast(String str, ab.e<? super LastIQ> eVar) {
        AnonymousClass1 anonymousClass1;
        XMPPTCPConnection xMPPTCPConnection;
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
            if (!((Boolean) this.canSend.invoke()).booleanValue() || (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) == null) {
                return null;
            }
            LastIQ lastIQ = new LastIQ(JidCreate.bareFrom(str), 0L, 2, null);
            te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, lastIQ);
            anonymousClass1.L$0 = cb.l.a(str);
            anonymousClass1.L$1 = cb.l.a(xMPPTCPConnection);
            anonymousClass1.L$2 = cb.l.a(lastIQ);
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objX = te.j.x(hVarSendIQFlow, anonymousClass1);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        return (IQ) objX;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }
}
