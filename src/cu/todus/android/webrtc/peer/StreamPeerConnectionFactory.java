package cu.todus.android.webrtc.peer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.rest.entity.NewEntity;
import cu.todus.android.data.xmpp.TurnCredentials;
import cu.todus.android.data.xmpp.TurnUri;
import cu.todus.android.webrtc.audio.AudioSwitchHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.EglBase;
import org.webrtc.HardwareVideoEncoderFactory;
import org.webrtc.Loggable;
import org.webrtc.Logging;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SimulcastVideoEncoderFactory;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.JavaAudioDeviceModule;
import org.webrtc.k;
import pe.m0;
import ua.n;
import ua.o;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J©\u0001\u0010\u001d\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00142\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00142\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J\u001d\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020!2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\b\b\u0002\u0010*\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\u001d\u0010/\u001a\u00020.2\u0006\u0010$\u001a\u00020+2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0012¢\u0006\u0004\b3\u00104R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\"\u0010:\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010808078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010;\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010DR\"\u0010G\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010F0F078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010;R\u001b\u0010L\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\bH\u0010I*\u0004\bJ\u0010KR\u0011\u0010P\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001b\u0010T\u001a\u00020F8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\bQ\u0010R*\u0004\bS\u0010K¨\u0006U"}, d2 = {"Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;", "", "Landroid/content/Context;", "context", "Lcu/todus/android/data/xmpp/TurnCredentials;", "turnCredentials", "<init>", "(Landroid/content/Context;Lcu/todus/android/data/xmpp/TurnCredentials;)V", "Lpe/m0;", "coroutineScope", "Lorg/webrtc/PeerConnection$RTCConfiguration;", "configuration", "Lcu/todus/android/webrtc/peer/StreamPeerType;", "type", "Lorg/webrtc/MediaConstraints;", "mediaConstraints", "Lkotlin/Function1;", "Lorg/webrtc/MediaStream;", "Lua/k0;", "onStreamAdded", "Lkotlin/Function2;", "Lcu/todus/android/webrtc/peer/StreamPeerConnection;", "onNegotiationNeeded", "Lorg/webrtc/IceCandidate;", "onIceCandidateRequest", "Lorg/webrtc/RtpTransceiver;", "onVideoTrack", "Lkotlin/Function0;", "onConnected", "makePeerConnection", "(Lpe/m0;Lorg/webrtc/PeerConnection$RTCConfiguration;Lcu/todus/android/webrtc/peer/StreamPeerType;Lorg/webrtc/MediaConstraints;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Llb/a;)Lcu/todus/android/webrtc/peer/StreamPeerConnection;", "", "isScreencast", "Lorg/webrtc/VideoSource;", "makeVideoSource", "(Z)Lorg/webrtc/VideoSource;", NewEntity.NEWS_CONFIG_SOURCE, "", "trackId", "Lorg/webrtc/VideoTrack;", "makeVideoTrack", "(Lorg/webrtc/VideoSource;Ljava/lang/String;)Lorg/webrtc/VideoTrack;", "constraints", "Lorg/webrtc/AudioSource;", "makeAudioSource", "(Lorg/webrtc/MediaConstraints;)Lorg/webrtc/AudioSource;", "Lorg/webrtc/AudioTrack;", "makeAudioTrack", "(Lorg/webrtc/AudioSource;Ljava/lang/String;)Lorg/webrtc/AudioTrack;", "createRtcConfigurationNew", "()Lorg/webrtc/PeerConnection$RTCConfiguration;", "dispose", "()V", "Landroid/content/Context;", "Lcu/todus/android/data/xmpp/TurnCredentials;", "Lua/n;", "Lorg/webrtc/EglBase;", "kotlin.jvm.PlatformType", "eglBaseLazy", "Lua/n;", "Lorg/webrtc/DefaultVideoDecoderFactory;", "videoDecoderFactory$delegate", "getVideoDecoderFactory", "()Lorg/webrtc/DefaultVideoDecoderFactory;", "videoDecoderFactory", "Lorg/webrtc/SimulcastVideoEncoderFactory;", "videoEncoderFactory$delegate", "getVideoEncoderFactory", "()Lorg/webrtc/SimulcastVideoEncoderFactory;", "videoEncoderFactory", "Lorg/webrtc/PeerConnectionFactory;", "factoryLazy", "getEglBase", "()Lorg/webrtc/EglBase;", "getEglBase$delegate", "(Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;)Ljava/lang/Object;", "eglBase", "Lorg/webrtc/EglBase$Context;", "getEglBaseContext", "()Lorg/webrtc/EglBase$Context;", "eglBaseContext", "getFactory", "()Lorg/webrtc/PeerConnectionFactory;", "getFactory$delegate", "factory", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StreamPeerConnectionFactory {
    public static final int $stable = 8;
    private final Context context;
    private final n eglBaseLazy;
    private final n factoryLazy;
    private final TurnCredentials turnCredentials;

    /* JADX INFO: renamed from: videoDecoderFactory$delegate, reason: from kotlin metadata */
    private final n videoDecoderFactory;

    /* JADX INFO: renamed from: videoEncoderFactory$delegate, reason: from kotlin metadata */
    private final n videoEncoderFactory;

    public StreamPeerConnectionFactory(Context context, TurnCredentials turnCredentials) {
        y.i(context, "context");
        y.i(turnCredentials, "turnCredentials");
        this.context = context;
        this.turnCredentials = turnCredentials;
        this.eglBaseLazy = o.a(new lb.a() { // from class: cu.todus.android.webrtc.peer.b
            @Override // lb.a
            public final Object invoke() {
                return k.b();
            }
        });
        this.videoDecoderFactory = o.a(new lb.a() { // from class: cu.todus.android.webrtc.peer.c
            @Override // lb.a
            public final Object invoke() {
                return StreamPeerConnectionFactory.videoDecoderFactory_delegate$lambda$0(this.f28769c);
            }
        });
        this.videoEncoderFactory = o.a(new lb.a() { // from class: cu.todus.android.webrtc.peer.d
            @Override // lb.a
            public final Object invoke() {
                return StreamPeerConnectionFactory.videoEncoderFactory_delegate$lambda$0(this.f28770c);
            }
        });
        this.factoryLazy = o.a(new lb.a() { // from class: cu.todus.android.webrtc.peer.e
            @Override // lb.a
            public final Object invoke() {
                return StreamPeerConnectionFactory.factoryLazy$lambda$0(this.f28771c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeerConnectionFactory factoryLazy$lambda$0(StreamPeerConnectionFactory streamPeerConnectionFactory) {
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(streamPeerConnectionFactory.context).setInjectableLogger(new Loggable() { // from class: cu.todus.android.webrtc.peer.f
            @Override // org.webrtc.Loggable
            public final void onLogMessage(String str, Logging.Severity severity, String str2) {
                StreamPeerConnectionFactory.factoryLazy$lambda$0$0(str, severity, str2);
            }
        }, Logging.Severity.LS_INFO).createInitializationOptions());
        PeerConnectionFactory.Builder videoEncoderFactory = PeerConnectionFactory.builder().setVideoDecoderFactory(streamPeerConnectionFactory.getVideoDecoderFactory()).setVideoEncoderFactory(streamPeerConnectionFactory.getVideoEncoderFactory());
        JavaAudioDeviceModule.Builder builder = JavaAudioDeviceModule.builder(streamPeerConnectionFactory.context);
        int i10 = Build.VERSION.SDK_INT;
        return videoEncoderFactory.setAudioDeviceModule(builder.setUseHardwareAcousticEchoCanceler(i10 >= 29).setUseHardwareNoiseSuppressor(i10 >= 29).createAudioDeviceModule()).createPeerConnectionFactory();
    }

    private final EglBase getEglBase() {
        Object value = this.eglBaseLazy.getValue();
        y.h(value, "getValue(...)");
        return (EglBase) value;
    }

    private final DefaultVideoDecoderFactory getVideoDecoderFactory() {
        return (DefaultVideoDecoderFactory) this.videoDecoderFactory.getValue();
    }

    private final SimulcastVideoEncoderFactory getVideoEncoderFactory() {
        return (SimulcastVideoEncoderFactory) this.videoEncoderFactory.getValue();
    }

    public static /* synthetic */ AudioSource makeAudioSource$default(StreamPeerConnectionFactory streamPeerConnectionFactory, MediaConstraints mediaConstraints, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mediaConstraints = new MediaConstraints();
        }
        return streamPeerConnectionFactory.makeAudioSource(mediaConstraints);
    }

    public static /* synthetic */ StreamPeerConnection makePeerConnection$default(StreamPeerConnectionFactory streamPeerConnectionFactory, m0 m0Var, PeerConnection.RTCConfiguration rTCConfiguration, StreamPeerType streamPeerType, MediaConstraints mediaConstraints, Function1 function1, Function2 function2, Function2 function3, Function1 function4, lb.a aVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            function1 = null;
        }
        if ((i10 & 32) != 0) {
            function2 = null;
        }
        if ((i10 & 64) != 0) {
            function3 = null;
        }
        if ((i10 & 128) != 0) {
            function4 = null;
        }
        return streamPeerConnectionFactory.makePeerConnection(m0Var, rTCConfiguration, streamPeerType, mediaConstraints, function1, function2, function3, function4, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultVideoDecoderFactory videoDecoderFactory_delegate$lambda$0(StreamPeerConnectionFactory streamPeerConnectionFactory) {
        return new DefaultVideoDecoderFactory(streamPeerConnectionFactory.getEglBaseContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimulcastVideoEncoderFactory videoEncoderFactory_delegate$lambda$0(StreamPeerConnectionFactory streamPeerConnectionFactory) {
        return new SimulcastVideoEncoderFactory(new HardwareVideoEncoderFactory(streamPeerConnectionFactory.getEglBaseContext(), true, true), new SoftwareVideoEncoderFactory());
    }

    public final PeerConnection.RTCConfiguration createRtcConfigurationNew() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PeerConnection.IceServer.builder("stun:l.google.com:19302").createIceServer());
        for (TurnUri turnUri : this.turnCredentials.getUris()) {
            String uri = a0.G(turnUri.getProto(), "tcp", true) ? turnUri.getUri() + "?transport=tcp" : turnUri.getUri();
            turnUri.getProto();
            this.turnCredentials.getUsername();
            arrayList.add(PeerConnection.IceServer.builder(uri).setUsername(this.turnCredentials.getUsername()).setPassword(this.turnCredentials.getPassword()).setTlsCertPolicy(PeerConnection.TlsCertPolicy.TLS_CERT_POLICY_INSECURE_NO_CHECK).createIceServer());
        }
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList);
        rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
        rTCConfiguration.iceTransportsType = PeerConnection.IceTransportsType.ALL;
        rTCConfiguration.iceConnectionReceivingTimeout = 10000;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        try {
            rTCConfiguration.iceCandidatePoolSize = 10;
            rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
            rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
            return rTCConfiguration;
        } catch (Exception e10) {
            Log.w(AudioSwitchHandler.TAG, "[createRtcConfigurationNew] Some RTCConfiguration properties not available on this API level: " + e10.getMessage());
            return rTCConfiguration;
        }
    }

    public final void dispose() {
        if (this.factoryLazy.isInitialized()) {
            getFactory().dispose();
        }
        if (this.eglBaseLazy.isInitialized()) {
            getEglBase().release();
        }
    }

    public final EglBase.Context getEglBaseContext() {
        EglBase.Context eglBaseContext = getEglBase().getEglBaseContext();
        y.h(eglBaseContext, "getEglBaseContext(...)");
        return eglBaseContext;
    }

    public final PeerConnectionFactory getFactory() {
        Object value = this.factoryLazy.getValue();
        y.h(value, "getValue(...)");
        return (PeerConnectionFactory) value;
    }

    public final AudioSource makeAudioSource(MediaConstraints constraints) {
        y.i(constraints, "constraints");
        AudioSource audioSourceCreateAudioSource = getFactory().createAudioSource(constraints);
        y.h(audioSourceCreateAudioSource, "createAudioSource(...)");
        return audioSourceCreateAudioSource;
    }

    public final AudioTrack makeAudioTrack(AudioSource source, String trackId) {
        y.i(source, "source");
        y.i(trackId, "trackId");
        AudioTrack audioTrackCreateAudioTrack = getFactory().createAudioTrack(trackId, source);
        y.h(audioTrackCreateAudioTrack, "createAudioTrack(...)");
        return audioTrackCreateAudioTrack;
    }

    public final StreamPeerConnection makePeerConnection(m0 coroutineScope, PeerConnection.RTCConfiguration configuration, StreamPeerType type, MediaConstraints mediaConstraints, Function1 onStreamAdded, Function2 onNegotiationNeeded, Function2 onIceCandidateRequest, Function1 onVideoTrack, lb.a onConnected) {
        y.i(coroutineScope, "coroutineScope");
        y.i(configuration, "configuration");
        y.i(type, "type");
        y.i(mediaConstraints, "mediaConstraints");
        y.i(onConnected, "onConnected");
        StreamPeerConnection streamPeerConnection = new StreamPeerConnection(coroutineScope, type, mediaConstraints, onStreamAdded, onNegotiationNeeded, onIceCandidateRequest, onVideoTrack, onConnected);
        PeerConnection peerConnectionCreatePeerConnection = getFactory().createPeerConnection(configuration, streamPeerConnection);
        if (peerConnectionCreatePeerConnection == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        streamPeerConnection.initialize(peerConnectionCreatePeerConnection);
        return streamPeerConnection;
    }

    public final VideoSource makeVideoSource(boolean isScreencast) {
        VideoSource videoSourceCreateVideoSource = getFactory().createVideoSource(isScreencast);
        y.h(videoSourceCreateVideoSource, "createVideoSource(...)");
        return videoSourceCreateVideoSource;
    }

    public final VideoTrack makeVideoTrack(VideoSource source, String trackId) {
        y.i(source, "source");
        y.i(trackId, "trackId");
        VideoTrack videoTrackCreateVideoTrack = getFactory().createVideoTrack(trackId, source);
        y.h(videoTrackCreateVideoTrack, "createVideoTrack(...)");
        return videoTrackCreateVideoTrack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void factoryLazy$lambda$0$0(String str, Logging.Severity severity, String str2) {
    }
}
