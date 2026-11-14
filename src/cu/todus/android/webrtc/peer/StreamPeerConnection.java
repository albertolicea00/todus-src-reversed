package cu.todus.android.webrtc.peer;

import af.g;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import cb.h;
import cb.l;
import cb.m;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.webrtc.audio.AudioSwitchHandler;
import cu.todus.android.webrtc.utils.SDPUtilsKt$createValue$2$observer$1;
import cu.todus.android.webrtc.utils.SDPUtilsKt$setValue$2$observer$1;
import cu.todus.android.webrtc.utils.StringifyKt;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import org.webrtc.AudioTrack;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.IceCandidateErrorEvent;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RTCStatsReport;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.SessionDescription;
import org.webrtc.t0;
import pe.a2;
import pe.k;
import pe.m0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.u;
import ua.v;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u001c*\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&H\u0086@¢\u0006\u0004\b(\u0010)J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&H\u0086@¢\u0006\u0004\b+\u0010)J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\n0&2\u0006\u0010-\u001a\u00020'H\u0086@¢\u0006\u0004\b.\u0010/J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\n0&2\u0006\u0010-\u001a\u00020'H\u0086@¢\u0006\u0004\b1\u0010/J\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020\n0&2\u0006\u00103\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b4\u00105J\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0018J\u0019\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b8\u00109J+\u0010>\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010:2\u0010\u0010=\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\nH\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bB\u00109J\u0019\u0010E\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u0015\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0G¢\u0006\u0004\bI\u0010JJ\u0019\u0010L\u001a\u00020\n2\b\u0010K\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\bL\u0010MJ\u0019\u0010N\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u001fH\u0016¢\u0006\u0004\bT\u0010UJ\u0019\u0010W\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010VH\u0016¢\u0006\u0004\bW\u0010XJ!\u0010Z\u001a\u00020\n2\u0010\u0010Y\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010<H\u0016¢\u0006\u0004\bZ\u0010[J\u0019\u0010^\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\b^\u0010_J\u0019\u0010a\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010`H\u0016¢\u0006\u0004\ba\u0010bJ\u0019\u0010d\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010cH\u0016¢\u0006\u0004\bd\u0010eJ\u0019\u0010h\u001a\u00020\n2\b\u0010g\u001a\u0004\u0018\u00010fH\u0016¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020\n¢\u0006\u0004\bj\u0010AJ\u000f\u0010k\u001a\u00020\u001cH\u0016¢\u0006\u0004\bk\u0010lR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010mR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010nR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010oR\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010pR(\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010qR(\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010qR$\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010pR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010rR\u0014\u0010s\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR$\u0010v\u001a\u00020\"2\u0006\u0010u\u001a\u00020\"8\u0006@BX\u0086.¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0086\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010H0\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcu/todus/android/webrtc/peer/StreamPeerConnection;", "Lorg/webrtc/PeerConnection$Observer;", "Lpe/m0;", "coroutineScope", "Lcu/todus/android/webrtc/peer/StreamPeerType;", "type", "Lorg/webrtc/MediaConstraints;", "mediaConstraints", "Lkotlin/Function1;", "Lorg/webrtc/MediaStream;", "Lua/k0;", "onStreamAdded", "Lkotlin/Function2;", "onNegotiationNeeded", "Lorg/webrtc/IceCandidate;", "onIceCandidate", "Lorg/webrtc/RtpTransceiver;", "onVideoTrack", "Lkotlin/Function0;", "onConnected", "<init>", "(Lpe/m0;Lcu/todus/android/webrtc/peer/StreamPeerType;Lorg/webrtc/MediaConstraints;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Llb/a;)V", "candidate", "onIceCandidateNew", "(Lorg/webrtc/IceCandidate;)V", "Lpe/a2;", "observeStats", "()Lpe/a2;", "", "mungeCodecs", "(Ljava/lang/String;)Ljava/lang/String;", "", "isInitialized", "()Z", "Lorg/webrtc/PeerConnection;", "peerConnection", "initialize", "(Lorg/webrtc/PeerConnection;)V", "Lua/u;", "Lorg/webrtc/SessionDescription;", "createOffer-IoAF18A", "(Lab/e;)Ljava/lang/Object;", "createOffer", "createAnswer-IoAF18A", "createAnswer", "sessionDescription", "setRemoteDescription-gIAlu-s", "(Lorg/webrtc/SessionDescription;Lab/e;)Ljava/lang/Object;", "setRemoteDescription", "setLocalDescription-gIAlu-s", "setLocalDescription", "iceCandidate", "addIceCandidate-gIAlu-s", "(Lorg/webrtc/IceCandidate;Lab/e;)Ljava/lang/Object;", "addIceCandidate", "stream", "onAddStream", "(Lorg/webrtc/MediaStream;)V", "Lorg/webrtc/RtpReceiver;", "receiver", "", "mediaStreams", "onAddTrack", "(Lorg/webrtc/RtpReceiver;[Lorg/webrtc/MediaStream;)V", "onRenegotiationNeeded", "()V", "onRemoveStream", "Lorg/webrtc/PeerConnection$IceConnectionState;", "newState", "onIceConnectionChange", "(Lorg/webrtc/PeerConnection$IceConnectionState;)V", "Lte/p0;", "Lorg/webrtc/RTCStatsReport;", "getStats", "()Lte/p0;", "transceiver", "onTrack", "(Lorg/webrtc/RtpTransceiver;)V", "onRemoveTrack", "(Lorg/webrtc/RtpReceiver;)V", "Lorg/webrtc/PeerConnection$SignalingState;", "onSignalingChange", "(Lorg/webrtc/PeerConnection$SignalingState;)V", "receiving", "onIceConnectionReceivingChange", "(Z)V", "Lorg/webrtc/PeerConnection$IceGatheringState;", "onIceGatheringChange", "(Lorg/webrtc/PeerConnection$IceGatheringState;)V", "iceCandidates", "onIceCandidatesRemoved", "([Lorg/webrtc/IceCandidate;)V", "Lorg/webrtc/IceCandidateErrorEvent;", "event", "onIceCandidateError", "(Lorg/webrtc/IceCandidateErrorEvent;)V", "Lorg/webrtc/PeerConnection$PeerConnectionState;", "onConnectionChange", "(Lorg/webrtc/PeerConnection$PeerConnectionState;)V", "Lorg/webrtc/CandidatePairChangeEvent;", "onSelectedCandidatePairChanged", "(Lorg/webrtc/CandidatePairChangeEvent;)V", "Lorg/webrtc/DataChannel;", "channel", "onDataChannel", "(Lorg/webrtc/DataChannel;)V", "resetProcessedIceCandidatesNew", "toString", "()Ljava/lang/String;", "Lpe/m0;", "Lcu/todus/android/webrtc/peer/StreamPeerType;", "Lorg/webrtc/MediaConstraints;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "Llb/a;", "typeTag", "Ljava/lang/String;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "connection", "Lorg/webrtc/PeerConnection;", "getConnection", "()Lorg/webrtc/PeerConnection;", "statsJob", "Lpe/a2;", "Laf/a;", "pendingIceMutex", "Laf/a;", "", "pendingIceCandidates", "Ljava/util/List;", "", "processedIceCandidatesNew", "Ljava/util/Set;", "Lte/b0;", "statsFlow", "Lte/b0;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StreamPeerConnection implements PeerConnection.Observer {
    public static final int $stable = 8;
    private PeerConnection connection;
    private final m0 coroutineScope;

    /* JADX INFO: renamed from: mediaConstraints, reason: from kotlin metadata and from toString */
    private final MediaConstraints constraints;
    private final lb.a onConnected;
    private final Function2 onIceCandidate;
    private final Function2 onNegotiationNeeded;
    private final Function1 onStreamAdded;
    private final Function1 onVideoTrack;
    private final List<IceCandidate> pendingIceCandidates;
    private final af.a pendingIceMutex;
    private final Set<String> processedIceCandidatesNew;
    private final b0 statsFlow;
    private a2 statsJob;
    private final StreamPeerType type;

    /* JADX INFO: renamed from: typeTag, reason: from kotlin metadata and from toString */
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PeerConnection.IceConnectionState.values().length];
            try {
                iArr[PeerConnection.IceConnectionState.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.CHECKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PeerConnection.IceConnectionState.CLOSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PeerConnection.IceGatheringState.values().length];
            try {
                iArr2[PeerConnection.IceGatheringState.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[PeerConnection.IceGatheringState.GATHERING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PeerConnection.IceGatheringState.COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.peer.StreamPeerConnection$observeStats$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.peer.StreamPeerConnection$observeStats$1", f = "StreamPeerConnection.kt", l = {393}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends m implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(StreamPeerConnection streamPeerConnection, RTCStatsReport rTCStatsReport) {
            String unused = streamPeerConnection.type;
            Objects.toString(rTCStatsReport);
            streamPeerConnection.statsFlow.setValue(rTCStatsReport);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = StreamPeerConnection.this.new AnonymousClass1(eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0024  */
        /* JADX WARN: Code duplicated, block: B:13:0x0030 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002e -> B:14:0x0031). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                pe.m0 r0 = (pe.m0) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r6.label
                r3 = 1
                if (r2 == 0) goto L1b
                if (r2 != r3) goto L13
                ua.v.b(r7)
                goto L31
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                ua.v.b(r7)
            L1e:
                boolean r7 = pe.n0.g(r0)
                if (r7 == 0) goto L42
                r6.L$0 = r0
                r6.label = r3
                r4 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r7 = pe.w0.b(r4, r6)
                if (r7 != r1) goto L31
                return r1
            L31:
                cu.todus.android.webrtc.peer.StreamPeerConnection r7 = cu.todus.android.webrtc.peer.StreamPeerConnection.this
                org.webrtc.PeerConnection r7 = r7.getConnection()
                cu.todus.android.webrtc.peer.StreamPeerConnection r2 = cu.todus.android.webrtc.peer.StreamPeerConnection.this
                cu.todus.android.webrtc.peer.a r4 = new cu.todus.android.webrtc.peer.a
                r4.<init>()
                r7.getStats(r4)
                goto L1e
            L42:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.peer.StreamPeerConnection.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.peer.StreamPeerConnection$onIceConnectionChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.peer.StreamPeerConnection$onIceConnectionChange$1", f = "StreamPeerConnection.kt", l = {356}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13441 extends m implements Function2 {
        int I$0;
        long J$0;
        int label;

        public C13441(ab.e<? super C13441> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return StreamPeerConnection.this.new C13441(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002f  */
        /* JADX WARN: Code duplicated, block: B:13:0x003d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003b -> B:14:0x003e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                int r1 = r9.I$0
                long r3 = r9.J$0
                ua.v.b(r10)
                goto L3e
            L13:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1b:
                ua.v.b(r10)
                long r3 = java.lang.System.currentTimeMillis()
                r10 = 30000(0x7530, float:4.2039E-41)
                r1 = r10
            L25:
                long r5 = java.lang.System.currentTimeMillis()
                long r5 = r5 - r3
                long r7 = (long) r1
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 >= 0) goto L42
                r9.J$0 = r3
                r9.I$0 = r1
                r9.label = r2
                r5 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r10 = pe.w0.b(r5, r9)
                if (r10 != r0) goto L3e
                return r0
            L3e:
                java.lang.System.currentTimeMillis()
                goto L25
            L42:
                java.lang.String r10 = "Call:toDus"
                java.lang.String r0 = "[onIceConnectionChange.watchdog] ICE recovery timeout after 30 seconds - giving up"
                android.util.Log.e(r10, r0)
                cu.todus.android.webrtc.peer.StreamPeerConnection r10 = cu.todus.android.webrtc.peer.StreamPeerConnection.this
                kotlin.jvm.functions.Function2 r10 = cu.todus.android.webrtc.peer.StreamPeerConnection.access$getOnNegotiationNeeded$p(r10)
                if (r10 == 0) goto L5a
                cu.todus.android.webrtc.peer.StreamPeerConnection r0 = cu.todus.android.webrtc.peer.StreamPeerConnection.this
                cu.todus.android.webrtc.peer.StreamPeerType r1 = cu.todus.android.webrtc.peer.StreamPeerConnection.access$getType$p(r0)
                r10.invoke(r0, r1)
            L5a:
                ua.k0 r10 = ua.k0.f43947a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.peer.StreamPeerConnection.C13441.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13441) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    public StreamPeerConnection(m0 coroutineScope, StreamPeerType type, MediaConstraints mediaConstraints, Function1 function1, Function2 function2, Function2 function3, Function1 function4, lb.a onConnected) {
        y.i(coroutineScope, "coroutineScope");
        y.i(type, "type");
        y.i(mediaConstraints, "mediaConstraints");
        y.i(onConnected, "onConnected");
        this.coroutineScope = coroutineScope;
        this.type = type;
        this.constraints = mediaConstraints;
        this.onStreamAdded = function1;
        this.onNegotiationNeeded = function2;
        this.onIceCandidate = function3;
        this.onVideoTrack = function4;
        this.onConnected = onConnected;
        this.type = StringifyKt.stringify(type);
        this.pendingIceMutex = g.b(false, 1, null);
        this.pendingIceCandidates = new ArrayList();
        this.processedIceCandidatesNew = new LinkedHashSet();
        this.statsFlow = r0.a(null);
        Objects.toString(mediaConstraints);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String mungeCodecs(String str) {
        return a0.O(a0.O(a0.O(str, "vp9", "VP9", false, 4, null), "vp8", "VP8", false, 4, null), "h264", "H264", false, 4, null);
    }

    private final a2 observeStats() {
        return k.d(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void onIceCandidateNew(IceCandidate candidate) {
        String str = candidate.sdp;
        String str2 = candidate.sdpMid + candidate.sdpMLineIndex + str;
        y.f(str);
        if (!d0.Y(str, "typ relay", true)) {
            candidate.toString();
            return;
        }
        if (this.processedIceCandidatesNew.contains(str2)) {
            return;
        }
        this.processedIceCandidatesNew.add(str2);
        this.processedIceCandidatesNew.size();
        Function2 function2 = this.onIceCandidate;
        if (function2 != null) {
            function2.invoke(candidate, this.type);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
    
        if (r8.lock(null, r0) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        if (r7 == r1) goto L29;
     */
    /* JADX INFO: renamed from: addIceCandidate-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m10124addIceCandidategIAlus(org.webrtc.IceCandidate r7, ab.e<? super ua.u> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cu.todus.android.webrtc.peer.StreamPeerConnection$addIceCandidate$1
            if (r0 == 0) goto L13
            r0 = r8
            cu.todus.android.webrtc.peer.StreamPeerConnection$addIceCandidate$1 r0 = (cu.todus.android.webrtc.peer.StreamPeerConnection$addIceCandidate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.webrtc.peer.StreamPeerConnection$addIceCandidate$1 r0 = new cu.todus.android.webrtc.peer.StreamPeerConnection$addIceCandidate$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.L$0
            org.webrtc.IceCandidate r7 = (org.webrtc.IceCandidate) r7
            ua.v.b(r8)
            ua.u r8 = (ua.u) r8
            java.lang.Object r7 = r8.j()
            goto La4
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.L$1
            af.a r7 = (af.a) r7
            java.lang.Object r0 = r0.L$0
            org.webrtc.IceCandidate r0 = (org.webrtc.IceCandidate) r0
            ua.v.b(r8)
            r8 = r7
            r7 = r0
            goto L6f
        L4d:
            ua.v.b(r8)
            org.webrtc.PeerConnection r8 = r6.getConnection()
            org.webrtc.SessionDescription r8 = r8.getRemoteDescription()
            if (r8 != 0) goto L8e
            j$.util.Objects.toString(r7)
            af.a r8 = r6.pendingIceMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r2 = 0
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r0 = r8.lock(r5, r0)
            if (r0 != r1) goto L6f
            goto La3
        L6f:
            java.util.List<org.webrtc.IceCandidate> r0 = r6.pendingIceCandidates     // Catch: java.lang.Throwable -> L89
            r0.add(r7)     // Catch: java.lang.Throwable -> L89
            r8.unlock(r5)
            ua.u$a r7 = ua.u.f43963f
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "RemoteDescription is not set"
            r7.<init>(r8)
            java.lang.Object r7 = ua.v.a(r7)
            java.lang.Object r7 = ua.u.b(r7)
            return r7
        L89:
            r7 = move-exception
            r8.unlock(r5)
            throw r7
        L8e:
            j$.util.Objects.toString(r7)
            org.webrtc.PeerConnection r8 = r6.getConnection()
            java.lang.Object r2 = cb.l.a(r7)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = cu.todus.android.webrtc.utils.PeerConnectionUtilsKt.addRtcIceCandidate(r8, r7, r0)
            if (r7 != r1) goto La4
        La3:
            return r1
        La4:
            ua.u.i(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.peer.StreamPeerConnection.m10124addIceCandidategIAlus(org.webrtc.IceCandidate, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: createAnswer-IoAF18A, reason: not valid java name */
    public final Object m10125createAnswerIoAF18A(ab.e<? super u> eVar) {
        StreamPeerConnection$createAnswer$1 streamPeerConnection$createAnswer$1;
        if (eVar instanceof StreamPeerConnection$createAnswer$1) {
            streamPeerConnection$createAnswer$1 = (StreamPeerConnection$createAnswer$1) eVar;
            int i10 = streamPeerConnection$createAnswer$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                streamPeerConnection$createAnswer$1.label = i10 - Integer.MIN_VALUE;
            } else {
                streamPeerConnection$createAnswer$1 = new StreamPeerConnection$createAnswer$1(this, eVar);
            }
        } else {
            streamPeerConnection$createAnswer$1 = new StreamPeerConnection$createAnswer$1(this, eVar);
        }
        Object objA = streamPeerConnection$createAnswer$1.result;
        Object objG = bb.b.g();
        int i11 = streamPeerConnection$createAnswer$1.label;
        if (i11 == 0) {
            v.b(objA);
            streamPeerConnection$createAnswer$1.I$0 = 0;
            streamPeerConnection$createAnswer$1.label = 1;
            ab.k kVar = new ab.k(bb.b.d(streamPeerConnection$createAnswer$1));
            getConnection().createAnswer(new SDPUtilsKt$createValue$2$observer$1(kVar), this.constraints);
            objA = kVar.a();
            if (objA == bb.b.g()) {
                h.c(streamPeerConnection$createAnswer$1);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: createOffer-IoAF18A, reason: not valid java name */
    public final Object m10126createOfferIoAF18A(ab.e<? super u> eVar) {
        StreamPeerConnection$createOffer$1 streamPeerConnection$createOffer$1;
        if (eVar instanceof StreamPeerConnection$createOffer$1) {
            streamPeerConnection$createOffer$1 = (StreamPeerConnection$createOffer$1) eVar;
            int i10 = streamPeerConnection$createOffer$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                streamPeerConnection$createOffer$1.label = i10 - Integer.MIN_VALUE;
            } else {
                streamPeerConnection$createOffer$1 = new StreamPeerConnection$createOffer$1(this, eVar);
            }
        } else {
            streamPeerConnection$createOffer$1 = new StreamPeerConnection$createOffer$1(this, eVar);
        }
        Object objA = streamPeerConnection$createOffer$1.result;
        Object objG = bb.b.g();
        int i11 = streamPeerConnection$createOffer$1.label;
        if (i11 == 0) {
            v.b(objA);
            streamPeerConnection$createOffer$1.I$0 = 0;
            streamPeerConnection$createOffer$1.label = 1;
            ab.k kVar = new ab.k(bb.b.d(streamPeerConnection$createOffer$1));
            getConnection().createOffer(new SDPUtilsKt$createValue$2$observer$1(kVar), this.constraints);
            objA = kVar.a();
            if (objA == bb.b.g()) {
                h.c(streamPeerConnection$createOffer$1);
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

    public final PeerConnection getConnection() {
        PeerConnection peerConnection = this.connection;
        if (peerConnection != null) {
            return peerConnection;
        }
        y.w("connection");
        return null;
    }

    public final p0 getStats() {
        return this.statsFlow;
    }

    public final void initialize(PeerConnection peerConnection) {
        y.i(peerConnection, "peerConnection");
        Objects.toString(peerConnection);
        this.connection = peerConnection;
    }

    public final boolean isInitialized() {
        return this.connection != null;
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream stream) {
        Function1 function1;
        Objects.toString(stream);
        if (stream == null || (function1 = this.onStreamAdded) == null) {
            return;
        }
        function1.invoke(stream);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver receiver, MediaStream[] mediaStreams) {
        Objects.toString(receiver);
        if (mediaStreams != null) {
            for (MediaStream mediaStream : mediaStreams) {
                Objects.toString(mediaStream);
                List<AudioTrack> list = mediaStream.audioTracks;
                if (list != null) {
                    for (AudioTrack audioTrack : list) {
                        y.f(audioTrack);
                        StringifyKt.stringify(audioTrack);
                        audioTrack.setEnabled(true);
                    }
                }
                Function1 function1 = this.onStreamAdded;
                if (function1 != null) {
                    function1.invoke(mediaStream);
                }
            }
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onConnectionChange(PeerConnection.PeerConnectionState newState) {
        Objects.toString(newState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate candidate) {
        Objects.toString(candidate);
        if (candidate == null) {
            return;
        }
        onIceCandidateNew(candidate);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidateError(IceCandidateErrorEvent event) {
        if (event == null) {
            return;
        }
        Log.e(AudioSwitchHandler.TAG, "[onIceCandidateError] #sfu; #" + this.type + "; address=" + event.address + ", port=" + event.port + ", url=" + event.url + ", errorCode=" + event.errorCode + ", errorText=" + event.errorText);
        Log.e(AudioSwitchHandler.TAG, "[onIceCandidateError] TURN allocation failed - check credentials, firewall, or server availability");
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState newState) {
        Objects.toString(newState);
        switch (newState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[newState.ordinal()]) {
            case 1:
            case 2:
                break;
            case 3:
                Log.i(AudioSwitchHandler.TAG, "[onIceConnectionChange] ✅ ICE_CONNECTED - One or more pairs working");
                this.onConnected.invoke();
                this.statsJob = observeStats();
                break;
            case 4:
                Log.i(AudioSwitchHandler.TAG, "[onIceConnectionChange] ✅ ICE_COMPLETED - All pairs checked successfully");
                this.onConnected.invoke();
                this.statsJob = observeStats();
                break;
            case 5:
                Log.w(AudioSwitchHandler.TAG, "[onIceConnectionChange] ⚠️ ICE_DISCONNECTED - Connection lost, waiting for recovery...");
                break;
            case 6:
                a2 a2Var = this.statsJob;
                if (a2Var != null) {
                    a2.a.a(a2Var, null, 1, null);
                }
                Log.e(AudioSwitchHandler.TAG, "[onIceConnectionChange] ICE_FAILED - All candidate pairs failed");
                Log.e(AudioSwitchHandler.TAG, "[onIceConnectionChange] DEBUGGING INFO:");
                Log.e(AudioSwitchHandler.TAG, "  Remote Description set: " + (getConnection().getRemoteDescription() != null));
                Log.e(AudioSwitchHandler.TAG, "  Local Description set: " + (getConnection().getLocalDescription() != null));
                Log.e(AudioSwitchHandler.TAG, "  Recent ICE state: FAILED");
                Log.e(AudioSwitchHandler.TAG, "  Possible causes:");
                Log.e(AudioSwitchHandler.TAG, "    1. TURN server not reachable (firewall, DNS, or IP mismatch)");
                Log.e(AudioSwitchHandler.TAG, "    2. UDP/TCP relay ports (49152-65535) blocked");
                Log.e(AudioSwitchHandler.TAG, "    3. TURN credentials expired or invalid");
                Log.e(AudioSwitchHandler.TAG, "    4. NAT/Firewall preventing peer-to-peer or relay connection");
                Log.e(AudioSwitchHandler.TAG, "    5. Mismatch between local and remote SDP");
                Log.i(AudioSwitchHandler.TAG, "[onIceConnectionChange] Attempting ICE restart (RFC 8445)...");
                try {
                    getConnection().restartIce();
                    Function2 function2 = this.onNegotiationNeeded;
                    if (function2 != null) {
                        function2.invoke(this, this.type);
                    }
                    Log.i(AudioSwitchHandler.TAG, "[onIceConnectionChange] ICE restart initiated - waiting for new SDP");
                } catch (Exception e10) {
                    Log.e(AudioSwitchHandler.TAG, "[onIceConnectionChange] Error during ICE restart: " + e10.getMessage());
                }
                k.d(this.coroutineScope, null, null, new C13441(null), 3, null);
                break;
            case 7:
                Log.i(AudioSwitchHandler.TAG, "[onIceConnectionChange] ICE_CLOSED - Connection properly closed");
                a2 a2Var2 = this.statsJob;
                if (a2Var2 != null) {
                    a2.a.a(a2Var2, null, 1, null);
                }
                break;
            default:
                Objects.toString(newState);
                break;
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState newState) {
        Objects.toString(newState);
        if (newState == null) {
            return;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$1[newState.ordinal()];
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveTrack(RtpReceiver receiver) {
        Objects.toString(receiver);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        Function2 function2 = this.onNegotiationNeeded;
        if (function2 != null) {
            function2.invoke(this, this.type);
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSelectedCandidatePairChanged(CandidatePairChangeEvent event) {
        Objects.toString(event);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState newState) {
        Objects.toString(newState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        t0.f(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onTrack(RtpTransceiver transceiver) {
        Objects.toString(transceiver);
        Function1 function1 = this.onVideoTrack;
        if (function1 != null) {
            function1.invoke(transceiver);
        }
    }

    public final void resetProcessedIceCandidatesNew() {
        this.processedIceCandidatesNew.clear();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: setLocalDescription-gIAlu-s, reason: not valid java name */
    public final Object m10127setLocalDescriptiongIAlus(SessionDescription sessionDescription, ab.e<? super u> eVar) {
        StreamPeerConnection$setLocalDescription$1 streamPeerConnection$setLocalDescription$1;
        if (eVar instanceof StreamPeerConnection$setLocalDescription$1) {
            streamPeerConnection$setLocalDescription$1 = (StreamPeerConnection$setLocalDescription$1) eVar;
            int i10 = streamPeerConnection$setLocalDescription$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                streamPeerConnection$setLocalDescription$1.label = i10 - Integer.MIN_VALUE;
            } else {
                streamPeerConnection$setLocalDescription$1 = new StreamPeerConnection$setLocalDescription$1(this, eVar);
            }
        } else {
            streamPeerConnection$setLocalDescription$1 = new StreamPeerConnection$setLocalDescription$1(this, eVar);
        }
        Object objA = streamPeerConnection$setLocalDescription$1.result;
        Object objG = bb.b.g();
        int i11 = streamPeerConnection$setLocalDescription$1.label;
        if (i11 == 0) {
            v.b(objA);
            SessionDescription.Type type = sessionDescription.type;
            String description = sessionDescription.description;
            y.h(description, "description");
            SessionDescription sessionDescription2 = new SessionDescription(type, mungeCodecs(description));
            StringifyKt.stringify(sessionDescription);
            streamPeerConnection$setLocalDescription$1.L$0 = l.a(sessionDescription);
            streamPeerConnection$setLocalDescription$1.L$1 = sessionDescription2;
            streamPeerConnection$setLocalDescription$1.I$0 = 0;
            streamPeerConnection$setLocalDescription$1.label = 1;
            ab.k kVar = new ab.k(bb.b.d(streamPeerConnection$setLocalDescription$1));
            getConnection().setLocalDescription(new SDPUtilsKt$setValue$2$observer$1(kVar), sessionDescription2);
            objA = kVar.a();
            if (objA == bb.b.g()) {
                h.c(streamPeerConnection$setLocalDescription$1);
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

    /* JADX WARN: Code duplicated, block: B:34:0x0129 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:14:0x0058, B:32:0x0123, B:34:0x0129, B:38:0x017e, B:31:0x0113), top: B:43:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x017e A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #0 {all -> 0x0065, blocks: (B:14:0x0058, B:32:0x0123, B:34:0x0129, B:38:0x017e, B:31:0x0113), top: B:43:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0177, code lost:
    
        if (cu.todus.android.webrtc.utils.PeerConnectionUtilsKt.addRtcIceCandidate(r2, r9, r3) == r4) goto L36;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0177 -> B:37:0x017a). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: setRemoteDescription-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m10128setRemoteDescriptiongIAlus(org.webrtc.SessionDescription r18, ab.e<? super ua.u> r19) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.peer.StreamPeerConnection.m10128setRemoteDescriptiongIAlus(org.webrtc.SessionDescription, ab.e):java.lang.Object");
    }

    public String toString() {
        return "StreamPeerConnection(type='" + this.type + "', constraints=" + this.constraints + ")";
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel channel) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidates) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean receiving) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream stream) {
    }
}
