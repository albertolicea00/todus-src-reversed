package cu.todus.android.uiCompose.call.screen.call;

import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.di.MediaModule;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0003¨\u0006\f"}, d2 = {"Lcu/todus/android/uiCompose/call/screen/call/VideoCallViewModel;", "Lcu/todus/android/uiCompose/call/screen/call/BaseCallViewModel;", "<init>", "()V", "Lua/k0;", "toggleMicrophone", "toggleCamera", "flipCamera", "enableCameraAutoNew", "startRingContinuousNew", "enableSpeakerNew", "stopRingContinuousNew", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VideoCallViewModel extends BaseCallViewModel {
    public static final int $stable = 8;

    public VideoCallViewModel() {
        startStateObserver();
    }

    public final void enableCameraAutoNew() throws InterruptedException {
        CallMediaState callMediaState = (CallMediaState) ownerCallMediaState().getValue();
        if (callMediaState.isCameraEnabled()) {
            return;
        }
        updateOwnerCallMediaState(CallMediaState.copy$default(callMediaState, false, true, false, 5, null));
        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = sessionManager();
        if (webRtcSessionManagerImplSessionManager != null) {
            webRtcSessionManagerImplSessionManager.enableCamera(true);
        }
    }

    public final void enableSpeakerNew() {
        CallMediaState callMediaState = (CallMediaState) ownerCallMediaState().getValue();
        updateOwnerCallMediaState(CallMediaState.copy$default(callMediaState, false, false, true, 3, null));
        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = sessionManager();
        if (webRtcSessionManagerImplSessionManager != null) {
            webRtcSessionManagerImplSessionManager.setSpeakerphoneOnNew(true);
        }
        callMediaState.isSoundEnable();
    }

    public final void flipCamera() {
        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = sessionManager();
        if (webRtcSessionManagerImplSessionManager != null) {
            webRtcSessionManagerImplSessionManager.flipCamera();
        }
    }

    public final void startRingContinuousNew() {
        try {
            MediaModule.INSTANCE.getInstance().startRingContinuousNew();
            enableSpeakerNew();
        } catch (Exception e10) {
            Log.e("VideoCallViewModel", "Error starting continuous ring", e10);
        }
    }

    public final void stopRingContinuousNew() {
        try {
            MediaModule.INSTANCE.getInstance().stopRingContinuousNew();
        } catch (Exception e10) {
            Log.e("VideoCallViewModel", "Error stopping continuous ring", e10);
        }
    }

    public final void toggleCamera() throws InterruptedException {
        CallMediaState callMediaState = (CallMediaState) ownerCallMediaState().getValue();
        boolean z10 = !callMediaState.isCameraEnabled();
        updateOwnerCallMediaState(CallMediaState.copy$default(callMediaState, false, z10, false, 5, null));
        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = sessionManager();
        if (webRtcSessionManagerImplSessionManager != null) {
            webRtcSessionManagerImplSessionManager.enableCamera(z10);
        }
    }

    public final void toggleMicrophone() {
        CallMediaState callMediaState = (CallMediaState) ownerCallMediaState().getValue();
        boolean z10 = !callMediaState.isMicrophoneEnabled();
        updateOwnerCallMediaState(CallMediaState.copy$default(callMediaState, z10, false, false, 6, null));
        WebRtcSessionManagerImpl webRtcSessionManagerImplSessionManager = sessionManager();
        if (webRtcSessionManagerImplSessionManager != null) {
            webRtcSessionManagerImplSessionManager.enableMicrophone(z10);
        }
    }
}
