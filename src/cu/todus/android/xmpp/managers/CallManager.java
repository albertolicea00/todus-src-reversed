package cu.todus.android.xmpp.managers;

import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.muxer.WebmConstants;
import androidx.room.RoomDatabaseKt;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.connection.NetworkChangeMonitor;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.preferences.CallQuality;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.xmpp.TurnCredentials;
import cu.todus.android.db.ToDusDatabase;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.notification.notifications.CallNotification;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.ConfigKey;
import cu.todus.android.webrtc.SignalingCommand;
import cu.todus.android.webrtc.peer.StreamPeerConnectionFactory;
import cu.todus.android.webrtc.service.CallServiceUtility;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import cu.todus.android.xmpp.StanzaListenerManager;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.iq.call.CallStatusIQ;
import cu.todus.android.xmpp.iq.call.GetCredentialsIQ;
import cu.z17.singledi.SinglediException;
import cu.z17.views.utils.Z17MutableListFlow;
import j$.util.Objects;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.w0;
import le.d0;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.muc.packet.Destroy;
import pe.a2;
import pe.d1;
import pe.e2;
import pe.m0;
import pe.n0;
import te.p0;
import te.r0;
import ua.k0;
import va.g0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 £\u00012\u00020\u0001:\u0002£\u0001Bg\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012$\u0010\u000e\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u001fJB\u0010&\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\nH\u0082@¢\u0006\u0004\b&\u0010'J \u0010(\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0082@¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0014H\u0002¢\u0006\u0004\b*\u0010\u0016J\u0017\u0010+\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u001fJ\u0017\u0010,\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010\u001fJ\u0017\u0010/\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\u001fJ\u000f\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b0\u0010\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00142\u0006\u00103\u001a\u00020\nH\u0082@¢\u0006\u0004\b4\u00105J \u00108\u001a\u00020\u00142\u0006\u00103\u001a\u00020\n2\u0006\u00107\u001a\u000206H\u0082@¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\nH\u0082@¢\u0006\u0004\b:\u00105J\u0018\u0010;\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\nH\u0082@¢\u0006\u0004\b;\u00105J\u0017\u0010=\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u001fJ\u000f\u0010>\u001a\u00020\u0014H\u0002¢\u0006\u0004\b>\u0010\u0016J:\u0010B\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010@\u001a\u0002062\b\b\u0002\u0010A\u001a\u00020\u0003H\u0082@¢\u0006\u0004\bB\u0010CJ:\u0010D\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010@\u001a\u0002062\b\b\u0002\u0010A\u001a\u00020\u0003H\u0082@¢\u0006\u0004\bD\u0010CJ1\u0010G\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020I2\u0006\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010KJ)\u0010N\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010M\u001a\u00020L2\b\b\u0002\u0010A\u001a\u00020\u0003H\u0002¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\u0014¢\u0006\u0004\bP\u0010\u0016J(\u0010T\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\n2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u0003H\u0086@¢\u0006\u0004\bT\u0010UJL\u0010Y\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010A\u001a\u00020\u00032\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0086@¢\u0006\u0004\bY\u0010ZJL\u0010[\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010A\u001a\u00020\u00032\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0086@¢\u0006\u0004\b[\u0010ZJB\u0010\\\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0086@¢\u0006\u0004\b\\\u0010]J\u0015\u0010^\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b^\u0010\u001fJ\u0015\u0010_\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b_\u0010\u001fJ\u000f\u0010`\u001a\u00020\u0014H\u0016¢\u0006\u0004\b`\u0010\u0016J\u000f\u0010a\u001a\u00020\u0014H\u0016¢\u0006\u0004\ba\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010b\u001a\u0004\bc\u0010dR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010b\u001a\u0004\be\u0010dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010b\u001a\u0004\bf\u0010dR5\u0010\u000e\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010g\u001a\u0004\bh\u0010iR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010j\u001a\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020#0\u007f8\u0006¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0084\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0081\u0001R%\u0010\u0086\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0085\u00018\u0006¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008a\u0001\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001d\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0006¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0006¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0006¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001¨\u0006¤\u0001"}, d2 = {"Lcu/todus/android/xmpp/managers/CallManager;", "Lcu/todus/android/xmpp/StanzaListenerManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function2;", "", "Lab/e;", "Lcu/todus/android/data/db/entity/toDus/User;", "", "getUserInfo", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/webrtc/CallState;", "requestingCalls", "<init>", "(Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function2;Lcu/z17/views/utils/Z17MutableListFlow;)V", "Lua/k0;", "cleanupSessionManagerNew", "()V", "Lcu/todus/android/data/xmpp/TurnCredentials;", "turnCredentials", "ownerIsCalling", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "provideSessionManager", "(Lcu/todus/android/data/xmpp/TurnCredentials;Z)Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "uid", "startTimeout", "(Ljava/lang/String;)V", "cancelTimeout", "maxToSend", Room.COLUMN_LAST_MSG, "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "callMediaState", "command", "receiveCallProcess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;Lcu/todus/android/data/xmpp/TurnCredentials;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "receivePickupProcess", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "onSessionScreenReadyNew", "receiveRejectCall", "receiveCallEnded", AppMeasurementSdk.ConditionalUserProperty.VALUE, "receiveCallConfig", "sendCmdIQ", "endCallProcess", "requestTurnCredentials", "(Lab/e;)Ljava/lang/Object;", "roomId", "createRoomIfNeed", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "", "actualDate", "insertDateMsg", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "updateStartTime", "updateEndTime", "withName", "startCallService", "closeCallService", "callId", "date", "isVideoCall", "buildStartCallMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLab/e;)Ljava/lang/Object;", "buildStartCallMessageNew", "toUser", "status", "buildAndSendCommandIQ", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "buildCallQuality", "(Ljava/lang/String;)I", "Lcu/todus/android/data/db/pojo/Partner;", "partner", "sendIncomingCallNotificationNew", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/Partner;Z)V", Destroy.ELEMENT, "Lcu/todus/android/data/db/pojo/content/CallContent;", "callContent", "isCancelled", "onCallMessage", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/CallContent;ZLab/e;)Ljava/lang/Object;", "onStarted", "onBusy", "onError", "startCallProcess", "(Ljava/lang/String;ZLlb/a;Llb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "startCallProcessNew", "sendPickupIQ", "(Ljava/lang/String;Llb/a;Llb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "sendRejectIQ", "sendEndCall", "startManager", "stopManager", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lkotlin/jvm/functions/Function2;", "getGetUserInfo", "()Lkotlin/jvm/functions/Function2;", "Lcu/z17/views/utils/Z17MutableListFlow;", "getRequestingCalls", "()Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/di/DatabaseModule;", "dataBaseModule", "Lcu/todus/android/di/DatabaseModule;", "Lcu/todus/android/volatileState/AppVolatileState;", "appVolatileState", "Lcu/todus/android/volatileState/AppVolatileState;", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lcu/todus/android/notification/NotificationManager;", "Lv5/f;", "gson", "Lv5/f;", "Lpe/a0;", "job", "Lpe/a0;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lte/b0;", "ownerCallMediaState", "Lte/b0;", "getOwnerCallMediaState", "()Lte/b0;", "_callState", "Lte/p0;", "callState", "Lte/p0;", "getCallState", "()Lte/p0;", "sessionManager", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "getSessionManager", "()Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "getMessageDao", "()Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "getAttachmentDao", "()Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "getRoomDao", "()Lcu/todus/android/db/dao/toDus/RoomDao;", "Lpe/a2;", "timeoutJob", "Lpe/a2;", "Lorg/jivesoftware/smack/StanzaListener;", "stanzaListener", "Lorg/jivesoftware/smack/StanzaListener;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallManager implements StanzaListenerManager {
    public static final String TAG = "CALL_MANAGER";
    private final te.b0 _callState;
    private final AppVolatileState appVolatileState;
    private final AttachmentDao attachmentDao;
    private final p0 callState;
    private final lb.a canSend;
    private final m0 coroutineScope;
    private final DatabaseModule dataBaseModule;
    private final Function2 getUserInfo;
    private final v5.f gson;
    private final pe.a0 job;
    private final lb.a mXMPPConnection;
    private final MessageDao messageDao;
    private final NotificationManager notificationManager;
    private final lb.a owner;
    private final te.b0 ownerCallMediaState;
    private final Z17MutableListFlow<CallState> requestingCalls;
    private final RoomDao roomDao;
    private WebRtcSessionManagerImpl sessionManager;
    private final StanzaListener stanzaListener;
    private a2 timeoutJob;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$1", f = "CallManager.kt", l = {PsExtractor.AUDIO_STREAM}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function2 {
        Object L$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$1$2", f = "CallManager.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "maxBitrate", "Lua/k0;", "<anonymous>", "(I)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ w0 $lastMaxBitRate;
            /* synthetic */ int I$0;
            int label;
            final /* synthetic */ CallManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(w0 w0Var, CallManager callManager, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$lastMaxBitRate = w0Var;
                this.this$0 = callManager;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$lastMaxBitRate, this.this$0, eVar);
                anonymousClass2.I$0 = ((Number) obj).intValue();
                return anonymousClass2;
            }

            public final Object invoke(int i10, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(Integer.valueOf(i10), eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                int i10 = this.I$0;
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                w0 w0Var = this.$lastMaxBitRate;
                if (w0Var.f36631c != i10) {
                    w0Var.f36631c = i10;
                    if (this.this$0.getSessionManager().isPeerConnectionInitializedNew()) {
                        try {
                            int i11 = i10 * 400000;
                            this.this$0.getSessionManager().setBitrateNew(200, i11, i11);
                        } catch (Exception e10) {
                            Log.e(CallManager.TAG, "Error al establecer el bitrate", e10);
                        }
                    }
                }
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (ab.e<? super k0>) obj2);
            }
        }

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return CallManager.this.new AnonymousClass1(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                w0 w0Var = new w0();
                w0Var.f36631c = -1;
                final p0 callState = CallManager.this.getCallState();
                te.h hVar = new te.h() { // from class: cu.todus.android.xmpp.managers.CallManager$1$invokeSuspend$$inlined$mapNotNull$1

                    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements te.i {
                        final /* synthetic */ te.i $this_unsafeFlow;

                        /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "CallManager.kt", l = {52}, m = "emit", v = 2)
                        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                        public static final class AnonymousClass1 extends cb.d {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(ab.e eVar) {
                                super(eVar);
                            }

                            @Override // cb.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(te.i iVar) {
                            this.$this_unsafeFlow = iVar;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // te.i
                        public final Object emit(Object obj, ab.e eVar) {
                            AnonymousClass1 anonymousClass1;
                            if (eVar instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) eVar;
                                int i10 = anonymousClass1.label;
                                if ((i10 & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i10 - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(eVar);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(eVar);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object objG = bb.b.g();
                            int i11 = anonymousClass1.label;
                            if (i11 == 0) {
                                ua.v.b(obj2);
                                te.i iVar = this.$this_unsafeFlow;
                                CallState callState = (CallState) obj;
                                Integer numD = callState != null ? cb.b.d(callState.getMaxToSend()) : null;
                                if (numD != null) {
                                    anonymousClass1.L$0 = cb.l.a(obj);
                                    anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                                    anonymousClass1.L$2 = cb.l.a(obj);
                                    anonymousClass1.L$3 = cb.l.a(iVar);
                                    anonymousClass1.L$4 = cb.l.a(numD);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (iVar.emit(numD, anonymousClass1) == objG) {
                                        return objG;
                                    }
                                }
                            } else {
                                if (i11 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ua.v.b(obj2);
                            }
                            return k0.f43947a;
                        }
                    }

                    @Override // te.h
                    public Object collect(te.i iVar, ab.e eVar) {
                        Object objCollect = callState.collect(new AnonymousClass2(iVar), eVar);
                        return objCollect == bb.b.g() ? objCollect : k0.f43947a;
                    }
                };
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(w0Var, CallManager.this, null);
                this.L$0 = cb.l.a(w0Var);
                this.label = 1;
                if (te.j.k(hVar, anonymousClass2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkChangeMonitor.ConnectionType.values().length];
            try {
                iArr[NetworkChangeMonitor.ConnectionType.CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkChangeMonitor.ConnectionType.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkChangeMonitor.ConnectionType.RECONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$buildStartCallMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {947}, m = "buildStartCallMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13971 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13971(ab.e<? super C13971> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.buildStartCallMessage(null, null, null, 0L, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$buildStartCallMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$buildStartCallMessage$2", f = "CallManager.kt", l = {967, 968, 969}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function1 {
        final /* synthetic */ String $callId;
        final /* synthetic */ String $command;
        final /* synthetic */ long $date;
        final /* synthetic */ String $msgId;
        final /* synthetic */ String $uid;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CallManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, long j10, String str2, CallManager callManager, String str3, String str4, ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
            this.$msgId = str;
            this.$date = j10;
            this.$uid = str2;
            this.this$0 = callManager;
            this.$callId = str3;
            this.$command = str4;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new AnonymousClass2(this.$msgId, this.$date, this.$uid, this.this$0, this.$callId, this.$command, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0122, code lost:
        
            if (r3.updateLastMessage(r4, r2, r3, r21) == r6) goto L21;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$buildStartCallMessageNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {DescriptorProtos.Edition.EDITION_PROTO2_VALUE}, m = "buildStartCallMessageNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C13981 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13981(ab.e<? super C13981> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.buildStartCallMessageNew(null, null, null, 0L, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$buildStartCallMessageNew$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$buildStartCallMessageNew$2", f = "CallManager.kt", l = {1019, 1020, 1021}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C13992 extends cb.m implements Function1 {
        final /* synthetic */ String $callId;
        final /* synthetic */ String $command;
        final /* synthetic */ long $date;
        final /* synthetic */ String $msgId;
        final /* synthetic */ String $uid;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CallManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13992(String str, long j10, String str2, CallManager callManager, String str3, String str4, ab.e<? super C13992> eVar) {
            super(1, eVar);
            this.$msgId = str;
            this.$date = j10;
            this.$uid = str2;
            this.this$0 = callManager;
            this.$command = str3;
            this.$callId = str4;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C13992(this.$msgId, this.$date, this.$uid, this.this$0, this.$command, this.$callId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C13992) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0128, code lost:
        
            if (r3.updateLastMessage(r4, r2, r3, r21) == r6) goto L21;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.C13992.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$createRoomIfNeed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND, 842, 850, 859}, m = "createRoomIfNeed", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14001 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14001(ab.e<? super C14001> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.createRoomIfNeed(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$endCallProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$endCallProcess$1", f = "CallManager.kt", l = {772}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C14011 extends cb.m implements Function2 {
        final /* synthetic */ CallState $call;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14011(CallState callState, ab.e<? super C14011> eVar) {
            super(2, eVar);
            this.$call = callState;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return CallManager.this.new C14011(this.$call, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    ua.v.b(obj);
                    CallManager callManager = CallManager.this;
                    String msgId = this.$call.getMsgId();
                    this.label = 1;
                    if (callManager.updateEndTime(msgId, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ua.v.b(obj);
                }
            } catch (Exception e10) {
                Log.e(CallManager.TAG, "[endCallProcess] Error actualizando hora de fin: " + e10.getMessage());
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C14011) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$insertDateMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {873, 876, 886}, m = "insertDateMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14021 extends cb.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14021(ab.e<? super C14021> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.insertDateMsg(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$onCallMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {229, WebmConstants.MkvEbmlElement.TIMESTAMP, 253}, m = "onCallMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14031 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14031(ab.e<? super C14031> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.onCallMessage(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$receiveCallProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {339, 341}, m = "receiveCallProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14041 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C14041(ab.e<? super C14041> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.receiveCallProcess(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$receivePickupProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {399}, m = "receivePickupProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14051 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14051(ab.e<? super C14051> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.receivePickupProcess(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$requestTurnCredentials$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {1129}, m = "requestTurnCredentials", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14061 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14061(ab.e<? super C14061> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.requestTurnCredentials(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$sendPickupIQ$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {634, 652, 655, 670}, m = "sendPickupIQ", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14071 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14071(ab.e<? super C14071> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.sendPickupIQ(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$startCallProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {512, 514, 516, 517, 532}, m = "startCallProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14081 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14081(ab.e<? super C14081> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.startCallProcess(null, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$startCallProcessNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {565, 582, 584, 586, 587, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "startCallProcessNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14091 extends cb.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14091(ab.e<? super C14091> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.startCallProcessNew(null, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$startTimeout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager$startTimeout$1", f = "CallManager.kt", l = {173}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C14101 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        int label;
        final /* synthetic */ CallManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14101(String str, CallManager callManager, ab.e<? super C14101> eVar) {
            super(2, eVar);
            this.$uid = str;
            this.this$0 = callManager;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C14101(this.$uid, this.this$0, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            CallState callState;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                this.label = 1;
                if (pe.w0.b(20000L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            CallState callState2 = (CallState) this.this$0.getCallState().getValue();
            if (kotlin.jvm.internal.y.d(callState2 != null ? callState2.getWith() : null, this.$uid) && (callState = (CallState) this.this$0.getCallState().getValue()) != null && !callState.getCallIsStarted()) {
                Log.w(CallManager.TAG, "Timeout alcanzado para la llamada con " + this.$uid + ". Finalizando.");
                this.this$0.endCallProcess();
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C14101) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$updateEndTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {913, 917}, m = "updateEndTime", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14111 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14111(ab.e<? super C14111> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.updateEndTime(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.CallManager$updateStartTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.CallManager", f = "CallManager.kt", l = {TypedValues.Custom.TYPE_BOOLEAN, 908}, m = "updateStartTime", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14121 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14121(ab.e<? super C14121> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallManager.this.updateStartTime(null, this);
        }
    }

    public CallManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner, Function2 getUserInfo, Z17MutableListFlow<CallState> requestingCalls) throws SinglediException {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(getUserInfo, "getUserInfo");
        kotlin.jvm.internal.y.i(requestingCalls, "requestingCalls");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        this.getUserInfo = getUserInfo;
        this.requestingCalls = requestingCalls;
        DatabaseModule singletonInitializer = DatabaseModule.INSTANCE.getInstance();
        this.dataBaseModule = singletonInitializer;
        this.appVolatileState = AppVolatileState.INSTANCE.getInstance();
        this.notificationManager = NotificationManager.INSTANCE.getInstance();
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        pe.a0 a0VarB = e2.b(null, 1, null);
        this.job = a0VarB;
        m0 m0VarA = n0.a(d1.b().plus(a0VarB));
        this.coroutineScope = m0VarA;
        this.ownerCallMediaState = r0.a(new CallMediaState(false, false, false, 7, null));
        te.b0 b0VarA = r0.a(null);
        this._callState = b0VarA;
        this.callState = b0VarA;
        this.sessionManager = provideSessionManager(new TurnCredentials(null, null, null, 7, null), false);
        this.messageDao = singletonInitializer.getMessageDao();
        this.attachmentDao = singletonInitializer.getAttachmentDao();
        this.roomDao = singletonInitializer.getRoomDao();
        this.stanzaListener = new StanzaListener() { // from class: cu.todus.android.xmpp.managers.b
            @Override // org.jivesoftware.smack.StanzaListener
            public final void processStanza(Stanza stanza) {
                CallManager.stanzaListener$lambda$0(this.f28856c, stanza);
            }
        };
        pe.k.d(m0VarA, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void buildAndSendCommandIQ(String toUser, String status, String command, String msgId) {
        String callId;
        String nameWithDomain = ((Owner) this.owner.invoke()).getNameWithDomain();
        CallState callState = (CallState) this._callState.getValue();
        if (callState == null || (callId = callState.getCallId()) == null) {
            callId = "";
        }
        Base64Util base64Util = Base64Util.INSTANCE;
        CallContent callContent = new CallContent(nameWithDomain, callId, Base64Util.encodedMessage$default(base64Util, command, 0, 2, (Object) null), msgId, 0L, 0L, 48, null);
        try {
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                String nameWithDomain2 = ((Owner) this.owner.invoke()).getNameWithDomain();
                String strT = this.gson.t(callContent);
                kotlin.jvm.internal.y.h(strT, "toJson(...)");
                xMPPTCPConnection.sendStanza(new CallStatusIQ(nameWithDomain2, toUser, status, Base64Util.encodedMessage$default(base64Util, strT, 0, 2, (Object) null)));
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void buildAndSendCommandIQ$default(CallManager callManager, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.y.h(string, "toString(...)");
            str4 = "call_" + le.a0.O(string, "-", "", false, 4, null);
        }
        callManager.buildAndSendCommandIQ(str, str2, str3, str4);
    }

    private final int buildCallQuality(String maxToSend) {
        Integer numV = le.z.v(maxToSend);
        int iIntValue = numV != null ? numV.intValue() : 2;
        int sendQuality = ((CallQuality) this.appVolatileState.getCallQuality().getValue()).getSendQuality();
        return iIntValue < sendQuality ? iIntValue : sendQuality;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object buildStartCallMessage(String str, String str2, String str3, long j10, boolean z10, ab.e<? super k0> eVar) {
        C13971 c13971;
        String str4;
        String str5;
        if (eVar instanceof C13971) {
            c13971 = (C13971) eVar;
            int i10 = c13971.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13971.label = i10 - Integer.MIN_VALUE;
            } else {
                c13971 = new C13971(eVar);
            }
        } else {
            c13971 = new C13971(eVar);
        }
        C13971 c13972 = c13971;
        Object obj = c13972.result;
        Object objG = bb.b.g();
        int i11 = c13972.label;
        if (i11 == 0) {
            ua.v.b(obj);
            String str6 = SignalingCommand.CALL + " " + ((CallQuality) this.appVolatileState.getCallQuality().getValue()).getReceivingQuality() + " " + (z10 ? "1" : "0");
            try {
                ToDusDatabase toDusDatabase = this.dataBaseModule.getToDusDatabase();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(str3, j10, str, this, str2, str6, null);
                c13972.L$0 = str;
                c13972.L$1 = cb.l.a(str2);
                c13972.L$2 = cb.l.a(str3);
                c13972.L$3 = str6;
                c13972.J$0 = j10;
                c13972.Z$0 = z10;
                c13972.label = 1;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, anonymousClass2, c13972) == objG) {
                    return objG;
                }
            } catch (Exception e10) {
                e = e10;
                str4 = str;
                str5 = str6;
                Log.e(TAG, "Fallo al construir e insertar mensaje de comando para " + str4 + ". Comando: " + str5, e);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str5 = (String) c13972.L$3;
            String str7 = (String) c13972.L$0;
            try {
                ua.v.b(obj);
            } catch (Exception e11) {
                e = e11;
                str4 = str7;
                Log.e(TAG, "Fallo al construir e insertar mensaje de comando para " + str4 + ". Comando: " + str5, e);
            }
        }
        return k0.f43947a;
    }

    public static /* synthetic */ Object buildStartCallMessage$default(CallManager callManager, String str, String str2, String str3, long j10, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return callManager.buildStartCallMessage(str, str2, str3, j10, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object buildStartCallMessageNew(String str, String str2, String str3, long j10, boolean z10, ab.e<? super k0> eVar) {
        C13981 c13981;
        String str4;
        String str5;
        if (eVar instanceof C13981) {
            c13981 = (C13981) eVar;
            int i10 = c13981.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c13981.label = i10 - Integer.MIN_VALUE;
            } else {
                c13981 = new C13981(eVar);
            }
        } else {
            c13981 = new C13981(eVar);
        }
        C13981 c13982 = c13981;
        Object obj = c13982.result;
        Object objG = bb.b.g();
        int i11 = c13982.label;
        if (i11 == 0) {
            ua.v.b(obj);
            String str6 = SignalingCommand.CALL + " " + ((CallQuality) this.appVolatileState.getCallQuality().getValue()).getSendQuality() + " " + (z10 ? "1" : "0");
            try {
                ToDusDatabase toDusDatabase = this.dataBaseModule.getToDusDatabase();
                C13992 c13992 = new C13992(str3, j10, str, this, str6, str2, null);
                c13982.L$0 = str;
                c13982.L$1 = cb.l.a(str2);
                c13982.L$2 = cb.l.a(str3);
                c13982.L$3 = str6;
                c13982.J$0 = j10;
                c13982.Z$0 = z10;
                c13982.label = 1;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c13992, c13982) == objG) {
                    return objG;
                }
            } catch (Exception e10) {
                e = e10;
                str4 = str;
                str5 = str6;
                Log.e(TAG, "Fallo al construir e insertar mensaje de comando para " + str4 + ". Comando: " + str5, e);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str5 = (String) c13982.L$3;
            String str7 = (String) c13982.L$0;
            try {
                ua.v.b(obj);
            } catch (Exception e11) {
                e = e11;
                str4 = str7;
                Log.e(TAG, "Fallo al construir e insertar mensaje de comando para " + str4 + ". Comando: " + str5, e);
            }
        }
        return k0.f43947a;
    }

    public static /* synthetic */ Object buildStartCallMessageNew$default(CallManager callManager, String str, String str2, String str3, long j10, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return callManager.buildStartCallMessageNew(str, str2, str3, j10, z10, eVar);
    }

    private final void cancelTimeout(String uid) {
        CallState callState = (CallState) this.callState.getValue();
        if (kotlin.jvm.internal.y.d(callState != null ? callState.getWith() : null, uid)) {
            a2 a2Var = this.timeoutJob;
            if (a2Var != null) {
                a2.a.a(a2Var, null, 1, null);
            }
            this.timeoutJob = null;
        }
    }

    private final void cleanupSessionManagerNew() {
        try {
            if (this.sessionManager.isPeerConnectionInitializedNew()) {
                this.sessionManager.disconnect();
            }
        } catch (Exception e10) {
            Log.w(TAG, "[cleanupSessionManagerNew] Error al limpiar sessionManager: " + e10.getMessage());
        }
    }

    private final void closeCallService() {
        this.appVolatileState.setCallStartTime(0L);
        CallServiceUtility.INSTANCE.stopService(MainModule.INSTANCE.getInstance().getAppContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x0114  */
    /* JADX WARN: Code duplicated, block: B:53:0x011f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
    
        if (r2 == r4) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014c, code lost:
    
        if (r2.insertIfNeedIgnore(r8, r3) == r4) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createRoomIfNeed(java.lang.String r27, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.createRoomIfNeed(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endCallProcess() {
        CallManager callManager;
        try {
            CallState callState = (CallState) this.callState.getValue();
            if (callState == null) {
                Log.w(TAG, "[endCallProcess] callState es null, retornando");
                return;
            }
            callState.getWith();
            callState.getCallIsStarted();
            try {
                callState.getWith();
                String with = callState.getWith();
                SignalingCommand signalingCommand = SignalingCommand.END;
                callManager = this;
                try {
                    buildAndSendCommandIQ$default(callManager, with, signalingCommand.toString(), signalingCommand.toString(), null, 8, null);
                } catch (Exception e10) {
                    e = e10;
                    try {
                        Log.e(TAG, "[endCallProcess] Error enviando END command: " + e.getMessage(), e);
                    } catch (Exception e11) {
                        e = e11;
                        Log.e(TAG, "[endCallProcess] ❌ EXCEPCIÓN NO ESPERADA: " + e.getMessage(), e);
                        e.printStackTrace();
                        try {
                            callManager._callState.setValue(null);
                            closeCallService();
                            k0 k0Var = k0.f43947a;
                            return;
                        } catch (Exception e12) {
                            Log.e(TAG, "[endCallProcess] Error limpiando después de excepción: " + e12.getMessage());
                            return;
                        }
                    }
                }
            } catch (Exception e13) {
                e = e13;
                callManager = this;
            }
            try {
                pe.k.d(callManager.coroutineScope, null, null, new C14011(callState, null), 3, null);
            } catch (Exception e14) {
                Log.e(TAG, "[endCallProcess] Error en coroutine launch: " + e14.getMessage());
            }
            try {
                if (callState.getCallIsStarted()) {
                    callManager.sessionManager.disconnectNew();
                }
            } catch (Exception e15) {
                Log.e(TAG, "[endCallProcess] Error desconectando WebRTC: " + e15.getMessage(), e15);
            }
            try {
                callManager._callState.setValue(null);
                callManager.ownerCallMediaState.setValue(new CallMediaState(false, false, false, 7, null));
                closeCallService();
                Log.i(TAG, "[endCallProcess] Proceso de llamada finalizado y estado limpiado.");
            } catch (Exception e16) {
                Log.e(TAG, "[endCallProcess] Error limpiando estado: " + e16.getMessage(), e16);
            }
        } catch (Exception e17) {
            e = e17;
            callManager = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:49:0x00d4, B:51:0x00d8, B:55:0x00e2, B:57:0x00ec, B:59:0x00fe), top: B:65:0x00d4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:49:0x00d4, B:51:0x00d8, B:55:0x00e2, B:57:0x00ec, B:59:0x00fe), top: B:65:0x00d4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00fe A[Catch: Exception -> 0x00dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00dd, blocks: (B:49:0x00d4, B:51:0x00d8, B:55:0x00e2, B:57:0x00ec, B:59:0x00fe), top: B:65:0x00d4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0162, code lost:
    
        if (r10.insertOrIgnore(r9, r5) == r6) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object insertDateMsg(java.lang.String r26, long r27, ab.e<? super ua.k0> r29) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.insertDateMsg(java.lang.String, long, ab.e):java.lang.Object");
    }

    private final void onSessionScreenReadyNew() {
        this.sessionManager.getOwnerIsCalling();
        try {
            this.sessionManager.onSessionScreenReady();
        } catch (Exception e10) {
            Log.e(TAG, "[onSessionScreenReadyNew] Error: " + e10.getMessage(), e10);
            endCallProcess();
        }
    }

    private final WebRtcSessionManagerImpl provideSessionManager(TurnCredentials turnCredentials, boolean ownerIsCalling) {
        MainModule.Companion companion = MainModule.INSTANCE;
        return new WebRtcSessionManagerImpl(companion.getInstance().getAppContext(), new StreamPeerConnectionFactory(companion.getInstance().getAppContext(), turnCredentials), new lb.a() { // from class: cu.todus.android.xmpp.managers.e
            @Override // lb.a
            public final Object invoke() {
                return CallManager.provideSessionManager$lambda$0(this.f28859c);
            }
        }, new Function1() { // from class: cu.todus.android.xmpp.managers.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CallManager.provideSessionManager$lambda$1(this.f28860c, (String) obj);
            }
        }, new lb.a() { // from class: cu.todus.android.xmpp.managers.g
            @Override // lb.a
            public final Object invoke() {
                return CallManager.provideSessionManager$lambda$2(this.f28861c);
            }
        }, ownerIsCalling, new Function1() { // from class: cu.todus.android.xmpp.managers.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CallManager.provideSessionManager$lambda$3((NetworkChangeMonitor.NetworkChangeEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 provideSessionManager$lambda$0(CallManager callManager) {
        Log.e(TAG, "WebRtcSessionManager error. Finalizando proceso de llamada.");
        callManager.endCallProcess();
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 provideSessionManager$lambda$1(CallManager callManager, String command) {
        kotlin.jvm.internal.y.i(command, "command");
        callManager.sendCmdIQ(command);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 provideSessionManager$lambda$2(CallManager callManager) {
        te.b0 b0Var = callManager._callState;
        CallState callState = (CallState) b0Var.getValue();
        b0Var.setValue(callState != null ? CallState.copy$default(callState, null, null, false, false, true, null, null, null, null, 0, false, 2031, null) : null);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k0 provideSessionManager$lambda$3(NetworkChangeMonitor.NetworkChangeEvent event) {
        kotlin.jvm.internal.y.i(event, "event");
        NetworkChangeMonitor.NetworkType type = event.getType();
        NetworkChangeMonitor.ConnectionType connectionType = event.getConnectionType();
        Objects.toString(type);
        Objects.toString(connectionType);
        int i10 = WhenMappings.$EnumSwitchMapping$0[event.getConnectionType().ordinal()];
        if (i10 == 1) {
            Log.w(TAG, "[onNetworkChange] Red cambió durante la llamada. Esperando reconexión...");
        } else if (i10 == 2) {
            Log.e(TAG, "[onNetworkChange] Red desconectada durante la llamada!");
        } else if (i10 == 3) {
            Objects.toString(event.getType());
        }
        return k0.f43947a;
    }

    private final void receiveCallConfig(String value) {
        CallState callState = (CallState) this._callState.getValue();
        if (callState != null) {
            ConfigKey configKey = ConfigKey.MIC;
            CallMediaState callMediaStateCopy$default = null;
            if (le.a0.U(value, configKey.toString(), false, 2, null)) {
                callMediaStateCopy$default = CallMediaState.copy$default(callState.getWithCallMediaState(), Boolean.parseBoolean(le.a0.O(value, configKey + "_", "", false, 4, null)), false, false, 6, null);
            } else {
                ConfigKey configKey2 = ConfigKey.CAMERA;
                if (le.a0.U(value, configKey2.toString(), false, 2, null)) {
                    callMediaStateCopy$default = CallMediaState.copy$default(callState.getWithCallMediaState(), false, Boolean.parseBoolean(le.a0.O(value, configKey2 + "_", "", false, 4, null)), false, 5, null);
                }
            }
            CallMediaState callMediaState = callMediaStateCopy$default;
            if (callMediaState != null) {
                this._callState.setValue(CallState.copy$default(callState, null, null, false, false, false, callMediaState, null, null, null, 0, false, 2015, null));
            }
        }
    }

    private final void receiveCallEnded(final String uid) {
        sendEndCall(uid);
        this.notificationManager.cancelNotifications(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(uid));
        this.requestingCalls.removeAll(new Function1() { // from class: cu.todus.android.xmpp.managers.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallManager.receiveCallEnded$lambda$0(uid, (CallState) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean receiveCallEnded$lambda$0(String str, CallState it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getWith(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:30:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:39:0x0150 A[Catch: Exception -> 0x0163, TryCatch #1 {Exception -> 0x0163, blocks: (B:34:0x011b, B:37:0x0135, B:39:0x0150, B:42:0x0165), top: B:52:0x011b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0165 A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #1 {Exception -> 0x0163, blocks: (B:34:0x011b, B:37:0x0135, B:39:0x0150, B:42:0x0165), top: B:52:0x011b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x00f8, please report this as an issue */
    public final Object receiveCallProcess(String str, String str2, String str3, CallMediaState callMediaState, TurnCredentials turnCredentials, String str4, ab.e<? super k0> eVar) {
        C14041 c14041;
        String str5;
        CallMediaState callMediaState2;
        String str6;
        String str7;
        String str8;
        TurnCredentials turnCredentials2;
        Partner partner;
        TurnCredentials turnCredentials3;
        String str9;
        CallMediaState callMediaState3;
        TurnCredentials turnCredentials4;
        String str10;
        CallMediaState callMediaState4;
        String str11;
        String str12;
        String str13;
        boolean z10;
        List listS0;
        User user;
        if (eVar instanceof C14041) {
            c14041 = (C14041) eVar;
            int i10 = c14041.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14041.label = i10 - Integer.MIN_VALUE;
            } else {
                c14041 = new C14041(eVar);
            }
        } else {
            c14041 = new C14041(eVar);
        }
        Object partnerById = c14041.result;
        Object objG = bb.b.g();
        int i11 = c14041.label;
        try {
            try {
                if (i11 == 0) {
                    ua.v.b(partnerById);
                    UserDao userDao = this.dataBaseModule.getUserDao();
                    c14041.L$0 = str;
                    c14041.L$1 = str2;
                    str5 = str3;
                    c14041.L$2 = str5;
                    callMediaState2 = callMediaState;
                    c14041.L$3 = callMediaState2;
                    c14041.L$4 = turnCredentials;
                    c14041.L$5 = str4;
                    c14041.label = 1;
                    partnerById = userDao.getPartnerById(str, c14041);
                    if (partnerById != objG) {
                        str6 = str;
                        str7 = str4;
                        str8 = str2;
                        turnCredentials2 = turnCredentials;
                    }
                    return objG;
                }
                if (i11 == 1) {
                    str7 = (String) c14041.L$5;
                    turnCredentials2 = (TurnCredentials) c14041.L$4;
                    CallMediaState callMediaState5 = (CallMediaState) c14041.L$3;
                    String str14 = (String) c14041.L$2;
                    str8 = (String) c14041.L$1;
                    str6 = (String) c14041.L$0;
                    ua.v.b(partnerById);
                    callMediaState2 = callMediaState5;
                    str5 = str14;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str7 = (String) c14041.L$5;
                    turnCredentials4 = (TurnCredentials) c14041.L$4;
                    callMediaState4 = (CallMediaState) c14041.L$3;
                    str10 = (String) c14041.L$2;
                    str11 = (String) c14041.L$1;
                    str12 = (String) c14041.L$0;
                    ua.v.b(partnerById);
                }
                user = (User) partnerById;
                if (user != null) {
                    Log.e(TAG, "No se pudo encontrar información para el usuario " + str12 + ". Descartando llamada.");
                    return k0.f43947a;
                }
                partner = new Partner(user, null, null, 6, null);
                str6 = str12;
                turnCredentials3 = turnCredentials4;
                callMediaState3 = callMediaState4;
                str9 = str10;
                str8 = str11;
                Partner partner2 = partner;
                str13 = str7;
                z10 = false;
                listS0 = d0.S0(str13, new String[]{" "}, false, 0, 6, null);
                g0.G0(listS0, ", ", null, null, 0, null, null, 62, null);
                if (listS0.size() > 1) {
                    boolean zD = kotlin.jvm.internal.y.d(listS0.get(1), "1");
                    Objects.toString(listS0.get(1));
                    z10 = zD;
                } else {
                    Log.w(TAG, "receiveCallProcess - Comando sin parámetro de video. Usando false.");
                }
                boolean z11 = z10;
                int iBuildCallQuality = buildCallQuality(str8);
                String str15 = str6;
                CallState callState = new CallState(null, str15, false, false, false, callMediaState3, turnCredentials3, partner2, str9, iBuildCallQuality, z11, 25, null);
                this.requestingCalls.add(callState);
                sendIncomingCallNotificationNew(str15, partner2, callState.isVideoCall());
                Log.i(TAG, "Llamada entrante de " + str15 + " añadida a la lista de solicitudes. Videollamada: " + z11);
                return k0.f43947a;
                listS0 = d0.S0(str13, new String[]{" "}, false, 0, 6, null);
                g0.G0(listS0, ", ", null, null, 0, null, null, 62, null);
                if (listS0.size() > 1) {
                    boolean zD2 = kotlin.jvm.internal.y.d(listS0.get(1), "1");
                    Objects.toString(listS0.get(1));
                    z10 = zD2;
                } else {
                    Log.w(TAG, "receiveCallProcess - Comando sin parámetro de video. Usando false.");
                }
            } catch (Exception e10) {
                e = e10;
                str13 = str13;
                Log.w(TAG, "Error al detectar tipo de llamada del comando: '" + str13 + "'. Error: " + e.getMessage());
            }
        } catch (Exception e11) {
            e = e11;
        }
        partner = (Partner) partnerById;
        if (partner == null) {
            Function2 function2 = this.getUserInfo;
            c14041.L$0 = str6;
            c14041.L$1 = str8;
            c14041.L$2 = str5;
            c14041.L$3 = callMediaState2;
            c14041.L$4 = turnCredentials2;
            c14041.L$5 = str7;
            c14041.L$6 = cb.l.a(partner);
            c14041.label = 2;
            partnerById = function2.invoke(str6, c14041);
            if (partnerById != objG) {
                turnCredentials4 = turnCredentials2;
                str10 = str5;
                callMediaState4 = callMediaState2;
                str11 = str8;
                str12 = str6;
                user = (User) partnerById;
                if (user != null) {
                    Log.e(TAG, "No se pudo encontrar información para el usuario " + str12 + ". Descartando llamada.");
                    return k0.f43947a;
                }
                partner = new Partner(user, null, null, 6, null);
                str6 = str12;
                turnCredentials3 = turnCredentials4;
                callMediaState3 = callMediaState4;
                str9 = str10;
                str8 = str11;
            }
            return objG;
        }
        turnCredentials3 = turnCredentials2;
        str9 = str5;
        callMediaState3 = callMediaState2;
        Partner partner3 = partner;
        str13 = str7;
        z10 = false;
        boolean z12 = z10;
        int iBuildCallQuality2 = buildCallQuality(str8);
        String str16 = str6;
        CallState callState2 = new CallState(null, str16, false, false, false, callMediaState3, turnCredentials3, partner3, str9, iBuildCallQuality2, z12, 25, null);
        this.requestingCalls.add(callState2);
        sendIncomingCallNotificationNew(str16, partner3, callState2.isVideoCall());
        Log.i(TAG, "Llamada entrante de " + str16 + " añadida a la lista de solicitudes. Videollamada: " + z12);
        return k0.f43947a;
    }

    public static /* synthetic */ Object receiveCallProcess$default(CallManager callManager, String str, String str2, String str3, CallMediaState callMediaState, TurnCredentials turnCredentials, String str4, ab.e eVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            str4 = "";
        }
        return callManager.receiveCallProcess(str, str2, str3, callMediaState, turnCredentials, str4, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object receivePickupProcess(String str, String str2, ab.e<? super k0> eVar) {
        C14051 c14051;
        CallState callState;
        String str3;
        String str4 = str;
        if (eVar instanceof C14051) {
            c14051 = (C14051) eVar;
            int i10 = c14051.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14051.label = i10 - Integer.MIN_VALUE;
            } else {
                c14051 = new C14051(eVar);
            }
        } else {
            c14051 = new C14051(eVar);
        }
        Object obj = c14051.result;
        Object objG = bb.b.g();
        int i11 = c14051.label;
        if (i11 == 0) {
            ua.v.b(obj);
            CallState callState2 = (CallState) this.callState.getValue();
            if (kotlin.jvm.internal.y.d(callState2 != null ? callState2.getWith() : null, str4)) {
                cancelTimeout(str);
                String msgId = callState2.getMsgId();
                c14051.L$0 = str4;
                c14051.L$1 = str2;
                c14051.L$2 = callState2;
                c14051.label = 1;
                if (updateStartTime(msgId, c14051) == objG) {
                    return objG;
                }
                callState = callState2;
                str3 = str2;
            } else {
                Log.w(TAG, "Se recibió PICKED para una llamada no existente o diferente. UID actual: " + (callState2 != null ? callState2.getWith() : null) + ", UID recibido: " + str4);
            }
            return k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CallState callState3 = (CallState) c14051.L$2;
        str3 = (String) c14051.L$1;
        String str5 = (String) c14051.L$0;
        ua.v.b(obj);
        callState = callState3;
        str4 = str5;
        startCallService(callState.getPartner().getName());
        this._callState.setValue(CallState.copy$default(callState, null, null, false, true, false, null, null, null, null, buildCallQuality(str3), false, 1527, null));
        onSessionScreenReadyNew();
        Log.i(TAG, "Llamada con " + str4 + " aceptada y comenzada.");
        return k0.f43947a;
    }

    private final void receiveRejectCall(final String uid) {
        CallState callState = (CallState) this._callState.getValue();
        if (kotlin.jvm.internal.y.d(uid, callState != null ? callState.getWith() : null)) {
            this._callState.setValue(null);
            this.ownerCallMediaState.setValue(new CallMediaState(false, false, false, 7, null));
            closeCallService();
        }
        this.requestingCalls.removeAll(new Function1() { // from class: cu.todus.android.xmpp.managers.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallManager.receiveRejectCall$lambda$0(uid, (CallState) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean receiveRejectCall$lambda$0(String str, CallState it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getWith(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x007f A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:12:0x002e, B:24:0x0077, B:27:0x007f, B:30:0x0087, B:19:0x003f, B:21:0x0049), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x0087 A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:12:0x002e, B:24:0x0077, B:27:0x007f, B:30:0x0087, B:19:0x003f, B:21:0x0049), top: B:34:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object requestTurnCredentials(ab.e<? super TurnCredentials> eVar) {
        C14061 c14061;
        GetCredentialsIQ getCredentialsIQ;
        TurnCredentials turnCredentials;
        if (eVar instanceof C14061) {
            c14061 = (C14061) eVar;
            int i10 = c14061.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14061.label = i10 - Integer.MIN_VALUE;
            } else {
                c14061 = new C14061(eVar);
            }
        } else {
            c14061 = new C14061(eVar);
        }
        Object objX = c14061.result;
        Object objG = bb.b.g();
        int i11 = c14061.label;
        try {
            if (i11 == 0) {
                ua.v.b(objX);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    GetCredentialsIQ getCredentialsIQ2 = new GetCredentialsIQ(((Owner) this.owner.invoke()).getNameWithDomain(), null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getCredentialsIQ2);
                    c14061.L$0 = cb.l.a(xMPPTCPConnection);
                    c14061.L$1 = cb.l.a(getCredentialsIQ2);
                    c14061.I$0 = 0;
                    c14061.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14061);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    getCredentialsIQ = null;
                }
                if (getCredentialsIQ != null) {
                    turnCredentials = getCredentialsIQ.getTurnCredentials();
                } else {
                    turnCredentials = null;
                }
                if (turnCredentials != null) {
                    return getCredentialsIQ.getTurnCredentials();
                }
                return null;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
            getCredentialsIQ = (GetCredentialsIQ) ((IQ) objX);
            if (getCredentialsIQ != null) {
                turnCredentials = getCredentialsIQ.getTurnCredentials();
            } else {
                turnCredentials = null;
            }
            if (turnCredentials != null) {
                return getCredentialsIQ.getTurnCredentials();
            }
        } catch (Exception e10) {
            Log.e(TAG, "Excepción al solicitar credenciales TURN", e10);
        }
        return null;
    }

    private final void sendCmdIQ(String command) {
        String with;
        CallState callState = (CallState) this.callState.getValue();
        if (callState == null || (with = callState.getWith()) == null) {
            return;
        }
        if (!((Boolean) this.canSend.invoke()).booleanValue()) {
            Log.e(TAG, "No se puede enviar comando: la conexión no está disponible.");
            return;
        }
        String str = (String) g0.y0(d0.S0(command, new String[]{" "}, false, 0, 6, null));
        if (str == null) {
            str = "";
        }
        buildAndSendCommandIQ$default(this, with, str, command, null, 8, null);
    }

    private final void sendIncomingCallNotificationNew(String uid, Partner partner, boolean isVideoCall) {
        String str;
        try {
            str = uid;
            try {
                this.notificationManager.notify(new CallNotification(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(uid), str, partner.getName(), partner.getPicture(), isVideoCall));
            } catch (Exception e10) {
                e = e10;
                Log.e(TAG, "Error al enviar notificación de llamada para " + str, e);
            }
        } catch (Exception e11) {
            e = e11;
            str = uid;
        }
    }

    public static /* synthetic */ void sendIncomingCallNotificationNew$default(CallManager callManager, String str, Partner partner, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        callManager.sendIncomingCallNotificationNew(str, partner, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sendPickupIQ$lambda$1(String str, CallState it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getWith(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sendRejectIQ$lambda$0(String str, CallState it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it.getWith(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stanzaListener$lambda$0(CallManager callManager, Stanza stanza) {
        if (stanza instanceof CallStatusIQ) {
            CoroutineUtilsKt.launchWithContext$default(callManager.coroutineScope, null, null, new CallManager$stanzaListener$1$1(stanza, callManager, null), 3, null);
        }
    }

    public static /* synthetic */ Object startCallProcess$default(CallManager callManager, String str, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return callManager.startCallProcess(str, z10, aVar, aVar2, aVar3, eVar);
    }

    public static /* synthetic */ Object startCallProcessNew$default(CallManager callManager, String str, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return callManager.startCallProcessNew(str, z10, aVar, aVar2, aVar3, eVar);
    }

    private final void startCallService(String withName) {
        this.appVolatileState.setCallStartTime(new Date().getTime());
        CallServiceUtility.INSTANCE.startService(MainModule.INSTANCE.getInstance().getAppContext(), withName);
    }

    private final void startTimeout(String uid) {
        a2 a2Var = this.timeoutJob;
        if (a2Var != null) {
            a2.a.a(a2Var, null, 1, null);
        }
        this.timeoutJob = pe.k.d(this.coroutineScope, null, null, new C14101(uid, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ef, code lost:
    
        if (r1.update(r8, r2) == r3) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateEndTime(java.lang.String r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.updateEndTime(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ef, code lost:
    
        if (r1.update(r8, r2) == r3) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateStartTime(java.lang.String r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.updateStartTime(java.lang.String, ab.e):java.lang.Object");
    }

    public final void destroy() {
        Log.i(TAG, "Destruyendo CallManager, cancelando todos los jobs.");
        a2.a.a(this.job, null, 1, null);
        closeCallService();
    }

    public final AttachmentDao getAttachmentDao() {
        return this.attachmentDao;
    }

    public final p0 getCallState() {
        return this.callState;
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    public final Function2 getGetUserInfo() {
        return this.getUserInfo;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final MessageDao getMessageDao() {
        return this.messageDao;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final te.b0 getOwnerCallMediaState() {
        return this.ownerCallMediaState;
    }

    public final Z17MutableListFlow<CallState> getRequestingCalls() {
        return this.requestingCalls;
    }

    public final RoomDao getRoomDao() {
        return this.roomDao;
    }

    public final WebRtcSessionManagerImpl getSessionManager() {
        return this.sessionManager;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:32:0x012b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0131  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c1  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0192, code lost:
    
        if (receivePickupProcess(r3, r5, r7) == r8) goto L40;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0131, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onCallMessage(java.lang.String r20, cu.todus.android.data.db.pojo.content.CallContent r21, boolean r22, ab.e<? super ua.k0> r23) {
        /*
            Method dump skipped, instruction units count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.onCallMessage(java.lang.String, cu.todus.android.data.db.pojo.content.CallContent, boolean, ab.e):java.lang.Object");
    }

    public final void sendEndCall(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        CallState callState = (CallState) this.callState.getValue();
        if (kotlin.jvm.internal.y.d(callState != null ? callState.getWith() : null, uid)) {
            cancelTimeout(uid);
            endCallProcess();
            return;
        }
        CallState callState2 = (CallState) this.callState.getValue();
        Log.w(TAG, "Se solicitó finalizar la llamada con " + uid + ", pero la llamada actual es con " + (callState2 != null ? callState2.getWith() : null) + ". Ignorando.");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x010e  */
    /* JADX WARN: Code duplicated, block: B:32:0x011c  */
    /* JADX WARN: Code duplicated, block: B:34:0x013b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0143  */
    /* JADX WARN: Code duplicated, block: B:38:0x014d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0152  */
    /* JADX WARN: Code duplicated, block: B:42:0x016d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0192  */
    /* JADX WARN: Code duplicated, block: B:48:0x019f  */
    /* JADX WARN: Code duplicated, block: B:51:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:54:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:57:0x0245  */
    /* JADX WARN: Code duplicated, block: B:59:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0108, code lost:
    
        if (pe.w0.b(600, r12) == r3) goto L56;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x011c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:59:0x02a2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x02c1, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0108 -> B:29:0x010c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendPickupIQ(java.lang.String r32, lb.a r33, lb.a r34, lb.a r35, ab.e<? super ua.k0> r36) {
        /*
            Method dump skipped, instruction units count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.sendPickupIQ(java.lang.String, lb.a, lb.a, lb.a, ab.e):java.lang.Object");
    }

    public final void sendRejectIQ(final String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        if (!((Boolean) this.canSend.invoke()).booleanValue()) {
            Log.e(TAG, "No se puede enviar mensaje de rechazo: la conexión no está disponible.");
            return;
        }
        SignalingCommand signalingCommand = SignalingCommand.REJECT;
        buildAndSendCommandIQ$default(this, uid, signalingCommand.toString(), String.valueOf(signalingCommand), null, 8, null);
        this.requestingCalls.removeAll(new Function1() { // from class: cu.todus.android.xmpp.managers.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallManager.sendRejectIQ$lambda$0(uid, (CallState) obj));
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:47:0x018e  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object startCallProcess(String str, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e<? super k0> eVar) {
        C14081 c14081;
        lb.a aVar4;
        boolean z11;
        String str2;
        lb.a aVar5;
        lb.a aVar6;
        lb.a aVar7;
        boolean z12;
        lb.a aVar8;
        long j10;
        Object objRequestTurnCredentials;
        lb.a aVar9;
        TurnCredentials turnCredentials;
        Object partnerById;
        boolean z13;
        lb.a aVar10;
        TurnCredentials turnCredentials2;
        lb.a aVar11;
        long j11;
        String callId;
        String str3;
        lb.a aVar12;
        if (eVar instanceof C14081) {
            c14081 = (C14081) eVar;
            int i10 = c14081.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14081.label = i10 - Integer.MIN_VALUE;
            } else {
                c14081 = new C14081(eVar);
            }
        } else {
            c14081 = new C14081(eVar);
        }
        C14081 c14082 = c14081;
        Object obj = c14082.result;
        Object objG = bb.b.g();
        int i11 = c14082.label;
        String str4 = TAG;
        if (i11 == 0) {
            ua.v.b(obj);
            if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                Log.e(TAG, "No se puede iniciar la llamada: la conexión no está disponible.");
                aVar3.invoke();
                return k0.f43947a;
            }
            if (this.callState.getValue() != null) {
                CallState callState = (CallState) this.callState.getValue();
                Log.w(TAG, "No se puede iniciar la llamada: ya hay una llamada en curso con " + (callState != null ? callState.getWith() : null));
                aVar2.invoke();
                return k0.f43947a;
            }
            c14082.L$0 = str;
            c14082.L$1 = aVar;
            c14082.L$2 = cb.l.a(aVar2);
            aVar4 = aVar3;
            c14082.L$3 = aVar4;
            z11 = z10;
            c14082.Z$0 = z11;
            c14082.label = 1;
            if (createRoomIfNeed(str, c14082) != objG) {
                str2 = str;
                aVar5 = aVar;
                aVar6 = aVar2;
            }
            return objG;
        }
        if (i11 == 1) {
            boolean z14 = c14082.Z$0;
            aVar4 = (lb.a) c14082.L$3;
            lb.a aVar13 = (lb.a) c14082.L$2;
            aVar5 = (lb.a) c14082.L$1;
            str2 = (String) c14082.L$0;
            ua.v.b(obj);
            z11 = z14;
            aVar6 = aVar13;
        } else {
            if (i11 == 2) {
                j10 = c14082.J$0;
                z12 = c14082.Z$0;
                aVar4 = (lb.a) c14082.L$3;
                lb.a aVar14 = (lb.a) c14082.L$2;
                lb.a aVar15 = (lb.a) c14082.L$1;
                String str5 = (String) c14082.L$0;
                ua.v.b(obj);
                aVar7 = aVar14;
                aVar8 = aVar15;
                str2 = str5;
                c14082.L$0 = str2;
                c14082.L$1 = aVar8;
                c14082.L$2 = cb.l.a(aVar7);
                c14082.L$3 = aVar4;
                c14082.Z$0 = z12;
                c14082.J$0 = j10;
                c14082.label = 3;
                objRequestTurnCredentials = requestTurnCredentials(c14082);
                if (objRequestTurnCredentials != objG) {
                    aVar9 = aVar7;
                    obj = objRequestTurnCredentials;
                    turnCredentials = (TurnCredentials) obj;
                    UserDao userDao = this.dataBaseModule.getUserDao();
                    c14082.L$0 = str2;
                    c14082.L$1 = aVar8;
                    c14082.L$2 = cb.l.a(aVar9);
                    c14082.L$3 = aVar4;
                    c14082.L$4 = turnCredentials;
                    c14082.Z$0 = z12;
                    c14082.J$0 = j10;
                    c14082.label = 4;
                    partnerById = userDao.getPartnerById(str2, c14082);
                    if (partnerById != objG) {
                        z13 = z12;
                        aVar10 = aVar4;
                        turnCredentials2 = turnCredentials;
                        obj = partnerById;
                        long j12 = j10;
                        aVar11 = aVar9;
                        j11 = j12;
                        String str6 = str2;
                        Partner partner = (Partner) obj;
                        if (turnCredentials2 == null) {
                        }
                        Log.e(str4, "Error al iniciar la llamada: no se obtuvieron credenciales o el partner es nulo.");
                        aVar10.invoke();
                        return k0.f43947a;
                    }
                }
                return objG;
            }
            if (i11 == 3) {
                j10 = c14082.J$0;
                z12 = c14082.Z$0;
                aVar4 = (lb.a) c14082.L$3;
                aVar9 = (lb.a) c14082.L$2;
                aVar8 = (lb.a) c14082.L$1;
                str2 = (String) c14082.L$0;
                ua.v.b(obj);
                str4 = TAG;
                turnCredentials = (TurnCredentials) obj;
                UserDao userDao2 = this.dataBaseModule.getUserDao();
                c14082.L$0 = str2;
                c14082.L$1 = aVar8;
                c14082.L$2 = cb.l.a(aVar9);
                c14082.L$3 = aVar4;
                c14082.L$4 = turnCredentials;
                c14082.Z$0 = z12;
                c14082.J$0 = j10;
                c14082.label = 4;
                partnerById = userDao2.getPartnerById(str2, c14082);
                if (partnerById != objG) {
                    z13 = z12;
                    aVar10 = aVar4;
                    turnCredentials2 = turnCredentials;
                    obj = partnerById;
                    long j13 = j10;
                    aVar11 = aVar9;
                    j11 = j13;
                    String str7 = str2;
                    Partner partner2 = (Partner) obj;
                    if (turnCredentials2 == null) {
                    }
                    Log.e(str4, "Error al iniciar la llamada: no se obtuvieron credenciales o el partner es nulo.");
                    aVar10.invoke();
                    return k0.f43947a;
                }
                return objG;
            }
            if (i11 == 4) {
                j11 = c14082.J$0;
                boolean z15 = c14082.Z$0;
                turnCredentials2 = (TurnCredentials) c14082.L$4;
                lb.a aVar16 = (lb.a) c14082.L$3;
                aVar11 = (lb.a) c14082.L$2;
                lb.a aVar17 = (lb.a) c14082.L$1;
                str2 = (String) c14082.L$0;
                ua.v.b(obj);
                z13 = z15;
                aVar10 = aVar16;
                str4 = TAG;
                aVar8 = aVar17;
                String str8 = str2;
                Partner partner3 = (Partner) obj;
                if (turnCredentials2 == null && partner3 != null) {
                    cleanupSessionManagerNew();
                    this.sessionManager = provideSessionManager(turnCredentials2, true);
                    String string = UUID.randomUUID().toString();
                    kotlin.jvm.internal.y.h(string, "toString(...)");
                    String str9 = "call_" + le.a0.O(string, "-", "", false, 4, null);
                    TurnCredentials turnCredentials3 = turnCredentials2;
                    lb.a aVar18 = aVar10;
                    boolean z16 = z13;
                    this._callState.setValue(new CallState(null, str8, true, false, false, new CallMediaState(false, false, false, 7, null), turnCredentials3, partner3, str9, ((CallQuality) this.appVolatileState.getCallQuality().getValue()).getSendQuality(), z13, 25, null));
                    CallState callState2 = (CallState) this._callState.getValue();
                    if (callState2 == null || (callId = callState2.getCallId()) == null) {
                        callId = "";
                    }
                    c14082.L$0 = str8;
                    c14082.L$1 = aVar8;
                    c14082.L$2 = cb.l.a(aVar11);
                    c14082.L$3 = cb.l.a(aVar18);
                    c14082.L$4 = cb.l.a(turnCredentials3);
                    c14082.L$5 = cb.l.a(partner3);
                    c14082.L$6 = cb.l.a(str9);
                    c14082.Z$0 = z16;
                    c14082.J$0 = j11;
                    c14082.label = 5;
                    if (buildStartCallMessage(str8, callId, str9, j11, z16, c14082) != objG) {
                        str3 = str8;
                        aVar12 = aVar8;
                    }
                    return objG;
                }
                Log.e(str4, "Error al iniciar la llamada: no se obtuvieron credenciales o el partner es nulo.");
                aVar10.invoke();
                return k0.f43947a;
            }
            if (i11 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar12 = (lb.a) c14082.L$1;
            str3 = (String) c14082.L$0;
            ua.v.b(obj);
            str4 = TAG;
        }
        aVar12.invoke();
        cb.b.d(Log.i(str4, "Proceso de llamada iniciado con " + str3 + "."));
        return k0.f43947a;
        long time = new Date().getTime();
        c14082.L$0 = str2;
        c14082.L$1 = aVar5;
        c14082.L$2 = cb.l.a(aVar6);
        c14082.L$3 = aVar4;
        c14082.Z$0 = z11;
        c14082.J$0 = time;
        c14082.label = 2;
        if (insertDateMsg(str2, time, c14082) != objG) {
            aVar7 = aVar6;
            z12 = z11;
            aVar8 = aVar5;
            j10 = time;
            c14082.L$0 = str2;
            c14082.L$1 = aVar8;
            c14082.L$2 = cb.l.a(aVar7);
            c14082.L$3 = aVar4;
            c14082.Z$0 = z12;
            c14082.J$0 = j10;
            c14082.label = 3;
            objRequestTurnCredentials = requestTurnCredentials(c14082);
            if (objRequestTurnCredentials != objG) {
                aVar9 = aVar7;
                obj = objRequestTurnCredentials;
                turnCredentials = (TurnCredentials) obj;
                UserDao userDao3 = this.dataBaseModule.getUserDao();
                c14082.L$0 = str2;
                c14082.L$1 = aVar8;
                c14082.L$2 = cb.l.a(aVar9);
                c14082.L$3 = aVar4;
                c14082.L$4 = turnCredentials;
                c14082.Z$0 = z12;
                c14082.J$0 = j10;
                c14082.label = 4;
                partnerById = userDao3.getPartnerById(str2, c14082);
                if (partnerById != objG) {
                    z13 = z12;
                    aVar10 = aVar4;
                    turnCredentials2 = turnCredentials;
                    obj = partnerById;
                    long j14 = j10;
                    aVar11 = aVar9;
                    j11 = j14;
                    String str10 = str2;
                    Partner partner4 = (Partner) obj;
                    if (turnCredentials2 == null) {
                    }
                    Log.e(str4, "Error al iniciar la llamada: no se obtuvieron credenciales o el partner es nulo.");
                    aVar10.invoke();
                    return k0.f43947a;
                }
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:21:0x0116
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final java.lang.Object startCallProcessNew(java.lang.String r30, boolean r31, lb.a r32, lb.a r33, lb.a r34, ab.e<? super ua.k0> r35) {
        /*
            Method dump skipped, instruction units count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.CallManager.startCallProcessNew(java.lang.String, boolean, lb.a, lb.a, lb.a, ab.e):java.lang.Object");
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void startManager() {
        StanzaFilter stanzaFilter = IQTypeFilter.RESULT;
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.addAsyncStanzaListener(this.stanzaListener, stanzaFilter);
        }
    }

    @Override // cu.todus.android.xmpp.StanzaListenerManager
    public void stopManager() {
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
        if (xMPPTCPConnection != null) {
            xMPPTCPConnection.removeAsyncStanzaListener(this.stanzaListener);
        }
    }
}
