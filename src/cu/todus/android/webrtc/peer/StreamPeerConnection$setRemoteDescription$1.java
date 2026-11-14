package cu.todus.android.webrtc.peer;

import kotlin.Metadata;
import ua.u;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.webrtc.peer.StreamPeerConnection", f = "StreamPeerConnection.kt", l = {482, 491, 146}, m = "setRemoteDescription-gIAlu-s", v = 2)
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class StreamPeerConnection$setRemoteDescription$1 extends cb.d {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamPeerConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPeerConnection$setRemoteDescription$1(StreamPeerConnection streamPeerConnection, ab.e<? super StreamPeerConnection$setRemoteDescription$1> eVar) {
        super(eVar);
        this.this$0 = streamPeerConnection;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM10128setRemoteDescriptiongIAlus = this.this$0.m10128setRemoteDescriptiongIAlus(null, this);
        return objM10128setRemoteDescriptiongIAlus == bb.b.g() ? objM10128setRemoteDescriptiongIAlus : u.a(objM10128setRemoteDescriptiongIAlus);
    }
}
