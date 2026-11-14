package cu.todus.android.webrtc.utils;

import ab.e;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import ua.k0;
import ua.u;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"cu/todus/android/webrtc/utils/SDPUtilsKt$setValue$2$observer$1", "Lorg/webrtc/SdpObserver;", "", "p0", "Lua/k0;", "onCreateFailure", "(Ljava/lang/String;)V", "Lorg/webrtc/SessionDescription;", "onCreateSuccess", "(Lorg/webrtc/SessionDescription;)V", "onSetSuccess", "()V", "message", "onSetFailure", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class SDPUtilsKt$setValue$2$observer$1 implements SdpObserver {
    final /* synthetic */ e<u> $it;

    /* JADX WARN: Multi-variable type inference failed */
    public SDPUtilsKt$setValue$2$observer$1(e<? super u> eVar) {
        this.$it = eVar;
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(String message) {
        e<u> eVar = this.$it;
        u.a aVar = u.f43963f;
        eVar.resumeWith(u.b(u.a(u.b(v.a(new RuntimeException(message))))));
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
        e<u> eVar = this.$it;
        u.a aVar = u.f43963f;
        eVar.resumeWith(u.b(u.a(u.b(k0.f43947a))));
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String p10) {
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription p10) {
    }
}
