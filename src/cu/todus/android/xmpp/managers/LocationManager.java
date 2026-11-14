package cu.todus.android.xmpp.managers;

import android.location.Location;
import androidx.camera.video.AudioStats;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.location.LocationDataSource;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.near.NearGetStatusIQ;
import cu.todus.android.xmpp.iq.near.NearHideIQ;
import cu.todus.android.xmpp.iq.near.NearSetIQ;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.d1;
import pe.m0;
import pe.n0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012$\u0010\u000b\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u001f\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b#\u0010\"R5\u0010\u000b\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcu/todus/android/xmpp/managers/LocationManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lkotlin/Function2;", "", "Lab/e;", "Lcu/todus/android/data/db/entity/toDus/User;", "getUserInfo", "<init>", "(Llb/a;Llb/a;Lkotlin/jvm/functions/Function2;)V", "Landroid/location/Location;", "currentPosition", "()Landroid/location/Location;", "", "latitude", "longitude", "sendNearLocation", "(DDLab/e;)Ljava/lang/Object;", "hideNearLocation", "(Lab/e;)Ljava/lang/Object;", "", DataLayout.ELEMENT, "pageSize", "", "Lcu/todus/android/data/db/pojo/NearPartner;", "getNearPage", "(IILab/e;)Ljava/lang/Object;", "getStatus", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "Lkotlin/jvm/functions/Function2;", "getGetUserInfo", "()Lkotlin/jvm/functions/Function2;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LocationManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final DatabaseModule databaseModule;
    private final Function2 getUserInfo;
    private final lb.a mXMPPConnection;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LocationManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LocationManager$1", f = "LocationManager.kt", l = {31, 32}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return LocationManager.this.new AnonymousClass1(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x003c  */
        /* JADX WARN: Code duplicated, block: B:19:0x0046  */
        /* JADX WARN: Code duplicated, block: B:20:0x004b  */
        /* JADX WARN: Code duplicated, block: B:23:0x0050  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
        
            if (r3.sendNearLocation(r4, r6, r9) == r0) goto L25;
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r10)
                goto L74
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1a:
                ua.v.b(r10)
                goto L34
            L1e:
                ua.v.b(r10)
                cu.todus.android.xmpp.managers.LocationManager r10 = cu.todus.android.xmpp.managers.LocationManager.this
                android.location.Location r10 = cu.todus.android.xmpp.managers.LocationManager.access$currentPosition(r10)
                if (r10 == 0) goto L74
                cu.todus.android.xmpp.managers.LocationManager r10 = cu.todus.android.xmpp.managers.LocationManager.this
                r9.label = r3
                java.lang.Object r10 = r10.getStatus(r9)
                if (r10 != r0) goto L34
                goto L73
            L34:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L74
                cu.todus.android.volatileState.AppVolatileState$Companion r10 = cu.todus.android.volatileState.AppVolatileState.INSTANCE
                java.lang.Object r10 = r10.getInstanceOrNull()
                cu.todus.android.volatileState.AppVolatileState r10 = (cu.todus.android.volatileState.AppVolatileState) r10
                if (r10 == 0) goto L4b
                cu.todus.android.connection.Quality r10 = r10.getOwnerConnection()
                goto L4c
            L4b:
                r10 = 0
            L4c:
                cu.todus.android.connection.Quality r1 = cu.todus.android.connection.Quality.BAD_QUALITY
                if (r10 == r1) goto L74
                cu.todus.android.xmpp.managers.LocationManager r3 = cu.todus.android.xmpp.managers.LocationManager.this
                android.location.Location r10 = cu.todus.android.xmpp.managers.LocationManager.access$currentPosition(r3)
                kotlin.jvm.internal.y.f(r10)
                double r4 = r10.getLatitude()
                cu.todus.android.xmpp.managers.LocationManager r10 = cu.todus.android.xmpp.managers.LocationManager.this
                android.location.Location r10 = cu.todus.android.xmpp.managers.LocationManager.access$currentPosition(r10)
                kotlin.jvm.internal.y.f(r10)
                double r6 = r10.getLongitude()
                r9.label = r2
                r8 = r9
                java.lang.Object r10 = r3.sendNearLocation(r4, r6, r8)
                if (r10 != r0) goto L74
            L73:
                return r0
            L74:
                ua.k0 r10 = ua.k0.f43947a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.LocationManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LocationManager$getNearPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LocationManager", f = "LocationManager.kt", l = {132, 84, 95}, m = "getNearPage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14551 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C14551(ab.e<? super C14551> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.getNearPage(0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LocationManager$getStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LocationManager", f = "LocationManager.kt", l = {132}, m = "getStatus", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14561 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14561(ab.e<? super C14561> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.getStatus(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LocationManager$hideNearLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LocationManager", f = "LocationManager.kt", l = {132}, m = "hideNearLocation", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14571 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14571(ab.e<? super C14571> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.hideNearLocation(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.LocationManager$sendNearLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.LocationManager", f = "LocationManager.kt", l = {132}, m = "sendNearLocation", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14581 extends cb.d {
        double D$0;
        double D$1;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14581(ab.e<? super C14581> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationManager.this.sendNearLocation(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, this);
        }
    }

    public LocationManager(lb.a canSend, lb.a mXMPPConnection, Function2 getUserInfo) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(getUserInfo, "getUserInfo");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.getUserInfo = getUserInfo;
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
        pe.k.d(n0.a(d1.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Location currentPosition() {
        return LocationDataSource.INSTANCE.getInstance().currentLocation();
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final Function2 getGetUserInfo() {
        return this.getUserInfo;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0178  */
    /* JADX WARN: Code duplicated, block: B:35:0x0182  */
    /* JADX WARN: Code duplicated, block: B:39:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:42:0x0201  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0201 -> B:52:0x02de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0290 -> B:47:0x0298). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getNearPage(int r27, int r28, ab.e<? super java.util.List<cu.todus.android.data.db.pojo.NearPartner>> r29) {
        /*
            Method dump skipped, instruction units count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.LocationManager.getNearPage(int, int, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getStatus(ab.e<? super Boolean> eVar) {
        C14561 c14561;
        NearGetStatusIQ nearGetStatusIQ;
        if (eVar instanceof C14561) {
            c14561 = (C14561) eVar;
            int i10 = c14561.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14561.label = i10 - Integer.MIN_VALUE;
            } else {
                c14561 = new C14561(eVar);
            }
        } else {
            c14561 = new C14561(eVar);
        }
        Object objX = c14561.result;
        Object objG = bb.b.g();
        int i11 = c14561.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                nearGetStatusIQ = null;
                if (xMPPTCPConnection != null) {
                    NearGetStatusIQ nearGetStatusIQ2 = new NearGetStatusIQ(false, 1, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, nearGetStatusIQ2);
                    c14561.L$0 = cb.l.a(xMPPTCPConnection);
                    c14561.L$1 = cb.l.a(nearGetStatusIQ2);
                    c14561.I$0 = 0;
                    c14561.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14561);
                    if (objX == objG) {
                        return objG;
                    }
                }
                if (nearGetStatusIQ != null) {
                    return cb.b.a(nearGetStatusIQ.getIsShowIn());
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        nearGetStatusIQ = (NearGetStatusIQ) ((IQ) objX);
        if (nearGetStatusIQ != null) {
            return cb.b.a(nearGetStatusIQ.getIsShowIn());
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object hideNearLocation(ab.e<? super Boolean> eVar) {
        C14571 c14571;
        NearHideIQ nearHideIQ;
        Integer code;
        if (eVar instanceof C14571) {
            c14571 = (C14571) eVar;
            int i10 = c14571.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14571.label = i10 - Integer.MIN_VALUE;
            } else {
                c14571 = new C14571(eVar);
            }
        } else {
            c14571 = new C14571(eVar);
        }
        Object objX = c14571.result;
        Object objG = bb.b.g();
        int i11 = c14571.label;
        boolean z10 = false;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                nearHideIQ = null;
                if (xMPPTCPConnection != null) {
                    NearHideIQ nearHideIQ2 = new NearHideIQ(null, 1, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, nearHideIQ2);
                    c14571.L$0 = cb.l.a(xMPPTCPConnection);
                    c14571.L$1 = cb.l.a(nearHideIQ2);
                    c14571.I$0 = 0;
                    c14571.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14571);
                    if (objX == objG) {
                        return objG;
                    }
                }
                if (nearHideIQ != null) {
                    code = nearHideIQ.getCode();
                    if (code != null && code.intValue() == 200) {
                        z10 = true;
                    }
                    return cb.b.a(z10);
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        nearHideIQ = (NearHideIQ) ((IQ) objX);
        if (nearHideIQ != null) {
            code = nearHideIQ.getCode();
            if (code != null) {
                z10 = true;
            }
            return cb.b.a(z10);
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object sendNearLocation(double d10, double d11, ab.e<? super Boolean> eVar) {
        C14581 c14581;
        NearSetIQ nearSetIQ;
        Integer code;
        if (eVar instanceof C14581) {
            c14581 = (C14581) eVar;
            int i10 = c14581.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14581.label = i10 - Integer.MIN_VALUE;
            } else {
                c14581 = new C14581(eVar);
            }
        } else {
            c14581 = new C14581(eVar);
        }
        Object objX = c14581.result;
        Object objG = bb.b.g();
        int i11 = c14581.label;
        boolean z10 = false;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    NearSetIQ nearSetIQ2 = new NearSetIQ(d10, d11, null, 4, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, nearSetIQ2);
                    c14581.L$0 = cb.l.a(xMPPTCPConnection);
                    c14581.L$1 = cb.l.a(nearSetIQ2);
                    c14581.D$0 = d10;
                    c14581.D$1 = d11;
                    c14581.I$0 = 0;
                    c14581.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14581);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    nearSetIQ = null;
                }
                if (nearSetIQ != null) {
                    code = nearSetIQ.getCode();
                    if (code != null && code.intValue() == 200) {
                        z10 = true;
                    }
                    return cb.b.a(z10);
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        nearSetIQ = (NearSetIQ) ((IQ) objX);
        if (nearSetIQ != null) {
            code = nearSetIQ.getCode();
            if (code != null) {
                z10 = true;
            }
            return cb.b.a(z10);
        }
        return cb.b.a(false);
    }
}
