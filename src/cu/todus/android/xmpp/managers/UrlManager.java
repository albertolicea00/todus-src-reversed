package cu.todus.android.xmpp.managers;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.location.LocationRequestCompat;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.s3.GetUrlIQ;
import cu.todus.android.xmpp.iq.s3.PutUrlIQ;
import kotlin.Metadata;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ6\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0018\u0010\u0014J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0019\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcu/todus/android/xmpp/managers/UrlManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lua/k0;", "on400Received", "<init>", "(Llb/a;Llb/a;Llb/a;)V", "", MarkerAction.COLUMN_ROOM, "", "type", "", "size", Attachment.COLUMN_PERSISTENT, "Lcu/todus/android/data/xmpp/FileResponse$FileResult;", "getPutUrlForRetry", "(Ljava/lang/String;IJZLab/e;)Ljava/lang/Object;", "url", "getUrlForRetry", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "getPutUrl", "getUrl", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOn400Received", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UrlManager {
    public static final int $stable = 0;
    private final lb.a canSend;
    private final lb.a mXMPPConnection;
    private final lb.a on400Received;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.UrlManager$getPutUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.UrlManager", f = "UrlManager.kt", l = {19, 30}, m = "getPutUrl", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UrlManager.this.getPutUrl(null, 0, 0L, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.UrlManager$getPutUrlForRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.UrlManager", f = "UrlManager.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "getPutUrlForRetry", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15141 extends cb.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C15141(ab.e<? super C15141> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UrlManager.this.getPutUrlForRetry(null, 0, 0L, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.UrlManager$getUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.UrlManager", f = "UrlManager.kt", l = {68, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "getUrl", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15151 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15151(ab.e<? super C15151> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UrlManager.this.getUrl(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.UrlManager$getUrlForRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.UrlManager", f = "UrlManager.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "getUrlForRetry", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C15161 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15161(ab.e<? super C15161> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UrlManager.this.getUrlForRetry(null, this);
        }
    }

    public UrlManager(lb.a canSend, lb.a mXMPPConnection, lb.a on400Received) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(on400Received, "on400Received");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.on400Received = on400Received;
    }

    public static /* synthetic */ Object getPutUrl$default(UrlManager urlManager, String str, int i10, long j10, boolean z10, ab.e eVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        return urlManager.getPutUrl(str, i10, j10, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:25:0x00af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object getPutUrlForRetry(String str, int i10, long j10, boolean z10, ab.e<? super FileResponse.FileResult> eVar) {
        C15141 c15141;
        PutUrlIQ putUrlIQ;
        Integer numD;
        if (eVar instanceof C15141) {
            c15141 = (C15141) eVar;
            int i11 = c15141.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c15141.label = i11 - Integer.MIN_VALUE;
            } else {
                c15141 = new C15141(eVar);
            }
        } else {
            c15141 = new C15141(eVar);
        }
        Object objX = c15141.result;
        Object objG = bb.b.g();
        int i12 = c15141.label;
        if (i12 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    PutUrlIQ putUrlIQ2 = new PutUrlIQ(null, str, i10, z10, (int) j10, null, null, 0, WebmConstants.MkvEbmlElement.AUDIO, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, putUrlIQ2);
                    c15141.L$0 = cb.l.a(str);
                    c15141.L$1 = cb.l.a(xMPPTCPConnection);
                    c15141.L$2 = cb.l.a(putUrlIQ2);
                    c15141.I$0 = i10;
                    c15141.J$0 = j10;
                    c15141.Z$0 = z10;
                    c15141.I$1 = 0;
                    c15141.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c15141);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    putUrlIQ = null;
                }
                if (putUrlIQ != null) {
                    numD = cb.b.d(putUrlIQ.getStatus());
                } else {
                    numD = null;
                }
                if (numD != null && numD.intValue() == 200) {
                    return new FileResponse.FileResult(putUrlIQ.getGet(), putUrlIQ.getPut(), false);
                }
            }
            return null;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        putUrlIQ = (PutUrlIQ) ((IQ) objX);
        if (putUrlIQ != null) {
            numD = cb.b.d(putUrlIQ.getStatus());
        } else {
            numD = null;
        }
        if (numD != null) {
            return new FileResponse.FileResult(putUrlIQ.getGet(), putUrlIQ.getPut(), false);
        }
        return null;
    }

    public static /* synthetic */ Object getPutUrlForRetry$default(UrlManager urlManager, String str, int i10, long j10, boolean z10, ab.e eVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        return urlManager.getPutUrlForRetry(str, i10, j10, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x008d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUrlForRetry(String str, ab.e<? super String> eVar) {
        C15161 c15161;
        GetUrlIQ getUrlIQ;
        Integer numD;
        if (eVar instanceof C15161) {
            c15161 = (C15161) eVar;
            int i10 = c15161.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c15161.label = i10 - Integer.MIN_VALUE;
            } else {
                c15161 = new C15161(eVar);
            }
        } else {
            c15161 = new C15161(eVar);
        }
        Object objX = c15161.result;
        Object objG = bb.b.g();
        int i11 = c15161.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                return "";
            }
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                GetUrlIQ getUrlIQ2 = new GetUrlIQ(str, null, 0, 6, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getUrlIQ2);
                c15161.L$0 = cb.l.a(str);
                c15161.L$1 = cb.l.a(xMPPTCPConnection);
                c15161.L$2 = cb.l.a(getUrlIQ2);
                c15161.I$0 = 0;
                c15161.label = 1;
                objX = te.j.x(hVarSendIQFlow, c15161);
                if (objX == objG) {
                    return objG;
                }
            } else {
                getUrlIQ = null;
            }
            if (getUrlIQ != null) {
                numD = cb.b.d(getUrlIQ.getStatus());
            } else {
                numD = null;
            }
            if (numD != null && numD.intValue() == 200) {
                return getUrlIQ.getDu();
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        getUrlIQ = (GetUrlIQ) ((IQ) objX);
        if (getUrlIQ != null) {
            numD = cb.b.d(getUrlIQ.getStatus());
        } else {
            numD = null;
        }
        if (numD != null) {
            return getUrlIQ.getDu();
        }
        return null;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOn400Received() {
        return this.on400Received;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x009f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00bb -> B:32:0x00c0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getPutUrl(java.lang.String r16, int r17, long r18, boolean r20, ab.e<? super cu.todus.android.data.xmpp.FileResponse.FileResult> r21) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.UrlManager.getPutUrl(java.lang.String, int, long, boolean, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x005f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        return r1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0070 -> B:27:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getUrl(java.lang.String r8, ab.e<? super java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cu.todus.android.xmpp.managers.UrlManager.C15151
            if (r0 == 0) goto L13
            r0 = r9
            cu.todus.android.xmpp.managers.UrlManager$getUrl$1 r0 = (cu.todus.android.xmpp.managers.UrlManager.C15151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.UrlManager$getUrl$1 r0 = new cu.todus.android.xmpp.managers.UrlManager$getUrl$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            ua.v.b(r9)
            goto L73
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            ua.v.b(r9)
            goto L54
        L46:
            ua.v.b(r9)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r7.getUrlForRetry(r8, r0)
            if (r9 != r1) goto L54
            goto L72
        L54:
            java.lang.String r9 = (java.lang.String) r9
            r2 = 0
            r6 = r2
            r2 = r8
            r8 = r6
        L5a:
            r5 = 3
            if (r8 >= r5) goto L77
            if (r9 == 0) goto L60
            return r9
        L60:
            r0.L$0 = r2
            java.lang.Object r9 = cb.l.a(r9)
            r0.L$1 = r9
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.getUrlForRetry(r2, r0)
            if (r9 != r1) goto L73
        L72:
            return r1
        L73:
            java.lang.String r9 = (java.lang.String) r9
            int r8 = r8 + r4
            goto L5a
        L77:
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.UrlManager.getUrl(java.lang.String, ab.e):java.lang.Object");
    }
}
