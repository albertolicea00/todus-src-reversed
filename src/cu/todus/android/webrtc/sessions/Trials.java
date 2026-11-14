package cu.todus.android.webrtc.sessions;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.webrtc.PeerConnectionFactory;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b0\bÇ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcu/todus/android/webrtc/sessions/Trials;", "", "<init>", "()V", "RTC_EVENT_LOG_NEW_FORMAT", "", "BWE_INJECTED_CONGESTION_CONTROLLE", "AUDIO_MINIMIZE_RESAMPLING_ON_MOBILE", "FLEX_FEC_03", "FLEX_FEC_03_ADVERTISED", "H264_SIMULCAST", "SUPPORT_VP9_SVC", "VP8_FORCED_FALLBACK_ENCODER_V2", "GENERIC_DESCRIPTOR_ADVERTISED", "VIDEO_DISCARD_PACKETS_WITH_UNKNOWN_SSRC", "VIDEO_BALANCED_DEGRADATION", "BOOSTED_SCREENSHAREQ", "VP8_SCREEN_SHARE", "VP8_CONFERENCE", "SIMULCAST_MAX_LAYERS", "USE_BASE_HEAVY_VP8_TL3_RATE_ALLOCATION", "SIMULCAST_SCREENSHARE", "KEEP_ABS_SEND_TIME_EXTENSION", "GENERIC_DESCRIPTOR_AUTH", "FORCE_SIMULATED_OVERUSE_INTERVAL_MS", "DECODER_DATA_DUMP_DIRECTORY", "VIDEO_PACING", "INITIAL_FRAMEDROP", "FRAME_DROPPER", "STUN_INTER_PACKET_DELAY", "EXTRA_ICE_PING", "RFC5389_STUN_RETRANSMISSIONS", "VP8_CPU_SPEED_ARM", "PROBING_SCREENSHARE_BWE", "STRICT_PACING_AND_PROBING", "RTT_MULT", "JITTER_UPPER_BOUND", "NORMALIZE_SIMULCAST_RESOLUTION", "VIDEO_QUALITY_SCALING", "CWND_EXPERIMENT", "CONGESTION_WINDOW_PUSHBACK", "LIBVPX_VP8_TRUSTED_RATE_CONTROLLER", "LIBVPX_VP9_TRUSTED_RATE_CONTROLLER", "SIMULCAST_UPSWITCH_HYSTERESIS_PERCENT", "SIMULCAST_SCREENSHARE_UPSWITCH_HYSTERESIS_PERCENT", "VIDEO_RATE_CONTROL", "AUDIO_SEND_SIDE_BWE", "AUDIO_ABWENO_TWCC", "AUDIO_FORCE_NO_TWCC", "AUDIO_SEND_SIDE_BWE_FOR_VIDEO", "SEND_SIDE_BWE_WITH_OVERHEAD", "AUDIO_ALLOCATION", "Builder", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Trials {
    public static final int $stable = 0;
    public static final String AUDIO_ABWENO_TWCC = "WebRTC-Audio-ABWENoTWCC";
    public static final String AUDIO_ALLOCATION = "WebRTC-Audio-Allocation";
    public static final String AUDIO_FORCE_NO_TWCC = "WebRTC-Audio-ForceNoTWCC";
    public static final String AUDIO_MINIMIZE_RESAMPLING_ON_MOBILE = "WebRTC-Audio-MinimizeResamplingOnMobile";
    public static final String AUDIO_SEND_SIDE_BWE = "WebRTC-Audio-SendSideBwe";
    public static final String AUDIO_SEND_SIDE_BWE_FOR_VIDEO = "WebRTC-Audio-SendSideBwe-For-Video";
    public static final String BOOSTED_SCREENSHAREQ = "WebRTC-BoostedScreenshareQp";
    public static final String BWE_INJECTED_CONGESTION_CONTROLLE = "WebRTC-Bwe-InjectedCongestionControlle";
    public static final String CONGESTION_WINDOW_PUSHBACK = "WebRTC-CongestionWindowPushback";
    public static final String CWND_EXPERIMENT = "WebRTC-CwndExperiment";
    public static final String DECODER_DATA_DUMP_DIRECTORY = "WebRTC-DecoderDataDumpDirectory";
    public static final String EXTRA_ICE_PING = "WebRTC-ExtraICEPing";
    public static final String FLEX_FEC_03 = "WebRTC-FlexFEC-03";
    public static final String FLEX_FEC_03_ADVERTISED = "WebRTC-FlexFEC-03-Advertised";
    public static final String FORCE_SIMULATED_OVERUSE_INTERVAL_MS = "WebRTC-ForceSimulatedOveruseIntervalMs";
    public static final String FRAME_DROPPER = "WebRTC-FrameDropper";
    public static final String GENERIC_DESCRIPTOR_ADVERTISED = "WebRTC-GenericDescriptorAdvertised";
    public static final String GENERIC_DESCRIPTOR_AUTH = "WebRTC-GenericDescriptorAuth";
    public static final String H264_SIMULCAST = "WebRTC-H264Simulcast";
    public static final String INITIAL_FRAMEDROP = "WebRTC-InitialFramedrop";
    public static final Trials INSTANCE = new Trials();
    public static final String JITTER_UPPER_BOUND = "WebRTC-JitterUpperBound";
    public static final String KEEP_ABS_SEND_TIME_EXTENSION = "WebRTC-KeepAbsSendTimeExtension";
    public static final String LIBVPX_VP8_TRUSTED_RATE_CONTROLLER = "WebRTC-LibvpxVp8TrustedRateController";
    public static final String LIBVPX_VP9_TRUSTED_RATE_CONTROLLER = "WebRTC-LibvpxVp9TrustedRateController";
    public static final String NORMALIZE_SIMULCAST_RESOLUTION = "WebRTC-NormalizeSimulcastResolution";
    public static final String PROBING_SCREENSHARE_BWE = "WebRTC-ProbingScreenshareBwe";
    public static final String RFC5389_STUN_RETRANSMISSIONS = "WebRTC-Rfc5389StunRetransmissions";
    public static final String RTC_EVENT_LOG_NEW_FORMAT = "WebRTC-RtcEventLogNewFormat";
    public static final String RTT_MULT = "WebRTC-RttMult";
    public static final String SEND_SIDE_BWE_WITH_OVERHEAD = "WebRTC-SendSideBwe-WithOverhead";
    public static final String SIMULCAST_MAX_LAYERS = "WebRTC-SimulcastMaxLayers";
    public static final String SIMULCAST_SCREENSHARE = "WebRTC-SimulcastScreenshare";
    public static final String SIMULCAST_SCREENSHARE_UPSWITCH_HYSTERESIS_PERCENT = "WebRTC-SimulcastScreenshareUpswitchHysteresisPercent";
    public static final String SIMULCAST_UPSWITCH_HYSTERESIS_PERCENT = "WebRTC-SimulcastUpswitchHysteresisPercent";
    public static final String STRICT_PACING_AND_PROBING = "WebRTC-StrictPacingAndProbing";
    public static final String STUN_INTER_PACKET_DELAY = "WebRTC-StunInterPacketDelay";
    public static final String SUPPORT_VP9_SVC = "WebRTC-SupportVP9SVC";
    public static final String USE_BASE_HEAVY_VP8_TL3_RATE_ALLOCATION = "WebRTC-UseBaseHeavyVP8TL3RateAllocation";
    public static final String VIDEO_BALANCED_DEGRADATION = "WebRTC-Video-BalancedDegradation";
    public static final String VIDEO_DISCARD_PACKETS_WITH_UNKNOWN_SSRC = "WebRTC-Video-DiscardPacketsWithUnknownSsrc";
    public static final String VIDEO_PACING = "WebRTC-Video-Pacing";
    public static final String VIDEO_QUALITY_SCALING = "WebRTC-Video-QualityScaling";
    public static final String VIDEO_RATE_CONTROL = "WebRTC-VideoRateControl";
    public static final String VP8_CONFERENCE = "WebRTC-VP8ConferenceTemporalLayers";
    public static final String VP8_CPU_SPEED_ARM = "WebRTC-VP8-CpuSpeed-Arm";
    public static final String VP8_FORCED_FALLBACK_ENCODER_V2 = "WebRTC-VP8-Forced-Fallback-Encoder-v2";
    public static final String VP8_SCREEN_SHARE = "WebRTC-VP8ScreenshareTemporalLayers";

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\n\u0010\n\u001a\u00020\tH\u0096\u0080\u0004R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/webrtc/sessions/Trials$Builder;", "", "<init>", "()V", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "enable", "trial", "", "toString", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private static final char SEPARATOR = '/';
        private final StringBuilder stringBuilder = new StringBuilder();
        public static final int $stable = 8;

        public final Builder enable(String trial) {
            this.stringBuilder.append(trial);
            this.stringBuilder.append(SEPARATOR);
            this.stringBuilder.append(PeerConnectionFactory.TRIAL_ENABLED);
            this.stringBuilder.append(SEPARATOR);
            return this;
        }

        public String toString() {
            String string = this.stringBuilder.toString();
            y.h(string, "toString(...)");
            return string;
        }
    }

    private Trials() {
    }
}
