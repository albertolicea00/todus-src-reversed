package cu.todus.android.repositories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.FileProvider;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.paging.PagingSource;
import androidx.room.RoomDatabaseKt;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.ToDusApp;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Reaction;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.ChannelSubscriber;
import cu.todus.android.data.db.pojo.FollowPartner;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.MarkerWithPartner;
import cu.todus.android.data.db.pojo.MessageWithAttachments;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.db.pojo.NearPartner;
import cu.todus.android.data.db.pojo.ReactionWithPartner;
import cu.todus.android.data.db.pojo.RoomMember;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.content.DeletedContent;
import cu.todus.android.data.db.pojo.content.EventContent;
import cu.todus.android.data.db.pojo.content.FileContent;
import cu.todus.android.data.db.pojo.content.LinkEntity;
import cu.todus.android.data.db.pojo.content.LinkInfoContent;
import cu.todus.android.data.db.pojo.content.LocationContent;
import cu.todus.android.data.db.pojo.content.ReplyMsgContent;
import cu.todus.android.data.db.pojo.messageentity.MessageEntity;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.AppStateStep;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.data.wrapper.DataWrapper;
import cu.todus.android.data.xmpp.AddMembersToGroupResponse;
import cu.todus.android.data.xmpp.AdminGroupActionsResponse;
import cu.todus.android.data.xmpp.ChannelAdmin;
import cu.todus.android.data.xmpp.ChannelInfo;
import cu.todus.android.data.xmpp.EditToDusIdResponse;
import cu.todus.android.data.xmpp.FileResponse;
import cu.todus.android.data.xmpp.FollowState;
import cu.todus.android.data.xmpp.JoinResult;
import cu.todus.android.data.xmpp.MucInfo;
import cu.todus.android.db.ToDusDatabase;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.db.dao.toDus.StickerDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.MediaModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.di.RetrofitModule;
import cu.todus.android.firebase.FirebaseDataSource;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.rest.auth.AuthDataSource;
import cu.todus.android.rest.certified.CertifiedInfoDataSource;
import cu.todus.android.s3.download.DownloadDataSource;
import cu.todus.android.s3.upload.UploadDataSource;
import cu.todus.android.s3.upload.UploadStatusDataSource;
import cu.todus.android.uiCompose.call.screen.call.CallMediaState;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.IntentUtil;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.webrtc.CallState;
import cu.todus.android.webrtc.sessions.WebRtcSessionManagerImpl;
import cu.todus.android.xmpp.ConnectionState;
import cu.todus.android.xmpp.XMPPDataSource;
import cu.todus.android.xmpp.XMPPUtils;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import cu.todus.android.xmpp.iq.last.LastIQ;
import cu.todus.android.xmpp.iq.version.GetUpdateInfoIQ;
import cu.todus.android.xmpp.managers.BlocksManager;
import cu.todus.android.xmpp.managers.CallManager;
import cu.todus.android.xmpp.managers.ChannelManager;
import cu.todus.android.xmpp.managers.GroupsManager;
import cu.todus.android.xmpp.managers.LastManager;
import cu.todus.android.xmpp.managers.LocationManager;
import cu.todus.android.xmpp.managers.PresenceManager;
import cu.todus.android.xmpp.managers.PrivacyManager;
import cu.todus.android.xmpp.managers.ProfileManager;
import cu.todus.android.xmpp.managers.RosterManager;
import cu.todus.android.xmpp.managers.StatusManager;
import cu.todus.android.xmpp.managers.UrlManager;
import cu.z17.compress.Compressor;
import cu.z17.compress.constraint.Compression;
import cu.z17.compress.constraint.QualityConstraintKt;
import cu.z17.compress.constraint.ResolutionConstraintKt;
import cu.z17.compress.constraint.SizeConstraintKt;
import cu.z17.singledi.SinglediException;
import cu.z17.singledi.SingletonInitializer;
import cu.z17.views.utils.Z17CoilDecoders;
import cu.z17.views.utils.Z17InlineUtilsKt;
import cu.z17.views.utils.Z17MutableListFlow;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.u0;
import kotlin.jvm.internal.y0;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import pe.d1;
import pe.e2;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000à\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 À\u00032\u00020\u0001:\u0002À\u0003B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0007\u0012(\u0010\u0010\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u001b\u0010\u0019J \u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0082@¢\u0006\u0004\b\u001f\u0010 J(\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b&\u0010'J\"\u0010+\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020)H\u0082@¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b.\u0010'J \u00100\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020/H\u0082@¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0082@¢\u0006\u0004\b2\u00103J,\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b7\u00108J\u0018\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b:\u0010'J\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;¢\u0006\u0004\b=\u0010>J\u0013\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?¢\u0006\u0004\bA\u0010BJ\u001a\u0010D\u001a\u00020\b2\b\b\u0002\u0010C\u001a\u00020\u0012H\u0086@¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000f¢\u0006\u0004\bI\u0010JJ\u0013\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120K¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010N\u001a\u00020\u0012¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020\u0012¢\u0006\u0004\bQ\u0010RJ\u0012\u0010T\u001a\u0004\u0018\u00010SH\u0086@¢\u0006\u0004\bT\u0010\u0019J\r\u0010U\u001a\u00020\b¢\u0006\u0004\bU\u0010\u0017J\u0010\u0010V\u001a\u00020\bH\u0086@¢\u0006\u0004\bV\u0010\u0019J\u0018\u0010W\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bW\u0010'J\"\u0010Z\u001a\u0004\u0018\u00010\u00012\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u0012H\u0086@¢\u0006\u0004\bZ\u0010[J\u001e\u0010^\u001a\u00020\b2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0004\b^\u0010_J\u001a\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0004\ba\u0010'J\u001d\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010`0b2\u0006\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\bc\u0010dJ\u001d\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0b2\u0006\u00109\u001a\u00020\u000f¢\u0006\u0004\bf\u0010dJ\u001e\u0010i\u001a\u00020\b2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020g0\\H\u0086@¢\u0006\u0004\bi\u0010_J\u0010\u0010j\u001a\u00020\bH\u0086@¢\u0006\u0004\bj\u0010\u0019J\u0010\u0010k\u001a\u00020\bH\u0086@¢\u0006\u0004\bk\u0010\u0019J\u0018\u0010l\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bl\u0010'J \u0010o\u001a\u0004\u0018\u00010n2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0004\bo\u0010_J\u001a\u0010q\u001a\u0004\u0018\u00010n2\u0006\u0010p\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bq\u0010'J#\u0010t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010s0\\0b2\u0006\u0010r\u001a\u00020\u000f¢\u0006\u0004\bt\u0010dJ!\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020s0u2\u0006\u0010r\u001a\u00020\u000f¢\u0006\u0004\bv\u0010wJ\u0018\u0010y\u001a\u00020\b2\u0006\u0010x\u001a\u00020)H\u0086@¢\u0006\u0004\by\u00103J\u0018\u0010z\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bz\u0010'Jc\u0010\u007f\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000f2\u000e\b\u0002\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\\2\u0006\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010#\u001a\u00020\u00122\u000e\b\u0002\u0010~\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\b\u007f\u0010\u0080\u0001Js\u0010\u0083\u0001\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000f2\u000e\b\u0002\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\\2\u0006\u0010\u001c\u001a\u00020\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010#\u001a\u00020\u00122\u000f\b\u0002\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\2\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J;\u0010\u0089\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u000e2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J@\u0010\u008c\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\\2\u0006\u0010!\u001a\u00020\u000f2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J@\u0010\u008e\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\\2\u0006\u0010!\u001a\u00020\u000f2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u008e\u0001\u0010\u008d\u0001J@\u0010\u008f\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\\2\u0006\u0010!\u001a\u00020\u000f2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u008f\u0001\u0010\u008d\u0001J@\u0010\u0090\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\\2\u0006\u0010!\u001a\u00020\u000f2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0090\u0001\u0010\u008d\u0001J0\u0010\u0093\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0092\u0001\u001a\u00030\u0091\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J0\u0010\u0097\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J0\u0010\u009b\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u009a\u0001\u001a\u00030\u0099\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J0\u0010\u009f\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000f2\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0086@¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001d\u0010¢\u0001\u001a\u0004\u0018\u00010g2\u0007\u0010¡\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b¢\u0001\u0010'J \u0010£\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010g0b2\u0007\u0010¡\u0001\u001a\u00020\u000f¢\u0006\u0005\b£\u0001\u0010dJ:\u0010§\u0001\u001a\u00020\b2\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\2\u0007\u0010¦\u0001\u001a\u00020\u001dH\u0086@¢\u0006\u0006\b§\u0001\u0010¨\u0001J9\u0010ª\u0001\u001a\u00020\b2\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\2\r\u0010h\u001a\t\u0012\u0005\u0012\u00030©\u00010\\2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@¢\u0006\u0006\bª\u0001\u0010«\u0001J \u0010¬\u0001\u001a\u00020\u00122\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\b¬\u0001\u0010_J!\u0010®\u0001\u001a\u00020\b2\r\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\b®\u0001\u0010_J#\u0010²\u0001\u001a\n\u0012\u0005\u0012\u00030±\u00010°\u00012\u0007\u0010¯\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b²\u0001\u0010'J\u001c\u0010´\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020gH\u0086@¢\u0006\u0006\b´\u0001\u0010µ\u0001J%\u0010·\u0001\u001a\u00020\b2\u0007\u0010¡\u0001\u001a\u00020\u000f2\u0007\u0010¶\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\b·\u0001\u0010¸\u0001J$\u0010¹\u0001\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000f2\u0007\u0010¶\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\b¹\u0001\u0010¸\u0001J\u001b\u0010»\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b»\u0001\u0010'J\u001a\u0010¼\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b¼\u0001\u0010'J\u001a\u0010½\u0001\u001a\u00020\b2\u0006\u0010x\u001a\u00020)H\u0086@¢\u0006\u0005\b½\u0001\u00103J\u001a\u0010¾\u0001\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b¾\u0001\u0010'J\u001a\u0010¿\u0001\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b¿\u0001\u0010'J!\u0010Á\u0001\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000f2\u0007\u0010À\u0001\u001a\u00020\u0012¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u001c\u0010Ã\u0001\u001a\u0004\u0018\u00010s2\u0006\u0010\"\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÃ\u0001\u0010'J\u001d\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00012\u0006\u0010\"\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÅ\u0001\u0010'J&\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020s0\\2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\bÆ\u0001\u0010_J,\u0010È\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0007\u0010Ç\u0001\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0086@¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u001a\u0010Ê\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÊ\u0001\u0010'J!\u0010Ì\u0001\u001a\t\u0012\u0005\u0012\u00030Ë\u00010\\2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÌ\u0001\u0010'J,\u0010Î\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0007\u0010Í\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0006\bÎ\u0001\u0010É\u0001J%\u0010Ñ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030Ð\u00010u2\u0007\u0010Ï\u0001\u001a\u00020\u000f¢\u0006\u0005\bÑ\u0001\u0010wJ!\u0010Ò\u0001\u001a\u00020\b2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\bÒ\u0001\u0010_J$\u0010Ô\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030Ó\u00010u2\u0006\u0010\"\u001a\u00020\u000f¢\u0006\u0005\bÔ\u0001\u0010wJ\u001b\u0010Ö\u0001\u001a\u00020\b2\u0007\u0010Õ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÖ\u0001\u0010'J+\u0010Ø\u0001\u001a\u00020\b2\r\u0010×\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\2\u0007\u0010Õ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u001a\u0010Ú\u0001\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÚ\u0001\u0010'J\u001c\u0010Û\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÛ\u0001\u0010'J\u001e\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0007\u0010Ü\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÞ\u0001\u0010'J5\u0010á\u0001\u001a\u00020\u00122\u0007\u0010ß\u0001\u001a\u00020\u000f2\r\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020n0\\2\b\u00105\u001a\u0004\u0018\u000104H\u0086@¢\u0006\u0006\bá\u0001\u0010â\u0001J+\u0010ä\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0\\0b2\r\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001e\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00012\u0007\u0010æ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bè\u0001\u0010'J\u001e\u0010é\u0001\u001a\u0005\u0018\u00010ç\u00012\u0007\u0010æ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bé\u0001\u0010'J&\u0010ë\u0001\u001a\u00020\u00122\u0007\u0010ê\u0001\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u000104H\u0086@¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u001a\u0010í\u0001\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bí\u0001\u0010'J\u001a\u0010î\u0001\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bî\u0001\u0010'JI\u0010ò\u0001\u001a\u00020\u00122\t\b\u0002\u0010ï\u0001\u001a\u00020\u000f2\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\t\b\u0002\u0010ð\u0001\u001a\u00020\u000f2\u0007\u0010Õ\u0001\u001a\u00020\u000f2\t\b\u0002\u0010ñ\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u001b\u0010ô\u0001\u001a\u00020\u00122\u0007\u0010Õ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bô\u0001\u0010'J7\u0010ø\u0001\u001a\u000b\u0012\u0005\u0012\u00030÷\u0001\u0018\u00010\\2\u0007\u0010Õ\u0001\u001a\u00020\u000f2\u0007\u0010õ\u0001\u001a\u00020\u000e2\u0007\u0010ö\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\bø\u0001\u0010ù\u0001J2\u0010ý\u0001\u001a\u001a\u0012\u0005\u0012\u00030û\u0001\u0018\u00010ú\u0001j\f\u0012\u0005\u0012\u00030û\u0001\u0018\u0001`ü\u00012\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bý\u0001\u0010'J4\u0010\u0080\u0002\u001a\u00020\u00122\u0007\u0010þ\u0001\u001a\u00020\u000f2\u0007\u0010Õ\u0001\u001a\u00020\u000f2\r\u0010ÿ\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0006\b\u0080\u0002\u0010\u0081\u0002J$\u0010\u0082\u0002\u001a\u00020\u00122\u0007\u0010Õ\u0001\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u0082\u0002\u0010\u0083\u0002J\u001d\u0010\u0085\u0002\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0085\u0002\u0010'J\u001b\u0010\u0086\u0002\u001a\u00020\b2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0086\u0002\u0010'J#\u0010\u0087\u0002\u001a\u00020\u00122\u0006\u00105\u001a\u0002042\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0087\u0002\u00108J\u001b\u0010\u0088\u0002\u001a\u00020\u00122\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0088\u0002\u0010'J%\u0010\u008a\u0002\u001a\u00020\u00122\u0007\u0010\u0089\u0002\u001a\u00020\u000f2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u008a\u0002\u0010\u0083\u0002J%\u0010\u008c\u0002\u001a\u00020\u00122\u0007\u0010\u008b\u0002\u001a\u00020\u000f2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u008c\u0002\u0010\u0083\u0002J)\u0010\u008d\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u008d\u0002\u0010'J)\u0010\u008e\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0007\u0010\u0084\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u008e\u0002\u0010'J%\u0010\u0090\u0002\u001a\u00020\u00122\u0007\u0010\u0084\u0002\u001a\u00020\u000f2\u0007\u0010\u008f\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u0090\u0002\u0010\u0083\u0002J,\u0010\u0093\u0002\u001a\u00030\u0092\u00022\u0007\u0010\u0084\u0002\u001a\u00020\u000f2\r\u0010\u0091\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J&\u0010\u0096\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0084\u0002\u001a\u00020\u000f2\u0007\u0010\u008f\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u0096\u0002\u0010\u0083\u0002J&\u0010\u0097\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0084\u0002\u001a\u00020\u000f2\u0007\u0010þ\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u0097\u0002\u0010\u0083\u0002J\u001a\u0010\u0098\u0002\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0098\u0002\u0010'J\u001a\u0010\u0099\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u0099\u0002\u0010'J\u001a\u0010\u009a\u0002\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u009a\u0002\u0010'J\u001c\u0010\u009b\u0002\u001a\u0004\u0018\u00010n2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u009b\u0002\u0010'J\u001b\u0010\u009d\u0002\u001a\u00020\u00122\u0007\u0010\u009c\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u009d\u0002\u0010'J\u001b\u0010\u009f\u0002\u001a\u00020\u00122\u0007\u0010\u009e\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b\u009f\u0002\u0010'J\u001c\u0010¡\u0002\u001a\u00020\u00122\u0007\u0010 \u0002\u001a\u000204H\u0086@¢\u0006\u0006\b¡\u0002\u0010¢\u0002J\u0012\u0010£\u0002\u001a\u00020\u0012H\u0086@¢\u0006\u0005\b£\u0002\u0010\u0019J\u001c\u0010¦\u0002\u001a\u00030¥\u00022\u0007\u0010¤\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b¦\u0002\u0010'J\u001a\u0010©\u0002\u001a\u00020\b2\b\u0010¨\u0002\u001a\u00030§\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u0014\u0010«\u0002\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0005\b«\u0002\u0010\u0019J)\u0010¯\u0002\u001a\u0004\u0018\u00010\u00122\b\u0010\u00ad\u0002\u001a\u00030¬\u00022\b\u0010®\u0002\u001a\u00030¬\u0002H\u0086@¢\u0006\u0006\b¯\u0002\u0010°\u0002J\u0014\u0010±\u0002\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0005\b±\u0002\u0010\u0019J.\u0010³\u0002\u001a\u000b\u0012\u0005\u0012\u00030²\u0002\u0018\u00010\\2\u0007\u0010õ\u0001\u001a\u00020\u000e2\u0007\u0010ö\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\b³\u0002\u0010´\u0002J)\u0010µ\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\r2\b\u00105\u001a\u0004\u0018\u000104H\u0086@¢\u0006\u0006\bµ\u0002\u0010¢\u0002J'\u0010·\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010¶\u0002H\u0086@¢\u0006\u0005\b·\u0002\u0010\u0019J.\u0010»\u0002\u001a\u00020\b2\u0007\u0010¸\u0002\u001a\u00020\u000f2\u0007\u0010¹\u0002\u001a\u00020\u000f2\u0007\u0010º\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b»\u0002\u0010É\u0001J3\u0010¼\u0002\u001a#\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\\\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\\\u0018\u00010¶\u0002H\u0086@¢\u0006\u0005\b¼\u0002\u0010\u0019J\u001d\u0010½\u0002\u001a\u0004\u0018\u00010\u00122\u0007\u0010Í\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0005\b½\u0002\u0010'J#\u0010¿\u0002\u001a\u0004\u0018\u00010\u00122\r\u0010¾\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0\\H\u0086@¢\u0006\u0005\b¿\u0002\u0010_J\u0012\u0010À\u0002\u001a\u00020\bH\u0086@¢\u0006\u0005\bÀ\u0002\u0010\u0019J6\u0010Â\u0002\u001a\u000b\u0012\u0005\u0012\u00030Á\u0002\u0018\u00010\\2\u0006\u00109\u001a\u00020\u000f2\u0007\u0010õ\u0001\u001a\u00020\u000e2\u0007\u0010ö\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\bÂ\u0002\u0010ù\u0001J6\u0010Ã\u0002\u001a\u000b\u0012\u0005\u0012\u00030Á\u0002\u0018\u00010\\2\u0006\u00109\u001a\u00020\u000f2\u0007\u0010õ\u0001\u001a\u00020\u000e2\u0007\u0010ö\u0001\u001a\u00020\u000eH\u0086@¢\u0006\u0006\bÃ\u0002\u0010ù\u0001J\u001c\u0010Ä\u0002\u001a\u0004\u0018\u00010\u00122\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÄ\u0002\u0010'J\u001c\u0010Å\u0002\u001a\u0004\u0018\u00010\u00122\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÅ\u0002\u0010'J\u001d\u0010Ç\u0002\u001a\u0005\u0018\u00010Æ\u00022\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÇ\u0002\u0010'J#\u0010È\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020g0u2\u0006\u00109\u001a\u00020\u000f¢\u0006\u0005\bÈ\u0002\u0010wJ#\u0010É\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020g0u2\u0006\u00109\u001a\u00020\u000f¢\u0006\u0005\bÉ\u0002\u0010wJ#\u0010Ê\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020g0u2\u0006\u00109\u001a\u00020\u000f¢\u0006\u0005\bÊ\u0002\u0010wJS\u0010Ï\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000f2\t\b\u0002\u0010Ë\u0002\u001a\u00020\u00122\r\u0010Ì\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Í\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Î\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@¢\u0006\u0006\bÏ\u0002\u0010Ð\u0002JS\u0010Ñ\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000f2\t\b\u0002\u0010Ë\u0002\u001a\u00020\u00122\r\u0010Ì\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Í\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Î\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@¢\u0006\u0006\bÑ\u0002\u0010Ð\u0002JH\u0010Ò\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000f2\r\u0010Ì\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Í\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\r\u0010Î\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@¢\u0006\u0006\bÒ\u0002\u0010Ó\u0002J\u001a\u0010Ô\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bÔ\u0002\u0010'J\u0016\u0010Ö\u0002\u001a\t\u0012\u0005\u0012\u00030Õ\u00020;¢\u0006\u0005\bÖ\u0002\u0010>J\u001a\u0010Ø\u0002\u001a\u00020\b2\b\u0010×\u0002\u001a\u00030Õ\u0002¢\u0006\u0006\bØ\u0002\u0010Ù\u0002J\u0019\u0010Ú\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010K¢\u0006\u0005\bÚ\u0002\u0010MJ\u0013\u0010Ü\u0002\u001a\u0005\u0018\u00010Û\u0002¢\u0006\u0006\bÜ\u0002\u0010Ý\u0002J\u0017\u0010Þ\u0002\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000f¢\u0006\u0005\bÞ\u0002\u0010JJ\u0016\u0010ß\u0002\u001a\b\u0012\u0004\u0012\u00020\u00120b¢\u0006\u0006\bß\u0002\u0010à\u0002J\u001d\u0010â\u0002\u001a\u0004\u0018\u00010n2\u0007\u0010á\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0005\bâ\u0002\u0010'R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010ã\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\u000f\n\u0005\b\u0006\u0010ä\u0002\u001a\u0006\bå\u0002\u0010æ\u0002R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\u000f\n\u0005\b\t\u0010ç\u0002\u001a\u0006\bè\u0002\u0010é\u0002R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\u000f\n\u0005\b\u000b\u0010ç\u0002\u001a\u0006\bê\u0002\u0010é\u0002R<\u0010\u0010\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\u000f\n\u0005\b\u0010\u0010ç\u0002\u001a\u0006\bë\u0002\u0010é\u0002R0\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006¢\u0006\u000f\n\u0005\b\u0011\u0010ç\u0002\u001a\u0006\bì\u0002\u0010é\u0002R\u0018\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\r\n\u0005\b\u0013\u0010í\u0002\u001a\u0004\b\u0013\u0010RR!\u0010î\u0002\u001a\b\u0012\u0004\u0012\u00020\u00120;8\u0006¢\u0006\u000f\n\u0006\bî\u0002\u0010ï\u0002\u001a\u0005\bð\u0002\u0010>R\u0018\u0010ò\u0002\u001a\u00030ñ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bò\u0002\u0010ó\u0002R\u0018\u0010õ\u0002\u001a\u00030ô\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0002\u0010ö\u0002R\u0018\u0010ø\u0002\u001a\u00030÷\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0002\u0010ù\u0002R\u0018\u0010û\u0002\u001a\u00030ú\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bû\u0002\u0010ü\u0002R\u0018\u0010þ\u0002\u001a\u00030ý\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bþ\u0002\u0010ÿ\u0002R\u0018\u0010\u0081\u0003\u001a\u00030\u0080\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0003\u0010\u0082\u0003R\u0018\u0010\u0084\u0003\u001a\u00030\u0083\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0003\u0010\u0085\u0003R\u0018\u0010\u0087\u0003\u001a\u00030\u0086\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0003\u0010\u0088\u0003R\u0018\u0010\u008a\u0003\u001a\u00030\u0089\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0003\u0010\u008b\u0003R\u0018\u0010\u008d\u0003\u001a\u00030\u008c\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0003\u0010\u008e\u0003R\u0018\u0010\u0090\u0003\u001a\u00030\u008f\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0003\u0010\u0091\u0003R\u0018\u0010\u0093\u0003\u001a\u00030\u0092\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0003\u0010\u0094\u0003R\u0018\u0010\u0096\u0003\u001a\u00030\u0095\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0003\u0010\u0097\u0003R\u0018\u0010\u0099\u0003\u001a\u00030\u0098\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0003\u0010\u009a\u0003R\u0018\u0010\u009c\u0003\u001a\u00030\u009b\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0003\u0010\u009d\u0003R\u0018\u0010\u009f\u0003\u001a\u00030\u009e\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0003\u0010 \u0003R\u0018\u0010¢\u0003\u001a\u00030¡\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0003\u0010£\u0003R\u001d\u0010¤\u0003\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0003\u0010ï\u0002R\u001a\u0010¦\u0003\u001a\u00030¥\u00038\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¦\u0003\u0010§\u0003R\u0018\u0010©\u0003\u001a\u00030¨\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0003\u0010ª\u0003R\u001c\u0010¬\u0003\u001a\u0005\u0018\u00010«\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0003\u0010\u00ad\u0003R\u001d\u0010¯\u0003\u001a\u00030®\u00038\u0006¢\u0006\u0010\n\u0006\b¯\u0003\u0010°\u0003\u001a\u0006\b±\u0003\u0010²\u0003R\u001d\u0010´\u0003\u001a\u00030³\u00038\u0006¢\u0006\u0010\n\u0006\b´\u0003\u0010µ\u0003\u001a\u0006\b¶\u0003\u0010·\u0003R\u001d\u0010¹\u0003\u001a\u00030¸\u00038\u0006¢\u0006\u0010\n\u0006\b¹\u0003\u0010º\u0003\u001a\u0006\b»\u0003\u0010¼\u0003R\u001b\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bA\u0010½\u0003R!\u0010¾\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0?8\u0006¢\u0006\u000f\n\u0006\b¾\u0003\u0010½\u0003\u001a\u0005\b¿\u0003\u0010B¨\u0006Á\u0003"}, d2 = {"Lcu/todus/android/repositories/MainRepository;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function1;", "Lua/k0;", "updateOwner", "Lcu/todus/android/exceptions/ToDusException;", "setError", "Lab/e;", "Lkotlin/Pair;", "", "", "newTokenLive", "retryRegister", "", "isFirstTime", "<init>", "(Landroid/content/Context;Llb/a;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "restartActivity", "()V", "loadBlocksInDB", "(Lab/e;)Ljava/lang/Object;", "initFirebase", "initShortcut", "roomId", "", "actualDate", "insertDateMsg", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "content", Room.COLUMN_LAST_MSG, "removeForAll", "transformToEditedOrDeleted", "(Ljava/lang/String;Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "setLinkInfo", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "replyMsg", "Lcu/todus/android/data/db/entity/toDus/Message;", "message", "setReply", "(Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Message;Lab/e;)Ljava/lang/Object;", "messageId", "transformToDelete", "Lcu/todus/android/data/db/pojo/MessageWithAttachments;", "transformToEdited", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/MessageWithAttachments;Lab/e;)Ljava/lang/Object;", "updateLastMessage", "(Lcu/todus/android/data/db/entity/toDus/Message;Lab/e;)Ljava/lang/Object;", "Landroid/net/Uri;", "imageUri", "channelId", "updateChannelImage", "(Landroid/net/Uri;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "uid", "getAndUpdateToDusId", "Lte/b0;", "Lcu/todus/android/xmpp/ConnectionState;", "connState", "()Lte/b0;", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lcu/todus/android/webrtc/CallState;", "requestingCalls", "()Lcu/z17/views/utils/Z17MutableListFlow;", "askForNewToken", "initializeXMPP", "(ZLab/e;)Ljava/lang/Object;", "getAuthToken", "()Lkotlin/Pair;", "it", "savePushToken", "(Ljava/lang/String;)V", "Lte/p0;", "mXMPPDataSourceDataState", "()Lte/p0;", "hasContactsPermission", "initRosterLoad", "(Z)Lua/k0;", "isConnected", "()Z", "Lcu/todus/android/xmpp/iq/version/GetUpdateInfoIQ;", "requestUpdateInfo", "forceReconnect", "disconnect", "leaveGroup", "roomLinkId", "isChannel", "getRoomInfoByLinkId", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "", "arr", "clearHistoryFromRooms", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/Room;", "getRoomById", "Lte/h;", "getRoomByIdFlow", "(Ljava/lang/String;)Lte/h;", "Lcu/todus/android/data/db/pojo/Partner;", "getPartnerByIdFlow", "Lcu/todus/android/data/db/entity/toDus/Attachment;", Service.Endpoint.LINKED_DEVICES_LIST, "upsertAttachments", "sendOnline", "sendAppClose", "tryResendMsg", "numbers", "Lcu/todus/android/data/db/entity/toDus/User;", "getUserInfoByNumber", "userId", "getUserInDBById", "id", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "getMsgsByRoomId", "Landroidx/paging/PagingSource;", "getMsgsByRoomIdForPaging", "(Ljava/lang/String;)Landroidx/paging/PagingSource;", "msg", "saveMsg", "createRoomIfNeed", "Lcu/todus/android/data/db/pojo/messageentity/MessageEntity;", "entities", "msgIdForEdit", "messageListToTransform", "sendMessage", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Lab/e;)Ljava/lang/Object;", "messageList", "msgPubIdForEdit", "sendMessageToChannel", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Ljava/io/File;", ExtensionFile.ELEMENT, TypedValues.TransitionType.S_DURATION, "replyId", "sendVoice", "(Ljava/lang/String;Ljava/io/File;ILjava/lang/String;Lab/e;)Ljava/lang/Object;", "files", "sendImages", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "sendFiles", "sendVideos", "sendAudios", "Lcu/todus/android/data/db/pojo/content/ContactContent;", "contactContent", "sendContact", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/ContactContent;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/pojo/content/LocationContent;", "locationContent", "sendLocation", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/LocationContent;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/pojo/content/EventContent;", "eventContent", "sendEvent", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/EventContent;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "sticker", "sendSticker", "(Ljava/lang/String;Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Sticker;Lab/e;)Ljava/lang/Object;", "attachmentId", "getAttachmentById", "getAttachmentByIdFlow", "roomIds", "msgIds", "time", "sendForward", "(Ljava/util/List;Ljava/util/List;JLab/e;)Ljava/lang/Object;", "Lcu/todus/android/domain/handlers/Send;", "sendFromIntent", "(Ljava/util/List;Ljava/util/List;Landroid/content/Context;Lab/e;)Ljava/lang/Object;", "allSentMsgsAreMine", Message.TABLE_NAME, "deleteMessages", "url", "Lcu/todus/android/data/wrapper/DataWrapper;", "Lcu/todus/android/data/db/pojo/content/LinkEntity;", "getLinkInfo", "attachment", "updateAttachment", "(Lcu/todus/android/data/db/entity/toDus/Attachment;Lab/e;)Ljava/lang/Object;", "state", "updateAttachmentState", "(Ljava/lang/String;ILab/e;)Ljava/lang/Object;", "updateMsgStatus", StreamManagement.Resume.ELEMENT, "getUrl", "displayAllMessages", "displaySingleMsgRead", "getFirstUnreadPosition", "getLast", "b", "sendTyping", "(Ljava/lang/String;Z)V", "getMsgById", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithRoomWithReactions;", "getFullMsgDataById", "getMsgsByIdIn", "shortMsg", "pinMsgInGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "unPinMsgInGroup", "Lcu/todus/android/data/db/pojo/RoomMember;", "getGroupMentionableMembers", AppMeasurementSdk.ConditionalUserProperty.VALUE, "reactToMsg", "entityId", "Lcu/todus/android/data/db/pojo/ReactionWithPartner;", "getReactionsByEntityId", "shareMsgs", "Lcu/todus/android/data/db/pojo/MarkerWithPartner;", "getMarkersFromMsg", "chId", "requestChannelMessages", "pubIds", "reloadChannelMsgs", "(Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "changeBlockState", "unBlockUser", "friendId", "Lcu/todus/android/data/db/pojo/Friend;", "getFriendById", "groupName", "members", "createGroup", "(Ljava/lang/String;Ljava/util/List;Landroid/net/Uri;Lab/e;)Ljava/lang/Object;", "ids", "getAttachmentsFlow", "(Ljava/util/List;)Lte/h;", "linkId", "Lcu/todus/android/data/xmpp/JoinResult;", "joinGroup", "joinChannel", "channelName", "createChannel", "(Ljava/lang/String;Landroid/net/Uri;Lab/e;)Ljava/lang/Object;", "reloadChannel", "leaveChannel", "name", "subject", "isDeletingImage", "updateChannelInfo", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "createChannelLink", DataLayout.ELEMENT, "pageSize", "Lcu/todus/android/data/db/pojo/ChannelSubscriber;", "getSubscribersPage", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lcu/todus/android/data/xmpp/ChannelAdmin;", "Lkotlin/collections/ArrayList;", "getChannelAdmins", "adminId", "newRights", "updateAdminRights", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "expelSubscriber", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "groupId", "callUpdateMucMemberList", "reloadGroup", "updateGroupImage", "removeGroupImage", "newName", "updateGroupName", "newInfo", "updateGroupInfo", "createGroupLink", "getOrCreateGroupLink", "memberId", "expelMember", "memberIds", "Lcu/todus/android/data/xmpp/AddMembersToGroupResponse;", "addNewMembers", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/AdminGroupActionsResponse;", "promoteToAdmin", "demoteFromAdmin", "subscribeCard", "reloadCard", "unsubscribeCard", "reloadUser", "newAlias", "updateAlias", "newBio", "updateBio", "uri", "updateProfileImage", "(Landroid/net/Uri;Lab/e;)Ljava/lang/Object;", "removeProfileImage", "newToDusId", "Lcu/todus/android/data/xmpp/EditToDusIdResponse;", "editToDusId", "Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;", "insideNotificationState", "addNewNotification", "(Lcu/todus/android/uiCompose/shared/insideNotification/InsideNotificationState;)V", "getNearStatus", "", "latitude", "longitude", "setLocation", "(DDLab/e;)Ljava/lang/Object;", "hideNearLocation", "Lcu/todus/android/data/db/pojo/NearPartner;", "getNearPage", "(IILab/e;)Ljava/lang/Object;", "uploadProductImage", "Lua/y;", "getProfilePrivacy", "newPrivacyOfProfileInfo", "newPrivacyOfLast", "newPrivacyOfProfilePhoto", "updateProfilePrivacy", "getPrivacyOfAdd", "updatePrivacyOfAdd", "excludes", "updatePrivacyOfAddExcludes", "retryUnsentStatuses", "Lcu/todus/android/data/db/pojo/FollowPartner;", "getFollowerPage", "getFollowingPage", "follow", "unFollow", "Lcu/todus/android/data/xmpp/FollowState;", "followState", "getImagesAttachmentsByRoomId", "getVideosAttachmentsByRoomId", "getLinksAttachmentsByRoomId", "isVideoCall", "onStarted", "onBusy", "onError", "startCallProcess", "(Ljava/lang/String;ZLlb/a;Llb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "startCallProcessNew", "acceptCallProcess", "(Ljava/lang/String;Llb/a;Llb/a;Llb/a;Lab/e;)Ljava/lang/Object;", "rejectCallProcess", "Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;", "ownerCallMediaState", "newCallMediaState", "changeOwnerCallMediaState", "(Lcu/todus/android/uiCompose/call/screen/call/CallMediaState;)V", "currentCallState", "Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "sessionManager", "()Lcu/todus/android/webrtc/sessions/WebRtcSessionManagerImpl;", "endCall", "getIsRinging", "()Lte/h;", User.COLUMN_TODUS_ID, "getUserOrReload", "Landroid/content/Context;", "Llb/a;", "getOwner", "()Llb/a;", "Lkotlin/jvm/functions/Function1;", "getUpdateOwner", "()Lkotlin/jvm/functions/Function1;", "getSetError", "getNewTokenLive", "getRetryRegister", "Z", "unableToSend", "Lte/b0;", "getUnableToSend", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lcu/todus/android/notification/NotificationManager;", "Lcu/todus/android/di/MainModule;", "mainModule", "Lcu/todus/android/di/MainModule;", "Lcu/todus/android/di/MediaModule;", "mediaModule", "Lcu/todus/android/di/MediaModule;", "Lcu/todus/android/di/PreferencesModule;", "preferences", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/volatileState/AppVolatileState;", "appVolatileState", "Lcu/todus/android/volatileState/AppVolatileState;", "Lcu/todus/android/db/ToDusDatabase;", "toDusDatabase", "Lcu/todus/android/db/ToDusDatabase;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "Lcu/todus/android/db/dao/toDus/StickerDao;", "stickerDao", "Lcu/todus/android/db/dao/toDus/StickerDao;", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "markerActionDao", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "Lcu/todus/android/rest/auth/AuthDataSource;", "authDataSource", "Lcu/todus/android/rest/auth/AuthDataSource;", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "certifiedInfoDataSource", "Lcu/todus/android/rest/certified/CertifiedInfoDataSource;", "connectionState", "Lcu/todus/android/firebase/FirebaseDataSource;", "firebaseDataSource", "Lcu/todus/android/firebase/FirebaseDataSource;", "Lpe/m0;", "coroutineScope", "Lpe/m0;", "Lcu/todus/android/xmpp/XMPPDataSource;", "mXMPPDataSource", "Lcu/todus/android/xmpp/XMPPDataSource;", "Lcu/todus/android/s3/download/DownloadDataSource;", "downloadDataSource", "Lcu/todus/android/s3/download/DownloadDataSource;", "getDownloadDataSource", "()Lcu/todus/android/s3/download/DownloadDataSource;", "Lcu/todus/android/s3/upload/UploadDataSource;", "uploadDataSource", "Lcu/todus/android/s3/upload/UploadDataSource;", "getUploadDataSource", "()Lcu/todus/android/s3/upload/UploadDataSource;", "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "uploadStatusDataSource", "Lcu/todus/android/s3/upload/UploadStatusDataSource;", "getUploadStatusDataSource", "()Lcu/todus/android/s3/upload/UploadStatusDataSource;", "Lcu/z17/views/utils/Z17MutableListFlow;", "channelsInLoad", "getChannelsInLoad", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainRepository {
    private final AppVolatileState appVolatileState;
    private final AttachmentDao attachmentDao;
    private final AuthDataSource authDataSource;
    private final CertifiedInfoDataSource certifiedInfoDataSource;
    private final Z17MutableListFlow<String> channelsInLoad;
    private final te.b0 connectionState;
    private final Context context;
    private final pe.m0 coroutineScope;
    private final DownloadDataSource downloadDataSource;
    private FirebaseDataSource firebaseDataSource;
    private final boolean isFirstTime;
    private XMPPDataSource mXMPPDataSource;
    private final MainModule mainModule;
    private final MarkerActionDao markerActionDao;
    private final MediaModule mediaModule;
    private final MessageDao messageDao;
    private final Function1 newTokenLive;
    private final NotificationManager notificationManager;
    private final lb.a owner;
    private final PreferencesModule preferences;
    private final ReactionDao reactionDao;
    private final Z17MutableListFlow<CallState> requestingCalls;
    private final Function1 retryRegister;
    private final RoomDao roomDao;
    private final Function1 setError;
    private final StatusDao statusDao;
    private final StickerDao stickerDao;
    private final ToDusDatabase toDusDatabase;
    private final te.b0 unableToSend;
    private final Function1 updateOwner;
    private final UploadDataSource uploadDataSource;
    private final UploadStatusDataSource uploadStatusDataSource;
    private final UserDao userDao;
    private final UserRoomJoinDao userRoomJoinDao;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$2", f = "MainRepository.kt", l = {228}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function1 {
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MainRepository.this.new AnonymousClass2(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass2) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository mainRepository = MainRepository.this;
                this.label = 1;
                if (mainRepository.loadBlocksInDB(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcu/todus/android/repositories/MainRepository$Companion;", "Lcu/z17/singledi/SingletonInitializer;", "Lcu/todus/android/repositories/MainRepository;", "<init>", "()V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion extends SingletonInitializer<MainRepository> {
        public /* synthetic */ Companion(kotlin.jvm.internal.p pVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$addNewMembers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2257}, m = "addNewMembers", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10311 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10311(ab.e<? super C10311> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.addNewMembers(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$allSentMsgsAreMine$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1461, 1465}, m = "allSentMsgsAreMine", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10321 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10321(ab.e<? super C10321> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.allSentMsgsAreMine(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$changeBlockState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1777, 1780, 1782}, m = "changeBlockState", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10331 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10331(ab.e<? super C10331> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.changeBlockState(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$clearHistoryFromRooms$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {368, 370}, m = "clearHistoryFromRooms", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10341 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C10341(ab.e<? super C10341> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.clearHistoryFromRooms(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$createChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1828, 1832, 1839}, m = "createChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10351 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10351(ab.e<? super C10351> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.createChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$createChannelLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1996, 1999, 2009}, m = "createChannelLink", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10361 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10361(ab.e<? super C10361> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.createChannelLink(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$createGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1801, 1809}, m = "createGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10371 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10371(ab.e<? super C10371> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.createGroup(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$createGroupLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2196, 2197, 2199}, m = "createGroupLink", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10381 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10381(ab.e<? super C10381> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.createGroupLink(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$createRoomIfNeed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {479, 484, XMPPTCPConnection.PacketWriter.QUEUE_SIZE}, m = "createRoomIfNeed", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10391 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10391(ab.e<? super C10391> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.createRoomIfNeed(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$deleteMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1505, 1532}, m = "deleteMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10401 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10401(ab.e<? super C10401> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.deleteMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$deleteMessages$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$deleteMessages$3", f = "MainRepository.kt", l = {1537, 1538, 1543, 1547, 1549, 1557, 1559, 1562, 1565}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function1 {
        final /* synthetic */ Set<String> $affectedRooms;
        final /* synthetic */ List<MessageWithAttachments> $msgsToDelete;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(List<MessageWithAttachments> list, Set<String> set, MainRepository mainRepository, ab.e<? super AnonymousClass3> eVar) {
            super(1, eVar);
            this.$msgsToDelete = list;
            this.$affectedRooms = set;
            this.this$0 = mainRepository;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new AnonymousClass3(this.$msgsToDelete, this.$affectedRooms, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass3) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0126  */
        /* JADX WARN: Code duplicated, block: B:21:0x013b  */
        /* JADX WARN: Code duplicated, block: B:27:0x0150  */
        /* JADX WARN: Code duplicated, block: B:30:0x0180  */
        /* JADX WARN: Code duplicated, block: B:34:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:85:0x014b A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0282 -> B:54:0x0284). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 958
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$demoteFromAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2271}, m = "demoteFromAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10411 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10411(ab.e<? super C10411> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.demoteFromAdmin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$displayAllMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1602, 1605, 1607}, m = "displayAllMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10421 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10421(ab.e<? super C10421> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.displayAllMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$displaySingleMsgRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1614, 1616}, m = "displaySingleMsgRead", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10431 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10431(ab.e<? super C10431> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.displaySingleMsgRead(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$editToDusId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2403}, m = "editToDusId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10441 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10441(ab.e<? super C10441> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.editToDusId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$expelMember$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2244, 2247}, m = "expelMember", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10451 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10451(ab.e<? super C10451> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.expelMember(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$expelSubscriber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2063}, m = "expelSubscriber", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10461 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10461(ab.e<? super C10461> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.expelSubscriber(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$forceReconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$forceReconnect$1", f = "MainRepository.kt", l = {328}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10471 extends cb.m implements Function1 {
        int label;

        public C10471(ab.e<? super C10471> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MainRepository.this.new C10471(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10471) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                MainRepository.this.getUnableToSend().setValue(cb.b.a(false));
                XMPPDataSource xMPPDataSource = MainRepository.this.mXMPPDataSource;
                if (xMPPDataSource != null) {
                    this.label = 1;
                    if (xMPPDataSource.reset(this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getAndUpdateToDusId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2379, 2387, 2388}, m = "getAndUpdateToDusId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10481 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10481(ab.e<? super C10481> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getAndUpdateToDusId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getAttachmentByIdFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getAttachmentByIdFlow$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10491 extends cb.m implements Function3 {
        int label;

        public C10491(ab.e<? super C10491> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10491(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getAttachmentsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getAttachmentsFlow$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lte/i;", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10501 extends cb.m implements Function3 {
        int label;

        public C10501(ab.e<? super C10501> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10501(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getIsRinging$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getIsRinging$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/Message;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10511 extends cb.m implements Function3 {
        int label;

        public C10511(ab.e<? super C10511> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10511(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getLast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1625}, m = "getLast", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10521 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10521(ab.e<? super C10521> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getLast(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getMsgsByRoomId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getMsgsByRoomId$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lte/i;", "", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10531 extends cb.m implements Function3 {
        int label;

        public C10531(ab.e<? super C10531> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10531(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getOrCreateGroupLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2212, 2219, 2224, 2228}, m = "getOrCreateGroupLink", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10541 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10541(ab.e<? super C10541> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getOrCreateGroupLink(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getPartnerByIdFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getPartnerByIdFlow$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/pojo/Partner;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10551 extends cb.m implements Function3 {
        int label;

        public C10551(ab.e<? super C10551> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10551(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getPrivacyOfAdd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2505, 2510, 2515, 2522, 2529}, m = "getPrivacyOfAdd", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10561 extends cb.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public C10561(ab.e<? super C10561> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getPrivacyOfAdd(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getRoomByIdFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$getRoomByIdFlow$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lte/i;", "Lcu/todus/android/data/db/entity/toDus/Room;", "", "it", "Lua/k0;", "<anonymous>", "(Lte/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C10571 extends cb.m implements Function3 {
        int label;

        public C10571(ab.e<? super C10571> eVar) {
            super(3, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            bb.b.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            return ua.k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(te.i iVar, Throwable th2, ab.e<? super ua.k0> eVar) {
            return new C10571(eVar).invokeSuspend(ua.k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1596}, m = "getUrl", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10581 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10581(ab.e<? super C10581> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getUrl(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getUserInfoByNumber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {440, 445, 448}, m = "getUserInfoByNumber", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10591 extends cb.d {
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

        public C10591(ab.e<? super C10591> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getUserInfoByNumber(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getUserOrReload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2713, 2717}, m = "getUserOrReload", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10601 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10601(ab.e<? super C10601> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.getUserOrReload(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$initFirebase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {285}, m = "initFirebase", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10611 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C10611(ab.e<? super C10611> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.initFirebase(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$initShortcut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {294}, m = "initShortcut", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10621 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C10621(ab.e<? super C10621> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.initShortcut(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$initializeXMPP$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {249, 252}, m = "initializeXMPP", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10631 extends cb.d {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10631(ab.e<? super C10631> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.initializeXMPP(false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$initializeXMPP$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class C10642 extends kotlin.jvm.internal.v implements lb.a {
        public C10642(Object obj) {
            super(0, obj, MainRepository.class, "restartActivity", "restartActivity()V", 0);
        }

        @Override // lb.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m9800invoke();
            return ua.k0.f43947a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m9800invoke() {
            ((MainRepository) this.receiver).restartActivity();
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$insertDateMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {387, 391, 406}, m = "insertDateMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10651 extends cb.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10651(ab.e<? super C10651> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.insertDateMsg(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$leaveChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1926, 1929, 1931}, m = "leaveChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10661 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10661(ab.e<? super C10661> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.leaveChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$leaveGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {339, 342}, m = "leaveGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10671 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10671(ab.e<? super C10671> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.leaveGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$pinMsgInGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1644}, m = "pinMsgInGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10691 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10691(ab.e<? super C10691> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.pinMsgInGroup(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$promoteToAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2264}, m = "promoteToAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10701 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10701(ab.e<? super C10701> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.promoteToAdmin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$reloadCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2305, 2307, 2310, 2326}, m = "reloadCard", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10711 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10711(ab.e<? super C10711> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.reloadCard(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$reloadChannelMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1770}, m = "reloadChannelMsgs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10721 extends cb.d {
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

        public C10721(ab.e<? super C10721> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.reloadChannelMsgs(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$reloadUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2359}, m = "reloadUser", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10731 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10731(ab.e<? super C10731> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.reloadUser(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$removeGroupImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2167, 2173}, m = "removeGroupImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10741 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10741(ab.e<? super C10741> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.removeGroupImage(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$removeProfileImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2376}, m = "removeProfileImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10751 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C10751(ab.e<? super C10751> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.removeProfileImage(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$requestChannelMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1755, 1758, 1760}, m = "requestChannelMessages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10761 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10761(ab.e<? super C10761> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.requestChannelMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$restartActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$restartActivity$1", f = "MainRepository.kt", l = {235}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10771 extends cb.m implements Function1 {
        int label;

        /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$restartActivity$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.repositories.MainRepository$restartActivity$1$1", f = "MainRepository.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02051 extends cb.m implements Function2 {
            int label;
            final /* synthetic */ MainRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02051(MainRepository mainRepository, ab.e<? super C02051> eVar) {
                super(2, eVar);
                this.this$0 = mainRepository;
            }

            @Override // cb.a
            public final ab.e<ua.k0> create(Object obj, ab.e<?> eVar) {
                return new C02051(this.this$0, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
                Intent launchIntentForPackage = this.this$0.context.getPackageManager().getLaunchIntentForPackage(this.this$0.context.getPackageName());
                kotlin.jvm.internal.y.f(launchIntentForPackage);
                launchIntentForPackage.addFlags(67141632);
                this.this$0.context.startActivity(launchIntentForPackage);
                return ua.k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(pe.m0 m0Var, ab.e<? super ua.k0> eVar) {
                return ((C02051) create(m0Var, eVar)).invokeSuspend(ua.k0.f43947a);
            }
        }

        public C10771(ab.e<? super C10771> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MainRepository.this.new C10771(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10771) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                Function1 newTokenLive = MainRepository.this.getNewTokenLive();
                this.label = 1;
                if (newTokenLive.invoke(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            pe.k.d(MainRepository.this.coroutineScope, d1.c(), null, new C02051(MainRepository.this, null), 2, null);
            return ua.k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$retryUnsentStatuses$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2548, 2550}, m = "retryUnsentStatuses", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10781 extends cb.d {
        int label;
        /* synthetic */ Object result;

        public C10781(ab.e<? super C10781> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.retryUnsentStatuses(this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$saveMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {465, 467}, m = "saveMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10791 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10791(ab.e<? super C10791> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.saveMsg(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendAudios$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {943, 949, 951, 958}, m = "sendAudios", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10801 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C10801(ab.e<? super C10801> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendAudios(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendAudios$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendAudios$2", f = "MainRepository.kt", l = {969, 971, 989}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10812 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ long $date;
        final /* synthetic */ String $messageId;
        final /* synthetic */ List<Pair<File, Long>> $processedAudios;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
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
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10812(String str, long j10, String str2, String str3, MainRepository mainRepository, String str4, List<? extends Pair<? extends File, Long>> list, ab.e<? super C10812> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.$content = str3;
            this.this$0 = mainRepository;
            this.$replyId = str4;
            this.$processedAudios = list;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10812(this.$messageId, this.$date, this.$roomId, this.$content, this.this$0, this.$replyId, this.$processedAudios, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10812) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:25:0x0165  */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
        
            if (r6.setReply(r7, r2, r25) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x015f, code lost:
        
            if (r10.insert(r10, r25) == r1) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x015f -> B:24:0x0162). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10812.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendContact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {AnalyticsListener.EVENT_UPSTREAM_DISCARDED, 1011, 1013}, m = "sendContact", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10821 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10821(ab.e<? super C10821> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendContact(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendContact$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendContact$2", f = "MainRepository.kt", l = {AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, AnalyticsListener.EVENT_AUDIO_TRACK_RELEASED, AnalyticsListener.EVENT_DROPPED_SEEKS_WHILE_SCRUBBING}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10832 extends cb.m implements Function1 {
        final /* synthetic */ ContactContent $contactContent;
        final /* synthetic */ long $date;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10832(String str, long j10, String str2, MainRepository mainRepository, ContactContent contactContent, String str3, ab.e<? super C10832> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.this$0 = mainRepository;
            this.$contactContent = contactContent;
            this.$replyId = str3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10832(this.$messageId, this.$date, this.$roomId, this.this$0, this.$contactContent, this.$replyId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10832) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00de, code lost:
        
            if (r15.insert(r1, r14) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 228
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10832.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1085, 1091, 1093}, m = "sendEvent", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10841 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10841(ab.e<? super C10841> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendEvent(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendEvent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendEvent$2", f = "MainRepository.kt", l = {1110, 1112, 1114}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10852 extends cb.m implements Function1 {
        final /* synthetic */ long $date;
        final /* synthetic */ EventContent $eventContent;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10852(String str, long j10, String str2, MainRepository mainRepository, EventContent eventContent, String str3, ab.e<? super C10852> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.this$0 = mainRepository;
            this.$eventContent = eventContent;
            this.$replyId = str3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10852(this.$messageId, this.$date, this.$roomId, this.this$0, this.$eventContent, this.$replyId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10852) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        
            if (r15.insert(r1, r14) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10852.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {785, 791, 793}, m = "sendFiles", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10861 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C10861(ab.e<? super C10861> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendFiles(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendFiles$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendFiles$2", f = "MainRepository.kt", l = {803, 805, 825}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10872 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ long $date;
        final /* synthetic */ List<File> $files;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10872(String str, long j10, String str2, String str3, MainRepository mainRepository, String str4, List<? extends File> list, ab.e<? super C10872> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.$content = str3;
            this.this$0 = mainRepository;
            this.$replyId = str4;
            this.$files = list;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10872(this.$messageId, this.$date, this.$roomId, this.$content, this.this$0, this.$replyId, this.$files, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10872) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:24:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:30:0x0156  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c5 -> B:8:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00cb -> B:8:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0150 -> B:29:0x0153). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10872.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendForward$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1282, 1284, 1299, 1323}, m = "sendForward", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10881 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C10881(ab.e<? super C10881> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendForward(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendFromIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1356, 1358, 1386, 1406, 1425, 1442, 1450}, m = "sendFromIntent", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10891 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C10891(ab.e<? super C10891> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendFromIntent(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendImages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 713, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 739}, m = "sendImages", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10901 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C10901(ab.e<? super C10901> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendImages(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendImages$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendImages$2", f = "MainRepository.kt", l = {748, 750, 771}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10912 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ long $date;
        final /* synthetic */ String $messageId;
        final /* synthetic */ List<ua.y> $processedAttachmentImage;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10912(String str, long j10, String str2, String str3, MainRepository mainRepository, String str4, List<? extends ua.y> list, ab.e<? super C10912> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.$content = str3;
            this.this$0 = mainRepository;
            this.$replyId = str4;
            this.$processedAttachmentImage = list;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10912(this.$messageId, this.$date, this.$roomId, this.$content, this.this$0, this.$replyId, this.$processedAttachmentImage, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10912) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:25:0x0192  */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ab, code lost:
        
            if (r6.setReply(r7, r2, r29) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x018c, code lost:
        
            if (r4.insert(r10, r29) == r1) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x018c -> B:24:0x018f). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instruction units count: 405
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10912.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1045, 1051, 1053}, m = "sendLocation", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10921 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10921(ab.e<? super C10921> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendLocation(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendLocation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendLocation$2", f = "MainRepository.kt", l = {1070, 1072, 1074}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10932 extends cb.m implements Function1 {
        final /* synthetic */ long $date;
        final /* synthetic */ LocationContent $locationContent;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10932(String str, long j10, String str2, MainRepository mainRepository, LocationContent locationContent, String str3, ab.e<? super C10932> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.this$0 = mainRepository;
            this.$locationContent = locationContent;
            this.$replyId = str3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10932(this.$messageId, this.$date, this.$roomId, this.this$0, this.$locationContent, this.$replyId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10932) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        
            if (r15.insert(r1, r14) == r0) goto L22;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10932.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {519, 523, 525}, m = "sendMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10941 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C10941(ab.e<? super C10941> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendMessage(null, null, null, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendMessage$2", f = "MainRepository.kt", l = {553, 556, 559, 563, 569}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10952 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ long $date;
        final /* synthetic */ List<MessageEntity> $entities;
        final /* synthetic */ List<String> $messageListToTransform;
        final /* synthetic */ String $msgIdForEdit;
        final /* synthetic */ boolean $removeForAll;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10952(String str, List<String> list, String str2, long j10, String str3, MainRepository mainRepository, List<? extends MessageEntity> list2, String str4, boolean z10, ab.e<? super C10952> eVar) {
            super(1, eVar);
            this.$msgIdForEdit = str;
            this.$messageListToTransform = list;
            this.$content = str2;
            this.$date = j10;
            this.$roomId = str3;
            this.this$0 = mainRepository;
            this.$entities = list2;
            this.$replyMsg = str4;
            this.$removeForAll = z10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10952(this.$msgIdForEdit, this.$messageListToTransform, this.$content, this.$date, this.$roomId, this.this$0, this.$entities, this.$replyMsg, this.$removeForAll, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<Object> eVar) {
            return ((C10952) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x0158  */
        /* JADX WARN: Code duplicated, block: B:47:0x0192  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0192 -> B:48:0x0193). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 413
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10952.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendMessageToChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {590}, m = "sendMessageToChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10961 extends cb.d {
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

        public C10961(ab.e<? super C10961> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendMessageToChannel(null, null, null, null, null, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendMessageToChannel$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendMessageToChannel$2", f = "MainRepository.kt", l = {593, 597, 599, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 613, 625, 630, 637}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10972 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ List<MessageEntity> $entities;
        final /* synthetic */ List<String> $messageList;
        final /* synthetic */ String $msgIdForEdit;
        final /* synthetic */ String $msgPubIdForEdit;
        final /* synthetic */ boolean $removeForAll;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10972(boolean z10, MainRepository mainRepository, List<String> list, String str, String str2, String str3, String str4, List<? extends MessageEntity> list2, String str5, ab.e<? super C10972> eVar) {
            super(1, eVar);
            this.$removeForAll = z10;
            this.this$0 = mainRepository;
            this.$messageList = list;
            this.$roomId = str;
            this.$msgPubIdForEdit = str2;
            this.$msgIdForEdit = str3;
            this.$content = str4;
            this.$entities = list2;
            this.$replyMsg = str5;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10972(this.$removeForAll, this.this$0, this.$messageList, this.$roomId, this.$msgPubIdForEdit, this.$msgIdForEdit, this.$content, this.$entities, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10972) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00f6 A[PHI: r0 r2 r3 r4 r6
          0x00f6: PHI (r0v21 int) = (r0v17 int), (r0v25 int) binds: [B:30:0x00f2, B:11:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r2v6 org.jivesoftware.smack.packet.IQ) = (r2v3 org.jivesoftware.smack.packet.IQ), (r2v9 org.jivesoftware.smack.packet.IQ) binds: [B:30:0x00f2, B:11:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r3v8 java.lang.String) = (r3v5 java.lang.String), (r3v11 java.lang.String) binds: [B:30:0x00f2, B:11:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r4v8 cu.todus.android.repositories.MainRepository) = (r4v5 cu.todus.android.repositories.MainRepository), (r4v11 cu.todus.android.repositories.MainRepository) binds: [B:30:0x00f2, B:11:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r6v7 java.lang.Object) = (r6v6 java.lang.Object), (r6v10 java.lang.Object) binds: [B:30:0x00f2, B:11:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:34:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:49:0x014a  */
        /* JADX WARN: Code duplicated, block: B:56:0x01b7 A[PHI: r0 r3 r4 r6
          0x01b7: PHI (r0v35 java.lang.String) = (r0v33 java.lang.String), (r0v41 java.lang.String) binds: [B:54:0x01b4, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]
          0x01b7: PHI (r3v13 cu.todus.android.data.db.entity.toDus.Message) = (r3v12 cu.todus.android.data.db.entity.toDus.Message), (r3v16 cu.todus.android.data.db.entity.toDus.Message) binds: [B:54:0x01b4, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]
          0x01b7: PHI (r4v14 cu.todus.android.data.db.pojo.MessageWithAttachments) = 
          (r4v13 cu.todus.android.data.db.pojo.MessageWithAttachments)
          (r4v17 cu.todus.android.data.db.pojo.MessageWithAttachments)
         binds: [B:54:0x01b4, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]
          0x01b7: PHI (r6v20 java.lang.Object) = (r6v19 java.lang.Object), (r6v22 java.lang.Object) binds: [B:54:0x01b4, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:58:0x01bb  */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0122, code lost:
        
            if (r4.updateLastMessage(r8, r2, r3, r24) == r9) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0202, code lost:
        
            if (r0.sendMessage(r1, r2, r3, r4, null, false, r7, r24) == r9) goto L64;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instruction units count: 542
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10972.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendSticker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1125, 1131, 1133}, m = "sendSticker", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C10981 extends cb.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10981(ab.e<? super C10981> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendSticker(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendSticker$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendSticker$2", f = "MainRepository.kt", l = {1157, 1159, 1161, 1163}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C10992 extends cb.m implements Function1 {
        final /* synthetic */ long $date;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        final /* synthetic */ Sticker $sticker;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10992(String str, long j10, String str2, MainRepository mainRepository, Sticker sticker, String str3, ab.e<? super C10992> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.this$0 = mainRepository;
            this.$sticker = sticker;
            this.$replyId = str3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C10992(this.$messageId, this.$date, this.$roomId, this.this$0, this.$sticker, this.$replyId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C10992) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0126  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x014b, code lost:
        
            if (cu.todus.android.db.dao.toDus.a7.a(r3, r5, 0, r28, 2, null) == r7) goto L28;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C10992.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendVideos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {842, 848, 881, 897}, m = "sendVideos", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11001 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C11001(ab.e<? super C11001> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendVideos(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendVideos$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendVideos$2", f = "MainRepository.kt", l = {907, 909, 928}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11012 extends cb.m implements Function1 {
        final /* synthetic */ List<ProcessedVideo> $attachmentProcessVideo;
        final /* synthetic */ String $content;
        final /* synthetic */ long $date;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11012(String str, long j10, String str2, String str3, MainRepository mainRepository, String str4, List<ProcessedVideo> list, ab.e<? super C11012> eVar) {
            super(1, eVar);
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.$content = str3;
            this.this$0 = mainRepository;
            this.$replyId = str4;
            this.$attachmentProcessVideo = list;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C11012(this.$messageId, this.$date, this.$roomId, this.$content, this.this$0, this.$replyId, this.$attachmentProcessVideo, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C11012) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:25:0x0165  */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
        
            if (r6.setReply(r7, r2, r31) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x015f, code lost:
        
            if (r4.insert(r11, r31) == r1) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x015f -> B:24:0x0162). Please report as a decompilation issue!!! */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C11012.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J@\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"cu/todus/android/repositories/MainRepository$sendVideos$ProcessedVideo", "", ExtensionFile.ELEMENT, "Ljava/io/File;", TypedValues.TransitionType.S_DURATION, "", "width", "height", "thumbnailPath", "", "<init>", "(Ljava/io/File;JJJLjava/lang/String;)V", "getFile", "()Ljava/io/File;", "getDuration", "()J", "getWidth", "getHeight", "getThumbnailPath", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/io/File;JJJLjava/lang/String;)Lcu/todus/android/repositories/MainRepository$sendVideos$ProcessedVideo;", "equals", "", "other", "hashCode", "", "toString", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ProcessedVideo {
        private final long duration;
        private final File file;
        private final long height;
        private final String thumbnailPath;
        private final long width;

        public ProcessedVideo(File file, long j10, long j11, long j12, String thumbnailPath) {
            kotlin.jvm.internal.y.i(file, "file");
            kotlin.jvm.internal.y.i(thumbnailPath, "thumbnailPath");
            this.file = file;
            this.duration = j10;
            this.width = j11;
            this.height = j12;
            this.thumbnailPath = thumbnailPath;
        }

        public static /* synthetic */ ProcessedVideo copy$default(ProcessedVideo processedVideo, File file, long j10, long j11, long j12, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                file = processedVideo.file;
            }
            if ((i10 & 2) != 0) {
                j10 = processedVideo.duration;
            }
            if ((i10 & 4) != 0) {
                j11 = processedVideo.width;
            }
            if ((i10 & 8) != 0) {
                j12 = processedVideo.height;
            }
            if ((i10 & 16) != 0) {
                str = processedVideo.thumbnailPath;
            }
            String str2 = str;
            long j13 = j12;
            return processedVideo.copy(file, j10, j11, j13, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getThumbnailPath() {
            return this.thumbnailPath;
        }

        public final ProcessedVideo copy(File file, long duration, long width, long height, String thumbnailPath) {
            kotlin.jvm.internal.y.i(file, "file");
            kotlin.jvm.internal.y.i(thumbnailPath, "thumbnailPath");
            return new ProcessedVideo(file, duration, width, height, thumbnailPath);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessedVideo)) {
                return false;
            }
            ProcessedVideo processedVideo = (ProcessedVideo) other;
            return kotlin.jvm.internal.y.d(this.file, processedVideo.file) && this.duration == processedVideo.duration && this.width == processedVideo.width && this.height == processedVideo.height && kotlin.jvm.internal.y.d(this.thumbnailPath, processedVideo.thumbnailPath);
        }

        public final long getDuration() {
            return this.duration;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getHeight() {
            return this.height;
        }

        public final String getThumbnailPath() {
            return this.thumbnailPath;
        }

        public final long getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((((this.file.hashCode() * 31) + defpackage.l.a(this.duration)) * 31) + defpackage.l.a(this.width)) * 31) + defpackage.l.a(this.height)) * 31) + this.thumbnailPath.hashCode();
        }

        public String toString() {
            return "ProcessedVideo(file=" + this.file + ", duration=" + this.duration + ", width=" + this.width + ", height=" + this.height + ", thumbnailPath=" + this.thumbnailPath + ")";
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendVoice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {656, 662, 664}, m = "sendVoice", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11021 extends cb.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11021(ab.e<? super C11021> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.sendVoice(null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$sendVoice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$sendVoice$2", f = "MainRepository.kt", l = {689, 691, 693}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11032 extends cb.m implements Function1 {
        final /* synthetic */ long $date;
        final /* synthetic */ int $duration;
        final /* synthetic */ File $file;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        final /* synthetic */ String $roomId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MainRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11032(File file, String str, long j10, String str2, MainRepository mainRepository, int i10, String str3, ab.e<? super C11032> eVar) {
            super(1, eVar);
            this.$file = file;
            this.$messageId = str;
            this.$date = j10;
            this.$roomId = str2;
            this.this$0 = mainRepository;
            this.$duration = i10;
            this.$replyId = str3;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return new C11032(this.$file, this.$messageId, this.$date, this.$roomId, this.this$0, this.$duration, this.$replyId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<Object> eVar) {
            return ((C11032) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0114, code lost:
        
            if (r5.insert(r2, r21) == r1) goto L27;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C11032.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$shareMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1684}, m = "shareMsgs", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11041 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11041(ab.e<? super C11041> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.shareMsgs(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$startCallProcessNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2642}, m = "startCallProcessNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11051 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11051(ab.e<? super C11051> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.startCallProcessNew(null, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$subscribeCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2277, 2288, 2291}, m = "subscribeCard", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11061 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11061(ab.e<? super C11061> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.subscribeCard(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$transformToEdited$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1248, 1250, 1252, 1253, 1265, 1277}, m = "transformToEdited", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11071 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11071(ab.e<? super C11071> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.transformToEdited(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$transformToEditedOrDeleted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$transformToEditedOrDeleted$2", f = "MainRepository.kt", l = {1176, 1184, 1185, 1187}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C11082 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ String $msgId;
        final /* synthetic */ boolean $removeForAll;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11082(String str, String str2, boolean z10, ab.e<? super C11082> eVar) {
            super(1, eVar);
            this.$msgId = str;
            this.$content = str2;
            this.$removeForAll = z10;
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MainRepository.this.new C11082(this.$msgId, this.$content, this.$removeForAll, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((C11082) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
        
            if (r10.transformToDelete(r11, r23) == r1) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
        
            r7 = r10;
            r6 = r9;
            r5 = r10;
            r2 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00df, code lost:
        
            if (r10.transformToEdited(r11, r8, r23) == r1) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0103, code lost:
        
            if (r4.upsert(r5, r23) == r1) goto L34;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.C11082.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$unFollow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2580, 2583}, m = "unFollow", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11091 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11091(ab.e<? super C11091> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.unFollow(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$unPinMsgInGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1654}, m = "unPinMsgInGroup", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11101 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11101(ab.e<? super C11101> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.unPinMsgInGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$unsubscribeCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2343, 2346, 2348}, m = "unsubscribeCard", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11111 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11111(ab.e<? super C11111> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.unsubscribeCard(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateAdminRights$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2042, 2048, 2054}, m = "updateAdminRights", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11121 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11121(ab.e<? super C11121> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateAdminRights(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateAlias$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2367}, m = "updateAlias", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11131 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11131(ab.e<? super C11131> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateAlias(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateBio$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2370}, m = "updateBio", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11141 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11141(ab.e<? super C11141> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateBio(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateChannelImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1863, 1865, 1872, 1880, 1892, 1900, 1908}, m = "updateChannelImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11151 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C11151(ab.e<? super C11151> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateChannelImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateChannelInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1952, 1956, 1958, 1986}, m = "updateChannelInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11161 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11161(ab.e<? super C11161> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateChannelInfo(null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateGroupImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2090, 2092, 2099, 2107, 2115, 2127, 2135, 2143, 2151}, m = "updateGroupImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11171 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C11171(ab.e<? super C11171> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateGroupImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateGroupInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2190}, m = "updateGroupInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11181 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11181(ab.e<? super C11181> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateGroupInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateGroupName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2184}, m = "updateGroupName", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11191 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11191(ab.e<? super C11191> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateGroupName(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateLastMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {1573, 1575, 1577}, m = "updateLastMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11201 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11201(ab.e<? super C11201> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateLastMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$updateProfileImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2373}, m = "updateProfileImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11211 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11211(ab.e<? super C11211> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.updateProfileImage(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$uploadProductImage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository", f = "MainRepository.kt", l = {2458, 2460, 2467, 2474}, m = "uploadProductImage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C11221 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public C11221(ab.e<? super C11221> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainRepository.this.uploadProductImage(null, this);
        }
    }

    public MainRepository(Context context, lb.a owner, Function1 updateOwner, Function1 setError, Function1 newTokenLive, Function1 retryRegister, boolean z10) {
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(updateOwner, "updateOwner");
        kotlin.jvm.internal.y.i(setError, "setError");
        kotlin.jvm.internal.y.i(newTokenLive, "newTokenLive");
        kotlin.jvm.internal.y.i(retryRegister, "retryRegister");
        this.context = context;
        this.owner = owner;
        this.updateOwner = updateOwner;
        this.setError = setError;
        this.newTokenLive = newTokenLive;
        this.retryRegister = retryRegister;
        this.isFirstTime = z10;
        this.unableToSend = te.r0.a(Boolean.FALSE);
        this.notificationManager = NotificationManager.INSTANCE.getInstance();
        this.mainModule = MainModule.INSTANCE.getInstance();
        this.mediaModule = MediaModule.INSTANCE.getInstance();
        this.preferences = PreferencesModule.INSTANCE.getInstance();
        this.appVolatileState = AppVolatileState.INSTANCE.getInstance();
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.toDusDatabase = companion.getInstance().getToDusDatabase();
        this.roomDao = companion.getInstance().getRoomDao();
        this.messageDao = companion.getInstance().getMessageDao();
        this.userDao = companion.getInstance().getUserDao();
        this.attachmentDao = companion.getInstance().getAttachmentDao();
        this.userRoomJoinDao = companion.getInstance().getUserRoomJoinDao();
        this.reactionDao = companion.getInstance().getReactionDao();
        this.stickerDao = companion.getInstance().getStickerDao();
        this.markerActionDao = companion.getInstance().getMarkerActionDao();
        this.statusDao = companion.getInstance().getStatusDao();
        RetrofitModule.Companion companion2 = RetrofitModule.INSTANCE;
        this.authDataSource = companion2.getInstance().getAuthDataSource();
        this.certifiedInfoDataSource = companion2.getInstance().getCertifiedInfoDataSource();
        this.connectionState = te.r0.a(ConnectionState.WAITING_FOR_CONNECTION);
        pe.m0 m0VarA = pe.n0.a(d1.b().plus(e2.b(null, 1, null)));
        this.coroutineScope = m0VarA;
        this.downloadDataSource = new DownloadDataSource(new MainRepository$downloadDataSource$1(this, null), new MainRepository$downloadDataSource$2(this), new MainRepository$downloadDataSource$3(this, null));
        this.uploadDataSource = new UploadDataSource(new MainRepository$uploadDataSource$1(this, null), new MainRepository$uploadDataSource$2(this), new MainRepository$uploadDataSource$3(this, null), new MainRepository$uploadDataSource$4(this));
        this.uploadStatusDataSource = new UploadStatusDataSource(new MainRepository$uploadStatusDataSource$1(this, null), new MainRepository$uploadStatusDataSource$2(this, null), new MainRepository$uploadStatusDataSource$3(this, null));
        this.requestingCalls = new Z17MutableListFlow<>(va.w.n());
        CoroutineUtilsKt.launchWithContext$default(m0VarA, null, null, new AnonymousClass1(null), 3, null);
        CoroutineUtilsKt.launchWithContext$default(m0VarA, null, null, new AnonymousClass2(null), 3, null);
        this.channelsInLoad = new Z17MutableListFlow<>(va.w.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String displayAllMessages$lambda$0$0(Message it) {
        kotlin.jvm.internal.y.i(it, "it");
        return it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:47:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x010a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0113  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object getAndUpdateToDusId(String str, ab.e<? super ua.k0> eVar) {
        C10481 c10481;
        Pair pair;
        String str2;
        RosterManager rosterManager;
        Integer num;
        Object appState;
        Pair pair2;
        PreferencesModule preferencesModule;
        AppState appStateCopy$default;
        String str3;
        Pair pair3;
        if (eVar instanceof C10481) {
            c10481 = (C10481) eVar;
            int i10 = c10481.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10481.label = i10 - Integer.MIN_VALUE;
            } else {
                c10481 = new C10481(eVar);
            }
        } else {
            c10481 = new C10481(eVar);
        }
        Object toDusId = c10481.result;
        Object objG = bb.b.g();
        int i11 = c10481.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str2 = (String) c10481.L$0;
                ua.v.b(toDusId);
            } else {
                if (i11 == 2) {
                    Pair pair4 = (Pair) c10481.L$1;
                    String str4 = (String) c10481.L$0;
                    ua.v.b(toDusId);
                    pair2 = pair4;
                    str2 = str4;
                    AppState appState2 = (AppState) toDusId;
                    preferencesModule = this.preferences;
                    appStateCopy$default = AppState.copy$default(appState2, AppStateStep.UPDATE_REQUIRED, null, null, 0, 0L, 30, null);
                    c10481.L$0 = str2;
                    c10481.L$1 = pair2;
                    c10481.L$2 = cb.l.a(appState2);
                    c10481.label = 3;
                    if (preferencesModule.setAppState(appStateCopy$default, c10481) != objG) {
                        str3 = str2;
                        pair3 = pair2;
                    }
                    return objG;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pair3 = (Pair) c10481.L$1;
                str3 = (String) c10481.L$0;
                ua.v.b(toDusId);
            }
            str2 = str3;
            pair = pair3;
            if (kotlin.jvm.internal.y.d(str2, ((Owner) this.owner.invoke()).getNameWithDomain())) {
                if ((pair != null ? (String) pair.getFirst() : null) != null) {
                    Function1 function1 = this.updateOwner;
                    Owner owner = (Owner) this.owner.invoke();
                    Object first = pair.getFirst();
                    kotlin.jvm.internal.y.f(first);
                    function1.invoke(Owner.copy$default(owner, null, null, null, 0, null, null, null, null, null, 0L, (String) first, 0, 3071, null));
                }
            }
            return ua.k0.f43947a;
        }
        ua.v.b(toDusId);
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (rosterManager = xMPPDataSource.getRosterManager()) == null) {
            pair = null;
            str2 = str;
            if (pair != null) {
                num = (Integer) pair.getSecond();
            } else {
                num = null;
            }
            if (num != null && ((Number) pair.getSecond()).intValue() != 0 && ((Number) pair.getSecond()).intValue() > 30102) {
                PreferencesModule preferencesModule2 = this.preferences;
                c10481.L$0 = str2;
                c10481.L$1 = pair;
                c10481.label = 2;
                appState = preferencesModule2.getAppState(c10481);
                if (appState != objG) {
                    pair2 = pair;
                    toDusId = appState;
                    AppState appState3 = (AppState) toDusId;
                    preferencesModule = this.preferences;
                    appStateCopy$default = AppState.copy$default(appState3, AppStateStep.UPDATE_REQUIRED, null, null, 0, 0L, 30, null);
                    c10481.L$0 = str2;
                    c10481.L$1 = pair2;
                    c10481.L$2 = cb.l.a(appState3);
                    c10481.label = 3;
                    if (preferencesModule.setAppState(appStateCopy$default, c10481) != objG) {
                        str3 = str2;
                        pair3 = pair2;
                        str2 = str3;
                        pair = pair3;
                    }
                }
            }
            if (kotlin.jvm.internal.y.d(str2, ((Owner) this.owner.invoke()).getNameWithDomain())) {
                if ((pair != null ? (String) pair.getFirst() : null) != null) {
                    Function1 function2 = this.updateOwner;
                    Owner owner2 = (Owner) this.owner.invoke();
                    Object first2 = pair.getFirst();
                    kotlin.jvm.internal.y.f(first2);
                    function2.invoke(Owner.copy$default(owner2, null, null, null, 0, null, null, null, null, null, 0L, (String) first2, 0, 3071, null));
                }
            }
            return ua.k0.f43947a;
        }
        String strO = le.a0.O(str, "@im.todus.cu", "", false, 4, null);
        c10481.L$0 = str;
        c10481.label = 1;
        toDusId = rosterManager.getToDusId(strO, c10481);
        if (toDusId != objG) {
            str2 = str;
        }
        return objG;
        pair = (Pair) toDusId;
        if (pair != null) {
            num = (Integer) pair.getSecond();
        } else {
            num = null;
        }
        if (num != null) {
            PreferencesModule preferencesModule3 = this.preferences;
            c10481.L$0 = str2;
            c10481.L$1 = pair;
            c10481.label = 2;
            appState = preferencesModule3.getAppState(c10481);
            if (appState != objG) {
                pair2 = pair;
                toDusId = appState;
                AppState appState4 = (AppState) toDusId;
                preferencesModule = this.preferences;
                appStateCopy$default = AppState.copy$default(appState4, AppStateStep.UPDATE_REQUIRED, null, null, 0, 0L, 30, null);
                c10481.L$0 = str2;
                c10481.L$1 = pair2;
                c10481.L$2 = cb.l.a(appState4);
                c10481.label = 3;
                if (preferencesModule.setAppState(appStateCopy$default, c10481) != objG) {
                    str3 = str2;
                    pair3 = pair2;
                    str2 = str3;
                    pair = pair3;
                }
            }
            return objG;
        }
        if (kotlin.jvm.internal.y.d(str2, ((Owner) this.owner.invoke()).getNameWithDomain())) {
            if ((pair != null ? (String) pair.getFirst() : null) != null) {
                Function1 function3 = this.updateOwner;
                Owner owner3 = (Owner) this.owner.invoke();
                Object first3 = pair.getFirst();
                kotlin.jvm.internal.y.f(first3);
                function3.invoke(Owner.copy$default(owner3, null, null, null, 0, null, null, null, null, null, 0L, (String) first3, 0, 3071, null));
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object initFirebase(ab.e<? super ua.k0> eVar) {
        C10611 c10611;
        XMPPDataSource xMPPDataSource;
        if (eVar instanceof C10611) {
            c10611 = (C10611) eVar;
            int i10 = c10611.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10611.label = i10 - Integer.MIN_VALUE;
            } else {
                c10611 = new C10611(eVar);
            }
        } else {
            c10611 = new C10611(eVar);
        }
        Object objX = c10611.result;
        Object objG = bb.b.g();
        int i11 = c10611.label;
        if (i11 == 0) {
            ua.v.b(objX);
            FirebaseDataSource firebaseDataSource = new FirebaseDataSource(((Owner) this.owner.invoke()).getUsername());
            this.firebaseDataSource = firebaseDataSource;
            te.h hVarSyncFBToken = firebaseDataSource.syncFBToken();
            c10611.label = 1;
            objX = te.j.x(hVarSyncFBToken, c10611);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        String str = (String) objX;
        if (str != null && (xMPPDataSource = this.mXMPPDataSource) != null) {
            xMPPDataSource.sendFirebaseToken(str);
        }
        return ua.k0.f43947a;
    }

    public static /* synthetic */ ua.k0 initRosterLoad$default(MainRepository mainRepository, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return mainRepository.initRosterLoad(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object initShortcut(ab.e<? super ua.k0> eVar) {
        C10621 c10621;
        if (eVar instanceof C10621) {
            c10621 = (C10621) eVar;
            int i10 = c10621.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10621.label = i10 - Integer.MIN_VALUE;
            } else {
                c10621 = new C10621(eVar);
            }
        } else {
            c10621 = new C10621(eVar);
        }
        Object allRoomList = c10621.result;
        Object objG = bb.b.g();
        int i11 = c10621.label;
        if (i11 == 0) {
            ua.v.b(allRoomList);
            RoomDao roomDao = this.roomDao;
            c10621.label = 1;
            allRoomList = roomDao.getAllRoomList(c10621);
            if (allRoomList == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(allRoomList);
        }
        List list = (List) allRoomList;
        this.notificationManager.updateShortcut(list.subList(0, rb.k.j(list.size(), this.notificationManager.maxShortcut())));
        return ua.k0.f43947a;
    }

    public static /* synthetic */ Object initializeXMPP$default(MainRepository mainRepository, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return mainRepository.initializeXMPP(z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d1, code lost:
    
        if (kotlin.jvm.internal.y.d(r7, r0.format(new java.util.Date(r14), r9)) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
    
        if (r0.insertOrIgnore(r11, r5) == r6) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object insertDateMsg(java.lang.String r25, long r26, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.insertDateMsg(java.lang.String, long, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadBlocksInDB(ab.e<? super ua.k0> eVar) {
        Object objCollect = this.userDao.getAllBlocked().collect(new te.i() { // from class: cu.todus.android.repositories.MainRepository.loadBlocksInDB.2
            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar2) {
                return emit((List<String>) obj, (ab.e<? super ua.k0>) eVar2);
            }

            public final Object emit(List<String> list, ab.e<? super ua.k0> eVar2) {
                MainRepository mainRepository = MainRepository.this;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    mainRepository.appVolatileState.getBlockRooms().put((String) it.next(), cb.b.a(true));
                }
                return ua.k0.f43947a;
            }
        }, eVar);
        return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestChannelMessages$lambda$0(String str, String it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(it, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartActivity() {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C10771(null), 3, null);
    }

    public static /* synthetic */ Object sendAudios$default(MainRepository mainRepository, String str, List list, String str2, String str3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        return mainRepository.sendAudios(str, list, str2, str3, eVar);
    }

    public static /* synthetic */ Object sendFiles$default(MainRepository mainRepository, String str, List list, String str2, String str3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        return mainRepository.sendFiles(str, list, str2, str3, eVar);
    }

    public static /* synthetic */ Object sendImages$default(MainRepository mainRepository, String str, List list, String str2, String str3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        return mainRepository.sendImages(str, list, str2, str3, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 sendImages$lambda$1$0(int i10, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        QualityConstraintKt.quality(compress, i10 * 30);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendMessage$default(MainRepository mainRepository, String str, List list, String str2, String str3, String str4, boolean z10, List list2, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = va.w.n();
        }
        return mainRepository.sendMessage(str, list, str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? false : z10, (i10 & 64) != 0 ? va.w.n() : list2, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendMessageToChannel$default(MainRepository mainRepository, String str, List list, String str2, String str3, String str4, boolean z10, List list2, String str5, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = va.w.n();
        }
        return mainRepository.sendMessageToChannel(str, list, str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? false : z10, (i10 & 64) != 0 ? va.w.n() : list2, (i10 & 128) != 0 ? null : str5, eVar);
    }

    public static /* synthetic */ Object sendVideos$default(MainRepository mainRepository, String str, List list, String str2, String str3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        return mainRepository.sendVideos(str, list, str2, str3, eVar);
    }

    public static /* synthetic */ Object sendVoice$default(MainRepository mainRepository, String str, File file, int i10, String str2, ab.e eVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        return mainRepository.sendVoice(str, file, i10, str2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setLinkInfo(String str, ab.e<? super ua.k0> eVar) {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objInsert = this.attachmentDao.insert(new Attachment(le.a0.O(string, "-", "", false, 4, null), str, new LinkInfoContent(false, null), 2, 20, false), eVar);
        return objInsert == bb.b.g() ? objInsert : ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setReply(String str, Message message, ab.e<? super ua.k0> eVar) {
        if (str == null || le.d0.q0(str)) {
            return ua.k0.f43947a;
        }
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objInsert = this.attachmentDao.insert(new Attachment(le.a0.O(string, "-", "", false, 4, null), message.getId(), new ReplyMsgContent(str, false, null, null, null, 0, 0L, false, false, null, null, 2046, null), 2, 9, false, 32, null), eVar);
        return objInsert == bb.b.g() ? objInsert : ua.k0.f43947a;
    }

    public static /* synthetic */ Object startCallProcess$default(MainRepository mainRepository, String str, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return mainRepository.startCallProcess(str, z10, aVar, aVar2, aVar3, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 startCallProcess$lambda$0(MainRepository mainRepository, lb.a aVar) {
        mainRepository.mediaModule.startRing();
        aVar.invoke();
        return ua.k0.f43947a;
    }

    public static /* synthetic */ Object startCallProcessNew$default(MainRepository mainRepository, String str, boolean z10, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return mainRepository.startCallProcessNew(str, z10, aVar, aVar2, aVar3, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 startCallProcessNew$lambda$0(MainRepository mainRepository, lb.a aVar) {
        mainRepository.mediaModule.startRing();
        aVar.invoke();
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformToDelete(String str, ab.e<? super ua.k0> eVar) {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        Object objInsert = this.attachmentDao.insert(new Attachment(le.a0.O(string, "-", "", false, 4, null), str, new DeletedContent(), 2, 16, true), eVar);
        return objInsert == bb.b.g() ? objInsert : ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x007e A[PHI: r1 r5 r9 r10 r11
      0x007e: PHI (r1v9 int) = (r1v7 int), (r1v10 int) binds: [B:43:0x0173, B:14:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r5v21 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r5v18 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r5v23 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:43:0x0173, B:14:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r9v15 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r9v12 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r9v18 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:43:0x0173, B:14:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r10v12 cu.todus.android.data.db.pojo.MessageWithAttachments) = 
      (r10v9 cu.todus.android.data.db.pojo.MessageWithAttachments)
      (r10v14 cu.todus.android.data.db.pojo.MessageWithAttachments)
     binds: [B:43:0x0173, B:14:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r11v9 java.lang.String) = (r11v6 java.lang.String), (r11v12 java.lang.String) binds: [B:43:0x0173, B:14:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x012b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0151  */
    /* JADX WARN: Code duplicated, block: B:46:0x0179  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d0 A[PHI: r1 r5 r9 r10 r13
      0x01d0: PHI (r1v11 int) = (r1v9 int), (r1v14 int) binds: [B:45:0x0177, B:50:0x01cd] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r5v24 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r5v21 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r5v27 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:45:0x0177, B:50:0x01cd] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r9v19 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r9v15 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r9v21 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:45:0x0177, B:50:0x01cd] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r10v15 cu.todus.android.data.db.pojo.MessageWithAttachments) = 
      (r10v12 cu.todus.android.data.db.pojo.MessageWithAttachments)
      (r10v16 cu.todus.android.data.db.pojo.MessageWithAttachments)
     binds: [B:45:0x0177, B:50:0x01cd] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r13v1 java.lang.String) = (r13v0 java.lang.String), (r13v2 java.lang.String) binds: [B:45:0x0177, B:50:0x01cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0221, code lost:
    
        if (r2.insert(r11, r3) == r4) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object transformToEdited(java.lang.String r22, cu.todus.android.data.db.pojo.MessageWithAttachments r23, ab.e<? super ua.k0> r24) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.transformToEdited(java.lang.String, cu.todus.android.data.db.pojo.MessageWithAttachments, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformToEditedOrDeleted(String str, String str2, boolean z10, ab.e<? super ua.k0> eVar) {
        return RoomDatabaseKt.withTransaction(this.toDusDatabase, new C11082(str2, str, z10, null), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:52:0x025d  */
    /* JADX WARN: Code duplicated, block: B:60:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x031e  */
    /* JADX WARN: Code duplicated, block: B:70:0x032f  */
    /* JADX WARN: Code duplicated, block: B:79:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:84:0x041a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0429  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object updateChannelImage(Uri uri, String str, ab.e<? super Pair<String, String>> eVar) {
        C11151 c11151;
        Uri uri2;
        File file;
        u0 u0Var;
        y0 y0Var;
        Object bounds;
        File file2;
        Uri uri3;
        String str2;
        final Pair pair;
        y0 y0Var2;
        u0 u0Var2;
        Object objCompress$default;
        Uri uri4;
        y0 y0Var3;
        String str3;
        u0 u0Var3;
        Pair pair2;
        File file3;
        XMPPDataSource xMPPDataSource;
        File file4;
        String str4;
        Pair pair3;
        Uri uri5;
        File file5;
        y0 y0Var4;
        u0 u0Var4;
        FileResponse.FileResult fileResult;
        UrlManager urlManager;
        File file6;
        String str5;
        Pair pair4;
        Uri uri6;
        File file7;
        y0 y0Var5;
        u0 u0Var5;
        File file8;
        u0 u0Var6;
        File file9;
        u0 u0Var7;
        FileResponse.FileResult fileResult2;
        y0 y0Var6;
        File file10;
        String str6;
        Uri uri7;
        final Pair pair5;
        FileResponse.FileResult fileResult3;
        Object objCompress$default2;
        String str7;
        Uri uri8;
        File file11;
        u0 u0Var8;
        y0 y0Var7;
        File file12;
        XMPPDataSource xMPPDataSource2;
        File file13;
        FileResponse.FileResult fileResult4;
        File file14;
        FileResponse.FileResult fileResult5;
        u0 u0Var9;
        int i10;
        String str8;
        y0 y0Var8;
        UrlManager urlManager2;
        File file15;
        Pair pair6;
        File file16;
        Uri uri9;
        y0 y0Var9;
        int i11;
        File file17;
        u0 u0Var10;
        u0 u0Var11;
        FileResponse.FileResult fileResult6;
        if (eVar instanceof C11151) {
            c11151 = (C11151) eVar;
            int i12 = c11151.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c11151.label = i12 - Integer.MIN_VALUE;
            } else {
                c11151 = new C11151(eVar);
            }
        } else {
            c11151 = new C11151(eVar);
        }
        C11151 c11152 = c11151;
        Object objDirectUpload = c11152.result;
        Object objG = bb.b.g();
        switch (c11152.label) {
            case 0:
                ua.v.b(objDirectUpload);
                try {
                    uri2 = uri;
                    try {
                        String path = MediaUtil.INSTANCE.getPath(this.context, uri2);
                        kotlin.jvm.internal.y.f(path);
                        file = new File(path);
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        file = null;
                    }
                    break;
                } catch (Exception e11) {
                    e = e11;
                    uri2 = uri;
                }
                if (file == null) {
                    return ua.z.a("", "");
                }
                u0Var = new u0();
                y0Var = new y0();
                y0Var.f36634c = ua.z.a("", "");
                File file18 = new File(uri2.getPath());
                c11152.L$0 = cb.l.a(uri2);
                c11152.L$1 = str;
                c11152.L$2 = file;
                c11152.L$3 = u0Var;
                c11152.L$4 = y0Var;
                c11152.label = 1;
                bounds = Z17InlineUtilsKt.getBounds(file18, c11152);
                if (bounds != objG) {
                    Uri uri10 = uri2;
                    file2 = file;
                    uri3 = uri10;
                    str2 = str;
                    pair = (Pair) bounds;
                    Compressor compressor = Compressor.INSTANCE;
                    Context context = this.context;
                    Function1 function1 = new Function1() { // from class: cu.todus.android.repositories.q0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainRepository.updateChannelImage$lambda$0(pair, (Compression) obj);
                        }
                    };
                    c11152.L$0 = cb.l.a(uri3);
                    c11152.L$1 = str2;
                    c11152.L$2 = file2;
                    c11152.L$3 = u0Var;
                    c11152.L$4 = y0Var;
                    c11152.L$5 = pair;
                    c11152.label = 2;
                    y0Var2 = y0Var;
                    u0Var2 = u0Var;
                    objCompress$default = Compressor.compress$default(compressor, context, file2, false, null, function1, c11152, 12, null);
                    if (objCompress$default != objG) {
                        uri4 = uri3;
                        objDirectUpload = objCompress$default;
                        y0Var3 = y0Var2;
                        str3 = str2;
                        u0Var3 = u0Var2;
                        pair2 = pair;
                        file3 = (File) objDirectUpload;
                        xMPPDataSource = this.mXMPPDataSource;
                        if (xMPPDataSource != null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                            File file19 = file2;
                            file4 = file3;
                            str4 = str3;
                            pair3 = pair2;
                            uri5 = uri4;
                            file5 = file19;
                            y0Var4 = y0Var3;
                            u0Var4 = u0Var3;
                            fileResult = null;
                            if (fileResult != null || fileResult.getWasError()) {
                                file8 = file4;
                                u0Var6 = u0Var4;
                                fileResult2 = fileResult;
                                y0Var6 = y0Var4;
                                file10 = file5;
                                str6 = str4;
                                uri7 = uri5;
                                pair5 = pair3;
                                Compressor compressor2 = Compressor.INSTANCE;
                                Context context2 = this.context;
                                Function1 function2 = new Function1() { // from class: cu.todus.android.repositories.r0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                                    }
                                };
                                c11152.L$0 = cb.l.a(uri7);
                                c11152.L$1 = str6;
                                c11152.L$2 = cb.l.a(file10);
                                c11152.L$3 = u0Var6;
                                c11152.L$4 = y0Var6;
                                c11152.L$5 = cb.l.a(pair5);
                                c11152.L$6 = cb.l.a(file8);
                                c11152.L$7 = cb.l.a(fileResult2);
                                c11152.L$8 = null;
                                c11152.label = 5;
                                fileResult3 = null;
                                objCompress$default2 = Compressor.compress$default(compressor2, context2, file10, false, null, function2, c11152, 12, null);
                                if (objCompress$default2 != objG) {
                                    str7 = str6;
                                    uri8 = uri7;
                                    file11 = file10;
                                    u0Var8 = u0Var6;
                                    objDirectUpload = objCompress$default2;
                                    y0Var7 = y0Var6;
                                    file12 = (File) objDirectUpload;
                                    xMPPDataSource2 = this.mXMPPDataSource;
                                    if (xMPPDataSource2 != null || (urlManager2 = xMPPDataSource2.getUrlManager()) == null) {
                                        y0 y0Var10 = y0Var7;
                                        u0 u0Var12 = u0Var8;
                                        file13 = file12;
                                        fileResult4 = fileResult2;
                                        file14 = file8;
                                        fileResult5 = fileResult3;
                                        u0Var9 = u0Var12;
                                        i10 = 0;
                                        str8 = str7;
                                        y0Var8 = y0Var10;
                                        if (fileResult5 != null && !fileResult5.getWasError()) {
                                            UploadDataSource.Companion companion = UploadDataSource.INSTANCE;
                                            String path2 = file12.getPath();
                                            kotlin.jvm.internal.y.h(path2, "getPath(...)");
                                            String put = fileResult5.getPut();
                                            c11152.L$0 = cb.l.a(uri8);
                                            c11152.L$1 = cb.l.a(str8);
                                            c11152.L$2 = cb.l.a(file11);
                                            c11152.L$3 = u0Var9;
                                            c11152.L$4 = y0Var8;
                                            c11152.L$5 = cb.l.a(pair5);
                                            c11152.L$6 = cb.l.a(file14);
                                            c11152.L$7 = cb.l.a(fileResult4);
                                            c11152.L$8 = cb.l.a(file13);
                                            c11152.L$9 = cb.l.a(file12);
                                            c11152.L$10 = fileResult5;
                                            c11152.L$11 = u0Var9;
                                            c11152.I$0 = i10;
                                            c11152.label = 7;
                                            objDirectUpload = companion.directUpload(put, path2, c11152);
                                            if (objDirectUpload != objG) {
                                                u0Var10 = u0Var9;
                                                u0Var11 = u0Var10;
                                                fileResult6 = fileResult5;
                                                u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                                                }
                                            }
                                        }
                                        return y0Var8.f36634c;
                                    }
                                    long length = file12.length();
                                    c11152.L$0 = cb.l.a(uri8);
                                    c11152.L$1 = cb.l.a(str7);
                                    c11152.L$2 = cb.l.a(file11);
                                    c11152.L$3 = u0Var8;
                                    c11152.L$4 = y0Var7;
                                    c11152.L$5 = cb.l.a(pair5);
                                    c11152.L$6 = cb.l.a(file8);
                                    c11152.L$7 = cb.l.a(fileResult2);
                                    c11152.L$8 = cb.l.a(file12);
                                    c11152.L$9 = file12;
                                    c11152.I$0 = 0;
                                    c11152.label = 6;
                                    u0 u0Var13 = u0Var8;
                                    y0 y0Var11 = y0Var7;
                                    Object putUrl$default = UrlManager.getPutUrl$default(urlManager2, str7, 6, length, false, c11152, 8, null);
                                    if (putUrl$default != objG) {
                                        file13 = file12;
                                        fileResult4 = fileResult2;
                                        file15 = file8;
                                        pair6 = pair5;
                                        file16 = file11;
                                        uri9 = uri8;
                                        u0Var9 = u0Var13;
                                        y0Var9 = y0Var11;
                                        objDirectUpload = putUrl$default;
                                        str8 = str7;
                                        i11 = 0;
                                        file17 = file13;
                                        File file20 = file15;
                                        i10 = i11;
                                        file14 = file20;
                                        file11 = file16;
                                        uri8 = uri9;
                                        fileResult5 = (FileResponse.FileResult) objDirectUpload;
                                        file12 = file17;
                                        pair5 = pair6;
                                        y0Var8 = y0Var9;
                                        if (fileResult5 != null) {
                                            UploadDataSource.Companion companion2 = UploadDataSource.INSTANCE;
                                            String path3 = file12.getPath();
                                            kotlin.jvm.internal.y.h(path3, "getPath(...)");
                                            String put2 = fileResult5.getPut();
                                            c11152.L$0 = cb.l.a(uri8);
                                            c11152.L$1 = cb.l.a(str8);
                                            c11152.L$2 = cb.l.a(file11);
                                            c11152.L$3 = u0Var9;
                                            c11152.L$4 = y0Var8;
                                            c11152.L$5 = cb.l.a(pair5);
                                            c11152.L$6 = cb.l.a(file14);
                                            c11152.L$7 = cb.l.a(fileResult4);
                                            c11152.L$8 = cb.l.a(file13);
                                            c11152.L$9 = cb.l.a(file12);
                                            c11152.L$10 = fileResult5;
                                            c11152.L$11 = u0Var9;
                                            c11152.I$0 = i10;
                                            c11152.label = 7;
                                            objDirectUpload = companion2.directUpload(put2, path3, c11152);
                                            if (objDirectUpload != objG) {
                                                u0Var10 = u0Var9;
                                                u0Var11 = u0Var10;
                                                fileResult6 = fileResult5;
                                                u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                                                }
                                            }
                                        }
                                        return y0Var8.f36634c;
                                    }
                                }
                            } else {
                                UploadDataSource.Companion companion3 = UploadDataSource.INSTANCE;
                                String path4 = file4.getPath();
                                kotlin.jvm.internal.y.h(path4, "getPath(...)");
                                String put3 = fileResult.getPut();
                                File file21 = file4;
                                c11152.L$0 = cb.l.a(uri5);
                                c11152.L$1 = str4;
                                c11152.L$2 = file5;
                                c11152.L$3 = u0Var4;
                                c11152.L$4 = y0Var4;
                                c11152.L$5 = pair3;
                                c11152.L$6 = cb.l.a(file21);
                                c11152.L$7 = fileResult;
                                c11152.L$8 = u0Var4;
                                c11152.label = 4;
                                objDirectUpload = companion3.directUpload(put3, path4, c11152);
                                if (objDirectUpload != objG) {
                                    file9 = file21;
                                    u0Var7 = u0Var4;
                                    u0Var4.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                    if (u0Var7.f36629c) {
                                        y0Var4.f36634c = ua.z.a("", fileResult.getGet());
                                    }
                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var4.f36634c).getSecond());
                                    file8 = file9;
                                    u0Var6 = u0Var7;
                                    fileResult2 = fileResult;
                                    y0Var6 = y0Var4;
                                    file10 = file5;
                                    str6 = str4;
                                    uri7 = uri5;
                                    pair5 = pair3;
                                    Compressor compressor3 = Compressor.INSTANCE;
                                    Context context3 = this.context;
                                    Function1 function3 = new Function1() { // from class: cu.todus.android.repositories.r0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                                        }
                                    };
                                    c11152.L$0 = cb.l.a(uri7);
                                    c11152.L$1 = str6;
                                    c11152.L$2 = cb.l.a(file10);
                                    c11152.L$3 = u0Var6;
                                    c11152.L$4 = y0Var6;
                                    c11152.L$5 = cb.l.a(pair5);
                                    c11152.L$6 = cb.l.a(file8);
                                    c11152.L$7 = cb.l.a(fileResult2);
                                    c11152.L$8 = null;
                                    c11152.label = 5;
                                    fileResult3 = null;
                                    objCompress$default2 = Compressor.compress$default(compressor3, context3, file10, false, null, function3, c11152, 12, null);
                                    if (objCompress$default2 != objG) {
                                        str7 = str6;
                                        uri8 = uri7;
                                        file11 = file10;
                                        u0Var8 = u0Var6;
                                        objDirectUpload = objCompress$default2;
                                        y0Var7 = y0Var6;
                                        file12 = (File) objDirectUpload;
                                        xMPPDataSource2 = this.mXMPPDataSource;
                                        if (xMPPDataSource2 != null) {
                                        }
                                        y0 y0Var12 = y0Var7;
                                        u0 u0Var14 = u0Var8;
                                        file13 = file12;
                                        fileResult4 = fileResult2;
                                        file14 = file8;
                                        fileResult5 = fileResult3;
                                        u0Var9 = u0Var14;
                                        i10 = 0;
                                        str8 = str7;
                                        y0Var8 = y0Var12;
                                        if (fileResult5 != null) {
                                            UploadDataSource.Companion companion4 = UploadDataSource.INSTANCE;
                                            String path5 = file12.getPath();
                                            kotlin.jvm.internal.y.h(path5, "getPath(...)");
                                            String put4 = fileResult5.getPut();
                                            c11152.L$0 = cb.l.a(uri8);
                                            c11152.L$1 = cb.l.a(str8);
                                            c11152.L$2 = cb.l.a(file11);
                                            c11152.L$3 = u0Var9;
                                            c11152.L$4 = y0Var8;
                                            c11152.L$5 = cb.l.a(pair5);
                                            c11152.L$6 = cb.l.a(file14);
                                            c11152.L$7 = cb.l.a(fileResult4);
                                            c11152.L$8 = cb.l.a(file13);
                                            c11152.L$9 = cb.l.a(file12);
                                            c11152.L$10 = fileResult5;
                                            c11152.L$11 = u0Var9;
                                            c11152.I$0 = i10;
                                            c11152.label = 7;
                                            objDirectUpload = companion4.directUpload(put4, path5, c11152);
                                            if (objDirectUpload != objG) {
                                                u0Var10 = u0Var9;
                                                u0Var11 = u0Var10;
                                                fileResult6 = fileResult5;
                                                u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                                                }
                                            }
                                        }
                                        return y0Var8.f36634c;
                                    }
                                }
                            }
                        } else {
                            long length2 = file3.length();
                            c11152.L$0 = cb.l.a(uri4);
                            c11152.L$1 = str3;
                            c11152.L$2 = file2;
                            c11152.L$3 = u0Var3;
                            c11152.L$4 = y0Var3;
                            c11152.L$5 = pair2;
                            c11152.L$6 = file3;
                            c11152.label = 3;
                            File file22 = file2;
                            y0 y0Var13 = y0Var3;
                            u0 u0Var15 = u0Var3;
                            String str9 = str3;
                            Object putUrl$default2 = UrlManager.getPutUrl$default(urlManager, str9, 5, length2, false, c11152, 8, null);
                            if (putUrl$default2 != objG) {
                                file6 = file3;
                                objDirectUpload = putUrl$default2;
                                str5 = str9;
                                pair4 = pair2;
                                uri6 = uri4;
                                file7 = file22;
                                y0Var5 = y0Var13;
                                u0Var5 = u0Var15;
                                str4 = str5;
                                uri5 = uri6;
                                file5 = file7;
                                y0Var4 = y0Var5;
                                file4 = file6;
                                u0Var4 = u0Var5;
                                pair3 = pair4;
                                fileResult = (FileResponse.FileResult) objDirectUpload;
                                if (fileResult != null) {
                                }
                                file8 = file4;
                                u0Var6 = u0Var4;
                                fileResult2 = fileResult;
                                y0Var6 = y0Var4;
                                file10 = file5;
                                str6 = str4;
                                uri7 = uri5;
                                pair5 = pair3;
                                Compressor compressor4 = Compressor.INSTANCE;
                                Context context4 = this.context;
                                Function1 function4 = new Function1() { // from class: cu.todus.android.repositories.r0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                                    }
                                };
                                c11152.L$0 = cb.l.a(uri7);
                                c11152.L$1 = str6;
                                c11152.L$2 = cb.l.a(file10);
                                c11152.L$3 = u0Var6;
                                c11152.L$4 = y0Var6;
                                c11152.L$5 = cb.l.a(pair5);
                                c11152.L$6 = cb.l.a(file8);
                                c11152.L$7 = cb.l.a(fileResult2);
                                c11152.L$8 = null;
                                c11152.label = 5;
                                fileResult3 = null;
                                objCompress$default2 = Compressor.compress$default(compressor4, context4, file10, false, null, function4, c11152, 12, null);
                                if (objCompress$default2 != objG) {
                                    str7 = str6;
                                    uri8 = uri7;
                                    file11 = file10;
                                    u0Var8 = u0Var6;
                                    objDirectUpload = objCompress$default2;
                                    y0Var7 = y0Var6;
                                    file12 = (File) objDirectUpload;
                                    xMPPDataSource2 = this.mXMPPDataSource;
                                    if (xMPPDataSource2 != null) {
                                    }
                                    y0 y0Var14 = y0Var7;
                                    u0 u0Var16 = u0Var8;
                                    file13 = file12;
                                    fileResult4 = fileResult2;
                                    file14 = file8;
                                    fileResult5 = fileResult3;
                                    u0Var9 = u0Var16;
                                    i10 = 0;
                                    str8 = str7;
                                    y0Var8 = y0Var14;
                                    if (fileResult5 != null) {
                                        UploadDataSource.Companion companion5 = UploadDataSource.INSTANCE;
                                        String path6 = file12.getPath();
                                        kotlin.jvm.internal.y.h(path6, "getPath(...)");
                                        String put5 = fileResult5.getPut();
                                        c11152.L$0 = cb.l.a(uri8);
                                        c11152.L$1 = cb.l.a(str8);
                                        c11152.L$2 = cb.l.a(file11);
                                        c11152.L$3 = u0Var9;
                                        c11152.L$4 = y0Var8;
                                        c11152.L$5 = cb.l.a(pair5);
                                        c11152.L$6 = cb.l.a(file14);
                                        c11152.L$7 = cb.l.a(fileResult4);
                                        c11152.L$8 = cb.l.a(file13);
                                        c11152.L$9 = cb.l.a(file12);
                                        c11152.L$10 = fileResult5;
                                        c11152.L$11 = u0Var9;
                                        c11152.I$0 = i10;
                                        c11152.label = 7;
                                        objDirectUpload = companion5.directUpload(put5, path6, c11152);
                                        if (objDirectUpload != objG) {
                                            u0Var10 = u0Var9;
                                            u0Var11 = u0Var10;
                                            fileResult6 = fileResult5;
                                            u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                            if (u0Var11.f36629c) {
                                                y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                                            }
                                        }
                                    }
                                    return y0Var8.f36634c;
                                }
                            }
                        }
                    }
                }
                return objG;
            case 1:
                y0Var = (y0) c11152.L$4;
                u0Var = (u0) c11152.L$3;
                file2 = (File) c11152.L$2;
                String str10 = (String) c11152.L$1;
                Uri uri11 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                str2 = str10;
                bounds = objDirectUpload;
                uri3 = uri11;
                pair = (Pair) bounds;
                Compressor compressor5 = Compressor.INSTANCE;
                Context context5 = this.context;
                Function1 function5 = new Function1() { // from class: cu.todus.android.repositories.q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainRepository.updateChannelImage$lambda$0(pair, (Compression) obj);
                    }
                };
                c11152.L$0 = cb.l.a(uri3);
                c11152.L$1 = str2;
                c11152.L$2 = file2;
                c11152.L$3 = u0Var;
                c11152.L$4 = y0Var;
                c11152.L$5 = pair;
                c11152.label = 2;
                y0Var2 = y0Var;
                u0Var2 = u0Var;
                objCompress$default = Compressor.compress$default(compressor5, context5, file2, false, null, function5, c11152, 12, null);
                if (objCompress$default != objG) {
                    uri4 = uri3;
                    objDirectUpload = objCompress$default;
                    y0Var3 = y0Var2;
                    str3 = str2;
                    u0Var3 = u0Var2;
                    pair2 = pair;
                    file3 = (File) objDirectUpload;
                    xMPPDataSource = this.mXMPPDataSource;
                    if (xMPPDataSource != null) {
                    }
                    File file110 = file2;
                    file4 = file3;
                    str4 = str3;
                    pair3 = pair2;
                    uri5 = uri4;
                    file5 = file110;
                    y0Var4 = y0Var3;
                    u0Var4 = u0Var3;
                    fileResult = null;
                    if (fileResult != null) {
                    }
                    file8 = file4;
                    u0Var6 = u0Var4;
                    fileResult2 = fileResult;
                    y0Var6 = y0Var4;
                    file10 = file5;
                    str6 = str4;
                    uri7 = uri5;
                    pair5 = pair3;
                    Compressor compressor6 = Compressor.INSTANCE;
                    Context context6 = this.context;
                    Function1 function6 = new Function1() { // from class: cu.todus.android.repositories.r0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                        }
                    };
                    c11152.L$0 = cb.l.a(uri7);
                    c11152.L$1 = str6;
                    c11152.L$2 = cb.l.a(file10);
                    c11152.L$3 = u0Var6;
                    c11152.L$4 = y0Var6;
                    c11152.L$5 = cb.l.a(pair5);
                    c11152.L$6 = cb.l.a(file8);
                    c11152.L$7 = cb.l.a(fileResult2);
                    c11152.L$8 = null;
                    c11152.label = 5;
                    fileResult3 = null;
                    objCompress$default2 = Compressor.compress$default(compressor6, context6, file10, false, null, function6, c11152, 12, null);
                    if (objCompress$default2 != objG) {
                        str7 = str6;
                        uri8 = uri7;
                        file11 = file10;
                        u0Var8 = u0Var6;
                        objDirectUpload = objCompress$default2;
                        y0Var7 = y0Var6;
                        file12 = (File) objDirectUpload;
                        xMPPDataSource2 = this.mXMPPDataSource;
                        if (xMPPDataSource2 != null) {
                            break;
                        }
                        y0 y0Var15 = y0Var7;
                        u0 u0Var17 = u0Var8;
                        file13 = file12;
                        fileResult4 = fileResult2;
                        file14 = file8;
                        fileResult5 = fileResult3;
                        u0Var9 = u0Var17;
                        i10 = 0;
                        str8 = str7;
                        y0Var8 = y0Var15;
                        if (fileResult5 != null) {
                            UploadDataSource.Companion companion6 = UploadDataSource.INSTANCE;
                            String path7 = file12.getPath();
                            kotlin.jvm.internal.y.h(path7, "getPath(...)");
                            String put6 = fileResult5.getPut();
                            c11152.L$0 = cb.l.a(uri8);
                            c11152.L$1 = cb.l.a(str8);
                            c11152.L$2 = cb.l.a(file11);
                            c11152.L$3 = u0Var9;
                            c11152.L$4 = y0Var8;
                            c11152.L$5 = cb.l.a(pair5);
                            c11152.L$6 = cb.l.a(file14);
                            c11152.L$7 = cb.l.a(fileResult4);
                            c11152.L$8 = cb.l.a(file13);
                            c11152.L$9 = cb.l.a(file12);
                            c11152.L$10 = fileResult5;
                            c11152.L$11 = u0Var9;
                            c11152.I$0 = i10;
                            c11152.label = 7;
                            objDirectUpload = companion6.directUpload(put6, path7, c11152);
                            if (objDirectUpload != objG) {
                                u0Var10 = u0Var9;
                                u0Var11 = u0Var10;
                                fileResult6 = fileResult5;
                                u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                if (u0Var11.f36629c) {
                                    y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                                }
                            }
                        }
                        return y0Var8.f36634c;
                    }
                    break;
                }
                return objG;
            case 2:
                Pair pair7 = (Pair) c11152.L$5;
                y0 y0Var16 = (y0) c11152.L$4;
                u0 u0Var18 = (u0) c11152.L$3;
                File file23 = (File) c11152.L$2;
                str3 = (String) c11152.L$1;
                Uri uri12 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                pair2 = pair7;
                y0Var3 = y0Var16;
                u0Var3 = u0Var18;
                file2 = file23;
                uri4 = uri12;
                file3 = (File) objDirectUpload;
                xMPPDataSource = this.mXMPPDataSource;
                if (xMPPDataSource != null) {
                    break;
                }
                File file111 = file2;
                file4 = file3;
                str4 = str3;
                pair3 = pair2;
                uri5 = uri4;
                file5 = file111;
                y0Var4 = y0Var3;
                u0Var4 = u0Var3;
                fileResult = null;
                if (fileResult != null) {
                    break;
                }
                file8 = file4;
                u0Var6 = u0Var4;
                fileResult2 = fileResult;
                y0Var6 = y0Var4;
                file10 = file5;
                str6 = str4;
                uri7 = uri5;
                pair5 = pair3;
                Compressor compressor7 = Compressor.INSTANCE;
                Context context7 = this.context;
                Function1 function7 = new Function1() { // from class: cu.todus.android.repositories.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                    }
                };
                c11152.L$0 = cb.l.a(uri7);
                c11152.L$1 = str6;
                c11152.L$2 = cb.l.a(file10);
                c11152.L$3 = u0Var6;
                c11152.L$4 = y0Var6;
                c11152.L$5 = cb.l.a(pair5);
                c11152.L$6 = cb.l.a(file8);
                c11152.L$7 = cb.l.a(fileResult2);
                c11152.L$8 = null;
                c11152.label = 5;
                fileResult3 = null;
                objCompress$default2 = Compressor.compress$default(compressor7, context7, file10, false, null, function7, c11152, 12, null);
                if (objCompress$default2 != objG) {
                    str7 = str6;
                    uri8 = uri7;
                    file11 = file10;
                    u0Var8 = u0Var6;
                    objDirectUpload = objCompress$default2;
                    y0Var7 = y0Var6;
                    file12 = (File) objDirectUpload;
                    xMPPDataSource2 = this.mXMPPDataSource;
                    if (xMPPDataSource2 != null) {
                        break;
                    }
                    y0 y0Var17 = y0Var7;
                    u0 u0Var19 = u0Var8;
                    file13 = file12;
                    fileResult4 = fileResult2;
                    file14 = file8;
                    fileResult5 = fileResult3;
                    u0Var9 = u0Var19;
                    i10 = 0;
                    str8 = str7;
                    y0Var8 = y0Var17;
                    if (fileResult5 != null) {
                        UploadDataSource.Companion companion7 = UploadDataSource.INSTANCE;
                        String path8 = file12.getPath();
                        kotlin.jvm.internal.y.h(path8, "getPath(...)");
                        String put7 = fileResult5.getPut();
                        c11152.L$0 = cb.l.a(uri8);
                        c11152.L$1 = cb.l.a(str8);
                        c11152.L$2 = cb.l.a(file11);
                        c11152.L$3 = u0Var9;
                        c11152.L$4 = y0Var8;
                        c11152.L$5 = cb.l.a(pair5);
                        c11152.L$6 = cb.l.a(file14);
                        c11152.L$7 = cb.l.a(fileResult4);
                        c11152.L$8 = cb.l.a(file13);
                        c11152.L$9 = cb.l.a(file12);
                        c11152.L$10 = fileResult5;
                        c11152.L$11 = u0Var9;
                        c11152.I$0 = i10;
                        c11152.label = 7;
                        objDirectUpload = companion7.directUpload(put7, path8, c11152);
                        if (objDirectUpload != objG) {
                            u0Var10 = u0Var9;
                            u0Var11 = u0Var10;
                            fileResult6 = fileResult5;
                            u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                            if (u0Var11.f36629c) {
                                y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                            }
                        }
                    }
                    return y0Var8.f36634c;
                }
                return objG;
            case 3:
                file6 = (File) c11152.L$6;
                pair4 = (Pair) c11152.L$5;
                y0Var5 = (y0) c11152.L$4;
                u0Var5 = (u0) c11152.L$3;
                file7 = (File) c11152.L$2;
                str5 = (String) c11152.L$1;
                uri6 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                str4 = str5;
                uri5 = uri6;
                file5 = file7;
                y0Var4 = y0Var5;
                file4 = file6;
                u0Var4 = u0Var5;
                pair3 = pair4;
                fileResult = (FileResponse.FileResult) objDirectUpload;
                if (fileResult != null) {
                    break;
                }
                file8 = file4;
                u0Var6 = u0Var4;
                fileResult2 = fileResult;
                y0Var6 = y0Var4;
                file10 = file5;
                str6 = str4;
                uri7 = uri5;
                pair5 = pair3;
                Compressor compressor8 = Compressor.INSTANCE;
                Context context8 = this.context;
                Function1 function8 = new Function1() { // from class: cu.todus.android.repositories.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                    }
                };
                c11152.L$0 = cb.l.a(uri7);
                c11152.L$1 = str6;
                c11152.L$2 = cb.l.a(file10);
                c11152.L$3 = u0Var6;
                c11152.L$4 = y0Var6;
                c11152.L$5 = cb.l.a(pair5);
                c11152.L$6 = cb.l.a(file8);
                c11152.L$7 = cb.l.a(fileResult2);
                c11152.L$8 = null;
                c11152.label = 5;
                fileResult3 = null;
                objCompress$default2 = Compressor.compress$default(compressor8, context8, file10, false, null, function8, c11152, 12, null);
                if (objCompress$default2 != objG) {
                    str7 = str6;
                    uri8 = uri7;
                    file11 = file10;
                    u0Var8 = u0Var6;
                    objDirectUpload = objCompress$default2;
                    y0Var7 = y0Var6;
                    file12 = (File) objDirectUpload;
                    xMPPDataSource2 = this.mXMPPDataSource;
                    if (xMPPDataSource2 != null) {
                        break;
                    }
                    y0 y0Var18 = y0Var7;
                    u0 u0Var110 = u0Var8;
                    file13 = file12;
                    fileResult4 = fileResult2;
                    file14 = file8;
                    fileResult5 = fileResult3;
                    u0Var9 = u0Var110;
                    i10 = 0;
                    str8 = str7;
                    y0Var8 = y0Var18;
                    if (fileResult5 != null) {
                        UploadDataSource.Companion companion8 = UploadDataSource.INSTANCE;
                        String path9 = file12.getPath();
                        kotlin.jvm.internal.y.h(path9, "getPath(...)");
                        String put8 = fileResult5.getPut();
                        c11152.L$0 = cb.l.a(uri8);
                        c11152.L$1 = cb.l.a(str8);
                        c11152.L$2 = cb.l.a(file11);
                        c11152.L$3 = u0Var9;
                        c11152.L$4 = y0Var8;
                        c11152.L$5 = cb.l.a(pair5);
                        c11152.L$6 = cb.l.a(file14);
                        c11152.L$7 = cb.l.a(fileResult4);
                        c11152.L$8 = cb.l.a(file13);
                        c11152.L$9 = cb.l.a(file12);
                        c11152.L$10 = fileResult5;
                        c11152.L$11 = u0Var9;
                        c11152.I$0 = i10;
                        c11152.label = 7;
                        objDirectUpload = companion8.directUpload(put8, path9, c11152);
                        if (objDirectUpload != objG) {
                            u0Var10 = u0Var9;
                            u0Var11 = u0Var10;
                            fileResult6 = fileResult5;
                            u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                            if (u0Var11.f36629c) {
                                y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                            }
                        }
                    }
                    return y0Var8.f36634c;
                }
                return objG;
            case 4:
                u0Var4 = (u0) c11152.L$8;
                fileResult = (FileResponse.FileResult) c11152.L$7;
                file9 = (File) c11152.L$6;
                pair3 = (Pair) c11152.L$5;
                y0Var4 = (y0) c11152.L$4;
                u0Var7 = (u0) c11152.L$3;
                file5 = (File) c11152.L$2;
                str4 = (String) c11152.L$1;
                uri5 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                u0Var4.f36629c = ((Boolean) objDirectUpload).booleanValue();
                if (u0Var7.f36629c) {
                    y0Var4.f36634c = ua.z.a("", fileResult.getGet());
                }
                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var4.f36634c).getSecond());
                file8 = file9;
                u0Var6 = u0Var7;
                fileResult2 = fileResult;
                y0Var6 = y0Var4;
                file10 = file5;
                str6 = str4;
                uri7 = uri5;
                pair5 = pair3;
                Compressor compressor9 = Compressor.INSTANCE;
                Context context9 = this.context;
                Function1 function9 = new Function1() { // from class: cu.todus.android.repositories.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainRepository.updateChannelImage$lambda$1(pair5, (Compression) obj);
                    }
                };
                c11152.L$0 = cb.l.a(uri7);
                c11152.L$1 = str6;
                c11152.L$2 = cb.l.a(file10);
                c11152.L$3 = u0Var6;
                c11152.L$4 = y0Var6;
                c11152.L$5 = cb.l.a(pair5);
                c11152.L$6 = cb.l.a(file8);
                c11152.L$7 = cb.l.a(fileResult2);
                c11152.L$8 = null;
                c11152.label = 5;
                fileResult3 = null;
                objCompress$default2 = Compressor.compress$default(compressor9, context9, file10, false, null, function9, c11152, 12, null);
                if (objCompress$default2 != objG) {
                    str7 = str6;
                    uri8 = uri7;
                    file11 = file10;
                    u0Var8 = u0Var6;
                    objDirectUpload = objCompress$default2;
                    y0Var7 = y0Var6;
                    file12 = (File) objDirectUpload;
                    xMPPDataSource2 = this.mXMPPDataSource;
                    if (xMPPDataSource2 != null) {
                        break;
                    }
                    y0 y0Var19 = y0Var7;
                    u0 u0Var111 = u0Var8;
                    file13 = file12;
                    fileResult4 = fileResult2;
                    file14 = file8;
                    fileResult5 = fileResult3;
                    u0Var9 = u0Var111;
                    i10 = 0;
                    str8 = str7;
                    y0Var8 = y0Var19;
                    if (fileResult5 != null) {
                        UploadDataSource.Companion companion9 = UploadDataSource.INSTANCE;
                        String path10 = file12.getPath();
                        kotlin.jvm.internal.y.h(path10, "getPath(...)");
                        String put9 = fileResult5.getPut();
                        c11152.L$0 = cb.l.a(uri8);
                        c11152.L$1 = cb.l.a(str8);
                        c11152.L$2 = cb.l.a(file11);
                        c11152.L$3 = u0Var9;
                        c11152.L$4 = y0Var8;
                        c11152.L$5 = cb.l.a(pair5);
                        c11152.L$6 = cb.l.a(file14);
                        c11152.L$7 = cb.l.a(fileResult4);
                        c11152.L$8 = cb.l.a(file13);
                        c11152.L$9 = cb.l.a(file12);
                        c11152.L$10 = fileResult5;
                        c11152.L$11 = u0Var9;
                        c11152.I$0 = i10;
                        c11152.label = 7;
                        objDirectUpload = companion9.directUpload(put9, path10, c11152);
                        if (objDirectUpload != objG) {
                            u0Var10 = u0Var9;
                            u0Var11 = u0Var10;
                            fileResult6 = fileResult5;
                            u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                            if (u0Var11.f36629c) {
                                y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                            }
                        }
                    }
                    return y0Var8.f36634c;
                }
                return objG;
            case 5:
                FileResponse.FileResult fileResult7 = (FileResponse.FileResult) c11152.L$7;
                File file24 = (File) c11152.L$6;
                Pair pair8 = (Pair) c11152.L$5;
                y0 y0Var20 = (y0) c11152.L$4;
                u0 u0Var20 = (u0) c11152.L$3;
                File file25 = (File) c11152.L$2;
                String str11 = (String) c11152.L$1;
                Uri uri13 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                fileResult2 = fileResult7;
                file8 = file24;
                pair5 = pair8;
                y0Var7 = y0Var20;
                u0Var8 = u0Var20;
                file11 = file25;
                str7 = str11;
                uri8 = uri13;
                fileResult3 = null;
                file12 = (File) objDirectUpload;
                xMPPDataSource2 = this.mXMPPDataSource;
                if (xMPPDataSource2 != null) {
                    break;
                }
                y0 y0Var110 = y0Var7;
                u0 u0Var112 = u0Var8;
                file13 = file12;
                fileResult4 = fileResult2;
                file14 = file8;
                fileResult5 = fileResult3;
                u0Var9 = u0Var112;
                i10 = 0;
                str8 = str7;
                y0Var8 = y0Var110;
                if (fileResult5 != null) {
                    UploadDataSource.Companion companion10 = UploadDataSource.INSTANCE;
                    String path11 = file12.getPath();
                    kotlin.jvm.internal.y.h(path11, "getPath(...)");
                    String put10 = fileResult5.getPut();
                    c11152.L$0 = cb.l.a(uri8);
                    c11152.L$1 = cb.l.a(str8);
                    c11152.L$2 = cb.l.a(file11);
                    c11152.L$3 = u0Var9;
                    c11152.L$4 = y0Var8;
                    c11152.L$5 = cb.l.a(pair5);
                    c11152.L$6 = cb.l.a(file14);
                    c11152.L$7 = cb.l.a(fileResult4);
                    c11152.L$8 = cb.l.a(file13);
                    c11152.L$9 = cb.l.a(file12);
                    c11152.L$10 = fileResult5;
                    c11152.L$11 = u0Var9;
                    c11152.I$0 = i10;
                    c11152.label = 7;
                    objDirectUpload = companion10.directUpload(put10, path11, c11152);
                    if (objDirectUpload != objG) {
                        u0Var10 = u0Var9;
                        u0Var11 = u0Var10;
                        fileResult6 = fileResult5;
                        u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                        if (u0Var11.f36629c) {
                            y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                        }
                    }
                    return objG;
                }
                return y0Var8.f36634c;
            case 6:
                i11 = c11152.I$0;
                file17 = (File) c11152.L$9;
                file13 = (File) c11152.L$8;
                fileResult4 = (FileResponse.FileResult) c11152.L$7;
                file15 = (File) c11152.L$6;
                pair6 = (Pair) c11152.L$5;
                y0Var9 = (y0) c11152.L$4;
                u0Var9 = (u0) c11152.L$3;
                file16 = (File) c11152.L$2;
                str8 = (String) c11152.L$1;
                uri9 = (Uri) c11152.L$0;
                ua.v.b(objDirectUpload);
                File file26 = file15;
                i10 = i11;
                file14 = file26;
                file11 = file16;
                uri8 = uri9;
                fileResult5 = (FileResponse.FileResult) objDirectUpload;
                file12 = file17;
                pair5 = pair6;
                y0Var8 = y0Var9;
                if (fileResult5 != null) {
                    UploadDataSource.Companion companion11 = UploadDataSource.INSTANCE;
                    String path12 = file12.getPath();
                    kotlin.jvm.internal.y.h(path12, "getPath(...)");
                    String put11 = fileResult5.getPut();
                    c11152.L$0 = cb.l.a(uri8);
                    c11152.L$1 = cb.l.a(str8);
                    c11152.L$2 = cb.l.a(file11);
                    c11152.L$3 = u0Var9;
                    c11152.L$4 = y0Var8;
                    c11152.L$5 = cb.l.a(pair5);
                    c11152.L$6 = cb.l.a(file14);
                    c11152.L$7 = cb.l.a(fileResult4);
                    c11152.L$8 = cb.l.a(file13);
                    c11152.L$9 = cb.l.a(file12);
                    c11152.L$10 = fileResult5;
                    c11152.L$11 = u0Var9;
                    c11152.I$0 = i10;
                    c11152.label = 7;
                    objDirectUpload = companion11.directUpload(put11, path12, c11152);
                    if (objDirectUpload != objG) {
                        u0Var10 = u0Var9;
                        u0Var11 = u0Var10;
                        fileResult6 = fileResult5;
                        u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                        if (u0Var11.f36629c) {
                            y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                        }
                    }
                    return objG;
                }
                return y0Var8.f36634c;
            case 7:
                u0Var10 = (u0) c11152.L$11;
                fileResult6 = (FileResponse.FileResult) c11152.L$10;
                y0Var8 = (y0) c11152.L$4;
                u0Var11 = (u0) c11152.L$3;
                ua.v.b(objDirectUpload);
                u0Var10.f36629c = ((Boolean) objDirectUpload).booleanValue();
                if (u0Var11.f36629c) {
                    y0Var8.f36634c = ua.z.a(fileResult6.getGet(), ((Pair) y0Var8.f36634c).getSecond());
                }
                return y0Var8.f36634c;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateChannelImage$lambda$0(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateChannelImage$lambda$1(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        SizeConstraintKt.size(compress, 64L, 10, 10);
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return ua.k0.f43947a;
    }

    public static /* synthetic */ Object updateChannelInfo$default(MainRepository mainRepository, String str, Uri uri, String str2, String str3, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        if ((i10 & 2) != 0) {
            uri = null;
        }
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return mainRepository.updateChannelInfo(str, uri, str2, str3, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateGroupImage$lambda$0(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 updateGroupImage$lambda$1(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        SizeConstraintKt.size(compress, 64L, 10, 10);
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return ua.k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (r11 == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        if (r11 == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c8, code lost:
    
        if (r1.updateLastMessage(r2, r3, r4, r6) == r0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateLastMessage(cu.todus.android.data.db.entity.toDus.Message r10, ab.e<? super ua.k0> r11) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.updateLastMessage(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.k0 uploadProductImage$lambda$0(Pair pair, Compression compress) {
        kotlin.jvm.internal.y.i(compress, "$this$compress");
        if (((Number) pair.getFirst()).intValue() > 4000 && ((Number) pair.getSecond()).intValue() > 4000) {
            ResolutionConstraintKt.resolution(compress, 1920, 1080);
        }
        return ua.k0.f43947a;
    }

    public final Object acceptCallProcess(String str, lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e<? super ua.k0> eVar) {
        CallManager callManager;
        this.notificationManager.cancelNotifications(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(str));
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objSendPickupIQ = callManager.sendPickupIQ(str, aVar, aVar2, aVar3, eVar);
        return objSendPickupIQ == bb.b.g() ? objSendPickupIQ : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object addNewMembers(String str, List<String> list, ab.e<? super AddMembersToGroupResponse> eVar) {
        C10311 c10311;
        GroupsManager groupsManager;
        if (eVar instanceof C10311) {
            c10311 = (C10311) eVar;
            int i10 = c10311.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10311.label = i10 - Integer.MIN_VALUE;
            } else {
                c10311 = new C10311(eVar);
            }
        } else {
            c10311 = new C10311(eVar);
        }
        Object objAddNewMembers = c10311.result;
        Object objG = bb.b.g();
        int i11 = c10311.label;
        if (i11 == 0) {
            ua.v.b(objAddNewMembers);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                c10311.L$0 = cb.l.a(str);
                c10311.L$1 = cb.l.a(list);
                c10311.label = 1;
                objAddNewMembers = groupsManager.addNewMembers(str, list, c10311);
                if (objAddNewMembers == objG) {
                    return objG;
                }
            }
            return new AddMembersToGroupResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objAddNewMembers);
        AddMembersToGroupResponse addMembersToGroupResponse = (AddMembersToGroupResponse) objAddNewMembers;
        if (addMembersToGroupResponse != null) {
            return addMembersToGroupResponse;
        }
        return new AddMembersToGroupResponse(0);
    }

    public final void addNewNotification(InsideNotificationState insideNotificationState) {
        kotlin.jvm.internal.y.i(insideNotificationState, "insideNotificationState");
        try {
            Context appContext = this.mainModule.getAppContext();
            kotlin.jvm.internal.y.g(appContext, "null cannot be cast to non-null type cu.todus.android.ToDusApp");
            ((ToDusApp) appContext).addNotification(insideNotificationState);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (r7 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object allSentMsgsAreMine(java.util.List<java.lang.String> r6, ab.e<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.MainRepository.C10321
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.MainRepository$allSentMsgsAreMine$1 r0 = (cu.todus.android.repositories.MainRepository.C10321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$allSentMsgsAreMine$1 r0 = new cu.todus.android.repositories.MainRepository$allSentMsgsAreMine$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            ua.v.b(r7)
            goto L75
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            ua.v.b(r7)
            goto L5c
        L40:
            ua.v.b(r7)
            cu.todus.android.db.dao.toDus.MessageDao r7 = r5.messageDao
            lb.a r2 = r5.owner
            java.lang.Object r2 = r2.invoke()
            cu.todus.android.data.preferences.Owner r2 = (cu.todus.android.data.preferences.Owner) r2
            java.lang.String r2 = r2.getNameWithDomain()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getMessagesNotMy(r6, r2, r0)
            if (r7 != r1) goto L5c
            goto L74
        L5c:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L7e
            cu.todus.android.db.dao.toDus.MessageDao r7 = r5.messageDao
            java.lang.Object r2 = cb.l.a(r6)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.getNoSent(r6, r0)
            if (r7 != r1) goto L75
        L74:
            return r1
        L75:
            java.lang.Number r7 = (java.lang.Number) r7
            int r6 = r7.intValue()
            if (r6 != 0) goto L7e
            goto L7f
        L7e:
            r4 = 0
        L7f:
            java.lang.Boolean r6 = cb.b.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.allSentMsgsAreMine(java.util.List, ab.e):java.lang.Object");
    }

    public final Object callUpdateMucMemberList(String str, ab.e<? super ua.k0> eVar) {
        GroupsManager groupsManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
            return null;
        }
        Object objAskForReloadMucMemberList = groupsManager.askForReloadMucMemberList(str, eVar);
        return objAskForReloadMucMemberList == bb.b.g() ? objAskForReloadMucMemberList : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r2.blockUser(r7, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00aa, code lost:
    
        if (unBlockUser(r7, r0) == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object changeBlockState(java.lang.String r7, ab.e<? super ua.k0> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cu.todus.android.repositories.MainRepository.C10331
            if (r0 == 0) goto L13
            r0 = r8
            cu.todus.android.repositories.MainRepository$changeBlockState$1 r0 = (cu.todus.android.repositories.MainRepository.C10331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$changeBlockState$1 r0 = new cu.todus.android.repositories.MainRepository$changeBlockState$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$1
            cu.todus.android.data.db.entity.toDus.User r7 = (cu.todus.android.data.db.entity.toDus.User) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto Lad
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.L$1
            cu.todus.android.data.db.entity.toDus.User r7 = (cu.todus.android.data.db.entity.toDus.User) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto L8d
        L4c:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto L64
        L54:
            ua.v.b(r8)
            cu.todus.android.db.dao.toDus.UserDao r8 = r6.userDao
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.getById(r7, r0)
            if (r8 != r1) goto L64
            goto Lac
        L64:
            cu.todus.android.data.db.entity.toDus.User r8 = (cu.todus.android.data.db.entity.toDus.User) r8
            if (r8 == 0) goto L90
            boolean r2 = r8.getBlocked()
            if (r2 != 0) goto L90
            cu.todus.android.xmpp.XMPPDataSource r2 = r6.mXMPPDataSource
            if (r2 == 0) goto Lb0
            cu.todus.android.xmpp.managers.BlocksManager r2 = r2.getBlocksManager()
            if (r2 == 0) goto Lb0
            java.lang.Object r3 = cb.l.a(r7)
            r0.L$0 = r3
            java.lang.Object r8 = cb.l.a(r8)
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r7 = r2.blockUser(r7, r0)
            if (r7 != r1) goto L8d
            goto Lac
        L8d:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        L90:
            if (r8 == 0) goto Lb0
            boolean r2 = r8.getBlocked()
            if (r2 != r5) goto Lb0
            java.lang.Object r2 = cb.l.a(r7)
            r0.L$0 = r2
            java.lang.Object r8 = cb.l.a(r8)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r6.unBlockUser(r7, r0)
            if (r7 != r1) goto Lad
        Lac:
            return r1
        Lad:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        Lb0:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.changeBlockState(java.lang.String, ab.e):java.lang.Object");
    }

    public final void changeOwnerCallMediaState(CallMediaState newCallMediaState) {
        CallManager callManager;
        te.b0 ownerCallMediaState;
        kotlin.jvm.internal.y.i(newCallMediaState, "newCallMediaState");
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null || (ownerCallMediaState = callManager.getOwnerCallMediaState()) == null) {
            return;
        }
        ownerCallMediaState.setValue(newCallMediaState);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0078  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:28:0x00df  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:? A[LOOP:0: B:17:0x0072->B:35:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00df -> B:29:0x00e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object clearHistoryFromRooms(java.util.List<java.lang.String> r13, ab.e<? super ua.k0> r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.clearHistoryFromRooms(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: renamed from: connState, reason: from getter */
    public final te.b0 getConnectionState() {
        return this.connectionState;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    /* JADX WARN: Code duplicated, block: B:34:0x00af  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
    
        if (r14.reloadChannels(r7) == r0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createChannel(java.lang.String r13, android.net.Uri r14, ab.e<? super java.lang.Boolean> r15) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.createChannel(java.lang.String, android.net.Uri, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:42:0x0139  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0134, code lost:
    
        if (r2.update(r4, r11) == r3) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createChannelLink(java.lang.String r32, ab.e<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.createChannelLink(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0106  */
    /* JADX WARN: Code duplicated, block: B:38:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r13v0, types: [cu.todus.android.repositories.MainRepository] */
    public final Object createGroup(String str, List<User> list, Uri uri, ab.e<? super Boolean> eVar) {
        C10371 c10371;
        String strO;
        List<User> list2;
        String str2;
        ?? BooleanValue;
        Uri uri2;
        GroupsManager groupsManager;
        String strFromMUCIdToJID;
        int i10;
        if (eVar instanceof C10371) {
            c10371 = (C10371) eVar;
            int i11 = c10371.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10371.label = i11 - Integer.MIN_VALUE;
            } else {
                c10371 = new C10371(eVar);
            }
        } else {
            c10371 = new C10371(eVar);
        }
        Object objCreateGroup = c10371.result;
        Object objG = bb.b.g();
        int i12 = c10371.label;
        if (i12 != 0) {
            if (i12 == 1) {
                strO = (String) c10371.L$3;
                uri2 = (Uri) c10371.L$2;
                List<User> list3 = (List) c10371.L$1;
                String str3 = (String) c10371.L$0;
                ua.v.b(objCreateGroup);
                list2 = list3;
                str2 = str3;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = c10371.I$0;
                ua.v.b(objCreateGroup);
            }
            BooleanValue = i10;
            return cb.b.a(BooleanValue != 0);
        }
        ua.v.b(objCreateGroup);
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        strO = le.a0.O(string, "-", "", false, 4, null);
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
            list2 = list;
            str2 = str;
            BooleanValue = 0;
            uri2 = uri;
            if (BooleanValue != 0 && uri2 != null) {
                strFromMUCIdToJID = XMPPUtils.INSTANCE.fromMUCIdToJID(strO);
                c10371.L$0 = cb.l.a(str2);
                c10371.L$1 = cb.l.a(list2);
                c10371.L$2 = cb.l.a(uri2);
                c10371.L$3 = cb.l.a(strO);
                c10371.I$0 = BooleanValue == true ? 1 : 0;
                c10371.label = 2;
                if (updateGroupImage(uri2, strFromMUCIdToJID, c10371) != objG) {
                    i10 = BooleanValue == true ? 1 : 0;
                    BooleanValue = i10;
                }
            }
            return cb.b.a(BooleanValue != 0);
        }
        String strFromMUCIdToJID2 = XMPPUtils.INSTANCE.fromMUCIdToJID(strO);
        list2 = list;
        ArrayList arrayList = new ArrayList(va.x.y(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((User) it.next()).getUid());
        }
        c10371.L$0 = cb.l.a(str);
        c10371.L$1 = cb.l.a(list);
        c10371.L$2 = uri;
        c10371.L$3 = strO;
        c10371.label = 1;
        objCreateGroup = groupsManager.createGroup(strFromMUCIdToJID2, str, arrayList, c10371);
        if (objCreateGroup != objG) {
            str2 = str;
            uri2 = uri;
        }
        return objG;
        BooleanValue = ((Boolean) objCreateGroup).booleanValue();
        if (BooleanValue != 0) {
            strFromMUCIdToJID = XMPPUtils.INSTANCE.fromMUCIdToJID(strO);
            c10371.L$0 = cb.l.a(str2);
            c10371.L$1 = cb.l.a(list2);
            c10371.L$2 = cb.l.a(uri2);
            c10371.L$3 = cb.l.a(strO);
            c10371.I$0 = BooleanValue == true ? 1 : 0;
            c10371.label = 2;
            if (updateGroupImage(uri2, strFromMUCIdToJID, c10371) != objG) {
                i10 = BooleanValue == true ? 1 : 0;
                BooleanValue = i10;
            }
            return objG;
        }
        return cb.b.a(BooleanValue != 0);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009d  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object createGroupLink(String str, ab.e<? super Pair<Integer, String>> eVar) {
        C10381 c10381;
        GroupsManager groupsManager;
        String str2;
        String str3;
        int i10;
        Room room;
        RoomDao roomDao;
        Room roomCopy$default;
        String str4;
        Room room2;
        String str5 = str;
        if (eVar instanceof C10381) {
            c10381 = (C10381) eVar;
            int i11 = c10381.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c10381.label = i11 - Integer.MIN_VALUE;
            } else {
                c10381 = new C10381(eVar);
            }
        } else {
            c10381 = new C10381(eVar);
        }
        Object objCreateGroupLinkId = c10381.result;
        Object objG = bb.b.g();
        int i12 = c10381.label;
        if (i12 == 0) {
            ua.v.b(objCreateGroupLinkId);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                c10381.L$0 = str5;
                c10381.label = 1;
                objCreateGroupLinkId = groupsManager.createGroupLinkId(str5, c10381);
                if (objCreateGroupLinkId != objG) {
                }
                return objG;
            }
            return null;
        }
        if (i12 == 1) {
            str5 = (String) c10381.L$0;
            ua.v.b(objCreateGroupLinkId);
        } else {
            if (i12 == 2) {
                i10 = c10381.I$0;
                str2 = (String) c10381.L$1;
                str3 = (String) c10381.L$0;
                ua.v.b(objCreateGroupLinkId);
                room = (Room) objCreateGroupLinkId;
                if (room != null) {
                    roomDao = this.roomDao;
                    Map mapA = w0.A(room.getConfig());
                    mapA.put(Room.CONFIG_SHARE_LINK, str2);
                    ua.k0 k0Var = ua.k0.f43947a;
                    roomCopy$default = Room.copy$default(room, null, null, 0, null, null, mapA, 0L, 0, null, false, false, false, 4063, null);
                    c10381.L$0 = cb.l.a(str3);
                    c10381.L$1 = str2;
                    c10381.L$2 = room;
                    c10381.I$0 = i10;
                    c10381.I$1 = 0;
                    c10381.label = 3;
                    if (roomDao.update(roomCopy$default, c10381) != objG) {
                        str4 = str2;
                        room2 = room;
                    }
                    return objG;
                }
                return null;
            }
            if (i12 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            room2 = (Room) c10381.L$2;
            str4 = (String) c10381.L$1;
            ua.v.b(objCreateGroupLinkId);
        }
        return ua.z.a(cb.b.d(room2.getType()), str4);
        String str6 = (String) objCreateGroupLinkId;
        if (str6 != null) {
            RoomDao roomDao2 = this.roomDao;
            c10381.L$0 = cb.l.a(str5);
            c10381.L$1 = str6;
            c10381.I$0 = 0;
            c10381.label = 2;
            Object roomById = roomDao2.getRoomById(str5, c10381);
            if (roomById != objG) {
                str2 = str6;
                objCreateGroupLinkId = roomById;
                str3 = str5;
                i10 = 0;
                room = (Room) objCreateGroupLinkId;
                if (room != null) {
                    roomDao = this.roomDao;
                    Map mapA2 = w0.A(room.getConfig());
                    mapA2.put(Room.CONFIG_SHARE_LINK, str2);
                    ua.k0 k0Var2 = ua.k0.f43947a;
                    roomCopy$default = Room.copy$default(room, null, null, 0, null, null, mapA2, 0L, 0, null, false, false, false, 4063, null);
                    c10381.L$0 = cb.l.a(str3);
                    c10381.L$1 = str2;
                    c10381.L$2 = room;
                    c10381.I$0 = i10;
                    c10381.I$1 = 0;
                    c10381.label = 3;
                    if (roomDao.update(roomCopy$default, c10381) != objG) {
                        str4 = str2;
                        room2 = room;
                        return ua.z.a(cb.b.d(room2.getType()), str4);
                    }
                }
            }
            return objG;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x0097  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:36:0x009f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
    
        if (r2 == r4) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0123, code lost:
    
        if (r2.insertIfNeedIgnore(r7, r3) == r4) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createRoomIfNeed(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.createRoomIfNeed(java.lang.String, ab.e):java.lang.Object");
    }

    public final te.p0 currentCallState() {
        CallManager callManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null) {
            return null;
        }
        return callManager.getCallState();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013c, code lost:
    
        if (androidx.room.RoomDatabaseKt.withTransaction(r4, r5, r0) == r1) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteMessages(java.util.List<java.lang.String> r14, ab.e<? super ua.k0> r15) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.deleteMessages(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object demoteFromAdmin(String str, String str2, ab.e<? super AdminGroupActionsResponse> eVar) {
        C10411 c10411;
        GroupsManager groupsManager;
        if (eVar instanceof C10411) {
            c10411 = (C10411) eVar;
            int i10 = c10411.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10411.label = i10 - Integer.MIN_VALUE;
            } else {
                c10411 = new C10411(eVar);
            }
        } else {
            c10411 = new C10411(eVar);
        }
        Object objDemoteFromAdmin = c10411.result;
        Object objG = bb.b.g();
        int i11 = c10411.label;
        if (i11 == 0) {
            ua.v.b(objDemoteFromAdmin);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                c10411.L$0 = cb.l.a(str);
                c10411.L$1 = cb.l.a(str2);
                c10411.label = 1;
                objDemoteFromAdmin = groupsManager.demoteFromAdmin(str, str2, c10411);
                if (objDemoteFromAdmin == objG) {
                    return objG;
                }
            }
            return new AdminGroupActionsResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objDemoteFromAdmin);
        AdminGroupActionsResponse adminGroupActionsResponse = (AdminGroupActionsResponse) objDemoteFromAdmin;
        if (adminGroupActionsResponse != null) {
            return adminGroupActionsResponse;
        }
        return new AdminGroupActionsResponse(0);
    }

    public final Object disconnect(ab.e<? super ua.k0> eVar) {
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null) {
            return ua.k0.f43947a;
        }
        Object objDisconnect = xMPPDataSource.disconnect(eVar);
        return objDisconnect == bb.b.g() ? objDisconnect : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        if (r9.updateStatusProgressive(r3, 3, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object displayAllMessages(java.lang.String r8, ab.e<? super ua.k0> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cu.todus.android.repositories.MainRepository.C10421
            if (r0 == 0) goto L13
            r0 = r9
            cu.todus.android.repositories.MainRepository$displayAllMessages$1 r0 = (cu.todus.android.repositories.MainRepository.C10421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$displayAllMessages$1 r0 = new cu.todus.android.repositories.MainRepository$displayAllMessages$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 3
            if (r2 == 0) goto L56
            if (r2 == r4) goto L4e
            if (r2 == r3) goto L40
            if (r2 != r5) goto L38
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            ua.v.b(r9)
            goto Lc5
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$0
            java.lang.String r3 = (java.lang.String) r3
            ua.v.b(r9)
            goto L99
        L4e:
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            ua.v.b(r9)
            goto L76
        L56:
            ua.v.b(r9)
            cu.todus.android.db.dao.toDus.MessageDao r9 = r7.messageDao
            lb.a r2 = r7.owner
            java.lang.Object r2 = r2.invoke()
            cu.todus.android.data.preferences.Owner r2 = (cu.todus.android.data.preferences.Owner) r2
            java.lang.String r2 = r2.getNameWithDomain()
            java.lang.Object r6 = cb.l.a(r8)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r9 = r9.unreadMessageByRoom(r8, r2, r0)
            if (r9 != r1) goto L76
            goto Lc4
        L76:
            r2 = r9
            java.util.List r2 = (java.util.List) r2
            cu.todus.android.xmpp.XMPPDataSource r9 = r7.mXMPPDataSource
            r4 = 0
            if (r9 == 0) goto L9b
            cu.todus.android.xmpp.managers.MessageManager r9 = r9.getMessageManager()
            if (r9 == 0) goto L9b
            java.lang.Object r6 = cb.l.a(r8)
            r0.L$0 = r6
            r0.L$1 = r2
            r0.I$0 = r4
            r0.label = r3
            java.lang.Object r9 = r9.sendDisplayMessage(r2, r0)
            if (r9 != r1) goto L97
            goto Lc4
        L97:
            r3 = r8
            r8 = r4
        L99:
            r4 = r8
            r8 = r3
        L9b:
            cu.todus.android.db.dao.toDus.MessageDao r9 = r7.messageDao
            ke.h r3 = va.g0.g0(r2)
            cu.todus.android.repositories.p0 r6 = new cu.todus.android.repositories.p0
            r6.<init>()
            ke.h r3 = ke.u.Q(r3, r6)
            java.util.List r3 = ke.u.a0(r3)
            java.lang.Object r8 = cb.l.a(r8)
            r0.L$0 = r8
            java.lang.Object r8 = cb.l.a(r2)
            r0.L$1 = r8
            r0.I$0 = r4
            r0.label = r5
            java.lang.Object r8 = r9.updateStatusProgressive(r3, r5, r0)
            if (r8 != r1) goto Lc5
        Lc4:
            return r1
        Lc5:
            ua.k0 r8 = ua.k0.f43947a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.displayAllMessages(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r7.updateStatusProgressive(r2, 3, r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object displaySingleMsgRead(cu.todus.android.data.db.entity.toDus.Message r6, ab.e<? super ua.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.MainRepository.C10431
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.MainRepository$displaySingleMsgRead$1 r0 = (cu.todus.android.repositories.MainRepository.C10431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$displaySingleMsgRead$1 r0 = new cu.todus.android.repositories.MainRepository$displaySingleMsgRead$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r6 = (cu.todus.android.data.db.entity.toDus.Message) r6
            ua.v.b(r7)
            goto L72
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r6 = (cu.todus.android.data.db.entity.toDus.Message) r6
            ua.v.b(r7)
            goto L5c
        L40:
            ua.v.b(r7)
            cu.todus.android.xmpp.XMPPDataSource r7 = r5.mXMPPDataSource
            if (r7 == 0) goto L5c
            cu.todus.android.xmpp.managers.MessageManager r7 = r7.getMessageManager()
            if (r7 == 0) goto L5c
            java.util.List r2 = va.v.e(r6)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.sendDisplayMessage(r2, r0)
            if (r7 != r1) goto L5c
            goto L71
        L5c:
            cu.todus.android.db.dao.toDus.MessageDao r7 = r5.messageDao
            java.lang.String r2 = r6.getId()
            java.lang.Object r6 = cb.l.a(r6)
            r0.L$0 = r6
            r0.label = r3
            r6 = 3
            java.lang.Object r6 = r7.updateStatusProgressive(r2, r6, r0)
            if (r6 != r1) goto L72
        L71:
            return r1
        L72:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.displaySingleMsgRead(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object editToDusId(String str, ab.e<? super EditToDusIdResponse> eVar) {
        C10441 c10441;
        EditToDusIdResponse editToDusIdResponse;
        RosterManager rosterManager;
        String str2;
        String str3 = str;
        if (eVar instanceof C10441) {
            c10441 = (C10441) eVar;
            int i10 = c10441.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10441.label = i10 - Integer.MIN_VALUE;
            } else {
                c10441 = new C10441(eVar);
            }
        } else {
            c10441 = new C10441(eVar);
        }
        Object objEditToDusId = c10441.result;
        Object objG = bb.b.g();
        int i11 = c10441.label;
        if (i11 == 0) {
            ua.v.b(objEditToDusId);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (rosterManager = xMPPDataSource.getRosterManager()) == null) {
                editToDusIdResponse = null;
            } else {
                c10441.L$0 = str3;
                c10441.label = 1;
                objEditToDusId = rosterManager.editToDusId(str3, c10441);
                if (objEditToDusId == objG) {
                    return objG;
                }
            }
            str2 = str3;
            if (editToDusIdResponse != null && editToDusIdResponse.getCode() == 2) {
                this.updateOwner.invoke(Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, null, null, null, null, 0L, str2, 0, 3071, null));
            }
            if (editToDusIdResponse == null) {
                return new EditToDusIdResponse(0);
            }
            return editToDusIdResponse;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str3 = (String) c10441.L$0;
        ua.v.b(objEditToDusId);
        editToDusIdResponse = (EditToDusIdResponse) objEditToDusId;
        str2 = str3;
        if (editToDusIdResponse != null) {
            this.updateOwner.invoke(Owner.copy$default((Owner) this.owner.invoke(), null, null, null, 0, null, null, null, null, null, 0L, str2, 0, 3071, null));
        }
        if (editToDusIdResponse == null) {
            return new EditToDusIdResponse(0);
        }
        return editToDusIdResponse;
    }

    public final void endCall(String uid) {
        CallManager callManager;
        kotlin.jvm.internal.y.i(uid, "uid");
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null && (callManager = xMPPDataSource.getCallManager()) != null) {
            callManager.sendEndCall(uid);
        }
        this.mediaModule.stopRing();
        changeOwnerCallMediaState(new CallMediaState(false, false, false, 7, null));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x0091  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r11 == r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        if (r2.setAffiliationToNone(r10, r11, r0) == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object expelMember(java.lang.String r9, java.lang.String r10, ab.e<? super java.lang.Boolean> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof cu.todus.android.repositories.MainRepository.C10451
            if (r0 == 0) goto L13
            r0 = r11
            cu.todus.android.repositories.MainRepository$expelMember$1 r0 = (cu.todus.android.repositories.MainRepository.C10451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$expelMember$1 r0 = new cu.todus.android.repositories.MainRepository$expelMember$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4c
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r11)
            goto L8f
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            ua.v.b(r11)
            goto L66
        L4c:
            ua.v.b(r11)
            cu.todus.android.xmpp.XMPPDataSource r11 = r8.mXMPPDataSource
            if (r11 == 0) goto L71
            cu.todus.android.xmpp.managers.GroupsManager r11 = r11.getGroupsManager()
            if (r11 == 0) goto L71
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r11 = r11.expelMember(r9, r10, r0)
            if (r11 != r1) goto L66
            goto L8e
        L66:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
            goto L74
        L71:
            r11 = r10
            r10 = r9
            r9 = r3
        L74:
            if (r9 == 0) goto L8f
            cu.todus.android.db.dao.toDus.UserRoomJoinDao r2 = r8.userRoomJoinDao
            java.lang.Object r6 = cb.l.a(r10)
            r0.L$0 = r6
            java.lang.Object r6 = cb.l.a(r11)
            r0.L$1 = r6
            r0.I$0 = r9
            r0.label = r4
            java.lang.Object r10 = r2.setAffiliationToNone(r10, r11, r0)
            if (r10 != r1) goto L8f
        L8e:
            return r1
        L8f:
            if (r9 == 0) goto L92
            r3 = r5
        L92:
            java.lang.Boolean r9 = cb.b.a(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.expelMember(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object expelSubscriber(String str, String str2, ab.e<? super Boolean> eVar) {
        C10461 c10461;
        boolean zBooleanValue;
        ChannelManager channelManager;
        if (eVar instanceof C10461) {
            c10461 = (C10461) eVar;
            int i10 = c10461.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10461.label = i10 - Integer.MIN_VALUE;
            } else {
                c10461 = new C10461(eVar);
            }
        } else {
            c10461 = new C10461(eVar);
        }
        Object objExpelSubscriber = c10461.result;
        Object objG = bb.b.g();
        int i11 = c10461.label;
        if (i11 == 0) {
            ua.v.b(objExpelSubscriber);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
                zBooleanValue = false;
            } else {
                String strO = le.a0.O(str2, "@im.todus.cu", "", false, 4, null);
                c10461.L$0 = cb.l.a(str);
                c10461.L$1 = cb.l.a(str2);
                c10461.label = 1;
                objExpelSubscriber = channelManager.expelSubscriber(strO, str, c10461);
                if (objExpelSubscriber == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objExpelSubscriber);
        zBooleanValue = ((Boolean) objExpelSubscriber).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    public final Object follow(String str, ab.e<? super Boolean> eVar) {
        StatusManager statusManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (statusManager = xMPPDataSource.getStatusManager()) == null) {
            return null;
        }
        return statusManager.follow(str, eVar);
    }

    public final Object followState(String str, ab.e<? super FollowState> eVar) {
        StatusManager statusManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (statusManager = xMPPDataSource.getStatusManager()) == null) {
            return null;
        }
        return statusManager.followState(str, eVar);
    }

    public final void forceReconnect() {
        CoroutineUtilsKt.launchWithContext$default(this.coroutineScope, null, null, new C10471(null), 3, null);
    }

    public final Object getAttachmentById(String str, ab.e<? super Attachment> eVar) {
        return this.attachmentDao.getAttachmentById(str, eVar);
    }

    public final te.h getAttachmentByIdFlow(String attachmentId) {
        kotlin.jvm.internal.y.i(attachmentId, "attachmentId");
        return te.j.g(this.attachmentDao.getAttachmentByIdFlow(attachmentId), new C10491(null));
    }

    public final te.h getAttachmentsFlow(List<String> ids) {
        kotlin.jvm.internal.y.i(ids, "ids");
        return te.j.g(this.attachmentDao.getAttachmentsFlow(ids), new C10501(null));
    }

    public final Pair<Boolean, String> getAuthToken() {
        Owner owner = (Owner) this.owner.invoke();
        return owner.getToken().length() > 0 ? ua.z.a(Boolean.TRUE, owner.getToken()) : ua.z.a(Boolean.FALSE, "");
    }

    public final Object getChannelAdmins(String str, ab.e<? super ArrayList<ChannelAdmin>> eVar) {
        ChannelManager channelManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
            return null;
        }
        Object channelAdmins = channelManager.getChannelAdmins(str, eVar);
        return channelAdmins == bb.b.g() ? channelAdmins : (ArrayList) channelAdmins;
    }

    public final Z17MutableListFlow<String> getChannelsInLoad() {
        return this.channelsInLoad;
    }

    public final DownloadDataSource getDownloadDataSource() {
        return this.downloadDataSource;
    }

    public final Object getFirstUnreadPosition(String str, ab.e<? super Integer> eVar) {
        return this.messageDao.unreadPositionMessageByRoom(str, ((Owner) this.owner.invoke()).getNameWithDomain(), eVar);
    }

    public final Object getFollowerPage(String str, int i10, int i11, ab.e<? super List<FollowPartner>> eVar) {
        StatusManager statusManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (statusManager = xMPPDataSource.getStatusManager()) == null) {
            return null;
        }
        return statusManager.getFollowerPage(str, i10, i11, eVar);
    }

    public final Object getFollowingPage(String str, int i10, int i11, ab.e<? super List<FollowPartner>> eVar) {
        StatusManager statusManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (statusManager = xMPPDataSource.getStatusManager()) == null) {
            return null;
        }
        return statusManager.getFollowingPage(str, i10, i11, eVar);
    }

    public final Object getFriendById(String str, ab.e<? super Friend> eVar) {
        return this.toDusDatabase.contactDao().getFriendById(str, eVar);
    }

    public final Object getFullMsgDataById(String str, ab.e<? super MessageWithPartnerWithRoomWithReactions> eVar) {
        return this.messageDao.fullMsgDataById(str, eVar);
    }

    public final Object getGroupMentionableMembers(String str, ab.e<? super List<RoomMember>> eVar) {
        return this.userRoomJoinDao.groupMembers(str, ((Owner) this.owner.invoke()).getNameWithDomain(), eVar);
    }

    public final PagingSource<Integer, Attachment> getImagesAttachmentsByRoomId(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return this.attachmentDao.getImagesAttachmentsByRoomId(uid);
    }

    public final te.h getIsRinging() {
        String with;
        CallState callState;
        MessageDao messageDao = this.messageDao;
        te.p0 p0VarCurrentCallState = currentCallState();
        if (p0VarCurrentCallState == null || (callState = (CallState) p0VarCurrentCallState.getValue()) == null || (with = callState.getWith()) == null) {
            with = "";
        }
        final te.h hVarG = te.j.g(messageDao.callMsgState(with), new C10511(null));
        return new te.h() { // from class: cu.todus.android.repositories.MainRepository$getIsRinging$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getIsRinging$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ MainRepository this$0;

                /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$getIsRinging$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.repositories.MainRepository$getIsRinging$$inlined$map$1$2", f = "MainRepository.kt", l = {50}, m = "emit", v = 2)
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass1 extends cb.d {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
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

                public AnonymousClass2(te.i iVar, MainRepository mainRepository) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = mainRepository;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // te.i
                public final Object emit(Object obj, ab.e eVar) {
                    AnonymousClass1 anonymousClass1;
                    te.p0 p0VarCurrentCallState;
                    CallState callState;
                    te.p0 p0VarCurrentCallState2;
                    CallState callState2;
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
                        Message message = (Message) obj;
                        Boolean boolA = cb.b.a((((message == null || message.getState() != 2) && (message == null || message.getState() != 3)) || !kotlin.jvm.internal.y.d(message.getUserSender(), ((Owner) this.this$0.getOwner().invoke()).getNameWithDomain()) || (p0VarCurrentCallState = this.this$0.currentCallState()) == null || (callState = (CallState) p0VarCurrentCallState.getValue()) == null || !callState.getOwnerIsCalling() || (p0VarCurrentCallState2 = this.this$0.currentCallState()) == null || (callState2 = (CallState) p0VarCurrentCallState2.getValue()) == null || callState2.getCallIsStarted()) ? false : true);
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(boolA, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ua.v.b(obj2);
                    }
                    return ua.k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarG.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : ua.k0.f43947a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getLast(String str, ab.e<? super ua.k0> eVar) {
        C10521 c10521;
        LastManager lastManager;
        if (eVar instanceof C10521) {
            c10521 = (C10521) eVar;
            int i10 = c10521.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10521.label = i10 - Integer.MIN_VALUE;
            } else {
                c10521 = new C10521(eVar);
            }
        } else {
            c10521 = new C10521(eVar);
        }
        Object last = c10521.result;
        Object objG = bb.b.g();
        int i11 = c10521.label;
        if (i11 == 0) {
            ua.v.b(last);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (lastManager = xMPPDataSource.getLastManager()) != null) {
                c10521.L$0 = cb.l.a(str);
                c10521.label = 1;
                last = lastManager.getLast(str, c10521);
                if (last == objG) {
                    return objG;
                }
            }
            return ua.k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(last);
        LastIQ lastIQ = (LastIQ) last;
        if (lastIQ != null) {
            Long lE = cb.b.e(lastIQ.getLast());
            if (lE.longValue() < 0) {
                lE = null;
            }
            if (lE != null) {
                AppVolatileState.INSTANCE.getInstance().updateUserLast(ua.z.a(lastIQ.getFrom().toString(), cb.b.e(lE.longValue() * 1000)));
            }
        }
        return ua.k0.f43947a;
    }

    public final Object getLinkInfo(String str, ab.e<? super DataWrapper<LinkEntity>> eVar) {
        return this.authDataSource.linkInfo(str, eVar);
    }

    public final PagingSource<Integer, Attachment> getLinksAttachmentsByRoomId(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return this.attachmentDao.getLinksAttachmentsByRoomId(uid);
    }

    public final PagingSource<Integer, MarkerWithPartner> getMarkersFromMsg(String msgId) {
        kotlin.jvm.internal.y.i(msgId, "msgId");
        return this.markerActionDao.getMarkerFromMsg(msgId);
    }

    public final Object getMsgById(String str, ab.e<? super MessageWithPartnerWithReactions> eVar) {
        return this.messageDao.messageWithUserById(str, eVar);
    }

    public final Object getMsgsByIdIn(List<String> list, ab.e<? super List<MessageWithPartnerWithReactions>> eVar) {
        return this.messageDao.getMsgsByIdIn(list, eVar);
    }

    public final te.h getMsgsByRoomId(String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        return te.j.g(this.messageDao.getAllByRoomFlow(id2), new C10531(null));
    }

    public final PagingSource<Integer, MessageWithPartnerWithReactions> getMsgsByRoomIdForPaging(String id2) {
        kotlin.jvm.internal.y.i(id2, "id");
        return this.messageDao.getAllByRoom(id2);
    }

    public final Object getNearPage(int i10, int i11, ab.e<? super List<NearPartner>> eVar) {
        LocationManager locationManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (locationManager = xMPPDataSource.getLocationManager()) == null) {
            return null;
        }
        return locationManager.getNearPage(i10, i11, eVar);
    }

    public final Object getNearStatus(ab.e<? super Boolean> eVar) {
        LocationManager locationManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (locationManager = xMPPDataSource.getLocationManager()) == null) {
            return null;
        }
        Object status = locationManager.getStatus(eVar);
        return status == bb.b.g() ? status : (Boolean) status;
    }

    public final Function1 getNewTokenLive() {
        return this.newTokenLive;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x0117  */
    /* JADX WARN: Code duplicated, block: B:56:0x011f  */
    /* JADX WARN: Code duplicated, block: B:62:0x012f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0135 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:68:0x017d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object getOrCreateGroupLink(String str, ab.e<? super Pair<Integer, String>> eVar) {
        C10541 c10541;
        Room room;
        y0 y0Var;
        String str2;
        Room room2;
        y0 y0Var2;
        GroupsManager groupsManager;
        String str3;
        y0 y0Var3;
        Map<String, String> config;
        int i10;
        String str4;
        y0 y0Var4;
        int i11;
        y0 y0Var5;
        String str5;
        Room room3;
        RoomDao roomDao;
        Room roomCopy$default;
        Room room4;
        Pair pair;
        String str6;
        String str7 = str;
        if (eVar instanceof C10541) {
            c10541 = (C10541) eVar;
            int i12 = c10541.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c10541.label = i12 - Integer.MIN_VALUE;
            } else {
                c10541 = new C10541(eVar);
            }
        } else {
            c10541 = new C10541(eVar);
        }
        Object roomById = c10541.result;
        Object objG = bb.b.g();
        int i13 = c10541.label;
        String str8 = "";
        int i14 = 1;
        if (i13 == 0) {
            ua.v.b(roomById);
            RoomDao roomDao2 = this.roomDao;
            c10541.L$0 = str7;
            c10541.label = 1;
            roomById = roomDao2.getRoomById(str7, c10541);
            if (roomById != objG) {
            }
            return objG;
        }
        if (i13 == 1) {
            str7 = (String) c10541.L$0;
            ua.v.b(roomById);
        } else {
            if (i13 == 2) {
                y0Var3 = (y0) c10541.L$3;
                y0Var = (y0) c10541.L$2;
                room2 = (Room) c10541.L$1;
                str3 = (String) c10541.L$0;
                ua.v.b(roomById);
                str5 = (String) roomById;
                if (str5 == null) {
                    room = room2;
                    y0Var2 = y0Var;
                    y0Var = y0Var3;
                    str7 = str3;
                    str3 = str7;
                    y0Var3 = y0Var;
                    y0Var = y0Var2;
                    room2 = room;
                    str5 = "";
                }
                y0Var3.f36634c = str5;
                String str9 = str3;
                i14 = 0;
                str7 = str9;
                if (le.d0.q0((CharSequence) y0Var.f36634c)) {
                    i10 = i14;
                    str4 = str7;
                    y0Var4 = y0Var;
                    room3 = room2;
                    if (i10 == 0) {
                        roomDao = this.roomDao;
                        Map mapA = w0.A(room3.getConfig());
                        mapA.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                        ua.k0 k0Var = ua.k0.f43947a;
                        roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA, 0L, 0, null, false, false, false, 4063, null);
                        c10541.L$0 = cb.l.a(str4);
                        c10541.L$1 = room3;
                        c10541.L$2 = y0Var4;
                        c10541.L$3 = null;
                        c10541.I$0 = i10;
                        c10541.label = 4;
                        if (roomDao.update(roomCopy$default, c10541) != objG) {
                            room4 = room3;
                        }
                    }
                    if (room3 != null) {
                        return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                    }
                    return null;
                }
                c10541.L$0 = cb.l.a(str7);
                c10541.L$1 = room2;
                c10541.L$2 = y0Var;
                c10541.L$3 = y0Var;
                c10541.I$0 = i14;
                c10541.label = 3;
                roomById = createGroupLink(str7, c10541);
                if (roomById != objG) {
                    int i15 = i14;
                    str4 = str7;
                    i11 = i15;
                    y0Var5 = y0Var;
                    pair = (Pair) roomById;
                    if (pair != null) {
                        str8 = str6;
                    }
                    y0Var.f36634c = str8;
                    i10 = i11;
                    y0Var4 = y0Var5;
                    room3 = room2;
                    if (i10 == 0) {
                        roomDao = this.roomDao;
                        Map mapA2 = w0.A(room3.getConfig());
                        mapA2.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                        ua.k0 k0Var2 = ua.k0.f43947a;
                        roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA2, 0L, 0, null, false, false, false, 4063, null);
                        c10541.L$0 = cb.l.a(str4);
                        c10541.L$1 = room3;
                        c10541.L$2 = y0Var4;
                        c10541.L$3 = null;
                        c10541.I$0 = i10;
                        c10541.label = 4;
                        if (roomDao.update(roomCopy$default, c10541) != objG) {
                            room4 = room3;
                        }
                    }
                    if (room3 != null) {
                        return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                    }
                    return null;
                }
                return objG;
            }
            if (i13 == 3) {
                i11 = c10541.I$0;
                y0Var = (y0) c10541.L$3;
                y0Var5 = (y0) c10541.L$2;
                room2 = (Room) c10541.L$1;
                str4 = (String) c10541.L$0;
                ua.v.b(roomById);
                pair = (Pair) roomById;
                if (pair != null && (str6 = (String) pair.getSecond()) != null) {
                    str8 = str6;
                }
                y0Var.f36634c = str8;
                i10 = i11;
                y0Var4 = y0Var5;
                room3 = room2;
                if (i10 == 0 && room3 != null) {
                    roomDao = this.roomDao;
                    Map mapA3 = w0.A(room3.getConfig());
                    mapA3.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                    ua.k0 k0Var3 = ua.k0.f43947a;
                    roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA3, 0L, 0, null, false, false, false, 4063, null);
                    c10541.L$0 = cb.l.a(str4);
                    c10541.L$1 = room3;
                    c10541.L$2 = y0Var4;
                    c10541.L$3 = null;
                    c10541.I$0 = i10;
                    c10541.label = 4;
                    if (roomDao.update(roomCopy$default, c10541) != objG) {
                        room4 = room3;
                    }
                    return objG;
                }
                if (room3 != null) {
                    return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                }
                return null;
            }
            if (i13 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            y0Var4 = (y0) c10541.L$2;
            room4 = (Room) c10541.L$1;
            ua.v.b(roomById);
        }
        room3 = room4;
        if (room3 != null) {
            return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
        }
        return null;
        room = (Room) roomById;
        y0Var = new y0();
        if (room == null || (config = room.getConfig()) == null || (str2 = config.get(Room.CONFIG_SHARE_LINK)) == null) {
            str2 = "";
        }
        y0Var.f36634c = str2;
        if (le.d0.q0(str2)) {
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
                y0Var2 = y0Var;
                str3 = str7;
                y0Var3 = y0Var;
                y0Var = y0Var2;
                room2 = room;
                str5 = "";
                y0Var3.f36634c = str5;
                String str10 = str3;
                i14 = 0;
                str7 = str10;
                if (le.d0.q0((CharSequence) y0Var.f36634c)) {
                    i10 = i14;
                    str4 = str7;
                    y0Var4 = y0Var;
                    room3 = room2;
                    if (i10 == 0) {
                        roomDao = this.roomDao;
                        Map mapA4 = w0.A(room3.getConfig());
                        mapA4.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                        ua.k0 k0Var4 = ua.k0.f43947a;
                        roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA4, 0L, 0, null, false, false, false, 4063, null);
                        c10541.L$0 = cb.l.a(str4);
                        c10541.L$1 = room3;
                        c10541.L$2 = y0Var4;
                        c10541.L$3 = null;
                        c10541.I$0 = i10;
                        c10541.label = 4;
                        if (roomDao.update(roomCopy$default, c10541) != objG) {
                            room4 = room3;
                            room3 = room4;
                        }
                    }
                    if (room3 != null) {
                        return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                    }
                    return null;
                }
                c10541.L$0 = cb.l.a(str7);
                c10541.L$1 = room2;
                c10541.L$2 = y0Var;
                c10541.L$3 = y0Var;
                c10541.I$0 = i14;
                c10541.label = 3;
                roomById = createGroupLink(str7, c10541);
                if (roomById != objG) {
                    int i16 = i14;
                    str4 = str7;
                    i11 = i16;
                    y0Var5 = y0Var;
                    pair = (Pair) roomById;
                    if (pair != null) {
                        str8 = str6;
                    }
                    y0Var.f36634c = str8;
                    i10 = i11;
                    y0Var4 = y0Var5;
                    room3 = room2;
                    if (i10 == 0) {
                        roomDao = this.roomDao;
                        Map mapA5 = w0.A(room3.getConfig());
                        mapA5.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                        ua.k0 k0Var5 = ua.k0.f43947a;
                        roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA5, 0L, 0, null, false, false, false, 4063, null);
                        c10541.L$0 = cb.l.a(str4);
                        c10541.L$1 = room3;
                        c10541.L$2 = y0Var4;
                        c10541.L$3 = null;
                        c10541.I$0 = i10;
                        c10541.label = 4;
                        if (roomDao.update(roomCopy$default, c10541) != objG) {
                            room4 = room3;
                            room3 = room4;
                        }
                    }
                    if (room3 != null) {
                        return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                    }
                    return null;
                }
            } else {
                c10541.L$0 = str7;
                c10541.L$1 = room;
                c10541.L$2 = y0Var;
                c10541.L$3 = y0Var;
                c10541.I$0 = 1;
                c10541.label = 2;
                Object groupLinkId = groupsManager.getGroupLinkId(str7, c10541);
                if (groupLinkId != objG) {
                    room2 = room;
                    roomById = groupLinkId;
                    str3 = str7;
                    y0Var3 = y0Var;
                    str5 = (String) roomById;
                    if (str5 == null) {
                        room = room2;
                        y0Var2 = y0Var;
                        y0Var = y0Var3;
                        str7 = str3;
                        str3 = str7;
                        y0Var3 = y0Var;
                        y0Var = y0Var2;
                        room2 = room;
                        str5 = "";
                    }
                    y0Var3.f36634c = str5;
                    String str11 = str3;
                    i14 = 0;
                    str7 = str11;
                    if (le.d0.q0((CharSequence) y0Var.f36634c)) {
                        i10 = i14;
                        str4 = str7;
                        y0Var4 = y0Var;
                        room3 = room2;
                        if (i10 == 0) {
                            roomDao = this.roomDao;
                            Map mapA6 = w0.A(room3.getConfig());
                            mapA6.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                            ua.k0 k0Var6 = ua.k0.f43947a;
                            roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA6, 0L, 0, null, false, false, false, 4063, null);
                            c10541.L$0 = cb.l.a(str4);
                            c10541.L$1 = room3;
                            c10541.L$2 = y0Var4;
                            c10541.L$3 = null;
                            c10541.I$0 = i10;
                            c10541.label = 4;
                            if (roomDao.update(roomCopy$default, c10541) != objG) {
                                room4 = room3;
                                room3 = room4;
                            }
                        }
                        if (room3 != null) {
                            return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                        }
                        return null;
                    }
                    c10541.L$0 = cb.l.a(str7);
                    c10541.L$1 = room2;
                    c10541.L$2 = y0Var;
                    c10541.L$3 = y0Var;
                    c10541.I$0 = i14;
                    c10541.label = 3;
                    roomById = createGroupLink(str7, c10541);
                    if (roomById != objG) {
                        int i17 = i14;
                        str4 = str7;
                        i11 = i17;
                        y0Var5 = y0Var;
                        pair = (Pair) roomById;
                        if (pair != null) {
                            str8 = str6;
                        }
                        y0Var.f36634c = str8;
                        i10 = i11;
                        y0Var4 = y0Var5;
                        room3 = room2;
                        if (i10 == 0) {
                            roomDao = this.roomDao;
                            Map mapA7 = w0.A(room3.getConfig());
                            mapA7.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                            ua.k0 k0Var7 = ua.k0.f43947a;
                            roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA7, 0L, 0, null, false, false, false, 4063, null);
                            c10541.L$0 = cb.l.a(str4);
                            c10541.L$1 = room3;
                            c10541.L$2 = y0Var4;
                            c10541.L$3 = null;
                            c10541.I$0 = i10;
                            c10541.label = 4;
                            if (roomDao.update(roomCopy$default, c10541) != objG) {
                                room4 = room3;
                                room3 = room4;
                            }
                        }
                        if (room3 != null) {
                            return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                        }
                        return null;
                    }
                }
            }
        } else {
            room2 = room;
            if (le.d0.q0((CharSequence) y0Var.f36634c)) {
                i10 = i14;
                str4 = str7;
                y0Var4 = y0Var;
                room3 = room2;
                if (i10 == 0) {
                    roomDao = this.roomDao;
                    Map mapA8 = w0.A(room3.getConfig());
                    mapA8.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                    ua.k0 k0Var8 = ua.k0.f43947a;
                    roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA8, 0L, 0, null, false, false, false, 4063, null);
                    c10541.L$0 = cb.l.a(str4);
                    c10541.L$1 = room3;
                    c10541.L$2 = y0Var4;
                    c10541.L$3 = null;
                    c10541.I$0 = i10;
                    c10541.label = 4;
                    if (roomDao.update(roomCopy$default, c10541) != objG) {
                        room4 = room3;
                        room3 = room4;
                    }
                }
                if (room3 != null) {
                    return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                }
                return null;
            }
            c10541.L$0 = cb.l.a(str7);
            c10541.L$1 = room2;
            c10541.L$2 = y0Var;
            c10541.L$3 = y0Var;
            c10541.I$0 = i14;
            c10541.label = 3;
            roomById = createGroupLink(str7, c10541);
            if (roomById != objG) {
                int i18 = i14;
                str4 = str7;
                i11 = i18;
                y0Var5 = y0Var;
                pair = (Pair) roomById;
                if (pair != null) {
                    str8 = str6;
                }
                y0Var.f36634c = str8;
                i10 = i11;
                y0Var4 = y0Var5;
                room3 = room2;
                if (i10 == 0) {
                    roomDao = this.roomDao;
                    Map mapA9 = w0.A(room3.getConfig());
                    mapA9.put(Room.CONFIG_SHARE_LINK, y0Var4.f36634c);
                    ua.k0 k0Var9 = ua.k0.f43947a;
                    roomCopy$default = Room.copy$default(room3, null, null, 0, null, null, mapA9, 0L, 0, null, false, false, false, 4063, null);
                    c10541.L$0 = cb.l.a(str4);
                    c10541.L$1 = room3;
                    c10541.L$2 = y0Var4;
                    c10541.L$3 = null;
                    c10541.I$0 = i10;
                    c10541.label = 4;
                    if (roomDao.update(roomCopy$default, c10541) != objG) {
                        room4 = room3;
                        room3 = room4;
                    }
                }
                if (room3 != null) {
                    return ua.z.a(cb.b.d(room3.getType()), y0Var4.f36634c);
                }
                return null;
            }
        }
        return objG;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    public final te.h getPartnerByIdFlow(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return te.j.g(this.userDao.getPartnerByIdFlow(uid), new C10551(null));
    }

    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Code duplicated, block: B:42:0x015d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0177  */
    /* JADX WARN: Code duplicated, block: B:48:0x017b  */
    /* JADX WARN: Code duplicated, block: B:57:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:60:0x0205  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x016a -> B:67:0x0296). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x020a -> B:67:0x0296). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0281 -> B:66:0x0285). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getPrivacyOfAdd(ab.e<? super ua.y> r32) {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.getPrivacyOfAdd(ab.e):java.lang.Object");
    }

    public final Object getProfilePrivacy(ab.e<? super ua.y> eVar) {
        PrivacyManager privacyManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (privacyManager = xMPPDataSource.getPrivacyManager()) == null) {
            return null;
        }
        Object profilePrivacy = privacyManager.getProfilePrivacy(eVar);
        return profilePrivacy == bb.b.g() ? profilePrivacy : (ua.y) profilePrivacy;
    }

    public final PagingSource<Integer, ReactionWithPartner> getReactionsByEntityId(String entityId) {
        kotlin.jvm.internal.y.i(entityId, "entityId");
        return this.reactionDao.getReactionsByEntityId(entityId);
    }

    public final Function1 getRetryRegister() {
        return this.retryRegister;
    }

    public final Object getRoomById(String str, ab.e<? super Room> eVar) {
        return this.roomDao.getRoomById(str, eVar);
    }

    public final te.h getRoomByIdFlow(String roomId) {
        kotlin.jvm.internal.y.i(roomId, "roomId");
        return te.j.g(this.roomDao.getRoomByIdFlow(roomId), new C10571(null));
    }

    public final Object getRoomInfoByLinkId(String str, boolean z10, ab.e<Object> eVar) {
        GroupsManager groupsManager;
        ChannelManager channelManager;
        if (z10) {
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
                return null;
            }
            Object channelInfoByLinkId = channelManager.getChannelInfoByLinkId(le.d0.K0(str, "@"), eVar);
            return channelInfoByLinkId == bb.b.g() ? channelInfoByLinkId : (ChannelInfo) channelInfoByLinkId;
        }
        XMPPDataSource xMPPDataSource2 = this.mXMPPDataSource;
        if (xMPPDataSource2 == null || (groupsManager = xMPPDataSource2.getGroupsManager()) == null) {
            return null;
        }
        Object groupInfoByLinkId = groupsManager.getGroupInfoByLinkId(str, eVar);
        return groupInfoByLinkId == bb.b.g() ? groupInfoByLinkId : (MucInfo) groupInfoByLinkId;
    }

    public final Function1 getSetError() {
        return this.setError;
    }

    public final Object getSubscribersPage(String str, int i10, int i11, ab.e<? super List<ChannelSubscriber>> eVar) {
        ChannelManager channelManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
            return null;
        }
        return channelManager.getSubscribersPage(str, i10, i11, eVar);
    }

    public final te.b0 getUnableToSend() {
        return this.unableToSend;
    }

    public final Function1 getUpdateOwner() {
        return this.updateOwner;
    }

    public final UploadDataSource getUploadDataSource() {
        return this.uploadDataSource;
    }

    public final UploadStatusDataSource getUploadStatusDataSource() {
        return this.uploadStatusDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUrl(String str, ab.e<? super String> eVar) {
        C10581 c10581;
        UrlManager urlManager;
        if (eVar instanceof C10581) {
            c10581 = (C10581) eVar;
            int i10 = c10581.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10581.label = i10 - Integer.MIN_VALUE;
            } else {
                c10581 = new C10581(eVar);
            }
        } else {
            c10581 = new C10581(eVar);
        }
        Object url = c10581.result;
        Object objG = bb.b.g();
        int i11 = c10581.label;
        if (i11 == 0) {
            ua.v.b(url);
            if (!le.a0.U(str, "https://s3.", false, 2, null) && !le.a0.U(str, "http://s3.", false, 2, null)) {
                return str;
            }
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                return "";
            }
            c10581.L$0 = cb.l.a(str);
            c10581.label = 1;
            url = urlManager.getUrl(str, c10581);
            if (url == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(url);
        }
        String str2 = (String) url;
        return str2 == null ? "" : str2;
    }

    public final Object getUserInDBById(String str, ab.e<? super User> eVar) {
        return this.userDao.getById(str, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getUserInfoByNumber(List<String> list, ab.e<? super User> eVar) {
        C10591 c10591;
        List<String> list2;
        User user;
        User user2;
        Object next;
        String str;
        int i10;
        Iterable iterable;
        int i11;
        RosterManager rosterManager;
        Object obj;
        String str2;
        int i12;
        int i13;
        List<String> list3;
        List<String> list4;
        UserDao userDao;
        Iterable iterable2;
        if (eVar instanceof C10591) {
            c10591 = (C10591) eVar;
            int i14 = c10591.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                c10591.label = i14 - Integer.MIN_VALUE;
            } else {
                c10591 = new C10591(eVar);
            }
        } else {
            c10591 = new C10591(eVar);
        }
        Object userByPossibleNumbers = c10591.result;
        Object objG = bb.b.g();
        int i15 = c10591.label;
        if (i15 == 0) {
            ua.v.b(userByPossibleNumbers);
            UserDao userDao2 = this.userDao;
            c10591.L$0 = list;
            c10591.label = 1;
            userByPossibleNumbers = userDao2.getUserByPossibleNumbers(list, c10591);
            if (userByPossibleNumbers != objG) {
            }
            list2 = list;
            return objG;
        }
        if (i15 == 1) {
            List<String> list5 = (List) c10591.L$0;
            ua.v.b(userByPossibleNumbers);
            list2 = list5;
        } else {
            if (i15 != 2) {
                if (i15 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                User user3 = (User) c10591.L$5;
                ua.v.b(userByPossibleNumbers);
                return user3;
            }
            i12 = c10591.I$1;
            i13 = c10591.I$0;
            str2 = (String) c10591.L$4;
            obj = c10591.L$3;
            Iterable iterable3 = (Iterable) c10591.L$2;
            user = (User) c10591.L$1;
            List<String> list6 = (List) c10591.L$0;
            ua.v.b(userByPossibleNumbers);
            iterable2 = iterable3;
            list3 = list6;
        }
        String str3 = str2;
        i11 = i12;
        list4 = list3;
        i10 = i13;
        str = str3;
        Object obj2 = obj;
        user2 = (User) userByPossibleNumbers;
        next = obj2;
        iterable = iterable2;
        if (user2 != null) {
            userDao = this.userDao;
            c10591.L$0 = cb.l.a(list4);
            c10591.L$1 = cb.l.a(user);
            c10591.L$2 = cb.l.a(iterable);
            c10591.L$3 = cb.l.a(next);
            c10591.L$4 = cb.l.a(str);
            c10591.L$5 = user2;
            c10591.I$0 = i10;
            c10591.I$1 = i11;
            c10591.label = 3;
            if (userDao.insert(user2, c10591) == objG) {
                list2 = list;
                return objG;
            }
        }
        return user2;
        list2 = list;
        user = (User) userByPossibleNumbers;
        if (user != null) {
            return user;
        }
        Iterator<T> it = list2.iterator();
        user2 = null;
        if (it.hasNext()) {
            next = it.next();
            str = (String) next;
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            i10 = 0;
            if (xMPPDataSource == null || (rosterManager = xMPPDataSource.getRosterManager()) == null) {
                iterable = list2;
                i11 = 0;
                list4 = list2;
                if (user2 != null) {
                    userDao = this.userDao;
                    c10591.L$0 = cb.l.a(list4);
                    c10591.L$1 = cb.l.a(user);
                    c10591.L$2 = cb.l.a(iterable);
                    c10591.L$3 = cb.l.a(next);
                    c10591.L$4 = cb.l.a(str);
                    c10591.L$5 = user2;
                    c10591.I$0 = i10;
                    c10591.I$1 = i11;
                    c10591.label = 3;
                    if (userDao.insert(user2, c10591) == objG) {
                    }
                }
            } else {
                c10591.L$0 = cb.l.a(list2);
                c10591.L$1 = cb.l.a(user);
                c10591.L$2 = cb.l.a(list2);
                c10591.L$3 = cb.l.a(next);
                c10591.L$4 = cb.l.a(str);
                c10591.I$0 = 0;
                c10591.I$1 = 0;
                c10591.label = 2;
                Object objReloadUser = rosterManager.reloadUser(str, c10591);
                if (objReloadUser != objG) {
                    List<String> list7 = list2;
                    obj = next;
                    userByPossibleNumbers = objReloadUser;
                    str2 = str;
                    i12 = 0;
                    i13 = 0;
                    list3 = list7;
                    iterable2 = list7;
                    String str4 = str2;
                    i11 = i12;
                    list4 = list3;
                    i10 = i13;
                    str = str4;
                    Object obj3 = obj;
                    user2 = (User) userByPossibleNumbers;
                    next = obj3;
                    iterable = iterable2;
                    if (user2 != null) {
                        userDao = this.userDao;
                        c10591.L$0 = cb.l.a(list4);
                        c10591.L$1 = cb.l.a(user);
                        c10591.L$2 = cb.l.a(iterable);
                        c10591.L$3 = cb.l.a(next);
                        c10591.L$4 = cb.l.a(str);
                        c10591.L$5 = user2;
                        c10591.I$0 = i10;
                        c10591.I$1 = i11;
                        c10591.label = 3;
                        if (userDao.insert(user2, c10591) == objG) {
                        }
                    }
                }
            }
            list2 = list;
            return objG;
        }
        return user2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r7 == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getUserOrReload(java.lang.String r6, ab.e<? super cu.todus.android.data.db.entity.toDus.User> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.MainRepository.C10601
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.MainRepository$getUserOrReload$1 r0 = (cu.todus.android.repositories.MainRepository.C10601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$getUserOrReload$1 r0 = new cu.todus.android.repositories.MainRepository$getUserOrReload$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            cu.todus.android.data.db.entity.toDus.User r6 = (cu.todus.android.data.db.entity.toDus.User) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L78
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L54
        L44:
            ua.v.b(r7)
            cu.todus.android.db.dao.toDus.UserDao r7 = r5.userDao
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getByToDusId(r6, r0)
            if (r7 != r1) goto L54
            goto L77
        L54:
            cu.todus.android.data.db.entity.toDus.User r7 = (cu.todus.android.data.db.entity.toDus.User) r7
            if (r7 == 0) goto L59
            return r7
        L59:
            cu.todus.android.xmpp.XMPPDataSource r2 = r5.mXMPPDataSource
            if (r2 == 0) goto L7b
            cu.todus.android.xmpp.managers.RosterManager r2 = r2.getRosterManager()
            if (r2 == 0) goto L7b
            java.lang.Object r4 = cb.l.a(r6)
            r0.L$0 = r4
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.reloadUser(r6, r0)
            if (r7 != r1) goto L78
        L77:
            return r1
        L78:
            cu.todus.android.data.db.entity.toDus.User r7 = (cu.todus.android.data.db.entity.toDus.User) r7
            return r7
        L7b:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.getUserOrReload(java.lang.String, ab.e):java.lang.Object");
    }

    public final PagingSource<Integer, Attachment> getVideosAttachmentsByRoomId(String uid) {
        kotlin.jvm.internal.y.i(uid, "uid");
        return this.attachmentDao.getVideosAttachmentsByRoomId(uid);
    }

    public final Object hideNearLocation(ab.e<? super Boolean> eVar) {
        LocationManager locationManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (locationManager = xMPPDataSource.getLocationManager()) == null) {
            return null;
        }
        Object objHideNearLocation = locationManager.hideNearLocation(eVar);
        return objHideNearLocation == bb.b.g() ? objHideNearLocation : (Boolean) objHideNearLocation;
    }

    public final ua.k0 initRosterLoad(boolean hasContactsPermission) {
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null) {
            return null;
        }
        xMPPDataSource.runParallelRosterLoad(hasContactsPermission);
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r2.invoke(r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initializeXMPP(boolean r13, ab.e<? super ua.k0> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof cu.todus.android.repositories.MainRepository.C10631
            if (r0 == 0) goto L13
            r0 = r14
            cu.todus.android.repositories.MainRepository$initializeXMPP$1 r0 = (cu.todus.android.repositories.MainRepository.C10631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$initializeXMPP$1 r0 = new cu.todus.android.repositories.MainRepository$initializeXMPP$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3e
            if (r2 == r3) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r13 = r0.L$0
            kotlin.Pair r13 = (kotlin.Pair) r13
            ua.v.b(r14)
            goto L71
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L38:
            boolean r13 = r0.Z$0
            ua.v.b(r14)
            goto L50
        L3e:
            ua.v.b(r14)
            if (r13 == 0) goto L74
            kotlin.jvm.functions.Function1 r14 = r12.newTokenLive
            r0.Z$0 = r13
            r0.label = r3
            java.lang.Object r14 = r14.invoke(r0)
            if (r14 != r1) goto L50
            goto L70
        L50:
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r2 = r14.getFirst()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 != r4) goto L74
            kotlin.jvm.functions.Function1 r2 = r12.retryRegister
            java.lang.Object r14 = cb.l.a(r14)
            r0.L$0 = r14
            r0.Z$0 = r13
            r0.label = r4
            java.lang.Object r13 = r2.invoke(r0)
            if (r13 != r1) goto L71
        L70:
            return r1
        L71:
            ua.k0 r13 = ua.k0.f43947a
            return r13
        L74:
            cu.todus.android.xmpp.XMPPDataSource r13 = r12.mXMPPDataSource
            if (r13 != 0) goto L98
            lb.a r2 = r12.owner
            kotlin.jvm.functions.Function1 r3 = r12.updateOwner
            android.content.Context r1 = r12.context
            te.b0 r4 = r12.connectionState
            cu.todus.android.repositories.MainRepository$initializeXMPP$2 r5 = new cu.todus.android.repositories.MainRepository$initializeXMPP$2
            r5.<init>(r12)
            kotlin.jvm.functions.Function1 r6 = r12.newTokenLive
            cu.todus.android.s3.upload.UploadDataSource r7 = r12.uploadDataSource
            cu.todus.android.s3.upload.UploadStatusDataSource r8 = r12.uploadStatusDataSource
            cu.todus.android.s3.download.DownloadDataSource r9 = r12.downloadDataSource
            boolean r10 = r12.isFirstTime
            cu.z17.views.utils.Z17MutableListFlow<cu.todus.android.webrtc.CallState> r11 = r12.requestingCalls
            cu.todus.android.xmpp.XMPPDataSource r0 = new cu.todus.android.xmpp.XMPPDataSource
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.mXMPPDataSource = r0
        L98:
            ua.k0 r13 = ua.k0.f43947a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.initializeXMPP(boolean, ab.e):java.lang.Object");
    }

    public final boolean isConnected() {
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null) {
            return xMPPDataSource.canSend();
        }
        return false;
    }

    /* JADX INFO: renamed from: isFirstTime, reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    public final Object joinChannel(String str, ab.e<? super JoinResult> eVar) {
        ChannelManager channelManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
            return null;
        }
        Object objSubscribe = channelManager.subscribe(str, eVar);
        return objSubscribe == bb.b.g() ? objSubscribe : (JoinResult) objSubscribe;
    }

    public final Object joinGroup(String str, ab.e<? super JoinResult> eVar) {
        GroupsManager groupsManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
            return null;
        }
        return groupsManager.joinToGroup(str, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (r11 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b9, code lost:
    
        if (r11.update(r4, r0) == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object leaveChannel(java.lang.String r10, ab.e<? super java.lang.Boolean> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cu.todus.android.repositories.MainRepository.C10661
            if (r0 == 0) goto L13
            r0 = r11
            cu.todus.android.repositories.MainRepository$leaveChannel$1 r0 = (cu.todus.android.repositories.MainRepository.C10661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$leaveChannel$1 r0 = new cu.todus.android.repositories.MainRepository$leaveChannel$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r10 = r0.L$1
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r11)
            goto Lbc
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            java.lang.Object r10 = r0.L$1
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            ua.v.b(r11)
            goto L92
        L4c:
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r11)
            goto L6c
        L54:
            ua.v.b(r11)
            cu.todus.android.xmpp.XMPPDataSource r11 = r9.mXMPPDataSource
            if (r11 == 0) goto L72
            cu.todus.android.xmpp.managers.ChannelManager r11 = r11.getChannelManager()
            if (r11 == 0) goto L72
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.leaveChannel(r10, r0)
            if (r11 != r1) goto L6c
            goto Lbb
        L6c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
        L6e:
            r8 = r11
            r11 = r10
            r10 = r8
            goto L74
        L72:
            r11 = 0
            goto L6e
        L74:
            java.lang.Boolean r2 = cb.b.a(r5)
            boolean r2 = kotlin.jvm.internal.y.d(r10, r2)
            if (r2 == 0) goto Lc1
            cu.todus.android.db.dao.toDus.RoomDao r2 = r9.roomDao
            r0.L$0 = r11
            java.lang.Object r6 = cb.l.a(r10)
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r2 = r2.delete(r11, r0)
            if (r2 != r1) goto L91
            goto Lbb
        L91:
            r2 = r11
        L92:
            cu.todus.android.db.dao.toDus.UserRoomJoinDao r11 = r9.userRoomJoinDao
            cu.todus.android.data.db.entity.toDus.UserRoomJoin r4 = new cu.todus.android.data.db.entity.toDus.UserRoomJoin
            lb.a r6 = r9.owner
            java.lang.Object r6 = r6.invoke()
            cu.todus.android.data.preferences.Owner r6 = (cu.todus.android.data.preferences.Owner) r6
            java.lang.String r6 = r6.getNameWithDomain()
            java.lang.String r7 = "none"
            r4.<init>(r6, r2, r7)
            java.lang.Object r2 = cb.l.a(r2)
            r0.L$0 = r2
            java.lang.Object r10 = cb.l.a(r10)
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r10 = r11.update(r4, r0)
            if (r10 != r1) goto Lbc
        Lbb:
            return r1
        Lbc:
            java.lang.Boolean r10 = cb.b.a(r5)
            return r10
        Lc1:
            r10 = 0
            java.lang.Boolean r10 = cb.b.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.leaveChannel(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        if (r10 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        if (r2.update(r5, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object leaveGroup(java.lang.String r9, ab.e<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cu.todus.android.repositories.MainRepository.C10671
            if (r0 == 0) goto L13
            r0 = r10
            cu.todus.android.repositories.MainRepository$leaveGroup$1 r0 = (cu.todus.android.repositories.MainRepository.C10671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$leaveGroup$1 r0 = new cu.todus.android.repositories.MainRepository$leaveGroup$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.L$1
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            ua.v.b(r10)
            goto L94
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            ua.v.b(r10)
            goto L5c
        L44:
            ua.v.b(r10)
            cu.todus.android.xmpp.XMPPDataSource r10 = r8.mXMPPDataSource
            if (r10 == 0) goto L5f
            cu.todus.android.xmpp.managers.GroupsManager r10 = r10.getGroupsManager()
            if (r10 == 0) goto L5f
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = r10.leaveGroup(r9, r0)
            if (r10 != r1) goto L5c
            goto L93
        L5c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L60
        L5f:
            r10 = 0
        L60:
            java.lang.Boolean r2 = cb.b.a(r4)
            boolean r2 = kotlin.jvm.internal.y.d(r10, r2)
            if (r2 == 0) goto L99
            cu.todus.android.db.dao.toDus.UserRoomJoinDao r2 = r8.userRoomJoinDao
            cu.todus.android.data.db.entity.toDus.UserRoomJoin r5 = new cu.todus.android.data.db.entity.toDus.UserRoomJoin
            lb.a r6 = r8.owner
            java.lang.Object r6 = r6.invoke()
            cu.todus.android.data.preferences.Owner r6 = (cu.todus.android.data.preferences.Owner) r6
            java.lang.String r6 = r6.getNameWithDomain()
            java.lang.String r7 = "none"
            r5.<init>(r6, r9, r7)
            java.lang.Object r9 = cb.l.a(r9)
            r0.L$0 = r9
            java.lang.Object r9 = cb.l.a(r10)
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.update(r5, r0)
            if (r9 != r1) goto L94
        L93:
            return r1
        L94:
            java.lang.Boolean r9 = cb.b.a(r4)
            return r9
        L99:
            r9 = 0
            java.lang.Boolean r9 = cb.b.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.leaveGroup(java.lang.String, ab.e):java.lang.Object");
    }

    public final te.p0 mXMPPDataSourceDataState() {
        te.b0 updatingInitialData;
        te.p0 p0VarB;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        return (xMPPDataSource == null || (updatingInitialData = xMPPDataSource.getUpdatingInitialData()) == null || (p0VarB = te.j.b(updatingInitialData)) == null) ? te.r0.a(Boolean.FALSE) : p0VarB;
    }

    public final te.b0 ownerCallMediaState() {
        CallManager callManager;
        te.b0 ownerCallMediaState;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        return (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null || (ownerCallMediaState = callManager.getOwnerCallMediaState()) == null) ? te.r0.a(new CallMediaState(false, false, false, 7, null)) : ownerCallMediaState;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object pinMsgInGroup(String str, String str2, String str3, ab.e<? super ua.k0> eVar) {
        C10691 c10691;
        GroupsManager groupsManager;
        if (eVar instanceof C10691) {
            c10691 = (C10691) eVar;
            int i10 = c10691.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10691.label = i10 - Integer.MIN_VALUE;
            } else {
                c10691 = new C10691(eVar);
            }
        } else {
            c10691 = new C10691(eVar);
        }
        C10691 c10692 = c10691;
        Object objChangeGroupConfigs$default = c10692.result;
        Object objG = bb.b.g();
        int i11 = c10692.label;
        if (i11 == 0) {
            ua.v.b(objChangeGroupConfigs$default);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                HashMap mapK = w0.k(ua.z.a(Room.CONFIG_PINED_MESSAGE, str2), ua.z.a(Room.CONFIG_PINED_MESSAGE_ID, str3));
                c10692.L$0 = cb.l.a(str);
                c10692.L$1 = cb.l.a(str2);
                c10692.L$2 = cb.l.a(str3);
                c10692.label = 1;
                objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager, str, null, null, mapK, c10692, 6, null);
                if (objChangeGroupConfigs$default == objG) {
                    return objG;
                }
            }
            return ua.k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objChangeGroupConfigs$default);
        ((Boolean) objChangeGroupConfigs$default).getClass();
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object promoteToAdmin(String str, String str2, ab.e<? super AdminGroupActionsResponse> eVar) {
        C10701 c10701;
        GroupsManager groupsManager;
        if (eVar instanceof C10701) {
            c10701 = (C10701) eVar;
            int i10 = c10701.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10701.label = i10 - Integer.MIN_VALUE;
            } else {
                c10701 = new C10701(eVar);
            }
        } else {
            c10701 = new C10701(eVar);
        }
        Object objPromoteToAdmin = c10701.result;
        Object objG = bb.b.g();
        int i11 = c10701.label;
        if (i11 == 0) {
            ua.v.b(objPromoteToAdmin);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                c10701.L$0 = cb.l.a(str);
                c10701.L$1 = cb.l.a(str2);
                c10701.label = 1;
                objPromoteToAdmin = groupsManager.promoteToAdmin(str, str2, c10701);
                if (objPromoteToAdmin == objG) {
                    return objG;
                }
            }
            return new AdminGroupActionsResponse(0);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objPromoteToAdmin);
        AdminGroupActionsResponse adminGroupActionsResponse = (AdminGroupActionsResponse) objPromoteToAdmin;
        if (adminGroupActionsResponse != null) {
            return adminGroupActionsResponse;
        }
        return new AdminGroupActionsResponse(0);
    }

    public final Object reactToMsg(String str, String str2, String str3, ab.e<? super ua.k0> eVar) {
        Object objInsert = this.reactionDao.insert(new Reaction(Reaction.INSTANCE.buildId(str2, ((Owner) this.owner.invoke()).getNameWithDomain()), str2, ((Owner) this.owner.invoke()).getNameWithDomain(), str, str3, 1, 0L, 64, null), eVar);
        return objInsert == bb.b.g() ? objInsert : ua.k0.f43947a;
    }

    public final Object rejectCallProcess(String str, ab.e<? super ua.k0> eVar) {
        CallManager callManager;
        String with;
        CallState callState;
        if (kotlin.jvm.internal.y.d(str, InstrumentationResultPrinter.REPORT_KEY_NUM_CURRENT)) {
            te.p0 p0VarCurrentCallState = currentCallState();
            if (p0VarCurrentCallState == null || (callState = (CallState) p0VarCurrentCallState.getValue()) == null || (with = callState.getWith()) == null) {
                with = "";
            }
            endCall(with);
        } else {
            this.notificationManager.cancelNotifications(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(str));
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (callManager = xMPPDataSource.getCallManager()) != null) {
                callManager.sendRejectIQ(str);
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:44:0x0143 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
    
        if (r2 == r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011e, code lost:
    
        if (r6.update(r2, r3) == r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x019c, code lost:
    
        if (r7.insert(r8, r3) == r4) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reloadCard(java.lang.String r27, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.reloadCard(java.lang.String, ab.e):java.lang.Object");
    }

    public final Object reloadChannel(String str, ab.e<? super ua.k0> eVar) {
        ChannelManager channelManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (channelManager = xMPPDataSource.getChannelManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objReloadChannel = channelManager.reloadChannel(str, eVar);
        return objReloadChannel == bb.b.g() ? objReloadChannel : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0094 -> B:25:0x009b). Please report as a decompilation issue!!! */
    public final Object reloadChannelMsgs(List<String> list, String str, ab.e<? super ua.k0> eVar) {
        C10721 c10721;
        String str2;
        C10721 c10722;
        Iterable iterable;
        Iterator it;
        int i10;
        XMPPDataSource xMPPDataSource;
        ChannelManager channelManager;
        Iterable iterable2;
        Iterator it2;
        String str3;
        List<String> list2;
        int i11;
        if (eVar instanceof C10721) {
            c10721 = (C10721) eVar;
            int i12 = c10721.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c10721.label = i12 - Integer.MIN_VALUE;
            } else {
                c10721 = new C10721(eVar);
            }
        } else {
            c10721 = new C10721(eVar);
        }
        Object obj = c10721.result;
        Object objG = bb.b.g();
        int i13 = c10721.label;
        if (i13 == 0) {
            ua.v.b(obj);
            str2 = str;
            c10722 = c10721;
            iterable = list;
            it = list.iterator();
            i10 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                String str4 = (String) next;
                xMPPDataSource = this.mXMPPDataSource;
                if (xMPPDataSource == null && (channelManager = xMPPDataSource.getChannelManager()) != null) {
                    c10722.L$0 = cb.l.a(list);
                    c10722.L$1 = str2;
                    c10722.L$2 = cb.l.a(iterable);
                    c10722.L$3 = it;
                    c10722.L$4 = cb.l.a(next);
                    c10722.L$5 = cb.l.a(str4);
                    c10722.I$0 = i10;
                    c10722.I$1 = 0;
                    c10722.label = 1;
                    if (channelManager.reloadPubById(str2, str4, c10722) == objG) {
                        return objG;
                    }
                    String str5 = str2;
                    iterable2 = iterable;
                    it2 = it;
                    c10721 = c10722;
                    str3 = str5;
                    list2 = list;
                    i11 = i10;
                }
            }
            return ua.k0.f43947a;
        }
        if (i13 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i11 = c10721.I$0;
        it2 = (Iterator) c10721.L$3;
        iterable2 = (Iterable) c10721.L$2;
        str3 = (String) c10721.L$1;
        list2 = (List) c10721.L$0;
        ua.v.b(obj);
        C10721 c10723 = c10721;
        it = it2;
        iterable = iterable2;
        str2 = str3;
        c10722 = c10723;
        i10 = i11;
        list = list2;
        while (it.hasNext()) {
            Object next2 = it.next();
            String str6 = (String) next2;
            xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null) {
            }
        }
        return ua.k0.f43947a;
    }

    public final Object reloadGroup(String str, ab.e<? super ua.k0> eVar) throws SinglediException {
        GroupsManager groupsManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objReloadGroup = groupsManager.reloadGroup(str, eVar);
        return objReloadGroup == bb.b.g() ? objReloadGroup : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reloadUser(String str, ab.e<? super User> eVar) {
        C10731 c10731;
        RosterManager rosterManager;
        if (eVar instanceof C10731) {
            c10731 = (C10731) eVar;
            int i10 = c10731.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10731.label = i10 - Integer.MIN_VALUE;
            } else {
                c10731 = new C10731(eVar);
            }
        } else {
            c10731 = new C10731(eVar);
        }
        Object objReloadUser = c10731.result;
        Object objG = bb.b.g();
        int i11 = c10731.label;
        if (i11 == 0) {
            ua.v.b(objReloadUser);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (rosterManager = xMPPDataSource.getRosterManager()) == null) {
                return null;
            }
            c10731.L$0 = cb.l.a(str);
            c10731.label = 1;
            objReloadUser = rosterManager.reloadUser(str, c10731);
            if (objReloadUser == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objReloadUser);
        }
        return (User) objReloadUser;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00be  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object removeGroupImage(String str, ab.e<? super Boolean> eVar) {
        C10741 c10741;
        String str2;
        Boolean bool;
        GroupsManager groupsManager;
        String str3;
        XMPPDataSource xMPPDataSource;
        GroupsManager groupsManager2;
        Object objChangeGroupConfigs$default;
        Boolean bool2;
        boolean zBooleanValue;
        boolean zBooleanValue2;
        if (eVar instanceof C10741) {
            c10741 = (C10741) eVar;
            int i10 = c10741.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10741.label = i10 - Integer.MIN_VALUE;
            } else {
                c10741 = new C10741(eVar);
            }
        } else {
            c10741 = new C10741(eVar);
        }
        C10741 c10742 = c10741;
        Object objChangeGroupConfigs$default2 = c10742.result;
        Object objG = bb.b.g();
        int i11 = c10742.label;
        Boolean bool3 = null;
        boolean z10 = false;
        if (i11 != 0) {
            if (i11 == 1) {
                str3 = (String) c10742.L$0;
                ua.v.b(objChangeGroupConfigs$default2);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bool2 = (Boolean) c10742.L$1;
                ua.v.b(objChangeGroupConfigs$default2);
            }
            bool3 = (Boolean) objChangeGroupConfigs$default2;
            bool = bool2;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                if (bool3 != null) {
                    zBooleanValue2 = bool3.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
                if (zBooleanValue2) {
                    z10 = true;
                }
            }
            return cb.b.a(z10);
        }
        ua.v.b(objChangeGroupConfigs$default2);
        XMPPDataSource xMPPDataSource2 = this.mXMPPDataSource;
        if (xMPPDataSource2 == null || (groupsManager = xMPPDataSource2.getGroupsManager()) == null) {
            str2 = str;
            bool = null;
            xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager2 = xMPPDataSource.getGroupsManager()) != null) {
                HashMap mapK = w0.k(ua.z.a(Room.CONFIG_PICTURE_THUMBNAIL, ""));
                c10742.L$0 = cb.l.a(str2);
                c10742.L$1 = bool;
                c10742.label = 2;
                objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager2, str2, null, null, mapK, c10742, 6, null);
                if (objChangeGroupConfigs$default != objG) {
                    bool2 = bool;
                    objChangeGroupConfigs$default2 = objChangeGroupConfigs$default;
                    bool3 = (Boolean) objChangeGroupConfigs$default2;
                    bool = bool2;
                }
            }
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                if (bool3 != null) {
                    zBooleanValue2 = bool3.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
                if (zBooleanValue2) {
                    z10 = true;
                }
            }
            return cb.b.a(z10);
        }
        HashMap mapK2 = w0.k(ua.z.a(Room.CONFIG_PICTURE, ""));
        c10742.L$0 = str;
        c10742.label = 1;
        objChangeGroupConfigs$default2 = GroupsManager.changeGroupConfigs$default(groupsManager, str, null, null, mapK2, c10742, 6, null);
        if (objChangeGroupConfigs$default2 != objG) {
            str3 = str;
        }
        return objG;
        bool = (Boolean) objChangeGroupConfigs$default2;
        str2 = str3;
        xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null) {
            HashMap mapK3 = w0.k(ua.z.a(Room.CONFIG_PICTURE_THUMBNAIL, ""));
            c10742.L$0 = cb.l.a(str2);
            c10742.L$1 = bool;
            c10742.label = 2;
            objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager2, str2, null, null, mapK3, c10742, 6, null);
            if (objChangeGroupConfigs$default != objG) {
                bool2 = bool;
                objChangeGroupConfigs$default2 = objChangeGroupConfigs$default;
                bool3 = (Boolean) objChangeGroupConfigs$default2;
                bool = bool2;
            }
            return objG;
        }
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            if (bool3 != null) {
                zBooleanValue2 = bool3.booleanValue();
            } else {
                zBooleanValue2 = false;
            }
            if (zBooleanValue2) {
                z10 = true;
            }
        }
        return cb.b.a(z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object removeProfileImage(ab.e<? super Boolean> eVar) {
        C10751 c10751;
        boolean zBooleanValue;
        ProfileManager profileManager;
        if (eVar instanceof C10751) {
            c10751 = (C10751) eVar;
            int i10 = c10751.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10751.label = i10 - Integer.MIN_VALUE;
            } else {
                c10751 = new C10751(eVar);
            }
        } else {
            c10751 = new C10751(eVar);
        }
        Object objRemoveProfileImage = c10751.result;
        Object objG = bb.b.g();
        int i11 = c10751.label;
        if (i11 == 0) {
            ua.v.b(objRemoveProfileImage);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (profileManager = xMPPDataSource.getProfileManager()) == null) {
                zBooleanValue = false;
            } else {
                c10751.label = 1;
                objRemoveProfileImage = profileManager.removeProfileImage(c10751);
                if (objRemoveProfileImage == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objRemoveProfileImage);
        zBooleanValue = ((Boolean) objRemoveProfileImage).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:31:0x008b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        if (r2.loadChannelMsgsBefore(r7, r4, r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestChannelMessages(final java.lang.String r7, ab.e<? super ua.k0> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cu.todus.android.repositories.MainRepository.C10761
            if (r0 == 0) goto L13
            r0 = r8
            cu.todus.android.repositories.MainRepository$requestChannelMessages$1 r0 = (cu.todus.android.repositories.MainRepository.C10761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$requestChannelMessages$1 r0 = new cu.todus.android.repositories.MainRepository$requestChannelMessages$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.L$1
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto L9e
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto L7d
        L47:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            ua.v.b(r8)
            goto L63
        L4f:
            ua.v.b(r8)
            cu.z17.views.utils.Z17MutableListFlow<java.lang.String> r8 = r6.channelsInLoad
            te.h r8 = r8.getValue()
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = te.j.x(r8, r0)
            if (r8 != r1) goto L63
            goto L9d
        L63:
            java.util.List r8 = (java.util.List) r8
            boolean r8 = r8.contains(r7)
            if (r8 != 0) goto La8
            cu.z17.views.utils.Z17MutableListFlow<java.lang.String> r8 = r6.channelsInLoad
            r8.add(r7)
            cu.todus.android.db.dao.toDus.MessageDao r8 = r6.messageDao
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.getFirstMessageOfChannel(r7, r0)
            if (r8 != r1) goto L7d
            goto L9d
        L7d:
            cu.todus.android.data.db.entity.toDus.Message r8 = (cu.todus.android.data.db.entity.toDus.Message) r8
            cu.todus.android.xmpp.XMPPDataSource r2 = r6.mXMPPDataSource
            if (r2 == 0) goto L9e
            if (r8 == 0) goto L8b
            java.lang.String r4 = r8.getPublId()
            if (r4 != 0) goto L8d
        L8b:
            java.lang.String r4 = "9223372036854775807"
        L8d:
            r0.L$0 = r7
            java.lang.Object r8 = cb.l.a(r8)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r2.loadChannelMsgsBefore(r7, r4, r0)
            if (r8 != r1) goto L9e
        L9d:
            return r1
        L9e:
            cu.z17.views.utils.Z17MutableListFlow<java.lang.String> r8 = r6.channelsInLoad
            cu.todus.android.repositories.o0 r0 = new cu.todus.android.repositories.o0
            r0.<init>()
            r8.removeAll(r0)
        La8:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.requestChannelMessages(java.lang.String, ab.e):java.lang.Object");
    }

    public final Object requestUpdateInfo(ab.e<? super GetUpdateInfoIQ> eVar) {
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null) {
            return xMPPDataSource.requestUpdateInfo(eVar);
        }
        return null;
    }

    public final Z17MutableListFlow<CallState> requestingCalls() {
        return this.requestingCalls;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (r6 == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object retryUnsentStatuses(ab.e<? super ua.k0> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cu.todus.android.repositories.MainRepository.C10781
            if (r0 == 0) goto L13
            r0 = r6
            cu.todus.android.repositories.MainRepository$retryUnsentStatuses$1 r0 = (cu.todus.android.repositories.MainRepository.C10781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$retryUnsentStatuses$1 r0 = new cu.todus.android.repositories.MainRepository$retryUnsentStatuses$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ua.v.b(r6)
            goto L69
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            ua.v.b(r6)
            goto L52
        L38:
            ua.v.b(r6)
            cu.todus.android.db.dao.toDus.StatusDao r6 = r5.statusDao
            lb.a r2 = r5.owner
            java.lang.Object r2 = r2.invoke()
            cu.todus.android.data.preferences.Owner r2 = (cu.todus.android.data.preferences.Owner) r2
            java.lang.String r2 = r2.getNameWithDomain()
            r0.label = r4
            java.lang.Object r6 = r6.prepareToSendStatusWithError(r2, r0)
            if (r6 != r1) goto L52
            goto L68
        L52:
            cu.todus.android.db.dao.toDus.StatusDao r6 = r5.statusDao
            lb.a r2 = r5.owner
            java.lang.Object r2 = r2.invoke()
            cu.todus.android.data.preferences.Owner r2 = (cu.todus.android.data.preferences.Owner) r2
            java.lang.String r2 = r2.getNameWithDomain()
            r0.label = r3
            java.lang.Object r6 = r6.getWaitingForUploadStatuses(r2, r0)
            if (r6 != r1) goto L69
        L68:
            return r1
        L69:
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
        L6f:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L81
            java.lang.Object r0 = r6.next()
            java.lang.String r0 = (java.lang.String) r0
            cu.todus.android.s3.upload.UploadStatusDataSource r1 = r5.uploadStatusDataSource
            r1.putStatusInUploadQueue(r0)
            goto L6f
        L81:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.retryUnsentStatuses(ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r1.updateLastMessage(r2, r3, r4, r6) == r0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveMsg(cu.todus.android.data.db.entity.toDus.Message r8, ab.e<? super ua.k0> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cu.todus.android.repositories.MainRepository.C10791
            if (r0 == 0) goto L14
            r0 = r9
            cu.todus.android.repositories.MainRepository$saveMsg$1 r0 = (cu.todus.android.repositories.MainRepository.C10791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cu.todus.android.repositories.MainRepository$saveMsg$1 r0 = new cu.todus.android.repositories.MainRepository$saveMsg$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L45
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r8 = r6.L$0
            cu.todus.android.data.db.entity.toDus.Message r8 = (cu.todus.android.data.db.entity.toDus.Message) r8
            ua.v.b(r9)     // Catch: java.lang.Exception -> L32
            goto L76
        L32:
            r0 = move-exception
            r8 = r0
            goto L73
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r6.L$0
            cu.todus.android.data.db.entity.toDus.Message r8 = (cu.todus.android.data.db.entity.toDus.Message) r8
            ua.v.b(r9)     // Catch: java.lang.Exception -> L32
            goto L55
        L45:
            ua.v.b(r9)
            cu.todus.android.db.dao.toDus.MessageDao r9 = r7.messageDao     // Catch: java.lang.Exception -> L32
            r6.L$0 = r8     // Catch: java.lang.Exception -> L32
            r6.label = r3     // Catch: java.lang.Exception -> L32
            java.lang.Object r9 = r9.insert(r8, r6)     // Catch: java.lang.Exception -> L32
            if (r9 != r0) goto L55
            goto L72
        L55:
            cu.todus.android.db.dao.toDus.RoomDao r1 = r7.roomDao     // Catch: java.lang.Exception -> L32
            r9 = r2
            java.lang.String r2 = r8.getRoomId()     // Catch: java.lang.Exception -> L32
            java.lang.String r3 = r8.getId()     // Catch: java.lang.Exception -> L32
            long r4 = r8.getCreateAt()     // Catch: java.lang.Exception -> L32
            java.lang.Object r8 = cb.l.a(r8)     // Catch: java.lang.Exception -> L32
            r6.L$0 = r8     // Catch: java.lang.Exception -> L32
            r6.label = r9     // Catch: java.lang.Exception -> L32
            java.lang.Object r8 = r1.updateLastMessage(r2, r3, r4, r6)     // Catch: java.lang.Exception -> L32
            if (r8 != r0) goto L76
        L72:
            return r0
        L73:
            r8.printStackTrace()
        L76:
            ua.k0 r8 = ua.k0.f43947a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.saveMsg(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    public final void savePushToken(String it) {
        kotlin.jvm.internal.y.i(it, "it");
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null) {
            xMPPDataSource.sendFirebaseToken(it);
        }
    }

    public final Object sendAppClose(ab.e<? super ua.k0> eVar) {
        PresenceManager presenceManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (presenceManager = xMPPDataSource.getPresenceManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objSendAppClose = presenceManager.sendAppClose(eVar);
        return objSendAppClose == bb.b.g() ? objSendAppClose : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0137  */
    /* JADX WARN: Code duplicated, block: B:35:0x0173  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendAudios(String str, List<? extends File> list, String str2, String str3, ab.e<? super ua.k0> eVar) {
        C10801 c10801;
        List<? extends File> list2;
        String str4;
        String str5;
        String str6;
        String str7;
        long j10;
        String str8;
        String str9;
        Object objG;
        List<? extends File> list3;
        String str10;
        String str11;
        String str12;
        ToDusDatabase toDusDatabase;
        String str13;
        C10812 c10812;
        String str14;
        String str15;
        String str16 = str;
        if (eVar instanceof C10801) {
            c10801 = (C10801) eVar;
            int i10 = c10801.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10801.label = i10 - Integer.MIN_VALUE;
            } else {
                c10801 = new C10801(eVar);
            }
        } else {
            c10801 = new C10801(eVar);
        }
        C10801 c10802 = c10801;
        Object obj = c10802.result;
        Object objG2 = bb.b.g();
        int i11 = c10802.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10802.L$0 = str16;
            list2 = list;
            c10802.L$1 = list2;
            str4 = str2;
            c10802.L$2 = str4;
            str5 = str3;
            c10802.L$3 = str5;
            c10802.label = 1;
            if (createRoomIfNeed(str16, c10802) != objG2) {
            }
            return objG2;
        }
        if (i11 == 1) {
            String str17 = (String) c10802.L$3;
            str4 = (String) c10802.L$2;
            List<? extends File> list4 = (List) c10802.L$1;
            String str18 = (String) c10802.L$0;
            ua.v.b(obj);
            str5 = str17;
            str16 = str18;
            list2 = list4;
        } else {
            if (i11 == 2) {
                j10 = c10802.J$0;
                str7 = (String) c10802.L$4;
                str9 = (String) c10802.L$3;
                str8 = (String) c10802.L$2;
                List<? extends File> list5 = (List) c10802.L$1;
                String str19 = (String) c10802.L$0;
                ua.v.b(obj);
                list2 = list5;
                str6 = str19;
                pe.k0 k0VarB = d1.b();
                MainRepository$sendAudios$processedAudios$1 mainRepository$sendAudios$processedAudios$1 = new MainRepository$sendAudios$processedAudios$1(list2, this, null);
                c10802.L$0 = str6;
                c10802.L$1 = cb.l.a(list2);
                c10802.L$2 = str8;
                c10802.L$3 = str9;
                c10802.L$4 = str7;
                c10802.J$0 = j10;
                c10802.label = 3;
                objG = pe.i.g(k0VarB, mainRepository$sendAudios$processedAudios$1, c10802);
                if (objG != objG2) {
                    list3 = list2;
                    str10 = str7;
                    str11 = str8;
                    str12 = str9;
                    List list6 = (List) objG;
                    toDusDatabase = this.toDusDatabase;
                    str13 = str6;
                    long j11 = j10;
                    String str20 = str11;
                    c10812 = new C10812(str10, j11, str13, str20, this, str12, list6, null);
                    c10802.L$0 = str13;
                    c10802.L$1 = cb.l.a(list3);
                    c10802.L$2 = cb.l.a(str20);
                    c10802.L$3 = cb.l.a(str12);
                    c10802.L$4 = str10;
                    c10802.L$5 = cb.l.a(list6);
                    c10802.J$0 = j11;
                    c10802.label = 4;
                    if (RoomDatabaseKt.withTransaction(toDusDatabase, c10812, c10802) != objG2) {
                        str14 = str10;
                        str15 = str13;
                    }
                }
                return objG2;
            }
            if (i11 == 3) {
                long j12 = c10802.J$0;
                String str21 = (String) c10802.L$4;
                String str22 = (String) c10802.L$3;
                String str23 = (String) c10802.L$2;
                List<? extends File> list7 = (List) c10802.L$1;
                str6 = (String) c10802.L$0;
                ua.v.b(obj);
                list3 = list7;
                str12 = str22;
                str10 = str21;
                str11 = str23;
                j10 = j12;
                objG = obj;
                List list8 = (List) objG;
                toDusDatabase = this.toDusDatabase;
                str13 = str6;
                long j13 = j10;
                String str24 = str11;
                c10812 = new C10812(str10, j13, str13, str24, this, str12, list8, null);
                c10802.L$0 = str13;
                c10802.L$1 = cb.l.a(list3);
                c10802.L$2 = cb.l.a(str24);
                c10802.L$3 = cb.l.a(str12);
                c10802.L$4 = str10;
                c10802.L$5 = cb.l.a(list8);
                c10802.J$0 = j13;
                c10802.label = 4;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10812, c10802) != objG2) {
                    str14 = str10;
                    str15 = str13;
                }
                return objG2;
            }
            if (i11 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str14 = (String) c10802.L$4;
            str15 = (String) c10802.L$0;
            ua.v.b(obj);
        }
        this.uploadDataSource.enqueueUpload(str14);
        this.appVolatileState.onNewMessage(str15);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10802.L$0 = str16;
        c10802.L$1 = list2;
        c10802.L$2 = str4;
        c10802.L$3 = str5;
        c10802.L$4 = strO;
        c10802.J$0 = time;
        c10802.label = 2;
        if (insertDateMsg(str16, time, c10802) != objG2) {
            str6 = str16;
            str7 = strO;
            j10 = time;
            String str25 = str5;
            str8 = str4;
            str9 = str25;
            pe.k0 k0VarB2 = d1.b();
            MainRepository$sendAudios$processedAudios$1 mainRepository$sendAudios$processedAudios$2 = new MainRepository$sendAudios$processedAudios$1(list2, this, null);
            c10802.L$0 = str6;
            c10802.L$1 = cb.l.a(list2);
            c10802.L$2 = str8;
            c10802.L$3 = str9;
            c10802.L$4 = str7;
            c10802.J$0 = j10;
            c10802.label = 3;
            objG = pe.i.g(k0VarB2, mainRepository$sendAudios$processedAudios$2, c10802);
            if (objG != objG2) {
                list3 = list2;
                str10 = str7;
                str11 = str8;
                str12 = str9;
                List list9 = (List) objG;
                toDusDatabase = this.toDusDatabase;
                str13 = str6;
                long j14 = j10;
                String str26 = str11;
                c10812 = new C10812(str10, j14, str13, str26, this, str12, list9, null);
                c10802.L$0 = str13;
                c10802.L$1 = cb.l.a(list3);
                c10802.L$2 = cb.l.a(str26);
                c10802.L$3 = cb.l.a(str12);
                c10802.L$4 = str10;
                c10802.L$5 = cb.l.a(list9);
                c10802.J$0 = j14;
                c10802.label = 4;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10812, c10802) != objG2) {
                    str14 = str10;
                    str15 = str13;
                    this.uploadDataSource.enqueueUpload(str14);
                    this.appVolatileState.onNewMessage(str15);
                    return ua.k0.f43947a;
                }
            }
        }
        return objG2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendContact(String str, ContactContent contactContent, String str2, ab.e<? super ua.k0> eVar) {
        C10821 c10821;
        ContactContent contactContent2;
        String str3;
        String str4;
        long j10;
        ContactContent contactContent3;
        String str5;
        String str6;
        ToDusDatabase toDusDatabase;
        C10832 c10832;
        String str7;
        String str8 = str;
        if (eVar instanceof C10821) {
            c10821 = (C10821) eVar;
            int i10 = c10821.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10821.label = i10 - Integer.MIN_VALUE;
            } else {
                c10821 = new C10821(eVar);
            }
        } else {
            c10821 = new C10821(eVar);
        }
        C10821 c10822 = c10821;
        Object obj = c10822.result;
        Object objG = bb.b.g();
        int i11 = c10822.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10822.L$0 = str8;
            contactContent2 = contactContent;
            c10822.L$1 = contactContent2;
            str3 = str2;
            c10822.L$2 = str3;
            c10822.label = 1;
            if (createRoomIfNeed(str8, c10822) != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            String str9 = (String) c10822.L$2;
            ContactContent contactContent4 = (ContactContent) c10822.L$1;
            String str10 = (String) c10822.L$0;
            ua.v.b(obj);
            contactContent2 = contactContent4;
            str3 = str9;
            str8 = str10;
        } else {
            if (i11 == 2) {
                j10 = c10822.J$0;
                String str11 = (String) c10822.L$3;
                String str12 = (String) c10822.L$2;
                contactContent3 = (ContactContent) c10822.L$1;
                String str13 = (String) c10822.L$0;
                ua.v.b(obj);
                str4 = str12;
                str6 = str13;
                str5 = str11;
                toDusDatabase = this.toDusDatabase;
                c10832 = new C10832(str5, j10, str6, this, contactContent3, str4, null);
                c10822.L$0 = str6;
                c10822.L$1 = cb.l.a(contactContent3);
                c10822.L$2 = cb.l.a(str4);
                c10822.L$3 = cb.l.a(str5);
                c10822.J$0 = j10;
                c10822.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10832, c10822) != objG) {
                    str7 = str6;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str7 = (String) c10822.L$0;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str7);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10822.L$0 = str8;
        c10822.L$1 = contactContent2;
        c10822.L$2 = str3;
        c10822.L$3 = strO;
        c10822.J$0 = time;
        c10822.label = 2;
        if (insertDateMsg(str8, time, c10822) != objG) {
            str4 = str3;
            j10 = time;
            contactContent3 = contactContent2;
            str5 = strO;
            str6 = str8;
            toDusDatabase = this.toDusDatabase;
            c10832 = new C10832(str5, j10, str6, this, contactContent3, str4, null);
            c10822.L$0 = str6;
            c10822.L$1 = cb.l.a(contactContent3);
            c10822.L$2 = cb.l.a(str4);
            c10822.L$3 = cb.l.a(str5);
            c10822.J$0 = j10;
            c10822.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10832, c10822) != objG) {
                str7 = str6;
                this.appVolatileState.onNewMessage(str7);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendEvent(String str, EventContent eventContent, String str2, ab.e<? super ua.k0> eVar) {
        C10841 c10841;
        EventContent eventContent2;
        String str3;
        String str4;
        long j10;
        EventContent eventContent3;
        String str5;
        String str6;
        ToDusDatabase toDusDatabase;
        C10852 c10852;
        String str7;
        String str8 = str;
        if (eVar instanceof C10841) {
            c10841 = (C10841) eVar;
            int i10 = c10841.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10841.label = i10 - Integer.MIN_VALUE;
            } else {
                c10841 = new C10841(eVar);
            }
        } else {
            c10841 = new C10841(eVar);
        }
        C10841 c10842 = c10841;
        Object obj = c10842.result;
        Object objG = bb.b.g();
        int i11 = c10842.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10842.L$0 = str8;
            eventContent2 = eventContent;
            c10842.L$1 = eventContent2;
            str3 = str2;
            c10842.L$2 = str3;
            c10842.label = 1;
            if (createRoomIfNeed(str8, c10842) != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            String str9 = (String) c10842.L$2;
            EventContent eventContent4 = (EventContent) c10842.L$1;
            String str10 = (String) c10842.L$0;
            ua.v.b(obj);
            eventContent2 = eventContent4;
            str3 = str9;
            str8 = str10;
        } else {
            if (i11 == 2) {
                j10 = c10842.J$0;
                String str11 = (String) c10842.L$3;
                String str12 = (String) c10842.L$2;
                eventContent3 = (EventContent) c10842.L$1;
                String str13 = (String) c10842.L$0;
                ua.v.b(obj);
                str4 = str12;
                str6 = str13;
                str5 = str11;
                toDusDatabase = this.toDusDatabase;
                c10852 = new C10852(str5, j10, str6, this, eventContent3, str4, null);
                c10842.L$0 = str6;
                c10842.L$1 = cb.l.a(eventContent3);
                c10842.L$2 = cb.l.a(str4);
                c10842.L$3 = cb.l.a(str5);
                c10842.J$0 = j10;
                c10842.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10852, c10842) != objG) {
                    str7 = str6;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str7 = (String) c10842.L$0;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str7);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10842.L$0 = str8;
        c10842.L$1 = eventContent2;
        c10842.L$2 = str3;
        c10842.L$3 = strO;
        c10842.J$0 = time;
        c10842.label = 2;
        if (insertDateMsg(str8, time, c10842) != objG) {
            str4 = str3;
            j10 = time;
            eventContent3 = eventContent2;
            str5 = strO;
            str6 = str8;
            toDusDatabase = this.toDusDatabase;
            c10852 = new C10852(str5, j10, str6, this, eventContent3, str4, null);
            c10842.L$0 = str6;
            c10842.L$1 = cb.l.a(eventContent3);
            c10842.L$2 = cb.l.a(str4);
            c10842.L$3 = cb.l.a(str5);
            c10842.J$0 = j10;
            c10842.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10852, c10842) != objG) {
                str7 = str6;
                this.appVolatileState.onNewMessage(str7);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0111  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendFiles(String str, List<? extends File> list, String str2, String str3, ab.e<? super ua.k0> eVar) {
        C10861 c10861;
        List<? extends File> list2;
        String str4;
        String str5;
        String str6;
        long j10;
        String str7;
        List<? extends File> list3;
        String str8;
        String str9;
        ToDusDatabase toDusDatabase;
        C10872 c10872;
        String str10;
        String str11;
        String str12 = str;
        if (eVar instanceof C10861) {
            c10861 = (C10861) eVar;
            int i10 = c10861.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10861.label = i10 - Integer.MIN_VALUE;
            } else {
                c10861 = new C10861(eVar);
            }
        } else {
            c10861 = new C10861(eVar);
        }
        C10861 c10862 = c10861;
        Object obj = c10862.result;
        Object objG = bb.b.g();
        int i11 = c10862.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10862.L$0 = str12;
            list2 = list;
            c10862.L$1 = list2;
            str4 = str2;
            c10862.L$2 = str4;
            str5 = str3;
            c10862.L$3 = str5;
            c10862.label = 1;
            if (createRoomIfNeed(str12, c10862) != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            String str13 = (String) c10862.L$3;
            str4 = (String) c10862.L$2;
            List<? extends File> list4 = (List) c10862.L$1;
            String str14 = (String) c10862.L$0;
            ua.v.b(obj);
            str5 = str13;
            str12 = str14;
            list2 = list4;
        } else {
            if (i11 == 2) {
                j10 = c10862.J$0;
                String str15 = (String) c10862.L$4;
                String str16 = (String) c10862.L$3;
                str6 = (String) c10862.L$2;
                List<? extends File> list5 = (List) c10862.L$1;
                String str17 = (String) c10862.L$0;
                ua.v.b(obj);
                str7 = str16;
                str9 = str17;
                list3 = list5;
                str8 = str15;
                toDusDatabase = this.toDusDatabase;
                c10872 = new C10872(str8, j10, str9, str6, this, str7, list3, null);
                c10862.L$0 = str9;
                c10862.L$1 = cb.l.a(list3);
                c10862.L$2 = cb.l.a(str6);
                c10862.L$3 = cb.l.a(str7);
                c10862.L$4 = str8;
                c10862.J$0 = j10;
                c10862.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10872, c10862) != objG) {
                    str10 = str8;
                    str11 = str9;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str10 = (String) c10862.L$4;
            str11 = (String) c10862.L$0;
            ua.v.b(obj);
        }
        this.uploadDataSource.enqueueUpload(str10);
        this.appVolatileState.onNewMessage(str11);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10862.L$0 = str12;
        c10862.L$1 = list2;
        c10862.L$2 = str4;
        c10862.L$3 = str5;
        c10862.L$4 = strO;
        c10862.J$0 = time;
        c10862.label = 2;
        if (insertDateMsg(str12, time, c10862) != objG) {
            String str18 = str5;
            str6 = str4;
            j10 = time;
            str7 = str18;
            list3 = list2;
            str8 = strO;
            str9 = str12;
            toDusDatabase = this.toDusDatabase;
            c10872 = new C10872(str8, j10, str9, str6, this, str7, list3, null);
            c10862.L$0 = str9;
            c10862.L$1 = cb.l.a(list3);
            c10862.L$2 = cb.l.a(str6);
            c10862.L$3 = cb.l.a(str7);
            c10862.L$4 = str8;
            c10862.J$0 = j10;
            c10862.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10872, c10862) != objG) {
                str10 = str8;
                str11 = str9;
                this.uploadDataSource.enqueueUpload(str10);
                this.appVolatileState.onNewMessage(str11);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x028c  */
    /* JADX WARN: Code duplicated, block: B:50:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:53:0x030a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0325  */
    /* JADX WARN: Code duplicated, block: B:58:0x033b  */
    /* JADX WARN: Code duplicated, block: B:65:0x043c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0465  */
    /* JADX WARN: Code duplicated, block: B:76:0x0346 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0228 -> B:43:0x0272). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0276 -> B:45:0x0286). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x043c -> B:66:0x044f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0465 -> B:67:0x0460). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendForward(java.util.List<java.lang.String> r45, java.util.List<java.lang.String> r46, long r47, ab.e<? super ua.k0> r49) {
        /*
            Method dump skipped, instruction units count: 1199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.sendForward(java.util.List, java.util.List, long, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:109:0x061b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0129  */
    /* JADX WARN: Code duplicated, block: B:24:0x0169  */
    /* JADX WARN: Code duplicated, block: B:28:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:31:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:32:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:35:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x0561 -> B:108:0x0617). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x05e9 -> B:107:0x05ff). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01db -> B:40:0x0220). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x022a -> B:42:0x0242). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendFromIntent(java.util.List<java.lang.String> r30, java.util.List<cu.todus.android.domain.handlers.Send> r31, android.content.Context r32, ab.e<? super ua.k0> r33) {
        /*
            Method dump skipped, instruction units count: 1610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.sendFromIntent(java.util.List, java.util.List, android.content.Context, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0193  */
    /* JADX WARN: Code duplicated, block: B:51:0x020e  */
    /* JADX WARN: Code duplicated, block: B:79:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x020e -> B:99:0x0224). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x02ab -> B:64:0x0261). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendImages(java.lang.String r30, java.util.List<? extends java.io.File> r31, java.lang.String r32, java.lang.String r33, ab.e<? super ua.k0> r34) {
        /*
            Method dump skipped, instruction units count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.sendImages(java.lang.String, java.util.List, java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendLocation(String str, LocationContent locationContent, String str2, ab.e<? super ua.k0> eVar) {
        C10921 c10921;
        LocationContent locationContent2;
        String str3;
        String str4;
        long j10;
        LocationContent locationContent3;
        String str5;
        String str6;
        ToDusDatabase toDusDatabase;
        C10932 c10932;
        String str7;
        String str8 = str;
        if (eVar instanceof C10921) {
            c10921 = (C10921) eVar;
            int i10 = c10921.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10921.label = i10 - Integer.MIN_VALUE;
            } else {
                c10921 = new C10921(eVar);
            }
        } else {
            c10921 = new C10921(eVar);
        }
        C10921 c10922 = c10921;
        Object obj = c10922.result;
        Object objG = bb.b.g();
        int i11 = c10922.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10922.L$0 = str8;
            locationContent2 = locationContent;
            c10922.L$1 = locationContent2;
            str3 = str2;
            c10922.L$2 = str3;
            c10922.label = 1;
            if (createRoomIfNeed(str8, c10922) != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            String str9 = (String) c10922.L$2;
            LocationContent locationContent4 = (LocationContent) c10922.L$1;
            String str10 = (String) c10922.L$0;
            ua.v.b(obj);
            locationContent2 = locationContent4;
            str3 = str9;
            str8 = str10;
        } else {
            if (i11 == 2) {
                j10 = c10922.J$0;
                String str11 = (String) c10922.L$3;
                String str12 = (String) c10922.L$2;
                locationContent3 = (LocationContent) c10922.L$1;
                String str13 = (String) c10922.L$0;
                ua.v.b(obj);
                str4 = str12;
                str6 = str13;
                str5 = str11;
                toDusDatabase = this.toDusDatabase;
                c10932 = new C10932(str5, j10, str6, this, locationContent3, str4, null);
                c10922.L$0 = str6;
                c10922.L$1 = cb.l.a(locationContent3);
                c10922.L$2 = cb.l.a(str4);
                c10922.L$3 = cb.l.a(str5);
                c10922.J$0 = j10;
                c10922.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10932, c10922) != objG) {
                    str7 = str6;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str7 = (String) c10922.L$0;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str7);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10922.L$0 = str8;
        c10922.L$1 = locationContent2;
        c10922.L$2 = str3;
        c10922.L$3 = strO;
        c10922.J$0 = time;
        c10922.label = 2;
        if (insertDateMsg(str8, time, c10922) != objG) {
            str4 = str3;
            j10 = time;
            locationContent3 = locationContent2;
            str5 = strO;
            str6 = str8;
            toDusDatabase = this.toDusDatabase;
            c10932 = new C10932(str5, j10, str6, this, locationContent3, str4, null);
            c10922.L$0 = str6;
            c10922.L$1 = cb.l.a(locationContent3);
            c10922.L$2 = cb.l.a(str4);
            c10922.L$3 = cb.l.a(str5);
            c10922.J$0 = j10;
            c10922.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10932, c10922) != objG) {
                str7 = str6;
                this.appVolatileState.onNewMessage(str7);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0136  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendMessage(String str, List<? extends MessageEntity> list, String str2, String str3, String str4, boolean z10, List<String> list2, ab.e<? super ua.k0> eVar) {
        C10941 c10941;
        String str5;
        String str6;
        boolean z11;
        List<? extends MessageEntity> list3;
        List<String> list4;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z12;
        String str11;
        long j10;
        ToDusDatabase toDusDatabase;
        C10952 c10952;
        String str12;
        String str13 = str2;
        if (eVar instanceof C10941) {
            c10941 = (C10941) eVar;
            int i10 = c10941.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10941.label = i10 - Integer.MIN_VALUE;
            } else {
                c10941 = new C10941(eVar);
            }
        } else {
            c10941 = new C10941(eVar);
        }
        C10941 c10942 = c10941;
        Object obj = c10942.result;
        Object objG = bb.b.g();
        int i11 = c10942.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10942.L$0 = str;
            c10942.L$1 = list;
            c10942.L$2 = str13;
            str5 = str3;
            c10942.L$3 = str5;
            c10942.L$4 = str4;
            c10942.L$5 = list2;
            c10942.Z$0 = z10;
            c10942.label = 1;
            if (createRoomIfNeed(str13, c10942) != objG) {
                str6 = str;
                z11 = z10;
                list3 = list;
                list4 = list2;
                str7 = str4;
            }
            return objG;
        }
        if (i11 == 1) {
            boolean z13 = c10942.Z$0;
            list4 = (List) c10942.L$5;
            str7 = (String) c10942.L$4;
            str5 = (String) c10942.L$3;
            String str14 = (String) c10942.L$2;
            list3 = (List) c10942.L$1;
            str6 = (String) c10942.L$0;
            ua.v.b(obj);
            z11 = z13;
            str13 = str14;
        } else {
            if (i11 == 2) {
                long j11 = c10942.J$0;
                boolean z14 = c10942.Z$0;
                List<String> list5 = (List) c10942.L$5;
                String str15 = (String) c10942.L$4;
                String str16 = (String) c10942.L$3;
                String str17 = (String) c10942.L$2;
                List<? extends MessageEntity> list6 = (List) c10942.L$1;
                String str18 = (String) c10942.L$0;
                ua.v.b(obj);
                str10 = str16;
                str8 = str17;
                list3 = list6;
                str11 = str15;
                z12 = z14;
                list4 = list5;
                j10 = j11;
                str9 = str18;
                toDusDatabase = this.toDusDatabase;
                c10952 = new C10952(str11, list4, str9, j10, str8, this, list3, str10, z12, null);
                c10942.L$0 = cb.l.a(str9);
                c10942.L$1 = cb.l.a(list3);
                c10942.L$2 = str8;
                c10942.L$3 = cb.l.a(str10);
                c10942.L$4 = cb.l.a(str11);
                c10942.L$5 = cb.l.a(list4);
                c10942.Z$0 = z12;
                c10942.J$0 = j10;
                c10942.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10952, c10942) != objG) {
                    str12 = str8;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str12 = (String) c10942.L$2;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str12);
        return ua.k0.f43947a;
        long time = new Date().getTime();
        c10942.L$0 = str6;
        c10942.L$1 = list3;
        c10942.L$2 = str13;
        c10942.L$3 = str5;
        c10942.L$4 = str7;
        c10942.L$5 = list4;
        c10942.Z$0 = z11;
        c10942.J$0 = time;
        c10942.label = 2;
        if (insertDateMsg(str13, time, c10942) != objG) {
            str8 = str13;
            str9 = str6;
            str10 = str5;
            z12 = z11;
            str11 = str7;
            j10 = time;
            toDusDatabase = this.toDusDatabase;
            c10952 = new C10952(str11, list4, str9, j10, str8, this, list3, str10, z12, null);
            c10942.L$0 = cb.l.a(str9);
            c10942.L$1 = cb.l.a(list3);
            c10942.L$2 = str8;
            c10942.L$3 = cb.l.a(str10);
            c10942.L$4 = cb.l.a(str11);
            c10942.L$5 = cb.l.a(list4);
            c10942.Z$0 = z12;
            c10942.J$0 = j10;
            c10942.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10952, c10942) != objG) {
                str12 = str8;
                this.appVolatileState.onNewMessage(str12);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object sendMessageToChannel(String str, List<? extends MessageEntity> list, String str2, String str3, String str4, boolean z10, List<String> list2, String str5, ab.e<? super ua.k0> eVar) {
        C10961 c10961;
        String str6;
        if (eVar instanceof C10961) {
            c10961 = (C10961) eVar;
            int i10 = c10961.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10961.label = i10 - Integer.MIN_VALUE;
            } else {
                c10961 = new C10961(eVar);
            }
        } else {
            c10961 = new C10961(eVar);
        }
        C10961 c10962 = c10961;
        Object obj = c10962.result;
        Object objG = bb.b.g();
        int i11 = c10962.label;
        if (i11 == 0) {
            ua.v.b(obj);
            ToDusDatabase toDusDatabase = this.toDusDatabase;
            C10972 c10972 = new C10972(z10, this, list2, str2, str5, str4, str, list, str3, null);
            c10962.L$0 = cb.l.a(str);
            c10962.L$1 = cb.l.a(list);
            c10962.L$2 = str2;
            c10962.L$3 = cb.l.a(str3);
            c10962.L$4 = cb.l.a(str4);
            c10962.L$5 = cb.l.a(list2);
            c10962.L$6 = cb.l.a(str5);
            c10962.Z$0 = z10;
            c10962.label = 1;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10972, c10962) == objG) {
                return objG;
            }
            str6 = str2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str6 = (String) c10962.L$2;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str6);
        return ua.k0.f43947a;
    }

    public final Object sendOnline(ab.e<? super ua.k0> eVar) {
        PresenceManager presenceManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (presenceManager = xMPPDataSource.getPresenceManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objSendOnline = presenceManager.sendOnline(eVar);
        return objSendOnline == bb.b.g() ? objSendOnline : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendSticker(String str, String str2, Sticker sticker, ab.e<? super ua.k0> eVar) {
        C10981 c10981;
        String str3;
        Sticker sticker2;
        Sticker sticker3;
        long j10;
        String str4;
        String str5;
        String str6;
        ToDusDatabase toDusDatabase;
        C10992 c10992;
        String str7;
        String str8 = str;
        if (eVar instanceof C10981) {
            c10981 = (C10981) eVar;
            int i10 = c10981.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c10981.label = i10 - Integer.MIN_VALUE;
            } else {
                c10981 = new C10981(eVar);
            }
        } else {
            c10981 = new C10981(eVar);
        }
        C10981 c10982 = c10981;
        Object obj = c10982.result;
        Object objG = bb.b.g();
        int i11 = c10982.label;
        if (i11 == 0) {
            ua.v.b(obj);
            c10982.L$0 = str8;
            str3 = str2;
            c10982.L$1 = str3;
            sticker2 = sticker;
            c10982.L$2 = sticker2;
            c10982.label = 1;
            if (createRoomIfNeed(str8, c10982) != objG) {
            }
            return objG;
        }
        if (i11 == 1) {
            Sticker sticker4 = (Sticker) c10982.L$2;
            String str9 = (String) c10982.L$1;
            String str10 = (String) c10982.L$0;
            ua.v.b(obj);
            str3 = str9;
            sticker2 = sticker4;
            str8 = str10;
        } else {
            if (i11 == 2) {
                j10 = c10982.J$0;
                String str11 = (String) c10982.L$3;
                Sticker sticker5 = (Sticker) c10982.L$2;
                String str12 = (String) c10982.L$1;
                String str13 = (String) c10982.L$0;
                ua.v.b(obj);
                sticker3 = sticker5;
                str6 = str13;
                str4 = str12;
                str5 = str11;
                toDusDatabase = this.toDusDatabase;
                c10992 = new C10992(str5, j10, str6, this, sticker3, str4, null);
                c10982.L$0 = str6;
                c10982.L$1 = cb.l.a(str4);
                c10982.L$2 = cb.l.a(sticker3);
                c10982.L$3 = cb.l.a(str5);
                c10982.J$0 = j10;
                c10982.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c10992, c10982) != objG) {
                    str7 = str6;
                }
                return objG;
            }
            if (i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str7 = (String) c10982.L$0;
            ua.v.b(obj);
        }
        this.appVolatileState.onNewMessage(str7);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        String strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c10982.L$0 = str8;
        c10982.L$1 = str3;
        c10982.L$2 = sticker2;
        c10982.L$3 = strO;
        c10982.J$0 = time;
        c10982.label = 2;
        if (insertDateMsg(str8, time, c10982) != objG) {
            sticker3 = sticker2;
            j10 = time;
            str4 = str3;
            str5 = strO;
            str6 = str8;
            toDusDatabase = this.toDusDatabase;
            c10992 = new C10992(str5, j10, str6, this, sticker3, str4, null);
            c10982.L$0 = str6;
            c10982.L$1 = cb.l.a(str4);
            c10982.L$2 = cb.l.a(sticker3);
            c10982.L$3 = cb.l.a(str5);
            c10982.J$0 = j10;
            c10982.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c10992, c10982) != objG) {
                str7 = str6;
                this.appVolatileState.onNewMessage(str7);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    public final void sendTyping(String uid, boolean b10) {
        kotlin.jvm.internal.y.i(uid, "uid");
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource != null) {
            xMPPDataSource.sendTyping(uid, b10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:42:0x019f  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d5 A[Catch: Exception -> 0x01da, TRY_LEAVE, TryCatch #8 {Exception -> 0x01da, blocks: (B:49:0x01c6, B:51:0x01d5), top: B:130:0x01c6 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01de  */
    /* JADX WARN: Code duplicated, block: B:59:0x01e8 A[Catch: Exception -> 0x01ed, TryCatch #3 {Exception -> 0x01ed, blocks: (B:57:0x01e2, B:59:0x01e8, B:62:0x01f5), top: B:120:0x01e2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0275  */
    /* JADX WARN: Code duplicated, block: B:77:0x0279  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x0291 A[Catch: Exception -> 0x029b, TryCatch #7 {Exception -> 0x029b, blocks: (B:78:0x028b, B:80:0x0291, B:87:0x02a0), top: B:128:0x028b }] */
    /* JADX WARN: Code duplicated, block: B:86:0x029d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x02db -> B:89:0x02a5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0279 -> B:128:0x028b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendVideos(java.lang.String r39, java.util.List<? extends java.io.File> r40, java.lang.String r41, java.lang.String r42, ab.e<? super ua.k0> r43) {
        /*
            Method dump skipped, instruction units count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.sendVideos(java.lang.String, java.util.List, java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0107  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object sendVoice(String str, File file, int i10, String str2, ab.e<? super ua.k0> eVar) {
        C11021 c11021;
        File file2;
        String str3;
        int i11;
        String strO;
        long j10;
        String str4;
        int i12;
        String str5;
        String str6;
        ToDusDatabase toDusDatabase;
        C11032 c11032;
        String str7;
        String str8;
        String str9 = str;
        if (eVar instanceof C11021) {
            c11021 = (C11021) eVar;
            int i13 = c11021.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                c11021.label = i13 - Integer.MIN_VALUE;
            } else {
                c11021 = new C11021(eVar);
            }
        } else {
            c11021 = new C11021(eVar);
        }
        C11021 c11022 = c11021;
        Object obj = c11022.result;
        Object objG = bb.b.g();
        int i14 = c11022.label;
        if (i14 == 0) {
            ua.v.b(obj);
            c11022.L$0 = str9;
            file2 = file;
            c11022.L$1 = file2;
            str3 = str2;
            c11022.L$2 = str3;
            i11 = i10;
            c11022.I$0 = i11;
            c11022.label = 1;
            if (createRoomIfNeed(str9, c11022) != objG) {
            }
            return objG;
        }
        if (i14 == 1) {
            int i15 = c11022.I$0;
            str3 = (String) c11022.L$2;
            File file3 = (File) c11022.L$1;
            String str10 = (String) c11022.L$0;
            ua.v.b(obj);
            i11 = i15;
            str9 = str10;
            file2 = file3;
        } else {
            if (i14 == 2) {
                long j11 = c11022.J$0;
                int i16 = c11022.I$0;
                strO = (String) c11022.L$3;
                String str11 = (String) c11022.L$2;
                File file4 = (File) c11022.L$1;
                String str12 = (String) c11022.L$0;
                ua.v.b(obj);
                j10 = j11;
                str4 = str11;
                str5 = str12;
                file2 = file4;
                i12 = i16;
                str6 = strO;
                long j12 = j10;
                toDusDatabase = this.toDusDatabase;
                c11032 = new C11032(file2, str6, j12, str5, this, i12, str4, null);
                c11022.L$0 = str5;
                c11022.L$1 = cb.l.a(file2);
                c11022.L$2 = cb.l.a(str4);
                c11022.L$3 = str6;
                c11022.I$0 = i12;
                c11022.J$0 = j12;
                c11022.label = 3;
                if (RoomDatabaseKt.withTransaction(toDusDatabase, c11032, c11022) != objG) {
                    str7 = str6;
                    str8 = str5;
                }
                return objG;
            }
            if (i14 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str7 = (String) c11022.L$3;
            str8 = (String) c11022.L$0;
            ua.v.b(obj);
        }
        this.uploadDataSource.enqueueUpload(str7);
        this.appVolatileState.onNewMessage(str8);
        return ua.k0.f43947a;
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.y.h(string, "toString(...)");
        strO = le.a0.O(string, "-", "", false, 4, null);
        long time = new Date().getTime();
        c11022.L$0 = str9;
        c11022.L$1 = file2;
        c11022.L$2 = str3;
        c11022.L$3 = strO;
        c11022.I$0 = i11;
        c11022.J$0 = time;
        c11022.label = 2;
        if (insertDateMsg(str9, time, c11022) != objG) {
            j10 = time;
            str4 = str3;
            i12 = i11;
            str5 = str9;
            str6 = strO;
            long j13 = j10;
            toDusDatabase = this.toDusDatabase;
            c11032 = new C11032(file2, str6, j13, str5, this, i12, str4, null);
            c11022.L$0 = str5;
            c11022.L$1 = cb.l.a(file2);
            c11022.L$2 = cb.l.a(str4);
            c11022.L$3 = str6;
            c11022.I$0 = i12;
            c11022.J$0 = j13;
            c11022.label = 3;
            if (RoomDatabaseKt.withTransaction(toDusDatabase, c11032, c11022) != objG) {
                str7 = str6;
                str8 = str5;
                this.uploadDataSource.enqueueUpload(str7);
                this.appVolatileState.onNewMessage(str8);
                return ua.k0.f43947a;
            }
        }
        return objG;
    }

    public final WebRtcSessionManagerImpl sessionManager() {
        CallManager callManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null) {
            return null;
        }
        return callManager.getSessionManager();
    }

    public final Object setLocation(double d10, double d11, ab.e<? super Boolean> eVar) {
        LocationManager locationManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (locationManager = xMPPDataSource.getLocationManager()) == null) {
            return null;
        }
        Object objSendNearLocation = locationManager.sendNearLocation(d10, d11, eVar);
        return objSendNearLocation == bb.b.g() ? objSendNearLocation : (Boolean) objSendNearLocation;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object shareMsgs(List<String> list, ab.e<? super ua.k0> eVar) {
        C11041 c11041;
        ArrayList arrayList;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Uri uriForFile;
        if (eVar instanceof C11041) {
            c11041 = (C11041) eVar;
            int i10 = c11041.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11041.label = i10 - Integer.MIN_VALUE;
            } else {
                c11041 = new C11041(eVar);
            }
        } else {
            c11041 = new C11041(eVar);
        }
        Object obj = c11041.result;
        Object objG = bb.b.g();
        int i11 = c11041.label;
        if (i11 == 0) {
            ua.v.b(obj);
            ArrayList arrayList2 = new ArrayList();
            MessageDao messageDao = this.messageDao;
            c11041.L$0 = cb.l.a(list);
            c11041.L$1 = arrayList2;
            c11041.label = 1;
            Object msgsByIdIn = messageDao.getMsgsByIdIn(list, c11041);
            if (msgsByIdIn == objG) {
                return objG;
            }
            obj = msgsByIdIn;
            arrayList = arrayList2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList = (ArrayList) c11041.L$1;
            ua.v.b(obj);
        }
        for (MessageWithPartnerWithReactions messageWithPartnerWithReactions : (Iterable) obj) {
            Iterator<T> it = messageWithPartnerWithReactions.getAttachments().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((Attachment) next).getType() != 6);
            if (next != null) {
                String id2 = messageWithPartnerWithReactions.getMessage().getId();
                Iterator<T> it2 = messageWithPartnerWithReactions.getAttachments().iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (((Attachment) next2).getType() != 6);
                Attachment attachment = (Attachment) next2;
                Content content = attachment != null ? attachment.getContent() : null;
                kotlin.jvm.internal.y.g(content, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                String fName = ((ContactContent) content).getFName();
                Iterator<T> it3 = messageWithPartnerWithReactions.getAttachments().iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                } while (((Attachment) next3).getType() != 6);
                Attachment attachment2 = (Attachment) next3;
                Content content2 = attachment2 != null ? attachment2.getContent() : null;
                kotlin.jvm.internal.y.g(content2, "null cannot be cast to non-null type cu.todus.android.data.db.pojo.content.ContactContent");
                arrayList.add(new ua.y(id2, fName + ": " + ((ContactContent) content2).getPhone(), null));
            } else {
                Iterator<T> it4 = messageWithPartnerWithReactions.getAttachments().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    Attachment attachment3 = (Attachment) next4;
                    if ((attachment3.getContent() instanceof FileContent) && (attachment3.getState() == 2 || attachment3.getState() == 6)) {
                        if (attachment3.getType() != 13) {
                            break;
                        }
                    }
                }
                Attachment attachment4 = (Attachment) next4;
                FileContent fileContent = (FileContent) (attachment4 != null ? attachment4.getContent() : null);
                String path = fileContent != null ? fileContent.getPath() : null;
                if (path != null) {
                    try {
                        Context context = this.context;
                        uriForFile = FileProvider.getUriForFile(context, context.getString(R.string.content_provider), new File(path));
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        uriForFile = null;
                    }
                } else {
                    uriForFile = null;
                }
                if (path != null && uriForFile == null) {
                    try {
                        Uri.fromFile(new File(path));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (path != null && uriForFile == null) {
                    try {
                        String path2 = MediaUtil.INSTANCE.getPath(this.context, Uri.parse(path));
                        kotlin.jvm.internal.y.f(path2);
                        Uri.fromFile(new File(path2));
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                String id3 = messageWithPartnerWithReactions.getMessage().getId();
                String content3 = messageWithPartnerWithReactions.getMessage().getContent();
                arrayList.add(new ua.y(id3, le.d0.q0(content3) ? null : content3, uriForFile));
            }
        }
        if (!arrayList.isEmpty()) {
            IntentUtil.INSTANCE.shareMessages(MainModule.INSTANCE.getInstance().getAppContext(), arrayList);
        }
        return ua.k0.f43947a;
    }

    public final Object startCallProcess(String str, boolean z10, final lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e<? super ua.k0> eVar) {
        CallManager callManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (callManager = xMPPDataSource.getCallManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objStartCallProcess = callManager.startCallProcess(str, z10, new lb.a() { // from class: cu.todus.android.repositories.k0
            @Override // lb.a
            public final Object invoke() {
                return MainRepository.startCallProcess$lambda$0(this.f20895c, aVar);
            }
        }, aVar2, aVar3, eVar);
        return objStartCallProcess == bb.b.g() ? objStartCallProcess : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object startCallProcessNew(String str, boolean z10, final lb.a aVar, lb.a aVar2, lb.a aVar3, ab.e<? super ua.k0> eVar) {
        C11051 c11051;
        Exception exc;
        if (eVar instanceof C11051) {
            c11051 = (C11051) eVar;
            int i10 = c11051.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11051.label = i10 - Integer.MIN_VALUE;
            } else {
                c11051 = new C11051(eVar);
            }
        } else {
            c11051 = new C11051(eVar);
        }
        C11051 c11052 = c11051;
        Object obj = c11052.result;
        Object objG = bb.b.g();
        int i11 = c11052.label;
        if (i11 == 0) {
            ua.v.b(obj);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null) {
                Log.e("MainRepository", "startCallProcessNew - XMPPDataSource es null!");
                aVar3.invoke();
                return ua.k0.f43947a;
            }
            if (xMPPDataSource != null) {
                try {
                    CallManager callManager = xMPPDataSource.getCallManager();
                    if (callManager != null) {
                        lb.a aVar4 = new lb.a() { // from class: cu.todus.android.repositories.m0
                            @Override // lb.a
                            public final Object invoke() {
                                return MainRepository.startCallProcessNew$lambda$0(this.f20898c, aVar);
                            }
                        };
                        c11052.L$0 = cb.l.a(str);
                        c11052.L$1 = cb.l.a(aVar);
                        c11052.L$2 = cb.l.a(aVar2);
                        c11052.L$3 = aVar3;
                        c11052.Z$0 = z10;
                        c11052.label = 1;
                        try {
                            if (callManager.startCallProcessNew(str, z10, aVar4, aVar2, aVar3, c11052) == objG) {
                                return objG;
                            }
                        } catch (Exception e10) {
                            exc = e10;
                            aVar3 = aVar3;
                            Log.e("MainRepository", "startCallProcessNew - Error: " + exc.getMessage(), exc);
                            aVar3.invoke();
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    exc = e;
                    Log.e("MainRepository", "startCallProcessNew - Error: " + exc.getMessage(), exc);
                    aVar3.invoke();
                    return ua.k0.f43947a;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar3 = (lb.a) c11052.L$3;
            try {
                ua.v.b(obj);
            } catch (Exception e12) {
                e = e12;
                exc = e;
                Log.e("MainRepository", "startCallProcessNew - Error: " + exc.getMessage(), exc);
                aVar3.invoke();
            }
        }
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0137, code lost:
    
        if (r1.update(r10, r2) == r3) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object subscribeCard(java.lang.String r27, ab.e<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.subscribeCard(java.lang.String, ab.e):java.lang.Object");
    }

    public final Object tryResendMsg(String str, ab.e<? super ua.k0> eVar) {
        Object objForceUpdateStatus = this.messageDao.forceUpdateStatus(str, 0, eVar);
        return objForceUpdateStatus == bb.b.g() ? objForceUpdateStatus : ua.k0.f43947a;
    }

    public final Object unBlockUser(String str, ab.e<? super Boolean> eVar) {
        BlocksManager blocksManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (blocksManager = xMPPDataSource.getBlocksManager()) == null) {
            return null;
        }
        Object objUnBlockUser = blocksManager.unBlockUser(str, eVar);
        return objUnBlockUser == bb.b.g() ? objUnBlockUser : (Boolean) objUnBlockUser;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r7 == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object unFollow(java.lang.String r6, ab.e<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.repositories.MainRepository.C11091
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.repositories.MainRepository$unFollow$1 r0 = (cu.todus.android.repositories.MainRepository.C11091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$unFollow$1 r0 = new cu.todus.android.repositories.MainRepository$unFollow$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            ua.v.b(r7)
            return r6
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            ua.v.b(r7)
            goto L5c
        L44:
            ua.v.b(r7)
            cu.todus.android.xmpp.XMPPDataSource r7 = r5.mXMPPDataSource
            if (r7 == 0) goto L5f
            cu.todus.android.xmpp.managers.StatusManager r7 = r7.getStatusManager()
            if (r7 == 0) goto L5f
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.unFollow(r6, r0)
            if (r7 != r1) goto L5c
            goto L7c
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L60
        L5f:
            r7 = 0
        L60:
            java.lang.Boolean r2 = cb.b.a(r4)
            boolean r2 = kotlin.jvm.internal.y.d(r7, r2)
            if (r2 == 0) goto L7d
            cu.todus.android.db.dao.toDus.StatusDao r2 = r5.statusDao
            java.lang.Object r4 = cb.l.a(r6)
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r2.deleteByRepliedId(r6, r0)
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.unFollow(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object unPinMsgInGroup(String str, ab.e<? super ua.k0> eVar) {
        C11101 c11101;
        GroupsManager groupsManager;
        if (eVar instanceof C11101) {
            c11101 = (C11101) eVar;
            int i10 = c11101.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11101.label = i10 - Integer.MIN_VALUE;
            } else {
                c11101 = new C11101(eVar);
            }
        } else {
            c11101 = new C11101(eVar);
        }
        C11101 c11102 = c11101;
        Object objChangeGroupConfigs$default = c11102.result;
        Object objG = bb.b.g();
        int i11 = c11102.label;
        if (i11 == 0) {
            ua.v.b(objChangeGroupConfigs$default);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null && (groupsManager = xMPPDataSource.getGroupsManager()) != null) {
                HashMap mapK = w0.k(ua.z.a(Room.CONFIG_PINED_MESSAGE, ""), ua.z.a(Room.CONFIG_PINED_MESSAGE_ID, ""));
                c11102.L$0 = cb.l.a(str);
                c11102.label = 1;
                objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager, str, null, null, mapK, c11102, 6, null);
                if (objChangeGroupConfigs$default == objG) {
                    return objG;
                }
            }
            return ua.k0.f43947a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objChangeGroupConfigs$default);
        ((Boolean) objChangeGroupConfigs$default).getClass();
        return ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
    
        if (r14.delete(r2, r0) == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object unsubscribeCard(java.lang.String r13, ab.e<? super java.lang.Boolean> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof cu.todus.android.repositories.MainRepository.C11111
            if (r0 == 0) goto L13
            r0 = r14
            cu.todus.android.repositories.MainRepository$unsubscribeCard$1 r0 = (cu.todus.android.repositories.MainRepository.C11111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.repositories.MainRepository$unsubscribeCard$1 r0 = new cu.todus.android.repositories.MainRepository$unsubscribeCard$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L54
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r13 = r0.L$1
            cu.todus.android.data.wrapper.DataWrapper r13 = (cu.todus.android.data.wrapper.DataWrapper) r13
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            ua.v.b(r14)
            goto Lc0
        L38:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L40:
            java.lang.Object r13 = r0.L$1
            cu.todus.android.data.wrapper.DataWrapper r13 = (cu.todus.android.data.wrapper.DataWrapper) r13
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            ua.v.b(r14)
            goto La9
        L4c:
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            ua.v.b(r14)
            goto L71
        L54:
            ua.v.b(r14)
            cu.todus.android.rest.certified.CertifiedInfoDataSource r14 = r12.certifiedInfoDataSource
            r10 = 4
            r11 = 0
            java.lang.String r7 = "@im.todus.cu"
            java.lang.String r8 = ""
            r9 = 0
            r6 = r13
            java.lang.String r13 = le.a0.O(r6, r7, r8, r9, r10, r11)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r14 = r14.unSubscribe(r13, r0)
            if (r14 != r1) goto L70
            goto Lbf
        L70:
            r13 = r6
        L71:
            cu.todus.android.data.wrapper.DataWrapper r14 = (cu.todus.android.data.wrapper.DataWrapper) r14
            java.lang.Object r2 = r14.getResponseBody()
            if (r2 != 0) goto L8e
            boolean r2 = r14.getResponseOkButNull()
            if (r2 != 0) goto L8e
            int r2 = r14.getCode()
            r6 = 404(0x194, float:5.66E-43)
            if (r2 != r6) goto L88
            goto L8e
        L88:
            r13 = 0
            java.lang.Boolean r13 = cb.b.a(r13)
            return r13
        L8e:
            java.lang.String[] r2 = new java.lang.String[]{r13}
            java.util.ArrayList r2 = va.w.g(r2)
            r0.L$0 = r13
            java.lang.Object r6 = cb.l.a(r14)
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r2 = r12.clearHistoryFromRooms(r2, r0)
            if (r2 != r1) goto La7
            goto Lbf
        La7:
            r2 = r13
            r13 = r14
        La9:
            cu.todus.android.db.dao.toDus.RoomDao r14 = r12.roomDao
            java.lang.Object r4 = cb.l.a(r2)
            r0.L$0 = r4
            java.lang.Object r13 = cb.l.a(r13)
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r13 = r14.delete(r2, r0)
            if (r13 != r1) goto Lc0
        Lbf:
            return r1
        Lc0:
            java.lang.Boolean r13 = cb.b.a(r5)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.unsubscribeCard(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:40:0x0101  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
    
        if (r2 == r4) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0146, code lost:
    
        if (r2 == r4) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateAdminRights(java.lang.String r24, java.lang.String r25, java.util.List<java.lang.String> r26, ab.e<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.updateAdminRights(java.lang.String, java.lang.String, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateAlias(String str, ab.e<? super Boolean> eVar) {
        C11131 c11131;
        boolean zBooleanValue;
        ProfileManager profileManager;
        if (eVar instanceof C11131) {
            c11131 = (C11131) eVar;
            int i10 = c11131.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11131.label = i10 - Integer.MIN_VALUE;
            } else {
                c11131 = new C11131(eVar);
            }
        } else {
            c11131 = new C11131(eVar);
        }
        Object objUpdateAlias = c11131.result;
        Object objG = bb.b.g();
        int i11 = c11131.label;
        if (i11 == 0) {
            ua.v.b(objUpdateAlias);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (profileManager = xMPPDataSource.getProfileManager()) == null) {
                zBooleanValue = false;
            } else {
                c11131.L$0 = cb.l.a(str);
                c11131.label = 1;
                objUpdateAlias = profileManager.updateAlias(str, c11131);
                if (objUpdateAlias == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objUpdateAlias);
        zBooleanValue = ((Boolean) objUpdateAlias).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    public final Object updateAttachment(Attachment attachment, ab.e<? super ua.k0> eVar) {
        Object objUpdate = this.attachmentDao.update(attachment, eVar);
        return objUpdate == bb.b.g() ? objUpdate : ua.k0.f43947a;
    }

    public final Object updateAttachmentState(String str, int i10, ab.e<? super ua.k0> eVar) {
        Object objUpdateAttachmentState = this.attachmentDao.updateAttachmentState(str, i10, eVar);
        return objUpdateAttachmentState == bb.b.g() ? objUpdateAttachmentState : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateBio(String str, ab.e<? super Boolean> eVar) {
        C11141 c11141;
        boolean zBooleanValue;
        ProfileManager profileManager;
        if (eVar instanceof C11141) {
            c11141 = (C11141) eVar;
            int i10 = c11141.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11141.label = i10 - Integer.MIN_VALUE;
            } else {
                c11141 = new C11141(eVar);
            }
        } else {
            c11141 = new C11141(eVar);
        }
        Object objUpdateBio = c11141.result;
        Object objG = bb.b.g();
        int i11 = c11141.label;
        if (i11 == 0) {
            ua.v.b(objUpdateBio);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (profileManager = xMPPDataSource.getProfileManager()) == null) {
                zBooleanValue = false;
            } else {
                c11141.L$0 = cb.l.a(str);
                c11141.label = 1;
                objUpdateBio = profileManager.updateBio(str, c11141);
                if (objUpdateBio == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objUpdateBio);
        zBooleanValue = ((Boolean) objUpdateBio).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0129  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:64:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:67:0x0211  */
    /* JADX WARN: Code duplicated, block: B:72:0x0285  */
    /* JADX WARN: Code duplicated, block: B:73:0x028a  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0280, code lost:
    
        if (r6.update(r5, r11) == r3) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateChannelInfo(java.lang.String r36, android.net.Uri r37, java.lang.String r38, java.lang.String r39, boolean r40, ab.e<? super java.lang.Boolean> r41) {
        /*
            Method dump skipped, instruction units count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.updateChannelInfo(java.lang.String, android.net.Uri, java.lang.String, java.lang.String, boolean, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0520  */
    /* JADX WARN: Code duplicated, block: B:103:0x0536  */
    /* JADX WARN: Code duplicated, block: B:106:0x054c  */
    /* JADX WARN: Code duplicated, block: B:46:0x028d  */
    /* JADX WARN: Code duplicated, block: B:49:0x029e  */
    /* JADX WARN: Code duplicated, block: B:58:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:66:0x034c  */
    /* JADX WARN: Code duplicated, block: B:79:0x03ea A[PHI: r0 r3 r4 r5 r6 r9 r10 r14 r16 r17
      0x03ea: PHI (r0v40 kotlin.jvm.internal.u0) = (r0v21 kotlin.jvm.internal.u0), (r0v21 kotlin.jvm.internal.u0), (r0v42 kotlin.jvm.internal.u0) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r3v31 java.io.File) = (r3v17 java.io.File), (r3v17 java.io.File), (r3v36 java.io.File) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r4v32 kotlin.jvm.internal.y0) = (r4v19 kotlin.jvm.internal.y0), (r4v19 kotlin.jvm.internal.y0), (r4v37 kotlin.jvm.internal.y0) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r5v26 cu.todus.android.data.xmpp.FileResponse$FileResult) = 
      (r5v14 cu.todus.android.data.xmpp.FileResponse$FileResult)
      (r5v14 cu.todus.android.data.xmpp.FileResponse$FileResult)
      (r5v28 cu.todus.android.data.xmpp.FileResponse$FileResult)
     binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r6v34 java.io.File) = (r6v14 java.io.File), (r6v14 java.io.File), (r6v37 java.io.File) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r9v3 cu.todus.android.repositories.MainRepository$updateGroupImage$1) = 
      (r9v0 cu.todus.android.repositories.MainRepository$updateGroupImage$1)
      (r9v0 cu.todus.android.repositories.MainRepository$updateGroupImage$1)
      (r9v4 cu.todus.android.repositories.MainRepository$updateGroupImage$1)
     binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r10v16 java.lang.String) = (r10v7 java.lang.String), (r10v7 java.lang.String), (r10v26 java.lang.String) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r14v11 kotlin.Pair) = (r14v6 kotlin.Pair), (r14v6 kotlin.Pair), (r14v13 kotlin.Pair) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r16v10 int) = (r16v5 int), (r16v5 int), (r16v11 int) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]
      0x03ea: PHI (r17v19 android.net.Uri) = (r17v9 android.net.Uri), (r17v9 android.net.Uri), (r17v21 android.net.Uri) binds: [B:57:0x02fd, B:59:0x0303, B:78:0x03d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x0439  */
    /* JADX WARN: Code duplicated, block: B:85:0x0448  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:95:0x04c7  */
    public final Object updateGroupImage(Uri uri, String str, ab.e<? super Boolean> eVar) {
        C11171 c11171;
        int i10;
        Uri uri2;
        File file;
        u0 u0Var;
        y0 y0Var;
        Uri uri3;
        Object obj;
        String str2;
        File file2;
        final Pair pair;
        u0 u0Var2;
        String str3;
        FileResponse.FileResult fileResult;
        Object objCompress$default;
        Uri uri4;
        Object obj2;
        y0 y0Var2;
        Pair pair2;
        String str4;
        u0 u0Var3;
        File file3;
        XMPPDataSource xMPPDataSource;
        File file4;
        String str5;
        FileResponse.FileResult fileResult2;
        File file5;
        y0 y0Var3;
        u0 u0Var4;
        UrlManager urlManager;
        Object obj3;
        String str6;
        Uri uri5;
        u0 u0Var5;
        File file6;
        y0 y0Var4;
        FileResponse.FileResult fileResult3;
        File file7;
        Uri uri6;
        u0 u0Var6;
        Object obj4;
        XMPPDataSource xMPPDataSource2;
        GroupsManager groupsManager;
        y0 y0Var5;
        Object obj5;
        String str7;
        Pair pair3;
        File file8;
        u0 u0Var7;
        Uri uri7;
        y0 y0Var6;
        File file9;
        FileResponse.FileResult fileResult4;
        File file10;
        String str8;
        Pair pair4;
        Object objCompress$default2;
        u0 u0Var8;
        Object obj6;
        String str9;
        Uri uri8;
        File file11;
        File file12;
        XMPPDataSource xMPPDataSource3;
        File file13;
        File file14;
        File file15;
        y0 y0Var7;
        File file16;
        Uri uri9;
        u0 u0Var9;
        int i11;
        String str10;
        FileResponse.FileResult fileResult5;
        UrlManager urlManager2;
        File file17;
        File file18;
        y0 y0Var8;
        File file19;
        Uri uri10;
        Pair pair5;
        u0 u0Var10;
        Object obj7;
        File file20;
        FileResponse.FileResult fileResult6;
        Uri uri11;
        File file21;
        Object objDirectUpload;
        File file22;
        y0 y0Var9;
        String str11;
        FileResponse.FileResult fileResult7;
        File file23;
        int i12;
        u0 u0Var11;
        Uri uri12;
        XMPPDataSource xMPPDataSource4;
        GroupsManager groupsManager2;
        u0 u0Var12;
        y0 y0Var10;
        if (eVar instanceof C11171) {
            c11171 = (C11171) eVar;
            int i13 = c11171.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                c11171.label = i13 - Integer.MIN_VALUE;
            } else {
                c11171 = new C11171(eVar);
            }
        } else {
            c11171 = new C11171(eVar);
        }
        C11171 c11172 = c11171;
        Object objChangeGroupConfigs$default = c11172.result;
        Object objG = bb.b.g();
        switch (c11172.label) {
            case 0:
                i10 = 0;
                ua.v.b(objChangeGroupConfigs$default);
                try {
                    uri2 = uri;
                    try {
                        String path = MediaUtil.INSTANCE.getPath(this.context, uri2);
                        kotlin.jvm.internal.y.f(path);
                        file = new File(path);
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        file = null;
                    }
                } catch (Exception e11) {
                    e = e11;
                    uri2 = uri;
                }
                if (file == null) {
                    return cb.b.a(false);
                }
                u0Var = new u0();
                y0 y0Var11 = new y0();
                y0Var11.f36634c = ua.z.a("", "");
                String path2 = uri2.getPath();
                if (path2 == null) {
                    path2 = "/";
                }
                File file24 = new File(path2);
                c11172.L$0 = cb.l.a(uri2);
                c11172.L$1 = str;
                c11172.L$2 = file;
                c11172.L$3 = u0Var;
                c11172.L$4 = y0Var11;
                c11172.label = 1;
                Object bounds = Z17InlineUtilsKt.getBounds(file24, c11172);
                if (bounds != objG) {
                    y0Var = y0Var11;
                    uri3 = uri2;
                    obj = bounds;
                    str2 = str;
                    file2 = file;
                    pair = (Pair) obj;
                    Compressor compressor = Compressor.INSTANCE;
                    Context context = this.context;
                    Function1 function1 = new Function1() { // from class: cu.todus.android.repositories.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            return MainRepository.updateGroupImage$lambda$0(pair, (Compression) obj8);
                        }
                    };
                    c11172.L$0 = cb.l.a(uri3);
                    c11172.L$1 = str2;
                    c11172.L$2 = file2;
                    c11172.L$3 = u0Var;
                    c11172.L$4 = y0Var;
                    c11172.L$5 = pair;
                    c11172.label = 2;
                    u0Var2 = u0Var;
                    str3 = str2;
                    fileResult = null;
                    objCompress$default = Compressor.compress$default(compressor, context, file2, false, null, function1, c11172, 12, null);
                    if (objCompress$default != objG) {
                        uri4 = uri3;
                        obj2 = objCompress$default;
                        y0Var2 = y0Var;
                        pair2 = pair;
                        str4 = str3;
                        u0Var3 = u0Var2;
                        file3 = (File) obj2;
                        xMPPDataSource = this.mXMPPDataSource;
                        if (xMPPDataSource != null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                            y0 y0Var12 = y0Var2;
                            u0 u0Var13 = u0Var3;
                            File file25 = file2;
                            file4 = file3;
                            str5 = str4;
                            fileResult2 = fileResult;
                            file5 = file25;
                            y0Var3 = y0Var12;
                            u0Var4 = u0Var13;
                            if (fileResult2 != null || fileResult2.getWasError()) {
                                final Pair pair6 = pair2;
                                y0Var6 = y0Var3;
                                file9 = file4;
                                fileResult4 = fileResult2;
                                file10 = file5;
                                str8 = str5;
                                Compressor compressor2 = Compressor.INSTANCE;
                                Context context2 = this.context;
                                Function1 function2 = new Function1() { // from class: cu.todus.android.repositories.j0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj8) {
                                        return MainRepository.updateGroupImage$lambda$1(pair6, (Compression) obj8);
                                    }
                                };
                                c11172.L$0 = cb.l.a(uri4);
                                c11172.L$1 = str8;
                                c11172.L$2 = cb.l.a(file10);
                                c11172.L$3 = u0Var4;
                                c11172.L$4 = y0Var6;
                                c11172.L$5 = cb.l.a(pair6);
                                c11172.L$6 = cb.l.a(file9);
                                c11172.L$7 = cb.l.a(fileResult4);
                                c11172.L$8 = null;
                                c11172.label = 6;
                                pair4 = pair6;
                                objCompress$default2 = Compressor.compress$default(compressor2, context2, file10, false, null, function2, c11172, 12, null);
                                if (objCompress$default2 != objG) {
                                    u0Var8 = u0Var4;
                                    obj6 = objCompress$default2;
                                    str9 = str8;
                                    uri8 = uri4;
                                    file11 = file10;
                                    file12 = (File) obj6;
                                    xMPPDataSource3 = this.mXMPPDataSource;
                                    if (xMPPDataSource3 != null || (urlManager2 = xMPPDataSource3.getUrlManager()) == null) {
                                        file13 = file12;
                                        file14 = file13;
                                        file15 = file9;
                                        y0Var7 = y0Var6;
                                        file16 = file11;
                                        uri9 = uri8;
                                        u0Var9 = u0Var8;
                                        i11 = 0;
                                        str10 = str9;
                                        fileResult5 = null;
                                        fileResult6 = fileResult4;
                                        if (fileResult5 != null && !fileResult5.getWasError()) {
                                            UploadDataSource.Companion companion = UploadDataSource.INSTANCE;
                                            uri11 = uri9;
                                            String path3 = file13.getPath();
                                            kotlin.jvm.internal.y.h(path3, "getPath(...)");
                                            String put = fileResult5.getPut();
                                            file21 = file13;
                                            c11172.L$0 = cb.l.a(uri11);
                                            c11172.L$1 = str10;
                                            c11172.L$2 = cb.l.a(file16);
                                            c11172.L$3 = u0Var9;
                                            c11172.L$4 = y0Var7;
                                            c11172.L$5 = cb.l.a(pair4);
                                            c11172.L$6 = cb.l.a(file15);
                                            c11172.L$7 = cb.l.a(fileResult6);
                                            c11172.L$8 = cb.l.a(file14);
                                            c11172.L$9 = cb.l.a(file21);
                                            c11172.L$10 = fileResult5;
                                            c11172.L$11 = u0Var9;
                                            c11172.I$0 = i11;
                                            c11172.label = 8;
                                            objDirectUpload = companion.directUpload(put, path3, c11172);
                                            if (objDirectUpload != objG) {
                                                file22 = file21;
                                                y0Var9 = y0Var7;
                                                str11 = str10;
                                                fileResult7 = fileResult5;
                                                file23 = file15;
                                                i12 = i11;
                                                u0Var11 = u0Var9;
                                                uri12 = uri11;
                                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                }
                                                xMPPDataSource4 = this.mXMPPDataSource;
                                                if (xMPPDataSource4 != null || (groupsManager2 = xMPPDataSource4.getGroupsManager()) == null) {
                                                    u0Var9 = u0Var11;
                                                } else {
                                                    HashMap mapK = w0.k(ua.z.a(Room.CONFIG_PICTURE_THUMBNAIL, ((Pair) y0Var9.f36634c).getFirst()));
                                                    c11172.L$0 = cb.l.a(uri12);
                                                    c11172.L$1 = cb.l.a(str11);
                                                    c11172.L$2 = cb.l.a(file16);
                                                    c11172.L$3 = u0Var11;
                                                    c11172.L$4 = y0Var9;
                                                    c11172.L$5 = cb.l.a(pair4);
                                                    c11172.L$6 = cb.l.a(file23);
                                                    c11172.L$7 = cb.l.a(fileResult6);
                                                    c11172.L$8 = cb.l.a(file14);
                                                    c11172.L$9 = cb.l.a(file22);
                                                    c11172.L$10 = cb.l.a(fileResult7);
                                                    c11172.L$11 = null;
                                                    c11172.I$0 = i12;
                                                    c11172.label = 9;
                                                    objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager2, str11, null, null, mapK, c11172, 6, null);
                                                    if (objChangeGroupConfigs$default != objG) {
                                                        u0Var12 = u0Var11;
                                                        y0Var10 = y0Var9;
                                                        y0Var9 = y0Var10;
                                                        u0Var9 = u0Var12;
                                                    }
                                                }
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                            }
                                        }
                                        return cb.b.a(u0Var9.f36629c);
                                    }
                                    long length = file12.length();
                                    c11172.L$0 = cb.l.a(uri8);
                                    c11172.L$1 = str9;
                                    c11172.L$2 = cb.l.a(file11);
                                    c11172.L$3 = u0Var8;
                                    c11172.L$4 = y0Var6;
                                    c11172.L$5 = cb.l.a(pair4);
                                    c11172.L$6 = cb.l.a(file9);
                                    c11172.L$7 = cb.l.a(fileResult4);
                                    c11172.L$8 = cb.l.a(file12);
                                    c11172.L$9 = file12;
                                    c11172.I$0 = i10;
                                    c11172.label = 7;
                                    u0 u0Var14 = u0Var8;
                                    Object putUrl$default = UrlManager.getPutUrl$default(urlManager2, str9, 6, length, false, c11172, 8, null);
                                    if (putUrl$default != objG) {
                                        file17 = file12;
                                        file18 = file9;
                                        y0Var8 = y0Var6;
                                        file19 = file11;
                                        uri10 = uri8;
                                        pair5 = pair4;
                                        u0Var10 = u0Var14;
                                        obj7 = putUrl$default;
                                        str10 = str9;
                                        i11 = 0;
                                        file20 = file17;
                                        pair4 = pair5;
                                        file13 = file20;
                                        fileResult5 = (FileResponse.FileResult) obj7;
                                        uri9 = uri10;
                                        file16 = file19;
                                        file15 = file18;
                                        y0Var7 = y0Var8;
                                        file14 = file17;
                                        u0Var9 = u0Var10;
                                        fileResult6 = fileResult4;
                                        if (fileResult5 != null) {
                                            UploadDataSource.Companion companion2 = UploadDataSource.INSTANCE;
                                            uri11 = uri9;
                                            String path4 = file13.getPath();
                                            kotlin.jvm.internal.y.h(path4, "getPath(...)");
                                            String put2 = fileResult5.getPut();
                                            file21 = file13;
                                            c11172.L$0 = cb.l.a(uri11);
                                            c11172.L$1 = str10;
                                            c11172.L$2 = cb.l.a(file16);
                                            c11172.L$3 = u0Var9;
                                            c11172.L$4 = y0Var7;
                                            c11172.L$5 = cb.l.a(pair4);
                                            c11172.L$6 = cb.l.a(file15);
                                            c11172.L$7 = cb.l.a(fileResult6);
                                            c11172.L$8 = cb.l.a(file14);
                                            c11172.L$9 = cb.l.a(file21);
                                            c11172.L$10 = fileResult5;
                                            c11172.L$11 = u0Var9;
                                            c11172.I$0 = i11;
                                            c11172.label = 8;
                                            objDirectUpload = companion2.directUpload(put2, path4, c11172);
                                            if (objDirectUpload != objG) {
                                                file22 = file21;
                                                y0Var9 = y0Var7;
                                                str11 = str10;
                                                fileResult7 = fileResult5;
                                                file23 = file15;
                                                i12 = i11;
                                                u0Var11 = u0Var9;
                                                uri12 = uri11;
                                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                }
                                                xMPPDataSource4 = this.mXMPPDataSource;
                                                if (xMPPDataSource4 != null) {
                                                }
                                                u0Var9 = u0Var11;
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                            }
                                        }
                                        return cb.b.a(u0Var9.f36629c);
                                    }
                                }
                            } else {
                                UploadDataSource.Companion companion3 = UploadDataSource.INSTANCE;
                                String path5 = file4.getPath();
                                kotlin.jvm.internal.y.h(path5, "getPath(...)");
                                String put3 = fileResult2.getPut();
                                c11172.L$0 = cb.l.a(uri4);
                                c11172.L$1 = str5;
                                c11172.L$2 = file5;
                                c11172.L$3 = u0Var4;
                                c11172.L$4 = y0Var3;
                                c11172.L$5 = pair2;
                                c11172.L$6 = cb.l.a(file4);
                                c11172.L$7 = fileResult2;
                                c11172.L$8 = u0Var4;
                                c11172.label = 4;
                                Object objDirectUpload2 = companion3.directUpload(put3, path5, c11172);
                                if (objDirectUpload2 != objG) {
                                    file6 = file4;
                                    y0Var4 = y0Var3;
                                    fileResult3 = fileResult2;
                                    file7 = file5;
                                    uri6 = uri4;
                                    u0Var6 = u0Var4;
                                    obj4 = objDirectUpload2;
                                    u0Var4.f36629c = ((Boolean) obj4).booleanValue();
                                    if (u0Var6.f36629c) {
                                        y0Var4.f36634c = ua.z.a("", fileResult3.getGet());
                                    }
                                    xMPPDataSource2 = this.mXMPPDataSource;
                                    if (xMPPDataSource2 != null || (groupsManager = xMPPDataSource2.getGroupsManager()) == null) {
                                        y0 y0Var13 = y0Var4;
                                        u0 u0Var15 = u0Var6;
                                        str5 = str5;
                                        file4 = file6;
                                        file5 = file7;
                                        y0Var3 = y0Var13;
                                        u0Var4 = u0Var15;
                                        uri4 = uri6;
                                        fileResult2 = fileResult3;
                                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var3.f36634c).getSecond());
                                        final Pair pair7 = pair2;
                                        y0Var6 = y0Var3;
                                        file9 = file4;
                                        fileResult4 = fileResult2;
                                        file10 = file5;
                                        str8 = str5;
                                        Compressor compressor3 = Compressor.INSTANCE;
                                        Context context3 = this.context;
                                        Function1 function3 = new Function1() { // from class: cu.todus.android.repositories.j0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj8) {
                                                return MainRepository.updateGroupImage$lambda$1(pair7, (Compression) obj8);
                                            }
                                        };
                                        c11172.L$0 = cb.l.a(uri4);
                                        c11172.L$1 = str8;
                                        c11172.L$2 = cb.l.a(file10);
                                        c11172.L$3 = u0Var4;
                                        c11172.L$4 = y0Var6;
                                        c11172.L$5 = cb.l.a(pair7);
                                        c11172.L$6 = cb.l.a(file9);
                                        c11172.L$7 = cb.l.a(fileResult4);
                                        c11172.L$8 = null;
                                        c11172.label = 6;
                                        pair4 = pair7;
                                        objCompress$default2 = Compressor.compress$default(compressor3, context3, file10, false, null, function3, c11172, 12, null);
                                        if (objCompress$default2 != objG) {
                                            u0Var8 = u0Var4;
                                            obj6 = objCompress$default2;
                                            str9 = str8;
                                            uri8 = uri4;
                                            file11 = file10;
                                            file12 = (File) obj6;
                                            xMPPDataSource3 = this.mXMPPDataSource;
                                            if (xMPPDataSource3 != null) {
                                            }
                                            file13 = file12;
                                            file14 = file13;
                                            file15 = file9;
                                            y0Var7 = y0Var6;
                                            file16 = file11;
                                            uri9 = uri8;
                                            u0Var9 = u0Var8;
                                            i11 = 0;
                                            str10 = str9;
                                            fileResult5 = null;
                                            fileResult6 = fileResult4;
                                            if (fileResult5 != null) {
                                                UploadDataSource.Companion companion4 = UploadDataSource.INSTANCE;
                                                uri11 = uri9;
                                                String path6 = file13.getPath();
                                                kotlin.jvm.internal.y.h(path6, "getPath(...)");
                                                String put4 = fileResult5.getPut();
                                                file21 = file13;
                                                c11172.L$0 = cb.l.a(uri11);
                                                c11172.L$1 = str10;
                                                c11172.L$2 = cb.l.a(file16);
                                                c11172.L$3 = u0Var9;
                                                c11172.L$4 = y0Var7;
                                                c11172.L$5 = cb.l.a(pair4);
                                                c11172.L$6 = cb.l.a(file15);
                                                c11172.L$7 = cb.l.a(fileResult6);
                                                c11172.L$8 = cb.l.a(file14);
                                                c11172.L$9 = cb.l.a(file21);
                                                c11172.L$10 = fileResult5;
                                                c11172.L$11 = u0Var9;
                                                c11172.I$0 = i11;
                                                c11172.label = 8;
                                                objDirectUpload = companion4.directUpload(put4, path6, c11172);
                                                if (objDirectUpload != objG) {
                                                    file22 = file21;
                                                    y0Var9 = y0Var7;
                                                    str11 = str10;
                                                    fileResult7 = fileResult5;
                                                    file23 = file15;
                                                    i12 = i11;
                                                    u0Var11 = u0Var9;
                                                    uri12 = uri11;
                                                    u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                    if (u0Var11.f36629c) {
                                                        y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                    }
                                                    xMPPDataSource4 = this.mXMPPDataSource;
                                                    if (xMPPDataSource4 != null) {
                                                    }
                                                    u0Var9 = u0Var11;
                                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                                }
                                            }
                                            return cb.b.a(u0Var9.f36629c);
                                        }
                                    } else {
                                        Pair[] pairArr = new Pair[1];
                                        pairArr[i10] = ua.z.a(Room.CONFIG_PICTURE, ((Pair) y0Var4.f36634c).getSecond());
                                        HashMap mapK2 = w0.k(pairArr);
                                        c11172.L$0 = cb.l.a(uri6);
                                        c11172.L$1 = str5;
                                        c11172.L$2 = file7;
                                        c11172.L$3 = u0Var6;
                                        c11172.L$4 = y0Var4;
                                        c11172.L$5 = pair2;
                                        c11172.L$6 = cb.l.a(file6);
                                        c11172.L$7 = cb.l.a(fileResult3);
                                        c11172.L$8 = null;
                                        c11172.label = 5;
                                        File file26 = file7;
                                        u0 u0Var16 = u0Var6;
                                        String str12 = str5;
                                        y0 y0Var14 = y0Var4;
                                        Object objChangeGroupConfigs$default2 = GroupsManager.changeGroupConfigs$default(groupsManager, str12, null, null, mapK2, c11172, 6, null);
                                        if (objChangeGroupConfigs$default2 != objG) {
                                            c11172 = c11172;
                                            y0Var5 = y0Var14;
                                            obj5 = objChangeGroupConfigs$default2;
                                            str7 = str12;
                                            file4 = file6;
                                            pair3 = pair2;
                                            file8 = file26;
                                            u0Var7 = u0Var16;
                                            uri7 = uri6;
                                            pair2 = pair3;
                                            y0Var3 = y0Var5;
                                            u0Var4 = u0Var7;
                                            file5 = file8;
                                            uri4 = uri7;
                                            str5 = str7;
                                            fileResult2 = fileResult3;
                                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var3.f36634c).getSecond());
                                            final Pair pair8 = pair2;
                                            y0Var6 = y0Var3;
                                            file9 = file4;
                                            fileResult4 = fileResult2;
                                            file10 = file5;
                                            str8 = str5;
                                            Compressor compressor4 = Compressor.INSTANCE;
                                            Context context4 = this.context;
                                            Function1 function4 = new Function1() { // from class: cu.todus.android.repositories.j0
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj8) {
                                                    return MainRepository.updateGroupImage$lambda$1(pair8, (Compression) obj8);
                                                }
                                            };
                                            c11172.L$0 = cb.l.a(uri4);
                                            c11172.L$1 = str8;
                                            c11172.L$2 = cb.l.a(file10);
                                            c11172.L$3 = u0Var4;
                                            c11172.L$4 = y0Var6;
                                            c11172.L$5 = cb.l.a(pair8);
                                            c11172.L$6 = cb.l.a(file9);
                                            c11172.L$7 = cb.l.a(fileResult4);
                                            c11172.L$8 = null;
                                            c11172.label = 6;
                                            pair4 = pair8;
                                            objCompress$default2 = Compressor.compress$default(compressor4, context4, file10, false, null, function4, c11172, 12, null);
                                            if (objCompress$default2 != objG) {
                                                u0Var8 = u0Var4;
                                                obj6 = objCompress$default2;
                                                str9 = str8;
                                                uri8 = uri4;
                                                file11 = file10;
                                                file12 = (File) obj6;
                                                xMPPDataSource3 = this.mXMPPDataSource;
                                                if (xMPPDataSource3 != null) {
                                                }
                                                file13 = file12;
                                                file14 = file13;
                                                file15 = file9;
                                                y0Var7 = y0Var6;
                                                file16 = file11;
                                                uri9 = uri8;
                                                u0Var9 = u0Var8;
                                                i11 = 0;
                                                str10 = str9;
                                                fileResult5 = null;
                                                fileResult6 = fileResult4;
                                                if (fileResult5 != null) {
                                                    UploadDataSource.Companion companion5 = UploadDataSource.INSTANCE;
                                                    uri11 = uri9;
                                                    String path7 = file13.getPath();
                                                    kotlin.jvm.internal.y.h(path7, "getPath(...)");
                                                    String put5 = fileResult5.getPut();
                                                    file21 = file13;
                                                    c11172.L$0 = cb.l.a(uri11);
                                                    c11172.L$1 = str10;
                                                    c11172.L$2 = cb.l.a(file16);
                                                    c11172.L$3 = u0Var9;
                                                    c11172.L$4 = y0Var7;
                                                    c11172.L$5 = cb.l.a(pair4);
                                                    c11172.L$6 = cb.l.a(file15);
                                                    c11172.L$7 = cb.l.a(fileResult6);
                                                    c11172.L$8 = cb.l.a(file14);
                                                    c11172.L$9 = cb.l.a(file21);
                                                    c11172.L$10 = fileResult5;
                                                    c11172.L$11 = u0Var9;
                                                    c11172.I$0 = i11;
                                                    c11172.label = 8;
                                                    objDirectUpload = companion5.directUpload(put5, path7, c11172);
                                                    if (objDirectUpload != objG) {
                                                        file22 = file21;
                                                        y0Var9 = y0Var7;
                                                        str11 = str10;
                                                        fileResult7 = fileResult5;
                                                        file23 = file15;
                                                        i12 = i11;
                                                        u0Var11 = u0Var9;
                                                        uri12 = uri11;
                                                        u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                        if (u0Var11.f36629c) {
                                                            y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                        }
                                                        xMPPDataSource4 = this.mXMPPDataSource;
                                                        if (xMPPDataSource4 != null) {
                                                        }
                                                        u0Var9 = u0Var11;
                                                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                                    }
                                                }
                                                return cb.b.a(u0Var9.f36629c);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            long length2 = file3.length();
                            c11172.L$0 = cb.l.a(uri4);
                            c11172.L$1 = str4;
                            c11172.L$2 = file2;
                            c11172.L$3 = u0Var3;
                            c11172.L$4 = y0Var2;
                            c11172.L$5 = pair2;
                            c11172.L$6 = file3;
                            c11172.label = 3;
                            File file27 = file2;
                            y0 y0Var15 = y0Var2;
                            u0 u0Var17 = u0Var3;
                            String str13 = str4;
                            Object putUrl$default2 = UrlManager.getPutUrl$default(urlManager, str13, 5, length2, false, c11172, 8, null);
                            if (putUrl$default2 != objG) {
                                file4 = file3;
                                obj3 = putUrl$default2;
                                str6 = str13;
                                uri5 = uri4;
                                file5 = file27;
                                y0Var3 = y0Var15;
                                u0Var5 = u0Var17;
                                u0 u0Var18 = u0Var5;
                                fileResult2 = (FileResponse.FileResult) obj3;
                                u0Var4 = u0Var18;
                                str5 = str6;
                                uri4 = uri5;
                                if (fileResult2 != null) {
                                    final Pair pair9 = pair2;
                                    y0Var6 = y0Var3;
                                    file9 = file4;
                                    fileResult4 = fileResult2;
                                    file10 = file5;
                                    str8 = str5;
                                    Compressor compressor5 = Compressor.INSTANCE;
                                    Context context5 = this.context;
                                    Function1 function5 = new Function1() { // from class: cu.todus.android.repositories.j0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj8) {
                                            return MainRepository.updateGroupImage$lambda$1(pair9, (Compression) obj8);
                                        }
                                    };
                                    c11172.L$0 = cb.l.a(uri4);
                                    c11172.L$1 = str8;
                                    c11172.L$2 = cb.l.a(file10);
                                    c11172.L$3 = u0Var4;
                                    c11172.L$4 = y0Var6;
                                    c11172.L$5 = cb.l.a(pair9);
                                    c11172.L$6 = cb.l.a(file9);
                                    c11172.L$7 = cb.l.a(fileResult4);
                                    c11172.L$8 = null;
                                    c11172.label = 6;
                                    pair4 = pair9;
                                    objCompress$default2 = Compressor.compress$default(compressor5, context5, file10, false, null, function5, c11172, 12, null);
                                    if (objCompress$default2 != objG) {
                                        u0Var8 = u0Var4;
                                        obj6 = objCompress$default2;
                                        str9 = str8;
                                        uri8 = uri4;
                                        file11 = file10;
                                        file12 = (File) obj6;
                                        xMPPDataSource3 = this.mXMPPDataSource;
                                        if (xMPPDataSource3 != null) {
                                        }
                                        file13 = file12;
                                        file14 = file13;
                                        file15 = file9;
                                        y0Var7 = y0Var6;
                                        file16 = file11;
                                        uri9 = uri8;
                                        u0Var9 = u0Var8;
                                        i11 = 0;
                                        str10 = str9;
                                        fileResult5 = null;
                                        fileResult6 = fileResult4;
                                        if (fileResult5 != null) {
                                            UploadDataSource.Companion companion6 = UploadDataSource.INSTANCE;
                                            uri11 = uri9;
                                            String path8 = file13.getPath();
                                            kotlin.jvm.internal.y.h(path8, "getPath(...)");
                                            String put6 = fileResult5.getPut();
                                            file21 = file13;
                                            c11172.L$0 = cb.l.a(uri11);
                                            c11172.L$1 = str10;
                                            c11172.L$2 = cb.l.a(file16);
                                            c11172.L$3 = u0Var9;
                                            c11172.L$4 = y0Var7;
                                            c11172.L$5 = cb.l.a(pair4);
                                            c11172.L$6 = cb.l.a(file15);
                                            c11172.L$7 = cb.l.a(fileResult6);
                                            c11172.L$8 = cb.l.a(file14);
                                            c11172.L$9 = cb.l.a(file21);
                                            c11172.L$10 = fileResult5;
                                            c11172.L$11 = u0Var9;
                                            c11172.I$0 = i11;
                                            c11172.label = 8;
                                            objDirectUpload = companion6.directUpload(put6, path8, c11172);
                                            if (objDirectUpload != objG) {
                                                file22 = file21;
                                                y0Var9 = y0Var7;
                                                str11 = str10;
                                                fileResult7 = fileResult5;
                                                file23 = file15;
                                                i12 = i11;
                                                u0Var11 = u0Var9;
                                                uri12 = uri11;
                                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                }
                                                xMPPDataSource4 = this.mXMPPDataSource;
                                                if (xMPPDataSource4 != null) {
                                                }
                                                u0Var9 = u0Var11;
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                            }
                                        }
                                        return cb.b.a(u0Var9.f36629c);
                                    }
                                } else {
                                    final Pair pair10 = pair2;
                                    y0Var6 = y0Var3;
                                    file9 = file4;
                                    fileResult4 = fileResult2;
                                    file10 = file5;
                                    str8 = str5;
                                    Compressor compressor6 = Compressor.INSTANCE;
                                    Context context6 = this.context;
                                    Function1 function6 = new Function1() { // from class: cu.todus.android.repositories.j0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj8) {
                                            return MainRepository.updateGroupImage$lambda$1(pair10, (Compression) obj8);
                                        }
                                    };
                                    c11172.L$0 = cb.l.a(uri4);
                                    c11172.L$1 = str8;
                                    c11172.L$2 = cb.l.a(file10);
                                    c11172.L$3 = u0Var4;
                                    c11172.L$4 = y0Var6;
                                    c11172.L$5 = cb.l.a(pair10);
                                    c11172.L$6 = cb.l.a(file9);
                                    c11172.L$7 = cb.l.a(fileResult4);
                                    c11172.L$8 = null;
                                    c11172.label = 6;
                                    pair4 = pair10;
                                    objCompress$default2 = Compressor.compress$default(compressor6, context6, file10, false, null, function6, c11172, 12, null);
                                    if (objCompress$default2 != objG) {
                                        u0Var8 = u0Var4;
                                        obj6 = objCompress$default2;
                                        str9 = str8;
                                        uri8 = uri4;
                                        file11 = file10;
                                        file12 = (File) obj6;
                                        xMPPDataSource3 = this.mXMPPDataSource;
                                        if (xMPPDataSource3 != null) {
                                        }
                                        file13 = file12;
                                        file14 = file13;
                                        file15 = file9;
                                        y0Var7 = y0Var6;
                                        file16 = file11;
                                        uri9 = uri8;
                                        u0Var9 = u0Var8;
                                        i11 = 0;
                                        str10 = str9;
                                        fileResult5 = null;
                                        fileResult6 = fileResult4;
                                        if (fileResult5 != null) {
                                            UploadDataSource.Companion companion7 = UploadDataSource.INSTANCE;
                                            uri11 = uri9;
                                            String path9 = file13.getPath();
                                            kotlin.jvm.internal.y.h(path9, "getPath(...)");
                                            String put7 = fileResult5.getPut();
                                            file21 = file13;
                                            c11172.L$0 = cb.l.a(uri11);
                                            c11172.L$1 = str10;
                                            c11172.L$2 = cb.l.a(file16);
                                            c11172.L$3 = u0Var9;
                                            c11172.L$4 = y0Var7;
                                            c11172.L$5 = cb.l.a(pair4);
                                            c11172.L$6 = cb.l.a(file15);
                                            c11172.L$7 = cb.l.a(fileResult6);
                                            c11172.L$8 = cb.l.a(file14);
                                            c11172.L$9 = cb.l.a(file21);
                                            c11172.L$10 = fileResult5;
                                            c11172.L$11 = u0Var9;
                                            c11172.I$0 = i11;
                                            c11172.label = 8;
                                            objDirectUpload = companion7.directUpload(put7, path9, c11172);
                                            if (objDirectUpload != objG) {
                                                file22 = file21;
                                                y0Var9 = y0Var7;
                                                str11 = str10;
                                                fileResult7 = fileResult5;
                                                file23 = file15;
                                                i12 = i11;
                                                u0Var11 = u0Var9;
                                                uri12 = uri11;
                                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                                if (u0Var11.f36629c) {
                                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                                }
                                                xMPPDataSource4 = this.mXMPPDataSource;
                                                if (xMPPDataSource4 != null) {
                                                }
                                                u0Var9 = u0Var11;
                                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                            }
                                        }
                                        return cb.b.a(u0Var9.f36629c);
                                    }
                                }
                            }
                        }
                    }
                }
                c11172 = c11172;
                return objG;
            case 1:
                obj = objChangeGroupConfigs$default;
                i10 = 0;
                y0 y0Var16 = (y0) c11172.L$4;
                u0Var = (u0) c11172.L$3;
                file = (File) c11172.L$2;
                String str14 = (String) c11172.L$1;
                Uri uri13 = (Uri) c11172.L$0;
                ua.v.b(obj);
                y0Var = y0Var16;
                str2 = str14;
                uri3 = uri13;
                file2 = file;
                pair = (Pair) obj;
                Compressor compressor7 = Compressor.INSTANCE;
                Context context7 = this.context;
                Function1 function7 = new Function1() { // from class: cu.todus.android.repositories.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj8) {
                        return MainRepository.updateGroupImage$lambda$0(pair, (Compression) obj8);
                    }
                };
                c11172.L$0 = cb.l.a(uri3);
                c11172.L$1 = str2;
                c11172.L$2 = file2;
                c11172.L$3 = u0Var;
                c11172.L$4 = y0Var;
                c11172.L$5 = pair;
                c11172.label = 2;
                u0Var2 = u0Var;
                str3 = str2;
                fileResult = null;
                objCompress$default = Compressor.compress$default(compressor7, context7, file2, false, null, function7, c11172, 12, null);
                if (objCompress$default != objG) {
                    uri4 = uri3;
                    obj2 = objCompress$default;
                    y0Var2 = y0Var;
                    pair2 = pair;
                    str4 = str3;
                    u0Var3 = u0Var2;
                    file3 = (File) obj2;
                    xMPPDataSource = this.mXMPPDataSource;
                    if (xMPPDataSource != null) {
                    }
                    y0 y0Var17 = y0Var2;
                    u0 u0Var19 = u0Var3;
                    File file28 = file2;
                    file4 = file3;
                    str5 = str4;
                    fileResult2 = fileResult;
                    file5 = file28;
                    y0Var3 = y0Var17;
                    u0Var4 = u0Var19;
                    if (fileResult2 != null) {
                        final Pair pair11 = pair2;
                        y0Var6 = y0Var3;
                        file9 = file4;
                        fileResult4 = fileResult2;
                        file10 = file5;
                        str8 = str5;
                        Compressor compressor8 = Compressor.INSTANCE;
                        Context context8 = this.context;
                        Function1 function8 = new Function1() { // from class: cu.todus.android.repositories.j0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj8) {
                                return MainRepository.updateGroupImage$lambda$1(pair11, (Compression) obj8);
                            }
                        };
                        c11172.L$0 = cb.l.a(uri4);
                        c11172.L$1 = str8;
                        c11172.L$2 = cb.l.a(file10);
                        c11172.L$3 = u0Var4;
                        c11172.L$4 = y0Var6;
                        c11172.L$5 = cb.l.a(pair11);
                        c11172.L$6 = cb.l.a(file9);
                        c11172.L$7 = cb.l.a(fileResult4);
                        c11172.L$8 = null;
                        c11172.label = 6;
                        pair4 = pair11;
                        objCompress$default2 = Compressor.compress$default(compressor8, context8, file10, false, null, function8, c11172, 12, null);
                        if (objCompress$default2 != objG) {
                            u0Var8 = u0Var4;
                            obj6 = objCompress$default2;
                            str9 = str8;
                            uri8 = uri4;
                            file11 = file10;
                            file12 = (File) obj6;
                            xMPPDataSource3 = this.mXMPPDataSource;
                            if (xMPPDataSource3 != null) {
                                break;
                            }
                            file13 = file12;
                            file14 = file13;
                            file15 = file9;
                            y0Var7 = y0Var6;
                            file16 = file11;
                            uri9 = uri8;
                            u0Var9 = u0Var8;
                            i11 = 0;
                            str10 = str9;
                            fileResult5 = null;
                            fileResult6 = fileResult4;
                            if (fileResult5 != null) {
                                UploadDataSource.Companion companion8 = UploadDataSource.INSTANCE;
                                uri11 = uri9;
                                String path10 = file13.getPath();
                                kotlin.jvm.internal.y.h(path10, "getPath(...)");
                                String put8 = fileResult5.getPut();
                                file21 = file13;
                                c11172.L$0 = cb.l.a(uri11);
                                c11172.L$1 = str10;
                                c11172.L$2 = cb.l.a(file16);
                                c11172.L$3 = u0Var9;
                                c11172.L$4 = y0Var7;
                                c11172.L$5 = cb.l.a(pair4);
                                c11172.L$6 = cb.l.a(file15);
                                c11172.L$7 = cb.l.a(fileResult6);
                                c11172.L$8 = cb.l.a(file14);
                                c11172.L$9 = cb.l.a(file21);
                                c11172.L$10 = fileResult5;
                                c11172.L$11 = u0Var9;
                                c11172.I$0 = i11;
                                c11172.label = 8;
                                objDirectUpload = companion8.directUpload(put8, path10, c11172);
                                if (objDirectUpload != objG) {
                                    file22 = file21;
                                    y0Var9 = y0Var7;
                                    str11 = str10;
                                    fileResult7 = fileResult5;
                                    file23 = file15;
                                    i12 = i11;
                                    u0Var11 = u0Var9;
                                    uri12 = uri11;
                                    u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                    if (u0Var11.f36629c) {
                                        y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                    }
                                    xMPPDataSource4 = this.mXMPPDataSource;
                                    if (xMPPDataSource4 != null) {
                                    }
                                    u0Var9 = u0Var11;
                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                }
                                break;
                            }
                            return cb.b.a(u0Var9.f36629c);
                        }
                    } else {
                        final Pair pair12 = pair2;
                        y0Var6 = y0Var3;
                        file9 = file4;
                        fileResult4 = fileResult2;
                        file10 = file5;
                        str8 = str5;
                        Compressor compressor9 = Compressor.INSTANCE;
                        Context context9 = this.context;
                        Function1 function9 = new Function1() { // from class: cu.todus.android.repositories.j0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj8) {
                                return MainRepository.updateGroupImage$lambda$1(pair12, (Compression) obj8);
                            }
                        };
                        c11172.L$0 = cb.l.a(uri4);
                        c11172.L$1 = str8;
                        c11172.L$2 = cb.l.a(file10);
                        c11172.L$3 = u0Var4;
                        c11172.L$4 = y0Var6;
                        c11172.L$5 = cb.l.a(pair12);
                        c11172.L$6 = cb.l.a(file9);
                        c11172.L$7 = cb.l.a(fileResult4);
                        c11172.L$8 = null;
                        c11172.label = 6;
                        pair4 = pair12;
                        objCompress$default2 = Compressor.compress$default(compressor9, context9, file10, false, null, function9, c11172, 12, null);
                        if (objCompress$default2 != objG) {
                            u0Var8 = u0Var4;
                            obj6 = objCompress$default2;
                            str9 = str8;
                            uri8 = uri4;
                            file11 = file10;
                            file12 = (File) obj6;
                            xMPPDataSource3 = this.mXMPPDataSource;
                            if (xMPPDataSource3 != null) {
                                break;
                            }
                            file13 = file12;
                            file14 = file13;
                            file15 = file9;
                            y0Var7 = y0Var6;
                            file16 = file11;
                            uri9 = uri8;
                            u0Var9 = u0Var8;
                            i11 = 0;
                            str10 = str9;
                            fileResult5 = null;
                            fileResult6 = fileResult4;
                            if (fileResult5 != null) {
                                UploadDataSource.Companion companion9 = UploadDataSource.INSTANCE;
                                uri11 = uri9;
                                String path11 = file13.getPath();
                                kotlin.jvm.internal.y.h(path11, "getPath(...)");
                                String put9 = fileResult5.getPut();
                                file21 = file13;
                                c11172.L$0 = cb.l.a(uri11);
                                c11172.L$1 = str10;
                                c11172.L$2 = cb.l.a(file16);
                                c11172.L$3 = u0Var9;
                                c11172.L$4 = y0Var7;
                                c11172.L$5 = cb.l.a(pair4);
                                c11172.L$6 = cb.l.a(file15);
                                c11172.L$7 = cb.l.a(fileResult6);
                                c11172.L$8 = cb.l.a(file14);
                                c11172.L$9 = cb.l.a(file21);
                                c11172.L$10 = fileResult5;
                                c11172.L$11 = u0Var9;
                                c11172.I$0 = i11;
                                c11172.label = 8;
                                objDirectUpload = companion9.directUpload(put9, path11, c11172);
                                if (objDirectUpload != objG) {
                                    file22 = file21;
                                    y0Var9 = y0Var7;
                                    str11 = str10;
                                    fileResult7 = fileResult5;
                                    file23 = file15;
                                    i12 = i11;
                                    u0Var11 = u0Var9;
                                    uri12 = uri11;
                                    u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                    if (u0Var11.f36629c) {
                                        y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                    }
                                    xMPPDataSource4 = this.mXMPPDataSource;
                                    if (xMPPDataSource4 != null) {
                                    }
                                    u0Var9 = u0Var11;
                                    Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                                }
                                break;
                            }
                            return cb.b.a(u0Var9.f36629c);
                        }
                    }
                }
                c11172 = c11172;
                return objG;
            case 2:
                i10 = 0;
                Pair pair13 = (Pair) c11172.L$5;
                y0Var2 = (y0) c11172.L$4;
                u0Var3 = (u0) c11172.L$3;
                file2 = (File) c11172.L$2;
                str4 = (String) c11172.L$1;
                Uri uri14 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                pair2 = pair13;
                obj2 = objChangeGroupConfigs$default;
                fileResult = null;
                uri4 = uri14;
                file3 = (File) obj2;
                xMPPDataSource = this.mXMPPDataSource;
                if (xMPPDataSource != null) {
                    break;
                }
                y0 y0Var18 = y0Var2;
                u0 u0Var110 = u0Var3;
                File file29 = file2;
                file4 = file3;
                str5 = str4;
                fileResult2 = fileResult;
                file5 = file29;
                y0Var3 = y0Var18;
                u0Var4 = u0Var110;
                if (fileResult2 != null) {
                    final Pair pair14 = pair2;
                    y0Var6 = y0Var3;
                    file9 = file4;
                    fileResult4 = fileResult2;
                    file10 = file5;
                    str8 = str5;
                    Compressor compressor10 = Compressor.INSTANCE;
                    Context context10 = this.context;
                    Function1 function10 = new Function1() { // from class: cu.todus.android.repositories.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            return MainRepository.updateGroupImage$lambda$1(pair14, (Compression) obj8);
                        }
                    };
                    c11172.L$0 = cb.l.a(uri4);
                    c11172.L$1 = str8;
                    c11172.L$2 = cb.l.a(file10);
                    c11172.L$3 = u0Var4;
                    c11172.L$4 = y0Var6;
                    c11172.L$5 = cb.l.a(pair14);
                    c11172.L$6 = cb.l.a(file9);
                    c11172.L$7 = cb.l.a(fileResult4);
                    c11172.L$8 = null;
                    c11172.label = 6;
                    pair4 = pair14;
                    objCompress$default2 = Compressor.compress$default(compressor10, context10, file10, false, null, function10, c11172, 12, null);
                    if (objCompress$default2 != objG) {
                        u0Var8 = u0Var4;
                        obj6 = objCompress$default2;
                        str9 = str8;
                        uri8 = uri4;
                        file11 = file10;
                        file12 = (File) obj6;
                        xMPPDataSource3 = this.mXMPPDataSource;
                        if (xMPPDataSource3 != null) {
                            break;
                        }
                        file13 = file12;
                        file14 = file13;
                        file15 = file9;
                        y0Var7 = y0Var6;
                        file16 = file11;
                        uri9 = uri8;
                        u0Var9 = u0Var8;
                        i11 = 0;
                        str10 = str9;
                        fileResult5 = null;
                        fileResult6 = fileResult4;
                        if (fileResult5 != null) {
                            UploadDataSource.Companion companion10 = UploadDataSource.INSTANCE;
                            uri11 = uri9;
                            String path12 = file13.getPath();
                            kotlin.jvm.internal.y.h(path12, "getPath(...)");
                            String put10 = fileResult5.getPut();
                            file21 = file13;
                            c11172.L$0 = cb.l.a(uri11);
                            c11172.L$1 = str10;
                            c11172.L$2 = cb.l.a(file16);
                            c11172.L$3 = u0Var9;
                            c11172.L$4 = y0Var7;
                            c11172.L$5 = cb.l.a(pair4);
                            c11172.L$6 = cb.l.a(file15);
                            c11172.L$7 = cb.l.a(fileResult6);
                            c11172.L$8 = cb.l.a(file14);
                            c11172.L$9 = cb.l.a(file21);
                            c11172.L$10 = fileResult5;
                            c11172.L$11 = u0Var9;
                            c11172.I$0 = i11;
                            c11172.label = 8;
                            objDirectUpload = companion10.directUpload(put10, path12, c11172);
                            if (objDirectUpload != objG) {
                                file22 = file21;
                                y0Var9 = y0Var7;
                                str11 = str10;
                                fileResult7 = fileResult5;
                                file23 = file15;
                                i12 = i11;
                                u0Var11 = u0Var9;
                                uri12 = uri11;
                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                if (u0Var11.f36629c) {
                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                }
                                xMPPDataSource4 = this.mXMPPDataSource;
                                if (xMPPDataSource4 != null) {
                                }
                                u0Var9 = u0Var11;
                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                            }
                            break;
                        }
                        return cb.b.a(u0Var9.f36629c);
                    }
                } else {
                    final Pair pair15 = pair2;
                    y0Var6 = y0Var3;
                    file9 = file4;
                    fileResult4 = fileResult2;
                    file10 = file5;
                    str8 = str5;
                    Compressor compressor11 = Compressor.INSTANCE;
                    Context context11 = this.context;
                    Function1 function11 = new Function1() { // from class: cu.todus.android.repositories.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            return MainRepository.updateGroupImage$lambda$1(pair15, (Compression) obj8);
                        }
                    };
                    c11172.L$0 = cb.l.a(uri4);
                    c11172.L$1 = str8;
                    c11172.L$2 = cb.l.a(file10);
                    c11172.L$3 = u0Var4;
                    c11172.L$4 = y0Var6;
                    c11172.L$5 = cb.l.a(pair15);
                    c11172.L$6 = cb.l.a(file9);
                    c11172.L$7 = cb.l.a(fileResult4);
                    c11172.L$8 = null;
                    c11172.label = 6;
                    pair4 = pair15;
                    objCompress$default2 = Compressor.compress$default(compressor11, context11, file10, false, null, function11, c11172, 12, null);
                    if (objCompress$default2 != objG) {
                        u0Var8 = u0Var4;
                        obj6 = objCompress$default2;
                        str9 = str8;
                        uri8 = uri4;
                        file11 = file10;
                        file12 = (File) obj6;
                        xMPPDataSource3 = this.mXMPPDataSource;
                        if (xMPPDataSource3 != null) {
                            break;
                        }
                        file13 = file12;
                        file14 = file13;
                        file15 = file9;
                        y0Var7 = y0Var6;
                        file16 = file11;
                        uri9 = uri8;
                        u0Var9 = u0Var8;
                        i11 = 0;
                        str10 = str9;
                        fileResult5 = null;
                        fileResult6 = fileResult4;
                        if (fileResult5 != null) {
                            UploadDataSource.Companion companion11 = UploadDataSource.INSTANCE;
                            uri11 = uri9;
                            String path13 = file13.getPath();
                            kotlin.jvm.internal.y.h(path13, "getPath(...)");
                            String put11 = fileResult5.getPut();
                            file21 = file13;
                            c11172.L$0 = cb.l.a(uri11);
                            c11172.L$1 = str10;
                            c11172.L$2 = cb.l.a(file16);
                            c11172.L$3 = u0Var9;
                            c11172.L$4 = y0Var7;
                            c11172.L$5 = cb.l.a(pair4);
                            c11172.L$6 = cb.l.a(file15);
                            c11172.L$7 = cb.l.a(fileResult6);
                            c11172.L$8 = cb.l.a(file14);
                            c11172.L$9 = cb.l.a(file21);
                            c11172.L$10 = fileResult5;
                            c11172.L$11 = u0Var9;
                            c11172.I$0 = i11;
                            c11172.label = 8;
                            objDirectUpload = companion11.directUpload(put11, path13, c11172);
                            if (objDirectUpload != objG) {
                                file22 = file21;
                                y0Var9 = y0Var7;
                                str11 = str10;
                                fileResult7 = fileResult5;
                                file23 = file15;
                                i12 = i11;
                                u0Var11 = u0Var9;
                                uri12 = uri11;
                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                if (u0Var11.f36629c) {
                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                }
                                xMPPDataSource4 = this.mXMPPDataSource;
                                if (xMPPDataSource4 != null) {
                                }
                                u0Var9 = u0Var11;
                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                            }
                            break;
                        }
                        return cb.b.a(u0Var9.f36629c);
                    }
                }
                c11172 = c11172;
                return objG;
            case 3:
                i10 = 0;
                File file30 = (File) c11172.L$6;
                Pair pair16 = (Pair) c11172.L$5;
                y0Var3 = (y0) c11172.L$4;
                u0Var5 = (u0) c11172.L$3;
                file5 = (File) c11172.L$2;
                str6 = (String) c11172.L$1;
                uri5 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                pair2 = pair16;
                file4 = file30;
                obj3 = objChangeGroupConfigs$default;
                u0 u0Var111 = u0Var5;
                fileResult2 = (FileResponse.FileResult) obj3;
                u0Var4 = u0Var111;
                str5 = str6;
                uri4 = uri5;
                if (fileResult2 != null) {
                    final Pair pair17 = pair2;
                    y0Var6 = y0Var3;
                    file9 = file4;
                    fileResult4 = fileResult2;
                    file10 = file5;
                    str8 = str5;
                    Compressor compressor12 = Compressor.INSTANCE;
                    Context context12 = this.context;
                    Function1 function12 = new Function1() { // from class: cu.todus.android.repositories.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            return MainRepository.updateGroupImage$lambda$1(pair17, (Compression) obj8);
                        }
                    };
                    c11172.L$0 = cb.l.a(uri4);
                    c11172.L$1 = str8;
                    c11172.L$2 = cb.l.a(file10);
                    c11172.L$3 = u0Var4;
                    c11172.L$4 = y0Var6;
                    c11172.L$5 = cb.l.a(pair17);
                    c11172.L$6 = cb.l.a(file9);
                    c11172.L$7 = cb.l.a(fileResult4);
                    c11172.L$8 = null;
                    c11172.label = 6;
                    pair4 = pair17;
                    objCompress$default2 = Compressor.compress$default(compressor12, context12, file10, false, null, function12, c11172, 12, null);
                    if (objCompress$default2 != objG) {
                        u0Var8 = u0Var4;
                        obj6 = objCompress$default2;
                        str9 = str8;
                        uri8 = uri4;
                        file11 = file10;
                        file12 = (File) obj6;
                        xMPPDataSource3 = this.mXMPPDataSource;
                        if (xMPPDataSource3 != null) {
                            break;
                        }
                        file13 = file12;
                        file14 = file13;
                        file15 = file9;
                        y0Var7 = y0Var6;
                        file16 = file11;
                        uri9 = uri8;
                        u0Var9 = u0Var8;
                        i11 = 0;
                        str10 = str9;
                        fileResult5 = null;
                        fileResult6 = fileResult4;
                        if (fileResult5 != null) {
                            UploadDataSource.Companion companion12 = UploadDataSource.INSTANCE;
                            uri11 = uri9;
                            String path14 = file13.getPath();
                            kotlin.jvm.internal.y.h(path14, "getPath(...)");
                            String put12 = fileResult5.getPut();
                            file21 = file13;
                            c11172.L$0 = cb.l.a(uri11);
                            c11172.L$1 = str10;
                            c11172.L$2 = cb.l.a(file16);
                            c11172.L$3 = u0Var9;
                            c11172.L$4 = y0Var7;
                            c11172.L$5 = cb.l.a(pair4);
                            c11172.L$6 = cb.l.a(file15);
                            c11172.L$7 = cb.l.a(fileResult6);
                            c11172.L$8 = cb.l.a(file14);
                            c11172.L$9 = cb.l.a(file21);
                            c11172.L$10 = fileResult5;
                            c11172.L$11 = u0Var9;
                            c11172.I$0 = i11;
                            c11172.label = 8;
                            objDirectUpload = companion12.directUpload(put12, path14, c11172);
                            if (objDirectUpload != objG) {
                                file22 = file21;
                                y0Var9 = y0Var7;
                                str11 = str10;
                                fileResult7 = fileResult5;
                                file23 = file15;
                                i12 = i11;
                                u0Var11 = u0Var9;
                                uri12 = uri11;
                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                if (u0Var11.f36629c) {
                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                }
                                xMPPDataSource4 = this.mXMPPDataSource;
                                if (xMPPDataSource4 != null) {
                                }
                                u0Var9 = u0Var11;
                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                            }
                            break;
                        }
                        return cb.b.a(u0Var9.f36629c);
                    }
                } else {
                    final Pair pair18 = pair2;
                    y0Var6 = y0Var3;
                    file9 = file4;
                    fileResult4 = fileResult2;
                    file10 = file5;
                    str8 = str5;
                    Compressor compressor13 = Compressor.INSTANCE;
                    Context context13 = this.context;
                    Function1 function13 = new Function1() { // from class: cu.todus.android.repositories.j0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj8) {
                            return MainRepository.updateGroupImage$lambda$1(pair18, (Compression) obj8);
                        }
                    };
                    c11172.L$0 = cb.l.a(uri4);
                    c11172.L$1 = str8;
                    c11172.L$2 = cb.l.a(file10);
                    c11172.L$3 = u0Var4;
                    c11172.L$4 = y0Var6;
                    c11172.L$5 = cb.l.a(pair18);
                    c11172.L$6 = cb.l.a(file9);
                    c11172.L$7 = cb.l.a(fileResult4);
                    c11172.L$8 = null;
                    c11172.label = 6;
                    pair4 = pair18;
                    objCompress$default2 = Compressor.compress$default(compressor13, context13, file10, false, null, function13, c11172, 12, null);
                    if (objCompress$default2 != objG) {
                        u0Var8 = u0Var4;
                        obj6 = objCompress$default2;
                        str9 = str8;
                        uri8 = uri4;
                        file11 = file10;
                        file12 = (File) obj6;
                        xMPPDataSource3 = this.mXMPPDataSource;
                        if (xMPPDataSource3 != null) {
                            break;
                        }
                        file13 = file12;
                        file14 = file13;
                        file15 = file9;
                        y0Var7 = y0Var6;
                        file16 = file11;
                        uri9 = uri8;
                        u0Var9 = u0Var8;
                        i11 = 0;
                        str10 = str9;
                        fileResult5 = null;
                        fileResult6 = fileResult4;
                        if (fileResult5 != null) {
                            UploadDataSource.Companion companion13 = UploadDataSource.INSTANCE;
                            uri11 = uri9;
                            String path15 = file13.getPath();
                            kotlin.jvm.internal.y.h(path15, "getPath(...)");
                            String put13 = fileResult5.getPut();
                            file21 = file13;
                            c11172.L$0 = cb.l.a(uri11);
                            c11172.L$1 = str10;
                            c11172.L$2 = cb.l.a(file16);
                            c11172.L$3 = u0Var9;
                            c11172.L$4 = y0Var7;
                            c11172.L$5 = cb.l.a(pair4);
                            c11172.L$6 = cb.l.a(file15);
                            c11172.L$7 = cb.l.a(fileResult6);
                            c11172.L$8 = cb.l.a(file14);
                            c11172.L$9 = cb.l.a(file21);
                            c11172.L$10 = fileResult5;
                            c11172.L$11 = u0Var9;
                            c11172.I$0 = i11;
                            c11172.label = 8;
                            objDirectUpload = companion13.directUpload(put13, path15, c11172);
                            if (objDirectUpload != objG) {
                                file22 = file21;
                                y0Var9 = y0Var7;
                                str11 = str10;
                                fileResult7 = fileResult5;
                                file23 = file15;
                                i12 = i11;
                                u0Var11 = u0Var9;
                                uri12 = uri11;
                                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                                if (u0Var11.f36629c) {
                                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                                }
                                xMPPDataSource4 = this.mXMPPDataSource;
                                if (xMPPDataSource4 != null) {
                                }
                                u0Var9 = u0Var11;
                                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                            }
                            break;
                        }
                        return cb.b.a(u0Var9.f36629c);
                    }
                }
                c11172 = c11172;
                return objG;
            case 4:
                obj4 = objChangeGroupConfigs$default;
                i10 = 0;
                u0Var4 = (u0) c11172.L$8;
                FileResponse.FileResult fileResult8 = (FileResponse.FileResult) c11172.L$7;
                File file31 = (File) c11172.L$6;
                Pair pair19 = (Pair) c11172.L$5;
                y0 y0Var19 = (y0) c11172.L$4;
                u0 u0Var20 = (u0) c11172.L$3;
                File file32 = (File) c11172.L$2;
                str5 = (String) c11172.L$1;
                Uri uri15 = (Uri) c11172.L$0;
                ua.v.b(obj4);
                file6 = file31;
                pair2 = pair19;
                u0Var6 = u0Var20;
                file7 = file32;
                uri6 = uri15;
                fileResult3 = fileResult8;
                y0Var4 = y0Var19;
                u0Var4.f36629c = ((Boolean) obj4).booleanValue();
                if (u0Var6.f36629c) {
                    y0Var4.f36634c = ua.z.a("", fileResult3.getGet());
                }
                xMPPDataSource2 = this.mXMPPDataSource;
                if (xMPPDataSource2 != null) {
                    break;
                }
                y0 y0Var110 = y0Var4;
                u0 u0Var112 = u0Var6;
                str5 = str5;
                file4 = file6;
                file5 = file7;
                y0Var3 = y0Var110;
                u0Var4 = u0Var112;
                uri4 = uri6;
                fileResult2 = fileResult3;
                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var3.f36634c).getSecond());
                final Pair pair110 = pair2;
                y0Var6 = y0Var3;
                file9 = file4;
                fileResult4 = fileResult2;
                file10 = file5;
                str8 = str5;
                Compressor compressor14 = Compressor.INSTANCE;
                Context context14 = this.context;
                Function1 function14 = new Function1() { // from class: cu.todus.android.repositories.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj8) {
                        return MainRepository.updateGroupImage$lambda$1(pair110, (Compression) obj8);
                    }
                };
                c11172.L$0 = cb.l.a(uri4);
                c11172.L$1 = str8;
                c11172.L$2 = cb.l.a(file10);
                c11172.L$3 = u0Var4;
                c11172.L$4 = y0Var6;
                c11172.L$5 = cb.l.a(pair110);
                c11172.L$6 = cb.l.a(file9);
                c11172.L$7 = cb.l.a(fileResult4);
                c11172.L$8 = null;
                c11172.label = 6;
                pair4 = pair110;
                objCompress$default2 = Compressor.compress$default(compressor14, context14, file10, false, null, function14, c11172, 12, null);
                if (objCompress$default2 != objG) {
                    u0Var8 = u0Var4;
                    obj6 = objCompress$default2;
                    str9 = str8;
                    uri8 = uri4;
                    file11 = file10;
                    file12 = (File) obj6;
                    xMPPDataSource3 = this.mXMPPDataSource;
                    if (xMPPDataSource3 != null) {
                        break;
                    }
                    file13 = file12;
                    file14 = file13;
                    file15 = file9;
                    y0Var7 = y0Var6;
                    file16 = file11;
                    uri9 = uri8;
                    u0Var9 = u0Var8;
                    i11 = 0;
                    str10 = str9;
                    fileResult5 = null;
                    fileResult6 = fileResult4;
                    if (fileResult5 != null) {
                        UploadDataSource.Companion companion14 = UploadDataSource.INSTANCE;
                        uri11 = uri9;
                        String path16 = file13.getPath();
                        kotlin.jvm.internal.y.h(path16, "getPath(...)");
                        String put14 = fileResult5.getPut();
                        file21 = file13;
                        c11172.L$0 = cb.l.a(uri11);
                        c11172.L$1 = str10;
                        c11172.L$2 = cb.l.a(file16);
                        c11172.L$3 = u0Var9;
                        c11172.L$4 = y0Var7;
                        c11172.L$5 = cb.l.a(pair4);
                        c11172.L$6 = cb.l.a(file15);
                        c11172.L$7 = cb.l.a(fileResult6);
                        c11172.L$8 = cb.l.a(file14);
                        c11172.L$9 = cb.l.a(file21);
                        c11172.L$10 = fileResult5;
                        c11172.L$11 = u0Var9;
                        c11172.I$0 = i11;
                        c11172.label = 8;
                        objDirectUpload = companion14.directUpload(put14, path16, c11172);
                        if (objDirectUpload != objG) {
                            file22 = file21;
                            y0Var9 = y0Var7;
                            str11 = str10;
                            fileResult7 = fileResult5;
                            file23 = file15;
                            i12 = i11;
                            u0Var11 = u0Var9;
                            uri12 = uri11;
                            u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                            if (u0Var11.f36629c) {
                                y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                            }
                            xMPPDataSource4 = this.mXMPPDataSource;
                            if (xMPPDataSource4 != null) {
                            }
                            u0Var9 = u0Var11;
                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                        }
                        break;
                    }
                    return cb.b.a(u0Var9.f36629c);
                }
                c11172 = c11172;
                return objG;
            case 5:
                i10 = 0;
                FileResponse.FileResult fileResult9 = (FileResponse.FileResult) c11172.L$7;
                file4 = (File) c11172.L$6;
                pair3 = (Pair) c11172.L$5;
                y0Var5 = (y0) c11172.L$4;
                u0Var7 = (u0) c11172.L$3;
                file8 = (File) c11172.L$2;
                str7 = (String) c11172.L$1;
                uri7 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                fileResult3 = fileResult9;
                obj5 = objChangeGroupConfigs$default;
                pair2 = pair3;
                y0Var3 = y0Var5;
                u0Var4 = u0Var7;
                file5 = file8;
                uri4 = uri7;
                str5 = str7;
                fileResult2 = fileResult3;
                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var3.f36634c).getSecond());
                final Pair pair111 = pair2;
                y0Var6 = y0Var3;
                file9 = file4;
                fileResult4 = fileResult2;
                file10 = file5;
                str8 = str5;
                Compressor compressor15 = Compressor.INSTANCE;
                Context context15 = this.context;
                Function1 function15 = new Function1() { // from class: cu.todus.android.repositories.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj8) {
                        return MainRepository.updateGroupImage$lambda$1(pair111, (Compression) obj8);
                    }
                };
                c11172.L$0 = cb.l.a(uri4);
                c11172.L$1 = str8;
                c11172.L$2 = cb.l.a(file10);
                c11172.L$3 = u0Var4;
                c11172.L$4 = y0Var6;
                c11172.L$5 = cb.l.a(pair111);
                c11172.L$6 = cb.l.a(file9);
                c11172.L$7 = cb.l.a(fileResult4);
                c11172.L$8 = null;
                c11172.label = 6;
                pair4 = pair111;
                objCompress$default2 = Compressor.compress$default(compressor15, context15, file10, false, null, function15, c11172, 12, null);
                if (objCompress$default2 != objG) {
                    u0Var8 = u0Var4;
                    obj6 = objCompress$default2;
                    str9 = str8;
                    uri8 = uri4;
                    file11 = file10;
                    file12 = (File) obj6;
                    xMPPDataSource3 = this.mXMPPDataSource;
                    if (xMPPDataSource3 != null) {
                        break;
                    }
                    file13 = file12;
                    file14 = file13;
                    file15 = file9;
                    y0Var7 = y0Var6;
                    file16 = file11;
                    uri9 = uri8;
                    u0Var9 = u0Var8;
                    i11 = 0;
                    str10 = str9;
                    fileResult5 = null;
                    fileResult6 = fileResult4;
                    if (fileResult5 != null) {
                        UploadDataSource.Companion companion15 = UploadDataSource.INSTANCE;
                        uri11 = uri9;
                        String path17 = file13.getPath();
                        kotlin.jvm.internal.y.h(path17, "getPath(...)");
                        String put15 = fileResult5.getPut();
                        file21 = file13;
                        c11172.L$0 = cb.l.a(uri11);
                        c11172.L$1 = str10;
                        c11172.L$2 = cb.l.a(file16);
                        c11172.L$3 = u0Var9;
                        c11172.L$4 = y0Var7;
                        c11172.L$5 = cb.l.a(pair4);
                        c11172.L$6 = cb.l.a(file15);
                        c11172.L$7 = cb.l.a(fileResult6);
                        c11172.L$8 = cb.l.a(file14);
                        c11172.L$9 = cb.l.a(file21);
                        c11172.L$10 = fileResult5;
                        c11172.L$11 = u0Var9;
                        c11172.I$0 = i11;
                        c11172.label = 8;
                        objDirectUpload = companion15.directUpload(put15, path17, c11172);
                        if (objDirectUpload != objG) {
                            file22 = file21;
                            y0Var9 = y0Var7;
                            str11 = str10;
                            fileResult7 = fileResult5;
                            file23 = file15;
                            i12 = i11;
                            u0Var11 = u0Var9;
                            uri12 = uri11;
                            u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                            if (u0Var11.f36629c) {
                                y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                            }
                            xMPPDataSource4 = this.mXMPPDataSource;
                            if (xMPPDataSource4 != null) {
                            }
                            u0Var9 = u0Var11;
                            Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                        }
                        break;
                    }
                    return cb.b.a(u0Var9.f36629c);
                }
                c11172 = c11172;
                return objG;
            case 6:
                i10 = 0;
                FileResponse.FileResult fileResult10 = (FileResponse.FileResult) c11172.L$7;
                File file33 = (File) c11172.L$6;
                Pair pair20 = (Pair) c11172.L$5;
                y0 y0Var20 = (y0) c11172.L$4;
                u0 u0Var21 = (u0) c11172.L$3;
                File file34 = (File) c11172.L$2;
                String str15 = (String) c11172.L$1;
                Uri uri16 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                fileResult4 = fileResult10;
                file9 = file33;
                pair4 = pair20;
                y0Var6 = y0Var20;
                u0Var8 = u0Var21;
                str9 = str15;
                uri8 = uri16;
                obj6 = objChangeGroupConfigs$default;
                file11 = file34;
                file12 = (File) obj6;
                xMPPDataSource3 = this.mXMPPDataSource;
                if (xMPPDataSource3 != null) {
                    break;
                }
                file13 = file12;
                file14 = file13;
                file15 = file9;
                y0Var7 = y0Var6;
                file16 = file11;
                uri9 = uri8;
                u0Var9 = u0Var8;
                i11 = 0;
                str10 = str9;
                fileResult5 = null;
                fileResult6 = fileResult4;
                if (fileResult5 != null) {
                    UploadDataSource.Companion companion16 = UploadDataSource.INSTANCE;
                    uri11 = uri9;
                    String path18 = file13.getPath();
                    kotlin.jvm.internal.y.h(path18, "getPath(...)");
                    String put16 = fileResult5.getPut();
                    file21 = file13;
                    c11172.L$0 = cb.l.a(uri11);
                    c11172.L$1 = str10;
                    c11172.L$2 = cb.l.a(file16);
                    c11172.L$3 = u0Var9;
                    c11172.L$4 = y0Var7;
                    c11172.L$5 = cb.l.a(pair4);
                    c11172.L$6 = cb.l.a(file15);
                    c11172.L$7 = cb.l.a(fileResult6);
                    c11172.L$8 = cb.l.a(file14);
                    c11172.L$9 = cb.l.a(file21);
                    c11172.L$10 = fileResult5;
                    c11172.L$11 = u0Var9;
                    c11172.I$0 = i11;
                    c11172.label = 8;
                    objDirectUpload = companion16.directUpload(put16, path18, c11172);
                    if (objDirectUpload != objG) {
                        file22 = file21;
                        y0Var9 = y0Var7;
                        str11 = str10;
                        fileResult7 = fileResult5;
                        file23 = file15;
                        i12 = i11;
                        u0Var11 = u0Var9;
                        uri12 = uri11;
                        u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                        if (u0Var11.f36629c) {
                            y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                        }
                        xMPPDataSource4 = this.mXMPPDataSource;
                        if (xMPPDataSource4 != null) {
                        }
                        u0Var9 = u0Var11;
                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                        break;
                    }
                    c11172 = c11172;
                    return objG;
                }
                return cb.b.a(u0Var9.f36629c);
            case 7:
                int i14 = c11172.I$0;
                File file35 = (File) c11172.L$9;
                File file36 = (File) c11172.L$8;
                FileResponse.FileResult fileResult11 = (FileResponse.FileResult) c11172.L$7;
                file18 = (File) c11172.L$6;
                pair5 = (Pair) c11172.L$5;
                y0Var8 = (y0) c11172.L$4;
                u0Var10 = (u0) c11172.L$3;
                file19 = (File) c11172.L$2;
                str10 = (String) c11172.L$1;
                uri10 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                fileResult4 = fileResult11;
                file17 = file36;
                file20 = file35;
                i11 = i14;
                obj7 = objChangeGroupConfigs$default;
                pair4 = pair5;
                file13 = file20;
                fileResult5 = (FileResponse.FileResult) obj7;
                uri9 = uri10;
                file16 = file19;
                file15 = file18;
                y0Var7 = y0Var8;
                file14 = file17;
                u0Var9 = u0Var10;
                fileResult6 = fileResult4;
                if (fileResult5 != null) {
                    UploadDataSource.Companion companion17 = UploadDataSource.INSTANCE;
                    uri11 = uri9;
                    String path19 = file13.getPath();
                    kotlin.jvm.internal.y.h(path19, "getPath(...)");
                    String put17 = fileResult5.getPut();
                    file21 = file13;
                    c11172.L$0 = cb.l.a(uri11);
                    c11172.L$1 = str10;
                    c11172.L$2 = cb.l.a(file16);
                    c11172.L$3 = u0Var9;
                    c11172.L$4 = y0Var7;
                    c11172.L$5 = cb.l.a(pair4);
                    c11172.L$6 = cb.l.a(file15);
                    c11172.L$7 = cb.l.a(fileResult6);
                    c11172.L$8 = cb.l.a(file14);
                    c11172.L$9 = cb.l.a(file21);
                    c11172.L$10 = fileResult5;
                    c11172.L$11 = u0Var9;
                    c11172.I$0 = i11;
                    c11172.label = 8;
                    objDirectUpload = companion17.directUpload(put17, path19, c11172);
                    if (objDirectUpload != objG) {
                        file22 = file21;
                        y0Var9 = y0Var7;
                        str11 = str10;
                        fileResult7 = fileResult5;
                        file23 = file15;
                        i12 = i11;
                        u0Var11 = u0Var9;
                        uri12 = uri11;
                        u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                        if (u0Var11.f36629c) {
                            y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                        }
                        xMPPDataSource4 = this.mXMPPDataSource;
                        if (xMPPDataSource4 != null) {
                        }
                        u0Var9 = u0Var11;
                        Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                        break;
                    }
                    c11172 = c11172;
                    return objG;
                }
                return cb.b.a(u0Var9.f36629c);
            case 8:
                int i15 = c11172.I$0;
                u0Var9 = (u0) c11172.L$11;
                fileResult7 = (FileResponse.FileResult) c11172.L$10;
                file22 = (File) c11172.L$9;
                file14 = (File) c11172.L$8;
                fileResult6 = (FileResponse.FileResult) c11172.L$7;
                File file37 = (File) c11172.L$6;
                Pair pair21 = (Pair) c11172.L$5;
                y0Var9 = (y0) c11172.L$4;
                u0 u0Var22 = (u0) c11172.L$3;
                file16 = (File) c11172.L$2;
                String str16 = (String) c11172.L$1;
                Uri uri17 = (Uri) c11172.L$0;
                ua.v.b(objChangeGroupConfigs$default);
                pair4 = pair21;
                str11 = str16;
                file23 = file37;
                u0Var11 = u0Var22;
                i12 = i15;
                uri12 = uri17;
                objDirectUpload = objChangeGroupConfigs$default;
                u0Var9.f36629c = ((Boolean) objDirectUpload).booleanValue();
                if (u0Var11.f36629c) {
                    y0Var9.f36634c = ua.z.a(fileResult7.getGet(), ((Pair) y0Var9.f36634c).getSecond());
                }
                xMPPDataSource4 = this.mXMPPDataSource;
                if (xMPPDataSource4 != null) {
                    break;
                }
                u0Var9 = u0Var11;
                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                return cb.b.a(u0Var9.f36629c);
            case 9:
                y0Var10 = (y0) c11172.L$4;
                u0Var12 = (u0) c11172.L$3;
                ua.v.b(objChangeGroupConfigs$default);
                y0Var9 = y0Var10;
                u0Var9 = u0Var12;
                Z17CoilDecoders.INSTANCE.getInstance().clearCacheFor((String) ((Pair) y0Var9.f36634c).getFirst());
                return cb.b.a(u0Var9.f36629c);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object updateGroupInfo(String str, String str2, ab.e<? super Boolean> eVar) {
        C11181 c11181;
        boolean zBooleanValue;
        GroupsManager groupsManager;
        if (eVar instanceof C11181) {
            c11181 = (C11181) eVar;
            int i10 = c11181.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11181.label = i10 - Integer.MIN_VALUE;
            } else {
                c11181 = new C11181(eVar);
            }
        } else {
            c11181 = new C11181(eVar);
        }
        C11181 c11182 = c11181;
        Object objChangeGroupConfigs$default = c11182.result;
        Object objG = bb.b.g();
        int i11 = c11182.label;
        if (i11 == 0) {
            ua.v.b(objChangeGroupConfigs$default);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
                zBooleanValue = false;
            } else {
                c11182.L$0 = cb.l.a(str);
                c11182.L$1 = cb.l.a(str2);
                c11182.label = 1;
                objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager, str2, null, str, null, c11182, 10, null);
                if (objChangeGroupConfigs$default == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objChangeGroupConfigs$default);
        zBooleanValue = ((Boolean) objChangeGroupConfigs$default).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object updateGroupName(String str, String str2, ab.e<? super Boolean> eVar) {
        C11191 c11191;
        boolean zBooleanValue;
        GroupsManager groupsManager;
        if (eVar instanceof C11191) {
            c11191 = (C11191) eVar;
            int i10 = c11191.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11191.label = i10 - Integer.MIN_VALUE;
            } else {
                c11191 = new C11191(eVar);
            }
        } else {
            c11191 = new C11191(eVar);
        }
        C11191 c11192 = c11191;
        Object objChangeGroupConfigs$default = c11192.result;
        Object objG = bb.b.g();
        int i11 = c11192.label;
        if (i11 == 0) {
            ua.v.b(objChangeGroupConfigs$default);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (groupsManager = xMPPDataSource.getGroupsManager()) == null) {
                zBooleanValue = false;
            } else {
                c11192.L$0 = cb.l.a(str);
                c11192.L$1 = cb.l.a(str2);
                c11192.label = 1;
                objChangeGroupConfigs$default = GroupsManager.changeGroupConfigs$default(groupsManager, str2, str, null, null, c11192, 12, null);
                if (objChangeGroupConfigs$default == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objChangeGroupConfigs$default);
        zBooleanValue = ((Boolean) objChangeGroupConfigs$default).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    public final Object updateMsgStatus(String str, int i10, ab.e<? super ua.k0> eVar) {
        Object objUpdateStatusProgressive = this.messageDao.updateStatusProgressive(va.v.e(str), i10, eVar);
        return objUpdateStatusProgressive == bb.b.g() ? objUpdateStatusProgressive : ua.k0.f43947a;
    }

    public final Object updatePrivacyOfAdd(String str, ab.e<? super Boolean> eVar) {
        PrivacyManager privacyManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (privacyManager = xMPPDataSource.getPrivacyManager()) == null) {
            return null;
        }
        Object objChangePrivacyOfAdd$default = PrivacyManager.changePrivacyOfAdd$default(privacyManager, str, null, eVar, 2, null);
        return objChangePrivacyOfAdd$default == bb.b.g() ? objChangePrivacyOfAdd$default : (Boolean) objChangePrivacyOfAdd$default;
    }

    public final Object updatePrivacyOfAddExcludes(List<String> list, ab.e<? super Boolean> eVar) {
        PrivacyManager privacyManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (privacyManager = xMPPDataSource.getPrivacyManager()) == null) {
            return null;
        }
        Object objChangePrivacyOfAdd = privacyManager.changePrivacyOfAdd("contacts", list, eVar);
        return objChangePrivacyOfAdd == bb.b.g() ? objChangePrivacyOfAdd : (Boolean) objChangePrivacyOfAdd;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateProfileImage(Uri uri, ab.e<? super Boolean> eVar) {
        C11211 c11211;
        boolean zBooleanValue;
        ProfileManager profileManager;
        if (eVar instanceof C11211) {
            c11211 = (C11211) eVar;
            int i10 = c11211.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c11211.label = i10 - Integer.MIN_VALUE;
            } else {
                c11211 = new C11211(eVar);
            }
        } else {
            c11211 = new C11211(eVar);
        }
        Object objUpdateProfileImage = c11211.result;
        Object objG = bb.b.g();
        int i11 = c11211.label;
        if (i11 == 0) {
            ua.v.b(objUpdateProfileImage);
            XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource == null || (profileManager = xMPPDataSource.getProfileManager()) == null) {
                zBooleanValue = false;
            } else {
                c11211.L$0 = cb.l.a(uri);
                c11211.label = 1;
                objUpdateProfileImage = profileManager.updateProfileImage(uri, c11211);
                if (objUpdateProfileImage == objG) {
                    return objG;
                }
            }
            return cb.b.a(zBooleanValue);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objUpdateProfileImage);
        zBooleanValue = ((Boolean) objUpdateProfileImage).booleanValue();
        return cb.b.a(zBooleanValue);
    }

    public final Object updateProfilePrivacy(String str, String str2, String str3, ab.e<? super ua.k0> eVar) {
        PrivacyManager privacyManager;
        XMPPDataSource xMPPDataSource = this.mXMPPDataSource;
        if (xMPPDataSource == null || (privacyManager = xMPPDataSource.getPrivacyManager()) == null) {
            return ua.k0.f43947a;
        }
        Object objChangeProfilePrivacy = privacyManager.changeProfilePrivacy(str3, str, str2, eVar);
        return objChangeProfilePrivacy == bb.b.g() ? objChangeProfilePrivacy : ua.k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:55:0x021c  */
    /* JADX WARN: Code duplicated, block: B:58:0x022b  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object uploadProductImage(Uri uri, ab.e<? super Pair<String, String>> eVar) {
        C11221 c11221;
        File file;
        File file2;
        y0 y0Var;
        u0 u0Var;
        Object obj;
        Pair pair;
        y0 y0Var2;
        u0 u0Var2;
        Uri uri2;
        File file3;
        File file4;
        XMPPDataSource xMPPDataSource;
        int i10;
        File file5;
        Pair pair2;
        u0 u0Var3;
        y0 y0Var3;
        FileResponse.FileResult fileResult;
        UrlManager urlManager;
        u0 u0Var4;
        int i11;
        File file6;
        Uri uri3;
        File file7;
        u0 u0Var5;
        y0 y0Var4;
        FileResponse.FileResult fileResult2;
        Uri uri4 = uri;
        if (eVar instanceof C11221) {
            c11221 = (C11221) eVar;
            int i12 = c11221.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                c11221.label = i12 - Integer.MIN_VALUE;
            } else {
                c11221 = new C11221(eVar);
            }
        } else {
            c11221 = new C11221(eVar);
        }
        C11221 c11222 = c11221;
        Object objDirectUpload = c11222.result;
        Object objG = bb.b.g();
        int i13 = c11222.label;
        if (i13 == 0) {
            ua.v.b(objDirectUpload);
            y0 y0Var5 = new y0();
            Pair pairA = ua.z.a("", "");
            y0Var5.f36634c = pairA;
            if (uri4 == null) {
                return pairA;
            }
            try {
                String path = MediaUtil.INSTANCE.getPath(this.context, uri4);
                kotlin.jvm.internal.y.f(path);
                file = new File(path);
            } catch (Exception e10) {
                e10.printStackTrace();
                file = null;
            }
            if (file == null) {
                return y0Var5.f36634c;
            }
            u0 u0Var6 = new u0();
            File file8 = new File(uri4.getPath());
            c11222.L$0 = cb.l.a(uri4);
            c11222.L$1 = y0Var5;
            c11222.L$2 = file;
            c11222.L$3 = u0Var6;
            c11222.label = 1;
            Object bounds = Z17InlineUtilsKt.getBounds(file8, c11222);
            if (bounds != objG) {
                file2 = file;
                objDirectUpload = bounds;
                y0Var = y0Var5;
                u0Var = u0Var6;
            }
            return objG;
        }
        if (i13 == 1) {
            u0 u0Var7 = (u0) c11222.L$3;
            File file9 = (File) c11222.L$2;
            y0 y0Var6 = (y0) c11222.L$1;
            Uri uri5 = (Uri) c11222.L$0;
            ua.v.b(objDirectUpload);
            u0Var = u0Var7;
            uri4 = uri5;
            y0Var = y0Var6;
            file2 = file9;
        } else {
            if (i13 == 2) {
                pair = (Pair) c11222.L$4;
                u0 u0Var8 = (u0) c11222.L$3;
                File file10 = (File) c11222.L$2;
                y0 y0Var7 = (y0) c11222.L$1;
                Uri uri6 = (Uri) c11222.L$0;
                ua.v.b(objDirectUpload);
                u0Var2 = u0Var8;
                file3 = file10;
                y0Var2 = y0Var7;
                obj = "";
                uri2 = uri6;
                file4 = (File) objDirectUpload;
                xMPPDataSource = this.mXMPPDataSource;
                if (xMPPDataSource != null || (urlManager = xMPPDataSource.getUrlManager()) == null) {
                    i10 = 0;
                    file5 = file4;
                    pair2 = pair;
                    u0Var3 = u0Var2;
                    y0Var3 = y0Var2;
                    fileResult = null;
                    if (fileResult != null) {
                        UploadDataSource.Companion companion = UploadDataSource.INSTANCE;
                        String path2 = file4.getPath();
                        kotlin.jvm.internal.y.h(path2, "getPath(...)");
                        String put = fileResult.getPut();
                        c11222.L$0 = cb.l.a(uri2);
                        c11222.L$1 = y0Var3;
                        c11222.L$2 = cb.l.a(file3);
                        c11222.L$3 = u0Var3;
                        c11222.L$4 = cb.l.a(pair2);
                        c11222.L$5 = cb.l.a(file5);
                        c11222.L$6 = cb.l.a(file4);
                        c11222.L$7 = fileResult;
                        c11222.L$8 = u0Var3;
                        c11222.I$0 = i10;
                        c11222.label = 4;
                        objDirectUpload = companion.directUpload(put, path2, c11222);
                        if (objDirectUpload != objG) {
                            u0Var5 = u0Var3;
                            y0Var4 = y0Var3;
                            fileResult2 = fileResult;
                        }
                    }
                    return y0Var3.f36634c;
                }
                long length = file4.length();
                c11222.L$0 = cb.l.a(uri2);
                c11222.L$1 = y0Var2;
                c11222.L$2 = cb.l.a(file3);
                c11222.L$3 = u0Var2;
                c11222.L$4 = cb.l.a(pair);
                c11222.L$5 = cb.l.a(file4);
                c11222.L$6 = file4;
                c11222.I$0 = 0;
                c11222.label = 3;
                y0 y0Var8 = y0Var2;
                Object putUrl$default = UrlManager.getPutUrl$default(urlManager, null, 7, length, false, c11222, 9, null);
                if (putUrl$default != objG) {
                    file5 = file4;
                    pair2 = pair;
                    u0Var4 = u0Var2;
                    i11 = 0;
                    file6 = file3;
                    uri3 = uri2;
                    y0Var3 = y0Var8;
                    objDirectUpload = putUrl$default;
                    file7 = file5;
                    fileResult = (FileResponse.FileResult) objDirectUpload;
                    i10 = i11;
                    file4 = file7;
                    u0Var3 = u0Var4;
                    file3 = file6;
                    uri2 = uri3;
                    if (fileResult != null) {
                        UploadDataSource.Companion companion2 = UploadDataSource.INSTANCE;
                        String path3 = file4.getPath();
                        kotlin.jvm.internal.y.h(path3, "getPath(...)");
                        String put2 = fileResult.getPut();
                        c11222.L$0 = cb.l.a(uri2);
                        c11222.L$1 = y0Var3;
                        c11222.L$2 = cb.l.a(file3);
                        c11222.L$3 = u0Var3;
                        c11222.L$4 = cb.l.a(pair2);
                        c11222.L$5 = cb.l.a(file5);
                        c11222.L$6 = cb.l.a(file4);
                        c11222.L$7 = fileResult;
                        c11222.L$8 = u0Var3;
                        c11222.I$0 = i10;
                        c11222.label = 4;
                        objDirectUpload = companion2.directUpload(put2, path3, c11222);
                        if (objDirectUpload != objG) {
                            u0Var5 = u0Var3;
                            y0Var4 = y0Var3;
                            fileResult2 = fileResult;
                        }
                    }
                    return y0Var3.f36634c;
                }
                return objG;
            }
            if (i13 == 3) {
                i11 = c11222.I$0;
                file7 = (File) c11222.L$6;
                file5 = (File) c11222.L$5;
                pair2 = (Pair) c11222.L$4;
                u0Var4 = (u0) c11222.L$3;
                file6 = (File) c11222.L$2;
                y0Var3 = (y0) c11222.L$1;
                uri3 = (Uri) c11222.L$0;
                ua.v.b(objDirectUpload);
                obj = "";
                fileResult = (FileResponse.FileResult) objDirectUpload;
                i10 = i11;
                file4 = file7;
                u0Var3 = u0Var4;
                file3 = file6;
                uri2 = uri3;
                if (fileResult != null && !fileResult.getWasError()) {
                    UploadDataSource.Companion companion3 = UploadDataSource.INSTANCE;
                    String path4 = file4.getPath();
                    kotlin.jvm.internal.y.h(path4, "getPath(...)");
                    String put3 = fileResult.getPut();
                    c11222.L$0 = cb.l.a(uri2);
                    c11222.L$1 = y0Var3;
                    c11222.L$2 = cb.l.a(file3);
                    c11222.L$3 = u0Var3;
                    c11222.L$4 = cb.l.a(pair2);
                    c11222.L$5 = cb.l.a(file5);
                    c11222.L$6 = cb.l.a(file4);
                    c11222.L$7 = fileResult;
                    c11222.L$8 = u0Var3;
                    c11222.I$0 = i10;
                    c11222.label = 4;
                    objDirectUpload = companion3.directUpload(put3, path4, c11222);
                    if (objDirectUpload != objG) {
                        u0Var5 = u0Var3;
                        y0Var4 = y0Var3;
                        fileResult2 = fileResult;
                    }
                    return objG;
                }
                return y0Var3.f36634c;
            }
            if (i13 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0Var3 = (u0) c11222.L$8;
            fileResult2 = (FileResponse.FileResult) c11222.L$7;
            u0Var5 = (u0) c11222.L$3;
            y0Var4 = (y0) c11222.L$1;
            ua.v.b(objDirectUpload);
            obj = "";
        }
        u0Var3.f36629c = ((Boolean) objDirectUpload).booleanValue();
        if (u0Var5.f36629c) {
            y0Var4.f36634c = ua.z.a(obj, fileResult2.getGet());
        }
        y0Var3 = y0Var4;
        return y0Var3.f36634c;
        final Pair pair3 = (Pair) objDirectUpload;
        Compressor compressor = Compressor.INSTANCE;
        Context context = this.context;
        Function1 function1 = new Function1() { // from class: cu.todus.android.repositories.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return MainRepository.uploadProductImage$lambda$0(pair3, (Compression) obj2);
            }
        };
        c11222.L$0 = cb.l.a(uri4);
        c11222.L$1 = y0Var;
        c11222.L$2 = cb.l.a(file2);
        c11222.L$3 = u0Var;
        c11222.L$4 = cb.l.a(pair3);
        c11222.label = 2;
        y0 y0Var9 = y0Var;
        u0 u0Var9 = u0Var;
        obj = "";
        Object objCompress$default = Compressor.compress$default(compressor, context, file2, false, null, function1, c11222, 12, null);
        if (objCompress$default != objG) {
            Uri uri7 = uri4;
            pair = pair3;
            objDirectUpload = objCompress$default;
            y0Var2 = y0Var9;
            u0Var2 = u0Var9;
            uri2 = uri7;
            file3 = file2;
            file4 = (File) objDirectUpload;
            xMPPDataSource = this.mXMPPDataSource;
            if (xMPPDataSource != null) {
            }
            i10 = 0;
            file5 = file4;
            pair2 = pair;
            u0Var3 = u0Var2;
            y0Var3 = y0Var2;
            fileResult = null;
            if (fileResult != null) {
                UploadDataSource.Companion companion4 = UploadDataSource.INSTANCE;
                String path5 = file4.getPath();
                kotlin.jvm.internal.y.h(path5, "getPath(...)");
                String put4 = fileResult.getPut();
                c11222.L$0 = cb.l.a(uri2);
                c11222.L$1 = y0Var3;
                c11222.L$2 = cb.l.a(file3);
                c11222.L$3 = u0Var3;
                c11222.L$4 = cb.l.a(pair2);
                c11222.L$5 = cb.l.a(file5);
                c11222.L$6 = cb.l.a(file4);
                c11222.L$7 = fileResult;
                c11222.L$8 = u0Var3;
                c11222.I$0 = i10;
                c11222.label = 4;
                objDirectUpload = companion4.directUpload(put4, path5, c11222);
                if (objDirectUpload != objG) {
                    u0Var5 = u0Var3;
                    y0Var4 = y0Var3;
                    fileResult2 = fileResult;
                    u0Var3.f36629c = ((Boolean) objDirectUpload).booleanValue();
                    if (u0Var5.f36629c) {
                        y0Var4.f36634c = ua.z.a(obj, fileResult2.getGet());
                    }
                    y0Var3 = y0Var4;
                }
            }
            return y0Var3.f36634c;
        }
        return objG;
    }

    public final Object upsertAttachments(List<Attachment> list, ab.e<? super ua.k0> eVar) {
        Object objUpsert = this.attachmentDao.upsert(list, eVar);
        return objUpsert == bb.b.g() ? objUpsert : ua.k0.f43947a;
    }

    /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.repositories.MainRepository$1", f = "MainRepository.kt", l = {216}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        int label;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
        }

        @Override // cb.a
        public final ab.e<ua.k0> create(ab.e<?> eVar) {
            return MainRepository.this.new AnonymousClass1(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super ua.k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(ua.k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                te.b0 connectionState = MainRepository.this.getConnectionState();
                C02041 c02041 = new C02041(MainRepository.this);
                this.label = 1;
                if (connectionState.collect(c02041, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(obj);
            }
            throw new ua.j();
        }

        /* JADX INFO: renamed from: cu.todus.android.repositories.MainRepository$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class C02041<T> implements te.i {
            final /* synthetic */ MainRepository this$0;

            public C02041(MainRepository mainRepository) {
                this.this$0 = mainRepository;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
            
                if (r8.getAndUpdateToDusId(r2, r0) == r1) goto L28;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(cu.todus.android.xmpp.ConnectionState r7, ab.e<? super ua.k0> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof cu.todus.android.repositories.MainRepository$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    cu.todus.android.repositories.MainRepository$1$1$emit$1 r0 = (cu.todus.android.repositories.MainRepository$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    cu.todus.android.repositories.MainRepository$1$1$emit$1 r0 = new cu.todus.android.repositories.MainRepository$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = bb.b.g()
                    int r2 = r0.label
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L4b
                    if (r2 == r5) goto L43
                    if (r2 == r4) goto L3b
                    if (r2 != r3) goto L33
                    java.lang.Object r7 = r0.L$0
                    cu.todus.android.xmpp.ConnectionState r7 = (cu.todus.android.xmpp.ConnectionState) r7
                    ua.v.b(r8)
                    goto L95
                L33:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L3b:
                    java.lang.Object r7 = r0.L$0
                    cu.todus.android.xmpp.ConnectionState r7 = (cu.todus.android.xmpp.ConnectionState) r7
                    ua.v.b(r8)
                    goto L76
                L43:
                    java.lang.Object r7 = r0.L$0
                    cu.todus.android.xmpp.ConnectionState r7 = (cu.todus.android.xmpp.ConnectionState) r7
                    ua.v.b(r8)
                    goto L65
                L4b:
                    ua.v.b(r8)
                    boolean r8 = r7.isConnected()
                    if (r8 == 0) goto L98
                    cu.todus.android.repositories.MainRepository r8 = r6.this$0
                    java.lang.Object r2 = cb.l.a(r7)
                    r0.L$0 = r2
                    r0.label = r5
                    java.lang.Object r8 = cu.todus.android.repositories.MainRepository.access$initFirebase(r8, r0)
                    if (r8 != r1) goto L65
                    goto L94
                L65:
                    cu.todus.android.repositories.MainRepository r8 = r6.this$0
                    java.lang.Object r2 = cb.l.a(r7)
                    r0.L$0 = r2
                    r0.label = r4
                    java.lang.Object r8 = cu.todus.android.repositories.MainRepository.access$initShortcut(r8, r0)
                    if (r8 != r1) goto L76
                    goto L94
                L76:
                    cu.todus.android.repositories.MainRepository r8 = r6.this$0
                    lb.a r2 = r8.getOwner()
                    java.lang.Object r2 = r2.invoke()
                    cu.todus.android.data.preferences.Owner r2 = (cu.todus.android.data.preferences.Owner) r2
                    java.lang.String r2 = r2.getNameWithDomain()
                    java.lang.Object r7 = cb.l.a(r7)
                    r0.L$0 = r7
                    r0.label = r3
                    java.lang.Object r7 = cu.todus.android.repositories.MainRepository.access$getAndUpdateToDusId(r8, r2, r0)
                    if (r7 != r1) goto L95
                L94:
                    return r1
                L95:
                    ua.k0 r7 = ua.k0.f43947a
                    return r7
                L98:
                    ua.k0 r7 = ua.k0.f43947a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.repositories.MainRepository.AnonymousClass1.C02041.emit(cu.todus.android.xmpp.ConnectionState, ab.e):java.lang.Object");
            }

            @Override // te.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, ab.e eVar) {
                return emit((ConnectionState) obj, (ab.e<? super ua.k0>) eVar);
            }
        }
    }
}
