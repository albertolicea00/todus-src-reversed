package cu.todus.android.xmpp;

import androidx.compose.ui.spatial.RectListKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.ReflectionUtil;
import cu.todus.android.xmpp.iq.call.CallStatusIQ;
import cu.todus.android.xmpp.iq.offline.OfflineElement;
import cu.todus.android.xmpp.iq.offline.SendOfflineIdIQ;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.z0;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.toDusSM.SMFilter;
import org.jivesoftware.smack.toDusSM.SMStanza;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.impl.JidCreate;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\"\b\b\u0000\u0010\u0004*\u00020\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\"\b\b\u0000\u0010\u0004*\u00020\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\t\u001a*\u0010\r\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\r\u0010\u000b\u001a\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0011\u001a\u001c\u0010\u0017\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b\u0017\u0010\u0014\u001a®\u0001\u0010&\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000420\u0010\u0006\u001a,\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u001f2(\u0010\"\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00000#H\u0086@¢\u0006\u0004\b&\u0010'\u001a!\u0010+\u001a\u00020\u0000*\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(¢\u0006\u0004\b+\u0010,\u001a\u0011\u0010/\u001a\u00020.*\u00020-¢\u0006\u0004\b/\u00100\u001a\"\u00102\u001a\u00020\u0015*\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020(0\u001bH\u0086@¢\u0006\u0004\b2\u00103\u001a\u0011\u00104\u001a\u00020(*\u00020-¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Lua/k0;", "removeAllXMPPConnectionListeners", "()V", "Lorg/jivesoftware/smack/packet/IQ;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "request", "Lte/h;", "sendIQFlow", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Lorg/jivesoftware/smack/packet/IQ;)Lte/h;", "suspendSendIqRequestAndWaitForResponse", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Lorg/jivesoftware/smack/packet/IQ;Lab/e;)Ljava/lang/Object;", "sendCallIQFlowNoCheckId", "suspendSendCallIQNoCheckIdRequestAndWaitForResponse", "Lorg/jivesoftware/smack/packet/Stanza;", "Lcu/todus/android/xmpp/StanzaConfirmResponse;", "sendStanzaFlowSM", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Lorg/jivesoftware/smack/packet/Stanza;)Lte/h;", "stanza", "suspendSendStanzaAndWaitForConfirm", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Lorg/jivesoftware/smack/packet/Stanza;Lab/e;)Ljava/lang/Object;", "", "sendStanzaFlowDEPRE", "suspendSendStanzaAndWaitForConfirmDEPRE", "Lkotlin/Function3;", "", "Lab/e;", "", "", DataLayout.ELEMENT, "pageSize", "", DelayInformation.ELEMENT, "Lkotlin/Function2;", "onPageResult", "Lkotlin/Function0;", "onComplete", "onError", "recursivePagingRequest", "(Lkotlin/jvm/functions/Function3;IIJLkotlin/jvm/functions/Function2;Llb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "", "ownerId", "id", "sendSMACK", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Ljava/lang/String;Ljava/lang/String;)V", "Lorg/jivesoftware/smack/packet/Message;", "Ljava/util/Date;", "createDateTime", "(Lorg/jivesoftware/smack/packet/Message;)Ljava/util/Date;", "ids", "sendOfflineReceivedIds", "(Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "getToDusFrom", "(Lorg/jivesoftware/smack/packet/Message;)Ljava/lang/String;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class XMPPInlinesKt {

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$recursivePagingRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt", f = "XMPPInlines.kt", l = {412, 431, 438, 440, 442}, m = "recursivePagingRequest", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1<T> extends cb.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPInlinesKt.recursivePagingRequest(null, 0, 0, 0L, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1", f = "XMPPInlines.kt", l = {255}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/jivesoftware/smack/packet/IQ;", ExifInterface.GPS_DIRECTION_TRUE, "Lre/u;", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13761 extends cb.m implements Function2 {

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ IQ $request;
        final /* synthetic */ XMPPTCPConnection $this_sendCallIQFlowNoCheckId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1$1", f = "XMPPInlines.kt", l = {169, 170}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02671 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02671(re.u uVar, ab.e<? super C02671> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02671(this.$$this$callbackFlow, eVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, null, r7) == r0) goto L15;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = bb.b.g()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 0
                    r4 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r4) goto L1b
                    if (r1 != r2) goto L13
                    ua.v.b(r8)
                    goto L38
                L13:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1b:
                    ua.v.b(r8)
                    goto L2d
                L1f:
                    ua.v.b(r8)
                    r7.label = r4
                    r5 = 3000(0xbb8, double:1.482E-320)
                    java.lang.Object r8 = pe.w0.b(r5, r7)
                    if (r8 != r0) goto L2d
                    goto L37
                L2d:
                    re.u r8 = r7.$$this$callbackFlow
                    r7.label = r2
                    java.lang.Object r8 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, r3, r7)
                    if (r8 != r0) goto L38
                L37:
                    return r0
                L38:
                    re.u r8 = r7.$$this$callbackFlow
                    re.w.a.a(r8, r3, r4, r3)
                    ua.k0 r8 = ua.k0.f43947a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPInlinesKt.C13761.C02671.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02671) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$1$2", f = "XMPPInlines.kt", l = {246}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            final /* synthetic */ m0 $tickTack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(re.u uVar, m0 m0Var, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
                this.$tickTack = m0Var;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$$this$callbackFlow, this.$tickTack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    re.u uVar = this.$$this$callbackFlow;
                    this.label = 1;
                    if (CoroutineUtilsKt.sendWithPrecautions(uVar, null, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                C13761.invokeSuspend$close(this.$tickTack, this.$$this$callbackFlow);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;TT;Lab/e<-Lcu/todus/android/xmpp/XMPPInlinesKt$sendCallIQFlowNoCheckId$1;>;)V */
        public C13761(XMPPTCPConnection xMPPTCPConnection, IQ iq, ab.e eVar) {
            super(2, eVar);
            this.$this_sendCallIQFlowNoCheckId = xMPPTCPConnection;
            this.$request = iq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T extends IQ> void invokeSuspend$close(m0 m0Var, re.u uVar) {
            n0.d(m0Var, null, 1, null);
            re.w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !z0.b(CallStatusIQ.class).p(stanza)) {
                return;
            }
            try {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendCallIQFlowNoCheckId$1$stanzaListener$1$1(uVar, (IQ) stanza, m0Var2, null), 3, null);
            } catch (Exception unused) {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendCallIQFlowNoCheckId$1$stanzaListener$1$3(uVar, m0Var2, null), 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !z0.b(CallStatusIQ.class).p(stanza)) {
                return;
            }
            try {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendCallIQFlowNoCheckId$1$groupChatListener$1$1(uVar, (IQ) stanza, m0Var2, null), 3, null);
            } catch (Exception unused) {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendCallIQFlowNoCheckId$1$groupChatListener$1$2(uVar, m0Var2, null), 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !z0.b(CallStatusIQ.class).p(stanza)) {
                return;
            }
            pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendCallIQFlowNoCheckId$1$errorStanzaListener$1$1(uVar, m0Var2, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$3(XMPPTCPConnection xMPPTCPConnection, StanzaListener stanzaListener, StanzaListener stanzaListener2, StanzaListener stanzaListener3, m0 m0Var) {
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener);
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener2);
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener3);
            n0.d(m0Var, null, 1, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13761 c13761 = new C13761(this.$this_sendCallIQFlowNoCheckId, this.$request, eVar);
            c13761.L$0 = obj;
            return c13761;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final re.u uVar = (re.u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                final m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
                final m0 m0VarA2 = n0.a(d1.b().plus(e2.b(null, 1, null)));
                pe.k.d(m0VarA2, null, null, new C02671(uVar, null), 3, null);
                final StanzaListener stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.w
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13761.invokeSuspend$lambda$0(m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                final StanzaListener stanzaListener2 = new StanzaListener() { // from class: cu.todus.android.xmpp.x
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13761.invokeSuspend$lambda$1(m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                final StanzaListener stanzaListener3 = new StanzaListener() { // from class: cu.todus.android.xmpp.y
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13761.invokeSuspend$lambda$2(m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                StanzaFilter stanzaFilter = IQTypeFilter.RESULT;
                StanzaFilter stanzaFilter2 = MessageTypeFilter.GROUPCHAT;
                StanzaFilter stanzaFilter3 = IQTypeFilter.ERROR;
                try {
                    this.$this_sendCallIQFlowNoCheckId.addAsyncStanzaListener(stanzaListener3, stanzaFilter3);
                    this.$this_sendCallIQFlowNoCheckId.addAsyncStanzaListener(stanzaListener2, stanzaFilter2);
                    this.$this_sendCallIQFlowNoCheckId.addAsyncStanzaListener(stanzaListener, stanzaFilter);
                    this.$this_sendCallIQFlowNoCheckId.sendStanza(this.$request);
                } catch (Exception unused) {
                    pe.k.d(m0VarA, null, null, new AnonymousClass2(uVar, m0VarA2, null), 3, null);
                }
                final XMPPTCPConnection xMPPTCPConnection = this.$this_sendCallIQFlowNoCheckId;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.xmpp.z
                    @Override // lb.a
                    public final Object invoke() {
                        return XMPPInlinesKt.C13761.invokeSuspend$lambda$3(xMPPTCPConnection, stanzaListener, stanzaListener2, stanzaListener3, m0VarA);
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.L$1 = cb.l.a(m0VarA);
                this.L$2 = cb.l.a(m0VarA2);
                this.L$3 = cb.l.a(stanzaListener);
                this.L$4 = cb.l.a(stanzaListener2);
                this.L$5 = cb.l.a(stanzaListener3);
                this.L$6 = cb.l.a(stanzaFilter);
                this.L$7 = cb.l.a(stanzaFilter2);
                this.L$8 = cb.l.a(stanzaFilter3);
                this.label = 1;
                if (re.s.a(uVar, aVar, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(re.u uVar, ab.e<? super k0> eVar) {
            return ((C13761) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendCallIQFlowNoCheckId$2", f = "XMPPInlines.kt", l = {262}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lorg/jivesoftware/smack/packet/IQ;", ExifInterface.GPS_DIRECTION_TRUE, "Lte/i;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.i iVar = (te.i) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.L$0 = cb.l.a(iVar);
                this.label = 1;
                if (iVar.emit(null, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar);
            anonymousClass2.L$0 = iVar;
            return anonymousClass2.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1", f = "XMPPInlines.kt", l = {148}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/jivesoftware/smack/packet/IQ;", ExifInterface.GPS_DIRECTION_TRUE, "Lre/u;", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13771 extends cb.m implements Function2 {

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ IQ $request;
        final /* synthetic */ XMPPTCPConnection $this_sendIQFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1$1", f = "XMPPInlines.kt", l = {RectListKt.BitOffsetForGesturable, 63}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02681 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02681(re.u uVar, ab.e<? super C02681> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02681(this.$$this$callbackFlow, eVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, null, r7) == r0) goto L15;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = bb.b.g()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 0
                    r4 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r4) goto L1b
                    if (r1 != r2) goto L13
                    ua.v.b(r8)
                    goto L38
                L13:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1b:
                    ua.v.b(r8)
                    goto L2d
                L1f:
                    ua.v.b(r8)
                    r7.label = r4
                    r5 = 10000(0x2710, double:4.9407E-320)
                    java.lang.Object r8 = pe.w0.b(r5, r7)
                    if (r8 != r0) goto L2d
                    goto L37
                L2d:
                    re.u r8 = r7.$$this$callbackFlow
                    r7.label = r2
                    java.lang.Object r8 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, r3, r7)
                    if (r8 != r0) goto L38
                L37:
                    return r0
                L38:
                    re.u r8 = r7.$$this$callbackFlow
                    re.w.a.a(r8, r3, r4, r3)
                    ua.k0 r8 = ua.k0.f43947a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPInlinesKt.C13771.C02681.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02681) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$1$2", f = "XMPPInlines.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            final /* synthetic */ m0 $tickTack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(re.u uVar, m0 m0Var, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
                this.$tickTack = m0Var;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$$this$callbackFlow, this.$tickTack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    re.u uVar = this.$$this$callbackFlow;
                    this.label = 1;
                    if (CoroutineUtilsKt.sendWithPrecautions(uVar, null, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                C13771.invokeSuspend$close(this.$tickTack, this.$$this$callbackFlow);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;TT;Lab/e<-Lcu/todus/android/xmpp/XMPPInlinesKt$sendIQFlow$1;>;)V */
        public C13771(XMPPTCPConnection xMPPTCPConnection, IQ iq, ab.e eVar) {
            super(2, eVar);
            this.$this_sendIQFlow = xMPPTCPConnection;
            this.$request = iq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T extends IQ> void invokeSuspend$close(m0 m0Var, re.u uVar) {
            n0.d(m0Var, null, 1, null);
            re.w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(IQ iq, m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !kotlin.jvm.internal.y.d(stanza.getStanzaId(), iq.getStanzaId())) {
                return;
            }
            try {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendIQFlow$1$stanzaListener$1$1(uVar, (IQ) stanza, m0Var2, null), 3, null);
            } catch (Exception unused) {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendIQFlow$1$stanzaListener$1$2(uVar, m0Var2, null), 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(IQ iq, m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !kotlin.jvm.internal.y.d(stanza.getStanzaId(), iq.getStanzaId())) {
                return;
            }
            try {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendIQFlow$1$groupChatListener$1$1(uVar, (IQ) stanza, m0Var2, null), 3, null);
            } catch (Exception unused) {
                pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendIQFlow$1$groupChatListener$1$2(uVar, m0Var2, null), 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(IQ iq, m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            if (stanza == null || !kotlin.jvm.internal.y.d(stanza.getStanzaId(), iq.getStanzaId())) {
                return;
            }
            pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendIQFlow$1$errorStanzaListener$1$1(uVar, m0Var2, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$3(XMPPTCPConnection xMPPTCPConnection, StanzaListener stanzaListener, StanzaListener stanzaListener2, StanzaListener stanzaListener3, m0 m0Var) {
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener);
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener2);
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener3);
            n0.d(m0Var, null, 1, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13771 c13771 = new C13771(this.$this_sendIQFlow, this.$request, eVar);
            c13771.L$0 = obj;
            return c13771;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final re.u uVar = (re.u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                final m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
                final m0 m0VarA2 = n0.a(d1.b().plus(e2.b(null, 1, null)));
                pe.k.d(m0VarA2, null, null, new C02681(uVar, null), 3, null);
                final IQ iq = this.$request;
                final StanzaListener stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.a0
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13771.invokeSuspend$lambda$0(iq, m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                final IQ iq2 = this.$request;
                final StanzaListener stanzaListener2 = new StanzaListener() { // from class: cu.todus.android.xmpp.b0
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13771.invokeSuspend$lambda$1(iq2, m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                final IQ iq3 = this.$request;
                final StanzaListener stanzaListener3 = new StanzaListener() { // from class: cu.todus.android.xmpp.c0
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza) {
                        XMPPInlinesKt.C13771.invokeSuspend$lambda$2(iq3, m0VarA, uVar, m0VarA2, stanza);
                    }
                };
                StanzaFilter stanzaFilter = IQTypeFilter.RESULT;
                StanzaFilter stanzaFilter2 = MessageTypeFilter.GROUPCHAT;
                StanzaFilter stanzaFilter3 = IQTypeFilter.ERROR;
                try {
                    this.$this_sendIQFlow.addAsyncStanzaListener(stanzaListener3, stanzaFilter3);
                    this.$this_sendIQFlow.addAsyncStanzaListener(stanzaListener2, stanzaFilter2);
                    this.$this_sendIQFlow.addAsyncStanzaListener(stanzaListener, stanzaFilter);
                    this.$this_sendIQFlow.sendStanza(this.$request);
                } catch (Exception unused) {
                    pe.k.d(m0VarA, null, null, new AnonymousClass2(uVar, m0VarA2, null), 3, null);
                }
                final XMPPTCPConnection xMPPTCPConnection = this.$this_sendIQFlow;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.xmpp.d0
                    @Override // lb.a
                    public final Object invoke() {
                        return XMPPInlinesKt.C13771.invokeSuspend$lambda$3(xMPPTCPConnection, stanzaListener, stanzaListener2, stanzaListener3, m0VarA);
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.L$1 = cb.l.a(m0VarA);
                this.L$2 = cb.l.a(m0VarA2);
                this.L$3 = cb.l.a(stanzaListener);
                this.L$4 = cb.l.a(stanzaListener2);
                this.L$5 = cb.l.a(stanzaListener3);
                this.L$6 = cb.l.a(stanzaFilter);
                this.L$7 = cb.l.a(stanzaFilter2);
                this.L$8 = cb.l.a(stanzaFilter3);
                this.label = 1;
                if (re.s.a(uVar, aVar, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(re.u uVar, ab.e<? super k0> eVar) {
            return ((C13771) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendIQFlow$2", f = "XMPPInlines.kt", l = {WebmConstants.MkvEbmlElement.BLOCK_DURATION}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lorg/jivesoftware/smack/packet/IQ;", ExifInterface.GPS_DIRECTION_TRUE, "Lte/i;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13782 extends cb.m implements Function3 {
        private /* synthetic */ Object L$0;
        int label;

        public C13782(ab.e<? super C13782> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.i iVar = (te.i) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.L$0 = cb.l.a(iVar);
                this.label = 1;
                if (iVar.emit(null, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            C13782 c13782 = new C13782(eVar);
            c13782.L$0 = iVar;
            return c13782.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1", f = "XMPPInlines.kt", l = {388}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13791 extends cb.m implements Function2 {
        final /* synthetic */ Stanza $request;
        final /* synthetic */ XMPPTCPConnection $this_sendStanzaFlowDEPRE;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1$1", f = "XMPPInlines.kt", l = {353, 354}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02691 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02691(re.u uVar, ab.e<? super C02691> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02691(this.$$this$callbackFlow, eVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, null, r7) == r0) goto L15;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = bb.b.g()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 0
                    r4 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r4) goto L1b
                    if (r1 != r2) goto L13
                    ua.v.b(r8)
                    goto L38
                L13:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1b:
                    ua.v.b(r8)
                    goto L2d
                L1f:
                    ua.v.b(r8)
                    r7.label = r4
                    r5 = 10000(0x2710, double:4.9407E-320)
                    java.lang.Object r8 = pe.w0.b(r5, r7)
                    if (r8 != r0) goto L2d
                    goto L37
                L2d:
                    re.u r8 = r7.$$this$callbackFlow
                    r7.label = r2
                    java.lang.Object r8 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r8, r3, r7)
                    if (r8 != r0) goto L38
                L37:
                    return r0
                L38:
                    re.u r8 = r7.$$this$callbackFlow
                    re.w.a.a(r8, r3, r4, r3)
                    ua.k0 r8 = ua.k0.f43947a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPInlinesKt.C13791.C02691.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02691) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$1$2", f = "XMPPInlines.kt", l = {379}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            final /* synthetic */ m0 $tickTack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(re.u uVar, m0 m0Var, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
                this.$tickTack = m0Var;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$$this$callbackFlow, this.$tickTack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    re.u uVar = this.$$this$callbackFlow;
                    Boolean boolA = cb.b.a(false);
                    this.label = 1;
                    if (CoroutineUtilsKt.sendWithPrecautions(uVar, boolA, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                C13791.invokeSuspend$close(this.$tickTack, this.$$this$callbackFlow);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13791(Stanza stanza, XMPPTCPConnection xMPPTCPConnection, ab.e<? super C13791> eVar) {
            super(2, eVar);
            this.$request = stanza;
            this.$this_sendStanzaFlowDEPRE = xMPPTCPConnection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(m0 m0Var, re.u uVar) {
            n0.d(m0Var, null, 1, null);
            re.w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza) {
            pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendStanzaFlowDEPRE$1$stanzaListener$1$1(uVar, m0Var2, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(XMPPTCPConnection xMPPTCPConnection, StanzaListener stanzaListener, m0 m0Var) {
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener);
            n0.d(m0Var, null, 1, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13791 c13791 = new C13791(this.$request, this.$this_sendStanzaFlowDEPRE, eVar);
            c13791.L$0 = obj;
            return c13791;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final re.u uVar = (re.u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                final m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
                final m0 m0VarA2 = n0.a(d1.b().plus(e2.b(null, 1, null)));
                pe.k.d(m0VarA2, null, null, new C02691(uVar, null), 3, null);
                Stanza stanza = this.$request;
                if (stanza instanceof Message) {
                    Message message = (Message) stanza;
                    EntityFullJid user = this.$this_sendStanzaFlowDEPRE.getUser();
                    message.setFrom(user != null ? user.asEntityBareJid() : null);
                }
                final StanzaListener stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.e0
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza2) {
                        XMPPInlinesKt.C13791.invokeSuspend$lambda$0(m0VarA, uVar, m0VarA2, stanza2);
                    }
                };
                try {
                    this.$this_sendStanzaFlowDEPRE.addStanzaIdAcknowledgedListener(this.$request.getStanzaId(), stanzaListener);
                    this.$this_sendStanzaFlowDEPRE.sendStanza(this.$request);
                } catch (Exception unused) {
                    pe.k.d(m0VarA, null, null, new AnonymousClass2(uVar, m0VarA2, null), 3, null);
                }
                final XMPPTCPConnection xMPPTCPConnection = this.$this_sendStanzaFlowDEPRE;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.xmpp.f0
                    @Override // lb.a
                    public final Object invoke() {
                        return XMPPInlinesKt.C13791.invokeSuspend$lambda$1(xMPPTCPConnection, stanzaListener, m0VarA);
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.L$1 = cb.l.a(m0VarA);
                this.L$2 = cb.l.a(m0VarA2);
                this.L$3 = cb.l.a(stanzaListener);
                this.label = 1;
                if (re.s.a(uVar, aVar, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(re.u uVar, ab.e<? super k0> eVar) {
            return ((C13791) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowDEPRE$2", f = "XMPPInlines.kt", l = {394}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13802 extends cb.m implements Function3 {
        private /* synthetic */ Object L$0;
        int label;

        public C13802(ab.e<? super C13802> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.i iVar = (te.i) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.L$0 = cb.l.a(iVar);
                this.label = 1;
                if (iVar.emit(null, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            C13802 c13802 = new C13802(eVar);
            c13802.L$0 = iVar;
            return c13802.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1", f = "XMPPInlines.kt", l = {333}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lre/u;", "Lcu/todus/android/xmpp/StanzaConfirmResponse;", "Lua/k0;", "<anonymous>", "(Lre/u;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13811 extends cb.m implements Function2 {
        final /* synthetic */ Stanza $request;
        final /* synthetic */ XMPPTCPConnection $this_sendStanzaFlowSM;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1$1", f = "XMPPInlines.kt", l = {278, 279}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02701 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02701(re.u uVar, ab.e<? super C02701> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02701(this.$$this$callbackFlow, eVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
            
                if (cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r7, r1, r6) == r0) goto L15;
             */
            @Override // cb.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = bb.b.g()
                    int r1 = r6.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    ua.v.b(r7)
                    goto L39
                L12:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1a:
                    ua.v.b(r7)
                    goto L2c
                L1e:
                    ua.v.b(r7)
                    r6.label = r3
                    r4 = 10000(0x2710, double:4.9407E-320)
                    java.lang.Object r7 = pe.w0.b(r4, r6)
                    if (r7 != r0) goto L2c
                    goto L38
                L2c:
                    re.u r7 = r6.$$this$callbackFlow
                    cu.todus.android.xmpp.StanzaConfirmResponse r1 = cu.todus.android.xmpp.StanzaConfirmResponse.TIMEOUT
                    r6.label = r2
                    java.lang.Object r7 = cu.todus.android.utils.CoroutineUtilsKt.sendWithPrecautions(r7, r1, r6)
                    if (r7 != r0) goto L39
                L38:
                    return r0
                L39:
                    re.u r7 = r6.$$this$callbackFlow
                    r0 = 0
                    re.w.a.a(r7, r0, r3, r0)
                    ua.k0 r7 = ua.k0.f43947a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPInlinesKt.C13811.C02701.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02701) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$1$2", f = "XMPPInlines.kt", l = {323}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ re.u $$this$callbackFlow;
            final /* synthetic */ m0 $tickTack;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(re.u uVar, m0 m0Var, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$$this$callbackFlow = uVar;
                this.$tickTack = m0Var;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$$this$callbackFlow, this.$tickTack, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    ua.v.b(obj);
                    re.u uVar = this.$$this$callbackFlow;
                    StanzaConfirmResponse stanzaConfirmResponse = StanzaConfirmResponse.ERROR;
                    this.label = 1;
                    if (CoroutineUtilsKt.sendWithPrecautions(uVar, stanzaConfirmResponse, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
                C13811.invokeSuspend$close(this.$tickTack, this.$$this$callbackFlow);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13811(XMPPTCPConnection xMPPTCPConnection, Stanza stanza, ab.e<? super C13811> eVar) {
            super(2, eVar);
            this.$this_sendStanzaFlowSM = xMPPTCPConnection;
            this.$request = stanza;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$close(m0 m0Var, re.u uVar) {
            n0.d(m0Var, null, 1, null);
            re.w.a.a(uVar.getChannel(), null, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(Stanza stanza, m0 m0Var, re.u uVar, m0 m0Var2, Stanza stanza2) {
            String stanzaId = "";
            try {
                if (stanza instanceof Message) {
                    stanzaId = ((Message) stanza).getStanzaId();
                } else if (stanza instanceof SMStanza) {
                    stanzaId = ((SMStanza) stanza).msgId;
                }
            } catch (Exception unused) {
            }
            if (stanza2 != null && (stanza2 instanceof SMStanza) && kotlin.jvm.internal.y.d(((SMStanza) stanza2).msgId, stanzaId)) {
                try {
                    pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendStanzaFlowSM$1$stanzaListener$1$1(uVar, m0Var2, null), 3, null);
                } catch (Exception unused2) {
                    pe.k.d(m0Var, null, null, new XMPPInlinesKt$sendStanzaFlowSM$1$stanzaListener$1$2(uVar, m0Var2, null), 3, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(XMPPTCPConnection xMPPTCPConnection, StanzaListener stanzaListener, m0 m0Var) {
            xMPPTCPConnection.removeAsyncStanzaListener(stanzaListener);
            n0.d(m0Var, null, 1, null);
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C13811 c13811 = new C13811(this.$this_sendStanzaFlowSM, this.$request, eVar);
            c13811.L$0 = obj;
            return c13811;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            final re.u uVar = (re.u) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                final m0 m0VarA = n0.a(d1.b().plus(e2.b(null, 1, null)));
                final m0 m0VarA2 = n0.a(d1.b().plus(e2.b(null, 1, null)));
                pe.k.d(m0VarA2, null, null, new C02701(uVar, null), 3, null);
                final Stanza stanza = this.$request;
                final StanzaListener stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.g0
                    @Override // org.jivesoftware.smack.StanzaListener
                    public final void processStanza(Stanza stanza2) {
                        XMPPInlinesKt.C13811.invokeSuspend$lambda$0(stanza, m0VarA, uVar, m0VarA2, stanza2);
                    }
                };
                try {
                    this.$this_sendStanzaFlowSM.addAsyncStanzaListener(stanzaListener, new SMFilter());
                    this.$this_sendStanzaFlowSM.sendStanza(this.$request);
                } catch (Exception e10) {
                    pe.k.d(m0VarA, null, null, new AnonymousClass2(uVar, m0VarA2, null), 3, null);
                    if (e10 instanceof SmackException.NotConnectedException) {
                        e10.printStackTrace();
                    }
                }
                final XMPPTCPConnection xMPPTCPConnection = this.$this_sendStanzaFlowSM;
                lb.a aVar = new lb.a() { // from class: cu.todus.android.xmpp.h0
                    @Override // lb.a
                    public final Object invoke() {
                        return XMPPInlinesKt.C13811.invokeSuspend$lambda$1(xMPPTCPConnection, stanzaListener, m0VarA);
                    }
                };
                this.L$0 = cb.l.a(uVar);
                this.L$1 = cb.l.a(m0VarA);
                this.L$2 = cb.l.a(m0VarA2);
                this.L$3 = cb.l.a(stanzaListener);
                this.label = 1;
                if (re.s.a(uVar, aVar, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(re.u uVar, ab.e<? super k0> eVar) {
            return ((C13811) create(uVar, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt$sendStanzaFlowSM$2", f = "XMPPInlines.kt", l = {338}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/xmpp/StanzaConfirmResponse;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13822 extends cb.m implements Function3 {
        private /* synthetic */ Object L$0;
        int label;

        public C13822(ab.e<? super C13822> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            te.i iVar = (te.i) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                StanzaConfirmResponse stanzaConfirmResponse = StanzaConfirmResponse.ERROR;
                this.L$0 = cb.l.a(iVar);
                this.label = 1;
                if (iVar.emit(stanzaConfirmResponse, this) == objG) {
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

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            C13822 c13822 = new C13822(eVar);
            c13822.L$0 = iVar;
            return c13822.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$suspendSendStanzaAndWaitForConfirm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt", f = "XMPPInlines.kt", l = {342}, m = "suspendSendStanzaAndWaitForConfirm", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13831 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13831(ab.e<? super C13831> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPInlinesKt.suspendSendStanzaAndWaitForConfirm(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.XMPPInlinesKt$suspendSendStanzaAndWaitForConfirmDEPRE$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.XMPPInlinesKt", f = "XMPPInlines.kt", l = {399}, m = "suspendSendStanzaAndWaitForConfirmDEPRE", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13841 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13841(ab.e<? super C13841> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XMPPInlinesKt.suspendSendStanzaAndWaitForConfirmDEPRE(null, null, this);
        }
    }

    public static final Date createDateTime(Message message) {
        Date stamp;
        Date stamp2;
        kotlin.jvm.internal.y.i(message, "<this>");
        Date date = new Date();
        if (message.hasExtension(DelayInformation.ELEMENT, DelayInformation.NAMESPACE)) {
            DelayInformation delayInformationFrom = DelayInformation.from(message);
            return (delayInformationFrom == null || (stamp2 = delayInformationFrom.getStamp()) == null) ? new Date() : stamp2;
        }
        if (!message.hasExtension(OfflineElement.ELEMENT, "jc")) {
            return date;
        }
        OfflineElement offlineElementFrom = OfflineElement.INSTANCE.from(message);
        return (offlineElementFrom == null || (stamp = offlineElementFrom.getStamp()) == null) ? new Date() : stamp;
    }

    public static final String getToDusFrom(Message message) {
        kotlin.jvm.internal.y.i(message, "<this>");
        if (message.getType() == Message.Type.groupchat) {
            return message.getFrom().isEntityFullJid() ? JidCreate.from(message.getFrom().getResourceOrEmpty()).toString() : message.getFrom().toString();
        }
        return message.getFrom().asEntityBareJidIfPossible().toString();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0075 A[PHI: r0 r3 r5 r7 r8 r9 r10 r12
      0x0075: PHI (r0v10 int) = (r0v9 int), (r0v23 int) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r3v8 int) = (r3v7 int), (r3v13 int) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r5v3 long) = (r5v2 long), (r5v6 long) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r7v3 java.util.List) = (r7v2 java.util.List), (r7v6 java.util.List) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r8v5 lb.a) = (r8v4 lb.a), (r8v12 lb.a) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r9v3 lb.a) = (r9v2 lb.a), (r9v8 lb.a) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r10v6 kotlin.jvm.functions.Function2) = (r10v5 kotlin.jvm.functions.Function2), (r10v15 kotlin.jvm.functions.Function2) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r12v4 kotlin.jvm.functions.Function3) = (r12v3 kotlin.jvm.functions.Function3), (r12v13 kotlin.jvm.functions.Function3) binds: [B:52:0x01aa, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01e0, code lost:
    
        if (recursivePagingRequest$default(r12, r4, r5, 0, r16, r9, r10, r11, 8, null) == r2) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object recursivePagingRequest(kotlin.jvm.functions.Function3 r18, int r19, int r20, long r21, kotlin.jvm.functions.Function2 r23, lb.a r24, lb.a r25, ab.e<? super ua.k0> r26) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.XMPPInlinesKt.recursivePagingRequest(kotlin.jvm.functions.Function3, int, int, long, kotlin.jvm.functions.Function2, lb.a, lb.a, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object recursivePagingRequest$default(Function3 function3, int i10, int i11, long j10, Function2 function2, lb.a aVar, lb.a aVar2, ab.e eVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 10;
        }
        if ((i12 & 8) != 0) {
            j10 = 250;
        }
        if ((i12 & 64) != 0) {
            aVar2 = new lb.a() { // from class: cu.todus.android.xmpp.v
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
        }
        long j11 = j10;
        return recursivePagingRequest(function3, i10, i11, j11, function2, aVar, aVar2, eVar);
    }

    public static final void removeAllXMPPConnectionListeners() throws IllegalAccessException {
        try {
            Field declaredField = XMPPConnectionRegistry.class.getDeclaredField("connectionEstablishedListeners");
            ReflectionUtil reflectionUtil = ReflectionUtil.INSTANCE;
            kotlin.jvm.internal.y.f(declaredField);
            reflectionUtil.makeAccessible(declaredField);
            Object obj = declaredField.get(null);
            kotlin.jvm.internal.y.g(obj, "null cannot be cast to non-null type java.util.concurrent.CopyOnWriteArraySet<org.jivesoftware.smack.ConnectionCreationListener>");
            ((CopyOnWriteArraySet) obj).clear();
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    public static final <T extends IQ> te.h sendCallIQFlowNoCheckId(XMPPTCPConnection xMPPTCPConnection, T request) {
        kotlin.jvm.internal.y.i(xMPPTCPConnection, "<this>");
        kotlin.jvm.internal.y.i(request, "request");
        return te.j.g(te.u.f(te.j.e(new C13761(xMPPTCPConnection, request, null)), 2L, null, 2, null), new AnonymousClass2(null));
    }

    public static final <T extends IQ> te.h sendIQFlow(XMPPTCPConnection xMPPTCPConnection, T request) {
        kotlin.jvm.internal.y.i(xMPPTCPConnection, "<this>");
        kotlin.jvm.internal.y.i(request, "request");
        return te.j.g(te.u.f(te.j.e(new C13771(xMPPTCPConnection, request, null)), 2L, null, 2, null), new C13782(null));
    }

    public static final Object sendOfflineReceivedIds(XMPPTCPConnection xMPPTCPConnection, List<String> list, ab.e<? super Boolean> eVar) {
        boolean z10;
        try {
            if (!list.isEmpty()) {
                xMPPTCPConnection.sendStanza(new SendOfflineIdIQ(list));
            }
            z10 = true;
        } catch (Exception e10) {
            e10.printStackTrace();
            z10 = false;
        }
        return cb.b.a(z10);
    }

    public static final void sendSMACK(XMPPTCPConnection xMPPTCPConnection, String ownerId, String id2) {
        kotlin.jvm.internal.y.i(xMPPTCPConnection, "<this>");
        kotlin.jvm.internal.y.i(ownerId, "ownerId");
        kotlin.jvm.internal.y.i(id2, "id");
        SMStanza sMStanza = new SMStanza(id2);
        sMStanza.setFrom(JidCreate.bareFrom(ownerId));
        try {
            xMPPTCPConnection.sendStanza(sMStanza);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @ua.e
    public static final te.h sendStanzaFlowDEPRE(XMPPTCPConnection xMPPTCPConnection, Stanza request) {
        kotlin.jvm.internal.y.i(xMPPTCPConnection, "<this>");
        kotlin.jvm.internal.y.i(request, "request");
        return te.j.g(te.u.f(te.j.e(new C13791(request, xMPPTCPConnection, null)), 2L, null, 2, null), new C13802(null));
    }

    public static final te.h sendStanzaFlowSM(XMPPTCPConnection xMPPTCPConnection, Stanza request) {
        kotlin.jvm.internal.y.i(xMPPTCPConnection, "<this>");
        kotlin.jvm.internal.y.i(request, "request");
        return te.j.g(te.u.f(te.j.e(new C13811(xMPPTCPConnection, request, null)), 2L, null, 2, null), new C13822(null));
    }

    public static final /* synthetic */ <T extends IQ> Object suspendSendCallIQNoCheckIdRequestAndWaitForResponse(XMPPTCPConnection xMPPTCPConnection, T t10, ab.e<? super T> eVar) {
        te.h hVarSendCallIQFlowNoCheckId = sendCallIQFlowNoCheckId(xMPPTCPConnection, t10);
        kotlin.jvm.internal.w.c(0);
        Object objX = te.j.x(hVarSendCallIQFlowNoCheckId, eVar);
        kotlin.jvm.internal.w.c(1);
        return (IQ) objX;
    }

    public static final /* synthetic */ <T extends IQ> Object suspendSendIqRequestAndWaitForResponse(XMPPTCPConnection xMPPTCPConnection, T t10, ab.e<? super T> eVar) {
        te.h hVarSendIQFlow = sendIQFlow(xMPPTCPConnection, t10);
        kotlin.jvm.internal.w.c(0);
        Object objX = te.j.x(hVarSendIQFlow, eVar);
        kotlin.jvm.internal.w.c(1);
        return (IQ) objX;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object suspendSendStanzaAndWaitForConfirm(XMPPTCPConnection xMPPTCPConnection, Stanza stanza, ab.e<? super StanzaConfirmResponse> eVar) {
        C13831 c13831;
        if (eVar instanceof C13831) {
            c13831 = (C13831) eVar;
            int i10 = c13831.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13831.label = i10 - Integer.MIN_VALUE;
            } else {
                c13831 = new C13831(eVar);
            }
        } else {
            c13831 = new C13831(eVar);
        }
        Object objX = c13831.result;
        Object objG = bb.b.g();
        int i11 = c13831.label;
        if (i11 == 0) {
            ua.v.b(objX);
            te.h hVarSendStanzaFlowSM = sendStanzaFlowSM(xMPPTCPConnection, stanza);
            c13831.L$0 = cb.l.a(xMPPTCPConnection);
            c13831.L$1 = cb.l.a(stanza);
            c13831.label = 1;
            objX = te.j.x(hVarSendStanzaFlowSM, c13831);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        return (StanzaConfirmResponse) objX;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @ua.e
    public static final Object suspendSendStanzaAndWaitForConfirmDEPRE(XMPPTCPConnection xMPPTCPConnection, Stanza stanza, ab.e<? super Boolean> eVar) {
        C13841 c13841;
        if (eVar instanceof C13841) {
            c13841 = (C13841) eVar;
            int i10 = c13841.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13841.label = i10 - Integer.MIN_VALUE;
            } else {
                c13841 = new C13841(eVar);
            }
        } else {
            c13841 = new C13841(eVar);
        }
        Object objX = c13841.result;
        Object objG = bb.b.g();
        int i11 = c13841.label;
        if (i11 == 0) {
            ua.v.b(objX);
            te.h hVarSendStanzaFlowDEPRE = sendStanzaFlowDEPRE(xMPPTCPConnection, stanza);
            c13841.L$0 = cb.l.a(xMPPTCPConnection);
            c13841.L$1 = cb.l.a(stanza);
            c13841.label = 1;
            objX = te.j.x(hVarSendStanzaFlowDEPRE, c13841);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        Boolean bool = (Boolean) objX;
        return cb.b.a(bool != null ? bool.booleanValue() : false);
    }
}
