package cu.todus.android.xmpp.managers;

import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.di.MainModule;
import cu.todus.android.downloadOffline.DownloadOfflineUtility;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.xmpp.StanzaListenerManager;
import cu.todus.android.xmpp.XMPPInlinesKt;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import pe.o0;
import pe.w0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 =2\u00020\u0001:\u0001=BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H¦@¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b!\u0010 R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b%\u0010 R$\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\b028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00101R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u0002098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcu/todus/android/xmpp/managers/IMManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "", "", "blockRoom", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "<init>", "(Llb/a;Llb/a;Ljava/util/Map;Llb/a;)V", "Lua/k0;", "resetConfirmationDebounceTimer", "()V", "sendOfflineIdsBatch", "Lorg/jivesoftware/smack/packet/Stanza;", "stanza", "stanzaProcess", "(Lorg/jivesoftware/smack/packet/Stanza;Lab/e;)Ljava/lang/Object;", "startManager", "stopManager", "Lorg/jivesoftware/smack/packet/Message;", "acceptCondition", "(Lorg/jivesoftware/smack/packet/Message;)Z", "stanzaId", "addOfflineReceivedIds", "(Ljava/lang/String;)V", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Ljava/util/Map;", "getBlockRoom", "()Ljava/util/Map;", "getOwner", "Lpe/m0;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "coroutineScope", "Lpe/m0;", "getCoroutineScope", "()Lpe/m0;", "Lre/g;", "stanzaQueue", "Lre/g;", "Lpe/a2;", "stanzaProcessingJob", "Lpe/a2;", "", "incomingOfflineMessageIds", "Ljava/util/List;", "confirmationDebounceJob", "Lorg/jivesoftware/smack/StanzaListener;", "stanzaListener", "Lorg/jivesoftware/smack/StanzaListener;", "Lorg/jivesoftware/smack/filter/AndFilter;", "getFilter", "()Lorg/jivesoftware/smack/filter/AndFilter;", "filter", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class IMManager implements StanzaListenerManager {
    private static final int BATCH_SIZE_LIMIT = 60;
    private static final long DEBOUNCE_TIME_MS = 2000;
    private static final String TAG = "IMManager_Debug";
    private static final String TAG2 = "IMManager_Debug_Completion";
    private final Map<String, Boolean> blockRoom;
    private final lb.a canSend;
    private a2 confirmationDebounceJob;
    private m0 coroutineScope;
    private final List<String> incomingOfflineMessageIds;
    private final lb.a mXMPPConnection;
    private final lb.a owner;
    private final StanzaListener stanzaListener;
    private a2 stanzaProcessingJob;
    private final re.g stanzaQueue;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.IMManager$resetConfirmationDebounceTimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.IMManager$resetConfirmationDebounceTimer$1", f = "IMManager.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = IMManager.this.new AnonymousClass1(eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            m0 m0Var = (m0) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.L$0 = m0Var;
                this.label = 1;
                if (w0.b(2000L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            if (kotlin.jvm.internal.y.d(m0Var.getCoroutineContext().get(a2.f40774e), IMManager.this.confirmationDebounceJob)) {
                Log.i(IMManager.TAG, "Confirmation debounce timer fired (2000 ms). Sending batch.");
                IMManager.this.sendOfflineIdsBatch();
            } else {
                cb.b.d(Log.d(IMManager.TAG, "Confirmation debounce timer fired, but it's a STALE job. Ignoring."));
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.IMManager$sendOfflineIdsBatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.IMManager$sendOfflineIdsBatch$1", f = "IMManager.kt", l = {177}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C14531 extends cb.m implements Function1 {
        final /* synthetic */ ArrayList<String> $idsToSend;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14531(ArrayList<String> arrayList, ab.e<? super C14531> eVar) {
            super(1, eVar);
            this.$idsToSend = arrayList;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return IMManager.this.new C14531(this.$idsToSend, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C14531) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) IMManager.this.getMXMPPConnection().invoke();
                if (xMPPTCPConnection != null) {
                    ArrayList<String> arrayList = this.$idsToSend;
                    this.label = 1;
                    obj = XMPPInlinesKt.sendOfflineReceivedIds(xMPPTCPConnection, arrayList, this);
                    if (obj == objG) {
                        return objG;
                    }
                }
                Log.i(IMManager.TAG, "sendOfflineIdsBatch(): SUCCESS - Sent batch of " + this.$idsToSend.size() + " IDs.");
                return k0.f43947a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            ((Boolean) obj).getClass();
            Log.i(IMManager.TAG, "sendOfflineIdsBatch(): SUCCESS - Sent batch of " + this.$idsToSend.size() + " IDs.");
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.IMManager$startManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.IMManager$startManager$1", f = "IMManager.kt", l = {70, 73}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C14541 extends cb.m implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        public C14541(ab.e<? super C14541> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return IMManager.this.new C14541(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0049  */
        /* JADX WARN: Code duplicated, block: B:21:0x0053  */
        /* JADX WARN: Code duplicated, block: B:30:0x0090  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
        
            if (r9.stanzaProcess(r1, r8) == r0) goto L24;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0069 -> B:8:0x0019). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r8.L$1
                org.jivesoftware.smack.packet.Stanza r1 = (org.jivesoftware.smack.packet.Stanza) r1
                java.lang.Object r4 = r8.L$0
                re.i r4 = (re.i) r4
                ua.v.b(r9)     // Catch: java.lang.Exception -> L1b
            L19:
                r9 = r4
                goto L6c
            L1b:
                r9 = move-exception
                goto L74
            L1d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L25:
                java.lang.Object r1 = r8.L$0
                re.i r1 = (re.i) r1
                ua.v.b(r9)
                r4 = r1
                goto L4b
            L2e:
                ua.v.b(r9)
                cu.todus.android.xmpp.managers.IMManager r9 = cu.todus.android.xmpp.managers.IMManager.this
                re.g r9 = cu.todus.android.xmpp.managers.IMManager.access$getStanzaQueue$p(r9)
                re.i r9 = r9.iterator()
            L3b:
                r8.L$0 = r9
                r1 = 0
                r8.L$1 = r1
                r8.label = r3
                java.lang.Object r1 = r9.b(r8)
                if (r1 != r0) goto L49
                goto L6b
            L49:
                r4 = r9
                r9 = r1
            L4b:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L90
                java.lang.Object r9 = r4.next()
                r1 = r9
                org.jivesoftware.smack.packet.Stanza r1 = (org.jivesoftware.smack.packet.Stanza) r1
                r1.getStanzaId()
                cu.todus.android.xmpp.managers.IMManager r9 = cu.todus.android.xmpp.managers.IMManager.this     // Catch: java.lang.Exception -> L1b
                r8.L$0 = r4     // Catch: java.lang.Exception -> L1b
                r8.L$1 = r1     // Catch: java.lang.Exception -> L1b
                r8.label = r2     // Catch: java.lang.Exception -> L1b
                java.lang.Object r9 = r9.stanzaProcess(r1, r8)     // Catch: java.lang.Exception -> L1b
                if (r9 != r0) goto L19
            L6b:
                return r0
            L6c:
                r1.getStanzaId()     // Catch: java.lang.Exception -> L70
                goto L3b
            L70:
                r4 = move-exception
                r7 = r4
                r4 = r9
                r9 = r7
            L74:
                java.lang.String r1 = r1.getStanzaId()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "<- ERROR processing stanza ID: "
                r5.append(r6)
                r5.append(r1)
                java.lang.String r1 = r5.toString()
                java.lang.String r5 = "IMManager_Debug"
                android.util.Log.e(r5, r1, r9)
                r9 = r4
                goto L3b
            L90:
                ua.k0 r9 = ua.k0.f43947a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.IMManager.C14541.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C14541) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public IMManager(lb.a canSend, lb.a mXMPPConnection, Map<String, Boolean> blockRoom, lb.a owner) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(blockRoom, "blockRoom");
        kotlin.jvm.internal.y.i(owner, "owner");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.blockRoom = blockRoom;
        this.owner = owner;
        this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.stanzaQueue = re.j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.incomingOfflineMessageIds = new ArrayList();
        this.stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.managers.s
            @Override // org.jivesoftware.smack.StanzaListener
            public final void processStanza(Stanza stanza) {
                IMManager.stanzaListener$lambda$0(this.f28866c, stanza);
            }
        };
    }

    private final synchronized void resetConfirmationDebounceTimer() {
        try {
            a2 a2Var = this.confirmationDebounceJob;
            if (a2Var != null) {
                a2.a.a(a2Var, null, 1, null);
            }
            a2 a2VarD = pe.k.d(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            this.confirmationDebounceJob = a2VarD;
            Objects.toString(a2VarD);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void sendOfflineIdsBatch() {
        if (this.incomingOfflineMessageIds.isEmpty()) {
            try {
                DownloadOfflineUtility.INSTANCE.stopService(MainModule.INSTANCE.getInstance().getAppContext());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return;
        }
        ArrayList arrayList = new ArrayList(this.incomingOfflineMessageIds);
        this.incomingOfflineMessageIds.clear();
        Log.i(TAG, "sendOfflineIdsBatch(): Preparing to send batch of " + arrayList.size() + " IDs. [" + g0.G0(arrayList, null, null, null, 0, null, null, 63, null) + "]");
        Log.i(TAG2, "sendOfflineIdsBatch(): Preparing to send batch of " + arrayList.size() + " IDs. [" + g0.G0(arrayList, null, null, null, 0, null, null, 63, null) + "]");
        CoroutineUtilsKt.launchWithContext$default(n0.a(d1.b()), null, null, new C14531(arrayList, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stanzaListener$lambda$0(IMManager iMManager, Stanza stanza) {
        stanza.getStanzaId();
        stanza.getStanzaId();
        iMManager.resetConfirmationDebounceTimer();
        pe.k.d(iMManager.coroutineScope, null, null, new IMManager$stanzaListener$1$1(iMManager, stanza, null), 3, null);
    }

    public final boolean acceptCondition(Message stanza) {
        kotlin.jvm.internal.y.i(stanza, "stanza");
        String toDusFrom = XMPPInlinesKt.getToDusFrom(stanza);
        if (this.blockRoom.containsKey(toDusFrom)) {
            return this.blockRoom.containsKey(toDusFrom) && stanza.getType() != Message.Type.chat;
        }
        return true;
    }

    public final synchronized void addOfflineReceivedIds(String stanzaId) {
        kotlin.jvm.internal.y.i(stanzaId, "stanzaId");
        if (this.incomingOfflineMessageIds.contains(stanzaId)) {
            Log.w(TAG, "addOfflineReceivedIds(): Ignored duplicate ID: " + stanzaId);
            return;
        }
        this.incomingOfflineMessageIds.add(stanzaId);
        this.incomingOfflineMessageIds.size();
        if (this.incomingOfflineMessageIds.size() >= 60) {
            Log.i(TAG, "addOfflineReceivedIds(): Batch size limit reached (" + this.incomingOfflineMessageIds.size() + "/60). Triggering immediate send.");
            a2 a2Var = this.confirmationDebounceJob;
            if (a2Var != null) {
                a2.a.a(a2Var, null, 1, null);
            }
            sendOfflineIdsBatch();
        } else {
            resetConfirmationDebounceTimer();
        }
    }

    public final Map<String, Boolean> getBlockRoom() {
        return this.blockRoom;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final m0 getCoroutineScope() {
        return this.coroutineScope;
    }

    public abstract AndFilter getFilter();

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public abstract Object stanzaProcess(Stanza stanza, ab.e<? super k0> eVar);

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        Log.i(TAG, "startManager(): Initializing...");
        a2 a2Var = (a2) this.coroutineScope.getCoroutineContext().get(a2.f40774e);
        if (a2Var == null || !a2Var.isActive()) {
            this.coroutineScope = n0.a(d1.b().plus(e2.b(null, 1, null)));
        }
        a2 a2VarD = pe.k.d(this.coroutineScope, null, o0.LAZY, new C14541(null), 1, null);
        this.stanzaProcessingJob = a2VarD;
        if (a2VarD != null) {
            a2VarD.start();
        }
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.addAsyncStanzaListener(this.stanzaListener, getFilter());
        }
        Log.i(TAG, "startManager(): Manager started. Listener is active.");
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        Log.i(TAG, "stopManager(): Cleaning up...");
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.removeAsyncStanzaListener(this.stanzaListener);
        }
        n0.d(this.coroutineScope, null, 1, null);
        a2 a2Var = this.confirmationDebounceJob;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
        Log.i(TAG, "stopManager(): Manager stopped and scope cancelled.");
    }
}
