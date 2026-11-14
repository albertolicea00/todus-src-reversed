package cu.todus.android.webrtc.utils;

import ab.e;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import ua.u;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"cu/todus/android/webrtc/utils/SDPUtilsKt$createValue$2$observer$1", "Lorg/webrtc/SdpObserver;", "Lorg/webrtc/SessionDescription;", "description", "Lua/k0;", "onCreateSuccess", "(Lorg/webrtc/SessionDescription;)V", "", "message", "onCreateFailure", "(Ljava/lang/String;)V", "onSetSuccess", "()V", "p0", "onSetFailure", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class SDPUtilsKt$createValue$2$observer$1 implements SdpObserver {
    final /* synthetic */ e<u> $it;

    /* JADX WARN: Multi-variable type inference failed */
    public SDPUtilsKt$createValue$2$observer$1(e<? super u> eVar) {
        this.$it = eVar;
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String message) {
        e<u> eVar = this.$it;
        u.a aVar = u.f43963f;
        eVar.resumeWith(u.b(u.a(u.b(v.a(new RuntimeException(message))))));
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription description) {
        if (description != null) {
            this.$it.resumeWith(u.b(u.a(u.b(description))));
            return;
        }
        e<u> eVar = this.$it;
        u.a aVar = u.f43963f;
        eVar.resumeWith(u.b(u.a(u.b(v.a(new RuntimeException("SessionDescription is null!"))))));
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(String p10) {
    }
}
