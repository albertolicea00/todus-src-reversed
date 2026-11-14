package cu.todus.android.webrtc.utils;

import cu.todus.android.webrtc.peer.StreamPeerType;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import org.webrtc.IceCandidateErrorEvent;
import org.webrtc.MediaStreamTrack;
import org.webrtc.SessionDescription;
import org.webrtc.audio.JavaAudioDeviceModule;
import ua.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006¨\u0006\u0007"}, d2 = {"stringify", "", "Lorg/webrtc/SessionDescription;", "Lorg/webrtc/MediaStreamTrack;", "Lorg/webrtc/IceCandidateErrorEvent;", "Lorg/webrtc/audio/JavaAudioDeviceModule$AudioSamples;", "Lcu/todus/android/webrtc/peer/StreamPeerType;", "app_productionPFast"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StringifyKt {

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StreamPeerType.values().length];
            try {
                iArr[StreamPeerType.PUBLISHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreamPeerType.SUBSCRIBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String stringify(SessionDescription sessionDescription) {
        y.i(sessionDescription, "<this>");
        return "SessionDescription(type=" + sessionDescription.type + ", description=" + sessionDescription.description + ")";
    }

    public static final String stringify(MediaStreamTrack mediaStreamTrack) {
        y.i(mediaStreamTrack, "<this>");
        return "MediaStreamTrack(id=" + mediaStreamTrack.id() + ", kind=" + mediaStreamTrack.kind() + ", enabled: " + mediaStreamTrack.enabled() + ", state=" + mediaStreamTrack.state() + ")";
    }

    public static final String stringify(IceCandidateErrorEvent iceCandidateErrorEvent) {
        y.i(iceCandidateErrorEvent, "<this>");
        return "IceCandidateErrorEvent(errorCode=" + iceCandidateErrorEvent.errorCode + ", " + iceCandidateErrorEvent.errorText + ", address=" + iceCandidateErrorEvent.address + ", port=" + iceCandidateErrorEvent.port + ", url=" + iceCandidateErrorEvent.url + ")";
    }

    public static final String stringify(JavaAudioDeviceModule.AudioSamples audioSamples) {
        y.i(audioSamples, "<this>");
        return "AudioSamples(audioFormat=" + audioSamples.getAudioFormat() + ", channelCount=" + audioSamples.getChannelCount() + ", sampleRate=" + audioSamples.getSampleRate() + ", data.size=" + audioSamples.getData().length + ")";
    }

    public static final String stringify(StreamPeerType streamPeerType) {
        y.i(streamPeerType, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[streamPeerType.ordinal()];
        if (i10 == 1) {
            return "publisher";
        }
        if (i10 == 2) {
            return "subscriber";
        }
        throw new r();
    }
}
