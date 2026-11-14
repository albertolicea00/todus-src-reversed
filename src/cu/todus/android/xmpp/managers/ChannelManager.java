package cu.todus.android.xmpp.managers;

import android.content.Context;
import androidx.compose.material.MenuKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import com.google.gson.reflect.TypeToken;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithRoomWithReactions;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.xmpp.ChannelAdmin;
import cu.todus.android.data.xmpp.ChannelInfo;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.utils.ExtensionFunsKt;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.XMPPUtils;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQById;
import cu.todus.android.xmpp.iq.channels.ChannelInfoIQByLink;
import cu.todus.android.xmpp.iq.channels.CreateChannelIQ;
import cu.todus.android.xmpp.iq.channels.DeletePubFromChannelIQ;
import cu.todus.android.xmpp.iq.channels.DeleteSubscriberChannelIQ;
import cu.todus.android.xmpp.iq.channels.DemoteAdminChannelIQ;
import cu.todus.android.xmpp.iq.channels.EditAdminRightsIQ;
import cu.todus.android.xmpp.iq.channels.EditInfoChannelIQ;
import cu.todus.android.xmpp.iq.channels.EditPubChannelIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelAdminsIQ;
import cu.todus.android.xmpp.iq.channels.GetChannelListPaginatedIQ;
import cu.todus.android.xmpp.iq.channels.LeaveChannelIQ;
import cu.todus.android.xmpp.iq.channels.PromoteToAdminChannelIQ;
import cu.todus.android.xmpp.mapper.MapperToRoom;
import cu.z17.views.utils.Z17CoilDecoders;
import cu.z17.views.utils.Z17MutableListFlow;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import le.d0;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import ua.k0;
import va.g0;
import va.w0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012$\u0010\r\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0015j\b\u0012\u0004\u0012\u00020\u0012`\u0016H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082@¢\u0006\u0004\b\u001f\u0010 J&\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082@¢\u0006\u0004\b!\u0010 J&\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082@¢\u0006\u0004\b\"\u0010 J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\nH\u0082@¢\u0006\u0004\b$\u0010%J\u001e\u0010'\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0082@¢\u0006\u0004\b'\u0010(J\u001e\u0010)\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0082@¢\u0006\u0004\b)\u0010(J$\u0010.\u001a\u00020\u00182\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*H\u0082@¢\u0006\u0004\b.\u0010/J(\u00101\u001a\u00020\u00182\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u0002000\u0015j\b\u0012\u0004\u0012\u000200`\u0016H\u0086@¢\u0006\u0004\b1\u0010\u001aJ\u0010\u00102\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b2\u00103J \u00106\u001a\u00020\u00182\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0086@¢\u0006\u0004\b6\u0010\u0014J\u001a\u00108\u001a\u0004\u0018\u00010\n2\u0006\u00107\u001a\u00020\nH\u0086@¢\u0006\u0004\b8\u0010%J\u001a\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00109\u001a\u00020\nH\u0086@¢\u0006\u0004\b;\u0010%J0\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\n2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<H\u0086@¢\u0006\u0004\b@\u0010AJ(\u0010C\u001a\u0012\u0012\u0004\u0012\u00020B0\u0015j\b\u0012\u0004\u0012\u00020B`\u00162\u0006\u0010#\u001a\u00020\nH\u0086@¢\u0006\u0004\bC\u0010%J\u001a\u0010E\u001a\u0004\u0018\u00010:2\u0006\u0010D\u001a\u00020\nH\u0086@¢\u0006\u0004\bE\u0010%J(\u0010H\u001a\u0004\u0018\u00010G2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010#\u001a\u00020\nH\u0086@¢\u0006\u0004\bH\u0010IJ*\u0010L\u001a\u0004\u0018\u00010G2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0086@¢\u0006\u0004\bL\u0010MJ\u0018\u0010O\u001a\u00020N2\u0006\u0010D\u001a\u00020\nH\u0086@¢\u0006\u0004\bO\u0010%J\u0018\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\nH\u0086@¢\u0006\u0004\bQ\u0010%J@\u0010W\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0086@¢\u0006\u0004\bW\u0010XJ(\u0010[\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0086@¢\u0006\u0004\b[\u0010MJ(\u0010\\\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0086@¢\u0006\u0004\b\\\u0010MJ \u0010]\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0086@¢\u0006\u0004\b]\u0010\u0014J \u0010^\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0086@¢\u0006\u0004\b^\u0010\u0014J\u0018\u0010_\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\nH\u0086@¢\u0006\u0004\b_\u0010%R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010`\u001a\u0004\ba\u0010bR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010`\u001a\u0004\bc\u0010bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010`\u001a\u0004\bd\u0010bR5\u0010\r\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010e\u001a\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR,\u0010u\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0*0t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010v¨\u0006w"}, d2 = {"Lcu/todus/android/xmpp/managers/ChannelManager;", "", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Lkotlin/Function2;", "", "Lab/e;", "Lcu/todus/android/data/db/entity/toDus/User;", "getUserInfo", "<init>", "(Llb/a;Llb/a;Llb/a;Lkotlin/jvm/functions/Function2;)V", "pairJson", Message.COLUMN_MESSAGE_PUBL_ID, "Lcu/todus/android/data/db/entity/toDus/Message;", "processChannelMessage", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pubList", "Lua/k0;", "handleUpdateLastInChannel", "(Ljava/util/ArrayList;Lab/e;)Ljava/lang/Object;", "message", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", "listAttachment", "processMessage", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "handleIncomingMsgAndAtt", "handleSendMarkers", "roomId", "notifyMsg", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", Service.Endpoint.LINKED_DEVICES_LIST, "updateChannelsInfo", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "channelInfoList", "Lkotlin/Pair;", "Lcu/todus/android/data/db/entity/toDus/Room;", "Lcu/todus/android/data/db/entity/toDus/UserRoomJoin;", "roomAndAffiliation", "addChannelToDB", "(Lkotlin/Pair;Lab/e;)Ljava/lang/Object;", "Landroid/os/Bundle;", "handlePublications", "reloadChannels", "(Lab/e;)Ljava/lang/Object;", "chId", "pubId", "reloadPubById", "channelName", "createChannel", "id", "Lcu/todus/android/data/xmpp/ChannelInfo;", "getChannelInfoById", "", DataLayout.ELEMENT, "pageSize", "Lcu/todus/android/data/db/pojo/ChannelSubscriber;", "getSubscribersPage", "(Ljava/lang/String;IILab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/ChannelAdmin;", "getChannelAdmins", "linkId", "getChannelInfoByLinkId", "msgIds", "Lorg/jivesoftware/smack/packet/IQ;", "deleteMessageFromChannel", "(Ljava/util/List;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "msgPubId", "content", "editMessageFromChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/xmpp/JoinResult;", Room.CONFIG_SUBSCRIBED_STATE, "uid", "leaveChannel", "name", "profilePhoto", "profilePhotoThumb", "subject", "link", "updateChannelInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "userId", "rights", "promoteAdmin", "editAdmin", "demoteAdmin", "expelSubscriber", "reloadChannel", "Llb/a;", "getCanSend", "()Llb/a;", "getMXMPPConnection", "getOwner", "Lkotlin/jvm/functions/Function2;", "getGetUserInfo", "()Lkotlin/jvm/functions/Function2;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lcu/todus/android/notification/NotificationManager;", "Lcu/todus/android/di/DatabaseModule;", "databaseModule", "Lcu/todus/android/di/DatabaseModule;", "Lv5/f;", "gson", "Lv5/f;", "Lcu/z17/views/utils/Z17MutableListFlow;", "incomingMessageNotInserted", "Lcu/z17/views/utils/Z17MutableListFlow;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelManager {
    public static final int $stable = 8;
    private final lb.a canSend;
    private final Context context;
    private final DatabaseModule databaseModule;
    private final Function2 getUserInfo;
    private final v5.f gson;
    private final Z17MutableListFlow<Pair<Message, List<Attachment>>> incomingMessageNotInserted;
    private final lb.a mXMPPConnection;
    private final NotificationManager notificationManager;
    private final lb.a owner;

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$addChannelToDB$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {314, 315}, m = "addChannelToDB", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.addChannelToDB(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$channelInfoList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {297, 305}, m = "channelInfoList", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14131 extends cb.d {
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
        int label;
        /* synthetic */ Object result;

        public C14131(ab.e<? super C14131> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.channelInfoList(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$createChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "createChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14141 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14141(ab.e<? super C14141> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.createChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$deleteMessageFromChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "deleteMessageFromChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14151 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14151(ab.e<? super C14151> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.deleteMessageFromChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$demoteAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "demoteAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14161 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14161(ab.e<? super C14161> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.demoteAdmin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$editAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "editAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14171 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14171(ab.e<? super C14171> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.editAdmin(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$editMessageFromChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "editMessageFromChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14181 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14181(ab.e<? super C14181> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.editMessageFromChannel(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$expelSubscriber$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "expelSubscriber", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14191 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14191(ab.e<? super C14191> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.expelSubscriber(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$getChannelAdmins$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "getChannelAdmins", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14201 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14201(ab.e<? super C14201> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.getChannelAdmins(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$getChannelInfoById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642, 372}, m = "getChannelInfoById", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14211 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14211(ab.e<? super C14211> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.getChannelInfoById(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$getChannelInfoByLinkId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "getChannelInfoByLinkId", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14221 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14221(ab.e<? super C14221> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.getChannelInfoByLinkId(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$getSubscribersPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642, 396, 411}, m = "getSubscribersPage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14231 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        Object L$0;
        Object L$1;
        Object L$10;
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

        public C14231(ab.e<? super C14231> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.getSubscribersPage(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$handleIncomingMsgAndAtt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {169, WebmConstants.MkvEbmlElement.PREV_SIZE, WebmConstants.MkvEbmlElement.PIXEL_WIDTH}, m = "handleIncomingMsgAndAtt", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14241 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14241(ab.e<? super C14241> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.handleIncomingMsgAndAtt(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$handlePublications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {88, 99}, m = "handlePublications", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14251 extends cb.d {
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

        public C14251(ab.e<? super C14251> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.handlePublications(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$handleSendMarkers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {ComposerKt.providerKey}, m = "handleSendMarkers", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14261 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14261(ab.e<? super C14261> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.handleSendMarkers(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$handleUpdateLastInChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {134, 137, 140}, m = "handleUpdateLastInChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14271 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14271(ab.e<? super C14271> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.handleUpdateLastInChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$leaveChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "leaveChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14281 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14281(ab.e<? super C14281> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.leaveChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$notifyMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {220}, m = "notifyMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14291 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14291(ab.e<? super C14291> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.notifyMsg(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$processChannelMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {MenuKt.InTransitionDuration}, m = "processChannelMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14301 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14301(ab.e<? super C14301> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.processChannelMessage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$processMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {153, WebmConstants.MkvEbmlElement.BLOCK_DURATION, 157, WebmConstants.MkvEbmlElement.CHANNELS}, m = "processMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14311 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14311(ab.e<? super C14311> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.processMessage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$promoteAdmin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "promoteAdmin", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14321 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14321(ab.e<? super C14321> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.promoteAdmin(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$reloadChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {601, TypedValues.MotionType.TYPE_EASING, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 629}, m = "reloadChannel", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14331 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C14331(ab.e<? super C14331> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.reloadChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$reloadChannels$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager$reloadChannels$2", f = "ChannelManager.kt", l = {642}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", DataLayout.ELEMENT, "", "pageSize"}, k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass2 extends cb.m implements Function3 {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(ab.e<? super AnonymousClass2> eVar) {
            super(3, eVar);
        }

        public final Object invoke(int i10, int i11, ab.e<? super List<String>> eVar) {
            AnonymousClass2 anonymousClass2 = ChannelManager.this.new AnonymousClass2(eVar);
            anonymousClass2.I$0 = i10;
            anonymousClass2.I$1 = i11;
            return anonymousClass2.invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0065  */
        /* JADX WARN: Code duplicated, block: B:18:0x006a A[RETURN] */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            GetChannelListPaginatedIQ getChannelListPaginatedIQ;
            int i10 = this.I$0;
            int i11 = this.I$1;
            Object objG = bb.b.g();
            int i12 = this.label;
            if (i12 == 0) {
                ua.v.b(obj);
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) ChannelManager.this.getMXMPPConnection().invoke();
                if (xMPPTCPConnection != null) {
                    GetChannelListPaginatedIQ getChannelListPaginatedIQ2 = new GetChannelListPaginatedIQ(null, i11, i10, 1, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getChannelListPaginatedIQ2);
                    this.L$0 = cb.l.a(xMPPTCPConnection);
                    this.L$1 = cb.l.a(getChannelListPaginatedIQ2);
                    this.I$0 = i10;
                    this.I$1 = i11;
                    this.I$2 = 0;
                    this.label = 1;
                    obj = te.j.x(hVarSendIQFlow, this);
                    if (obj == objG) {
                        return objG;
                    }
                } else {
                    getChannelListPaginatedIQ = null;
                }
                if (getChannelListPaginatedIQ != null) {
                    return getChannelListPaginatedIQ.getChId();
                }
                return null;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
            getChannelListPaginatedIQ = (GetChannelListPaginatedIQ) ((IQ) obj);
            if (getChannelListPaginatedIQ != null) {
                return getChannelListPaginatedIQ.getChId();
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (ab.e<? super List<String>>) obj3);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$reloadChannels$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager$reloadChannels$3", f = "ChannelManager.kt", l = {271}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "it", "Lua/k0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass3 extends cb.m implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(ab.e<? super AnonymousClass3> eVar) {
            super(2, eVar);
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            AnonymousClass3 anonymousClass3 = ChannelManager.this.new AnonymousClass3(eVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                ua.v.b(obj);
                ChannelManager channelManager = ChannelManager.this;
                ArrayList arrayList = new ArrayList(va.x.y(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()) + "@ch");
                }
                this.L$0 = cb.l.a(list);
                this.label = 1;
                if (channelManager.updateChannelsInfo(arrayList, this) == objG) {
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
        public final Object invoke(List<String> list, ab.e<? super k0> eVar) {
            return ((AnonymousClass3) create(list, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$reloadPubById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642, 334}, m = "reloadPubById", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14341 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14341(ab.e<? super C14341> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.reloadPubById(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$subscribe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642, 492}, m = Room.CONFIG_SUBSCRIBED_STATE, v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14351 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14351(ab.e<? super C14351> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.subscribe(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$updateChannelInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {642}, m = "updateChannelInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14361 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C14361(ab.e<? super C14361> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.updateChannelInfo(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.ChannelManager$updateChannelsInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.ChannelManager", f = "ChannelManager.kt", l = {283, 291}, m = "updateChannelsInfo", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14371 extends cb.d {
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

        public C14371(ab.e<? super C14371> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelManager.this.updateChannelsInfo(null, this);
        }
    }

    public ChannelManager(lb.a canSend, lb.a mXMPPConnection, lb.a owner, Function2 getUserInfo) {
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(getUserInfo, "getUserInfo");
        this.canSend = canSend;
        this.mXMPPConnection = mXMPPConnection;
        this.owner = owner;
        this.getUserInfo = getUserInfo;
        MainModule.Companion companion = MainModule.INSTANCE;
        this.context = companion.getInstance().getAppContext();
        this.notificationManager = NotificationManager.INSTANCE.getInstance();
        this.databaseModule = DatabaseModule.INSTANCE.getInstance();
        this.gson = companion.getInstance().getGson();
        this.incomingMessageNotInserted = new Z17MutableListFlow<>(va.w.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        if (r8.insert(r2, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object addChannelToDB(kotlin.Pair<cu.todus.android.data.db.entity.toDus.Room, cu.todus.android.data.db.entity.toDus.UserRoomJoin> r7, ab.e<? super ua.k0> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cu.todus.android.xmpp.managers.ChannelManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            cu.todus.android.xmpp.managers.ChannelManager$addChannelToDB$1 r0 = (cu.todus.android.xmpp.managers.ChannelManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.ChannelManager$addChannelToDB$1 r0 = new cu.todus.android.xmpp.managers.ChannelManager$addChannelToDB$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.L$1
            kotlin.Pair r7 = (kotlin.Pair) r7
            java.lang.Object r7 = r0.L$0
            kotlin.Pair r7 = (kotlin.Pair) r7
            ua.v.b(r8)     // Catch: java.lang.Exception -> L34
            goto L98
        L34:
            r7 = move-exception
            goto L95
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r4 = r0.L$0
            kotlin.Pair r4 = (kotlin.Pair) r4
            ua.v.b(r8)     // Catch: java.lang.Exception -> L34
            r5 = r7
            r7 = r2
            goto L72
        L4e:
            ua.v.b(r8)
            cu.todus.android.di.DatabaseModule r8 = r6.databaseModule     // Catch: java.lang.Exception -> L34
            cu.todus.android.db.dao.toDus.RoomDao r8 = r8.getRoomDao()     // Catch: java.lang.Exception -> L34
            java.lang.Object r2 = r7.getFirst()     // Catch: java.lang.Exception -> L34
            cu.todus.android.data.db.entity.toDus.Room r2 = (cu.todus.android.data.db.entity.toDus.Room) r2     // Catch: java.lang.Exception -> L34
            java.lang.Object r5 = cb.l.a(r7)     // Catch: java.lang.Exception -> L34
            r0.L$0 = r5     // Catch: java.lang.Exception -> L34
            r0.L$1 = r7     // Catch: java.lang.Exception -> L34
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Exception -> L34
            r0.label = r4     // Catch: java.lang.Exception -> L34
            java.lang.Object r8 = r8.insert(r2, r0)     // Catch: java.lang.Exception -> L34
            if (r8 != r1) goto L71
            goto L94
        L71:
            r4 = r7
        L72:
            cu.todus.android.di.DatabaseModule r8 = r6.databaseModule     // Catch: java.lang.Exception -> L34
            cu.todus.android.db.dao.toDus.UserRoomJoinDao r8 = r8.getUserRoomJoinDao()     // Catch: java.lang.Exception -> L34
            java.lang.Object r2 = r7.getSecond()     // Catch: java.lang.Exception -> L34
            cu.todus.android.data.db.entity.toDus.UserRoomJoin r2 = (cu.todus.android.data.db.entity.toDus.UserRoomJoin) r2     // Catch: java.lang.Exception -> L34
            java.lang.Object r4 = cb.l.a(r4)     // Catch: java.lang.Exception -> L34
            r0.L$0 = r4     // Catch: java.lang.Exception -> L34
            java.lang.Object r7 = cb.l.a(r7)     // Catch: java.lang.Exception -> L34
            r0.L$1 = r7     // Catch: java.lang.Exception -> L34
            r0.I$0 = r5     // Catch: java.lang.Exception -> L34
            r0.label = r3     // Catch: java.lang.Exception -> L34
            java.lang.Object r7 = r8.insert(r2, r0)     // Catch: java.lang.Exception -> L34
            if (r7 != r1) goto L98
        L94:
            return r1
        L95:
            r7.printStackTrace()
        L98:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.addChannelToDB(kotlin.Pair, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0090  */
    /* JADX WARN: Code duplicated, block: B:22:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:28:0x011f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0129  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x011f -> B:29:0x0121). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0129 -> B:17:0x008a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object channelInfoList(java.util.List<java.lang.String> r18, ab.e<? super ua.k0> r19) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.channelInfoList(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x009b A[Catch: SQLiteConstraintException -> 0x0039, TryCatch #0 {SQLiteConstraintException -> 0x0039, blocks: (B:14:0x0034, B:21:0x004d, B:33:0x0087, B:35:0x009b, B:36:0x00a2, B:24:0x005a, B:30:0x0074, B:27:0x0061), top: B:42:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
    
        if (r9.forceUpdateStatus(r2, 2, r0) == r1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleIncomingMsgAndAtt(final cu.todus.android.data.db.entity.toDus.Message r7, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r8, ab.e<? super ua.k0> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof cu.todus.android.xmpp.managers.ChannelManager.C14241
            if (r0 == 0) goto L13
            r0 = r9
            cu.todus.android.xmpp.managers.ChannelManager$handleIncomingMsgAndAtt$1 r0 = (cu.todus.android.xmpp.managers.ChannelManager.C14241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.ChannelManager$handleIncomingMsgAndAtt$1 r0 = new cu.todus.android.xmpp.managers.ChannelManager$handleIncomingMsgAndAtt$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L5e
            if (r2 == r4) goto L51
            if (r2 == r5) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r9)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            goto Lc5
        L39:
            r9 = move-exception
            goto Lb9
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r9)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            goto L87
        L51:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r9)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            goto L74
        L5e:
            ua.v.b(r9)
            cu.todus.android.di.DatabaseModule r9 = r6.databaseModule     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.db.dao.toDus.MessageDao r9 = r9.getMessageDao()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$0 = r7     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$1 = r8     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.label = r4     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            java.lang.Object r9 = r9.insert(r7, r0)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            if (r9 != r1) goto L74
            goto Lb8
        L74:
            cu.todus.android.di.DatabaseModule r9 = r6.databaseModule     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.db.dao.toDus.AttachmentDao r9 = r9.getAttachmentDao()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$0 = r7     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$1 = r8     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.label = r5     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            java.lang.Object r9 = r9.insertAllIfNeeded(r8, r0)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            if (r9 != r1) goto L87
            goto Lb8
        L87:
            cu.z17.views.utils.Z17MutableListFlow<kotlin.Pair<cu.todus.android.data.db.entity.toDus.Message, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>>> r9 = r6.incomingMessageNotInserted     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.xmpp.managers.k r2 = new cu.todus.android.xmpp.managers.k     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r2.<init>()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r9.removeAll(r2)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.volatileState.AppVolatileState$Companion r9 = cu.todus.android.volatileState.AppVolatileState.INSTANCE     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            java.lang.Object r9 = r9.getInstanceOrNull()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.volatileState.AppVolatileState r9 = (cu.todus.android.volatileState.AppVolatileState) r9     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            if (r9 == 0) goto La2
            java.lang.String r2 = r7.getRoomId()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r9.onNewMessage(r2)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
        La2:
            cu.todus.android.di.DatabaseModule r9 = r6.databaseModule     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            cu.todus.android.db.dao.toDus.MessageDao r9 = r9.getMessageDao()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            java.lang.String r2 = r7.getId()     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$0 = r7     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.L$1 = r8     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            r0.label = r3     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            java.lang.Object r7 = r9.forceUpdateStatus(r2, r5, r0)     // Catch: android.database.sqlite.SQLiteConstraintException -> L39
            if (r7 != r1) goto Lc5
        Lb8:
            return r1
        Lb9:
            r9.printStackTrace()
            cu.z17.views.utils.Z17MutableListFlow<kotlin.Pair<cu.todus.android.data.db.entity.toDus.Message, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>>> r9 = r6.incomingMessageNotInserted
            kotlin.Pair r7 = ua.z.a(r7, r8)
            r9.add(r7)
        Lc5:
            ua.k0 r7 = ua.k0.f43947a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.handleIncomingMsgAndAtt(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleIncomingMsgAndAtt$lambda$0(Message message, Pair it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(((Message) it.getFirst()).getId(), message.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object handleSendMarkers(Message message, List<Attachment> list, ab.e<? super k0> eVar) {
        C14261 c14261;
        int i10;
        String userSender;
        if (eVar instanceof C14261) {
            c14261 = (C14261) eVar;
            int i11 = c14261.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c14261.label = i11 - Integer.MIN_VALUE;
            } else {
                c14261 = new C14261(eVar);
            }
        } else {
            c14261 = new C14261(eVar);
        }
        Object obj = c14261.result;
        Object objG = bb.b.g();
        int i12 = c14261.label;
        try {
            if (i12 == 0) {
                ua.v.b(obj);
                if (!defpackage.r.a(list) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i10 = 0;
                            break;
                        }
                        if (((Attachment) it.next()).getType() == 16) {
                            i10 = 1;
                            break;
                        }
                    }
                } else {
                    i10 = 0;
                    break;
                }
                int i13 = i10 ^ 1;
                if (!kotlin.jvm.internal.y.d(message.getUserSender(), ((Owner) this.owner.invoke()).getNameWithDomain())) {
                    if (d0.a0(message.getRoomId(), Service.Config.MUC_LIGHT_SERVICE_NAME, false, 2, null)) {
                        userSender = message.getRoomId() + "/" + message.getUserSender();
                    } else {
                        userSender = message.getUserSender();
                    }
                    String str = userSender;
                    if (XMPPUtils.INSTANCE.needSendMarkers(message.getRoomId()) && i10 == 0) {
                        MarkerActionDao markerActionDao = this.databaseModule.getMarkerActionDao();
                        String string = UUID.randomUUID().toString();
                        kotlin.jvm.internal.y.h(string, "toString(...)");
                        List<MarkerAction> listE = va.v.e(new MarkerAction(le.a0.O(string, "-", "", false, 4, null), message.getId(), str, 1, 0L, 16, null));
                        c14261.L$0 = cb.l.a(message);
                        c14261.L$1 = cb.l.a(list);
                        c14261.L$2 = cb.l.a(str);
                        c14261.I$0 = i13;
                        c14261.label = 1;
                        if (markerActionDao.insertOrReplace(listE, c14261) == objG) {
                            return objG;
                        }
                    }
                }
                return k0.f43947a;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(obj);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x0110  */
    /* JADX WARN: Code duplicated, block: B:50:0x013b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0144  */
    /* JADX WARN: Code duplicated, block: B:55:0x015c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019b, code lost:
    
        if (r11.updateLastMessage(r9, r5, r6, r8) == r2) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdateLastInChannel(java.util.ArrayList<cu.todus.android.data.db.entity.toDus.Message> r19, ab.e<? super ua.k0> r20) {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.handleUpdateLastInChannel(java.util.ArrayList, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object notifyMsg(String str, ab.e<? super k0> eVar) {
        C14291 c14291;
        ke.h<MessageWithPartnerWithRoomWithReactions> hVarI;
        if (eVar instanceof C14291) {
            c14291 = (C14291) eVar;
            int i10 = c14291.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14291.label = i10 - Integer.MIN_VALUE;
            } else {
                c14291 = new C14291(eVar);
            }
        } else {
            c14291 = new C14291(eVar);
        }
        Object messagesForNotifications = c14291.result;
        Object objG = bb.b.g();
        int i11 = c14291.label;
        try {
            if (i11 == 0) {
                ua.v.b(messagesForNotifications);
                MessageDao messageDao = this.databaseModule.getMessageDao();
                c14291.L$0 = cb.l.a(str);
                c14291.label = 1;
                messagesForNotifications = messageDao.getMessagesForNotifications(str, c14291);
                if (messagesForNotifications == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(messagesForNotifications);
            }
            hVarI = g0.g0(g0.Y0((Iterable) messagesForNotifications));
        } catch (Exception unused) {
            hVarI = ke.q.i();
        }
        ArrayList arrayList = new ArrayList();
        for (MessageWithPartnerWithRoomWithReactions messageWithPartnerWithRoomWithReactions : hVarI) {
            if (messageWithPartnerWithRoomWithReactions.getMessage().getCreateAt() >= new Date().getTime() - ((long) 172800000)) {
                arrayList.add(ExtensionFunsKt.toNotification(messageWithPartnerWithRoomWithReactions, this.context, ((Owner) this.owner.invoke()).getNameWithDomain(), ((Owner) this.owner.invoke()).getAlias()));
            }
        }
        if (!arrayList.isEmpty()) {
            this.notificationManager.notify(arrayList);
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object processChannelMessage(String str, String str2, ab.e<? super Message> eVar) {
        C14301 c14301;
        if (eVar instanceof C14301) {
            c14301 = (C14301) eVar;
            int i10 = c14301.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14301.label = i10 - Integer.MIN_VALUE;
            } else {
                c14301 = new C14301(eVar);
            }
        } else {
            c14301 = new C14301(eVar);
        }
        Object obj = c14301.result;
        Object objG = bb.b.g();
        int i11 = c14301.label;
        try {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Message message = (Message) c14301.L$4;
                ua.v.b(obj);
                return message;
            }
            ua.v.b(obj);
            Type type = new TypeToken<Pair<? extends Message, ? extends List<? extends Attachment>>>() { // from class: cu.todus.android.xmpp.managers.ChannelManager$processChannelMessage$turnsType$1
            }.getType();
            Object objK = this.gson.k(str, type);
            kotlin.jvm.internal.y.h(objK, "fromJson(...)");
            Pair pair = (Pair) objK;
            Message messageCopy$default = Message.copy$default((Message) pair.getFirst(), null, null, null, null, 0L, -2, null, null, str2, 223, null);
            Iterable iterable = (Iterable) pair.getSecond();
            ArrayList arrayList = new ArrayList(va.x.y(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(Attachment.copy$default((Attachment) it.next(), null, null, null, 4, 0, false, 55, null));
            }
            List<Attachment> listO1 = g0.o1(arrayList);
            c14301.L$0 = cb.l.a(str);
            c14301.L$1 = cb.l.a(str2);
            c14301.L$2 = cb.l.a(type);
            c14301.L$3 = cb.l.a(pair);
            c14301.L$4 = messageCopy$default;
            c14301.L$5 = cb.l.a(listO1);
            c14301.label = 1;
            return processMessage(messageCopy$default, listO1, c14301) == objG ? objG : messageCopy$default;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00ab A[PHI: r9 r10 r11
      0x00ab: PHI (r9v4 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r9v3 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r9v16 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:28:0x00a8, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r10v4 cu.todus.android.data.db.entity.toDus.Message) = (r10v3 cu.todus.android.data.db.entity.toDus.Message), (r10v11 cu.todus.android.data.db.entity.toDus.Message) binds: [B:28:0x00a8, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r11v8 java.lang.Object) = (r11v7 java.lang.Object), (r11v1 java.lang.Object) binds: [B:28:0x00a8, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
    
        if (notifyMsg(r2, r0) == r1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processMessage(cu.todus.android.data.db.entity.toDus.Message r9, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r10, ab.e<? super ua.k0> r11) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.processMessage(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0075  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a7 -> B:23:0x00af). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object updateChannelsInfo(java.util.List<java.lang.String> r14, ab.e<? super ua.k0> r15) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.updateChannelsInfo(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object createChannel(String str, ab.e<? super String> eVar) {
        C14141 c14141;
        IQ iq;
        String chId;
        if (eVar instanceof C14141) {
            c14141 = (C14141) eVar;
            int i10 = c14141.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14141.label = i10 - Integer.MIN_VALUE;
            } else {
                c14141 = new C14141(eVar);
            }
        } else {
            c14141 = new C14141(eVar);
        }
        Object objX = c14141.result;
        Object objG = bb.b.g();
        int i11 = c14141.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue()) {
                XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
                if (xMPPTCPConnection != null) {
                    String string = UUID.randomUUID().toString();
                    kotlin.jvm.internal.y.h(string, "toString(...)");
                    CreateChannelIQ createChannelIQ = new CreateChannelIQ(str, le.a0.O(string, "-", "", false, 4, null), 0, null, null, null, null, MenuKt.InTransitionDuration, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, createChannelIQ);
                    c14141.L$0 = cb.l.a(str);
                    c14141.L$1 = cb.l.a(xMPPTCPConnection);
                    c14141.L$2 = cb.l.a(createChannelIQ);
                    c14141.I$0 = 0;
                    c14141.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14141);
                    if (objX == objG) {
                        return objG;
                    }
                } else {
                    iq = null;
                }
                if (!(iq instanceof CreateChannelIQ)) {
                    chId = ((CreateChannelIQ) iq).getChId();
                    if (d0.q0(chId)) {
                        return null;
                    }
                    return chId;
                }
                if (iq instanceof EmptyResultIQ) {
                    return "";
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        iq = (IQ) objX;
        if (!(iq instanceof CreateChannelIQ)) {
            if (iq instanceof EmptyResultIQ) {
                return "";
            }
            return null;
        }
        chId = ((CreateChannelIQ) iq).getChId();
        if (d0.q0(chId)) {
            return null;
        }
        return chId;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deleteMessageFromChannel(List<String> list, String str, ab.e<? super IQ> eVar) {
        C14151 c14151;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14151) {
            c14151 = (C14151) eVar;
            int i10 = c14151.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14151.label = i10 - Integer.MIN_VALUE;
            } else {
                c14151 = new C14151(eVar);
            }
        } else {
            c14151 = new C14151(eVar);
        }
        Object objX = c14151.result;
        Object objG = bb.b.g();
        int i11 = c14151.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue() || (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) == null) {
                return null;
            }
            DeletePubFromChannelIQ deletePubFromChannelIQ = new DeletePubFromChannelIQ(list, str);
            te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, deletePubFromChannelIQ);
            c14151.L$0 = cb.l.a(list);
            c14151.L$1 = cb.l.a(str);
            c14151.L$2 = cb.l.a(xMPPTCPConnection);
            c14151.L$3 = cb.l.a(deletePubFromChannelIQ);
            c14151.I$0 = 0;
            c14151.label = 1;
            objX = te.j.x(hVarSendIQFlow, c14151);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        return (IQ) objX;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object demoteAdmin(String str, String str2, ab.e<? super Boolean> eVar) {
        C14161 c14161;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14161) {
            c14161 = (C14161) eVar;
            int i10 = c14161.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14161.label = i10 - Integer.MIN_VALUE;
            } else {
                c14161 = new C14161(eVar);
            }
        } else {
            c14161 = new C14161(eVar);
        }
        Object objX = c14161.result;
        Object objG = bb.b.g();
        int i11 = c14161.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                DemoteAdminChannelIQ demoteAdminChannelIQ = new DemoteAdminChannelIQ(str, str2);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, demoteAdminChannelIQ);
                c14161.L$0 = cb.l.a(str);
                c14161.L$1 = cb.l.a(str2);
                c14161.L$2 = cb.l.a(xMPPTCPConnection);
                c14161.L$3 = cb.l.a(demoteAdminChannelIQ);
                c14161.I$0 = 0;
                c14161.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14161);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq instanceof EmptyResultIQ);
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object editAdmin(String str, String str2, String str3, ab.e<? super Boolean> eVar) {
        C14171 c14171;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14171) {
            c14171 = (C14171) eVar;
            int i10 = c14171.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14171.label = i10 - Integer.MIN_VALUE;
            } else {
                c14171 = new C14171(eVar);
            }
        } else {
            c14171 = new C14171(eVar);
        }
        Object objX = c14171.result;
        Object objG = bb.b.g();
        int i11 = c14171.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                EditAdminRightsIQ editAdminRightsIQ = new EditAdminRightsIQ(str2, str, str3);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, editAdminRightsIQ);
                c14171.L$0 = cb.l.a(str);
                c14171.L$1 = cb.l.a(str2);
                c14171.L$2 = cb.l.a(str3);
                c14171.L$3 = cb.l.a(xMPPTCPConnection);
                c14171.L$4 = cb.l.a(editAdminRightsIQ);
                c14171.I$0 = 0;
                c14171.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14171);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq instanceof EmptyResultIQ);
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object editMessageFromChannel(String str, String str2, String str3, ab.e<? super IQ> eVar) {
        C14181 c14181;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14181) {
            c14181 = (C14181) eVar;
            int i10 = c14181.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14181.label = i10 - Integer.MIN_VALUE;
            } else {
                c14181 = new C14181(eVar);
            }
        } else {
            c14181 = new C14181(eVar);
        }
        Object objX = c14181.result;
        Object objG = bb.b.g();
        int i11 = c14181.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue() || (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) == null) {
                return null;
            }
            EditPubChannelIQ editPubChannelIQ = new EditPubChannelIQ(str2, str, str3);
            te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, editPubChannelIQ);
            c14181.L$0 = cb.l.a(str);
            c14181.L$1 = cb.l.a(str2);
            c14181.L$2 = cb.l.a(str3);
            c14181.L$3 = cb.l.a(xMPPTCPConnection);
            c14181.L$4 = cb.l.a(editPubChannelIQ);
            c14181.I$0 = 0;
            c14181.label = 1;
            objX = te.j.x(hVarSendIQFlow, c14181);
            if (objX == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(objX);
        }
        return (IQ) objX;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object expelSubscriber(String str, String str2, ab.e<? super Boolean> eVar) {
        C14191 c14191;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14191) {
            c14191 = (C14191) eVar;
            int i10 = c14191.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14191.label = i10 - Integer.MIN_VALUE;
            } else {
                c14191 = new C14191(eVar);
            }
        } else {
            c14191 = new C14191(eVar);
        }
        Object objX = c14191.result;
        Object objG = bb.b.g();
        int i11 = c14191.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                DeleteSubscriberChannelIQ deleteSubscriberChannelIQ = new DeleteSubscriberChannelIQ(str, str2);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, deleteSubscriberChannelIQ);
                c14191.L$0 = cb.l.a(str);
                c14191.L$1 = cb.l.a(str2);
                c14191.L$2 = cb.l.a(xMPPTCPConnection);
                c14191.L$3 = cb.l.a(deleteSubscriberChannelIQ);
                c14191.I$0 = 0;
                c14191.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14191);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq instanceof EmptyResultIQ);
        }
        return cb.b.a(false);
    }

    public final lb.a getCanSend() {
        return this.canSend;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getChannelAdmins(String str, ab.e<? super ArrayList<ChannelAdmin>> eVar) {
        C14201 c14201;
        ArrayList<ChannelAdmin> admins;
        if (eVar instanceof C14201) {
            c14201 = (C14201) eVar;
            int i10 = c14201.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14201.label = i10 - Integer.MIN_VALUE;
            } else {
                c14201 = new C14201(eVar);
            }
        } else {
            c14201 = new C14201(eVar);
        }
        Object objX = c14201.result;
        Object objG = bb.b.g();
        int i11 = c14201.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (!((Boolean) this.canSend.invoke()).booleanValue()) {
                return new ArrayList();
            }
            XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke();
            if (xMPPTCPConnection != null) {
                GetChannelAdminsIQ getChannelAdminsIQ = new GetChannelAdminsIQ(str, null, 2, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, getChannelAdminsIQ);
                c14201.L$0 = cb.l.a(str);
                c14201.L$1 = cb.l.a(xMPPTCPConnection);
                c14201.L$2 = cb.l.a(getChannelAdminsIQ);
                c14201.I$0 = 0;
                c14201.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14201);
                if (objX == objG) {
                    return objG;
                }
            }
            return new ArrayList();
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        GetChannelAdminsIQ getChannelAdminsIQ2 = (GetChannelAdminsIQ) ((IQ) objX);
        if (getChannelAdminsIQ2 != null && (admins = getChannelAdminsIQ2.getAdmins()) != null) {
            return admins;
        }
        return new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getChannelInfoById(String str, ab.e<? super ChannelInfo> eVar) {
        C14211 c14211;
        String message;
        XMPPTCPConnection xMPPTCPConnection;
        ChannelInfoIQById channelInfoIQById;
        ChannelInfo channelInfo;
        if (eVar instanceof C14211) {
            c14211 = (C14211) eVar;
            int i10 = c14211.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14211.label = i10 - Integer.MIN_VALUE;
            } else {
                c14211 = new C14211(eVar);
            }
        } else {
            c14211 = new C14211(eVar);
        }
        Object objX = c14211.result;
        Object objG = bb.b.g();
        int i11 = c14211.label;
        try {
            if (i11 == 0) {
                ua.v.b(objX);
                if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                    ChannelInfoIQById channelInfoIQById2 = new ChannelInfoIQById(str, null, 2, null);
                    te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, channelInfoIQById2);
                    c14211.L$0 = str;
                    c14211.L$1 = cb.l.a(xMPPTCPConnection);
                    c14211.L$2 = cb.l.a(channelInfoIQById2);
                    c14211.I$0 = 0;
                    c14211.label = 1;
                    objX = te.j.x(hVarSendIQFlow, c14211);
                    if (objX == objG) {
                        return objG;
                    }
                    channelInfoIQById = (ChannelInfoIQById) ((IQ) objX);
                    if (channelInfoIQById != null) {
                        return null;
                    }
                }
            } else {
                if (i11 == 1) {
                    str = (String) c14211.L$0;
                    ua.v.b(objX);
                    channelInfoIQById = (ChannelInfoIQById) ((IQ) objX);
                    if (channelInfoIQById != null || (channelInfo = channelInfoIQById.getChannelInfo()) == null) {
                        return null;
                    }
                    channelInfo.setId(str);
                    return channelInfo;
                }
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua.v.b(objX);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            String message2 = e10.getMessage();
            if ((message2 != null && d0.a0(message2, "ERR_CH_NOT_SUBSCRIBER", false, 2, null)) || ((message = e10.getMessage()) != null && d0.a0(message, "ERR_CH_CHANNEL_NOT_EXISTS", false, 2, null))) {
                RoomDao roomDao = this.databaseModule.getRoomDao();
                c14211.L$0 = cb.l.a(str);
                c14211.L$1 = cb.l.a(e10);
                c14211.L$2 = null;
                c14211.label = 2;
                if (roomDao.delete(str, c14211) == objG) {
                    return objG;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getChannelInfoByLinkId(String str, ab.e<? super ChannelInfo> eVar) {
        C14221 c14221;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14221) {
            c14221 = (C14221) eVar;
            int i10 = c14221.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14221.label = i10 - Integer.MIN_VALUE;
            } else {
                c14221 = new C14221(eVar);
            }
        } else {
            c14221 = new C14221(eVar);
        }
        Object objX = c14221.result;
        Object objG = bb.b.g();
        int i11 = c14221.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                ChannelInfoIQByLink channelInfoIQByLink = new ChannelInfoIQByLink(d0.K0(str, "@"), null, 2, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, channelInfoIQByLink);
                c14221.L$0 = cb.l.a(str);
                c14221.L$1 = cb.l.a(xMPPTCPConnection);
                c14221.L$2 = cb.l.a(channelInfoIQByLink);
                c14221.I$0 = 0;
                c14221.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14221);
                if (objX == objG) {
                    return objG;
                }
            }
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        ChannelInfoIQByLink channelInfoIQByLink2 = (ChannelInfoIQByLink) ((IQ) objX);
        if (channelInfoIQByLink2 != null) {
            return channelInfoIQByLink2.getChannelInfo();
        }
        return null;
    }

    public final Function2 getGetUserInfo() {
        return this.getUserInfo;
    }

    public final lb.a getMXMPPConnection() {
        return this.mXMPPConnection;
    }

    public final lb.a getOwner() {
        return this.owner;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x0210  */
    /* JADX WARN: Code duplicated, block: B:39:0x0215  */
    /* JADX WARN: Code duplicated, block: B:42:0x0233  */
    /* JADX WARN: Code duplicated, block: B:43:0x026e  */
    /* JADX WARN: Code duplicated, block: B:46:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0233 -> B:52:0x0329). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x02cc -> B:47:0x02e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getSubscribersPage(java.lang.String r29, int r30, int r31, ab.e<? super java.util.List<cu.todus.android.data.db.pojo.ChannelSubscriber>> r32) {
        /*
            Method dump skipped, instruction units count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.getSubscribersPage(java.lang.String, int, int, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0085  */
    /* JADX WARN: Code duplicated, block: B:27:0x0096  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:43:0x0106 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #1 {Exception -> 0x0069, blocks: (B:16:0x0064, B:41:0x0102, B:43:0x0106), top: B:58:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f6 -> B:41:0x0102). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object handlePublications(java.util.ArrayList<android.os.Bundle> r18, ab.e<? super ua.k0> r19) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.handlePublications(java.util.ArrayList, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object leaveChannel(String str, ab.e<? super Boolean> eVar) {
        C14281 c14281;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14281) {
            c14281 = (C14281) eVar;
            int i10 = c14281.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14281.label = i10 - Integer.MIN_VALUE;
            } else {
                c14281 = new C14281(eVar);
            }
        } else {
            c14281 = new C14281(eVar);
        }
        Object objX = c14281.result;
        Object objG = bb.b.g();
        int i11 = c14281.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                LeaveChannelIQ leaveChannelIQ = new LeaveChannelIQ(str);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, leaveChannelIQ);
                c14281.L$0 = cb.l.a(str);
                c14281.L$1 = cb.l.a(xMPPTCPConnection);
                c14281.L$2 = cb.l.a(leaveChannelIQ);
                c14281.I$0 = 0;
                c14281.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14281);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq instanceof EmptyResultIQ);
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object promoteAdmin(String str, String str2, String str3, ab.e<? super Boolean> eVar) {
        C14321 c14321;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14321) {
            c14321 = (C14321) eVar;
            int i10 = c14321.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14321.label = i10 - Integer.MIN_VALUE;
            } else {
                c14321 = new C14321(eVar);
            }
        } else {
            c14321 = new C14321(eVar);
        }
        Object objX = c14321.result;
        Object objG = bb.b.g();
        int i11 = c14321.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                PromoteToAdminChannelIQ promoteToAdminChannelIQ = new PromoteToAdminChannelIQ(str, str2, str3);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, promoteToAdminChannelIQ);
                c14321.L$0 = cb.l.a(str);
                c14321.L$1 = cb.l.a(str2);
                c14321.L$2 = cb.l.a(str3);
                c14321.L$3 = cb.l.a(xMPPTCPConnection);
                c14321.L$4 = cb.l.a(promoteToAdminChannelIQ);
                c14321.I$0 = 0;
                c14321.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14321);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq instanceof EmptyResultIQ);
        }
        return cb.b.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x0126  */
    /* JADX WARN: Code duplicated, block: B:49:0x017a  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x013e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object reloadChannel(String str, ab.e<? super k0> eVar) {
        C14331 c14331;
        String str2;
        ChannelInfo channelInfo;
        Room room;
        String version;
        Pair<Room, UserRoomJoin> pairFromChannelInfoToRoom;
        RoomDao roomDao;
        Map mapA;
        Room roomCopy$default;
        ChannelInfo channelInfo2;
        ChannelInfo channelInfo3;
        int i10;
        String key;
        String value;
        Pair<Room, UserRoomJoin> pair;
        UserRoomJoinDao userRoomJoinDao;
        UserRoomJoin second;
        String str3 = str;
        if (eVar instanceof C14331) {
            c14331 = (C14331) eVar;
            int i11 = c14331.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c14331.label = i11 - Integer.MIN_VALUE;
            } else {
                c14331 = new C14331(eVar);
            }
        } else {
            c14331 = new C14331(eVar);
        }
        Object channelInfoById = c14331.result;
        Object objG = bb.b.g();
        int i12 = c14331.label;
        if (i12 == 0) {
            ua.v.b(channelInfoById);
            c14331.L$0 = str3;
            c14331.label = 1;
            channelInfoById = getChannelInfoById(str3, c14331);
            if (channelInfoById != objG) {
            }
            return objG;
        }
        if (i12 == 1) {
            str3 = (String) c14331.L$0;
            ua.v.b(channelInfoById);
        } else {
            if (i12 == 2) {
                channelInfo = (ChannelInfo) c14331.L$1;
                String str4 = (String) c14331.L$0;
                ua.v.b(channelInfoById);
                str2 = str4;
                room = (Room) channelInfoById;
                if (channelInfo != null) {
                    version = channelInfo.getVersion();
                } else {
                    version = null;
                }
                if (!kotlin.jvm.internal.y.d(version, room != null ? room.getVersion() : null) && channelInfo != null) {
                    pairFromChannelInfoToRoom = MapperToRoom.INSTANCE.fromChannelInfoToRoom(channelInfo, ((Owner) this.owner.invoke()).getUsername());
                    roomDao = this.databaseModule.getRoomDao();
                    Room first = pairFromChannelInfoToRoom.getFirst();
                    kotlin.jvm.internal.y.f(room);
                    String msgId = room.getMsgId();
                    boolean secret = room.getSecret();
                    boolean zIsMuted = room.isMuted();
                    long lastUpdate = room.getLastUpdate();
                    boolean pined = room.getPined();
                    mapA = w0.A(pairFromChannelInfoToRoom.getFirst().getConfig());
                    for (Map.Entry<String, String> entry : room.getConfig().entrySet()) {
                        key = entry.getKey();
                        value = entry.getValue();
                        if (mapA.get(key) == null) {
                            mapA.put(key, value);
                        }
                    }
                    roomCopy$default = Room.copy$default(first, null, null, 0, null, null, mapA, lastUpdate, 0, msgId, pined, secret, zIsMuted, WebmConstants.MkvEbmlElement.CHANNELS, null);
                    c14331.L$0 = cb.l.a(str2);
                    c14331.L$1 = cb.l.a(channelInfo);
                    c14331.L$2 = cb.l.a(room);
                    c14331.L$3 = cb.l.a(channelInfo);
                    c14331.L$4 = pairFromChannelInfoToRoom;
                    c14331.I$0 = 0;
                    c14331.label = 3;
                    if (roomDao.update(roomCopy$default, c14331) != objG) {
                        channelInfo2 = channelInfo;
                        channelInfo3 = channelInfo2;
                        i10 = 0;
                        userRoomJoinDao = this.databaseModule.getUserRoomJoinDao();
                        second = pairFromChannelInfoToRoom.getSecond();
                        c14331.L$0 = cb.l.a(str2);
                        c14331.L$1 = cb.l.a(channelInfo3);
                        c14331.L$2 = cb.l.a(room);
                        c14331.L$3 = cb.l.a(channelInfo2);
                        c14331.L$4 = pairFromChannelInfoToRoom;
                        c14331.I$0 = i10;
                        c14331.label = 4;
                        if (userRoomJoinDao.upsert(second, c14331) != objG) {
                            pair = pairFromChannelInfoToRoom;
                        }
                    }
                    return objG;
                }
                return k0.f43947a;
            }
            if (i12 == 3) {
                i10 = c14331.I$0;
                Pair<Room, UserRoomJoin> pair2 = (Pair) c14331.L$4;
                channelInfo2 = (ChannelInfo) c14331.L$3;
                room = (Room) c14331.L$2;
                channelInfo3 = (ChannelInfo) c14331.L$1;
                str2 = (String) c14331.L$0;
                ua.v.b(channelInfoById);
                pairFromChannelInfoToRoom = pair2;
                try {
                    userRoomJoinDao = this.databaseModule.getUserRoomJoinDao();
                    second = pairFromChannelInfoToRoom.getSecond();
                    c14331.L$0 = cb.l.a(str2);
                    c14331.L$1 = cb.l.a(channelInfo3);
                    c14331.L$2 = cb.l.a(room);
                    c14331.L$3 = cb.l.a(channelInfo2);
                    c14331.L$4 = pairFromChannelInfoToRoom;
                    c14331.I$0 = i10;
                    c14331.label = 4;
                    if (userRoomJoinDao.upsert(second, c14331) != objG) {
                        pair = pairFromChannelInfoToRoom;
                    }
                    return objG;
                } catch (Exception e10) {
                    e = e10;
                    pair = pairFromChannelInfoToRoom;
                    e.printStackTrace();
                }
            } else {
                if (i12 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pair = (Pair) c14331.L$4;
                try {
                    ua.v.b(channelInfoById);
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                }
            }
        }
        Z17CoilDecoders.Companion companion = Z17CoilDecoders.INSTANCE;
        companion.getInstance().clearCacheFor(pair.getFirst().getPicture());
        companion.getInstance().clearCacheFor(pair.getFirst().getThumbnail());
        return k0.f43947a;
        ChannelInfo channelInfo4 = (ChannelInfo) channelInfoById;
        RoomDao roomDao2 = this.databaseModule.getRoomDao();
        c14331.L$0 = cb.l.a(str3);
        c14331.L$1 = channelInfo4;
        c14331.label = 2;
        Object roomById = roomDao2.getRoomById(str3, c14331);
        if (roomById != objG) {
            str2 = str3;
            channelInfo = channelInfo4;
            channelInfoById = roomById;
            room = (Room) channelInfoById;
            if (channelInfo != null) {
                version = channelInfo.getVersion();
            } else {
                version = null;
            }
            if (!kotlin.jvm.internal.y.d(version, room != null ? room.getVersion() : null)) {
                pairFromChannelInfoToRoom = MapperToRoom.INSTANCE.fromChannelInfoToRoom(channelInfo, ((Owner) this.owner.invoke()).getUsername());
                roomDao = this.databaseModule.getRoomDao();
                Room first2 = pairFromChannelInfoToRoom.getFirst();
                kotlin.jvm.internal.y.f(room);
                String msgId2 = room.getMsgId();
                boolean secret2 = room.getSecret();
                boolean zIsMuted2 = room.isMuted();
                long lastUpdate2 = room.getLastUpdate();
                boolean pined2 = room.getPined();
                mapA = w0.A(pairFromChannelInfoToRoom.getFirst().getConfig());
                while (r12.hasNext()) {
                    key = entry.getKey();
                    value = entry.getValue();
                    if (mapA.get(key) == null) {
                        mapA.put(key, value);
                    }
                }
                roomCopy$default = Room.copy$default(first2, null, null, 0, null, null, mapA, lastUpdate2, 0, msgId2, pined2, secret2, zIsMuted2, WebmConstants.MkvEbmlElement.CHANNELS, null);
                c14331.L$0 = cb.l.a(str2);
                c14331.L$1 = cb.l.a(channelInfo);
                c14331.L$2 = cb.l.a(room);
                c14331.L$3 = cb.l.a(channelInfo);
                c14331.L$4 = pairFromChannelInfoToRoom;
                c14331.I$0 = 0;
                c14331.label = 3;
                if (roomDao.update(roomCopy$default, c14331) != objG) {
                    channelInfo2 = channelInfo;
                    channelInfo3 = channelInfo2;
                    i10 = 0;
                    userRoomJoinDao = this.databaseModule.getUserRoomJoinDao();
                    second = pairFromChannelInfoToRoom.getSecond();
                    c14331.L$0 = cb.l.a(str2);
                    c14331.L$1 = cb.l.a(channelInfo3);
                    c14331.L$2 = cb.l.a(room);
                    c14331.L$3 = cb.l.a(channelInfo2);
                    c14331.L$4 = pairFromChannelInfoToRoom;
                    c14331.I$0 = i10;
                    c14331.label = 4;
                    if (userRoomJoinDao.upsert(second, c14331) != objG) {
                        pair = pairFromChannelInfoToRoom;
                        Z17CoilDecoders.Companion companion2 = Z17CoilDecoders.INSTANCE;
                        companion2.getInstance().clearCacheFor(pair.getFirst().getPicture());
                        companion2.getInstance().clearCacheFor(pair.getFirst().getThumbnail());
                    }
                }
            }
            return k0.f43947a;
        }
        return objG;
    }

    public final Object reloadChannels(ab.e<? super k0> eVar) {
        if (!((Boolean) this.canSend.invoke()).booleanValue()) {
            return k0.f43947a;
        }
        Object objRecursivePagingRequest$default = XMPPInlinesKt.recursivePagingRequest$default(new AnonymousClass2(null), 0, 10, 0L, new AnonymousClass3(null), new lb.a() { // from class: cu.todus.android.xmpp.managers.l
            @Override // lb.a
            public final Object invoke() {
                return k0.f43947a;
            }
        }, null, eVar, 72, null);
        return objRecursivePagingRequest$default == bb.b.g() ? objRecursivePagingRequest$default : k0.f43947a;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e2, code lost:
    
        if (handlePublications(r4, r1) == r2) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reloadPubById(java.lang.String r15, java.lang.String r16, ab.e<? super ua.k0> r17) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.reloadPubById(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
    
        if (reloadChannels(r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object subscribe(java.lang.String r9, ab.e<? super cu.todus.android.data.xmpp.JoinResult> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cu.todus.android.xmpp.managers.ChannelManager.C14351
            if (r0 == 0) goto L13
            r0 = r10
            cu.todus.android.xmpp.managers.ChannelManager$subscribe$1 r0 = (cu.todus.android.xmpp.managers.ChannelManager.C14351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.ChannelManager$subscribe$1 r0 = new cu.todus.android.xmpp.managers.ChannelManager$subscribe$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4d
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r9 = r0.L$1
            org.jivesoftware.smack.packet.IQ r9 = (org.jivesoftware.smack.packet.IQ) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            ua.v.b(r10)
            goto La2
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.lang.Object r9 = r0.L$2
            org.jivesoftware.smack.packet.IQ r9 = (org.jivesoftware.smack.packet.IQ) r9
            java.lang.Object r9 = r0.L$1
            org.jivesoftware.smack.tcp.XMPPTCPConnection r9 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            ua.v.b(r10)
            goto L80
        L4d:
            ua.v.b(r10)
            lb.a r10 = r8.mXMPPConnection
            java.lang.Object r10 = r10.invoke()
            org.jivesoftware.smack.tcp.XMPPTCPConnection r10 = (org.jivesoftware.smack.tcp.XMPPTCPConnection) r10
            if (r10 == 0) goto La5
            cu.todus.android.xmpp.iq.channels.SubscribeToChannelIQ r2 = new cu.todus.android.xmpp.iq.channels.SubscribeToChannelIQ
            r2.<init>(r9)
            te.h r6 = cu.todus.android.xmpp.XMPPInlinesKt.sendIQFlow(r10, r2)
            java.lang.Object r7 = cb.l.a(r9)
            r0.L$0 = r7
            java.lang.Object r10 = cb.l.a(r10)
            r0.L$1 = r10
            java.lang.Object r10 = cb.l.a(r2)
            r0.L$2 = r10
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r10 = te.j.x(r6, r0)
            if (r10 != r1) goto L80
            goto La1
        L80:
            org.jivesoftware.smack.packet.IQ r10 = (org.jivesoftware.smack.packet.IQ) r10
            if (r10 == 0) goto La5
            boolean r2 = r10 instanceof org.jivesoftware.smack.packet.EmptyResultIQ
            if (r2 == 0) goto La5
            java.lang.Object r9 = cb.l.a(r9)
            r0.L$0 = r9
            java.lang.Object r9 = cb.l.a(r10)
            r0.L$1 = r9
            r9 = 0
            r0.L$2 = r9
            r0.I$0 = r3
            r0.label = r4
            java.lang.Object r9 = r8.reloadChannels(r0)
            if (r9 != r1) goto La2
        La1:
            return r1
        La2:
            cu.todus.android.data.xmpp.JoinResult r9 = cu.todus.android.data.xmpp.JoinResult.JOINED
            return r9
        La5:
            cu.todus.android.data.xmpp.JoinResult r9 = cu.todus.android.data.xmpp.JoinResult.FAIL_JOIN
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.ChannelManager.subscribe(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object updateChannelInfo(String str, String str2, String str3, String str4, String str5, String str6, ab.e<? super Boolean> eVar) {
        C14361 c14361;
        XMPPTCPConnection xMPPTCPConnection;
        if (eVar instanceof C14361) {
            c14361 = (C14361) eVar;
            int i10 = c14361.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14361.label = i10 - Integer.MIN_VALUE;
            } else {
                c14361 = new C14361(eVar);
            }
        } else {
            c14361 = new C14361(eVar);
        }
        Object objX = c14361.result;
        Object objG = bb.b.g();
        int i11 = c14361.label;
        if (i11 == 0) {
            ua.v.b(objX);
            if (((Boolean) this.canSend.invoke()).booleanValue() && (xMPPTCPConnection = (XMPPTCPConnection) this.mXMPPConnection.invoke()) != null) {
                EditInfoChannelIQ editInfoChannelIQ = new EditInfoChannelIQ(str, str5, null, str2, str3, str4, str6, 4, null);
                te.h hVarSendIQFlow = XMPPInlinesKt.sendIQFlow(xMPPTCPConnection, editInfoChannelIQ);
                c14361.L$0 = cb.l.a(str);
                c14361.L$1 = cb.l.a(str2);
                c14361.L$2 = cb.l.a(str3);
                c14361.L$3 = cb.l.a(str4);
                c14361.L$4 = cb.l.a(str5);
                c14361.L$5 = cb.l.a(str6);
                c14361.L$6 = cb.l.a(xMPPTCPConnection);
                c14361.L$7 = cb.l.a(editInfoChannelIQ);
                c14361.I$0 = 0;
                c14361.label = 1;
                objX = te.j.x(hVarSendIQFlow, c14361);
                if (objX == objG) {
                    return objG;
                }
            }
            return cb.b.a(false);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objX);
        IQ iq = (IQ) objX;
        if (iq != null) {
            return cb.b.a(iq.getType() == IQ.Type.result);
        }
        return cb.b.a(false);
    }
}
