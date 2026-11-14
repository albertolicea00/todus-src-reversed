package cu.todus.android.webrtc.utils;

import ab.e;
import ab.k;
import bb.b;
import cb.d;
import cb.f;
import cb.h;
import kotlin.Metadata;
import org.webrtc.AddIceObserver;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import ua.k0;
import ua.u;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/webrtc/PeerConnection;", "Lorg/webrtc/IceCandidate;", "iceCandidate", "Lua/u;", "Lua/k0;", "addRtcIceCandidate", "(Lorg/webrtc/PeerConnection;Lorg/webrtc/IceCandidate;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PeerConnectionUtilsKt {

    /* JADX INFO: renamed from: cu.todus.android.webrtc.utils.PeerConnectionUtilsKt$addRtcIceCandidate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @f(c = "cu.todus.android.webrtc.utils.PeerConnectionUtilsKt", f = "PeerConnectionUtils.kt", l = {10}, m = "addRtcIceCandidate", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objAddRtcIceCandidate = PeerConnectionUtilsKt.addRtcIceCandidate(null, null, this);
            return objAddRtcIceCandidate == b.g() ? objAddRtcIceCandidate : u.a(objAddRtcIceCandidate);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object addRtcIceCandidate(PeerConnection peerConnection, IceCandidate iceCandidate, e<? super u> eVar) throws Throwable {
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
        Object objA = anonymousClass1.result;
        Object objG = b.g();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            v.b(objA);
            anonymousClass1.L$0 = peerConnection;
            anonymousClass1.L$1 = iceCandidate;
            anonymousClass1.label = 1;
            final k kVar = new k(b.d(anonymousClass1));
            peerConnection.addIceCandidate(iceCandidate, new AddIceObserver() { // from class: cu.todus.android.webrtc.utils.PeerConnectionUtilsKt$addRtcIceCandidate$2$1
                @Override // org.webrtc.AddIceObserver
                public void onAddFailure(String error) {
                    e<u> eVar2 = kVar;
                    u.a aVar = u.f43963f;
                    eVar2.resumeWith(u.b(u.a(u.b(v.a(new RuntimeException(error))))));
                }

                @Override // org.webrtc.AddIceObserver
                public void onAddSuccess() {
                    e<u> eVar2 = kVar;
                    u.a aVar = u.f43963f;
                    eVar2.resumeWith(u.b(u.a(u.b(k0.f43947a))));
                }
            });
            objA = kVar.a();
            if (objA == b.g()) {
                h.c(anonymousClass1);
            }
            if (objA == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(objA);
        }
        return ((u) objA).j();
    }
}
