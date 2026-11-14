package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.privacy.PrivacyAddGetIQ;
import cu.todus.android.xmpp.iq.privacy.PrivacyAddUpdateIQ;
import cu.todus.android.xmpp.iq.privacy.PrivacyGetIQ;
import cu.todus.android.xmpp.iq.privacy.PrivacyUpdateIQ;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import le.d0;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u0012H\u0086@¢\u0006\u0004\b\u0014\u0010\fJ(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcu/todus/android/xmpp/managers/PrivacyManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "<init>", "(Llb/a;Llb/a;)V", "Lua/y;", "", "getProfilePrivacy", "(Lab/e;)Ljava/lang/Object;", "newPrivacyOfProfilePhoto", "newPrivacyOfProfileInfo", "newPrivacyOfLast", "changeProfilePrivacy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lkotlin/Pair;", "", "getPrivacyOfAdd", AppMeasurementSdk.ConditionalUserProperty.VALUE, "excludes", "changePrivacyOfAdd", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PrivacyManager {
    public static final int $stable = 0;
    private final lb.a canSend;
    private final lb.a mXMPPConnection;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.PrivacyManager$changePrivacyOfAdd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.PrivacyManager", f = "PrivacyManager.kt", l = {59}, m = "changePrivacyOfAdd", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyManager.this.changePrivacyOfAdd(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.PrivacyManager$changeProfilePrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.PrivacyManager", f = "PrivacyManager.kt", l = {59}, m = "changeProfilePrivacy", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14871 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14871(ab.e<? super C14871> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyManager.this.changeProfilePrivacy(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.PrivacyManager$getPrivacyOfAdd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.PrivacyManager", f = "PrivacyManager.kt", l = {59}, m = "getPrivacyOfAdd", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14881 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14881(ab.e<? super C14881> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyManager.this.getPrivacyOfAdd(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.PrivacyManager$getProfilePrivacy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.PrivacyManager", f = "PrivacyManager.kt", l = {59}, m = "getProfilePrivacy", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14891 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14891(ab.e<? super C14891> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrivacyManager.this.getProfilePrivacy(this);
        }
    }

    public PrivacyManager(lb.a canSend, lb.a mXMPPConnection) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object changePrivacyOfAdd$default(PrivacyManager privacyManager, String str, List list, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = va.w.n();
        }
        return privacyManager.changePrivacyOfAdd(str, list, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object changePrivacyOfAdd(String str, List<String> list, ab.e<? super Boolean> eVar) {
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
        Object objX = anonymousClass1.result;
        Object objG = bb.b.g();
        int i11 = anonymousClass1.label;
        boolean z10 = true;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    PrivacyAddUpdateIQ privacyAddUpdateIQ = new PrivacyAddUpdateIQ(str, list);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, privacyAddUpdateIQ);
                    anonymousClass1.L$0 = cb.l.a(str);
                    anonymousClass1.L$1 = cb.l.a(list);
                    anonymousClass1.L$2 = cb.l.a(xMPPTCPConnection);
                    anonymousClass1.L$3 = cb.l.a(privacyAddUpdateIQ);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    objX = te.j.x(hVarSendIQFlow, anonymousClass1);
                    if (objX == objG) {
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
        ua.v.b(objX);
        return cb.b.a(z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object changeProfilePrivacy(String str, String str2, String str3, ab.e<? super Boolean> eVar) {
        C14871 c14871;
        if (eVar instanceof C14871) {
            c14871 = (C14871) eVar;
            int i10 = c14871.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14871.label = i10 - Integer.MIN_VALUE;
            } else {
                c14871 = new C14871(eVar);
            }
        } else {
            c14871 = new C14871(eVar);
        }
        Object objX = c14871.result;
        Object objG = bb.b.g();
        int i11 = c14871.label;
        boolean z10 = true;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    PrivacyUpdateIQ privacyUpdateIQ = new PrivacyUpdateIQ(str2, str3, str);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, privacyUpdateIQ);
                    c14871.L$0 = cb.l.a(str);
                    c14871.L$1 = cb.l.a(str2);
                    c14871.L$2 = cb.l.a(str3);
                    c14871.L$3 = cb.l.a(xMPPTCPConnection);
                    c14871.L$4 = cb.l.a(privacyUpdateIQ);
                    c14871.I$0 = 0;
                    c14871.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14871);
                    if (objX == objG) {
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
        ua.v.b(objX);
        return cb.b.a(z10);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getPrivacyOfAdd(ab.e<? super Pair<String, ? extends List<String>>> eVar) {
        C14881 c14881;
        if (eVar instanceof C14881) {
            c14881 = (C14881) eVar;
            int i10 = c14881.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14881.label = i10 - Integer.MIN_VALUE;
            } else {
                c14881 = new C14881(eVar);
            }
        } else {
            c14881 = new C14881(eVar);
        }
        Object objX = c14881.result;
        Object objG = bb.b.g();
        int i11 = c14881.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                return new Pair("error", va.w.n());
            }
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                PrivacyAddGetIQ privacyAddGetIQ = new PrivacyAddGetIQ(null, null, 3, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, privacyAddGetIQ);
                c14881.L$0 = cb.l.a(xMPPTCPConnection);
                c14881.L$1 = cb.l.a(privacyAddGetIQ);
                c14881.I$0 = 0;
                c14881.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14881);
                if (objX == objG) {
                    return objG;
                }
            }
            return new Pair("error", va.w.n());
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        PrivacyAddGetIQ privacyAddGetIQ2 = (PrivacyAddGetIQ) ((IQ) objX);
        if (privacyAddGetIQ2 != null) {
            String whoCan = privacyAddGetIQ2.getWhoCan();
            List listS0 = d0.S0(privacyAddGetIQ2.getExceptions(), new String[]{","}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listS0) {
                if (!d0.q0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            return new Pair(whoCan, arrayList);
        }
        return new Pair("error", va.w.n());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getProfilePrivacy(ab.e<? super ua.y> eVar) {
        C14891 c14891;
        if (eVar instanceof C14891) {
            c14891 = (C14891) eVar;
            int i10 = c14891.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14891.label = i10 - Integer.MIN_VALUE;
            } else {
                c14891 = new C14891(eVar);
            }
        } else {
            c14891 = new C14891(eVar);
        }
        Object objX = c14891.result;
        Object objG = bb.b.g();
        int i11 = c14891.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                return new ua.y("error", "error", "error");
            }
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                PrivacyGetIQ privacyGetIQ = new PrivacyGetIQ(null, null, null, 7, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, privacyGetIQ);
                c14891.L$0 = cb.l.a(xMPPTCPConnection);
                c14891.L$1 = cb.l.a(privacyGetIQ);
                c14891.I$0 = 0;
                c14891.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14891);
                if (objX == objG) {
                    return objG;
                }
            }
            return new ua.y("error", "error", "error");
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        PrivacyGetIQ privacyGetIQ2 = (PrivacyGetIQ) ((IQ) objX);
        if (privacyGetIQ2 != null) {
            return new ua.y(privacyGetIQ2.getInfo(), privacyGetIQ2.getLast(), privacyGetIQ2.getProfilePhoto());
        }
        return new ua.y("error", "error", "error");
    }
}
