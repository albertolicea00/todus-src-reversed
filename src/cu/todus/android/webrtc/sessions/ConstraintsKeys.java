package cu.todus.android.webrtc.sessions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b$\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcu/todus/android/webrtc/sessions/ConstraintsKeys;", "", "<init>", "()V", "KEY_MAX_ASPECT_RATIO", "", "KEY_MIN_ASPECT_RATIO", "KEY_MAX_WIDTH", "KEY_MIN_WIDTH", "KEY_MAX_HEIGHT", "KEY_MIN_HEIGHT", "KEY_MAX_FRAME_RATE", "KEY_MIN_FRAME_RATE", "KEY_GOOGLE_NOISE_REDUCTION", "KEY_ECHO_CANCELLATION", "KEY_GOOGLE_ECHO_CANCELLATION", "KEY_GOOGLE_ECHO_CANCELLATION_2", "KEY_GOOGLE_DA_ECHO_CANCELLATION", "KEY_GOOGLE_AUTO_GAIN_CONTROL", "KEY_GOOGLE_AUTO_GAIN_CONTROL_2", "KEY_GOOGLE_NOISE_SUPPRESSION", "KEY_GOOGLE_NOISE_SUPPRESSION_2", "KEY_GOOGLE_HIGHPASS_FILTER", "KEY_GOOGLE_TYPING_NOISE_DETECTION", "KEY_GOOGLE_AUDIO_MIRRORING", "KEY_GOOGLE_AUDIO_NETWORK_ADAPTOR_CONFIG", "KEY_OFFER_TO_RECEIVE_VIDEO", "KEY_OFFER_TO_RECEIVE_AUDIO", "KEY_VOICE_ACTIVITY_DETECTION", "KEY_ICE_RESTART", "KEY_GOOGLE_USE_RTP_MUX", "KEY_DTLS_SRTP_KEY_AGREEMENT", "KEY_RTP_DATA_CHANNELS", "KEY_GOOGLE_DSCP", "KEY_GOOGLE_IPV6", "KEY_GOOGLE_SUSPEND_BELOW_MIN_BITRATE", "KEY_GOOGLE_COMBINED_AUDIO_VIDEO_BWE", "KEY_GOOGLE_SCREENCAST_MIN_BITRATE", "KEY_GOOGLE_CPU_OVERUSE_DETECTION", "KEY_GOOGLE_PAYLOAD_PADDING", "KEY_GOOGLE_NUM_SIMULCAST_LAYERS", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConstraintsKeys {
    public static final int $stable = 0;
    public static final ConstraintsKeys INSTANCE = new ConstraintsKeys();
    public static final String KEY_DTLS_SRTP_KEY_AGREEMENT = "DtlsSrtpKeyAgreement";
    public static final String KEY_ECHO_CANCELLATION = "echoCancellation";
    public static final String KEY_GOOGLE_AUDIO_MIRRORING = "googAudioMirroring";
    public static final String KEY_GOOGLE_AUDIO_NETWORK_ADAPTOR_CONFIG = "googAudioNetworkAdaptorConfig";
    public static final String KEY_GOOGLE_AUTO_GAIN_CONTROL = "googAutoGainControl";
    public static final String KEY_GOOGLE_AUTO_GAIN_CONTROL_2 = "googAutoGainControl2";
    public static final String KEY_GOOGLE_COMBINED_AUDIO_VIDEO_BWE = "googCombinedAudioVideoBwe";
    public static final String KEY_GOOGLE_CPU_OVERUSE_DETECTION = "googCpuOveruseDetection";
    public static final String KEY_GOOGLE_DA_ECHO_CANCELLATION = "googDAEchoCancellation";
    public static final String KEY_GOOGLE_DSCP = "googDscp";
    public static final String KEY_GOOGLE_ECHO_CANCELLATION = "googEchoCancellation";
    public static final String KEY_GOOGLE_ECHO_CANCELLATION_2 = "googEchoCancellation2";
    public static final String KEY_GOOGLE_HIGHPASS_FILTER = "googHighpassFilter";
    public static final String KEY_GOOGLE_IPV6 = "googIPv6";
    public static final String KEY_GOOGLE_NOISE_REDUCTION = "googNoiseReduction";
    public static final String KEY_GOOGLE_NOISE_SUPPRESSION = "googNoiseSuppression";
    public static final String KEY_GOOGLE_NOISE_SUPPRESSION_2 = "googNoiseSuppression2";
    public static final String KEY_GOOGLE_NUM_SIMULCAST_LAYERS = "googNumSimulcastLayers";
    public static final String KEY_GOOGLE_PAYLOAD_PADDING = "googPayloadPadding";
    public static final String KEY_GOOGLE_SCREENCAST_MIN_BITRATE = "googScreencastMinBitrate";
    public static final String KEY_GOOGLE_SUSPEND_BELOW_MIN_BITRATE = "googSuspendBelowMinBitrate";
    public static final String KEY_GOOGLE_TYPING_NOISE_DETECTION = "googTypingNoiseDetection";
    public static final String KEY_GOOGLE_USE_RTP_MUX = "googUseRtpMUX";
    public static final String KEY_ICE_RESTART = "IceRestart";
    public static final String KEY_MAX_ASPECT_RATIO = "maxAspectRatio";
    public static final String KEY_MAX_FRAME_RATE = "maxFrameRate";
    public static final String KEY_MAX_HEIGHT = "maxHeight";
    public static final String KEY_MAX_WIDTH = "maxWidth";
    public static final String KEY_MIN_ASPECT_RATIO = "minAspectRatio";
    public static final String KEY_MIN_FRAME_RATE = "minFrameRate";
    public static final String KEY_MIN_HEIGHT = "minHeight";
    public static final String KEY_MIN_WIDTH = "minWidth";
    public static final String KEY_OFFER_TO_RECEIVE_AUDIO = "OfferToReceiveAudio";
    public static final String KEY_OFFER_TO_RECEIVE_VIDEO = "OfferToReceiveVideo";
    public static final String KEY_RTP_DATA_CHANNELS = "RtpDataChannels";
    public static final String KEY_VOICE_ACTIVITY_DETECTION = "VoiceActivityDetection";

    private ConstraintsKeys() {
    }
}
