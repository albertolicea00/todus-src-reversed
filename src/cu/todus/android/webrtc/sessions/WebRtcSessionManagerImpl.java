package cu.todus.android.webrtc.sessions;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import androidx.window.core.layout.WindowSizeClass;
import cu.todus.android.connection.NetworkChangeMonitor;
import cu.todus.android.webrtc.ConfigKey;
import cu.todus.android.webrtc.SignalingCommand;
import cu.todus.android.webrtc.audio.AudioHandler;
import cu.todus.android.webrtc.audio.AudioSwitchHandler;
import cu.todus.android.webrtc.peer.StreamPeerConnection;
import cu.todus.android.webrtc.peer.StreamPeerConnectionFactory;
import cu.todus.android.webrtc.peer.StreamPeerType;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;
import le.d0;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera2Capturer;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStreamTrack;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import pe.d1;
import pe.m0;
import pe.n0;
import pe.w2;
import te.a0;
import te.b0;
import te.f0;
import te.h0;
import te.p0;
import te.r0;
import ua.k0;
import ua.u;
import ua.v;
import ua.z;
import va.r;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 ¿\u00012\u00020\u0001:\u0002¿\u0001Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u001d\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\nH\u0082@¢\u0006\u0004\b\"\u0010 J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0082@¢\u0006\u0004\b#\u0010 J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010)\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b)\u0010\u0017J\r\u0010*\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0007¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00020\u0007¢\u0006\u0004\b-\u0010+J\u0015\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\r¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\r¢\u0006\u0004\b1\u00100J\u0015\u00102\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\r¢\u0006\u0004\b2\u00100J\r\u00103\u001a\u00020\u0007¢\u0006\u0004\b3\u0010+J\r\u00104\u001a\u00020\u0007¢\u0006\u0004\b4\u0010+J\r\u00105\u001a\u00020\u0007¢\u0006\u0004\b5\u0010+J\r\u00106\u001a\u00020\r¢\u0006\u0004\b6\u00107J%\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u000208¢\u0006\u0004\b<\u0010=R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010B\u001a\u0004\bC\u0010DR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010ER\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010BR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010F\u001a\u0004\bG\u00107R\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010ER\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR&\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\\0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R&\u0010`\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\\0_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001c\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001f\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0f8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010eR\u001f\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0f8\u0006¢\u0006\f\n\u0004\bl\u0010h\u001a\u0004\bm\u0010jR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001d\u0010u\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010T\u001a\u0004\bs\u0010tR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020$0v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010TR\u001b\u0010|\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010T\u001a\u0004\bz\u0010{R\"\u0010\u007f\u001a\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010}0}0v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010TR\u001d\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010TR\u001c\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020c0v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010TR \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010T\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010T\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010TR\u001d\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010TR\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010FR)\u0010\u0096\u0001\u001a\u0014\u0012\u0004\u0012\u00020\n0\u0094\u0001j\t\u0012\u0004\u0012\u00020\n`\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R \u0010\u009f\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009c\u0001\u0010T\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010 \u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010FR\u0018\u0010¡\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010FR\u0018\u0010¢\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010FR\u001f\u0010¦\u0001\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\u000f\u001a\u0005\b£\u0001\u0010&*\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010ª\u0001\u001a\u00030§\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R \u0010®\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b«\u0001\u0010¬\u0001*\u0006\b\u00ad\u0001\u0010¥\u0001R!\u0010²\u0001\u001a\u00030\u0080\u00018BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b¯\u0001\u0010°\u0001*\u0006\b±\u0001\u0010¥\u0001R \u0010¶\u0001\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b³\u0001\u0010´\u0001*\u0006\bµ\u0001\u0010¥\u0001R!\u0010º\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b·\u0001\u0010¸\u0001*\u0006\b¹\u0001\u0010¥\u0001R!\u0010¾\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b»\u0001\u0010¼\u0001*\u0006\b½\u0001\u0010¥\u0001¨\u0006À\u0001"}, d2 = {"Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "", "Landroid/content/Context;", "context", "Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;", "peerConnectionFactory", "Lkotlin/Function0;", "Lua/k0;", "onError", "Lkotlin/Function1;", "", "sendCommandAsMsg", "onConnected", "", "ownerIsCalling", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;", "onNetworkChange", "<init>", "(Landroid/content/Context;Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;Llb/a;Lkotlin/jvm/functions/Function1;Llb/a;ZLkotlin/jvm/functions/Function1;)V", "Lcu/todus/android/webrtc/SignalingCommand;", "signalingCommand", "message", "sendCommand", "(Lcu/todus/android/webrtc/SignalingCommand;Ljava/lang/String;)V", "event", "handleNetworkChangeNew", "(Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;)V", "sendOffer", "(Lab/e;)Ljava/lang/Object;", "sendAnswer", "sdp", "handleAnswer", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "ice", "handleIceNew", "handleOfferNew", "Lorg/webrtc/VideoCapturer;", "buildCameraCapturer", "()Lorg/webrtc/VideoCapturer;", "command", "text", "handleSignalingCommand", "addTracksWithValidationSmartNew", "()V", "onSessionScreenReady", "flipCamera", "enabled", "enableMicrophone", "(Z)V", "enableCamera", "setSpeakerphoneOnNew", "disconnect", "disconnectNew", "enableIceSendingOnRingNew", "isPeerConnectionInitializedNew", "()Z", "", "minBitrate", "currentBitrate", "maxBitrate", "setBitrateNew", "(III)V", "Landroid/content/Context;", "Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;", "getPeerConnectionFactory", "()Lcu/todus/android/webrtc/peer/StreamPeerConnectionFactory;", "Llb/a;", "getOnError", "()Llb/a;", "Lkotlin/jvm/functions/Function1;", "Z", "getOwnerIsCalling", "Lpe/m0;", "sessionManagerScope", "Lpe/m0;", "Laf/a;", "disconnectMutex", "Laf/a;", "isDisconnected", "Landroid/os/Handler;", "mainThreadHandler", "Landroid/os/Handler;", "Lcu/todus/android/connection/NetworkChangeMonitor;", "networkMonitor$delegate", "Lua/n;", "getNetworkMonitor", "()Lcu/todus/android/connection/NetworkChangeMonitor;", "networkMonitor", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "lastNetworkType", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkType;", "Lte/a0;", "Lkotlin/Pair;", "_signalingCommandFlow", "Lte/a0;", "Lte/f0;", "signalingCommandFlow", "Lte/f0;", "Lte/b0;", "Lorg/webrtc/VideoTrack;", "_localVideoTrackFlow", "Lte/b0;", "Lte/p0;", "localVideoTrackFlow", "Lte/p0;", "getLocalVideoTrackFlow", "()Lte/p0;", "_remoteVideoTrackFlow", "remoteVideoTrackFlow", "getRemoteVideoTrackFlow", "Lorg/webrtc/MediaConstraints;", "mediaConstraints", "Lorg/webrtc/MediaConstraints;", "Landroid/hardware/camera2/CameraManager;", "cameraManager$delegate", "getCameraManager", "()Landroid/hardware/camera2/CameraManager;", "cameraManager", "Lua/n;", "videoCapturerLazy", "Lorg/webrtc/Camera2Enumerator;", "cameraEnumerator$delegate", "getCameraEnumerator", "()Lorg/webrtc/Camera2Enumerator;", "cameraEnumerator", "Lorg/webrtc/SurfaceTextureHelper;", "kotlin.jvm.PlatformType", "surfaceTextureHelperLazy", "Lorg/webrtc/VideoSource;", "videoSourceLazy", "localVideoTrackLazy", "Lcu/todus/android/webrtc/audio/AudioHandler;", "audioHandler$delegate", "getAudioHandler", "()Lcu/todus/android/webrtc/audio/AudioHandler;", "audioHandler", "Landroid/media/AudioManager;", "audioManager$delegate", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager", "Lorg/webrtc/AudioSource;", "audioSourceLazy", "Lorg/webrtc/AudioTrack;", "localAudioTrackLazy", "offer", "Ljava/lang/String;", "startSendIce", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "iceArray", "Ljava/util/ArrayList;", "", "sentIceCandidatesNew", "Ljava/util/Set;", "Lcu/todus/android/webrtc/peer/StreamPeerConnection;", "peerConnection$delegate", "getPeerConnection", "()Lcu/todus/android/webrtc/peer/StreamPeerConnection;", "peerConnection", "answerSent", "offerSent", "tracksAdded", "getVideoCapturer", "getVideoCapturer$delegate", "(Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;)Ljava/lang/Object;", "videoCapturer", "Lorg/webrtc/CameraEnumerationAndroid$CaptureFormat;", "getResolution", "()Lorg/webrtc/CameraEnumerationAndroid$CaptureFormat;", "resolution", "getSurfaceTextureHelper", "()Lorg/webrtc/SurfaceTextureHelper;", "getSurfaceTextureHelper$delegate", "surfaceTextureHelper", "getVideoSource", "()Lorg/webrtc/VideoSource;", "getVideoSource$delegate", "videoSource", "getLocalVideoTrack", "()Lorg/webrtc/VideoTrack;", "getLocalVideoTrack$delegate", "localVideoTrack", "getAudioSource", "()Lorg/webrtc/AudioSource;", "getAudioSource$delegate", "audioSource", "getLocalAudioTrack", "()Lorg/webrtc/AudioTrack;", "getLocalAudioTrack$delegate", "localAudioTrack", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebRtcSessionManagerImpl {
    public static final String TAG = "WebRtcSession";
    private final b0 _localVideoTrackFlow;
    private final b0 _remoteVideoTrackFlow;
    private final a0 _signalingCommandFlow;
    private boolean answerSent;

    /* JADX INFO: renamed from: audioHandler$delegate, reason: from kotlin metadata */
    private final ua.n audioHandler;

    /* JADX INFO: renamed from: audioManager$delegate, reason: from kotlin metadata */
    private final ua.n audioManager;
    private final ua.n audioSourceLazy;

    /* JADX INFO: renamed from: cameraEnumerator$delegate, reason: from kotlin metadata */
    private final ua.n cameraEnumerator;

    /* JADX INFO: renamed from: cameraManager$delegate, reason: from kotlin metadata */
    private final ua.n cameraManager;
    private final Context context;
    private final af.a disconnectMutex;
    private final ArrayList<String> iceArray;
    private boolean isDisconnected;
    private NetworkChangeMonitor.NetworkType lastNetworkType;
    private final ua.n localAudioTrackLazy;
    private final p0 localVideoTrackFlow;
    private final ua.n localVideoTrackLazy;
    private final Handler mainThreadHandler;
    private final MediaConstraints mediaConstraints;

    /* JADX INFO: renamed from: networkMonitor$delegate, reason: from kotlin metadata */
    private final ua.n networkMonitor;
    private String offer;
    private boolean offerSent;
    private final lb.a onConnected;
    private final lb.a onError;
    private final Function1 onNetworkChange;
    private final boolean ownerIsCalling;

    /* JADX INFO: renamed from: peerConnection$delegate, reason: from kotlin metadata */
    private final ua.n peerConnection;
    private final StreamPeerConnectionFactory peerConnectionFactory;
    private final p0 remoteVideoTrackFlow;
    private final Function1 sendCommandAsMsg;
    private final Set<String> sentIceCandidatesNew;
    private final m0 sessionManagerScope;
    private final f0 signalingCommandFlow;
    private boolean startSendIce;
    private final ua.n surfaceTextureHelperLazy;
    private boolean tracksAdded;
    private final ua.n videoCapturerLazy;
    private final ua.n videoSourceLazy;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$2", f = "WebRtcSessionManagerImpl.kt", l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return WebRtcSessionManagerImpl.this.new AnonymousClass2(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                f0 f0Var = WebRtcSessionManagerImpl.this.signalingCommandFlow;
                final WebRtcSessionManagerImpl webRtcSessionManagerImpl = WebRtcSessionManagerImpl.this;
                te.i iVar = new te.i() { // from class: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.2.1

                    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$2$1$WhenMappings */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    public static final /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SignalingCommand.values().length];
                            try {
                                iArr[SignalingCommand.OFFER.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[SignalingCommand.ANSWER.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[SignalingCommand.ICE.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // te.i
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, ab.e eVar) {
                        return emit((Pair<? extends SignalingCommand, String>) obj2, (ab.e<? super k0>) eVar);
                    }

                    public final Object emit(Pair<? extends SignalingCommand, String> pair, ab.e<? super k0> eVar) {
                        SignalingCommand signalingCommandComponent1 = pair.component1();
                        String strComponent2 = pair.component2();
                        if (webRtcSessionManagerImpl.isDisconnected) {
                            return k0.f43947a;
                        }
                        int i11 = WhenMappings.$EnumSwitchMapping$0[signalingCommandComponent1.ordinal()];
                        if (i11 == 1) {
                            Object objHandleOfferNew = webRtcSessionManagerImpl.handleOfferNew(strComponent2, eVar);
                            return objHandleOfferNew == bb.b.g() ? objHandleOfferNew : k0.f43947a;
                        }
                        if (i11 == 2) {
                            Object objHandleAnswer = webRtcSessionManagerImpl.handleAnswer(strComponent2, eVar);
                            return objHandleAnswer == bb.b.g() ? objHandleAnswer : k0.f43947a;
                        }
                        if (i11 != 3) {
                            return k0.f43947a;
                        }
                        Object objHandleIceNew = webRtcSessionManagerImpl.handleIceNew(strComponent2, eVar);
                        return objHandleIceNew == bb.b.g() ? objHandleIceNew : k0.f43947a;
                    }
                };
                this.label = 1;
                if (f0Var.collect(iVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            throw new ua.j();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$3", f = "WebRtcSessionManagerImpl.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return WebRtcSessionManagerImpl.this.new AnonymousClass3(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            try {
                WebRtcSessionManagerImpl.this.getNetworkMonitor().startMonitoring();
            } catch (Exception e10) {
                Log.e(WebRtcSessionManagerImpl.TAG, "[init] Error al iniciar monitoreo: " + e10.getMessage());
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$4", f = "WebRtcSessionManagerImpl.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;", "event", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass4 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(ab.e<? super AnonymousClass4> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass4 anonymousClass4 = WebRtcSessionManagerImpl.this.new AnonymousClass4(eVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkChangeMonitor.NetworkChangeEvent networkChangeEvent, ab.e<? super k0> eVar) {
            return ((AnonymousClass4) create(networkChangeEvent, eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            NetworkChangeMonitor.NetworkChangeEvent networkChangeEvent = (NetworkChangeMonitor.NetworkChangeEvent) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            if (!WebRtcSessionManagerImpl.this.isDisconnected) {
                WebRtcSessionManagerImpl.this.handleNetworkChangeNew(networkChangeEvent);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$5", f = "WebRtcSessionManagerImpl.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/connection/NetworkChangeMonitor$NetworkChangeEvent;", "", "exception", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass5 extends cb.m implements Function3 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(ab.e<? super AnonymousClass5> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Throwable th2 = (Throwable) this.L$0;
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            Log.e(WebRtcSessionManagerImpl.TAG, "[init] Error en flow de red: " + th2.getMessage());
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super k0> eVar) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(eVar);
            anonymousClass5.L$0 = th2;
            return anonymousClass5.invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl$Companion;", "", "<init>", "()V", "splitCallCmd", "", "text", "TAG", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        public final String splitCallCmd(String text) {
            y.i(text, "text");
            return d0.b1(text, ' ', null, 2, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkChangeMonitor.ConnectionType.values().length];
            try {
                iArr[NetworkChangeMonitor.ConnectionType.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkChangeMonitor.ConnectionType.CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkChangeMonitor.ConnectionType.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkChangeMonitor.ConnectionType.RECONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$disconnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$disconnect$1", f = "WebRtcSessionManagerImpl.kt", l = {TypedValues.MotionType.TYPE_PATHMOTION_ARC}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return WebRtcSessionManagerImpl.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            af.a aVar;
            WebRtcSessionManagerImpl webRtcSessionManagerImpl;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                aVar = WebRtcSessionManagerImpl.this.disconnectMutex;
                WebRtcSessionManagerImpl webRtcSessionManagerImpl2 = WebRtcSessionManagerImpl.this;
                this.L$0 = aVar;
                this.L$1 = webRtcSessionManagerImpl2;
                this.I$0 = 0;
                this.label = 1;
                if (aVar.lock(null, this) == objG) {
                    return objG;
                }
                webRtcSessionManagerImpl = webRtcSessionManagerImpl2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                webRtcSessionManagerImpl = (WebRtcSessionManagerImpl) this.L$1;
                aVar = (af.a) this.L$0;
                v.b(obj);
            }
            try {
                if (webRtcSessionManagerImpl.isDisconnected) {
                    k0 k0Var = k0.f43947a;
                    aVar.unlock(null);
                    return k0Var;
                }
                webRtcSessionManagerImpl.isDisconnected = true;
                try {
                    webRtcSessionManagerImpl.getNetworkMonitor().stopMonitoring();
                } catch (Exception e10) {
                    try {
                        Log.e(WebRtcSessionManagerImpl.TAG, "[disconnect] Error al detener networkMonitor: " + e10.getMessage());
                    } catch (Exception e11) {
                        Log.e(WebRtcSessionManagerImpl.TAG, "Error en disconnect: " + e11.getMessage());
                    }
                }
                if (webRtcSessionManagerImpl.videoCapturerLazy.isInitialized()) {
                    try {
                        webRtcSessionManagerImpl.getVideoCapturer().stopCapture();
                    } catch (Exception unused) {
                    }
                }
                if (webRtcSessionManagerImpl.getPeerConnection().isInitialized()) {
                    webRtcSessionManagerImpl.getPeerConnection().getConnection().close();
                    webRtcSessionManagerImpl.getPeerConnection().getConnection().dispose();
                }
                if (webRtcSessionManagerImpl.localVideoTrackLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getLocalVideoTrack().dispose();
                }
                if (webRtcSessionManagerImpl.localAudioTrackLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getLocalAudioTrack().dispose();
                }
                if (webRtcSessionManagerImpl.videoSourceLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getVideoSource().dispose();
                }
                if (webRtcSessionManagerImpl.audioSourceLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getAudioSource().dispose();
                }
                webRtcSessionManagerImpl.getAudioHandler().stop();
                if (webRtcSessionManagerImpl.videoCapturerLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getVideoCapturer().dispose();
                }
                if (webRtcSessionManagerImpl.surfaceTextureHelperLazy.isInitialized()) {
                    webRtcSessionManagerImpl.getSurfaceTextureHelper().dispose();
                }
                n0.d(webRtcSessionManagerImpl.sessionManagerScope, null, 1, null);
                webRtcSessionManagerImpl.getPeerConnectionFactory().dispose();
                k0 k0Var2 = k0.f43947a;
                aVar.unlock(null);
                return k0.f43947a;
            } catch (Throwable th2) {
                aVar.unlock(null);
                throw th2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$handleAnswer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl", f = "WebRtcSessionManagerImpl.kt", l = {499}, m = "handleAnswer", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13451 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13451(ab.e<? super C13451> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebRtcSessionManagerImpl.this.handleAnswer(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$handleIceNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl", f = "WebRtcSessionManagerImpl.kt", l = {522}, m = "handleIceNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13461 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13461(ab.e<? super C13461> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebRtcSessionManagerImpl.this.handleIceNew(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$handleOfferNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl", f = "WebRtcSessionManagerImpl.kt", l = {583}, m = "handleOfferNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13471 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13471(ab.e<? super C13471> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebRtcSessionManagerImpl.this.handleOfferNew(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$handleSignalingCommand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$handleSignalingCommand$1", f = "WebRtcSessionManagerImpl.kt", l = {88}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13481 extends cb.m implements Function2 {
        final /* synthetic */ SignalingCommand $command;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13481(SignalingCommand signalingCommand, String str, ab.e<? super C13481> eVar) {
            super(2, eVar);
            this.$command = signalingCommand;
            this.$value = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return WebRtcSessionManagerImpl.this.new C13481(this.$command, this.$value, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                a0 a0Var = WebRtcSessionManagerImpl.this._signalingCommandFlow;
                Pair pairA = z.a(this.$command, this.$value);
                this.label = 1;
                if (a0Var.emit(pairA, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13481) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$onSessionScreenReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$onSessionScreenReady$1", f = "WebRtcSessionManagerImpl.kt", l = {255, 261}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C13491 extends cb.m implements Function2 {
        int label;

        public C13491(ab.e<? super C13491> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return WebRtcSessionManagerImpl.this.new C13491(eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        
            if (r5.sendAnswer(r4) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        
            if (r5.sendOffer(r4) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                ua.v.b(r5)
                goto L78
            L1b:
                ua.v.b(r5)
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$isDisconnected$p(r5)
                if (r5 == 0) goto L29
                ua.k0 r5 = ua.k0.f43947a
                return r5
            L29:
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                te.b0 r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$get_localVideoTrackFlow$p(r5)
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r1 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                org.webrtc.VideoTrack r1 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getLocalVideoTrack(r1)
                r5.setValue(r1)
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                java.lang.String r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getOffer$p(r5)
                if (r5 == 0) goto L58
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getAnswerSent$p(r5)
                if (r5 != 0) goto L58
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$setAnswerSent$p(r5, r3)
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                r4.label = r3
                java.lang.Object r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$sendAnswer(r5, r4)
                if (r5 != r0) goto L78
                goto L77
            L58:
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = r5.getOwnerIsCalling()
                if (r5 == 0) goto L78
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getOfferSent$p(r5)
                if (r5 != 0) goto L78
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$setOfferSent$p(r5, r3)
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                r4.label = r2
                java.lang.Object r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$sendOffer(r5, r4)
                if (r5 != r0) goto L78
            L77:
                return r0
            L78:
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getAnswerSent$p(r5)
                if (r5 != 0) goto L88
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                boolean r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.access$getOfferSent$p(r5)
                if (r5 == 0) goto L8d
            L88:
                cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl r5 = cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.this
                r5.enableIceSendingOnRingNew()
            L8d:
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl.C13491.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C13491) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$sendAnswer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl", f = "WebRtcSessionManagerImpl.kt", l = {WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 482}, m = "sendAnswer", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13501 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13501(ab.e<? super C13501> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebRtcSessionManagerImpl.this.sendAnswer(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl$sendOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl", f = "WebRtcSessionManagerImpl.kt", l = {462, 464}, m = "sendOffer", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13511 extends cb.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13511(ab.e<? super C13511> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebRtcSessionManagerImpl.this.sendOffer(this);
        }
    }

    public WebRtcSessionManagerImpl(Context context, StreamPeerConnectionFactory peerConnectionFactory, lb.a onError, Function1 sendCommandAsMsg, lb.a onConnected, boolean z10, Function1 function1) {
        y.i(context, "context");
        y.i(peerConnectionFactory, "peerConnectionFactory");
        y.i(onError, "onError");
        y.i(sendCommandAsMsg, "sendCommandAsMsg");
        y.i(onConnected, "onConnected");
        this.context = context;
        this.peerConnectionFactory = peerConnectionFactory;
        this.onError = onError;
        this.sendCommandAsMsg = sendCommandAsMsg;
        this.onConnected = onConnected;
        this.ownerIsCalling = z10;
        this.onNetworkChange = function1;
        m0 m0VarA = n0.a(w2.b(null, 1, null).plus(d1.a()));
        this.sessionManagerScope = m0VarA;
        this.disconnectMutex = af.g.b(false, 1, null);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.networkMonitor = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.j
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.networkMonitor_delegate$lambda$0(this.f28780c);
            }
        });
        this.lastNetworkType = getNetworkMonitor().getCurrentNetworkType();
        a0 a0VarB = h0.b(0, 0, null, 7, null);
        this._signalingCommandFlow = a0VarB;
        this.signalingCommandFlow = a0VarB;
        b0 b0VarA = r0.a(null);
        this._localVideoTrackFlow = b0VarA;
        this.localVideoTrackFlow = te.j.b(b0VarA);
        b0 b0VarA2 = r0.a(null);
        this._remoteVideoTrackFlow = b0VarA2;
        this.remoteVideoTrackFlow = te.j.b(b0VarA2);
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(ConstraintsKeys.KEY_OFFER_TO_RECEIVE_AUDIO, "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(ConstraintsKeys.KEY_OFFER_TO_RECEIVE_VIDEO, "true"));
        this.mediaConstraints = mediaConstraints;
        this.cameraManager = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.m
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.cameraManager_delegate$lambda$0(this.f28783c);
            }
        });
        this.videoCapturerLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.n
            @Override // lb.a
            public final Object invoke() {
                return this.f28784c.buildCameraCapturer();
            }
        });
        this.cameraEnumerator = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.o
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.cameraEnumerator_delegate$lambda$0(this.f28785c);
            }
        });
        this.surfaceTextureHelperLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.p
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.surfaceTextureHelperLazy$lambda$0(this.f28786c);
            }
        });
        this.videoSourceLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.b
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.videoSourceLazy$lambda$0(this.f28773c);
            }
        });
        this.localVideoTrackLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.c
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.localVideoTrackLazy$lambda$0(this.f28774c);
            }
        });
        this.audioHandler = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.d
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.audioHandler_delegate$lambda$0(this.f28775c);
            }
        });
        this.audioManager = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.e
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.audioManager_delegate$lambda$0(this.f28776c);
            }
        });
        this.audioSourceLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.f
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.audioSourceLazy$lambda$0(this.f28777c);
            }
        });
        this.localAudioTrackLazy = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.k
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.localAudioTrackLazy$lambda$0(this.f28781c);
            }
        });
        this.iceArray = new ArrayList<>();
        this.sentIceCandidatesNew = new LinkedHashSet();
        this.peerConnection = ua.o.a(new lb.a() { // from class: cu.todus.android.webrtc.sessions.l
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.peerConnection_delegate$lambda$0(this.f28782c);
            }
        });
        pe.k.d(m0VarA, d1.c(), null, new AnonymousClass2(null), 2, null);
        pe.k.d(m0VarA, null, null, new AnonymousClass3(null), 3, null);
        te.j.F(te.j.g(te.j.K(getNetworkMonitor().getNetworkChangeFlow(), new AnonymousClass4(null)), new AnonymousClass5(null)), m0VarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 _init_$lambda$0(String it) {
        y.i(it, "it");
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioSwitchHandler audioHandler_delegate$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return new AudioSwitchHandler(webRtcSessionManagerImpl.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager audioManager_delegate$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return (AudioManager) ContextCompat.getSystemService(webRtcSessionManagerImpl.context, AudioManager.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioSource audioSourceLazy$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return webRtcSessionManagerImpl.peerConnectionFactory.makeAudioSource(new MediaConstraints());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoCapturer buildCameraCapturer() throws CameraAccessException {
        String str;
        CameraManager cameraManager = getCameraManager();
        if (cameraManager == null) {
            throw new RuntimeException("No CameraManager");
        }
        String[] cameraIdList = cameraManager.getCameraIdList();
        y.h(cameraIdList, "getCameraIdList(...)");
        int length = cameraIdList.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = null;
                break;
            }
            str = cameraIdList[i10];
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == 0) {
                break;
            }
            i10++;
        }
        if (str == null) {
            str = (String) r.w0(cameraIdList);
        }
        return new Camera2Capturer(this.context, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Camera2Enumerator cameraEnumerator_delegate$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return new Camera2Enumerator(webRtcSessionManagerImpl.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraManager cameraManager_delegate$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return (CameraManager) ContextCompat.getSystemService(webRtcSessionManagerImpl.context, CameraManager.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudioHandler getAudioHandler() {
        return (AudioHandler) this.audioHandler.getValue();
    }

    private final AudioManager getAudioManager() {
        return (AudioManager) this.audioManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudioSource getAudioSource() {
        return (AudioSource) this.audioSourceLazy.getValue();
    }

    private final Camera2Enumerator getCameraEnumerator() {
        return (Camera2Enumerator) this.cameraEnumerator.getValue();
    }

    private final CameraManager getCameraManager() {
        return (CameraManager) this.cameraManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudioTrack getLocalAudioTrack() {
        return (AudioTrack) this.localAudioTrackLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoTrack getLocalVideoTrack() {
        return (VideoTrack) this.localVideoTrackLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkChangeMonitor getNetworkMonitor() {
        return (NetworkChangeMonitor) this.networkMonitor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreamPeerConnection getPeerConnection() {
        return (StreamPeerConnection) this.peerConnection.getValue();
    }

    private final CameraEnumerationAndroid.CaptureFormat getResolution() {
        Object obj;
        String str;
        String[] deviceNames = getCameraEnumerator().getDeviceNames();
        y.h(deviceNames, "getDeviceNames(...)");
        int length = deviceNames.length;
        int i10 = 0;
        while (true) {
            obj = null;
            if (i10 >= length) {
                str = null;
                break;
            }
            str = deviceNames[i10];
            if (getCameraEnumerator().isFrontFacing(str)) {
                break;
            }
            i10++;
        }
        if (str == null) {
            String[] deviceNames2 = getCameraEnumerator().getDeviceNames();
            y.h(deviceNames2, "getDeviceNames(...)");
            str = (String) r.w0(deviceNames2);
        }
        List<CameraEnumerationAndroid.CaptureFormat> supportedFormats = getCameraEnumerator().getSupportedFormats(str);
        if (supportedFormats != null) {
            for (Object obj2 : supportedFormats) {
                if (((CameraEnumerationAndroid.CaptureFormat) obj2).width <= 720) {
                    obj = obj2;
                    break;
                }
            }
            CameraEnumerationAndroid.CaptureFormat captureFormat = (CameraEnumerationAndroid.CaptureFormat) obj;
            if (captureFormat != null) {
                return captureFormat;
            }
        }
        throw new IllegalStateException("No resolution");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurfaceTextureHelper getSurfaceTextureHelper() {
        Object value = this.surfaceTextureHelperLazy.getValue();
        y.h(value, "getValue(...)");
        return (SurfaceTextureHelper) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoCapturer getVideoCapturer() {
        return (VideoCapturer) this.videoCapturerLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSource getVideoSource() {
        return (VideoSource) this.videoSourceLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleAnswer(String str, ab.e<? super k0> eVar) {
        C13451 c13451;
        if (eVar instanceof C13451) {
            c13451 = (C13451) eVar;
            int i10 = c13451.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13451.label = i10 - Integer.MIN_VALUE;
            } else {
                c13451 = new C13451(eVar);
            }
        } else {
            c13451 = new C13451(eVar);
        }
        Object obj = c13451.result;
        Object objG = bb.b.g();
        int i11 = c13451.label;
        try {
            if (i11 == 0) {
                v.b(obj);
                if (this.isDisconnected) {
                    return k0.f43947a;
                }
                StreamPeerConnection peerConnection = getPeerConnection();
                SessionDescription sessionDescription = new SessionDescription(SessionDescription.Type.ANSWER, str);
                c13451.L$0 = cb.l.a(str);
                c13451.label = 1;
                if (peerConnection.m10128setRemoteDescriptiongIAlus(sessionDescription, c13451) == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                ((u) obj).j();
            }
            enableIceSendingOnRingNew();
        } catch (Exception e10) {
            Log.e(TAG, "[handleAnswer] Error procesando ANSWER: " + e10.getMessage(), e10);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleIceNew(String str, ab.e<? super k0> eVar) {
        C13461 c13461;
        Object objM10124addIceCandidategIAlus;
        if (eVar instanceof C13461) {
            c13461 = (C13461) eVar;
            int i10 = c13461.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13461.label = i10 - Integer.MIN_VALUE;
            } else {
                c13461 = new C13461(eVar);
            }
        } else {
            c13461 = new C13461(eVar);
        }
        Object obj = c13461.result;
        Object objG = bb.b.g();
        int i11 = c13461.label;
        try {
            if (i11 == 0) {
                v.b(obj);
                if (this.isDisconnected) {
                    return k0.f43947a;
                }
                List listR0 = d0.R0(str, new char[]{'$'}, false, 0, 6, null);
                if (listR0.size() == 3) {
                    Object obj2 = listR0.get(0);
                    Object obj3 = listR0.get(1);
                    Objects.toString(obj2);
                    Objects.toString(obj3);
                    IceCandidate iceCandidate = new IceCandidate((String) listR0.get(0), Integer.parseInt((String) listR0.get(1)), (String) listR0.get(2));
                    StreamPeerConnection peerConnection = getPeerConnection();
                    c13461.L$0 = cb.l.a(str);
                    c13461.L$1 = cb.l.a(listR0);
                    c13461.L$2 = cb.l.a(iceCandidate);
                    c13461.label = 1;
                    objM10124addIceCandidategIAlus = peerConnection.m10124addIceCandidategIAlus(iceCandidate, c13461);
                    if (objM10124addIceCandidategIAlus == objG) {
                        return objG;
                    }
                } else {
                    cb.b.d(Log.w(TAG, "[handleIceNew] Formato ICE inválido. Esperado: mid$mline$sdp. Recibido: " + str));
                }
                return k0.f43947a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            objM10124addIceCandidategIAlus = ((u) obj).j();
            if (!u.h(objM10124addIceCandidategIAlus)) {
                Log.w(TAG, "[handleIceNew] Candidato encolado - esperando descripciones locales/remotas");
            }
            if (!this.startSendIce && (this.offerSent || this.answerSent)) {
                enableIceSendingOnRingNew();
            }
            k0 k0Var = k0.f43947a;
        } catch (Exception e10) {
            cb.b.d(Log.e(TAG, "[handleIceNew] Error agregando ICE: " + e10.getMessage(), e10));
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNetworkChangeNew(NetworkChangeMonitor.NetworkChangeEvent event) {
        NetworkChangeMonitor.NetworkType type = event.getType();
        NetworkChangeMonitor.ConnectionType connectionType = event.getConnectionType();
        Objects.toString(type);
        Objects.toString(connectionType);
        Function1 function1 = this.onNetworkChange;
        if (function1 != null) {
            function1.invoke(event);
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[event.getConnectionType().ordinal()];
        if (i10 == 1) {
            Objects.toString(event.getType());
            this.lastNetworkType = event.getType();
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                Log.e(TAG, "[handleNetworkChangeNew] RED DESCONECTADA");
                this.lastNetworkType = null;
                return;
            } else {
                if (i10 != 4) {
                    throw new ua.r();
                }
                Objects.toString(event.getType());
                this.lastNetworkType = event.getType();
                return;
            }
        }
        Log.w(TAG, "[handleNetworkChangeNew] RED CAMBIÓ: " + this.lastNetworkType + " → " + event.getType());
        this.lastNetworkType = event.getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleOfferNew(String str, ab.e<? super k0> eVar) {
        C13471 c13471;
        if (eVar instanceof C13471) {
            c13471 = (C13471) eVar;
            int i10 = c13471.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13471.label = i10 - Integer.MIN_VALUE;
            } else {
                c13471 = new C13471(eVar);
            }
        } else {
            c13471 = new C13471(eVar);
        }
        Object obj = c13471.result;
        Object objG = bb.b.g();
        int i11 = c13471.label;
        if (i11 == 0) {
            v.b(obj);
            if (this.isDisconnected) {
                return k0.f43947a;
            }
            this.offer = str;
            StreamPeerConnection peerConnection = getPeerConnection();
            SessionDescription sessionDescription = new SessionDescription(SessionDescription.Type.OFFER, str);
            c13471.L$0 = cb.l.a(str);
            c13471.label = 1;
            if (peerConnection.m10128setRemoteDescriptiongIAlus(sessionDescription, c13471) == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(obj);
            ((u) obj).j();
        }
        onSessionScreenReady();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioTrack localAudioTrackLazy$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return webRtcSessionManagerImpl.peerConnectionFactory.makeAudioTrack(webRtcSessionManagerImpl.getAudioSource(), "Audio" + UUID.randomUUID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoTrack localVideoTrackLazy$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return webRtcSessionManagerImpl.peerConnectionFactory.makeVideoTrack(webRtcSessionManagerImpl.getVideoSource(), "Video" + UUID.randomUUID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkChangeMonitor networkMonitor_delegate$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return new NetworkChangeMonitor(webRtcSessionManagerImpl.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreamPeerConnection peerConnection_delegate$lambda$0(final WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        StreamPeerConnectionFactory streamPeerConnectionFactory = webRtcSessionManagerImpl.peerConnectionFactory;
        return StreamPeerConnectionFactory.makePeerConnection$default(streamPeerConnectionFactory, webRtcSessionManagerImpl.sessionManagerScope, streamPeerConnectionFactory.createRtcConfigurationNew(), StreamPeerType.SUBSCRIBER, webRtcSessionManagerImpl.mediaConstraints, null, null, new Function2() { // from class: cu.todus.android.webrtc.sessions.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WebRtcSessionManagerImpl.peerConnection_delegate$lambda$0$0(this.f28772c, (IceCandidate) obj, (StreamPeerType) obj2);
            }
        }, new Function1() { // from class: cu.todus.android.webrtc.sessions.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebRtcSessionManagerImpl.peerConnection_delegate$lambda$0$1(this.f28778c, (RtpTransceiver) obj);
            }
        }, new lb.a() { // from class: cu.todus.android.webrtc.sessions.i
            @Override // lb.a
            public final Object invoke() {
                return WebRtcSessionManagerImpl.peerConnection_delegate$lambda$0$2(this.f28779c);
            }
        }, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 peerConnection_delegate$lambda$0$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl, IceCandidate iceCandidate, StreamPeerType streamPeerType) {
        y.i(iceCandidate, "iceCandidate");
        y.i(streamPeerType, "<unused var>");
        String str = iceCandidate.sdpMid + "$" + iceCandidate.sdpMLineIndex + "$" + iceCandidate.sdp;
        if (webRtcSessionManagerImpl.sentIceCandidatesNew.contains(str)) {
            le.f0.z1(str, 40);
            return k0.f43947a;
        }
        if (webRtcSessionManagerImpl.startSendIce && !webRtcSessionManagerImpl.isDisconnected) {
            le.f0.z1(str, 60);
            webRtcSessionManagerImpl.sendCommand(SignalingCommand.ICE, str);
            webRtcSessionManagerImpl.sentIceCandidatesNew.add(str);
        } else if (!webRtcSessionManagerImpl.isDisconnected) {
            webRtcSessionManagerImpl.iceArray.size();
            webRtcSessionManagerImpl.iceArray.add(str);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 peerConnection_delegate$lambda$0$1(WebRtcSessionManagerImpl webRtcSessionManagerImpl, RtpTransceiver rtpTransceiver) {
        RtpReceiver receiver;
        if (webRtcSessionManagerImpl.isDisconnected) {
            return k0.f43947a;
        }
        MediaStreamTrack mediaStreamTrackTrack = (rtpTransceiver == null || (receiver = rtpTransceiver.getReceiver()) == null) ? null : receiver.track();
        if (mediaStreamTrackTrack instanceof VideoTrack) {
            pe.k.d(webRtcSessionManagerImpl.sessionManagerScope, null, null, new WebRtcSessionManagerImpl$peerConnection$2$2$1(webRtcSessionManagerImpl, mediaStreamTrackTrack, null), 3, null);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 peerConnection_delegate$lambda$0$2(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        webRtcSessionManagerImpl.onConnected.invoke();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object sendAnswer(ab.e<? super k0> eVar) {
        C13501 c13501;
        Object objM10125createAnswerIoAF18A;
        SessionDescription sessionDescription;
        Object objJ;
        if (eVar instanceof C13501) {
            c13501 = (C13501) eVar;
            int i10 = c13501.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13501.label = i10 - Integer.MIN_VALUE;
            } else {
                c13501 = new C13501(eVar);
            }
        } else {
            c13501 = new C13501(eVar);
        }
        Object obj = c13501.result;
        Object objG = bb.b.g();
        int i11 = c13501.label;
        if (i11 == 0) {
            v.b(obj);
            if (this.isDisconnected) {
                return k0.f43947a;
            }
            StreamPeerConnection peerConnection = getPeerConnection();
            c13501.label = 1;
            objM10125createAnswerIoAF18A = peerConnection.m10125createAnswerIoAF18A(c13501);
            if (objM10125createAnswerIoAF18A != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            v.b(obj);
            objM10125createAnswerIoAF18A = ((u) obj).j();
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionDescription = (SessionDescription) c13501.L$0;
            v.b(obj);
            objJ = ((u) obj).j();
        }
        if (u.h(objJ)) {
            SignalingCommand signalingCommand = SignalingCommand.ANSWER;
            String description = sessionDescription.description;
            y.h(description, "description");
            sendCommand(signalingCommand, description);
            k0 k0Var = k0.f43947a;
        } else {
            Throwable thE = u.e(objJ);
            cb.b.d(Log.e(TAG, "[sendAnswer] Error al establecer descripción local: " + (thE != null ? thE.getMessage() : null)));
        }
        return k0.f43947a;
        if (u.g(objM10125createAnswerIoAF18A)) {
            objM10125createAnswerIoAF18A = null;
        }
        SessionDescription sessionDescription2 = (SessionDescription) objM10125createAnswerIoAF18A;
        if (sessionDescription2 != null) {
            StreamPeerConnection peerConnection2 = getPeerConnection();
            c13501.L$0 = sessionDescription2;
            c13501.I$0 = 0;
            c13501.label = 2;
            Object objM10127setLocalDescriptiongIAlus = peerConnection2.m10127setLocalDescriptiongIAlus(sessionDescription2, c13501);
            if (objM10127setLocalDescriptiongIAlus != objG) {
                sessionDescription = sessionDescription2;
                objJ = objM10127setLocalDescriptiongIAlus;
                if (u.h(objJ)) {
                    SignalingCommand signalingCommand2 = SignalingCommand.ANSWER;
                    String description2 = sessionDescription.description;
                    y.h(description2, "description");
                    sendCommand(signalingCommand2, description2);
                    k0 k0Var2 = k0.f43947a;
                } else {
                    Throwable thE2 = u.e(objJ);
                    if (thE2 != null) {
                    }
                    cb.b.d(Log.e(TAG, "[sendAnswer] Error al establecer descripción local: " + (thE2 != null ? thE2.getMessage() : null)));
                }
            }
            return objG;
        }
        cb.b.d(Log.e(TAG, "[sendAnswer] Fallo al crear ANSWER"));
        return k0.f43947a;
    }

    private final void sendCommand(SignalingCommand signalingCommand, String message) {
        if (this.isDisconnected) {
            return;
        }
        Objects.toString(signalingCommand);
        this.sendCommandAsMsg.invoke(signalingCommand + " " + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object sendOffer(ab.e<? super k0> eVar) {
        C13511 c13511;
        Object objM10126createOfferIoAF18A;
        SessionDescription sessionDescription;
        Object objJ;
        if (eVar instanceof C13511) {
            c13511 = (C13511) eVar;
            int i10 = c13511.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13511.label = i10 - Integer.MIN_VALUE;
            } else {
                c13511 = new C13511(eVar);
            }
        } else {
            c13511 = new C13511(eVar);
        }
        Object obj = c13511.result;
        Object objG = bb.b.g();
        int i11 = c13511.label;
        if (i11 == 0) {
            v.b(obj);
            if (this.isDisconnected) {
                return k0.f43947a;
            }
            StreamPeerConnection peerConnection = getPeerConnection();
            c13511.label = 1;
            objM10126createOfferIoAF18A = peerConnection.m10126createOfferIoAF18A(c13511);
            if (objM10126createOfferIoAF18A != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            v.b(obj);
            objM10126createOfferIoAF18A = ((u) obj).j();
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionDescription = (SessionDescription) c13511.L$0;
            v.b(obj);
            objJ = ((u) obj).j();
        }
        if (u.h(objJ)) {
            SignalingCommand signalingCommand = SignalingCommand.OFFER;
            String description = sessionDescription.description;
            y.h(description, "description");
            sendCommand(signalingCommand, description);
            k0 k0Var = k0.f43947a;
        } else {
            Throwable thE = u.e(objJ);
            cb.b.d(Log.e(TAG, "[sendOffer] Error al establecer descripción local: " + (thE != null ? thE.getMessage() : null)));
        }
        return k0.f43947a;
        if (u.g(objM10126createOfferIoAF18A)) {
            objM10126createOfferIoAF18A = null;
        }
        SessionDescription sessionDescription2 = (SessionDescription) objM10126createOfferIoAF18A;
        if (sessionDescription2 != null) {
            StreamPeerConnection peerConnection2 = getPeerConnection();
            c13511.L$0 = sessionDescription2;
            c13511.I$0 = 0;
            c13511.label = 2;
            Object objM10127setLocalDescriptiongIAlus = peerConnection2.m10127setLocalDescriptiongIAlus(sessionDescription2, c13511);
            if (objM10127setLocalDescriptiongIAlus != objG) {
                sessionDescription = sessionDescription2;
                objJ = objM10127setLocalDescriptiongIAlus;
                if (u.h(objJ)) {
                    SignalingCommand signalingCommand2 = SignalingCommand.OFFER;
                    String description2 = sessionDescription.description;
                    y.h(description2, "description");
                    sendCommand(signalingCommand2, description2);
                    k0 k0Var2 = k0.f43947a;
                } else {
                    Throwable thE2 = u.e(objJ);
                    if (thE2 != null) {
                    }
                    cb.b.d(Log.e(TAG, "[sendOffer] Error al establecer descripción local: " + (thE2 != null ? thE2.getMessage() : null)));
                }
            }
            return objG;
        }
        cb.b.d(Log.e(TAG, "[sendOffer] Fallo al crear OFFER"));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceTextureHelper surfaceTextureHelperLazy$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        return SurfaceTextureHelper.create("WebRtcSurfaceThread", webRtcSessionManagerImpl.peerConnectionFactory.getEglBaseContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoSource videoSourceLazy$lambda$0(WebRtcSessionManagerImpl webRtcSessionManagerImpl) {
        VideoSource videoSourceMakeVideoSource = webRtcSessionManagerImpl.peerConnectionFactory.makeVideoSource(webRtcSessionManagerImpl.getVideoCapturer().isScreencast());
        webRtcSessionManagerImpl.getVideoCapturer().initialize(webRtcSessionManagerImpl.getSurfaceTextureHelper(), webRtcSessionManagerImpl.context, videoSourceMakeVideoSource.getCapturerObserver());
        webRtcSessionManagerImpl.getVideoCapturer().startCapture(webRtcSessionManagerImpl.getResolution().width, webRtcSessionManagerImpl.getResolution().height, 30);
        return videoSourceMakeVideoSource;
    }

    public final void addTracksWithValidationSmartNew() {
        if (this.tracksAdded || this.isDisconnected) {
            return;
        }
        try {
            getPeerConnection().getConnection().addTrack(getLocalAudioTrack());
            getPeerConnection().getConnection().addTrack(getLocalVideoTrack());
            this.tracksAdded = true;
        } catch (Exception e10) {
            Log.e(TAG, "Error tracks: " + e10.getMessage());
        }
    }

    public final void disconnect() {
        pe.k.d(n0.a(d1.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void disconnectNew() {
        disconnect();
    }

    public final void enableCamera(boolean enabled) throws InterruptedException {
        if (this.isDisconnected) {
            return;
        }
        if (enabled) {
            getVideoCapturer().startCapture(getResolution().width, getResolution().height, 30);
        } else if (this.videoCapturerLazy.isInitialized()) {
            getVideoCapturer().stopCapture();
        }
        sendCommand(SignalingCommand.CONFIG, ConfigKey.CAMERA + "_" + enabled);
    }

    public final void enableIceSendingOnRingNew() {
        if (this.isDisconnected) {
            return;
        }
        if ((this.offerSent || this.answerSent) && !this.startSendIce) {
            this.iceArray.size();
            this.startSendIce = true;
            for (String str : this.iceArray) {
                if (!this.sentIceCandidatesNew.contains(str)) {
                    le.f0.z1(str, 50);
                    sendCommand(SignalingCommand.ICE, str);
                    this.sentIceCandidatesNew.add(str);
                }
            }
            this.iceArray.clear();
        }
    }

    public final void enableMicrophone(boolean enabled) {
        if (this.isDisconnected) {
            return;
        }
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            audioManager.setMicrophoneMute(!enabled);
        }
        sendCommand(SignalingCommand.CONFIG, ConfigKey.MIC + "_" + enabled);
    }

    public final void flipCamera() {
        if (!this.isDisconnected && this.videoCapturerLazy.isInitialized()) {
            VideoCapturer videoCapturer = getVideoCapturer();
            if (videoCapturer instanceof CameraVideoCapturer) {
                ((CameraVideoCapturer) videoCapturer).switchCamera(null);
            }
        }
    }

    public final p0 getLocalVideoTrackFlow() {
        return this.localVideoTrackFlow;
    }

    public final lb.a getOnError() {
        return this.onError;
    }

    public final boolean getOwnerIsCalling() {
        return this.ownerIsCalling;
    }

    public final StreamPeerConnectionFactory getPeerConnectionFactory() {
        return this.peerConnectionFactory;
    }

    public final p0 getRemoteVideoTrackFlow() {
        return this.remoteVideoTrackFlow;
    }

    public final void handleSignalingCommand(SignalingCommand command, String text) {
        y.i(command, "command");
        y.i(text, "text");
        if (this.isDisconnected) {
            return;
        }
        pe.k.d(this.sessionManagerScope, null, null, new C13481(command, INSTANCE.splitCallCmd(text), null), 3, null);
    }

    public final boolean isPeerConnectionInitializedNew() {
        try {
            return getPeerConnection().getConnection() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void onSessionScreenReady() {
        if (this.answerSent || this.offerSent || this.isDisconnected) {
            return;
        }
        try {
            getAudioHandler().start();
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                audioManager.setMode(3);
            }
            addTracksWithValidationSmartNew();
            pe.k.d(this.sessionManagerScope, null, null, new C13491(null), 3, null);
        } catch (Exception e10) {
            Log.e(TAG, "[onSessionScreenReady] ERROR: " + e10.getMessage(), e10);
            this.onError.invoke();
        }
    }

    public final void setBitrateNew(int minBitrate, int currentBitrate, int maxBitrate) {
        try {
            if (isPeerConnectionInitializedNew()) {
                getPeerConnection().getConnection().setBitrate(Integer.valueOf(minBitrate), Integer.valueOf(currentBitrate), Integer.valueOf(maxBitrate));
            }
        } catch (Exception e10) {
            Log.e(TAG, "[setBitrateNew] Error: " + e10.getMessage());
        }
    }

    public final void setSpeakerphoneOnNew(boolean enabled) {
        Object next;
        try {
            AudioManager audioManager = getAudioManager();
            if (audioManager == null) {
                return;
            }
            if (audioManager.getMode() != 3) {
                audioManager.setMode(3);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    List<AudioDeviceInfo> availableCommunicationDevices = audioManager.getAvailableCommunicationDevices();
                    y.h(availableCommunicationDevices, "getAvailableCommunicationDevices(...)");
                    if (availableCommunicationDevices.isEmpty()) {
                        Log.w(TAG, "[setSpeakerphoneOnNew] No hay dispositivos de comunicación disponibles");
                    } else {
                        int i10 = enabled ? 2 : 1;
                        Iterator<T> it = availableCommunicationDevices.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (((AudioDeviceInfo) next).getType() != i10);
                        AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) next;
                        if (audioDeviceInfo != null) {
                            audioManager.setCommunicationDevice(audioDeviceInfo);
                            audioDeviceInfo.getType();
                        } else {
                            Log.w(TAG, "[setSpeakerphoneOnNew] Dispositivo no encontrado para tipo: " + i10);
                        }
                    }
                } catch (Exception e10) {
                    Log.e(TAG, "[setSpeakerphoneOnNew] Error con API S+: " + e10.getMessage(), e10);
                }
            } else {
                audioManager.setSpeakerphoneOn(enabled);
            }
            if (audioManager.getRingerMode() != 0) {
                int streamVolume = audioManager.getStreamVolume(0);
                int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                if (streamVolume < streamMaxVolume / 2) {
                    audioManager.setStreamVolume(0, streamMaxVolume / 2, 0);
                }
            }
        } catch (Exception e11) {
            Log.e(TAG, "[setSpeakerphoneOnNew] Error fatal: " + e11.getMessage(), e11);
        }
    }

    public /* synthetic */ WebRtcSessionManagerImpl(Context context, StreamPeerConnectionFactory streamPeerConnectionFactory, lb.a aVar, Function1 function1, lb.a aVar2, boolean z10, Function1 function2, int i10, kotlin.jvm.internal.p pVar) {
        this(context, streamPeerConnectionFactory, aVar, (i10 & 8) != 0 ? new Function1() { // from class: cu.todus.android.webrtc.sessions.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebRtcSessionManagerImpl._init_$lambda$0((String) obj);
            }
        } : function1, aVar2, z10, (i10 & 64) != 0 ? null : function2);
    }
}
