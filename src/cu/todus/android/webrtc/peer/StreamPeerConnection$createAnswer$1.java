package cu.todus.android.webrtc.peer;

import kotlin.Metadata;
import ua.u;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@cb.f(c = "cu.todus.android.webrtc.peer.StreamPeerConnection", f = "StreamPeerConnection.kt", l = {482}, m = "createAnswer-IoAF18A", v = 2)
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class StreamPeerConnection$createAnswer$1 extends cb.d {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamPeerConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPeerConnection$createAnswer$1(StreamPeerConnection streamPeerConnection, ab.e<? super StreamPeerConnection$createAnswer$1> eVar) {
        super(eVar);
        this.this$0 = streamPeerConnection;
    }

    @Override // cb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM10125createAnswerIoAF18A = this.this$0.m10125createAnswerIoAF18A(this);
        return objM10125createAnswerIoAF18A == bb.b.g() ? objM10125createAnswerIoAF18A : u.a(objM10125createAnswerIoAF18A);
    }
}
