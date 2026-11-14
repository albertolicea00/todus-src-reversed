package cu.todus.android.xmpp.managers;

import android.content.Context;
import android.util.Log;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import cu.todus.android.data.db.entity.toDus.Attachment;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.db.pojo.Partner;
import cu.todus.android.data.db.pojo.RoomItemView;
import cu.todus.android.data.db.pojo.content.CallContent;
import cu.todus.android.data.db.pojo.content.Content;
import cu.todus.android.data.db.pojo.info.ConfigChangeInGroup;
import cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.xmpp.ChatMarker;
import cu.todus.android.data.xmpp.GroupAffiliation;
import cu.todus.android.db.dao.toDus.AttachmentDao;
import cu.todus.android.db.dao.toDus.ContactDao;
import cu.todus.android.db.dao.toDus.MarkerActionDao;
import cu.todus.android.db.dao.toDus.MessageDao;
import cu.todus.android.db.dao.toDus.ReactionDao;
import cu.todus.android.db.dao.toDus.RoomDao;
import cu.todus.android.db.dao.toDus.StatusDao;
import cu.todus.android.db.dao.toDus.UserDao;
import cu.todus.android.db.dao.toDus.UserRoomJoinDao;
import cu.todus.android.di.DatabaseModule;
import cu.todus.android.di.MainModule;
import cu.todus.android.notification.ConfigProcessor;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.notification.notifications.CallNotification;
import cu.todus.android.utils.Base64Util;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPInlinesKt;
import cu.todus.android.xmpp.XMPPUtils;
import cu.todus.android.xmpp.iq.groups.AffiliationsChangeExtension;
import cu.todus.android.xmpp.iq.groups.ConfigurationsChangeExtension;
import cu.todus.android.xmpp.iq.offline.OfflineElement;
import cu.z17.views.utils.Z17MutableListFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import le.d0;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chatstates.ChatStateToDus;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtensionToDus;
import org.jxmpp.jid.impl.JidCreate;
import ua.k0;
import va.g0;
import va.y0;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BÁ\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002\u0012\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u0012$\u0010\u0017\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u0012$\u0010\u0019\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u0012$\u0010\u001b\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u00122\u0010\u001f\u001a.\b\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u0012(\u0010!\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 \u0012\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00100#\u0012.\u0010(\u001a*\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b4\u00101J \u00107\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.2\u0006\u00106\u001a\u000205H\u0082@¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b9\u00101J\u0017\u0010:\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b<\u00101J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b=\u00101J\u0018\u0010>\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.H\u0082@¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b@\u00101J\u0018\u0010A\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.H\u0082@¢\u0006\u0004\bA\u0010?J%\u0010E\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002¢\u0006\u0004\bE\u0010FJ \u0010I\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0082@¢\u0006\u0004\bI\u0010JJ&\u0010L\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0BH\u0082@¢\u0006\u0004\bL\u0010MJ \u0010P\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0082@¢\u0006\u0004\bP\u0010JJ \u0010S\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0082@¢\u0006\u0004\bS\u0010JJ(\u0010W\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0082@¢\u0006\u0004\bW\u0010XJ8\u0010[\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010Y\u001a\u0002052\b\b\u0002\u0010Z\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b[\u0010\\J\u0018\u0010]\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.H\u0082@¢\u0006\u0004\b]\u0010?J\u0017\u0010^\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b^\u0010_J\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020`0B2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\ba\u0010bJ#\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030c2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\bd\u0010eJ\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020g0f2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020g2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\bj\u0010kJ0\u0010n\u001a\u00020\u00102\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0B2\b\b\u0002\u0010Z\u001a\u00020\u0003H\u0082@¢\u0006\u0004\bn\u0010oJ\u0018\u0010p\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bp\u0010qJ\u0018\u0010r\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\br\u0010qJ\u0018\u0010s\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bs\u0010qJ\u0018\u0010t\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bt\u0010qJ\u0018\u0010u\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bu\u0010qJ\u0018\u0010v\u001a\u00020\u00102\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bv\u0010qJ\u0018\u0010w\u001a\u00020\u00032\u0006\u0010l\u001a\u00020gH\u0082@¢\u0006\u0004\bw\u0010qJ\u0018\u0010y\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\bH\u0082@¢\u0006\u0004\by\u0010zJ \u0010}\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\b2\u0006\u0010|\u001a\u00020{H\u0082@¢\u0006\u0004\b}\u0010~J#\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\b2\u0006\u0010|\u001a\u00020\u007fH\u0082@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J%\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\b2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0082@¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J:\u0010\u0087\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0B2\u0007\u0010\u0086\u0001\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0003H\u0082@¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J)\u0010\u0089\u0001\u001a\u00020\u00032\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0BH\u0082@¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J)\u0010\u008b\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0BH\u0082@¢\u0006\u0006\b\u008b\u0001\u0010\u008a\u0001J)\u0010\u008c\u0001\u001a\u00020\u00102\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0BH\u0082@¢\u0006\u0006\b\u008c\u0001\u0010\u008a\u0001J\u001a\u0010\u008d\u0001\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\bH\u0082@¢\u0006\u0005\b\u008d\u0001\u0010zJ\u001b\u0010\u008f\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\bH\u0082@¢\u0006\u0005\b\u008f\u0001\u0010zJ'\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\b2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0003H\u0082@¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00032\u0007\u0010\u0093\u0001\u001a\u00020\bH\u0082@¢\u0006\u0005\b\u0094\u0001\u0010zJ\u001a\u0010\u0095\u0001\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\bH\u0082@¢\u0006\u0005\b\u0095\u0001\u0010zJ(\u0010\u0096\u0001\u001a\u00020g2\u0006\u0010l\u001a\u00020g2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001c\u0010\u0099\u0001\u001a\u00020\u00102\u0007\u0010/\u001a\u00030\u0098\u0001H\u0096@¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J!\u0010\u009b\u0001\u001a\u00020\u00102\f\u0010l\u001a\b\u0012\u0004\u0012\u00020g0BH\u0086@¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\r\u001a\u00020\f8\u0006¢\u0006\u000f\n\u0005\b\r\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\u000f\n\u0005\b\u000f\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006¢\u0006\u000f\n\u0005\b\u0011\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R6\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\u0015\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R8\u0010\u0017\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\u0017\u0010¦\u0001\u001a\u0006\b©\u0001\u0010¨\u0001R8\u0010\u0019\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\u0019\u0010¦\u0001\u001a\u0006\bª\u0001\u0010¨\u0001R8\u0010\u001b\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\u001b\u0010¦\u0001\u001a\u0006\b«\u0001\u0010¨\u0001RF\u0010\u001f\u001a.\b\u0001\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\u001f\u0010¦\u0001\u001a\u0006\b¬\u0001\u0010¨\u0001R<\u0010!\u001a$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140 8\u0006¢\u0006\u000f\n\u0005\b!\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001R6\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00128\u0006¢\u0006\u000f\n\u0005\b\"\u0010¦\u0001\u001a\u0006\b°\u0001\u0010¨\u0001R&\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00100#8\u0006¢\u0006\u000f\n\u0005\b%\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001RB\u0010(\u001a*\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140&8\u0006¢\u0006\u000f\n\u0005\b(\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0018\u0010¾\u0001\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010Á\u0001\u001a\u00030À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0018\u0010Ä\u0001\u001a\u00030Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0018\u0010Ç\u0001\u001a\u00030Æ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0018\u0010Ê\u0001\u001a\u00030É\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0018\u0010Í\u0001\u001a\u00030Ì\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ð\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ó\u0001\u001a\u00030Ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R0\u0010Ö\u0001\u001a\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020g\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B0c0Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R \u0010Ù\u0001\u001a\u00030Ø\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001¨\u0006Ý\u0001"}, d2 = {"Lcu/todus/android/xmpp/managers/MessageManager;", "Lcu/todus/android/xmpp/managers/IMManager;", "Lkotlin/Function0;", "", "canSend", "Lorg/jivesoftware/smack/tcp/XMPPTCPConnection;", "mXMPPConnection", "", "", "blockRoom", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Landroid/content/Context;", "context", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lua/k0;", "reloadChannels", "Lkotlin/Function2;", "Lab/e;", "", "callMucMemberList", "Lcu/todus/android/data/db/entity/toDus/User;", "getUserInfo", "Lcu/todus/android/data/xmpp/MucInfo;", "getGroupInfo", "Lcu/todus/android/data/xmpp/ChannelInfo;", "getChannelInfo", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "handlePublications", "Lkotlin/Function3;", "reloadPub", "reloadUser", "Lkotlin/Function1;", "Lcu/todus/android/data/db/pojo/content/StatusExistenceContent;", "handleStatusExistence", "Lkotlin/Function4;", "Lcu/todus/android/data/db/pojo/content/CallContent;", "handleCallMessage", "<init>", "(Llb/a;Llb/a;Ljava/util/Map;Llb/a;Landroid/content/Context;Lcu/todus/android/notification/NotificationManager;Llb/a;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Llb/o;)V", "stanzaId", "sendReceived", "(Ljava/lang/String;)V", "Lorg/jivesoftware/smack/packet/Message;", "stanza", "identifyNotification", "(Lorg/jivesoftware/smack/packet/Message;)Z", "handleNotification", "()V", "identifyMarker", "Ljava/util/Date;", "createAt", "handleMarker", "(Lorg/jivesoftware/smack/packet/Message;Ljava/util/Date;Lab/e;)Ljava/lang/Object;", "identifyTyping", "handleTyping", "(Lorg/jivesoftware/smack/packet/Message;)V", "identifyAddedToChannel", "identifyAffiliationChange", "handleAffiliationChange", "(Lorg/jivesoftware/smack/packet/Message;Lab/e;)Ljava/lang/Object;", "identifyRoomConfigs", "handleRoomConfigs", "", "Lcu/todus/android/data/db/entity/toDus/Attachment;", Attachment.TABLE_NAME, "handleReaction", "(Lorg/jivesoftware/smack/packet/Message;Ljava/util/List;)V", "chId", "pubId", "handlePubEdited", "(Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "pubsId", "handlePubDeleted", "(Ljava/lang/String;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "userId", User.COLUMN_TODUS_ID, "handleUpdateToDusId", "senderId", Room.COLUMN_LAST_MSG, "handleDeleteOwnerMsg", "getUrl", "streamUrl", "downloadUrl", "handleStreamVideoProcessed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "date", "callIsCancelled", "handleNotNullBody", "(Lorg/jivesoftware/smack/packet/Message;Ljava/util/List;Ljava/util/Date;ZLab/e;)Ljava/lang/Object;", "handleNullBody", "getFrom", "(Lorg/jivesoftware/smack/packet/Message;)Ljava/lang/String;", "Lcu/todus/android/data/xmpp/ChatMarker;", "getChatMarket", "(Lorg/jivesoftware/smack/packet/Message;)Ljava/util/List;", "Lkotlin/Pair;", "getChatState", "(Lorg/jivesoftware/smack/packet/Message;)Lkotlin/Pair;", "Lke/h;", "Lcu/todus/android/data/db/entity/toDus/Message;", "getAffiliationsChange", "(Lorg/jivesoftware/smack/packet/Message;)Lke/h;", "getRoomConfigChange", "(Lorg/jivesoftware/smack/packet/Message;)Lcu/todus/android/data/db/entity/toDus/Message;", "message", "listAttachment", "processMessage", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;ZLab/e;)Ljava/lang/Object;", "handleRoomExistence", "(Lcu/todus/android/data/db/entity/toDus/Message;Lab/e;)Ljava/lang/Object;", "createNewRoom", "newGroupRoom", "newChannelRoom", "newUserRoom", "newCardRoom", "handlePayload", "roomId", "handleDestroyGroupPayload", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInGroup;", "messagePayload", "handlePrivilegesChangeInGroupPayload", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/info/PrivilegesChangeInGroup;Lab/e;)Ljava/lang/Object;", "Lcu/todus/android/data/db/pojo/info/ConfigChangeInGroup;", "handleConfigChangeInGroupPayload", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/info/ConfigChangeInGroup;Lab/e;)Ljava/lang/Object;", "", "actualDate", "insertDateMsg", "(Ljava/lang/String;JLab/e;)Ljava/lang/Object;", "werePayload", "handleInsertionAndNotification", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;ZZLab/e;)Ljava/lang/Object;", "handlePrivileges", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;Lab/e;)Ljava/lang/Object;", "handleIncomingMsgAndAtt", "handleSendMarkers", "notifyMsg", "id", "notifyCall", "isVideoCall", "notifyCallNew", "(Ljava/lang/String;ZLab/e;)Ljava/lang/Object;", "uid", "needSendMarkers", "isRoomOfficial", "ensureCallMessageContentNew", "(Lcu/todus/android/data/db/entity/toDus/Message;Ljava/util/List;)Lcu/todus/android/data/db/entity/toDus/Message;", "Lorg/jivesoftware/smack/packet/Stanza;", "stanzaProcess", "(Lorg/jivesoftware/smack/packet/Stanza;Lab/e;)Ljava/lang/Object;", "sendDisplayMessage", "(Ljava/util/List;Lab/e;)Ljava/lang/Object;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcu/todus/android/notification/NotificationManager;", "getNotificationManager", "()Lcu/todus/android/notification/NotificationManager;", "Llb/a;", "getReloadChannels", "()Llb/a;", "Lkotlin/jvm/functions/Function2;", "getCallMucMemberList", "()Lkotlin/jvm/functions/Function2;", "getGetUserInfo", "getGetGroupInfo", "getGetChannelInfo", "getHandlePublications", "Lkotlin/jvm/functions/Function3;", "getReloadPub", "()Lkotlin/jvm/functions/Function3;", "getReloadUser", "Lkotlin/jvm/functions/Function1;", "getHandleStatusExistence", "()Lkotlin/jvm/functions/Function1;", "Llb/o;", "getHandleCallMessage", "()Llb/o;", "Lcu/todus/android/db/dao/toDus/MessageDao;", "messageDao", "Lcu/todus/android/db/dao/toDus/MessageDao;", "Lcu/todus/android/db/dao/toDus/UserDao;", "userDao", "Lcu/todus/android/db/dao/toDus/UserDao;", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "userRoomJoinDao", "Lcu/todus/android/db/dao/toDus/UserRoomJoinDao;", "Lcu/todus/android/db/dao/toDus/RoomDao;", "roomDao", "Lcu/todus/android/db/dao/toDus/RoomDao;", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "attachmentDao", "Lcu/todus/android/db/dao/toDus/AttachmentDao;", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "markerActionDao", "Lcu/todus/android/db/dao/toDus/MarkerActionDao;", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "reactionDao", "Lcu/todus/android/db/dao/toDus/ReactionDao;", "Lcu/todus/android/db/dao/toDus/StatusDao;", "statusDao", "Lcu/todus/android/db/dao/toDus/StatusDao;", "Lcu/todus/android/db/dao/toDus/ContactDao;", "contactDao", "Lcu/todus/android/db/dao/toDus/ContactDao;", "Lv5/f;", "gson", "Lv5/f;", "Lcu/z17/views/utils/Z17MutableListFlow;", "incomingMessageNotInserted", "Lcu/z17/views/utils/Z17MutableListFlow;", "Lorg/jivesoftware/smack/filter/AndFilter;", "filter", "Lorg/jivesoftware/smack/filter/AndFilter;", "getFilter", "()Lorg/jivesoftware/smack/filter/AndFilter;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageManager extends IMManager {
    public static final int $stable = 8;
    private final AttachmentDao attachmentDao;
    private final Function2 callMucMemberList;
    private final ContactDao contactDao;
    private final Context context;
    private final AndFilter filter;
    private final Function2 getChannelInfo;
    private final Function2 getGroupInfo;
    private final Function2 getUserInfo;
    private final v5.f gson;
    private final lb.o handleCallMessage;
    private final Function2 handlePublications;
    private final Function1 handleStatusExistence;
    private final Z17MutableListFlow<Pair<Message, List<Attachment>>> incomingMessageNotInserted;
    private final MarkerActionDao markerActionDao;
    private final MessageDao messageDao;
    private final NotificationManager notificationManager;
    private final ReactionDao reactionDao;
    private final lb.a reloadChannels;
    private final Function3 reloadPub;
    private final Function2 reloadUser;
    private final RoomDao roomDao;
    private final StatusDao statusDao;
    private final UserDao userDao;
    private final UserRoomJoinDao userRoomJoinDao;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ChatMarker.TYPE.values().length];
            try {
                iArr[ChatMarker.TYPE.DISPLAYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatMarker.TYPE.RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GroupAffiliation.values().length];
            try {
                iArr2[GroupAffiliation.member.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GroupAffiliation.owner.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GroupAffiliation.admin.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PrivilegesChangeInGroup.PRIVILEGES.values().length];
            try {
                iArr3[PrivilegesChangeInGroup.PRIVILEGES.MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[PrivilegesChangeInGroup.PRIVILEGES.OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[PrivilegesChangeInGroup.PRIVILEGES.ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[PrivilegesChangeInGroup.PRIVILEGES.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleAffiliationChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {694}, m = "handleAffiliationChange", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends cb.d {
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

        public AnonymousClass1(ab.e<? super AnonymousClass1> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleAffiliationChange(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleConfigChangeInGroupPayload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1394, 1434}, m = "handleConfigChangeInGroupPayload", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14591 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C14591(ab.e<? super C14591> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleConfigChangeInGroupPayload(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleDeleteOwnerMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {793, 795, 798}, m = "handleDeleteOwnerMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14601 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14601(ab.e<? super C14601> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleDeleteOwnerMsg(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleIncomingMsgAndAtt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1583, 1586, 1589, 1592, 1596, 1601, 1606}, m = "handleIncomingMsgAndAtt", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14611 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14611(ab.e<? super C14611> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleIncomingMsgAndAtt(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleInsertionAndNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1488, 1491, 1496, 1500, 1513, 1546, 1550}, m = "handleInsertionAndNotification", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14621 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;

        public C14621(ab.e<? super C14621> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleInsertionAndNotification(null, null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleMarker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {639, 641, 647}, m = "handleMarker", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14631 extends cb.d {
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

        public C14631(ab.e<? super C14631> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleMarker(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleNotNullBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {844, 849, 855, 857}, m = "handleNotNullBody", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14641 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14641(ab.e<? super C14641> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleNotNullBody(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleNullBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {880, 886, 889, 895, 912}, m = "handleNullBody", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14651 extends cb.d {
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

        public C14651(ab.e<? super C14651> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleNullBody(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handlePayload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1284, 1289, 1297}, m = "handlePayload", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14661 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14661(ab.e<? super C14661> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handlePayload(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handlePrivileges$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1568}, m = "handlePrivileges", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14671 extends cb.d {
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
        /* synthetic */ Object result;

        public C14671(ab.e<? super C14671> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handlePrivileges(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handlePrivilegesChangeInGroupPayload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1323, 1351, 1360, 1369, 1378}, m = "handlePrivilegesChangeInGroupPayload", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14681 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14681(ab.e<? super C14681> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handlePrivilegesChangeInGroupPayload(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handlePubDeleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {770, 772, 775}, m = "handlePubDeleted", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14691 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14691(ab.e<? super C14691> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handlePubDeleted(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleReaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager$handleReaction$1", f = "MessageManager.kt", l = {734, 738, 742, 748, 750, 752}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C14701 extends cb.m implements Function1 {
        final /* synthetic */ List<Attachment> $attachments;
        final /* synthetic */ org.jivesoftware.smack.packet.Message $stanza;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MessageManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14701(List<Attachment> list, MessageManager messageManager, org.jivesoftware.smack.packet.Message message, ab.e<? super C14701> eVar) {
            super(1, eVar);
            this.$attachments = list;
            this.this$0 = messageManager;
            this.$stanza = message;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C14701(this.$attachments, this.this$0, this.$stanza, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C14701) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0138  */
        /* JADX WARN: Code duplicated, block: B:31:0x0144  */
        /* JADX WARN: Code duplicated, block: B:34:0x0199  */
        /* JADX WARN: Code duplicated, block: B:37:0x019f A[PHI: r2 r5 r8
          0x019f: PHI (r2v21 cu.todus.android.data.db.entity.toDus.Reaction) = 
          (r2v14 cu.todus.android.data.db.entity.toDus.Reaction)
          (r2v14 cu.todus.android.data.db.entity.toDus.Reaction)
          (r2v18 cu.todus.android.data.db.entity.toDus.Reaction)
          (r2v22 cu.todus.android.data.db.entity.toDus.Reaction)
         binds: [B:21:0x010e, B:22:0x0110, B:36:0x019d, B:35:0x019a] A[DONT_GENERATE, DONT_INLINE]
          0x019f: PHI (r5v14 cu.todus.android.data.db.pojo.content.ReactionContent) = 
          (r5v6 cu.todus.android.data.db.pojo.content.ReactionContent)
          (r5v6 cu.todus.android.data.db.pojo.content.ReactionContent)
          (r5v11 cu.todus.android.data.db.pojo.content.ReactionContent)
          (r5v17 cu.todus.android.data.db.pojo.content.ReactionContent)
         binds: [B:21:0x010e, B:22:0x0110, B:36:0x019d, B:35:0x019a] A[DONT_GENERATE, DONT_INLINE]
          0x019f: PHI (r8v9 cu.todus.android.data.db.entity.toDus.Reaction) = 
          (r8v2 cu.todus.android.data.db.entity.toDus.Reaction)
          (r8v2 cu.todus.android.data.db.entity.toDus.Reaction)
          (r8v6 cu.todus.android.data.db.entity.toDus.Reaction)
          (r8v10 cu.todus.android.data.db.entity.toDus.Reaction)
         binds: [B:21:0x010e, B:22:0x0110, B:36:0x019d, B:35:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:40:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:44:0x01e6 A[DONT_INVERT, PHI: r2 r5 r6 r7
          0x01e6: PHI (r2v32 cu.todus.android.data.db.entity.toDus.Reaction) = (r2v29 cu.todus.android.data.db.entity.toDus.Reaction), (r2v37 cu.todus.android.data.db.entity.toDus.Reaction) binds: [B:42:0x01e3, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]
          0x01e6: PHI (r5v23 cu.todus.android.data.db.entity.toDus.Reaction) = (r5v20 cu.todus.android.data.db.entity.toDus.Reaction), (r5v26 cu.todus.android.data.db.entity.toDus.Reaction) binds: [B:42:0x01e3, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]
          0x01e6: PHI (r6v27 cu.todus.android.data.db.pojo.content.ReactionContent) = 
          (r6v24 cu.todus.android.data.db.pojo.content.ReactionContent)
          (r6v30 cu.todus.android.data.db.pojo.content.ReactionContent)
         binds: [B:42:0x01e3, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]
          0x01e6: PHI (r7v15 java.lang.Object) = (r7v14 java.lang.Object), (r7v17 java.lang.Object) binds: [B:42:0x01e3, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:45:0x01e8  */
        /* JADX WARN: Code duplicated, block: B:47:0x01eb  */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0210, code lost:
        
            if (r4.invoke(r7, r29) == r1) goto L49;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instruction units count: 560
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.C14701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleRoomExistence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1078, 1081}, m = "handleRoomExistence", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14711 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14711(ab.e<? super C14711> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleRoomExistence(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleSendMarkers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1627, 1628}, m = "handleSendMarkers", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14721 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14721(ab.e<? super C14721> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleSendMarkers(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$handleStreamVideoProcessed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {809, 812}, m = "handleStreamVideoProcessed", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14731 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14731(ab.e<? super C14731> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.handleStreamVideoProcessed(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$insertDateMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1443, 1447, 1462}, m = "insertDateMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14741 extends cb.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14741(ab.e<? super C14741> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.insertDateMsg(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$isRoomOfficial$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1761}, m = "isRoomOfficial", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14751 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14751(ab.e<? super C14751> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.isRoomOfficial(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$needSendMarkers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1757}, m = "needSendMarkers", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14761 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14761(ab.e<? super C14761> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.needSendMarkers(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$newCardRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1242, 1249, 1263}, m = "newCardRoom", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14771 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14771(ab.e<? super C14771> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.newCardRoom(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$newChannelRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1166, 1174, 1176, 1178, 1193}, m = "newChannelRoom", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14781 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14781(ab.e<? super C14781> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.newChannelRoom(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$newGroupRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1108, 1111, 1122, 1133, 1135, 1150, 1161}, m = "newGroupRoom", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14791 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14791(ab.e<? super C14791> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.newGroupRoom(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$newUserRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1207, 1214, 1216, 1224, 1231}, m = "newUserRoom", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14801 extends cb.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14801(ab.e<? super C14801> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.newUserRoom(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$notifyCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1697}, m = "notifyCall", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14811 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14811(ab.e<? super C14811> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.notifyCall(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$notifyCallNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1718}, m = "notifyCallNew", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14821 extends cb.d {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C14821(ab.e<? super C14821> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.notifyCallNew(null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$notifyMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1644, 1674}, m = "notifyMsg", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14831 extends cb.d {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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

        public C14831(ab.e<? super C14831> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.notifyMsg(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$processMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1048, 1061, 1063, 1065}, m = "processMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14841 extends cb.d {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C14841(ab.e<? super C14841> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.processMessage(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$sendDisplayMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {1738, 1749, ProgressIndicatorKt.LinearAnimationDuration}, m = "sendDisplayMessage", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14851 extends cb.d {
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
        int label;
        /* synthetic */ Object result;

        public C14851(ab.e<? super C14851> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.sendDisplayMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.xmpp.managers.MessageManager$stanzaProcess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.xmpp.managers.MessageManager", f = "MessageManager.kt", l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS, 212, 222, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 248, 258, 260, 261, 437, 450, 459, 478, 488, 1853, 543, 551, 566, 570}, m = "stanzaProcess", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C14861 extends cb.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C14861(ab.e<? super C14861> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageManager.this.stanzaProcess(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager(lb.a canSend, lb.a mXMPPConnection, Map<String, Boolean> blockRoom, lb.a owner, Context context, NotificationManager notificationManager, lb.a reloadChannels, Function2 callMucMemberList, Function2 getUserInfo, Function2 getGroupInfo, Function2 getChannelInfo, Function2 handlePublications, Function3 reloadPub, Function2 reloadUser, Function1 handleStatusExistence, lb.o handleCallMessage) {
        super(canSend, mXMPPConnection, blockRoom, owner);
        kotlin.jvm.internal.y.i(canSend, "canSend");
        kotlin.jvm.internal.y.i(mXMPPConnection, "mXMPPConnection");
        kotlin.jvm.internal.y.i(blockRoom, "blockRoom");
        kotlin.jvm.internal.y.i(owner, "owner");
        kotlin.jvm.internal.y.i(context, "context");
        kotlin.jvm.internal.y.i(notificationManager, "notificationManager");
        kotlin.jvm.internal.y.i(reloadChannels, "reloadChannels");
        kotlin.jvm.internal.y.i(callMucMemberList, "callMucMemberList");
        kotlin.jvm.internal.y.i(getUserInfo, "getUserInfo");
        kotlin.jvm.internal.y.i(getGroupInfo, "getGroupInfo");
        kotlin.jvm.internal.y.i(getChannelInfo, "getChannelInfo");
        kotlin.jvm.internal.y.i(handlePublications, "handlePublications");
        kotlin.jvm.internal.y.i(reloadPub, "reloadPub");
        kotlin.jvm.internal.y.i(reloadUser, "reloadUser");
        kotlin.jvm.internal.y.i(handleStatusExistence, "handleStatusExistence");
        kotlin.jvm.internal.y.i(handleCallMessage, "handleCallMessage");
        this.context = context;
        this.notificationManager = notificationManager;
        this.reloadChannels = reloadChannels;
        this.callMucMemberList = callMucMemberList;
        this.getUserInfo = getUserInfo;
        this.getGroupInfo = getGroupInfo;
        this.getChannelInfo = getChannelInfo;
        this.handlePublications = handlePublications;
        this.reloadPub = reloadPub;
        this.reloadUser = reloadUser;
        this.handleStatusExistence = handleStatusExistence;
        this.handleCallMessage = handleCallMessage;
        DatabaseModule.Companion companion = DatabaseModule.INSTANCE;
        this.messageDao = companion.getInstance().getMessageDao();
        this.userDao = companion.getInstance().getUserDao();
        this.userRoomJoinDao = companion.getInstance().getUserRoomJoinDao();
        this.roomDao = companion.getInstance().getRoomDao();
        this.attachmentDao = companion.getInstance().getAttachmentDao();
        this.markerActionDao = companion.getInstance().getMarkerActionDao();
        this.reactionDao = companion.getInstance().getReactionDao();
        this.statusDao = companion.getInstance().getStatusDao();
        this.contactDao = companion.getInstance().getContactDao();
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        this.incomingMessageNotInserted = new Z17MutableListFlow<>(va.w.n());
        this.filter = new AndFilter(new OrFilter(MessageTypeFilter.CHAT, MessageTypeFilter.NORMAL, MessageTypeFilter.GROUPCHAT, MessageTypeFilter.HEADLINE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createNewRoom(Message message, ab.e<? super k0> eVar) {
        XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
        if (xMPPUtils.isMUC(message.getRoomId())) {
            Object objNewGroupRoom = newGroupRoom(message, eVar);
            return objNewGroupRoom == bb.b.g() ? objNewGroupRoom : k0.f43947a;
        }
        if (xMPPUtils.isChannel(message.getRoomId())) {
            Object objNewChannelRoom = newChannelRoom(message, eVar);
            return objNewChannelRoom == bb.b.g() ? objNewChannelRoom : k0.f43947a;
        }
        if (xMPPUtils.isCard(message.getRoomId())) {
            Object objNewCardRoom = newCardRoom(message, eVar);
            return objNewCardRoom == bb.b.g() ? objNewCardRoom : k0.f43947a;
        }
        Object objNewUserRoom = newUserRoom(message, eVar);
        return objNewUserRoom == bb.b.g() ? objNewUserRoom : k0.f43947a;
    }

    private final Message ensureCallMessageContentNew(Message message, List<Attachment> listAttachment) {
        Object next;
        String state;
        if (d0.q0(message.getContent())) {
            Iterator<T> it = listAttachment.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((Attachment) next).getType() != 32);
            Attachment attachment = (Attachment) next;
            if (attachment != null) {
                try {
                    Content content = attachment.getContent();
                    CallContent callContent = content instanceof CallContent ? (CallContent) content : null;
                    Base64Util base64Util = Base64Util.INSTANCE;
                    if (callContent == null || (state = callContent.getState()) == null) {
                        state = "";
                    }
                    String strDecodedMessage$default = Base64Util.decodedMessage$default(base64Util, state, 0, 2, null);
                    String str = strDecodedMessage$default == null ? "" : strDecodedMessage$default;
                    if (!d0.q0(str)) {
                        return Message.copy$default(message, null, null, null, str, 0L, 0, null, null, null, TypedValues.PositionType.TYPE_PERCENT_WIDTH, null);
                    }
                } catch (Exception e10) {
                    Log.w("CallManager", "Error al rellenar msg.content para videollamada: " + e10.getMessage());
                }
            }
        }
        return message;
    }

    private final ke.h getAffiliationsChange(final org.jivesoftware.smack.packet.Message stanza) {
        return ke.u.Q(y0.B(((AffiliationsChangeExtension) stanza.getExtension("x", "x11")).getAffiliations()), new Function1() { // from class: cu.todus.android.xmpp.managers.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageManager.getAffiliationsChange$lambda$0(stanza, (Map.Entry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Message getAffiliationsChange$lambda$0(org.jivesoftware.smack.packet.Message message, Map.Entry it) {
        PrivilegesChangeInGroup privilegesChangeInGroup;
        kotlin.jvm.internal.y.i(it, "it");
        Message.Builder builderUserSender = new Message.Builder().roomId(message.getFrom().asEntityBareJidIfPossible().toString()).state(3).userSender(it.getKey().toString());
        GroupAffiliation groupAffiliation = (GroupAffiliation) it.getValue();
        int i10 = groupAffiliation == null ? -1 : WhenMappings.$EnumSwitchMapping$1[groupAffiliation.ordinal()];
        if (i10 == 1) {
            privilegesChangeInGroup = new PrivilegesChangeInGroup(it.getKey().toString(), PrivilegesChangeInGroup.PRIVILEGES.MEMBER, null, 4, null);
        } else if (i10 != 2) {
            privilegesChangeInGroup = i10 != 3 ? new PrivilegesChangeInGroup(it.getKey().toString(), PrivilegesChangeInGroup.PRIVILEGES.NONE, null, 4, null) : new PrivilegesChangeInGroup(it.getKey().toString(), PrivilegesChangeInGroup.PRIVILEGES.ADMIN, null, 4, null);
        } else {
            privilegesChangeInGroup = new PrivilegesChangeInGroup(it.getKey().toString(), PrivilegesChangeInGroup.PRIVILEGES.OWNER, null, 4, null);
        }
        return builderUserSender.messagePayload(privilegesChangeInGroup).build();
    }

    private final List<ChatMarker> getChatMarket(final org.jivesoftware.smack.packet.Message stanza) {
        ArrayList arrayList = new ArrayList();
        List<ExtensionElement> extensions = stanza.getExtensions(ChatMarkersElements.ReceivedExtension.ELEMENT, ChatMarkersElements.NAMESPACE);
        kotlin.jvm.internal.y.h(extensions, "getExtensions(...)");
        arrayList.addAll(ke.u.a0(ke.u.Q(ke.u.Q(g0.g0(extensions), new Function1() { // from class: cu.todus.android.xmpp.managers.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageManager.getChatMarket$lambda$0((ExtensionElement) obj);
            }
        }), new Function1() { // from class: cu.todus.android.xmpp.managers.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageManager.getChatMarket$lambda$1(this.f28868c, stanza, (ChatMarkersElements.ReceivedExtension) obj);
            }
        })));
        List<ExtensionElement> extensions2 = stanza.getExtensions(ChatMarkersElements.DisplayedExtension.ELEMENT, ChatMarkersElements.NAMESPACE);
        kotlin.jvm.internal.y.h(extensions2, "getExtensions(...)");
        arrayList.addAll(ke.u.a0(ke.u.Q(ke.u.Q(g0.g0(extensions2), new Function1() { // from class: cu.todus.android.xmpp.managers.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageManager.getChatMarket$lambda$2((ExtensionElement) obj);
            }
        }), new Function1() { // from class: cu.todus.android.xmpp.managers.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MessageManager.getChatMarket$lambda$3(this.f28870c, stanza, (ChatMarkersElements.DisplayedExtension) obj);
            }
        })));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatMarkersElements.ReceivedExtension getChatMarket$lambda$0(ExtensionElement extensionElement) {
        kotlin.jvm.internal.y.g(extensionElement, "null cannot be cast to non-null type org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements.ReceivedExtension");
        return (ChatMarkersElements.ReceivedExtension) extensionElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatMarker getChatMarket$lambda$1(MessageManager messageManager, org.jivesoftware.smack.packet.Message message, ChatMarkersElements.ReceivedExtension it) {
        kotlin.jvm.internal.y.i(it, "it");
        String id2 = it.getId();
        kotlin.jvm.internal.y.h(id2, "getId(...)");
        return new ChatMarker(id2, messageManager.getFrom(message), ChatMarker.TYPE.RECEIVED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatMarkersElements.DisplayedExtension getChatMarket$lambda$2(ExtensionElement extensionElement) {
        kotlin.jvm.internal.y.g(extensionElement, "null cannot be cast to non-null type org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements.DisplayedExtension");
        return (ChatMarkersElements.DisplayedExtension) extensionElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatMarker getChatMarket$lambda$3(MessageManager messageManager, org.jivesoftware.smack.packet.Message message, ChatMarkersElements.DisplayedExtension it) {
        kotlin.jvm.internal.y.i(it, "it");
        String id2 = it.getId();
        kotlin.jvm.internal.y.h(id2, "getId(...)");
        return new ChatMarker(id2, messageManager.getFrom(message), ChatMarker.TYPE.DISPLAYED);
    }

    private final Pair<String, Boolean> getChatState(org.jivesoftware.smack.packet.Message stanza) {
        ExtensionElement extension = stanza.getExtension(ChatStateExtensionToDus.NAMESPACE);
        kotlin.jvm.internal.y.g(extension, "null cannot be cast to non-null type org.jivesoftware.smackx.chatstates.packet.ChatStateExtensionToDus");
        return new Pair<>(getFrom(stanza), Boolean.valueOf(((ChatStateExtensionToDus) extension).getChatState() == ChatStateToDus.csc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFrom(org.jivesoftware.smack.packet.Message stanza) {
        if (stanza.getType() == org.jivesoftware.smack.packet.Message.Type.groupchat) {
            return stanza.getFrom().isEntityFullJid() ? JidCreate.from(stanza.getFrom().getResourceOrEmpty()).toString() : stanza.getFrom().toString();
        }
        return stanza.getFrom().asEntityBareJidIfPossible().toString();
    }

    private final Message getRoomConfigChange(org.jivesoftware.smack.packet.Message stanza) {
        ConfigurationsChangeExtension configurationsChangeExtension = (ConfigurationsChangeExtension) stanza.getExtension("x", "x10");
        Message.Builder builder = new Message.Builder();
        String stanzaId = stanza.getStanzaId();
        kotlin.jvm.internal.y.h(stanzaId, "getStanzaId(...)");
        return builder.id(stanzaId).roomId(stanza.getFrom().asEntityBareJidIfPossible().toString()).state(3).messagePayload(new ConfigChangeInGroup(configurationsChangeExtension.getPrevVersion(), configurationsChangeExtension.getVersion(), configurationsChangeExtension.getRoomName(), configurationsChangeExtension.getSubject(), configurationsChangeExtension.getCustomConfigs())).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleAffiliationChange(org.jivesoftware.smack.packet.Message message, ab.e<? super k0> eVar) {
        AnonymousClass1 anonymousClass1;
        Iterator it;
        ke.h hVar;
        ke.h hVar2;
        int i10;
        if (eVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) eVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(eVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(eVar);
        }
        Object obj = anonymousClass1.result;
        Object objG = bb.b.g();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            ua.v.b(obj);
            ke.h affiliationsChange = getAffiliationsChange(message);
            it = affiliationsChange.iterator();
            hVar = affiliationsChange;
            hVar2 = hVar;
            i10 = 0;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = anonymousClass1.I$0;
            it = (Iterator) anonymousClass1.L$3;
            ke.h hVar3 = (ke.h) anonymousClass1.L$2;
            ke.h hVar4 = (ke.h) anonymousClass1.L$1;
            org.jivesoftware.smack.packet.Message message2 = (org.jivesoftware.smack.packet.Message) anonymousClass1.L$0;
            ua.v.b(obj);
            i10 = i13;
            hVar2 = hVar3;
            hVar = hVar4;
            message = message2;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Message message3 = (Message) next;
            ArrayList arrayList = new ArrayList();
            anonymousClass1.L$0 = cb.l.a(message);
            anonymousClass1.L$1 = cb.l.a(hVar);
            anonymousClass1.L$2 = cb.l.a(hVar2);
            anonymousClass1.L$3 = it;
            anonymousClass1.L$4 = cb.l.a(next);
            anonymousClass1.L$5 = cb.l.a(message3);
            anonymousClass1.I$0 = i10;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 1;
            if (processMessage$default(this, message3, arrayList, false, anonymousClass1, 4, null) == objG) {
                return objG;
            }
        }
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0214, code lost:
    
        if (r5.update(r4, r2) == r3) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleConfigChangeInGroupPayload(java.lang.String r30, cu.todus.android.data.db.pojo.info.ConfigChangeInGroup r31, ab.e<? super ua.k0> r32) {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleConfigChangeInGroupPayload(java.lang.String, cu.todus.android.data.db.pojo.info.ConfigChangeInGroup, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:30:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
    
        if (r2.removeById(r4, r0) == r1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleDeleteOwnerMsg(java.lang.String r8, java.lang.String r9, ab.e<? super ua.k0> r10) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleDeleteOwnerMsg(java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleDestroyGroupPayload(String str, ab.e<? super k0> eVar) {
        Object objUpdate = this.userRoomJoinDao.update(new UserRoomJoin(((Owner) getOwner().invoke()).getNameWithDomain(), str, "none"), eVar);
        return objUpdate == bb.b.g() ? objUpdate : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db A[Catch: SQLiteConstraintException -> 0x0041, PHI: r13 r14 r15
      0x00db: PHI (r13v10 cu.todus.android.data.db.entity.toDus.Message) = (r13v48 cu.todus.android.data.db.entity.toDus.Message), (r13v49 cu.todus.android.data.db.entity.toDus.Message) binds: [B:43:0x00d7, B:33:0x00a2] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r14v6 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v3 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v8 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:43:0x00d7, B:33:0x00a2] A[DONT_GENERATE, DONT_INLINE]
      0x00db: PHI (r15v10 java.lang.Object) = (r15v9 java.lang.Object), (r15v1 java.lang.Object) binds: [B:43:0x00d7, B:33:0x00a2] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00df A[Catch: SQLiteConstraintException -> 0x0041, TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f9 A[Catch: SQLiteConstraintException -> 0x0041, PHI: r1 r13 r14 r15
      0x00f9: PHI (r1v5 java.lang.Object) = (r1v4 java.lang.Object), (r1v12 java.lang.Object) binds: [B:48:0x00f5, B:31:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r13v14 cu.todus.android.data.db.entity.toDus.Message) = (r13v47 cu.todus.android.data.db.entity.toDus.Message), (r13v18 cu.todus.android.data.db.entity.toDus.Message) binds: [B:48:0x00f5, B:31:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r14v9 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v6 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v11 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:48:0x00f5, B:31:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x00f9: PHI (r15v12 cu.todus.android.data.db.entity.toDus.Room) = (r15v11 cu.todus.android.data.db.entity.toDus.Room), (r15v13 cu.todus.android.data.db.entity.toDus.Room) binds: [B:48:0x00f5, B:31:0x0094] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fd A[Catch: SQLiteConstraintException -> 0x0041, TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0138  */
    /* JADX WARN: Code duplicated, block: B:57:0x013a  */
    /* JADX WARN: Code duplicated, block: B:59:0x013e A[Catch: SQLiteConstraintException -> 0x0041, PHI: r13 r14 r15
      0x013e: PHI (r13v19 cu.todus.android.data.db.entity.toDus.Message) = 
      (r13v45 cu.todus.android.data.db.entity.toDus.Message)
      (r13v46 cu.todus.android.data.db.entity.toDus.Message)
      (r13v21 cu.todus.android.data.db.entity.toDus.Message)
     binds: [B:46:0x00dd, B:53:0x010b, B:58:0x013c] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r14v12 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v6 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v9 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v13 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:46:0x00dd, B:53:0x010b, B:58:0x013c] A[DONT_GENERATE, DONT_INLINE]
      0x013e: PHI (r15v14 cu.todus.android.data.db.entity.toDus.Room) = 
      (r15v11 cu.todus.android.data.db.entity.toDus.Room)
      (r15v12 cu.todus.android.data.db.entity.toDus.Room)
      (r15v15 cu.todus.android.data.db.entity.toDus.Room)
     binds: [B:46:0x00dd, B:53:0x010b, B:58:0x013c] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0156  */
    /* JADX WARN: Code duplicated, block: B:62:0x0157 A[Catch: SQLiteConstraintException -> 0x0041, PHI: r13 r14 r15
      0x0157: PHI (r13v26 cu.todus.android.data.db.entity.toDus.Message) = (r13v44 cu.todus.android.data.db.entity.toDus.Message), (r13v29 cu.todus.android.data.db.entity.toDus.Message) binds: [B:60:0x0154, B:25:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0157: PHI (r14v16 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v12 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v18 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:60:0x0154, B:25:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0157: PHI (r15v16 cu.todus.android.data.db.entity.toDus.Room) = (r15v14 cu.todus.android.data.db.entity.toDus.Room), (r15v17 cu.todus.android.data.db.entity.toDus.Room) binds: [B:60:0x0154, B:25:0x006c] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x016b A[Catch: SQLiteConstraintException -> 0x0041, TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x017e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0192  */
    /* JADX WARN: Code duplicated, block: B:71:0x0193 A[Catch: SQLiteConstraintException -> 0x0041, PHI: r13 r14 r15
      0x0193: PHI (r13v30 cu.todus.android.data.db.entity.toDus.Message) = (r13v43 cu.todus.android.data.db.entity.toDus.Message), (r13v33 cu.todus.android.data.db.entity.toDus.Message) binds: [B:69:0x0190, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0193: PHI (r14v19 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v16 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v21 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:69:0x0190, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0193: PHI (r15v18 cu.todus.android.data.db.entity.toDus.Room) = (r15v16 cu.todus.android.data.db.entity.toDus.Room), (r15v22 cu.todus.android.data.db.entity.toDus.Room) binds: [B:69:0x0190, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteConstraintException -> 0x0041, blocks: (B:14:0x003c, B:74:0x01a7, B:71:0x0193, B:62:0x0157, B:64:0x016b, B:65:0x0172, B:68:0x017f, B:59:0x013e, B:50:0x00f9, B:52:0x00fd, B:54:0x010d, B:33:0x00a2, B:45:0x00db, B:47:0x00df, B:36:0x00af, B:42:0x00c7, B:39:0x00b6), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01a4, code lost:
    
        if (r15 == r0) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [cu.todus.android.xmpp.managers.MessageManager] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleIncomingMsgAndAtt(cu.todus.android.data.db.entity.toDus.Message r13, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r14, ab.e<? super ua.k0> r15) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleIncomingMsgAndAtt(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleIncomingMsgAndAtt$lambda$0(Message message, Pair it) {
        kotlin.jvm.internal.y.i(it, "it");
        return kotlin.jvm.internal.y.d(((Message) it.getFirst()).getId(), message.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:103:0x0271  */
    /* JADX WARN: Code duplicated, block: B:106:0x027a  */
    /* JADX WARN: Code duplicated, block: B:109:0x029b A[Catch: Exception -> 0x02ad, TRY_LEAVE, TryCatch #0 {Exception -> 0x02ad, blocks: (B:104:0x0274, B:107:0x027c, B:109:0x029b), top: B:128:0x0274 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ad A[PHI: r14 r25 r26 r27
      0x02ad: PHI (r14v5 boolean) = (r14v4 boolean), (r14v4 boolean), (r14v6 boolean) binds: [B:126:0x02ad, B:108:0x0299, B:111:0x02a6] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r25v3 cu.todus.android.data.db.entity.toDus.Attachment) = 
      (r25v1 cu.todus.android.data.db.entity.toDus.Attachment)
      (r25v1 cu.todus.android.data.db.entity.toDus.Attachment)
      (r25v4 cu.todus.android.data.db.entity.toDus.Attachment)
     binds: [B:126:0x02ad, B:108:0x0299, B:111:0x02a6] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r26v3 cu.todus.android.data.db.entity.toDus.Room) = 
      (r26v1 cu.todus.android.data.db.entity.toDus.Room)
      (r26v1 cu.todus.android.data.db.entity.toDus.Room)
      (r26v4 cu.todus.android.data.db.entity.toDus.Room)
     binds: [B:126:0x02ad, B:108:0x0299, B:111:0x02a6] A[DONT_GENERATE, DONT_INLINE]
      0x02ad: PHI (r27v3 cu.todus.android.data.db.entity.toDus.Message) = 
      (r27v1 cu.todus.android.data.db.entity.toDus.Message)
      (r27v1 cu.todus.android.data.db.entity.toDus.Message)
      (r27v4 cu.todus.android.data.db.entity.toDus.Message)
     binds: [B:126:0x02ad, B:108:0x0299, B:111:0x02a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x02e9 A[LOOP:0: B:77:0x0215->B:117:0x02e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:119:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:123:0x0322  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x024a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0085 A[PHI: r1 r2 r3 r6 r8 r11 r12 r13
      0x0085: PHI (r1v10 boolean) = (r1v8 boolean), (r1v20 boolean) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r2v9 int) = (r2v7 int), (r2v11 int) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r3v17 java.lang.Object) = (r3v16 java.lang.Object), (r3v1 java.lang.Object) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r6v9 boolean) = (r6v7 boolean), (r6v11 boolean) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r8v10 boolean) = (r8v8 boolean), (r8v12 boolean) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r11v11 cu.todus.android.data.db.entity.toDus.Message) = (r11v8 cu.todus.android.data.db.entity.toDus.Message), (r11v14 cu.todus.android.data.db.entity.toDus.Message) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r12v11 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r12v8 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r12v14 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r13v7 cu.todus.android.data.db.entity.toDus.Message) = (r13v4 cu.todus.android.data.db.entity.toDus.Message), (r13v11 cu.todus.android.data.db.entity.toDus.Message) binds: [B:39:0x0177, B:15:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0109  */
    /* JADX WARN: Code duplicated, block: B:34:0x0127  */
    /* JADX WARN: Code duplicated, block: B:38:0x014f A[PHI: r1 r2 r6 r8 r11 r12 r13
      0x014f: PHI (r1v8 boolean) = (r1v6 boolean), (r1v9 boolean) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r2v7 int) = (r2v5 int), (r2v8 int) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r6v7 boolean) = (r6v5 boolean), (r6v8 boolean) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r8v8 boolean) = (r8v6 boolean), (r8v9 boolean) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r11v8 cu.todus.android.data.db.entity.toDus.Message) = (r11v5 cu.todus.android.data.db.entity.toDus.Message), (r11v10 cu.todus.android.data.db.entity.toDus.Message) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r12v8 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r12v4 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r12v10 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r13v4 cu.todus.android.data.db.entity.toDus.Message) = (r13v2 cu.todus.android.data.db.entity.toDus.Message), (r13v6 cu.todus.android.data.db.entity.toDus.Message) binds: [B:36:0x014b, B:17:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x0188  */
    /* JADX WARN: Code duplicated, block: B:46:0x0199  */
    /* JADX WARN: Code duplicated, block: B:48:0x019c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x019e  */
    /* JADX WARN: Code duplicated, block: B:50:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f2 A[PHI: r1 r2 r6 r8 r11 r12 r13 r14 r15
      0x01f2: PHI (r1v21 ??) = (r1v15 ??), (r1v29 ??) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r2v12 boolean) = (r2v10 boolean), (r2v15 boolean) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r6v12 int) = (r6v10 int), (r6v15 int) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r8v13 cu.todus.android.data.db.entity.toDus.Message) = (r8v11 cu.todus.android.data.db.entity.toDus.Message), (r8v16 cu.todus.android.data.db.entity.toDus.Message) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r11v15 boolean) = (r11v12 boolean), (r11v18 boolean) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r12v15 boolean) = (r12v12 boolean), (r12v18 boolean) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r13v12 cu.todus.android.data.db.entity.toDus.Room) = (r13v9 cu.todus.android.data.db.entity.toDus.Room), (r13v16 cu.todus.android.data.db.entity.toDus.Room) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r14v2 cu.todus.android.data.db.entity.toDus.Message) = (r14v1 cu.todus.android.data.db.entity.toDus.Message), (r14v8 cu.todus.android.data.db.entity.toDus.Message) binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x01f2: PHI (r15v3 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r15v2 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r15v6 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:58:0x01c3, B:62:0x01ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x0209  */
    /* JADX WARN: Code duplicated, block: B:76:0x0211  */
    /* JADX WARN: Code duplicated, block: B:79:0x021b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:82:0x022b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0235  */
    /* JADX WARN: Code duplicated, block: B:88:0x0246 A[LOOP:1: B:83:0x022f->B:88:0x0246, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x0256 A[Catch: Exception -> 0x02a6, TryCatch #1 {Exception -> 0x02a6, blocks: (B:92:0x024e, B:94:0x0256, B:96:0x025a, B:99:0x0260), top: B:130:0x024e }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0259  */
    /* JADX WARN: Code duplicated, block: B:99:0x0260 A[Catch: Exception -> 0x02a6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x02a6, blocks: (B:92:0x024e, B:94:0x0256, B:96:0x025a, B:99:0x0260), top: B:130:0x024e }] */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02e1, code lost:
    
        if (notifyCallNew(r7, r10, r4) == r5) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x031d, code lost:
    
        if (notifyMsg(r7, r4) == r5) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ea, code lost:
    
        if (r3 == r5) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r23v0, types: [cu.todus.android.xmpp.managers.MessageManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleInsertionAndNotification(cu.todus.android.data.db.entity.toDus.Message r24, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r25, boolean r26, boolean r27, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleInsertionAndNotification(cu.todus.android.data.db.entity.toDus.Message, java.util.List, boolean, boolean, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:32|(1:38)(1:(1:35)(1:37))|36|39|72|40|(5:43|44|(1:46)|50|(6:53|54|49|59|(1:65)(2:61|(1:63)(1:64))|66))) */
    /* JADX WARN: Code duplicated, block: B:30:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:34:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0128  */
    /* JADX WARN: Code duplicated, block: B:37:0x012c  */
    /* JADX WARN: Code duplicated, block: B:38:0x012e  */
    /* JADX WARN: Code duplicated, block: B:43:0x016f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0178 A[Catch: Exception -> 0x00b7, TryCatch #2 {Exception -> 0x00b7, blocks: (B:44:0x0174, B:46:0x0178, B:50:0x018a, B:23:0x00b0), top: B:76:0x00b0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:70:0x022e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ca, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01cb, code lost:
    
        r6 = r2;
        r15 = r4;
        r2 = r5;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0225, code lost:
    
        if (r7.updateStatusProgressive(r8, r14, r5) == r3) goto L68;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00f7, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0225 -> B:14:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleMarker(org.jivesoftware.smack.packet.Message r25, java.util.Date r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleMarker(org.jivesoftware.smack.packet.Message, java.util.Date, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x014e  */
    /* JADX WARN: Code duplicated, block: B:39:0x017e A[DONT_INVERT, PHI: r2 r11 r12 r13 r14 r15
      0x017e: PHI (r2v17 org.jivesoftware.smack.packet.Message) = (r2v16 org.jivesoftware.smack.packet.Message), (r2v24 org.jivesoftware.smack.packet.Message) binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r11v7 boolean) = (r11v6 boolean), (r11v14 boolean) binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r12v5 kotlin.Pair) = (r12v4 kotlin.Pair), (r12v13 kotlin.Pair) binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r13v4 java.util.Date) = (r13v3 java.util.Date), (r13v11 java.util.Date) binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r14v5 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>) = 
      (r14v4 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
      (r14v11 java.util.List<cu.todus.android.data.db.entity.toDus.Attachment>)
     binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r15v20 java.lang.Object) = (r15v19 java.lang.Object), (r15v1 java.lang.Object) binds: [B:37:0x017b, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x0181  */
    /* JADX WARN: Code duplicated, block: B:43:0x0184  */
    /* JADX WARN: Code duplicated, block: B:48:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01b2, code lost:
    
        if (r15.invoke(r4, r0) == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleNotNullBody(org.jivesoftware.smack.packet.Message r11, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r12, java.util.Date r13, boolean r14, ab.e<? super ua.k0> r15) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleNotNullBody(org.jivesoftware.smack.packet.Message, java.util.List, java.util.Date, boolean, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object handleNotNullBody$default(MessageManager messageManager, org.jivesoftware.smack.packet.Message message, List list, Date date, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return messageManager.handleNotNullBody(message, list, date, z10, eVar);
    }

    private final void handleNotification() {
        this.notificationManager.reNotify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:45:0x0200  */
    /* JADX WARN: Code duplicated, block: B:49:0x0260  */
    /* JADX WARN: Code duplicated, block: B:51:0x027c  */
    /* JADX WARN: Code duplicated, block: B:56:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:68:0x027f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0171, code lost:
    
        if (r7.invoke(r8, r3) == r4) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0313, code lost:
    
        if (r2.insert(r6, r3) == r4) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleNullBody(org.jivesoftware.smack.packet.Message r33, ab.e<? super ua.k0> r34) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleNullBody(org.jivesoftware.smack.packet.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (handleDestroyGroupPayload(r8, r0) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
    
        if (handlePrivilegesChangeInGroupPayload(r8, r2, r0) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
    
        if (handleConfigChangeInGroupPayload(r8, r2, r0) == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handlePayload(cu.todus.android.data.db.entity.toDus.Message r7, ab.e<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cu.todus.android.xmpp.managers.MessageManager.C14661
            if (r0 == 0) goto L13
            r0 = r8
            cu.todus.android.xmpp.managers.MessageManager$handlePayload$1 r0 = (cu.todus.android.xmpp.managers.MessageManager.C14661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.MessageManager$handlePayload$1 r0 = new cu.todus.android.xmpp.managers.MessageManager$handlePayload$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = bb.b.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4c
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r8)
            goto Lae
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r8)
            goto L8c
        L44:
            java.lang.Object r7 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r7 = (cu.todus.android.data.db.entity.toDus.Message) r7
            ua.v.b(r8)
            goto L6a
        L4c:
            ua.v.b(r8)
            cu.todus.android.data.db.pojo.info.MessagePayload r8 = r7.getPayload()
            boolean r2 = r8 instanceof cu.todus.android.data.db.pojo.info.DestroyGroup
            if (r2 == 0) goto L6f
            java.lang.String r8 = r7.getRoomId()
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r7 = r6.handleDestroyGroupPayload(r8, r0)
            if (r7 != r1) goto L6a
            goto Lad
        L6a:
            java.lang.Boolean r7 = cb.b.a(r5)
            return r7
        L6f:
            boolean r2 = r8 instanceof cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup
            if (r2 == 0) goto L91
            java.lang.String r8 = r7.getRoomId()
            cu.todus.android.data.db.pojo.info.MessagePayload r2 = r7.getPayload()
            cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup r2 = (cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup) r2
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r7 = r6.handlePrivilegesChangeInGroupPayload(r8, r2, r0)
            if (r7 != r1) goto L8c
            goto Lad
        L8c:
            java.lang.Boolean r7 = cb.b.a(r5)
            return r7
        L91:
            boolean r8 = r8 instanceof cu.todus.android.data.db.pojo.info.ConfigChangeInGroup
            if (r8 == 0) goto Lb3
            java.lang.String r8 = r7.getRoomId()
            cu.todus.android.data.db.pojo.info.MessagePayload r2 = r7.getPayload()
            cu.todus.android.data.db.pojo.info.ConfigChangeInGroup r2 = (cu.todus.android.data.db.pojo.info.ConfigChangeInGroup) r2
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r6.handleConfigChangeInGroupPayload(r8, r2, r0)
            if (r7 != r1) goto Lae
        Lad:
            return r1
        Lae:
            java.lang.Boolean r7 = cb.b.a(r5)
            return r7
        Lb3:
            r7 = 0
            java.lang.Boolean r7 = cb.b.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handlePayload(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ee -> B:27:0x00f3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object handlePrivileges(cu.todus.android.data.db.entity.toDus.Message r18, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r19, ab.e<? super java.lang.Boolean> r20) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handlePrivileges(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01a1, code lost:
    
        if (r6.upsert(r7, r3) == r4) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handlePrivilegesChangeInGroupPayload(java.lang.String r20, cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handlePrivilegesChangeInGroupPayload(java.lang.String, cu.todus.android.data.db.pojo.info.PrivilegesChangeInGroup, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
    
        if (r1.updateLastMessage(r11, r3, r4, r6) == r0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handlePubDeleted(java.lang.String r10, java.util.List<java.lang.String> r11, ab.e<? super ua.k0> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof cu.todus.android.xmpp.managers.MessageManager.C14691
            if (r0 == 0) goto L14
            r0 = r12
            cu.todus.android.xmpp.managers.MessageManager$handlePubDeleted$1 r0 = (cu.todus.android.xmpp.managers.MessageManager.C14691) r0
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
            cu.todus.android.xmpp.managers.MessageManager$handlePubDeleted$1 r0 = new cu.todus.android.xmpp.managers.MessageManager$handlePubDeleted$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = bb.b.g()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L5f
            if (r1 == r4) goto L52
            if (r1 == r3) goto L46
            if (r1 != r2) goto L3e
            java.lang.Object r10 = r6.L$2
            cu.todus.android.data.db.entity.toDus.Message r10 = (cu.todus.android.data.db.entity.toDus.Message) r10
            java.lang.Object r10 = r6.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = r6.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r12)
            goto Lb5
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L46:
            java.lang.Object r10 = r6.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r6.L$0
            java.lang.String r11 = (java.lang.String) r11
            ua.v.b(r12)
            goto L8b
        L52:
            java.lang.Object r10 = r6.L$1
            r11 = r10
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r10 = r6.L$0
            java.lang.String r10 = (java.lang.String) r10
            ua.v.b(r12)
            goto L75
        L5f:
            ua.v.b(r12)
            cu.todus.android.db.dao.toDus.MessageDao r12 = r9.messageDao
            r6.L$0 = r10
            java.lang.Object r1 = cb.l.a(r11)
            r6.L$1 = r1
            r6.label = r4
            java.lang.Object r12 = r12.removeByPubIdInChannel(r10, r11, r6)
            if (r12 != r0) goto L75
            goto Lb4
        L75:
            cu.todus.android.db.dao.toDus.MessageDao r12 = r9.messageDao
            r6.L$0 = r10
            java.lang.Object r1 = cb.l.a(r11)
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r12 = r12.getLastMessageOfChannel(r10, r6)
            if (r12 != r0) goto L88
            goto Lb4
        L88:
            r8 = r11
            r11 = r10
            r10 = r8
        L8b:
            cu.todus.android.data.db.entity.toDus.Message r12 = (cu.todus.android.data.db.entity.toDus.Message) r12
            if (r12 == 0) goto Lb8
            cu.todus.android.db.dao.toDus.RoomDao r1 = r9.roomDao
            java.lang.String r3 = r12.getId()
            long r4 = r12.getCreateAt()
            java.lang.Object r7 = cb.l.a(r11)
            r6.L$0 = r7
            java.lang.Object r10 = cb.l.a(r10)
            r6.L$1 = r10
            java.lang.Object r10 = cb.l.a(r12)
            r6.L$2 = r10
            r6.label = r2
            r2 = r11
            java.lang.Object r10 = r1.updateLastMessage(r2, r3, r4, r6)
            if (r10 != r0) goto Lb5
        Lb4:
            return r0
        Lb5:
            ua.k0 r10 = ua.k0.f43947a
            return r10
        Lb8:
            ua.k0 r10 = ua.k0.f43947a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handlePubDeleted(java.lang.String, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handlePubEdited(String str, String str2, ab.e<? super k0> eVar) {
        Object objInvoke = this.reloadPub.invoke(str, str2, eVar);
        return objInvoke == bb.b.g() ? objInvoke : k0.f43947a;
    }

    private final void handleReaction(org.jivesoftware.smack.packet.Message stanza, List<Attachment> attachments) {
        CoroutineUtilsKt.launchWithContext$default(getCoroutineScope(), null, null, new C14701(attachments, this, stanza, null), 3, null);
        String stanzaId = stanza.getStanzaId();
        kotlin.jvm.internal.y.h(stanzaId, "getStanzaId(...)");
        sendReceived(stanzaId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRoomConfigs(org.jivesoftware.smack.packet.Message message, ab.e<? super k0> eVar) {
        Object objProcessMessage$default = processMessage$default(this, getRoomConfigChange(message), new ArrayList(), false, eVar, 4, null);
        return objProcessMessage$default == bb.b.g() ? objProcessMessage$default : k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (createNewRoom(r6, r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleRoomExistence(cu.todus.android.data.db.entity.toDus.Message r6, ab.e<? super ua.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cu.todus.android.xmpp.managers.MessageManager.C14711
            if (r0 == 0) goto L13
            r0 = r7
            cu.todus.android.xmpp.managers.MessageManager$handleRoomExistence$1 r0 = (cu.todus.android.xmpp.managers.MessageManager.C14711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            cu.todus.android.xmpp.managers.MessageManager$handleRoomExistence$1 r0 = new cu.todus.android.xmpp.managers.MessageManager$handleRoomExistence$1
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
            cu.todus.android.data.db.entity.toDus.Room r6 = (cu.todus.android.data.db.entity.toDus.Room) r6
            java.lang.Object r6 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r6 = (cu.todus.android.data.db.entity.toDus.Message) r6
            ua.v.b(r7)
            goto L71
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$0
            cu.todus.android.data.db.entity.toDus.Message r6 = (cu.todus.android.data.db.entity.toDus.Message) r6
            ua.v.b(r7)
            goto L58
        L44:
            ua.v.b(r7)
            cu.todus.android.db.dao.toDus.RoomDao r7 = r5.roomDao
            java.lang.String r2 = r6.getRoomId()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getRoomById(r2, r0)
            if (r7 != r1) goto L58
            goto L70
        L58:
            cu.todus.android.data.db.entity.toDus.Room r7 = (cu.todus.android.data.db.entity.toDus.Room) r7
            if (r7 != 0) goto L74
            java.lang.Object r2 = cb.l.a(r6)
            r0.L$0 = r2
            java.lang.Object r7 = cb.l.a(r7)
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r5.createNewRoom(r6, r0)
            if (r6 != r1) goto L71
        L70:
            return r1
        L71:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        L74:
            ua.k0 r6 = ua.k0.f43947a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleRoomExistence(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x013d, code lost:
    
        if (r1.insertOrReplace(r6, r2) == r3) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleSendMarkers(cu.todus.android.data.db.entity.toDus.Message r20, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleSendMarkers(cu.todus.android.data.db.entity.toDus.Message, java.util.List, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f7, code lost:
    
        if (r4.update(r1, r2) == r3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleStreamVideoProcessed(java.lang.String r41, java.lang.String r42, java.lang.String r43, ab.e<? super ua.k0> r44) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.handleStreamVideoProcessed(java.lang.String, java.lang.String, java.lang.String, ab.e):java.lang.Object");
    }

    private final void handleTyping(org.jivesoftware.smack.packet.Message stanza) {
        AppVolatileState.INSTANCE.getInstance().updateUserTyping(getChatState(stanza));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleUpdateToDusId(String str, String str2, ab.e<? super k0> eVar) {
        Object objUpdateToDusId = this.userDao.updateToDusId(str, str2, eVar);
        return objUpdateToDusId == bb.b.g() ? objUpdateToDusId : k0.f43947a;
    }

    private final boolean identifyAddedToChannel(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension("todus:ch:added");
    }

    private final boolean identifyAffiliationChange(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension("x", "x11");
    }

    private final boolean identifyMarker(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension(ChatMarkersElements.NAMESPACE) && !(stanza.getExtension(ChatMarkersElements.NAMESPACE) instanceof ChatMarkersElements.MarkableExtension);
    }

    private final boolean identifyNotification(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension(OfflineElement.ELEMENT_END, "jc") || stanza.hasExtension(OfflineElement.ELEMENT_END, "");
    }

    private final boolean identifyRoomConfigs(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension("x", "x10");
    }

    private final boolean identifyTyping(org.jivesoftware.smack.packet.Message stanza) {
        return stanza.hasExtension(ChatStateExtensionToDus.NAMESPACE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d1, code lost:
    
        if (kotlin.jvm.internal.y.d(r7, r0.format(new java.util.Date(r14), r9)) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011d, code lost:
    
        if (r0.insertOrIgnore(r11, r5) == r6) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object insertDateMsg(java.lang.String r25, long r26, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.insertDateMsg(java.lang.String, long, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object isRoomOfficial(String str, ab.e<? super Boolean> eVar) {
        C14751 c14751;
        User roomUser;
        if (eVar instanceof C14751) {
            c14751 = (C14751) eVar;
            int i10 = c14751.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14751.label = i10 - Integer.MIN_VALUE;
            } else {
                c14751 = new C14751(eVar);
            }
        } else {
            c14751 = new C14751(eVar);
        }
        Object roomItemViewById = c14751.result;
        Object objG = bb.b.g();
        int i11 = c14751.label;
        if (i11 == 0) {
            ua.v.b(roomItemViewById);
            RoomDao roomDao = this.roomDao;
            c14751.L$0 = cb.l.a(str);
            c14751.label = 1;
            roomItemViewById = roomDao.getRoomItemViewById(str, c14751);
            if (roomItemViewById == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ua.v.b(roomItemViewById);
        }
        RoomItemView roomItemView = (RoomItemView) roomItemViewById;
        return cb.b.a((roomItemView == null || (roomUser = roomItemView.getRoomUser()) == null || roomUser.getOfficial() != 1) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object needSendMarkers(String str, ab.e<? super Boolean> eVar) {
        C14761 c14761;
        if (eVar instanceof C14761) {
            c14761 = (C14761) eVar;
            int i10 = c14761.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14761.label = i10 - Integer.MIN_VALUE;
            } else {
                c14761 = new C14761(eVar);
            }
        } else {
            c14761 = new C14761(eVar);
        }
        Object objIsRoomOfficial = c14761.result;
        Object objG = bb.b.g();
        int i11 = c14761.label;
        if (i11 == 0) {
            ua.v.b(objIsRoomOfficial);
            if (!XMPPUtils.INSTANCE.isChannel(str)) {
                c14761.L$0 = cb.l.a(str);
                c14761.label = 1;
                objIsRoomOfficial = isRoomOfficial(str, c14761);
                if (objIsRoomOfficial == objG) {
                    return objG;
                }
            }
            return cb.b.a(z);
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ua.v.b(objIsRoomOfficial);
        boolean z10 = ((Boolean) objIsRoomOfficial).booleanValue() ? false : true;
        return cb.b.a(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e9, code lost:
    
        if (r10.insertIfNeed(r11, r2) == r3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0150, code lost:
    
        if (r6.insertIfNeed(r10, r2) == r3) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object newCardRoom(cu.todus.android.data.db.entity.toDus.Message r28, ab.e<? super ua.k0> r29) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.newCardRoom(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
    
        if (r0.insert(r8, r2) == r3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x018d, code lost:
    
        if (r0.insert(r7, r2) == r3) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object newChannelRoom(cu.todus.android.data.db.entity.toDus.Message r27, ab.e<? super ua.k0> r28) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.newChannelRoom(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:46:0x0146  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011f, code lost:
    
        if (r0.insert(r6, r2) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x013f, code lost:
    
        if (r0.invoke(r6, r2) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ce, code lost:
    
        if (r0.insert(r6, r2) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ed, code lost:
    
        if (r0.invoke(r6, r2) == r3) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v5, types: [cu.todus.android.data.db.entity.toDus.Message, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object newGroupRoom(cu.todus.android.data.db.entity.toDus.Message r25, ab.e<? super ua.k0> r26) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.newGroupRoom(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
    
        if (r1.insertIfNeed(r8, r2) == r3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x015e, code lost:
    
        if (r1.insertIfNeed(r7, r2) == r3) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object newUserRoom(cu.todus.android.data.db.entity.toDus.Message r25, ab.e<? super ua.k0> r26) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.newUserRoom(cu.todus.android.data.db.entity.toDus.Message, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object notifyCall(String str, ab.e<? super k0> eVar) {
        C14811 c14811;
        String picture;
        String name;
        if (eVar instanceof C14811) {
            c14811 = (C14811) eVar;
            int i10 = c14811.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14811.label = i10 - Integer.MIN_VALUE;
            } else {
                c14811 = new C14811(eVar);
            }
        } else {
            c14811 = new C14811(eVar);
        }
        Object partnerById = c14811.result;
        Object objG = bb.b.g();
        int i11 = c14811.label;
        if (i11 == 0) {
            ua.v.b(partnerById);
            UserDao userDao = this.userDao;
            c14811.L$0 = str;
            c14811.label = 1;
            partnerById = userDao.getPartnerById(str, c14811);
            if (partnerById == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c14811.L$0;
            ua.v.b(partnerById);
        }
        String str2 = str;
        Partner partner = (Partner) partnerById;
        this.notificationManager.notify(new CallNotification(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(str2), str2, (partner == null || (name = partner.getName()) == null) ? "" : name, (partner == null || (picture = partner.getPicture()) == null) ? "" : picture, true));
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object notifyCallNew(String str, boolean z10, ab.e<? super k0> eVar) {
        C14821 c14821;
        String picture;
        String name;
        if (eVar instanceof C14821) {
            c14821 = (C14821) eVar;
            int i10 = c14821.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c14821.label = i10 - Integer.MIN_VALUE;
            } else {
                c14821 = new C14821(eVar);
            }
        } else {
            c14821 = new C14821(eVar);
        }
        Object partnerById = c14821.result;
        Object objG = bb.b.g();
        int i11 = c14821.label;
        if (i11 == 0) {
            ua.v.b(partnerById);
            UserDao userDao = this.userDao;
            c14821.L$0 = str;
            c14821.Z$0 = z10;
            c14821.label = 1;
            partnerById = userDao.getPartnerById(str, c14821);
            if (partnerById == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z10 = c14821.Z$0;
            str = (String) c14821.L$0;
            ua.v.b(partnerById);
        }
        String str2 = str;
        Partner partner = (Partner) partnerById;
        this.notificationManager.notify(new CallNotification(ConfigProcessor.INSTANCE.buildHeritagePrivateCall(str2), str2, (partner == null || (name = partner.getName()) == null) ? "" : name, (partner == null || (picture = partner.getPicture()) == null) ? "" : picture, z10));
        return k0.f43947a;
    }

    public static /* synthetic */ Object notifyCallNew$default(MessageManager messageManager, String str, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return messageManager.notifyCallNew(str, z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x010c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0132  */
    /* JADX WARN: Code duplicated, block: B:47:0x0156  */
    /* JADX WARN: Code duplicated, block: B:48:0x0158  */
    /* JADX WARN: Code duplicated, block: B:51:0x0163  */
    /* JADX WARN: Code duplicated, block: B:54:0x017a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0188  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:65:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01da  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:74:0x0210  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:94:0x013f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01c5 -> B:63:0x01cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x022a -> B:76:0x021a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object notifyMsg(java.lang.String r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.notifyMsg(java.lang.String, ab.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0101  */
    /* JADX WARN: Code duplicated, block: B:50:0x0139  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0164, code lost:
    
        if (handleInsertionAndNotification(r8, r7, r1, r4, r5) == r6) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processMessage(cu.todus.android.data.db.entity.toDus.Message r19, java.util.List<cu.todus.android.data.db.entity.toDus.Attachment> r20, boolean r21, ab.e<? super ua.k0> r22) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.processMessage(cu.todus.android.data.db.entity.toDus.Message, java.util.List, boolean, ab.e):java.lang.Object");
    }

    public static /* synthetic */ Object processMessage$default(MessageManager messageManager, Message message, List list, boolean z10, ab.e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return messageManager.processMessage(message, list, z10, eVar);
    }

    private final void sendReceived(String stanzaId) {
        addOfflineReceivedIds(stanzaId);
        XMPPTCPConnection xMPPTCPConnection = (XMPPTCPConnection) getMXMPPConnection().invoke();
        if (xMPPTCPConnection != null) {
            XMPPInlinesKt.sendSMACK(xMPPTCPConnection, ((Owner) getOwner().invoke()).getNameWithDomain(), stanzaId);
        }
    }

    public final Function2 getCallMucMemberList() {
        return this.callMucMemberList;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // cu.todus.android.xmpp.managers.IMManager
    public AndFilter getFilter() {
        return this.filter;
    }

    public final Function2 getGetChannelInfo() {
        return this.getChannelInfo;
    }

    public final Function2 getGetGroupInfo() {
        return this.getGroupInfo;
    }

    public final Function2 getGetUserInfo() {
        return this.getUserInfo;
    }

    public final lb.o getHandleCallMessage() {
        return this.handleCallMessage;
    }

    public final Function2 getHandlePublications() {
        return this.handlePublications;
    }

    public final Function1 getHandleStatusExistence() {
        return this.handleStatusExistence;
    }

    public final NotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public final lb.a getReloadChannels() {
        return this.reloadChannels;
    }

    public final Function3 getReloadPub() {
        return this.reloadPub;
    }

    public final Function2 getReloadUser() {
        return this.reloadUser;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0099  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d2 -> B:31:0x00d6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendDisplayMessage(java.util.List<cu.todus.android.data.db.entity.toDus.Message> r26, ab.e<? super ua.k0> r27) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.sendDisplayMessage(java.util.List, ab.e):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:108:0x044b  */
    /* JADX WARN: Code duplicated, block: B:110:0x045c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0467  */
    /* JADX WARN: Code duplicated, block: B:113:0x046d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0478  */
    /* JADX WARN: Code duplicated, block: B:116:0x047e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0489  */
    /* JADX WARN: Code duplicated, block: B:119:0x048f  */
    /* JADX WARN: Code duplicated, block: B:120:0x049a  */
    /* JADX WARN: Code duplicated, block: B:122:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:125:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:126:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:128:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:129:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:131:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:132:0x0505  */
    /* JADX WARN: Code duplicated, block: B:134:0x050b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0516  */
    /* JADX WARN: Code duplicated, block: B:137:0x051c  */
    /* JADX WARN: Code duplicated, block: B:138:0x0527  */
    /* JADX WARN: Code duplicated, block: B:140:0x052d  */
    /* JADX WARN: Code duplicated, block: B:141:0x0538  */
    /* JADX WARN: Code duplicated, block: B:143:0x053e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0549  */
    /* JADX WARN: Code duplicated, block: B:146:0x054f  */
    /* JADX WARN: Code duplicated, block: B:147:0x055a  */
    /* JADX WARN: Code duplicated, block: B:149:0x0560  */
    /* JADX WARN: Code duplicated, block: B:150:0x056b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0571  */
    /* JADX WARN: Code duplicated, block: B:153:0x057c  */
    /* JADX WARN: Code duplicated, block: B:155:0x0582  */
    /* JADX WARN: Code duplicated, block: B:156:0x058d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0593  */
    /* JADX WARN: Code duplicated, block: B:159:0x059e  */
    /* JADX WARN: Code duplicated, block: B:161:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:162:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:164:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:165:0x05be  */
    /* JADX WARN: Code duplicated, block: B:167:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:168:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:170:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:171:0x05de  */
    /* JADX WARN: Code duplicated, block: B:173:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:174:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:176:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:177:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:179:0x0604  */
    /* JADX WARN: Code duplicated, block: B:184:0x0629 A[LOOP:1: B:182:0x0623->B:184:0x0629, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:187:0x0649  */
    /* JADX WARN: Code duplicated, block: B:190:0x0653  */
    /* JADX WARN: Code duplicated, block: B:198:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:201:0x06ca A[LOOP:3: B:199:0x06c4->B:201:0x06ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:204:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:207:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:215:0x0750  */
    /* JADX WARN: Code duplicated, block: B:218:0x0763 A[LOOP:5: B:216:0x075d->B:218:0x0763, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:221:0x0781  */
    /* JADX WARN: Code duplicated, block: B:224:0x078b  */
    /* JADX WARN: Code duplicated, block: B:232:0x07eb  */
    /* JADX WARN: Code duplicated, block: B:235:0x07fe A[LOOP:7: B:233:0x07f8->B:235:0x07fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:238:0x081c  */
    /* JADX WARN: Code duplicated, block: B:239:0x0821  */
    /* JADX WARN: Code duplicated, block: B:242:0x0834 A[LOOP:8: B:240:0x082e->B:242:0x0834, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:245:0x0852  */
    /* JADX WARN: Code duplicated, block: B:248:0x085e  */
    /* JADX WARN: Code duplicated, block: B:253:0x088a  */
    /* JADX WARN: Code duplicated, block: B:256:0x089d A[LOOP:10: B:254:0x0897->B:256:0x089d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:259:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:262:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:270:0x0936  */
    /* JADX WARN: Code duplicated, block: B:273:0x0949 A[LOOP:12: B:271:0x0943->B:273:0x0949, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:276:0x0967  */
    /* JADX WARN: Code duplicated, block: B:279:0x0971  */
    /* JADX WARN: Code duplicated, block: B:284:0x0996  */
    /* JADX WARN: Code duplicated, block: B:294:0x09ef  */
    /* JADX WARN: Code duplicated, block: B:297:0x0a02 A[LOOP:15: B:295:0x09fc->B:297:0x0a02, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:300:0x0a20  */
    /* JADX WARN: Code duplicated, block: B:303:0x0a2a  */
    /* JADX WARN: Code duplicated, block: B:307:0x0a53  */
    /* JADX WARN: Code duplicated, block: B:309:0x0a5f  */
    /* JADX WARN: Code duplicated, block: B:311:0x0afe  */
    /* JADX WARN: Code duplicated, block: B:312:0x0b02  */
    /* JADX WARN: Code duplicated, block: B:314:0x0b13  */
    /* JADX WARN: Code duplicated, block: B:319:0x0b20  */
    /* JADX WARN: Code duplicated, block: B:322:0x0b26  */
    /* JADX WARN: Code duplicated, block: B:325:0x0b2d  */
    /* JADX WARN: Code duplicated, block: B:328:0x0b35 A[Catch: Exception -> 0x0b23, TRY_LEAVE, TryCatch #1 {Exception -> 0x0b23, blocks: (B:326:0x0b2f, B:328:0x0b35), top: B:401:0x0b2f }] */
    /* JADX WARN: Code duplicated, block: B:330:0x0b3f  */
    /* JADX WARN: Code duplicated, block: B:333:0x0b4e  */
    /* JADX WARN: Code duplicated, block: B:337:0x0b5a  */
    /* JADX WARN: Code duplicated, block: B:339:0x0b69  */
    /* JADX WARN: Code duplicated, block: B:340:0x0b6c  */
    /* JADX WARN: Code duplicated, block: B:342:0x0b81  */
    /* JADX WARN: Code duplicated, block: B:344:0x0b84  */
    /* JADX WARN: Code duplicated, block: B:346:0x0b97 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:352:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:355:0x0bb1  */
    /* JADX WARN: Code duplicated, block: B:357:0x0bb8  */
    /* JADX WARN: Code duplicated, block: B:360:0x0bf2  */
    /* JADX WARN: Code duplicated, block: B:361:0x0bf5  */
    /* JADX WARN: Code duplicated, block: B:364:0x0c0a  */
    /* JADX WARN: Code duplicated, block: B:367:0x0c10  */
    /* JADX WARN: Code duplicated, block: B:371:0x0c3c  */
    /* JADX WARN: Code duplicated, block: B:373:0x0c3f  */
    /* JADX WARN: Code duplicated, block: B:377:0x0c54  */
    /* JADX WARN: Code duplicated, block: B:379:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:381:0x0c7a  */
    /* JADX WARN: Code duplicated, block: B:386:0x0cbd  */
    /* JADX WARN: Code duplicated, block: B:388:0x0ccf  */
    /* JADX WARN: Code duplicated, block: B:393:0x0cfc  */
    /* JADX WARN: Code duplicated, block: B:403:0x0b1a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:0x0611 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:432:0x06b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x074a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x07e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:446:0x086a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:447:? A[LOOP:9: B:246:0x0858->B:447:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:449:0x0930 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:453:0x09e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:456:0x09e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:461:0x0c4e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0356  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:90:0x037d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0380  */
    /* JADX WARN: Code duplicated, block: B:95:0x039f  */
    /* JADX WARN: Code duplicated, block: B:99:0x03e2  */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0415, code lost:
    
        if (r12.deleteChunksByMsgId(r4, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x069f, code lost:
    
        if (r0.handleStreamVideoProcessed(r6, r9, r12, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0738, code lost:
    
        if (r0.handleDeleteOwnerMsg(r4, r12, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x07d3, code lost:
    
        if (r0.handleUpdateToDusId(r6, r9, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x091e, code lost:
    
        if (r0.handlePubEdited(r6, r9, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x09d1, code lost:
    
        if (r0.handlePubDeleted(r4, r6, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0cb7, code lost:
    
        if (handleNotNullBody$default(r0, r4, r2, r3, false, r5, 8, null) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0cf6, code lost:
    
        if (r0.handleNullBody(r4, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x023b, code lost:
    
        if (r0.handleMarker(r2, r11, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0286, code lost:
    
        if (r0.handleAffiliationChange(r2, r5) == r8) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02ae, code lost:
    
        if (r0.handleRoomConfigs(r2, r5) == r8) goto L390;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v142, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v155, types: [int] */
    /* JADX WARN: Type inference failed for: r1v193 */
    /* JADX WARN: Type inference failed for: r1v194 */
    /* JADX WARN: Type inference failed for: r1v195 */
    /* JADX WARN: Type inference failed for: r1v63 */
    @Override // cu.todus.android.xmpp.managers.IMManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object stanzaProcess(org.jivesoftware.smack.packet.Stanza r33, ab.e<? super ua.k0> r34) {
        /*
            Method dump skipped, instruction units count: 3390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.xmpp.managers.MessageManager.stanzaProcess(org.jivesoftware.smack.packet.Stanza, ab.e):java.lang.Object");
    }
}
